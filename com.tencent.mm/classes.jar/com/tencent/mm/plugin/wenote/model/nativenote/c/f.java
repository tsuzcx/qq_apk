package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class f
{
  public static c ey(View paramView)
  {
    AppMethodBeat.i(26929);
    if (paramView == null)
    {
      AppMethodBeat.o(26929);
      return null;
    }
    WXRTEditText localWXRTEditText1 = (WXRTEditText)paramView.findViewById(2131826607);
    WXRTEditText localWXRTEditText2 = (WXRTEditText)paramView.findViewById(2131826604);
    paramView = (WXRTEditText)paramView.findViewById(2131826606);
    if (localWXRTEditText1 != null) {
      paramView = new c(localWXRTEditText1);
    }
    for (;;)
    {
      AppMethodBeat.o(26929);
      return paramView;
      if ((localWXRTEditText2 != null) && (paramView != null)) {
        paramView = new c(localWXRTEditText2, paramView);
      } else {
        paramView = null;
      }
    }
  }
  
  public static View f(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(26928);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(26928);
      return null;
    }
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        paramRecyclerView = ((LinearLayoutManager)paramRecyclerView).bH(paramInt);
        AppMethodBeat.o(26928);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.f
 * JD-Core Version:    0.7.0.1
 */