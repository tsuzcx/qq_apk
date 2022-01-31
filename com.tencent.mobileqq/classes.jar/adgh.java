import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import java.io.File;

public class adgh
  implements Runnable
{
  public adgh(FMSettings paramFMSettings, String paramString, File paramFile, int paramInt, FMSettingInterface.MoveFileCallback paramMoveFileCallback) {}
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, localFile, this.jdField_a_of_type_JavaIoFile, new adgi(this));
    localFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adgh
 * JD-Core Version:    0.7.0.1
 */