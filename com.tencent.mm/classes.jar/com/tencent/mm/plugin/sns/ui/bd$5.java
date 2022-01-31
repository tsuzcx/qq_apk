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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class bd$5
  implements View.OnClickListener
{
  bd$5(bd parambd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39866);
    ab.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
    if (!(paramView.getTag() instanceof q))
    {
      AppMethodBeat.o(39866);
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
      ((Intent)localObject).putExtra("key_product_scene", 2);
      ((Intent)localObject).putExtra("key_product_info", paramView);
      d.b(this.scK.context, "product", ".ui.MallProductUI", (Intent)localObject);
    }
    AppMethodBeat.o(39866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.5
 * JD-Core Version:    0.7.0.1
 */