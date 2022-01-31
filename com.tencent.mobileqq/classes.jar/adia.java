import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransEntity;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransProxy;

public class adia
  implements Runnable
{
  public adia(UniformDownloadBPTransProxy paramUniformDownloadBPTransProxy, UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity) {}
  
  public void run()
  {
    try
    {
      UniformDownloadBPTransProxy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransEntity, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adia
 * JD-Core Version:    0.7.0.1
 */