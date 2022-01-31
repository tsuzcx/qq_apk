import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class aaew
  implements ITransactionCallback
{
  public aaew(ARCloudFileUpload paramARCloudFileUpload, ARCloudReqInfo paramARCloudReqInfo, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload))
      {
        if (ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload) != null)
        {
          int i = 0;
          if (i < ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).size())
          {
            if (((aaex)ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.equals(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a))
            {
              paramArrayOfByte = ((aaex)ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback;
              str = ((aaex)ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a;
              ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).remove(i);
              QLog.i("AREngine_ARCloudFileUpload", 1, "Upload failed. retCode = " + paramInt + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str);
              if (paramArrayOfByte != null) {
                paramArrayOfByte.a(paramInt, str, null);
              }
              return;
            }
            i += 1;
          }
        }
      }
      paramArrayOfByte = null;
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    Object localObject2 = null;
    String str2 = "";
    Object localObject3 = ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).size())
          {
            if (!((aaex)ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.equals(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a)) {
              continue;
            }
            localObject1 = ((aaex)ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback;
            str1 = ((aaex)ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a;
            ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload).remove(i);
          }
        }
        paramArrayOfByte = ARCloudFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload, paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((ARCloudFileUpload.ARCloudFileUploadCallback)localObject1).a(i, str1, paramArrayOfByte);
          }
          return;
          i += 1;
          continue;
        }
        QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 0 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1);
      }
      finally {}
      int i = 0;
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a + ". total size = " + this.jdField_a_of_type_Long + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaew
 * JD-Core Version:    0.7.0.1
 */