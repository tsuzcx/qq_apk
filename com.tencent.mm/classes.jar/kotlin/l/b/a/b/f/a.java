package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.n.n;

public final class a
{
  private static final a.a ajeo;
  @Deprecated
  private static final f ajet;
  @Deprecated
  private static final c ajeu;
  private final c ajep;
  private final c ajeq;
  private final f ajer;
  private final c ajes;
  
  static
  {
    AppMethodBeat.i(191384);
    ajeo = new a.a((byte)0);
    Object localObject = f.bJg("<local>");
    s.s(localObject, "special(\"<local>\")");
    ajet = (f)localObject;
    localObject = c.s((f)localObject);
    s.s(localObject, "topLevel(LOCAL_NAME)");
    ajeu = (c)localObject;
    AppMethodBeat.o(191384);
  }
  
  private a(c paramc, f paramf)
  {
    AppMethodBeat.i(191382);
    this.ajep = paramc;
    this.ajeq = null;
    this.ajer = paramf;
    this.ajes = null;
    AppMethodBeat.o(191382);
  }
  
  public a(c paramc, f paramf, char paramChar)
  {
    this(paramc, paramf, (byte)0);
    AppMethodBeat.i(191383);
    AppMethodBeat.o(191383);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191387);
    if (this == paramObject)
    {
      AppMethodBeat.o(191387);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(191387);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.ajep, paramObject.ajep))
    {
      AppMethodBeat.o(191387);
      return false;
    }
    if (!s.p(this.ajeq, paramObject.ajeq))
    {
      AppMethodBeat.o(191387);
      return false;
    }
    if (!s.p(this.ajer, paramObject.ajer))
    {
      AppMethodBeat.o(191387);
      return false;
    }
    if (!s.p(this.ajes, paramObject.ajes))
    {
      AppMethodBeat.o(191387);
      return false;
    }
    AppMethodBeat.o(191387);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(191386);
    int k = this.ajep.hashCode();
    int i;
    int m;
    if (this.ajeq == null)
    {
      i = 0;
      m = this.ajer.hashCode();
      if (this.ajes != null) {
        break label74;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(191386);
      return ((i + k * 31) * 31 + m) * 31 + j;
      i = this.ajeq.hashCode();
      break;
      label74:
      j = this.ajes.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191385);
    Object localObject = new StringBuilder();
    String str = this.ajep.PF();
    s.s(str, "packageName.asString()");
    ((StringBuilder)localObject).append(n.a(str, '.', '/'));
    ((StringBuilder)localObject).append("/");
    if (this.ajeq != null)
    {
      ((StringBuilder)localObject).append(this.ajeq);
      ((StringBuilder)localObject).append(".");
    }
    ((StringBuilder)localObject).append(this.ajer);
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(191385);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */