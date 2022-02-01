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
public final class TeenModePrivatePwdUI$c$a
  implements h<com.tencent.mm.am.a.a<fak>>
{
  public TeenModePrivatePwdUI$c$a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI) {}
  
  public final Object a(com.tencent.mm.am.a.a<fak> parama, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(279314);
    parama = (com.tencent.mm.am.a.a)parama;
    if (parama.ovD == b.ovB)
    {
      paramd = TeenModePrivatePwdUI.i(this.Tbm);
      if (paramd != null) {
        paramd.dismiss();
      }
      if (parama.errCode != 0) {
        break label220;
      }
      j localj = j.hEy();
      parama = (fak)parama.ott;
      if (parama != null) {
        break label212;
      }
      parama = null;
      paramd = parama;
      if (parama == null) {
        paramd = j.hEy().hFb;
      }
      localj.hFb = paramd;
      j.hEy().qfP = 2;
      paramd = new Intent((Context)this.Tbm.getContext(), SettingsTeenModeMain.class);
      paramd.addFlags(67108864);
      parama = this.Tbm;
      paramd = new com.tencent.mm.hellhoundlib.b.a().cG(paramd);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramd.aYi(), "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI$doModify$1$invokeSuspend$$inlined$collect$1", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramd.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI$doModify$1$invokeSuspend$$inlined$collect$1", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      aa.db((Context)this.Tbm.getContext(), this.Tbm.getString(a.g.app_modify_success));
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(279314);
      return parama;
      label212:
      parama = parama.Njp;
      break;
      label220:
      paramd = new Intent();
      paramd.putExtra("result_err", parama.errMsg);
      this.Tbm.setResult(0, paramd);
      this.Tbm.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModePrivatePwdUI.c.a
 * JD-Core Version:    0.7.0.1
 */