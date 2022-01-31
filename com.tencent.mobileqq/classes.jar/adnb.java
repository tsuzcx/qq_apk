import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class adnb
  implements Runnable
{
  public adnb(VideoFilePresenter paramVideoFilePresenter, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -6101) && (this.jdField_a_of_type_Int != -7003) && (this.jdField_a_of_type_Int != 201)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_AndroidAppActivity.getString(2131428191));
    }
    label298:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_Int == -6101) || (this.jdField_a_of_type_Int == -7003))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_AndroidAppActivity.getString(2131428188);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label298;
        }
        localObject = DialogUtil.a(BaseActivity.sTopActivity, 230, "", (String)localObject, null, "我知道了", new adnc(this), null);
        if (((QQCustomDialog)localObject).isShowing()) {
          break;
        }
        ((QQCustomDialog)localObject).show();
        return;
        if (this.jdField_a_of_type_Int == 201)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.f()) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_AndroidAppActivity.getString(2131428192);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_AndroidAppActivity.getString(2131428191));
          }
        }
        else
        {
          String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterVideoFilePresenter.jdField_a_of_type_AndroidAppActivity.getString(2131428191);
          localObject = str;
          if (QLog.isColorLevel())
          {
            QLog.i("FileBrowserPresenter<FileAssistant>", 2, "can not handle video error. rc=[" + this.jdField_a_of_type_Int + "]  msg=[" + this.jdField_a_of_type_JavaLangString + "]");
            localObject = str;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adnb
 * JD-Core Version:    0.7.0.1
 */