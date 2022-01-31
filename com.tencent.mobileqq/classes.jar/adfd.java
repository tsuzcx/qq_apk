import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileUploader;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class adfd
  implements Runnable
{
  adfd(adfc paramadfc, FileTransferHandler.FileUploadInfo paramFileUploadInfo, List paramList) {}
  
  public void run()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId) + "],retCode[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_Int) + "]");
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_JavaLangString.length() > 0))
    {
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "id[" + String.valueOf(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId) + "] will show taost, retCode[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_Int) + "], retMsg:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_JavaLangString);
      OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).a().a(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).uniseq, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).peerUin, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).peerType, 4, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).Uuid = new String(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_ArrayOfByte);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_c_of_type_Long > 104857600L)) {
        break label374;
      }
      OfflineSendWorker.b(this.jdField_a_of_type_Adfc.a);
    }
    label374:
    do
    {
      return;
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "=_= ^! nSessionID[" + String.valueOf(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId) + "]!!!!!Server Return the UUID is null!!!!!");
      break;
      OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).status = 0;
      OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).a().c(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a));
      OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId) + "]");
      }
      if (FMConfig.b)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.add(0, "14.17.29.27:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_Short);
      }
      String str = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.b);
      if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.d)
      {
        str = "/?ver=2&ukey=" + str + "&filekey=" + OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a) + "&filesize=" + OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).fileSize;
        OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).strServerPath = ("http://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + str);
        OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a, FileUploader.a(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a), OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).peerType, 0, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).getFilePath(), this.jdField_a_of_type_JavaUtilList, str));
      }
      for (;;)
      {
        if (OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a) == null) {
          break label1231;
        }
        OfflineSendWorker.b(this.jdField_a_of_type_Adfc.a, false);
        OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).a(this.jdField_a_of_type_Adfc.a);
        if (OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).a(0L)) {
          break;
        }
        OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a, 1005);
        OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).a().a(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).uniseq, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).peerUin, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).peerType, 15, null, 0, "");
        OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).fileSize, 9045, "sendFile error");
        OfflineSendWorker.b(this.jdField_a_of_type_Adfc.a, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).fileSize, 9045, "sendFile error");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId + "],sendFile return false");
        return;
        if (2 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.d)
        {
          OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).strServerPath = ("http://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + "/ftn_handler");
          OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).bombData = str.getBytes();
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_c_of_type_ArrayOfByte != null)
          {
            OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).strFileSHA = FileHttpUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_c_of_type_ArrayOfByte);
            OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a, true);
          }
          OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a, FileUploader.a(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a), OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).peerType, 0, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).getFilePath(), str, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).strFileSHA, this.jdField_a_of_type_JavaUtilList, "/ftn_handler"));
        }
        else
        {
          QLog.w("OfflineSendWorker<FileAssistant>", 1, "onUpdateSendOfflineFile httpsvrApiVer[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.d + "] not recognized");
        }
      }
      OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a, 1005);
      OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).a().a(OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).uniseq, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).peerUin, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).peerType, 15, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_JavaLangString);
      OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).fileSize, 9045, "upload param error");
      OfflineSendWorker.b(this.jdField_a_of_type_Adfc.a, OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).fileSize, 9045, "upload param error");
    } while (!QLog.isColorLevel());
    label1231:
    QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + OfflineSendWorker.a(this.jdField_a_of_type_Adfc.a).nSessionId + "],retCode[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler$FileUploadInfo.jdField_a_of_type_Int + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adfd
 * JD-Core Version:    0.7.0.1
 */