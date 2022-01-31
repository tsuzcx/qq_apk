package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public class VoiceCreateUI
  extends BaseVoicePrintUI
  implements l.a
{
  private View jYD;
  private View kTD;
  private int trt;
  private l tsg;
  private o tsh;
  private NoiseDetectMaskView tsi;
  private Button tsj;
  private int tsk;
  private c tsl;
  
  public VoiceCreateUI()
  {
    AppMethodBeat.i(26168);
    this.tsh = null;
    this.kTD = null;
    this.tsj = null;
    this.trt = 1;
    this.tsk = 0;
    this.tsl = new VoiceCreateUI.1(this);
    AppMethodBeat.o(26168);
  }
  
  private void cLt()
  {
    AppMethodBeat.i(26172);
    ab.d("MicroMsg.VoiceCreateUI", "start noise detect");
    this.kTD.setVisibility(4);
    this.jYD.setVisibility(4);
    this.trM.setVisibility(4);
    this.tsi.setVisibility(0);
    this.tsh.cLi();
    AppMethodBeat.o(26172);
  }
  
  private void cLu()
  {
    AppMethodBeat.i(26177);
    Intent localIntent = new Intent();
    localIntent.putExtra("KIsCreateSuccess", false);
    setResult(-1, localIntent);
    AppMethodBeat.o(26177);
  }
  
  private void start()
  {
    AppMethodBeat.i(26171);
    ab.d("MicroMsg.VoiceCreateUI", "start create");
    this.tsh.reset();
    this.tsi.reset();
    cLt();
    AppMethodBeat.o(26171);
  }
  
  public final void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26175);
    ab.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(26175);
        return;
        ab.d("MicroMsg.VoiceCreateUI", "finish create step 1");
        this.trL.setEnabled(false);
        this.trt = 2;
        cLl();
        a.a(this.trO, new VoiceCreateUI.7(this));
        AppMethodBeat.o(26175);
        return;
        this.tsk = 0;
        ab.d("MicroMsg.VoiceCreateUI", "finish create step 2");
        Intent localIntent = new Intent();
        localIntent.putExtra("KIsCreateSuccess", true);
        setResult(-1, localIntent);
        localIntent = new Intent();
        localIntent.setClass(this, VoicePrintFinishUI.class);
        localIntent.putExtra("kscene_type", 72);
        startActivity(localIntent);
        finish();
      }
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26175);
      return;
      AppMethodBeat.o(26175);
      return;
      cLu();
      this.tsk += 1;
      if (this.tsk >= 2)
      {
        ab.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
        this.tsk = 0;
        startActivity(new Intent(this, VoiceReCreatePromptUI.class));
        overridePendingTransition(2131034266, 2131034263);
        finish();
        AppMethodBeat.o(26175);
        return;
      }
      this.trL.setEnabled(true);
      this.trO.bRO();
      this.trO.setErr(2131304579);
      this.trO.cLz();
    }
  }
  
  public final void aeB(String paramString)
  {
    AppMethodBeat.i(26173);
    ab.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
    cLk();
    this.tru = paramString;
    this.trO.bRO();
    this.trO.cLx();
    this.trO.setTipText(paramString);
    this.trL.setEnabled(true);
    AppMethodBeat.o(26173);
  }
  
  public final void aeC(String paramString)
  {
    AppMethodBeat.i(26174);
    ab.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
    this.tru = paramString;
    this.trO.bRO();
    this.trO.cLx();
    this.trO.setTipText(paramString);
    this.trL.setEnabled(true);
    AppMethodBeat.o(26174);
  }
  
  protected final void bMe()
  {
    AppMethodBeat.i(26170);
    this.tsg = new l(this);
    findViewById(2131823890).setVisibility(8);
    this.trO.setTitleText(2131304577);
    this.trO.cLy();
    this.trL.setEnabled(false);
    this.tsh = new o();
    this.jYD = findViewById(2131828768);
    this.tsi = ((NoiseDetectMaskView)findViewById(2131827529));
    this.kTD = findViewById(2131823924);
    this.tsj = ((Button)findViewById(2131823890));
    this.tsj.setVisibility(8);
    this.tsj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26162);
        VoiceCreateUI.this.cLl();
        a.a(VoiceCreateUI.this.trO, new VoiceCreateUI.2.1(this));
        AppMethodBeat.o(26162);
      }
    });
    this.tsi.setOnClickRetryCallback(new VoiceCreateUI.3(this));
    this.tsi.setOnCancelDetectCallback(new NoiseDetectMaskView.a()
    {
      public final void cLq()
      {
        AppMethodBeat.i(26164);
        VoiceCreateUI.e(VoiceCreateUI.this);
        o localo = VoiceCreateUI.f(VoiceCreateUI.this);
        ab.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
        localo.jdField_try.Et();
        localo.trz.stopTimer();
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(26164);
      }
    });
    com.tencent.mm.sdk.b.a.ymk.c(this.tsl);
    this.kTD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26165);
        VoiceCreateUI.e(VoiceCreateUI.this);
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(26165);
      }
    });
    start();
    AppMethodBeat.o(26170);
  }
  
  public final void cLf()
  {
    AppMethodBeat.i(26176);
    cLm();
    cLu();
    AppMethodBeat.o(26176);
  }
  
  public final void cLg()
  {
    AppMethodBeat.i(153682);
    GY(2131304562);
    cLu();
    AppMethodBeat.o(153682);
  }
  
  protected final void cLn()
  {
    AppMethodBeat.i(26169);
    ab.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[] { this.trQ });
    if (!bo.isNullOrNil(this.trQ))
    {
      this.trL.setEnabled(false);
      this.trO.bRN();
      l locall;
      f localf;
      if (this.trt == 1)
      {
        locall = this.tsg;
        localf = new f(this.trQ, 71, locall.trv, 0);
        localf.tre = true;
        aw.Rc().a(localf, 0);
        locall.trt = 71;
        AppMethodBeat.o(26169);
        return;
      }
      if (this.trt == 2)
      {
        locall = this.tsg;
        localf = new f(this.trQ, 72, locall.trv, locall.trh);
        localf.tre = true;
        aw.Rc().a(localf, 0);
        locall.trt = 72;
      }
    }
    AppMethodBeat.o(26169);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26179);
    super.onBackPressed();
    cLu();
    AppMethodBeat.o(26179);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26178);
    super.onDestroy();
    l locall = this.tsg;
    aw.Rc().b(611, locall);
    aw.Rc().b(612, locall);
    locall.trw = null;
    com.tencent.mm.sdk.b.a.ymk.d(this.tsl);
    AppMethodBeat.o(26178);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI
 * JD-Core Version:    0.7.0.1
 */