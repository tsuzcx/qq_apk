import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

public class adcb
  extends BroadcastReceiver
{
  public adcb(FileViewMusicService paramFileViewMusicService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.media.AUDIO_BECOMING_NOISY")) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adcb
 * JD-Core Version:    0.7.0.1
 */