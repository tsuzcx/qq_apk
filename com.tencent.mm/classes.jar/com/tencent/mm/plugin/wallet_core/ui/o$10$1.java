package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import java.util.ArrayList;
import java.util.List;

final class o$10$1
  implements j.b
{
  o$10$1(o.10 param10) {}
  
  public final void a(FavorPayInfo paramFavorPayInfo)
  {
    Object localObject2 = null;
    this.qGp.qGj.qmA = paramFavorPayInfo;
    label46:
    String str1;
    if (this.qGp.qGj.nqa == null)
    {
      i = 0;
      if (this.qGp.qGj.nqa != null) {
        break label306;
      }
      paramFavorPayInfo = "";
      aa.d(i, paramFavorPayInfo, 15, this.qGp.qGj.qmA.qvC);
      this.qGp.qGj.qFK = false;
      i = this.qGp.qGj.qmA.qvD;
      str1 = this.qGp.qGj.qmA.qvE;
      paramFavorPayInfo = com.tencent.mm.plugin.wallet_core.model.o.bVs().kt(true);
      if (i == 0) {
        break label323;
      }
    }
    label306:
    label323:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label329;
      }
      this.qGp.qGj.qmA.qvG = "";
      if (!a.a(this.qGp.qGj.qmA, this.qGp.qGj.qFM)) {
        break label473;
      }
      this.qGp.qGj.qFK = true;
      if (paramFavorPayInfo.size() != 0) {
        break label444;
      }
      this.qGp.qGj.qmA.qvG = this.qGp.val$context.getString(a.i.wallet_favor_need_bind_bankcard);
      label216:
      this.qGp.qGj.dismiss();
      if (this.qGp.qGj.qGe == null) {
        break label473;
      }
      this.qGp.qGj.qGe.a(this.qGp.qGj.qFy.getText(), this.qGp.qGj.qmA, this.qGp.qGj.qFK);
      return;
      i = this.qGp.qGj.nqa.bUV;
      break;
      paramFavorPayInfo = this.qGp.qGj.nqa.bMX;
      break label46;
    }
    label329:
    Object localObject1 = new ArrayList();
    int j = 0;
    label341:
    if (j < paramFavorPayInfo.size()) {
      if (bk.bl(str1))
      {
        if (((Bankcard)paramFavorPayInfo.get(j)).field_bankcardType.equals("CFT")) {
          break label835;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        ((List)localObject1).add((Bankcard)paramFavorPayInfo.get(j));
      }
      j += 1;
      break label341;
      if (((Bankcard)paramFavorPayInfo.get(j)).field_bankcardType.equals(str1))
      {
        i = 1;
        continue;
        paramFavorPayInfo = (FavorPayInfo)localObject1;
        break;
        label444:
        this.qGp.qGj.qmA.qvG = this.qGp.val$context.getString(a.i.wallet_favor_need_change_bankcard);
        break label216;
        label473:
        if (this.qGp.qGj.qFB != null) {
          this.qGp.qGj.qFB.setTag(this.qGp.qGj.qmA);
        }
        localObject1 = this.qGp.qGj.qnm.QF(this.qGp.qGj.qmA.qvC);
        double d = this.qGp.qGo.qwO.qkV;
        String str3;
        String str2;
        String str4;
        if ((localObject1 != null) && (((h)localObject1).qld > 0.0D))
        {
          d = ((h)localObject1).qkV;
          str3 = e.B(((h)localObject1).qlc);
          str2 = e.B(this.qGp.qGo.qwO.qkT);
          str1 = ((h)localObject1).qlf;
          paramFavorPayInfo = null;
          if ((localObject1 == null) || (((h)localObject1).qle == 0)) {
            break label829;
          }
          str4 = ((h)localObject1).qlg;
          localObject1 = str4;
          if (bk.bl(str1)) {}
        }
        label829:
        for (localObject1 = "," + str4;; localObject1 = null)
        {
          if ((!bk.bl(str1)) || (!bk.bl((String)localObject1))) {
            if (bk.bl(paramFavorPayInfo)) {
              paramFavorPayInfo = localObject2;
            }
          }
          for (;;)
          {
            this.qGp.qGj.d(str3, d);
            this.qGp.qGj.QP(str2);
            this.qGp.qGj.fl(str1, paramFavorPayInfo);
            paramFavorPayInfo = this.qGp.qGj;
            str1 = this.qGp.qGo.mOZ;
            paramFavorPayInfo.QQ((String)localObject1);
            return;
            d = this.qGp.qGo.qwO.qkT;
            str3 = e.B(this.qGp.qGo.qwO.qkT);
            paramFavorPayInfo = this.qGp.val$context.getString(a.i.wallet_pwd_dialog_more_favors);
            str1 = null;
            str2 = null;
            break;
            paramFavorPayInfo = "," + paramFavorPayInfo;
          }
        }
      }
      label835:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o.10.1
 * JD-Core Version:    0.7.0.1
 */