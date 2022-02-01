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
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

public class c
{
  private static final WeakHashMap<Activity, c> FTd;
  public static final boolean HlA;
  @SuppressLint({"StaticFieldLeak"})
  private static final c HlE;
  private final Set<WeakReference<a>> HlB;
  private boolean HlC;
  public int HlD;
  private final WeakReference<Activity> mActivityRef;
  
  static
  {
    AppMethodBeat.i(133824);
    if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.c.eHr())) {}
    for (boolean bool = true;; bool = false)
    {
      HlA = bool;
      HlE = new c()
      {
        public final void a(c.a paramAnonymousa) {}
        
        public final void b(c.a paramAnonymousa) {}
      };
      FTd = new WeakHashMap();
      AppMethodBeat.o(133824);
      return;
    }
  }
  
  private c(Activity paramActivity)
  {
    AppMethodBeat.i(133819);
    this.HlB = new HashSet();
    this.HlC = false;
    this.HlD = 0;
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(133819);
  }
  
  public static c bj(Activity paramActivity)
  {
    AppMethodBeat.i(133822);
    if ((!HlA) || (paramActivity == null))
    {
      paramActivity = HlE;
      AppMethodBeat.o(133822);
      return paramActivity;
    }
    c localc2 = (c)FTd.get(paramActivity);
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c(paramActivity);
      FTd.put(paramActivity, localc1);
    }
    AppMethodBeat.o(133822);
    return localc1;
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(133820);
    Object localObject1;
    if (!this.HlC)
    {
      this.HlC = true;
      localObject1 = (Activity)this.mActivityRef.get();
      if ((localObject1 != null) && (((Activity)localObject1).getWindow() != null)) {}
    }
    else
    {
      if (parama != null)
      {
        this.HlB.add(new WeakReference(parama));
        if (this.HlD > 0) {
          parama.sG(this.HlD);
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
          break label195;
        }
        localObject1 = localViewGroup.getChildAt(i);
        if (("android:status:background".equals(((View)localObject1).getTransitionName())) || ("android:navigation:background".equals(((View)localObject1).getTransitionName()))) {
          break label188;
        }
      }
      catch (Exception localException)
      {
        this.HlC = false;
        ad.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", new Object[] { localException });
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
      break;
      break;
      label188:
      i += 1;
      continue;
      label195:
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
      Iterator localIterator = new LinkedList(this.HlB).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((parama == localWeakReference.get()) || (localWeakReference.get() == null)) {
          this.HlB.remove(localWeakReference);
        }
      }
    }
    AppMethodBeat.o(133821);
  }
  
  public static abstract interface a
  {
    public abstract void sG(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.c
 * JD-Core Version:    0.7.0.1
 */