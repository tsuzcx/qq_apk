package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;

public final class d
{
  private static final int TJA;
  private static final int TJB;
  private static final int TJC;
  private static final int TJD;
  public static final d TJE;
  public static final d TJF;
  public static final d TJG;
  public static final d TJH;
  public static final d TJI;
  public static final d TJJ;
  public static final d TJK;
  public static final d TJL;
  public static final d TJM;
  public static final d TJN;
  private static final List<d.a.a> TJO;
  private static final List<d.a.a> TJP;
  public static final a TJQ;
  private static int TJt;
  private static final int TJu;
  private static final int TJv;
  private static final int TJw;
  private static final int TJx;
  private static final int TJy;
  private static final int TJz;
  final int TJr;
  public final List<c> TJs;
  
  static
  {
    AppMethodBeat.i(60201);
    TJQ = new a((byte)0);
    TJt = 1;
    TJu = a.hKX();
    TJv = a.hKX();
    TJw = a.hKX();
    TJx = a.hKX();
    TJy = a.hKX();
    TJz = a.hKX();
    TJA = a.hKX() - 1;
    TJB = TJu | TJv | TJw;
    TJC = TJv | TJy | TJz;
    TJD = TJy | TJz;
    TJE = new d(TJA);
    TJF = new d(TJD);
    TJG = new d(TJu);
    TJH = new d(TJv);
    TJI = new d(TJw);
    TJJ = new d(TJB);
    TJK = new d(TJx);
    TJL = new d(TJy);
    TJM = new d(TJz);
    TJN = new d(TJC);
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
        i = ((d)localObject1).TJr;
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
    TJO = j.p((Iterable)localObject3);
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
      if (p.j(((Field)localObject4).getType(), Integer.TYPE)) {
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
        localObject1 = new t("null cannot be cast to non-null type kotlin.Int");
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
    TJP = j.p((Iterable)localObject2);
    AppMethodBeat.o(60201);
  }
  
  public d(int paramInt, List<? extends c> paramList)
  {
    AppMethodBeat.i(60199);
    this.TJs = paramList;
    paramList = ((Iterable)this.TJs).iterator();
    while (paramList.hasNext()) {
      paramInt &= (((c)paramList.next()).hKN() ^ 0xFFFFFFFF);
    }
    this.TJr = paramInt;
    AppMethodBeat.o(60199);
  }
  
  public final boolean avF(int paramInt)
  {
    return (this.TJr & paramInt) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60198);
    Object localObject2 = ((Iterable)TJO).iterator();
    int i;
    label49:
    label53:
    label67:
    Iterator localIterator;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((d.a.a)localObject1).mask == this.TJr)
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
        localObject1 = (Iterable)TJP;
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
      if (avF(((d.a.a)localObject1).mask)) {}
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
    Object localObject1 = "DescriptorKindFilter(" + (String)localObject2 + ", " + this.TJs + ')';
    AppMethodBeat.o(60198);
    return localObject1;
  }
  
  public static final class a
  {
    static int hKX()
    {
      AppMethodBeat.i(60197);
      int i = d.hKO();
      d.avG(d.hKO() << 1);
      AppMethodBeat.o(60197);
      return i;
    }
    
    static final class a
    {
      final int mask;
      final String name;
      
      public a(int paramInt, String paramString)
      {
        AppMethodBeat.i(60196);
        this.mask = paramInt;
        this.name = paramString;
        AppMethodBeat.o(60196);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.d
 * JD-Core Version:    0.7.0.1
 */