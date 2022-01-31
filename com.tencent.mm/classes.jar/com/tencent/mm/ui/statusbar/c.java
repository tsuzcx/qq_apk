package com.tencent.mm.ui.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class c
{
  private static final WeakHashMap<Activity, c> vXA;
  public static final boolean vXv;
  @SuppressLint({"StaticFieldLeak"})
  private static final c vXz;
  private final WeakReference<Activity> mActivityRef;
  private final Set<WeakReference<a>> vXw = new HashSet();
  private boolean vXx = false;
  int vXy = 0;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.g.c.csB())) {}
    for (boolean bool = true;; bool = false)
    {
      vXv = bool;
      vXz = new c()
      {
        public final void a(c.a paramAnonymousa) {}
      };
      vXA = new WeakHashMap();
      return;
    }
  }
  
  private c(Activity paramActivity)
  {
    this.mActivityRef = new WeakReference(paramActivity);
  }
  
  public static c af(Activity paramActivity)
  {
    if ((!vXv) || (paramActivity == null)) {
      localObject = vXz;
    }
    c localc;
    do
    {
      return localObject;
      localc = (c)vXA.get(paramActivity);
      localObject = localc;
    } while (localc != null);
    Object localObject = new c(paramActivity);
    vXA.put(paramActivity, localObject);
    return localObject;
  }
  
  public void a(a parama)
  {
    Object localObject;
    if (!this.vXx)
    {
      this.vXx = true;
      localObject = (Activity)this.mActivityRef.get();
      if ((localObject != null) && (((Activity)localObject).getWindow() != null)) {
        break label74;
      }
    }
    for (;;)
    {
      if (parama != null)
      {
        this.vXw.add(new WeakReference(parama));
        if (this.vXy > 0) {
          parama.ml(this.vXy);
        }
      }
      return;
      try
      {
        label74:
        ViewGroup localViewGroup = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
        localObject = localViewGroup;
        if (localViewGroup.getChildCount() == 1) {
          localObject = localViewGroup.getChildAt(0);
        }
        ((View)localObject).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
        {
          public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
          {
            c.b(c.this, c.a(c.this, paramAnonymousWindowInsets.getSystemWindowInsetTop()));
            return paramAnonymousWindowInsets.consumeSystemWindowInsets();
          }
        });
        ((View)localObject).requestApplyInsets();
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", new Object[] { localException });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ml(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.c
 * JD-Core Version:    0.7.0.1
 */