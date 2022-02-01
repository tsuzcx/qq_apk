package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class f
{
  public static View e(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(30622);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(30622);
      return null;
    }
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        paramRecyclerView = ((LinearLayoutManager)paramRecyclerView).bY(paramInt);
        AppMethodBeat.o(30622);
        return paramRecyclerView;
      }
    }
    catch (Exception paramRecyclerView)
    {
      for (;;)
      {
        paramRecyclerView = null;
      }
    }
  }
  
  public static c fn(View paramView)
  {
    AppMethodBeat.i(30623);
    if (paramView == null)
    {
      AppMethodBeat.o(30623);
      return null;
    }
    WXRTEditText localWXRTEditText1 = (WXRTEditText)paramView.findViewById(2131304265);
    WXRTEditText localWXRTEditText2 = (WXRTEditText)paramView.findViewById(2131297580);
    paramView = (WXRTEditText)paramView.findViewById(2131297578);
    if (localWXRTEditText1 != null) {
      paramView = new c(localWXRTEditText1);
    }
    for (;;)
    {
      AppMethodBeat.o(30623);
      return paramView;
      if ((localWXRTEditText2 != null) && (paramView != null)) {
        paramView = new c(localWXRTEditText2, paramView);
      } else {
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.f
 * JD-Core Version:    0.7.0.1
 */