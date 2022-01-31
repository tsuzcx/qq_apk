package com.tencent.mm.plugin.voiceprint.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.1;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.File;

public abstract class BaseVoicePrintUI
  extends MMActivity
{
  private boolean lGI = false;
  private final am lGR = new am(new am.a()
  {
    public final boolean tC()
    {
      if (BaseVoicePrintUI.a(BaseVoicePrintUI.this) == null) {
        return true;
      }
      p localp = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
      if (localp.byP != null)
      {
        i = localp.byP.getMaxAmplitude();
        if (i > p.bEl) {
          p.bEl = i;
        }
        y.d("MicroMsg.VoicePrintRecoder", " map: " + i + " max:" + p.bEl + " per:" + i * 100 / p.bEl);
      }
      for (int i = i * 100 / p.bEl;; i = 0)
      {
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, i);
        return true;
      }
    }
  }, true);
  Button pLP;
  View pLQ;
  VoicePrintVolumeMeter pLR;
  VoiceTipInfoView pLS;
  p pLT = null;
  String pLU = null;
  private boolean pLV = false;
  private View pLW;
  private boolean pLX = false;
  private final p.a pLY = new BaseVoicePrintUI.1(this);
  am pLZ = new am(new BaseVoicePrintUI.4(this), true);
  String pLy = null;
  private ah pMa = new ah(Looper.getMainLooper(), new ah.a()
  {
    public final boolean handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1)
      {
        y.d("MicroMsg.BaseVoicePrintUI", "start record");
        com.tencent.mm.sdk.platformtools.au.b(ae.getContext(), R.l.talkroom_press, new au.a()
        {
          public final void ug()
          {
            y.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
          }
        });
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, "voice_pt_voice_print_record.rec");
        paramAnonymousMessage = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
        Object localObject = BaseVoicePrintUI.d(BaseVoicePrintUI.this);
        BaseVoicePrintUI localBaseVoicePrintUI = BaseVoicePrintUI.this;
        paramAnonymousMessage.fileName = ((String)localObject);
        y.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[] { paramAnonymousMessage.fileName });
        com.tencent.mm.model.au.Hy().a(paramAnonymousMessage);
        int i = com.tencent.mm.model.au.Hy().yk();
        paramAnonymousMessage.pvP = false;
        paramAnonymousMessage.eLi = new b(localBaseVoicePrintUI);
        if (i != 0)
        {
          paramAnonymousMessage.ew(100);
          BaseVoicePrintUI.e(BaseVoicePrintUI.this).S(100L, 100L);
          paramAnonymousMessage = BaseVoicePrintUI.this;
          paramAnonymousMessage.pLS.bPv();
          localObject = paramAnonymousMessage.pLS;
          y.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(((VoiceTipInfoView)localObject).haW.getVisibility()), Boolean.valueOf(((VoiceTipInfoView)localObject).pMU) });
          if ((((VoiceTipInfoView)localObject).haW.getVisibility() != 0) || (((VoiceTipInfoView)localObject).pMU)) {
            break label352;
          }
          ((VoiceTipInfoView)localObject).haW.clearAnimation();
          ((VoiceTipInfoView)localObject).pMU = true;
          a.a(((VoiceTipInfoView)localObject).haW, ((VoiceTipInfoView)localObject).getContext(), new VoiceTipInfoView.3((VoiceTipInfoView)localObject));
        }
        for (;;)
        {
          paramAnonymousMessage.pLS.setTipText(paramAnonymousMessage.pLy);
          paramAnonymousMessage.pLZ.stopTimer();
          paramAnonymousMessage.pLZ.S(500L, 500L);
          paramAnonymousMessage.pLQ.setVisibility(0);
          paramAnonymousMessage = paramAnonymousMessage.pLR;
          paramAnonymousMessage.reset();
          paramAnonymousMessage.mIsPlaying = true;
          localObject = paramAnonymousMessage.pMD;
          long l = VoicePrintVolumeMeter.lHI;
          ((am)localObject).S(l, l);
          paramAnonymousMessage.bPo();
          return true;
          new p.1(paramAnonymousMessage).sendEmptyMessageDelayed(0, 50L);
          break;
          label352:
          y.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
          ((VoiceTipInfoView)localObject).haW.clearAnimation();
          ((VoiceTipInfoView)localObject).haW.setVisibility(4);
          ((VoiceTipInfoView)localObject).haW.invalidate();
        }
      }
      return false;
    }
  });
  
  protected final void bPe()
  {
    ai.l(new BaseVoicePrintUI.7(this), 1300L);
  }
  
  protected final void bPf()
  {
    if ((this.pLW.getVisibility() == 4) || (this.pLW.getVisibility() == 8)) {
      return;
    }
    if (this.pLX)
    {
      this.pLW.setVisibility(4);
      return;
    }
    this.pLX = true;
    a.a(this.pLW, this, new BaseVoicePrintUI.9(this));
  }
  
  protected final void bPg()
  {
    zO(R.l.voice_print_network_error);
  }
  
  protected abstract void bPh();
  
  protected abstract void beK();
  
  protected final int getLayoutId()
  {
    return R.i.voice_print_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    this.pLS = ((VoiceTipInfoView)findViewById(R.h.tip_info_view));
    this.pLP = ((Button)findViewById(R.h.recoder_btn));
    this.pLQ = findViewById(R.h.volume_layout);
    this.pLR = ((VoicePrintVolumeMeter)findViewById(R.h.volume_meter));
    this.pLW = findViewById(R.h.button_press_tips);
    this.pLS.bPv();
    this.pLR.setArchView(this.pLP);
    this.pLT = new p();
    this.pLT.pLK = this.pLY;
    this.pLP.setOnTouchListener(new BaseVoicePrintUI.10(this));
    findViewById(R.h.left_btn).setOnClickListener(new BaseVoicePrintUI.2(this));
    beK();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.pLR;
    ((VoicePrintVolumeMeter)localObject).pMD.stopTimer();
    ((VoicePrintVolumeMeter)localObject).pMC.mnU.getLooper().quit();
    y.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
    y.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
    localObject = new File(m.bh("voice_pt_voice_print_record.rec", false));
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = new File(m.bh("voice_pt_voice_print_noise_detect.rec", false));
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
  }
  
  protected final void zO(int paramInt)
  {
    this.pLS.bPr();
    this.pLS.setErr(paramInt);
    this.pLS.bPu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */