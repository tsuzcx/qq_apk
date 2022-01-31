import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class adjq
  implements View.OnClickListener
{
  public adjq(FileManagerEntity paramFileManagerEntity, Activity paramActivity, IFileBrowser paramIFileBrowser) {}
  
  public void onClick(View paramView)
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      paramView = new FileManagerEntity();
      paramView.copyFrom(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      paramView.nSessionId = FileManagerUtil.a().longValue();
      paramView.status = 2;
      ((QQAppInterface)localObject1).a().d(paramView);
      Object localObject2 = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject2).b = "file_forward";
      ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Int = 71;
      ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Long = paramView.fileSize;
      ((FileManagerReporter.fileAssistantReportData)localObject2).c = FileUtil.a(paramView.fileName);
      ((FileManagerReporter.fileAssistantReportData)localObject2).d = FileManagerUtil.a(paramView.getCloudType(), paramView.peerType);
      FileManagerReporter.a(((QQAppInterface)localObject1).getCurrentAccountUin(), (FileManagerReporter.fileAssistantReportData)localObject2);
      int i = ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      localObject2 = ForwardFileOption.a(paramView);
      ((ForwardFileInfo)localObject2).b(i);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 0);
      ((Bundle)localObject1).putParcelable("fileinfo", (Parcelable)localObject2);
      ((Bundle)localObject1).putBoolean("not_forward", true);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtra("destroy_last_activity", true);
      ((Intent)localObject2).putExtra("forward_type", 0);
      ((Intent)localObject2).putExtra("forward_filepath", paramView.getFilePath());
      ((Intent)localObject2).putExtra("forward_text", "已选择" + FileManagerUtil.d(paramView.fileName) + "，大小" + FileUtil.a(paramView.fileSize) + "。");
      ((Intent)localObject2).putExtra("k_favorites", FileManagerUtil.c(paramView));
      if ((!FileUtil.b(paramView.getFilePath())) && ((paramView.getCloudType() == 6) || (paramView.getCloudType() == 7)) && (paramView.nFileType == 0)) {
        ((Intent)localObject2).putExtra("forward_type", 1);
      }
      if ((paramView.getCloudType() == 8) && (paramView.nFileType == 0)) {
        ((Intent)localObject2).putExtra("forward_type", 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ActionBarUtil getFileForwardClick forwardType=" + i + "newEntity.nFileType=" + paramView.nFileType);
      }
      if ((((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof TroopFileDetailBrowserActivity))) && (((FileBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).b())) {
        ((Intent)localObject2).putExtra("direct_send_if_dataline_forward", true);
      }
      if (!NetworkUtil.d(BaseApplication.getContext())) {
        FMToastUtil.a(2131428327);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(2);
        return;
        if (FileModel.a(paramView).a(false)) {
          FMDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131428241, 2131428237, new adjr(this, (Intent)localObject2));
        } else {
          ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 103);
        }
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adjq
 * JD-Core Version:    0.7.0.1
 */