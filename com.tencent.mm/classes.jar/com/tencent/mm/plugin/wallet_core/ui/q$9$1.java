package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import java.util.List;

final class q$9$1
  implements l.b
{
  q$9$1(q.9 param9) {}
  
  public final void a(FavorPayInfo paramFavorPayInfo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(47601);
    this.utv.utp.tVQ = paramFavorPayInfo;
    int i;
    if (this.utv.utp.pVo == null)
    {
      i = 0;
      if (this.utv.utp.pVo != null) {
        break label294;
      }
      paramFavorPayInfo = "";
      label51:
      ad.e(i, paramFavorPayInfo, 15, this.utv.utp.tVQ.uhU);
      this.utv.utp.usQ = false;
      paramFavorPayInfo = b.bt(this.utv.utp.tVQ.uhV, this.utv.utp.tVQ.uhW);
      this.utv.utp.tVQ.uhY = "";
      if (!b.a(this.utv.utp.tVQ, this.utv.utp.usS)) {
        break label339;
      }
      this.utv.utp.usQ = true;
      if (paramFavorPayInfo.size() != 0) {
        break label311;
      }
    }
    label294:
    label311:
    for (this.utv.utp.tVQ.uhY = this.utv.val$context.getString(2131305066);; this.utv.utp.tVQ.uhY = this.utv.val$context.getString(2131305067))
    {
      this.utv.utp.dismiss();
      if (this.utv.utp.utj == null) {
        break label339;
      }
      this.utv.utp.utj.a(this.utv.utp.usE.getText(), this.utv.utp.tVQ, this.utv.utp.usQ);
      AppMethodBeat.o(47601);
      return;
      i = this.utv.utp.pVo.cCD;
      break;
      paramFavorPayInfo = this.utv.utp.pVo.cnI;
      break label51;
    }
    label339:
    if (this.utv.utp.usH != null) {
      this.utv.utp.usH.setTag(this.utv.utp.tVQ);
    }
    Object localObject1 = this.utv.utp.tWD.afD(this.utv.utp.tVQ.uhU);
    double d;
    String str1;
    String str3;
    String str2;
    String str4;
    if ((localObject1 != null) && (((j)localObject1).tUm > 0.0D))
    {
      d = ((j)localObject1).tUe;
      str1 = e.F(((j)localObject1).tUl);
      str3 = e.F(this.utv.utu.ujm.tUc);
      str2 = ((j)localObject1).tUo;
      paramFavorPayInfo = null;
      if ((localObject1 == null) || (((j)localObject1).tUn == 0)) {
        break label657;
      }
      str4 = ((j)localObject1).tUp;
      localObject1 = str4;
      if (bo.isNullOrNil(str2)) {}
    }
    label657:
    for (localObject1 = ",".concat(String.valueOf(str4));; localObject1 = null)
    {
      if ((!bo.isNullOrNil(str2)) || (!bo.isNullOrNil((String)localObject1))) {
        if (bo.isNullOrNil(paramFavorPayInfo)) {
          paramFavorPayInfo = localObject2;
        }
      }
      for (;;)
      {
        this.utv.utp.f(str1, d);
        this.utv.utp.afN(str3);
        this.utv.utp.hc(str2, paramFavorPayInfo);
        this.utv.utp.afO((String)localObject1);
        AppMethodBeat.o(47601);
        return;
        d = this.utv.utu.ujm.tUc;
        str1 = e.F(this.utv.utu.ujm.tUc);
        paramFavorPayInfo = this.utv.val$context.getString(2131305527);
        str2 = null;
        str3 = null;
        break;
        paramFavorPayInfo = ",".concat(String.valueOf(paramFavorPayInfo));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.9.1
 * JD-Core Version:    0.7.0.1
 */