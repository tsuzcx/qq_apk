package com.tencent.mm.plugin.repairer.ui.demo;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI$Adapter$ViewHolder;", "datas", "", "Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI$UserData;", "(Ljava/util/List;)V", "getDatas", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerAccessibilityDemoUI$a
  extends RecyclerView.a<RepairerAccessibilityDemoUI.a.a>
{
  private final List<RepairerAccessibilityDemoUI.b> lMl;
  
  public RepairerAccessibilityDemoUI$a(List<RepairerAccessibilityDemoUI.b> paramList)
  {
    AppMethodBeat.i(278179);
    this.lMl = paramList;
    AppMethodBeat.o(278179);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(278184);
    int i = this.lMl.size();
    AppMethodBeat.o(278184);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerAccessibilityDemoUI.a
 * JD-Core Version:    0.7.0.1
 */