package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class bf$6
  implements View.OnClickListener
{
  bf$6(bf parambf) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
    if (!(paramView.getTag() instanceof q)) {}
    do
    {
      return;
      localObject = (q)paramView.getTag();
      paramView = ((q)localObject).oOz;
    } while (paramView.tNr.sPJ.size() <= 0);
    Object localObject = af.bDF().OB(((q)localObject).bJQ);
    if (this.pkg.oOe != null) {
      this.pkg.oOe.bDk().y((n)localObject);
    }
    paramView = ((awd)paramView.tNr.sPJ.get(0)).oOw;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_from_scene", 12);
    if (!TextUtils.isEmpty(paramView))
    {
      String[] arrayOfString = paramView.split("#");
      if (arrayOfString.length >= 2)
      {
        y.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + arrayOfString[0]);
        ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
        ((Intent)localObject).putExtra("key_card_ext", arrayOfString[1]);
        d.b(this.pkg.context, "card", ".ui.CardDetailUI", (Intent)localObject);
        return;
      }
      if (arrayOfString.length == 1)
      {
        y.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
        y.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :" + paramView);
        ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
        ((Intent)localObject).putExtra("key_card_ext", "");
        d.b(this.pkg.context, "card", ".ui.CardDetailUI", (Intent)localObject);
        return;
      }
      y.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
      y.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :" + paramView);
      return;
    }
    y.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.6
 * JD-Core Version:    0.7.0.1
 */