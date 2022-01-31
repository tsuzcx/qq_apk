import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener;

public class acsd
  implements AudioManager.OnAudioFocusChangeListener
{
  public acsd(ExtendFriendVoicePlayer paramExtendFriendVoicePlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((ExtendFriendVoicePlayer.a(this.a) != null) && (paramInt == -1) && (ExtendFriendVoicePlayer.a(this.a) != null)) {
      ExtendFriendVoicePlayer.a(this.a).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsd
 * JD-Core Version:    0.7.0.1
 */