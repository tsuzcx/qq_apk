package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;

public class VoiceCreateUI
  extends BaseVoicePrintUI
  implements l.a
{
  private l AwX;
  private o AwY;
  private NoiseDetectMaskView AwZ;
  private int Awj;
  private Button Axa;
  private int Axb;
  private c Axc;
  private View nDu;
  private View oDG;
  
  public VoiceCreateUI()
  {
    AppMethodBeat.i(29849);
    this.AwY = null;
    this.oDG = null;
    this.Axa = null;
    this.Awj = 1;
    this.Axb = 0;
    this.Axc = new c() {};
    AppMethodBeat.o(29849);
  }
  
  private void egL()
  {
    AppMethodBeat.i(29853);
    ac.d("MicroMsg.VoiceCreateUI", "start noise detect");
    this.oDG.setVisibility(4);
    this.nDu.setVisibility(4);
    this.AwD.setVisibility(4);
    this.AwZ.setVisibility(0);
    this.AwY.egA();
    AppMethodBeat.o(29853);
  }
  
  private void egM()
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
    ac.d("MicroMsg.VoiceCreateUI", "start create");
    this.AwY.reset();
    this.AwZ.reset();
    egL();
    AppMethodBeat.o(29852);
  }
  
  public final void R(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(29856);
    ac.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
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
        ac.d("MicroMsg.VoiceCreateUI", "finish create step 1");
        this.AwC.setEnabled(false);
        this.Awj = 2;
        egD();
        a.a(this.AwF, new a.a()
        {
          public final void egG()
          {
            AppMethodBeat.i(29848);
            VoiceCreateUI.this.AwF.reset();
            VoiceCreateUI.this.AwF.egQ();
            VoiceCreateUI.this.AwF.egR();
            VoiceCreateUI.this.AwC.setVisibility(4);
            VoiceCreateUI.this.AwF.setTitleText(2131764747);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(0);
            VoiceCreateUI.this.AwF.der();
            AppMethodBeat.o(29848);
          }
          
          public final void egH() {}
        });
        AppMethodBeat.o(29856);
        return;
        this.Axb = 0;
        ac.d("MicroMsg.VoiceCreateUI", "finish create step 2");
        localObject = new Intent();
        ((Intent)localObject).putExtra("KIsCreateSuccess", true);
        setResult(-1, (Intent)localObject);
        localObject = new Intent();
        ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
        ((Intent)localObject).putExtra("kscene_type", 72);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
      egM();
      this.Axb += 1;
      if (this.Axb >= 2)
      {
        ac.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
        this.Axb = 0;
        localObject = new Intent(this, VoiceReCreatePromptUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(2130772144, 2130772141);
        finish();
        AppMethodBeat.o(29856);
        return;
      }
      this.AwC.setEnabled(true);
      this.AwF.der();
      this.AwF.setErr(2131764752);
      this.AwF.egS();
    }
  }
  
  public final void ayq(String paramString)
  {
    AppMethodBeat.i(29854);
    ac.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
    egC();
    this.Awk = paramString;
    this.AwF.der();
    this.AwF.egQ();
    this.AwF.setTipText(paramString);
    this.AwC.setEnabled(true);
    AppMethodBeat.o(29854);
  }
  
  public final void ayr(String paramString)
  {
    AppMethodBeat.i(29855);
    ac.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
    this.Awk = paramString;
    this.AwF.der();
    this.AwF.egQ();
    this.AwF.setTipText(paramString);
    this.AwC.setEnabled(true);
    AppMethodBeat.o(29855);
  }
  
  public final void ays(String paramString)
  {
    AppMethodBeat.i(196104);
    String str = paramString;
    if (bs.isNullOrNil(paramString)) {
      str = getString(2131764735);
    }
    this.AwF.der();
    this.AwF.setErr(str);
    this.AwF.egS();
    egM();
    AppMethodBeat.o(196104);
  }
  
  protected final void cXK()
  {
    AppMethodBeat.i(29851);
    this.AwX = new l(this);
    findViewById(2131304179).setVisibility(8);
    this.AwF.setTitleText(2131764750);
    this.AwF.egR();
    this.AwC.setEnabled(false);
    this.AwY = new o();
    this.nDu = findViewById(2131306481);
    this.AwZ = ((NoiseDetectMaskView)findViewById(2131302160));
    this.oDG = findViewById(2131301383);
    this.Axa = ((Button)findViewById(2131304179));
    this.Axa.setVisibility(8);
    this.Axa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29843);
        VoiceCreateUI.this.egD();
        a.a(VoiceCreateUI.this.AwF, new a.a()
        {
          public final void egG()
          {
            AppMethodBeat.i(29842);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(8);
            VoiceCreateUI.this.AwF.setTitleText(2131764750);
            VoiceCreateUI.this.AwF.vLT.setVisibility(0);
            VoiceCreateUI.this.AwC.setEnabled(true);
            VoiceCreateUI.this.AwC.setVisibility(0);
            AppMethodBeat.o(29842);
          }
          
          public final void egH() {}
        });
        AppMethodBeat.o(29843);
      }
    });
    this.AwZ.setOnClickRetryCallback(new NoiseDetectMaskView.b()
    {
      public final void egJ()
      {
        AppMethodBeat.i(29844);
        h.wUl.f(11390, new Object[] { Integer.valueOf(5) });
        VoiceCreateUI.d(VoiceCreateUI.this);
        AppMethodBeat.o(29844);
      }
    });
    this.AwZ.setOnCancelDetectCallback(new NoiseDetectMaskView.a()
    {
      public final void egI()
      {
        AppMethodBeat.i(29845);
        VoiceCreateUI.e(VoiceCreateUI.this);
        o localo = VoiceCreateUI.f(VoiceCreateUI.this);
        ac.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
        localo.Awo.NX();
        localo.Awp.stopTimer();
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(29845);
      }
    });
    com.tencent.mm.sdk.b.a.GpY.c(this.Axc);
    this.oDG.setOnClickListener(new View.OnClickListener()
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
  
  protected final void egF()
  {
    AppMethodBeat.i(29850);
    ac.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[] { this.AwH });
    if (!bs.isNullOrNil(this.AwH))
    {
      this.AwC.setEnabled(false);
      this.AwF.egP();
      l locall;
      f localf;
      if (this.Awj == 1)
      {
        locall = this.AwX;
        localf = new f(this.AwH, 71, locall.Awl, 0);
        localf.AvU = true;
        az.agi().a(localf, 0);
        locall.Awj = 71;
        AppMethodBeat.o(29850);
        return;
      }
      if (this.Awj == 2)
      {
        locall = this.AwX;
        localf = new f(this.AwH, 72, locall.Awl, locall.AvX);
        localf.AvU = true;
        az.agi().a(localf, 0);
        locall.Awj = 72;
      }
    }
    AppMethodBeat.o(29850);
  }
  
  public final void egx()
  {
    AppMethodBeat.i(29857);
    egE();
    egM();
    AppMethodBeat.o(29857);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(29861);
    super.onBackPressed();
    egM();
    AppMethodBeat.o(29861);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29860);
    super.onDestroy();
    l locall = this.AwX;
    az.agi().b(611, locall);
    az.agi().b(612, locall);
    locall.Awm = null;
    com.tencent.mm.sdk.b.a.GpY.d(this.Axc);
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