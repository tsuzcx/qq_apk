package com.tencent.mm.plugin.wenote.ui.nativenote.adapter;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends RecyclerView.a<a>
{
  private k JJu;
  private h JKK;
  public boolean JKL;
  private final String TAG;
  
  public b(k paramk)
  {
    AppMethodBeat.i(30841);
    this.TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";
    this.JKL = false;
    this.JJu = paramk;
    this.JKK = new h();
    AppMethodBeat.o(30841);
  }
  
  private void a(a parama, int paramInt)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30842);
        com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(paramInt);
        if ((localc != null) && (localc.getType() == parama.cCY()))
        {
          parama.a(localc, paramInt, localc.getType());
          AppMethodBeat.o(30842);
          return;
        }
        if (localc == null)
        {
          Log.e("MicroMsg.Note.NoteRecyclerViewAdapter", "onBindViewHolder, item is null %b, position is %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
          AppMethodBeat.o(30842);
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(30844);
    if (this.JKL)
    {
      i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size();
      AppMethodBeat.o(30844);
      return i + 1;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size();
    AppMethodBeat.o(30844);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(30843);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(paramInt);
    if (localc != null)
    {
      paramInt = localc.getType();
      AppMethodBeat.o(30843);
      return paramInt;
    }
    if ((this.JKL) && (paramInt == com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size()))
    {
      AppMethodBeat.o(30843);
      return 30;
    }
    Log.e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(30843);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b
 * JD-Core Version:    0.7.0.1
 */