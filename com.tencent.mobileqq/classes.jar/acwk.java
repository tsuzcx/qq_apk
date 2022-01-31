import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import java.io.File;

public class acwk
  implements Runnable
{
  public acwk(FMSettings paramFMSettings, String paramString, File paramFile, int paramInt, FMSettingInterface.MoveFileCallback paramMoveFileCallback) {}
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, localFile, this.jdField_a_of_type_JavaIoFile, new acwl(this));
    localFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwk
 * JD-Core Version:    0.7.0.1
 */