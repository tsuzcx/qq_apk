package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

public abstract interface a
  extends IInterface
{
  public abstract void a(MediaMetadataCompat paramMediaMetadataCompat);
  
  public abstract void a(ParcelableVolumeInfo paramParcelableVolumeInfo);
  
  public abstract void a(PlaybackStateCompat paramPlaybackStateCompat);
  
  public abstract void a(String paramString, Bundle paramBundle);
  
  public abstract void bf();
  
  public abstract void h(boolean paramBoolean);
  
  public abstract void i(boolean paramBoolean);
  
  public abstract void onExtrasChanged(Bundle paramBundle);
  
  public abstract void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList);
  
  public abstract void onQueueTitleChanged(CharSequence paramCharSequence);
  
  public abstract void onSessionDestroyed();
  
  public abstract void v(int paramInt);
  
  public abstract void w(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.a
 * JD-Core Version:    0.7.0.1
 */