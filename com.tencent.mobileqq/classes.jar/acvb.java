import android.os.Handler;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class acvb
  implements Runnable
{
  public acvb(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(VideoFilePresenter.a(this.a));
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {}
    while ((VideoFilePresenter.b(this.a)) || (!this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      return;
    }
    int i = (int)this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    int j = (int)this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(i);
    float f = i / j;
    if (f <= 0.001D)
    {
      VideoFilePresenter.a(this.a).postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 100L);
      return;
    }
    if (i >= VideoFilePresenter.a(this.a)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b((int)(f * 10000.0F));
    }
    VideoFilePresenter.a(this.a).postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvb
 * JD-Core Version:    0.7.0.1
 */