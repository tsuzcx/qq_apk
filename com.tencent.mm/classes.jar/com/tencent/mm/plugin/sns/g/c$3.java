package com.tencent.mm.plugin.sns.g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ab;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(c paramc, Context paramContext, SnsObject paramSnsObject, d.a parama, d.b paramb, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(36778);
    ab.i("MicroMsg.SnSABTestMgr", "onClick alert1");
    c.a(this.rlj, this.val$context, this.rfg, this.rlk, this.rlg, this.rlh, this.rli);
    AppMethodBeat.o(36778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.c.3
 * JD-Core Version:    0.7.0.1
 */