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
  public final j.a RbJ;
  private final HashMap<String, j.a> jvh;
  
  public b(j.a parama)
  {
    AppMethodBeat.i(199697);
    this.jvh = new HashMap();
    this.RbJ = parama;
    AppMethodBeat.o(199697);
  }
  
  private j.a bqN(String paramString)
  {
    AppMethodBeat.i(199711);
    if (paramString == null)
    {
      paramString = this.RbJ;
      AppMethodBeat.o(199711);
      return paramString;
    }
    synchronized (this.jvh)
    {
      Iterator localIterator = this.jvh.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramString.endsWith((String)localEntry.getKey()))
        {
          paramString = (j.a)localEntry.getValue();
          AppMethodBeat.o(199711);
          return paramString;
        }
      }
      paramString = this.RbJ;
      AppMethodBeat.o(199711);
      return paramString;
    }
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(199710);
    bqN(paramj.getTag()).a(paramj);
    this.RbJ.a(paramj);
    AppMethodBeat.o(199710);
  }
  
  public final boolean a(String paramString, j.a parama)
  {
    AppMethodBeat.i(199698);
    synchronized (this.jvh)
    {
      if (this.jvh.put(paramString, parama) == null)
      {
        bool = true;
        AppMethodBeat.o(199698);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final boolean aDn(String paramString)
  {
    AppMethodBeat.i(199712);
    j.a locala = bqN(paramString);
    if ((locala instanceof j.b))
    {
      boolean bool = ((j.b)locala).aDn(paramString);
      AppMethodBeat.o(199712);
      return bool;
    }
    AppMethodBeat.o(199712);
    return true;
  }
  
  public final Bitmap aaC()
  {
    AppMethodBeat.i(199709);
    Bitmap localBitmap = this.RbJ.aaC();
    AppMethodBeat.o(199709);
    return localBitmap;
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(199703);
    paramString = bqN(paramString).b(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(199703);
    return paramString;
  }
  
  public final void bqM(String paramString)
  {
    AppMethodBeat.i(199700);
    synchronized (this.jvh)
    {
      this.jvh.remove(paramString);
      AppMethodBeat.o(199700);
      return;
    }
  }
  
  public final Bitmap gJ(String paramString)
  {
    AppMethodBeat.i(199705);
    paramString = bqN(paramString).gJ(paramString);
    AppMethodBeat.o(199705);
    return paramString;
  }
  
  public final Bitmap gK(String paramString)
  {
    AppMethodBeat.i(199707);
    paramString = bqN(paramString).gK(paramString);
    AppMethodBeat.o(199707);
    return paramString;
  }
  
  public final j.a hjg()
  {
    return this.RbJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b
 * JD-Core Version:    0.7.0.1
 */