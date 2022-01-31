package com.tencent.mm.plugin.sns.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.op;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.av.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$11$1
  implements DialogInterface.OnClickListener
{
  b$11$1(b.11 param11, View paramView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(40257);
    if (!(this.bTJ.getTag() instanceof String))
    {
      AppMethodBeat.o(40257);
      return;
    }
    paramDialogInterface = (String)this.bTJ.getTag();
    ab.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramDialogInterface)));
    n localn = ag.cpf().abv(paramDialogInterface);
    if (localn == null)
    {
      ab.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[] { paramDialogInterface });
      AppMethodBeat.o(40257);
      return;
    }
    Object localObject2;
    if (localn.csJ())
    {
      ab.i("MicroMsg.TimelineClickListener", "dead item");
      ag.cpf().EA(localn.rCV);
      if (this.skh.skd.sjY != null) {
        this.skh.skd.sjY.cvZ();
      }
      if (this.skh.skd.cpt == 0)
      {
        localObject1 = com.tencent.mm.modelsns.b.lV(739);
        localObject2 = ((com.tencent.mm.modelsns.b)localObject1).uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type);
        if (!localn.csJ()) {
          break label234;
        }
        paramDialogInterface = "2";
      }
      for (;;)
      {
        ((com.tencent.mm.modelsns.b)localObject2).uv(paramDialogInterface);
        ((com.tencent.mm.modelsns.b)localObject1).ake();
        if (localn.field_type == 21) {
          com.tencent.mm.plugin.sns.lucky.a.g.cnW().cnY();
        }
        AppMethodBeat.o(40257);
        return;
        localObject1 = com.tencent.mm.modelsns.b.lW(739);
        break;
        label234:
        if (localn.field_snsId == 0L) {
          paramDialogInterface = "1";
        } else {
          paramDialogInterface = "0";
        }
      }
    }
    if (localn.coN())
    {
      ab.i("MicroMsg.TimelineClickListener", "cancel item " + localn.csH());
      ag.cpb().u(localn);
      this.skh.skd.cts();
      AppMethodBeat.o(40257);
      return;
    }
    ab.i("MicroMsg.TimelineClickListener", "delete by server");
    paramDialogInterface = localn.getSnsId();
    ag.cpe().lI(v.abO(paramDialogInterface));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(new r(v.abO(paramDialogInterface), 1), 0);
    ag.cpf().delete(v.abO(paramDialogInterface));
    ag.cpk().lU(v.abO(paramDialogInterface));
    com.tencent.mm.plugin.sns.storage.i.lT(v.abO(paramDialogInterface));
    this.skh.skd.cts();
    Object localObject1 = localn.csh();
    if (localObject1 != null)
    {
      if (((TimeLineObject)localObject1).xTR != null) {
        break label580;
      }
      paramDialogInterface = null;
      if ((!bo.isNullOrNil(paramDialogInterface)) && (com.tencent.mm.plugin.sns.c.a.gmP.dG(paramDialogInterface)))
      {
        localObject2 = com.tencent.mm.plugin.sns.c.a.gmP.dE(paramDialogInterface);
        op localop = new op();
        localop.cFg.appId = paramDialogInterface;
        localop.cFg.cFh = ((TimeLineObject)localObject1).jJA;
        localop.cFg.bYA = ((String)localObject2);
        localop.cFg.mediaTagName = ((TimeLineObject)localObject1).xTW;
        com.tencent.mm.sdk.b.a.ymk.l(localop);
      }
    }
    if (this.skh.skd.cpt == 0)
    {
      localObject1 = com.tencent.mm.modelsns.b.lV(739);
      label532:
      localObject2 = ((com.tencent.mm.modelsns.b)localObject1).uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type);
      if (!localn.csJ()) {
        break label601;
      }
      paramDialogInterface = "2";
    }
    for (;;)
    {
      ((com.tencent.mm.modelsns.b)localObject2).uv(paramDialogInterface);
      ((com.tencent.mm.modelsns.b)localObject1).ake();
      AppMethodBeat.o(40257);
      return;
      label580:
      paramDialogInterface = ((TimeLineObject)localObject1).xTR.Id;
      break;
      localObject1 = com.tencent.mm.modelsns.b.lW(739);
      break label532;
      label601:
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