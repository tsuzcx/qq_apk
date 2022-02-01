package kotlin.l.b.a.b.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.k.j;
import kotlin.l.b.a.b.e.c.a.c;
import kotlin.l.b.a.b.e.c.a.f;

public final class a
{
  public final a Twl;
  public final f Twm;
  private final c Twn;
  public final String[] Two;
  public final String[] Twp;
  private final String Twq;
  private final int Twr;
  private final String packageName;
  public final String[] strings;
  
  public a(a parama, f paramf, c paramc, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(58283);
    this.Twl = parama;
    this.Twm = paramf;
    this.Twn = paramc;
    this.Two = paramArrayOfString1;
    this.Twp = paramArrayOfString2;
    this.strings = paramArrayOfString3;
    this.Twq = paramString1;
    this.Twr = paramInt;
    this.packageName = paramString2;
    AppMethodBeat.o(58283);
  }
  
  public final String hEp()
  {
    String str = this.Twq;
    if (this.Twl == a.Twx) {}
    for (int i = 1; i != 0; i = 0) {
      return str;
    }
    return null;
  }
  
  public final boolean hEq()
  {
    return (this.Twr & 0x2) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58282);
    String str = this.Twl + " version=" + this.Twm;
    AppMethodBeat.o(58282);
    return str;
  }
  
  public static enum a
  {
    public static final a TwA;
    private static final Map<Integer, a> Twz;
    private final int id;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(58278);
      Object localObject1 = new a("UNKNOWN", 0, 0);
      Tws = (a)localObject1;
      Object localObject2 = new a("CLASS", 1, 1);
      Twt = (a)localObject2;
      a locala1 = new a("FILE_FACADE", 2, 2);
      Twu = locala1;
      a locala2 = new a("SYNTHETIC_CLASS", 3, 3);
      Twv = locala2;
      a locala3 = new a("MULTIFILE_CLASS", 4, 4);
      Tww = locala3;
      a locala4 = new a("MULTIFILE_CLASS_PART", 5, 5);
      Twx = locala4;
      Twy = new a[] { localObject1, localObject2, locala1, locala2, locala3, locala4 };
      TwA = new a((byte)0);
      localObject1 = values();
      localObject2 = (Map)new LinkedHashMap(j.mZ(ae.atJ(localObject1.length), 16));
      int j = localObject1.length;
      while (i < j)
      {
        locala1 = localObject1[i];
        ((Map)localObject2).put(Integer.valueOf(locala1.id), locala1);
        i += 1;
      }
      Twz = (Map)localObject2;
      AppMethodBeat.o(58278);
    }
    
    private a(int paramInt)
    {
      this.id = paramInt;
    }
    
    public static final a atR(int paramInt)
    {
      AppMethodBeat.i(58281);
      a locala2 = (a)Twz.get(Integer.valueOf(paramInt));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = Tws;
      }
      AppMethodBeat.o(58281);
      return locala1;
    }
    
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */