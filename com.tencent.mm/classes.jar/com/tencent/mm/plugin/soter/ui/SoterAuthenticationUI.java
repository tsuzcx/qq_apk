package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.c.c.a;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.soter.a.a.1;
import com.tencent.soter.a.b.d;
import com.tencent.soter.a.g.e.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;

public class SoterAuthenticationUI
  extends AppCompatActivity
{
  private static android.support.v7.app.b snU = null;
  public static SoterAuthenticationUI.a soF = null;
  private ResultReceiver Di;
  private String appId;
  private int fromScene;
  private ProgressDialog kFY;
  private int scene;
  private c soC;
  private boolean soD;
  private com.tencent.soter.core.c.i soE;
  private com.tencent.soter.a.b.b<d> soG;
  private c.a sok;
  
  public SoterAuthenticationUI()
  {
    AppMethodBeat.i(73900);
    this.soC = null;
    this.kFY = null;
    this.fromScene = -1;
    this.scene = -1;
    this.soD = false;
    this.soE = null;
    this.appId = null;
    this.sok = new SoterAuthenticationUI.1(this);
    this.soG = new SoterAuthenticationUI.2(this);
    AppMethodBeat.o(73900);
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
    AppMethodBeat.i(73904);
    this.Di.send(1, b(paramk));
    c(paramk);
    finish();
    AppMethodBeat.o(73904);
  }
  
  private static Bundle b(k paramk)
  {
    AppMethodBeat.i(73905);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramk.errCode);
    localBundle.putString("err_msg", paramk.errMsg);
    localBundle.putByte("use_mode", paramk.sop);
    localBundle.putString("result_json", paramk.cGu);
    localBundle.putString("result_json_signature", paramk.soq);
    ab.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", new Object[] { localBundle.toString() });
    AppMethodBeat.o(73905);
    return localBundle;
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(73906);
    if (paramk == null)
    {
      AppMethodBeat.o(73906);
      return;
    }
    if (this.fromScene == 1)
    {
      int i = Aw(paramk.errCode);
      com.tencent.mm.plugin.soter.d.i.au(this.appId, paramk.errCode, i);
    }
    AppMethodBeat.o(73906);
  }
  
  public void finish()
  {
    AppMethodBeat.i(140137);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(140137);
  }
  
  @TargetApi(23)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73901);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    this.Di = ((ResultReceiver)getIntent().getParcelableExtra("Soter_Result_Receiver"));
    if (soF != null) {
      SoterAuthenticationUI.a.a(soF);
    }
    soF = new SoterAuthenticationUI.a(this, (byte)0);
    paramBundle = new j();
    Object localObject1 = new k();
    Object localObject2 = getIntent().getStringExtra("auth_mode");
    if (bo.isNullOrNil((String)localObject2))
    {
      ab.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
      ((k)localObject1).errCode = 90003;
      ((k)localObject1).errMsg = "authen mode is null";
    }
    for (;;)
    {
      if (((k)localObject1).errCode != 0)
      {
        a((k)localObject1);
        AppMethodBeat.o(73901);
        return;
      }
      try
      {
        paramBundle.soo = Byte.parseByte(bo.bf(((String)localObject2).substring(2), "00"), 16);
        paramBundle.mGC = getIntent().getStringExtra("challenge");
        paramBundle.content = getIntent().getStringExtra("auth_content");
        if (!com.tencent.soter.core.a.dVc())
        {
          ab.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
          ((k)localObject1).errCode = 90001;
          ((k)localObject1).errMsg = "not support soter";
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        ab.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[] { localObject2 });
        ((k)localObject1).errCode = 90003;
        ((k)localObject1).errMsg = "authen mode is illegal: number format error. found: ".concat(String.valueOf(localObject2));
        continue;
        if (paramBundle.soo <= 0)
        {
          ab.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
          ((k)localObject1).errCode = 90003;
          ((k)localObject1).errMsg = "resp model error";
          continue;
        }
        if (bo.isNullOrNil(paramBundle.mGC))
        {
          ab.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
          ((k)localObject1).errCode = 90004;
          ((k)localObject1).errMsg = "challenge is null";
          continue;
        }
        if (paramBundle.mGC.length() >= 512)
        {
          ab.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
          ((k)localObject1).errCode = 90004;
          ((k)localObject1).errMsg = "challenge is too long. 512 chars at most";
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
        ab.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
        paramBundle.content = getString(2131304050);
        continue;
        this.fromScene = getIntent().getIntExtra("key_soter_fp_luggage_fromscene", 1);
        this.scene = getIntent().getIntExtra("key_soter_fp_luggage_scene", 2048);
        localObject2 = com.tencent.mm.plugin.soter.c.a.snR;
        this.soC = com.tencent.mm.plugin.soter.c.a.a(this, paramBundle, (k)localObject1, soF);
        if (this.soC == null)
        {
          ab.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
          ((k)localObject1).errCode = 90003;
          ((k)localObject1).errMsg = "no corresponding mode";
          a((k)localObject1);
          AppMethodBeat.o(73901);
          return;
        }
        this.soC.soj = null;
        this.soC.soi = null;
        this.soC.mScene = this.scene;
        this.soC.sok = this.sok;
        boolean bool = com.tencent.soter.a.c.a.dVu().isInit();
        ab.i("MicroMsg.SoterAuthenticationUI", "hy: isInit:".concat(String.valueOf(bool)));
        if (!bool)
        {
          ab.i("MicroMsg.SoterAuthenticationUI", "hy: init scene:" + this.soC.mScene);
          paramBundle = new e.a().H(new int[] { this.soC.mScene }).BnE;
          localObject1 = getApplicationContext();
          localObject2 = this.soG;
          g.dVG().O(new a.1((Context)localObject1, paramBundle, (com.tencent.soter.a.b.b)localObject2));
          this.soD = true;
        }
        this.appId = getIntent().getStringExtra("key_app_id");
        this.soC.eB();
        AppMethodBeat.o(73901);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label213:
        break label213;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73908);
    super.onDestroy();
    if ((this.kFY != null) && (this.kFY.isShowing()))
    {
      ab.i("MicroMsg.SoterAuthenticationUI", "onDestroy mProgressDialog dismiss!");
      this.kFY.dismiss();
    }
    if ((snU != null) && (snU.isShowing()))
    {
      ab.i("MicroMsg.SoterAuthenticationUI", "onDestroy mAuthenDialog dismiss!");
      snU.dismiss();
    }
    SoterAuthenticationUI.a.a(soF);
    if (this.soD)
    {
      f.dVD().dVE();
      com.tencent.soter.a.c.a locala = com.tencent.soter.a.c.a.dVu();
      try
      {
        locala.bRB = false;
        locala.coB = false;
        locala.BmZ = new SparseArray(10);
        locala.Bna = null;
        return;
      }
      finally
      {
        AppMethodBeat.o(73908);
      }
    }
    AppMethodBeat.o(73908);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(73903);
    super.onPause();
    if (this.soC != null) {
      this.soC.onPause();
    }
    AppMethodBeat.o(73903);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(73907);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.soC != null) {
      this.soC.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(73907);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73902);
    super.onResume();
    if (this.soC != null) {
      this.soC.onResume();
    }
    overridePendingTransition(0, 0);
    AppMethodBeat.o(73902);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI
 * JD-Core Version:    0.7.0.1
 */