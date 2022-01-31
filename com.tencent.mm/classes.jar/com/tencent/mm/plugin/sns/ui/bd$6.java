package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.i.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class bd$6
  implements View.OnClickListener
{
  bd$6(bd parambd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39867);
    ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
    if (!(paramView.getTag() instanceof q))
    {
      AppMethodBeat.o(39867);
      return;
    }
    Object localObject = (q)paramView.getTag();
    paramView = ((q)localObject).rGk;
    if (paramView.xTS.wOa.size() > 0)
    {
      localObject = ag.cpf().abv(((q)localObject).crk);
      if (this.scK.rFN != null) {
        this.scK.rFN.coJ().x((n)localObject);
      }
      paramView = ((bcs)paramView.xTS.wOa.get(0)).rGh;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_from_scene", 12);
      if (!TextUtils.isEmpty(paramView))
      {
        String[] arrayOfString = paramView.split("#");
        if (arrayOfString.length >= 2)
        {
          ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + arrayOfString[0]);
          ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
          ((Intent)localObject).putExtra("key_card_ext", arrayOfString[1]);
          d.b(this.scK.context, "card", ".ui.CardDetailUI", (Intent)localObject);
          AppMethodBeat.o(39867);
          return;
        }
        if (arrayOfString.length == 1)
        {
          ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
          ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(paramView)));
          ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
          ((Intent)localObject).putExtra("key_card_ext", "");
          d.b(this.scK.context, "card", ".ui.CardDetailUI", (Intent)localObject);
          AppMethodBeat.o(39867);
          return;
        }
        ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
        ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(paramView)));
        AppMethodBeat.o(39867);
        return;
      }
      ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
    }
    AppMethodBeat.o(39867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.6
 * JD-Core Version:    0.7.0.1
 */