package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class CheckSmsCanAddCardUI
  extends MMActivity
  implements i
{
  private String OyL;
  private d rr;
  
  private void gGU()
  {
    AppMethodBeat.i(32989);
    Toast.makeText(this, getString(2131767022), 1).show();
    LauncherUI.jI(this);
    finish();
    AppMethodBeat.o(32989);
  }
  
  protected int getLayoutId()
  {
    return 2131495126;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32986);
    super.onCreate(paramBundle);
    hideTitleView();
    if ((!bg.aVG()) || (bg.azj()))
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
      if ((!Util.isNullOrNil(str)) && (str.equals("cardpackage"))) {
        break label224;
      }
      Log.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", new Object[] { str });
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label267;
      }
      bg.azz().a(1038, this);
      paramBundle = new d.a();
      paramBundle.iLN = new zn();
      paramBundle.iLO = new zo();
      paramBundle.funcId = 1038;
      paramBundle.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
      this.rr = paramBundle.aXF();
      ((zn)this.rr.iLK.iLR).LkQ = this.OyL;
      Log.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[] { this.OyL });
      this.rr = aa.d(this.rr);
      AppMethodBeat.o(32986);
      return;
      label224:
      this.OyL = paramBundle.getQueryParameter("encrystr");
      Log.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", new Object[] { this.OyL });
      if (Util.isNullOrNil(this.OyL)) {
        break;
      }
    }
    label267:
    gGU();
    AppMethodBeat.o(32986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32987);
    super.onDestroy();
    bg.azz().b(1038, this);
    AppMethodBeat.o(32987);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(32988);
    Log.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramq = (zo)this.rr.iLL.iLR;
      paramString = paramq.eaO;
      paramq = paramq.eaP;
      Log.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", new Object[] { paramString, paramq });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_card_id", paramString);
      localIntent.putExtra("key_card_ext", paramq);
      localIntent.putExtra("key_from_scene", 8);
      localIntent.putExtra("key_is_sms_add_card", true);
      c.c(this, "card", ".ui.CardDetailUI", localIntent);
      finish();
      AppMethodBeat.o(32988);
      return;
    }
    gGU();
    AppMethodBeat.o(32988);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.CheckSmsCanAddCardUI
 * JD-Core Version:    0.7.0.1
 */