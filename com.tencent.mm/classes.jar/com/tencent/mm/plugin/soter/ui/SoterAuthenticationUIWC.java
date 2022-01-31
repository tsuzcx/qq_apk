package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.b.e;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.plugin.soter.d.l;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.b.d;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUIWC
  extends MMActivity
{
  private static android.support.v7.app.b snU = null;
  public static SoterAuthenticationUIWC.a soI = null;
  private String appId;
  private int fromScene;
  private ProgressDialog kFY;
  private c soC;
  private com.tencent.soter.a.b.b<d> soG;
  
  public SoterAuthenticationUIWC()
  {
    AppMethodBeat.i(59365);
    this.soC = null;
    this.kFY = null;
    this.fromScene = -1;
    this.appId = null;
    this.soG = new SoterAuthenticationUIWC.1(this);
    AppMethodBeat.o(59365);
  }
  
  private static int Aw(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return 0;
    case 90001: 
    case 90002: 
    case 90003: 
    case 90004: 
    case 90006: 
    case 90007: 
    case 90011: 
      return 2;
    }
    return 3;
  }
  
  private void a(k paramk)
  {
    AppMethodBeat.i(59369);
    setResult(1, d(paramk));
    c(paramk);
    finish();
    AppMethodBeat.o(59369);
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(59371);
    if (paramk == null)
    {
      AppMethodBeat.o(59371);
      return;
    }
    if (this.fromScene == 0)
    {
      int i = Aw(paramk.errCode);
      l locall = l.sor;
      l.m("requireSoterBiometricAuthentication", this.appId, i, paramk.errCode);
    }
    AppMethodBeat.o(59371);
  }
  
  private static Intent d(k paramk)
  {
    AppMethodBeat.i(59370);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramk.errCode);
    localBundle.putString("err_msg", paramk.errMsg);
    localBundle.putByte("use_mode", paramk.sop);
    localBundle.putString("result_json", paramk.cGu);
    localBundle.putString("result_json_signature", paramk.soq);
    ab.d("MicroMsg.SoterAuthenticationUIWC", "hy: dump mp soter result: %s", new Object[] { localBundle.toString() });
    paramk = new Intent();
    paramk.putExtras(localBundle);
    AppMethodBeat.o(59370);
    return paramk;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  @TargetApi(23)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(59366);
    super.onCreate(paramBundle);
    if (soI != null) {
      SoterAuthenticationUIWC.a.a(soI);
    }
    soI = new SoterAuthenticationUIWC.a(this, (byte)0);
    paramBundle = new j();
    k localk = new k();
    Object localObject = getIntent().getStringExtra("auth_mode");
    if (bo.isNullOrNil((String)localObject))
    {
      ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode : null");
      localk.errCode = 90003;
      localk.errMsg = "authen mode is null";
    }
    for (;;)
    {
      if (localk.errCode != 0)
      {
        a(localk);
        AppMethodBeat.o(59366);
        return;
      }
      try
      {
        paramBundle.soo = Byte.parseByte(bo.bf(((String)localObject).substring(2), "00"), 16);
        paramBundle.mGC = getIntent().getStringExtra("challenge");
        paramBundle.content = getIntent().getStringExtra("auth_content");
        if (!m.cyg())
        {
          ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: not support soter");
          localk.errCode = 90001;
          localk.errMsg = "not support soter";
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode format: %s", new Object[] { localObject });
        localk.errCode = 90003;
        localk.errMsg = "authen mode is illegal: number format error. found: ".concat(String.valueOf(localObject));
        continue;
        if (paramBundle.soo <= 0)
        {
          ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: request mode illegal");
          localk.errCode = 90003;
          localk.errMsg = "resp model error";
          continue;
        }
        if (bo.isNullOrNil(paramBundle.mGC))
        {
          ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge null");
          localk.errCode = 90004;
          localk.errMsg = "challenge is null";
          continue;
        }
        if (paramBundle.mGC.length() >= 512)
        {
          ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge too long");
          localk.errCode = 90004;
          localk.errMsg = "challenge is too long. 512 chars at most";
          continue;
        }
        if (bo.isNullOrNil(paramBundle.content))
        {
          paramBundle.content = getString(2131304050);
          continue;
        }
        if (paramBundle.content.length() <= 42) {
          continue;
        }
        ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: content too long. use default");
        paramBundle.content = getString(2131304050);
        continue;
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        localObject = com.tencent.mm.plugin.soter.c.a.snR;
        this.soC = com.tencent.mm.plugin.soter.c.a.a(this, paramBundle, localk, soI);
        if (this.soC == null)
        {
          ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: no corresponding authen mode");
          localk.errCode = 90003;
          localk.errMsg = "no corresponding mode";
          a(localk);
          AppMethodBeat.o(59366);
          return;
        }
        this.soC.soj = new f();
        this.soC.soi = new e();
        this.soC.mScene = 2;
        this.appId = getIntent().getStringExtra("key_app_id");
        this.soC.eB();
        AppMethodBeat.o(59366);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label184:
        break label184;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(59373);
    super.onDestroy();
    if ((this.kFY != null) && (this.kFY.isShowing()))
    {
      ab.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mProgressDialog dismiss!");
      this.kFY.dismiss();
    }
    if ((snU != null) && (snU.isShowing()))
    {
      ab.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mAuthenDialog dismiss!");
      snU.dismiss();
    }
    SoterAuthenticationUIWC.a.a(soI);
    AppMethodBeat.o(59373);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(59368);
    super.onPause();
    if (this.soC != null) {
      this.soC.onPause();
    }
    AppMethodBeat.o(59368);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(59372);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.soC != null) {
      this.soC.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(59372);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(59367);
    super.onResume();
    if (this.soC != null) {
      this.soC.onResume();
    }
    AppMethodBeat.o(59367);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC
 * JD-Core Version:    0.7.0.1
 */