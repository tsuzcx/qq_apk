package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/layout/IndicatorLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "Companion", "plugin-story_release"})
public final class IndicatorLayoutManager
  extends LinearLayoutManager
{
  private static final String TAG = "MicroMsg.IndicatorLayoutManager";
  public static final a zGd;
  
  static
  {
    AppMethodBeat.i(119940);
    zGd = new a((byte)0);
    TAG = "MicroMsg.IndicatorLayoutManager";
    AppMethodBeat.o(119940);
  }
  
  public IndicatorLayoutManager(Context paramContext)
  {
    super(0);
    AppMethodBeat.i(119939);
    AppMethodBeat.o(119939);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(119937);
    paramInt = super.a(paramInt, paramo, paramt);
    ac.i(TAG, "scrollHorizontallyBy: " + getItemCount() + ' ' + getChildCount());
    AppMethodBeat.o(119937);
    return paramInt;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(119936);
    k.h(paramo, "recycler");
    k.h(paramt, "state");
    super.c(paramo, paramt);
    ac.i(TAG, "onLayoutChildren: " + getItemCount() + ' ' + getChildCount());
    AppMethodBeat.o(119936);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(119938);
    int i = jX();
    int j = jZ();
    if (paramInt - i < 2)
    {
      super.ca(paramInt - 2);
      AppMethodBeat.o(119938);
      return;
    }
    if (j - paramInt < 2) {
      super.ca(paramInt + 2);
    }
    AppMethodBeat.o(119938);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/layout/IndicatorLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.layout.IndicatorLayoutManager
 * JD-Core Version:    0.7.0.1
 */