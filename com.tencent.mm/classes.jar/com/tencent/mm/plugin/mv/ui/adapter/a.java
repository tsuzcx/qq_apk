package com.tencent.mm.plugin.mv.ui.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder;", "itemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "(Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemClickListener", "()Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "list", "", "MusicLyricViewHolder", "OnItemClickListener", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<a>
{
  final b MaF;
  private final String TAG;
  private final ArrayList<String> pUj;
  
  public a(b paramb)
  {
    AppMethodBeat.i(287246);
    this.MaF = paramb;
    this.TAG = "MicroMsg.MusicLyricAdapter";
    this.pUj = new ArrayList();
    AppMethodBeat.o(287246);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(287259);
    int i = this.pUj.size();
    AppMethodBeat.o(287259);
    return i;
  }
  
  public final void hM(List<String> paramList)
  {
    AppMethodBeat.i(287253);
    s.u(paramList, "list");
    this.pUj.clear();
    this.pUj.addAll((Collection)paramList);
    this.bZE.notifyChanged();
    AppMethodBeat.o(287253);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter;Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTextView", "()Landroid/widget/TextView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    final TextView dyR;
    
    public a()
    {
      super();
      AppMethodBeat.i(287287);
      this.dyR = ((TextView)localObject.findViewById(b.e.LSW));
      localObject.setOnClickListener(new a.a..ExternalSyntheticLambda0(a.this, this));
      AppMethodBeat.o(287287);
    }
    
    private static final void a(a parama, a parama1, View paramView)
    {
      AppMethodBeat.i(287295);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parama);
      localb.cH(parama1);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(parama1, "this$1");
      parama = parama.MaF;
      parama1.KJ();
      parama.dRJ();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287295);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "", "onClick", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void dRJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.a
 * JD-Core Version:    0.7.0.1
 */