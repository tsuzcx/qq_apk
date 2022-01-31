package com.tencent.mm.plugin.story.ui.b;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/layout/IndicatorLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "Companion", "plugin-story_release"})
public final class c
  extends LinearLayoutManager
{
  private static final String TAG = "MicroMsg.IndicatorLayoutManager";
  public static final c.a sKg;
  
  static
  {
    AppMethodBeat.i(110234);
    sKg = new c.a((byte)0);
    TAG = "MicroMsg.IndicatorLayoutManager";
    AppMethodBeat.o(110234);
  }
  
  public c(Context paramContext)
  {
    super(0);
    AppMethodBeat.i(110233);
    AppMethodBeat.o(110233);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(110231);
    paramInt = super.a(paramInt, paramo, params);
    ab.i(TAG, "scrollHorizontallyBy: " + getItemCount() + ' ' + getChildCount());
    AppMethodBeat.o(110231);
    return paramInt;
  }
  
  public final void bJ(int paramInt)
  {
    AppMethodBeat.i(110232);
    int i = iu();
    int j = iw();
    if (paramInt - i < 2)
    {
      super.bJ(paramInt - 2);
      AppMethodBeat.o(110232);
      return;
    }
    if (j - paramInt < 2) {
      super.bJ(paramInt + 2);
    }
    AppMethodBeat.o(110232);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(110230);
    j.q(paramo, "recycler");
    j.q(params, "state");
    super.c(paramo, params);
    ab.i(TAG, "onLayoutChildren: " + getItemCount() + ' ' + getChildCount());
    AppMethodBeat.o(110230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.b.c
 * JD-Core Version:    0.7.0.1
 */