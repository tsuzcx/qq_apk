package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;
import java.util.List;

final class j
  implements s
{
  private final WeakReference<h> hZ;
  
  j(h paramh)
  {
    this.hZ = new WeakReference(paramh);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((h)this.hZ.get() != null) {
      new q(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public final void aZ()
  {
    h localh = (h)this.hZ.get();
    if ((localh != null) && (localh.hX)) {
      int i = Build.VERSION.SDK_INT;
    }
  }
  
  public final void ba()
  {
    this.hZ.get();
  }
  
  public final void bb()
  {
    this.hZ.get();
  }
  
  public final void e(Object paramObject)
  {
    h localh = (h)this.hZ.get();
    if ((localh != null) && (!localh.hX)) {
      PlaybackStateCompat.h(paramObject);
    }
  }
  
  public final void f(Object paramObject)
  {
    if ((h)this.hZ.get() != null) {
      MediaMetadataCompat.d(paramObject);
    }
  }
  
  public final void onQueueChanged(List<?> paramList)
  {
    if ((h)this.hZ.get() != null) {
      MediaSessionCompat.QueueItem.f(paramList);
    }
  }
  
  public final void onSessionDestroyed()
  {
    this.hZ.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.j
 * JD-Core Version:    0.7.0.1
 */