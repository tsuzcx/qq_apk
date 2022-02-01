package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class f
{
  public static View c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(264584);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(264584);
      return null;
    }
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        paramRecyclerView = ((LinearLayoutManager)paramRecyclerView).findViewByPosition(paramInt);
        AppMethodBeat.o(264584);
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
  
  public static c hq(View paramView)
  {
    AppMethodBeat.i(30623);
    if (paramView == null)
    {
      AppMethodBeat.o(30623);
      return null;
    }
    WXRTEditText localWXRTEditText1 = (WXRTEditText)paramView.findViewById(R.h.dTc);
    WXRTEditText localWXRTEditText2 = (WXRTEditText)paramView.findViewById(R.h.duF);
    paramView = (WXRTEditText)paramView.findViewById(R.h.duD);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.f
 * JD-Core Version:    0.7.0.1
 */