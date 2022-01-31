package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class f
{
  public static c ds(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    WXRTEditText localWXRTEditText1 = (WXRTEditText)paramView.findViewById(R.h.rte_text);
    WXRTEditText localWXRTEditText2 = (WXRTEditText)paramView.findViewById(R.h.btnPrev);
    paramView = (WXRTEditText)paramView.findViewById(R.h.btnNext);
    if (localWXRTEditText1 != null) {
      paramView = new c(localWXRTEditText1);
    }
    for (;;)
    {
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
    if (paramRecyclerView == null) {
      return null;
    }
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        paramRecyclerView = ((LinearLayoutManager)paramRecyclerView).bC(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.f
 * JD-Core Version:    0.7.0.1
 */