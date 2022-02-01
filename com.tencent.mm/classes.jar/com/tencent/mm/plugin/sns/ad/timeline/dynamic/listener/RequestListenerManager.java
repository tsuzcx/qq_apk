package com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener;

import android.app.Activity;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RequestListenerManager
  implements p
{
  private static final Map<Integer, RequestListenerManager> PYN;
  public b PYO;
  
  static
  {
    AppMethodBeat.i(311079);
    PYN = new ArrayMap();
    AppMethodBeat.o(311079);
  }
  
  private RequestListenerManager()
  {
    AppMethodBeat.i(311068);
    this.PYO = new b();
    AppMethodBeat.o(311068);
  }
  
  public static RequestListenerManager bn(Activity paramActivity)
  {
    AppMethodBeat.i(311046);
    if ((paramActivity instanceof q))
    {
      RequestListenerManager localRequestListenerManager2 = (RequestListenerManager)PYN.get(Integer.valueOf(paramActivity.hashCode()));
      RequestListenerManager localRequestListenerManager1 = localRequestListenerManager2;
      if (localRequestListenerManager2 == null)
      {
        localRequestListenerManager2 = bo(paramActivity);
        localRequestListenerManager1 = localRequestListenerManager2;
        if (localRequestListenerManager2 != null)
        {
          Log.i("RequestListenerManager", "new one RequestListenerManager instance!!!");
          PYN.put(Integer.valueOf(paramActivity.hashCode()), localRequestListenerManager2);
          localRequestListenerManager1 = localRequestListenerManager2;
        }
      }
      AppMethodBeat.o(311046);
      return localRequestListenerManager1;
    }
    AppMethodBeat.o(311046);
    return null;
  }
  
  private static RequestListenerManager bo(Activity paramActivity)
  {
    AppMethodBeat.i(311052);
    try
    {
      if ((paramActivity instanceof q))
      {
        paramActivity = o((q)paramActivity);
        return paramActivity;
      }
    }
    finally
    {
      AppMethodBeat.o(311052);
    }
    return null;
  }
  
  private static RequestListenerManager o(q paramq)
  {
    AppMethodBeat.i(311059);
    if (paramq == null) {}
    try
    {
      return null;
    }
    finally
    {
      RequestListenerManager localRequestListenerManager;
      boolean bool;
      Log.e("RequestListenerManager", "new one instance of RequestListenerManager failed!");
      AppMethodBeat.o(311059);
    }
    localRequestListenerManager = new RequestListenerManager();
    bool = localRequestListenerManager.p(paramq);
    if (!bool)
    {
      AppMethodBeat.o(311059);
      return null;
    }
    AppMethodBeat.o(311059);
    return localRequestListenerManager;
    return null;
  }
  
  private boolean p(q paramq)
  {
    AppMethodBeat.i(311072);
    if (paramq != null) {}
    try
    {
      paramq.getLifecycle().addObserver(this);
      AppMethodBeat.o(311072);
      return true;
    }
    finally
    {
      for (;;)
      {
        Log.e("RequestListenerManager", "RequestListenerManager attachToOwner failed!");
      }
    }
    Log.w("RequestListenerManager", "the life cycle owner is null!");
    AppMethodBeat.o(311072);
    return false;
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(311089);
    b localb = this.PYO;
    Map.Entry localEntry;
    if (localb != null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(311089);
        return;
      }
      localObject = (WeakReference)localb.oqi.get(paramString);
      if ((localObject == null) || (((WeakReference)localObject).get() != parama))
      {
        localObject = localb.oqi.entrySet().iterator();
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
        localb.oqi.remove(localObject);
      }
      localb.oqi.put(paramString, new WeakReference(parama));
      AppMethodBeat.o(311089);
      return;
    }
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public final void doDestroy(q paramq)
  {
    AppMethodBeat.i(311099);
    try
    {
      paramq = this.PYO;
      if (paramq != null) {
        paramq.oqi.clear();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager
 * JD-Core Version:    0.7.0.1
 */