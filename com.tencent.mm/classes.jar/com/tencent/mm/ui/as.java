package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.Window;
import android.view.WindowInsets;
import androidx.a.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

@TargetApi(21)
public final class as
{
  private static final boolean Wfj;
  private static final WeakHashMap<Activity, as> Wfk;
  private WindowInsets Wfl;
  private final Set<View.OnApplyWindowInsetsListener> ueH;
  
  static
  {
    AppMethodBeat.i(153549);
    if (Build.VERSION.SDK_INT < 23) {}
    for (boolean bool = true;; bool = false)
    {
      Wfj = bool;
      Wfk = new WeakHashMap();
      AppMethodBeat.o(153549);
      return;
    }
  }
  
  private as(final Activity paramActivity)
  {
    AppMethodBeat.i(153547);
    this.ueH = new HashSet();
    paramActivity.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153542);
        paramActivity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
        {
          public final WindowInsets onApplyWindowInsets(View paramAnonymous2View, WindowInsets paramAnonymous2WindowInsets)
          {
            AppMethodBeat.i(153541);
            synchronized (as.this)
            {
              as.a(as.this, new WindowInsets(paramAnonymous2WindowInsets));
            }
            synchronized (as.a(as.this))
            {
              LinkedList localLinkedList = new LinkedList(as.a(as.this));
              ??? = localLinkedList.iterator();
              while (((Iterator)???).hasNext())
              {
                ((View.OnApplyWindowInsetsListener)((Iterator)???).next()).onApplyWindowInsets(paramAnonymous2View, paramAnonymous2WindowInsets);
                continue;
                paramAnonymous2View = finally;
                AppMethodBeat.o(153541);
                throw paramAnonymous2View;
              }
            }
            paramAnonymous2View = paramAnonymous2View.onApplyWindowInsets(paramAnonymous2WindowInsets);
            AppMethodBeat.o(153541);
            return paramAnonymous2View;
          }
        });
        AppMethodBeat.o(153542);
      }
    });
    AppMethodBeat.o(153547);
  }
  
  @TargetApi(21)
  public static as bt(Activity paramActivity)
  {
    AppMethodBeat.i(153544);
    paramActivity = g(paramActivity, true);
    AppMethodBeat.o(153544);
    return paramActivity;
  }
  
  public static WindowInsets bu(Activity paramActivity)
  {
    AppMethodBeat.i(153545);
    if (Wfj)
    {
      paramActivity = g(paramActivity, false);
      if (paramActivity == null)
      {
        AppMethodBeat.o(153545);
        return null;
      }
      paramActivity = paramActivity.hIZ();
      AppMethodBeat.o(153545);
      return paramActivity;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramActivity = paramActivity.getWindow().getDecorView().getRootWindowInsets();
      AppMethodBeat.o(153545);
      return paramActivity;
    }
    AppMethodBeat.o(153545);
    return null;
  }
  
  private static as g(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(153546);
    synchronized (Wfk)
    {
      as localas2 = (as)Wfk.get(paramActivity);
      as localas1 = localas2;
      if (localas2 == null)
      {
        localas1 = localas2;
        if (paramBoolean)
        {
          localas1 = new as(paramActivity);
          Wfk.put(paramActivity, localas1);
        }
      }
      AppMethodBeat.o(153546);
      return localas1;
    }
  }
  
  private WindowInsets hIZ()
  {
    try
    {
      WindowInsets localWindowInsets = this.Wfl;
      return localWindowInsets;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void l(Application paramApplication)
  {
    AppMethodBeat.i(153543);
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {}
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(153538);
        this.Wfm.apply(paramAnonymousActivity);
        AppMethodBeat.o(153538);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(153540);
        synchronized (as.hJa())
        {
          paramAnonymousActivity = (as)as.hJa().remove(paramAnonymousActivity);
          if (paramAnonymousActivity == null) {
            break label72;
          }
        }
        synchronized (as.a(paramAnonymousActivity))
        {
          as.a(paramAnonymousActivity).clear();
          AppMethodBeat.o(153540);
          return;
          paramAnonymousActivity = finally;
          AppMethodBeat.o(153540);
          throw paramAnonymousActivity;
        }
        label72:
        AppMethodBeat.o(153540);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity) {}
      
      public final void onActivityResumed(Activity paramAnonymousActivity) {}
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(153539);
        this.Wfm.apply(paramAnonymousActivity);
        AppMethodBeat.o(153539);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    });
    AppMethodBeat.o(153543);
  }
  
  public final void a(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(153548);
    synchronized (this.ueH)
    {
      this.ueH.add(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(153548);
      return;
    }
  }
  
  public final void b(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(175981);
    synchronized (this.ueH)
    {
      this.ueH.remove(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(175981);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.as
 * JD-Core Version:    0.7.0.1
 */