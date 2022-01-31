import android.os.Bundle;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.qphone.base.util.QLog;

public class acux
  implements Runnable
{
  public acux(FileManagerDataCenter paramFileManagerDataCenter, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "INTENT_ACTION_RENAME_FILENAME extra is null!!!");
      }
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("peerUin");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("peerType");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("sourceStr");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("filePath");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("dataLength");
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("fileSourceId");
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle.getBundle("otherData");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter.a(str1, i, str3, l, j, str2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acux
 * JD-Core Version:    0.7.0.1
 */