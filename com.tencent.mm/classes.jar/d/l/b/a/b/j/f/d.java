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
  private static int JSZ;
  private static final int JTa;
  private static final int JTb;
  private static final int JTc;
  private static final int JTd;
  private static final int JTe;
  private static final int JTf;
  private static final int JTg;
  private static final int JTh;
  private static final int JTi;
  private static final int JTj;
  public static final d JTk;
  public static final d JTl;
  public static final d JTm;
  public static final d JTn;
  public static final d JTo;
  public static final d JTp;
  public static final d JTq;
  public static final d JTr;
  public static final d JTs;
  public static final d JTt;
  private static final List<d.a.a> JTu;
  private static final List<d.a.a> JTv;
  public static final a JTw;
  final int JSX;
  public final List<c> JSY;
  
  static
  {
    AppMethodBeat.i(60201);
    JTw = new a((byte)0);
    JSZ = 1;
    JTa = a.fJq();
    JTb = a.fJq();
    JTc = a.fJq();
    JTd = a.fJq();
    JTe = a.fJq();
    JTf = a.fJq();
    JTg = a.fJq() - 1;
    JTh = JTa | JTb | JTc;
    JTi = JTb | JTe | JTf;
    JTj = JTe | JTf;
    JTk = new d(JTg);
    JTl = new d(JTj);
    JTm = new d(JTa);
    JTn = new d(JTb);
    JTo = new d(JTc);
    JTp = new d(JTh);
    JTq = new d(JTd);
    JTr = new d(JTe);
    JTs = new d(JTf);
    JTt = new d(JTi);
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
        i = ((d)localObject1).JSX;
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
    JTu = j.m((Iterable)localObject3);
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
    JTv = j.m((Iterable)localObject2);
    AppMethodBeat.o(60201);
  }
  
  public d(int paramInt, List<? extends c> paramList)
  {
    AppMethodBeat.i(60199);
    this.JSY = paramList;
    paramList = ((Iterable)this.JSY).iterator();
    while (paramList.hasNext()) {
      paramInt &= (((c)paramList.next()).fJg() ^ 0xFFFFFFFF);
    }
    this.JSX = paramInt;
    AppMethodBeat.o(60199);
  }
  
  public final boolean afP(int paramInt)
  {
    return (this.JSX & paramInt) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60198);
    Object localObject2 = ((Iterable)JTu).iterator();
    int i;
    label49:
    label53:
    label67:
    Iterator localIterator;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((d.a.a)localObject1).mask == this.JSX)
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
        localObject1 = (Iterable)JTv;
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
      if (afP(((d.a.a)localObject1).mask)) {}
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
    Object localObject1 = "DescriptorKindFilter(" + (String)localObject2 + ", " + this.JSY + ')';
    AppMethodBeat.o(60198);
    return localObject1;
  }
  
  public static final class a
  {
    static int fJq()
    {
      AppMethodBeat.i(60197);
      int i = d.fJh();
      d.afQ(d.fJh() << 1);
      AppMethodBeat.o(60197);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.d
 * JD-Core Version:    0.7.0.1
 */