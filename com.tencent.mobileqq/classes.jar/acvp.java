import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class acvp
  implements Runnable
{
  public acvp(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "running OfflineFileHitReq:" + MessageCache.a());
    }
    OfflineFileUploadPara localOfflineFileUploadPara = new OfflineFileUploadPara();
    localOfflineFileUploadPara.jdField_a_of_type_JavaLangString = this.a.e;
    localOfflineFileUploadPara.jdField_a_of_type_Long = this.a.d;
    this.a.jdField_a_of_type_ArrayOfByte = FileManagerUtil.c(this.a.jdField_b_of_type_JavaLangString);
    this.a.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString);
    this.a.c = FileManagerUtil.b(this.a.jdField_b_of_type_JavaLangString);
    if ((this.a.jdField_a_of_type_ArrayOfByte == null) || (this.a.jdField_b_of_type_ArrayOfByte == null) || (this.a.c == null))
    {
      this.a.a(null, 0);
      return;
    }
    localOfflineFileUploadPara.c = this.a.jdField_a_of_type_ArrayOfByte;
    localOfflineFileUploadPara.d = this.a.jdField_b_of_type_ArrayOfByte;
    localOfflineFileUploadPara.e = this.a.c;
    try
    {
      localOfflineFileUploadPara.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      localOfflineFileUploadPara.jdField_a_of_type_ArrayOfByte = this.a.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localOfflineFileUploadPara, FileManagerRSWorker.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvp
 * JD-Core Version:    0.7.0.1
 */