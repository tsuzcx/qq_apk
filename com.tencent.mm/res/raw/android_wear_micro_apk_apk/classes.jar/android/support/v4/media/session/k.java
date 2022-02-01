package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;
import java.util.List;

class k
  extends b
{
  private final WeakReference<h> jY;
  
  k(h paramh)
  {
    this.jY = new WeakReference(paramh);
  }
  
  public void a(MediaMetadataCompat paramMediaMetadataCompat)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(3, paramMediaMetadataCompat, null);
    }
  }
  
  public void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      if (paramParcelableVolumeInfo == null) {
        break label55;
      }
    }
    label55:
    for (paramParcelableVolumeInfo = new q(paramParcelableVolumeInfo.kp, paramParcelableVolumeInfo.kq, paramParcelableVolumeInfo.kr, paramParcelableVolumeInfo.ks, paramParcelableVolumeInfo.kt);; paramParcelableVolumeInfo = null)
    {
      localh.a(4, paramParcelableVolumeInfo, null);
      return;
    }
  }
  
  public final void a(PlaybackStateCompat paramPlaybackStateCompat)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(2, paramPlaybackStateCompat, null);
    }
  }
  
  public final void a(String paramString, Bundle paramBundle)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(1, paramString, paramBundle);
    }
  }
  
  public final void bf()
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(13, null, null);
    }
  }
  
  public final void h(boolean paramBoolean) {}
  
  public final void i(boolean paramBoolean)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(11, Boolean.valueOf(paramBoolean), null);
    }
  }
  
  public void onExtrasChanged(Bundle paramBundle)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(7, paramBundle, null);
    }
  }
  
  public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(5, paramList, null);
    }
  }
  
  public void onQueueTitleChanged(CharSequence paramCharSequence)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(6, paramCharSequence, null);
    }
  }
  
  public void onSessionDestroyed()
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(8, null, null);
    }
  }
  
  public final void v(int paramInt)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(9, Integer.valueOf(paramInt), null);
    }
  }
  
  public final void w(int paramInt)
  {
    h localh = (h)this.jY.get();
    if (localh != null) {
      localh.a(12, Integer.valueOf(paramInt), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.k
 * JD-Core Version:    0.7.0.1
 */