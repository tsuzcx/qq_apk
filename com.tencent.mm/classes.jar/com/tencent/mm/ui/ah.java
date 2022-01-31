package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.arch.a.c.a;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

@TargetApi(21)
public final class ah
{
  private static final boolean zfL;
  private static final WeakHashMap<Activity, ah> zfM;
  final Set<View.OnApplyWindowInsetsListener> jmL;
  private WindowInsets zfN;
  
  static
  {
    AppMethodBeat.i(146202);
    if (Build.VERSION.SDK_INT < 23) {}
    for (boolean bool = true;; bool = false)
    {
      zfL = bool;
      zfM = new WeakHashMap();
      AppMethodBeat.o(146202);
      return;
    }
  }
  
  private ah(final Activity paramActivity)
  {
    AppMethodBeat.i(146200);
    this.jmL = new HashSet();
    paramActivity.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146195);
        paramActivity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
        {
          public final WindowInsets onApplyWindowInsets(View paramAnonymous2View, WindowInsets paramAnonymous2WindowInsets)
          {
            AppMethodBeat.i(146194);
            synchronized (ah.this)
            {
              ah.a(ah.this, new WindowInsets(paramAnonymous2WindowInsets));
            }
            synchronized (ah.a(ah.this))
            {
              LinkedList localLinkedList = new LinkedList(ah.a(ah.this));
              ??? = localLinkedList.iterator();
              while (((Iterator)???).hasNext())
              {
                ((View.OnApplyWindowInsetsListener)((Iterator)???).next()).onApplyWindowInsets(paramAnonymous2View, paramAnonymous2WindowInsets);
                continue;
                paramAnonymous2View = finally;
                AppMethodBeat.o(146194);
                throw paramAnonymous2View;
              }
            }
            paramAnonymous2View = paramAnonymous2View.onApplyWindowInsets(paramAnonymous2WindowInsets);
            AppMethodBeat.o(146194);
            return paramAnonymous2View;
          }
        });
        AppMethodBeat.o(146195);
      }
    });
    AppMethodBeat.o(146200);
  }
  
  @TargetApi(21)
  public static ah aB(Activity paramActivity)
  {
    AppMethodBeat.i(146197);
    paramActivity = d(paramActivity, true);
    AppMethodBeat.o(146197);
    return paramActivity;
  }
  
  public static WindowInsets aC(Activity paramActivity)
  {
    AppMethodBeat.i(146198);
    if (zfL)
    {
      paramActivity = d(paramActivity, false);
      if (paramActivity == null)
      {
        AppMethodBeat.o(146198);
        return null;
      }
      paramActivity = paramActivity.dDr();
      AppMethodBeat.o(146198);
      return paramActivity;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramActivity = paramActivity.getWindow().getDecorView().getRootWindowInsets();
      AppMethodBeat.o(146198);
      return paramActivity;
    }
    AppMethodBeat.o(146198);
    return null;
  }
  
  private static ah d(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(146199);
    synchronized (zfM)
    {
      ah localah2 = (ah)zfM.get(paramActivity);
      ah localah1 = localah2;
      if (localah2 == null)
      {
        localah1 = localah2;
        if (paramBoolean)
        {
          localah1 = new ah(paramActivity);
          zfM.put(paramActivity, localah1);
        }
      }
      AppMethodBeat.o(146199);
      return localah1;
    }
  }
  
  private WindowInsets dDr()
  {
    try
    {
      WindowInsets localWindowInsets = this.zfN;
      return localWindowInsets;
    }
    finally {}
  }
  
  public static void e(Application paramApplication)
  {
    AppMethodBeat.i(146196);
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {}
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(146192);
        this.zfO.apply(paramAnonymousActivity);
        AppMethodBeat.o(146192);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
      
      public final void onActivityPaused(Activity paramAnonymousActivity) {}
      
      public final void onActivityResumed(Activity paramAnonymousActivity) {}
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(146193);
        this.zfO.apply(paramAnonymousActivity);
        AppMethodBeat.o(146193);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    });
    AppMethodBeat.o(146196);
  }
  
  public final void a(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(146201);
    synchronized (this.jmL)
    {
      this.jmL.add(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(146201);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ah
 * JD-Core Version:    0.7.0.1
 */