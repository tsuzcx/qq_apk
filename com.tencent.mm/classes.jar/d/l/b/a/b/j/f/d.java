package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.v;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static final int NxA;
  public static final d NxB;
  public static final d NxC;
  public static final d NxD;
  public static final d NxE;
  public static final d NxF;
  public static final d NxG;
  public static final d NxH;
  public static final d NxI;
  public static final d NxJ;
  public static final d NxK;
  private static final List<d.a.a> NxL;
  private static final List<d.a.a> NxM;
  public static final a NxN;
  private static int Nxq;
  private static final int Nxr;
  private static final int Nxs;
  private static final int Nxt;
  private static final int Nxu;
  private static final int Nxv;
  private static final int Nxw;
  private static final int Nxx;
  private static final int Nxy;
  private static final int Nxz;
  final int Nxo;
  public final List<c> Nxp;
  
  static
  {
    AppMethodBeat.i(60201);
    NxN = new a((byte)0);
    Nxq = 1;
    Nxr = a.gts();
    Nxs = a.gts();
    Nxt = a.gts();
    Nxu = a.gts();
    Nxv = a.gts();
    Nxw = a.gts();
    Nxx = a.gts() - 1;
    Nxy = Nxr | Nxs | Nxt;
    Nxz = Nxs | Nxv | Nxw;
    NxA = Nxv | Nxw;
    NxB = new d(Nxx);
    NxC = new d(NxA);
    NxD = new d(Nxr);
    NxE = new d(Nxs);
    NxF = new d(Nxt);
    NxG = new d(Nxy);
    NxH = new d(Nxu);
    NxI = new d(Nxv);
    NxJ = new d(Nxw);
    NxK = new d(Nxz);
    Object localObject1 = d.class.getFields();
    p.g(localObject1, "T::class.java.fields");
    Object localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      p.g(localObject3, "it");
      if (Modifier.isStatic(((Field)localObject3).getModifiers())) {
        ((Collection)localObject2).add(localObject3);
      }
      i += 1;
    }
    localObject1 = (Iterable)localObject2;
    Object localObject3 = (Collection)new ArrayList();
    Object localObject4 = ((Iterable)localObject1).iterator();
    label434:
    while (((Iterator)localObject4).hasNext())
    {
      Field localField = (Field)((Iterator)localObject4).next();
      localObject2 = localField.get(null);
      localObject1 = localObject2;
      if (!(localObject2 instanceof d)) {
        localObject1 = null;
      }
      localObject1 = (d)localObject1;
      if (localObject1 != null)
      {
        i = ((d)localObject1).Nxo;
        p.g(localField, "field");
        localObject1 = localField.getName();
        p.g(localObject1, "field.name");
      }
      for (localObject1 = new d.a.a(i, (String)localObject1);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label434;
        }
        ((Collection)localObject3).add(localObject1);
        break;
      }
    }
    NxL = j.l((Iterable)localObject3);
    localObject1 = d.class.getFields();
    p.g(localObject1, "T::class.java.fields");
    localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      p.g(localObject3, "it");
      if (Modifier.isStatic(((Field)localObject3).getModifiers())) {
        ((Collection)localObject2).add(localObject3);
      }
      i += 1;
    }
    localObject2 = (Iterable)localObject2;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (Field)localObject3;
      p.g(localObject4, "it");
      if (p.i(((Field)localObject4).getType(), Integer.TYPE)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject1).iterator();
    label701:
    label752:
    label755:
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Field)((Iterator)localObject3).next();
      localObject4 = ((Field)localObject1).get(null);
      if (localObject4 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(60201);
        throw ((Throwable)localObject1);
      }
      j = ((Integer)localObject4).intValue();
      if (j == (-j & j))
      {
        i = 1;
        if (i == 0) {
          break label752;
        }
        p.g(localObject1, "field");
        localObject1 = ((Field)localObject1).getName();
        p.g(localObject1, "field.name");
      }
      for (localObject1 = new d.a.a(j, (String)localObject1);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label755;
        }
        ((Collection)localObject2).add(localObject1);
        break;
        i = 0;
        break label701;
      }
    }
    NxM = j.l((Iterable)localObject2);
    AppMethodBeat.o(60201);
  }
  
  public d(int paramInt, List<? extends c> paramList)
  {
    AppMethodBeat.i(60199);
    this.Nxp = paramList;
    paramList = ((Iterable)this.Nxp).iterator();
    while (paramList.hasNext()) {
      paramInt &= (((c)paramList.next()).gti() ^ 0xFFFFFFFF);
    }
    this.Nxo = paramInt;
    AppMethodBeat.o(60199);
  }
  
  public final boolean alm(int paramInt)
  {
    return (this.Nxo & paramInt) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60198);
    Object localObject2 = ((Iterable)NxL).iterator();
    int i;
    label49:
    label53:
    label67:
    Iterator localIterator;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((d.a.a)localObject1).mask == this.Nxo)
      {
        i = 1;
        if (i == 0) {
          break label154;
        }
        localObject1 = (d.a.a)localObject1;
        if (localObject1 == null) {
          break label161;
        }
        localObject1 = ((d.a.a)localObject1).name;
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label195;
        }
        localObject1 = (Iterable)NxM;
        localObject2 = (Collection)new ArrayList();
        localIterator = ((Iterable)localObject1).iterator();
      }
    }
    label154:
    label161:
    label169:
    for (;;)
    {
      label99:
      if (!localIterator.hasNext()) {
        break label171;
      }
      localObject1 = (d.a.a)localIterator.next();
      if (alm(((d.a.a)localObject1).mask)) {}
      for (localObject1 = ((d.a.a)localObject1).name;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label169;
        }
        ((Collection)localObject2).add(localObject1);
        break label99;
        i = 0;
        break label49;
        break;
        localObject1 = null;
        break label53;
        localObject1 = null;
        break label67;
      }
    }
    label171:
    localObject2 = j.a((Iterable)localObject2, (CharSequence)" | ", null, null, 0, null, null, 62);
    label195:
    Object localObject1 = "DescriptorKindFilter(" + (String)localObject2 + ", " + this.Nxp + ')';
    AppMethodBeat.o(60198);
    return localObject1;
  }
  
  public static final class a
  {
    static int gts()
    {
      AppMethodBeat.i(60197);
      int i = d.gtj();
      d.aln(d.gtj() << 1);
      AppMethodBeat.o(60197);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.d
 * JD-Core Version:    0.7.0.1
 */