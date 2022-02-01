package com.tencent.tmediacodec.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.a;
import com.tencent.tmediacodec.b.e;
import com.tencent.tmediacodec.b.f;
import com.tencent.tmediacodec.e.a.b;
import com.tencent.tmediacodec.e.b.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class b
{
  c Smv;
  private final CopyOnWriteArraySet<f> Smw;
  private final int bwA;
  private final String name;
  
  public b(int paramInt, String paramString)
  {
    AppMethodBeat.i(190154);
    this.Smw = new CopyOnWriteArraySet();
    this.bwA = paramInt;
    this.name = paramString;
    AppMethodBeat.o(190154);
  }
  
  private static f a(f paramf, Iterator paramIterator)
  {
    AppMethodBeat.i(190158);
    while (paramIterator.hasNext())
    {
      f localf = (f)paramIterator.next();
      if (TextUtils.equals(paramf.hpz(), localf.hpz()))
      {
        AppMethodBeat.o(190158);
        return localf;
      }
    }
    AppMethodBeat.o(190158);
    return null;
  }
  
  private final f e(e parame)
  {
    AppMethodBeat.i(190164);
    Iterator localIterator = this.Smw.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if ((!localf.aHN) && (localf.a(parame) != a.b.SmB))
      {
        AppMethodBeat.o(190164);
        return localf;
      }
      localf.hpx();
      if (localf.hpy()) {
        l(localf);
      }
    }
    AppMethodBeat.o(190164);
    return null;
  }
  
  private f hpD()
  {
    AppMethodBeat.i(190159);
    Object localObject = this.Smw.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (f)((Iterator)localObject).next();
      AppMethodBeat.o(190159);
      return localObject;
    }
    AppMethodBeat.o(190159);
    return null;
  }
  
  private boolean isFull()
  {
    AppMethodBeat.i(190155);
    if (this.Smw.size() == this.bwA)
    {
      AppMethodBeat.o(190155);
      return true;
    }
    AppMethodBeat.o(190155);
    return false;
  }
  
  private f k(f paramf)
  {
    AppMethodBeat.i(190157);
    Iterator localIterator = this.Smw.iterator();
    if (a.hpn().Slb.SmJ == b.a.SmM)
    {
      paramf = a(paramf, localIterator);
      if (paramf != null)
      {
        AppMethodBeat.o(190157);
        return paramf;
      }
    }
    paramf = hpD();
    AppMethodBeat.o(190157);
    return paramf;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(190162);
    new StringBuilder("CodecWrapperPool clear:").append(this.Smw);
    com.tencent.tmediacodec.g.b.bqR("CodecWrapperPool");
    Iterator localIterator = this.Smw.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (this.Smv != null) {
        this.Smv.i(localf);
      }
    }
    this.Smw.clear();
    AppMethodBeat.o(190162);
  }
  
  public final f d(e parame)
  {
    AppMethodBeat.i(190161);
    parame = e(parame);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "obtain codecWrapper:".concat(String.valueOf(parame));
      com.tencent.tmediacodec.g.b.bqQ("CodecWrapperPool");
    }
    if (parame != null)
    {
      this.Smw.remove(parame);
      AppMethodBeat.o(190161);
      return parame;
    }
    AppMethodBeat.o(190161);
    return null;
  }
  
  public final void j(f paramf)
  {
    AppMethodBeat.i(190156);
    if (isFull()) {
      l(k(paramf));
    }
    this.Smw.add(paramf);
    AppMethodBeat.o(190156);
  }
  
  public final void l(f paramf)
  {
    AppMethodBeat.i(190160);
    if (this.Smw.remove(paramf))
    {
      if (this.Smv != null)
      {
        this.Smv.i(paramf);
        AppMethodBeat.o(190160);
      }
    }
    else
    {
      new StringBuilder("pool:").append(this.name).append(" remove ").append(paramf).append(" not found");
      com.tencent.tmediacodec.g.b.bqS("CodecWrapperPool");
    }
    AppMethodBeat.o(190160);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190163);
    String str = "size:" + this.Smw.size() + " elements:" + this.Smw;
    AppMethodBeat.o(190163);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.c.b
 * JD-Core Version:    0.7.0.1
 */