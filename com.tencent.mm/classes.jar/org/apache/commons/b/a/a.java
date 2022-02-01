package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static volatile b KmC = b.KmF;
  private final StringBuffer KmD;
  private final b KmE;
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
      localb = KmC;
    }
    paramb = new StringBuffer(512);
    this.KmD = paramb;
    this.KmE = localb;
    this.object = paramObject;
    if (paramObject != null) {
      if ((localb.KmM) && (paramObject != null))
      {
        b.fR(paramObject);
        if (!localb.KmN) {
          break label153;
        }
        paramb.append(org.apache.commons.b.b.bz(paramObject.getClass()));
      }
    }
    for (;;)
    {
      if ((localb.KmO) && (paramObject != null))
      {
        b.fR(paramObject);
        paramb.append('@');
        paramb.append(Integer.toHexString(System.identityHashCode(paramObject)));
      }
      paramb.append(localb.uNS);
      if (localb.KmQ) {
        localb.c(paramb);
      }
      AppMethodBeat.o(40695);
      return;
      label153:
      paramb.append(paramObject.getClass().getName());
    }
  }
  
  public final a fP(Object paramObject)
  {
    AppMethodBeat.i(40696);
    this.KmE.b(this.KmD, paramObject);
    AppMethodBeat.o(40696);
    return this;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(40697);
    if (this.object == null)
    {
      this.KmD.append(this.KmE.KmY);
      localObject1 = this.KmD.toString();
      AppMethodBeat.o(40697);
      return localObject1;
    }
    Object localObject1 = this.KmE;
    StringBuffer localStringBuffer = this.KmD;
    Object localObject2 = this.object;
    int k;
    int m;
    if (!((b)localObject1).KmR)
    {
      k = localStringBuffer.length();
      m = ((b)localObject1).KmS.length();
      if ((k > 0) && (m > 0) && (k >= m))
      {
        i = 0;
        label105:
        if (i >= m) {
          break label179;
        }
        if (localStringBuffer.charAt(k - 1 - i) == ((b)localObject1).KmS.charAt(m - 1 - i)) {
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
      localStringBuffer.append(((b)localObject1).uNT);
      b.fS(localObject2);
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