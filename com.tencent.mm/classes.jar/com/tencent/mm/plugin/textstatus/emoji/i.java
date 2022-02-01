package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentViewHolder;", "context", "Landroid/content/Context;", "emojiSubTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends RecyclerView.a<d>
{
  public static final i.a TkJ;
  private ArrayList<f> Jpa;
  private final a TkH;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(290753);
    TkJ = new i.a((byte)0);
    AppMethodBeat.o(290753);
  }
  
  public i(Context paramContext, ArrayList<f> paramArrayList, a parama)
  {
    AppMethodBeat.i(290745);
    this.context = paramContext;
    this.Jpa = paramArrayList;
    this.TkH = parama;
    AppMethodBeat.o(290745);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(290760);
    int i = this.Jpa.size();
    AppMethodBeat.o(290760);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.i
 * JD-Core Version:    0.7.0.1
 */