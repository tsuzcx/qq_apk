package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.a.c;
import com.tencent.tinker.a.b.a.d;
import com.tencent.tinker.a.b.a.f;
import com.tencent.tinker.a.b.a.g;
import com.tencent.tinker.a.b.a.h;
import java.io.EOFException;

public final class b
{
  final a wVp;
  
  public b(a parama)
  {
    this.wVp = parama;
  }
  
  public final short[] b(short[] paramArrayOfShort)
  {
    h localh = new h(paramArrayOfShort.length);
    c localc = new c();
    f localf = new f(localh, localc);
    paramArrayOfShort = new d(new g(paramArrayOfShort));
    int i;
    try
    {
      paramArrayOfShort.a(new b.a(this, localc));
      paramArrayOfShort.a(new b.a(this, localf));
      i = localh.wTF;
      if (i == localh.wTN.length) {
        return localh.wTN;
      }
    }
    catch (EOFException paramArrayOfShort)
    {
      throw new j(paramArrayOfShort);
    }
    paramArrayOfShort = new short[i];
    System.arraycopy(localh.wTN, 0, paramArrayOfShort, 0, i);
    return paramArrayOfShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.b
 * JD-Core Version:    0.7.0.1
 */