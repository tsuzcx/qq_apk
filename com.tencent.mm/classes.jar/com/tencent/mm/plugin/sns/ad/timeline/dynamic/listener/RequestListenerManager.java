package com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener;

import android.app.Activity;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RequestListenerManager
  implements k
{
  private static final Map<Integer, RequestListenerManager> JHM;
  public b JHN;
  
  static
  {
    AppMethodBeat.i(250323);
    JHM = new ArrayMap();
    AppMethodBeat.o(250323);
  }
  
  private RequestListenerManager()
  {
    AppMethodBeat.i(250310);
    this.JHN = new b();
    AppMethodBeat.o(250310);
  }
  
  public static RequestListenerManager aL(Activity paramActivity)
  {
    AppMethodBeat.i(250302);
    if ((paramActivity instanceof l))
    {
      RequestListenerManager localRequestListenerManager2 = (RequestListenerManager)JHM.get(Integer.valueOf(paramActivity.hashCode()));
      RequestListenerManager localRequestListenerManager1 = localRequestListenerManager2;
      if (localRequestListenerManager2 == null)
      {
        localRequestListenerManager2 = aM(paramActivity);
        localRequestListenerManager1 = localRequestListenerManager2;
        if (localRequestListenerManager2 != null)
        {
          Log.i("RequestListenerManager", "new one RequestListenerManager instance!!!");
          JHM.put(Integer.valueOf(paramActivity.hashCode()), localRequestListenerManager2);
          localRequestListenerManager1 = localRequestListenerManager2;
        }
      }
      AppMethodBeat.o(250302);
      return localRequestListenerManager1;
    }
    AppMethodBeat.o(250302);
    return null;
  }
  
  private static RequestListenerManager aM(Activity paramActivity)
  {
    AppMethodBeat.i(250304);
    try
    {
      if ((paramActivity instanceof l))
      {
        paramActivity = f((l)paramActivity);
        AppMethodBeat.o(250304);
        return paramActivity;
      }
    }
    catch (Throwable paramActivity)
    {
      AppMethodBeat.o(250304);
    }
    return null;
  }
  
  private static RequestListenerManager f(l paraml)
  {
    AppMethodBeat.i(250307);
    if (paraml == null) {}
    try
    {
      Log.w("RequestListenerManager", "the input life cycle owner is null!");
      AppMethodBeat.o(250307);
      return null;
    }
    catch (Throwable paraml)
    {
      RequestListenerManager localRequestListenerManager;
      boolean bool;
      Log.e("RequestListenerManager", "new one instance of RequestListenerManager failed!");
      AppMethodBeat.o(250307);
    }
    localRequestListenerManager = new RequestListenerManager();
    bool = localRequestListenerManager.g(paraml);
    if (!bool)
    {
      AppMethodBeat.o(250307);
      return null;
    }
    AppMethodBeat.o(250307);
    return localRequestListenerManager;
    return null;
  }
  
  private boolean g(l paraml)
  {
    AppMethodBeat.i(250313);
    if (paraml != null) {}
    try
    {
      paraml.getLifecycle().a(this);
      AppMethodBeat.o(250313);
      return true;
    }
    catch (Throwable paraml)
    {
      for (;;)
      {
        Log.e("RequestListenerManager", "RequestListenerManager attachToOwner failed!");
      }
    }
    Log.w("RequestListenerManager", "the life cycle owner is null!");
    AppMethodBeat.o(250313);
    return false;
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(250316);
    b localb = this.JHN;
    Map.Entry localEntry;
    if (localb != null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(250316);
        return;
      }
      localObject = (WeakReference)localb.lyH.get(paramString);
      if ((localObject == null) || (((WeakReference)localObject).get() != parama))
      {
        localObject = localb.lyH.entrySet().iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localEntry = (Map.Entry)((Iterator)localObject).next();
        } while ((localEntry == null) || (localEntry.getValue() != parama));
      }
    }
    for (Object localObject = (String)localEntry.getKey();; localObject = null)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(paramString))) {
        localb.lyH.remove(localObject);
      }
      localb.lyH.put(paramString, new WeakReference(parama));
      AppMethodBeat.o(250316);
      return;
    }
  }
  
  @t(jl=h.a.ON_DESTROY)
  public final void doDestroy(l paraml)
  {
    AppMethodBeat.i(250319);
    try
    {
      paraml = this.JHN;
      if (paraml != null) {
        paraml.lyH.clear();
      }
      AppMethodBeat.o(250319);
      return;
    }
    catch (Throwable paraml)
    {
      AppMethodBeat.o(250319);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager
 * JD-Core Version:    0.7.0.1
 */