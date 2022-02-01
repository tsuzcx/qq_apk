package com.tencent.mm.ui.component.support;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/support/ActivityLifecycleInjector;", "", "()V", "activityLifecycleCallbacks", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/component/ActivityLifecycleDetailedCallbacks;", "Lkotlin/collections/ArrayList;", "instrumentation", "Landroid/app/Instrumentation;", "getInstrumentation", "()Landroid/app/Instrumentation;", "instrumentation$delegate", "Lkotlin/Lazy;", "lifecycleDetailedDispatcher", "com/tencent/mm/ui/component/support/ActivityLifecycleInjector$lifecycleDetailedDispatcher$1", "Lcom/tencent/mm/ui/component/support/ActivityLifecycleInjector$lifecycleDetailedDispatcher$1;", "collectActivityLifecycleDetailedCallbacks", "registerActivityDetailedLifecycleCallbacks", "", "callback", "unregisterActivityDetailedLifecycleCallbacks", "ActivityLifecycleDetailedDispatcher", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a afac;
  private static final ArrayList<com.tencent.mm.ui.component.a> afad;
  private static final kotlin.j afae;
  private static final b afaf;
  
  static
  {
    AppMethodBeat.i(250387);
    afac = new a();
    afad = new ArrayList();
    afae = k.cm((kotlin.g.a.a)a.a.afah);
    afaf = new b();
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject = MMApplicationContext.getContext();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Application");
        AppMethodBeat.o(250387);
        throw ((Throwable)localObject);
      }
      ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new Application.ActivityLifecycleCallbacks()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(250346);
          s.u(paramAnonymousActivity, "activity");
          if ((paramAnonymousActivity instanceof AppCompatActivity)) {}
          for (Object localObject = (AppCompatActivity)paramAnonymousActivity;; localObject = null)
          {
            if (localObject != null)
            {
              localObject = ((AppCompatActivity)localObject).getLifecycle();
              if (localObject != null) {
                ((androidx.lifecycle.j)localObject).addObserver((p)new ActivityLifecycleInjector.1.onActivityCreated.1(paramAnonymousActivity, paramAnonymousBundle));
              }
            }
            AppMethodBeat.o(250346);
            return;
          }
        }
        
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(250355);
          s.u(paramAnonymousActivity, "activity");
          if ((paramAnonymousActivity instanceof AppCompatActivity))
          {
            a.jxT();
            a.b.onActivityPostDestroyed(paramAnonymousActivity);
          }
          AppMethodBeat.o(250355);
        }
        
        public final void onActivityPaused(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(250376);
          s.u(paramAnonymousActivity, "activity");
          AppMethodBeat.o(250376);
        }
        
        public final void onActivityResumed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(250370);
          s.u(paramAnonymousActivity, "activity");
          AppMethodBeat.o(250370);
        }
        
        public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(250386);
          s.u(paramAnonymousActivity, "activity");
          s.u(paramAnonymousBundle, "outState");
          AppMethodBeat.o(250386);
        }
        
        public final void onActivityStarted(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(250361);
          s.u(paramAnonymousActivity, "activity");
          AppMethodBeat.o(250361);
        }
        
        public final void onActivityStopped(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(250381);
          s.u(paramAnonymousActivity, "activity");
          AppMethodBeat.o(250381);
        }
      });
      AppMethodBeat.o(250387);
      return;
    }
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Application");
      AppMethodBeat.o(250387);
      throw ((Throwable)localObject);
    }
    ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new Application.ActivityLifecycleCallbacks()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(250372);
        s.u(paramAnonymousActivity, "activity");
        AppMethodBeat.o(250372);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(250401);
        s.u(paramAnonymousActivity, "activity");
        AppMethodBeat.o(250401);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(250391);
        s.u(paramAnonymousActivity, "activity");
        AppMethodBeat.o(250391);
      }
      
      public final void onActivityPostCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(250349);
        s.u(paramAnonymousActivity, "activity");
        a.jxT();
        a.b.onActivityPostCreated(paramAnonymousActivity, paramAnonymousBundle);
        AppMethodBeat.o(250349);
      }
      
      public final void onActivityPostDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(250365);
        s.u(paramAnonymousActivity, "activity");
        a.jxT();
        a.b.onActivityPostDestroyed(paramAnonymousActivity);
        AppMethodBeat.o(250365);
      }
      
      public final void onActivityPreDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(250358);
        s.u(paramAnonymousActivity, "activity");
        a.jxT();
        a.b.onActivityPreDestroyed(paramAnonymousActivity);
        AppMethodBeat.o(250358);
      }
      
      public final void onActivityResumed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(250384);
        s.u(paramAnonymousActivity, "activity");
        AppMethodBeat.o(250384);
      }
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(250398);
        s.u(paramAnonymousActivity, "activity");
        s.u(paramAnonymousBundle, "outState");
        AppMethodBeat.o(250398);
      }
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(250377);
        s.u(paramAnonymousActivity, "activity");
        AppMethodBeat.o(250377);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(250395);
        s.u(paramAnonymousActivity, "activity");
        AppMethodBeat.o(250395);
      }
    });
    AppMethodBeat.o(250387);
  }
  
  public static void a(com.tencent.mm.ui.component.a parama)
  {
    AppMethodBeat.i(250343);
    s.u(parama, "callback");
    synchronized (afad)
    {
      afad.add(parama);
      AppMethodBeat.o(250343);
      return;
    }
  }
  
  public static void b(com.tencent.mm.ui.component.a parama)
  {
    AppMethodBeat.i(250350);
    s.u(parama, "callback");
    synchronized (afad)
    {
      afad.remove(parama);
      AppMethodBeat.o(250350);
      return;
    }
  }
  
  private static ArrayList<com.tencent.mm.ui.component.a> jxR()
  {
    AppMethodBeat.i(250360);
    for (;;)
    {
      synchronized (afad)
      {
        int i;
        if (!((Collection)afad).isEmpty())
        {
          i = 1;
          if (i != 0)
          {
            ArrayList localArrayList1 = new ArrayList((Collection)afad);
            ah localah = ah.aiuX;
            AppMethodBeat.o(250360);
            return localArrayList1;
          }
        }
        else
        {
          i = 0;
        }
      }
      Object localObject2 = null;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/component/support/ActivityLifecycleInjector$lifecycleDetailedDispatcher$1", "Lcom/tencent/mm/ui/component/support/ActivityLifecycleInjector$ActivityLifecycleDetailedDispatcher;", "onActivityPostCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityPostDestroyed", "onActivityPreDestroyed", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static void onActivityPostCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(250325);
      s.u(paramActivity, "activity");
      Object localObject = a.afac;
      localObject = a.jxS();
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.ui.component.a)((Iterator)localObject).next()).onActivityPostCreated(paramActivity, paramBundle);
        }
      }
      AppMethodBeat.o(250325);
    }
    
    public static void onActivityPostDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(250339);
      s.u(paramActivity, "activity");
      Object localObject = a.afac;
      localObject = a.jxS();
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.ui.component.a)((Iterator)localObject).next()).onActivityPostDestroyed(paramActivity);
        }
      }
      AppMethodBeat.o(250339);
    }
    
    public static void onActivityPreDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(250333);
      s.u(paramActivity, "activity");
      Object localObject = a.afac;
      localObject = a.jxS();
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.ui.component.a)((Iterator)localObject).next()).onActivityPreDestroyed(paramActivity);
        }
      }
      AppMethodBeat.o(250333);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.component.support.a
 * JD-Core Version:    0.7.0.1
 */