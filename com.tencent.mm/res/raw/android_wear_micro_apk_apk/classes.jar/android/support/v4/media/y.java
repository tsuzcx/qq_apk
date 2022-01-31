package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import java.util.List;

final class y<T extends x>
  extends v<T>
{
  public y(T paramT)
  {
    super(paramT);
  }
  
  public final void onChildrenLoaded(String paramString, List<MediaBrowser.MediaItem> paramList, Bundle paramBundle)
  {
    ((x)this.gS).e(paramList);
  }
  
  public final void onError(String paramString, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.y
 * JD-Core Version:    0.7.0.1
 */