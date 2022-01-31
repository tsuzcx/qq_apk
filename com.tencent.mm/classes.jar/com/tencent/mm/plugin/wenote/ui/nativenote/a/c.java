package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends RecyclerView.a<a>
{
  private final String TAG;
  private k vBM;
  private g vDl;
  
  public c(k paramk)
  {
    AppMethodBeat.i(27143);
    this.TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";
    this.vBM = paramk;
    this.vDl = new g();
    AppMethodBeat.o(27143);
  }
  
  private void a(a parama, int paramInt)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(27144);
        com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(paramInt);
        if ((localc != null) && (localc.getType() == parama.djX()))
        {
          parama.a(localc, paramInt, localc.getType());
          AppMethodBeat.o(27144);
          return;
        }
        if (localc == null)
        {
          ab.e("MicroMsg.Note.NoteRecyclerViewAdapter", "onBindViewHolder, item is null %b, position is %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
          AppMethodBeat.o(27144);
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
    AppMethodBeat.i(27146);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().size();
    AppMethodBeat.o(27146);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(27145);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(paramInt);
    if (localc != null)
    {
      paramInt = localc.getType();
      AppMethodBeat.o(27145);
      return paramInt;
    }
    ab.e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(27145);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */