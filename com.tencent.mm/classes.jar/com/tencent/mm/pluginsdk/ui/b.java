package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements j.a, j.b
{
  private final j.a ERR;
  private final HashMap<String, j.a> gdc;
  
  public b(j.a parama)
  {
    AppMethodBeat.i(195430);
    this.gdc = new HashMap();
    this.ERR = parama;
    AppMethodBeat.o(195430);
  }
  
  private j.a aMt(String paramString)
  {
    AppMethodBeat.i(195438);
    if (paramString == null)
    {
      paramString = this.ERR;
      AppMethodBeat.o(195438);
      return paramString;
    }
    synchronized (this.gdc)
    {
      Iterator localIterator = this.gdc.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramString.endsWith((String)localEntry.getKey()))
        {
          paramString = (j.a)localEntry.getValue();
          AppMethodBeat.o(195438);
          return paramString;
        }
      }
      paramString = this.ERR;
      AppMethodBeat.o(195438);
      return paramString;
    }
  }
  
  public final Bitmap LL()
  {
    AppMethodBeat.i(195436);
    Bitmap localBitmap = this.ERR.LL();
    AppMethodBeat.o(195436);
    return localBitmap;
  }
  
  public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195433);
    paramString = aMt(paramString).a(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(195433);
    return paramString;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(195437);
    aMt(paramj.getTag()).a(paramj);
    this.ERR.a(paramj);
    AppMethodBeat.o(195437);
  }
  
  public final boolean a(String paramString, j.a parama)
  {
    AppMethodBeat.i(195431);
    synchronized (this.gdc)
    {
      if (this.gdc.put(paramString, parama) == null)
      {
        bool = true;
        AppMethodBeat.o(195431);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final void aMs(String paramString)
  {
    AppMethodBeat.i(195432);
    synchronized (this.gdc)
    {
      this.gdc.remove(paramString);
      AppMethodBeat.o(195432);
      return;
    }
  }
  
  public final boolean ahv(String paramString)
  {
    AppMethodBeat.i(195439);
    j.a locala = aMt(paramString);
    if ((locala instanceof j.b))
    {
      boolean bool = ((j.b)locala).ahv(paramString);
      AppMethodBeat.o(195439);
      return bool;
    }
    AppMethodBeat.o(195439);
    return true;
  }
  
  public final j.a fby()
  {
    return this.ERR;
  }
  
  public final Bitmap fg(String paramString)
  {
    AppMethodBeat.i(195434);
    paramString = aMt(paramString).fg(paramString);
    AppMethodBeat.o(195434);
    return paramString;
  }
  
  public final Bitmap fh(String paramString)
  {
    AppMethodBeat.i(195435);
    paramString = aMt(paramString).fh(paramString);
    AppMethodBeat.o(195435);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b
 * JD-Core Version:    0.7.0.1
 */