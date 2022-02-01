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
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
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
import com.tencent.mm.ui.au;
import java.lang.ref.WeakReference;

public final class c
  extends BaseSmallView
{
  TextView FyG;
  public com.tencent.mm.plugin.voip.ui.a Fzp;
  private TextView Haz;
  private boolean KQf;
  private int NKW;
  private int NKX;
  private int NUC;
  private int NZt;
  boolean OgH;
  RelativeLayout OgI;
  boolean OgJ;
  private Runnable OgK;
  private OpenGlRender Ohb;
  OpenGlView Ohc;
  private OpenGlRender Ohd;
  OpenGlView Ohe;
  private int[] Ohf;
  private int Ohg;
  private int Ohh;
  ImageView jmf;
  private IListener khI;
  private boolean mIsStarted;
  private int mStatus;
  private float radius;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(236737);
    this.Ohf = null;
    this.Ohg = 0;
    this.mStatus = -1;
    this.Ohh = 0;
    this.NZt = 0;
    this.Fzp = null;
    this.NKW = 0;
    this.NKX = 0;
    this.KQf = false;
    this.radius = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.OgJ = false;
    this.OgK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115758);
        c localc = c.this;
        if ((!localc.OgH) && (localc.OgJ))
        {
          localc.OgH = true;
          localc.OgJ = false;
          localc.Ohc.setVisibility(0);
          localc.Ohc.setAlpha(0.0F);
          localc.Ohc.animate().alpha(1.0F).setDuration(500L).start();
          localc.Ohe.setAlpha(1.0F);
          localc.Ohe.animate().alpha(0.0F).setDuration(500L).setListener(new c.5(localc)).start();
        }
        AppMethodBeat.o(115758);
      }
    };
    this.khI = new c.2(this);
    LayoutInflater.from(paramContext).inflate(b.e.voip_widget_video_talking, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.OgI = ((RelativeLayout)findViewById(b.d.voip_mini_windows_layout));
    this.OgI.setVisibility(4);
    this.jmf = ((ImageView)findViewById(b.d.voip_mini_full_icon));
    this.FyG = ((TextView)findViewById(b.d.voip_mini_full_tv));
    this.Ohc = ((OpenGlView)findViewById(b.d.ogv_talking));
    this.Ohb = new OpenGlRender(this.Ohc, OpenGlRender.RenderRemote);
    this.Haz = ((TextView)findViewById(b.d.tip_tv));
    this.Haz.setTextSize(1, 12.0F);
    this.Ohc.setRenderer(this.Ohb);
    this.Ohc.setRenderMode(0);
    this.Ohc.setClipToOutline(true);
    this.Ohc.setOutlineProvider(new e(this.radius));
    this.Ohb.NZE = new OpenGlRender.b()
    {
      public final void SH(long paramAnonymousLong)
      {
        AppMethodBeat.i(237927);
        if ((c.this.NVe != null) && (c.this.NVe.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.NVe.get()).aq(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(237927);
      }
      
      public final void SI(long paramAnonymousLong)
      {
        AppMethodBeat.i(237928);
        if ((c.this.NVe != null) && (c.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.NVe.get()).aq(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(237928);
      }
      
      public final void SJ(long paramAnonymousLong)
      {
        AppMethodBeat.i(237930);
        if ((c.this.NVe != null) && (c.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.NVe.get()).aq(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(237930);
      }
      
      public final void gCa()
      {
        AppMethodBeat.i(237926);
        if ((c.this.NVe != null) && (c.this.NVe.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.NVe.get()).aq(0L, 3);
        }
        AppMethodBeat.o(237926);
      }
    };
    this.Ohc.Bn(true);
    this.Ohe = ((OpenGlView)findViewById(b.d.ogv_local_video));
    this.Ohd = new OpenGlRender(this.Ohe, OpenGlRender.RenderLocal);
    this.Ohe.setClipToOutline(true);
    this.Ohe.setOutlineProvider(new e(this.radius));
    this.Ohd.NZE = new OpenGlRender.b()
    {
      public final void SH(long paramAnonymousLong)
      {
        AppMethodBeat.i(237570);
        if ((c.this.NVe != null) && (c.this.NVe.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.NVe.get()).aq(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(237570);
      }
      
      public final void SI(long paramAnonymousLong)
      {
        AppMethodBeat.i(237571);
        if ((c.this.NVe != null) && (c.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.NVe.get()).aq(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(237571);
      }
      
      public final void SJ(long paramAnonymousLong)
      {
        AppMethodBeat.i(237572);
        if ((c.this.NVe != null) && (c.this.NVe.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.NVe.get()).aq(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(237572);
      }
      
      public final void gCa()
      {
        AppMethodBeat.i(237568);
        if ((c.this.NVe != null) && (c.this.NVe.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.NVe.get()).aq(0L, 3);
        }
        AppMethodBeat.o(237568);
      }
    };
    this.Ohe.setVisibility(0);
    this.Ohe.setRenderer(this.Ohd);
    this.Ohe.setRenderMode(0);
    this.mIsStarted = false;
    this.OgH = false;
    EventCenter.instance.addListener(this.khI);
    setContentDescription(paramContext.getString(b.g.chatting_voip_video));
    AppMethodBeat.o(236737);
  }
  
  private void gEK()
  {
    AppMethodBeat.i(184100);
    this.Haz.setVisibility(8);
    AppMethodBeat.o(184100);
  }
  
  private void gEQ()
  {
    AppMethodBeat.i(115765);
    if (!this.mIsStarted)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", new Object[] { Integer.valueOf(this.Ohh) });
      this.mIsStarted = true;
      this.Ohb.qS();
      this.Ohd.qS();
      this.Ohd.setVoipBeauty(this.Ohh);
      this.Ohb.setVoipBeauty(this.Ohh);
      this.Ohd.setSpatiotemporalDenosing(this.NZt);
      this.Ohb.setSpatiotemporalDenosing(this.NZt);
      if ((this.NKW != 0) && (this.NKX != 0)) {
        kN(this.NKW, this.NKX);
      }
    }
    AppMethodBeat.o(115765);
  }
  
  public final void Be(boolean paramBoolean)
  {
    AppMethodBeat.i(184101);
    if (paramBoolean)
    {
      this.Haz.setVisibility(0);
      this.Haz.setText(b.g.voip_net_status_warning_hint_mini);
      AppMethodBeat.o(184101);
      return;
    }
    super.Be(false);
    AppMethodBeat.o(184101);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    AppMethodBeat.i(115767);
    if ((this.Ohd == null) || (this.Ohb == null))
    {
      AppMethodBeat.o(115767);
      return;
    }
    gEQ();
    this.surfaceTexture = paramSurfaceTexture;
    this.MRb = paramd;
    this.Ohd.a(this.surfaceTexture, this.MRb);
    this.Ohb.a(this.surfaceTexture, this.MRb);
    AppMethodBeat.o(115767);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(115774);
    if (8 == this.Ohe.getVisibility())
    {
      AppMethodBeat.o(115774);
      return;
    }
    gEQ();
    if (OpenGlRender.NZh == 1)
    {
      if (this.Ohg < paramInt1 * paramInt2) {
        this.Ohf = null;
      }
      if (this.Ohf == null)
      {
        this.Ohg = (paramInt1 * paramInt2);
        this.Ohf = new int[this.Ohg];
      }
      if ((com.tencent.mm.plugin.voip.c.gxs().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.Ohf, false) < 0) || (this.Ohf == null))
      {
        AppMethodBeat.o(115774);
        return;
      }
      this.Ohd.a(this.Ohf, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      AppMethodBeat.o(115774);
      return;
    }
    if (OpenGlRender.NZh == 2) {
      this.Ohd.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
    }
    AppMethodBeat.o(115774);
  }
  
  public final void aQM(String paramString)
  {
    AppMethodBeat.i(184096);
    if (this.Haz != null)
    {
      this.Haz.setTextSize(1, 12.0F);
      this.Haz.setText(paramString);
    }
    AppMethodBeat.o(184096);
  }
  
  public final void aQN(String paramString)
  {
    AppMethodBeat.i(184095);
    AppMethodBeat.o(184095);
  }
  
  public final void eXH()
  {
    AppMethodBeat.i(184099);
    gEK();
    this.OgI.setVisibility(0);
    this.jmf.setImageDrawable(au.o(getContext(), b.f.icon_filled_mike_off, Color.parseColor("#FFFFFF")));
    this.FyG.setText(b.g.voip_start_record_failed);
    this.FyG.requestLayout();
    super.eXH();
    AppMethodBeat.o(184099);
  }
  
  public final boolean eYB()
  {
    AppMethodBeat.i(184097);
    super.eYB();
    gEK();
    this.OgI.setVisibility(0);
    this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_call_end, Color.parseColor("#FFFFFF")));
    this.FyG.setVisibility(0);
    this.FyG.setText(b.g.voip_miniwindow_end_wording);
    this.FyG.requestLayout();
    this.Haz.setVisibility(8);
    AppMethodBeat.o(184097);
    return true;
  }
  
  public final void eYC()
  {
    AppMethodBeat.i(184102);
    this.Haz.setVisibility(8);
    this.OgI.setVisibility(8);
    AppMethodBeat.o(184102);
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115766);
    if ((!this.OgH) && (this.OgJ)) {
      h.ZvG.bc(this.OgK);
    }
    gEQ();
    if (OpenGlRender.NZh == 1)
    {
      this.Ohb.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115766);
      return;
    }
    this.Ohb.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115766);
  }
  
  public final void gBT()
  {
    AppMethodBeat.i(115769);
    if ((this.mIsStarted) && (this.Ohd != null) && (this.Ohb != null))
    {
      this.Ohd.gDn();
      this.Ohb.gDn();
    }
    AppMethodBeat.o(115769);
  }
  
  public final void gEJ()
  {
    AppMethodBeat.i(184094);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.OgJ)) {
      this.Ohe.Bn(false);
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
      this.Ohe.Bn(true);
    }
  }
  
  public final OpenGlRender getBeautyData()
  {
    return this.Ohd;
  }
  
  public final OpenGlRender getSpatioTemporalFilterData()
  {
    return this.Ohd;
  }
  
  public final void kN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115771);
    Log.i("MicroMsg.Voip.TalkingSmallView", "adjustHWViewAspectRatio, mIsStarted:%b, HWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115771);
      return;
    }
    this.NKW = paramInt1;
    this.NKX = paramInt2;
    if ((this.mIsStarted) && (this.Ohd != null) && (this.Ohb != null))
    {
      this.Ohd.kN(paramInt1, paramInt2);
      this.Ohb.kN(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115771);
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(115779);
    this.Ohb.qS();
    this.Ohd.qS();
    AppMethodBeat.o(115779);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(236744);
    super.onViewAdded(paramView);
    if (this.NVe != null)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if ((this.NVe != null) && (this.NVe.get() != null))
      {
        paramView = (com.tencent.mm.plugin.voip.ui.c)this.NVe.get();
        if ((260 != this.mStatus) && (6 != this.mStatus)) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.aQ(false, bool);
          this.Ohd.NZC = true;
          this.Ohb.NZC = true;
          AppMethodBeat.o(236744);
          return;
        }
      }
    }
    else
    {
      this.KQf = true;
    }
    AppMethodBeat.o(236744);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115772);
    this.Ohd.releaseSurfaceTexture();
    this.Ohb.releaseSurfaceTexture();
    AppMethodBeat.o(115772);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115768);
    this.Ohc.NYx.requestRender();
    AppMethodBeat.o(115768);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(236770);
    super.c(paramCaptureView);
    AppMethodBeat.o(236770);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115773);
    this.NUC = paramInt;
    Log.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, hwdec: %d, before changeSurfaceRender", new Object[] { Integer.valueOf(this.NUC) });
    if ((this.Ohd != null) && (this.Ohb != null))
    {
      this.Ohd.setShowMode(0);
      if ((this.NUC & 0x1) == 0) {
        break label123;
      }
      this.Ohb.setShowMode(1);
    }
    for (;;)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d, after changeSurfaceRender", new Object[] { Integer.valueOf(this.Ohd.zow), Integer.valueOf(this.Ohb.zow) });
      gEQ();
      AppMethodBeat.o(115773);
      return;
      label123:
      this.Ohb.setShowMode(0);
    }
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(236763);
    Log.i("MicroMsg.Voip.TalkingSmallView", "setSpatiotemporalDenosining, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt) });
    this.NZt = paramInt;
    if ((this.mIsStarted) && (this.Ohd != null) && (this.Ohb != null))
    {
      this.Ohd.setSpatiotemporalDenosing(paramInt);
      this.Ohb.setSpatiotemporalDenosing(paramInt);
    }
    AppMethodBeat.o(236763);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(115780);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.OgJ = true;
      this.Ohc.Bn(true);
      this.Ohe.setVisibility(0);
      this.Ohe.Bn(false);
      this.Haz.setVisibility(0);
    }
    this.cyl.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(236365);
        if (c.this.findViewById(b.d.voip_maximize) != null) {
          c.this.findViewById(b.d.voip_maximize).setVisibility(8);
        }
        AppMethodBeat.o(236365);
      }
    }, 3000L);
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus != 0))
    {
      this.Ohc.setVisibility(0);
      this.Ohc.Bn(false);
      this.Ohe.Bn(true);
      this.Haz.setText("");
      this.Haz.setVisibility(8);
    }
    AppMethodBeat.o(115780);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184098);
    if (this.NKw != paramInt)
    {
      gEK();
      this.NKw = paramInt;
      this.OgI.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.FyG.requestLayout();
      this.Haz.setVisibility(8);
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(184098);
      return;
      this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_bluetooth, Color.parseColor("#FFFFFF")));
      this.FyG.setText(b.g.voip_mini_bluetooth);
      continue;
      this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_volume_up, Color.parseColor("#FFFFFF")));
      this.FyG.setText(b.g.voip_mini_mike);
      continue;
      this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_ear, Color.parseColor("#FFFFFF")));
      this.FyG.setText(b.g.voip_mini_earpiece);
      continue;
      this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_headset, Color.parseColor("#FFFFFF")));
      this.FyG.setText(b.g.voip_mini_headset);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115770);
    Log.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt) });
    this.Ohh = paramInt;
    if ((this.mIsStarted) && (this.Ohd != null) && (this.Ohb != null))
    {
      this.Ohd.setVoipBeauty(paramInt);
      this.Ohb.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115770);
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(236772);
    super.setVoipUIListener(paramc);
    if ((this.KQf) && (this.NVe != null) && (this.NVe.get() != null))
    {
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.NVe.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      paramc.aQ(false, bool);
      this.Ohd.NZC = true;
      this.Ohb.NZC = true;
      this.KQf = false;
      AppMethodBeat.o(236772);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115775);
    super.uninit();
    EventCenter.instance.removeListener(this.khI);
    setVisibility(4);
    if (this.mIsStarted)
    {
      this.Ohb.gDm();
      this.Ohd.gDm();
    }
    AppMethodBeat.o(115775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.c
 * JD-Core Version:    0.7.0.1
 */