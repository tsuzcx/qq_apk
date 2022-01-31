import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class acuz
  implements Runnable
{
  public acuz(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      VideoFilePresenter.a(this.a, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration());
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(VideoFilePresenter.a(this.a));
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(false);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acuz
 * JD-Core Version:    0.7.0.1
 */