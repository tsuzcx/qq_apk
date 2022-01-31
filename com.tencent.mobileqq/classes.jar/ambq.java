import IPwdPxyMQQ.RespondQueryIPwdStat;
import RegisterProxySvcPack.OnlineInfos;
import RegisterProxySvcPack.SvcRespParam;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.statsvc.getonline.StatSvcGetOnline.Instance;
import tencent.im.statsvc.getonline.StatSvcGetOnline.ReqBody;
import tencent.im.statsvc.getonline.StatSvcGetOnline.RspBody;
import tencent.im.statsvc.stat.mute.StatSetMute.ReqBody;
import tencent.im.statsvc.stat.mute.StatSetMute.RspBody;

public class ambq
  extends alpd
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected Handler a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private int d = 1;
  private int e = 1;
  private int f;
  private int g = 1;
  private int h;
  
  public ambq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new ambr(this, Looper.getMainLooper());
  }
  
  public int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long a()
  {
    try
    {
      long l = this.jdField_a_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    send(createToServiceMsg("RegPrxySvc.infoAndroid"));
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.h = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      QLog.d("RegisterProxySvcPack", 2, "setSelfPcSuppViewPcVersion:" + paramLong);
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StatSetMute.ReqBody localReqBody = new StatSetMute.ReqBody();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localReqBody.set_mute.set(i);
      ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.SetMute");
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      localToServiceMsg.extraData.putBoolean("param_is_mute", paramBoolean);
      send(localToServiceMsg);
      return;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int b()
  {
    try
    {
      int i = this.jdField_b_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    StatSvcGetOnline.ReqBody localReqBody = new StatSvcGetOnline.ReqBody();
    localReqBody.uint64_uin.set(this.app.getLongAccountUin());
    localReqBody.uint32_appid.set(0);
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetOnlineStatus");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    send(localToServiceMsg);
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(long paramLong)
  {
    try
    {
      this.jdField_b_of_type_Long = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int c()
  {
    try
    {
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxySvcPack", 2, "iState:" + this.jdField_a_of_type_Int + ", clientType:" + this.jdField_b_of_type_Long + ", appId:" + this.jdField_c_of_type_Long);
    }
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(102)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(102, 1000L);
    }
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(long paramLong)
  {
    try
    {
      this.jdField_c_of_type_Long = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int d()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(int paramInt)
  {
    try
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label162;
        }
        QLog.d("RegisterProxySvcPack", 2, "uIsSetPwd = " + paramLong);
      }
      finally {}
      if ((this.app != null) && (i != -1))
      {
        this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_is_set_password" + this.app.getCurrentAccountUin(), i).commit();
        return;
        if (paramLong != 2L) {
          i = -1;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("RegisterProxySvcPack", 2, "RegisterProxySvcPackHandler.app is null or isSetPassword is error ,isSetPassword = " + i);
        continue;
        label162:
        if (paramLong != 1L) {
          break;
        }
        i = 1;
      }
    }
  }
  
  public int e()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int f()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f(int paramInt)
  {
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g(int paramInt)
  {
    try
    {
      this.g = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return ambs.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    boolean bool = true;
    int i = 1;
    if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.infoAndroid")) {
      QLog.d("RegisterProxySvcPack", 2, "resp of RegPrxySvc.infoAndroid");
    }
    label140:
    label309:
    label318:
    label508:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.PushParam"))
            {
              if (paramObject != null)
              {
                paramObject = (SvcRespParam)paramObject;
                e(paramObject.iIsSupportDataLine);
                f(paramObject.iIsSupportPrintable);
                g(paramObject.iIsSupportViewPCFile);
                a(paramObject.iPcVersion);
                ArrayList localArrayList = paramObject.onlineinfos;
                paramFromServiceMsg = null;
                paramToServiceMsg = null;
                if (localArrayList == null) {
                  break label1082;
                }
                i = 0;
                paramFromServiceMsg = paramToServiceMsg;
                if (i >= localArrayList.size()) {
                  break label1082;
                }
                paramFromServiceMsg = (OnlineInfos)localArrayList.get(i);
                if (paramFromServiceMsg.clientType == 9)
                {
                  i = paramFromServiceMsg.onlineStatus;
                  c(i);
                  if ((paramToServiceMsg == null) || (paramToServiceMsg.onlineStatus != 1)) {
                    break label318;
                  }
                  b(1);
                  b(66831L);
                  c(paramToServiceMsg.instanceId);
                }
                for (;;)
                {
                  i = j;
                  if (((ybf)this.app.getManager(335)).a(paramObject)) {
                    i = 1;
                  }
                  this.h = i;
                  c();
                  QLog.d("RegisterProxySvcPack", 2, "online status of pc: state:" + paramObject.PCstat + "- ram:" + paramObject.iIsSupportC2CRoamMsg + "- supportdataline:" + paramObject.iIsSupportDataLine + "- PcVersion:" + paramObject.iPcVersion + "- uRoamFlag:" + paramObject.uRoamFlag);
                  return;
                  if (paramFromServiceMsg.clientType != 15) {
                    break label1079;
                  }
                  paramToServiceMsg = paramFromServiceMsg;
                  i += 1;
                  break;
                  if ((paramObject.iPCClientType == 65793) || (paramObject.iPCClientType == 77313))
                  {
                    i = paramObject.PCstat;
                    if (paramObject.iIsSupportDataLine == 2) {
                      i = 0;
                    }
                    b(i);
                    if (i == 1)
                    {
                      b(paramObject.iPCClientType);
                      c(1L);
                    }
                    notifyUI(1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramObject.iIsSupportDataLine) });
                  }
                }
              }
              QLog.d("RegisterProxySvcPack", 2, "RegPrxySvc.PushParam is null");
              return;
            }
            if (!paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.QueryIpwdStat")) {
              break label508;
            }
            if (paramObject == null) {
              break;
            }
            paramToServiceMsg = (RespondQueryIPwdStat)paramObject;
          } while (paramToServiceMsg == null);
          d(paramToServiceMsg.uIsSetPwd);
        } while (!QLog.isColorLevel());
        QLog.d("RegisterProxySvcPack", 2, "QueryIPwdStat:" + paramToServiceMsg.uIsSetPwd);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("RegisterProxySvcPack", 2, "IPwdPxyMQQ.RespondQueryIPwdStat is null");
      return;
      if (!paramFromServiceMsg.getServiceCmd().equals("StatSvc.GetOnlineStatus")) {
        break label873;
      }
      if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        break;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, "CMD_GET_SELFPCSTATUS_KICKED onReceive :" + bool);
      }
    } while (!bool);
    for (;;)
    {
      try
      {
        label534:
        paramToServiceMsg = new StatSvcGetOnline.RspBody();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        j = paramToServiceMsg.error_code.get();
        if (j != 0) {
          break label818;
        }
        if (QLog.isColorLevel()) {
          QLog.e("RegisterProxySvcPack", 2, "errorCode: " + j);
        }
        if (i == 0) {
          break label824;
        }
        if ((!paramToServiceMsg.uint64_uin.has()) || (this.app.getLongAccountUin() != paramToServiceMsg.uint64_uin.get()) || (!paramToServiceMsg.msg_instances.has())) {
          break;
        }
        paramToServiceMsg = paramToServiceMsg.msg_instances.get().iterator();
        if (!paramToServiceMsg.hasNext()) {
          break;
        }
        paramFromServiceMsg = (StatSvcGetOnline.Instance)paramToServiceMsg.next();
        if (paramFromServiceMsg == null) {
          continue;
        }
        i = paramFromServiceMsg.uint32_client_type.get();
        if (!QLog.isColorLevel()) {
          break label1090;
        }
        QLog.e("RegisterProxySvcPack", 2, "uint32_client_type: " + i);
      }
      catch (Exception paramToServiceMsg) {}
      b(1);
      b(i);
      c(paramFromServiceMsg.uint32_instance_id.get());
      c();
      continue;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("RegisterProxySvcPack", 2, "CMD_GET_SELFPCSTATUS_KICKED onReceive fail: ", paramToServiceMsg);
      return;
      bool = false;
      break label534;
      label818:
      i = 0;
      continue;
      label824:
      if ((!paramToServiceMsg.error_msg.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("RegisterProxySvcPack", 2, "err msg: " + paramToServiceMsg.error_msg.get());
      return;
      label873:
      if (!paramFromServiceMsg.getServiceCmd().equals("StatSvc.SetMute")) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, "CMD_REQ_SET_MUTE onReceive :" + paramFromServiceMsg.isSuccess());
      }
      if (paramObject == null) {
        break;
      }
      for (;;)
      {
        try
        {
          paramToServiceMsg = new StatSetMute.RspBody();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          i = paramToServiceMsg.error_code.get();
          if (i != 0) {
            break label1038;
          }
          if (paramToServiceMsg.set_mute_resp.get() == 1)
          {
            SettingCloneUtil.writeValue(this.app.getApp().getApplicationContext(), this.app.c(), null, "qqsetting_qrlogin_set_mute", bool);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("RegisterProxySvcPack", 2, new Object[] { "setmute success ismute:", Boolean.valueOf(bool) });
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          return;
        }
        bool = false;
      }
      label1038:
      QLog.d("RegisterProxySvcPack", 1, new Object[] { "setmute err:", Integer.valueOf(i), " ,msg:", paramToServiceMsg.error_msg.get() });
      return;
      label1079:
      break label309;
      label1082:
      i = 0;
      paramToServiceMsg = paramFromServiceMsg;
      break label140;
      label1090:
      if ((i != 65793) && (i != 77313)) {
        if (i != 66831) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambq
 * JD-Core Version:    0.7.0.1
 */