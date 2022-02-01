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
  public static final b JnQ;
  private final d.f JnG;
  private final a JnH;
  private final a JnI;
  private final a JnJ;
  private final a JnK;
  private final a JnL;
  private final a JnM;
  private final a JnN;
  private final a JnO;
  private final aa JnP;
  
  static
  {
    AppMethodBeat.i(56690);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(i.class), "kotlinReflectScope", "getKotlinReflectScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), (d.l.k)w.a(new u(w.bk(i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bk(i.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bk(i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bk(i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bk(i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bk(i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bk(i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)w.a(new u(w.bk(i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")) };
    JnQ = new b((byte)0);
    AppMethodBeat.o(56690);
  }
  
  public i(y paramy, aa paramaa)
  {
    AppMethodBeat.i(56692);
    this.JnP = paramaa;
    this.JnG = g.a(d.k.JfJ, (d.g.a.a)new c(paramy));
    this.JnH = new a(1);
    this.JnI = new a(1);
    this.JnJ = new a(1);
    this.JnK = new a(2);
    this.JnL = new a(3);
    this.JnM = new a(1);
    this.JnN = new a(2);
    this.JnO = new a(3);
    AppMethodBeat.o(56692);
  }
  
  public final e fxo()
  {
    AppMethodBeat.i(56691);
    Object localObject1 = this.JnH;
    Object localObject2 = $$delegatedProperties[1];
    d.g.b.k.h(this, "types");
    d.g.b.k.h(localObject2, "property");
    localObject2 = n.capitalize(((d.l.k)localObject2).getName());
    int i = ((a)localObject1).JnR;
    d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.aQC((String)localObject2);
    d.g.b.k.g(localf, "Name.identifier(className)");
    localObject2 = ((h)this.JnG.getValue()).c(localf, (d.l.b.a.b.c.a.a)c.JwG);
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject2 = (e)localObject1;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.JnP.a(new d.l.b.a.b.f.a(j.fxp(), localf), d.a.j.listOf(Integer.valueOf(i)));
    }
    AppMethodBeat.o(56691);
    return localObject1;
  }
  
  static final class a
  {
    final int JnR;
    
    public a(int paramInt)
    {
      this.JnR = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */