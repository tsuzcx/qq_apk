package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "hideRect", "Landroid/graphics/Rect;", "maxHeight", "scrollY", "tenDpHeight", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "updateChildren", "updateHideArea", "rect", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEmojiLayoutManager
  extends GridLayoutManager
{
  public static final TextStatusEmojiLayoutManager.a TkP;
  private int ibi;
  private final Rect mkA;
  
  static
  {
    AppMethodBeat.i(290826);
    TkP = new TextStatusEmojiLayoutManager.a((byte)0);
    AppMethodBeat.o(290826);
  }
  
  public TextStatusEmojiLayoutManager(Context paramContext)
  {
    super(7);
    AppMethodBeat.i(290815);
    this.mkA = new Rect();
    AppMethodBeat.o(290815);
  }
  
  public final void aoq(int paramInt)
  {
    AppMethodBeat.i(290842);
    if (paramInt != -1) {
      this.ibi = paramInt;
    }
    if (this.mkA.isEmpty())
    {
      AppMethodBeat.o(290842);
      return;
    }
    AppMethodBeat.o(290842);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(290832);
    super.onLayoutChildren(paramn, params);
    aoq(-1);
    AppMethodBeat.o(290832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiLayoutManager
 * JD-Core Version:    0.7.0.1
 */