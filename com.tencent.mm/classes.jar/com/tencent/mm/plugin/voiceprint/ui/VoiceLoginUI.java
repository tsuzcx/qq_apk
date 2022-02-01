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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;

public class VoiceLoginUI
  extends BaseVoicePrintUI
  implements n.a
{
  private com.tencent.mm.plugin.voiceprint.model.n Axf = null;
  private String lhM = null;
  
  private void goBack()
  {
    AppMethodBeat.i(29878);
    setResult(0);
    finish();
    AppMethodBeat.o(29878);
  }
  
  public final void ayt(String paramString)
  {
    AppMethodBeat.i(29880);
    ac.d("MicroMsg.VoiceLoginUI", "onGetText");
    this.Awk = paramString;
    this.AwF.egQ();
    this.AwF.setTipText(paramString);
    this.AwF.der();
    this.AwC.setEnabled(true);
    AppMethodBeat.o(29880);
  }
  
  protected final void cXK()
  {
    AppMethodBeat.i(29877);
    findViewById(2131304179).setVisibility(8);
    this.AwF.egP();
    this.AwF.setTitleText(2131764734);
    this.AwF.egR();
    this.AwC.setEnabled(false);
    AppMethodBeat.o(29877);
  }
  
  protected final void egF()
  {
    AppMethodBeat.i(29876);
    ac.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[] { this.AwH });
    if ((!bs.isNullOrNil(this.AwH)) && (!bs.isNullOrNil(this.Awk)))
    {
      Object localObject = this.Axf;
      localObject = new com.tencent.mm.plugin.voiceprint.model.h(this.AwH, ((com.tencent.mm.plugin.voiceprint.model.n)localObject).Awl, ((com.tencent.mm.plugin.voiceprint.model.n)localObject).jGE);
      ((com.tencent.mm.plugin.voiceprint.model.h)localObject).AvU = true;
      az.agi().a((com.tencent.mm.ak.n)localObject, 0);
      this.AwC.setEnabled(false);
      this.AwF.egP();
    }
    AppMethodBeat.o(29876);
  }
  
  public final void egx()
  {
    AppMethodBeat.i(29882);
    RT(2131764741);
    AppMethodBeat.o(29882);
  }
  
  public final void egz()
  {
    AppMethodBeat.i(29883);
    this.AwC.setEnabled(false);
    this.AwC.setVisibility(4);
    this.AwF.der();
    this.AwF.setErr(2131764740);
    this.AwF.egS();
    AppMethodBeat.o(29883);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29875);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.wUl.f(11557, new Object[] { Integer.valueOf(1) });
    this.lhM = bs.bG(getIntent().getStringExtra("Kusername"), null);
    paramBundle = bs.bG(getIntent().getStringExtra("Kvertify_key"), null);
    ac.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[] { this.lhM, Boolean.valueOf(bs.isNullOrNil(paramBundle)) });
    if ((bs.isNullOrNil(this.lhM)) && (bs.isNullOrNil(paramBundle)))
    {
      ac.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
      AppMethodBeat.o(29875);
      return;
    }
    this.Axf = new com.tencent.mm.plugin.voiceprint.model.n();
    this.Axf.lhM = this.lhM;
    this.Axf.jGE = paramBundle;
    this.Axf.Awn = this;
    paramBundle = this.Axf;
    if (bs.isNullOrNil(paramBundle.jGE))
    {
      paramBundle = new e(paramBundle.lhM);
      az.agi().a(paramBundle, 0);
    }
    for (;;)
    {
      ac.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bs.eWi(), this });
      setBackBtn(new VoiceLoginUI.1(this));
      if (d.kZ(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131100695));
        updataStatusBarIcon(aj.DT());
      }
      AppMethodBeat.o(29875);
      return;
      paramBundle.egy();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29884);
    super.onDestroy();
    if (this.Axf != null)
    {
      com.tencent.mm.plugin.voiceprint.model.n localn = this.Axf;
      az.agi().b(618, localn);
      az.agi().b(616, localn);
      az.agi().b(617, localn);
      localn.Awn = null;
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
      ac.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(29885);
      return;
    }
    ac.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29885);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        egC();
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
  
  public final void sp(boolean paramBoolean)
  {
    AppMethodBeat.i(29881);
    this.AwF.der();
    this.AwC.setEnabled(true);
    if (paramBoolean)
    {
      ac.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[] { bs.aLJ(this.Axf.iRo) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", this.Axf.iRo);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(29881);
      return;
    }
    ac.i("MicroMsg.VoiceLoginUI", "login failed");
    this.AwF.setErr(2131764733);
    this.AwF.egS();
    AppMethodBeat.o(29881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI
 * JD-Core Version:    0.7.0.1
 */