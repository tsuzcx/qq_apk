package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.ah;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.h;
import kotlin.l.b.a.b.j.j;
import kotlin.l.b.a.b.k.a.q;

public final class a
{
  public static <D extends kotlin.l.b.a.b.b.b> Collection<D> a(f paramf, Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, q paramq, j paramj)
  {
    AppMethodBeat.i(57648);
    if (paramf == null) {
      aKu(0);
    }
    if (paramCollection1 == null) {
      aKu(1);
    }
    if (paramCollection2 == null) {
      aKu(2);
    }
    if (parame == null) {
      aKu(3);
    }
    if (paramq == null) {
      aKu(4);
    }
    if (paramj == null) {
      aKu(5);
    }
    paramf = a(paramf, paramCollection1, paramCollection2, parame, paramq, paramj, false);
    AppMethodBeat.o(57648);
    return paramf;
  }
  
  private static <D extends kotlin.l.b.a.b.b.b> Collection<D> a(f paramf, Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, q paramq, j paramj, final boolean paramBoolean)
  {
    AppMethodBeat.i(57650);
    if (paramf == null) {
      aKu(12);
    }
    if (paramCollection1 == null) {
      aKu(13);
    }
    if (paramCollection2 == null) {
      aKu(14);
    }
    if (parame == null) {
      aKu(15);
    }
    if (paramq == null) {
      aKu(16);
    }
    if (paramj == null) {
      aKu(17);
    }
    final LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramj.a(paramf, paramCollection1, paramCollection2, parame, new h()
    {
      public final void a(kotlin.l.b.a.b.b.b paramAnonymousb, Collection<? extends kotlin.l.b.a.b.b.b> paramAnonymousCollection)
      {
        AppMethodBeat.i(57646);
        if (paramAnonymousb == null) {
          aKu(3);
        }
        if (paramAnonymousCollection == null) {
          aKu(4);
        }
        if ((paramBoolean) && (paramAnonymousb.koh() != b.a.aiGm))
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
          aKu(1);
        }
        if (paramAnonymousb2 == null) {
          aKu(2);
        }
        AppMethodBeat.o(57645);
      }
      
      public final void e(kotlin.l.b.a.b.b.b paramAnonymousb)
      {
        AppMethodBeat.i(57644);
        if (paramAnonymousb == null) {
          aKu(0);
        }
        j.a(paramAnonymousb, new kotlin.g.a.b() {});
        localLinkedHashSet.add(paramAnonymousb);
        AppMethodBeat.o(57644);
      }
    });
    AppMethodBeat.o(57650);
    return localLinkedHashSet;
  }
  
  public static <D extends kotlin.l.b.a.b.b.b> Collection<D> b(f paramf, Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, q paramq, j paramj)
  {
    AppMethodBeat.i(57649);
    if (paramf == null) {
      aKu(6);
    }
    if (paramCollection1 == null) {
      aKu(7);
    }
    if (paramCollection2 == null) {
      aKu(8);
    }
    if (parame == null) {
      aKu(9);
    }
    if (paramq == null) {
      aKu(10);
    }
    if (paramj == null) {
      aKu(11);
    }
    paramf = a(paramf, paramCollection1, paramCollection2, parame, paramq, paramj, true);
    AppMethodBeat.o(57649);
    return paramf;
  }
  
  public static bd b(f paramf, e parame)
  {
    AppMethodBeat.i(57651);
    if (paramf == null) {
      aKu(19);
    }
    if (parame == null) {
      aKu(20);
    }
    parame = parame.klv();
    if (parame.size() != 1)
    {
      AppMethodBeat.o(57651);
      return null;
    }
    parame = ((d)parame.iterator().next()).kod().iterator();
    while (parame.hasNext())
    {
      bd localbd = (bd)parame.next();
      if (localbd.kok().equals(paramf))
      {
        AppMethodBeat.o(57651);
        return localbd;
      }
    }
    AppMethodBeat.o(57651);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */