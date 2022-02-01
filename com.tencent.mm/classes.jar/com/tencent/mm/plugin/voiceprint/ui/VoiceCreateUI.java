package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aak;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
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
  private int NHp;
  private l NId;
  private o NIe;
  private NoiseDetectMaskView NIf;
  private Button NIg;
  private int NIh;
  private IListener NIi;
  private View sHR;
  private View uct;
  
  public VoiceCreateUI()
  {
    AppMethodBeat.i(29849);
    this.NIe = null;
    this.uct = null;
    this.NIg = null;
    this.NHp = 1;
    this.NIh = 0;
    this.NIi = new IListener() {};
    AppMethodBeat.o(29849);
  }
  
  private void gxd()
  {
    AppMethodBeat.i(29853);
    Log.d("MicroMsg.VoiceCreateUI", "start noise detect");
    this.uct.setVisibility(4);
    this.sHR.setVisibility(4);
    this.NHJ.setVisibility(4);
    this.NIf.setVisibility(0);
    this.NIe.Yv();
    AppMethodBeat.o(29853);
  }
  
  private void gxe()
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
    this.NIe.reset();
    this.NIf.reset();
    gxd();
    AppMethodBeat.o(29852);
  }
  
  public final void al(boolean paramBoolean, int paramInt)
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
        this.NHI.setEnabled(false);
        this.NHp = 2;
        gwV();
        a.a(this.NHL, new a.a()
        {
          public final void gwY()
          {
            AppMethodBeat.i(29848);
            VoiceCreateUI.this.NHL.reset();
            VoiceCreateUI.this.NHL.gxh();
            VoiceCreateUI.this.NHL.gxi();
            VoiceCreateUI.this.NHI.setVisibility(4);
            VoiceCreateUI.this.NHL.setTitleText(R.l.eVd);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(0);
            VoiceCreateUI.this.NHL.eUn();
            AppMethodBeat.o(29848);
          }
          
          public final void gwZ() {}
        });
        AppMethodBeat.o(29856);
        return;
        this.NIh = 0;
        Log.d("MicroMsg.VoiceCreateUI", "finish create step 2");
        localObject = new Intent();
        ((Intent)localObject).putExtra("KIsCreateSuccess", true);
        setResult(-1, (Intent)localObject);
        localObject = new Intent();
        ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
        ((Intent)localObject).putExtra("kscene_type", 72);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      gxe();
      this.NIh += 1;
      if (this.NIh >= 2)
      {
        Log.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
        this.NIh = 0;
        localObject = new Intent(this, VoiceReCreatePromptUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
        finish();
        AppMethodBeat.o(29856);
        return;
      }
      this.NHI.setEnabled(true);
      this.NHL.eUn();
      this.NHL.setErr(R.l.eVh);
      this.NHL.gxj();
    }
  }
  
  public final void bfW(String paramString)
  {
    AppMethodBeat.i(29854);
    Log.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
    gwU();
    this.NHq = paramString;
    this.NHL.eUn();
    this.NHL.gxh();
    this.NHL.setTipText(paramString);
    this.NHI.setEnabled(true);
    AppMethodBeat.o(29854);
  }
  
  public final void bfX(String paramString)
  {
    AppMethodBeat.i(29855);
    Log.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
    this.NHq = paramString;
    this.NHL.eUn();
    this.NHL.gxh();
    this.NHL.setTipText(paramString);
    this.NHI.setEnabled(true);
    AppMethodBeat.o(29855);
  }
  
  public final void bfY(String paramString)
  {
    AppMethodBeat.i(205799);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = getString(R.l.eUX);
    }
    bga(str);
    gxe();
    AppMethodBeat.o(205799);
  }
  
  protected final void eNb()
  {
    AppMethodBeat.i(29851);
    this.NId = new l(this);
    findViewById(R.h.right_btn).setVisibility(8);
    this.NHL.setTitleText(R.l.eVf);
    this.NHL.gxi();
    this.NHI.setEnabled(false);
    this.NIe = new o();
    this.sHR = findViewById(R.h.dZT);
    this.NIf = ((NoiseDetectMaskView)findViewById(R.h.mask));
    this.uct = findViewById(R.h.left_btn);
    this.NIg = ((Button)findViewById(R.h.right_btn));
    this.NIg.setVisibility(8);
    this.NIg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29843);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        VoiceCreateUI.this.gwV();
        a.a(VoiceCreateUI.this.NHL, new a.a()
        {
          public final void gwY()
          {
            AppMethodBeat.i(29842);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(8);
            VoiceCreateUI.this.NHL.setTitleText(R.l.eVf);
            VoiceCreateUI.this.NHL.Haz.setVisibility(0);
            VoiceCreateUI.this.NHI.setEnabled(true);
            VoiceCreateUI.this.NHI.setVisibility(0);
            AppMethodBeat.o(29842);
          }
          
          public final void gwZ() {}
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29843);
      }
    });
    this.NIf.setOnClickRetryCallback(new NoiseDetectMaskView.b()
    {
      public final void gxb()
      {
        AppMethodBeat.i(29844);
        h.IzE.a(11390, new Object[] { Integer.valueOf(5) });
        VoiceCreateUI.d(VoiceCreateUI.this);
        AppMethodBeat.o(29844);
      }
    });
    this.NIf.setOnCancelDetectCallback(new NoiseDetectMaskView.a()
    {
      public final void gxa()
      {
        AppMethodBeat.i(29845);
        VoiceCreateUI.e(VoiceCreateUI.this);
        o localo = VoiceCreateUI.f(VoiceCreateUI.this);
        Log.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
        localo.NHu.aeJ();
        localo.NHv.stopTimer();
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(29845);
      }
    });
    EventCenter.instance.addListener(this.NIi);
    this.uct.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29846);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        VoiceCreateUI.e(VoiceCreateUI.this);
        VoiceCreateUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29846);
      }
    });
    start();
    AppMethodBeat.o(29851);
  }
  
  public final void gwQ()
  {
    AppMethodBeat.i(29857);
    gwW();
    gxe();
    AppMethodBeat.o(29857);
  }
  
  protected final void gwX()
  {
    AppMethodBeat.i(29850);
    Log.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[] { this.NHN });
    if (!Util.isNullOrNil(this.NHN))
    {
      this.NHI.setEnabled(false);
      this.NHL.dBa();
      l locall;
      f localf;
      if (this.NHp == 1)
      {
        locall = this.NId;
        localf = new f(this.NHN, 71, locall.NHr, 0);
        localf.NHc = true;
        bh.aGY().a(localf, 0);
        locall.NHp = 71;
        AppMethodBeat.o(29850);
        return;
      }
      if (this.NHp == 2)
      {
        locall = this.NId;
        localf = new f(this.NHN, 72, locall.NHr, locall.NHe);
        localf.NHc = true;
        bh.aGY().a(localf, 0);
        locall.NHp = 72;
      }
    }
    AppMethodBeat.o(29850);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(29861);
    super.onBackPressed();
    gxe();
    AppMethodBeat.o(29861);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29860);
    super.onDestroy();
    l locall = this.NId;
    bh.aGY().b(611, locall);
    bh.aGY().b(612, locall);
    locall.NHs = null;
    EventCenter.instance.removeListener(this.NIi);
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