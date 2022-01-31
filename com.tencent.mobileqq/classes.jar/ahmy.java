import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import java.io.File;

public class ahmy
  implements bftq
{
  private static ahmy jdField_a_of_type_Ahmy;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ahmz jdField_a_of_type_Ahmz;
  private String jdField_a_of_type_JavaLangString = "";
  
  private ahmy()
  {
    a();
    SDCardMountMonitorReceiver.a().a(this);
  }
  
  public static ahmy a()
  {
    if (jdField_a_of_type_Ahmy == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ahmy == null) {
        jdField_a_of_type_Ahmy = new ahmy();
      }
      return jdField_a_of_type_Ahmy;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = bftg.b();
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
    String str = bftg.b();
    if ((this.jdField_a_of_type_Ahmz != null) && (!str.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Ahmz.a(1, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ahmz.a(0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahmy
 * JD-Core Version:    0.7.0.1
 */