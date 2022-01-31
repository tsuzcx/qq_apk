package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.w;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.su;
import com.tencent.mm.protocal.protobuf.sv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class CheckSmsCanAddCardUI
  extends MMActivity
  implements f
{
  private b rr;
  private String yUV;
  
  private void dAV()
  {
    AppMethodBeat.i(29164);
    Toast.makeText(this, getString(2131304494), 1).show();
    LauncherUI.hG(this);
    finish();
    AppMethodBeat.o(29164);
  }
  
  protected int getLayoutId()
  {
    return 2130969950;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29161);
    super.onCreate(paramBundle);
    hideTitleView();
    if ((!aw.aaB()) || (aw.QP()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(29161);
      return;
    }
    paramBundle = getIntent().getData();
    if (paramBundle != null)
    {
      String str = paramBundle.getHost();
      if ((!bo.isNullOrNil(str)) && (str.equals("cardpackage"))) {
        break label227;
      }
      ab.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", new Object[] { str });
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label270;
      }
      aw.Rc().a(1038, this);
      paramBundle = new b.a();
      paramBundle.fsX = new su();
      paramBundle.fsY = new sv();
      paramBundle.funcId = 1038;
      paramBundle.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
      this.rr = paramBundle.ado();
      ((su)this.rr.fsV.fta).wLn = this.yUV;
      ab.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[] { this.yUV });
      this.rr = w.b(this.rr);
      AppMethodBeat.o(29161);
      return;
      label227:
      this.yUV = paramBundle.getQueryParameter("encrystr");
      ab.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", new Object[] { this.yUV });
      if (bo.isNullOrNil(this.yUV)) {
        break;
      }
    }
    label270:
    dAV();
    AppMethodBeat.o(29161);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29162);
    super.onDestroy();
    aw.Rc().b(1038, this);
    AppMethodBeat.o(29162);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(29163);
    ab.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (sv)this.rr.fsW.fta;
      paramString = paramm.cHn;
      paramm = paramm.cHo;
      ab.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", new Object[] { paramString, paramm });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_card_id", paramString);
      localIntent.putExtra("key_card_ext", paramm);
      localIntent.putExtra("key_from_scene", 8);
      localIntent.putExtra("key_is_sms_add_card", true);
      d.c(this, "card", ".ui.CardDetailUI", localIntent);
      finish();
      AppMethodBeat.o(29163);
      return;
    }
    dAV();
    AppMethodBeat.o(29163);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.CheckSmsCanAddCardUI
 * JD-Core Version:    0.7.0.1
 */