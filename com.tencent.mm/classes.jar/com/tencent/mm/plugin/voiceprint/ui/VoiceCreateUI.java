package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class VoiceCreateUI
  extends BaseVoicePrintUI
  implements l.a
{
  private View iMF = null;
  private int pLx = 1;
  private l pMk;
  private o pMl = null;
  private View pMm;
  private NoiseDetectMaskView pMn;
  private Button pMo = null;
  private int pMp = 0;
  private c pMq = new VoiceCreateUI.1(this);
  
  private void bPn()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("KIsCreateSuccess", false);
    setResult(-1, localIntent);
  }
  
  private void start()
  {
    y.d("MicroMsg.VoiceCreateUI", "start create");
    this.pMl.reset();
    Object localObject = this.pMn;
    if (((NoiseDetectMaskView)localObject).fsc != null) {
      ((NoiseDetectMaskView)localObject).fsc.setVisibility(0);
    }
    ((NoiseDetectMaskView)localObject).kFl.setText(R.l.voice_print_noise_detecting);
    ((NoiseDetectMaskView)localObject).pMe.setVisibility(8);
    y.d("MicroMsg.VoiceCreateUI", "start noise detect");
    this.iMF.setVisibility(4);
    this.pMm.setVisibility(4);
    this.pLQ.setVisibility(4);
    this.pMn.setVisibility(0);
    localObject = this.pMl;
    y.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
    ((o)localObject).reset();
    String str = m.bh("voice_pt_voice_print_noise_detect.rec", true);
    if (!((o)localObject).pLC.cD(str))
    {
      ((o)localObject).pLC.uh();
      ((o)localObject).reset();
      y.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
    }
    for (;;)
    {
      ((o)localObject).pLD.S(100L, 100L);
      return;
      y.d("MicroMsg.VoicePrintNoiseDetector", "start record");
    }
  }
  
  public final void PV(String paramString)
  {
    y.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
    bPe();
    this.pLy = paramString;
    this.pLS.bPr();
    this.pLS.bPs();
    this.pLS.setTipText(paramString);
    this.pLP.setEnabled(true);
  }
  
  public final void PW(String paramString)
  {
    y.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
    this.pLy = paramString;
    this.pLS.bPr();
    this.pLS.bPs();
    this.pLS.setTipText(paramString);
    this.pLP.setEnabled(true);
  }
  
  public final void bPa()
  {
    bPg();
    bPn();
  }
  
  protected final void bPh()
  {
    y.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[] { this.pLU });
    if (!bk.bl(this.pLU))
    {
      this.pLP.setEnabled(false);
      this.pLS.bPq();
      if (this.pLx != 1) {
        break label97;
      }
      locall = this.pMk;
      localf = new f(this.pLU, 71, locall.pLz, 0);
      localf.pLi = true;
      au.Dk().a(localf, 0);
      locall.pLx = 71;
    }
    label97:
    while (this.pLx != 2) {
      return;
    }
    l locall = this.pMk;
    f localf = new f(this.pLU, 72, locall.pLz, locall.pLl);
    localf.pLi = true;
    au.Dk().a(localf, 0);
    locall.pLx = 72;
  }
  
  protected final void beK()
  {
    this.pMk = new l(this);
    findViewById(R.h.right_btn).setVisibility(8);
    this.pLS.setTitleText(R.l.voice_read_title);
    this.pLS.bPt();
    this.pLP.setEnabled(false);
    this.pMl = new o();
    this.pMm = findViewById(R.h.voice_bottom);
    this.pMn = ((NoiseDetectMaskView)findViewById(R.h.mask));
    this.iMF = findViewById(R.h.left_btn);
    this.pMo = ((Button)findViewById(R.h.right_btn));
    this.pMo.setVisibility(8);
    this.pMo.setOnClickListener(new VoiceCreateUI.2(this));
    this.pMn.setOnClickRetryCallback(new VoiceCreateUI.3(this));
    this.pMn.setOnCancelDetectCallback(new VoiceCreateUI.4(this));
    com.tencent.mm.sdk.b.a.udP.c(this.pMq);
    this.iMF.setOnClickListener(new VoiceCreateUI.5(this));
    start();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    bPn();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    l locall = this.pMk;
    au.Dk().b(611, locall);
    au.Dk().b(612, locall);
    locall.pLA = null;
    com.tencent.mm.sdk.b.a.udP.d(this.pMq);
  }
  
  public final void x(boolean paramBoolean, int paramInt)
  {
    y.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 71: 
        y.d("MicroMsg.VoiceCreateUI", "finish create step 1");
        this.pLP.setEnabled(false);
        this.pLx = 2;
        bPf();
        a.a(this.pLS, new VoiceCreateUI.7(this));
        return;
      }
      this.pMp = 0;
      y.d("MicroMsg.VoiceCreateUI", "finish create step 2");
      Intent localIntent = new Intent();
      localIntent.putExtra("KIsCreateSuccess", true);
      setResult(-1, localIntent);
      localIntent = new Intent();
      localIntent.setClass(this, VoicePrintFinishUI.class);
      localIntent.putExtra("kscene_type", 72);
      startActivity(localIntent);
      finish();
      return;
    }
    switch (paramInt)
    {
    case 71: 
    default: 
      return;
    }
    bPn();
    this.pMp += 1;
    if (this.pMp >= 2)
    {
      y.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
      this.pMp = 0;
      startActivity(new Intent(this, VoiceReCreatePromptUI.class));
      overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      finish();
      return;
    }
    this.pLP.setEnabled(true);
    this.pLS.bPr();
    this.pLS.setErr(R.l.voice_regeist_error);
    this.pLS.bPu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI
 * JD-Core Version:    0.7.0.1
 */