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
  c ZPg;
  private final CopyOnWriteArraySet<f> ZPh;
  private final int bgc;
  private final String name;
  
  public b(int paramInt, String paramString)
  {
    AppMethodBeat.i(224490);
    this.ZPh = new CopyOnWriteArraySet();
    this.bgc = paramInt;
    this.name = paramString;
    AppMethodBeat.o(224490);
  }
  
  private static f a(f paramf, Iterator paramIterator)
  {
    AppMethodBeat.i(224498);
    while (paramIterator.hasNext())
    {
      f localf = (f)paramIterator.next();
      if (TextUtils.equals(paramf.itf(), localf.itf()))
      {
        AppMethodBeat.o(224498);
        return localf;
      }
    }
    AppMethodBeat.o(224498);
    return null;
  }
  
  private final f e(e parame)
  {
    AppMethodBeat.i(224520);
    Iterator localIterator = this.ZPh.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if ((!localf.QCj) && (localf.a(parame) != a.b.ZPm))
      {
        AppMethodBeat.o(224520);
        return localf;
      }
      localf.itd();
      if (localf.ite()) {
        l(localf);
      }
    }
    AppMethodBeat.o(224520);
    return null;
  }
  
  private boolean itj()
  {
    AppMethodBeat.i(224492);
    if (this.ZPh.size() == this.bgc)
    {
      AppMethodBeat.o(224492);
      return true;
    }
    AppMethodBeat.o(224492);
    return false;
  }
  
  private f itk()
  {
    AppMethodBeat.i(224500);
    Object localObject = this.ZPh.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (f)((Iterator)localObject).next();
      AppMethodBeat.o(224500);
      return localObject;
    }
    AppMethodBeat.o(224500);
    return null;
  }
  
  private f k(f paramf)
  {
    AppMethodBeat.i(224496);
    Iterator localIterator = this.ZPh.iterator();
    if (a.isT().ZNM.ZPu == b.a.ZPx)
    {
      paramf = a(paramf, localIterator);
      if (paramf != null)
      {
        AppMethodBeat.o(224496);
        return paramf;
      }
    }
    paramf = itk();
    AppMethodBeat.o(224496);
    return paramf;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(224512);
    new StringBuilder("CodecWrapperPool clear:").append(this.ZPh);
    com.tencent.tmediacodec.g.b.bDQ("CodecWrapperPool");
    Iterator localIterator = this.ZPh.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (this.ZPg != null) {
        this.ZPg.i(localf);
      }
    }
    this.ZPh.clear();
    AppMethodBeat.o(224512);
  }
  
  public final f d(e parame)
  {
    AppMethodBeat.i(224510);
    parame = e(parame);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "obtain codecWrapper:".concat(String.valueOf(parame));
      com.tencent.tmediacodec.g.b.bDP("CodecWrapperPool");
    }
    if (parame != null)
    {
      this.ZPh.remove(parame);
      AppMethodBeat.o(224510);
      return parame;
    }
    AppMethodBeat.o(224510);
    return null;
  }
  
  public final void j(f paramf)
  {
    AppMethodBeat.i(224493);
    if (itj()) {
      l(k(paramf));
    }
    this.ZPh.add(paramf);
    AppMethodBeat.o(224493);
  }
  
  public final void l(f paramf)
  {
    AppMethodBeat.i(224505);
    if (this.ZPh.remove(paramf))
    {
      if (this.ZPg != null)
      {
        this.ZPg.i(paramf);
        AppMethodBeat.o(224505);
      }
    }
    else
    {
      new StringBuilder("pool:").append(this.name).append(" remove ").append(paramf).append(" not found");
      com.tencent.tmediacodec.g.b.bDR("CodecWrapperPool");
    }
    AppMethodBeat.o(224505);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224515);
    String str = "size:" + this.ZPh.size() + " elements:" + this.ZPh;
    AppMethodBeat.o(224515);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.c.b
 * JD-Core Version:    0.7.0.1
 */