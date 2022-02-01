package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class CheckSmsCanAddCardUI
  extends MMActivity
  implements g
{
  private String HgT;
  private b rr;
  
  private void feX()
  {
    AppMethodBeat.i(32989);
    Toast.makeText(this, getString(2131764651), 1).show();
    LauncherUI.jv(this);
    finish();
    AppMethodBeat.o(32989);
  }
  
  protected int getLayoutId()
  {
    return 2131494530;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32986);
    super.onCreate(paramBundle);
    hideTitleView();
    if ((!az.ayN()) || (az.afS()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(32986);
      return;
    }
    paramBundle = getIntent().getData();
    if (paramBundle != null)
    {
      String str = paramBundle.getHost();
      if ((!bs.isNullOrNil(str)) && (str.equals("cardpackage"))) {
        break label224;
      }
      ac.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", new Object[] { str });
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label267;
      }
      az.agi().a(1038, this);
      paramBundle = new b.a();
      paramBundle.hvt = new vx();
      paramBundle.hvu = new vy();
      paramBundle.funcId = 1038;
      paramBundle.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
      this.rr = paramBundle.aAz();
      ((vx)this.rr.hvr.hvw).Eqo = this.HgT;
      ac.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[] { this.HgT });
      this.rr = x.d(this.rr);
      AppMethodBeat.o(32986);
      return;
      label224:
      this.HgT = paramBundle.getQueryParameter("encrystr");
      ac.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", new Object[] { this.HgT });
      if (bs.isNullOrNil(this.HgT)) {
        break;
      }
    }
    label267:
    feX();
    AppMethodBeat.o(32986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32987);
    super.onDestroy();
    az.agi().b(1038, this);
    AppMethodBeat.o(32987);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(32988);
    ac.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramn = (vy)this.rr.hvs.hvw;
      paramString = paramn.dvO;
      paramn = paramn.dvP;
      ac.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", new Object[] { paramString, paramn });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_card_id", paramString);
      localIntent.putExtra("key_card_ext", paramn);
      localIntent.putExtra("key_from_scene", 8);
      localIntent.putExtra("key_is_sms_add_card", true);
      d.c(this, "card", ".ui.CardDetailUI", localIntent);
      finish();
      AppMethodBeat.o(32988);
      return;
    }
    feX();
    AppMethodBeat.o(32988);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.CheckSmsCanAddCardUI
 * JD-Core Version:    0.7.0.1
 */