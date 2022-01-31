package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
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

final class bf$5
  implements View.OnClickListener
{
  bf$5(bf parambf) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
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
    ((Intent)localObject).putExtra("key_product_scene", 2);
    ((Intent)localObject).putExtra("key_product_info", paramView);
    d.b(this.pkg.context, "product", ".ui.MallProductUI", (Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.5
 * JD-Core Version:    0.7.0.1
 */