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
public final class am
{
  private static final boolean JgH;
  private static final WeakHashMap<Activity, am> JgI;
  private WindowInsets JgJ;
  private final Set<View.OnApplyWindowInsetsListener> pjv;
  
  static
  {
    AppMethodBeat.i(153549);
    if (Build.VERSION.SDK_INT < 23) {}
    for (boolean bool = true;; bool = false)
    {
      JgH = bool;
      JgI = new WeakHashMap();
      AppMethodBeat.o(153549);
      return;
    }
  }
  
  private am(final Activity paramActivity)
  {
    AppMethodBeat.i(153547);
    this.pjv = new HashSet();
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
            synchronized (am.this)
            {
              am.a(am.this, new WindowInsets(paramAnonymous2WindowInsets));
            }
            synchronized (am.a(am.this))
            {
              LinkedList localLinkedList = new LinkedList(am.a(am.this));
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
  public static am bg(Activity paramActivity)
  {
    AppMethodBeat.i(153544);
    paramActivity = d(paramActivity, true);
    AppMethodBeat.o(153544);
    return paramActivity;
  }
  
  public static WindowInsets bh(Activity paramActivity)
  {
    AppMethodBeat.i(153545);
    if (JgH)
    {
      paramActivity = d(paramActivity, false);
      if (paramActivity == null)
      {
        AppMethodBeat.o(153545);
        return null;
      }
      paramActivity = paramActivity.fyc();
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
  
  private static am d(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(153546);
    synchronized (JgI)
    {
      am localam2 = (am)JgI.get(paramActivity);
      am localam1 = localam2;
      if (localam2 == null)
      {
        localam1 = localam2;
        if (paramBoolean)
        {
          localam1 = new am(paramActivity);
          JgI.put(paramActivity, localam1);
        }
      }
      AppMethodBeat.o(153546);
      return localam1;
    }
  }
  
  private WindowInsets fyc()
  {
    try
    {
      WindowInsets localWindowInsets = this.JgJ;
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
        this.JgK.apply(paramAnonymousActivity);
        AppMethodBeat.o(153538);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(153540);
        synchronized (am.fyd())
        {
          paramAnonymousActivity = (am)am.fyd().remove(paramAnonymousActivity);
          if (paramAnonymousActivity == null) {
            break label72;
          }
        }
        synchronized (am.a(paramAnonymousActivity))
        {
          am.a(paramAnonymousActivity).clear();
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
        this.JgK.apply(paramAnonymousActivity);
        AppMethodBeat.o(153539);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    });
    AppMethodBeat.o(153543);
  }
  
  public final void a(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(153548);
    synchronized (this.pjv)
    {
      this.pjv.add(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(153548);
      return;
    }
  }
  
  public final void b(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(175981);
    synchronized (this.pjv)
    {
      this.pjv.remove(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(175981);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.am
 * JD-Core Version:    0.7.0.1
 */