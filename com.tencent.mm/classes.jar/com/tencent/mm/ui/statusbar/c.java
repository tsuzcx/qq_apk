package com.tencent.mm.ui.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.vendor.Meizu;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

public class c
{
  private static final WeakHashMap<Activity, c> OLL;
  @SuppressLint({"StaticFieldLeak"})
  private static final c QoB;
  public static final boolean Qow;
  private WeakReference<View> QoA;
  private final Set<WeakReference<a>> Qox;
  private boolean Qoy;
  public int Qoz;
  private final WeakReference<Activity> mActivityRef;
  
  static
  {
    AppMethodBeat.i(133824);
    if ((Build.VERSION.SDK_INT >= 21) && (!Meizu.hasSmartBar())) {}
    for (boolean bool = true;; bool = false)
    {
      Qow = bool;
      QoB = new c()
      {
        public final void a(c.a paramAnonymousa) {}
        
        public final void b(c.a paramAnonymousa) {}
      };
      OLL = new WeakHashMap();
      AppMethodBeat.o(133824);
      return;
    }
  }
  
  private c(Activity paramActivity)
  {
    AppMethodBeat.i(133819);
    this.Qox = new HashSet();
    this.Qoy = false;
    this.Qoz = 0;
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(133819);
  }
  
  public static c bt(Activity paramActivity)
  {
    AppMethodBeat.i(133822);
    if ((!Qow) || (paramActivity == null))
    {
      paramActivity = QoB;
      AppMethodBeat.o(133822);
      return paramActivity;
    }
    c localc2 = (c)OLL.get(paramActivity);
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c(paramActivity);
      OLL.put(paramActivity, localc1);
    }
    AppMethodBeat.o(133822);
    return localc1;
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(133820);
    Object localObject1;
    if (!this.Qoy)
    {
      this.Qoy = true;
      localObject1 = (Activity)this.mActivityRef.get();
      if ((localObject1 != null) && (((Activity)localObject1).getWindow() != null)) {}
    }
    else
    {
      if (parama != null)
      {
        this.Qox.add(new WeakReference(parama));
        if (this.Qoz > 0) {
          parama.yf(this.Qoz);
        }
      }
      AppMethodBeat.o(133820);
      return;
    }
    for (;;)
    {
      final ViewGroup localViewGroup;
      int i;
      try
      {
        localViewGroup = (ViewGroup)((Activity)localObject1).getWindow().getDecorView();
        i = 0;
        if (i >= localViewGroup.getChildCount()) {
          break label208;
        }
        localObject1 = localViewGroup.getChildAt(i);
        if (("android:status:background".equals(((View)localObject1).getTransitionName())) || ("android:navigation:background".equals(((View)localObject1).getTransitionName()))) {
          break label201;
        }
      }
      catch (Exception localException)
      {
        this.Qoy = false;
        Log.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", new Object[] { localException });
      }
      ((View)localObject3).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          AppMethodBeat.i(133818);
          c.b(c.this, c.a(c.this, paramAnonymousWindowInsets.getSystemWindowInsetTop()));
          paramAnonymousWindowInsets = paramAnonymousWindowInsets.consumeSystemWindowInsets();
          if (paramAnonymousView != localViewGroup) {
            paramAnonymousView.onApplyWindowInsets(paramAnonymousWindowInsets);
          }
          AppMethodBeat.o(133818);
          return paramAnonymousWindowInsets;
        }
      });
      ((View)localObject3).requestApplyInsets();
      this.QoA = new WeakReference(localObject3);
      break;
      break;
      label201:
      i += 1;
      continue;
      label208:
      Object localObject2 = null;
      Object localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = localViewGroup;
      }
    }
  }
  
  public void b(a parama)
  {
    AppMethodBeat.i(133821);
    if (parama != null)
    {
      Iterator localIterator = new LinkedList(this.Qox).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((parama == localWeakReference.get()) || (localWeakReference.get() == null)) {
          this.Qox.remove(localWeakReference);
        }
      }
    }
    AppMethodBeat.o(133821);
  }
  
  public final void requestApplyInsets()
  {
    AppMethodBeat.i(196231);
    if ((this.QoA != null) && (this.QoA.get() != null)) {
      ((View)this.QoA.get()).requestApplyInsets();
    }
    AppMethodBeat.o(196231);
  }
  
  public static abstract interface a
  {
    public abstract void yf(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.c
 * JD-Core Version:    0.7.0.1
 */