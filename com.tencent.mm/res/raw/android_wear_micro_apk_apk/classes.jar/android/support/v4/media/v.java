package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import java.util.List;

class v<T extends u>
  extends MediaBrowser.SubscriptionCallback
{
  protected final T iQ;
  
  public v(T paramT)
  {
    this.iQ = paramT;
  }
  
  public void onChildrenLoaded(String paramString, List<MediaBrowser.MediaItem> paramList)
  {
    this.iQ.d(paramList);
  }
  
  public void onError(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.v
 * JD-Core Version:    0.7.0.1
 */