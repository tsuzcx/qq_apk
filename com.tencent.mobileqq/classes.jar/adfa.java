import android.app.Activity;
import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;

public class adfa
  implements View.OnClickListener
{
  public adfa(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    int i;
    int j;
    do
    {
      do
      {
        return;
        this.a.jdField_a_of_type_AndroidAppActivity.finish();
        this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 2131034423);
        return;
      } while (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
      if (VideoFilePresenter.a(this.a))
      {
        VideoFilePresenter.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        FileManagerReporter.a("0X8004BE5");
        this.a.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(VideoFilePresenter.a(this.a));
        VideoFilePresenter.a(this.a);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(VideoFilePresenter.a(this.a));
        return;
        VideoFilePresenter.b(this.a);
      }
      VideoFilePresenter.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b());
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.e(true);
      return;
      this.a.jdField_a_of_type_AndroidAppActivity.finish();
      this.a.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 2131034423);
      return;
      i = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
      j = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
    } while ((i != 6) || (j != 1) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() == null));
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adfa
 * JD-Core Version:    0.7.0.1
 */