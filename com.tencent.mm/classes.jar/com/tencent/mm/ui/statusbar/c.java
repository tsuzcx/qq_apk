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
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

public class c
{
  public static final boolean ApJ;
  @SuppressLint({"StaticFieldLeak"})
  private static final c ApN;
  private static final WeakHashMap<Activity, c> zfM;
  private final Set<WeakReference<a>> ApK;
  private boolean ApL;
  int ApM;
  private final WeakReference<Activity> mActivityRef;
  
  static
  {
    AppMethodBeat.i(67849);
    if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.c.duQ())) {}
    for (boolean bool = true;; bool = false)
    {
      ApJ = bool;
      ApN = new c()
      {
        public final void a(c.a paramAnonymousa) {}
        
        public final void b(c.a paramAnonymousa) {}
      };
      zfM = new WeakHashMap();
      AppMethodBeat.o(67849);
      return;
    }
  }
  
  private c(Activity paramActivity)
  {
    AppMethodBeat.i(67845);
    this.ApK = new HashSet();
    this.ApL = false;
    this.ApM = 0;
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(67845);
  }
  
  public static c aH(Activity paramActivity)
  {
    AppMethodBeat.i(67847);
    if ((!ApJ) || (paramActivity == null))
    {
      paramActivity = ApN;
      AppMethodBeat.o(67847);
      return paramActivity;
    }
    c localc2 = (c)zfM.get(paramActivity);
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c(paramActivity);
      zfM.put(paramActivity, localc1);
    }
    AppMethodBeat.o(67847);
    return localc1;
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(67846);
    Object localObject;
    if (!this.ApL)
    {
      this.ApL = true;
      localObject = (Activity)this.mActivityRef.get();
      if ((localObject != null) && (((Activity)localObject).getWindow() != null)) {
        break label80;
      }
    }
    for (;;)
    {
      this.ApK.add(new WeakReference(parama));
      if (this.ApM > 0) {
        parama.pB(this.ApM);
      }
      AppMethodBeat.o(67846);
      return;
      try
      {
        label80:
        ViewGroup localViewGroup = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
        localObject = localViewGroup;
        if (localViewGroup.getChildCount() == 1) {
          localObject = localViewGroup.getChildAt(0);
        }
        ((View)localObject).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
        {
          public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
          {
            AppMethodBeat.i(67844);
            c.b(c.this, c.a(c.this, paramAnonymousWindowInsets.getSystemWindowInsetTop()));
            paramAnonymousView = paramAnonymousWindowInsets.consumeSystemWindowInsets();
            AppMethodBeat.o(67844);
            return paramAnonymousView;
          }
        });
        ((View)localObject).requestApplyInsets();
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", new Object[] { localException });
      }
    }
  }
  
  public void b(a parama)
  {
    AppMethodBeat.i(141902);
    Iterator localIterator = new LinkedList(this.ApK).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((parama == localWeakReference.get()) || (localWeakReference.get() == null)) {
        this.ApK.remove(localWeakReference);
      }
    }
    AppMethodBeat.o(141902);
  }
  
  public static abstract interface a
  {
    public abstract void pB(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.c
 * JD-Core Version:    0.7.0.1
 */