package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.d.a.e.t;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.b;
import java.util.Arrays;
import java.util.Set;

public abstract interface j
{
  public abstract g a(a parama);
  
  public abstract t i(b paramb);
  
  public abstract Set<String> j(b paramb);
  
  public static final class a
  {
    public final a NpB;
    private final byte[] Nzs;
    private final g Nzt;
    
    private a(a parama, byte[] paramArrayOfByte, g paramg)
    {
      AppMethodBeat.i(57580);
      this.NpB = parama;
      this.Nzs = paramArrayOfByte;
      this.Nzt = paramg;
      AppMethodBeat.o(57580);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(57584);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.i(this.NpB, paramObject.NpB)) || (!p.i(this.Nzs, paramObject.Nzs)) || (!p.i(this.Nzt, paramObject.Nzt))) {}
        }
      }
      else
      {
        AppMethodBeat.o(57584);
        return true;
      }
      AppMethodBeat.o(57584);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(57583);
      Object localObject = this.NpB;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.Nzs;
        if (localObject == null) {
          break label80;
        }
      }
      label80:
      for (int j = Arrays.hashCode((byte[])localObject);; j = 0)
      {
        localObject = this.Nzt;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(57583);
        return (j + i * 31) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57582);
      String str = "Request(classId=" + this.NpB + ", previouslyFoundClassFileContent=" + Arrays.toString(this.Nzs) + ", outerClass=" + this.Nzt + ")";
      AppMethodBeat.o(57582);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.j
 * JD-Core Version:    0.7.0.1
 */