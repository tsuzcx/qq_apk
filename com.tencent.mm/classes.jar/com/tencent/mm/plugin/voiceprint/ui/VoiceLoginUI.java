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
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;

public class VoiceLoginUI
  extends BaseVoicePrintUI
  implements n.a
{
  private String kGt = null;
  private com.tencent.mm.plugin.voiceprint.model.n zez = null;
  
  private void goBack()
  {
    AppMethodBeat.i(29878);
    setResult(0);
    finish();
    AppMethodBeat.o(29878);
  }
  
  public final void atc(String paramString)
  {
    AppMethodBeat.i(29880);
    ad.d("MicroMsg.VoiceLoginUI", "onGetText");
    this.zdE = paramString;
    this.zdZ.dRF();
    this.zdZ.setTipText(paramString);
    this.zdZ.cQI();
    this.zdW.setEnabled(true);
    AppMethodBeat.o(29880);
  }
  
  protected final void cKf()
  {
    AppMethodBeat.i(29877);
    findViewById(2131304179).setVisibility(8);
    this.zdZ.cQH();
    this.zdZ.setTitleText(2131764734);
    this.zdZ.dRG();
    this.zdW.setEnabled(false);
    AppMethodBeat.o(29877);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(29882);
    PK(2131764741);
    AppMethodBeat.o(29882);
  }
  
  public final void dRp()
  {
    AppMethodBeat.i(29883);
    this.zdW.setEnabled(false);
    this.zdW.setVisibility(4);
    this.zdZ.cQI();
    this.zdZ.setErr(2131764740);
    this.zdZ.dRH();
    AppMethodBeat.o(29883);
  }
  
  protected final void dRv()
  {
    AppMethodBeat.i(29876);
    ad.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[] { this.zeb });
    if ((!bt.isNullOrNil(this.zeb)) && (!bt.isNullOrNil(this.zdE)))
    {
      Object localObject = this.zez;
      localObject = new com.tencent.mm.plugin.voiceprint.model.h(this.zeb, ((com.tencent.mm.plugin.voiceprint.model.n)localObject).zdF, ((com.tencent.mm.plugin.voiceprint.model.n)localObject).jgp);
      ((com.tencent.mm.plugin.voiceprint.model.h)localObject).zdo = true;
      az.aeS().a((com.tencent.mm.al.n)localObject, 0);
      this.zdW.setEnabled(false);
      this.zdZ.cQH();
    }
    AppMethodBeat.o(29876);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29875);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.vKh.f(11557, new Object[] { Integer.valueOf(1) });
    this.kGt = bt.by(getIntent().getStringExtra("Kusername"), null);
    paramBundle = bt.by(getIntent().getStringExtra("Kvertify_key"), null);
    ad.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[] { this.kGt, Boolean.valueOf(bt.isNullOrNil(paramBundle)) });
    if ((bt.isNullOrNil(this.kGt)) && (bt.isNullOrNil(paramBundle)))
    {
      ad.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
      AppMethodBeat.o(29875);
      return;
    }
    this.zez = new com.tencent.mm.plugin.voiceprint.model.n();
    this.zez.kGt = this.kGt;
    this.zez.jgp = paramBundle;
    this.zez.zdH = this;
    paramBundle = this.zez;
    if (bt.isNullOrNil(paramBundle.jgp))
    {
      paramBundle = new e(paramBundle.kGt);
      az.aeS().a(paramBundle, 0);
    }
    for (;;)
    {
      ad.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bt.eGN(), this });
      setBackBtn(new VoiceLoginUI.1(this));
      if (d.lf(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131100695));
        updataStatusBarIcon(ai.Eq());
      }
      AppMethodBeat.o(29875);
      return;
      paramBundle.dRo();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29884);
    super.onDestroy();
    if (this.zez != null)
    {
      com.tencent.mm.plugin.voiceprint.model.n localn = this.zez;
      az.aeS().b(618, localn);
      az.aeS().b(616, localn);
      az.aeS().b(617, localn);
      localn.zdH = null;
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
        dRs();
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
  
  public final void ro(boolean paramBoolean)
  {
    AppMethodBeat.i(29881);
    this.zdZ.cQI();
    this.zdW.setEnabled(true);
    if (paramBoolean)
    {
      ad.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[] { bt.aGs(this.zez.iri) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", this.zez.iri);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(29881);
      return;
    }
    ad.i("MicroMsg.VoiceLoginUI", "login failed");
    this.zdZ.setErr(2131764733);
    this.zdZ.dRH();
    AppMethodBeat.o(29881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI
 * JD-Core Version:    0.7.0.1
 */