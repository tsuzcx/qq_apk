import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import java.io.File;

public class alod
  implements blwq
{
  private static alod jdField_a_of_type_Alod;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private aloe jdField_a_of_type_Aloe;
  private String jdField_a_of_type_JavaLangString = "";
  
  private alod()
  {
    a();
    SDCardMountMonitorReceiver.a().a(this);
  }
  
  public static alod a()
  {
    if (jdField_a_of_type_Alod == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Alod == null) {
        jdField_a_of_type_Alod = new alod();
      }
      return jdField_a_of_type_Alod;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = blwf.b();
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
    String str = blwf.b();
    if ((this.jdField_a_of_type_Aloe != null) && (!str.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Aloe.a(1, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Aloe.a(0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alod
 * JD-Core Version:    0.7.0.1
 */