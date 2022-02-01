package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;

public class VoiceCreateUI
  extends BaseVoicePrintUI
  implements l.a
{
  private View naW;
  private View oah;
  private int zdD;
  private l zer;
  private o zes;
  private NoiseDetectMaskView zet;
  private Button zeu;
  private int zev;
  private c zew;
  
  public VoiceCreateUI()
  {
    AppMethodBeat.i(29849);
    this.zes = null;
    this.oah = null;
    this.zeu = null;
    this.zdD = 1;
    this.zev = 0;
    this.zew = new c() {};
    AppMethodBeat.o(29849);
  }
  
  private void dRB()
  {
    AppMethodBeat.i(29853);
    ad.d("MicroMsg.VoiceCreateUI", "start noise detect");
    this.oah.setVisibility(4);
    this.naW.setVisibility(4);
    this.zdX.setVisibility(4);
    this.zet.setVisibility(0);
    this.zes.dRq();
    AppMethodBeat.o(29853);
  }
  
  private void dRC()
  {
    AppMethodBeat.i(29859);
    Intent localIntent = new Intent();
    localIntent.putExtra("KIsCreateSuccess", false);
    setResult(-1, localIntent);
    AppMethodBeat.o(29859);
  }
  
  private void start()
  {
    AppMethodBeat.i(29852);
    ad.d("MicroMsg.VoiceCreateUI", "start create");
    this.zes.reset();
    this.zet.reset();
    dRB();
    AppMethodBeat.o(29852);
  }
  
  public final void P(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(29856);
    ad.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    Object localObject;
    if (paramBoolean)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(29856);
        return;
        ad.d("MicroMsg.VoiceCreateUI", "finish create step 1");
        this.zdW.setEnabled(false);
        this.zdD = 2;
        dRt();
        a.a(this.zdZ, new a.a()
        {
          public final void dRw()
          {
            AppMethodBeat.i(29848);
            VoiceCreateUI.this.zdZ.reset();
            VoiceCreateUI.this.zdZ.dRF();
            VoiceCreateUI.this.zdZ.dRG();
            VoiceCreateUI.this.zdW.setVisibility(4);
            VoiceCreateUI.this.zdZ.setTitleText(2131764747);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(0);
            VoiceCreateUI.this.zdZ.cQI();
            AppMethodBeat.o(29848);
          }
          
          public final void dRx() {}
        });
        AppMethodBeat.o(29856);
        return;
        this.zev = 0;
        ad.d("MicroMsg.VoiceCreateUI", "finish create step 2");
        localObject = new Intent();
        ((Intent)localObject).putExtra("KIsCreateSuccess", true);
        setResult(-1, (Intent)localObject);
        localObject = new Intent();
        ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
        ((Intent)localObject).putExtra("kscene_type", 72);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
      }
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29856);
      return;
      AppMethodBeat.o(29856);
      return;
      dRC();
      this.zev += 1;
      if (this.zev >= 2)
      {
        ad.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
        this.zev = 0;
        localObject = new Intent(this, VoiceReCreatePromptUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(2130772144, 2130772141);
        finish();
        AppMethodBeat.o(29856);
        return;
      }
      this.zdW.setEnabled(true);
      this.zdZ.cQI();
      this.zdZ.setErr(2131764752);
      this.zdZ.dRH();
    }
  }
  
  public final void asZ(String paramString)
  {
    AppMethodBeat.i(29854);
    ad.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
    dRs();
    this.zdE = paramString;
    this.zdZ.cQI();
    this.zdZ.dRF();
    this.zdZ.setTipText(paramString);
    this.zdW.setEnabled(true);
    AppMethodBeat.o(29854);
  }
  
  public final void ata(String paramString)
  {
    AppMethodBeat.i(29855);
    ad.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
    this.zdE = paramString;
    this.zdZ.cQI();
    this.zdZ.dRF();
    this.zdZ.setTipText(paramString);
    this.zdW.setEnabled(true);
    AppMethodBeat.o(29855);
  }
  
  public final void atb(String paramString)
  {
    AppMethodBeat.i(191275);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = getString(2131764735);
    }
    this.zdZ.cQI();
    this.zdZ.setErr(str);
    this.zdZ.dRH();
    dRC();
    AppMethodBeat.o(191275);
  }
  
  protected final void cKf()
  {
    AppMethodBeat.i(29851);
    this.zer = new l(this);
    findViewById(2131304179).setVisibility(8);
    this.zdZ.setTitleText(2131764750);
    this.zdZ.dRG();
    this.zdW.setEnabled(false);
    this.zes = new o();
    this.naW = findViewById(2131306481);
    this.zet = ((NoiseDetectMaskView)findViewById(2131302160));
    this.oah = findViewById(2131301383);
    this.zeu = ((Button)findViewById(2131304179));
    this.zeu.setVisibility(8);
    this.zeu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29843);
        VoiceCreateUI.this.dRt();
        a.a(VoiceCreateUI.this.zdZ, new a.a()
        {
          public final void dRw()
          {
            AppMethodBeat.i(29842);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(8);
            VoiceCreateUI.this.zdZ.setTitleText(2131764750);
            VoiceCreateUI.this.zdZ.uDc.setVisibility(0);
            VoiceCreateUI.this.zdW.setEnabled(true);
            VoiceCreateUI.this.zdW.setVisibility(0);
            AppMethodBeat.o(29842);
          }
          
          public final void dRx() {}
        });
        AppMethodBeat.o(29843);
      }
    });
    this.zet.setOnClickRetryCallback(new NoiseDetectMaskView.b()
    {
      public final void dRz()
      {
        AppMethodBeat.i(29844);
        h.vKh.f(11390, new Object[] { Integer.valueOf(5) });
        VoiceCreateUI.d(VoiceCreateUI.this);
        AppMethodBeat.o(29844);
      }
    });
    this.zet.setOnCancelDetectCallback(new NoiseDetectMaskView.a()
    {
      public final void dRy()
      {
        AppMethodBeat.i(29845);
        VoiceCreateUI.e(VoiceCreateUI.this);
        o localo = VoiceCreateUI.f(VoiceCreateUI.this);
        ad.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
        localo.zdI.Ob();
        localo.zdJ.stopTimer();
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(29845);
      }
    });
    com.tencent.mm.sdk.b.a.ESL.c(this.zew);
    this.oah.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29846);
        VoiceCreateUI.e(VoiceCreateUI.this);
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(29846);
      }
    });
    start();
    AppMethodBeat.o(29851);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(29857);
    dRu();
    dRC();
    AppMethodBeat.o(29857);
  }
  
  protected final void dRv()
  {
    AppMethodBeat.i(29850);
    ad.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[] { this.zeb });
    if (!bt.isNullOrNil(this.zeb))
    {
      this.zdW.setEnabled(false);
      this.zdZ.cQH();
      l locall;
      f localf;
      if (this.zdD == 1)
      {
        locall = this.zer;
        localf = new f(this.zeb, 71, locall.zdF, 0);
        localf.zdo = true;
        az.aeS().a(localf, 0);
        locall.zdD = 71;
        AppMethodBeat.o(29850);
        return;
      }
      if (this.zdD == 2)
      {
        locall = this.zer;
        localf = new f(this.zeb, 72, locall.zdF, locall.zdr);
        localf.zdo = true;
        az.aeS().a(localf, 0);
        locall.zdD = 72;
      }
    }
    AppMethodBeat.o(29850);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(29861);
    super.onBackPressed();
    dRC();
    AppMethodBeat.o(29861);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29860);
    super.onDestroy();
    l locall = this.zer;
    az.aeS().b(611, locall);
    az.aeS().b(612, locall);
    locall.zdG = null;
    com.tencent.mm.sdk.b.a.ESL.d(this.zew);
    AppMethodBeat.o(29860);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI
 * JD-Core Version:    0.7.0.1
 */