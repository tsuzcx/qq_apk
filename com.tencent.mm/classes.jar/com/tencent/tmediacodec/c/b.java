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
  c ahUh;
  private final CopyOnWriteArraySet<f> ahUi;
  private final int cZV;
  private final String name;
  
  public b(int paramInt, String paramString)
  {
    AppMethodBeat.i(210738);
    this.ahUi = new CopyOnWriteArraySet();
    this.cZV = paramInt;
    this.name = paramString;
    AppMethodBeat.o(210738);
  }
  
  private static f a(f paramf, Iterator paramIterator)
  {
    AppMethodBeat.i(210755);
    while (paramIterator.hasNext())
    {
      f localf = (f)paramIterator.next();
      if (TextUtils.equals(paramf.kcz(), localf.kcz()))
      {
        AppMethodBeat.o(210755);
        return localf;
      }
    }
    AppMethodBeat.o(210755);
    return null;
  }
  
  private final f e(e parame)
  {
    AppMethodBeat.i(210770);
    Iterator localIterator = this.ahUi.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if ((!localf.Xvs) && (localf.a(parame) != a.b.ahUn))
      {
        AppMethodBeat.o(210770);
        return localf;
      }
      localf.kcx();
      if (localf.kcy()) {
        l(localf);
      }
    }
    AppMethodBeat.o(210770);
    return null;
  }
  
  private f k(f paramf)
  {
    AppMethodBeat.i(210749);
    Iterator localIterator = this.ahUi.iterator();
    if (a.kcn().ahSN.ahUv == b.a.ahUy)
    {
      paramf = a(paramf, localIterator);
      if (paramf != null)
      {
        AppMethodBeat.o(210749);
        return paramf;
      }
    }
    paramf = kcE();
    AppMethodBeat.o(210749);
    return paramf;
  }
  
  private boolean kcD()
  {
    AppMethodBeat.i(210744);
    if (this.ahUi.size() == this.cZV)
    {
      AppMethodBeat.o(210744);
      return true;
    }
    AppMethodBeat.o(210744);
    return false;
  }
  
  private f kcE()
  {
    AppMethodBeat.i(210762);
    Object localObject = this.ahUi.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (f)((Iterator)localObject).next();
      AppMethodBeat.o(210762);
      return localObject;
    }
    AppMethodBeat.o(210762);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(210796);
    new StringBuilder("CodecWrapperPool clear:").append(this.ahUi);
    com.tencent.tmediacodec.g.b.Q("CodecWrapperPool");
    Iterator localIterator = this.ahUi.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (this.ahUh != null) {
        this.ahUh.i(localf);
      }
    }
    this.ahUi.clear();
    AppMethodBeat.o(210796);
  }
  
  public final f d(e parame)
  {
    AppMethodBeat.i(210788);
    parame = e(parame);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "obtain codecWrapper:".concat(String.valueOf(parame));
      com.tencent.tmediacodec.g.b.O("CodecWrapperPool");
    }
    if (parame != null)
    {
      this.ahUi.remove(parame);
      AppMethodBeat.o(210788);
      return parame;
    }
    AppMethodBeat.o(210788);
    return null;
  }
  
  public final void j(f paramf)
  {
    AppMethodBeat.i(210776);
    if (kcD()) {
      l(k(paramf));
    }
    this.ahUi.add(paramf);
    AppMethodBeat.o(210776);
  }
  
  public final void l(f paramf)
  {
    AppMethodBeat.i(210783);
    if (this.ahUi.remove(paramf))
    {
      if (this.ahUh != null)
      {
        this.ahUh.i(paramf);
        AppMethodBeat.o(210783);
      }
    }
    else
    {
      new StringBuilder("pool:").append(this.name).append(" remove ").append(paramf).append(" not found");
      com.tencent.tmediacodec.g.b.R("CodecWrapperPool");
    }
    AppMethodBeat.o(210783);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210802);
    String str = "size:" + this.ahUi.size() + " elements:" + this.ahUi;
    AppMethodBeat.o(210802);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.c.b
 * JD-Core Version:    0.7.0.1
 */