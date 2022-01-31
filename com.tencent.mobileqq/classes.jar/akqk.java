import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class akqk
  implements ITransactionCallback
{
  akqk(akqi paramakqi, aksh paramaksh, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (akqi.a(this.jdField_a_of_type_Akqi))
      {
        if (akqi.a(this.jdField_a_of_type_Akqi) != null)
        {
          int i = 0;
          if (i < akqi.a(this.jdField_a_of_type_Akqi).size())
          {
            if (((akqn)akqi.a(this.jdField_a_of_type_Akqi).get(i)).jdField_a_of_type_Aksh.a.equals(this.jdField_a_of_type_Aksh.a))
            {
              paramArrayOfByte = ((akqn)akqi.a(this.jdField_a_of_type_Akqi).get(i)).jdField_a_of_type_Akql;
              str = ((akqn)akqi.a(this.jdField_a_of_type_Akqi).get(i)).jdField_a_of_type_Aksh.a;
              akqi.a(this.jdField_a_of_type_Akqi).remove(i);
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
    Object localObject3 = akqi.a(this.jdField_a_of_type_Akqi);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (akqi.a(this.jdField_a_of_type_Akqi) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < akqi.a(this.jdField_a_of_type_Akqi).size())
          {
            if (!((akqn)akqi.a(this.jdField_a_of_type_Akqi).get(i)).jdField_a_of_type_Aksh.a.equals(this.jdField_a_of_type_Aksh.a)) {
              continue;
            }
            localObject1 = ((akqn)akqi.a(this.jdField_a_of_type_Akqi).get(i)).jdField_a_of_type_Akql;
            str1 = ((akqn)akqi.a(this.jdField_a_of_type_Akqi).get(i)).jdField_a_of_type_Aksh.a;
            akqi.a(this.jdField_a_of_type_Akqi).remove(i);
          }
        }
        paramArrayOfByte = akqi.a(this.jdField_a_of_type_Akqi, paramArrayOfByte, this.jdField_a_of_type_Aksh);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((akql)localObject1).a(i, str1, paramArrayOfByte);
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
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_Aksh.a);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_Aksh.a + ". total size = " + this.jdField_a_of_type_Long + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akqk
 * JD-Core Version:    0.7.0.1
 */