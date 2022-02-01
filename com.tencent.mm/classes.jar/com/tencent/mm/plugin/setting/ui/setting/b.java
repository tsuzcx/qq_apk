package com.tencent.mm.plugin.setting.ui.setting;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.g;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder;", "compositionList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/config/MessageRingtone;", "iRingtoneChooseCallback", "Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder$IRingtoneChooseCallback;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder$IRingtoneChooseCallback;)V", "getIRingtoneChooseCallback", "()Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder$IRingtoneChooseCallback;", "getItemCount", "", "onBindViewHolder", "", "viewHolderLongClick", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<c>
{
  private final ArrayList<g> Jql;
  private final c.a Ppy;
  
  public b(ArrayList<g> paramArrayList, c.a parama)
  {
    AppMethodBeat.i(298725);
    this.Jql = paramArrayList;
    this.Ppy = parama;
    AppMethodBeat.o(298725);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(298729);
    int i = this.Jql.size();
    AppMethodBeat.o(298729);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.b
 * JD-Core Version:    0.7.0.1
 */