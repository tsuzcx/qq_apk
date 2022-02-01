package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.f.b.c;
import java.util.Timer;
import java.util.TimerTask;

public class CropImageView
  extends ImageView
{
  private boolean JKk;
  private Drawable JKl;
  private boolean LaN;
  private boolean LaO;
  private float LaP;
  private float LaQ;
  private PointF LaR;
  float LaS;
  float LaT;
  boolean LaU;
  private boolean LaV;
  private boolean LaW;
  private boolean LaX;
  private boolean LaY;
  private boolean LaZ;
  private boolean Lba;
  private boolean Lbb;
  private float Lbc;
  private c Lbd;
  private boolean Lbe;
  private boolean Lbf;
  Timer Lbg;
  aq Lbh;
  private b Lbi;
  aq Lbj;
  private a Lbk;
  private boolean Lbl;
  private float aTL;
  private float aTM;
  private Timer cOI;
  int dyw;
  private View.OnTouchListener tOH;
  Bitmap tZb;
  private float translateX;
  private float translateY;
  private long vqv;
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143044);
    this.LaN = true;
    this.LaO = false;
    this.LaR = new PointF();
    this.LaS = 0.0F;
    this.LaT = 0.0F;
    this.LaU = false;
    this.LaV = false;
    this.LaW = false;
    this.LaX = false;
    this.LaY = false;
    this.LaZ = false;
    this.Lba = false;
    this.Lbb = false;
    this.Lbc = 1.0F;
    this.translateX = 0.0F;
    this.translateY = 0.0F;
    this.cOI = new Timer(true);
    this.Lbd = null;
    this.Lbe = false;
    this.Lbf = false;
    this.Lbh = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143038);
        ae.d("MicroMsg.CropImageView", "on handler");
        if (paramAnonymousMessage.what == 4659) {
          CropImageView.this.zoomIn();
        }
        do
        {
          for (;;)
          {
            super.handleMessage(paramAnonymousMessage);
            AppMethodBeat.o(143038);
            return;
            if (paramAnonymousMessage.what == 4658)
            {
              CropImageView.this.zoomOut();
            }
            else
            {
              if (paramAnonymousMessage.what != 4660) {
                break;
              }
              if ((CropImageView.a(CropImageView.this) != null) && (CropImageView.b(CropImageView.this) != null))
              {
                CropImageView.b(CropImageView.this).cancel();
                CropImageView.c(CropImageView.this);
              }
            }
          }
        } while (paramAnonymousMessage.what != 4661);
        MotionEvent localMotionEvent = (MotionEvent)paramAnonymousMessage.obj;
        CropImageView.a(CropImageView.this, System.currentTimeMillis());
        CropImageView.a(CropImageView.this, false);
        if ((localMotionEvent.getRawX() - CropImageView.d(CropImageView.this) > 10.0F) || (localMotionEvent.getRawY() - CropImageView.e(CropImageView.this) > 10.0F) || (localMotionEvent.getRawX() - CropImageView.d(CropImageView.this) < -10.0F) || (localMotionEvent.getRawY() - CropImageView.e(CropImageView.this) < -10.0F)) {}
        for (int i = 0;; i = 1)
        {
          if (i != 0)
          {
            long l = System.currentTimeMillis();
            if ((CropImageView.f(CropImageView.this) != 0L) && (l - CropImageView.f(CropImageView.this) < 300L) && (l - CropImageView.f(CropImageView.this) >= 0L) && (CropImageView.g(CropImageView.this) != null)) {
              CropImageView.g(CropImageView.this).fOH();
            }
            CropImageView.a(CropImageView.this, 0L);
          }
          f.a(CropImageView.h(CropImageView.this), CropImageView.i(CropImageView.this));
          break;
        }
      }
    };
    this.Lbi = null;
    this.Lbj = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143039);
        if (paramAnonymousMessage.what == 4653) {
          if ((CropImageView.a(CropImageView.this) != null) && (CropImageView.m(CropImageView.this) != null))
          {
            CropImageView.m(CropImageView.this).cancel();
            CropImageView.n(CropImageView.this);
          }
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(143039);
          return;
          CropImageView.o(CropImageView.this);
        }
      }
    };
    this.dyw = 0;
    this.Lbl = true;
    this.tOH = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, final MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143041);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/tools/CropImageView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (!CropImageView.u(CropImageView.this))
        {
          a.a(false, this, "com/tencent/mm/ui/tools/CropImageView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143041);
          return false;
        }
        if (CropImageView.i(CropImageView.this) == null)
        {
          a.a(false, this, "com/tencent/mm/ui/tools/CropImageView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143041);
          return false;
        }
        int i = paramAnonymousMotionEvent.getAction() & 0xFF;
        ae.d("MicroMsg.CropImageView", "on touch : event type=" + i + ", isDownOnImg=" + CropImageView.v(CropImageView.this));
        if ((!CropImageView.v(CropImageView.this)) && (i != 0))
        {
          a.a(false, this, "com/tencent/mm/ui/tools/CropImageView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143041);
          return false;
        }
        switch (i)
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/ui/tools/CropImageView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143041);
          return false;
          ae.d("MicroMsg.CropImageView", "action_mult_down");
          CropImageView.b(CropImageView.this, true);
          CropImageView.this.LaS = f.aa(paramAnonymousMotionEvent);
          if (CropImageView.this.LaS > 5.0F)
          {
            CropImageView.this.LaU = true;
            f.a(CropImageView.h(CropImageView.this), paramAnonymousMotionEvent);
            a.a(true, this, "com/tencent/mm/ui/tools/CropImageView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(143041);
            return true;
            ae.d("MicroMsg.CropImageView", "action_mult_up");
            CropImageView.this.LaU = false;
            CropImageView.b(CropImageView.this, true);
            a.a(true, this, "com/tencent/mm/ui/tools/CropImageView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(143041);
            return true;
            ae.d("MicroMsg.CropImageView", "action_down");
            CropImageView.a(CropImageView.this, paramAnonymousMotionEvent.getRawX());
            CropImageView.b(CropImageView.this, paramAnonymousMotionEvent.getRawY());
            ae.d("MicroMsg.CropImageView", "lastX=" + CropImageView.w(CropImageView.this) + ",lastY=" + CropImageView.x(CropImageView.this));
            CropImageView.c(CropImageView.this, CropImageView.w(CropImageView.this));
            CropImageView.d(CropImageView.this, CropImageView.x(CropImageView.this));
            paramAnonymousView = CropImageView.this.getImageMatrix();
            paramAnonymousMotionEvent = new RectF();
            paramAnonymousMotionEvent.set(0.0F, 0.0F, CropImageView.i(CropImageView.this).getWidth(), CropImageView.i(CropImageView.this).getHeight());
            paramAnonymousView.mapRect(paramAnonymousMotionEvent);
            CropImageView.a(CropImageView.this, paramAnonymousMotionEvent.contains(CropImageView.w(CropImageView.this), CropImageView.x(CropImageView.this)));
            CropImageView.a(CropImageView.this, System.currentTimeMillis());
            continue;
            ae.d("MicroMsg.CropImageView", "action_move");
            float f1;
            if (CropImageView.this.LaU)
            {
              ae.d("MicroMsg.CropImageView", "is valid mult down");
              CropImageView.this.LaT = f.aa(paramAnonymousMotionEvent);
              f1 = CropImageView.this.LaT - CropImageView.this.LaS;
              if ((CropImageView.this.LaT > 5.0F) && (Math.abs(f1) > 5.0F))
              {
                f.a(CropImageView.h(CropImageView.this), paramAnonymousMotionEvent);
                ae.d("MicroMsg.CropImageView", "mX=" + CropImageView.h(CropImageView.this).x + ",mY=" + CropImageView.h(CropImageView.this).y);
                if (f1 <= 0.0F) {
                  break label846;
                }
                ae.d("MicroMsg.CropImageView", "zoom in");
                CropImageView.this.zoomIn();
              }
            }
            for (;;)
            {
              CropImageView.this.LaS = CropImageView.this.LaT;
              if (!CropImageView.y(CropImageView.this))
              {
                f1 = paramAnonymousMotionEvent.getRawX() - CropImageView.w(CropImageView.this);
                float f2 = paramAnonymousMotionEvent.getRawY() - CropImageView.x(CropImageView.this);
                if ((Math.abs(f1) > 5.0F) || (Math.abs(f2) > 5.0F)) {
                  CropImageView.this.getImageMatrix().postTranslate(f1, f2);
                }
                CropImageView.this.invalidate();
              }
              CropImageView.b(CropImageView.this, false);
              CropImageView.a(CropImageView.this, paramAnonymousMotionEvent.getRawX());
              CropImageView.b(CropImageView.this, paramAnonymousMotionEvent.getRawY());
              break;
              label846:
              ae.d("MicroMsg.CropImageView", "zoom out");
              CropImageView.this.zoomOut();
            }
            ae.d("MicroMsg.CropImageView", "action_up");
            if (CropImageView.z(CropImageView.this))
            {
              CropImageView.c(CropImageView.this, false);
              if (CropImageView.A(CropImageView.this))
              {
                CropImageView.d(CropImageView.this, false);
                CropImageView.this.zoomOut();
                CropImageView.this.zoomOut();
                CropImageView.this.zoomOut();
                CropImageView.this.zoomOut();
                CropImageView.this.zoomOut();
              }
              else
              {
                CropImageView.d(CropImageView.this, true);
                CropImageView.this.zoomIn();
                CropImageView.this.zoomIn();
                CropImageView.this.zoomIn();
                CropImageView.this.zoomIn();
                CropImageView.this.zoomIn();
              }
            }
            else
            {
              CropImageView.c(CropImageView.this, true);
              if (CropImageView.B(CropImageView.this) != null) {
                CropImageView.B(CropImageView.this).cancel();
              }
              CropImageView.a(CropImageView.this, new Timer());
              paramAnonymousView = new TimerTask()
              {
                public final void run()
                {
                  AppMethodBeat.i(143040);
                  if (CropImageView.z(CropImageView.this))
                  {
                    Message localMessage = new Message();
                    localMessage.what = 4661;
                    localMessage.obj = paramAnonymousMotionEvent;
                    CropImageView.l(CropImageView.this).sendMessage(localMessage);
                    CropImageView.c(CropImageView.this, false);
                  }
                  AppMethodBeat.o(143040);
                }
              };
              CropImageView.B(CropImageView.this).schedule(paramAnonymousView, 200L);
            }
          }
        }
      }
    };
    this.JKk = false;
    fOI();
    AppMethodBeat.o(143044);
  }
  
  private void fOJ()
  {
    AppMethodBeat.i(143048);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.LaR.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.LaR.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(1.0666F, 1.0666F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.tZb);
    invalidate();
    AppMethodBeat.o(143048);
  }
  
  private void fOK()
  {
    AppMethodBeat.i(143050);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.LaR.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.LaR.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(0.9375F, 0.9375F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.tZb);
    invalidate();
    AppMethodBeat.o(143050);
  }
  
  public final void fOI()
  {
    AppMethodBeat.i(143046);
    setOnTouchListener(this.tOH);
    AppMethodBeat.o(143046);
  }
  
  public Bitmap getBmp()
  {
    return this.tZb;
  }
  
  public int getGifHeight()
  {
    AppMethodBeat.i(143053);
    if ((this.JKk) && (this.JKl != null))
    {
      i = this.JKl.getIntrinsicHeight();
      AppMethodBeat.o(143053);
      return i;
    }
    int i = getHeight();
    AppMethodBeat.o(143053);
    return i;
  }
  
  public int getGifWidth()
  {
    AppMethodBeat.i(143052);
    if ((this.JKk) && (this.JKl != null))
    {
      i = this.JKl.getIntrinsicWidth();
      AppMethodBeat.o(143052);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(143052);
    return i;
  }
  
  public int getRotateCount()
  {
    return this.dyw;
  }
  
  public void setEnableOprate(boolean paramBoolean)
  {
    this.Lbl = paramBoolean;
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(143051);
    try
    {
      this.JKk = true;
      this.JKl = c.mx(paramString, paramString);
      setImageDrawable(this.JKl);
      AppMethodBeat.o(143051);
      return;
    }
    catch (Exception paramString)
    {
      this.JKk = false;
      AppMethodBeat.o(143051);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(143045);
    this.JKk = false;
    this.tZb = paramBitmap;
    f.a(this.LaR, paramBitmap);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(143045);
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    this.LaN = paramBoolean;
  }
  
  public void setOnShortClick(a parama)
  {
    this.Lbk = parama;
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(143047);
    this.Lbc *= 1.0666F;
    if (1.0F <= this.Lbc) {
      this.LaX = false;
    }
    if (1.6F < this.Lbc) {}
    for (this.LaW = true; (this.LaN) && (4.0F < this.Lbc); this.LaW = false)
    {
      this.Lbc = 4.0F;
      AppMethodBeat.o(143047);
      return;
    }
    fOJ();
    AppMethodBeat.o(143047);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(143049);
    this.Lbc *= 0.9375F;
    if (1.6F > this.Lbc) {
      this.LaW = false;
    }
    if (1.0F > this.Lbc) {}
    for (this.LaX = true; 0.4F > this.Lbc; this.LaX = false)
    {
      this.Lbc = 0.4F;
      AppMethodBeat.o(143049);
      return;
    }
    fOK();
    AppMethodBeat.o(143049);
  }
  
  public static abstract interface a
  {
    public abstract void fOH();
  }
  
  final class b
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(143042);
      Message localMessage = new Message();
      if ((CropImageView.p(this.Lbm)) || (CropImageView.q(this.Lbm)) || (CropImageView.r(this.Lbm)) || (CropImageView.s(this.Lbm))) {}
      for (localMessage.what = 4654;; localMessage.what = 4653)
      {
        CropImageView.t(this.Lbm).sendMessage(localMessage);
        AppMethodBeat.o(143042);
        return;
      }
    }
  }
  
  final class c
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(143043);
      ae.d("MicroMsg.CropImageView", "in timer task run");
      Message localMessage = new Message();
      if (CropImageView.j(this.Lbm)) {
        localMessage.what = 4659;
      }
      for (;;)
      {
        CropImageView.l(this.Lbm).sendMessage(localMessage);
        AppMethodBeat.o(143043);
        return;
        if (CropImageView.k(this.Lbm)) {
          localMessage.what = 4658;
        } else {
          localMessage.what = 4660;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView
 * JD-Core Version:    0.7.0.1
 */