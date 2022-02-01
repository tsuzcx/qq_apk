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
public final class ak
{
  private static final boolean HsR;
  private static final WeakHashMap<Activity, ak> HsS;
  private WindowInsets HsT;
  private final Set<View.OnApplyWindowInsetsListener> oFR;
  
  static
  {
    AppMethodBeat.i(153549);
    if (Build.VERSION.SDK_INT < 23) {}
    for (boolean bool = true;; bool = false)
    {
      HsR = bool;
      HsS = new WeakHashMap();
      AppMethodBeat.o(153549);
      return;
    }
  }
  
  private ak(final Activity paramActivity)
  {
    AppMethodBeat.i(153547);
    this.oFR = new HashSet();
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
            synchronized (ak.this)
            {
              ak.a(ak.this, new WindowInsets(paramAnonymous2WindowInsets));
            }
            synchronized (ak.a(ak.this))
            {
              LinkedList localLinkedList = new LinkedList(ak.a(ak.this));
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
  public static ak bg(Activity paramActivity)
  {
    AppMethodBeat.i(153544);
    paramActivity = d(paramActivity, true);
    AppMethodBeat.o(153544);
    return paramActivity;
  }
  
  public static WindowInsets bh(Activity paramActivity)
  {
    AppMethodBeat.i(153545);
    if (HsR)
    {
      paramActivity = d(paramActivity, false);
      if (paramActivity == null)
      {
        AppMethodBeat.o(153545);
        return null;
      }
      paramActivity = paramActivity.fhM();
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
  
  private static ak d(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(153546);
    synchronized (HsS)
    {
      ak localak2 = (ak)HsS.get(paramActivity);
      ak localak1 = localak2;
      if (localak2 == null)
      {
        localak1 = localak2;
        if (paramBoolean)
        {
          localak1 = new ak(paramActivity);
          HsS.put(paramActivity, localak1);
        }
      }
      AppMethodBeat.o(153546);
      return localak1;
    }
  }
  
  private WindowInsets fhM()
  {
    try
    {
      WindowInsets localWindowInsets = this.HsT;
      return localWindowInsets;
    }
    finally {}
  }
  
  public static void g(Application paramApplication)
  {
    AppMethodBeat.i(153543);
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {}
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(153538);
        this.HsU.apply(paramAnonymousActivity);
        AppMethodBeat.o(153538);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(153540);
        synchronized (ak.fhN())
        {
          paramAnonymousActivity = (ak)ak.fhN().remove(paramAnonymousActivity);
          if (paramAnonymousActivity == null) {
            break label72;
          }
        }
        synchronized (ak.a(paramAnonymousActivity))
        {
          ak.a(paramAnonymousActivity).clear();
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
        this.HsU.apply(paramAnonymousActivity);
        AppMethodBeat.o(153539);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    });
    AppMethodBeat.o(153543);
  }
  
  public final void a(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(153548);
    synchronized (this.oFR)
    {
      this.oFR.add(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(153548);
      return;
    }
  }
  
  public final void b(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(175981);
    synchronized (this.oFR)
    {
      this.oFR.remove(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(175981);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ak
 * JD-Core Version:    0.7.0.1
 */