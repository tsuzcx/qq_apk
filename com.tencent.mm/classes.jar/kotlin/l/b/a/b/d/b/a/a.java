package kotlin.l.b.a.b.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.k.i;
import kotlin.l.b.a.b.e.c.a.c;
import kotlin.l.b.a.b.e.c.a.f;

public final class a
{
  public final a aaZb;
  public final f aaZc;
  private final c aaZd;
  public final String[] aaZe;
  public final String[] aaZf;
  public final String[] aaZg;
  private final String aaZh;
  private final int aaZi;
  private final String packageName;
  
  public a(a parama, f paramf, c paramc, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(58283);
    this.aaZb = parama;
    this.aaZc = paramf;
    this.aaZd = paramc;
    this.aaZe = paramArrayOfString1;
    this.aaZf = paramArrayOfString2;
    this.aaZg = paramArrayOfString3;
    this.aaZh = paramString1;
    this.aaZi = paramInt;
    this.packageName = paramString2;
    AppMethodBeat.o(58283);
  }
  
  public final String iIJ()
  {
    String str = this.aaZh;
    if (this.aaZb == a.aaZo) {}
    for (int i = 1; i != 0; i = 0) {
      return str;
    }
    return null;
  }
  
  public final boolean iIK()
  {
    return (this.aaZi & 0x2) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58282);
    String str = this.aaZb + " version=" + this.aaZc;
    AppMethodBeat.o(58282);
    return str;
  }
  
  public static enum a
  {
    private static final Map<Integer, a> aaZq;
    public static final a aaZr;
    private final int id;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(58278);
      Object localObject1 = new a("UNKNOWN", 0, 0);
      aaZj = (a)localObject1;
      Object localObject2 = new a("CLASS", 1, 1);
      aaZk = (a)localObject2;
      a locala1 = new a("FILE_FACADE", 2, 2);
      aaZl = locala1;
      a locala2 = new a("SYNTHETIC_CLASS", 3, 3);
      aaZm = locala2;
      a locala3 = new a("MULTIFILE_CLASS", 4, 4);
      aaZn = locala3;
      a locala4 = new a("MULTIFILE_CLASS_PART", 5, 5);
      aaZo = locala4;
      aaZp = new a[] { localObject1, localObject2, locala1, locala2, locala3, locala4 };
      aaZr = new a((byte)0);
      localObject1 = values();
      localObject2 = (Map)new LinkedHashMap(i.ov(ae.aDD(localObject1.length), 16));
      int j = localObject1.length;
      while (i < j)
      {
        locala1 = localObject1[i];
        ((Map)localObject2).put(Integer.valueOf(locala1.id), locala1);
        i += 1;
      }
      aaZq = (Map)localObject2;
      AppMethodBeat.o(58278);
    }
    
    private a(int paramInt)
    {
      this.id = paramInt;
    }
    
    public static final a aDL(int paramInt)
    {
      AppMethodBeat.i(58281);
      a locala2 = (a)aaZq.get(Integer.valueOf(paramInt));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = aaZj;
      }
      AppMethodBeat.o(58281);
      return locala1;
    }
    
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */