package org.apache.commons.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static volatile b ajWY = b.ajXb;
  private final StringBuffer ajWZ;
  private final b ajXa;
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
      localb = ajWY;
    }
    paramb = new StringBuffer(512);
    this.ajWZ = paramb;
    this.ajXa = localb;
    this.object = paramObject;
    if (paramObject != null) {
      if ((localb.ajXi) && (paramObject != null))
      {
        b.jM(paramObject);
        if (!localb.ajXj) {
          break label153;
        }
        paramb.append(org.apache.commons.c.b.cP(paramObject.getClass()));
      }
    }
    for (;;)
    {
      if ((localb.ajXk) && (paramObject != null))
      {
        b.jM(paramObject);
        paramb.append('@');
        paramb.append(Integer.toHexString(System.identityHashCode(paramObject)));
      }
      paramb.append(localb.NmA);
      if (localb.ajXm) {
        localb.c(paramb);
      }
      AppMethodBeat.o(40695);
      return;
      label153:
      paramb.append(paramObject.getClass().getName());
    }
  }
  
  public final a jK(Object paramObject)
  {
    AppMethodBeat.i(40696);
    this.ajXa.b(this.ajWZ, paramObject);
    AppMethodBeat.o(40696);
    return this;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(40697);
    if (this.object == null)
    {
      this.ajWZ.append(this.ajXa.ajXu);
      localObject1 = this.ajWZ.toString();
      AppMethodBeat.o(40697);
      return localObject1;
    }
    Object localObject1 = this.ajXa;
    StringBuffer localStringBuffer = this.ajWZ;
    Object localObject2 = this.object;
    int k;
    int m;
    if (!((b)localObject1).ajXn)
    {
      k = localStringBuffer.length();
      m = ((b)localObject1).ajXo.length();
      if ((k > 0) && (m > 0) && (k >= m))
      {
        i = 0;
        label105:
        if (i >= m) {
          break label179;
        }
        if (localStringBuffer.charAt(k - 1 - i) == ((b)localObject1).ajXo.charAt(m - 1 - i)) {
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
      localStringBuffer.append(((b)localObject1).NmB);
      b.jN(localObject2);
      break;
      i += 1;
      break label105;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.c.a.a
 * JD-Core Version:    0.7.0.1
 */