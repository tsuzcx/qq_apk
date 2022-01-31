import android.os.Handler;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class adff
  implements Runnable
{
  adff(adfe paramadfe) {}
  
  public void run()
  {
    if ((this.a.a.b == true) && (this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(VideoFilePresenter.a(this.a.a));
    if (VideoFilePresenter.a(this.a.a) != null) {
      VideoFilePresenter.a(this.a.a).postDelayed(this.a.a.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adff
 * JD-Core Version:    0.7.0.1
 */