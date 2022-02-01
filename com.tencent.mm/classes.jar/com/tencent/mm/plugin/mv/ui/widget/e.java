package com.tencent.mm.plugin.mv.ui.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public final class e
{
  private final a MlW;
  private float MlX;
  private float MlY;
  private boolean MlZ;
  private boolean Mma;
  float Mmb;
  float Mmc;
  private float Mmd;
  private float Mme;
  private float Mmf;
  private float Mmg;
  private float Mmh;
  private long Mmi;
  private long Mmj;
  private boolean Mmk;
  int Mml;
  private int Mmm;
  float Mmn;
  float Mmo;
  int Mmp;
  boolean Mmq;
  private final Context mContext;
  private final Handler mHandler;
  private GestureDetector mQj;
  
  public e(Context paramContext, a parama)
  {
    this(paramContext, parama, (byte)0);
  }
  
  private e(Context paramContext, a parama, byte paramByte)
  {
    AppMethodBeat.i(286664);
    this.Mmp = 0;
    this.mContext = paramContext;
    this.MlW = parama;
    parama = ViewConfiguration.get(paramContext);
    this.Mml = (parama.getScaledTouchSlop() * 2);
    this.Mmm = (parama.getScaledTouchSlop() * 4);
    this.mHandler = null;
    paramByte = paramContext.getApplicationInfo().targetSdkVersion;
    if (paramByte > 18)
    {
      this.MlZ = true;
      if ((this.MlZ) && (this.mQj == null))
      {
        paramContext = new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(286681);
            b localb = new b();
            localb.cH(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(286681);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(286659);
            b localb = new b();
            localb.cH(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
            e.this.Mmn = paramAnonymousMotionEvent.getX();
            e.this.Mmo = paramAnonymousMotionEvent.getY();
            e.this.Mmp = 1;
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(286659);
            return true;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(286675);
            b localb = new b();
            localb.cH(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
            super.onLongPress(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(286675);
          }
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(286666);
            b localb = new b();
            localb.cH(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(286666);
            return bool;
          }
        };
        this.mQj = new GestureDetector(this.mContext, paramContext, this.mHandler);
      }
    }
    if (paramByte > 22) {
      this.Mma = true;
    }
    AppMethodBeat.o(286664);
  }
  
  final boolean gss()
  {
    return this.Mmp != 0;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(286685);
    this.Mmi = paramMotionEvent.getEventTime();
    int i1 = paramMotionEvent.getActionMasked();
    if (this.MlZ)
    {
      GestureDetector localGestureDetector = this.mQj;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    int n = paramMotionEvent.getPointerCount();
    int j;
    if (this.Mmp == 2)
    {
      i = 1;
      if ((i1 != 1) && (i1 != 3) && (i == 0)) {
        break label196;
      }
      j = 1;
      label136:
      if ((i1 != 0) && (j == 0)) {
        break label232;
      }
      if (!this.Mmk) {
        break label202;
      }
      this.MlW.b(this);
      this.Mmk = false;
      this.Mmd = 0.0F;
    }
    for (this.Mmp = 0;; this.Mmp = 0)
    {
      label196:
      label202:
      do
      {
        if (j == 0) {
          break label232;
        }
        AppMethodBeat.o(286685);
        return true;
        i = 0;
        break;
        j = 0;
        break label136;
      } while ((!gss()) || (j == 0));
      this.Mmk = false;
      this.Mmd = 0.0F;
    }
    label232:
    if ((!this.Mmk) && (this.Mma)) {
      gss();
    }
    int k;
    label287:
    label298:
    float f2;
    float f1;
    if ((i1 == 0) || (i1 == 6) || (i1 == 5) || (i != 0))
    {
      i = 1;
      if (i1 != 6) {
        break label430;
      }
      k = 1;
      if (k == 0) {
        break label436;
      }
      j = paramMotionEvent.getActionIndex();
      f2 = 0.0F;
      f1 = 0.0F;
      if (k == 0) {
        break label442;
      }
      k = n - 1;
      label313:
      if (!gss()) {
        break label457;
      }
      f2 = this.Mmn;
      f1 = this.Mmo;
      if (paramMotionEvent.getY() >= f1) {
        break label449;
      }
      this.Mmq = true;
    }
    float f3;
    for (;;)
    {
      f4 = 0.0F;
      f3 = 0.0F;
      int m = 0;
      while (m < n)
      {
        float f6 = f3;
        f5 = f4;
        if (j != m)
        {
          f5 = f4 + Math.abs(paramMotionEvent.getX(m) - f2);
          f6 = f3 + Math.abs(paramMotionEvent.getY(m) - f1);
        }
        m += 1;
        f3 = f6;
        f4 = f5;
      }
      i = 0;
      break;
      label430:
      k = 0;
      break label287;
      label436:
      j = -1;
      break label298;
      label442:
      k = n;
      break label313;
      label449:
      this.Mmq = false;
      continue;
      label457:
      m = 0;
      while (m < n)
      {
        f4 = f1;
        f3 = f2;
        if (j != m)
        {
          f3 = f2 + paramMotionEvent.getX(m);
          f4 = f1 + paramMotionEvent.getY(m);
        }
        m += 1;
        f1 = f4;
        f2 = f3;
      }
      f2 /= k;
      f1 /= k;
    }
    f4 /= k;
    f3 /= k;
    float f5 = 2.0F * f4;
    float f4 = 2.0F * f3;
    boolean bool;
    if (gss())
    {
      f3 = f4;
      bool = this.Mmk;
      this.MlX = f2;
      this.MlY = f1;
      if ((!gss()) && (this.Mmk) && ((f3 < this.Mmm) || (i != 0)))
      {
        this.MlW.b(this);
        this.Mmk = false;
        this.Mmd = f3;
      }
      if (i != 0)
      {
        this.Mme = f5;
        this.Mmg = f5;
        this.Mmf = f4;
        this.Mmh = f4;
        this.Mmb = f3;
        this.Mmc = f3;
        this.Mmd = f3;
      }
      if (!gss()) {
        break label899;
      }
    }
    label899:
    for (int i = this.Mml;; i = this.Mmm)
    {
      if ((!this.Mmk) && (f3 >= i) && ((bool) || (Math.abs(f3 - this.Mmd) > this.Mml)))
      {
        this.Mme = f5;
        this.Mmg = f5;
        this.Mmf = f4;
        this.Mmh = f4;
        this.Mmb = f3;
        this.Mmc = f3;
        this.Mmj = this.Mmi;
        this.Mmk = this.MlW.a(this);
      }
      if (i1 == 2)
      {
        this.Mme = f5;
        this.Mmf = f4;
        this.Mmb = f3;
        bool = true;
        if (this.Mmk) {
          bool = this.MlW.c(this);
        }
        if (bool)
        {
          this.Mmg = this.Mme;
          this.Mmh = this.Mmf;
          this.Mmc = this.Mmb;
          this.Mmj = this.Mmi;
        }
      }
      AppMethodBeat.o(286685);
      return true;
      f3 = (float)Math.hypot(f5, f4);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(e parame);
    
    public abstract void b(e parame);
    
    public abstract boolean c(e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */