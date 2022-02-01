package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.an;
import d.l.b.a.b.e.a.b;
import d.l.b.a.b.e.b.a;
import d.l.b.a.b.e.b.c;

public final class h
{
  final c KVO;
  final a LHA;
  final an LHB;
  final a.b LHz;
  
  public h(c paramc, a.b paramb, a parama, an paraman)
  {
    AppMethodBeat.i(60288);
    this.KVO = paramc;
    this.LHz = paramb;
    this.LHA = parama;
    this.LHB = paraman;
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
        if ((!k.g(this.KVO, paramObject.KVO)) || (!k.g(this.LHz, paramObject.LHz)) || (!k.g(this.LHA, paramObject.LHA)) || (!k.g(this.LHB, paramObject.LHB))) {}
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
    Object localObject = this.KVO;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.LHz;
      if (localObject == null) {
        break label105;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.LHA;
      if (localObject == null) {
        break label110;
      }
    }
    label105:
    label110:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.LHB;
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
    String str = "ClassData(nameResolver=" + this.KVO + ", classProto=" + this.LHz + ", metadataVersion=" + this.LHA + ", sourceElement=" + this.LHB + ")";
    AppMethodBeat.o(60289);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.h
 * JD-Core Version:    0.7.0.1
 */