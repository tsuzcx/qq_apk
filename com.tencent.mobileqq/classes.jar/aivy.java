import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ScribblePicUploadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aivy
  implements ITransactionCallback
{
  public aivy(ScribblePicUploadProcessor paramScribblePicUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.a(l2, l3, l4, l5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.b);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + " transInfo:" + str2);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.b.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.b.a = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.s = this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.q;
    paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
      ScribblePicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor, paramHashMap.bytes_download_url.get().toStringUtf8());
      if (ScribblePicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor) == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.a(-1, "URL IS NULL", "", this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.b);
        this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.d();
        this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.a(l2, l3, l4, l5);
        this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        ScribblePicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor);
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ScribblePicUploadProcessor localScribblePicUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.e = l;
    localScribblePicUploadProcessor.s = l;
    if ((paramInt <= this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.q) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.o) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.k)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileScribblePicUploadProcessor.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivy
 * JD-Core Version:    0.7.0.1
 */