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
  private static int ablV;
  private static final int ablW;
  private static final int ablX;
  private static final int ablY;
  private static final int ablZ;
  private static final int abma;
  private static final int abmb;
  private static final int abmc;
  private static final int abmd;
  private static final int abme;
  private static final int abmf;
  public static final d abmg;
  public static final d abmh;
  public static final d abmi;
  public static final d abmj;
  public static final d abmk;
  public static final d abml;
  public static final d abmm;
  public static final d abmn;
  public static final d abmo;
  public static final d abmp;
  private static final List<d.a.a> abmq;
  private static final List<d.a.a> abmr;
  public static final a abms;
  final int ablT;
  public final List<c> ablU;
  
  static
  {
    AppMethodBeat.i(60201);
    abms = new a((byte)0);
    ablV = 1;
    ablW = a.iPn();
    ablX = a.iPn();
    ablY = a.iPn();
    ablZ = a.iPn();
    abma = a.iPn();
    abmb = a.iPn();
    abmc = a.iPn() - 1;
    abmd = ablW | ablX | ablY;
    abme = ablX | abma | abmb;
    abmf = abma | abmb;
    abmg = new d(abmc);
    abmh = new d(abmf);
    abmi = new d(ablW);
    abmj = new d(ablX);
    abmk = new d(ablY);
    abml = new d(abmd);
    abmm = new d(ablZ);
    abmn = new d(abma);
    abmo = new d(abmb);
    abmp = new d(abme);
    Object localObject1 = d.class.getFields();
    p.j(localObject1, "T::class.java.fields");
    Object localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      p.j(localObject3, "it");
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
        i = ((d)localObject1).ablT;
        p.j(localField, "field");
        localObject1 = localField.getName();
        p.j(localObject1, "field.name");
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
    abmq = j.p((Iterable)localObject3);
    localObject1 = d.class.getFields();
    p.j(localObject1, "T::class.java.fields");
    localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      p.j(localObject3, "it");
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
      p.j(localObject4, "it");
      if (p.h(((Field)localObject4).getType(), Integer.TYPE)) {
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
        p.j(localObject1, "field");
        localObject1 = ((Field)localObject1).getName();
        p.j(localObject1, "field.name");
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
    abmr = j.p((Iterable)localObject2);
    AppMethodBeat.o(60201);
  }
  
  public d(int paramInt, List<? extends c> paramList)
  {
    AppMethodBeat.i(60199);
    this.ablU = paramList;
    paramList = ((Iterable)this.ablU).iterator();
    while (paramList.hasNext()) {
      paramInt &= (((c)paramList.next()).iPd() ^ 0xFFFFFFFF);
    }
    this.ablT = paramInt;
    AppMethodBeat.o(60199);
  }
  
  public final boolean aFz(int paramInt)
  {
    return (this.ablT & paramInt) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60198);
    Object localObject2 = ((Iterable)abmq).iterator();
    int i;
    label49:
    label53:
    label67:
    Iterator localIterator;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((d.a.a)localObject1).mask == this.ablT)
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
        localObject1 = (Iterable)abmr;
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
      if (aFz(((d.a.a)localObject1).mask)) {}
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
    Object localObject1 = "DescriptorKindFilter(" + (String)localObject2 + ", " + this.ablU + ')';
    AppMethodBeat.o(60198);
    return localObject1;
  }
  
  public static final class a
  {
    static int iPn()
    {
      AppMethodBeat.i(60197);
      int i = d.iPe();
      d.aFA(d.iPe() << 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.d
 * JD-Core Version:    0.7.0.1
 */