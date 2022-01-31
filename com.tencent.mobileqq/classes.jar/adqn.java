import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import java.util.Iterator;
import java.util.List;

public class adqn
  implements Runnable
{
  public adqn(UniformDownloader paramUniformDownloader, Bundle paramBundle, int paramInt, String paramString) {}
  
  public void run()
  {
    if (UniformDownloader.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader, false, UniformDownloader.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader))) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.a();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        this.jdField_a_of_type_AndroidOsBundle.putBundle("_CB_USERDATA", UniformDownloader.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader));
      }
      Iterator localIterator = UniformDownloader.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader).iterator();
      while (localIterator.hasNext())
      {
        UniformDownloader.IUniformDownloaderListener localIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)localIterator.next();
        if (localIUniformDownloaderListener != null) {
          localIUniformDownloaderListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adqn
 * JD-Core Version:    0.7.0.1
 */