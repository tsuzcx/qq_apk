package com.tencent.mm.plugin.textstatus.emoji;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder;", "typeName", "", "subTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "selectedPosition", "", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "(Ljava/lang/String;Ljava/util/ArrayList;ILcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;)V", "getListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "viewHolderList", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "reset", "setSelection", "context", "Landroid/content/Context;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends RecyclerView.a<g>
{
  public static final l.a TkS;
  private final ArrayList<g> GyR;
  private final ArrayList<f> Jpu;
  private final g.a TkI;
  int dyx;
  final String typeName;
  
  static
  {
    AppMethodBeat.i(290736);
    TkS = new l.a((byte)0);
    AppMethodBeat.o(290736);
  }
  
  public l(String paramString, ArrayList<f> paramArrayList, int paramInt, g.a parama)
  {
    AppMethodBeat.i(290728);
    this.typeName = paramString;
    this.Jpu = paramArrayList;
    this.dyx = paramInt;
    this.TkI = parama;
    this.GyR = new ArrayList(this.Jpu.size());
    AppMethodBeat.o(290728);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(290742);
    int i = this.Jpu.size();
    AppMethodBeat.o(290742);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.l
 * JD-Core Version:    0.7.0.1
 */