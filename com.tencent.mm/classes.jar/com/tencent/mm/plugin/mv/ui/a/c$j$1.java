package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$3$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-mv_release"})
public final class c$j$1
  implements CommentDrawerContract.CloseDrawerCallback
{
  public final void g(int paramInt, List<? extends s> paramList)
  {
    AppMethodBeat.i(258891);
    p.h(paramList, "data");
    this.UqY.Asf.ArY.commentCount = paramInt;
    c.b(this.UqY.Asc, this.UqY.qhp, this.UqY.Asf);
    AppMethodBeat.o(258891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c.j.1
 * JD-Core Version:    0.7.0.1
 */