package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.Timer;

public class VoipVoiceFragment
  extends VoipBaseFragment
{
  private boolean kMD;
  private Runnable lym;
  private boolean mIsMute;
  private Timer mTimer;
  private TextView nXc;
  private boolean tDO;
  private Button tDm;
  private View tEA;
  private RelativeLayout tEB;
  private MMCheckBox tEC;
  private TextView tED;
  private RelativeLayout tEE;
  private MMCheckBox tEF;
  private TextView tEG;
  private TextView tEH;
  private TextView tEI;
  private VoipBigIconButton tEJ;
  private VoipBigIconButton tEK;
  private VoipBigIconButton tEL;
  private VoipBigIconButton tEM;
  private VoipSmallIconButton tEN;
  private boolean tEO;
  private OpenGlRender tEP;
  private View.OnClickListener tEQ;
  private View.OnClickListener tER;
  private View.OnClickListener tES;
  private View.OnClickListener tET;
  private View.OnClickListener tEU;
  private View.OnClickListener tEV;
  private View.OnClickListener tEh;
  private View.OnClickListener tEi;
  private View tEt;
  private ImageView tEu;
  private TextView tEv;
  private TextView tEw;
  private TextView tEx;
  private TextView tEy;
  private TextView tEz;
  private int txp;
  
  public VoipVoiceFragment()
  {
    AppMethodBeat.i(4949);
    this.txp = 1;
    this.mIsMute = false;
    this.kMD = false;
    this.tDO = false;
    this.tEO = false;
    this.tEh = new VoipVoiceFragment.1(this);
    this.tEi = new VoipVoiceFragment.3(this);
    this.tEQ = new VoipVoiceFragment.4(this);
    this.tER = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(4943);
        boolean bool = VoipVoiceFragment.b(VoipVoiceFragment.this).isChecked();
        ab.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.tCc != null) && (VoipVoiceFragment.this.tCc.get() != null)) {
          ((c)VoipVoiceFragment.this.tCc.get()).jx(bool);
        }
        VoipVoiceFragment.a(VoipVoiceFragment.this, bool);
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(true);
        AppMethodBeat.o(4943);
      }
    };
    this.tES = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(4944);
        ab.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
        h.qsU.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(2) });
        if ((VoipVoiceFragment.this.tCc != null) && (VoipVoiceFragment.this.tCc.get() != null) && (((c)VoipVoiceFragment.this.tCc.get()).cMO()))
        {
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.d(VoipVoiceFragment.this).setText(2131304766);
          VoipVoiceFragment.this.tCA.a(VoipVoiceFragment.e(VoipVoiceFragment.this), VoipBaseFragment.tCt);
          VoipVoiceFragment.f(VoipVoiceFragment.this).setVisibility(0);
          VoipVoiceFragment.g(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.c(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.h(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.i(VoipVoiceFragment.this).setVisibility(0);
        }
        AppMethodBeat.o(4944);
      }
    };
    this.tET = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(4945);
        ab.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
        h.qsU.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(5) });
        if ((VoipVoiceFragment.this.tCc != null) && (VoipVoiceFragment.this.tCc.get() != null) && (((c)VoipVoiceFragment.this.tCc.get()).cMN()))
        {
          VoipVoiceFragment.h(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.this.gm(2131304727, -1);
          if (VoipVoiceFragment.this.tCz != null) {
            VoipVoiceFragment.this.tCz.U(true, false);
          }
        }
        AppMethodBeat.o(4945);
      }
    };
    this.tEU = new VoipVoiceFragment.8(this);
    this.tEV = new VoipVoiceFragment.9(this);
    this.lym = new VoipVoiceFragment.10(this);
    AppMethodBeat.o(4949);
  }
  
  private void HH(int paramInt)
  {
    AppMethodBeat.i(4955);
    this.tEt.setVisibility(0);
    this.tEx.setVisibility(8);
    this.tEy.setText(2131304698);
    this.tCA.a(this.tEz, tCt);
    this.tEA.setVisibility(0);
    if (this.tEw != null)
    {
      if ((!ad.arf(this.eaX)) || (bo.aa(this.tEw.getText()))) {
        break label279;
      }
      this.tEw.setVisibility(0);
    }
    for (;;)
    {
      this.tEJ.setVisibility(8);
      this.tEK.setVisibility(8);
      this.tEL.setVisibility(8);
      this.tEM.setVisibility(0);
      this.tEN.setVisibility(8);
      this.tEE.setVisibility(0);
      this.tEF.setEnabled(false);
      this.tEF.setBackgroundResource(2130840783);
      this.tEG.setTextColor(1728053247);
      cPn();
      this.tEF.setChecked(this.mIsMute);
      this.tEB.setVisibility(0);
      if ((paramInt != 4097) && (2 == this.txp)) {
        gm(2131304614, 10000);
      }
      cOX();
      this.tEI.setVisibility(8);
      if (com.tencent.mm.plugin.voip.b.cLC().txI != null)
      {
        this.tEI.setVisibility(0);
        this.tEI.setText(com.tencent.mm.plugin.voip.b.cLC().txI);
      }
      if (tCy == 2) {
        this.tEO = true;
      }
      AppMethodBeat.o(4955);
      return;
      label279:
      this.tEw.setVisibility(8);
    }
  }
  
  private void arF()
  {
    AppMethodBeat.i(4966);
    if ((this.mTimer == null) || (this.kMD))
    {
      AppMethodBeat.o(4966);
      return;
    }
    if (-1L == this.tCd) {
      this.tCd = bo.aox();
    }
    this.kMD = true;
    VoipVoiceFragment.2 local2 = new VoipVoiceFragment.2(this);
    this.mTimer.schedule(local2, 50L, 1000L);
    AppMethodBeat.o(4966);
  }
  
  private void cPe()
  {
    AppMethodBeat.i(4954);
    this.tEt.setVisibility(0);
    this.tEx.setVisibility(8);
    this.tEy.setText(2131304720);
    this.tCA.a(this.tEz, tCt);
    this.tEA.setVisibility(0);
    this.tEJ.setVisibility(8);
    this.tEK.setVisibility(8);
    this.tEL.setVisibility(8);
    this.tEM.setVisibility(0);
    this.tEN.setVisibility(8);
    this.tEE.setVisibility(0);
    this.tEF.setEnabled(false);
    this.tEF.setBackgroundResource(2130840783);
    this.tEG.setTextColor(1728053247);
    this.tEI.setVisibility(8);
    if (com.tencent.mm.plugin.voip.b.cLC().txI != null)
    {
      this.tEI.setVisibility(0);
      this.tEI.setText(com.tencent.mm.plugin.voip.b.cLC().txI);
    }
    cPn();
    this.tEF.setChecked(this.mIsMute);
    this.tEB.setVisibility(0);
    if (2 == this.txp) {
      gm(2131304614, 10000);
    }
    cOX();
    AppMethodBeat.o(4954);
  }
  
  private void cPi()
  {
    AppMethodBeat.i(4956);
    this.tEy.setText(2131304766);
    this.tCA.a(this.tEz, tCt);
    this.tEJ.setVisibility(8);
    this.tEK.setVisibility(8);
    this.tEL.setVisibility(0);
    this.tEM.setVisibility(8);
    this.tEN.setVisibility(8);
    AppMethodBeat.o(4956);
  }
  
  private void cPj()
  {
    AppMethodBeat.i(4957);
    this.tCA.cOZ();
    this.tEL.setEnabled(false);
    this.tEM.setEnabled(false);
    this.tEJ.setEnabled(false);
    this.tEK.setEnabled(false);
    this.tEN.setEnabled(false);
    AppMethodBeat.o(4957);
  }
  
  private void cPk()
  {
    AppMethodBeat.i(4958);
    this.tEt.setVisibility(0);
    this.tEA.setVisibility(0);
    this.tEy.setText(2131304699);
    this.tCA.a(this.tEz, tCt);
    if (this.tEw != null)
    {
      if ((!ad.arf(this.eaX)) || (bo.aa(this.tEw.getText()))) {
        break label211;
      }
      this.tEw.setVisibility(0);
    }
    for (;;)
    {
      cPn();
      this.tEJ.setVisibility(0);
      this.tEK.setVisibility(0);
      this.tEL.setVisibility(8);
      this.tEM.setVisibility(8);
      if (this.tDO) {
        this.tEN.setVisibility(0);
      }
      if (tCy == 256)
      {
        this.tEO = true;
        gm(2131304615, 10000);
      }
      cOX();
      this.tEI.setVisibility(8);
      if (com.tencent.mm.plugin.voip.b.cLC().txI != null)
      {
        this.tEI.setVisibility(0);
        this.tEI.setText(com.tencent.mm.plugin.voip.b.cLC().txI);
      }
      AppMethodBeat.o(4958);
      return;
      label211:
      this.tEw.setVisibility(8);
    }
  }
  
  private void cPl()
  {
    AppMethodBeat.i(4959);
    this.tEt.setVisibility(0);
    this.tEA.setVisibility(0);
    this.tEy.setText(2131304766);
    this.tCA.a(this.tEz, tCt);
    this.tEJ.setVisibility(8);
    this.tEK.setVisibility(8);
    this.tEL.setVisibility(0);
    this.tEM.setVisibility(8);
    this.tEN.setVisibility(8);
    gm(2131304614, 10000);
    cOX();
    AppMethodBeat.o(4959);
  }
  
  private void cPm()
  {
    AppMethodBeat.i(4960);
    this.tEM.setVisibility(8);
    this.tEJ.setVisibility(8);
    this.tEK.setVisibility(8);
    this.tEN.setVisibility(8);
    this.tEA.setVisibility(8);
    this.tCA.cOZ();
    this.tEL.setVisibility(0);
    this.tEx.setVisibility(0);
    this.tEE.setVisibility(0);
    this.tEB.setVisibility(0);
    this.tEt.setVisibility(0);
    this.tDm.setVisibility(0);
    this.tEF.setEnabled(true);
    this.tEF.setBackgroundResource(2130840772);
    this.tEG.setTextColor(-1);
    cPn();
    this.tEF.setChecked(this.mIsMute);
    if (!this.tEO) {
      gm(2131304607, 10000);
    }
    for (;;)
    {
      cOX();
      arF();
      this.tEI.setVisibility(8);
      if (com.tencent.mm.plugin.voip.b.cLC().txI != null)
      {
        this.tEI.setVisibility(0);
        this.tEI.setText(com.tencent.mm.plugin.voip.b.cLC().txI);
      }
      AppMethodBeat.o(4960);
      return;
      if (2 == this.txp) {
        gm(2131304609, 10000);
      } else if (3 == this.txp) {
        gm(2131304608, 10000);
      }
    }
  }
  
  private void cPn()
  {
    AppMethodBeat.i(4968);
    if ((this.tEC == null) || (this.tED == null))
    {
      ab.e("MicroMsg.VoipVoiceFragment", "speaker is null");
      AppMethodBeat.o(4968);
      return;
    }
    if ((4 == this.txp) || (3 == this.txp))
    {
      this.tEC.setEnabled(false);
      this.tED.setTextColor(1728053247);
      this.tEC.setBackgroundResource(2130840769);
      ab.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, disable mCbVoiceSpeakerSwitcher");
      AppMethodBeat.o(4968);
      return;
    }
    if (this.txp == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.tEC.setBackgroundResource(2130840773);
      this.tEC.setEnabled(true);
      this.tED.setTextColor(-1);
      this.tEC.setChecked(bool);
      ab.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, set mCbVoiceSpeakerSwitcher isChecked:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(4968);
      return;
    }
  }
  
  public final void HF(int paramInt)
  {
    AppMethodBeat.i(4967);
    this.txp = paramInt;
    cPn();
    AppMethodBeat.o(4967);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt) {}
  
  public final void a(CaptureView paramCaptureView) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  protected final void aeH(String paramString)
  {
    AppMethodBeat.i(4961);
    if (this.tEI != null)
    {
      this.tEI.setVisibility(0);
      this.tEI.setText(paramString);
    }
    AppMethodBeat.o(4961);
  }
  
  public final void cNc() {}
  
  public final void cOQ() {}
  
  public final OpenGlRender cOU()
  {
    return null;
  }
  
  protected final void cOV()
  {
    AppMethodBeat.i(4964);
    if (this.nXc != null)
    {
      this.nXc.clearAnimation();
      this.nXc.setVisibility(8);
    }
    AppMethodBeat.o(4964);
  }
  
  public final void cOW() {}
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public final OpenGlRender getFilterData()
  {
    return this.tEP;
  }
  
  public final void gj(int paramInt1, int paramInt2) {}
  
  public final void gl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4952);
    super.gl(paramInt1, paramInt2);
    ab.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.a.b.HN(paramInt2) + ", action: " + com.tencent.mm.plugin.voip.a.b.HN(paramInt1) + ", lastStatus: " + com.tencent.mm.plugin.voip.a.b.HN(tCy) + ", isSwitchFromVideo: " + this.tEO);
    if (this.tCu == null)
    {
      ab.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(4952);
      return;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(4952);
      return;
      cPe();
      AppMethodBeat.o(4952);
      return;
      HH(paramInt1);
      AppMethodBeat.o(4952);
      return;
      cPi();
      AppMethodBeat.o(4952);
      return;
      cPm();
      AppMethodBeat.o(4952);
      return;
      cPj();
      AppMethodBeat.o(4952);
      return;
      cPk();
      AppMethodBeat.o(4952);
      return;
      cPl();
    }
  }
  
  protected final void gm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4962);
    if (this.tEH == null)
    {
      AppMethodBeat.o(4962);
      return;
    }
    this.tEH.setText(paramInt1);
    this.tEH.setVisibility(0);
    this.tEH.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.tEH.setBackgroundResource(2130840774);
    this.tEH.setCompoundDrawables(null, null, null, null);
    this.tEH.setCompoundDrawablePadding(0);
    this.iMP.removeCallbacks(this.lym);
    if (-1 != paramInt2) {
      this.iMP.postDelayed(this.lym, paramInt2);
    }
    AppMethodBeat.o(4962);
  }
  
  protected final void mZ(boolean paramBoolean)
  {
    AppMethodBeat.i(4963);
    if (this.nXc != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.nXc.setText(2131304711);
    }
    for (;;)
    {
      this.nXc.clearAnimation();
      this.nXc.setVisibility(0);
      AppMethodBeat.o(4963);
      return;
      label49:
      this.nXc.setText(2131304710);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(4951);
    paramBundle = new DisplayMetrics();
    ((WindowManager)paramLayoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
    ab.i("MicroMsg.VoipVoiceFragment", "dpi: " + paramBundle.heightPixels / paramBundle.density);
    if (paramBundle.heightPixels / paramBundle.density <= 540.0F)
    {
      this.tCu = ((RelativeLayout)paramLayoutInflater.inflate(2130971114, paramViewGroup, false));
      this.tCv = ((ImageView)this.tCu.findViewById(2131828841));
      this.tEt = this.tCu.findViewById(2131828878);
      this.tEu = ((ImageView)this.tCu.findViewById(2131828879));
      a.b.a(this.tEu, this.eaX, 0.0375F, true);
      this.tEv = ((TextView)this.tCu.findViewById(2131828881));
      this.tEv.setText(com.tencent.mm.pluginsdk.ui.d.j.b(getActivity(), s.nE(this.eaX), this.tEv.getTextSize()));
      this.tEw = ((TextView)this.tCu.findViewById(2131828882));
      this.tEx = ((TextView)this.tCu.findViewById(2131828894));
      this.tEy = ((TextView)this.tCu.findViewById(2131828884));
      this.tEz = ((TextView)this.tCu.findViewById(2131828885));
      this.tEA = this.tCu.findViewById(2131828883);
      this.tEH = ((TextView)this.tCu.findViewById(2131828893));
      this.tEI = ((TextView)this.tCu.findViewById(2131828892));
      this.nXc = ((TextView)this.tCu.findViewById(2131825222));
      j(this.tEz);
      this.tEE = ((RelativeLayout)this.tCu.findViewById(2131828895));
      this.tEF = ((MMCheckBox)this.tCu.findViewById(2131828896));
      this.tEF.setChecked(this.mIsMute);
      this.tEG = ((TextView)this.tCu.findViewById(2131828897));
      this.tEG.setText(2131304705);
      this.tEB = ((RelativeLayout)this.tCu.findViewById(2131828898));
      this.tEC = ((MMCheckBox)this.tCu.findViewById(2131828899));
      this.tED = ((TextView)this.tCu.findViewById(2131828900));
      this.tED.setText(2131304737);
      cPn();
      this.tEJ = ((VoipBigIconButton)this.tCu.findViewById(2131828888));
      this.tEJ.setOnClickListener(this.tES);
      this.tEK = ((VoipBigIconButton)this.tCu.findViewById(2131828887));
      this.tEK.setOnClickListener(this.tET);
      this.tEL = ((VoipBigIconButton)this.tCu.findViewById(2131828890));
      this.tEL.setOnClickListener(this.tEU);
      this.tEM = ((VoipBigIconButton)this.tCu.findViewById(2131828891));
      this.tEM.setOnClickListener(this.tEV);
      if (d.wp("VOIPBlockIgnoreButton") != 0) {
        break label908;
      }
    }
    label908:
    for (boolean bool = true;; bool = false)
    {
      this.tDO = bool;
      this.tEN = ((VoipSmallIconButton)this.tCu.findViewById(2131828889));
      this.tEN.setOnClickListener(this.tEi);
      if (!this.tDO) {
        this.tEN.setVisibility(8);
      }
      this.tEC.setOnClickListener(this.tEQ);
      this.tEF.setOnClickListener(this.tER);
      this.tDm = ((Button)this.tCu.findViewById(2131828847));
      this.tDm.setOnClickListener(this.tEh);
      int i = com.tencent.mm.ui.base.t.hY(getActivity());
      ab.d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(i)));
      ai(this.tDm, i);
      if ((this.txk) && (2 == this.txp)) {
        gm(2131304614, 10000);
      }
      paramLayoutInflater = a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eaX));
      if (!bo.isNullOrNil(paramLayoutInflater)) {
        this.tEw.setText(paramLayoutInflater);
      }
      this.mTimer = new Timer();
      gl(this.tCx, this.mStatus);
      paramLayoutInflater = this.tCu;
      AppMethodBeat.o(4951);
      return paramLayoutInflater;
      this.tCu = ((RelativeLayout)paramLayoutInflater.inflate(2130971113, paramViewGroup, false));
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break;
      }
      ((RelativeLayout)this.tCu.findViewById(2131828886)).setPadding(0, 0, 0, BackwardSupportUtil.b.b(getActivity(), 40.0F));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(4950);
    this.kMD = false;
    super.onDestroy();
    AppMethodBeat.o(4950);
  }
  
  public final void requestRender() {}
  
  public final void setHWDecMode(int paramInt) {}
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(4965);
    ab.b("MicroMsg.VoipVoiceFragment", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    if ((this.tEF != null) && (this.tEG != null)) {
      this.tEF.setChecked(paramBoolean);
    }
    AppMethodBeat.o(4965);
  }
  
  public final void setVoipBeauty(int paramInt) {}
  
  public final void uninit()
  {
    AppMethodBeat.i(4953);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    super.uninit();
    AppMethodBeat.o(4953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment
 * JD-Core Version:    0.7.0.1
 */