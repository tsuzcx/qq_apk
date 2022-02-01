package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.ui.widget.PagInputView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PagEditTextPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getLayout", "()Landroid/view/ViewGroup;", "pagInputView", "Lcom/tencent/mm/plugin/vlog/ui/widget/PagInputView;", "kotlin.jvm.PlatformType", "editPag", "", "text", "", "onBackPress", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  private final ViewGroup GrB;
  final PagInputView Ujo;
  
  public w(ViewGroup paramViewGroup, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282480);
    this.GrB = paramViewGroup;
    this.Ujo = ((PagInputView)this.GrB.findViewById(a.f.editor_pag_input));
    this.Ujo.setTextChangeCallback((b)new u(parama) {});
    AppMethodBeat.o(282480);
  }
  
  public final void bfr(String paramString)
  {
    AppMethodBeat.i(282489);
    s.u(paramString, "text");
    this.Ujo.setup(paramString);
    this.Ujo.setShow(true);
    AppMethodBeat.o(282489);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282500);
    if (this.Ujo.getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.Ujo.setShow(false);
      a.b.a(this.GrC, a.c.NOD);
      AppMethodBeat.o(282500);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(282500);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.w
 * JD-Core Version:    0.7.0.1
 */