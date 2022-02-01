package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static volatile b NUK = b.NUO;
  private final StringBuffer NUL;
  private final b NUN;
  private final Object object;
  
  public a(Object paramObject, b paramb)
  {
    this(paramObject, paramb, (byte)0);
  }
  
  private a(Object paramObject, b paramb, byte paramByte)
  {
    AppMethodBeat.i(40695);
    b localb = paramb;
    if (paramb == null) {
      localb = NUK;
    }
    paramb = new StringBuffer(512);
    this.NUL = paramb;
    this.NUN = localb;
    this.object = paramObject;
    if (paramObject != null) {
      if ((localb.NUV) && (paramObject != null))
      {
        b.gv(paramObject);
        if (!localb.NUW) {
          break label153;
        }
        paramb.append(org.apache.commons.b.b.bE(paramObject.getClass()));
      }
    }
    for (;;)
    {
      if ((localb.NUX) && (paramObject != null))
      {
        b.gv(paramObject);
        paramb.append('@');
        paramb.append(Integer.toHexString(System.identityHashCode(paramObject)));
      }
      paramb.append(localb.xez);
      if (localb.NUZ) {
        localb.c(paramb);
      }
      AppMethodBeat.o(40695);
      return;
      label153:
      paramb.append(paramObject.getClass().getName());
    }
  }
  
  public final a gt(Object paramObject)
  {
    AppMethodBeat.i(40696);
    this.NUN.b(this.NUL, paramObject);
    AppMethodBeat.o(40696);
    return this;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(40697);
    if (this.object == null)
    {
      this.NUL.append(this.NUN.NVh);
      localObject1 = this.NUL.toString();
      AppMethodBeat.o(40697);
      return localObject1;
    }
    Object localObject1 = this.NUN;
    StringBuffer localStringBuffer = this.NUL;
    Object localObject2 = this.object;
    int k;
    int m;
    if (!((b)localObject1).NVa)
    {
      k = localStringBuffer.length();
      m = ((b)localObject1).NVb.length();
      if ((k > 0) && (m > 0) && (k >= m))
      {
        i = 0;
        label105:
        if (i >= m) {
          break label179;
        }
        if (localStringBuffer.charAt(k - 1 - i) == ((b)localObject1).NVb.charAt(m - 1 - i)) {
          break label172;
        }
      }
    }
    label172:
    label179:
    for (int i = j;; i = 1)
    {
      if (i != 0) {
        localStringBuffer.setLength(k - m);
      }
      localStringBuffer.append(((b)localObject1).xeA);
      b.gw(localObject2);
      break;
      i += 1;
      break label105;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.a.a
 * JD-Core Version:    0.7.0.1
 */