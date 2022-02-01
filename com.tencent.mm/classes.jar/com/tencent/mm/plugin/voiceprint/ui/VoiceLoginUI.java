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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;

public class VoiceLoginUI
  extends BaseVoicePrintUI
  implements n.a
{
  private n GSa = null;
  private String mRa = null;
  
  private void goBack()
  {
    AppMethodBeat.i(29878);
    setResult(0);
    finish();
    AppMethodBeat.o(29878);
  }
  
  public final void aUv(String paramString)
  {
    AppMethodBeat.i(29880);
    Log.d("MicroMsg.VoiceLoginUI", "onGetText");
    this.GRf = paramString;
    this.GRA.fEV();
    this.GRA.setTipText(paramString);
    this.GRA.ekF();
    this.GRx.setEnabled(true);
    AppMethodBeat.o(29880);
  }
  
  protected final void edG()
  {
    AppMethodBeat.i(29877);
    findViewById(2131307087).setVisibility(8);
    this.GRA.fEU();
    this.GRA.setTitleText(2131767171);
    this.GRA.fEW();
    this.GRx.setEnabled(false);
    AppMethodBeat.o(29877);
  }
  
  public final void fED()
  {
    AppMethodBeat.i(29882);
    acL(2131767178);
    AppMethodBeat.o(29882);
  }
  
  public final void fEF()
  {
    AppMethodBeat.i(29883);
    this.GRx.setEnabled(false);
    this.GRx.setVisibility(4);
    this.GRA.ekF();
    this.GRA.setErr(2131767177);
    this.GRA.fEX();
    AppMethodBeat.o(29883);
  }
  
  protected final void fEK()
  {
    AppMethodBeat.i(29876);
    Log.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[] { this.GRC });
    if ((!Util.isNullOrNil(this.GRC)) && (!Util.isNullOrNil(this.GRf)))
    {
      Object localObject = this.GSa;
      localObject = new com.tencent.mm.plugin.voiceprint.model.h(this.GRC, ((n)localObject).GRg, ((n)localObject).lhR);
      ((com.tencent.mm.plugin.voiceprint.model.h)localObject).GQR = true;
      bg.azz().a((q)localObject, 0);
      this.GRx.setEnabled(false);
      this.GRA.fEU();
    }
    AppMethodBeat.o(29876);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29875);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.CyF.a(11557, new Object[] { Integer.valueOf(1) });
    this.mRa = Util.nullAs(getIntent().getStringExtra("Kusername"), null);
    paramBundle = Util.nullAs(getIntent().getStringExtra("Kvertify_key"), null);
    Log.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[] { this.mRa, Boolean.valueOf(Util.isNullOrNil(paramBundle)) });
    if ((Util.isNullOrNil(this.mRa)) && (Util.isNullOrNil(paramBundle)))
    {
      Log.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
      AppMethodBeat.o(29875);
      return;
    }
    this.GSa = new n();
    this.GSa.mRa = this.mRa;
    this.GSa.lhR = paramBundle;
    this.GSa.GRi = this;
    paramBundle = this.GSa;
    if (Util.isNullOrNil(paramBundle.lhR))
    {
      paramBundle = new e(paramBundle.mRa);
      bg.azz().a(paramBundle, 0);
    }
    for (;;)
    {
      Log.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), Util.getStack(), this });
      setBackBtn(new VoiceLoginUI.1(this));
      if (d.oD(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131100888));
        updataStatusBarIcon(ao.isDarkMode());
      }
      AppMethodBeat.o(29875);
      return;
      paramBundle.fEE();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29884);
    super.onDestroy();
    if (this.GSa != null)
    {
      n localn = this.GSa;
      bg.azz().b(618, localn);
      bg.azz().b(616, localn);
      bg.azz().b(617, localn);
      localn.GRi = null;
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
      Log.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(29885);
      return;
    }
    Log.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29885);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        fEH();
        AppMethodBeat.o(29885);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131756929), false, new VoiceLoginUI.2(this), new VoiceLoginUI.3(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wO(boolean paramBoolean)
  {
    AppMethodBeat.i(29881);
    this.GRA.ekF();
    this.GRx.setEnabled(true);
    if (paramBoolean)
    {
      Log.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[] { Util.secPrint(this.GSa.kly) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", this.GSa.kly);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(29881);
      return;
    }
    Log.i("MicroMsg.VoiceLoginUI", "login failed");
    this.GRA.setErr(2131767170);
    this.GRA.fEX();
    AppMethodBeat.o(29881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI
 * JD-Core Version:    0.7.0.1
 */