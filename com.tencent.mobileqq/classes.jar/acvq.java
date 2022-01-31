import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class acvq
  implements FMSettingInterface.MoveFileCallback
{
  public acvq(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    this.a.a(2005);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 12, null, paramInt, null);
    FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.e, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "sdcard full", null);
    FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.j, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.e, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "sdcard full", null);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a.jdField_d_of_type_JavaLangString.equalsIgnoreCase(paramString1)) {
      this.a.jdField_d_of_type_JavaLangString = paramString2;
    }
    while (!this.a.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramString1)) {
      return;
    }
    this.a.jdField_b_of_type_JavaLangString = paramString2;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvq
 * JD-Core Version:    0.7.0.1
 */