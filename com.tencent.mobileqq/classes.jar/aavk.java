import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.msg.data.DeviceMsgHandle.3;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class aavk
  extends BusinessHandler
{
  public static final String a;
  public static String b;
  public static HashMap<String, List<MessageRecord>> b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public aasi a;
  private aasp jdField_a_of_type_Aasp = new aavl(this);
  public aave a;
  private aavi jdField_a_of_type_Aavi;
  public aavj a;
  anau jdField_a_of_type_Anau = new aavn(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aavm(this);
  public HashMap<String, List<aasp>> a;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  public ConcurrentHashMap<Long, MessageRecord> a;
  private List<Long> b;
  public ConcurrentHashMap<Long, MessageRecord> b;
  
  static
  {
    jdField_a_of_type_JavaLangString = MessageForDeviceFile.class.getSimpleName();
    jdField_b_of_type_JavaLangString = "FileMsg";
    c = "CloudPrintMsg";
    d = "ImgMsg";
    e = "VideoMsg";
    f = "AudioMsg";
    g = "Device";
    h = "7000-NASDevPushFile";
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public aavk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Aasp);
    this.jdField_a_of_type_Aavi = new aavi(paramQQAppInterface);
    this.jdField_a_of_type_Aave = new aave(paramQQAppInterface);
    this.jdField_a_of_type_Aasi = new aasi();
    this.jdField_a_of_type_Aavj = new aavj(paramQQAppInterface);
    a(f, this.jdField_a_of_type_Aasi);
    a(e, this.jdField_a_of_type_Aasi);
    a(g, this.jdField_a_of_type_Aasi);
    a(g, this.jdField_a_of_type_Aave);
    a(g, this.jdField_a_of_type_Aavj);
    a(jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Aavi);
    a(c, this.jdField_a_of_type_Aavi);
    a(d, this.jdField_a_of_type_Aavi);
    a(h, this.jdField_a_of_type_Aavi);
    a("8000-NASDevMusicFile", this.jdField_a_of_type_Aavi);
    a("8001-NASDevVideoFile", this.jdField_a_of_type_Aavi);
    a("8002-NASDevDocumentFile", this.jdField_a_of_type_Aavi);
    a("8003-NASDevCommonFile", this.jdField_a_of_type_Aavi);
    a("", this.jdField_a_of_type_Aavi);
    a("", this.jdField_a_of_type_Aasi);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("SmartDevice_DeviceUnBindRst");
    localIntentFilter.addAction("SmartDevice_DeviceAdminUnbind");
    localIntentFilter.addAction("DeviceSomebodyJoin");
    localIntentFilter.addAction("DeviceSomebodyQuit");
    localIntentFilter.addAction("DeviceSomebodyReject");
    localIntentFilter.addAction("SmartDevice_receiveDPMsg");
    localIntentFilter.addAction("SmartDevice_DeviceVasFlagChange");
    localIntentFilter.addAction("SmartDevice_QueryIsDeviceBinded");
    localIntentFilter.addAction("SmartDevice_sendCCDataPointMsgResult");
    localIntentFilter.addAction("SmartDevice_OnMiniFileTransferProgress");
    localIntentFilter.addAction("SmartDevice_OnMiniFileTransferComplete");
    localIntentFilter.addAction("SmartDevice_OnDataPointFileMsgProgress");
    localIntentFilter.addAction("SmartDevice_OnDataPointFileMsgSendRet");
    localIntentFilter.addAction("SmartDevice_DeviceBindRst");
    localIntentFilter.addAction("On_OccupyMicrophoneNotify_Push");
    localIntentFilter.addAction("SmartDevice_sendToAIO_Capture");
    localIntentFilter.addAction("SmartDevice_sendToAIO_Mp4");
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.smartdevice.permission.broadcast", null);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anau);
    paramQQAppInterface = (anat)paramQQAppInterface.getBusinessHandler(34);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "DeviceMsgHandle init success!");
    }
  }
  
  public static MessageRecord a(String paramString, long paramLong)
  {
    List localList = (List)jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (localList == null) {
      return null;
    }
    paramString = null;
    int i = 0;
    for (;;)
    {
      if (i < localList.size())
      {
        paramString = (MessageRecord)localList.get(i);
        if (paramString.uniseq == paramLong) {
          localList.remove(i);
        }
      }
      else
      {
        return paramString;
      }
      i += 1;
    }
  }
  
  private void a()
  {
    DeviceInfo[] arrayOfDeviceInfo = ((aara)this.app.getBusinessHandler(51)).a();
    if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
      this.app.handleReceivedMessage(1, true, true);
    }
  }
  
  private void a(long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)bbli.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.app.getCurrentAccountUin();
    localMessageForDeviceText.senderuin = String.valueOf(paramLong1);
    localMessageForDeviceText.frienduin = paramString1;
    localMessageForDeviceText.msg = paramString2;
    localMessageForDeviceText.time = paramLong2;
    if (paramBoolean) {
      localMessageForDeviceText.extStr = "device_groupchat";
    }
    paramString1 = new ArrayList();
    paramString1.add(localMessageForDeviceText);
    a(paramString1);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    paramString4 = npm.a(paramString4, 45, "UTF-8", "...");
    paramString5 = npm.a(paramString5, 90, "UTF-8", "...");
    String str = acvu.jdField_a_of_type_JavaLangString + "http://maps.google.com/maps?q=" + paramString2 + "," + paramString3 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
    if (!paramContext.getResources().getString(2131695577).equals(paramString4)) {}
    for (paramContext = paramContext.getResources().getString(2131691171) + " " + paramString4;; paramContext = paramContext.getResources().getString(2131691171))
    {
      paramString2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString2 + "&lon=" + paramString3 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramContext = new bcgt(StructMsgForGeneralShare.class).c(32).a(paramContext).d(str).a("plugin", paramString2, paramString2, paramString2, paramString2).a();
      paramString2 = bchg.a(2);
      paramString2.a("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramContext.addItem(paramString2);
      paramContext = bbli.a(this.app, this.app.getCurrentAccountUin(), paramString1, this.app.getCurrentAccountUin(), 9501, 100L, paramContext);
      this.app.getMessageFacade().addMessage(paramContext, this.app.getCurrentAccountUin());
      return;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Object localObject = (List)jdField_b_of_type_JavaUtilHashMap.get(paramMessageRecord.frienduin);
    if (localObject == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(paramMessageRecord);
      jdField_b_of_type_JavaUtilHashMap.put(paramMessageRecord.frienduin, localObject);
      return;
    }
    ((List)localObject).add(paramMessageRecord);
  }
  
  private void a(String paramString, long paramLong)
  {
    paramString = a(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new DeviceMsgHandle.3(this, paramString), 0L);
  }
  
  private void a(List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    this.app.getMessageFacade().addMessage(paramList, this.app.getCurrentAccountUin());
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "cost:" + (System.currentTimeMillis() - l));
    }
  }
  
  private boolean a(String paramString)
  {
    bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramString).optInt("nodisturb", 0);
        if (i != 1) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
  }
  
  private void b(String paramString, long paramLong)
  {
    paramString = a(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    paramString.extraflag = 32768;
    this.app.getMsgCache().a(paramString.frienduin, paramString.istroop, paramString.uniseq);
    String str = paramString.frienduin;
    int i = paramString.istroop;
    paramLong = paramString.uniseq;
    ((MessageHandler)this.app.getBusinessHandler(0)).notifyUI(MessageHandler.a(paramString.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(paramLong) });
  }
  
  public aasi a()
  {
    return this.jdField_a_of_type_Aasi;
  }
  
  public aave a()
  {
    return this.jdField_a_of_type_Aave;
  }
  
  public aavi a()
  {
    return this.jdField_a_of_type_Aavi;
  }
  
  public aavj a()
  {
    return this.jdField_a_of_type_Aavj;
  }
  
  public void a(DataPoint paramDataPoint)
  {
    try
    {
      Object localObject = new JSONObject(paramDataPoint.mValue);
      long l = ((JSONObject)localObject).optLong("msg_time", bbko.a());
      localObject = ((JSONObject)localObject).optString("text", " ");
      a(Long.toString(paramDataPoint.mDin), (String)localObject, l, null);
      return;
    }
    catch (Exception paramDataPoint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramDataPoint.getMessage());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForDeviceText paramMessageForDeviceText)
  {
    paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramMessageForDeviceText.uniseq);
    if ("device_groupchat".equals(paramMessageForDeviceText.extStr)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramQQAppInterface, paramSessionInfo, paramMessageForDeviceText.msg, bool);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = bftf.a(paramString, 560, 20, null, new ArrayList());
    int i = 0;
    if (i < localArrayList.size())
    {
      String str1 = (String)localArrayList.get(i);
      paramString = "";
      if (str1 != null) {
        paramString = bblk.a(str1, true, null);
      }
      int j = (int)bbko.a();
      str1 = paramQQAppInterface.getCurrentAccountUin();
      String str2 = paramSessionInfo.curFriendUin;
      long l = bblk.a(i);
      MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)bbli.a(-4508);
      localMessageForDeviceText.init(str1, paramSessionInfo.curFriendUin, str2, paramString, j, -4508, paramSessionInfo.curType, i);
      localMessageForDeviceText.longMsgCount = localArrayList.size();
      localMessageForDeviceText.longMsgIndex = ((byte)i);
      localMessageForDeviceText.longMsgId = i;
      localMessageForDeviceText.isread = true;
      localMessageForDeviceText.msgUid = l;
      localMessageForDeviceText.shmsgseq = bblk.a(i, paramSessionInfo.curType);
      localMessageForDeviceText.issend = 1;
      localMessageForDeviceText.mAnimFlag = true;
      if (paramBoolean) {
        localMessageForDeviceText.extStr = "device_groupchat";
      }
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
        localMessageForDeviceText.extraflag = 32768;
      }
      paramQQAppInterface.getMessageFacade().addMessage(localMessageForDeviceText, str1);
      a(localMessageForDeviceText);
      if (localMessageForDeviceText.extraflag == 32768) {}
      for (;;)
      {
        if (localMessageForDeviceText.extraflag != 32768)
        {
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          ((aara)paramQQAppInterface.getBusinessHandler(51)).a(localMessageForDeviceText.msg, Long.parseLong(localMessageForDeviceText.frienduin), l, localMessageForDeviceText.msgseq);
        }
        i += 1;
        break;
        paramQQAppInterface.getMsgCache().d(localMessageForDeviceText);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)bbli.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.app.getCurrentAccountUin();
    localMessageForDeviceText.senderuin = paramString1;
    localMessageForDeviceText.frienduin = paramString1;
    localMessageForDeviceText.msg = paramString2;
    localMessageForDeviceText.time = paramLong;
    localMessageForDeviceText.extStr = paramString3;
    paramString1 = new ArrayList();
    paramString1.add(localMessageForDeviceText);
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    int i = 0;
    MessageForGrayTips localMessageForGrayTips;
    switch (paramInt)
    {
    default: 
      paramInt = i;
      localMessageForGrayTips = (MessageForGrayTips)bbli.a(paramInt);
      localMessageForGrayTips.init(this.app.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong, paramInt, 9501, paramLong);
      localMessageForGrayTips.isread = paramBoolean1;
      if (!paramBoolean2) {
        break;
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      localMessageForGrayTips.issend = paramInt;
      paramString1 = new ArrayList();
      paramString1.add(localMessageForGrayTips);
      a(paramString1);
      return;
      paramInt = -4505;
      break;
      paramInt = -4507;
      break;
      paramInt = -4506;
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    MessageForNewGrayTips localMessageForNewGrayTips;
    if (paramBoolean3)
    {
      i = -5001;
      localMessageForNewGrayTips = (MessageForNewGrayTips)bbli.a(i);
      localMessageForNewGrayTips.init(this.app.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong, i, 9501, paramLong);
      localMessageForNewGrayTips.isread = paramBoolean1;
      if (!paramBoolean2) {
        break label104;
      }
    }
    label104:
    for (int i = 1;; i = 0)
    {
      localMessageForNewGrayTips.issend = i;
      localMessageForNewGrayTips.spans = null;
      localMessageForNewGrayTips.updateMsgData();
      paramString1 = new ArrayList();
      paramString1.add(localMessageForNewGrayTips);
      a(paramString1);
      return;
      i = -5000;
      break;
    }
  }
  
  public boolean a(String paramString, aasp paramaasp)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    if (!((List)localObject).contains(paramaasp)) {
      ((List)localObject).add(paramaasp);
    }
    return true;
  }
  
  public boolean b(String paramString, aasp paramaasp)
  {
    paramString = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      paramString.remove(paramaasp);
    }
    return true;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return BusinessObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(f, this.jdField_a_of_type_Aasi);
    b(e, this.jdField_a_of_type_Aasi);
    b(g, this.jdField_a_of_type_Aasi);
    b(g, this.jdField_a_of_type_Aave);
    b(jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Aavi);
    b(c, this.jdField_a_of_type_Aavi);
    b(d, this.jdField_a_of_type_Aavi);
    b(h, this.jdField_a_of_type_Aavi);
    b("8000-NASDevMusicFile", this.jdField_a_of_type_Aavi);
    b("8001-NASDevVideoFile", this.jdField_a_of_type_Aavi);
    b("8002-NASDevDocumentFile", this.jdField_a_of_type_Aavi);
    b("8003-NASDevCommonFile", this.jdField_a_of_type_Aavi);
    b("", this.jdField_a_of_type_Aavi);
    b("", this.jdField_a_of_type_Aasi);
    this.app.removeObserver(this.jdField_a_of_type_Aasp);
    this.app.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.app.removeObserver(this.jdField_a_of_type_Anau);
    this.jdField_a_of_type_Aavi = null;
    this.jdField_a_of_type_Aave = null;
    this.jdField_a_of_type_Aasi = null;
    this.jdField_a_of_type_Aavj = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aavk
 * JD-Core Version:    0.7.0.1
 */