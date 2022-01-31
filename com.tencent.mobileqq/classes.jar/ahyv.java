import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class ahyv
  implements Runnable
{
  public ahyv(String paramString1, String paramString2) {}
  
  public void run()
  {
    FileUtils.a(PtvTemplateManager.a.getPath() + File.separator, this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahyv
 * JD-Core Version:    0.7.0.1
 */