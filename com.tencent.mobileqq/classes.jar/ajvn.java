import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import java.io.File;

public class ajvn
  implements bjii
{
  private static ajvn jdField_a_of_type_Ajvn;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ajvo jdField_a_of_type_Ajvo;
  private String jdField_a_of_type_JavaLangString = "";
  
  private ajvn()
  {
    a();
    SDCardMountMonitorReceiver.a().a(this);
  }
  
  public static ajvn a()
  {
    if (jdField_a_of_type_Ajvn == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ajvn == null) {
        jdField_a_of_type_Ajvn = new ajvn();
      }
      return jdField_a_of_type_Ajvn;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = bjhx.b();
    if (QLog.isColorLevel()) {
      QLog.d("StorageManager", 2, "updateStorePath, storeVideoPath=" + this.jdField_a_of_type_JavaLangString);
    }
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("StorageManager", 2, "create root path directory error", localException);
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StorageManager", 2, "sdcard mount receiver, isMount=" + paramBoolean);
    }
    String str = bjhx.b();
    if ((this.jdField_a_of_type_Ajvo != null) && (!str.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Ajvo.a(1, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ajvo.a(0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvn
 * JD-Core Version:    0.7.0.1
 */