package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class VoiceLoginUI
  extends BaseVoicePrintUI
  implements n.a
{
  private String ikj = null;
  private n tso = null;
  
  private void goBack()
  {
    AppMethodBeat.i(26196);
    setResult(0);
    finish();
    AppMethodBeat.o(26196);
  }
  
  public final void aeD(String paramString)
  {
    AppMethodBeat.i(26198);
    ab.d("MicroMsg.VoiceLoginUI", "onGetText");
    this.tru = paramString;
    this.trO.cLx();
    this.trO.setTipText(paramString);
    this.trO.bRO();
    this.trL.setEnabled(true);
    AppMethodBeat.o(26198);
  }
  
  protected final void bMe()
  {
    AppMethodBeat.i(26195);
    findViewById(2131823890).setVisibility(8);
    this.trO.bRN();
    this.trO.setTitleText(2131304561);
    this.trO.cLy();
    this.trL.setEnabled(false);
    AppMethodBeat.o(26195);
  }
  
  public final void cLf()
  {
    AppMethodBeat.i(26200);
    GY(2131304568);
    AppMethodBeat.o(26200);
  }
  
  public final void cLg()
  {
    AppMethodBeat.i(26201);
    this.trL.setEnabled(false);
    this.trL.setVisibility(4);
    this.trO.bRO();
    this.trO.setErr(2131304567);
    this.trO.cLz();
    AppMethodBeat.o(26201);
  }
  
  protected final void cLn()
  {
    AppMethodBeat.i(26194);
    ab.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[] { this.trQ });
    if ((!bo.isNullOrNil(this.trQ)) && (!bo.isNullOrNil(this.tru)))
    {
      Object localObject = this.tso;
      localObject = new com.tencent.mm.plugin.voiceprint.model.h(this.trQ, ((n)localObject).trv, ((n)localObject).hll);
      ((com.tencent.mm.plugin.voiceprint.model.h)localObject).tre = true;
      aw.Rc().a((m)localObject, 0);
      this.trL.setEnabled(false);
      this.trO.bRN();
    }
    AppMethodBeat.o(26194);
  }
  
  public final void mH(boolean paramBoolean)
  {
    AppMethodBeat.i(26199);
    this.trO.bRO();
    this.trL.setEnabled(true);
    if (paramBoolean)
    {
      ab.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[] { bo.aqg(this.tso.gEl) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", this.tso.gEl);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(26199);
      return;
    }
    ab.i("MicroMsg.VoiceLoginUI", "login failed");
    this.trO.setErr(2131304560);
    this.trO.cLz();
    AppMethodBeat.o(26199);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26193);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.qsU.e(11557, new Object[] { Integer.valueOf(1) });
    this.ikj = bo.bf(getIntent().getStringExtra("Kusername"), null);
    paramBundle = bo.bf(getIntent().getStringExtra("Kvertify_key"), null);
    ab.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[] { this.ikj, Boolean.valueOf(bo.isNullOrNil(paramBundle)) });
    if ((bo.isNullOrNil(this.ikj)) && (bo.isNullOrNil(paramBundle)))
    {
      ab.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
      AppMethodBeat.o(26193);
      return;
    }
    this.tso = new n();
    this.tso.ikj = this.ikj;
    this.tso.hll = paramBundle;
    this.tso.trx = this;
    paramBundle = this.tso;
    if (bo.isNullOrNil(paramBundle.hll))
    {
      paramBundle = new e(paramBundle.ikj);
      aw.Rc().a(paramBundle, 0);
    }
    for (;;)
    {
      ab.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bo.dtY(), this });
      setBackBtn(new VoiceLoginUI.1(this));
      if (d.fv(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131690310));
        supportLightStatusBar();
      }
      AppMethodBeat.o(26193);
      return;
      paramBundle.cLh();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26202);
    super.onDestroy();
    if (this.tso != null)
    {
      n localn = this.tso;
      aw.Rc().b(618, localn);
      aw.Rc().b(616, localn);
      aw.Rc().b(617, localn);
      localn.trx = null;
    }
    AppMethodBeat.o(26202);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26197);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(26197);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(26197);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26203);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(26203);
      return;
    }
    ab.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26203);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cLk();
        AppMethodBeat.o(26203);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302075), getString(2131302083), getString(2131300996), getString(2131297837), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26191);
          paramAnonymousDialogInterface.dismiss();
          VoiceLoginUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          AppMethodBeat.o(26191);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26192);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(26192);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI
 * JD-Core Version:    0.7.0.1
 */