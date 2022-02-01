package mqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqRegulatorCallback;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.IServiceCmdCallback;

public class MainService
{
  public static final String CMD_PRE_AUTH = "QQConnectLogin.pre_auth";
  public static final String MSFPROCESSNAMETAG = ":MSF";
  public static final String MSF_SERVICE_NAME = "com.tencent.mobileqq.msf.service.MsfService";
  public static final String QQPROCESSNAME = "com.tencent.mobileqq";
  public static final String SERVICE_CMD = "serviceCmd";
  private static final String TAG = "MainService";
  public static final String UIN_NOT_MATCH_TAG = "uinNotMatch";
  public static boolean isDebugVersion = false;
  public static boolean isGrayVersion = false;
  private static IServiceCmdCallback sCmdCallback;
  public static int sNativeTidOfReceiver = -1;
  public static long sPwdPacketTime;
  public static long sReceiverCpuTime;
  public static MqqRegulatorCallback sRegulatorCallback;
  private static AbstractUnifiedMonitor um;
  private IAuthHandler authHandler = new MainService.7(this);
  public int cbExceedCount = 0;
  public int cbIncreaseCount = 0;
  public long cbIncreaseTime = 0L;
  public long cbLastUpdateSPTime = 0L;
  private IErrorHandler errorHandler = new MainService.MyErrorHandler(this, null);
  private MobileQQ mApplicaiton;
  private volatile AppRuntime.InterceptKickListener mInterceptKickListener;
  private final Map<Integer, Class<? extends MSFServlet>> mRequestServlets = new ConcurrentHashMap();
  private IMsfMsgHandler msfMsgHandler = new MainService.3(this);
  private final Runnable msfReceiver = new MainService.2(this);
  private Thread msfRecvThread;
  private final MsfRespHandleUtil msfRespHandleUtil;
  public final MsfServiceSdk msfSub;
  INotifyHandler notifyHandler = new MainService.5(this);
  private IPushHandler pushHandler = new MainService.4(this);
  private boolean recvThreadRegulatoring = false;
  private IRegisterUinHandler registerUinHandler = new MainService.6(this);
  private int reportThreshold = -1;
  private IServerInfoHandler serverInfoHandler = new MainService.8(this);
  private IServerMsgPushHandler serverMsgPushHandler = new MainService.9(this);
  private int umNotReported = 0;
  
  MainService(MobileQQ paramMobileQQ, int paramInt, String paramString, boolean paramBoolean)
  {
    this.mApplicaiton = paramMobileQQ;
    this.msfSub = MsfServiceSdk.get();
    this.msfSub.init(paramMobileQQ, paramInt, paramString, "com.tencent.mobileqq.msf.service.MsfService", this.errorHandler, MobileQQ.processName);
    this.msfRespHandleUtil = new MsfRespHandleUtil(new IMsfHandler[] { this.msfMsgHandler, this.pushHandler, this.notifyHandler, this.authHandler, this.registerUinHandler, this.serverMsgPushHandler, this.serverInfoHandler });
    if (paramBoolean) {
      start();
    }
  }
  
  private boolean isValidAccount(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString1, AppRuntime paramAppRuntime, boolean paramBoolean, String paramString2)
  {
    return (paramBoolean) || (paramString2.equals(paramAppRuntime.getAccount())) || (isWhiteCommand(paramFromServiceMsg)) || ((paramString1 != null) && (paramString1.equals("subaccount"))) || ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().containsKey("uinNotMatch")));
  }
  
  private boolean isWhiteCommand(FromServiceMsg paramFromServiceMsg)
  {
    return ("login.auth".equals(paramFromServiceMsg.getServiceCmd())) || ("wtlogin.login".equals(paramFromServiceMsg.getServiceCmd())) || (MsfCommand.wt_GetStViaSMSVerifyLogin.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_loginAuth.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_name2uin.equals(paramFromServiceMsg.getMsfCommand())) || ("login.chguin".equals(paramFromServiceMsg.getServiceCmd()));
  }
  
  private void notifyCostTooLongIfDebug(FromServiceMsg paramFromServiceMsg, AppRuntime paramAppRuntime, long paramLong)
  {
    if ((isDebugVersion) && (paramLong >= 5000L) && (paramAppRuntime != null) && (!AppSetting.k())) {
      paramAppRuntime.runOnUiThread(new MainService.1(this, paramFromServiceMsg, paramLong));
    }
  }
  
  private void receiveMessageFromMSF(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = this.mApplicaiton;
    Object localObject3 = null;
    Object localObject2 = ((MobileQQ)localObject1).waitAppRuntime(null);
    localObject1 = localObject2;
    if (paramToServiceMsg != null) {
      localObject1 = ((AppRuntime)localObject2).getAppRuntime(paramToServiceMsg.extraData.getString("moduleId"));
    }
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = SystemClock.currentThreadTimeMillis();
    }
    long l2;
    String str1;
    int i;
    if (paramToServiceMsg != null)
    {
      localObject2 = (Class)this.mRequestServlets.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
      l2 = paramToServiceMsg.extraData.getLong("sendTime");
      l2 = System.currentTimeMillis() - l2;
      paramFromServiceMsg.addAttribute("msf_receive", Long.valueOf(System.currentTimeMillis()));
      if (paramFromServiceMsg.isSuccess())
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[MSF Receive]");
          ((StringBuilder)localObject3).append(paramFromServiceMsg.getServiceCmd());
          ((StringBuilder)localObject3).append(" appSeq:");
          ((StringBuilder)localObject3).append(paramToServiceMsg.getAppSeq());
          ((StringBuilder)localObject3).append("  ");
          ((StringBuilder)localObject3).append(localObject1.getClass().getSimpleName());
          ((StringBuilder)localObject3).append("@");
          ((StringBuilder)localObject3).append(localObject1.hashCode());
          ((StringBuilder)localObject3).append("  cost=");
          ((StringBuilder)localObject3).append(l2);
          ((StringBuilder)localObject3).append("ms.");
          QLog.d("mqq", 2, ((StringBuilder)localObject3).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[MSF Receive]");
        ((StringBuilder)localObject3).append(paramFromServiceMsg.getServiceCmd());
        ((StringBuilder)localObject3).append(" appSeq:");
        ((StringBuilder)localObject3).append(paramToServiceMsg.getAppSeq());
        ((StringBuilder)localObject3).append("  ");
        ((StringBuilder)localObject3).append(localObject1.getClass().getSimpleName());
        ((StringBuilder)localObject3).append("@");
        ((StringBuilder)localObject3).append(localObject1.hashCode());
        ((StringBuilder)localObject3).append("  code=");
        ((StringBuilder)localObject3).append(paramFromServiceMsg.getResultCode());
        ((StringBuilder)localObject3).append(",cost=");
        ((StringBuilder)localObject3).append(l2);
        ((StringBuilder)localObject3).append("ms.");
        QLog.w("mqq", 2, ((StringBuilder)localObject3).toString());
      }
      localObject3 = sCmdCallback;
      if (localObject3 != null) {
        ((IServiceCmdCallback)localObject3).onCmdResponse(paramFromServiceMsg.getServiceCmd());
      }
      recordKeyTimestamp(paramToServiceMsg, paramFromServiceMsg);
      str1 = (String)paramToServiceMsg.getAttribute("from_where");
      localObject3 = (String)paramToServiceMsg.getAttribute("mainaccount");
      i = 0;
    }
    else
    {
      if ((this.mApplicaiton.getQQProcessName().endsWith(":video")) || (QLog.isColorLevel()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[MSF Push]");
        ((StringBuilder)localObject2).append(paramFromServiceMsg.getServiceCmd());
        ((StringBuilder)localObject2).append(",ssoseq=");
        ((StringBuilder)localObject2).append(paramFromServiceMsg.getRequestSsoSeq());
        QLog.d("mqq", 1, ((StringBuilder)localObject2).toString());
      }
      str1 = null;
      localObject2 = str1;
      i = 1;
    }
    boolean bool;
    if ("0".equals(paramFromServiceMsg.getUin()))
    {
      paramFromServiceMsg.setUin(((AppRuntime)localObject1).getAccount());
      bool = true;
    }
    else
    {
      bool = false;
    }
    FromServiceMsg localFromServiceMsg = paramFromServiceMsg;
    String str2 = paramFromServiceMsg.getUin();
    if ((str1 != null) && (str1.length() > 0)) {
      localFromServiceMsg.addAttribute("from_where", str1);
    }
    if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
      localFromServiceMsg.addAttribute("mainaccount", localObject3);
    }
    if (isValidAccount(paramToServiceMsg, paramFromServiceMsg, str1, (AppRuntime)localObject1, bool, str2))
    {
      startUnifiedMonitorReport();
      l2 = SystemClock.uptimeMillis();
      ((AppRuntime)localObject1).getServletContainer().notifyMSFServlet((Class)localObject2, localFromServiceMsg);
      if (i != 0) {
        try
        {
          paramToServiceMsg = ((AppRuntime)localObject1).subRuntimeMap.values().iterator();
          while (paramToServiceMsg.hasNext()) {
            ((AppRuntime)paramToServiceMsg.next()).getServletContainer().notifyMSFServlet((Class)localObject2, localFromServiceMsg);
          }
          l2 = SystemClock.uptimeMillis() - l2;
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "", paramToServiceMsg);
          }
        }
      }
      stopUnifiedMonitorReport(localFromServiceMsg, l2);
      long l3 = SystemClock.currentThreadTimeMillis();
      sReceiverCpuTime = l3;
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, new Object[] { "[MSF End][notifyMSFServlet]", paramFromServiceMsg.getServiceCmd(), ",ssoseq=", Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()), ",cost=", Long.valueOf(l2), "ms, cpucost=", Long.valueOf(l3 - l1), "(", Long.valueOf(l3), ")." });
      }
      reportMsfLongCallback(localFromServiceMsg, l2);
      reportMSFCallBackCost(l2, false);
      notifyCostTooLongIfDebug(localFromServiceMsg, (AppRuntime)localObject1, l2);
    }
  }
  
  private void recordKeyTimestamp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      long l1 = paramToServiceMsg.extraData.getLong("sendTime", 0L);
      long l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf", Long.valueOf(0L))).longValue();
      long l3 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net", Long.valueOf(0L))).longValue();
      long l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf", Long.valueOf(0L))).longValue();
      long l5 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2app", Long.valueOf(0L))).longValue();
      long l6 = System.currentTimeMillis();
      paramFromServiceMsg.extraData.putLong("timestamp_app2msf_atAppSite", l1);
      paramFromServiceMsg.extraData.putLong("timestamp_app2msf_atMsfSite", l2);
      paramFromServiceMsg.extraData.putLong("timestamp_msf2net_atMsfSite", l3);
      paramFromServiceMsg.extraData.putLong("timestamp_net2msf_atMsfSite", l4);
      paramFromServiceMsg.extraData.putLong("timestamp_msf2app_atMsfSite", l5);
      paramFromServiceMsg.extraData.putLong("timestamp_msf2app_atAppSite", l6);
    }
  }
  
  private void reportMsfLongCallback(FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    if (paramLong >= 2000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("cmd", paramFromServiceMsg.getServiceCmd());
      paramFromServiceMsg = new RdmReq();
      paramFromServiceMsg.eventName = "longTimeCallback";
      paramFromServiceMsg.elapse = paramLong;
      paramFromServiceMsg.size = 0L;
      paramFromServiceMsg.isSucceed = true;
      paramFromServiceMsg.isRealTime = false;
      paramFromServiceMsg.params = localHashMap;
      paramFromServiceMsg = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), paramFromServiceMsg);
      paramFromServiceMsg.setNeedCallback(false);
      paramFromServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
      this.msfSub.sendMsg(paramFromServiceMsg);
    }
  }
  
  public static void setServiceCmdCallback(IServiceCmdCallback paramIServiceCmdCallback)
  {
    sCmdCallback = paramIServiceCmdCallback;
  }
  
  public static void setUnifiedMonitorInstance(AbstractUnifiedMonitor paramAbstractUnifiedMonitor)
  {
    um = paramAbstractUnifiedMonitor;
  }
  
  private void startUnifiedMonitorReport()
  {
    if (this.reportThreshold == -1)
    {
      localAbstractUnifiedMonitor = um;
      if (localAbstractUnifiedMonitor != null) {
        if (localAbstractUnifiedMonitor.whetherReportDuringThisStartup(7))
        {
          this.reportThreshold = um.getThreshold(7);
          um.setMonitoredThread(7, Thread.currentThread(), null);
        }
        else
        {
          this.reportThreshold = -2;
        }
      }
    }
    AbstractUnifiedMonitor localAbstractUnifiedMonitor = um;
    if ((localAbstractUnifiedMonitor != null) && (localAbstractUnifiedMonitor.whetherStackEnabled(7))) {
      um.reportStackIfTimeout(7);
    }
  }
  
  private void stopUnifiedMonitorReport(FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    int i = this.reportThreshold;
    if (i > 0)
    {
      if (paramLong > i)
      {
        if (um.whetherReportThisTime(7)) {
          um.addEvent(7, paramFromServiceMsg.getServiceCmd(), (int)paramLong, this.umNotReported, null);
        }
        this.umNotReported = 0;
        return;
      }
      if (um.whetherStackEnabled(7)) {
        um.notifyNotTimeout(7);
      }
      this.umNotReported += 1;
    }
  }
  
  public void clearServlets()
  {
    this.mRequestServlets.clear();
  }
  
  public void kick(AppRuntime.KickParams paramKickParams)
  {
    if (paramKickParams != null)
    {
      IErrorHandler localIErrorHandler = this.errorHandler;
      if ((localIErrorHandler instanceof MainService.MyErrorHandler)) {
        ((MainService.MyErrorHandler)localIErrorHandler).onKickedInternal((ToServiceMsg)paramKickParams.toServiceMsg, (FromServiceMsg)paramKickParams.fromServiceMsg, paramKickParams.isTokenExpired, paramKickParams.isSameDevice);
      }
    }
  }
  
  public void onRecvVerifyManagerCallback(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    this.msfRespHandleUtil.handleRespMsg(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void reportMSFCallBackCost(long paramLong, boolean paramBoolean)
  {
    if (paramLong >= 0L)
    {
      this.cbIncreaseTime += paramLong;
      this.cbIncreaseCount += 1;
      if (paramLong >= 2000L) {
        this.cbExceedCount += 1;
      }
    }
    paramLong = SystemClock.elapsedRealtime();
    long l1 = this.cbLastUpdateSPTime;
    if (l1 > 0L)
    {
      if (paramLong - l1 > 600000L) {
        paramBoolean = true;
      }
    }
    else {
      this.cbLastUpdateSPTime = paramLong;
    }
    if ((paramBoolean) && (this.cbIncreaseTime > 0L))
    {
      long l2 = System.currentTimeMillis();
      Object localObject1 = this.mApplicaiton.getSharedPreferences("msf_cb_report", 0);
      paramLong = ((SharedPreferences)localObject1).getLong("cbLastReportTime", l2);
      l1 = ((SharedPreferences)localObject1).getLong("cbTotalTime", 0L) + this.cbIncreaseTime;
      int i = ((SharedPreferences)localObject1).getInt("cbTotalCount", 0);
      i = this.cbIncreaseCount + i;
      int j = ((SharedPreferences)localObject1).getInt("cbExceedCount", 0) + this.cbExceedCount;
      if (l2 - paramLong >= 86400000L)
      {
        if (i > 0) {
          paramLong = l1 / i;
        } else {
          paramLong = 0L;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reportMSFCallBackCost-->cbTotalTime:");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append(" ,cbTotalCount:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" ,cbAverageTime:");
          ((StringBuilder)localObject2).append(paramLong);
          QLog.d("mqq", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = new RdmReq();
        HashMap localHashMap = new HashMap();
        localHashMap.put("cbAverageTime", String.valueOf(paramLong));
        localHashMap.put("cbTotalCount", String.valueOf(i));
        localHashMap.put("cbExceedCount", String.valueOf(j));
        ((RdmReq)localObject2).eventName = "MSFCallBackAvgCost";
        ((RdmReq)localObject2).elapse = paramLong;
        ((RdmReq)localObject2).size = 0L;
        ((RdmReq)localObject2).isSucceed = true;
        ((RdmReq)localObject2).isRealTime = false;
        ((RdmReq)localObject2).params = localHashMap;
        localObject2 = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), (RdmReq)localObject2);
        ((ToServiceMsg)localObject2).extraData.putLong("sendTime", System.currentTimeMillis());
        this.msfSub.sendMsg((ToServiceMsg)localObject2);
        i = 0;
        j = 0;
        l1 = 0L;
        paramLong = l2;
      }
      else if (paramLong > l2)
      {
        paramLong = l2;
      }
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putLong("cbLastReportTime", paramLong);
      ((SharedPreferences.Editor)localObject1).putLong("cbTotalTime", l1);
      ((SharedPreferences.Editor)localObject1).putInt("cbTotalCount", i);
      ((SharedPreferences.Editor)localObject1).putInt("cbExceedCount", j);
      ((SharedPreferences.Editor)localObject1).commit();
      this.cbLastUpdateSPTime = SystemClock.elapsedRealtime();
      this.cbIncreaseTime = 0L;
      this.cbIncreaseCount = 0;
      this.cbExceedCount = 0;
    }
  }
  
  void sendMessageToMSF(ToServiceMsg paramToServiceMsg, MSFServlet paramMSFServlet)
  {
    if (paramToServiceMsg.getServiceName() == null) {
      paramToServiceMsg.setServiceName(this.msfSub.getMsfServiceName());
    }
    this.mRequestServlets.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramMSFServlet.getClass());
    paramToServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
    paramToServiceMsg.extraData.putString("moduleId", paramMSFServlet.getAppRuntime().getModuleId());
    int i = this.msfSub.sendMsg(paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MSF Send]");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append(" appSeq:");
      localStringBuilder.append(paramToServiceMsg.getAppSeq());
      localStringBuilder.append("  ");
      localStringBuilder.append(paramMSFServlet.getAppRuntime().getClass().getSimpleName());
      localStringBuilder.append("@");
      localStringBuilder.append(paramMSFServlet.getAppRuntime().hashCode());
      localStringBuilder.append("  from ");
      localStringBuilder.append(paramMSFServlet.getClass().getSimpleName());
      localStringBuilder.append(", res = ");
      localStringBuilder.append(i);
      QLog.d("mqq", 2, localStringBuilder.toString());
    }
    paramMSFServlet = sCmdCallback;
    if (paramMSFServlet != null) {
      paramMSFServlet.onCmdRequest(paramToServiceMsg.getServiceCmd());
    }
  }
  
  public void setInterceptKickListener(AppRuntime.InterceptKickListener paramInterceptKickListener)
  {
    this.mInterceptKickListener = paramInterceptKickListener;
  }
  
  public void start()
  {
    if (this.msfRecvThread == null)
    {
      this.msfRecvThread = new Thread(this.msfReceiver, "MSF-Receiver");
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start MSF-Receiver ");
      localStringBuilder.append(this.msfRecvThread.getId());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      localObject = this.mApplicaiton;
      if ((localObject != null) && (((MobileQQ)localObject).getQQProcessName() != null) && (this.mApplicaiton.getQQProcessName().endsWith(":video"))) {
        this.msfRecvThread.setPriority(10);
      } else {
        this.msfRecvThread.setPriority(5);
      }
      this.msfRecvThread.start();
      localObject = sRegulatorCallback;
      if (localObject != null) {
        this.recvThreadRegulatoring = ((MqqRegulatorCallback)localObject).regulatorThread(this.msfRecvThread);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MainService
 * JD-Core Version:    0.7.0.1
 */