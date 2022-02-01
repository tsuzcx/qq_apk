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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.model.ab;
import com.tencent.mm.plugin.multitalk.model.ab.a;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.b.p;

public class MultiTalkVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener, f
{
  private static final int[] whg = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private String bVF;
  private av cjg;
  private TextPaint iU;
  private int index;
  public int mId;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private Paint oZB;
  private int oZC;
  private boolean oZD;
  private boolean oZE;
  private int position;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  private String text;
  private String username;
  private com.tencent.mm.ui.base.o whh;
  private MultiTalkVideoView.b whi;
  a whj;
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(114762);
    this.whi = MultiTalkVideoView.b.whs;
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (bu.flY())) {}
    for (boolean bool = true;; bool = false)
    {
      this.oZD = bool;
      this.iU = null;
      this.text = "";
      this.oZE = false;
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.oZC = 0;
      this.mId = -1;
      this.whj = new a();
      initView();
      AppMethodBeat.o(114762);
      return;
    }
  }
  
  public MultiTalkVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(114763);
    this.whi = MultiTalkVideoView.b.whs;
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (bu.flY())) {}
    for (boolean bool = true;; bool = false)
    {
      this.oZD = bool;
      this.iU = null;
      this.text = "";
      this.oZE = false;
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.oZC = 0;
      this.mId = -1;
      this.whj = new a();
      initView();
      AppMethodBeat.o(114763);
      return;
    }
  }
  
  private void aUi()
  {
    AppMethodBeat.i(178947);
    if (this.oZE)
    {
      AppMethodBeat.o(178947);
      return;
    }
    this.oZE = true;
    this.cjg = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(206605);
        h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206604);
            MultiTalkVideoView.c(MultiTalkVideoView.this);
            AppMethodBeat.o(206604);
          }
        });
        AppMethodBeat.o(206605);
        return true;
      }
    }, true);
    this.cjg.az(1000L, 1000L);
    AppMethodBeat.o(178947);
  }
  
  private static Matrix c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(206606);
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
        AppMethodBeat.o(206606);
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
  
  private void dqU()
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
          ad.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
          AppMethodBeat.o(114771);
          continue;
        }
        localCanvas2.drawColor(0, PorterDuff.Mode.CLEAR);
      }
      finally {}
      if (this.oZD) {
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
        ad.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", localException, "drawNone unlockCanvasAndPost crash", new Object[0]);
        AppMethodBeat.o(114771);
      }
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(114764);
    this.oZB = new Paint();
    this.oZB.setColor(-16777216);
    this.oZB.setFilterBitmap(false);
    this.oZB.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    if (this.oZD)
    {
      this.oZC = 0;
      this.iU = new TextPaint();
      this.iU.setColor(-65536);
      this.iU.setTextSize(25.0F);
      this.iU.setAntiAlias(true);
      this.oZE = false;
      this.text = "debug...";
      aUi();
    }
    AppMethodBeat.o(114764);
  }
  
  public final void a(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(206607);
    Matrix localMatrix = c(paramCanvas.getWidth(), paramCanvas.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2);
    if (!paramBoolean) {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }
    if (!paramBitmap.isRecycled()) {}
    try
    {
      paramCanvas.drawBitmap(paramBitmap, localMatrix, this.oZB);
      if (!paramBoolean)
      {
        this.whj.whm = paramBitmap.copy(Bitmap.Config.ARGB_8888, false);
        this.whj.whn = paramInt1;
        this.whj.who = paramInt2;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        try
        {
          new StaticLayout(this.text, this.iU, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw(paramCanvas);
          AppMethodBeat.o(206607);
          return;
        }
        catch (Exception paramCanvas)
        {
          ad.i("MicroMsg.MT.MultiTalkVideoView", "draw debug error");
        }
        paramBitmap = paramBitmap;
        ad.e("MicroMsg.MT.MultiTalkVideoView", "draw bitmap error");
      }
      AppMethodBeat.o(206607);
    }
    if ((this.oZD) && (!paramBoolean)) {
      this.oZC += 1;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(178948);
    if ((parama != null) && (parama.whm != null) && (!parama.whm.isRecycled()))
    {
      e(parama.whm, parama.whn, parama.who);
      AppMethodBeat.o(178948);
      return;
    }
    dqU();
    AppMethodBeat.o(178948);
  }
  
  public final void dqO()
  {
    AppMethodBeat.i(114767);
    if (dqV()) {
      z.dqx().dpS().a(this, getMeasuredWidth(), getMeasuredHeight());
    }
    AppMethodBeat.o(114767);
  }
  
  public final void dqP()
  {
    AppMethodBeat.i(114768);
    if (bt.isNullOrNil(getUsername()))
    {
      AppMethodBeat.o(114768);
      return;
    }
    dqS();
    ad.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[] { getUsername(), this.whi.name() });
    this.whi = MultiTalkVideoView.b.whp;
    dqO();
    AppMethodBeat.o(114768);
  }
  
  public final void dqQ()
  {
    AppMethodBeat.i(114769);
    dqS();
    ad.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[] { getUsername(), this.whi.name() });
    this.whi = MultiTalkVideoView.b.whq;
    a(this.whj);
    AppMethodBeat.o(114769);
  }
  
  public final void dqR()
  {
    AppMethodBeat.i(206609);
    ax localax = ax.aQz("multi_talk_config");
    if ((!localax.getBoolean("has_opened_screen_cast", false)) && (!localax.getBoolean("has_showed_tip_window", false)))
    {
      if (this.whh == null) {
        this.whh = new com.tencent.mm.ui.base.o(((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131496415, null, false), -2, -2);
      }
      if (!this.whh.isShowing())
      {
        View localView = this.whh.getContentView();
        localView.measure(0, 0);
        int i = (getWidth() - localView.getMeasuredWidth()) / 2;
        int[] arrayOfInt = new int[2];
        getLocationInWindow(arrayOfInt);
        this.whh.showAtLocation(this, 0, i + arrayOfInt[0], arrayOfInt[1] - localView.getMeasuredHeight() + 15);
        localax.putBoolean("has_showed_tip_window", true);
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
    this.whi = MultiTalkVideoView.b.whr;
    dqU();
    this.whj.whm = null;
    AppMethodBeat.o(206609);
  }
  
  public final void dqS()
  {
    AppMethodBeat.i(206610);
    if ((this.whh != null) && (this.whh.isShowing()))
    {
      this.whh.dismiss();
      this.whh = null;
    }
    AppMethodBeat.o(206610);
  }
  
  public final void dqT()
  {
    AppMethodBeat.i(114770);
    if ((this.whh != null) && (this.whh.isShowing())) {
      this.whh.dismiss();
    }
    ad.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[] { getUsername(), this.whi.name() });
    this.whi = MultiTalkVideoView.b.whs;
    er("", -1);
    dqU();
    AppMethodBeat.o(114770);
  }
  
  public final boolean dqV()
  {
    return this.whi == MultiTalkVideoView.b.whp;
  }
  
  public final boolean dqW()
  {
    return this.whi == MultiTalkVideoView.b.whq;
  }
  
  public final boolean dqX()
  {
    return this.whi == MultiTalkVideoView.b.whr;
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
          ad.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
          n.dpu();
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
        ad.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[] { this.username });
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
          n.dpu();
          ad.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
          AppMethodBeat.o(114766);
        }
      }
    }
  }
  
  public final void er(String paramString, int paramInt)
  {
    AppMethodBeat.i(178946);
    ad.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[] { this.username, paramString });
    this.username = paramString;
    am localam = ((l)g.ab(l.class)).azp().Bf(paramString);
    if (localam != null) {}
    for (this.bVF = localam.adu();; this.bVF = paramString)
    {
      this.mId = paramInt;
      AppMethodBeat.o(178946);
      return;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(206608);
    setSurfaceTextureListener(null);
    AppMethodBeat.o(206608);
  }
  
  public a getCurrentSnapShot()
  {
    return this.whj;
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
    ad.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureAvailable %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceTexture = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    fzf();
    this.mSurface = new Surface(paramSurfaceTexture);
    aq.f(new Runnable()
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
      ad.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureDestroyed %s %b", new Object[] { str, Boolean.valueOf(bool) });
      this.surfaceTexture = null;
      this.surfaceHeight = 0;
      this.surfaceWidth = 0;
      if (this.cjg != null)
      {
        this.cjg.stopTimer();
        this.cjg = null;
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
    ad.i("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206603);
        MultiTalkVideoView.this.refreshView();
        AppMethodBeat.o(206603);
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
    ad.v("MicroMsg.MT.MultiTalkVideoView", "onSurfaceTextureUpdated %s %b", new Object[] { str, Boolean.valueOf(bool) });
    this.mSurface = null;
    AppMethodBeat.o(114777);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(114773);
    if (dqV())
    {
      z.dqx().dpS().a(this, getMeasuredWidth(), getMeasuredHeight());
      AppMethodBeat.o(114773);
      return;
    }
    if (dqW())
    {
      Object localObject = z.dqx().dpS();
      p.h(this, "target");
      localObject = ((ab)localObject).arE(getUsername());
      Bitmap localBitmap = ((ab.a)localObject).wdv;
      if (localBitmap != null)
      {
        e(localBitmap, ((ab.a)localObject).angle, ((ab.a)localObject).mirror);
        AppMethodBeat.o(114773);
        return;
      }
      AppMethodBeat.o(114773);
      return;
    }
    dqU();
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
    Bitmap whm;
    int whn;
    int who;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView
 * JD-Core Version:    0.7.0.1
 */