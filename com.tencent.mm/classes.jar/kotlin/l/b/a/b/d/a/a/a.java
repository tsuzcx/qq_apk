package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.g;
import kotlin.l.b.a.b.j.i;
import kotlin.l.b.a.b.k.a.r;
import kotlin.x;

public final class a
{
  public static <D extends kotlin.l.b.a.b.b.b> Collection<D> a(f paramf, Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, r paramr, i parami)
  {
    AppMethodBeat.i(57648);
    if (paramf == null) {
      atM(0);
    }
    if (paramCollection1 == null) {
      atM(1);
    }
    if (paramCollection2 == null) {
      atM(2);
    }
    if (parame == null) {
      atM(3);
    }
    if (paramr == null) {
      atM(4);
    }
    if (parami == null) {
      atM(5);
    }
    paramf = a(paramf, paramCollection1, paramCollection2, parame, paramr, parami, false);
    AppMethodBeat.o(57648);
    return paramf;
  }
  
  private static <D extends kotlin.l.b.a.b.b.b> Collection<D> a(f paramf, Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, r paramr, i parami, final boolean paramBoolean)
  {
    AppMethodBeat.i(57650);
    if (paramf == null) {
      atM(12);
    }
    if (paramCollection1 == null) {
      atM(13);
    }
    if (paramCollection2 == null) {
      atM(14);
    }
    if (parame == null) {
      atM(15);
    }
    if (paramr == null) {
      atM(16);
    }
    if (parami == null) {
      atM(17);
    }
    final LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    parami.a(paramf, paramCollection1, paramCollection2, parame, new g()
    {
      public final void a(kotlin.l.b.a.b.b.b paramAnonymousb, Collection<? extends kotlin.l.b.a.b.b.b> paramAnonymousCollection)
      {
        AppMethodBeat.i(57646);
        if (paramAnonymousb == null) {
          atM(3);
        }
        if (paramAnonymousCollection == null) {
          atM(4);
        }
        if ((paramBoolean) && (paramAnonymousb.hAA() != b.a.TgX))
        {
          AppMethodBeat.o(57646);
          return;
        }
        super.a(paramAnonymousb, paramAnonymousCollection);
        AppMethodBeat.o(57646);
      }
      
      public final void a(kotlin.l.b.a.b.b.b paramAnonymousb1, kotlin.l.b.a.b.b.b paramAnonymousb2)
      {
        AppMethodBeat.i(57645);
        if (paramAnonymousb1 == null) {
          atM(1);
        }
        if (paramAnonymousb2 == null) {
          atM(2);
        }
        AppMethodBeat.o(57645);
      }
      
      public final void e(kotlin.l.b.a.b.b.b paramAnonymousb)
      {
        AppMethodBeat.i(57644);
        if (paramAnonymousb == null) {
          atM(0);
        }
        i.a(paramAnonymousb, new kotlin.g.a.b() {});
        localLinkedHashSet.add(paramAnonymousb);
        AppMethodBeat.o(57644);
      }
    });
    AppMethodBeat.o(57650);
    return localLinkedHashSet;
  }
  
  public static <D extends kotlin.l.b.a.b.b.b> Collection<D> b(f paramf, Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, r paramr, i parami)
  {
    AppMethodBeat.i(57649);
    if (paramf == null) {
      atM(6);
    }
    if (paramCollection1 == null) {
      atM(7);
    }
    if (paramCollection2 == null) {
      atM(8);
    }
    if (parame == null) {
      atM(9);
    }
    if (paramr == null) {
      atM(10);
    }
    if (parami == null) {
      atM(11);
    }
    paramf = a(paramf, paramCollection1, paramCollection2, parame, paramr, parami, true);
    AppMethodBeat.o(57649);
    return paramf;
  }
  
  public static av b(f paramf, e parame)
  {
    AppMethodBeat.i(57651);
    if (paramf == null) {
      atM(19);
    }
    if (parame == null) {
      atM(20);
    }
    parame = parame.hxW();
    if (parame.size() != 1)
    {
      AppMethodBeat.o(57651);
      return null;
    }
    parame = ((d)parame.iterator().next()).hAw().iterator();
    while (parame.hasNext())
    {
      av localav = (av)parame.next();
      if (localav.hAH().equals(paramf))
      {
        AppMethodBeat.o(57651);
        return localav;
      }
    }
    AppMethodBeat.o(57651);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */