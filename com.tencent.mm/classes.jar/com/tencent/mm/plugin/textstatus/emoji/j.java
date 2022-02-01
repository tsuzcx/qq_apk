package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.bm;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder;", "context", "Landroid/content/Context;", "emojiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/textstatus/proto/WxImeEmojiData;", "emojiSubType", "", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends RecyclerView.a<e>
{
  public static final j.a TkN;
  private LinkedList<bm> Jpl;
  private String Jpm;
  private final a TkH;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(290791);
    TkN = new j.a((byte)0);
    AppMethodBeat.o(290791);
  }
  
  public j(Context paramContext, LinkedList<bm> paramLinkedList, String paramString, a parama)
  {
    AppMethodBeat.i(290774);
    this.context = paramContext;
    this.Jpl = paramLinkedList;
    this.Jpm = paramString;
    this.TkH = parama;
    AppMethodBeat.o(290774);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(290802);
    int i = this.Jpl.size();
    AppMethodBeat.o(290802);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.j
 * JD-Core Version:    0.7.0.1
 */