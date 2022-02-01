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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;

public class VoiceLoginUI
  extends BaseVoicePrintUI
  implements n.a
{
  private n NIl = null;
  private String pRV = null;
  
  private void goBack()
  {
    AppMethodBeat.i(29878);
    setResult(0);
    finish();
    AppMethodBeat.o(29878);
  }
  
  public final void AG(boolean paramBoolean)
  {
    AppMethodBeat.i(29881);
    this.NHL.eUn();
    this.NHI.setEnabled(true);
    if (paramBoolean)
    {
      Log.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[] { Util.secPrint(this.NIl.ndo) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", this.NIl.ndo);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(29881);
      return;
    }
    Log.i("MicroMsg.VoiceLoginUI", "login failed");
    this.NHL.setErr(R.l.eUV);
    this.NHL.gxj();
    AppMethodBeat.o(29881);
  }
  
  public final void bfZ(String paramString)
  {
    AppMethodBeat.i(29880);
    Log.d("MicroMsg.VoiceLoginUI", "onGetText");
    this.NHq = paramString;
    this.NHL.gxh();
    this.NHL.setTipText(paramString);
    this.NHL.eUn();
    this.NHI.setEnabled(true);
    AppMethodBeat.o(29880);
  }
  
  protected final void eNb()
  {
    AppMethodBeat.i(29877);
    findViewById(R.h.right_btn).setVisibility(8);
    this.NHL.dBa();
    this.NHL.setTitleText(R.l.eUW);
    this.NHL.gxi();
    this.NHI.setEnabled(false);
    AppMethodBeat.o(29877);
  }
  
  public final void gwQ()
  {
    AppMethodBeat.i(29882);
    akv(R.l.eVb);
    AppMethodBeat.o(29882);
  }
  
  public final void gwS()
  {
    AppMethodBeat.i(29883);
    this.NHI.setEnabled(false);
    this.NHI.setVisibility(4);
    this.NHL.eUn();
    this.NHL.setErr(R.l.eVa);
    this.NHL.gxj();
    AppMethodBeat.o(29883);
  }
  
  protected final void gwX()
  {
    AppMethodBeat.i(29876);
    Log.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[] { this.NHN });
    if ((!Util.isNullOrNil(this.NHN)) && (!Util.isNullOrNil(this.NHq)))
    {
      Object localObject = this.NIl;
      localObject = new com.tencent.mm.plugin.voiceprint.model.h(this.NHN, ((n)localObject).NHr, ((n)localObject).ocz);
      ((com.tencent.mm.plugin.voiceprint.model.h)localObject).NHc = true;
      bh.aGY().a((q)localObject, 0);
      this.NHI.setEnabled(false);
      this.NHL.dBa();
    }
    AppMethodBeat.o(29876);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29875);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.IzE.a(11557, new Object[] { Integer.valueOf(1) });
    this.pRV = Util.nullAs(getIntent().getStringExtra("Kusername"), null);
    paramBundle = Util.nullAs(getIntent().getStringExtra("Kvertify_key"), null);
    Log.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[] { this.pRV, Boolean.valueOf(Util.isNullOrNil(paramBundle)) });
    if ((Util.isNullOrNil(this.pRV)) && (Util.isNullOrNil(paramBundle)))
    {
      Log.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
      AppMethodBeat.o(29875);
      return;
    }
    this.NIl = new n();
    this.NIl.pRV = this.pRV;
    this.NIl.ocz = paramBundle;
    this.NIl.NHt = this;
    paramBundle = this.NIl;
    if (Util.isNullOrNil(paramBundle.ocz))
    {
      paramBundle = new e(paramBundle.pRV);
      bh.aGY().a(paramBundle, 0);
    }
    for (;;)
    {
      Log.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), Util.getStack(), this });
      setBackBtn(new VoiceLoginUI.1(this));
      if (d.qV(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(R.e.navpage));
        updataStatusBarIcon(ar.isDarkMode());
      }
      AppMethodBeat.o(29875);
      return;
      paramBundle.gwR();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29884);
    super.onDestroy();
    if (this.NIl != null)
    {
      n localn = this.NIl;
      bh.aGY().b(618, localn);
      bh.aGY().b(616, localn);
      bh.aGY().b(617, localn);
      localn.NHt = null;
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
        gwU();
        AppMethodBeat.o(29885);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new VoiceLoginUI.2(this), new VoiceLoginUI.3(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI
 * JD-Core Version:    0.7.0.1
 */