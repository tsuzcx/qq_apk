package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.report.service.g;
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
  private int BVE;
  private l BWs;
  private o BWt;
  private NoiseDetectMaskView BWu;
  private Button BWv;
  private int BWw;
  private c BWx;
  private View ofS;
  private View phg;
  
  public VoiceCreateUI()
  {
    AppMethodBeat.i(29849);
    this.BWt = null;
    this.phg = null;
    this.BWv = null;
    this.BVE = 1;
    this.BWw = 0;
    this.BWx = new c() {};
    AppMethodBeat.o(29849);
  }
  
  private void euw()
  {
    AppMethodBeat.i(29853);
    ad.d("MicroMsg.VoiceCreateUI", "start noise detect");
    this.phg.setVisibility(4);
    this.ofS.setVisibility(4);
    this.BVY.setVisibility(4);
    this.BWu.setVisibility(0);
    this.BWt.Jw();
    AppMethodBeat.o(29853);
  }
  
  private void eux()
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
    this.BWt.reset();
    this.BWu.reset();
    euw();
    AppMethodBeat.o(29852);
  }
  
  public final void S(boolean paramBoolean, int paramInt)
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
        this.BVX.setEnabled(false);
        this.BVE = 2;
        euo();
        a.a(this.BWa, new a.a()
        {
          public final void eur()
          {
            AppMethodBeat.i(29848);
            VoiceCreateUI.this.BWa.reset();
            VoiceCreateUI.this.BWa.euB();
            VoiceCreateUI.this.BWa.euC();
            VoiceCreateUI.this.BVX.setVisibility(4);
            VoiceCreateUI.this.BWa.setTitleText(2131764747);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(0);
            VoiceCreateUI.this.BWa.dnP();
            AppMethodBeat.o(29848);
          }
          
          public final void eus() {}
        });
        AppMethodBeat.o(29856);
        return;
        this.BWw = 0;
        ad.d("MicroMsg.VoiceCreateUI", "finish create step 2");
        localObject = new Intent();
        ((Intent)localObject).putExtra("KIsCreateSuccess", true);
        setResult(-1, (Intent)localObject);
        localObject = new Intent();
        ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
        ((Intent)localObject).putExtra("kscene_type", 72);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
      eux();
      this.BWw += 1;
      if (this.BWw >= 2)
      {
        ad.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
        this.BWw = 0;
        localObject = new Intent(this, VoiceReCreatePromptUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(2130772144, 2130772141);
        finish();
        AppMethodBeat.o(29856);
        return;
      }
      this.BVX.setEnabled(true);
      this.BWa.dnP();
      this.BWa.setErr(2131764752);
      this.BWa.euD();
    }
  }
  
  public final void aDA(String paramString)
  {
    AppMethodBeat.i(29855);
    ad.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
    this.BVF = paramString;
    this.BWa.dnP();
    this.BWa.euB();
    this.BWa.setTipText(paramString);
    this.BVX.setEnabled(true);
    AppMethodBeat.o(29855);
  }
  
  public final void aDB(String paramString)
  {
    AppMethodBeat.i(193407);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = getString(2131764735);
    }
    this.BWa.dnP();
    this.BWa.setErr(str);
    this.BWa.euD();
    eux();
    AppMethodBeat.o(193407);
  }
  
  public final void aDz(String paramString)
  {
    AppMethodBeat.i(29854);
    ad.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
    eun();
    this.BVF = paramString;
    this.BWa.dnP();
    this.BWa.euB();
    this.BWa.setTipText(paramString);
    this.BVX.setEnabled(true);
    AppMethodBeat.o(29854);
  }
  
  protected final void dgW()
  {
    AppMethodBeat.i(29851);
    this.BWs = new l(this);
    findViewById(2131304179).setVisibility(8);
    this.BWa.setTitleText(2131764750);
    this.BWa.euC();
    this.BVX.setEnabled(false);
    this.BWt = new o();
    this.ofS = findViewById(2131306481);
    this.BWu = ((NoiseDetectMaskView)findViewById(2131302160));
    this.phg = findViewById(2131301383);
    this.BWv = ((Button)findViewById(2131304179));
    this.BWv.setVisibility(8);
    this.BWv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29843);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        VoiceCreateUI.this.euo();
        a.a(VoiceCreateUI.this.BWa, new a.a()
        {
          public final void eur()
          {
            AppMethodBeat.i(29842);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(8);
            VoiceCreateUI.this.BWa.setTitleText(2131764750);
            VoiceCreateUI.this.BWa.wTc.setVisibility(0);
            VoiceCreateUI.this.BVX.setEnabled(true);
            VoiceCreateUI.this.BVX.setVisibility(0);
            AppMethodBeat.o(29842);
          }
          
          public final void eus() {}
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29843);
      }
    });
    this.BWu.setOnClickRetryCallback(new NoiseDetectMaskView.b()
    {
      public final void euu()
      {
        AppMethodBeat.i(29844);
        g.yhR.f(11390, new Object[] { Integer.valueOf(5) });
        VoiceCreateUI.d(VoiceCreateUI.this);
        AppMethodBeat.o(29844);
      }
    });
    this.BWu.setOnCancelDetectCallback(new NoiseDetectMaskView.a()
    {
      public final void eut()
      {
        AppMethodBeat.i(29845);
        VoiceCreateUI.e(VoiceCreateUI.this);
        o localo = VoiceCreateUI.f(VoiceCreateUI.this);
        ad.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
        localo.BVJ.PG();
        localo.BVK.stopTimer();
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(29845);
      }
    });
    com.tencent.mm.sdk.b.a.IbL.c(this.BWx);
    this.phg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29846);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        VoiceCreateUI.e(VoiceCreateUI.this);
        VoiceCreateUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29846);
      }
    });
    start();
    AppMethodBeat.o(29851);
  }
  
  public final void euj()
  {
    AppMethodBeat.i(29857);
    eup();
    eux();
    AppMethodBeat.o(29857);
  }
  
  protected final void euq()
  {
    AppMethodBeat.i(29850);
    ad.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[] { this.BWc });
    if (!bt.isNullOrNil(this.BWc))
    {
      this.BVX.setEnabled(false);
      this.BWa.euA();
      l locall;
      f localf;
      if (this.BVE == 1)
      {
        locall = this.BWs;
        localf = new f(this.BWc, 71, locall.BVG, 0);
        localf.BVp = true;
        ba.aiU().a(localf, 0);
        locall.BVE = 71;
        AppMethodBeat.o(29850);
        return;
      }
      if (this.BVE == 2)
      {
        locall = this.BWs;
        localf = new f(this.BWc, 72, locall.BVG, locall.BVs);
        localf.BVp = true;
        ba.aiU().a(localf, 0);
        locall.BVE = 72;
      }
    }
    AppMethodBeat.o(29850);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(29861);
    super.onBackPressed();
    eux();
    AppMethodBeat.o(29861);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29860);
    super.onDestroy();
    l locall = this.BWs;
    ba.aiU().b(611, locall);
    ba.aiU().b(612, locall);
    locall.BVH = null;
    com.tencent.mm.sdk.b.a.IbL.d(this.BWx);
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