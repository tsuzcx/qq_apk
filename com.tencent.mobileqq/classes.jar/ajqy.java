import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import java.io.File;

public class ajqy
  implements bjeb
{
  private static ajqy jdField_a_of_type_Ajqy;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ajqz jdField_a_of_type_Ajqz;
  private String jdField_a_of_type_JavaLangString = "";
  
  private ajqy()
  {
    a();
    SDCardMountMonitorReceiver.a().a(this);
  }
  
  public static ajqy a()
  {
    if (jdField_a_of_type_Ajqy == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ajqy == null) {
        jdField_a_of_type_Ajqy = new ajqy();
      }
      return jdField_a_of_type_Ajqy;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = bjdq.b();
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
    String str = bjdq.b();
    if ((this.jdField_a_of_type_Ajqz != null) && (!str.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Ajqz.a(1, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ajqz.a(0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqy
 * JD-Core Version:    0.7.0.1
 */