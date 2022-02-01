package com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RequestListenerManager
  implements LifecycleObserver
{
  private static final Map<Integer, RequestListenerManager> DxT;
  public b DxU;
  
  static
  {
    AppMethodBeat.i(202151);
    DxT = new ArrayMap();
    AppMethodBeat.o(202151);
  }
  
  private RequestListenerManager()
  {
    AppMethodBeat.i(202147);
    this.DxU = new b();
    AppMethodBeat.o(202147);
  }
  
  public static RequestListenerManager aF(Activity paramActivity)
  {
    AppMethodBeat.i(202144);
    if ((paramActivity instanceof LifecycleOwner))
    {
      RequestListenerManager localRequestListenerManager2 = (RequestListenerManager)DxT.get(Integer.valueOf(paramActivity.hashCode()));
      RequestListenerManager localRequestListenerManager1 = localRequestListenerManager2;
      if (localRequestListenerManager2 == null)
      {
        localRequestListenerManager2 = aG(paramActivity);
        localRequestListenerManager1 = localRequestListenerManager2;
        if (localRequestListenerManager2 != null)
        {
          Log.i("RequestListenerManager", "new one RequestListenerManager instance!!!");
          DxT.put(Integer.valueOf(paramActivity.hashCode()), localRequestListenerManager2);
          localRequestListenerManager1 = localRequestListenerManager2;
        }
      }
      AppMethodBeat.o(202144);
      return localRequestListenerManager1;
    }
    AppMethodBeat.o(202144);
    return null;
  }
  
  private static RequestListenerManager aG(Activity paramActivity)
  {
    AppMethodBeat.i(202145);
    try
    {
      if ((paramActivity instanceof LifecycleOwner))
      {
        paramActivity = e((LifecycleOwner)paramActivity);
        AppMethodBeat.o(202145);
        return paramActivity;
      }
    }
    catch (Throwable paramActivity)
    {
      AppMethodBeat.o(202145);
    }
    return null;
  }
  
  private static RequestListenerManager e(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(202146);
    if (paramLifecycleOwner == null) {}
    try
    {
      Log.w("RequestListenerManager", "the input life cycle owner is null!");
      AppMethodBeat.o(202146);
      return null;
    }
    catch (Throwable paramLifecycleOwner)
    {
      RequestListenerManager localRequestListenerManager;
      boolean bool;
      Log.e("RequestListenerManager", "new one instance of RequestListenerManager failed!");
      AppMethodBeat.o(202146);
    }
    localRequestListenerManager = new RequestListenerManager();
    bool = localRequestListenerManager.f(paramLifecycleOwner);
    if (!bool)
    {
      AppMethodBeat.o(202146);
      return null;
    }
    AppMethodBeat.o(202146);
    return localRequestListenerManager;
    return null;
  }
  
  private boolean f(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(202148);
    if (paramLifecycleOwner != null) {}
    try
    {
      paramLifecycleOwner.getLifecycle().addObserver(this);
      AppMethodBeat.o(202148);
      return true;
    }
    catch (Throwable paramLifecycleOwner)
    {
      for (;;)
      {
        Log.e("RequestListenerManager", "RequestListenerManager attachToOwner failed!");
      }
    }
    Log.w("RequestListenerManager", "the life cycle owner is null!");
    AppMethodBeat.o(202148);
    return false;
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(202149);
    b localb = this.DxU;
    Map.Entry localEntry;
    if (localb != null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(202149);
        return;
      }
      localObject = (WeakReference)localb.iIE.get(paramString);
      if ((localObject == null) || (((WeakReference)localObject).get() != parama))
      {
        localObject = localb.iIE.entrySet().iterator();
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
        localb.iIE.remove(localObject);
      }
      localb.iIE.put(paramString, new WeakReference(parama));
      AppMethodBeat.o(202149);
      return;
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void doDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(202150);
    try
    {
      paramLifecycleOwner = this.DxU;
      if (paramLifecycleOwner != null) {
        paramLifecycleOwner.iIE.clear();
      }
      AppMethodBeat.o(202150);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(202150);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager
 * JD-Core Version:    0.7.0.1
 */