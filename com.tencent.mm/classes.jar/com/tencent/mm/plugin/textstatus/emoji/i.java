package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentViewHolder;", "context", "Landroid/content/Context;", "emojiSubTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-textstatus_release"})
public final class i
  extends RecyclerView.a<d>
{
  public static final a MBd;
  private ArrayList<f> DvU;
  private final a MBb;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(237155);
    MBd = new a((byte)0);
    AppMethodBeat.o(237155);
  }
  
  public i(Context paramContext, ArrayList<f> paramArrayList, a parama)
  {
    AppMethodBeat.i(237154);
    this.context = paramContext;
    this.DvU = paramArrayList;
    this.MBb = parama;
    AppMethodBeat.o(237154);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(237153);
    int i = this.DvU.size();
    AppMethodBeat.o(237153);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentAdapter$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.i
 * JD-Core Version:    0.7.0.1
 */