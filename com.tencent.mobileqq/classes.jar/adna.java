import android.os.Handler;
import android.os.PowerManager.WakeLock;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

public class adna
  implements Runnable
{
  public adna(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      if (FileManagerUtil.c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b())) {
        QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo video, but mediaplay null!");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d() != 1);
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo online video, but mediaplay null!");
      return;
      VideoFilePresenter.a(this.a).acquire();
      this.a.c();
      if (VideoFilePresenter.b(this.a))
      {
        VideoFilePresenter.a(this.a, false);
        VideoFilePresenter.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        HashMap localHashMap = new HashMap();
        localHashMap.put("shouq_bus_type", "bus_type_filevideo_online_play_again");
        this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
        this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.a.jdField_a_of_type_AndroidAppActivity, VideoFilePresenter.a(this.a), VideoFilePresenter.a(this.a), 0L, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
      }
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      VideoFilePresenter.a(this.a).postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1000L);
      VideoFilePresenter.d(this.a);
    } while ((!FileManagerUtil.c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b())) || (!QLog.isDevelopLevel()));
    QLog.d("#@#@", 1, "userPos[" + VideoFilePresenter.a(this.a) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adna
 * JD-Core Version:    0.7.0.1
 */