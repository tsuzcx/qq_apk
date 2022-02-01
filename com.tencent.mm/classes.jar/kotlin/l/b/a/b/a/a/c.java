package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k;
import kotlin.l.b.a.b.f.f;
import kotlin.n.n;

public enum c
{
  public static final a aiEH;
  public final kotlin.l.b.a.b.f.c aiEI;
  public final String aiEJ;
  private final boolean aiEK;
  private final boolean aiEL;
  
  static
  {
    AppMethodBeat.i(191445);
    aiEM = new c("Function", 0, k.aiCr, "Function", false, false);
    aiEN = new c("SuspendFunction", 1, k.aiCi, "SuspendFunction", true, false);
    aiEO = new c("KFunction", 2, k.aiCo, "KFunction", false, true);
    aiEP = new c("KSuspendFunction", 3, k.aiCo, "KSuspendFunction", true, true);
    aiEQ = new c[] { aiEM, aiEN, aiEO, aiEP };
    aiEH = new a((byte)0);
    AppMethodBeat.o(191445);
  }
  
  private c(kotlin.l.b.a.b.f.c paramc, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aiEI = paramc;
    this.aiEJ = paramString;
    this.aiEK = paramBoolean1;
    this.aiEL = paramBoolean2;
  }
  
  public final f aKz(int paramInt)
  {
    AppMethodBeat.i(191451);
    f localf = f.bJe(s.X(this.aiEJ, Integer.valueOf(paramInt)));
    s.s(localf, "identifier(\"$classNamePrefix$arity\")");
    AppMethodBeat.o(191451);
    return localf;
  }
  
  public static final class a
  {
    public static c.a.a a(String paramString, kotlin.l.b.a.b.f.c paramc)
    {
      AppMethodBeat.i(191439);
      s.u(paramString, "className");
      s.u(paramc, "packageFqName");
      paramc = a(paramc, paramString);
      if (paramc == null)
      {
        AppMethodBeat.o(191439);
        return null;
      }
      paramString = paramString.substring(paramc.aiEJ.length());
      s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = bIJ(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(191439);
        return null;
      }
      paramString = new c.a.a(paramc, paramString.intValue());
      AppMethodBeat.o(191439);
      return paramString;
    }
    
    private static c a(kotlin.l.b.a.b.f.c paramc, String paramString)
    {
      AppMethodBeat.i(191434);
      s.u(paramc, "packageFqName");
      s.u(paramString, "className");
      c[] arrayOfc = c.values();
      int k = arrayOfc.length;
      int i = 0;
      while (i < k)
      {
        c localc = arrayOfc[i];
        if ((s.p(localc.aiEI, paramc)) && (n.U(paramString, localc.aiEJ, false))) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(191434);
          return localc;
        }
        i += 1;
      }
      AppMethodBeat.o(191434);
      return null;
    }
    
    public static c b(String paramString, kotlin.l.b.a.b.f.c paramc)
    {
      AppMethodBeat.i(191443);
      s.u(paramString, "className");
      s.u(paramc, "packageFqName");
      paramString = a(paramString, paramc);
      if (paramString == null)
      {
        AppMethodBeat.o(191443);
        return null;
      }
      paramString = paramString.aiER;
      AppMethodBeat.o(191443);
      return paramString;
    }
    
    private static Integer bIJ(String paramString)
    {
      AppMethodBeat.i(191448);
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(191448);
        return null;
      }
      int m = paramString.length();
      int j = 0;
      int k = 0;
      while (j < m)
      {
        int n = paramString.charAt(j) - '0';
        if (n >= 0) {
          if (n <= 9) {
            i = 1;
          }
        }
        while (i == 0)
        {
          AppMethodBeat.o(191448);
          return null;
          i = 0;
          continue;
          i = 0;
        }
        k = k * 10 + n;
        j += 1;
      }
      AppMethodBeat.o(191448);
      return Integer.valueOf(k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */