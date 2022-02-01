package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;

public final class g
{
  private final e aiUh;
  private final kotlin.l.b.a.b.l.e aiUv;
  private final j aiUw;
  private final f<a, ad> aiUx;
  
  public g(e parame)
  {
    AppMethodBeat.i(192139);
    this.aiUv = new kotlin.l.b.a.b.l.e("Type parameter upper bound erasion results");
    this.aiUw = kotlin.k.cm((kotlin.g.a.a)new b(this));
    e locale = parame;
    if (parame == null) {
      locale = new e(this);
    }
    this.aiUh = locale;
    parame = this.aiUv.bd((kotlin.g.a.b)new c(this));
    s.s(parame, "storage.createMemoizedFu… isRaw, typeAttr) }\n    }");
    this.aiUx = parame;
    AppMethodBeat.o(192139);
  }
  
  public final ad a(ba paramba, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(192148);
    s.u(paramba, "typeParameter");
    s.u(parama, "typeAttr");
    paramba = (ad)this.aiUx.invoke(new a(paramba, paramBoolean, parama));
    AppMethodBeat.o(192148);
    return paramba;
  }
  
  final ad b(a parama)
  {
    AppMethodBeat.i(192153);
    parama = parama.aiUb;
    if (parama == null) {}
    for (parama = null; parama == null; parama = kotlin.l.b.a.b.m.d.a.aG((ad)parama))
    {
      parama = (al)this.aiUw.getValue();
      s.s(parama, "erroneousErasedBound");
      parama = (ad)parama;
      AppMethodBeat.o(192153);
      return parama;
    }
    AppMethodBeat.o(192153);
    return parama;
  }
  
  static final class a
  {
    final a aiUA;
    final ba aiUy;
    final boolean aiUz;
    
    public a(ba paramba, boolean paramBoolean, a parama)
    {
      AppMethodBeat.i(192142);
      this.aiUy = paramba;
      this.aiUz = paramBoolean;
      this.aiUA = parama;
      AppMethodBeat.o(192142);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(192143);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(192143);
        return false;
      }
      if ((s.p(((a)paramObject).aiUy, this.aiUy)) && (((a)paramObject).aiUz == this.aiUz) && (((a)paramObject).aiUA.aiTY == this.aiUA.aiTY) && (((a)paramObject).aiUA.aiTX == this.aiUA.aiTX) && (((a)paramObject).aiUA.aiTZ == this.aiUA.aiTZ) && (s.p(((a)paramObject).aiUA.aiUb, this.aiUA.aiUb)))
      {
        AppMethodBeat.o(192143);
        return true;
      }
      AppMethodBeat.o(192143);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 1;
      int j = 0;
      AppMethodBeat.i(192149);
      int m = this.aiUy.hashCode();
      if (this.aiUz)
      {
        i = 1;
        i = i + m * 31 + m;
        i += i * 31 + this.aiUA.aiTY.hashCode();
        m = i + (i * 31 + this.aiUA.aiTX.hashCode());
        if (!this.aiUA.aiTZ) {
          break label139;
        }
      }
      label139:
      for (int i = k;; i = 0)
      {
        k = m + (i + m * 31);
        al localal = this.aiUA.aiUb;
        i = j;
        if (localal != null) {
          i = localal.hashCode();
        }
        AppMethodBeat.o(192149);
        return k + (k * 31 + i);
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(192155);
      String str = "DataToEraseUpperBound(typeParameter=" + this.aiUy + ", isRaw=" + this.aiUz + ", typeAttr=" + this.aiUA + ')';
      AppMethodBeat.o(192155);
      return str;
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.a<al>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.b<g.a, ad>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.g
 * JD-Core Version:    0.7.0.1
 */