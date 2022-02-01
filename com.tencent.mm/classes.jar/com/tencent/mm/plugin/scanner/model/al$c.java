package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.l;
import com.tencent.mm.plugin.scanner.view.d;
import com.tencent.threadpool.i;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/model/ScanProductShowBoxDialogHelper$showProductResultDialog$1", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onSuccessAnimationEnd", "", "singlePoint", "", "onSuccessAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al$c
  implements d
{
  public al$c(h paramh, com.tencent.mm.plugin.scanner.scan_goods_new.h paramh1, al paramal, al.b paramb) {}
  
  private static final void a(h paramh, com.tencent.mm.plugin.scanner.scan_goods_new.h paramh1, al paramal, al.b paramb)
  {
    AppMethodBeat.i(314292);
    kotlin.g.b.s.u(paramh, "$scanUIModel");
    kotlin.g.b.s.u(paramh1, "$info");
    kotlin.g.b.s.u(paramal, "this$0");
    if (paramh.gQS())
    {
      AppMethodBeat.o(314292);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("template_type", 1);
    localBundle.putString("req_key", paramh1.hAT);
    localBundle.putString("enter_session", am.gRn());
    localBundle.putString("tab_session", am.ahS(12));
    localBundle.putString("scan_session", am.ahU(12));
    localBundle.putString("detect_session", String.valueOf(paramh1.hBk));
    localBundle.putString("scanTabMerge", "1");
    if (paramh1.source == 3)
    {
      localBundle.putFloat("fixed_dialog_height_rate", 0.75F);
      paramh1 = new n((List)kotlin.a.p.al(new String[] { paramh1.hAT }), true);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramh1, 0);
    }
    paramh = paramh.getUIContext();
    kotlin.g.b.s.checkNotNull(paramh);
    paramh = l.a(paramh, localBundle, al.a(paramal));
    if (paramb != null) {
      paramb.l(paramh);
    }
    AppMethodBeat.o(314292);
  }
  
  public final void BY(boolean paramBoolean)
  {
    AppMethodBeat.i(314301);
    com.tencent.threadpool.h.ahAA.o(new al.c..ExternalSyntheticLambda0(this.OTd, this.OTe, this.OTf, this.OTg), 200L);
    AppMethodBeat.o(314301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.al.c
 * JD-Core Version:    0.7.0.1
 */