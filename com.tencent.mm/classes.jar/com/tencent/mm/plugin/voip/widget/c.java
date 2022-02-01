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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.am;
import java.lang.ref.WeakReference;

public final class c
  extends BaseSmallView
{
  private int AAu;
  private int AAv;
  private int AJn;
  public com.tencent.mm.plugin.voip.ui.a AKz;
  private OpenGlRender ATH;
  OpenGlView ATI;
  private OpenGlRender ATJ;
  OpenGlView ATK;
  private int[] ATL;
  private int ATM;
  private int ATN;
  boolean ATl;
  RelativeLayout ATm;
  TextView ATn;
  private float ATo;
  boolean ATp;
  private Runnable ATq;
  ImageView fBA;
  private com.tencent.mm.sdk.b.c gmw;
  private boolean mIsStarted;
  private int mStatus;
  private float radius;
  private TextView uhg;
  private TextView vLT;
  private boolean yKB;
  
  public c(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    AppMethodBeat.i(115763);
    this.ATL = null;
    this.ATM = 0;
    this.mStatus = -1;
    this.ATN = 0;
    this.AKz = null;
    this.AAu = 0;
    this.AAv = 0;
    this.yKB = false;
    this.radius = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 12);
    this.ATp = false;
    this.ATq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115758);
        c localc = c.this;
        if ((!localc.ATl) && (localc.ATp))
        {
          localc.ATl = true;
          localc.ATp = false;
          localc.ATI.setVisibility(0);
          localc.ATI.setAlpha(0.0F);
          localc.ATI.animate().alpha(1.0F).setDuration(500L).start();
          localc.ATK.setAlpha(1.0F);
          localc.ATK.animate().alpha(0.0F).setDuration(500L).setListener(new c.5(localc)).start();
        }
        AppMethodBeat.o(115758);
      }
    };
    this.gmw = new c.2(this);
    LayoutInflater.from(paramContext).inflate(2131495887, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.ATm = ((RelativeLayout)findViewById(2131306580));
    this.ATm.setVisibility(4);
    this.fBA = ((ImageView)findViewById(2131306578));
    this.ATn = ((TextView)findViewById(2131306579));
    this.ATo = paramFloat;
    this.ATI = ((OpenGlView)findViewById(2131302998));
    this.ATH = new OpenGlRender(this.ATI, OpenGlRender.RenderRemote);
    this.uhg = ((TextView)findViewById(2131305822));
    this.uhg.setVisibility(0);
    this.vLT = ((TextView)findViewById(2131305880));
    this.vLT.setTextSize(1, 12.0F);
    this.ATI.setRenderer(this.ATH);
    this.ATI.setRenderMode(0);
    this.ATI.setClipToOutline(true);
    this.ATI.setOutlineProvider(new e(12.0F));
    this.ATH.AOE = new OpenGlRender.b()
    {
      public final void elr()
      {
        AppMethodBeat.i(208591);
        if ((c.this.AJQ != null) && (c.this.AJQ.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.AJQ.get()).Z(0L, 3);
        }
        AppMethodBeat.o(208591);
      }
      
      public final void yR(long paramAnonymousLong)
      {
        AppMethodBeat.i(208592);
        if ((c.this.AJQ != null) && (c.this.AJQ.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.AJQ.get()).Z(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(208592);
      }
      
      public final void yS(long paramAnonymousLong)
      {
        AppMethodBeat.i(208593);
        if ((c.this.AJQ != null) && (c.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.AJQ.get()).Z(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(208593);
      }
      
      public final void yT(long paramAnonymousLong)
      {
        AppMethodBeat.i(208594);
        if ((c.this.AJQ != null) && (c.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.AJQ.get()).Z(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(208594);
      }
    };
    this.ATI.sW(true);
    this.ATK = ((OpenGlView)findViewById(2131302997));
    this.ATJ = new OpenGlRender(this.ATK, OpenGlRender.RenderLocal);
    this.ATK.setClipToOutline(true);
    this.ATK.setOutlineProvider(new e(this.radius));
    this.ATJ.AOE = new OpenGlRender.b()
    {
      public final void elr()
      {
        AppMethodBeat.i(208595);
        if ((c.this.AJQ != null) && (c.this.AJQ.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.AJQ.get()).Z(0L, 3);
        }
        AppMethodBeat.o(208595);
      }
      
      public final void yR(long paramAnonymousLong)
      {
        AppMethodBeat.i(208596);
        if ((c.this.AJQ != null) && (c.this.AJQ.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.AJQ.get()).Z(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(208596);
      }
      
      public final void yS(long paramAnonymousLong)
      {
        AppMethodBeat.i(208597);
        if ((c.this.AJQ != null) && (c.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.AJQ.get()).Z(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(208597);
      }
      
      public final void yT(long paramAnonymousLong)
      {
        AppMethodBeat.i(208598);
        if ((c.this.AJQ != null) && (c.this.AJQ.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.AJQ.get()).Z(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(208598);
      }
    };
    this.ATK.setVisibility(0);
    this.ATK.setRenderer(this.ATJ);
    this.ATK.setRenderMode(0);
    this.mIsStarted = false;
    this.ATl = false;
    com.tencent.mm.sdk.b.a.GpY.c(this.gmw);
    setContentDescription(paramContext.getString(2131757334));
    AppMethodBeat.o(115763);
  }
  
  private void enr()
  {
    AppMethodBeat.i(184100);
    this.vLT.setVisibility(8);
    this.uhg.setVisibility(8);
    AppMethodBeat.o(184100);
  }
  
  private void enx()
  {
    AppMethodBeat.i(115765);
    if (!this.mIsStarted)
    {
      ac.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", new Object[] { Integer.valueOf(this.ATN) });
      this.mIsStarted = true;
      this.ATH.onStarted();
      this.ATJ.onStarted();
      this.ATJ.setVoipBeauty(this.ATN);
      this.ATH.setVoipBeauty(this.ATN);
      if ((this.AAu != 0) && (this.AAv != 0)) {
        ie(this.AAu, this.AAv);
      }
    }
    AppMethodBeat.o(115765);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    AppMethodBeat.i(115767);
    if ((this.ATJ == null) || (this.ATH == null))
    {
      AppMethodBeat.o(115767);
      return;
    }
    enx();
    this.surfaceTexture = paramSurfaceTexture;
    this.AKY = paramd;
    this.ATJ.a(this.surfaceTexture, this.AKY);
    this.ATH.a(this.surfaceTexture, this.AKY);
    AppMethodBeat.o(115767);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(115774);
    if (8 == this.ATK.getVisibility())
    {
      AppMethodBeat.o(115774);
      return;
    }
    enx();
    if (OpenGlRender.AOo == 1)
    {
      if (this.ATM < paramInt1 * paramInt2) {
        this.ATL = null;
      }
      if (this.ATL == null)
      {
        this.ATM = (paramInt1 * paramInt2);
        this.ATL = new int[this.ATM];
      }
      if ((com.tencent.mm.plugin.voip.c.ehb().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.ATL, false) < 0) || (this.ATL == null))
      {
        AppMethodBeat.o(115774);
        return;
      }
      this.ATJ.a(this.ATL, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      AppMethodBeat.o(115774);
      return;
    }
    if (OpenGlRender.AOo == 2) {
      this.ATJ.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
    }
    AppMethodBeat.o(115774);
  }
  
  public final void ayB(String paramString)
  {
    AppMethodBeat.i(184095);
    AppMethodBeat.o(184095);
  }
  
  public final void ayC(String paramString)
  {
    AppMethodBeat.i(184096);
    if (this.uhg != null)
    {
      this.uhg.setTextSize(1, 12.0F);
      this.uhg.setText(paramString);
    }
    AppMethodBeat.o(184096);
  }
  
  public final void dgi()
  {
    AppMethodBeat.i(184099);
    enr();
    this.ATm.setVisibility(0);
    this.fBA.setImageDrawable(am.k(getContext(), 2131690327, Color.parseColor("#FFFFFF")));
    this.ATn.setText(2131764923);
    super.dgi();
    AppMethodBeat.o(184099);
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115766);
    if ((!this.ATl) && (this.ATp)) {
      h.JZN.aQ(this.ATq);
    }
    enx();
    if (OpenGlRender.AOo == 1)
    {
      this.ATH.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115766);
      return;
    }
    this.ATH.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115766);
  }
  
  public final void elk()
  {
    AppMethodBeat.i(115769);
    if ((this.mIsStarted) && (this.ATJ != null) && (this.ATH != null))
    {
      this.ATJ.emB();
      this.ATH.emB();
    }
    AppMethodBeat.o(115769);
  }
  
  public final boolean ely()
  {
    AppMethodBeat.i(184097);
    super.ely();
    enr();
    this.ATm.setVisibility(0);
    this.fBA.setImageDrawable(am.k(getContext(), 2131690360, Color.parseColor("#FFFFFF")));
    this.ATn.setVisibility(0);
    this.ATn.setText(2131764882);
    this.uhg.setVisibility(8);
    AppMethodBeat.o(184097);
    return true;
  }
  
  public final void elz()
  {
    AppMethodBeat.i(184102);
    this.vLT.setVisibility(8);
    this.ATm.setVisibility(8);
    AppMethodBeat.o(184102);
  }
  
  public final void enq()
  {
    AppMethodBeat.i(184094);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.ATp)) {
      this.ATK.sW(false);
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
      this.ATK.sW(true);
    }
  }
  
  public final OpenGlRender getBeautyData()
  {
    return this.ATJ;
  }
  
  public final void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115771);
    ac.i("MicroMsg.Voip.TalkingSmallView", "adjustHWViewAspectRatio, mIsStarted:%b, HWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115771);
      return;
    }
    this.AAu = paramInt1;
    this.AAv = paramInt2;
    if ((this.mIsStarted) && (this.ATJ != null) && (this.ATH != null))
    {
      this.ATJ.ie(paramInt1, paramInt2);
      this.ATH.ie(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115771);
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(115779);
    this.ATH.onStarted();
    this.ATJ.onStarted();
    AppMethodBeat.o(115779);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(208601);
    super.onViewAdded(paramView);
    if (this.AJQ != null)
    {
      ac.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if ((this.AJQ != null) && (this.AJQ.get() != null))
      {
        paramView = (com.tencent.mm.plugin.voip.ui.c)this.AJQ.get();
        if ((260 != this.mStatus) && (6 != this.mStatus)) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.ap(false, bool);
          this.ATJ.AOC = true;
          this.ATH.AOC = true;
          AppMethodBeat.o(208601);
          return;
        }
      }
    }
    else
    {
      this.yKB = true;
    }
    AppMethodBeat.o(208601);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115772);
    this.ATJ.releaseSurfaceTexture();
    this.ATH.releaseSurfaceTexture();
    AppMethodBeat.o(115772);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115768);
    this.ATI.ANw.requestRender();
    AppMethodBeat.o(115768);
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(184101);
    if (paramBoolean)
    {
      this.vLT.setVisibility(0);
      this.vLT.setText(2131764894);
      this.uhg.setVisibility(8);
      AppMethodBeat.o(184101);
      return;
    }
    super.sM(false);
    AppMethodBeat.o(184101);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115776);
    ac.l("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
    if (this.otK != null)
    {
      removeView(this.otK);
      this.otK = null;
    }
    if (paramCaptureView != null)
    {
      this.otK = paramCaptureView;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(1, 1);
      localLayoutParams.leftMargin = 20;
      localLayoutParams.topMargin = 20;
      addView(paramCaptureView, localLayoutParams);
      paramCaptureView.setVisibility(0);
      ac.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
    }
    AppMethodBeat.o(115776);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115773);
    this.AJn = paramInt;
    ac.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, hwdec: %d, before changeSurfaceRender", new Object[] { Integer.valueOf(this.AJn) });
    if ((this.ATJ != null) && (this.ATH != null))
    {
      this.ATJ.Ta(0);
      if ((this.AJn & 0x1) == 0) {
        break label121;
      }
      this.ATH.Ta(1);
    }
    for (;;)
    {
      ac.i("MicroMsg.Voip.TalkingSmallView", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d, after changeSurfaceRender", new Object[] { Integer.valueOf(this.ATJ.AOw), Integer.valueOf(this.ATH.AOw) });
      enx();
      AppMethodBeat.o(115773);
      return;
      label121:
      this.ATH.Ta(0);
    }
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(115780);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.ATp = true;
      this.ATI.sW(true);
      this.ATK.setVisibility(0);
      this.ATK.sW(false);
      this.uhg.setVisibility(0);
    }
    this.gqT.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208600);
        if (c.this.findViewById(2131306577) != null) {
          c.this.findViewById(2131306577).setVisibility(8);
        }
        AppMethodBeat.o(208600);
      }
    }, 3000L);
    ac.m("czf", "set status is %s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus != 0))
    {
      this.ATI.setVisibility(0);
      this.ATI.sW(false);
      this.ATK.sW(true);
      this.uhg.setText("");
      this.uhg.setVisibility(8);
    }
    AppMethodBeat.o(115780);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184098);
    if (this.AzM != paramInt)
    {
      enr();
      this.AzM = paramInt;
      this.ATm.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.uhg.setVisibility(8);
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(184098);
      return;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690357, Color.parseColor("#FFFFFF")));
      this.ATn.setText(2131764878);
      continue;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
      this.ATn.setText(2131764881);
      continue;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690395, Color.parseColor("#FFFFFF")));
      this.ATn.setText(2131764879);
      continue;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690411, Color.parseColor("#FFFFFF")));
      this.ATn.setText(2131764880);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115770);
    ac.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt) });
    this.ATN = paramInt;
    if ((this.mIsStarted) && (this.ATJ != null) && (this.ATH != null))
    {
      this.ATJ.setVoipBeauty(paramInt);
      this.ATH.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115770);
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(208602);
    super.setVoipUIListener(paramc);
    if ((this.yKB) && (this.AJQ != null) && (this.AJQ.get() != null))
    {
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.AJQ.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      paramc.ap(false, bool);
      this.ATJ.AOC = true;
      this.ATH.AOC = true;
      this.yKB = false;
      AppMethodBeat.o(208602);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115775);
    super.uninit();
    com.tencent.mm.sdk.b.a.GpY.d(this.gmw);
    setVisibility(4);
    if (this.mIsStarted)
    {
      this.ATH.emA();
      this.ATJ.emA();
    }
    AppMethodBeat.o(115775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.c
 * JD-Core Version:    0.7.0.1
 */