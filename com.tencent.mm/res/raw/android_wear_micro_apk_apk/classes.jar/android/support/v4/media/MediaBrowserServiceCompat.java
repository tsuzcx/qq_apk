package android.support.v4.media;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.b.a;
import android.support.v4.b.m;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat
  extends Service
{
  static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
  final a<IBinder, ab> gT = new a();
  ab gU;
  final ag gV = new ag(this);
  MediaSessionCompat.Token gW;
  
  static List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
  {
    if (paramList == null) {
      paramBundle = null;
    }
    int m;
    do
    {
      return paramBundle;
      i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
      m = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      if (i != -1) {
        break;
      }
      paramBundle = paramList;
    } while (m == -1);
    int k = m * i;
    int j = k + m;
    if ((i < 0) || (m <= 0) || (k >= paramList.size())) {
      return Collections.EMPTY_LIST;
    }
    int i = j;
    if (j > paramList.size()) {
      i = paramList.size();
    }
    return paramList.subList(k, i);
  }
  
  static boolean a(String paramString, ab paramab, IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return paramab.hg.remove(paramString) != null;
    }
    List localList = (List)paramab.hg.get(paramString);
    boolean bool1;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      bool1 = false;
      while (localIterator.hasNext()) {
        if (paramIBinder == ((m)localIterator.next()).first)
        {
          localIterator.remove();
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (localList.size() == 0) {
        paramab.hg.remove(paramString);
      }
    }
    for (boolean bool2 = bool1;; bool2 = false) {
      return bool2;
    }
  }
  
  final void a(final String paramString, final ab paramab, IBinder paramIBinder, final Bundle paramBundle)
  {
    Object localObject = (List)paramab.hg.get(paramString);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = ((List)localObject).iterator();
      m localm;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localm = (m)localIterator.next();
      } while ((paramIBinder != localm.first) || (!z.a(paramBundle, (Bundle)localm.second)));
      do
      {
        return;
        ((List)localObject).add(new m(paramIBinder, paramBundle));
        paramab.hg.put(paramString, localObject);
        paramIBinder = new ac(paramString) {};
        this.gU = paramab;
        if (paramBundle != null) {
          paramIBinder.setFlags(1);
        }
        this.gU = null;
      } while (paramIBinder.isDone());
      throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + paramab.hc + " id=" + paramString);
    }
  }
  
  public abstract aa aK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat
 * JD-Core Version:    0.7.0.1
 */