package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.an;
import d.l.b.a.b.e.a.b;
import d.l.b.a.b.e.b.a;
import d.l.b.a.b.e.b.c;

public final class h
{
  final a.b NVE;
  final a NVF;
  final an NVG;
  final c NjZ;
  
  public h(c paramc, a.b paramb, a parama, an paraman)
  {
    AppMethodBeat.i(60288);
    this.NjZ = paramc;
    this.NVE = paramb;
    this.NVF = parama;
    this.NVG = paraman;
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
        if ((!p.i(this.NjZ, paramObject.NjZ)) || (!p.i(this.NVE, paramObject.NVE)) || (!p.i(this.NVF, paramObject.NVF)) || (!p.i(this.NVG, paramObject.NVG))) {}
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
    Object localObject = this.NjZ;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.NVE;
      if (localObject == null) {
        break label105;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.NVF;
      if (localObject == null) {
        break label110;
      }
    }
    label105:
    label110:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.NVG;
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
    String str = "ClassData(nameResolver=" + this.NjZ + ", classProto=" + this.NVE + ", metadataVersion=" + this.NVF + ", sourceElement=" + this.NVG + ")";
    AppMethodBeat.o(60289);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.h
 * JD-Core Version:    0.7.0.1
 */