package d.l.b.a.b.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.k.h;
import d.l.b.a.b.e.c.a.c;
import d.l.b.a.b.e.c.a.f;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a
{
  public final a JFj;
  public final f JFk;
  private final c JFl;
  public final String[] JFm;
  public final String[] JFn;
  private final String JFo;
  private final int JFp;
  private final String packageName;
  public final String[] strings;
  
  public a(a parama, f paramf, c paramc, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(58283);
    this.JFj = parama;
    this.JFk = paramf;
    this.JFl = paramc;
    this.JFm = paramArrayOfString1;
    this.JFn = paramArrayOfString2;
    this.strings = paramArrayOfString3;
    this.JFo = paramString1;
    this.JFp = paramInt;
    this.packageName = paramString2;
    AppMethodBeat.o(58283);
  }
  
  public final String fCi()
  {
    String str = this.JFo;
    if (this.JFj == a.JFv) {}
    for (int i = 1; i != 0; i = 0) {
      return str;
    }
    return null;
  }
  
  public final boolean fCj()
  {
    return (this.JFp & 0x2) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58282);
    String str = this.JFj + " version=" + this.JFk;
    AppMethodBeat.o(58282);
    return str;
  }
  
  public static enum a
  {
    private static final Map<Integer, a> JFx;
    public static final a JFy;
    private final int id;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(58278);
      Object localObject1 = new a("UNKNOWN", 0, 0);
      JFq = (a)localObject1;
      Object localObject2 = new a("CLASS", 1, 1);
      JFr = (a)localObject2;
      a locala1 = new a("FILE_FACADE", 2, 2);
      JFs = locala1;
      a locala2 = new a("SYNTHETIC_CLASS", 3, 3);
      JFt = locala2;
      a locala3 = new a("MULTIFILE_CLASS", 4, 4);
      JFu = locala3;
      a locala4 = new a("MULTIFILE_CLASS_PART", 5, 5);
      JFv = locala4;
      JFw = new a[] { localObject1, localObject2, locala1, locala2, locala3, locala4 };
      JFy = new a((byte)0);
      localObject1 = values();
      localObject2 = (Map)new LinkedHashMap(h.kK(ae.adL(localObject1.length), 16));
      int j = localObject1.length;
      while (i < j)
      {
        locala1 = localObject1[i];
        ((Map)localObject2).put(Integer.valueOf(locala1.id), locala1);
        i += 1;
      }
      JFx = (Map)localObject2;
      AppMethodBeat.o(58278);
    }
    
    private a(int paramInt)
    {
      this.id = paramInt;
    }
    
    public static final a adU(int paramInt)
    {
      AppMethodBeat.i(58281);
      a locala2 = (a)JFx.get(Integer.valueOf(paramInt));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = JFq;
      }
      AppMethodBeat.o(58281);
      return locala1;
    }
    
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */