package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.k;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.c.a.c;
import kotlin.l.b.a.b.j.f.h;

public final class i
{
  public static final b aaHM;
  private final kotlin.f aaHC;
  private final a aaHD;
  private final a aaHE;
  private final a aaHF;
  private final a aaHG;
  private final a aaHH;
  private final a aaHI;
  private final a aaHJ;
  private final a aaHK;
  private final aa aaHL;
  
  static
  {
    AppMethodBeat.i(56690);
    cMt = new kotlin.l.n[] { (kotlin.l.n)ab.a(new z(ab.bO(i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.n)ab.a(new z(ab.bO(i.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.n)ab.a(new z(ab.bO(i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.n)ab.a(new z(ab.bO(i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.n)ab.a(new z(ab.bO(i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.n)ab.a(new z(ab.bO(i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.n)ab.a(new z(ab.bO(i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.n)ab.a(new z(ab.bO(i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")) };
    aaHM = new b((byte)0);
    AppMethodBeat.o(56690);
  }
  
  public i(y paramy, aa paramaa)
  {
    AppMethodBeat.i(56692);
    this.aaHL = paramaa;
    this.aaHC = g.a(k.aazC, (kotlin.g.a.a)new c(paramy));
    this.aaHD = new a(1);
    this.aaHE = new a(1);
    this.aaHF = new a(1);
    this.aaHG = new a(2);
    this.aaHH = new a(3);
    this.aaHI = new a(1);
    this.aaHJ = new a(2);
    this.aaHK = new a(3);
    AppMethodBeat.o(56692);
  }
  
  public final e iDH()
  {
    AppMethodBeat.i(56691);
    Object localObject1 = this.aaHD;
    Object localObject2 = cMt[0];
    p.k(this, "types");
    p.k(localObject2, "property");
    localObject2 = kotlin.n.n.capitalize(((kotlin.l.n)localObject2).getName());
    int i = ((a)localObject1).aaHN;
    kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.bHb((String)localObject2);
    p.j(localf, "Name.identifier(className)");
    localObject2 = ((h)this.aaHC.getValue()).c(localf, (kotlin.l.b.a.b.c.a.a)c.aaQD);
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject2 = (e)localObject1;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.aaHL.a(new kotlin.l.b.a.b.f.a(j.iDI(), localf), kotlin.a.j.listOf(Integer.valueOf(i)));
    }
    AppMethodBeat.o(56691);
    return localObject1;
  }
  
  static final class a
  {
    final int aaHN;
    
    public a(int paramInt)
    {
      this.aaHN = paramInt;
    }
  }
  
  public static final class b {}
  
  static final class c
    extends q
    implements kotlin.g.a.a<h>
  {
    c(y paramy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */