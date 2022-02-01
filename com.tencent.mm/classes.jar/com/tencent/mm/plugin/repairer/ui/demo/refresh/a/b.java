package com.tencent.mm.plugin.repairer.ui.demo.refresh.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/adapter/RecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/adapter/RecyclerAdapter$ItemHolder;", "datas", "", "", "context", "Landroid/content/Context;", "(Ljava/util/List;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDatas", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemHolder", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<a>
{
  private final Context context;
  private final List<String> lMl;
  
  public b(List<String> paramList, Context paramContext)
  {
    AppMethodBeat.i(278429);
    this.lMl = paramList;
    this.context = paramContext;
    AppMethodBeat.o(278429);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(278431);
    int i = this.lMl.size();
    AppMethodBeat.o(278431);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/adapter/RecyclerAdapter$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/adapter/RecyclerAdapter;Landroid/view/View;)V", "tvTest", "Landroid/widget/TextView;", "getTvTest", "()Landroid/widget/TextView;", "setTvTest", "(Landroid/widget/TextView;)V", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    TextView OxU;
    
    public a()
    {
      super();
      AppMethodBeat.i(278427);
      this$1 = localObject.findViewById(b.c.Ovj);
      s.s(b.this, "itemView.findViewById(R.id.tvTest)");
      this.OxU = ((TextView)b.this);
      AppMethodBeat.o(278427);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.a.b
 * JD-Core Version:    0.7.0.1
 */