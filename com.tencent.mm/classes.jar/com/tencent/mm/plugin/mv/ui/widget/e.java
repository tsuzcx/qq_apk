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
  private final a GrU;
  private float GrV;
  private float GrW;
  private boolean GrX;
  private boolean GrY;
  private float GrZ;
  private float Gsa;
  private float Gsb;
  private float Gsc;
  private float Gsd;
  private float Gse;
  private float Gsf;
  private long Gsg;
  private long Gsh;
  private boolean Gsi;
  private int Gsj;
  private int Gsk;
  float Gsl;
  float Gsm;
  int Gsn;
  private boolean Gso;
  private final Context mContext;
  private final Handler mHandler;
  private GestureDetector pCU;
  
  public e(Context paramContext, a parama)
  {
    this(paramContext, parama, (byte)0);
  }
  
  private e(Context paramContext, a parama, byte paramByte)
  {
    AppMethodBeat.i(229140);
    this.Gsn = 0;
    this.mContext = paramContext;
    this.GrU = parama;
    parama = ViewConfiguration.get(paramContext);
    this.Gsj = (parama.getScaledTouchSlop() * 2);
    this.Gsk = (parama.getScaledTouchSlop() * 4);
    this.mHandler = null;
    paramByte = paramContext.getApplicationInfo().targetSdkVersion;
    if (paramByte > 18)
    {
      this.GrX = true;
      if ((this.GrX) && (this.pCU == null))
      {
        paramContext = new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(233245);
            b localb = new b();
            localb.bn(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(233245);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(233237);
            b localb = new b();
            localb.bn(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
            e.this.Gsl = paramAnonymousMotionEvent.getX();
            e.this.Gsm = paramAnonymousMotionEvent.getY();
            e.this.Gsn = 1;
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(233237);
            return true;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(233243);
            b localb = new b();
            localb.bn(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
            super.onLongPress(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(233243);
          }
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(233240);
            b localb = new b();
            localb.bn(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(233240);
            return bool;
          }
        };
        this.pCU = new GestureDetector(this.mContext, paramContext, this.mHandler);
      }
    }
    if (paramByte > 22) {
      this.GrY = true;
    }
    AppMethodBeat.o(229140);
  }
  
  private boolean fip()
  {
    return this.Gsn != 0;
  }
  
  public final float fiq()
  {
    AppMethodBeat.i(229150);
    float f;
    if (fip())
    {
      if (((this.Gso) && (this.GrZ < this.Gsa)) || ((!this.Gso) && (this.GrZ > this.Gsa))) {}
      for (int i = 1;; i = 0)
      {
        f = Math.abs(1.0F - this.GrZ / this.Gsa) * 0.5F;
        if (this.Gsa > this.Gsj) {
          break;
        }
        AppMethodBeat.o(229150);
        return 1.0F;
      }
      if (i != 0)
      {
        AppMethodBeat.o(229150);
        return 1.0F + f;
      }
      AppMethodBeat.o(229150);
      return 1.0F - f;
    }
    if (this.Gsa > 0.0F)
    {
      f = this.GrZ / this.Gsa;
      AppMethodBeat.o(229150);
      return f;
    }
    AppMethodBeat.o(229150);
    return 1.0F;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(229146);
    this.Gsg = paramMotionEvent.getEventTime();
    int i1 = paramMotionEvent.getActionMasked();
    if (this.GrX)
    {
      GestureDetector localGestureDetector = this.pCU;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aFh(), "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    int n = paramMotionEvent.getPointerCount();
    int j;
    if (this.Gsn == 2)
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
      if (!this.Gsi) {
        break label202;
      }
      this.GrU.b(this);
      this.Gsi = false;
      this.Gsb = 0.0F;
    }
    for (this.Gsn = 0;; this.Gsn = 0)
    {
      label196:
      label202:
      do
      {
        if (j == 0) {
          break label232;
        }
        AppMethodBeat.o(229146);
        return true;
        i = 0;
        break;
        j = 0;
        break label136;
      } while ((!fip()) || (j == 0));
      this.Gsi = false;
      this.Gsb = 0.0F;
    }
    label232:
    if ((!this.Gsi) && (this.GrY)) {
      fip();
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
      if (!fip()) {
        break label457;
      }
      f2 = this.Gsl;
      f1 = this.Gsm;
      if (paramMotionEvent.getY() >= f1) {
        break label449;
      }
      this.Gso = true;
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
      this.Gso = false;
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
    if (fip())
    {
      f3 = f4;
      bool = this.Gsi;
      this.GrV = f2;
      this.GrW = f1;
      if ((!fip()) && (this.Gsi) && ((f3 < this.Gsk) || (i != 0)))
      {
        this.GrU.b(this);
        this.Gsi = false;
        this.Gsb = f3;
      }
      if (i != 0)
      {
        this.Gsc = f5;
        this.Gse = f5;
        this.Gsd = f4;
        this.Gsf = f4;
        this.GrZ = f3;
        this.Gsa = f3;
        this.Gsb = f3;
      }
      if (!fip()) {
        break label890;
      }
    }
    label890:
    for (int i = this.Gsj;; i = this.Gsk)
    {
      if ((!this.Gsi) && (f3 >= i) && ((bool) || (Math.abs(f3 - this.Gsb) > this.Gsj)))
      {
        this.Gsc = f5;
        this.Gse = f5;
        this.Gsd = f4;
        this.Gsf = f4;
        this.GrZ = f3;
        this.Gsa = f3;
        this.Gsh = this.Gsg;
        this.Gsi = this.GrU.a(this);
      }
      if (i1 == 2)
      {
        this.Gsc = f5;
        this.Gsd = f4;
        this.GrZ = f3;
        if (this.Gsi) {
          this.GrU.c(this);
        }
        this.Gse = this.Gsc;
        this.Gsf = this.Gsd;
        this.Gsa = this.GrZ;
        this.Gsh = this.Gsg;
      }
      AppMethodBeat.o(229146);
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