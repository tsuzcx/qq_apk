package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  extends LinearLayoutManager
{
  private final int vDh;
  public int vDi;
  public boolean vDj;
  
  public a()
  {
    AppMethodBeat.i(27140);
    this.vDh = j.gJ(ah.getContext());
    this.vDi = -1;
    this.vDj = false;
    AppMethodBeat.o(27140);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    int j = 1;
    AppMethodBeat.i(27141);
    if (!this.vDj)
    {
      paramInt = super.b(paramInt, paramo, params);
      AppMethodBeat.o(27141);
      return paramInt;
    }
    int i;
    if (paramInt < 0) {
      if (k.bo(49.0F) <= Math.abs(paramInt)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        if (this.vDh + k.bo(49.0F) < paramInt) {
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (this.vDj))
        {
          AppMethodBeat.o(27141);
          return 0;
          i = 0;
          break;
          i = 0;
          continue;
        }
        try
        {
          paramInt = super.b(paramInt, paramo, params);
          AppMethodBeat.o(27141);
          return paramInt;
        }
        catch (Exception paramo)
        {
          AppMethodBeat.o(27141);
          return 0;
        }
      }
      i = 0;
    }
  }
  
  public final int c(RecyclerView.s params)
  {
    if (this.vDi > 0) {
      return this.vDi;
    }
    return 900;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(27142);
    try
    {
      super.c(paramo, params);
      AppMethodBeat.o(27142);
      return;
    }
    catch (Exception paramo)
    {
      AppMethodBeat.o(27142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.a
 * JD-Core Version:    0.7.0.1
 */