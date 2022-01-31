package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.view.KeyEvent;
import java.util.List;

public abstract interface d
  extends IInterface
{
  public abstract void a(int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(MediaDescriptionCompat paramMediaDescriptionCompat);
  
  public abstract void a(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt);
  
  public abstract void a(RatingCompat paramRatingCompat);
  
  public abstract void a(RatingCompat paramRatingCompat, Bundle paramBundle);
  
  public abstract void a(a parama);
  
  public abstract void a(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper);
  
  public abstract boolean a(KeyEvent paramKeyEvent);
  
  public abstract boolean aP();
  
  public abstract PendingIntent aQ();
  
  public abstract ParcelableVolumeInfo aR();
  
  public abstract MediaMetadataCompat aS();
  
  public abstract PlaybackStateCompat aT();
  
  public abstract boolean aU();
  
  public abstract boolean aV();
  
  public abstract int aW();
  
  public abstract void aX();
  
  public abstract void aY();
  
  public abstract void b(int paramInt1, int paramInt2, String paramString);
  
  public abstract void b(MediaDescriptionCompat paramMediaDescriptionCompat);
  
  public abstract void b(a parama);
  
  public abstract void fastForward();
  
  public abstract void g(boolean paramBoolean);
  
  public abstract Bundle getExtras();
  
  public abstract long getFlags();
  
  public abstract String getPackageName();
  
  public abstract List<MediaSessionCompat.QueueItem> getQueue();
  
  public abstract CharSequence getQueueTitle();
  
  public abstract int getRatingType();
  
  public abstract int getRepeatMode();
  
  public abstract String getTag();
  
  public abstract void h(boolean paramBoolean);
  
  public abstract void n(int paramInt);
  
  public abstract void o(int paramInt);
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void playFromMediaId(String paramString, Bundle paramBundle);
  
  public abstract void playFromSearch(String paramString, Bundle paramBundle);
  
  public abstract void playFromUri(Uri paramUri, Bundle paramBundle);
  
  public abstract void prepare();
  
  public abstract void prepareFromMediaId(String paramString, Bundle paramBundle);
  
  public abstract void prepareFromSearch(String paramString, Bundle paramBundle);
  
  public abstract void prepareFromUri(Uri paramUri, Bundle paramBundle);
  
  public abstract void rewind();
  
  public abstract void seekTo(long paramLong);
  
  public abstract void sendCustomAction(String paramString, Bundle paramBundle);
  
  public abstract void setRepeatMode(int paramInt);
  
  public abstract void skipToQueueItem(long paramLong);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.d
 * JD-Core Version:    0.7.0.1
 */