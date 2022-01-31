import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import java.io.File;

public class ahzq
  implements bhca
{
  private static ahzq jdField_a_of_type_Ahzq;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ahzr jdField_a_of_type_Ahzr;
  private String jdField_a_of_type_JavaLangString = "";
  
  private ahzq()
  {
    a();
    SDCardMountMonitorReceiver.a().a(this);
  }
  
  public static ahzq a()
  {
    if (jdField_a_of_type_Ahzq == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ahzq == null) {
        jdField_a_of_type_Ahzq = new ahzq();
      }
      return jdField_a_of_type_Ahzq;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = bhbp.b();
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
    String str = bhbp.b();
    if ((this.jdField_a_of_type_Ahzr != null) && (!str.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Ahzr.a(1, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ahzr.a(0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahzq
 * JD-Core Version:    0.7.0.1
 */