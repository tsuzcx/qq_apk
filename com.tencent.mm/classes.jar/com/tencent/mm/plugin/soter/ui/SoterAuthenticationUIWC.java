package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.ah.a.c;
import com.tencent.mm.plugin.soter.b.e;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.plugin.soter.d.l;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.b.d;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUIWC
  extends MMActivity
{
  private static android.support.v7.app.b prS = null;
  public static SoterAuthenticationUIWC.a psC = null;
  private String appId = null;
  private int fromScene = -1;
  private ProgressDialog khj = null;
  private com.tencent.soter.a.b.b<d> psA = new com.tencent.soter.a.b.b() {};
  private c psw = null;
  
  private void a(k paramk)
  {
    setResult(1, d(paramk));
    c(paramk);
    finish();
  }
  
  private void c(k paramk)
  {
    if (paramk == null) {}
    while (this.fromScene != 0) {
      return;
    }
    int j = paramk.errCode;
    int i = -1;
    switch (j)
    {
    }
    for (;;)
    {
      l locall = l.psq;
      l.m("requireSoterBiometricAuthentication", this.appId, i, paramk.errCode);
      return;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private static Intent d(k paramk)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramk.errCode);
    localBundle.putString("err_msg", paramk.aox);
    localBundle.putByte("use_mode", paramk.pso);
    localBundle.putString("result_json", paramk.bYt);
    localBundle.putString("result_json_signature", paramk.psp);
    y.d("MicroMsg.SoterAuthenticationUIWC", "hy: dump mp soter result: %s", new Object[] { localBundle.toString() });
    paramk = new Intent();
    paramk.putExtras(localBundle);
    return paramk;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  @TargetApi(23)
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (psC != null) {
      SoterAuthenticationUIWC.a.a(psC);
    }
    psC = new SoterAuthenticationUIWC.a(this, (byte)0);
    paramBundle = new j();
    k localk = new k();
    Object localObject = getIntent().getStringExtra("auth_mode");
    if (bk.bl((String)localObject))
    {
      y.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode : null");
      localk.errCode = 90003;
      localk.aox = "authen mode is null";
    }
    for (;;)
    {
      if (localk.errCode != 0)
      {
        a(localk);
        return;
      }
      try
      {
        paramBundle.psn = Byte.parseByte(bk.aM(((String)localObject).substring(2), "00"), 16);
        paramBundle.klM = getIntent().getStringExtra("challenge");
        paramBundle.content = getIntent().getStringExtra("auth_content");
        if (!m.bKV())
        {
          y.e("MicroMsg.SoterAuthenticationUIWC", "hy: not support soter");
          localk.errCode = 90001;
          localk.aox = "not support soter";
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        y.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode format: %s", new Object[] { localObject });
        localk.errCode = 90003;
        localk.aox = ("authen mode is illegal: number format error. found: " + (String)localObject);
        continue;
        if (paramBundle.psn <= 0)
        {
          y.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: request mode illegal");
          localk.errCode = 90003;
          localk.aox = "resp model error";
          continue;
        }
        if (bk.bl(paramBundle.klM))
        {
          y.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge null");
          localk.errCode = 90004;
          localk.aox = "challenge is null";
          continue;
        }
        if (paramBundle.klM.length() >= 512)
        {
          y.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge too long");
          localk.errCode = 90004;
          localk.aox = "challenge is too long. 512 chars at most";
          continue;
        }
        if (bk.bl(paramBundle.content))
        {
          paramBundle.content = getString(a.c.soter_authen_put_finger_msg);
          continue;
        }
        if (paramBundle.content.length() <= 42) {
          continue;
        }
        y.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: content too long. use default");
        paramBundle.content = getString(a.c.soter_authen_put_finger_msg);
        continue;
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        localObject = com.tencent.mm.plugin.soter.c.a.prP;
        this.psw = com.tencent.mm.plugin.soter.c.a.a(this, paramBundle, localk, psC);
        if (this.psw == null)
        {
          y.e("MicroMsg.SoterAuthenticationUIWC", "hy: no corresponding authen mode");
          localk.errCode = 90003;
          localk.aox = "no corresponding mode";
          a(localk);
          return;
        }
        this.psw.psh = new f();
        this.psw.psg = new e();
        this.psw.fzn = 2;
        this.appId = getIntent().getStringExtra("key_app_id");
        this.psw.ef();
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label172:
        break label172;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.khj != null) && (this.khj.isShowing()))
    {
      y.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mProgressDialog dismiss!");
      this.khj.dismiss();
    }
    if ((prS != null) && (prS.isShowing()))
    {
      y.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mAuthenDialog dismiss!");
      prS.dismiss();
    }
    SoterAuthenticationUIWC.a.a(psC);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.psw != null) {
      this.psw.onPause();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.psw != null) {
      this.psw.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.psw != null) {
      this.psw.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC
 * JD-Core Version:    0.7.0.1
 */