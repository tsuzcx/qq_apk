package android.support.v4.media;

import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

class p
  implements u
{
  p(o paramo) {}
  
  public final void d(List<?> paramList)
  {
    if (this.iO.iN == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = (n)this.iO.iN.get())
    {
      MediaBrowserCompat.MediaItem.c(paramList);
      return;
    }
    paramList = MediaBrowserCompat.MediaItem.c(paramList);
    List localList = ((n)localObject1).aZ();
    localObject1 = ((n)localObject1).aY();
    int i = 0;
    label63:
    int j;
    int m;
    int k;
    if (i < localList.size())
    {
      Object localObject2 = (Bundle)((List)localObject1).get(i);
      if ((localObject2 != null) && (paramList != null))
      {
        j = ((Bundle)localObject2).getInt("android.media.browse.extra.PAGE", -1);
        int n = ((Bundle)localObject2).getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if ((j != -1) || (n != -1))
        {
          m = n * j;
          k = m + n;
          if ((j >= 0) && (n > 0) && (m < paramList.size())) {
            break label171;
          }
          localObject2 = Collections.EMPTY_LIST;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label63;
      break;
      label171:
      j = k;
      if (k > paramList.size()) {
        j = paramList.size();
      }
      paramList.subList(m, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.p
 * JD-Core Version:    0.7.0.1
 */