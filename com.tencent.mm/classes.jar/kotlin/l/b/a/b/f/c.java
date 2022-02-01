package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class c
{
  public static final c ajew;
  public final d ajex;
  private transient c ajey;
  
  static
  {
    AppMethodBeat.i(59295);
    ajew = new c("");
    AppMethodBeat.o(59295);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(59280);
    this.ajex = new d(paramString, this);
    AppMethodBeat.o(59280);
  }
  
  public c(d paramd)
  {
    AppMethodBeat.i(59281);
    this.ajex = paramd;
    AppMethodBeat.o(59281);
  }
  
  private c(d paramd, c paramc)
  {
    AppMethodBeat.i(59282);
    this.ajex = paramd;
    this.ajey = paramc;
    AppMethodBeat.o(59282);
  }
  
  public static c s(f paramf)
  {
    AppMethodBeat.i(59291);
    if (paramf == null) {
      aKu(13);
    }
    paramf = new c(d.u(paramf));
    AppMethodBeat.o(59291);
    return paramf;
  }
  
  public final String PF()
  {
    AppMethodBeat.i(59283);
    String str = this.ajex.PF();
    if (str == null) {
      aKu(4);
    }
    AppMethodBeat.o(59283);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59293);
    if (this == paramObject)
    {
      AppMethodBeat.o(59293);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(59293);
      return false;
    }
    paramObject = (c)paramObject;
    if (!this.ajex.equals(paramObject.ajex))
    {
      AppMethodBeat.o(59293);
      return false;
    }
    AppMethodBeat.o(59293);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59294);
    int i = this.ajex.hashCode();
    AppMethodBeat.o(59294);
    return i;
  }
  
  public final boolean isRoot()
  {
    AppMethodBeat.i(369488);
    boolean bool = this.ajex.ajeC.isEmpty();
    AppMethodBeat.o(369488);
    return bool;
  }
  
  public final d kxR()
  {
    AppMethodBeat.i(59284);
    d locald = this.ajex;
    if (locald == null) {
      aKu(5);
    }
    AppMethodBeat.o(59284);
    return locald;
  }
  
  public final c kxS()
  {
    AppMethodBeat.i(59286);
    if (this.ajey != null)
    {
      localObject = this.ajey;
      if (localObject == null) {
        aKu(6);
      }
      AppMethodBeat.o(59286);
      return localObject;
    }
    if (isRoot())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59286);
      throw ((Throwable)localObject);
    }
    this.ajey = new c(this.ajex.kxY());
    Object localObject = this.ajey;
    if (localObject == null) {
      aKu(7);
    }
    AppMethodBeat.o(59286);
    return localObject;
  }
  
  public final f kxT()
  {
    AppMethodBeat.i(59288);
    f localf = this.ajex.kxT();
    if (localf == null) {
      aKu(9);
    }
    AppMethodBeat.o(59288);
    return localf;
  }
  
  public final f kxU()
  {
    AppMethodBeat.i(59289);
    f localf = this.ajex.kxU();
    if (localf == null) {
      aKu(10);
    }
    AppMethodBeat.o(59289);
    return localf;
  }
  
  public final List<f> kxV()
  {
    AppMethodBeat.i(191396);
    List localList = this.ajex.kxV();
    if (localList == null) {
      aKu(11);
    }
    AppMethodBeat.o(191396);
    return localList;
  }
  
  public final c q(f paramf)
  {
    AppMethodBeat.i(59287);
    if (paramf == null) {
      aKu(8);
    }
    paramf = new c(this.ajex.t(paramf), this);
    AppMethodBeat.o(59287);
    return paramf;
  }
  
  public final boolean r(f paramf)
  {
    AppMethodBeat.i(59290);
    if (paramf == null) {
      aKu(12);
    }
    boolean bool = this.ajex.r(paramf);
    AppMethodBeat.o(59290);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59292);
    String str = this.ajex.toString();
    AppMethodBeat.o(59292);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.f.c
 * JD-Core Version:    0.7.0.1
 */