package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static volatile b UgO = b.UgR;
  private final StringBuffer UgP;
  private final b UgQ;
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
      localb = UgO;
    }
    paramb = new StringBuffer(512);
    this.UgP = paramb;
    this.UgQ = localb;
    this.object = paramObject;
    if (paramObject != null) {
      if ((localb.UgY) && (paramObject != null))
      {
        b.gD(paramObject);
        if (!localb.UgZ) {
          break label153;
        }
        paramb.append(org.apache.commons.b.b.bE(paramObject.getClass()));
      }
    }
    for (;;)
    {
      if ((localb.Uha) && (paramObject != null))
      {
        b.gD(paramObject);
        paramb.append('@');
        paramb.append(Integer.toHexString(System.identityHashCode(paramObject)));
      }
      paramb.append(localb.But);
      if (localb.Uhc) {
        localb.c(paramb);
      }
      AppMethodBeat.o(40695);
      return;
      label153:
      paramb.append(paramObject.getClass().getName());
    }
  }
  
  public final a gB(Object paramObject)
  {
    AppMethodBeat.i(40696);
    this.UgQ.b(this.UgP, paramObject);
    AppMethodBeat.o(40696);
    return this;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(40697);
    if (this.object == null)
    {
      this.UgP.append(this.UgQ.Uhk);
      localObject1 = this.UgP.toString();
      AppMethodBeat.o(40697);
      return localObject1;
    }
    Object localObject1 = this.UgQ;
    StringBuffer localStringBuffer = this.UgP;
    Object localObject2 = this.object;
    int k;
    int m;
    if (!((b)localObject1).Uhd)
    {
      k = localStringBuffer.length();
      m = ((b)localObject1).Uhe.length();
      if ((k > 0) && (m > 0) && (k >= m))
      {
        i = 0;
        label105:
        if (i >= m) {
          break label179;
        }
        if (localStringBuffer.charAt(k - 1 - i) == ((b)localObject1).Uhe.charAt(m - 1 - i)) {
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
      localStringBuffer.append(((b)localObject1).Buu);
      b.gE(localObject2);
      break;
      i += 1;
      break label105;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.apache.commons.b.a.a
 * JD-Core Version:    0.7.0.1
 */