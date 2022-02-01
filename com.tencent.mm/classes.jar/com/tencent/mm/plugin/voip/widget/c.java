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
import com.tencent.mm.media.f.d;
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
import com.tencent.mm.ui.am;
import java.lang.ref.WeakReference;

public final class c
  extends BaseSmallView
{
  ImageView fxT;
  private boolean mIsStarted;
  private int mStatus;
  private float radius;
  private TextView sYS;
  private TextView uDc;
  private boolean xxL;
  boolean zAX;
  RelativeLayout zAY;
  TextView zAZ;
  private float zBa;
  boolean zBb;
  private Runnable zBc;
  private OpenGlRender zBt;
  OpenGlView zBu;
  private OpenGlRender zBv;
  OpenGlView zBw;
  private int[] zBx;
  private int zBy;
  private int zBz;
  private int zhL;
  private int zhM;
  private int zqz;
  public com.tencent.mm.plugin.voip.ui.a zrO;
  private com.tencent.mm.sdk.b.c zrl;
  
  public c(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    AppMethodBeat.i(115763);
    this.zBx = null;
    this.zBy = 0;
    this.mStatus = -1;
    this.zBz = 0;
    this.zrO = null;
    this.zhL = 0;
    this.zhM = 0;
    this.xxL = false;
    this.radius = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 12);
    this.zBb = false;
    this.zBc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115758);
        c localc = c.this;
        if ((!localc.zAX) && (localc.zBb))
        {
          localc.zAX = true;
          localc.zBb = false;
          localc.zBu.setVisibility(0);
          localc.zBu.setAlpha(0.0F);
          localc.zBu.animate().alpha(1.0F).setDuration(500L).start();
          localc.zBw.setAlpha(1.0F);
          localc.zBw.animate().alpha(0.0F).setDuration(500L).setListener(new c.5(localc)).start();
        }
        AppMethodBeat.o(115758);
      }
    };
    this.zrl = new c.2(this);
    LayoutInflater.from(paramContext).inflate(2131495887, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.zAY = ((RelativeLayout)findViewById(2131306580));
    this.zAY.setVisibility(4);
    this.fxT = ((ImageView)findViewById(2131306578));
    this.zAZ = ((TextView)findViewById(2131306579));
    this.zBa = paramFloat;
    this.zBu = ((OpenGlView)findViewById(2131302998));
    this.zBt = new OpenGlRender(this.zBu, OpenGlRender.RenderRemote);
    this.sYS = ((TextView)findViewById(2131305822));
    this.sYS.setVisibility(0);
    this.uDc = ((TextView)findViewById(2131305880));
    this.uDc.setTextSize(1, 12.0F);
    this.zBu.setRenderer(this.zBt);
    this.zBu.setRenderMode(0);
    this.zBu.setClipToOutline(true);
    this.zBu.setOutlineProvider(new e(12.0F));
    this.zBt.zvN = new OpenGlRender.b()
    {
      public final void dWf()
      {
        AppMethodBeat.i(192253);
        if ((c.this.zrd != null) && (c.this.zrd.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.zrd.get()).W(0L, 3);
        }
        AppMethodBeat.o(192253);
      }
      
      public final void uo(long paramAnonymousLong)
      {
        AppMethodBeat.i(192254);
        if ((c.this.zrd != null) && (c.this.zrd.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.zrd.get()).W(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(192254);
      }
      
      public final void up(long paramAnonymousLong)
      {
        AppMethodBeat.i(192255);
        if ((c.this.zrd != null) && (c.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.zrd.get()).W(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(192255);
      }
      
      public final void uq(long paramAnonymousLong)
      {
        AppMethodBeat.i(192256);
        if ((c.this.zrd != null) && (c.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.zrd.get()).W(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(192256);
      }
    };
    this.zBu.rV(true);
    this.zBw = ((OpenGlView)findViewById(2131302997));
    this.zBv = new OpenGlRender(this.zBw, OpenGlRender.RenderLocal);
    this.zBw.setClipToOutline(true);
    this.zBw.setOutlineProvider(new e(this.radius));
    this.zBv.zvN = new OpenGlRender.b()
    {
      public final void dWf()
      {
        AppMethodBeat.i(192257);
        if ((c.this.zrd != null) && (c.this.zrd.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.zrd.get()).W(0L, 3);
        }
        AppMethodBeat.o(192257);
      }
      
      public final void uo(long paramAnonymousLong)
      {
        AppMethodBeat.i(192258);
        if ((c.this.zrd != null) && (c.this.zrd.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.zrd.get()).W(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(192258);
      }
      
      public final void up(long paramAnonymousLong)
      {
        AppMethodBeat.i(192259);
        if ((c.this.zrd != null) && (c.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.zrd.get()).W(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(192259);
      }
      
      public final void uq(long paramAnonymousLong)
      {
        AppMethodBeat.i(192260);
        if ((c.this.zrd != null) && (c.this.zrd.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.zrd.get()).W(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(192260);
      }
    };
    this.zBw.setVisibility(0);
    this.zBw.setRenderer(this.zBv);
    this.zBw.setRenderMode(0);
    this.mIsStarted = false;
    this.zAX = false;
    com.tencent.mm.sdk.b.a.ESL.c(this.zrl);
    setContentDescription(paramContext.getString(2131757334));
    AppMethodBeat.o(115763);
  }
  
  private void dXV()
  {
    AppMethodBeat.i(184100);
    this.uDc.setVisibility(8);
    this.sYS.setVisibility(8);
    AppMethodBeat.o(184100);
  }
  
  private void dYb()
  {
    AppMethodBeat.i(115765);
    if (!this.mIsStarted)
    {
      ad.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", new Object[] { Integer.valueOf(this.zBz) });
      this.mIsStarted = true;
      this.zBt.onStarted();
      this.zBv.onStarted();
      this.zBv.setVoipBeauty(this.zBz);
      this.zBt.setVoipBeauty(this.zBz);
      if ((this.zhL != 0) && (this.zhM != 0)) {
        hP(this.zhL, this.zhM);
      }
    }
    AppMethodBeat.o(115765);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    AppMethodBeat.i(115767);
    if ((this.zBv == null) || (this.zBt == null))
    {
      AppMethodBeat.o(115767);
      return;
    }
    dYb();
    this.surfaceTexture = paramSurfaceTexture;
    this.zsn = paramd;
    this.zBv.a(this.surfaceTexture, this.zsn);
    this.zBt.a(this.surfaceTexture, this.zsn);
    AppMethodBeat.o(115767);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(115774);
    if (8 == this.zBw.getVisibility())
    {
      AppMethodBeat.o(115774);
      return;
    }
    dYb();
    if (OpenGlRender.zvx == 1)
    {
      if (this.zBy < paramInt1 * paramInt2) {
        this.zBx = null;
      }
      if (this.zBx == null)
      {
        this.zBy = (paramInt1 * paramInt2);
        this.zBx = new int[this.zBy];
      }
      if ((com.tencent.mm.plugin.voip.c.dRQ().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.zBx, false) < 0) || (this.zBx == null))
      {
        AppMethodBeat.o(115774);
        return;
      }
      this.zBv.a(this.zBx, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      AppMethodBeat.o(115774);
      return;
    }
    if (OpenGlRender.zvx == 2) {
      this.zBv.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
    }
    AppMethodBeat.o(115774);
  }
  
  public final void atk(String paramString)
  {
    AppMethodBeat.i(184095);
    AppMethodBeat.o(184095);
  }
  
  public final void atl(String paramString)
  {
    AppMethodBeat.i(184096);
    if (this.sYS != null)
    {
      this.sYS.setTextSize(1, 12.0F);
      this.sYS.setText(paramString);
    }
    AppMethodBeat.o(184096);
  }
  
  public final void cSz()
  {
    AppMethodBeat.i(184099);
    dXV();
    this.zAY.setVisibility(0);
    this.fxT.setImageDrawable(am.i(getContext(), 2131690327, Color.parseColor("#FFFFFF")));
    this.zAZ.setText(2131764923);
    super.cSz();
    AppMethodBeat.o(184099);
  }
  
  public final void dVY()
  {
    AppMethodBeat.i(115769);
    if ((this.mIsStarted) && (this.zBv != null) && (this.zBt != null))
    {
      this.zBv.dXh();
      this.zBt.dXh();
    }
    AppMethodBeat.o(115769);
  }
  
  public final boolean dWm()
  {
    AppMethodBeat.i(184097);
    super.dWm();
    dXV();
    this.zAY.setVisibility(0);
    this.fxT.setImageDrawable(am.i(getContext(), 2131690360, Color.parseColor("#FFFFFF")));
    this.zAZ.setVisibility(0);
    this.zAZ.setText(2131764882);
    this.sYS.setVisibility(8);
    AppMethodBeat.o(184097);
    return true;
  }
  
  public final void dWn()
  {
    AppMethodBeat.i(184102);
    this.uDc.setVisibility(8);
    this.zAY.setVisibility(8);
    AppMethodBeat.o(184102);
  }
  
  public final void dXU()
  {
    AppMethodBeat.i(184094);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.zBb)) {
      this.zBw.rV(false);
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
      this.zBw.rV(true);
    }
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115766);
    if ((!this.zAX) && (this.zBb)) {
      h.Iye.aN(this.zBc);
    }
    dYb();
    if (OpenGlRender.zvx == 1)
    {
      this.zBt.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115766);
      return;
    }
    this.zBt.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115766);
  }
  
  public final OpenGlRender getBeautyData()
  {
    return this.zBv;
  }
  
  public final void hP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115771);
    ad.i("MicroMsg.Voip.TalkingSmallView", "adjustHWViewAspectRatio, mIsStarted:%b, HWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115771);
      return;
    }
    this.zhL = paramInt1;
    this.zhM = paramInt2;
    if ((this.mIsStarted) && (this.zBv != null) && (this.zBt != null))
    {
      this.zBv.hP(paramInt1, paramInt2);
      this.zBt.hP(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115771);
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(115779);
    this.zBt.onStarted();
    this.zBv.onStarted();
    AppMethodBeat.o(115779);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(192263);
    super.onViewAdded(paramView);
    if (this.zrd != null)
    {
      ad.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if ((this.zrd != null) && (this.zrd.get() != null))
      {
        paramView = (com.tencent.mm.plugin.voip.ui.c)this.zrd.get();
        if ((260 != this.mStatus) && (6 != this.mStatus)) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.al(false, bool);
          this.zBv.zvL = true;
          AppMethodBeat.o(192263);
          return;
        }
      }
    }
    else
    {
      this.xxL = true;
    }
    AppMethodBeat.o(192263);
  }
  
  public final void rL(boolean paramBoolean)
  {
    AppMethodBeat.i(184101);
    if (paramBoolean)
    {
      this.uDc.setVisibility(0);
      this.uDc.setText(2131764894);
      this.sYS.setVisibility(8);
      AppMethodBeat.o(184101);
      return;
    }
    super.rL(false);
    AppMethodBeat.o(184101);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115772);
    this.zBv.releaseSurfaceTexture();
    this.zBt.releaseSurfaceTexture();
    AppMethodBeat.o(115772);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115768);
    this.zBu.zuE.requestRender();
    AppMethodBeat.o(115768);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115776);
    ad.l("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
    if (this.zlf != null)
    {
      removeView(this.zlf);
      this.zlf = null;
    }
    if (paramCaptureView != null)
    {
      this.zlf = paramCaptureView;
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
    this.zqz = paramInt;
    ad.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, hwdec: %d, before changeSurfaceRender", new Object[] { Integer.valueOf(this.zqz) });
    if ((this.zBv != null) && (this.zBt != null))
    {
      this.zBv.QR(0);
      if ((this.zqz & 0x1) == 0) {
        break label121;
      }
      this.zBt.QR(1);
    }
    for (;;)
    {
      ad.i("MicroMsg.Voip.TalkingSmallView", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d, after changeSurfaceRender", new Object[] { Integer.valueOf(this.zBv.zvF), Integer.valueOf(this.zBt.zvF) });
      dYb();
      AppMethodBeat.o(115773);
      return;
      label121:
      this.zBt.QR(0);
    }
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(115780);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.zBb = true;
      this.zBu.rV(true);
      this.zBw.setVisibility(0);
      this.zBw.rV(false);
      this.sYS.setVisibility(0);
    }
    this.oFl.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192262);
        if (c.this.findViewById(2131306577) != null) {
          c.this.findViewById(2131306577).setVisibility(8);
        }
        AppMethodBeat.o(192262);
      }
    }, 3000L);
    ad.m("czf", "set status is %s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus != 0))
    {
      this.zBu.setVisibility(0);
      this.zBu.rV(false);
      this.zBw.rV(true);
      this.sYS.setText("");
      this.sYS.setVisibility(8);
    }
    AppMethodBeat.o(115780);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184098);
    if (this.zhd != paramInt)
    {
      dXV();
      this.zhd = paramInt;
      this.zAY.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.sYS.setVisibility(8);
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(184098);
      return;
      this.fxT.setImageDrawable(am.i(getContext(), 2131690357, Color.parseColor("#FFFFFF")));
      this.zAZ.setText(2131764878);
      continue;
      this.fxT.setImageDrawable(am.i(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
      this.zAZ.setText(2131764881);
      continue;
      this.fxT.setImageDrawable(am.i(getContext(), 2131690395, Color.parseColor("#FFFFFF")));
      this.zAZ.setText(2131764879);
      continue;
      this.fxT.setImageDrawable(am.i(getContext(), 2131690411, Color.parseColor("#FFFFFF")));
      this.zAZ.setText(2131764880);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115770);
    ad.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt) });
    this.zBz = paramInt;
    if ((this.mIsStarted) && (this.zBv != null) && (this.zBt != null))
    {
      this.zBv.setVoipBeauty(paramInt);
      this.zBt.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115770);
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(192264);
    super.setVoipUIListener(paramc);
    if ((this.xxL) && (this.zrd != null) && (this.zrd.get() != null))
    {
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.zrd.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label95;
      }
    }
    label95:
    for (boolean bool = true;; bool = false)
    {
      paramc.al(false, bool);
      this.zBv.zvL = true;
      this.xxL = false;
      AppMethodBeat.o(192264);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115775);
    super.uninit();
    com.tencent.mm.sdk.b.a.ESL.d(this.zrl);
    setVisibility(4);
    if (this.mIsStarted)
    {
      this.zBt.dXg();
      this.zBv.dXg();
    }
    AppMethodBeat.o(115775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.c
 * JD-Core Version:    0.7.0.1
 */