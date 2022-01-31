package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.g;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends RecyclerView.a<a>
{
  private final String TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";
  private k rLi;
  private g rMH;
  
  public c(k paramk)
  {
    this.rLi = paramk;
    this.rMH = new g();
  }
  
  private void a(a parama, int paramInt)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(paramInt);
        if ((localc != null) && (localc.getType() == parama.cjv()))
        {
          parama.a(localc, paramInt, localc.getType());
          return;
        }
        if (localc == null) {
          y.e("MicroMsg.Note.NoteRecyclerViewAdapter", "onBindViewHolder, item is null %b, position is %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        } else {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public final int getItemCount()
  {
    return com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(paramInt);
    if (localc != null) {
      return localc.getType();
    }
    y.e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", new Object[] { Integer.valueOf(paramInt) });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */