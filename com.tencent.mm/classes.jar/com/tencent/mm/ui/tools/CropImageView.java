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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.i.b.c;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;

public class CropImageView
  extends ImageView
{
  private long KgK;
  private boolean adVH;
  private Drawable adVI;
  private boolean afEA;
  private boolean afEB;
  private boolean afEC;
  private boolean afED;
  private boolean afEE;
  private float afEF;
  private boolean afEG;
  private boolean afEH;
  d<?> afEI;
  MMHandler afEJ;
  private CropImageView.b afEK;
  MMHandler afEL;
  private a afEM;
  private boolean afEN;
  private boolean afEq;
  private boolean afEr;
  private float afEs;
  private float afEt;
  private PointF afEu;
  float afEv;
  float afEw;
  boolean afEx;
  private boolean afEy;
  private boolean afEz;
  private float cxM;
  private float cxN;
  int hOX;
  private View.OnTouchListener onTouchListener;
  private float translateX;
  private float translateY;
  Bitmap wNk;
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143044);
    this.afEq = true;
    this.afEr = false;
    this.afEu = new PointF();
    this.afEv = 0.0F;
    this.afEw = 0.0F;
    this.afEx = false;
    this.afEy = false;
    this.afEz = false;
    this.afEA = false;
    this.afEB = false;
    this.afEC = false;
    this.afED = false;
    this.afEE = false;
    this.afEF = 1.0F;
    this.translateX = 0.0F;
    this.translateY = 0.0F;
    this.afEG = false;
    this.afEH = false;
    this.afEI = null;
    this.afEJ = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143038);
        Log.d("MicroMsg.CropImageView", "on handler");
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
            if (paramAnonymousMessage.what != 4658) {
              break;
            }
            CropImageView.this.zoomOut();
          }
        } while ((paramAnonymousMessage.what == 4660) || (paramAnonymousMessage.what != 4661));
        MotionEvent localMotionEvent = (MotionEvent)paramAnonymousMessage.obj;
        CropImageView.a(CropImageView.this, System.currentTimeMillis());
        CropImageView.a(CropImageView.this, false);
        if ((localMotionEvent.getRawX() - CropImageView.a(CropImageView.this) > 10.0F) || (localMotionEvent.getRawY() - CropImageView.b(CropImageView.this) > 10.0F) || (localMotionEvent.getRawX() - CropImageView.a(CropImageView.this) < -10.0F) || (localMotionEvent.getRawY() - CropImageView.b(CropImageView.this) < -10.0F)) {}
        for (int i = 0;; i = 1)
        {
          if (i != 0)
          {
            long l = System.currentTimeMillis();
            if ((CropImageView.c(CropImageView.this) != 0L) && (l - CropImageView.c(CropImageView.this) < 300L) && (l - CropImageView.c(CropImageView.this) >= 0L) && (CropImageView.d(CropImageView.this) != null)) {
              CropImageView.d(CropImageView.this).jCW();
            }
            CropImageView.a(CropImageView.this, 0L);
          }
          g.a(CropImageView.e(CropImageView.this), CropImageView.f(CropImageView.this));
          break;
        }
      }
    };
    this.afEK = null;
    this.afEL = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143039);
        if (paramAnonymousMessage.what != 4653) {
          CropImageView.h(CropImageView.this);
        }
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(143039);
      }
    };
    this.hOX = 0;
    this.afEN = true;
    this.onTouchListener = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, final MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143041);
        if (!CropImageView.i(CropImageView.this))
        {
          AppMethodBeat.o(143041);
          return false;
        }
        if (CropImageView.f(CropImageView.this) == null)
        {
          AppMethodBeat.o(143041);
          return false;
        }
        int i = paramAnonymousMotionEvent.getAction() & 0xFF;
        Log.d("MicroMsg.CropImageView", "on touch : event type=" + i + ", isDownOnImg=" + CropImageView.j(CropImageView.this));
        if ((!CropImageView.j(CropImageView.this)) && (i != 0))
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
          Log.d("MicroMsg.CropImageView", "action_mult_down");
          CropImageView.b(CropImageView.this, true);
          CropImageView.this.afEv = g.at(paramAnonymousMotionEvent);
          if (CropImageView.this.afEv > 5.0F)
          {
            CropImageView.this.afEx = true;
            g.a(CropImageView.e(CropImageView.this), paramAnonymousMotionEvent);
            AppMethodBeat.o(143041);
            return true;
            Log.d("MicroMsg.CropImageView", "action_mult_up");
            CropImageView.this.afEx = false;
            CropImageView.b(CropImageView.this, true);
            AppMethodBeat.o(143041);
            return true;
            Log.d("MicroMsg.CropImageView", "action_down");
            CropImageView.a(CropImageView.this, paramAnonymousMotionEvent.getRawX());
            CropImageView.b(CropImageView.this, paramAnonymousMotionEvent.getRawY());
            Log.d("MicroMsg.CropImageView", "lastX=" + CropImageView.k(CropImageView.this) + ",lastY=" + CropImageView.l(CropImageView.this));
            CropImageView.c(CropImageView.this, CropImageView.k(CropImageView.this));
            CropImageView.d(CropImageView.this, CropImageView.l(CropImageView.this));
            paramAnonymousView = CropImageView.this.getImageMatrix();
            paramAnonymousMotionEvent = new RectF();
            paramAnonymousMotionEvent.set(0.0F, 0.0F, CropImageView.f(CropImageView.this).getWidth(), CropImageView.f(CropImageView.this).getHeight());
            paramAnonymousView.mapRect(paramAnonymousMotionEvent);
            CropImageView.a(CropImageView.this, paramAnonymousMotionEvent.contains(CropImageView.k(CropImageView.this), CropImageView.l(CropImageView.this)));
            CropImageView.a(CropImageView.this, System.currentTimeMillis());
            continue;
            Log.d("MicroMsg.CropImageView", "action_move");
            float f1;
            if (CropImageView.this.afEx)
            {
              Log.d("MicroMsg.CropImageView", "is valid mult down");
              CropImageView.this.afEw = g.at(paramAnonymousMotionEvent);
              f1 = CropImageView.this.afEw - CropImageView.this.afEv;
              if ((CropImageView.this.afEw > 5.0F) && (Math.abs(f1) > 5.0F))
              {
                g.a(CropImageView.e(CropImageView.this), paramAnonymousMotionEvent);
                Log.d("MicroMsg.CropImageView", "mX=" + CropImageView.e(CropImageView.this).x + ",mY=" + CropImageView.e(CropImageView.this).y);
                if (f1 <= 0.0F) {
                  break label731;
                }
                Log.d("MicroMsg.CropImageView", "zoom in");
                CropImageView.this.zoomIn();
              }
            }
            for (;;)
            {
              CropImageView.this.afEv = CropImageView.this.afEw;
              if (!CropImageView.m(CropImageView.this))
              {
                f1 = paramAnonymousMotionEvent.getRawX() - CropImageView.k(CropImageView.this);
                float f2 = paramAnonymousMotionEvent.getRawY() - CropImageView.l(CropImageView.this);
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
              Log.d("MicroMsg.CropImageView", "zoom out");
              CropImageView.this.zoomOut();
            }
            Log.d("MicroMsg.CropImageView", "action_up");
            if (CropImageView.n(CropImageView.this))
            {
              CropImageView.c(CropImageView.this, false);
              if (CropImageView.o(CropImageView.this))
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
              if (CropImageView.p(CropImageView.this) != null) {
                CropImageView.p(CropImageView.this).cancel(true);
              }
              CropImageView.a(CropImageView.this, h.ahAA.p(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(143040);
                  if (CropImageView.n(CropImageView.this))
                  {
                    Message localMessage = new Message();
                    localMessage.what = 4661;
                    localMessage.obj = paramAnonymousMotionEvent;
                    CropImageView.g(CropImageView.this).sendMessage(localMessage);
                    CropImageView.c(CropImageView.this, false);
                  }
                  AppMethodBeat.o(143040);
                }
              }, 200L));
            }
          }
        }
      }
    };
    this.adVH = false;
    jCX();
    AppMethodBeat.o(143044);
  }
  
  private void jCY()
  {
    AppMethodBeat.i(143048);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.afEu.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.afEu.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(1.0666F, 1.0666F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.wNk);
    invalidate();
    AppMethodBeat.o(143048);
  }
  
  private void jCZ()
  {
    AppMethodBeat.i(143050);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.afEu.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.afEu.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(0.9375F, 0.9375F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.wNk);
    invalidate();
    AppMethodBeat.o(143050);
  }
  
  public Bitmap getBmp()
  {
    return this.wNk;
  }
  
  public int getGifHeight()
  {
    AppMethodBeat.i(143053);
    if ((this.adVH) && (this.adVI != null))
    {
      i = this.adVI.getIntrinsicHeight();
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
    if ((this.adVH) && (this.adVI != null))
    {
      i = this.adVI.getIntrinsicWidth();
      AppMethodBeat.o(143052);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(143052);
    return i;
  }
  
  public int getRotateCount()
  {
    return this.hOX;
  }
  
  public final void jCX()
  {
    AppMethodBeat.i(143046);
    setOnTouchListener(this.onTouchListener);
    AppMethodBeat.o(143046);
  }
  
  public void setEnableOprate(boolean paramBoolean)
  {
    this.afEN = paramBoolean;
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(143051);
    try
    {
      this.adVH = true;
      this.adVI = c.qd(paramString, paramString);
      setImageDrawable(this.adVI);
      AppMethodBeat.o(143051);
      return;
    }
    catch (Exception paramString)
    {
      this.adVH = false;
      AppMethodBeat.o(143051);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(143045);
    this.adVH = false;
    this.wNk = paramBitmap;
    g.a(this.afEu, paramBitmap);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(143045);
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    this.afEq = paramBoolean;
  }
  
  public void setOnShortClick(a parama)
  {
    this.afEM = parama;
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(143047);
    this.afEF *= 1.0666F;
    if (1.0F <= this.afEF) {
      this.afEA = false;
    }
    if (1.6F < this.afEF) {}
    for (this.afEz = true; (this.afEq) && (4.0F < this.afEF); this.afEz = false)
    {
      this.afEF = 4.0F;
      AppMethodBeat.o(143047);
      return;
    }
    jCY();
    AppMethodBeat.o(143047);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(143049);
    this.afEF *= 0.9375F;
    if (1.6F > this.afEF) {
      this.afEz = false;
    }
    if (1.0F > this.afEF) {}
    for (this.afEA = true; 0.4F > this.afEF; this.afEA = false)
    {
      this.afEF = 0.4F;
      AppMethodBeat.o(143049);
      return;
    }
    jCZ();
    AppMethodBeat.o(143049);
  }
  
  public static abstract interface a
  {
    public abstract void jCW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView
 * JD-Core Version:    0.7.0.1
 */