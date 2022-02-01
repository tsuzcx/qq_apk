package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;

public class VoiceLoginUI
  extends BaseVoicePrintUI
  implements n.a
{
  private com.tencent.mm.plugin.voiceprint.model.n BWA = null;
  private String lEN = null;
  
  private void goBack()
  {
    AppMethodBeat.i(29878);
    setResult(0);
    finish();
    AppMethodBeat.o(29878);
  }
  
  public final void aDC(String paramString)
  {
    AppMethodBeat.i(29880);
    ad.d("MicroMsg.VoiceLoginUI", "onGetText");
    this.BVF = paramString;
    this.BWa.euB();
    this.BWa.setTipText(paramString);
    this.BWa.dnP();
    this.BVX.setEnabled(true);
    AppMethodBeat.o(29880);
  }
  
  protected final void dgW()
  {
    AppMethodBeat.i(29877);
    findViewById(2131304179).setVisibility(8);
    this.BWa.euA();
    this.BWa.setTitleText(2131764734);
    this.BWa.euC();
    this.BVX.setEnabled(false);
    AppMethodBeat.o(29877);
  }
  
  public final void euj()
  {
    AppMethodBeat.i(29882);
    TL(2131764741);
    AppMethodBeat.o(29882);
  }
  
  public final void eul()
  {
    AppMethodBeat.i(29883);
    this.BVX.setEnabled(false);
    this.BVX.setVisibility(4);
    this.BWa.dnP();
    this.BWa.setErr(2131764740);
    this.BWa.euD();
    AppMethodBeat.o(29883);
  }
  
  protected final void euq()
  {
    AppMethodBeat.i(29876);
    ad.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[] { this.BWc });
    if ((!bt.isNullOrNil(this.BWc)) && (!bt.isNullOrNil(this.BVF)))
    {
      Object localObject = this.BWA;
      localObject = new com.tencent.mm.plugin.voiceprint.model.h(this.BWc, ((com.tencent.mm.plugin.voiceprint.model.n)localObject).BVG, ((com.tencent.mm.plugin.voiceprint.model.n)localObject).kaQ);
      ((com.tencent.mm.plugin.voiceprint.model.h)localObject).BVp = true;
      ba.aiU().a((com.tencent.mm.al.n)localObject, 0);
      this.BVX.setEnabled(false);
      this.BWa.euA();
    }
    AppMethodBeat.o(29876);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29875);
    super.onCreate(paramBundle);
    g.yhR.f(11557, new Object[] { Integer.valueOf(1) });
    this.lEN = bt.bI(getIntent().getStringExtra("Kusername"), null);
    paramBundle = bt.bI(getIntent().getStringExtra("Kvertify_key"), null);
    ad.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[] { this.lEN, Boolean.valueOf(bt.isNullOrNil(paramBundle)) });
    if ((bt.isNullOrNil(this.lEN)) && (bt.isNullOrNil(paramBundle)))
    {
      ad.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
      AppMethodBeat.o(29875);
      return;
    }
    this.BWA = new com.tencent.mm.plugin.voiceprint.model.n();
    this.BWA.lEN = this.lEN;
    this.BWA.kaQ = paramBundle;
    this.BWA.BVI = this;
    paramBundle = this.BWA;
    if (bt.isNullOrNil(paramBundle.kaQ))
    {
      paramBundle = new e(paramBundle.lEN);
      ba.aiU().a(paramBundle, 0);
    }
    for (;;)
    {
      ad.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bt.flS(), this });
      setBackBtn(new VoiceLoginUI.1(this));
      if (d.ly(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131100695));
        updataStatusBarIcon(al.isDarkMode());
      }
      AppMethodBeat.o(29875);
      return;
      paramBundle.euk();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29884);
    super.onDestroy();
    if (this.BWA != null)
    {
      com.tencent.mm.plugin.voiceprint.model.n localn = this.BWA;
      ba.aiU().b(618, localn);
      ba.aiU().b(616, localn);
      ba.aiU().b(617, localn);
      localn.BVI = null;
    }
    AppMethodBeat.o(29884);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29879);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(29879);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(29879);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(29885);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(29885);
      return;
    }
    ad.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29885);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        eun();
        AppMethodBeat.o(29885);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new VoiceLoginUI.2(this), new VoiceLoginUI.3(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sY(boolean paramBoolean)
  {
    AppMethodBeat.i(29881);
    this.BWa.dnP();
    this.BVX.setEnabled(true);
    if (paramBoolean)
    {
      ad.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[] { bt.aRp(this.BWA.jkw) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", this.BWA.jkw);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(29881);
      return;
    }
    ad.i("MicroMsg.VoiceLoginUI", "login failed");
    this.BWa.setErr(2131764733);
    this.BWa.euD();
    AppMethodBeat.o(29881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI
 * JD-Core Version:    0.7.0.1
 */