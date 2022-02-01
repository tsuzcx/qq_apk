package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.am.b.b;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.b.j;
import com.tencent.mm.protocal.protobuf.fak;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tenpay.android.wechat.TempSecureEditText;
import kotlin.Metadata;
import kotlin.ah;
import kotlinx.coroutines.b.h;

@Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class TeenModePrivatePwdUI$b$a
  implements h<a<fak>>
{
  public TeenModePrivatePwdUI$b$a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI) {}
  
  public final Object a(a<fak> parama, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(279147);
    parama = (a)parama;
    if (parama.ovD == b.ovB)
    {
      paramd = TeenModePrivatePwdUI.i(this.Tbm);
      if (paramd != null) {
        paramd.dismiss();
      }
      if (parama.errCode != 0) {
        break label98;
      }
      j.hEy().hFb = null;
      j.hEy().qfP = 1;
      this.Tbm.finish();
      aa.db((Context)this.Tbm.getContext(), this.Tbm.getString(a.g.SXW));
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(279147);
      return parama;
      label98:
      TeenModePrivatePwdUI.b(this.Tbm, parama.errMsg);
      TeenModePrivatePwdUI.k(this.Tbm).setText((CharSequence)"");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModePrivatePwdUI.b.a
 * JD-Core Version:    0.7.0.1
 */