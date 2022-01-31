package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.soter.a.f;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.c.c.a;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.a.1;
import com.tencent.soter.a.b.d;
import com.tencent.soter.a.g.e.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.i;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUI
  extends AppCompatActivity
{
  private static android.support.v7.app.b prS = null;
  public static SoterAuthenticationUI.a psz = null;
  private ResultReceiver Cz;
  private String appId = null;
  private int fromScene = -1;
  private ProgressDialog khj = null;
  private com.tencent.soter.a.b.b<d> psA = new SoterAuthenticationUI.2(this);
  private c.a psi = new SoterAuthenticationUI.1(this);
  private c psw = null;
  private boolean psx = false;
  private i psy = null;
  private int scene = -1;
  
  private void a(k paramk)
  {
    this.Cz.send(1, b(paramk));
    c(paramk);
    finish();
  }
  
  private static Bundle b(k paramk)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramk.errCode);
    localBundle.putString("err_msg", paramk.aox);
    localBundle.putByte("use_mode", paramk.pso);
    localBundle.putString("result_json", paramk.bYt);
    localBundle.putString("result_json_signature", paramk.psp);
    y.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", new Object[] { localBundle.toString() });
    return localBundle;
  }
  
  private void c(k paramk)
  {
    if (paramk == null) {}
    while (this.fromScene != 1) {
      return;
    }
    int i;
    switch (paramk.errCode)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      String str = this.appId;
      int j = paramk.errCode;
      ((com.tencent.mm.plugin.appbrand.p.b)e.j(com.tencent.mm.plugin.appbrand.p.b.class)).f(13711, new Object[] { Integer.valueOf(0), str, Integer.valueOf(j), Integer.valueOf(i) });
      return;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  @TargetApi(23)
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.Cz = ((ResultReceiver)getIntent().getParcelableExtra("Soter_Result_Receiver"));
    if (psz != null) {
      SoterAuthenticationUI.a.a(psz);
    }
    psz = new SoterAuthenticationUI.a(this, (byte)0);
    paramBundle = new j();
    Object localObject1 = new k();
    Object localObject2 = getIntent().getStringExtra("auth_mode");
    if (bk.bl((String)localObject2))
    {
      y.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
      ((k)localObject1).errCode = 90003;
      ((k)localObject1).aox = "authen mode is null";
    }
    for (;;)
    {
      if (((k)localObject1).errCode != 0)
      {
        a((k)localObject1);
        return;
      }
      try
      {
        paramBundle.psn = Byte.parseByte(bk.aM(((String)localObject2).substring(2), "00"), 16);
        paramBundle.klM = getIntent().getStringExtra("challenge");
        paramBundle.content = getIntent().getStringExtra("auth_content");
        if (!com.tencent.soter.core.a.cPh())
        {
          y.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
          ((k)localObject1).errCode = 90001;
          ((k)localObject1).aox = "not support soter";
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        y.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[] { localObject2 });
        ((k)localObject1).errCode = 90003;
        ((k)localObject1).aox = ("authen mode is illegal: number format error. found: " + (String)localObject2);
        continue;
        if (paramBundle.psn <= 0)
        {
          y.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
          ((k)localObject1).errCode = 90003;
          ((k)localObject1).aox = "resp model error";
          continue;
        }
        if (bk.bl(paramBundle.klM))
        {
          y.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
          ((k)localObject1).errCode = 90004;
          ((k)localObject1).aox = "challenge is null";
          continue;
        }
        if (paramBundle.klM.length() >= 512)
        {
          y.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
          ((k)localObject1).errCode = 90004;
          ((k)localObject1).aox = "challenge is too long. 512 chars at most";
          continue;
        }
        if (bk.bl(paramBundle.content))
        {
          paramBundle.content = getString(a.f.soter_authen_put_finger_msg);
          continue;
        }
        if (paramBundle.content.length() <= 42) {
          continue;
        }
        y.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
        paramBundle.content = getString(a.f.soter_authen_put_finger_msg);
        continue;
        this.fromScene = getIntent().getIntExtra("key_soter_fp_luggage_fromscene", 1);
        this.scene = getIntent().getIntExtra("key_soter_fp_luggage_scene", 2048);
        localObject2 = com.tencent.mm.plugin.soter.c.a.prP;
        this.psw = com.tencent.mm.plugin.soter.c.a.a(this, paramBundle, (k)localObject1, psz);
        if (this.psw == null)
        {
          y.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
          ((k)localObject1).errCode = 90003;
          ((k)localObject1).aox = "no corresponding mode";
          a((k)localObject1);
          return;
        }
        this.psw.psh = null;
        this.psw.psg = null;
        this.psw.fzn = this.scene;
        this.psw.psi = this.psi;
        boolean bool = com.tencent.soter.a.c.a.cPy().isInit();
        y.i("MicroMsg.SoterAuthenticationUI", "hy: isInit:" + bool);
        if (!bool)
        {
          y.i("MicroMsg.SoterAuthenticationUI", "hy: init scene:" + this.psw.fzn);
          paramBundle = new e.a().x(new int[] { this.psw.fzn }).wQe;
          localObject1 = getApplicationContext();
          localObject2 = this.psA;
          g.cPK().H(new a.1((Context)localObject1, paramBundle, (com.tencent.soter.a.b.b)localObject2));
          this.psx = true;
        }
        this.appId = getIntent().getStringExtra("key_app_id");
        this.psw.ef();
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label197:
        break label197;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.khj != null) && (this.khj.isShowing()))
    {
      y.i("MicroMsg.SoterAuthenticationUI", "onDestroy mProgressDialog dismiss!");
      this.khj.dismiss();
    }
    if ((prS != null) && (prS.isShowing()))
    {
      y.i("MicroMsg.SoterAuthenticationUI", "onDestroy mAuthenDialog dismiss!");
      prS.dismiss();
    }
    SoterAuthenticationUI.a.a(psz);
    if (this.psx)
    {
      f.cPH().cPI();
      com.tencent.soter.a.c.a locala = com.tencent.soter.a.c.a.cPy();
      try
      {
        locala.dBn = false;
        locala.bHn = false;
        locala.wPz = new SparseArray(10);
        locala.wPA = null;
        return;
      }
      finally {}
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI
 * JD-Core Version:    0.7.0.1
 */