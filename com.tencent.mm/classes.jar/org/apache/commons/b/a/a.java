package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static volatile b OrQ = b.OrT;
  private final StringBuffer OrR;
  private final b OrS;
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
      localb = OrQ;
    }
    paramb = new StringBuffer(512);
    this.OrR = paramb;
    this.OrS = localb;
    this.object = paramObject;
    if (paramObject != null) {
      if ((localb.Osa) && (paramObject != null))
      {
        b.gy(paramObject);
        if (!localb.Osb) {
          break label153;
        }
        paramb.append(org.apache.commons.b.b.bE(paramObject.getClass()));
      }
    }
    for (;;)
    {
      if ((localb.Osc) && (paramObject != null))
      {
        b.gy(paramObject);
        paramb.append('@');
        paramb.append(Integer.toHexString(System.identityHashCode(paramObject)));
      }
      paramb.append(localb.xuq);
      if (localb.Ose) {
        localb.c(paramb);
      }
      AppMethodBeat.o(40695);
      return;
      label153:
      paramb.append(paramObject.getClass().getName());
    }
  }
  
  public final a gw(Object paramObject)
  {
    AppMethodBeat.i(40696);
    this.OrS.b(this.OrR, paramObject);
    AppMethodBeat.o(40696);
    return this;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(40697);
    if (this.object == null)
    {
      this.OrR.append(this.OrS.Osm);
      localObject1 = this.OrR.toString();
      AppMethodBeat.o(40697);
      return localObject1;
    }
    Object localObject1 = this.OrS;
    StringBuffer localStringBuffer = this.OrR;
    Object localObject2 = this.object;
    int k;
    int m;
    if (!((b)localObject1).Osf)
    {
      k = localStringBuffer.length();
      m = ((b)localObject1).Osg.length();
      if ((k > 0) && (m > 0) && (k >= m))
      {
        i = 0;
        label105:
        if (i >= m) {
          break label179;
        }
        if (localStringBuffer.charAt(k - 1 - i) == ((b)localObject1).Osg.charAt(m - 1 - i)) {
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
      localStringBuffer.append(((b)localObject1).xur);
      b.gz(localObject2);
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