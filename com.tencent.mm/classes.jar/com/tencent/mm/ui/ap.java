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
public final class ap
{
  private static final boolean OLK;
  private static final WeakHashMap<Activity, ap> OLL;
  private WindowInsets OLM;
  private final Set<View.OnApplyWindowInsetsListener> qFF;
  
  static
  {
    AppMethodBeat.i(153549);
    if (Build.VERSION.SDK_INT < 23) {}
    for (boolean bool = true;; bool = false)
    {
      OLK = bool;
      OLL = new WeakHashMap();
      AppMethodBeat.o(153549);
      return;
    }
  }
  
  private ap(final Activity paramActivity)
  {
    AppMethodBeat.i(153547);
    this.qFF = new HashSet();
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
            synchronized (ap.this)
            {
              ap.a(ap.this, new WindowInsets(paramAnonymous2WindowInsets));
            }
            synchronized (ap.a(ap.this))
            {
              LinkedList localLinkedList = new LinkedList(ap.a(ap.this));
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
  public static ap bn(Activity paramActivity)
  {
    AppMethodBeat.i(153544);
    paramActivity = f(paramActivity, true);
    AppMethodBeat.o(153544);
    return paramActivity;
  }
  
  public static WindowInsets bo(Activity paramActivity)
  {
    AppMethodBeat.i(153545);
    if (OLK)
    {
      paramActivity = f(paramActivity, false);
      if (paramActivity == null)
      {
        AppMethodBeat.o(153545);
        return null;
      }
      paramActivity = paramActivity.gJZ();
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
  
  private static ap f(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(153546);
    synchronized (OLL)
    {
      ap localap2 = (ap)OLL.get(paramActivity);
      ap localap1 = localap2;
      if (localap2 == null)
      {
        localap1 = localap2;
        if (paramBoolean)
        {
          localap1 = new ap(paramActivity);
          OLL.put(paramActivity, localap1);
        }
      }
      AppMethodBeat.o(153546);
      return localap1;
    }
  }
  
  private WindowInsets gJZ()
  {
    try
    {
      WindowInsets localWindowInsets = this.OLM;
      return localWindowInsets;
    }
    finally {}
  }
  
  public static void i(Application paramApplication)
  {
    AppMethodBeat.i(153543);
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {}
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(153538);
        this.OLN.apply(paramAnonymousActivity);
        AppMethodBeat.o(153538);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(153540);
        synchronized (ap.gKa())
        {
          paramAnonymousActivity = (ap)ap.gKa().remove(paramAnonymousActivity);
          if (paramAnonymousActivity == null) {
            break label72;
          }
        }
        synchronized (ap.a(paramAnonymousActivity))
        {
          ap.a(paramAnonymousActivity).clear();
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
        this.OLN.apply(paramAnonymousActivity);
        AppMethodBeat.o(153539);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    });
    AppMethodBeat.o(153543);
  }
  
  public final void a(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(153548);
    synchronized (this.qFF)
    {
      this.qFF.add(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(153548);
      return;
    }
  }
  
  public final void b(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(175981);
    synchronized (this.qFF)
    {
      this.qFF.remove(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(175981);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ap
 * JD-Core Version:    0.7.0.1
 */