package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
import java.util.LinkedList;
import java.util.UUID;

final class f$9
  implements View.OnClickListener
{
  f$9(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126440);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new foe();
    paramView.scene = this.TPf.getListVideoUIComponent().hNz().scene;
    paramView.zIO = UUID.randomUUID().toString();
    paramView.abOh = this.TPf.getListVideoUIComponent().hNz().mpa;
    paramView.abOi = this.TPf.getListVideoUIComponent().hNz().abOi;
    paramView.abOf = f.o(this.TPf).abOM.Ido;
    paramView.abOg = this.TPf.getListVideoUIComponent().hNz().abOg;
    paramView.abOk = f.p(this.TPf).abOM;
    paramView.hAB = "topstory";
    paramView.mpa = this.TPf.getListVideoUIComponent().hNz().mpa;
    paramView.abOj = f.q(this.TPf).abOw;
    paramView.abOk.abOE = f.r(this.TPf).abOE;
    paramView.Wol.addAll(f.s(this.TPf).abOM.Wol);
    aj.a(this.TPf.getListVideoUIComponent().fWt(), paramView);
    a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(126440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.9
 * JD-Core Version:    0.7.0.1
 */