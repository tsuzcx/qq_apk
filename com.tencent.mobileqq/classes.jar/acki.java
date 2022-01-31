import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;

public class acki
  implements Runnable
{
  public acki(FileTransferHandler paramFileTransferHandler, FileManagerEntity paramFileManagerEntity, hummer_resv_21.FileImgInfo paramFileImgInfo, SubMsgType0x4.MsgBody paramMsgBody, FileTransferObserver paramFileTransferObserver, Handler paramHandler, String paramString) {}
  
  public void run()
  {
    FileManagerUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight > 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth > 0))
    {
      this.jdField_a_of_type_TencentImMsgResv21Hummer_resv_21$FileImgInfo.uint32_file_height.set(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight);
      this.jdField_a_of_type_TencentImMsgResv21Hummer_resv_21$FileImgInfo.uint32_file_width.set(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth);
      this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0x4SubMsgType0x4$MsgBody.file_image_info.set(this.jdField_a_of_type_TencentImMsgResv21Hummer_resv_21$FileImgInfo);
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]Send CCMsg, setThumbSize height[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + "], width[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + "]");
    }
    for (;;)
    {
      byte[] arrayOfByte = this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0x4SubMsgType0x4$MsgBody.toByteArray();
      FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
      localFMTransC2CMsgInfo.busiType = 1028;
      localFMTransC2CMsgInfo.uuid = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      localFMTransC2CMsgInfo.uniseq = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq;
      localFMTransC2CMsgInfo.fileTransferObserver = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver;
      localFMTransC2CMsgInfo.msgSeq = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq;
      localFMTransC2CMsgInfo.msgUid = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid;
      localFMTransC2CMsgInfo.sessionId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      localFMTransC2CMsgInfo.entity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess = true;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      QLog.i("FileTransferHandler<FileAssistant>", 2, "=_= ^> [Send CC]send offline CC [" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], 0x211, 0x4");
      this.jdField_a_of_type_AndroidOsHandler.post(new ackk(this, arrayOfByte, localFMTransC2CMsgInfo));
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.hasNoThumb()) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2))) {
        new Handler(Looper.getMainLooper()).postDelayed(new ackj(this), 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acki
 * JD-Core Version:    0.7.0.1
 */