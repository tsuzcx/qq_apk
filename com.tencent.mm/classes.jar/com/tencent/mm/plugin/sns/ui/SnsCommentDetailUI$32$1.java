package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class SnsCommentDetailUI$32$1
  implements DialogInterface.OnClickListener
{
  SnsCommentDetailUI$32$1(SnsCommentDetailUI.32 param32) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(219867);
    ae.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.k(this.Atm.AsY));
    paramDialogInterface = h.aBr(SnsCommentDetailUI.k(this.Atm.AsY));
    if (paramDialogInterface == null)
    {
      ae.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[] { SnsCommentDetailUI.k(this.Atm.AsY) });
      AppMethodBeat.o(219867);
      return;
    }
    if (paramDialogInterface.Rt(32))
    {
      AppMethodBeat.o(219867);
      return;
    }
    Object localObject;
    if (paramDialogInterface.field_snsId == 0L)
    {
      ah.dXE().Rx(paramDialogInterface.AdJ);
      localObject = new Intent();
      ((Intent)localObject).putExtra("sns_gallery_op_id", x.aBN(SnsCommentDetailUI.k(this.Atm.AsY)));
      this.Atm.AsY.setResult(-1, (Intent)localObject);
      if ((SnsCommentDetailUI.w(this.Atm.AsY)) && (!paramDialogInterface.isValid())) {
        ((Intent)localObject).putExtra("sns_gallery_force_finish", true);
      }
      localObject = paramDialogInterface.ebP();
      if (localObject != null) {
        if (((TimeLineObject)localObject).HUF != null) {
          break label368;
        }
      }
    }
    label368:
    for (paramDialogInterface = null;; paramDialogInterface = ((TimeLineObject)localObject).HUF.Id)
    {
      if ((!bu.isNullOrNil(paramDialogInterface)) && (com.tencent.mm.plugin.sns.c.a.iUA.fE(paramDialogInterface)))
      {
        String str = com.tencent.mm.plugin.sns.c.a.iUA.fC(paramDialogInterface);
        rc localrc = new rc();
        localrc.dGH.appId = paramDialogInterface;
        localrc.dGH.dGJ = ((TimeLineObject)localObject).nIJ;
        localrc.dGH.dGI = str;
        com.tencent.mm.sdk.b.a.IvT.l(localrc);
      }
      this.Atm.AsY.finish();
      AppMethodBeat.o(219867);
      return;
      ah.dXD().Al(paramDialogInterface.field_snsId);
      g.ajS();
      g.ajQ().gDv.a(new r(paramDialogInterface.field_snsId, 1), 0);
      ah.dXE().delete(paramDialogInterface.field_snsId);
      ah.dXJ().AB(paramDialogInterface.field_snsId);
      i.AA(paramDialogInterface.field_snsId);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.32.1
 * JD-Core Version:    0.7.0.1
 */