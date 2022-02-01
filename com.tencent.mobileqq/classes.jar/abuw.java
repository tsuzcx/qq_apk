import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class abuw
  extends absc
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<absd> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<Long, abse> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  private ConcurrentHashMap<Long, Long> b = new ConcurrentHashMap(10);
  
  public abuw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private long a(MessageForDeviceFile paramMessageForDeviceFile, View paramView, arhk paramarhk)
  {
    long l1;
    if ((paramMessageForDeviceFile == null) || (TextUtils.isEmpty(paramMessageForDeviceFile.strMediaKey)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceGroupChatMsgProcessor", 2, "mr is null or strCoverKey is empty in downloadCoverFile!");
      }
      l1 = 0L;
      return l1;
    }
    if (!bgnt.d(BaseApplication.getContext())) {
      return 0L;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      absd localabsd = (absd)localIterator.next();
      if (localabsd.a() == paramView) {
        localabsd.b = new WeakReference(paramarhk);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new absd(this, paramView, paramarhk));
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramMessageForDeviceFile.uSessionID))) {
        return paramMessageForDeviceFile.uSessionID;
      }
      if (this.b.containsKey(Long.valueOf(paramMessageForDeviceFile.uniseq)))
      {
        l1 = ((Long)this.b.get(Long.valueOf(paramMessageForDeviceFile.uniseq))).longValue();
        if (bbyp.a() - l1 < 3600L) {
          return paramMessageForDeviceFile.uSessionID;
        }
      }
      long l2 = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForDeviceFile.strMediaKey, paramMessageForDeviceFile.strFileKey2, 3, 2154);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
      if ((paramView instanceof MessageForDeviceFile)) {
        ((MessageForDeviceFile)paramView).uSessionID = l2;
      }
      paramMessageForDeviceFile.uSessionID = l2;
      l1 = l2;
      if (l2 == 0L) {
        break;
      }
      a(l2, paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
      return l2;
    }
  }
  
  private MessageRecord a(long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("duration", 0);
    String str = paramJSONObject.optString("file_key", "");
    paramJSONObject = paramJSONObject.optString("fkey2", "");
    MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)bbzh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(paramLong2), null, 9501);
    localMessageForDevPtt.url = "";
    localMessageForDevPtt.urlAtServer = str;
    localMessageForDevPtt.strFileKey2 = paramJSONObject;
    localMessageForDevPtt.channeltype = 3;
    localMessageForDevPtt.itemType = 2;
    localMessageForDevPtt.sttAbility = 0;
    localMessageForDevPtt.longPttVipFlag = 0;
    localMessageForDevPtt.c2cViaOffline = true;
    localMessageForDevPtt.msgtype = -4501;
    localMessageForDevPtt.istroop = 9501;
    localMessageForDevPtt.issend = 0;
    localMessageForDevPtt.isread = false;
    localMessageForDevPtt.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForDevPtt.senderuin = Long.toString(paramLong1);
    localMessageForDevPtt.frienduin = Long.toString(paramLong2);
    localMessageForDevPtt.time = bbyp.a();
    localMessageForDevPtt.msg = (bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForDevPtt.senderuin, true) + ": " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691134));
    localMessageForDevPtt.voiceLength = i;
    localMessageForDevPtt.extStr = "device_groupchat";
    localMessageForDevPtt.serial();
    return localMessageForDevPtt;
  }
  
  private void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new abse(this, paramString, paramInt, paramLong2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceGroupChatMsgProcessor", 2, "found resume");
  }
  
  private MessageRecord b(long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("media_key", "");
    String str2 = paramJSONObject.optString("cover_key", "");
    String str3 = paramJSONObject.optString("fkey2", "");
    paramJSONObject = paramJSONObject.optString("ckey2", "");
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)bbzh.a(-4500);
    localMessageForDeviceFile.strServiceName = abux.d;
    localMessageForDeviceFile.msgtype = -4500;
    localMessageForDeviceFile.istroop = 9501;
    localMessageForDeviceFile.filePath = "";
    localMessageForDeviceFile.issend = 0;
    localMessageForDeviceFile.isread = false;
    localMessageForDeviceFile.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForDeviceFile.senderuin = Long.toString(paramLong1);
    localMessageForDeviceFile.frienduin = Long.toString(paramLong2);
    localMessageForDeviceFile.msgStatus = 3;
    localMessageForDeviceFile.nFileStatus = 1;
    localMessageForDeviceFile.time = bbyp.a();
    localMessageForDeviceFile.msg = (bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForDeviceFile.senderuin, true) + ": " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691400));
    localMessageForDeviceFile.nFileMsgType = 2;
    localMessageForDeviceFile.extStr = "device_groupchat";
    localMessageForDeviceFile.strCoverKey = str2;
    localMessageForDeviceFile.strMediaKey = str1;
    localMessageForDeviceFile.strFileKey2 = str3;
    localMessageForDeviceFile.strCoverKey2 = paramJSONObject;
    localMessageForDeviceFile.serial();
    return localMessageForDeviceFile;
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (absd)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((absd)localObject).a();
      localObject = ((absd)localObject).a();
      if ((localView != null) && (localObject != null))
      {
        j = i;
        if ((paramMessageRecord instanceof MessageForDeviceFile)) {
          ((arhk)localObject).a(localView, (MessageForDeviceFile)paramMessageRecord);
        }
      }
      for (int j = i;; j = i - 1)
      {
        i = j + 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
  }
  
  public long a(MessageRecord paramMessageRecord, View paramView, arhk paramarhk)
  {
    if ((paramMessageRecord instanceof MessageForDeviceFile)) {
      return a((MessageForDeviceFile)paramMessageRecord, paramView, paramarhk);
    }
    return 0L;
  }
  
  protected MessageRecord a(long paramLong)
  {
    Object localObject1 = (abse)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject2 instanceof QQAppInterface)) {
        break;
      }
      localObject2 = ((QQAppInterface)localObject2).a().a(((abse)localObject1).jdField_a_of_type_JavaLangString, ((abse)localObject1).jdField_a_of_type_Int, ((abse)localObject1).jdField_a_of_type_Long);
      localObject1 = localObject2;
    } while (localObject2 != null);
    if (QLog.isColorLevel()) {
      QLog.d("DeviceGroupChatMsgProcessor", 2, "device file msg null");
    }
    return null;
    return null;
  }
  
  public void a(DataPoint paramDataPoint)
  {
    try
    {
      localJSONObject = new JSONObject(paramDataPoint.mValue);
      l2 = localJSONObject.optLong("from_uin");
      l1 = l2;
      if (0L == l2) {
        l1 = paramDataPoint.mDin;
      }
      long l3 = localJSONObject.optLong("to_din");
      l2 = l3;
      if (0L == l3) {
        l2 = paramDataPoint.mDin;
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        return;
      }
      localMessageRecord = null;
      if (10011 != paramDataPoint.mProperityId) {
        break label177;
      }
      localMessageRecord = a(l1, l2, localJSONObject);
    }
    catch (JSONException paramDataPoint)
    {
      JSONObject localJSONObject;
      long l2;
      long l1;
      MessageRecord localMessageRecord;
      while (QLog.isColorLevel())
      {
        QLog.d("DeviceGroupChatMsgProcessor", 2, "getString from json error:" + paramDataPoint.getMessage());
        return;
        label177:
        if (10010 == paramDataPoint.mProperityId) {
          localMessageRecord = b(l1, l2, localJSONObject);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return;
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (!paramSession.bSend)
    {
      localMessageRecord = a(paramSession.uSessionID);
      if (localMessageRecord != null) {
        break label21;
      }
    }
    label21:
    label156:
    do
    {
      return;
      MessageForDeviceFile localMessageForDeviceFile;
      if ((localMessageRecord instanceof MessageForDeviceFile))
      {
        localMessageForDeviceFile = (MessageForDeviceFile)localMessageRecord;
        if (localMessageForDeviceFile.uSessionID != paramSession.uSessionID) {
          continue;
        }
        localMessageForDeviceFile.filePath = paramSession.strFilePathSrc;
        localMessageForDeviceFile.progress = 1.0F;
        if (!paramBoolean) {
          break label156;
        }
        localMessageForDeviceFile.nFileStatus = 5;
        this.b.remove(Long.valueOf(localMessageRecord.uniseq));
      }
      for (;;)
      {
        localMessageForDeviceFile.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 9501, localMessageRecord.uniseq, localMessageRecord.msgData);
        if ((localMessageForDeviceFile.uSessionID == paramSession.uSessionID) && (paramBoolean)) {
          b(localMessageForDeviceFile);
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramSession.uSessionID));
        return;
        localMessageForDeviceFile.nFileStatus = 6;
        this.b.put(Long.valueOf(localMessageRecord.uniseq), Long.valueOf(bbyp.a()));
      }
    } while (!QLog.isColorLevel());
    QLog.d("DeviceGroupChatMsgProcessor", 2, "error:can not find session id in message record");
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject = (DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50);
    long l;
    if ((paramMessageRecord instanceof MessageForDeviceFile))
    {
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramMessageRecord;
      l = ((DeviceFileHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForDeviceFile.strMediaKey, localMessageForDeviceFile.strFileKey2, 3, 2154);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      if ((localObject instanceof MessageForDeviceFile)) {
        ((MessageForDeviceFile)localObject).uSessionID = l;
      }
      localMessageForDeviceFile.uSessionID = l;
    }
    for (;;)
    {
      if (l != 0L) {
        a(l, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      }
      return;
      l = 0L;
    }
  }
  
  public void b(Session paramSession)
  {
    Object localObject;
    if (!paramSession.bSend)
    {
      localObject = a(paramSession.uSessionID);
      if (localObject != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof MessageForDeviceFile));
      localObject = (MessageForDeviceFile)localObject;
    } while (((MessageForDeviceFile)localObject).uSessionID != paramSession.uSessionID);
    ((MessageForDeviceFile)localObject).nFileStatus = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abuw
 * JD-Core Version:    0.7.0.1
 */