import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;

public class aees
  implements AudioManager.OnAudioFocusChangeListener
{
  public aees(SmallVideoFragment paramSmallVideoFragment) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (SmallVideoFragment.a(this.a))) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aees
 * JD-Core Version:    0.7.0.1
 */