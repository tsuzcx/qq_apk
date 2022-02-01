package com.tencent.mm.plugin.wenote.ui.nativenote.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.aj;

public class NoteLinearLayoutManager
  extends LinearLayoutManager
{
  private final int BGr;
  public int old;
  public boolean ole;
  
  public NoteLinearLayoutManager()
  {
    AppMethodBeat.i(30837);
    this.BGr = i.il(aj.getContext());
    this.old = -1;
    this.ole = false;
    AppMethodBeat.o(30837);
  }
  
  public NoteLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(30838);
    this.BGr = i.il(aj.getContext());
    this.old = -1;
    this.ole = false;
    AppMethodBeat.o(30838);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    int j = 1;
    AppMethodBeat.i(30839);
    if (!this.ole)
    {
      paramInt = super.b(paramInt, paramo, params);
      AppMethodBeat.o(30839);
      return paramInt;
    }
    int i;
    if (paramInt < 0) {
      if (k.aQ(49.0F) <= Math.abs(paramInt)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        if (this.BGr + k.aQ(49.0F) < paramInt) {
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (this.ole))
        {
          AppMethodBeat.o(30839);
          return 0;
          i = 0;
          break;
          i = 0;
          continue;
        }
        try
        {
          paramInt = super.b(paramInt, paramo, params);
          AppMethodBeat.o(30839);
          return paramInt;
        }
        catch (Exception paramo)
        {
          AppMethodBeat.o(30839);
          return 0;
        }
      }
      i = 0;
    }
  }
  
  public final int c(RecyclerView.s params)
  {
    if (this.old > 0) {
      return this.old;
    }
    return 900;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(30840);
    try
    {
      super.c(paramo, params);
      AppMethodBeat.o(30840);
      return;
    }
    catch (Exception paramo)
    {
      AppMethodBeat.o(30840);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.adapter.NoteLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */