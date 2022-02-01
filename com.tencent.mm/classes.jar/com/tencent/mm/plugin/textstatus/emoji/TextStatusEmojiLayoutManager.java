package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "hideRect", "Landroid/graphics/Rect;", "maxHeight", "scrollY", "tenDpHeight", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "updateChildren", "updateHideArea", "rect", "Companion", "plugin-textstatus_release"})
public final class TextStatusEmojiLayoutManager
  extends GridLayoutManager
{
  public static final a MBj;
  private int fVl;
  private final Rect jLp;
  
  static
  {
    AppMethodBeat.i(235908);
    MBj = new a((byte)0);
    AppMethodBeat.o(235908);
  }
  
  public TextStatusEmojiLayoutManager(Context paramContext)
  {
    super(7);
    AppMethodBeat.i(235907);
    this.jLp = new Rect();
    AppMethodBeat.o(235907);
  }
  
  public final void aji(int paramInt)
  {
    AppMethodBeat.i(235905);
    if (paramInt != -1) {
      this.fVl = paramInt;
    }
    if (this.jLp.isEmpty())
    {
      AppMethodBeat.o(235905);
      return;
    }
    AppMethodBeat.o(235905);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(235903);
    super.onLayoutChildren(paramn, params);
    aji(-1);
    AppMethodBeat.o(235903);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiLayoutManager
 * JD-Core Version:    0.7.0.1
 */