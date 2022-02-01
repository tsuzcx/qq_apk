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
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

public class c
{
  private static final WeakHashMap<Activity, c> JBt;
  @SuppressLint({"StaticFieldLeak"})
  private static final c KZA;
  public static final boolean KZw;
  private final Set<WeakReference<a>> KZx;
  private boolean KZy;
  public int KZz;
  private final WeakReference<Activity> mActivityRef;
  
  static
  {
    AppMethodBeat.i(133824);
    if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.c.fqr())) {}
    for (boolean bool = true;; bool = false)
    {
      KZw = bool;
      KZA = new c()
      {
        public final void a(c.a paramAnonymousa) {}
        
        public final void b(c.a paramAnonymousa) {}
      };
      JBt = new WeakHashMap();
      AppMethodBeat.o(133824);
      return;
    }
  }
  
  private c(Activity paramActivity)
  {
    AppMethodBeat.i(133819);
    this.KZx = new HashSet();
    this.KZy = false;
    this.KZz = 0;
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(133819);
  }
  
  public static c bn(Activity paramActivity)
  {
    AppMethodBeat.i(133822);
    if ((!KZw) || (paramActivity == null))
    {
      paramActivity = KZA;
      AppMethodBeat.o(133822);
      return paramActivity;
    }
    c localc2 = (c)JBt.get(paramActivity);
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c(paramActivity);
      JBt.put(paramActivity, localc1);
    }
    AppMethodBeat.o(133822);
    return localc1;
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(133820);
    Object localObject1;
    if (!this.KZy)
    {
      this.KZy = true;
      localObject1 = (Activity)this.mActivityRef.get();
      if ((localObject1 != null) && (((Activity)localObject1).getWindow() != null)) {}
    }
    else
    {
      if (parama != null)
      {
        this.KZx.add(new WeakReference(parama));
        if (this.KZz > 0) {
          parama.ug(this.KZz);
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
        this.KZy = false;
        ae.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", new Object[] { localException });
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
      Iterator localIterator = new LinkedList(this.KZx).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((parama == localWeakReference.get()) || (localWeakReference.get() == null)) {
          this.KZx.remove(localWeakReference);
        }
      }
    }
    AppMethodBeat.o(133821);
  }
  
  public static abstract interface a
  {
    public abstract void ug(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.c
 * JD-Core Version:    0.7.0.1
 */