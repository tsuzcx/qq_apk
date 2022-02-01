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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.h.b.c;

public class CropImageView
  extends ImageView
{
  private long Eoe;
  private boolean Wos;
  private Drawable Wot;
  private boolean XOc;
  private boolean XOd;
  private float XOe;
  private float XOf;
  private PointF XOg;
  float XOh;
  float XOi;
  boolean XOj;
  private boolean XOk;
  private boolean XOl;
  private boolean XOm;
  private boolean XOn;
  private boolean XOo;
  private boolean XOp;
  private boolean XOq;
  private float XOr;
  private boolean XOs;
  private boolean XOt;
  d<?> XOu;
  MMHandler XOv;
  private CropImageView.b XOw;
  MMHandler XOx;
  private a XOy;
  private boolean XOz;
  private float aCa;
  private float aCb;
  private View.OnTouchListener aIw;
  int fJu;
  Bitmap tJN;
  private float translateX;
  private float translateY;
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143044);
    this.XOc = true;
    this.XOd = false;
    this.XOg = new PointF();
    this.XOh = 0.0F;
    this.XOi = 0.0F;
    this.XOj = false;
    this.XOk = false;
    this.XOl = false;
    this.XOm = false;
    this.XOn = false;
    this.XOo = false;
    this.XOp = false;
    this.XOq = false;
    this.XOr = 1.0F;
    this.translateX = 0.0F;
    this.translateY = 0.0F;
    this.XOs = false;
    this.XOt = false;
    this.XOu = null;
    this.XOv = new MMHandler()
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
              CropImageView.d(CropImageView.this).hYm();
            }
            CropImageView.a(CropImageView.this, 0L);
          }
          f.a(CropImageView.e(CropImageView.this), CropImageView.f(CropImageView.this));
          break;
        }
      }
    };
    this.XOw = null;
    this.XOx = new MMHandler()
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
    this.fJu = 0;
    this.XOz = true;
    this.aIw = new View.OnTouchListener()
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
          CropImageView.this.XOh = f.aq(paramAnonymousMotionEvent);
          if (CropImageView.this.XOh > 5.0F)
          {
            CropImageView.this.XOj = true;
            f.a(CropImageView.e(CropImageView.this), paramAnonymousMotionEvent);
            AppMethodBeat.o(143041);
            return true;
            Log.d("MicroMsg.CropImageView", "action_mult_up");
            CropImageView.this.XOj = false;
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
            if (CropImageView.this.XOj)
            {
              Log.d("MicroMsg.CropImageView", "is valid mult down");
              CropImageView.this.XOi = f.aq(paramAnonymousMotionEvent);
              f1 = CropImageView.this.XOi - CropImageView.this.XOh;
              if ((CropImageView.this.XOi > 5.0F) && (Math.abs(f1) > 5.0F))
              {
                f.a(CropImageView.e(CropImageView.this), paramAnonymousMotionEvent);
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
              CropImageView.this.XOh = CropImageView.this.XOi;
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
              CropImageView.a(CropImageView.this, h.ZvG.o(new Runnable()
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
    this.Wos = false;
    hYn();
    AppMethodBeat.o(143044);
  }
  
  private void hYo()
  {
    AppMethodBeat.i(143048);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.XOg.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.XOg.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(1.0666F, 1.0666F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.tJN);
    invalidate();
    AppMethodBeat.o(143048);
  }
  
  private void hYp()
  {
    AppMethodBeat.i(143050);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.XOg.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.XOg.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(0.9375F, 0.9375F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.tJN);
    invalidate();
    AppMethodBeat.o(143050);
  }
  
  public Bitmap getBmp()
  {
    return this.tJN;
  }
  
  public int getGifHeight()
  {
    AppMethodBeat.i(143053);
    if ((this.Wos) && (this.Wot != null))
    {
      i = this.Wot.getIntrinsicHeight();
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
    if ((this.Wos) && (this.Wot != null))
    {
      i = this.Wot.getIntrinsicWidth();
      AppMethodBeat.o(143052);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(143052);
    return i;
  }
  
  public int getRotateCount()
  {
    return this.fJu;
  }
  
  public final void hYn()
  {
    AppMethodBeat.i(143046);
    setOnTouchListener(this.aIw);
    AppMethodBeat.o(143046);
  }
  
  public void setEnableOprate(boolean paramBoolean)
  {
    this.XOz = paramBoolean;
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(143051);
    try
    {
      this.Wos = true;
      this.Wot = c.of(paramString, paramString);
      setImageDrawable(this.Wot);
      AppMethodBeat.o(143051);
      return;
    }
    catch (Exception paramString)
    {
      this.Wos = false;
      AppMethodBeat.o(143051);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(143045);
    this.Wos = false;
    this.tJN = paramBitmap;
    f.a(this.XOg, paramBitmap);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(143045);
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    this.XOc = paramBoolean;
  }
  
  public void setOnShortClick(a parama)
  {
    this.XOy = parama;
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(143047);
    this.XOr *= 1.0666F;
    if (1.0F <= this.XOr) {
      this.XOm = false;
    }
    if (1.6F < this.XOr) {}
    for (this.XOl = true; (this.XOc) && (4.0F < this.XOr); this.XOl = false)
    {
      this.XOr = 4.0F;
      AppMethodBeat.o(143047);
      return;
    }
    hYo();
    AppMethodBeat.o(143047);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(143049);
    this.XOr *= 0.9375F;
    if (1.6F > this.XOr) {
      this.XOl = false;
    }
    if (1.0F > this.XOr) {}
    for (this.XOm = true; 0.4F > this.XOr; this.XOm = false)
    {
      this.XOr = 0.4F;
      AppMethodBeat.o(143049);
      return;
    }
    hYp();
    AppMethodBeat.o(143049);
  }
  
  public static abstract interface a
  {
    public abstract void hYm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView
 * JD-Core Version:    0.7.0.1
 */