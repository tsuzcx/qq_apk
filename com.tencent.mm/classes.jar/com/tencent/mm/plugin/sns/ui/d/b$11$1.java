package com.tencent.mm.plugin.sns.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.np;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.au.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$11$1
  implements DialogInterface.OnClickListener
{
  b$11$1(b.11 param11, View paramView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!(this.hdG.getTag() instanceof String)) {
      return;
    }
    paramDialogInterface = (String)this.hdG.getTag();
    y.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + paramDialogInterface);
    n localn = af.bDF().OB(paramDialogInterface);
    if (localn == null)
    {
      y.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[] { paramDialogInterface });
      return;
    }
    label152:
    Object localObject2;
    if (localn.bGG())
    {
      y.i("MicroMsg.TimelineClickListener", "dead item");
      af.bDF().yu(localn.oLk);
      if (this.ppp.ppl.ppg != null) {
        this.ppp.ppl.ppg.bJw();
      }
      if (this.ppp.ppl.source == 0)
      {
        localObject1 = com.tencent.mm.modelsns.b.jd(739);
        localObject2 = ((com.tencent.mm.modelsns.b)localObject1).ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type);
        if (!localn.bGG()) {
          break label221;
        }
        paramDialogInterface = "2";
      }
      for (;;)
      {
        ((com.tencent.mm.modelsns.b)localObject2).ni(paramDialogInterface);
        ((com.tencent.mm.modelsns.b)localObject1).QX();
        if (localn.field_type != 21) {
          break;
        }
        com.tencent.mm.plugin.sns.lucky.a.g.bCu().bCw();
        return;
        localObject1 = com.tencent.mm.modelsns.b.je(739);
        break label152;
        label221:
        if (localn.field_snsId == 0L) {
          paramDialogInterface = "1";
        } else {
          paramDialogInterface = "0";
        }
      }
    }
    if (localn.bDo())
    {
      y.i("MicroMsg.TimelineClickListener", "cancel item " + localn.bGE());
      af.bDB().u(localn);
      this.ppp.ppl.bHo();
      return;
    }
    y.i("MicroMsg.TimelineClickListener", "delete by server");
    paramDialogInterface = localn.bGk();
    af.bDE().gd(v.OU(paramDialogInterface));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(new r(v.OU(paramDialogInterface), 1), 0);
    af.bDF().delete(v.OU(paramDialogInterface));
    af.bDK().go(v.OU(paramDialogInterface));
    com.tencent.mm.plugin.sns.storage.i.gn(v.OU(paramDialogInterface));
    this.ppp.ppl.bHo();
    Object localObject1 = localn.bGe();
    if (localObject1 != null)
    {
      if (((bxk)localObject1).tNq != null) {
        break label557;
      }
      paramDialogInterface = null;
      if ((!bk.bl(paramDialogInterface)) && (com.tencent.mm.plugin.sns.c.a.eUS.cu(paramDialogInterface)))
      {
        localObject2 = com.tencent.mm.plugin.sns.c.a.eUS.cs(paramDialogInterface);
        np localnp = new np();
        localnp.bXk.appId = paramDialogInterface;
        localnp.bXk.bXl = ((bxk)localObject1).hPY;
        localnp.bXk.bwQ = ((String)localObject2);
        localnp.bXk.mediaTagName = ((bxk)localObject1).tNv;
        com.tencent.mm.sdk.b.a.udP.m(localnp);
      }
    }
    if (this.ppp.ppl.source == 0)
    {
      localObject1 = com.tencent.mm.modelsns.b.jd(739);
      label514:
      localObject2 = ((com.tencent.mm.modelsns.b)localObject1).ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type);
      if (!localn.bGG()) {
        break label578;
      }
      paramDialogInterface = "2";
    }
    for (;;)
    {
      ((com.tencent.mm.modelsns.b)localObject2).ni(paramDialogInterface);
      ((com.tencent.mm.modelsns.b)localObject1).QX();
      return;
      label557:
      paramDialogInterface = ((bxk)localObject1).tNq.lsK;
      break;
      localObject1 = com.tencent.mm.modelsns.b.je(739);
      break label514;
      label578:
      if (localn.field_snsId == 0L) {
        paramDialogInterface = "1";
      } else {
        paramDialogInterface = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.11.1
 * JD-Core Version:    0.7.0.1
 */