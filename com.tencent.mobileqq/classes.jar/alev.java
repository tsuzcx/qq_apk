import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class alev
  implements ITransactionCallback
{
  alev(alet paramalet, algs paramalgs, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (alet.a(this.jdField_a_of_type_Alet))
      {
        if (alet.a(this.jdField_a_of_type_Alet) != null)
        {
          int i = 0;
          if (i < alet.a(this.jdField_a_of_type_Alet).size())
          {
            if (((aley)alet.a(this.jdField_a_of_type_Alet).get(i)).jdField_a_of_type_Algs.a.equals(this.jdField_a_of_type_Algs.a))
            {
              paramArrayOfByte = ((aley)alet.a(this.jdField_a_of_type_Alet).get(i)).jdField_a_of_type_Alew;
              str = ((aley)alet.a(this.jdField_a_of_type_Alet).get(i)).jdField_a_of_type_Algs.a;
              alet.a(this.jdField_a_of_type_Alet).remove(i);
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
    Object localObject3 = alet.a(this.jdField_a_of_type_Alet);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (alet.a(this.jdField_a_of_type_Alet) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < alet.a(this.jdField_a_of_type_Alet).size())
          {
            if (!((aley)alet.a(this.jdField_a_of_type_Alet).get(i)).jdField_a_of_type_Algs.a.equals(this.jdField_a_of_type_Algs.a)) {
              continue;
            }
            localObject1 = ((aley)alet.a(this.jdField_a_of_type_Alet).get(i)).jdField_a_of_type_Alew;
            str1 = ((aley)alet.a(this.jdField_a_of_type_Alet).get(i)).jdField_a_of_type_Algs.a;
            alet.a(this.jdField_a_of_type_Alet).remove(i);
          }
        }
        paramArrayOfByte = alet.a(this.jdField_a_of_type_Alet, paramArrayOfByte, this.jdField_a_of_type_Algs);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((alew)localObject1).a(i, str1, paramArrayOfByte);
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
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_Algs.a);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_Algs.a + ". total size = " + this.jdField_a_of_type_Long + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alev
 * JD-Core Version:    0.7.0.1
 */