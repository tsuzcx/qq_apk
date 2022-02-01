package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g;
import d.g.b.l;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.b.aa;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.y;
import d.l.b.a.b.c.a.c;
import d.l.b.a.b.j.f.h;
import d.n.n;

public final class i
{
  public static final b Lbk;
  private final d.f Lba;
  private final a Lbb;
  private final a Lbc;
  private final a Lbd;
  private final a Lbe;
  private final a Lbf;
  private final a Lbg;
  private final a Lbh;
  private final a Lbi;
  private final aa Lbj;
  
  static
  {
    AppMethodBeat.i(56690);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(i.class), "kotlinReflectScope", "getKotlinReflectScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), (d.l.k)w.a(new u(w.bn(i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bn(i.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bn(i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bn(i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bn(i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bn(i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bn(i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bn(i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")) };
    Lbk = new b((byte)0);
    AppMethodBeat.o(56690);
  }
  
  public i(y paramy, aa paramaa)
  {
    AppMethodBeat.i(56692);
    this.Lbj = paramaa;
    this.Lba = g.a(d.k.KTd, (d.g.a.a)new c(paramy));
    this.Lbb = new a(1);
    this.Lbc = new a(1);
    this.Lbd = new a(1);
    this.Lbe = new a(2);
    this.Lbf = new a(3);
    this.Lbg = new a(1);
    this.Lbh = new a(2);
    this.Lbi = new a(3);
    AppMethodBeat.o(56692);
  }
  
  public final e fPS()
  {
    AppMethodBeat.i(56691);
    Object localObject1 = this.Lbb;
    Object localObject2 = $$delegatedProperties[1];
    d.g.b.k.h(this, "types");
    d.g.b.k.h(localObject2, "property");
    localObject2 = n.capitalize(((d.l.k)localObject2).getName());
    int i = ((a)localObject1).Lbl;
    d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.aWB((String)localObject2);
    d.g.b.k.g(localf, "Name.identifier(className)");
    localObject2 = ((h)this.Lba.getValue()).c(localf, (d.l.b.a.b.c.a.a)c.LjZ);
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject2 = (e)localObject1;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.Lbj.a(new d.l.b.a.b.f.a(j.fPT(), localf), d.a.j.listOf(Integer.valueOf(i)));
    }
    AppMethodBeat.o(56691);
    return localObject1;
  }
  
  static final class a
  {
    final int Lbl;
    
    public a(int paramInt)
    {
      this.Lbl = paramInt;
    }
  }
  
  public static final class b {}
  
  static final class c
    extends l
    implements d.g.a.a<h>
  {
    c(y paramy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */