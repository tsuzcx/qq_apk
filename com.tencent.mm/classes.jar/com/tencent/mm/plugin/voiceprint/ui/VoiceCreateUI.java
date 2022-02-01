package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ach;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class VoiceCreateUI
  extends BaseVoicePrintUI
  implements l.a
{
  private int Utp;
  private l Uue;
  private o Uuf;
  private NoiseDetectMaskView Uug;
  private Button Uuh;
  private int Uui;
  private IListener Uuj;
  private View vNn;
  private View xix;
  
  public VoiceCreateUI()
  {
    AppMethodBeat.i(29849);
    this.Uuf = null;
    this.xix = null;
    this.Uuh = null;
    this.Utp = 1;
    this.Uui = 0;
    this.Uuj = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(29849);
  }
  
  private void hVa()
  {
    AppMethodBeat.i(29853);
    Log.d("MicroMsg.VoiceCreateUI", "start noise detect");
    this.xix.setVisibility(4);
    this.vNn.setVisibility(4);
    this.UtJ.setVisibility(4);
    this.Uug.setVisibility(0);
    this.Uuf.aAq();
    AppMethodBeat.o(29853);
  }
  
  private void hVb()
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
    this.Uuf.reset();
    this.Uug.reset();
    hVa();
    AppMethodBeat.o(29852);
  }
  
  public final void an(boolean paramBoolean, int paramInt)
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
        this.UtI.setEnabled(false);
        this.Utp = 2;
        hUS();
        a.a(this.UtL, new a.a()
        {
          public final void hUV()
          {
            AppMethodBeat.i(29848);
            VoiceCreateUI.this.UtL.reset();
            VoiceCreateUI.this.UtL.hVe();
            VoiceCreateUI.this.UtL.hVf();
            VoiceCreateUI.this.UtI.setVisibility(4);
            VoiceCreateUI.this.UtL.setTitleText(R.l.gYh);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(0);
            VoiceCreateUI.this.UtL.gdb();
            AppMethodBeat.o(29848);
          }
          
          public final void hUW() {}
        });
        AppMethodBeat.o(29856);
        return;
        this.Uui = 0;
        Log.d("MicroMsg.VoiceCreateUI", "finish create step 2");
        localObject = new Intent();
        ((Intent)localObject).putExtra("KIsCreateSuccess", true);
        setResult(-1, (Intent)localObject);
        localObject = new Intent();
        ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
        ((Intent)localObject).putExtra("kscene_type", 72);
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
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
      hVb();
      this.Uui += 1;
      if (this.Uui >= 2)
      {
        Log.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
        this.Uui = 0;
        localObject = new Intent(this, VoiceReCreatePromptUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
        finish();
        AppMethodBeat.o(29856);
        return;
      }
      this.UtI.setEnabled(true);
      this.UtL.gdb();
      this.UtL.setErr(R.l.gYl);
      this.UtL.hVg();
    }
  }
  
  public final void bfC(String paramString)
  {
    AppMethodBeat.i(29854);
    Log.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
    hUR();
    this.Utq = paramString;
    this.UtL.gdb();
    this.UtL.hVe();
    this.UtL.setTipText(paramString);
    this.UtI.setEnabled(true);
    AppMethodBeat.o(29854);
  }
  
  public final void bfD(String paramString)
  {
    AppMethodBeat.i(29855);
    Log.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
    this.Utq = paramString;
    this.UtL.gdb();
    this.UtL.hVe();
    this.UtL.setTipText(paramString);
    this.UtI.setEnabled(true);
    AppMethodBeat.o(29855);
  }
  
  public final void bfE(String paramString)
  {
    AppMethodBeat.i(272759);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = getString(R.l.gYb);
    }
    bfG(str);
    hVb();
    AppMethodBeat.o(272759);
  }
  
  protected final void fVu()
  {
    AppMethodBeat.i(29851);
    this.Uue = new l(this);
    findViewById(R.h.right_btn).setVisibility(8);
    this.UtL.setTitleText(R.l.gYj);
    this.UtL.hVf();
    this.UtI.setEnabled(false);
    this.Uuf = new o();
    this.vNn = findViewById(R.h.gcH);
    this.Uug = ((NoiseDetectMaskView)findViewById(R.h.mask));
    this.xix = findViewById(R.h.left_btn);
    this.Uuh = ((Button)findViewById(R.h.right_btn));
    this.Uuh.setVisibility(8);
    this.Uuh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29843);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        VoiceCreateUI.this.hUS();
        a.a(VoiceCreateUI.this.UtL, new a.a()
        {
          public final void hUV()
          {
            AppMethodBeat.i(29842);
            VoiceCreateUI.c(VoiceCreateUI.this).setVisibility(8);
            VoiceCreateUI.this.UtL.setTitleText(R.l.gYj);
            VoiceCreateUI.this.UtL.MYG.setVisibility(0);
            VoiceCreateUI.this.UtI.setEnabled(true);
            VoiceCreateUI.this.UtI.setVisibility(0);
            AppMethodBeat.o(29842);
          }
          
          public final void hUW() {}
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29843);
      }
    });
    this.Uug.setOnClickRetryCallback(new NoiseDetectMaskView.b()
    {
      public final void hUY()
      {
        AppMethodBeat.i(29844);
        h.OAn.b(11390, new Object[] { Integer.valueOf(5) });
        VoiceCreateUI.d(VoiceCreateUI.this);
        AppMethodBeat.o(29844);
      }
    });
    this.Uug.setOnCancelDetectCallback(new NoiseDetectMaskView.a()
    {
      public final void hUX()
      {
        AppMethodBeat.i(29845);
        VoiceCreateUI.e(VoiceCreateUI.this);
        o localo = VoiceCreateUI.f(VoiceCreateUI.this);
        Log.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
        localo.Utu.aGH();
        localo.Utv.stopTimer();
        VoiceCreateUI.this.finish();
        AppMethodBeat.o(29845);
      }
    });
    this.Uuj.alive();
    this.xix.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29846);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        VoiceCreateUI.e(VoiceCreateUI.this);
        VoiceCreateUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29846);
      }
    });
    start();
    AppMethodBeat.o(29851);
  }
  
  public final void hUN()
  {
    AppMethodBeat.i(29857);
    hUT();
    hVb();
    AppMethodBeat.o(29857);
  }
  
  protected final void hUU()
  {
    AppMethodBeat.i(29850);
    Log.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[] { this.UtN });
    if (!Util.isNullOrNil(this.UtN))
    {
      this.UtI.setEnabled(false);
      this.UtL.eAg();
      l locall;
      com.tencent.mm.plugin.voiceprint.model.f localf;
      if (this.Utp == 1)
      {
        locall = this.Uue;
        localf = new com.tencent.mm.plugin.voiceprint.model.f(this.UtN, 71, locall.Utr, 0);
        localf.Utc = true;
        bh.aZW().a(localf, 0);
        locall.Utp = 71;
        AppMethodBeat.o(29850);
        return;
      }
      if (this.Utp == 2)
      {
        locall = this.Uue;
        localf = new com.tencent.mm.plugin.voiceprint.model.f(this.UtN, 72, locall.Utr, locall.Ute);
        localf.Utc = true;
        bh.aZW().a(localf, 0);
        locall.Utp = 72;
      }
    }
    AppMethodBeat.o(29850);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(29861);
    super.onBackPressed();
    hVb();
    AppMethodBeat.o(29861);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29860);
    super.onDestroy();
    l locall = this.Uue;
    bh.aZW().b(611, locall);
    bh.aZW().b(612, locall);
    locall.Uts = null;
    this.Uuj.dead();
    AppMethodBeat.o(29860);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI
 * JD-Core Version:    0.7.0.1
 */