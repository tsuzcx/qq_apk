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
  public final j.a XXP;
  private final HashMap<String, j.a> lYy;
  
  public b(j.a parama)
  {
    AppMethodBeat.i(245054);
    this.lYy = new HashMap();
    this.XXP = parama;
    AppMethodBeat.o(245054);
  }
  
  private j.a bqC(String paramString)
  {
    AppMethodBeat.i(245058);
    if (paramString == null)
    {
      paramString = this.XXP;
      AppMethodBeat.o(245058);
      return paramString;
    }
    synchronized (this.lYy)
    {
      Iterator localIterator = this.lYy.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramString.endsWith((String)localEntry.getKey()))
        {
          paramString = (j.a)localEntry.getValue();
          AppMethodBeat.o(245058);
          return paramString;
        }
      }
      paramString = this.XXP;
      AppMethodBeat.o(245058);
      return paramString;
    }
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(245073);
    bqC(paramj.getTag()).a(paramj);
    this.XXP.a(paramj);
    AppMethodBeat.o(245073);
  }
  
  public final boolean a(String paramString, j.a parama)
  {
    AppMethodBeat.i(245061);
    synchronized (this.lYy)
    {
      if (this.lYy.put(paramString, parama) == null)
      {
        bool = true;
        AppMethodBeat.o(245061);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final Bitmap aCj()
  {
    AppMethodBeat.i(245070);
    Bitmap localBitmap = this.XXP.aCj();
    AppMethodBeat.o(245070);
    return localBitmap;
  }
  
  public final boolean ayI(String paramString)
  {
    AppMethodBeat.i(245074);
    j.a locala = bqC(paramString);
    if ((locala instanceof j.b))
    {
      boolean bool = ((j.b)locala).ayI(paramString);
      AppMethodBeat.o(245074);
      return bool;
    }
    AppMethodBeat.o(245074);
    return true;
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(245063);
    paramString = bqC(paramString).b(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(245063);
    return paramString;
  }
  
  public final void bqB(String paramString)
  {
    AppMethodBeat.i(245062);
    synchronized (this.lYy)
    {
      this.lYy.remove(paramString);
      AppMethodBeat.o(245062);
      return;
    }
  }
  
  public final Bitmap ik(String paramString)
  {
    AppMethodBeat.i(245067);
    paramString = bqC(paramString).ik(paramString);
    AppMethodBeat.o(245067);
    return paramString;
  }
  
  public final Bitmap loadBitmap(String paramString)
  {
    AppMethodBeat.i(245066);
    paramString = bqC(paramString).loadBitmap(paramString);
    AppMethodBeat.o(245066);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b
 * JD-Core Version:    0.7.0.1
 */