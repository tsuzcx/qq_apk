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
import com.tencent.mm.g.a.lk;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import com.tencent.mm.plugin.voip.video.GLTextureView.i;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlRender.b;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public final class c
  extends BaseSmallView
{
  private boolean Atj;
  public com.tencent.mm.plugin.voip.ui.a CBf;
  boolean CKX;
  RelativeLayout CKY;
  TextView CKZ;
  private float CLa;
  boolean CLb;
  private Runnable CLc;
  private OpenGlRender CLt;
  OpenGlView CLu;
  private OpenGlRender CLv;
  OpenGlView CLw;
  private int[] CLx;
  private int CLy;
  private int CLz;
  private int CqV;
  private int CqW;
  private int CzS;
  ImageView fWT;
  private com.tencent.mm.sdk.b.c gIM;
  private boolean mIsStarted;
  private int mStatus;
  private float radius;
  private TextView xiT;
  
  public c(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    AppMethodBeat.i(115763);
    this.CLx = null;
    this.CLy = 0;
    this.mStatus = -1;
    this.CLz = 0;
    this.CBf = null;
    this.CqV = 0;
    this.CqW = 0;
    this.Atj = false;
    this.radius = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 12);
    this.CLb = false;
    this.CLc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115758);
        c localc = c.this;
        if ((!localc.CKX) && (localc.CLb))
        {
          localc.CKX = true;
          localc.CLb = false;
          localc.CLu.setVisibility(0);
          localc.CLu.setAlpha(0.0F);
          localc.CLu.animate().alpha(1.0F).setDuration(500L).start();
          localc.CLw.setAlpha(1.0F);
          localc.CLw.animate().alpha(0.0F).setDuration(500L).setListener(new c.5(localc)).start();
        }
        AppMethodBeat.o(115758);
      }
    };
    this.gIM = new com.tencent.mm.sdk.b.c() {};
    LayoutInflater.from(paramContext).inflate(2131495887, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.CKY = ((RelativeLayout)findViewById(2131306580));
    this.CKY.setVisibility(4);
    this.fWT = ((ImageView)findViewById(2131306578));
    this.CKZ = ((TextView)findViewById(2131306579));
    this.CLa = paramFloat;
    this.CLu = ((OpenGlView)findViewById(2131302998));
    this.CLt = new OpenGlRender(this.CLu, OpenGlRender.RenderRemote);
    this.xiT = ((TextView)findViewById(2131305880));
    this.xiT.setTextSize(1, 12.0F);
    this.CLu.setRenderer(this.CLt);
    this.CLu.setRenderMode(0);
    this.CLu.setClipToOutline(true);
    this.CLu.setOutlineProvider(new e(this.radius));
    this.CLt.CFC = new OpenGlRender.b()
    {
      public final void BW(long paramAnonymousLong)
      {
        AppMethodBeat.i(210319);
        if ((c.this.CAv != null) && (c.this.CAv.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CAv.get()).ae(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(210319);
      }
      
      public final void BX(long paramAnonymousLong)
      {
        AppMethodBeat.i(210320);
        if ((c.this.CAv != null) && (c.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CAv.get()).ae(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(210320);
      }
      
      public final void BY(long paramAnonymousLong)
      {
        AppMethodBeat.i(210321);
        if ((c.this.CAv != null) && (c.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CAv.get()).ae(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(210321);
      }
      
      public final void eCJ()
      {
        AppMethodBeat.i(210318);
        if ((c.this.CAv != null) && (c.this.CAv.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CAv.get()).ae(0L, 3);
        }
        AppMethodBeat.o(210318);
      }
    };
    this.CLu.tN(true);
    this.CLw = ((OpenGlView)findViewById(2131302997));
    this.CLv = new OpenGlRender(this.CLw, OpenGlRender.RenderLocal);
    this.CLw.setClipToOutline(true);
    this.CLw.setOutlineProvider(new e(this.radius));
    this.CLv.CFC = new OpenGlRender.b()
    {
      public final void BW(long paramAnonymousLong)
      {
        AppMethodBeat.i(210323);
        if ((c.this.CAv != null) && (c.this.CAv.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CAv.get()).ae(paramAnonymousLong, 2);
        }
        AppMethodBeat.o(210323);
      }
      
      public final void BX(long paramAnonymousLong)
      {
        AppMethodBeat.i(210324);
        if ((c.this.CAv != null) && (c.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CAv.get()).ae(paramAnonymousLong, 0);
        }
        AppMethodBeat.o(210324);
      }
      
      public final void BY(long paramAnonymousLong)
      {
        AppMethodBeat.i(210325);
        if ((c.this.CAv != null) && (c.this.CAv.get() != null) && (paramAnonymousLong > 0L)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CAv.get()).ae(paramAnonymousLong, 1);
        }
        AppMethodBeat.o(210325);
      }
      
      public final void eCJ()
      {
        AppMethodBeat.i(210322);
        if ((c.this.CAv != null) && (c.this.CAv.get() != null)) {
          ((com.tencent.mm.plugin.voip.ui.c)c.this.CAv.get()).ae(0L, 3);
        }
        AppMethodBeat.o(210322);
      }
    };
    this.CLw.setVisibility(0);
    this.CLw.setRenderer(this.CLv);
    this.CLw.setRenderMode(0);
    this.mIsStarted = false;
    this.CKX = false;
    com.tencent.mm.sdk.b.a.IvT.c(this.gIM);
    setContentDescription(paramContext.getString(2131757334));
    AppMethodBeat.o(115763);
  }
  
  private void eEY()
  {
    AppMethodBeat.i(184100);
    this.xiT.setVisibility(8);
    AppMethodBeat.o(184100);
  }
  
  private void eFe()
  {
    AppMethodBeat.i(115765);
    if (!this.mIsStarted)
    {
      ae.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", new Object[] { Integer.valueOf(this.CLz) });
      this.mIsStarted = true;
      this.CLt.onStarted();
      this.CLv.onStarted();
      this.CLv.setVoipBeauty(this.CLz);
      this.CLt.setVoipBeauty(this.CLz);
      if ((this.CqV != 0) && (this.CqW != 0)) {
        iv(this.CqV, this.CqW);
      }
    }
    AppMethodBeat.o(115765);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    AppMethodBeat.i(115767);
    if ((this.CLv == null) || (this.CLt == null))
    {
      AppMethodBeat.o(115767);
      return;
    }
    eFe();
    this.surfaceTexture = paramSurfaceTexture;
    this.CBE = paramd;
    this.CLv.a(this.surfaceTexture, this.CBE);
    this.CLt.a(this.surfaceTexture, this.CBE);
    AppMethodBeat.o(115767);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(115774);
    if (8 == this.CLw.getVisibility())
    {
      AppMethodBeat.o(115774);
      return;
    }
    eFe();
    if (OpenGlRender.CFf == 1)
    {
      if (this.CLy < paramInt1 * paramInt2) {
        this.CLx = null;
      }
      if (this.CLx == null)
      {
        this.CLy = (paramInt1 * paramInt2);
        this.CLx = new int[this.CLy];
      }
      if ((com.tencent.mm.plugin.voip.c.eys().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.CLx, false) < 0) || (this.CLx == null))
      {
        AppMethodBeat.o(115774);
        return;
      }
      this.CLv.a(this.CLx, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      AppMethodBeat.o(115774);
      return;
    }
    if (OpenGlRender.CFf == 2) {
      this.CLv.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
    }
    AppMethodBeat.o(115774);
  }
  
  public final void aFc(String paramString)
  {
    AppMethodBeat.i(184095);
    AppMethodBeat.o(184095);
  }
  
  public final void aFd(String paramString)
  {
    AppMethodBeat.i(184096);
    if (this.xiT != null)
    {
      this.xiT.setTextSize(1, 12.0F);
      this.xiT.setText(paramString);
    }
    AppMethodBeat.o(184096);
  }
  
  public final void dtu()
  {
    AppMethodBeat.i(184099);
    eEY();
    this.CKY.setVisibility(0);
    this.fWT.setImageDrawable(ao.k(getContext(), 2131690327, Color.parseColor("#FFFFFF")));
    this.CKZ.setText(2131764923);
    this.CKZ.requestLayout();
    super.dtu();
    AppMethodBeat.o(184099);
  }
  
  public final void eCC()
  {
    AppMethodBeat.i(115769);
    if ((this.mIsStarted) && (this.CLv != null) && (this.CLt != null))
    {
      this.CLv.eEf();
      this.CLt.eEf();
    }
    AppMethodBeat.o(115769);
  }
  
  public final boolean eCQ()
  {
    AppMethodBeat.i(184097);
    super.eCQ();
    eEY();
    this.CKY.setVisibility(0);
    this.fWT.setImageDrawable(ao.k(getContext(), 2131690360, Color.parseColor("#FFFFFF")));
    this.CKZ.setVisibility(0);
    this.CKZ.setText(2131764882);
    this.CKZ.requestLayout();
    this.xiT.setVisibility(8);
    AppMethodBeat.o(184097);
    return true;
  }
  
  public final void eCR()
  {
    AppMethodBeat.i(184102);
    this.xiT.setVisibility(8);
    this.CKY.setVisibility(8);
    AppMethodBeat.o(184102);
  }
  
  public final void eEX()
  {
    AppMethodBeat.i(184094);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.CLb)) {
      this.CLw.tN(false);
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
      this.CLw.tN(true);
    }
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115766);
    if ((!this.CKX) && (this.CLb)) {
      h.MqF.aM(this.CLc);
    }
    eFe();
    if (OpenGlRender.CFf == 1)
    {
      this.CLt.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(115766);
      return;
    }
    this.CLt.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(115766);
  }
  
  public final OpenGlRender getBeautyData()
  {
    return this.CLv;
  }
  
  public final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115771);
    ae.i("MicroMsg.Voip.TalkingSmallView", "adjustHWViewAspectRatio, mIsStarted:%b, HWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(115771);
      return;
    }
    this.CqV = paramInt1;
    this.CqW = paramInt2;
    if ((this.mIsStarted) && (this.CLv != null) && (this.CLt != null))
    {
      this.CLv.iv(paramInt1, paramInt2);
      this.CLt.iv(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115771);
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(115779);
    this.CLt.onStarted();
    this.CLv.onStarted();
    AppMethodBeat.o(115779);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(210328);
    super.onViewAdded(paramView);
    if (this.CAv != null)
    {
      ae.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if ((this.CAv != null) && (this.CAv.get() != null))
      {
        paramView = (com.tencent.mm.plugin.voip.ui.c)this.CAv.get();
        if ((260 != this.mStatus) && (6 != this.mStatus)) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.at(false, bool);
          this.CLv.CFA = true;
          this.CLt.CFA = true;
          AppMethodBeat.o(210328);
          return;
        }
      }
    }
    else
    {
      this.Atj = true;
    }
    AppMethodBeat.o(210328);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115772);
    this.CLv.releaseSurfaceTexture();
    this.CLt.releaseSurfaceTexture();
    AppMethodBeat.o(115772);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115768);
    this.CLu.CEn.requestRender();
    AppMethodBeat.o(115768);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115776);
    ae.l("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
    if (this.pdJ != null)
    {
      removeView(this.pdJ);
      this.pdJ = null;
    }
    if (paramCaptureView != null)
    {
      this.pdJ = paramCaptureView;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(1, 1);
      localLayoutParams.leftMargin = 20;
      localLayoutParams.topMargin = 20;
      addView(paramCaptureView, localLayoutParams);
      paramCaptureView.setVisibility(0);
      ae.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
    }
    AppMethodBeat.o(115776);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115773);
    this.CzS = paramInt;
    ae.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, hwdec: %d, before changeSurfaceRender", new Object[] { Integer.valueOf(this.CzS) });
    if ((this.CLv != null) && (this.CLt != null))
    {
      this.CLv.VA(0);
      if ((this.CzS & 0x1) == 0) {
        break label121;
      }
      this.CLt.VA(1);
    }
    for (;;)
    {
      ae.i("MicroMsg.Voip.TalkingSmallView", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d, after changeSurfaceRender", new Object[] { Integer.valueOf(this.CLv.CFu), Integer.valueOf(this.CLt.CFu) });
      eFe();
      AppMethodBeat.o(115773);
      return;
      label121:
      this.CLt.VA(0);
    }
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(115780);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.CLb = true;
      this.CLu.tN(true);
      this.CLw.setVisibility(0);
      this.CLw.tN(false);
      this.xiT.setVisibility(0);
    }
    this.gNm.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210327);
        if (c.this.findViewById(2131306577) != null) {
          c.this.findViewById(2131306577).setVisibility(8);
        }
        AppMethodBeat.o(210327);
      }
    }, 3000L);
    ae.m("czf", "set status is %s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus != 0))
    {
      this.CLu.setVisibility(0);
      this.CLu.tN(false);
      this.CLw.tN(true);
      this.xiT.setText("");
      this.xiT.setVisibility(8);
    }
    AppMethodBeat.o(115780);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184098);
    if (this.Cqn != paramInt)
    {
      eEY();
      this.Cqn = paramInt;
      this.CKY.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.CKZ.requestLayout();
      this.xiT.setVisibility(8);
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(184098);
      return;
      this.fWT.setImageDrawable(ao.k(getContext(), 2131690357, Color.parseColor("#FFFFFF")));
      this.CKZ.setText(2131764878);
      continue;
      this.fWT.setImageDrawable(ao.k(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
      this.CKZ.setText(2131764881);
      continue;
      this.fWT.setImageDrawable(ao.k(getContext(), 2131690395, Color.parseColor("#FFFFFF")));
      this.CKZ.setText(2131764879);
      continue;
      this.fWT.setImageDrawable(ao.k(getContext(), 2131690411, Color.parseColor("#FFFFFF")));
      this.CKZ.setText(2131764880);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115770);
    ae.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.mIsStarted), Integer.valueOf(paramInt) });
    this.CLz = paramInt;
    if ((this.mIsStarted) && (this.CLv != null) && (this.CLt != null))
    {
      this.CLv.setVoipBeauty(paramInt);
      this.CLt.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115770);
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(210329);
    super.setVoipUIListener(paramc);
    if ((this.Atj) && (this.CAv != null) && (this.CAv.get() != null))
    {
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.CAv.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      paramc.at(false, bool);
      this.CLv.CFA = true;
      this.CLt.CFA = true;
      this.Atj = false;
      AppMethodBeat.o(210329);
      return;
    }
  }
  
  public final void tC(boolean paramBoolean)
  {
    AppMethodBeat.i(184101);
    if (paramBoolean)
    {
      this.xiT.setVisibility(0);
      this.xiT.setText(2131764894);
      AppMethodBeat.o(184101);
      return;
    }
    super.tC(false);
    AppMethodBeat.o(184101);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115775);
    super.uninit();
    com.tencent.mm.sdk.b.a.IvT.d(this.gIM);
    setVisibility(4);
    if (this.mIsStarted)
    {
      this.CLt.eEe();
      this.CLv.eEe();
    }
    AppMethodBeat.o(115775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.c
 * JD-Core Version:    0.7.0.1
 */