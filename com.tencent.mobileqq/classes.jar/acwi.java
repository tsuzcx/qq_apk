import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class acwi
  extends FileTransferObserver
{
  public acwi(FileVideoManager.VideoControl paramVideoControl) {}
  
  protected void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    super.b(paramBoolean, paramFileUploadInfo, paramStatictisInfo);
    paramStatictisInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBoolean) && ((paramFileUploadInfo.c == 2) || (paramFileUploadInfo.c == 0)) && (!this.a.a.bSend))
    {
      QLog.i("FileVideoManager<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramFileUploadInfo.jdField_a_of_type_Int + "],retMsg[" + paramFileUploadInfo.jdField_a_of_type_JavaLangString + "],retStat[" + paramFileUploadInfo.c + "]. need to send file receipt");
      paramStatictisInfo.a().a(this.a.a.peerUin, this.a.a.fileName, this.a.a.Uuid, this.a.a.fileSize, 0L);
      return;
    }
    QLog.i("FileVideoManager<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramFileUploadInfo.jdField_a_of_type_Int + "],retMsg[" + paramFileUploadInfo.jdField_a_of_type_JavaLangString + "],retStat[" + paramFileUploadInfo.c + "]. don't need to send file receipt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwi
 * JD-Core Version:    0.7.0.1
 */