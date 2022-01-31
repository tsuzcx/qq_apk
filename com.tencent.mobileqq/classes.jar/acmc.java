import android.content.Context;
import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerInitCallback;
import java.util.HashMap;

public final class acmc
  implements Runnable
{
  public acmc(Context paramContext, FileVideoManager.FileVideoManagerInitCallback paramFileVideoManagerInitCallback) {}
  
  public void run()
  {
    if (FileVideoManager.a == null) {
      FileVideoManager.a = new FileVideoManager(null);
    }
    if (FileVideoManager.a(FileVideoManager.a) == null) {
      FileVideoManager.a(FileVideoManager.a, new HashMap());
    }
    FileVideoManager.a(FileVideoManager.a, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerInitCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmc
 * JD-Core Version:    0.7.0.1
 */