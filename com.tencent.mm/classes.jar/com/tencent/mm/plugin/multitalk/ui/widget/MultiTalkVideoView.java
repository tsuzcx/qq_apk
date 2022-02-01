package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.model.ab;
import com.tencent.mm.plugin.multitalk.model.ab.a;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.b.p;

public class MultiTalkVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener, f
{
  private static final int[] wwJ = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private String bVF;
  private aw cji;
  private TextPaint iU;
  private int index;
  public int mId;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private Paint pgf;
  private int pgg;
  private boolean pgh;
  private boolean pgi;
  private int position;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  private String text;
  private String username;
  private com.tencent.mm.ui.base.o wwK;
  private MultiTalkVideoView.b wwL;
  private boolean wwM;
  a wwN;
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(114762);
    this.wwL = MultiTalkVideoView.b.wwW;
    if ((j.IS_FLAVOR_RED) || (bv.fpT())) {}
    for (boolean bool = true;; bool = false)
    {
      this.pgh = bool;
      this.iU = null;
      this.text = "";
      this.pgi = false;
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.pgg = 0;
      this.mId = -1;
      this.wwM = false;
      this.wwN = new a();
      initView();
      AppMethodBeat.o(114762);
      return;
    }
  }
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(114763);
    this.wwL = MultiTalkVideoView.b.wwW;
    if ((j.IS_FLAVOR_RED) || (bv.fpT())) {}
    for (boolean bool = true;; bool = false)
    {
      this.pgh = bool;
      this.iU = null;
      this.text = "";
      this.pgi = false;
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.pgg = 0;
      this.mId = -1;
      this.wwM = false;
      this.wwN = new a();
      initView();
      AppMethodBeat.o(114763);
      return;
    }
  }
  
  private void aUH()
  {
    AppMethodBeat.i(178947);
    if (this.pgi)
    {
      AppMethodBeat.o(178947);
      return;
    }
    this.pgi = true;
    this.cji = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(190837);
        h.MqF.aM(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(190836);
            MultiTalkVideoView.c(MultiTalkVideoView.this);
            AppMethodBeat.o(190836);
          }
        });
        AppMethodBeat.o(190837);
        return true;
      }
    }, true);
    this.cji.ay(1000L, 1000L);
    AppMethodBeat.o(178947);
  }
  
  private static Matrix c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(190838);
    Matrix localMatrix = new Matrix();
    if ((paramInt5 == OpenGlRender.FLAG_Angle270) || (paramInt5 == 270))
    {
      localMatrix.postTranslate(-paramInt3 / 2.0F, -paramInt4 / 2.0F);
      localMatrix.postRotate(270.0F);
      localMatrix.postTranslate(paramInt4 / 2.0F, paramInt3 / 2.0F);
    }
    for (;;)
    {
      if (paramInt6 == OpenGlRender.FLAG_Mirror)
      {
        localMatrix.postScale(-1.0F, 1.0F);
        localMatrix.postTranslate(paramInt4, 0.0F);
      }
      float f1 = paramInt2 / paramInt1;
      float f2 = paramInt3 / paramInt4;
      if (f1 < f2)
      {
        f1 = paramInt2 / paramInt3;
        localMatrix.postScale(f1, f1);
        localMatrix.postTranslate((paramInt1 - f1 * paramInt4) / 2.0F, 0.0F);
      }
      for (;;)
      {
        AppMethodBeat.o(190838);
        return localMatrix;
        if ((paramInt5 != OpenGlRender.FLAG_Angle90) && (paramInt5 != 90)) {
          break label278;
        }
        localMatrix.postTranslate(-paramInt3 / 2.0F, -paramInt4 / 2.0F);
        localMatrix.postRotate(90.0F);
        localMatrix.postTranslate(paramInt4 / 2.0F, paramInt3 / 2.0F);
        break;
        if (f1 > f2)
        {
          f1 = paramInt1 / paramInt4;
          localMatrix.postScale(f1, f1);
          localMatrix.postTranslate(0.0F, (paramInt2 - paramInt3 * f1) / 2.0F);
        }
        else
        {
          localMatrix.postScale(paramInt1 / paramInt4, paramInt2 / paramInt3);
        }
      }
      label278:
      paramInt5 = paramInt3;
      paramInt3 = paramInt4;
      paramInt4 = paramInt5;
    }
  }
  
  private void dug()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114771);
        if ((this.surfaceTexture == null) || (this.surfaceWidth == 0) || (this.surfaceHeight == 0))
        {
          AppMethodBeat.o(114771);
          return;
        }
        Canvas localCanvas1 = lockCanvas(null);
        if (localCanvas1 == null)
        {
          ae.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
          AppMethodBeat.o(114771);
          continue;
        }
        localCanvas2.drawColor(0, PorterDuff.Mode.CLEAR);
      }
      finally {}
      if (this.pgh) {
        localCanvas2.drawColor(-65536);
      }
      this.text = "drawing none";
      try
      {
        unlockCanvasAndPost(localCanvas2);
        AppMethodBeat.o(114771);
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", localException, "drawNone unlockCanvasAndPost crash", new Object[0]);
        AppMethodBeat.o(114771);
      }
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(114764);
    this.pgf = new Paint();
    this.pgf.setColor(-16777216);
    this.pgf.setFilterBitmap(false);
    this.pgf.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    if (this.pgh)
    {
      this.pgg = 0;
      this.iU = new TextPaint();
      this.iU.setColor(-65536);
      this.iU.setTextSize(25.0F);
      this.iU.setAntiAlias(true);
      this.pgi = false;
      aUH();
      this.wwM = z.dtK().dsX();
      this.text = ("isILink: " + this.wwM);
    }
    AppMethodBeat.o(114764);
  }
  
  public final void a(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(190839);
    Matrix localMatrix = c(paramCanvas.getWidth(), paramCanvas.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2);
    if (!paramBoolean) {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }
    if (!paramBitmap.isRecycled()) {}
    try
    {
      paramCanvas.drawBitmap(paramBitmap, localMatrix, this.pgf);
      if (!paramBoolean)
      {
        this.wwN.wwQ = paramBitmap.copy(Bitmap.Config.ARGB_8888, false);
        this.wwN.wwR = paramInt1;
        this.wwN.wwS = paramInt2;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        try
        {
          new StaticLayout(this.text, this.iU, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw(paramCanvas);
          AppMethodBeat.o(190839);
          return;
        }
        catch (Exception paramCanvas)
        {
          ae.i("MicroMsg.MT.MultiTalkVideoView", "draw debug error");
        }
        paramBitmap = paramBitmap;
        ae.e("MicroMsg.MT.MultiTalkVideoView", "draw bitmap error");
      }
      AppMethodBeat.o(190839);
    }
    if ((this.pgh) && (!paramBoolean)) {
      this.pgg += 1;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(178948);
    if ((parama != null) && (parama.wwQ != null) && (!parama.wwQ.isRecycled()))
    {
      e(parama.wwQ, parama.wwR, parama.wwS);
      AppMethodBeat.o(178948);
      return;
    }
    dug();
    AppMethodBeat.o(178948);
  }
  
  public final void dua()
  {
    AppMethodBeat.i(114767);
    if (duh()) {
      z.dtK().dte().a(this, getMeasuredWidth(), getMeasuredHeight());
    }
    AppMethodBeat.o(114767);
  }
  
  public final void dub()
  {
    AppMethodBeat.i(114768);
    if (bu.isNullOrNil(getUsername()))
    {
      AppMethodBeat.o(114768);
      return;
    }
    due();
    ae.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[] { getUsername(), this.wwL.name() });
    this.wwL = MultiTalkVideoView.b.wwT;
    dua();
    AppMethodBeat.o(114768);
  }
  
  public final void duc()
  {
    AppMethodBeat.i(114769);
    due();
    ae.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[] { getUsername(), this.wwL.name() });
    this.wwL = MultiTalkVideoView.b.wwU;
    a(this.wwN);
    AppMethodBeat.o(114769);
  }
  
  public final void dud()
  {
    AppMethodBeat.i(190841);
    ay localay = ay.aRW("multi_talk_config");
    if ((!localay.getBoolean("has_opened_screen_cast", false)) && (!localay.getBoolean("has_showed_tip_window", false)))
    {
      if (this.wwK == null) {
        this.wwK = new com.tencent.mm.ui.base.o(((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131496415, null, false), -2, -2);
      }
      if (!this.wwK.isShowing())
      {
        View localView = this.wwK.getContentView();
        localView.measure(0, 0);
        int i = (getWidth() - localView.getMeasuredWidth()) / 2;
        int[] arrayOfInt = new int[2];
        getLocationInWindow(arrayOfInt);
        this.wwK.showAtLocation(this, 0, i + arrayOfInt[0], arrayOfInt[1] - localView.getMeasuredHeight() + 15);
        localay.putBoolean("has_showed_tip_window", true);
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114757);
            if (MultiTalkVideoView.a(MultiTalkVideoView.this) != null)
            {
              MultiTalkVideoView.a(MultiTalkVideoView.this).dismiss();
              MultiTalkVideoView.b(MultiTalkVideoView.this);
            }
            AppMethodBeat.o(114757);
          }
        }, 3000L);
      }
    }
    this.wwL = MultiTalkVideoView.b.wwV;
    dug();
    this.wwN.wwQ = null;
    AppMethodBeat.o(190841);
  }
  
  public final void due()
  {
    AppMethodBeat.i(190842);
    if ((this.wwK != null) && (this.wwK.isShowing()))
    {
      this.wwK.dismiss();
      this.wwK = null;
    }
    AppMethodBeat.o(190842);
  }
  
  public final void duf()
  {
    AppMethodBeat.i(114770);
    if ((this.wwK != null) && (this.wwK.isShowing())) {
      this.wwK.dismiss();
    }
    ae.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[] { getUsername(), this.wwL.name() });
    this.wwL = MultiTalkVideoView.b.wwW;
    ez("", -1);
    dug();
    AppMethodBeat.o(114770);
  }
  
  public final boolean duh()
  {
    return this.wwL == MultiTalkVideoView.b.wwT;
  }
  
  public final boolean dui()
  {
    return this.wwL == MultiTalkVideoView.b.wwU;
  }
  
  public final boolean duj()
  {
    return this.wwL == MultiTalkVideoView.b.wwV;
  }
  
  public final void e(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(114766);
        if ((paramBitmap == null) || (paramBitmap.isRecycled()))
        {
          ae.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
          n.dsF();
          AppMethodBeat.o(114766);
          return;
        }
        int i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if ((this.surfaceTexture == null) || (this.surfaceWidth == 0) || (this.surfaceHeight == 0) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0))
        {
          AppMethodBeat.o(114766);
          continue;
        }
        this.mVideoWidth = i;
      }
      finally {}
      this.mVideoHeight = j;
      Canvas localCanvas = lockCanvas(null);
      if (localCanvas == null)
      {
        ae.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[] { this.username });
        AppMethodBeat.o(114766);
      }
      else
      {
        a(localCanvas, paramBitmap, paramInt1, paramInt2, false);
        try
        {
          unlockCanvasAndPost(localCanvas);
          AppMethodBeat.o(114766);
        }
        catch (Exception paramBitmap)
        {
          n.dsF();
          ae.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
          AppMethodBeat.o(114766);
        }
      }
    }
  }
  
  public final void ez(String paramString, int paramInt)
  {
    AppMethodBeat.i(178946);
    ae.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[] { this.username, paramString });
    this.username = paramString;
    an localan = ((l)g.ab(l.class)).azF().BH(paramString);
    if (localan != null) {}
    for (this.bVF = localan.adF();; this.bVF = paramString)
    {
      this.mId = paramInt;
      AppMethodBeat.o(178946);
      return;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(190840);
    setSurfaceTextureListener(null);
    AppMethodBeat.o(190840);
  }
  
  public a getCurrentSnapShot()
  {
    return this.wwN;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getNickName()
  {
    return this.bVF;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(114774);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ae.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureAvailable %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceTexture = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    fDh();
    this.mSurface = new Surface(paramSurfaceTexture);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114758);
        MultiTalkVideoView.this.refreshView();
        AppMethodBeat.o(114758);
      }
    });
    AppMethodBeat.o(114774);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(114776);
    String str = this.username;
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureDestroyed %s %b", new Object[] { str, Boolean.valueOf(bool) });
      this.surfaceTexture = null;
      this.surfaceHeight = 0;
      this.surfaceWidth = 0;
      if (this.cji != null)
      {
        this.cji.stopTimer();
        this.cji = null;
      }
      AppMethodBeat.o(114776);
      return false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(114775);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ae.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190835);
        MultiTalkVideoView.this.refreshView();
        AppMethodBeat.o(190835);
      }
    });
    AppMethodBeat.o(114775);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = false;
    AppMethodBeat.i(114777);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ae.v("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureUpdated %s %b", new Object[] { str, Boolean.valueOf(bool) });
    this.mSurface = null;
    AppMethodBeat.o(114777);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(114773);
    if (duh())
    {
      z.dtK().dte().a(this, getMeasuredWidth(), getMeasuredHeight());
      AppMethodBeat.o(114773);
      return;
    }
    if (dui())
    {
      Object localObject = z.dtK().dte();
      p.h(this, "target");
      localObject = ((ab)localObject).asQ(getUsername());
      Bitmap localBitmap = ((ab.a)localObject).wsX;
      if (localBitmap != null)
      {
        e(localBitmap, ((ab.a)localObject).angle, ((ab.a)localObject).mirror);
        AppMethodBeat.o(114773);
        return;
      }
      AppMethodBeat.o(114773);
      return;
    }
    dug();
    AppMethodBeat.o(114773);
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public final class a
  {
    Bitmap wwQ;
    int wwR;
    int wwS;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView
 * JD-Core Version:    0.7.0.1
 */