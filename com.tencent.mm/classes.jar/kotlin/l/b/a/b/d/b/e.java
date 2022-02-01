package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.ar;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.d.b.a.a.a;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.h.l;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.k.a.k;
import kotlin.r;

public final class e
{
  private static final Set<a.a> aiWA;
  private static final kotlin.l.b.a.b.e.c.a.e aiWB;
  private static final kotlin.l.b.a.b.e.c.a.e aiWC;
  private static final kotlin.l.b.a.b.e.c.a.e aiWD;
  public static final e.a aiWy;
  private static final Set<a.a> aiWz;
  public kotlin.l.b.a.b.k.a.j aiWx;
  
  static
  {
    AppMethodBeat.i(58191);
    aiWy = new e.a((byte)0);
    aiWz = ar.setOf(a.a.aiXK);
    aiWA = ar.setOf(new a.a[] { a.a.aiXL, a.a.aiXO });
    aiWB = new kotlin.l.b.a.b.e.c.a.e(new int[] { 1, 1, 2 });
    aiWC = new kotlin.l.b.a.b.e.c.a.e(new int[] { 1, 1, 11 });
    aiWD = new kotlin.l.b.a.b.e.c.a.e(new int[] { 1, 1, 13 });
    AppMethodBeat.o(58191);
  }
  
  private static String[] a(o paramo, Set<? extends a.a> paramSet)
  {
    AppMethodBeat.i(58190);
    kotlin.l.b.a.b.d.b.a.a locala = paramo.kqo();
    String[] arrayOfString = locala.aiXC;
    paramo = arrayOfString;
    if (arrayOfString == null) {
      paramo = locala.aiXD;
    }
    if ((paramo != null) && (paramSet.contains(locala.aiXA)))
    {
      AppMethodBeat.o(58190);
      return paramo;
    }
    AppMethodBeat.o(58190);
    return null;
  }
  
  private final kotlin.l.b.a.b.k.a.s<kotlin.l.b.a.b.e.c.a.e> b(o paramo)
  {
    AppMethodBeat.i(58187);
    if ((ksK()) || (paramo.kqo().aiXB.axM()))
    {
      AppMethodBeat.o(58187);
      return null;
    }
    paramo = new kotlin.l.b.a.b.k.a.s(paramo.kqo().aiXB, kotlin.l.b.a.b.e.c.a.e.ajef, paramo.dgd(), paramo.kmb());
    AppMethodBeat.o(58187);
    return paramo;
  }
  
  private final boolean c(o paramo)
  {
    AppMethodBeat.i(58188);
    if (((ksJ().ajlX.kzS()) && ((paramo.kqo().ktc()) || (kotlin.g.b.s.p(paramo.kqo().aiXB, aiWB)))) || (d(paramo)))
    {
      AppMethodBeat.o(58188);
      return true;
    }
    AppMethodBeat.o(58188);
    return false;
  }
  
  private final boolean d(o paramo)
  {
    AppMethodBeat.i(58189);
    if ((!ksJ().ajlX.kzR()) && (paramo.kqo().ktc()) && (kotlin.g.b.s.p(paramo.kqo().aiXB, aiWC)))
    {
      AppMethodBeat.o(58189);
      return true;
    }
    AppMethodBeat.o(58189);
    return false;
  }
  
  private final kotlin.l.b.a.b.k.a.b.f e(o paramo)
  {
    AppMethodBeat.i(191952);
    if (!ksJ().ajlX.kzT())
    {
      if (paramo.kqo().ktb())
      {
        paramo = kotlin.l.b.a.b.k.a.b.f.ajnz;
        AppMethodBeat.o(191952);
        return paramo;
      }
      if (paramo.kqo().kta())
      {
        paramo = kotlin.l.b.a.b.k.a.b.f.ajnA;
        AppMethodBeat.o(191952);
        return paramo;
      }
    }
    paramo = kotlin.l.b.a.b.k.a.b.f.ajny;
    AppMethodBeat.o(191952);
    return paramo;
  }
  
  private final boolean ksK()
  {
    AppMethodBeat.i(58184);
    boolean bool = ksJ().ajlX.ksK();
    AppMethodBeat.o(58184);
    return bool;
  }
  
  public final h a(ah paramah, o paramo)
  {
    AppMethodBeat.i(58186);
    kotlin.g.b.s.u(paramah, "descriptor");
    kotlin.g.b.s.u(paramo, "kotlinClass");
    Object localObject1 = a(paramo, aiWA);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58186);
      return null;
    }
    Object localObject3 = paramo.kqo().aiXE;
    if (localObject3 == null)
    {
      AppMethodBeat.o(58186);
      return null;
    }
    try
    {
      localObject1 = kotlin.l.b.a.b.e.c.a.g.g((String[])localObject1, (String[])localObject3);
      if (localObject1 == null)
      {
        AppMethodBeat.o(58186);
        return null;
      }
    }
    catch (l locall)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException(kotlin.g.b.s.X("Could not read data from ", paramo.dgd()), (Throwable)locall);
      AppMethodBeat.o(58186);
      throw localIllegalStateException;
    }
    finally
    {
      for (;;)
      {
        if ((ksK()) || (paramo.kqo().aiXB.axM()))
        {
          AppMethodBeat.o(58186);
          throw localObject2;
        }
        localk = null;
      }
      localObject3 = (kotlin.l.b.a.b.e.c.a.f)localk.bsC;
      a.k localk = (a.k)localk.bsD;
      i locali = new i(paramo, localk, (c)localObject3, b(paramo), c(paramo), e(paramo));
      paramah = (h)new kotlin.l.b.a.b.k.a.b.j(paramah, localk, (c)localObject3, (kotlin.l.b.a.b.e.b.a)paramo.kqo().aiXB, (kotlin.l.b.a.b.k.a.b.g)locali, ksJ(), "scope for " + locali + " in " + paramah, (kotlin.g.a.a)e.b.aiWE);
      AppMethodBeat.o(58186);
    }
    return paramah;
  }
  
  public final kotlin.l.b.a.b.k.a.f a(o paramo)
  {
    AppMethodBeat.i(58185);
    kotlin.g.b.s.u(paramo, "kotlinClass");
    Object localObject1 = a(paramo, aiWz);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58185);
      return null;
    }
    Object localObject3 = paramo.kqo().aiXE;
    if (localObject3 == null)
    {
      AppMethodBeat.o(58185);
      return null;
    }
    try
    {
      localObject1 = kotlin.l.b.a.b.e.c.a.g.f((String[])localObject1, (String[])localObject3);
      if (localObject1 == null)
      {
        AppMethodBeat.o(58185);
        return null;
      }
    }
    catch (l locall)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException(kotlin.g.b.s.X("Could not read data from ", paramo.dgd()), (Throwable)locall);
      AppMethodBeat.o(58185);
      throw localIllegalStateException;
    }
    finally
    {
      for (;;)
      {
        if ((ksK()) || (paramo.kqo().aiXB.axM()))
        {
          AppMethodBeat.o(58185);
          throw localObject2;
        }
        localb = null;
      }
      localObject3 = (kotlin.l.b.a.b.e.c.a.f)localb.bsC;
      a.b localb = (a.b)localb.bsD;
      q localq = new q(paramo, b(paramo), c(paramo), e(paramo));
      paramo = new kotlin.l.b.a.b.k.a.f((c)localObject3, localb, (kotlin.l.b.a.b.e.b.a)paramo.kqo().aiXB, (av)localq);
      AppMethodBeat.o(58185);
    }
    return paramo;
  }
  
  public final kotlin.l.b.a.b.k.a.j ksJ()
  {
    AppMethodBeat.i(58183);
    kotlin.l.b.a.b.k.a.j localj = this.aiWx;
    if (localj != null)
    {
      AppMethodBeat.o(58183);
      return localj;
    }
    kotlin.g.b.s.bIx("components");
    AppMethodBeat.o(58183);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.e
 * JD-Core Version:    0.7.0.1
 */