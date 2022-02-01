package kotlin.l.b.a.b.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ak;
import kotlin.k.k;
import kotlin.l.b.a.b.e.c.a.e;

public final class a
{
  public final a aiXA;
  public final e aiXB;
  public final String[] aiXC;
  public final String[] aiXD;
  public final String[] aiXE;
  private final String aiXF;
  private final int aiXG;
  private final String packageName;
  
  public a(a parama, e parame, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(191953);
    this.aiXA = parama;
    this.aiXB = parame;
    this.aiXC = paramArrayOfString1;
    this.aiXD = paramArrayOfString2;
    this.aiXE = paramArrayOfString3;
    this.aiXF = paramString1;
    this.aiXG = paramInt;
    this.packageName = paramString2;
    AppMethodBeat.o(191953);
  }
  
  private static boolean qw(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public final String ksZ()
  {
    String str = this.aiXF;
    if (this.aiXA == a.aiXO) {}
    for (int i = 1; i != 0; i = 0) {
      return str;
    }
    return null;
  }
  
  public final boolean kta()
  {
    AppMethodBeat.i(191958);
    if ((qw(this.aiXG, 16)) && (!qw(this.aiXG, 32)))
    {
      AppMethodBeat.o(191958);
      return true;
    }
    AppMethodBeat.o(191958);
    return false;
  }
  
  public final boolean ktb()
  {
    AppMethodBeat.i(191962);
    if ((qw(this.aiXG, 64)) && (!qw(this.aiXG, 32)))
    {
      AppMethodBeat.o(191962);
      return true;
    }
    AppMethodBeat.o(191962);
    return false;
  }
  
  public final boolean ktc()
  {
    AppMethodBeat.i(191966);
    boolean bool = qw(this.aiXG, 2);
    AppMethodBeat.o(191966);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58282);
    String str = this.aiXA + " version=" + this.aiXB;
    AppMethodBeat.o(58282);
    return str;
  }
  
  public static enum a
  {
    public static final a.a.a aiXH;
    private static final Map<Integer, a> aiXI;
    private final int id;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(58278);
      aiXJ = new a("UNKNOWN", 0, 0);
      aiXK = new a("CLASS", 1, 1);
      aiXL = new a("FILE_FACADE", 2, 2);
      aiXM = new a("SYNTHETIC_CLASS", 3, 3);
      aiXN = new a("MULTIFILE_CLASS", 4, 4);
      aiXO = new a("MULTIFILE_CLASS_PART", 5, 5);
      aiXP = new a[] { aiXJ, aiXK, aiXL, aiXM, aiXN, aiXO };
      aiXH = new a.a.a((byte)0);
      a[] arrayOfa = values();
      Map localMap = (Map)new LinkedHashMap(k.qu(ak.aKi(arrayOfa.length), 16));
      int j = arrayOfa.length;
      while (i < j)
      {
        a locala = arrayOfa[i];
        localMap.put(Integer.valueOf(locala.id), locala);
        i += 1;
      }
      aiXI = localMap;
      AppMethodBeat.o(58278);
    }
    
    private a(int paramInt)
    {
      this.id = paramInt;
    }
    
    public static final a aKA(int paramInt)
    {
      AppMethodBeat.i(58281);
      a locala = (a)aiXI.get(Integer.valueOf(paramInt));
      if (locala == null)
      {
        locala = aiXJ;
        AppMethodBeat.o(58281);
        return locala;
      }
      AppMethodBeat.o(58281);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */