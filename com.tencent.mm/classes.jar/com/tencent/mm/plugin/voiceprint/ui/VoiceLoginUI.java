package com.tencent.mm.plugin.voiceprint.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;

public class VoiceLoginUI
  extends BaseVoicePrintUI
  implements n.a
{
  private n Uum = null;
  private String sWX = null;
  
  private void goBack()
  {
    AppMethodBeat.i(29878);
    setResult(0);
    finish();
    AppMethodBeat.o(29878);
  }
  
  public final void Gf(boolean paramBoolean)
  {
    AppMethodBeat.i(29881);
    this.UtL.gdb();
    this.UtI.setEnabled(true);
    if (paramBoolean)
    {
      Log.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[] { Util.secPrint(this.Uum.pZt) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", this.Uum.pZt);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(29881);
      return;
    }
    Log.i("MicroMsg.VoiceLoginUI", "login failed");
    this.UtL.setErr(R.l.gXZ);
    this.UtL.hVg();
    AppMethodBeat.o(29881);
  }
  
  public final void bfF(String paramString)
  {
    AppMethodBeat.i(29880);
    Log.d("MicroMsg.VoiceLoginUI", "onGetText");
    this.Utq = paramString;
    this.UtL.hVe();
    this.UtL.setTipText(paramString);
    this.UtL.gdb();
    this.UtI.setEnabled(true);
    AppMethodBeat.o(29880);
  }
  
  protected final void fVu()
  {
    AppMethodBeat.i(29877);
    findViewById(R.h.right_btn).setVisibility(8);
    this.UtL.eAg();
    this.UtL.setTitleText(R.l.gYa);
    this.UtL.hVf();
    this.UtI.setEnabled(false);
    AppMethodBeat.o(29877);
  }
  
  public final void hUN()
  {
    AppMethodBeat.i(29882);
    apQ(R.l.gYf);
    AppMethodBeat.o(29882);
  }
  
  public final void hUP()
  {
    AppMethodBeat.i(29883);
    this.UtI.setEnabled(false);
    this.UtI.setVisibility(4);
    this.UtL.gdb();
    this.UtL.setErr(R.l.gYe);
    this.UtL.hVg();
    AppMethodBeat.o(29883);
  }
  
  protected final void hUU()
  {
    AppMethodBeat.i(29876);
    Log.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[] { this.UtN });
    if ((!Util.isNullOrNil(this.UtN)) && (!Util.isNullOrNil(this.Utq)))
    {
      Object localObject = this.Uum;
      localObject = new com.tencent.mm.plugin.voiceprint.model.h(this.UtN, ((n)localObject).Utr, ((n)localObject).rdq);
      ((com.tencent.mm.plugin.voiceprint.model.h)localObject).Utc = true;
      bh.aZW().a((p)localObject, 0);
      this.UtI.setEnabled(false);
      this.UtL.eAg();
    }
    AppMethodBeat.o(29876);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29875);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.OAn.b(11557, new Object[] { Integer.valueOf(1) });
    this.sWX = Util.nullAs(getIntent().getStringExtra("Kusername"), null);
    paramBundle = Util.nullAs(getIntent().getStringExtra("Kvertify_key"), null);
    Log.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[] { this.sWX, Boolean.valueOf(Util.isNullOrNil(paramBundle)) });
    if ((Util.isNullOrNil(this.sWX)) && (Util.isNullOrNil(paramBundle)))
    {
      Log.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
      AppMethodBeat.o(29875);
      return;
    }
    this.Uum = new n();
    this.Uum.sWX = this.sWX;
    this.Uum.rdq = paramBundle;
    this.Uum.Utt = this;
    paramBundle = this.Uum;
    if (Util.isNullOrNil(paramBundle.rdq))
    {
      paramBundle = new e(paramBundle.sWX);
      bh.aZW().a(paramBundle, 0);
    }
    for (;;)
    {
      Log.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, getString(R.l.gUZ))), Util.getStack(), this });
      setBackBtn(new VoiceLoginUI.1(this));
      if (d.rb(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(R.e.navpage));
        updataStatusBarIcon(aw.isDarkMode());
      }
      AppMethodBeat.o(29875);
      return;
      paramBundle.hUO();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29884);
    super.onDestroy();
    if (this.Uum != null)
    {
      n localn = this.Uum;
      bh.aZW().b(618, localn);
      bh.aZW().b(616, localn);
      bh.aZW().b(617, localn);
      localn.Utt = null;
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
        hUR();
        AppMethodBeat.o(29885);
        return;
      }
      k.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new VoiceLoginUI.2(this), new VoiceLoginUI.3(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI
 * JD-Core Version:    0.7.0.1
 */