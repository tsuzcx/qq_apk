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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import com.tencent.mm.plugin.voip.video.GLTextureView.i;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlRender.b;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public final class c
  extends BaseSmallView
{
  private boolean AbW;
  private int BZu;
  private int BZv;
  private int Cio;
  public com.tencent.mm.plugin.voip.ui.a CjB;
  private OpenGlRender CtP;
  OpenGlView CtQ;
  private OpenGlRender CtR;
  OpenGlView CtS;
  private int[] CtT;
  private int CtU;
  private int CtV;
  boolean Ctt;
  RelativeLayout Ctu;
  TextView Ctv;
  private float Ctw;
  boolean Ctx;
  private Runnable Cty;
  ImageView fUN;
  private com.tencent.mm.sdk.b.c gGf;
  private boolean mIsStarted;
  private int mStatus;
  private float radius;
  private TextView wTc;
  
  public c(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    AppMethodBeat.i(115763);
    this.CtT = null;
    this.CtU = 0;
    this.mStatus = -1;
    this.CtV = 0;
    this.CjB = null;
    this.BZu = 0;
    this.BZv = 0;
    this.AbW = false;
    this.radius = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 12);
    this.Ctx = false;
    this.Cty = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115758);
        c localc = c.this;
        if ((!localc.Ctt) && (localc.Ctx))
        {
          localc.Ctt = true;
          localc.Ctx = false;
          localc.CtQ.setVisibility(0);
          localc.CtQ.setAlpha(0.0F);
          localc.CtQ.animate().alpha(1.0F).setDuration(500L).start();
          localc.CtS.setAlpha(1.0F);
          localc.CtS.animate().alpha(0.0F).setDuration(500L).setListener(new c.5(localc)).start();
        }
        AppMethodBeat.o(115758);
      }
    };
    this.gGf = new c.2(this);
    LayoutInflater.from(paramContext).inflate(2131495887, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.Ctu = ((RelativeLayout)findViewById(2131306580));
    this.Ctu.setVisibility(4);
    this.fUN = ((ImageView)findViewById(2131306578));
    this.Ctv = ((TextView)findViewById(2131306579));
    this.Ctw = paramFloat;
    this.CtQ = ((OpenGlView)findViewById(2131302998));
    this.CtP = new OpenGlRender(this.CtQ, OpenGlRender.RenderRemote);
    this.wTc = ((TextView)findViewById(2131305880));
    this.wTc.setTextSize(1, 12.0F);
    this.CtQ.setRenderer(this.CtP);
    this.CtQ.setRenderMode(0);
    this.CtQ.setClipToOutline(true);
    this.CtQ.setOutlineProvider(new e(12.0F));
    this.CtP.CnY = new OpenGlRender.b()
    {
      public final void BA(long paramAnonymousLong)
      {
        AppMethodBeat.i(216642);
        if ((c.this.CiR != null) && (c.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CiR.get()).ae(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(216642);
      }
      
      public final void By(long paramAnonymousLong)
      {
        AppMethodBeat.i(216640);
        if ((c.this.CiR != null) && (c.this.CiR.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CiR.get()).ae(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(216640);
      }
      
      public final void Bz(long paramAnonymousLong)
      {
        AppMethodBeat.i(216641);
        if ((c.this.CiR != null) && (c.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CiR.get()).ae(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(216641);
      }
      
      public final void ezb()
      {
        AppMethodBeat.i(216639);
        if ((c.this.CiR != null) && (c.this.CiR.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CiR.get()).ae(0L, 3);
        }
        AppMethodBeat.o(216639);
      }
    };
    this.CtQ.tG(true);
    this.CtS = ((OpenGlView)findViewById(2131302997));
    this.CtR = new OpenGlRender(this.CtS, OpenGlRender.RenderLocal);
    this.CtS.setClipToOutline(true);
    this.CtS.setOutlineProvider(new e(this.radius));
    this.CtR.CnY = new OpenGlRender.b()
    {
      public final void BA(long paramAnonymousLong)
      {
        AppMethodBeat.i(216646);
        if ((c.this.CiR != null) && (c.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CiR.get()).ae(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(216646);
      }
      
      public final void By(long paramAnonymousLong)
      {
        AppMethodBeat.i(216644);
        if ((c.this.CiR != null) && (c.this.CiR.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CiR.get()).ae(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(216644);
      }
      
      public final void Bz(long paramAnonymousLong)
      {
        AppMethodBeat.i(216645);
        if ((c.this.CiR != null) && (c.this.CiR.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CiR.get()).ae(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(216645);
      }
      
      public final void ezb()
      {
        AppMethodBeat.i(216643);
        if ((c.this.CiR != null) && (c.this.CiR.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CiR.get()).ae(0L, 3);
        }
        AppMethodBeat.o(216643);
      }
    };
    this.CtS.setVisibility(0);
    this.CtS.setRenderer(this.CtR);
    this.CtS.setRenderMode(0);
    this.mIsStarted = false;
    this.Ctt = false;
    com.tencent.mm.sdk.b.a.IbL.c(this.gGf);
    setContentDescription(paramContext.getString(2131757334));
    AppMethodBeat.o(115763);
  }
  
  private void eBq()
  {
    AppMethodBeat.i(184100);
    this.wTc.setVisibility(8);
    AppMethodBeat.o(184100);
  }
  
  private void eBw()
  {
    AppMethodBeat.i(115765);
    if (!this.mIsStarted)
    {
      ad.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", new Object[] { Integer.valueOf(this.CtV) });
      this.mIsStarted = true;
      this.CtP.onStarted();
      this.CtR.onStarted();
      this.CtR.setVoipBeauty(this.CtV);
      this.CtP.setVoipBeauty(this.CtV);
      if ((this.BZu != 0) && (this.BZv != 0)) {
        ir(this.BZu, this.BZv);
      }
    }
    AppMethodBeat.o(115765);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    AppMethodBeat.i(115767);
    if ((this.CtR == null) || (this.CtP == null))
    {
      AppMethodBeat.o(115767);
      return;
    }
    eBw();
    this.surfaceTexture = paramSurfaceTexture;
    this.Cka = paramd;
    this.CtR.a(this.surfaceTexture, this.Cka);
    this.CtP.a(this.surfaceTexture, this.Cka);
    AppMethodBeat.o(115767);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(115774);
    if (8 == this.CtS.getVisibility())
    {
      AppMethodBeat.o(115774);
      return;
    }
    eBw();
    if (OpenGlRender.CnB == 1)
    {
      if (this.CtU < paramInt1 * paramInt2) {
        this.CtT = null;
      }
      if (this.CtT == null)
      {
        this.CtU = (paramInt1 * paramInt2);
        this.CtT = new int[this.CtU];
      }
      if ((com.tencent.mm.plugin.voip.c.euM().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.CtT, false) < 0) || (this.CtT == null))
      {
        AppMethodBeat.o(115774);
        return;
      }
      this.CtR.a(this.CtT, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      AppMethodBeat.o(115774);
      return;
    }
    if (OpenGlRender.CnB == 2) {
      this.CtR.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
    }
    AppMethodBeat.o(115774);
  }
  
  public final void aDJ(String paramString)
  {
    AppMethodBeat.i(184095);
    AppMethodBeat.o(184095);
  }
  
  public final void aDK(String paramString)
  {
    AppMethodBeat.i(184096);
    if (this.wTc != null)
    {
      this.wTc.setTextSize(1, 12.0F);
      this.wTc.setText(paramString);
    }
    AppMethodBeat.o(184096);
  }
  
  public final void dqh()
  {
    AppMethodBeat.i(184099);
    eBq();
    this.Ctu.setVisibility(0);
    this.fUN.setImageDrawable(ao.k(getContext(), 2131690327, Color.parseColor("#FFFFFF")));
    this.Ctv.setText(2131764923);
    this.Ctv.requestLayout();
    super.dqh();
    AppMethodBeat.o(184099);
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115766);
    if ((!this.Ctt) && (this.Ctx)) {
      h.LTJ.aP(this.Cty);
    }
    eBw();
    if (OpenGlRender.CnB == 1)
    {
      this.CtP.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115766);
      return;
    }
    this.CtP.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115766);
  }
  
  public final void eBp()
  {
    AppMethodBeat.i(184094);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.Ctx)) {
      this.CtS.tG(false);
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
      this.CtS.tG(true);
    }
  }
  
  public final void eyU()
  {
    AppMethodBeat.i(115769);
    if ((this.mIsStarted) && (this.CtR != null) && (this.CtP != null))
    {
      this.CtR.eAx();
      this.CtP.eAx();
    }
    AppMethodBeat.o(115769);
  }
  
  public final boolean ezi()
  {
    AppMethodBeat.i(184097);
    super.ezi();
    eBq();
    this.Ctu.setVisibility(0);
    this.fUN.setImageDrawable(ao.k(getContext(), 2131690360, Color.parseColor("#FFFFFF")));
    this.Ctv.setVisibility(0);
    this.Ctv.setText(2131764882);
    this.Ctv.requestLayout();
    this.wTc.setVisibility(8);
    AppMethodBeat.o(184097);
    return true;
  }
  
  public final void ezj()
  {
    AppMethodBeat.i(184102);
    this.wTc.setVisibility(8);
    this.Ctu.setVisibility(8);
    AppMethodBeat.o(184102);
  }
  
  public final OpenGlRender getBeautyData()
  {
    return this.CtR;
  }
  
  public final void ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115771);
    ad.i("MicroMsg.Voip.TalkingSmallView", "adjustHWViewAspectRatio, mIsStarted:%b, HWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115771);
      return;
    }
    this.BZu = paramInt1;
    this.BZv = paramInt2;
    if ((this.mIsStarted) && (this.CtR != null) && (this.CtP != null))
    {
      this.CtR.ir(paramInt1, paramInt2);
      this.CtP.ir(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115771);
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(115779);
    this.CtP.onStarted();
    this.CtR.onStarted();
    AppMethodBeat.o(115779);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(216649);
    super.onViewAdded(paramView);
    if (this.CiR != null)
    {
      ad.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if ((this.CiR != null) && (this.CiR.get() != null))
      {
        paramView = (com.tencent.mm.plugin.voip.ui.c)this.CiR.get();
        if ((260 != this.mStatus) && (6 != this.mStatus)) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.au(false, bool);
          this.CtR.CnW = true;
          this.CtP.CnW = true;
          AppMethodBeat.o(216649);
          return;
        }
      }
    }
    else
    {
      this.AbW = true;
    }
    AppMethodBeat.o(216649);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115772);
    this.CtR.releaseSurfaceTexture();
    this.CtP.releaseSurfaceTexture();
    AppMethodBeat.o(115772);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115768);
    this.CtQ.CmJ.requestRender();
    AppMethodBeat.o(115768);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115776);
    ad.l("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
    if (this.oXg != null)
    {
      removeView(this.oXg);
      this.oXg = null;
    }
    if (paramCaptureView != null)
    {
      this.oXg = paramCaptureView;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(1, 1);
      localLayoutParams.leftMargin = 20;
      localLayoutParams.topMargin = 20;
      addView(paramCaptureView, localLayoutParams);
      paramCaptureView.setVisibility(0);
      ad.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
    }
    AppMethodBeat.o(115776);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115773);
    this.Cio = paramInt;
    ad.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, hwdec: %d, before changeSurfaceRender", new Object[] { Integer.valueOf(this.Cio) });
    if ((this.CtR != null) && (this.CtP != null))
    {
      this.CtR.UT(0);
      if ((this.Cio & 0x1) == 0) {
        break label121;
      }
      this.CtP.UT(1);
    }
    for (;;)
    {
      ad.i("MicroMsg.Voip.TalkingSmallView", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d, after changeSurfaceRender", new Object[] { Integer.valueOf(this.CtR.CnQ), Integer.valueOf(this.CtP.CnQ) });
      eBw();
      AppMethodBeat.o(115773);
      return;
      label121:
      this.CtP.UT(0);
    }
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(115780);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.Ctx = true;
      this.CtQ.tG(true);
      this.CtS.setVisibility(0);
      this.CtS.tG(false);
      this.wTc.setVisibility(0);
    }
    this.gKD.postDelayed(new c.6(this), 3000L);
    ad.m("czf", "set status is %s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus != 0))
    {
      this.CtQ.setVisibility(0);
      this.CtQ.tG(false);
      this.CtS.tG(true);
      this.wTc.setText("");
      this.wTc.setVisibility(8);
    }
    AppMethodBeat.o(115780);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184098);
    if (this.BYM != paramInt)
    {
      eBq();
      this.BYM = paramInt;
      this.Ctu.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.Ctv.requestLayout();
      this.wTc.setVisibility(8);
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(184098);
      return;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690357, Color.parseColor("#FFFFFF")));
      this.Ctv.setText(2131764878);
      continue;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
      this.Ctv.setText(2131764881);
      continue;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690395, Color.parseColor("#FFFFFF")));
      this.Ctv.setText(2131764879);
      continue;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690411, Color.parseColor("#FFFFFF")));
      this.Ctv.setText(2131764880);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115770);
    ad.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt) });
    this.CtV = paramInt;
    if ((this.mIsStarted) && (this.CtR != null) && (this.CtP != null))
    {
      this.CtR.setVoipBeauty(paramInt);
      this.CtP.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115770);
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(216650);
    super.setVoipUIListener(paramc);
    if ((this.AbW) && (this.CiR != null) && (this.CiR.get() != null))
    {
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.CiR.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      paramc.au(false, bool);
      this.CtR.CnW = true;
      this.CtP.CnW = true;
      this.AbW = false;
      AppMethodBeat.o(216650);
      return;
    }
  }
  
  public final void tv(boolean paramBoolean)
  {
    AppMethodBeat.i(184101);
    if (paramBoolean)
    {
      this.wTc.setVisibility(0);
      this.wTc.setText(2131764894);
      AppMethodBeat.o(184101);
      return;
    }
    super.tv(false);
    AppMethodBeat.o(184101);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115775);
    super.uninit();
    com.tencent.mm.sdk.b.a.IbL.d(this.gGf);
    setVisibility(4);
    if (this.mIsStarted)
    {
      this.CtP.eAw();
      this.CtR.eAw();
    }
    AppMethodBeat.o(115775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.c
 * JD-Core Version:    0.7.0.1
 */