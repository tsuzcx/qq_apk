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
  private final j.a Fkm;
  private final HashMap<String, j.a> gfk;
  
  public b(j.a parama)
  {
    AppMethodBeat.i(218883);
    this.gfk = new HashMap();
    this.Fkm = parama;
    AppMethodBeat.o(218883);
  }
  
  private j.a aNP(String paramString)
  {
    AppMethodBeat.i(218891);
    if (paramString == null)
    {
      paramString = this.Fkm;
      AppMethodBeat.o(218891);
      return paramString;
    }
    synchronized (this.gfk)
    {
      Iterator localIterator = this.gfk.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramString.endsWith((String)localEntry.getKey()))
        {
          paramString = (j.a)localEntry.getValue();
          AppMethodBeat.o(218891);
          return paramString;
        }
      }
      paramString = this.Fkm;
      AppMethodBeat.o(218891);
      return paramString;
    }
  }
  
  public final Bitmap LT()
  {
    AppMethodBeat.i(218889);
    Bitmap localBitmap = this.Fkm.LT();
    AppMethodBeat.o(218889);
    return localBitmap;
  }
  
  public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(218886);
    paramString = aNP(paramString).a(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(218886);
    return paramString;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(218890);
    aNP(paramj.getTag()).a(paramj);
    this.Fkm.a(paramj);
    AppMethodBeat.o(218890);
  }
  
  public final boolean a(String paramString, j.a parama)
  {
    AppMethodBeat.i(218884);
    synchronized (this.gfk)
    {
      if (this.gfk.put(paramString, parama) == null)
      {
        bool = true;
        AppMethodBeat.o(218884);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final void aNO(String paramString)
  {
    AppMethodBeat.i(218885);
    synchronized (this.gfk)
    {
      this.gfk.remove(paramString);
      AppMethodBeat.o(218885);
      return;
    }
  }
  
  public final boolean ais(String paramString)
  {
    AppMethodBeat.i(218892);
    j.a locala = aNP(paramString);
    if ((locala instanceof j.b))
    {
      boolean bool = ((j.b)locala).ais(paramString);
      AppMethodBeat.o(218892);
      return bool;
    }
    AppMethodBeat.o(218892);
    return true;
  }
  
  public final j.a ffm()
  {
    return this.Fkm;
  }
  
  public final Bitmap fl(String paramString)
  {
    AppMethodBeat.i(218887);
    paramString = aNP(paramString).fl(paramString);
    AppMethodBeat.o(218887);
    return paramString;
  }
  
  public final Bitmap fm(String paramString)
  {
    AppMethodBeat.i(218888);
    paramString = aNP(paramString).fm(paramString);
    AppMethodBeat.o(218888);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b
 * JD-Core Version:    0.7.0.1
 */