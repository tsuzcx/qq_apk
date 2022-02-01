package com.tencent.mm.ui;

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

public final class ay
{
  private static final boolean adKS;
  private static final WeakHashMap<Activity, ay> adKT;
  private WindowInsets adKU;
  private final Set<View.OnApplyWindowInsetsListener> eO;
  
  static
  {
    AppMethodBeat.i(153549);
    if (Build.VERSION.SDK_INT < 23) {}
    for (boolean bool = true;; bool = false)
    {
      adKS = bool;
      adKT = new WeakHashMap();
      AppMethodBeat.o(153549);
      return;
    }
  }
  
  private ay(final Activity paramActivity)
  {
    AppMethodBeat.i(153547);
    this.eO = new HashSet();
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
            synchronized (ay.this)
            {
              ay.a(ay.this, new WindowInsets(paramAnonymous2WindowInsets));
            }
            synchronized (ay.a(ay.this))
            {
              LinkedList localLinkedList = new LinkedList(ay.a(ay.this));
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
  
  public static ay bX(Activity paramActivity)
  {
    AppMethodBeat.i(153544);
    paramActivity = i(paramActivity, true);
    AppMethodBeat.o(153544);
    return paramActivity;
  }
  
  public static WindowInsets bY(Activity paramActivity)
  {
    AppMethodBeat.i(153545);
    if (adKS)
    {
      paramActivity = i(paramActivity, false);
      if (paramActivity == null)
      {
        AppMethodBeat.o(153545);
        return null;
      }
      paramActivity = paramActivity.jlp();
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
  
  private static ay i(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(153546);
    synchronized (adKT)
    {
      ay localay2 = (ay)adKT.get(paramActivity);
      ay localay1 = localay2;
      if (localay2 == null)
      {
        localay1 = localay2;
        if (paramBoolean)
        {
          localay1 = new ay(paramActivity);
          adKT.put(paramActivity, localay1);
        }
      }
      AppMethodBeat.o(153546);
      return localay1;
    }
  }
  
  private WindowInsets jlp()
  {
    try
    {
      WindowInsets localWindowInsets = this.adKU;
      return localWindowInsets;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void k(Application paramApplication)
  {
    AppMethodBeat.i(153543);
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {}
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(153538);
        ay.this.apply(paramAnonymousActivity);
        AppMethodBeat.o(153538);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(153540);
        synchronized (ay.jlq())
        {
          paramAnonymousActivity = (ay)ay.jlq().remove(paramAnonymousActivity);
          if (paramAnonymousActivity == null) {
            break label72;
          }
        }
        synchronized (ay.a(paramAnonymousActivity))
        {
          ay.a(paramAnonymousActivity).clear();
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
        ay.this.apply(paramAnonymousActivity);
        AppMethodBeat.o(153539);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    });
    AppMethodBeat.o(153543);
  }
  
  public final void a(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(153548);
    synchronized (this.eO)
    {
      this.eO.add(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(153548);
      return;
    }
  }
  
  public final void b(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    AppMethodBeat.i(175981);
    synchronized (this.eO)
    {
      this.eO.remove(paramOnApplyWindowInsetsListener);
      AppMethodBeat.o(175981);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ay
 * JD-Core Version:    0.7.0.1
 */