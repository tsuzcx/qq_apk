import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

class adnt
  implements Runnable
{
  adnt(adnr paramadnr, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Adnr.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    this.jdField_a_of_type_Adnr.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    VideoFilePresenter.a(this.jdField_a_of_type_Adnr.a, this.jdField_a_of_type_JavaLangString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_filevideo_online_play");
    this.jdField_a_of_type_Adnr.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    this.jdField_a_of_type_Adnr.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_Adnr.a.jdField_a_of_type_AndroidAppActivity, VideoFilePresenter.a(this.jdField_a_of_type_Adnr.a), 0L, 0L, this.jdField_a_of_type_Adnr.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adnt
 * JD-Core Version:    0.7.0.1
 */