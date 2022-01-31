import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;

public class acty
  implements Runnable
{
  public acty(TroopFileModel paramTroopFileModel, TroopFileStatusInfo paramTroopFileStatusInfo) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileModel<FileAssistant>", 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_c_of_type_Int) }));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if ((((FileManagerEntity)localObject).isFromProcessingForward2c2cOrDiscItem()) || (((FileManagerEntity)localObject).isFromProcessingForward2DatalineItem())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_c_of_type_JavaLangString);
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      TroopFileModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) && (TroopFileModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel) != 8)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.a((float)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_c_of_type_Long * 1.0F / ((float)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Long * 1.0F));
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.e();
          continue;
          long l = ((FileManagerEntity)localObject).lastTime;
          String str = ((FileManagerEntity)localObject).selfUin;
          boolean bool = ((FileManagerEntity)localObject).bSend;
          ((FileManagerEntity)localObject).copyFrom(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo));
          ((FileManagerEntity)localObject).lastTime = l;
          ((FileManagerEntity)localObject).selfUin = str;
          ((FileManagerEntity)localObject).bSend = bool;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.d() == 3)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.e();
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.d();
                }
                if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.a((float)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_c_of_type_Long * 1.0F / ((float)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Long * 1.0F));
                  continue;
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("TroopFile_DeleteFile", true);
                  ((Intent)localObject).putExtra("TroopFile_FileName", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g);
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject);
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.jdField_a_of_type_AndroidAppActivity.finish();
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acty
 * JD-Core Version:    0.7.0.1
 */