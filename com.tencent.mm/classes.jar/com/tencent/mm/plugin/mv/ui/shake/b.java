package com.tencent.mm.plugin.mv.ui.shake;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.mv.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter$MusicLyricViewHolder;", "itemClickListener", "Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter$OnItemClickListener;", "type", "", "(Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter$OnItemClickListener;I)V", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "highLightPosition", "getItemClickListener", "()Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter$OnItemClickListener;", "getType", "()I", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHighLightPosition", "update", "list", "", "MusicLyricViewHolder", "OnItemClickListener", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<a>
{
  final b.b McN;
  int McO;
  private final ArrayList<String> pUj;
  final int type;
  
  public b(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(287358);
    this.McN = paramb;
    this.type = paramInt;
    this.pUj = new ArrayList();
    this.McO = -1;
    AppMethodBeat.o(287358);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(287386);
    int i = this.pUj.size();
    AppMethodBeat.o(287386);
    return i;
  }
  
  public final void hM(List<String> paramList)
  {
    AppMethodBeat.i(287372);
    s.u(paramList, "list");
    this.pUj.clear();
    this.pUj.addAll((Collection)paramList);
    this.bZE.notifyChanged();
    AppMethodBeat.o(287372);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter$MusicLyricViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter;Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTextView", "()Landroid/widget/TextView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    final TextView dyR;
    
    public a()
    {
      super();
      AppMethodBeat.i(287427);
      this.dyR = ((TextView)localObject.findViewById(b.e.LSW));
      localObject.setOnClickListener(new b.a..ExternalSyntheticLambda0(b.this, this));
      AppMethodBeat.o(287427);
    }
    
    private static final void a(b paramb, a parama, View paramView)
    {
      AppMethodBeat.i(287432);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(parama);
      localb.cH(paramView);
      a.c("com/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter$MusicLyricViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramb, "this$0");
      s.u(parama, "this$1");
      parama.KJ();
      a.a(new Object(), "com/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter$MusicLyricViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.b
 * JD-Core Version:    0.7.0.1
 */