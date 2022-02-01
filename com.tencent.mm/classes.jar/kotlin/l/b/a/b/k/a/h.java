package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.b.a;
import kotlin.l.b.a.b.e.b.c;

public final class h
{
  final c SZH;
  final a.b TKA;
  final a TKB;
  final an TKC;
  
  public h(c paramc, a.b paramb, a parama, an paraman)
  {
    AppMethodBeat.i(60288);
    this.SZH = paramc;
    this.TKA = paramb;
    this.TKB = parama;
    this.TKC = paraman;
    AppMethodBeat.o(60288);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60291);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.j(this.SZH, paramObject.SZH)) || (!p.j(this.TKA, paramObject.TKA)) || (!p.j(this.TKB, paramObject.TKB)) || (!p.j(this.TKC, paramObject.TKC))) {}
      }
    }
    else
    {
      AppMethodBeat.o(60291);
      return true;
    }
    AppMethodBeat.o(60291);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(60290);
    Object localObject = this.SZH;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.TKA;
      if (localObject == null) {
        break label105;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.TKB;
      if (localObject == null) {
        break label110;
      }
    }
    label105:
    label110:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.TKC;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      AppMethodBeat.o(60290);
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60289);
    String str = "ClassData(nameResolver=" + this.SZH + ", classProto=" + this.TKA + ", metadataVersion=" + this.TKB + ", sourceElement=" + this.TKC + ")";
    AppMethodBeat.o(60289);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.h
 * JD-Core Version:    0.7.0.1
 */