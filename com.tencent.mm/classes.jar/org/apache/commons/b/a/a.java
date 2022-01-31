package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static volatile b CQK = b.CQN;
  private final StringBuffer CQL;
  private final b CQM;
  private final Object object;
  
  public a(Object paramObject, b paramb)
  {
    this(paramObject, paramb, (byte)0);
  }
  
  private a(Object paramObject, b paramb, byte paramByte)
  {
    AppMethodBeat.i(142934);
    b localb = paramb;
    if (paramb == null) {
      localb = CQK;
    }
    paramb = new StringBuffer(512);
    this.CQL = paramb;
    this.CQM = localb;
    this.object = paramObject;
    if (paramObject != null) {
      if ((localb.CQU) && (paramObject != null))
      {
        b.em(paramObject);
        if (!localb.CQV) {
          break label153;
        }
        paramb.append(org.apache.commons.b.b.aX(paramObject.getClass()));
      }
    }
    for (;;)
    {
      if ((localb.CQW) && (paramObject != null))
      {
        b.em(paramObject);
        paramb.append('@');
        paramb.append(Integer.toHexString(System.identityHashCode(paramObject)));
      }
      paramb.append(localb.pLF);
      if (localb.CQY) {
        localb.b(paramb);
      }
      AppMethodBeat.o(142934);
      return;
      label153:
      paramb.append(paramObject.getClass().getName());
    }
  }
  
  public final a ek(Object paramObject)
  {
    AppMethodBeat.i(142935);
    this.CQM.b(this.CQL, paramObject);
    AppMethodBeat.o(142935);
    return this;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(142936);
    if (this.object == null)
    {
      this.CQL.append(this.CQM.CRg);
      localObject1 = this.CQL.toString();
      AppMethodBeat.o(142936);
      return localObject1;
    }
    Object localObject1 = this.CQM;
    StringBuffer localStringBuffer = this.CQL;
    Object localObject2 = this.object;
    int k;
    int m;
    if (!((b)localObject1).CQZ)
    {
      k = localStringBuffer.length();
      m = ((b)localObject1).CRa.length();
      if ((k > 0) && (m > 0) && (k >= m))
      {
        i = 0;
        label105:
        if (i >= m) {
          break label179;
        }
        if (localStringBuffer.charAt(k - 1 - i) == ((b)localObject1).CRa.charAt(m - 1 - i)) {
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
      localStringBuffer.append(((b)localObject1).pLG);
      b.en(localObject2);
      break;
      i += 1;
      break label105;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.apache.commons.b.a.a
 * JD-Core Version:    0.7.0.1
 */