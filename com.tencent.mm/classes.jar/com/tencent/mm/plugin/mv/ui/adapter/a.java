package com.tencent.mm.plugin.mv.ui.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder;", "itemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "(Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemClickListener", "()Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "list", "", "MusicLyricViewHolder", "OnItemClickListener", "plugin-mv_release"})
public final class a
  extends RecyclerView.a<a>
{
  final b Gfl;
  private final String TAG;
  private final ArrayList<String> mXB;
  
  public a(b paramb)
  {
    AppMethodBeat.i(238205);
    this.Gfl = paramb;
    this.TAG = "MicroMsg.MusicLyricAdapter";
    this.mXB = new ArrayList();
    AppMethodBeat.o(238205);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(238202);
    int i = this.mXB.size();
    AppMethodBeat.o(238202);
    return i;
  }
  
  public final void gg(List<String> paramList)
  {
    AppMethodBeat.i(238193);
    p.k(paramList, "list");
    this.mXB.clear();
    this.mXB.addAll((Collection)paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(238193);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter;Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTextView", "()Landroid/widget/TextView;", "plugin-mv_release"})
  public final class a
    extends RecyclerView.v
  {
    final TextView bFR;
    
    public a()
    {
      super();
      AppMethodBeat.i(226685);
      this.bFR = ((TextView)localObject.findViewById(b.e.FXw));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(225172);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = this.Gfn.Gfm.Gfl;
          this.Gfn.md();
          paramAnonymousView.dkT();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(225172);
        }
      });
      AppMethodBeat.o(226685);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "", "onClick", "", "position", "", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void dkT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.a
 * JD-Core Version:    0.7.0.1
 */