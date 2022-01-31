package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.b.v;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
{
  Context context;
  public BaseAdapter jXl;
  public a pZZ;
  private c qaa;
  
  public i(Context paramContext, BaseAdapter paramBaseAdapter, a parama)
  {
    AppMethodBeat.i(153625);
    this.qaa = new i.1(this);
    this.context = paramContext;
    this.jXl = paramBaseAdapter;
    this.pZZ = parama;
    com.tencent.mm.sdk.b.a.ymk.c(this.qaa);
    AppMethodBeat.o(153625);
  }
  
  public final u Co(int paramInt)
  {
    AppMethodBeat.i(153626);
    Object localObject = this.pZZ.pZb.fjy.iterator();
    while (((Iterator)localObject).hasNext())
    {
      u localu = (u)((Iterator)localObject).next();
      if (paramInt == localu.id)
      {
        AppMethodBeat.o(153626);
        return localu;
      }
    }
    localObject = new u();
    ((u)localObject).id = paramInt;
    ((u)localObject).status = 0;
    this.pZZ.pZb.fjy.add(localObject);
    AppMethodBeat.o(153626);
    return localObject;
  }
  
  public final byte[] cgg()
  {
    AppMethodBeat.i(153627);
    com.tencent.mm.sdk.b.a.ymk.d(this.qaa);
    Object localObject = new v();
    if ((this.pZZ != null) && (this.pZZ.pZb != null) && (this.pZZ.pZb.fjy != null))
    {
      Iterator localIterator = this.pZZ.pZb.fjy.iterator();
      while (localIterator.hasNext())
      {
        u localu = (u)localIterator.next();
        if (!bo.isNullOrNil(localu.pYY)) {
          ((v)localObject).fjy.add(localu);
        }
      }
    }
    this.jXl = null;
    this.pZZ = null;
    this.context = null;
    try
    {
      localObject = ((v)localObject).toByteArray();
      AppMethodBeat.o(153627);
      return localObject;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(153627);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.i
 * JD-Core Version:    0.7.0.1
 */