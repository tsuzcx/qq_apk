package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/layout/IndicatorLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "Companion", "plugin-story_release"})
public final class IndicatorLayoutManager
  extends LinearLayoutManager
{
  public static final a FzO;
  private static final String TAG = "MicroMsg.IndicatorLayoutManager";
  
  static
  {
    AppMethodBeat.i(119940);
    FzO = new a((byte)0);
    TAG = "MicroMsg.IndicatorLayoutManager";
    AppMethodBeat.o(119940);
  }
  
  public IndicatorLayoutManager(Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(119939);
    AppMethodBeat.o(119939);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(119936);
    p.h(paramn, "recycler");
    p.h(params, "state");
    super.onLayoutChildren(paramn, params);
    Log.i(TAG, "onLayoutChildren: " + getItemCount() + ' ' + getChildCount());
    AppMethodBeat.o(119936);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(119937);
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    Log.i(TAG, "scrollHorizontallyBy: " + getItemCount() + ' ' + getChildCount());
    AppMethodBeat.o(119937);
    return paramInt;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(119938);
    int i = kt();
    int j = kv();
    if (paramInt - i < 2)
    {
      super.scrollToPosition(paramInt - 2);
      AppMethodBeat.o(119938);
      return;
    }
    if (j - paramInt < 2) {
      super.scrollToPosition(paramInt + 2);
    }
    AppMethodBeat.o(119938);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/layout/IndicatorLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.layout.IndicatorLayoutManager
 * JD-Core Version:    0.7.0.1
 */