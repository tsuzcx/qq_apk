package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.p;
import kotlin.g.b.af;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.c.a.d;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.g.h;

public final class j
{
  public static final j.b aiBR;
  private final kotlin.l.b.a.b.b.ag aiBS;
  private final kotlin.j aiBT;
  private final a aiBU;
  private final a aiBV;
  private final a aiBW;
  private final a aiBX;
  private final a aiBY;
  private final a aiBZ;
  private final a aiCa;
  private final a aiCb;
  
  static
  {
    AppMethodBeat.i(56690);
    aYe = new kotlin.l.o[] { (kotlin.l.o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(j.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(j.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(j.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(j.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(j.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(j.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(j.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(j.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")) };
    aiBR = new j.b((byte)0);
    AppMethodBeat.o(56690);
  }
  
  public j(ae paramae, kotlin.l.b.a.b.b.ag paramag)
  {
    AppMethodBeat.i(56692);
    this.aiBS = paramag;
    this.aiBT = kotlin.k.a(kotlin.o.aiuG, (kotlin.g.a.a)new c(paramae));
    this.aiBU = new a(1);
    this.aiBV = new a(1);
    this.aiBW = new a(1);
    this.aiBX = new a(2);
    this.aiBY = new a(3);
    this.aiBZ = new a(1);
    this.aiCa = new a(2);
    this.aiCb = new a(3);
    AppMethodBeat.o(56692);
  }
  
  public final kotlin.l.b.a.b.b.e kmY()
  {
    AppMethodBeat.i(56691);
    Object localObject1 = this.aiBU;
    Object localObject2 = aYe[0];
    s.u(this, "types");
    s.u(localObject2, "property");
    localObject2 = kotlin.l.b.a.b.n.a.a.bJy(((kotlin.l.o)localObject2).getName());
    int i = ((a)localObject1).aiCc;
    localObject2 = f.bJe((String)localObject2);
    s.s(localObject2, "identifier(className)");
    localObject1 = ((h)this.aiBT.getValue()).c((f)localObject2, (kotlin.l.b.a.b.c.a.b)d.aiNC);
    if ((localObject1 instanceof kotlin.l.b.a.b.b.e)) {}
    for (localObject1 = (kotlin.l.b.a.b.b.e)localObject1; localObject1 == null; localObject1 = null)
    {
      localObject1 = this.aiBS.a(new kotlin.l.b.a.b.f.b(k.aiCo, (f)localObject2), p.listOf(Integer.valueOf(i)));
      AppMethodBeat.o(56691);
      return localObject1;
    }
    AppMethodBeat.o(56691);
    return localObject1;
  }
  
  static final class a
  {
    final int aiCc;
    
    public a(int paramInt)
    {
      this.aiCc = paramInt;
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.a<h>
  {
    c(ae paramae)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.j
 * JD-Core Version:    0.7.0.1
 */