package com.tencent.mm.plugin.wenote.ui.nativenote.adapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class NoteLinearLayoutManager
  extends LinearLayoutManager
{
  private final int XDB;
  public int xwJ;
  public boolean xwK;
  
  public NoteLinearLayoutManager()
  {
    AppMethodBeat.i(30837);
    this.XDB = j.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.xwJ = -1;
    this.xwK = false;
    AppMethodBeat.o(30837);
  }
  
  public NoteLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(30838);
    this.XDB = j.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.xwJ = -1;
    this.xwK = false;
    AppMethodBeat.o(30838);
  }
  
  public final int b(RecyclerView.s params)
  {
    if (this.xwJ > 0) {
      return this.xwJ;
    }
    return 900;
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(275225);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(275225);
      return;
    }
    catch (Exception paramn)
    {
      AppMethodBeat.o(275225);
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int j = 1;
    AppMethodBeat.i(275221);
    if (!this.xwK)
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(275221);
      return paramInt;
    }
    int i;
    if (paramInt < 0) {
      if (k.cg(49.0F) <= Math.abs(paramInt)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        if (this.XDB + k.cg(49.0F) < paramInt) {
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (this.xwK))
        {
          AppMethodBeat.o(275221);
          return 0;
          i = 0;
          break;
          i = 0;
          continue;
        }
        try
        {
          paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
          AppMethodBeat.o(275221);
          return paramInt;
        }
        catch (Exception paramn)
        {
          AppMethodBeat.o(275221);
          return 0;
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.adapter.NoteLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */