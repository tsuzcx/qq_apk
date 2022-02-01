package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;

public class VoiceCreateUI
  extends BaseVoicePrintUI
  implements l.a
{
  private l CnT;
  private o CnU;
  private NoiseDetectMaskView CnV;
  private Button CnW;
  private int CnX;
  private c CnY;
  private int Cnf;
  private View olQ;
  private View pnM;
  
  public VoiceCreateUI()
  {
    AppMethodBeat.i(29849);
    this.CnU = null;
    this.pnM = null;
    this.CnW = null;
    this.Cnf = 1;
    this.CnX = 0;
    this.CnY = new c() {};
    AppMethodBeat.o(29849);
  }
  
  private void eyc()
  {
    AppMethodBeat.i(29853);
    ae.d("MicroMsg.VoiceCreateUI", "start noise detect");
    this.pnM.setVisibility(4);
    this.olQ.setVisibility(4);
    this.Cnz.setVisibility(4);
    this.CnV.setVisibility(0);
    this.CnU.JE();
    AppMethodBeat.o(29853);
  }
  
  private void eyd()
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
    ae.d("MicroMsg.VoiceCreateUI", "start create");
    this.CnU.reset();
    this.CnV.reset();
    eyc();
    AppMethodBeat.o(29852);
  }
  
  public final void V(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(29856);
    ae.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
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
        ae.d("MicroMsg.VoiceCreateUI", "finish create step 1");
        this.Cny.setEnabled(false);
        this.Cnf = 2;
        exU();
        a.a(this.CnB, new a.a()
        {
          public final void exX()
          {
            AppMethodBeat.i(29848);
            VoiceCreateUI.this.CnB.reset();
            VoiceCreateUI.this.CnB.eyh();
            VoiceCreateUI.this.CnB.eyi();
            VoiceCreateUI.this.Cny.setVisibility(4);
            VoiceCreateUI.this.CnB.setTitleText(2131764747);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(0);
            VoiceCreateUI.this.CnB.dqN();
            AppMethodBeat.o(29848);
          }
          
          public final void exY() {}
        });
        AppMethodBeat.o(29856);
        return;
        this.CnX = 0;
        ae.d("MicroMsg.VoiceCreateUI", "finish create step 2");
        localObject = new Intent();
        ((Intent)localObject).putExtra("KIsCreateSuccess", true);
        setResult(-1, (Intent)localObject);
        localObject = new Intent();
        ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
        ((Intent)localObject).putExtra("kscene_type", 72);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
      eyd();
      this.CnX += 1;
      if (this.CnX >= 2)
      {
        ae.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
        this.CnX = 0;
        localObject = new Intent(this, VoiceReCreatePromptUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(2130772144, 2130772141);
        finish();
        AppMethodBeat.o(29856);
        return;
      }
      this.Cny.setEnabled(true);
      this.CnB.dqN();
      this.CnB.setErr(2131764752);
      this.CnB.eyj();
    }
  }
  
  public final void aES(String paramString)
  {
    AppMethodBeat.i(29854);
    ae.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
    exT();
    this.Cng = paramString;
    this.CnB.dqN();
    this.CnB.eyh();
    this.CnB.setTipText(paramString);
    this.Cny.setEnabled(true);
    AppMethodBeat.o(29854);
  }
  
  public final void aET(String paramString)
  {
    AppMethodBeat.i(29855);
    ae.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
    this.Cng = paramString;
    this.CnB.dqN();
    this.CnB.eyh();
    this.CnB.setTipText(paramString);
    this.Cny.setEnabled(true);
    AppMethodBeat.o(29855);
  }
  
  public final void aEU(String paramString)
  {
    AppMethodBeat.i(186686);
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = getString(2131764735);
    }
    this.CnB.dqN();
    this.CnB.setErr(str);
    this.CnB.eyj();
    eyd();
    AppMethodBeat.o(186686);
  }
  
  protected final void djV()
  {
    AppMethodBeat.i(29851);
    this.CnT = new l(this);
    findViewById(2131304179).setVisibility(8);
    this.CnB.setTitleText(2131764750);
    this.CnB.eyi();
    this.Cny.setEnabled(false);
    this.CnU = new o();
    this.olQ = findViewById(2131306481);
    this.CnV = ((NoiseDetectMaskView)findViewById(2131302160));
    this.pnM = findViewById(2131301383);
    this.CnW = ((Button)findViewById(2131304179));
    this.CnW.setVisibility(8);
    this.CnW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29843);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        VoiceCreateUI.this.exU();
        a.a(VoiceCreateUI.this.CnB, new a.a()
        {
          public final void exX()
          {
            AppMethodBeat.i(29842);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(8);
            VoiceCreateUI.this.CnB.setTitleText(2131764750);
            VoiceCreateUI.this.CnB.xiT.setVisibility(0);
            VoiceCreateUI.this.Cny.setEnabled(true);
            VoiceCreateUI.this.Cny.setVisibility(0);
            AppMethodBeat.o(29842);
          }
          
          public final void exY() {}
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29843);
      }
    });
    this.CnV.setOnClickRetryCallback(new NoiseDetectMaskView.b()
    {
      public final void eya()
      {
        AppMethodBeat.i(29844);
        g.yxI.f(11390, new Object[] { Integer.valueOf(5) });
        VoiceCreateUI.d(VoiceCreateUI.this);
        AppMethodBeat.o(29844);
      }
    });
    this.CnV.setOnCancelDetectCallback(new NoiseDetectMaskView.a()
    {
      public final void exZ()
      {
        AppMethodBeat.i(29845);
        VoiceCreateUI.e(VoiceCreateUI.this);
        o localo = VoiceCreateUI.f(VoiceCreateUI.this);
        ae.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
        localo.Cnk.PF();
        localo.Cnl.stopTimer();
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(29845);
      }
    });
    com.tencent.mm.sdk.b.a.IvT.c(this.CnY);
    this.pnM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29846);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        VoiceCreateUI.e(VoiceCreateUI.this);
        VoiceCreateUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29846);
      }
    });
    start();
    AppMethodBeat.o(29851);
  }
  
  public final void exP()
  {
    AppMethodBeat.i(29857);
    exV();
    eyd();
    AppMethodBeat.o(29857);
  }
  
  protected final void exW()
  {
    AppMethodBeat.i(29850);
    ae.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[] { this.CnD });
    if (!bu.isNullOrNil(this.CnD))
    {
      this.Cny.setEnabled(false);
      this.CnB.eyg();
      l locall;
      f localf;
      if (this.Cnf == 1)
      {
        locall = this.CnT;
        localf = new f(this.CnD, 71, locall.Cnh, 0);
        localf.CmQ = true;
        bc.ajj().a(localf, 0);
        locall.Cnf = 71;
        AppMethodBeat.o(29850);
        return;
      }
      if (this.Cnf == 2)
      {
        locall = this.CnT;
        localf = new f(this.CnD, 72, locall.Cnh, locall.CmT);
        localf.CmQ = true;
        bc.ajj().a(localf, 0);
        locall.Cnf = 72;
      }
    }
    AppMethodBeat.o(29850);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(29861);
    super.onBackPressed();
    eyd();
    AppMethodBeat.o(29861);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29860);
    super.onDestroy();
    l locall = this.CnT;
    bc.ajj().b(611, locall);
    bc.ajj().b(612, locall);
    locall.Cni = null;
    com.tencent.mm.sdk.b.a.IvT.d(this.CnY);
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