package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.a.d;
import kotlin.g.b.s;

public final class bh
{
  private static final Map<bi, Integer> aiGM;
  public static final bh aiHA;
  private static final h aiHB;
  
  static
  {
    AppMethodBeat.i(56922);
    aiHA = new bh();
    Map localMap = (Map)new d();
    localMap.put(f.aiHH, Integer.valueOf(0));
    localMap.put(e.aiHG, Integer.valueOf(0));
    localMap.put(b.aiHD, Integer.valueOf(1));
    localMap.put(g.aiHI, Integer.valueOf(1));
    localMap.put(h.aiHJ, Integer.valueOf(2));
    s.u(localMap, "builder");
    aiGM = ((d)localMap).klb();
    aiHB = h.aiHJ;
    AppMethodBeat.o(56922);
  }
  
  public static Integer a(bi parambi1, bi parambi2)
  {
    AppMethodBeat.i(191794);
    s.u(parambi1, "first");
    s.u(parambi2, "second");
    if (parambi1 == parambi2)
    {
      AppMethodBeat.o(191794);
      return Integer.valueOf(0);
    }
    parambi1 = (Integer)aiGM.get(parambi1);
    parambi2 = (Integer)aiGM.get(parambi2);
    if ((parambi1 == null) || (parambi2 == null) || (s.p(parambi1, parambi2)))
    {
      AppMethodBeat.o(191794);
      return null;
    }
    int i = parambi1.intValue();
    int j = parambi2.intValue();
    AppMethodBeat.o(191794);
    return Integer.valueOf(i - j);
  }
  
  public static boolean b(bi parambi)
  {
    AppMethodBeat.i(56921);
    s.u(parambi, "visibility");
    if ((parambi == e.aiHG) || (parambi == f.aiHH))
    {
      AppMethodBeat.o(56921);
      return true;
    }
    AppMethodBeat.o(56921);
    return false;
  }
  
  public static final class a
    extends bi
  {
    public static final a aiHC;
    
    static
    {
      AppMethodBeat.i(191830);
      aiHC = new a();
      AppMethodBeat.o(191830);
    }
    
    private a()
    {
      super(false);
    }
  }
  
  public static final class b
    extends bi
  {
    public static final b aiHD;
    
    static
    {
      AppMethodBeat.i(191835);
      aiHD = new b();
      AppMethodBeat.o(191835);
    }
    
    private b()
    {
      super(false);
    }
  }
  
  public static final class c
    extends bi
  {
    public static final c aiHE;
    
    static
    {
      AppMethodBeat.i(191831);
      aiHE = new c();
      AppMethodBeat.o(191831);
    }
    
    private c()
    {
      super(false);
    }
  }
  
  public static final class d
    extends bi
  {
    public static final d aiHF;
    
    static
    {
      AppMethodBeat.i(191832);
      aiHF = new d();
      AppMethodBeat.o(191832);
    }
    
    private d()
    {
      super(false);
    }
  }
  
  public static final class e
    extends bi
  {
    public static final e aiHG;
    
    static
    {
      AppMethodBeat.i(191825);
      aiHG = new e();
      AppMethodBeat.o(191825);
    }
    
    private e()
    {
      super(false);
    }
  }
  
  public static final class f
    extends bi
  {
    public static final f aiHH;
    
    static
    {
      AppMethodBeat.i(191826);
      aiHH = new f();
      AppMethodBeat.o(191826);
    }
    
    private f()
    {
      super(false);
    }
    
    public final String koC()
    {
      return "private/*private to this*/";
    }
  }
  
  public static final class g
    extends bi
  {
    public static final g aiHI;
    
    static
    {
      AppMethodBeat.i(191828);
      aiHI = new g();
      AppMethodBeat.o(191828);
    }
    
    private g()
    {
      super(true);
    }
  }
  
  public static final class h
    extends bi
  {
    public static final h aiHJ;
    
    static
    {
      AppMethodBeat.i(191824);
      aiHJ = new h();
      AppMethodBeat.o(191824);
    }
    
    private h()
    {
      super(true);
    }
  }
  
  public static final class i
    extends bi
  {
    public static final i aiHK;
    
    static
    {
      AppMethodBeat.i(191827);
      aiHK = new i();
      AppMethodBeat.o(191827);
    }
    
    private i()
    {
      super(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.bh
 * JD-Core Version:    0.7.0.1
 */