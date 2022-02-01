import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.DeviceCommonMsgProcessor;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class aasi
  extends aasp
{
  aase jdField_a_of_type_Aase = new aase();
  aash jdField_a_of_type_Aash = new aash();
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new aasj(this, Looper.getMainLooper());
  private final ArrayList<aask> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet(10);
  private ConcurrentHashMap<String, aasn> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  private ConcurrentHashMap<Long, Long> b = new ConcurrentHashMap(10);
  
  private void a(long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramLong1 + ""))
    {
      paramString = new aasn(this, paramString, paramLong2, paramInt, "", 0L);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(paramLong1), paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceAVFileMsgObserver", 2, "found resume");
  }
  
  private void b(Session paramSession, boolean paramBoolean)
  {
    aasn localaasn = (aasn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    if (localaasn == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(aavk.e))
    {
      this.jdField_a_of_type_Aash.a(paramSession, localaasn.jdField_a_of_type_JavaLangString, localaasn.jdField_a_of_type_Long, localaasn.jdField_a_of_type_Int, paramBoolean);
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = (QQAppInterface)localObject1;
        localObject2 = ((aara)((QQAppInterface)localObject1).getBusinessHandler(51)).a(Long.parseLong(localaasn.jdField_a_of_type_JavaLangString));
        if (localObject2 == null) {
          break label377;
        }
      }
    }
    label157:
    label170:
    label364:
    label377:
    for (int i = ((DeviceInfo)localObject2).productId;; i = 0)
    {
      if (localObject2 != null) {}
      for (long l = ((DeviceInfo)localObject2).din;; l = 0L)
      {
        int j;
        if (paramSession.actionInfo.strServiceName.compareTo(aavk.f) == 0) {
          if (paramBoolean)
          {
            j = 0;
            abdm.a((AppRuntime)localObject1, l, "Net_SendMsg_Audio", 0, j, i);
            localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
            if (localObject1 != null) {
              ((MqqHandler)localObject1).sendEmptyMessage(1009);
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
            localObject2 = new aasm(this);
            if (!paramBoolean) {
              break label364;
            }
          }
        }
        for (i = 1003;; i = 1005)
        {
          ((aasm)localObject2).jdField_a_of_type_Int = i;
          ((aasm)localObject2).jdField_a_of_type_Long = localaasn.jdField_a_of_type_Long;
          ((Message)localObject1).obj = localObject2;
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject1, 0L);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(String.valueOf(paramSession.uSessionID));
          return;
          if (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(aavk.f)) {
            break;
          }
          this.jdField_a_of_type_Aase.a(paramSession, localaasn.jdField_a_of_type_JavaLangString, localaasn.jdField_a_of_type_Long, localaasn.jdField_a_of_type_Int, paramBoolean);
          break;
          j = 1;
          break label157;
          if (paramSession.actionInfo.strServiceName.compareTo(aavk.e) != 0) {
            break label170;
          }
          if (paramBoolean) {}
          for (j = 0;; j = 1)
          {
            abdm.a((AppRuntime)localObject1, l, "Net_SendMsg_Video", 0, j, i);
            break;
          }
        }
      }
    }
  }
  
  private void c(Session paramSession)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)bbli.a(-4503);
      localMessageForDevShortVideo.videoFileName = paramSession.strFilePathSrc;
      localMessageForDevShortVideo.msgtype = -4503;
      localMessageForDevShortVideo.istroop = 9501;
      localMessageForDevShortVideo.issend = 0;
      localMessageForDevShortVideo.isread = false;
      localMessageForDevShortVideo.selfuin = ((QQAppInterface)localObject).getCurrentAccountUin();
      localMessageForDevShortVideo.senderuin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevShortVideo.frienduin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevShortVideo.uuid = "";
      localMessageForDevShortVideo.videoFileFormat = 2;
      localMessageForDevShortVideo.videoFileSize = ((int)paramSession.uFileSizeSrc);
      localMessageForDevShortVideo.videoFileStatus = 2000;
      localMessageForDevShortVideo.videoFileProgress = 0;
      localMessageForDevShortVideo.fileType = 19;
      localMessageForDevShortVideo.lastModified = 0L;
      localMessageForDevShortVideo.fileSessionId = paramSession.uSessionID;
      localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
      localMessageForDevShortVideo.serial();
      a(paramSession.uSessionID, localMessageForDevShortVideo.frienduin, localMessageForDevShortVideo.uniseq, localMessageForDevShortVideo.istroop);
      ((QQAppInterface)localObject).getMessageFacade().addMessage(localMessageForDevShortVideo, ((QQAppInterface)localObject).getCurrentAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("DeviceAVFileMsgObserver", 2, "recievemsg msg.uniseq:" + localMessageForDevShortVideo.uniseq + " ===> filesize:" + localMessageForDevShortVideo.videoFileSize + " fileStatus:" + ShortVideoUtils.getFileStatusStr(localMessageForDevShortVideo.videoFileStatus));
      }
    }
  }
  
  public String a(DataPoint paramDataPoint)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramDataPoint.mValue);
        long l1 = ((JSONObject)localObject1).optLong("msg_time", bbko.a());
        long l2 = ((JSONObject)localObject1).optLong("duration", 0L);
        String str2 = ((JSONObject)localObject1).optString("file_key", "");
        String str3 = ((JSONObject)localObject1).optString("file_url", "");
        String str1 = ((JSONObject)localObject1).optString("file_mini", "");
        if (TextUtils.isEmpty(str1))
        {
          str1 = ((JSONObject)localObject1).optString("media_mini", "");
          localObject1 = ((JSONObject)localObject1).optString("fkey2", "");
          Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject2 instanceof QQAppInterface))
          {
            localObject2 = (QQAppInterface)localObject2;
            if (QLog.isColorLevel()) {
              QLog.d("DeviceAVFileMsgObserver", 2, "receive audiomsg length:" + l2);
            }
            MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)bbli.a(-4501);
            localMessageForDevPtt.url = "";
            localMessageForDevPtt.channeltype = 1;
            localMessageForDevPtt.urlAtServer = str2;
            if (!TextUtils.isEmpty(str3))
            {
              localMessageForDevPtt.channeltype = 2;
              localMessageForDevPtt.urlAtServer = str3;
              localMessageForDevPtt.itemType = 2;
              localMessageForDevPtt.sttAbility = 0;
              localMessageForDevPtt.longPttVipFlag = 0;
              localMessageForDevPtt.c2cViaOffline = true;
              localMessageForDevPtt.msgtype = -4501;
              localMessageForDevPtt.istroop = 9501;
              localMessageForDevPtt.issend = 0;
              localMessageForDevPtt.isread = false;
              localMessageForDevPtt.selfuin = ((QQAppInterface)localObject2).getCurrentAccountUin();
              localMessageForDevPtt.senderuin = Long.toString(paramDataPoint.mDin);
              localMessageForDevPtt.frienduin = Long.toString(paramDataPoint.mDin);
              localMessageForDevPtt.time = l1;
              localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
              localMessageForDevPtt.voiceLength = ((int)l2);
              if (QLog.isColorLevel()) {
                QLog.d("DeviceAVFileMsgObserver", 2, "voiceLength onReceiveAudioMsg " + localMessageForDevPtt.voiceLength);
              }
              localMessageForDevPtt.serial();
              localMessageForDevPtt.saveExtInfoToExtStr("smartdevice_ptt_channeltype", String.valueOf(localMessageForDevPtt.channeltype));
              ((QQAppInterface)localObject2).getMessageFacade().addMessage(localMessageForDevPtt, ((QQAppInterface)localObject2).getCurrentAccountUin());
              return localMessageForDevPtt.msg;
            }
            if (TextUtils.isEmpty(str1)) {
              continue;
            }
            localMessageForDevPtt.channeltype = 3;
            localMessageForDevPtt.urlAtServer = str1;
            localMessageForDevPtt.strFileKey2 = ((String)localObject1);
            continue;
          }
          return "";
        }
      }
      catch (JSONException paramDataPoint)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceAVFileMsgObserver", 2, "getString from json error:" + paramDataPoint.getMessage());
        }
      }
    }
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    float f;
    do
    {
      return;
      int i = paramBundle.getInt("cookie", 0);
      f = paramBundle.getFloat("percent", 0.0F);
      localObject = new Session();
      ((Session)localObject).uSessionID = i;
      paramBundle = (aasn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(i));
    } while (paramBundle == null);
    this.jdField_a_of_type_Aase.a((Session)localObject, paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_a_of_type_Long, paramBundle.jdField_a_of_type_Int, f);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    aasm localaasm = new aasm(this);
    localaasm.jdField_a_of_type_Int = 1002;
    localaasm.jdField_a_of_type_Float = f;
    localaasm.jdField_a_of_type_Long = paramBundle.jdField_a_of_type_Long;
    ((Message)localObject).obj = localaasm;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject, 0L);
  }
  
  void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "handleMessage" + ((aasm)paramMessage.obj).jdField_a_of_type_Long + " status " + paramMessage.what + "retCode " + paramMessage.arg1);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (aask)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((aask)localObject).a();
      localObject = ((aask)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((aasl)localObject).a(localView, (aasm)paramMessage.obj);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
      }
    }
  }
  
  public void a(View paramView, aasl paramaasl)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aask localaask = (aask)localIterator.next();
      if (localaask.a() == paramView)
      {
        localaask.b = new WeakReference(paramaasl);
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new aask(this, paramView, paramaasl));
  }
  
  public void a(MessageForDevPtt paramMessageForDevPtt)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramMessageForDevPtt.uniseq))) {}
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            return;
            if (!this.b.containsKey(Long.valueOf(paramMessageForDevPtt.uniseq))) {
              break;
            }
            l = ((Long)this.b.get(Long.valueOf(paramMessageForDevPtt.uniseq))).longValue();
          } while (bbko.a() - l < 3600L);
        } while (TextUtils.isEmpty(paramMessageForDevPtt.urlAtServer));
        localObject = BaseApplicationImpl.getApplication().getRuntime();
      } while (!(localObject instanceof QQAppInterface));
      Object localObject = (QQAppInterface)localObject;
      DeviceFileHandler localDeviceFileHandler = (DeviceFileHandler)((QQAppInterface)localObject).getBusinessHandler(50);
      if (paramMessageForDevPtt.channeltype == 0) {}
      try
      {
        paramMessageForDevPtt.channeltype = Integer.parseInt(paramMessageForDevPtt.getExtInfoFromExtStr("smartdevice_ptt_channeltype"));
        l = localDeviceFileHandler.a((QQAppInterface)localObject, paramMessageForDevPtt.urlAtServer, paramMessageForDevPtt.strFileKey2, paramMessageForDevPtt.channeltype, 2108);
        this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramMessageForDevPtt.uniseq));
        localObject = String.valueOf(l);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          paramMessageForDevPtt = new aasn(this, paramMessageForDevPtt.frienduin, paramMessageForDevPtt.uniseq, paramMessageForDevPtt.istroop, "", 0L);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, paramMessageForDevPtt);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("DeviceAVFileMsgObserver", 2, "found resume");
  }
  
  public void a(Session paramSession)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "onServiceSessionNew : service@" + paramSession.actionInfo.strServiceName);
    }
    if ((!paramSession.bSend) && (paramSession.actionInfo.strServiceName.equalsIgnoreCase(aavk.e))) {
      c(paramSession);
    }
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "onServiceSessionProgress : service@" + paramSession.actionInfo.strServiceName);
    }
    aasn localaasn = (aasn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    Message localMessage;
    aasm localaasm;
    if (localaasn != null)
    {
      if (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(aavk.e)) {
        break label165;
      }
      this.jdField_a_of_type_Aash.a(paramSession, localaasn.jdField_a_of_type_JavaLangString, localaasn.jdField_a_of_type_Long, localaasn.jdField_a_of_type_Int, paramFloat);
      localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
      localaasm = new aasm(this);
      if (!paramSession.bSend) {
        break label205;
      }
    }
    label165:
    label205:
    for (localaasm.jdField_a_of_type_Int = 1002;; localaasm.jdField_a_of_type_Int = 2002)
    {
      localaasm.jdField_a_of_type_Float = paramFloat;
      localaasm.jdField_a_of_type_Long = localaasn.jdField_a_of_type_Long;
      localMessage.obj = localaasm;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
      return;
      if (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(aavk.f)) {
        break;
      }
      this.jdField_a_of_type_Aase.a(paramSession, localaasn.jdField_a_of_type_JavaLangString, localaasn.jdField_a_of_type_Long, localaasn.jdField_a_of_type_Int, paramFloat);
      break;
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "onServiceSessionComplete : service@" + paramSession.actionInfo.strServiceName);
    }
    if (paramSession == null) {
      QLog.e("DeviceAVFileMsgObserver", 1, "onServiceSessionComplete, session == null !!!!!");
    }
    aasn localaasn;
    do
    {
      return;
      if (paramSession.bSend)
      {
        b(paramSession, paramBoolean);
        return;
      }
      localaasn = (aasn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    } while (localaasn == null);
    label135:
    Object localObject1;
    Object localObject2;
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(aavk.e))
    {
      DeviceCommonMsgProcessor.a(paramSession, paramBoolean);
      this.jdField_a_of_type_Aash.a(paramSession, localaasn.jdField_a_of_type_JavaLangString, localaasn.jdField_a_of_type_Long, localaasn.jdField_a_of_type_Int, paramBoolean);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
      localObject2 = new aasm(this);
      if (!paramBoolean) {
        break label432;
      }
    }
    label432:
    for (int i = 2003;; i = 2005)
    {
      ((aasm)localObject2).jdField_a_of_type_Int = i;
      ((aasm)localObject2).jdField_a_of_type_Long = localaasn.jdField_a_of_type_Long;
      ((Message)localObject1).obj = localObject2;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject1, 0L);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(String.valueOf(paramSession.uSessionID));
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(localaasn.jdField_a_of_type_Long));
      if (!paramBoolean) {
        break label439;
      }
      this.b.remove(Long.valueOf(localaasn.jdField_a_of_type_Long));
      return;
      if ((paramSession.actionInfo.strServiceName.equalsIgnoreCase(aavk.f)) || (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(aavk.g))) {
        break label135;
      }
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject1 instanceof QQAppInterface)) {
        break label135;
      }
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = ((QQAppInterface)localObject1).getMessageFacade().getMsgItemByUniseq(localaasn.jdField_a_of_type_JavaLangString, localaasn.jdField_a_of_type_Int, localaasn.jdField_a_of_type_Long);
      if (localObject2 == null) {
        break;
      }
      if (!(localObject2 instanceof MessageForDevPtt)) {
        break label135;
      }
      MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)localObject2;
      localMessageForDevPtt.url = paramSession.strFilePathSrc;
      if (paramBoolean) {}
      for (localMessageForDevPtt.fileSize = aszt.a(paramSession.strFilePathSrc);; localMessageForDevPtt.fileSize = -1L)
      {
        localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
        localMessageForDevPtt.serial();
        ((QQAppInterface)localObject1).getMessageFacade().updateMsgContentByUniseq(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, localMessageForDevPtt.msgData);
        break;
      }
    }
    label439:
    this.b.put(Long.valueOf(localaasn.jdField_a_of_type_Long), Long.valueOf(bbko.a()));
  }
  
  public void a(MessageRecord paramMessageRecord, float paramFloat)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    aasm localaasm = new aasm(this);
    localaasm.jdField_a_of_type_Int = 1002;
    localaasm.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localaasm.jdField_a_of_type_Float = paramFloat;
    localMessage.obj = localaasm;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
  }
  
  public void a(MessageRecord paramMessageRecord, Boolean paramBoolean)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    aasm localaasm = new aasm(this);
    int i;
    if (paramBoolean.booleanValue())
    {
      i = 1003;
      localaasm.jdField_a_of_type_Int = i;
      localaasm.jdField_a_of_type_Long = paramMessageRecord.uniseq;
      if (!paramBoolean.booleanValue()) {
        break label89;
      }
    }
    label89:
    for (float f = 1.0F;; f = 0.0F)
    {
      localaasm.jdField_a_of_type_Float = f;
      localMessage.obj = localaasm;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
      return;
      i = 1005;
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = (aara)((QQAppInterface)localObject1).getBusinessHandler(51);
      if ((!paramString1.equalsIgnoreCase(aavk.f)) || (localObject2 == null) || (!((aara)localObject2).b(paramLong1))) {
        break label192;
      }
      localObject1 = new Session();
      ((Session)localObject1).uSessionID = ((aara)localObject2).a(paramLong1, paramString2, paramInt2);
      ((Session)localObject1).strFilePathSrc = paramString2;
      ((Session)localObject1).uFileSizeSrc = aszt.a(paramString2);
      localObject2 = String.valueOf(((Session)localObject1).uSessionID);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject2)) {
        break label221;
      }
      paramString2 = new aasn(this, String.valueOf(paramLong1), paramLong2, paramInt1, paramString2, ((Session)localObject1).uFileSizeSrc);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, paramString2);
      label154:
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        if (!paramString1.equalsIgnoreCase(aavk.e)) {
          break label238;
        }
        this.jdField_a_of_type_Aash.a((Session)localObject1, String.valueOf(paramLong1), paramLong2, paramInt1, false);
      }
    }
    label192:
    label221:
    label238:
    while (!paramString1.equalsIgnoreCase(aavk.f))
    {
      return;
      localObject2 = ((DeviceFileHandler)((QQAppInterface)localObject1).getBusinessHandler(50)).a(paramString2, paramString1, null, paramLong1);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      return;
      if (!QLog.isColorLevel()) {
        break label154;
      }
      QLog.d("DeviceAVFileMsgObserver", 2, "found resume");
      break label154;
    }
    this.jdField_a_of_type_Aase.a((Session)localObject1, String.valueOf(paramLong1), paramLong2, paramInt1, false);
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((aasn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Long == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public void b(Bundle paramBundle)
  {
    boolean bool = true;
    if (paramBundle == null) {}
    aasn localaasn;
    do
    {
      return;
      j = paramBundle.getInt("cookie", 0);
      i = paramBundle.getInt("err_code", 1);
      paramBundle = new Session();
      paramBundle.uSessionID = j;
      localaasn = (aasn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramBundle.uSessionID));
    } while (localaasn == null);
    paramBundle.strFilePathSrc = localaasn.jdField_b_of_type_JavaLangString;
    paramBundle.uFileSizeSrc = localaasn.jdField_b_of_type_Long;
    Object localObject1 = this.jdField_a_of_type_Aase;
    Object localObject2 = localaasn.jdField_a_of_type_JavaLangString;
    long l = localaasn.jdField_a_of_type_Long;
    int j = localaasn.jdField_a_of_type_Int;
    if (i == 0)
    {
      ((aase)localObject1).a(paramBundle, (String)localObject2, l, j, bool);
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = (QQAppInterface)localObject1;
        localObject2 = ((aara)((QQAppInterface)localObject1).getBusinessHandler(51)).a(Long.parseLong(localaasn.jdField_a_of_type_JavaLangString));
        if (localObject2 != null) {
          j = ((DeviceInfo)localObject2).productId;
        }
        if (localObject2 != null) {
          l = ((DeviceInfo)localObject2).din;
        }
        localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).sendEmptyMessage(1009);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
      localObject2 = new aasm(this);
      if (i != 0) {
        break label300;
      }
    }
    label300:
    for (int i = 1003;; i = 1005)
    {
      ((aasm)localObject2).jdField_a_of_type_Int = i;
      ((aasm)localObject2).jdField_a_of_type_Long = localaasn.jdField_a_of_type_Long;
      ((Message)localObject1).obj = localObject2;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject1, 0L);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(String.valueOf(paramBundle.uSessionID));
      return;
      bool = false;
      break;
    }
  }
  
  public void b(Session paramSession)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "onServiceSessionStart : service@" + paramSession.actionInfo.strServiceName);
    }
    aasn localaasn = (aasn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    if (localaasn == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    aasm localaasm = new aasm(this);
    if (paramSession.bSend) {}
    for (localaasm.jdField_a_of_type_Int = 1001;; localaasm.jdField_a_of_type_Int = 2001)
    {
      localaasm.jdField_a_of_type_Long = localaasn.jdField_a_of_type_Long;
      localMessage.obj = localaasm;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
      return;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, float paramFloat)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    aasm localaasm = new aasm(this);
    if (paramMessageRecord.isSendFromLocal()) {}
    for (int i = 1002;; i = 2002)
    {
      localaasm.jdField_a_of_type_Int = i;
      localaasm.jdField_a_of_type_Long = paramMessageRecord.uniseq;
      localaasm.jdField_a_of_type_Float = paramFloat;
      localMessage.obj = localaasm;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
      return;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, Boolean paramBoolean)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    aasm localaasm = new aasm(this);
    int i;
    if (paramMessageRecord.isSendFromLocal()) {
      if (paramBoolean.booleanValue())
      {
        i = 1003;
        localaasm.jdField_a_of_type_Int = i;
        localaasm.jdField_a_of_type_Long = paramMessageRecord.uniseq;
        if (!paramBoolean.booleanValue()) {
          break label119;
        }
      }
    }
    label119:
    for (float f = 1.0F;; f = 0.0F)
    {
      localaasm.jdField_a_of_type_Float = f;
      localMessage.obj = localaasm;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
      return;
      i = 1005;
      break;
      if (paramBoolean.booleanValue())
      {
        i = 2003;
        break;
      }
      i = 2005;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasi
 * JD-Core Version:    0.7.0.1
 */