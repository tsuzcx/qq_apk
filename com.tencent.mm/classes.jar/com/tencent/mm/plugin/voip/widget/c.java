package com.tencent.mm.plugin.voip.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import com.tencent.mm.plugin.voip.video.GLTextureView.i;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlRender.b;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;

public final class c
  extends BaseSmallView
{
  private TextView BgP;
  private boolean ECo;
  private int GUK;
  private int GUL;
  private int HdK;
  private int HiE;
  boolean HpO;
  RelativeLayout HpP;
  boolean HpQ;
  private Runnable HpR;
  private OpenGlRender Hqi;
  OpenGlView Hqj;
  private OpenGlRender Hqk;
  OpenGlView Hql;
  private int[] Hqm;
  private int Hqn;
  private int Hqo;
  ImageView gBZ;
  private IListener hvF;
  private boolean mIsStarted;
  private int mStatus;
  private float radius;
  public com.tencent.mm.plugin.voip.ui.a zTN;
  TextView zTe;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(235973);
    this.Hqm = null;
    this.Hqn = 0;
    this.mStatus = -1;
    this.Hqo = 0;
    this.HiE = 0;
    this.zTN = null;
    this.GUK = 0;
    this.GUL = 0;
    this.ECo = false;
    this.radius = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.HpQ = false;
    this.HpR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115758);
        c localc = c.this;
        if ((!localc.HpO) && (localc.HpQ))
        {
          localc.HpO = true;
          localc.HpQ = false;
          localc.Hqj.setVisibility(0);
          localc.Hqj.setAlpha(0.0F);
          localc.Hqj.animate().alpha(1.0F).setDuration(500L).start();
          localc.Hql.setAlpha(1.0F);
          localc.Hql.animate().alpha(0.0F).setDuration(500L).setListener(new c.5(localc)).start();
        }
        AppMethodBeat.o(115758);
      }
    };
    this.hvF = new c.2(this);
    LayoutInflater.from(paramContext).inflate(2131496867, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.HpP = ((RelativeLayout)findViewById(2131310040));
    this.HpP.setVisibility(4);
    this.gBZ = ((ImageView)findViewById(2131310038));
    this.zTe = ((TextView)findViewById(2131310039));
    this.Hqj = ((OpenGlView)findViewById(2131305591));
    this.Hqi = new OpenGlRender(this.Hqj, OpenGlRender.RenderRemote);
    this.BgP = ((TextView)findViewById(2131309163));
    this.BgP.setTextSize(1, 12.0F);
    this.Hqj.setRenderer(this.Hqi);
    this.Hqj.setRenderMode(0);
    this.Hqj.setClipToOutline(true);
    this.Hqj.setOutlineProvider(new e(this.radius));
    this.Hqi.HiQ = new OpenGlRender.b()
    {
      public final void Lj(long paramAnonymousLong)
      {
        AppMethodBeat.i(235964);
        if ((c.this.Hen != null) && (c.this.Hen.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.Hen.get()).ah(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(235964);
      }
      
      public final void Lk(long paramAnonymousLong)
      {
        AppMethodBeat.i(235965);
        if ((c.this.Hen != null) && (c.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.Hen.get()).ah(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(235965);
      }
      
      public final void Ll(long paramAnonymousLong)
      {
        AppMethodBeat.i(235966);
        if ((c.this.Hen != null) && (c.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.Hen.get()).ah(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(235966);
      }
      
      public final void fJD()
      {
        AppMethodBeat.i(235963);
        if ((c.this.Hen != null) && (c.this.Hen.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.Hen.get()).ah(0L, 3);
        }
        AppMethodBeat.o(235963);
      }
    };
    this.Hqj.xv(true);
    this.Hql = ((OpenGlView)findViewById(2131305590));
    this.Hqk = new OpenGlRender(this.Hql, OpenGlRender.RenderLocal);
    this.Hql.setClipToOutline(true);
    this.Hql.setOutlineProvider(new e(this.radius));
    this.Hqk.HiQ = new OpenGlRender.b()
    {
      public final void Lj(long paramAnonymousLong)
      {
        AppMethodBeat.i(235968);
        if ((c.this.Hen != null) && (c.this.Hen.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.Hen.get()).ah(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(235968);
      }
      
      public final void Lk(long paramAnonymousLong)
      {
        AppMethodBeat.i(235969);
        if ((c.this.Hen != null) && (c.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.Hen.get()).ah(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(235969);
      }
      
      public final void Ll(long paramAnonymousLong)
      {
        AppMethodBeat.i(235970);
        if ((c.this.Hen != null) && (c.this.Hen.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.Hen.get()).ah(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(235970);
      }
      
      public final void fJD()
      {
        AppMethodBeat.i(235967);
        if ((c.this.Hen != null) && (c.this.Hen.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.Hen.get()).ah(0L, 3);
        }
        AppMethodBeat.o(235967);
      }
    };
    this.Hql.setVisibility(0);
    this.Hql.setRenderer(this.Hqk);
    this.Hql.setRenderMode(0);
    this.mIsStarted = false;
    this.HpO = false;
    EventCenter.instance.addListener(this.hvF);
    setContentDescription(paramContext.getString(2131757548));
    AppMethodBeat.o(235973);
  }
  
  private void fMg()
  {
    AppMethodBeat.i(184100);
    this.BgP.setVisibility(8);
    AppMethodBeat.o(184100);
  }
  
  private void fMm()
  {
    AppMethodBeat.i(115765);
    if (!this.mIsStarted)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", new Object[] { Integer.valueOf(this.Hqo) });
      this.mIsStarted = true;
      this.Hqi.onStarted();
      this.Hqk.onStarted();
      this.Hqk.setVoipBeauty(this.Hqo);
      this.Hqi.setVoipBeauty(this.Hqo);
      this.Hqk.setSpatiotemporalDenosing(this.HiE);
      this.Hqi.setSpatiotemporalDenosing(this.HiE);
      if ((this.GUK != 0) && (this.GUL != 0)) {
        jA(this.GUK, this.GUL);
      }
    }
    AppMethodBeat.o(115765);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    AppMethodBeat.i(115767);
    if ((this.Hqk == null) || (this.Hqi == null))
    {
      AppMethodBeat.o(115767);
      return;
    }
    fMm();
    this.surfaceTexture = paramSurfaceTexture;
    this.GgP = paramd;
    this.Hqk.a(this.surfaceTexture, this.GgP);
    this.Hqi.a(this.surfaceTexture, this.GgP);
    AppMethodBeat.o(115767);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(115774);
    if (8 == this.Hql.getVisibility())
    {
      AppMethodBeat.o(115774);
      return;
    }
    fMm();
    if (OpenGlRender.His == 1)
    {
      if (this.Hqn < paramInt1 * paramInt2) {
        this.Hqm = null;
      }
      if (this.Hqm == null)
      {
        this.Hqn = (paramInt1 * paramInt2);
        this.Hqm = new int[this.Hqn];
      }
      if ((com.tencent.mm.plugin.voip.c.fFg().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.Hqm, false) < 0) || (this.Hqm == null))
      {
        AppMethodBeat.o(115774);
        return;
      }
      this.Hqk.a(this.Hqm, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      AppMethodBeat.o(115774);
      return;
    }
    if (OpenGlRender.His == 2) {
      this.Hqk.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
    }
    AppMethodBeat.o(115774);
  }
  
  public final void aGx(String paramString)
  {
    AppMethodBeat.i(184096);
    if (this.BgP != null)
    {
      this.BgP.setTextSize(1, 12.0F);
      this.BgP.setText(paramString);
    }
    AppMethodBeat.o(184096);
  }
  
  public final void aGy(String paramString)
  {
    AppMethodBeat.i(184095);
    AppMethodBeat.o(184095);
  }
  
  public final void enR()
  {
    AppMethodBeat.i(184099);
    fMg();
    this.HpP.setVisibility(0);
    this.gBZ.setImageDrawable(ar.m(getContext(), 2131690443, Color.parseColor("#FFFFFF")));
    this.zTe.setText(2131767364);
    this.zTe.requestLayout();
    super.enR();
    AppMethodBeat.o(184099);
  }
  
  public final boolean eoK()
  {
    AppMethodBeat.i(184097);
    super.eoK();
    fMg();
    this.HpP.setVisibility(0);
    this.gBZ.setImageDrawable(ar.m(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
    this.zTe.setVisibility(0);
    this.zTe.setText(2131767321);
    this.zTe.requestLayout();
    this.BgP.setVisibility(8);
    AppMethodBeat.o(184097);
    return true;
  }
  
  public final void eoL()
  {
    AppMethodBeat.i(184102);
    this.BgP.setVisibility(8);
    this.HpP.setVisibility(8);
    AppMethodBeat.o(184102);
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115766);
    if ((!this.HpO) && (this.HpQ)) {
      h.RTc.aV(this.HpR);
    }
    fMm();
    if (OpenGlRender.His == 1)
    {
      this.Hqi.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115766);
      return;
    }
    this.Hqi.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115766);
  }
  
  public final void fJx()
  {
    AppMethodBeat.i(115769);
    if ((this.mIsStarted) && (this.Hqk != null) && (this.Hqi != null))
    {
      this.Hqk.fKN();
      this.Hqi.fKN();
    }
    AppMethodBeat.o(115769);
  }
  
  public final void fMf()
  {
    AppMethodBeat.i(184094);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.HpQ)) {
      this.Hql.xv(false);
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
      }
      localLayoutParams1.width = -1;
      localLayoutParams1.height = -1;
      setLayoutParams(localLayoutParams1);
      AppMethodBeat.o(184094);
      return;
      this.Hql.xv(true);
    }
  }
  
  public final OpenGlRender getBeautyData()
  {
    return this.Hqk;
  }
  
  public final OpenGlRender getSpatioTemporalFilterData()
  {
    return this.Hqk;
  }
  
  public final void jA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115771);
    Log.i("MicroMsg.Voip.TalkingSmallView", "adjustHWViewAspectRatio, mIsStarted:%b, HWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115771);
      return;
    }
    this.GUK = paramInt1;
    this.GUL = paramInt2;
    if ((this.mIsStarted) && (this.Hqk != null) && (this.Hqi != null))
    {
      this.Hqk.jA(paramInt1, paramInt2);
      this.Hqi.jA(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115771);
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(115779);
    this.Hqi.onStarted();
    this.Hqk.onStarted();
    AppMethodBeat.o(115779);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(235974);
    super.onViewAdded(paramView);
    if (this.Hen != null)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if ((this.Hen != null) && (this.Hen.get() != null))
      {
        paramView = (com.tencent.mm.plugin.voip.ui.c)this.Hen.get();
        if ((260 != this.mStatus) && (6 != this.mStatus)) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.aE(false, bool);
          this.Hqk.HiO = true;
          this.Hqi.HiO = true;
          AppMethodBeat.o(235974);
          return;
        }
      }
    }
    else
    {
      this.ECo = true;
    }
    AppMethodBeat.o(235974);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115772);
    this.Hqk.releaseSurfaceTexture();
    this.Hqi.releaseSurfaceTexture();
    AppMethodBeat.o(115772);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115768);
    this.Hqj.HhI.requestRender();
    AppMethodBeat.o(115768);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(235976);
    Log.printDebugStack("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
    if (this.qsJ != null)
    {
      removeView(this.qsJ);
      this.qsJ = null;
    }
    if (paramCaptureView != null)
    {
      this.qsJ = paramCaptureView;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(1, 1);
      localLayoutParams.leftMargin = 20;
      localLayoutParams.topMargin = 20;
      addView(paramCaptureView, localLayoutParams);
      paramCaptureView.setVisibility(0);
      Log.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
    }
    AppMethodBeat.o(235976);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115773);
    this.HdK = paramInt;
    Log.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, hwdec: %d, before changeSurfaceRender", new Object[] { Integer.valueOf(this.HdK) });
    if ((this.Hqk != null) && (this.Hqi != null))
    {
      this.Hqk.setShowMode(0);
      if ((this.HdK & 0x1) == 0) {
        break label121;
      }
      this.Hqi.setShowMode(1);
    }
    for (;;)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d, after changeSurfaceRender", new Object[] { Integer.valueOf(this.Hqk.HiI), Integer.valueOf(this.Hqi.HiI) });
      fMm();
      AppMethodBeat.o(115773);
      return;
      label121:
      this.Hqi.setShowMode(0);
    }
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(235975);
    Log.i("MicroMsg.Voip.TalkingSmallView", "setSpatiotemporalDenosining, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt) });
    this.HiE = paramInt;
    if ((this.mIsStarted) && (this.Hqk != null) && (this.Hqi != null))
    {
      this.Hqk.setSpatiotemporalDenosing(paramInt);
      this.Hqi.setSpatiotemporalDenosing(paramInt);
    }
    AppMethodBeat.o(235975);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(115780);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.HpQ = true;
      this.Hqj.xv(true);
      this.Hql.setVisibility(0);
      this.Hql.xv(false);
      this.BgP.setVisibility(0);
    }
    this.czp.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235972);
        if (c.this.findViewById(2131310037) != null) {
          c.this.findViewById(2131310037).setVisibility(8);
        }
        AppMethodBeat.o(235972);
      }
    }, 3000L);
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus != 0))
    {
      this.Hqj.setVisibility(0);
      this.Hqj.xv(false);
      this.Hql.xv(true);
      this.BgP.setText("");
      this.BgP.setVisibility(8);
    }
    AppMethodBeat.o(115780);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184098);
    if (this.GUk != paramInt)
    {
      fMg();
      this.GUk = paramInt;
      this.HpP.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.zTe.requestLayout();
      this.BgP.setVisibility(8);
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(184098);
      return;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690495, Color.parseColor("#FFFFFF")));
      this.zTe.setText(2131767317);
      continue;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690708, Color.parseColor("#FFFFFF")));
      this.zTe.setText(2131767320);
      continue;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690544, Color.parseColor("#FFFFFF")));
      this.zTe.setText(2131767318);
      continue;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690568, Color.parseColor("#FFFFFF")));
      this.zTe.setText(2131767319);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115770);
    Log.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt) });
    this.Hqo = paramInt;
    if ((this.mIsStarted) && (this.Hqk != null) && (this.Hqi != null))
    {
      this.Hqk.setVoipBeauty(paramInt);
      this.Hqi.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115770);
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(235977);
    super.setVoipUIListener(paramc);
    if ((this.ECo) && (this.Hen != null) && (this.Hen.get() != null))
    {
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.Hen.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      paramc.aE(false, bool);
      this.Hqk.HiO = true;
      this.Hqi.HiO = true;
      this.ECo = false;
      AppMethodBeat.o(235977);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115775);
    super.uninit();
    EventCenter.instance.removeListener(this.hvF);
    setVisibility(4);
    if (this.mIsStarted)
    {
      this.Hqi.fKM();
      this.Hqk.fKM();
    }
    AppMethodBeat.o(115775);
  }
  
  public final void xm(boolean paramBoolean)
  {
    AppMethodBeat.i(184101);
    if (paramBoolean)
    {
      this.BgP.setVisibility(0);
      this.BgP.setText(2131767333);
      AppMethodBeat.o(184101);
      return;
    }
    super.xm(false);
    AppMethodBeat.o(184101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.c
 * JD-Core Version:    0.7.0.1
 */