package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ab;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.c.y;
import kotlin.l.b.a.b.d.a.c.f;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.d.b.p;
import kotlin.l.b.a.b.l.l;
import kotlin.l.b.a.b.l.m;

public final class h
  extends y
{
  private final kotlin.l.b.a.b.b.a.g aiHM;
  private final kotlin.l.b.a.b.d.a.c.h aiSh;
  private final t aiTn;
  private final kotlin.l.b.a.b.l.h aiTo;
  private final d aiTp;
  public final kotlin.l.b.a.b.l.h<List<kotlin.l.b.a.b.f.c>> aiTq;
  private final kotlin.l.b.a.b.l.h aiTr;
  
  static
  {
    AppMethodBeat.i(57885);
    aYe = new kotlin.l.o[] { (kotlin.l.o)ai.a((af)new ag((kotlin.l.e)ai.cz(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), (kotlin.l.o)ai.a((af)new ag((kotlin.l.e)ai.cz(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;")) };
    AppMethodBeat.o(57885);
  }
  
  public h(kotlin.l.b.a.b.d.a.c.h paramh, t paramt)
  {
    super(paramh.aiSp.aiEx, paramt.koY());
    AppMethodBeat.i(57890);
    this.aiTn = paramt;
    this.aiSh = kotlin.l.b.a.b.d.a.c.a.a(paramh, (kotlin.l.b.a.b.b.g)this, null, 6);
    this.aiTo = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new a(this));
    this.aiTp = new d(this.aiSh, this.aiTn, this);
    this.aiTq = this.aiSh.aiSp.aiBu.a((kotlin.g.a.a)new c(this), (List)ab.aivy);
    if (this.aiSh.aiSp.aiOo.aiPg) {
      paramh = kotlin.l.b.a.b.b.a.g.aiIh;
    }
    for (paramh = g.a.kpB();; paramh = f.a(this.aiSh, (kotlin.l.b.a.b.d.a.e.d)this.aiTn))
    {
      this.aiHM = paramh;
      this.aiTr = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(57890);
      return;
    }
  }
  
  public final kotlin.l.b.a.b.b.e d(kotlin.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57887);
    kotlin.g.b.s.u(paramg, "jClass");
    i locali = this.aiTp.aiSI;
    kotlin.g.b.s.u(paramg, "javaClass");
    paramg = locali.a(paramg.kok(), paramg);
    AppMethodBeat.o(57887);
    return paramg;
  }
  
  public final kotlin.l.b.a.b.b.a.g knl()
  {
    return this.aiHM;
  }
  
  public final av knm()
  {
    AppMethodBeat.i(57889);
    av localav = (av)new p(this);
    AppMethodBeat.o(57889);
    return localav;
  }
  
  public final Map<String, kotlin.l.b.a.b.d.b.o> ksu()
  {
    AppMethodBeat.i(57886);
    Map localMap = (Map)l.a(this.aiTo, aYe[0]);
    AppMethodBeat.o(57886);
    return localMap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57888);
    String str = "Lazy Java package fragment: " + this.aiIl + " of module " + this.aiSh.aiSp.aiEx;
    AppMethodBeat.o(57888);
    return str;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<Map<String, ? extends kotlin.l.b.a.b.d.b.o>>
  {
    a(h paramh)
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.a<HashMap<kotlin.l.b.a.b.j.e.d, kotlin.l.b.a.b.j.e.d>>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.f.c>>
  {
    c(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */