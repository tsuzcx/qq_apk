import com.tencent.mobileqq.hotpic.DiskStorageManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class adxy
  implements Runnable
{
  private final File jdField_a_of_type_JavaIoFile;
  
  public adxy(DiskStorageManager paramDiskStorageManager, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public void run()
  {
    try
    {
      DiskStorageManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicDiskStorageManager, this.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      QLog.d("DiskStorageManager", 2, "IO exception run error in background", localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxy
 * JD-Core Version:    0.7.0.1
 */