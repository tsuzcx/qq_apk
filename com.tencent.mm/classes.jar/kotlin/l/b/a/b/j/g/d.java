package kotlin.l.b.a.b.j.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;

public final class d
{
  public static final a ajkC;
  private static int ajkF;
  private static final int ajkG;
  private static final int ajkH;
  private static final int ajkI;
  private static final int ajkJ;
  private static final int ajkK;
  private static final int ajkL;
  private static final int ajkM;
  private static final int ajkN;
  private static final int ajkO;
  private static final int ajkP;
  public static final d ajkQ;
  public static final d ajkR;
  public static final d ajkS;
  public static final d ajkT;
  public static final d ajkU;
  public static final d ajkV;
  public static final d ajkW;
  public static final d ajkX;
  public static final d ajkY;
  public static final d ajkZ;
  private static final List<d.a.a> ajla;
  private static final List<d.a.a> ajlb;
  public final List<c> ajkD;
  final int ajkE;
  
  static
  {
    AppMethodBeat.i(60201);
    ajkC = new a((byte)0);
    ajkF = 1;
    ajkG = a.kzI();
    ajkH = a.kzI();
    ajkI = a.kzI();
    ajkJ = a.kzI();
    ajkK = a.kzI();
    ajkL = a.kzI();
    ajkM = a.kzI() - 1;
    ajkN = ajkG | ajkH | ajkI;
    ajkO = ajkH | ajkK | ajkL;
    ajkP = ajkK | ajkL;
    ajkQ = new d(ajkM);
    ajkR = new d(ajkP);
    ajkS = new d(ajkG);
    ajkT = new d(ajkH);
    ajkU = new d(ajkI);
    ajkV = new d(ajkN);
    ajkW = new d(ajkJ);
    ajkX = new d(ajkK);
    ajkY = new d(ajkL);
    ajkZ = new d(ajkO);
    Object localObject1 = d.class.getFields();
    s.s(localObject1, "T::class.java.fields");
    localObject1 = (Object[])localObject1;
    Object localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      if (Modifier.isStatic(((Field)localObject3).getModifiers())) {
        ((Collection)localObject2).add(localObject3);
      }
      i += 1;
    }
    localObject1 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList();
    Object localObject3 = ((Iterable)localObject1).iterator();
    Object localObject4;
    label424:
    label427:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Field)((Iterator)localObject3).next();
      localObject1 = ((Field)localObject4).get(null);
      if ((localObject1 instanceof d))
      {
        localObject1 = (d)localObject1;
        label373:
        if (localObject1 == null) {
          break label424;
        }
        i = ((d)localObject1).ajkE;
        localObject1 = ((Field)localObject4).getName();
        s.s(localObject1, "field.name");
      }
      for (localObject1 = new d.a.a(i, (String)localObject1);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label427;
        }
        ((Collection)localObject2).add(localObject1);
        break;
        localObject1 = null;
        break label373;
      }
    }
    ajla = (List)localObject2;
    localObject1 = d.class.getFields();
    s.s(localObject1, "T::class.java.fields");
    localObject1 = (Object[])localObject1;
    localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
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
      if (s.p(((Field)localObject3).getType(), Integer.TYPE)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject1).iterator();
    label677:
    label722:
    label725:
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Field)((Iterator)localObject3).next();
      localObject4 = ((Field)localObject1).get(null);
      if (localObject4 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(60201);
        throw ((Throwable)localObject1);
      }
      j = ((Integer)localObject4).intValue();
      if (j == (-j & j))
      {
        i = 1;
        if (i == 0) {
          break label722;
        }
        localObject1 = ((Field)localObject1).getName();
        s.s(localObject1, "field.name");
      }
      for (localObject1 = new d.a.a(j, (String)localObject1);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label725;
        }
        ((Collection)localObject2).add(localObject1);
        break;
        i = 0;
        break label677;
      }
    }
    ajlb = (List)localObject2;
    AppMethodBeat.o(60201);
  }
  
  public d(int paramInt, List<? extends c> paramList)
  {
    AppMethodBeat.i(60199);
    this.ajkD = paramList;
    paramList = ((Iterable)this.ajkD).iterator();
    while (paramList.hasNext()) {
      paramInt &= (((c)paramList.next()).kzy() ^ 0xFFFFFFFF);
    }
    this.ajkE = paramInt;
    AppMethodBeat.o(60199);
  }
  
  public final boolean aMn(int paramInt)
  {
    return (this.ajkE & paramInt) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192251);
    if (this == paramObject)
    {
      AppMethodBeat.o(192251);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(192251);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
      AppMethodBeat.o(192251);
      throw paramObject;
    }
    if (!s.p(this.ajkD, ((d)paramObject).ajkD))
    {
      AppMethodBeat.o(192251);
      return false;
    }
    if (this.ajkE != ((d)paramObject).ajkE)
    {
      AppMethodBeat.o(192251);
      return false;
    }
    AppMethodBeat.o(192251);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(192254);
    int i = this.ajkD.hashCode();
    int j = this.ajkE;
    AppMethodBeat.o(192254);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60198);
    Object localObject2 = ((Iterable)ajla).iterator();
    int i;
    label50:
    label54:
    label65:
    Iterator localIterator;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((d.a.a)localObject1).mask == this.ajkE)
      {
        i = 1;
        if (i == 0) {
          break label152;
        }
        localObject1 = (d.a.a)localObject1;
        if (localObject1 != null) {
          break label159;
        }
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label196;
        }
        localObject1 = (Iterable)ajlb;
        localObject2 = (Collection)new ArrayList();
        localIterator = ((Iterable)localObject1).iterator();
      }
    }
    label152:
    label159:
    label170:
    for (;;)
    {
      label97:
      if (!localIterator.hasNext()) {
        break label172;
      }
      localObject1 = (d.a.a)localIterator.next();
      if (aMn(((d.a.a)localObject1).mask)) {}
      for (localObject1 = ((d.a.a)localObject1).name;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label170;
        }
        ((Collection)localObject2).add(localObject1);
        break label97;
        i = 0;
        break label50;
        break;
        localObject1 = null;
        break label54;
        localObject1 = ((d.a.a)localObject1).name;
        break label65;
      }
    }
    label172:
    localObject2 = p.a((Iterable)localObject2, (CharSequence)" | ", null, null, 0, null, null, 62);
    label196:
    Object localObject1 = "DescriptorKindFilter(" + (String)localObject2 + ", " + this.ajkD + ')';
    AppMethodBeat.o(60198);
    return localObject1;
  }
  
  public static final class a
  {
    static int kzI()
    {
      AppMethodBeat.i(60197);
      int i = d.kzz();
      a locala = d.ajkC;
      d.aMo(d.kzz() << 1);
      AppMethodBeat.o(60197);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.d
 * JD-Core Version:    0.7.0.1
 */