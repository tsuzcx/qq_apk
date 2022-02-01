package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.b.aa;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.y;
import d.l.b.a.b.c.a.c;
import d.l.b.a.b.j.f.h;
import d.n.n;

public final class i
{
  public static final b MSf;
  private final d.f MRV;
  private final a MRW;
  private final a MRX;
  private final a MRY;
  private final a MRZ;
  private final a MSa;
  private final a MSb;
  private final a MSc;
  private final a MSd;
  private final aa MSe;
  
  static
  {
    AppMethodBeat.i(56690);
    cwV = new d.l.k[] { (d.l.k)z.a(new x(z.bp(i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)z.a(new x(z.bp(i.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)z.a(new x(z.bp(i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)z.a(new x(z.bp(i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)z.a(new x(z.bp(i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)z.a(new x(z.bp(i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)z.a(new x(z.bp(i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)z.a(new x(z.bp(i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")) };
    MSf = new b((byte)0);
    AppMethodBeat.o(56690);
  }
  
  public i(y paramy, aa paramaa)
  {
    AppMethodBeat.i(56692);
    this.MSe = paramaa;
    this.MRV = g.a(d.k.MKb, (d.g.a.a)new c(paramy));
    this.MRW = new a(1);
    this.MRX = new a(1);
    this.MRY = new a(1);
    this.MRZ = new a(2);
    this.MSa = new a(3);
    this.MSb = new a(1);
    this.MSc = new a(2);
    this.MSd = new a(3);
    AppMethodBeat.o(56692);
  }
  
  public final e ghq()
  {
    AppMethodBeat.i(56691);
    Object localObject1 = this.MRW;
    Object localObject2 = cwV[0];
    p.h(this, "types");
    p.h(localObject2, "property");
    localObject2 = n.capitalize(((d.l.k)localObject2).getName());
    int i = ((a)localObject1).MSg;
    d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.bcE((String)localObject2);
    p.g(localf, "Name.identifier(className)");
    localObject2 = ((h)this.MRV.getValue()).c(localf, (d.l.b.a.b.c.a.a)c.NaW);
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject2 = (e)localObject1;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.MSe.a(new d.l.b.a.b.f.a(j.ghr(), localf), d.a.j.listOf(Integer.valueOf(i)));
    }
    AppMethodBeat.o(56691);
    return localObject1;
  }
  
  static final class a
  {
    final int MSg;
    
    public a(int paramInt)
    {
      this.MSg = paramInt;
    }
  }
  
  public static final class b {}
  
  static final class c
    extends q
    implements d.g.a.a<h>
  {
    c(y paramy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */