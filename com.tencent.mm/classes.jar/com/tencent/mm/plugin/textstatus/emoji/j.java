package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.ap;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder;", "context", "Landroid/content/Context;", "emojiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/textstatus/proto/WxImeEmojiData;", "emojiSubType", "", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-textstatus_release"})
public final class j
  extends RecyclerView.a<e>
{
  public static final a MBh;
  private LinkedList<ap> Dwe;
  private String Dwf;
  private final a MBb;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(237138);
    MBh = new a((byte)0);
    AppMethodBeat.o(237138);
  }
  
  public j(Context paramContext, LinkedList<ap> paramLinkedList, String paramString, a parama)
  {
    AppMethodBeat.i(237137);
    this.context = paramContext;
    this.Dwe = paramLinkedList;
    this.Dwf = paramString;
    this.MBb = parama;
    AppMethodBeat.o(237137);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(237135);
    int i = this.Dwe.size();
    AppMethodBeat.o(237135);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridAdapter$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.j
 * JD-Core Version:    0.7.0.1
 */