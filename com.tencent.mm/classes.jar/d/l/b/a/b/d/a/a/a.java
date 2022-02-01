package d.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.d;
import d.l.b.a.b.b.e;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.g;
import d.l.b.a.b.j.i;
import d.l.b.a.b.k.a.r;
import d.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class a
{
  public static <D extends d.l.b.a.b.b.b> Collection<D> a(f paramf, Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, r paramr, i parami)
  {
    AppMethodBeat.i(57648);
    if (paramf == null) {
      adP(0);
    }
    if (paramCollection1 == null) {
      adP(1);
    }
    if (paramCollection2 == null) {
      adP(2);
    }
    if (parame == null) {
      adP(3);
    }
    if (paramr == null) {
      adP(4);
    }
    if (parami == null) {
      adP(5);
    }
    paramf = a(paramf, paramCollection1, paramCollection2, parame, paramr, parami, false);
    AppMethodBeat.o(57648);
    return paramf;
  }
  
  private static <D extends d.l.b.a.b.b.b> Collection<D> a(f paramf, Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, r paramr, i parami, final boolean paramBoolean)
  {
    AppMethodBeat.i(57650);
    if (paramf == null) {
      adP(12);
    }
    if (paramCollection1 == null) {
      adP(13);
    }
    if (paramCollection2 == null) {
      adP(14);
    }
    if (parame == null) {
      adP(15);
    }
    if (paramr == null) {
      adP(16);
    }
    if (parami == null) {
      adP(17);
    }
    final LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    parami.a(paramf, paramCollection1, paramCollection2, parame, new g()
    {
      public final void a(d.l.b.a.b.b.b paramAnonymousb1, d.l.b.a.b.b.b paramAnonymousb2)
      {
        AppMethodBeat.i(57645);
        if (paramAnonymousb1 == null) {
          adP(1);
        }
        if (paramAnonymousb2 == null) {
          adP(2);
        }
        AppMethodBeat.o(57645);
      }
      
      public final void a(d.l.b.a.b.b.b paramAnonymousb, Collection<? extends d.l.b.a.b.b.b> paramAnonymousCollection)
      {
        AppMethodBeat.i(57646);
        if (paramAnonymousb == null) {
          adP(3);
        }
        if (paramAnonymousCollection == null) {
          adP(4);
        }
        if ((paramBoolean) && (paramAnonymousb.fyu() != b.a.JpW))
        {
          AppMethodBeat.o(57646);
          return;
        }
        super.a(paramAnonymousb, paramAnonymousCollection);
        AppMethodBeat.o(57646);
      }
      
      public final void e(d.l.b.a.b.b.b paramAnonymousb)
      {
        AppMethodBeat.i(57644);
        if (paramAnonymousb == null) {
          adP(0);
        }
        i.a(paramAnonymousb, new d.g.a.b() {});
        localLinkedHashSet.add(paramAnonymousb);
        AppMethodBeat.o(57644);
      }
    });
    AppMethodBeat.o(57650);
    return localLinkedHashSet;
  }
  
  public static av b(f paramf, e parame)
  {
    AppMethodBeat.i(57651);
    if (paramf == null) {
      adP(19);
    }
    if (parame == null) {
      adP(20);
    }
    parame = parame.fvR();
    if (parame.size() != 1)
    {
      AppMethodBeat.o(57651);
      return null;
    }
    parame = ((d)parame.iterator().next()).fyq().iterator();
    while (parame.hasNext())
    {
      av localav = (av)parame.next();
      if (localav.fyB().equals(paramf))
      {
        AppMethodBeat.o(57651);
        return localav;
      }
    }
    AppMethodBeat.o(57651);
    return null;
  }
  
  public static <D extends d.l.b.a.b.b.b> Collection<D> b(f paramf, Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, r paramr, i parami)
  {
    AppMethodBeat.i(57649);
    if (paramf == null) {
      adP(6);
    }
    if (paramCollection1 == null) {
      adP(7);
    }
    if (paramCollection2 == null) {
      adP(8);
    }
    if (parame == null) {
      adP(9);
    }
    if (paramr == null) {
      adP(10);
    }
    if (parami == null) {
      adP(11);
    }
    paramf = a(paramf, paramCollection1, paramCollection2, parame, paramr, parami, true);
    AppMethodBeat.o(57649);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */