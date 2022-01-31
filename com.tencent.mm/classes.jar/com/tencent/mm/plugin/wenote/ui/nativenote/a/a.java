package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends LinearLayoutManager
{
  private final int rMD = j.u(ae.getContext(), true);
  public int rME = -1;
  public boolean rMF = false;
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    int k = 1;
    int j = 0;
    int i;
    if (!this.rMF)
    {
      i = super.b(paramInt, paramo, params);
      return i;
    }
    if (paramInt < 0) {
      if (k.az(49.0F) <= Math.abs(paramInt)) {
        i = 1;
      }
    }
    for (;;)
    {
      label46:
      if (paramInt > 0) {
        if (this.rMD + k.az(49.0F) < paramInt) {
          i = k;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          i = j;
          if (this.rMF) {
            break;
          }
        }
        try
        {
          paramInt = super.b(paramInt, paramo, params);
          return paramInt;
        }
        catch (Exception paramo)
        {
          return 0;
        }
        i = 0;
        break label46;
        i = 0;
      }
      i = 0;
    }
  }
  
  protected final int c(RecyclerView.s params)
  {
    if (this.rME > 0) {
      return this.rME;
    }
    return 900;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    try
    {
      super.c(paramo, params);
      return;
    }
    catch (Exception paramo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.a
 * JD-Core Version:    0.7.0.1
 */