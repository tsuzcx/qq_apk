package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class j$11
  implements f
{
  j$11(j paramj) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    if (this.uJI.dnm != null)
    {
      this.uJI.dnm.dismiss();
      this.uJI.dnm = null;
    }
    if (paramm.getType() == 255)
    {
      au.Dk().b(255, this.uJI.uJD);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.uJI.mN(true);
      }
    }
    while (paramm.getType() != 384)
    {
      do
      {
        return;
      } while (w.a.a(this.uJI.uJA, paramInt1, paramInt2, paramString, 4));
      this.uJI.mN(false);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      au.Hx();
      c.Dz().o(77830, ((ab)paramm).NJ());
      paramString = new Intent(this.uJI.uJA, RegByMobileSetPwdUI.class);
      paramString.putExtra("kintent_hint", this.uJI.getString(R.l.settings_modify_password_tip));
      this.uJI.uJA.startActivity(paramString);
      return;
    }
    this.uJI.nTF = true;
    h.a(this.uJI.uJA, R.l.settings_password_error, R.l.app_tip, new j.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.j.11
 * JD-Core Version:    0.7.0.1
 */