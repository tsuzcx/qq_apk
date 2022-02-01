package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.zd;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class VoiceCreateUI
  extends BaseVoicePrintUI
  implements l.a
{
  private l GRS;
  private o GRT;
  private NoiseDetectMaskView GRU;
  private Button GRV;
  private int GRW;
  private IListener GRX;
  private int GRe;
  private View pyo;
  private View qDs;
  
  public VoiceCreateUI()
  {
    AppMethodBeat.i(29849);
    this.GRT = null;
    this.qDs = null;
    this.GRV = null;
    this.GRe = 1;
    this.GRW = 0;
    this.GRX = new IListener() {};
    AppMethodBeat.o(29849);
  }
  
  private void fEQ()
  {
    AppMethodBeat.i(29853);
    Log.d("MicroMsg.VoiceCreateUI", "start noise detect");
    this.qDs.setVisibility(4);
    this.pyo.setVisibility(4);
    this.GRy.setVisibility(4);
    this.GRU.setVisibility(0);
    this.GRT.TR();
    AppMethodBeat.o(29853);
  }
  
  private void fER()
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
    Log.d("MicroMsg.VoiceCreateUI", "start create");
    this.GRT.reset();
    this.GRU.reset();
    fEQ();
    AppMethodBeat.o(29852);
  }
  
  public final void Y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(29856);
    Log.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
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
        Log.d("MicroMsg.VoiceCreateUI", "finish create step 1");
        this.GRx.setEnabled(false);
        this.GRe = 2;
        fEI();
        a.a(this.GRA, new a.a()
        {
          public final void fEL()
          {
            AppMethodBeat.i(29848);
            VoiceCreateUI.this.GRA.reset();
            VoiceCreateUI.this.GRA.fEV();
            VoiceCreateUI.this.GRA.fEW();
            VoiceCreateUI.this.GRx.setVisibility(4);
            VoiceCreateUI.this.GRA.setTitleText(2131767184);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(0);
            VoiceCreateUI.this.GRA.ekF();
            AppMethodBeat.o(29848);
          }
          
          public final void fEM() {}
        });
        AppMethodBeat.o(29856);
        return;
        this.GRW = 0;
        Log.d("MicroMsg.VoiceCreateUI", "finish create step 2");
        localObject = new Intent();
        ((Intent)localObject).putExtra("KIsCreateSuccess", true);
        setResult(-1, (Intent)localObject);
        localObject = new Intent();
        ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
        ((Intent)localObject).putExtra("kscene_type", 72);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      fER();
      this.GRW += 1;
      if (this.GRW >= 2)
      {
        Log.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
        this.GRW = 0;
        localObject = new Intent(this, VoiceReCreatePromptUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(2130772169, 2130772166);
        finish();
        AppMethodBeat.o(29856);
        return;
      }
      this.GRx.setEnabled(true);
      this.GRA.ekF();
      this.GRA.setErr(2131767189);
      this.GRA.fEX();
    }
  }
  
  public final void aUs(String paramString)
  {
    AppMethodBeat.i(29854);
    Log.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
    fEH();
    this.GRf = paramString;
    this.GRA.ekF();
    this.GRA.fEV();
    this.GRA.setTipText(paramString);
    this.GRx.setEnabled(true);
    AppMethodBeat.o(29854);
  }
  
  public final void aUt(String paramString)
  {
    AppMethodBeat.i(29855);
    Log.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
    this.GRf = paramString;
    this.GRA.ekF();
    this.GRA.fEV();
    this.GRA.setTipText(paramString);
    this.GRx.setEnabled(true);
    AppMethodBeat.o(29855);
  }
  
  public final void aUu(String paramString)
  {
    AppMethodBeat.i(232126);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = getString(2131767172);
    }
    this.GRA.ekF();
    this.GRA.setErr(str);
    this.GRA.fEX();
    fER();
    AppMethodBeat.o(232126);
  }
  
  protected final void edG()
  {
    AppMethodBeat.i(29851);
    this.GRS = new l(this);
    findViewById(2131307087).setVisibility(8);
    this.GRA.setTitleText(2131767187);
    this.GRA.fEW();
    this.GRx.setEnabled(false);
    this.GRT = new o();
    this.pyo = findViewById(2131309940);
    this.GRU = ((NoiseDetectMaskView)findViewById(2131304501));
    this.qDs = findViewById(2131303137);
    this.GRV = ((Button)findViewById(2131307087));
    this.GRV.setVisibility(8);
    this.GRV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29843);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        VoiceCreateUI.this.fEI();
        a.a(VoiceCreateUI.this.GRA, new a.a()
        {
          public final void fEL()
          {
            AppMethodBeat.i(29842);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(8);
            VoiceCreateUI.this.GRA.setTitleText(2131767187);
            VoiceCreateUI.this.GRA.BgP.setVisibility(0);
            VoiceCreateUI.this.GRx.setEnabled(true);
            VoiceCreateUI.this.GRx.setVisibility(0);
            AppMethodBeat.o(29842);
          }
          
          public final void fEM() {}
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29843);
      }
    });
    this.GRU.setOnClickRetryCallback(new NoiseDetectMaskView.b()
    {
      public final void fEO()
      {
        AppMethodBeat.i(29844);
        h.CyF.a(11390, new Object[] { Integer.valueOf(5) });
        VoiceCreateUI.d(VoiceCreateUI.this);
        AppMethodBeat.o(29844);
      }
    });
    this.GRU.setOnCancelDetectCallback(new NoiseDetectMaskView.a()
    {
      public final void fEN()
      {
        AppMethodBeat.i(29845);
        VoiceCreateUI.e(VoiceCreateUI.this);
        o localo = VoiceCreateUI.f(VoiceCreateUI.this);
        Log.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
        localo.GRj.ZZ();
        localo.GRk.stopTimer();
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(29845);
      }
    });
    EventCenter.instance.addListener(this.GRX);
    this.qDs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29846);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        VoiceCreateUI.e(VoiceCreateUI.this);
        VoiceCreateUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29846);
      }
    });
    start();
    AppMethodBeat.o(29851);
  }
  
  public final void fED()
  {
    AppMethodBeat.i(29857);
    fEJ();
    fER();
    AppMethodBeat.o(29857);
  }
  
  protected final void fEK()
  {
    AppMethodBeat.i(29850);
    Log.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[] { this.GRC });
    if (!Util.isNullOrNil(this.GRC))
    {
      this.GRx.setEnabled(false);
      this.GRA.fEU();
      l locall;
      f localf;
      if (this.GRe == 1)
      {
        locall = this.GRS;
        localf = new f(this.GRC, 71, locall.GRg, 0);
        localf.GQR = true;
        bg.azz().a(localf, 0);
        locall.GRe = 71;
        AppMethodBeat.o(29850);
        return;
      }
      if (this.GRe == 2)
      {
        locall = this.GRS;
        localf = new f(this.GRC, 72, locall.GRg, locall.GQT);
        localf.GQR = true;
        bg.azz().a(localf, 0);
        locall.GRe = 72;
      }
    }
    AppMethodBeat.o(29850);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(29861);
    super.onBackPressed();
    fER();
    AppMethodBeat.o(29861);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29860);
    super.onDestroy();
    l locall = this.GRS;
    bg.azz().b(611, locall);
    bg.azz().b(612, locall);
    locall.GRh = null;
    EventCenter.instance.removeListener(this.GRX);
    AppMethodBeat.o(29860);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI
 * JD-Core Version:    0.7.0.1
 */