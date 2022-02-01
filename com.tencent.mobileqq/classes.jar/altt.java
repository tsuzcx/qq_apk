import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.cache.SDCardMountMonitorReceiver.SDCardMountStateListener;
import java.io.File;

public class altt
  implements SDCardMountMonitorReceiver.SDCardMountStateListener
{
  private static altt jdField_a_of_type_Altt;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private altu jdField_a_of_type_Altu;
  private String jdField_a_of_type_JavaLangString = "";
  
  private altt()
  {
    a();
    SDCardMountMonitorReceiver.getInstance().addListener(this);
  }
  
  public static altt a()
  {
    if (jdField_a_of_type_Altt == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Altt == null) {
        jdField_a_of_type_Altt = new altt();
      }
      return jdField_a_of_type_Altt;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = CacheManager.getVideoFileCacheDir();
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
  
  public void onSDCardMountStateChange(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StorageManager", 2, "sdcard mount receiver, isMount=" + paramBoolean);
    }
    String str = CacheManager.getVideoFileCacheDir();
    if ((this.jdField_a_of_type_Altu != null) && (!str.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Altu.a(1, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Altu.a(0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altt
 * JD-Core Version:    0.7.0.1
 */