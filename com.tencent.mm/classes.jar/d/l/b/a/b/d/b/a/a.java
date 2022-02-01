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
  public final a LsC;
  public final f LsD;
  private final c LsE;
  public final String[] LsF;
  public final String[] LsG;
  private final String LsH;
  private final int LsI;
  private final String packageName;
  public final String[] strings;
  
  public a(a parama, f paramf, c paramc, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(58283);
    this.LsC = parama;
    this.LsD = paramf;
    this.LsE = paramc;
    this.LsF = paramArrayOfString1;
    this.LsG = paramArrayOfString2;
    this.strings = paramArrayOfString3;
    this.LsH = paramString1;
    this.LsI = paramInt;
    this.packageName = paramString2;
    AppMethodBeat.o(58283);
  }
  
  public final String fUM()
  {
    String str = this.LsH;
    if (this.LsC == a.LsO) {}
    for (int i = 1; i != 0; i = 0) {
      return str;
    }
    return null;
  }
  
  public final boolean fUN()
  {
    return (this.LsI & 0x2) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58282);
    String str = this.LsC + " version=" + this.LsD;
    AppMethodBeat.o(58282);
    return str;
  }
  
  public static enum a
  {
    private static final Map<Integer, a> LsQ;
    public static final a LsR;
    private final int id;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(58278);
      Object localObject1 = new a("UNKNOWN", 0, 0);
      LsJ = (a)localObject1;
      Object localObject2 = new a("CLASS", 1, 1);
      LsK = (a)localObject2;
      a locala1 = new a("FILE_FACADE", 2, 2);
      LsL = locala1;
      a locala2 = new a("SYNTHETIC_CLASS", 3, 3);
      LsM = locala2;
      a locala3 = new a("MULTIFILE_CLASS", 4, 4);
      LsN = locala3;
      a locala4 = new a("MULTIFILE_CLASS_PART", 5, 5);
      LsO = locala4;
      LsP = new a[] { localObject1, localObject2, locala1, locala2, locala3, locala4 };
      LsR = new a((byte)0);
      localObject1 = values();
      localObject2 = (Map)new LinkedHashMap(h.la(ae.agH(localObject1.length), 16));
      int j = localObject1.length;
      while (i < j)
      {
        locala1 = localObject1[i];
        ((Map)localObject2).put(Integer.valueOf(locala1.id), locala1);
        i += 1;
      }
      LsQ = (Map)localObject2;
      AppMethodBeat.o(58278);
    }
    
    private a(int paramInt)
    {
      this.id = paramInt;
    }
    
    public static final a agQ(int paramInt)
    {
      AppMethodBeat.i(58281);
      a locala2 = (a)LsQ.get(Integer.valueOf(paramInt));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = LsJ;
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