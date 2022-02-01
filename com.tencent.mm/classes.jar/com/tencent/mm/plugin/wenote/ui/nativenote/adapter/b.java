package com.tencent.mm.plugin.wenote.ui.nativenote.adapter;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends RecyclerView.a<a>
{
  private final String TAG;
  private k XCl;
  private h XDC;
  public boolean XDD;
  
  public b(k paramk)
  {
    AppMethodBeat.i(30841);
    this.TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";
    this.XDD = false;
    this.XCl = paramk;
    this.XDC = new h();
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
        com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(paramInt);
        if ((localc != null) && (localc.getType() == parama.dvW()))
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
    if (this.XDD)
    {
      i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().size();
      AppMethodBeat.o(30844);
      return i + 1;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().size();
    AppMethodBeat.o(30844);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(30843);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(paramInt);
    if (localc != null)
    {
      paramInt = localc.getType();
      AppMethodBeat.o(30843);
      return paramInt;
    }
    if ((this.XDD) && (paramInt == com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().size()))
    {
      AppMethodBeat.o(30843);
      return 30;
    }
    Log.e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(30843);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b
 * JD-Core Version:    0.7.0.1
 */