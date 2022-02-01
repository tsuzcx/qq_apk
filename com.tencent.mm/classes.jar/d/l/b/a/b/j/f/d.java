package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.v;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static final int LGA;
  private static final int LGB;
  private static final int LGC;
  public static final d LGD;
  public static final d LGE;
  public static final d LGF;
  public static final d LGG;
  public static final d LGH;
  public static final d LGI;
  public static final d LGJ;
  public static final d LGK;
  public static final d LGL;
  public static final d LGM;
  private static final List<d.a.a> LGN;
  private static final List<d.a.a> LGO;
  public static final a LGP;
  private static int LGs;
  private static final int LGt;
  private static final int LGu;
  private static final int LGv;
  private static final int LGw;
  private static final int LGx;
  private static final int LGy;
  private static final int LGz;
  final int LGq;
  public final List<c> LGr;
  
  static
  {
    AppMethodBeat.i(60201);
    LGP = new a((byte)0);
    LGs = 1;
    LGt = a.gbT();
    LGu = a.gbT();
    LGv = a.gbT();
    LGw = a.gbT();
    LGx = a.gbT();
    LGy = a.gbT();
    LGz = a.gbT() - 1;
    LGA = LGt | LGu | LGv;
    LGB = LGu | LGx | LGy;
    LGC = LGx | LGy;
    LGD = new d(LGz);
    LGE = new d(LGC);
    LGF = new d(LGt);
    LGG = new d(LGu);
    LGH = new d(LGv);
    LGI = new d(LGA);
    LGJ = new d(LGw);
    LGK = new d(LGx);
    LGL = new d(LGy);
    LGM = new d(LGB);
    Object localObject1 = d.class.getFields();
    k.g(localObject1, "T::class.java.fields");
    Object localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      k.g(localObject3, "it");
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
        i = ((d)localObject1).LGq;
        k.g(localField, "field");
        localObject1 = localField.getName();
        k.g(localObject1, "field.name");
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
    LGN = j.l((Iterable)localObject3);
    localObject1 = d.class.getFields();
    k.g(localObject1, "T::class.java.fields");
    localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      k.g(localObject3, "it");
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
      k.g(localObject4, "it");
      if (k.g(((Field)localObject4).getType(), Integer.TYPE)) {
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
        k.g(localObject1, "field");
        localObject1 = ((Field)localObject1).getName();
        k.g(localObject1, "field.name");
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
    LGO = j.l((Iterable)localObject2);
    AppMethodBeat.o(60201);
  }
  
  public d(int paramInt, List<? extends c> paramList)
  {
    AppMethodBeat.i(60199);
    this.LGr = paramList;
    paramList = ((Iterable)this.LGr).iterator();
    while (paramList.hasNext()) {
      paramInt &= (((c)paramList.next()).gbJ() ^ 0xFFFFFFFF);
    }
    this.LGq = paramInt;
    AppMethodBeat.o(60199);
  }
  
  public final boolean aiL(int paramInt)
  {
    return (this.LGq & paramInt) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60198);
    Object localObject2 = ((Iterable)LGN).iterator();
    int i;
    label49:
    label53:
    label67:
    Iterator localIterator;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((d.a.a)localObject1).mask == this.LGq)
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
        localObject1 = (Iterable)LGO;
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
      if (aiL(((d.a.a)localObject1).mask)) {}
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
    Object localObject1 = "DescriptorKindFilter(" + (String)localObject2 + ", " + this.LGr + ')';
    AppMethodBeat.o(60198);
    return localObject1;
  }
  
  public static final class a
  {
    static int gbT()
    {
      AppMethodBeat.i(60197);
      int i = d.gbK();
      d.aiM(d.gbK() << 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.d
 * JD-Core Version:    0.7.0.1
 */