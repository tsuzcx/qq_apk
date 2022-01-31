package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.op;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsCommentDetailUI$28$1
  implements DialogInterface.OnClickListener
{
  SnsCommentDetailUI$28$1(SnsCommentDetailUI.28 param28) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(38810);
    ab.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.k(this.rPE.rPu));
    paramDialogInterface = h.abv(SnsCommentDetailUI.k(this.rPE.rPu));
    if (paramDialogInterface == null)
    {
      ab.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[] { SnsCommentDetailUI.k(this.rPE.rPu) });
      AppMethodBeat.o(38810);
      return;
    }
    if (paramDialogInterface.Ex(32))
    {
      AppMethodBeat.o(38810);
      return;
    }
    Object localObject;
    if (paramDialogInterface.field_snsId == 0L)
    {
      ag.cpf().EA(paramDialogInterface.rCV);
      localObject = new Intent();
      ((Intent)localObject).putExtra("sns_gallery_op_id", v.abP(SnsCommentDetailUI.k(this.rPE.rPu)));
      this.rPE.rPu.setResult(-1, (Intent)localObject);
      if ((SnsCommentDetailUI.s(this.rPE.rPu)) && (!paramDialogInterface.isValid())) {
        ((Intent)localObject).putExtra("sns_gallery_force_finish", true);
      }
      localObject = paramDialogInterface.csh();
      if (localObject != null) {
        if (((TimeLineObject)localObject).xTR != null) {
          break label368;
        }
      }
    }
    label368:
    for (paramDialogInterface = null;; paramDialogInterface = ((TimeLineObject)localObject).xTR.Id)
    {
      if ((!bo.isNullOrNil(paramDialogInterface)) && (com.tencent.mm.plugin.sns.c.a.gmP.dG(paramDialogInterface)))
      {
        String str = com.tencent.mm.plugin.sns.c.a.gmP.dE(paramDialogInterface);
        op localop = new op();
        localop.cFg.appId = paramDialogInterface;
        localop.cFg.cFh = ((TimeLineObject)localObject).jJA;
        localop.cFg.bYA = str;
        com.tencent.mm.sdk.b.a.ymk.l(localop);
      }
      this.rPE.rPu.finish();
      AppMethodBeat.o(38810);
      return;
      ag.cpe().lI(paramDialogInterface.field_snsId);
      g.RM();
      g.RK().eHt.a(new r(paramDialogInterface.field_snsId, 1), 0);
      ag.cpf().delete(paramDialogInterface.field_snsId);
      ag.cpk().lU(paramDialogInterface.field_snsId);
      i.lT(paramDialogInterface.field_snsId);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.28.1
 * JD-Core Version:    0.7.0.1
 */