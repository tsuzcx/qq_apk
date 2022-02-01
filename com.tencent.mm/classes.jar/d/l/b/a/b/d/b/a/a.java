package d.l.b.a.b.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.k.j;
import d.l.b.a.b.e.c.a.c;
import d.l.b.a.b.e.c.a.f;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a
{
  public final a NGF;
  public final f NGG;
  private final c NGH;
  public final String[] NGI;
  public final String[] NGJ;
  private final String NGK;
  private final int NGL;
  private final String packageName;
  public final String[] strings;
  
  public a(a parama, f paramf, c paramc, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(58283);
    this.NGF = parama;
    this.NGG = paramf;
    this.NGH = paramc;
    this.NGI = paramArrayOfString1;
    this.NGJ = paramArrayOfString2;
    this.strings = paramArrayOfString3;
    this.NGK = paramString1;
    this.NGL = paramInt;
    this.packageName = paramString2;
    AppMethodBeat.o(58283);
  }
  
  public final String gqN()
  {
    String str = this.NGK;
    if (this.NGF == a.NGR) {}
    for (int i = 1; i != 0; i = 0) {
      return str;
    }
    return null;
  }
  
  public final boolean gqO()
  {
    return (this.NGL & 0x2) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58282);
    String str = this.NGF + " version=" + this.NGG;
    AppMethodBeat.o(58282);
    return str;
  }
  
  public static enum a
  {
    private static final Map<Integer, a> NGT;
    public static final a NGU;
    private final int id;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(58278);
      Object localObject1 = new a("UNKNOWN", 0, 0);
      NGM = (a)localObject1;
      Object localObject2 = new a("CLASS", 1, 1);
      NGN = (a)localObject2;
      a locala1 = new a("FILE_FACADE", 2, 2);
      NGO = locala1;
      a locala2 = new a("SYNTHETIC_CLASS", 3, 3);
      NGP = locala2;
      a locala3 = new a("MULTIFILE_CLASS", 4, 4);
      NGQ = locala3;
      a locala4 = new a("MULTIFILE_CLASS_PART", 5, 5);
      NGR = locala4;
      NGS = new a[] { localObject1, localObject2, locala1, locala2, locala3, locala4 };
      NGU = new a((byte)0);
      localObject1 = values();
      localObject2 = (Map)new LinkedHashMap(j.lw(ae.ajS(localObject1.length), 16));
      int j = localObject1.length;
      while (i < j)
      {
        locala1 = localObject1[i];
        ((Map)localObject2).put(Integer.valueOf(locala1.id), locala1);
        i += 1;
      }
      NGT = (Map)localObject2;
      AppMethodBeat.o(58278);
    }
    
    private a(int paramInt)
    {
      this.id = paramInt;
    }
    
    public static final a akb(int paramInt)
    {
      AppMethodBeat.i(58281);
      a locala2 = (a)NGT.get(Integer.valueOf(paramInt));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = NGM;
      }
      AppMethodBeat.o(58281);
      return locala1;
    }
    
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */