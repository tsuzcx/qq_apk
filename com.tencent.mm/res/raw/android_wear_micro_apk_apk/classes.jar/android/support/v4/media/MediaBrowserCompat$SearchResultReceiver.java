package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserCompat$SearchResultReceiver
  extends ResultReceiver
{
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
    }
    if ((paramInt != 0) || (paramBundle == null) || (!paramBundle.containsKey("search_results"))) {}
    for (;;)
    {
      return;
      paramBundle = paramBundle.getParcelableArray("search_results");
      if (paramBundle != null)
      {
        ArrayList localArrayList = new ArrayList();
        int i = paramBundle.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localArrayList.add((MediaBrowserCompat.MediaItem)paramBundle[paramInt]);
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.SearchResultReceiver
 * JD-Core Version:    0.7.0.1
 */