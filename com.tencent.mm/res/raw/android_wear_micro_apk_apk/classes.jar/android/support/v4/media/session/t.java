package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

final class t<T extends s>
  extends MediaController.Callback
{
  protected final T kk;
  
  public t(T paramT)
  {
    this.kk = paramT;
  }
  
  public final void onAudioInfoChanged(MediaController.PlaybackInfo paramPlaybackInfo)
  {
    s locals = this.kk;
    int j = paramPlaybackInfo.getPlaybackType();
    AudioAttributes localAudioAttributes = ((MediaController.PlaybackInfo)paramPlaybackInfo).getAudioAttributes();
    int i;
    if ((localAudioAttributes.getFlags() & 0x1) == 1) {
      i = 7;
    }
    for (;;)
    {
      locals.a(j, i, paramPlaybackInfo.getVolumeControl(), paramPlaybackInfo.getMaxVolume(), paramPlaybackInfo.getCurrentVolume());
      return;
      if ((localAudioAttributes.getFlags() & 0x4) == 4) {
        i = 6;
      } else {
        switch (localAudioAttributes.getUsage())
        {
        default: 
          i = 3;
          break;
        case 1: 
        case 11: 
        case 12: 
        case 14: 
          i = 3;
          break;
        case 13: 
          i = 1;
          break;
        case 2: 
          i = 0;
          break;
        case 3: 
          i = 8;
          break;
        case 4: 
          i = 4;
          break;
        case 6: 
          i = 2;
          break;
        case 5: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
          i = 5;
        }
      }
    }
  }
  
  public final void onExtrasChanged(Bundle paramBundle)
  {
    this.kk.bs();
  }
  
  public final void onMetadataChanged(MediaMetadata paramMediaMetadata)
  {
    this.kk.l(paramMediaMetadata);
  }
  
  public final void onPlaybackStateChanged(PlaybackState paramPlaybackState)
  {
    this.kk.k(paramPlaybackState);
  }
  
  public final void onQueueChanged(List<MediaSession.QueueItem> paramList)
  {
    this.kk.onQueueChanged(paramList);
  }
  
  public final void onQueueTitleChanged(CharSequence paramCharSequence)
  {
    this.kk.br();
  }
  
  public final void onSessionDestroyed()
  {
    this.kk.onSessionDestroyed();
  }
  
  public final void onSessionEvent(String paramString, Bundle paramBundle)
  {
    this.kk.bq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.t
 * JD-Core Version:    0.7.0.1
 */