import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;

public class aivz
  implements MediaPlayer.OnPreparedListener
{
  public aivz(RedPacketKSongFragment paramRedPacketKSongFragment, boolean paramBoolean) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "playSong onPrepared");
    }
    RedPacketKSongFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment, true);
    bdfi.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment.getActivity(), true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    paramMediaPlayer.start();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivz
 * JD-Core Version:    0.7.0.1
 */