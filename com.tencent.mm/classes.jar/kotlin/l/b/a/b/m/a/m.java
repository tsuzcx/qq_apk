package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.j.j;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.c.i;

public final class m
  implements l
{
  private final g ajjc;
  private final f ajqU;
  private final j ajro;
  
  public m(g paramg, f paramf)
  {
    AppMethodBeat.i(191679);
    this.ajjc = paramg;
    this.ajqU = paramf;
    paramg = j.g(this.ajjc);
    s.s(paramg, "createWithTypeRefiner(kotlinTypeRefiner)");
    this.ajro = paramg;
    AppMethodBeat.o(191679);
  }
  
  public static boolean a(a parama, bk parambk1, bk parambk2)
  {
    AppMethodBeat.i(191689);
    s.u(parama, "<this>");
    s.u(parambk1, "a");
    s.u(parambk2, "b");
    kotlin.l.b.a.b.m.f localf = kotlin.l.b.a.b.m.f.ajoS;
    boolean bool = kotlin.l.b.a.b.m.f.c((kotlin.l.b.a.b.m.g)parama, (i)parambk1, (i)parambk2);
    AppMethodBeat.o(191689);
    return bool;
  }
  
  public static boolean b(a parama, bk parambk1, bk parambk2)
  {
    AppMethodBeat.i(191693);
    s.u(parama, "<this>");
    s.u(parambk1, "subType");
    s.u(parambk2, "superType");
    kotlin.l.b.a.b.m.f localf = kotlin.l.b.a.b.m.f.ajoS;
    boolean bool = kotlin.l.b.a.b.m.f.b((kotlin.l.b.a.b.m.g)parama, (i)parambk1, (i)parambk2);
    AppMethodBeat.o(191693);
    return bool;
  }
  
  public final boolean d(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(61085);
    s.u(paramad1, "subtype");
    s.u(paramad2, "supertype");
    boolean bool = b(new a(true, false, false, this.ajjc, this.ajqU, null, 38), paramad1.kAK(), paramad2.kAK());
    AppMethodBeat.o(61085);
    return bool;
  }
  
  public final boolean e(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(61086);
    s.u(paramad1, "a");
    s.u(paramad2, "b");
    boolean bool = a(new a(false, false, false, this.ajjc, this.ajqU, null, 38), paramad1.kAK(), paramad2.kAK());
    AppMethodBeat.o(61086);
    return bool;
  }
  
  public final g kAT()
  {
    return this.ajjc;
  }
  
  public final j kAU()
  {
    return this.ajro;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.m
 * JD-Core Version:    0.7.0.1
 */