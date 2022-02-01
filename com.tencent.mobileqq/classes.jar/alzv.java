import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import java.io.File;

public class alzv
  implements bmxs
{
  private static alzv jdField_a_of_type_Alzv;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private alzw jdField_a_of_type_Alzw;
  private String jdField_a_of_type_JavaLangString = "";
  
  private alzv()
  {
    a();
    SDCardMountMonitorReceiver.a().a(this);
  }
  
  public static alzv a()
  {
    if (jdField_a_of_type_Alzv == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Alzv == null) {
        jdField_a_of_type_Alzv = new alzv();
      }
      return jdField_a_of_type_Alzv;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = bmxh.b();
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
    String str = bmxh.b();
    if ((this.jdField_a_of_type_Alzw != null) && (!str.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Alzw.a(1, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Alzw.a(0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzv
 * JD-Core Version:    0.7.0.1
 */