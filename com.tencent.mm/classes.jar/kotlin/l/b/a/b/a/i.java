package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.c.a.c;
import kotlin.l.b.a.b.j.f.h;
import kotlin.n.n;

public final class i
{
  public static final b TeS;
  private final kotlin.f TeI;
  private final a TeJ;
  private final a TeK;
  private final a TeL;
  private final a TeM;
  private final a TeN;
  private final a TeO;
  private final a TeP;
  private final a TeQ;
  private final kotlin.l.b.a.b.b.aa TeR;
  
  static
  {
    AppMethodBeat.i(56690);
    cLI = new kotlin.l.k[] { (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(i.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")) };
    TeS = new b((byte)0);
    AppMethodBeat.o(56690);
  }
  
  public i(kotlin.l.b.a.b.b.y paramy, kotlin.l.b.a.b.b.aa paramaa)
  {
    AppMethodBeat.i(56692);
    this.TeR = paramaa;
    this.TeI = g.a(kotlin.k.SWQ, (kotlin.g.a.a)new c(paramy));
    this.TeJ = new a(1);
    this.TeK = new a(1);
    this.TeL = new a(1);
    this.TeM = new a(2);
    this.TeN = new a(3);
    this.TeO = new a(1);
    this.TeP = new a(2);
    this.TeQ = new a(3);
    AppMethodBeat.o(56692);
  }
  
  public final e hzv()
  {
    AppMethodBeat.i(56691);
    Object localObject1 = this.TeJ;
    Object localObject2 = cLI[0];
    p.h(this, "types");
    p.h(localObject2, "property");
    localObject2 = n.capitalize(((kotlin.l.k)localObject2).getName());
    int i = ((a)localObject1).TeT;
    kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.btY((String)localObject2);
    p.g(localf, "Name.identifier(className)");
    localObject2 = ((h)this.TeI.getValue()).c(localf, (kotlin.l.b.a.b.c.a.a)c.TnJ);
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject2 = (e)localObject1;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.TeR.a(new kotlin.l.b.a.b.f.a(j.hzw(), localf), kotlin.a.j.listOf(Integer.valueOf(i)));
    }
    AppMethodBeat.o(56691);
    return localObject1;
  }
  
  static final class a
  {
    final int TeT;
    
    public a(int paramInt)
    {
      this.TeT = paramInt;
    }
  }
  
  public static final class b {}
  
  static final class c
    extends q
    implements kotlin.g.a.a<h>
  {
    c(kotlin.l.b.a.b.b.y paramy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */