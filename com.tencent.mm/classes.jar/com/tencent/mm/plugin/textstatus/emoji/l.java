package com.tencent.mm.plugin.textstatus.emoji;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder;", "typeName", "", "subTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "selectedPosition", "", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "(Ljava/lang/String;Ljava/util/ArrayList;ILcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;)V", "getListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "viewHolderList", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "reset", "setSelection", "context", "Landroid/content/Context;", "Companion", "plugin-textstatus_release"})
public final class l
  extends RecyclerView.a<g>
{
  public static final a MBm;
  private final ArrayList<g> AXn;
  private final ArrayList<f> Dwn;
  private final g.a MBc;
  int bFx;
  final String typeName;
  
  static
  {
    AppMethodBeat.i(233906);
    MBm = new a((byte)0);
    AppMethodBeat.o(233906);
  }
  
  public l(String paramString, ArrayList<f> paramArrayList, int paramInt, g.a parama)
  {
    AppMethodBeat.i(233904);
    this.typeName = paramString;
    this.Dwn = paramArrayList;
    this.bFx = paramInt;
    this.MBc = parama;
    this.AXn = new ArrayList(this.Dwn.size());
    AppMethodBeat.o(233904);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(233902);
    int i = this.Dwn.size();
    AppMethodBeat.o(233902);
    return i;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeAdapter$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.l
 * JD-Core Version:    0.7.0.1
 */