package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.b;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.b.j;
import com.tencent.mm.protocal.protobuf.fak;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.ah;
import kotlinx.coroutines.b.h;

@Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class TeenModeGuardianInfoUI$b$a
  implements h<com.tencent.mm.am.a.a<fak>>
{
  public TeenModeGuardianInfoUI$b$a(w paramw, TeenModeGuardianInfoUI paramTeenModeGuardianInfoUI) {}
  
  public final Object a(com.tencent.mm.am.a.a<fak> parama, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(279202);
    parama = (com.tencent.mm.am.a.a)parama;
    if (parama.ovD == b.ovB)
    {
      this.Tbg.dismiss();
      if (parama.errCode != 0) {
        break label214;
      }
      aa.db((Context)this.Tbf.getContext(), this.Tbf.getString(a.g.SYa));
      j localj = j.hEy();
      parama = (fak)parama.ott;
      if (parama != null) {
        break label198;
      }
      parama = null;
      localj.hFb = parama;
      j.hEy().qfP = 2;
      paramd = new Intent((Context)this.Tbf.getContext(), TeenModePrivatePwdUI.class);
      paramd.putExtra("intent_process", 4);
      paramd.addFlags(67108864);
      parama = this.Tbf;
      paramd = new com.tencent.mm.hellhoundlib.b.a().cG(paramd);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramd.aYi(), "com/tencent/mm/plugin/teenmode/ui/TeenModeGuardianInfoUI$doScene$1$invokeSuspend$$inlined$collect$1", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramd.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/plugin/teenmode/ui/TeenModeGuardianInfoUI$doScene$1$invokeSuspend$$inlined$collect$1", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(279202);
      return parama;
      label198:
      paramd = parama.Njp;
      parama = paramd;
      if (paramd != null) {
        break;
      }
      parama = null;
      break;
      label214:
      TeenModeGuardianInfoUI.a(this.Tbf, parama.errMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModeGuardianInfoUI.b.a
 * JD-Core Version:    0.7.0.1
 */