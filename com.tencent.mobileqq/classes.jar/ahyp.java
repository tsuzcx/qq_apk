import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ahyp
  implements Runnable
{
  public ahyp(PtvTemplateManager paramPtvTemplateManager, String paramString) {}
  
  public void run()
  {
    FileUtils.a(PtvTemplateManager.b.getPath() + File.separator, "doodle_template_new.cfg", this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahyp
 * JD-Core Version:    0.7.0.1
 */