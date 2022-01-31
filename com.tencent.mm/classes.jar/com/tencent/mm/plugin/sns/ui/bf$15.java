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
import java.util.LinkedList;

final class bf$15
  implements View.OnClickListener
{
  bf$15(bf parambf) {}
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof q)) {}
    do
    {
      return;
      localObject2 = (q)paramView.getTag();
      localObject1 = ((q)localObject2).oOz;
    } while (((bxk)localObject1).tNr.sPJ.size() <= 0);
    Object localObject2 = af.bDF().OB(((q)localObject2).bJQ);
    if (this.pkg.oOe != null) {
      this.pkg.oOe.bDk().y((n)localObject2);
    }
    Object localObject1 = ((awd)((bxk)localObject1).tNr.sPJ.get(0)).oOw;
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
    d.b(paramView.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.15
 * JD-Core Version:    0.7.0.1
 */