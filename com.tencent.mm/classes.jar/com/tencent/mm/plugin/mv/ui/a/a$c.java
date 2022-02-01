package com.tencent.mm.plugin.mv.ui.a;

import android.view.View;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.a.d;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$Companion;", "", "()V", "handleSelection", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "plugin-mv_release"})
public final class a$c
{
  public static void a(h paramh, d paramd)
  {
    AppMethodBeat.i(258208);
    p.h(paramh, "holder");
    p.h(paramd, "item");
    View localView = paramh.aus;
    p.g(localView, "holder.itemView");
    localView.setSelected(paramd.uOQ);
    localView = paramh.Mn(2131305132);
    if (paramd.uOQ)
    {
      if (paramd.type != 0)
      {
        paramd = paramh.aus.findViewById(2131305145);
        p.g(paramd, "holder.itemView.findView…Id<View>(R.id.mvItemMask)");
        paramd.setVisibility(8);
        p.g(localView, "actionRoot");
        localView.setVisibility(0);
      }
      for (;;)
      {
        paramh = paramh.Mn(2131305144);
        p.g(paramh, "holder.getView<View>(R.id.mvItemLyricRoot)");
        paramh.setVisibility(0);
        AppMethodBeat.o(258208);
        return;
        paramd = paramh.aus.findViewById(2131305145);
        p.g(paramd, "holder.itemView.findView…Id<View>(R.id.mvItemMask)");
        paramd.setVisibility(0);
        p.g(localView, "actionRoot");
        localView.setVisibility(8);
      }
    }
    ((ProgressBar)paramh.aus.findViewById(2131305785)).setProgress(0);
    paramd = paramh.aus.findViewById(2131305145);
    p.g(paramd, "holder.itemView.findView…Id<View>(R.id.mvItemMask)");
    paramd.setVisibility(0);
    p.g(localView, "actionRoot");
    localView.setVisibility(8);
    paramh = paramh.Mn(2131305144);
    p.g(paramh, "holder.getView<View>(R.id.mvItemLyricRoot)");
    paramh.setVisibility(8);
    AppMethodBeat.o(258208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.a.c
 * JD-Core Version:    0.7.0.1
 */