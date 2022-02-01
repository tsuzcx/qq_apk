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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.f.b.c;
import java.util.Timer;
import java.util.TimerTask;

public class CropImageView
  extends ImageView
{
  private boolean GbR;
  private Drawable GbS;
  private boolean HmS;
  private boolean HmT;
  private float HmU;
  private float HmV;
  private PointF HmW;
  float HmX;
  float HmY;
  boolean HmZ;
  private boolean Hna;
  private boolean Hnb;
  private boolean Hnc;
  private boolean Hnd;
  private boolean Hne;
  private boolean Hnf;
  private boolean Hng;
  private float Hnh;
  private c Hni;
  private boolean Hnj;
  private boolean Hnk;
  Timer Hnl;
  ap Hnm;
  private b Hnn;
  ap Hno;
  private a Hnp;
  private boolean Hnq;
  int dnV;
  private float qXK;
  Bitmap rJR;
  private View.OnTouchListener ryf;
  private long sTp;
  private float seQ;
  private Timer tOV;
  private float translateX;
  private float translateY;
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143044);
    this.HmS = true;
    this.HmT = false;
    this.HmW = new PointF();
    this.HmX = 0.0F;
    this.HmY = 0.0F;
    this.HmZ = false;
    this.Hna = false;
    this.Hnb = false;
    this.Hnc = false;
    this.Hnd = false;
    this.Hne = false;
    this.Hnf = false;
    this.Hng = false;
    this.Hnh = 1.0F;
    this.translateX = 0.0F;
    this.translateY = 0.0F;
    this.tOV = new Timer(true);
    this.Hni = null;
    this.Hnj = false;
    this.Hnk = false;
    this.Hnm = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143038);
        ad.d("MicroMsg.CropImageView", "on handler");
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
              CropImageView.g(CropImageView.this).fdI();
            }
            CropImageView.a(CropImageView.this, 0L);
          }
          f.a(CropImageView.h(CropImageView.this), CropImageView.i(CropImageView.this));
          break;
        }
      }
    };
    this.Hnn = null;
    this.Hno = new ap()
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
    this.dnV = 0;
    this.Hnq = true;
    this.ryf = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, final MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143041);
        if (!CropImageView.u(CropImageView.this))
        {
          AppMethodBeat.o(143041);
          return false;
        }
        if (CropImageView.i(CropImageView.this) == null)
        {
          AppMethodBeat.o(143041);
          return false;
        }
        int i = paramAnonymousMotionEvent.getAction() & 0xFF;
        ad.d("MicroMsg.CropImageView", "on touch : event type=" + i + ", isDownOnImg=" + CropImageView.v(CropImageView.this));
        if ((!CropImageView.v(CropImageView.this)) && (i != 0))
        {
          AppMethodBeat.o(143041);
          return false;
        }
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(143041);
          return false;
          ad.d("MicroMsg.CropImageView", "action_mult_down");
          CropImageView.b(CropImageView.this, true);
          CropImageView.this.HmX = f.aa(paramAnonymousMotionEvent);
          if (CropImageView.this.HmX > 5.0F)
          {
            CropImageView.this.HmZ = true;
            f.a(CropImageView.h(CropImageView.this), paramAnonymousMotionEvent);
            AppMethodBeat.o(143041);
            return true;
            ad.d("MicroMsg.CropImageView", "action_mult_up");
            CropImageView.this.HmZ = false;
            CropImageView.b(CropImageView.this, true);
            AppMethodBeat.o(143041);
            return true;
            ad.d("MicroMsg.CropImageView", "action_down");
            CropImageView.a(CropImageView.this, paramAnonymousMotionEvent.getRawX());
            CropImageView.b(CropImageView.this, paramAnonymousMotionEvent.getRawY());
            ad.d("MicroMsg.CropImageView", "lastX=" + CropImageView.w(CropImageView.this) + ",lastY=" + CropImageView.x(CropImageView.this));
            CropImageView.c(CropImageView.this, CropImageView.w(CropImageView.this));
            CropImageView.d(CropImageView.this, CropImageView.x(CropImageView.this));
            paramAnonymousView = CropImageView.this.getImageMatrix();
            paramAnonymousMotionEvent = new RectF();
            paramAnonymousMotionEvent.set(0.0F, 0.0F, CropImageView.i(CropImageView.this).getWidth(), CropImageView.i(CropImageView.this).getHeight());
            paramAnonymousView.mapRect(paramAnonymousMotionEvent);
            CropImageView.a(CropImageView.this, paramAnonymousMotionEvent.contains(CropImageView.w(CropImageView.this), CropImageView.x(CropImageView.this)));
            CropImageView.a(CropImageView.this, System.currentTimeMillis());
            continue;
            ad.d("MicroMsg.CropImageView", "action_move");
            float f1;
            if (CropImageView.this.HmZ)
            {
              ad.d("MicroMsg.CropImageView", "is valid mult down");
              CropImageView.this.HmY = f.aa(paramAnonymousMotionEvent);
              f1 = CropImageView.this.HmY - CropImageView.this.HmX;
              if ((CropImageView.this.HmY > 5.0F) && (Math.abs(f1) > 5.0F))
              {
                f.a(CropImageView.h(CropImageView.this), paramAnonymousMotionEvent);
                ad.d("MicroMsg.CropImageView", "mX=" + CropImageView.h(CropImageView.this).x + ",mY=" + CropImageView.h(CropImageView.this).y);
                if (f1 <= 0.0F) {
                  break label731;
                }
                ad.d("MicroMsg.CropImageView", "zoom in");
                CropImageView.this.zoomIn();
              }
            }
            for (;;)
            {
              CropImageView.this.HmX = CropImageView.this.HmY;
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
              label731:
              ad.d("MicroMsg.CropImageView", "zoom out");
              CropImageView.this.zoomOut();
            }
            ad.d("MicroMsg.CropImageView", "action_up");
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
    this.GbR = false;
    fdJ();
    AppMethodBeat.o(143044);
  }
  
  private void fdK()
  {
    AppMethodBeat.i(143048);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.HmW.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.HmW.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(1.0666F, 1.0666F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.rJR);
    invalidate();
    AppMethodBeat.o(143048);
  }
  
  private void fdL()
  {
    AppMethodBeat.i(143050);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.HmW.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.HmW.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(0.9375F, 0.9375F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.rJR);
    invalidate();
    AppMethodBeat.o(143050);
  }
  
  public final void fdJ()
  {
    AppMethodBeat.i(143046);
    setOnTouchListener(this.ryf);
    AppMethodBeat.o(143046);
  }
  
  public Bitmap getBmp()
  {
    return this.rJR;
  }
  
  public int getGifHeight()
  {
    AppMethodBeat.i(143053);
    if ((this.GbR) && (this.GbS != null))
    {
      i = this.GbS.getIntrinsicHeight();
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
    if ((this.GbR) && (this.GbS != null))
    {
      i = this.GbS.getIntrinsicWidth();
      AppMethodBeat.o(143052);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(143052);
    return i;
  }
  
  public int getRotateCount()
  {
    return this.dnV;
  }
  
  public void setEnableOprate(boolean paramBoolean)
  {
    this.Hnq = paramBoolean;
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(143051);
    try
    {
      this.GbR = true;
      this.GbS = c.lu(paramString, paramString);
      setImageDrawable(this.GbS);
      AppMethodBeat.o(143051);
      return;
    }
    catch (Exception paramString)
    {
      this.GbR = false;
      AppMethodBeat.o(143051);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(143045);
    this.GbR = false;
    this.rJR = paramBitmap;
    f.a(this.HmW, paramBitmap);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(143045);
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    this.HmS = paramBoolean;
  }
  
  public void setOnShortClick(a parama)
  {
    this.Hnp = parama;
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(143047);
    this.Hnh *= 1.0666F;
    if (1.0F <= this.Hnh) {
      this.Hnc = false;
    }
    if (1.6F < this.Hnh) {}
    for (this.Hnb = true; (this.HmS) && (4.0F < this.Hnh); this.Hnb = false)
    {
      this.Hnh = 4.0F;
      AppMethodBeat.o(143047);
      return;
    }
    fdK();
    AppMethodBeat.o(143047);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(143049);
    this.Hnh *= 0.9375F;
    if (1.6F > this.Hnh) {
      this.Hnb = false;
    }
    if (1.0F > this.Hnh) {}
    for (this.Hnc = true; 0.4F > this.Hnh; this.Hnc = false)
    {
      this.Hnh = 0.4F;
      AppMethodBeat.o(143049);
      return;
    }
    fdL();
    AppMethodBeat.o(143049);
  }
  
  public static abstract interface a
  {
    public abstract void fdI();
  }
  
  final class b
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(143042);
      Message localMessage = new Message();
      if ((CropImageView.p(this.Hnr)) || (CropImageView.q(this.Hnr)) || (CropImageView.r(this.Hnr)) || (CropImageView.s(this.Hnr))) {}
      for (localMessage.what = 4654;; localMessage.what = 4653)
      {
        CropImageView.t(this.Hnr).sendMessage(localMessage);
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
      ad.d("MicroMsg.CropImageView", "in timer task run");
      Message localMessage = new Message();
      if (CropImageView.j(this.Hnr)) {
        localMessage.what = 4659;
      }
      for (;;)
      {
        CropImageView.l(this.Hnr).sendMessage(localMessage);
        AppMethodBeat.o(143043);
        return;
        if (CropImageView.k(this.Hnr)) {
          localMessage.what = 4658;
        } else {
          localMessage.what = 4660;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView
 * JD-Core Version:    0.7.0.1
 */