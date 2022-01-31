import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class alew
  implements ITransactionCallback
{
  alew(aleu paramaleu, algt paramalgt, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (aleu.a(this.jdField_a_of_type_Aleu))
      {
        if (aleu.a(this.jdField_a_of_type_Aleu) != null)
        {
          int i = 0;
          if (i < aleu.a(this.jdField_a_of_type_Aleu).size())
          {
            if (((alez)aleu.a(this.jdField_a_of_type_Aleu).get(i)).jdField_a_of_type_Algt.a.equals(this.jdField_a_of_type_Algt.a))
            {
              paramArrayOfByte = ((alez)aleu.a(this.jdField_a_of_type_Aleu).get(i)).jdField_a_of_type_Alex;
              str = ((alez)aleu.a(this.jdField_a_of_type_Aleu).get(i)).jdField_a_of_type_Algt.a;
              aleu.a(this.jdField_a_of_type_Aleu).remove(i);
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
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    Object localObject2 = null;
    String str2 = "";
    Object localObject3 = aleu.a(this.jdField_a_of_type_Aleu);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (aleu.a(this.jdField_a_of_type_Aleu) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < aleu.a(this.jdField_a_of_type_Aleu).size())
          {
            if (!((alez)aleu.a(this.jdField_a_of_type_Aleu).get(i)).jdField_a_of_type_Algt.a.equals(this.jdField_a_of_type_Algt.a)) {
              continue;
            }
            localObject1 = ((alez)aleu.a(this.jdField_a_of_type_Aleu).get(i)).jdField_a_of_type_Alex;
            str1 = ((alez)aleu.a(this.jdField_a_of_type_Aleu).get(i)).jdField_a_of_type_Algt.a;
            aleu.a(this.jdField_a_of_type_Aleu).remove(i);
          }
        }
        paramArrayOfByte = aleu.a(this.jdField_a_of_type_Aleu, paramArrayOfByte, this.jdField_a_of_type_Algt);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((alex)localObject1).a(i, str1, paramArrayOfByte);
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
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_Algt.a);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_Algt.a + ". total size = " + this.jdField_a_of_type_Long + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alew
 * JD-Core Version:    0.7.0.1
 */