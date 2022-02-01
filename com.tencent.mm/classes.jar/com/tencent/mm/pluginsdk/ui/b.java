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
  private final j.a Kbe;
  private final HashMap<String, j.a> gKR;
  
  public b(j.a parama)
  {
    AppMethodBeat.i(223831);
    this.gKR = new HashMap();
    this.Kbe = parama;
    AppMethodBeat.o(223831);
  }
  
  private j.a ber(String paramString)
  {
    AppMethodBeat.i(223839);
    if (paramString == null)
    {
      paramString = this.Kbe;
      AppMethodBeat.o(223839);
      return paramString;
    }
    synchronized (this.gKR)
    {
      Iterator localIterator = this.gKR.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramString.endsWith((String)localEntry.getKey()))
        {
          paramString = (j.a)localEntry.getValue();
          AppMethodBeat.o(223839);
          return paramString;
        }
      }
      paramString = this.Kbe;
      AppMethodBeat.o(223839);
      return paramString;
    }
  }
  
  public final Bitmap Wg()
  {
    AppMethodBeat.i(223837);
    Bitmap localBitmap = this.Kbe.Wg();
    AppMethodBeat.o(223837);
    return localBitmap;
  }
  
  public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(223834);
    paramString = ber(paramString).a(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(223834);
    return paramString;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(223838);
    ber(paramj.getTag()).a(paramj);
    this.Kbe.a(paramj);
    AppMethodBeat.o(223838);
  }
  
  public final boolean a(String paramString, j.a parama)
  {
    AppMethodBeat.i(223832);
    synchronized (this.gKR)
    {
      if (this.gKR.put(paramString, parama) == null)
      {
        bool = true;
        AppMethodBeat.o(223832);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final boolean aub(String paramString)
  {
    AppMethodBeat.i(223840);
    j.a locala = ber(paramString);
    if ((locala instanceof j.b))
    {
      boolean bool = ((j.b)locala).aub(paramString);
      AppMethodBeat.o(223840);
      return bool;
    }
    AppMethodBeat.o(223840);
    return true;
  }
  
  public final void beq(String paramString)
  {
    AppMethodBeat.i(223833);
    synchronized (this.gKR)
    {
      this.gKR.remove(paramString);
      AppMethodBeat.o(223833);
      return;
    }
  }
  
  public final Bitmap fZ(String paramString)
  {
    AppMethodBeat.i(223835);
    paramString = ber(paramString).fZ(paramString);
    AppMethodBeat.o(223835);
    return paramString;
  }
  
  public final Bitmap ga(String paramString)
  {
    AppMethodBeat.i(223836);
    paramString = ber(paramString).ga(paramString);
    AppMethodBeat.o(223836);
    return paramString;
  }
  
  public final j.a gow()
  {
    return this.Kbe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b
 * JD-Core Version:    0.7.0.1
 */