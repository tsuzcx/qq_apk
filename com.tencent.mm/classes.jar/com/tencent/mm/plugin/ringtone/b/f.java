package com.tencent.mm.plugin.ringtone.b;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.b.d;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/RingtoneConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "()V", "TAG", "", "applyRingtonePlay", "", "itemView", "Landroid/view/View;", "play", "", "ringback", "getLayoutId", "", "initFromCache", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "initRingtoneInfo", "loadDefaultResource", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.view.recyclerview.f<e>
{
  private final String TAG = "MicroMsg.RingtoneConverter";
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(273031);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(273031);
  }
  
  public final int getLayoutId()
  {
    return b.d.ringtone_item_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.b.f
 * JD-Core Version:    0.7.0.1
 */