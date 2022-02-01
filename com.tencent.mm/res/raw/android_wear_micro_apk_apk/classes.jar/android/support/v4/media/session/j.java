package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;
import java.util.List;

final class j
  implements s
{
  private final WeakReference<h> jY;
  
  j(h paramh)
  {
    this.jY = new WeakReference(paramh);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((h)this.jY.get() != null) {
      new q(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public final void bq()
  {
    h localh = (h)this.jY.get();
    if ((localh != null) && (localh.jW)) {
      int i = Build.VERSION.SDK_INT;
    }
  }
  
  public final void br()
  {
    this.jY.get();
  }
  
  public final void bs()
  {
    this.jY.get();
  }
  
  public final void k(Object paramObject)
  {
    h localh = (h)this.jY.get();
    if ((localh != null) && (!localh.jW)) {
      PlaybackStateCompat.o(paramObject);
    }
  }
  
  public final void l(Object paramObject)
  {
    if ((h)this.jY.get() != null) {
      MediaMetadataCompat.j(paramObject);
    }
  }
  
  public final void onQueueChanged(List<?> paramList)
  {
    if ((h)this.jY.get() != null) {
      MediaSessionCompat.QueueItem.f(paramList);
    }
  }
  
  public final void onSessionDestroyed()
  {
    this.jY.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.j
 * JD-Core Version:    0.7.0.1
 */