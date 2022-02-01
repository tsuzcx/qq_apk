package com.tencent.mm.plugin.wenote.ui.nativenote.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class NoteLinearLayoutManager
  extends LinearLayoutManager
{
  private final int JKJ;
  public int qOi;
  public boolean qOj;
  
  public NoteLinearLayoutManager()
  {
    AppMethodBeat.i(30837);
    this.JKJ = i.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.qOi = -1;
    this.qOj = false;
    AppMethodBeat.o(30837);
  }
  
  public NoteLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(30838);
    this.JKJ = i.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.qOi = -1;
    this.qOj = false;
    AppMethodBeat.o(30838);
  }
  
  public final int b(RecyclerView.s params)
  {
    if (this.qOi > 0) {
      return this.qOi;
    }
    return 900;
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(30840);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(30840);
      return;
    }
    catch (Exception paramn)
    {
      AppMethodBeat.o(30840);
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int j = 1;
    AppMethodBeat.i(30839);
    if (!this.qOj)
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(30839);
      return paramInt;
    }
    int i;
    if (paramInt < 0) {
      if (k.be(49.0F) <= Math.abs(paramInt)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        if (this.JKJ + k.be(49.0F) < paramInt) {
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (this.qOj))
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
          paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
          AppMethodBeat.o(30839);
          return paramInt;
        }
        catch (Exception paramn)
        {
          AppMethodBeat.o(30839);
          return 0;
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.adapter.NoteLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */