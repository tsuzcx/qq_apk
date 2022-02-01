package com.tencent.mm.plugin.wenote.ui.nativenote.adapter;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends RecyclerView.a<a>
{
  private k BFc;
  private h BGs;
  public boolean BGt;
  private final String TAG;
  
  public b(k paramk)
  {
    AppMethodBeat.i(30841);
    this.TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";
    this.BGt = false;
    this.BFc = paramk;
    this.BGs = new h();
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
        com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(paramInt);
        if ((localc != null) && (localc.getType() == parama.bSa()))
        {
          parama.a(localc, paramInt, localc.getType());
          AppMethodBeat.o(30842);
          return;
        }
        if (localc == null)
        {
          ad.e("MicroMsg.Note.NoteRecyclerViewAdapter", "onBindViewHolder, item is null %b, position is %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
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
    if (this.BGt)
    {
      i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().size();
      AppMethodBeat.o(30844);
      return i + 1;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().size();
    AppMethodBeat.o(30844);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(30843);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(paramInt);
    if (localc != null)
    {
      paramInt = localc.getType();
      AppMethodBeat.o(30843);
      return paramInt;
    }
    if ((this.BGt) && (paramInt == com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().size()))
    {
      AppMethodBeat.o(30843);
      return 30;
    }
    ad.e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(30843);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b
 * JD-Core Version:    0.7.0.1
 */