package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.al.x;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class CheckSmsCanAddCardUI
  extends MMActivity
  implements f
{
  private String IUj;
  private b rr;
  
  private void fvf()
  {
    AppMethodBeat.i(32989);
    Toast.makeText(this, getString(2131764651), 1).show();
    LauncherUI.jF(this);
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
    if ((!ba.aBR()) || (ba.aiE()))
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
      if ((!bt.isNullOrNil(str)) && (str.equals("cardpackage"))) {
        break label224;
      }
      ad.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", new Object[] { str });
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label267;
      }
      ba.aiU().a(1038, this);
      paramBundle = new b.a();
      paramBundle.hNM = new xw();
      paramBundle.hNN = new xx();
      paramBundle.funcId = 1038;
      paramBundle.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
      this.rr = paramBundle.aDC();
      ((xw)this.rr.hNK.hNQ).FXz = this.IUj;
      ad.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[] { this.IUj });
      this.rr = x.d(this.rr);
      AppMethodBeat.o(32986);
      return;
      label224:
      this.IUj = paramBundle.getQueryParameter("encrystr");
      ad.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", new Object[] { this.IUj });
      if (bt.isNullOrNil(this.IUj)) {
        break;
      }
    }
    label267:
    fvf();
    AppMethodBeat.o(32986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32987);
    super.onDestroy();
    ba.aiU().b(1038, this);
    AppMethodBeat.o(32987);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(32988);
    ad.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramn = (xx)this.rr.hNL.hNQ;
      paramString = paramn.dHX;
      paramn = paramn.dHY;
      ad.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", new Object[] { paramString, paramn });
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
    fvf();
    AppMethodBeat.o(32988);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.CheckSmsCanAddCardUI
 * JD-Core Version:    0.7.0.1
 */