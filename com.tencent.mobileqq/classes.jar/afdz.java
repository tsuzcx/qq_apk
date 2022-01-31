import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class afdz
  implements Runnable
{
  afdz(afdx paramafdx) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.c)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.c, 0L, 0L, null, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.jdField_a_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdz
 * JD-Core Version:    0.7.0.1
 */