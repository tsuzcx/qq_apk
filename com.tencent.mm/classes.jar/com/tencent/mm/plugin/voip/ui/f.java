package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import java.lang.ref.WeakReference;
import java.util.Timer;

public final class f
  extends d
{
  private TextView lzQ;
  private boolean mIsMute = false;
  private Timer mTimer;
  private int pSh = 1;
  private Button pXI;
  private View.OnClickListener pYH = new f.1(this);
  private View.OnClickListener pYI = new f.3(this);
  private Runnable pYN = new f.10(this);
  private View pYU;
  private ImageView pYV;
  private TextView pYW;
  private TextView pYX;
  private TextView pYY;
  private TextView pYZ;
  private boolean pYk = false;
  private boolean pYm = false;
  private View pZa;
  private RelativeLayout pZb;
  private MMCheckBox pZc;
  private TextView pZd;
  private RelativeLayout pZe;
  private MMCheckBox pZf;
  private TextView pZg;
  private TextView pZh;
  private TextView pZi;
  private VoipBigIconButton pZj;
  private VoipBigIconButton pZk;
  private VoipBigIconButton pZl;
  private VoipBigIconButton pZm;
  private VoipSmallIconButton pZn;
  private boolean pZo = false;
  private OpenGlRender pZp;
  private View.OnClickListener pZq = new f.4(this);
  private View.OnClickListener pZr = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = f.b(f.this).isChecked();
      y.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[] { Boolean.valueOf(bool) });
      f.b(f.this).setEnabled(false);
      if ((f.this.pWz != null) && (f.this.pWz.get() != null)) {
        ((c)f.this.pWz.get()).hE(bool);
      }
      f.a(f.this, bool);
      f.b(f.this).setEnabled(true);
    }
  };
  private View.OnClickListener pZs = new f.6(this);
  private View.OnClickListener pZt = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      y.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
      h.nFQ.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(5) });
      if ((f.this.pWz != null) && (f.this.pWz.get() != null) && (((c)f.this.pWz.get()).bQx()))
      {
        f.h(f.this).setEnabled(false);
        f.c(f.this).setEnabled(false);
        f.this.cD(f.this.getString(a.e.voip_reject_call), -1);
        if (f.this.pWV != null) {
          f.this.pWV.J(true, false);
        }
      }
    }
  };
  private View.OnClickListener pZu = new f.8(this);
  private View.OnClickListener pZv = new f.9(this);
  
  private void bSf()
  {
    boolean bool = false;
    if ((this.pZc == null) || (this.pZd == null))
    {
      y.e("MicroMsg.VoipVoiceFragment", "speaker is null");
      return;
    }
    if ((4 == this.pSh) || (3 == this.pSh))
    {
      this.pZc.setEnabled(false);
      this.pZd.setTextColor(1728053247);
      this.pZc.setBackgroundResource(a.a.voip_speaker_disable);
      return;
    }
    if (this.pSh == 1) {
      bool = true;
    }
    this.pZc.setBackgroundResource(a.a.voip_switch_speaker_btn);
    this.pZc.setEnabled(true);
    this.pZd.setTextColor(-1);
    this.pZc.setChecked(bool);
  }
  
  public final void Ap(int paramInt)
  {
    this.pSh = paramInt;
    bSf();
  }
  
  protected final void Qa(String paramString)
  {
    if (this.pZi != null)
    {
      this.pZi.setVisibility(0);
      this.pZi.setText(paramString);
    }
  }
  
  public final void a(CaptureView paramCaptureView) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public final void bQK() {}
  
  protected final void bRY()
  {
    if (this.lzQ != null)
    {
      this.lzQ.clearAnimation();
      this.lzQ.setVisibility(0);
    }
  }
  
  protected final void bRZ()
  {
    if (this.lzQ != null)
    {
      this.lzQ.clearAnimation();
      this.lzQ.setVisibility(8);
    }
  }
  
  public final void c(int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  protected final void cD(String paramString, int paramInt)
  {
    if (this.pZh == null) {}
    do
    {
      return;
      this.pZh.setText(bk.pm(paramString));
      this.pZh.setVisibility(0);
      this.pZh.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.pZh.setBackgroundResource(a.a.voip_toast_bg);
      this.pZh.setCompoundDrawables(null, null, null, null);
      this.pZh.setCompoundDrawablePadding(0);
      this.hcZ.removeCallbacks(this.pYN);
    } while (-1 == paramInt);
    this.hcZ.postDelayed(this.pYN, paramInt);
  }
  
  public final void en(int paramInt1, int paramInt2)
  {
    super.en(paramInt1, paramInt2);
    y.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.a.b.At(paramInt2) + ", action: " + com.tencent.mm.plugin.voip.a.b.At(paramInt1) + ", lastStatus: " + com.tencent.mm.plugin.voip.a.b.At(pWU) + ", isSwitchFromVideo: " + this.pZo);
    if (this.pWQ == null) {
      y.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
    }
    label857:
    do
    {
      do
      {
        return;
        switch (paramInt2)
        {
        default: 
          return;
        case 1: 
          this.pYU.setVisibility(0);
          this.pYX.setVisibility(8);
          this.pYY.setText(a.e.voip_outcalling);
          this.pWW.a(this.pYZ, pWP);
          this.pZa.setVisibility(0);
          this.pZj.setVisibility(8);
          this.pZk.setVisibility(8);
          this.pZl.setVisibility(8);
          this.pZm.setVisibility(0);
          this.pZn.setVisibility(8);
          this.pZe.setVisibility(0);
          this.pZf.setEnabled(false);
          this.pZf.setBackgroundResource(a.a.voip_voiceoff_disable);
          this.pZg.setTextColor(1728053247);
          this.pZi.setVisibility(8);
          if (com.tencent.mm.plugin.voip.b.bPx().pSz != null)
          {
            this.pZi.setVisibility(0);
            this.pZi.setText(com.tencent.mm.plugin.voip.b.bPx().pSz);
          }
          bSf();
          this.pZf.setChecked(this.mIsMute);
          this.pZb.setVisibility(0);
          if (2 == this.pSh) {
            cD(getString(a.e.voip_audio_talking_hint), 10000);
          }
          bSa();
          return;
        case 3: 
          this.pYU.setVisibility(0);
          this.pYX.setVisibility(8);
          this.pYY.setText(a.e.voip_invite_waiting_tip);
          this.pWW.a(this.pYZ, pWP);
          this.pZa.setVisibility(0);
          this.pZj.setVisibility(8);
          this.pZk.setVisibility(8);
          this.pZl.setVisibility(8);
          this.pZm.setVisibility(0);
          this.pZn.setVisibility(8);
          this.pZe.setVisibility(0);
          this.pZf.setEnabled(false);
          this.pZf.setBackgroundResource(a.a.voip_voiceoff_disable);
          this.pZg.setTextColor(1728053247);
          bSf();
          this.pZf.setChecked(this.mIsMute);
          this.pZb.setVisibility(0);
          if ((paramInt1 != 4097) && (2 == this.pSh)) {
            cD(getString(a.e.voip_audio_talking_hint), 10000);
          }
          bSa();
          this.pZi.setVisibility(8);
          if (com.tencent.mm.plugin.voip.b.bPx().pSz != null)
          {
            this.pZi.setVisibility(0);
            this.pZi.setText(com.tencent.mm.plugin.voip.b.bPx().pSz);
          }
          break;
        }
      } while (pWU != 2);
      this.pZo = true;
      return;
      this.pYY.setText(a.e.voip_waitting);
      this.pWW.a(this.pYZ, pWP);
      this.pZj.setVisibility(8);
      this.pZk.setVisibility(8);
      this.pZl.setVisibility(0);
      this.pZm.setVisibility(8);
      this.pZn.setVisibility(8);
      return;
      this.pZm.setVisibility(8);
      this.pZj.setVisibility(8);
      this.pZk.setVisibility(8);
      this.pZn.setVisibility(8);
      this.pZa.setVisibility(8);
      this.pWW.bSc();
      this.pZl.setVisibility(0);
      this.pYX.setVisibility(0);
      this.pZe.setVisibility(0);
      this.pZb.setVisibility(0);
      this.pYU.setVisibility(0);
      this.pXI.setVisibility(0);
      this.pZf.setEnabled(true);
      this.pZf.setBackgroundResource(a.a.voip_switch_audio_btn);
      this.pZg.setTextColor(-1);
      bSf();
      this.pZf.setChecked(this.mIsMute);
      if (!this.pZo)
      {
        cD(getString(a.e.voip_accept_invite_normal), 10000);
        bSa();
        if ((this.mTimer != null) && (!this.pYk)) {
          break label965;
        }
      }
      for (;;)
      {
        this.pZi.setVisibility(8);
        if (com.tencent.mm.plugin.voip.b.bPx().pSz == null) {
          break;
        }
        this.pZi.setVisibility(0);
        this.pZi.setText(com.tencent.mm.plugin.voip.b.bPx().pSz);
        return;
        if (2 == this.pSh)
        {
          cD(getString(a.e.voip_accept_invite_video_to_audio_without_headset), 10000);
          break label857;
        }
        if (3 != this.pSh) {
          break label857;
        }
        cD(getString(a.e.voip_accept_invite_video_to_audio_with_headset), 10000);
        break label857;
        if (-1L == this.pWA) {
          this.pWA = bk.UX();
        }
        this.pYk = true;
        f.2 local2 = new f.2(this);
        this.mTimer.schedule(local2, 50L, 1000L);
      }
      this.pWW.bSc();
      this.pZl.setEnabled(false);
      this.pZm.setEnabled(false);
      this.pZj.setEnabled(false);
      this.pZk.setEnabled(false);
      this.pZn.setEnabled(false);
      return;
      this.pYU.setVisibility(0);
      this.pZa.setVisibility(0);
      this.pYY.setText(a.e.voip_invited_audio_tip);
      this.pWW.a(this.pYZ, pWP);
      bSf();
      this.pZj.setVisibility(0);
      this.pZk.setVisibility(0);
      this.pZl.setVisibility(8);
      this.pZm.setVisibility(8);
      if (this.pYm) {
        this.pZn.setVisibility(0);
      }
      if (pWU == 256)
      {
        this.pZo = true;
        cD(getString(a.e.voip_audio_talking_hint_from), 10000);
      }
      bSa();
      this.pZi.setVisibility(8);
    } while (com.tencent.mm.plugin.voip.b.bPx().pSz == null);
    label965:
    this.pZi.setVisibility(0);
    this.pZi.setText(com.tencent.mm.plugin.voip.b.bPx().pSz);
    return;
    this.pYU.setVisibility(0);
    this.pZa.setVisibility(0);
    this.pYY.setText(a.e.voip_waitting);
    this.pWW.a(this.pYZ, pWP);
    this.pZj.setVisibility(8);
    this.pZk.setVisibility(8);
    this.pZl.setVisibility(0);
    this.pZm.setVisibility(8);
    this.pZn.setVisibility(8);
    cD(getString(a.e.voip_audio_talking_hint), 10000);
    bSa();
  }
  
  public final OpenGlRender getFilterData()
  {
    return this.pZp;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = new DisplayMetrics();
    ((WindowManager)paramLayoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
    y.i("MicroMsg.VoipVoiceFragment", "dpi: " + paramBundle.heightPixels / paramBundle.density);
    if (paramBundle.heightPixels / paramBundle.density <= 540.0F)
    {
      this.pWQ = ((RelativeLayout)paramLayoutInflater.inflate(a.c.voip_voice_fragment_for_small_screen, paramViewGroup, false));
      this.pWR = ((ImageView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_blur_avatar));
      this.pYU = this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_avatar_and_status_ctn);
      this.pYV = ((ImageView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_remote_talker_avatar));
      com.tencent.mm.pluginsdk.ui.a.b.a(this.pYV, this.djD, 0.0375F, true);
      this.pYW = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_remote_talker_name));
      this.pYW.setText(j.a(getActivity(), com.tencent.mm.model.r.gV(this.djD), this.pYW.getTextSize()));
      this.pYX = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_time));
      this.pYY = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_invite_tips));
      this.pYZ = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_invite_tips_dot));
      this.pZa = this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_invite_tips_ctn);
      this.pZh = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_call_hint));
      this.pZi = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_risk_call_hint));
      this.lzQ = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_net_status_hint));
      c(this.pYZ, getResources().getString(a.e.voip_three_dot));
      this.pZe = ((RelativeLayout)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_mic_switcher_container));
      this.pZf = ((MMCheckBox)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_mic_switcher));
      this.pZf.setChecked(this.mIsMute);
      this.pZg = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_mic_switcher_text));
      this.pZg.setText(a.e.voip_mute_on);
      this.pZb = ((RelativeLayout)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_speaker_switcher_container));
      this.pZc = ((MMCheckBox)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_speaker_switcher));
      this.pZd = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_speaker_switcher_text));
      this.pZd.setText(a.e.voip_speaker_on);
      bSf();
      this.pZj = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_accept_invite));
      this.pZj.setOnClickListener(this.pZs);
      this.pZk = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_reject_invite));
      this.pZk.setOnClickListener(this.pZt);
      this.pZl = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_hangup_talking));
      this.pZl.setOnClickListener(this.pZu);
      this.pZm = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_voice_cancel_inviting));
      this.pZm.setOnClickListener(this.pZv);
      if (com.tencent.mm.plugin.voip.a.d.oX("VOIPBlockIgnoreButton") != 0) {
        break label855;
      }
    }
    label855:
    for (boolean bool = true;; bool = false)
    {
      this.pYm = bool;
      this.pZn = ((VoipSmallIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_ignore_voice_invite));
      this.pZn.setOnClickListener(this.pYI);
      if (!this.pYm) {
        this.pZn.setVisibility(8);
      }
      this.pZc.setOnClickListener(this.pZq);
      this.pZf.setOnClickListener(this.pZr);
      this.pXI = ((Button)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.btn_minimize_voip));
      this.pXI.setOnClickListener(this.pYH);
      int i = s.gO(getActivity());
      y.d("MicroMsg.VoipVoiceFragment", "statusHeight: " + i);
      Q(this.pXI, i);
      if ((this.pSc) && (2 == this.pSh)) {
        cD(getString(a.e.voip_audio_talking_hint), 10000);
      }
      this.mTimer = new Timer();
      en(this.pWT, this.mStatus);
      return this.pWQ;
      this.pWQ = ((RelativeLayout)paramLayoutInflater.inflate(a.c.voip_voice_fragment, paramViewGroup, false));
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break;
      }
      ((RelativeLayout)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.rl_voice_controllers)).setPadding(0, 0, 0, BackwardSupportUtil.b.b(getActivity(), 40.0F));
      break;
    }
  }
  
  public final void onDestroy()
  {
    this.pYk = false;
    super.onDestroy();
  }
  
  public final void setHWDecMode(int paramInt) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
    if ((this.pZf != null) && (this.pZg != null)) {
      this.pZf.setChecked(paramBoolean);
    }
  }
  
  public final void setVoipBeauty(int paramInt) {}
  
  public final void uninit()
  {
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    super.uninit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f
 * JD-Core Version:    0.7.0.1
 */