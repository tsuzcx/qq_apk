package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v4.app.FragmentActivity;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.MovableTextureView;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public final class e
  extends d
{
  private TextView lzQ;
  private Timer mTimer;
  Bitmap muQ = null;
  int[] muz = null;
  private CaptureView pRW;
  private TextView pXA;
  private TextView pXB;
  private TextView pXC;
  private View pXD;
  private TextView pXE;
  private TextView pXF;
  private TextView pXG;
  private RelativeLayout pXH;
  private Button pXI;
  private VoipSmallIconButton pXJ;
  private VoipSmallIconButton pXK;
  private VoipSmallIconButton pXL;
  private VoipBigIconButton pXM;
  private VoipBigIconButton pXN;
  private VoipBigIconButton pXO;
  private VoipBigIconButton pXP;
  private VoipBigIconButton pXQ;
  private VoipBigIconButton pXR;
  private TextView pXS;
  private TextView pXT;
  private TextView pXU;
  private TextView pXV;
  private TextView pXW;
  private TextView pXX;
  private VoIPVideoView pXY;
  private f pXZ = null;
  private OpenGlView pXu;
  private OpenGlView pXv;
  private OpenGlRender pXw;
  private OpenGlRender pXx;
  private View pXy;
  private ImageView pXz;
  private View.OnClickListener pYA = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      y.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
      if ((e.this.pWz != null) && (e.this.pWz.get() != null) && (((c)e.this.pWz.get()).bQs()))
      {
        e.a(e.this).setEnabled(false);
        e.b(e.this).setEnabled(false);
        e.this.cD(e.this.getString(a.e.voip_finish_call), -1);
      }
    }
  };
  private View.OnClickListener pYB = new e.12(this);
  private View.OnClickListener pYC = new e.16(this);
  private View.OnClickListener pYD = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      y.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
      if ((aq.isWifi(e.this.getActivity())) || (q.bQY()))
      {
        e.c(e.this);
        return;
      }
      h.a(e.this.getActivity(), a.e.voip_not_wifi_warnning_message, a.e.voip_not_wifi_warnning_title, new e.17.1(this), new e.17.2(this));
    }
  };
  private View.OnClickListener pYE = new e.18(this);
  private View.OnClickListener pYF = new e.19(this);
  private View.OnClickListener pYG = new e.20(this);
  private View.OnClickListener pYH = new e.21(this);
  private View.OnClickListener pYI = new e.22(this);
  private View.OnClickListener pYJ = new e.2(this);
  private View.OnClickListener pYK = new e.3(this);
  private View.OnClickListener pYL = new e.7(this);
  private Runnable pYM = new e.8(this);
  private Runnable pYN = new e.9(this);
  int pYO = 0;
  private Button pYa = null;
  private Button pYb = null;
  private boolean pYc = false;
  private int pYd;
  private int pYe;
  private int pYf;
  private int pYg;
  private int pYh;
  private int pYi = 0;
  private boolean pYj = false;
  private boolean pYk = false;
  private boolean pYl = false;
  private boolean pYm;
  public long pYn = 0L;
  private Bitmap pYo = null;
  private e.a pYp;
  public MMTextureView pYq;
  public MMTextureView pYr;
  private boolean pYs = false;
  public int pYt = 0;
  public int pYu = 0;
  private int pYv = 0;
  private int pYw = 0;
  private HandlerThread pYx = null;
  private am pYy = null;
  private boolean pYz = false;
  
  private void b(CaptureView paramCaptureView)
  {
    if ((this.pWQ == null) || (paramCaptureView == null)) {
      return;
    }
    this.pWQ.removeView(this.pRW);
    this.pRW = null;
    this.pRW = paramCaptureView;
    this.pWQ.addView(paramCaptureView, new RelativeLayout.LayoutParams(1, 1));
    this.pRW.setVisibility(0);
    this.pRW.setAlpha(0.0F);
    y.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
  }
  
  private void bSe()
  {
    y.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
    this.pYi += 1;
    this.hcZ.postDelayed(this.pYM, 10000L);
  }
  
  private Point kc(boolean paramBoolean)
  {
    int i = (int)(getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5.0D);
    float f = i;
    com.tencent.mm.plugin.voip.b.bPx();
    return new Point((int)(f * com.tencent.mm.plugin.voip.model.r.ka(paramBoolean)), i);
  }
  
  public final void Ap(int paramInt) {}
  
  protected final void Qa(String paramString)
  {
    if (this.pXG != null)
    {
      this.pXG.setVisibility(0);
      this.pXG.setText(paramString);
    }
  }
  
  public final void a(CaptureView paramCaptureView)
  {
    this.pRW = paramCaptureView;
    b(this.pRW);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (!this.pYl) {}
    do
    {
      return;
      if (OpenGlRender.qbn != 1) {
        break;
      }
      if (this.pYO < paramInt1 * paramInt2) {
        this.muz = null;
      }
      if (this.muz == null)
      {
        this.pYO = (paramInt1 * paramInt2);
        this.muz = new int[this.pYO];
      }
    } while ((com.tencent.mm.plugin.voip.b.bPx().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.muz, true) < 0) || (this.muz == null));
    if (this.pYj) {
      this.pXw.a(this.muz, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
    }
    for (;;)
    {
      this.pYe += 1;
      if (paramInt6 > 0) {
        this.pYd += 1;
      }
      paramArrayOfByte = this.pXZ;
      paramArrayOfByte.qax = paramInt1;
      paramArrayOfByte.qay = paramInt2;
      paramArrayOfByte = this.pXZ;
      paramInt1 = this.pWQ.getWidth();
      paramInt2 = this.pWQ.getHeight();
      paramArrayOfByte.qaw = paramInt1;
      paramArrayOfByte.fx = paramInt2;
      return;
      this.pXx.a(this.muz, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      continue;
      if (OpenGlRender.qbn == 2) {
        if (this.pYj) {
          this.pXw.c(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true);
        } else {
          this.pXx.c(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true);
        }
      }
    }
  }
  
  public final void bQK()
  {
    if (!this.pYl) {
      return;
    }
    this.pXx.bSz();
    this.pXw.bSz();
  }
  
  public final void bRS()
  {
    if (this.pRW != null)
    {
      this.pWQ.removeView(this.pRW);
      this.pWQ.addView(this.pRW, new RelativeLayout.LayoutParams(1, 1));
      this.pRW.setVisibility(0);
      this.pRW.setAlpha(0.0F);
      y.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
    }
  }
  
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
  
  public final void c(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (!this.pYl) {
      return;
    }
    this.pYf += 1;
    if (OpenGlRender.qbn == 1)
    {
      if (this.pYj)
      {
        this.pXx.a(paramArrayOfInt, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90, false);
        return;
      }
      this.pXw.a(paramArrayOfInt, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90, false);
      return;
    }
    if (this.pYj)
    {
      this.pXx.a(paramArrayOfInt, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
      return;
    }
    this.pXw.a(paramArrayOfInt, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
  }
  
  protected final void cD(String paramString, int paramInt)
  {
    if (this.pXF == null) {}
    do
    {
      return;
      this.pXF.setText(bk.pm(paramString));
      this.pXF.setVisibility(0);
      this.pXF.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.pXF.setBackgroundResource(a.a.voip_toast_bg);
      this.pXF.setCompoundDrawables(null, null, null, null);
      this.pXF.setCompoundDrawablePadding(0);
      this.hcZ.removeCallbacks(this.pYN);
    } while (-1 == paramInt);
    this.hcZ.postDelayed(this.pYN, paramInt);
  }
  
  public final void en(int paramInt1, int paramInt2)
  {
    super.en(paramInt1, paramInt2);
    y.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.a.b.At(paramInt2));
    if (this.pWQ == null) {
      y.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        switch (paramInt2)
        {
        default: 
          return;
        case 0: 
        case 2: 
          this.pXD.setVisibility(0);
          this.pXu.setVisibility(0);
          this.pXB.setText(a.e.voip_invite_waiting_tip);
          this.pWR.setVisibility(8);
          this.pXF.setVisibility(8);
          this.pXG.setVisibility(8);
          if (com.tencent.mm.plugin.voip.b.bPx().pSz != null)
          {
            this.pXG.setVisibility(0);
            this.pXG.setText(com.tencent.mm.plugin.voip.b.bPx().pSz);
          }
          this.pWW.a(this.pXC, pWP);
          this.pXR.setVisibility(8);
          this.pXQ.setVisibility(8);
          this.pXM.setVisibility(0);
          this.pXP.setVisibility(8);
          this.pXO.setVisibility(8);
          this.pXL.setVisibility(8);
          this.pXN.setVisibility(8);
          this.pXK.setVisibility(0);
          this.pXJ.setVisibility(8);
          return;
        case 256: 
          this.pXu.setVisibility(0);
          if (this.pWS != null) {
            bSb();
          }
          this.pXy.setVisibility(0);
          this.pXA.setVisibility(0);
          this.pXB.setText(a.e.voip_invited_video_tip);
          this.pXD.setVisibility(0);
          this.pXz.setVisibility(0);
          this.pWW.a(this.pXC, pWP);
          this.pXR.setVisibility(8);
          this.pXQ.setVisibility(8);
          this.pXM.setVisibility(8);
          this.pXP.setVisibility(8);
          this.pXO.setVisibility(0);
          this.pXL.setVisibility(0);
          this.pXN.setVisibility(0);
          this.pXK.setVisibility(8);
          if (this.pYm) {
            this.pXJ.setVisibility(0);
          }
          this.pXG.setVisibility(8);
        }
      } while (com.tencent.mm.plugin.voip.b.bPx().pSz == null);
      this.pXG.setVisibility(0);
      this.pXG.setText(com.tencent.mm.plugin.voip.b.bPx().pSz);
      return;
      localObject = new e.15(this);
      this.pWQ.setOnClickListener((View.OnClickListener)localObject);
      if (this.pWS != null) {
        this.pWS.setVisibility(8);
      }
    } while (this.pXv.getVisibility() == 0);
    boolean bool;
    if (this.pSc) {
      if (!this.pYj)
      {
        bool = true;
        label570:
        this.pYj = bool;
        if (this.pYj) {
          break label935;
        }
        bool = true;
        label584:
        localObject = kc(bool);
        this.pXv.eq(((Point)localObject).x, ((Point)localObject).y);
        if (com.tencent.mm.platformtools.ae.eTA)
        {
          this.pXS.setVisibility(0);
          this.pXT.setVisibility(0);
          this.pXU.setVisibility(0);
          this.pXV.setVisibility(0);
          this.pXW.setVisibility(0);
          this.pXX.setVisibility(0);
        }
        this.pXy.setVisibility(8);
        this.pXu.setVisibility(0);
        this.pXv.setVisibility(0);
        this.pYq.setVisibility(0);
        this.pXE.setVisibility(0);
        this.pXI.setVisibility(0);
        this.pXR.setVisibility(0);
        this.pXQ.setVisibility(0);
        this.pXM.setVisibility(8);
        this.pXP.setVisibility(0);
        this.pXO.setVisibility(8);
        this.pXL.setVisibility(8);
        this.pXN.setVisibility(8);
        this.pXK.setVisibility(8);
        this.pXJ.setVisibility(8);
        setHWDecMode(this.pYt);
        y.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[] { Integer.valueOf(this.pYt) });
        if (this.pYj) {
          break label971;
        }
        bool = true;
        label829:
        localObject = kc(bool);
        ((MovableVideoView)this.pXv).eo(((Point)localObject).x, ((Point)localObject).y);
        if ((this.mTimer != null) && (!this.pYk)) {
          break label976;
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.ae.cqS().getBoolean("voipfaceDebug", false))
      {
        this.pYa.setVisibility(0);
        this.pYb.setVisibility(0);
      }
      bSe();
      if (this.pWT != 4102) {
        break;
      }
      cD(getString(a.e.voip_accept_invite_normal), 10000);
      return;
      bool = false;
      break label570;
      label935:
      bool = false;
      break label584;
      if (!this.pYj) {}
      for (bool = true;; bool = false)
      {
        this.pYj = bool;
        this.pXY.setVisibility(8);
        break;
      }
      label971:
      bool = false;
      break label829;
      label976:
      if (-1L == this.pWA) {
        this.pWA = bk.UX();
      }
      this.pYn = this.pWA;
      this.pYk = true;
      localObject = new e.13(this);
      this.mTimer.schedule((TimerTask)localObject, 1000L, 1000L);
      this.pYx = com.tencent.mm.sdk.f.e.aap("VoipVideoFragment_cpuStatThread");
      this.pYx.start();
      this.pYy = new am(this.pYx.getLooper(), new e.14(this), true);
      this.pYz = true;
      this.pYy.S(1000L, 1000L);
    }
    this.pWW.bSc();
    this.pXM.setEnabled(false);
    this.pXQ.setEnabled(false);
    this.pXP.setEnabled(false);
    this.pXO.setEnabled(false);
    this.pXN.setEnabled(false);
    this.pXL.setEnabled(false);
    this.pXR.setEnabled(false);
    this.pXK.setEnabled(false);
    this.pXJ.setEnabled(false);
    switch (paramInt1)
    {
    }
    while (this.pWV != null)
    {
      this.pWV.J(true, false);
      return;
      this.pXF.setVisibility(0);
      this.pXF.setText(a.e.voip_no_resp);
    }
    this.pXB.setText(a.e.voip_waitting);
    this.pWW.a(this.pXC, pWP);
  }
  
  public final OpenGlRender getFilterData()
  {
    if (this.pYj) {
      return this.pXw;
    }
    return this.pXx;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.pWQ = ((RelativeLayout)paramLayoutInflater.inflate(a.c.voip_video_fragment, paramViewGroup, false));
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.rl_video_controllers)).setPadding(0, 0, 0, BackwardSupportUtil.b.b(getActivity(), 40.0F));
    }
    this.pWR = ((ImageView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_blur_avatar));
    this.pWS = ((ImageView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_transparent_blur));
    this.pXH = ((RelativeLayout)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.ll_voip_mask));
    this.pXu = ((OpenGlView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.big_video));
    this.pXu.ep(mScreenWidth, mScreenHeight);
    this.pYq = ((MMTextureView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.hwView));
    this.pYq.setVisibility(0);
    y.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
    if (this.pYq != null) {
      y.i("MicroMsg.Voip.VoipVideoFragment", "hwView creat ok");
    }
    this.pXR = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_switch_camera));
    this.pXR.setOnClickListener(this.pYL);
    this.pXQ = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_switch_to_voice));
    this.pXQ.setOnClickListener(this.pYB);
    this.pXM = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_cancel_video_invite));
    this.pXM.setOnClickListener(this.pYG);
    this.pXP = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_hangup_video_talking));
    this.pXP.setOnClickListener(this.pYA);
    this.pXO = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_accept_video_invite));
    this.pXO.setOnClickListener(this.pYE);
    this.pXL = ((VoipSmallIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_accept_video_invite_use_voice));
    this.pXL.setOnClickListener(this.pYD);
    this.pXN = ((VoipBigIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_reject_video_invite));
    this.pXN.setOnClickListener(this.pYF);
    this.pXK = ((VoipSmallIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_switchto_audio_invite));
    this.pXK.setOnClickListener(this.pYC);
    boolean bool;
    if (com.tencent.mm.plugin.voip.a.d.oX("VOIPBlockIgnoreButton") == 0)
    {
      bool = true;
      this.pYm = bool;
      this.pXJ = ((VoipSmallIconButton)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_ignore_video_invite));
      this.pXJ.setOnClickListener(this.pYI);
      if (!this.pYm) {
        this.pXJ.setVisibility(8);
      }
      this.pXE = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_time));
      this.pXy = this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_remote_talker_container);
      this.pXz = ((ImageView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_remote_talker_avatar));
      com.tencent.mm.pluginsdk.ui.a.b.a(this.pXz, this.djD, 0.0588235F, true);
      this.pXA = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_remote_talker_name));
      this.pXB = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_calling_status));
      this.pXC = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_calling_status_dot));
      this.pXD = this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_calling_status_ctn);
      c(this.pXC, getResources().getString(a.e.voip_three_dot));
      this.pXF = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_call_hint));
      this.pXG = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_video_risk_call_hint));
      this.pXI = ((Button)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.btn_minimize_voip));
      this.lzQ = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_net_status_hint));
      if (com.tencent.mm.platformtools.ae.eTA)
      {
        this.pXS = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_cap_fps));
        this.pXT = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_send_fps));
        this.pXU = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_recv_fps));
        this.pXV = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_send_kbps));
        this.pXW = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_recv_kbps));
        this.pXX = ((TextView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.engineInfo));
      }
      this.pYa = ((Button)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_face_debug));
      this.pYb = ((Button)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_face_debug_switch));
      this.pYa.setVisibility(8);
      this.pYb.setVisibility(8);
      this.pYa.setOnClickListener(this.pYJ);
      this.pYb.setOnClickListener(this.pYK);
      this.pXZ = new f(getActivity());
      this.pWQ.addView(this.pXZ);
      this.pXZ.setVisibility(8);
      this.pXI.setOnClickListener(this.pYH);
      b(this.pRW);
      int i = s.gO(getActivity());
      y.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: " + i);
      Q(this.pXI, i);
      Q(this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_time_tv_container), i);
      Q(this.pXy, i);
      this.pYe = 0;
      this.pYd = 0;
      this.pYf = 0;
      this.pYg = 0;
      this.pYh = 0;
      this.pYv = 0;
      this.pYw = 0;
      paramLayoutInflater = (WindowManager)getActivity().getSystemService("window");
      i = paramLayoutInflater.getDefaultDisplay().getHeight() / 5;
      int j = paramLayoutInflater.getDefaultDisplay().getWidth() * i / paramLayoutInflater.getDefaultDisplay().getHeight();
      this.pXv = new MovableVideoView(getActivity().getApplicationContext());
      ((MovableVideoView)this.pXv).eo(j, i);
      this.pXv.setVisibility(8);
      this.pXw = new OpenGlRender(this.pXv, OpenGlRender.RenderRemote);
      this.pXv.setRenderer(this.pXw);
      this.pXv.setRenderMode(0);
      this.pXx = new OpenGlRender(this.pXu, OpenGlRender.RenderLocal);
      this.pXu.setRenderer(this.pXx);
      this.pXu.setRenderMode(0);
      this.pXu.setVisibility(0);
      y.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
      this.pYr = new MovableTextureView(getActivity().getApplicationContext());
      paramLayoutInflater = (MovableTextureView)this.pYr;
      paramLayoutInflater.mWidth = j;
      paramLayoutInflater.qav = i;
      paramViewGroup = new DisplayMetrics();
      paramBundle = (WindowManager)paramLayoutInflater.getContext().getSystemService("window");
      if (paramLayoutInflater.mScreenWidth == 0)
      {
        paramLayoutInflater.mScreenWidth = paramBundle.getDefaultDisplay().getWidth();
        paramLayoutInflater.mScreenHeight = paramBundle.getDefaultDisplay().getHeight();
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, i);
      localLayoutParams.topMargin = (a.fromDPToPix(paramLayoutInflater.getContext(), 12) + s.gO(paramLayoutInflater.getContext()));
      localLayoutParams.leftMargin = (paramLayoutInflater.mScreenWidth - paramLayoutInflater.mWidth - localLayoutParams.topMargin + s.gO(paramLayoutInflater.getContext()));
      paramLayoutInflater.setLayoutParams(localLayoutParams);
      paramLayoutInflater.qaN = (paramLayoutInflater.mScreenHeight - paramLayoutInflater.qav);
      paramLayoutInflater.qaO = (paramLayoutInflater.mScreenWidth - paramLayoutInflater.mWidth);
      paramBundle.getDefaultDisplay().getMetrics(paramViewGroup);
      y.i("MicroMsg.MovableTextureView", "steve: Init MovableTextureView successfully! size=" + j + " x " + i);
      this.pYr.setVisibility(8);
      ((c)this.pWz.get()).b(this.pYq);
      if (!Build.MODEL.equals("Nexus 6")) {
        break label1685;
      }
      this.pXv.setZOrderOnTop(true);
    }
    for (;;)
    {
      this.pWQ.addView(this.pXv);
      this.pXv.setOnClickListener(new e.4(this));
      this.pYr.setOnClickListener(new e.5(this));
      this.pXA.setText(j.a(getActivity(), com.tencent.mm.model.r.gV(this.djD), this.pXA.getTextSize()));
      if (this.pSc) {
        this.hcZ.postDelayed(new e.6(this), 2000L);
      }
      this.pXY = ((VoIPVideoView)this.pWQ.findViewById(com.tencent.mm.plugin.voip.a.b.voip_talking_video_view));
      this.mTimer = new Timer("VoIP_video_talking_count");
      y.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", new Object[] { Integer.valueOf(this.pYu) });
      this.pXx.setVoipBeauty(this.pYu);
      this.pXw.setVoipBeauty(this.pYu);
      this.pYl = true;
      en(0, this.mStatus);
      return this.pWQ;
      bool = false;
      break;
      label1685:
      this.pXv.setZOrderMediaOverlay(true);
    }
  }
  
  public final void onDestroy()
  {
    this.pYk = false;
    super.onDestroy();
  }
  
  public final void onDetach()
  {
    y.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if ((this.pYy != null) && (this.pYx != null))
    {
      this.pYy.stopTimer();
      this.pYx.quit();
    }
    this.pYz = false;
    super.onDetach();
  }
  
  public final void onStart()
  {
    this.pXx.qaX = true;
    this.pXw.qaX = true;
    super.onStart();
  }
  
  public final void onStop()
  {
    this.pXx.bSy();
    this.pXw.bSy();
    super.onStop();
  }
  
  public final void setHWDecMode(int paramInt)
  {
    boolean bool;
    if (this.hcZ != null)
    {
      if ((paramInt & 0x1) == 0) {
        break label61;
      }
      bool = true;
      y.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label66;
      }
      this.hcZ.post(new Runnable()
      {
        public final void run()
        {
          e.this.pYq.setVisibility(4);
          e.this.pYr.setVisibility(4);
          e.l(e.this).setVisibility(0);
          e.l(e.this).bringToFront();
          e.m(e.this).setVisibility(0);
        }
      });
    }
    for (;;)
    {
      this.pYt = paramInt;
      return;
      label61:
      bool = false;
      break;
      label66:
      y.i("MicroMsg.Voip.VoipVideoFragment", "use hw texture");
      this.hcZ.post(new e.11(this));
    }
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    y.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.pYl) });
    this.pYu = paramInt;
    if (!this.pYl) {
      return;
    }
    this.pXx.setVoipBeauty(this.pYu);
    this.pXw.setVoipBeauty(this.pYu);
  }
  
  public final void uninit()
  {
    this.pXv.setVisibility(4);
    if (this.pRW != null)
    {
      this.pWQ.removeView(this.pRW);
      this.pRW = null;
      y.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
    }
    if (this.pYp != null)
    {
      com.tencent.mm.sdk.f.e.remove(this.pYp);
      this.pYp = null;
    }
    super.uninit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e
 * JD-Core Version:    0.7.0.1
 */