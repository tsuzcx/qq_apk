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
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;

public class VoiceLoginUI
  extends BaseVoicePrintUI
  implements n.a
{
  private com.tencent.mm.plugin.voiceprint.model.n Cob = null;
  private String lJm = null;
  
  private void goBack()
  {
    AppMethodBeat.i(29878);
    setResult(0);
    finish();
    AppMethodBeat.o(29878);
  }
  
  public final void aEV(String paramString)
  {
    AppMethodBeat.i(29880);
    ae.d("MicroMsg.VoiceLoginUI", "onGetText");
    this.Cng = paramString;
    this.CnB.eyh();
    this.CnB.setTipText(paramString);
    this.CnB.dqN();
    this.Cny.setEnabled(true);
    AppMethodBeat.o(29880);
  }
  
  protected final void djV()
  {
    AppMethodBeat.i(29877);
    findViewById(2131304179).setVisibility(8);
    this.CnB.eyg();
    this.CnB.setTitleText(2131764734);
    this.CnB.eyi();
    this.Cny.setEnabled(false);
    AppMethodBeat.o(29877);
  }
  
  public final void exP()
  {
    AppMethodBeat.i(29882);
    Us(2131764741);
    AppMethodBeat.o(29882);
  }
  
  public final void exR()
  {
    AppMethodBeat.i(29883);
    this.Cny.setEnabled(false);
    this.Cny.setVisibility(4);
    this.CnB.dqN();
    this.CnB.setErr(2131764740);
    this.CnB.eyj();
    AppMethodBeat.o(29883);
  }
  
  protected final void exW()
  {
    AppMethodBeat.i(29876);
    ae.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[] { this.CnD });
    if ((!bu.isNullOrNil(this.CnD)) && (!bu.isNullOrNil(this.Cng)))
    {
      Object localObject = this.Cob;
      localObject = new com.tencent.mm.plugin.voiceprint.model.h(this.CnD, ((com.tencent.mm.plugin.voiceprint.model.n)localObject).Cnh, ((com.tencent.mm.plugin.voiceprint.model.n)localObject).keg);
      ((com.tencent.mm.plugin.voiceprint.model.h)localObject).CmQ = true;
      bc.ajj().a((com.tencent.mm.ak.n)localObject, 0);
      this.Cny.setEnabled(false);
      this.CnB.eyg();
    }
    AppMethodBeat.o(29876);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29875);
    super.onCreate(paramBundle);
    g.yxI.f(11557, new Object[] { Integer.valueOf(1) });
    this.lJm = bu.bI(getIntent().getStringExtra("Kusername"), null);
    paramBundle = bu.bI(getIntent().getStringExtra("Kvertify_key"), null);
    ae.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[] { this.lJm, Boolean.valueOf(bu.isNullOrNil(paramBundle)) });
    if ((bu.isNullOrNil(this.lJm)) && (bu.isNullOrNil(paramBundle)))
    {
      ae.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
      AppMethodBeat.o(29875);
      return;
    }
    this.Cob = new com.tencent.mm.plugin.voiceprint.model.n();
    this.Cob.lJm = this.lJm;
    this.Cob.keg = paramBundle;
    this.Cob.Cnj = this;
    paramBundle = this.Cob;
    if (bu.isNullOrNil(paramBundle.keg))
    {
      paramBundle = new e(paramBundle.lJm);
      bc.ajj().a(paramBundle, 0);
    }
    for (;;)
    {
      ae.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bu.fpN(), this });
      setBackBtn(new VoiceLoginUI.1(this));
      if (d.lA(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131100695));
        updataStatusBarIcon(al.isDarkMode());
      }
      AppMethodBeat.o(29875);
      return;
      paramBundle.exQ();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29884);
    super.onDestroy();
    if (this.Cob != null)
    {
      com.tencent.mm.plugin.voiceprint.model.n localn = this.Cob;
      bc.ajj().b(618, localn);
      bc.ajj().b(616, localn);
      bc.ajj().b(617, localn);
      localn.Cnj = null;
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
      ae.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(29885);
      return;
    }
    ae.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29885);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        exT();
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
  
  public final void tf(boolean paramBoolean)
  {
    AppMethodBeat.i(29881);
    this.CnB.dqN();
    this.Cny.setEnabled(true);
    if (paramBoolean)
    {
      ae.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[] { bu.aSM(this.Cob.jnq) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", this.Cob.jnq);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(29881);
      return;
    }
    ae.i("MicroMsg.VoiceLoginUI", "login failed");
    this.CnB.setErr(2131764733);
    this.CnB.eyj();
    AppMethodBeat.o(29881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI
 * JD-Core Version:    0.7.0.1
 */