import android.text.TextUtils;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.data.DeviceImageInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.DeviceFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class actg
  implements IThumbController
{
  public actg(DeviceFileModel paramDeviceFileModel) {}
  
  public void a(FileBrowserModelBase.ImageFileInfo paramImageFileInfo)
  {
    paramImageFileInfo = ((DeviceImageInfo)paramImageFileInfo).a();
    if (paramImageFileInfo == null) {}
    label12:
    do
    {
      do
      {
        do
        {
          break label12;
          do
          {
            return;
          } while ((TextUtils.isEmpty(paramImageFileInfo.a())) || (FileManagerUtil.a(paramImageFileInfo.a()) != 0) || (!TextUtils.isEmpty(paramImageFileInfo.g())));
          paramImageFileInfo = paramImageFileInfo.a();
          if (paramImageFileInfo != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(paramImageFileInfo.strThumbPath)) {
          break;
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener == null);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(String.valueOf(paramImageFileInfo.nSessionId), paramImageFileInfo.strThumbPath);
      return;
      paramImageFileInfo = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramImageFileInfo.peerUin, paramImageFileInfo.peerType, paramImageFileInfo.msgSeq);
    } while (paramImageFileInfo == null);
    paramImageFileInfo = (MessageForDeviceSingleStruct)paramImageFileInfo;
    DevSingleStructMsgProcessor localDevSingleStructMsgProcessor = ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a();
    DeviceFileModel.a(this.a, localDevSingleStructMsgProcessor.a(paramImageFileInfo, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actg
 * JD-Core Version:    0.7.0.1
 */