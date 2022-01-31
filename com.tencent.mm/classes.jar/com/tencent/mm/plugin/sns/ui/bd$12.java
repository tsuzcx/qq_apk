package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
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
import java.util.LinkedList;

final class bd$12
  implements View.OnClickListener
{
  bd$12(bd parambd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39875);
    if (!(paramView.getTag() instanceof q))
    {
      AppMethodBeat.o(39875);
      return;
    }
    Object localObject2 = (q)paramView.getTag();
    Object localObject1 = ((q)localObject2).rGk;
    if (((TimeLineObject)localObject1).xTS.wOa.size() > 0)
    {
      localObject2 = ag.cpf().abv(((q)localObject2).crk);
      if (this.scK.rFN != null) {
        this.scK.rFN.coJ().x((n)localObject2);
      }
      localObject1 = ((bcs)((TimeLineObject)localObject1).xTS.wOa.get(0)).rGh;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
      ((Intent)localObject2).putExtra("preceding_scence", 10);
      ((Intent)localObject2).putExtra("download_entrance_scene", 13);
      d.b(paramView.getContext(), "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject2);
    }
    AppMethodBeat.o(39875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.12
 * JD-Core Version:    0.7.0.1
 */