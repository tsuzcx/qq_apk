package d.l.b.a.b.h;

import TFieldDescriptorType;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;

public final class h<FieldDescriptorType extends a<FieldDescriptorType>>
{
  private static final h LAa;
  final v<FieldDescriptorType, Object> LzX;
  private boolean LzY;
  boolean LzZ;
  
  static
  {
    AppMethodBeat.i(59470);
    LAa = new h((byte)0);
    AppMethodBeat.o(59470);
  }
  
  private h()
  {
    AppMethodBeat.i(59448);
    this.LzZ = false;
    this.LzX = v.aiH(16);
    AppMethodBeat.o(59448);
  }
  
  private h(byte paramByte)
  {
    AppMethodBeat.i(59449);
    this.LzZ = false;
    this.LzX = v.aiH(0);
    gai();
    AppMethodBeat.o(59449);
  }
  
  private static int a(z.a parama, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(59466);
    int i = f.fK(paramInt);
    paramInt = i;
    if (parama == z.a.LBv) {
      paramInt = i * 2;
    }
    i = b(parama, paramObject);
    AppMethodBeat.o(59466);
    return paramInt + i;
  }
  
  static int a(z.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return parama.LBF;
  }
  
  public static Object a(e parame, z.a parama)
  {
    AppMethodBeat.i(59461);
    long l;
    int i;
    switch (1.LAc[parama.ordinal()])
    {
    default: 
      parame = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      AppMethodBeat.o(59461);
      throw parame;
    case 1: 
      double d = Double.longBitsToDouble(parame.gab());
      AppMethodBeat.o(59461);
      return Double.valueOf(d);
    case 2: 
      float f = Float.intBitsToFloat(parame.gaa());
      AppMethodBeat.o(59461);
      return Float.valueOf(f);
    case 3: 
      l = parame.xG();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 4: 
      l = parame.xG();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 5: 
      i = parame.xF();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 6: 
      l = parame.gab();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 7: 
      i = parame.gaa();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 8: 
      boolean bool = parame.fZX();
      AppMethodBeat.o(59461);
      return Boolean.valueOf(bool);
    case 9: 
      i = parame.xF();
      if ((i <= parame.bufferSize - parame.bGt) && (i > 0))
      {
        parama = new String(parame.buffer, parame.bGt, i, "UTF-8");
        parame.bGt = (i + parame.bGt);
        AppMethodBeat.o(59461);
        return parama;
      }
      if (i == 0)
      {
        AppMethodBeat.o(59461);
        return "";
      }
      parame = new String(parame.aiz(i), "UTF-8");
      AppMethodBeat.o(59461);
      return parame;
    case 10: 
      parame = parame.fZY();
      AppMethodBeat.o(59461);
      return parame;
    case 11: 
      i = parame.xF();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 12: 
      i = parame.gaa();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 13: 
      l = parame.gab();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 14: 
      i = parame.xF();
      int j = -(i & 0x1);
      AppMethodBeat.o(59461);
      return Integer.valueOf(j ^ i >>> 1);
    case 15: 
      l = e.Cs(parame.xG());
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 16: 
      parame = new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
      AppMethodBeat.o(59461);
      throw parame;
    case 17: 
      parame = new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
      AppMethodBeat.o(59461);
      throw parame;
    }
    parame = new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    AppMethodBeat.o(59461);
    throw parame;
  }
  
  private static void a(f paramf, z.a parama, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(59462);
    if (parama == z.a.LBv)
    {
      parama = (q)paramObject;
      paramf.bz(paramInt, 3);
      parama.a(paramf);
      paramf.bz(paramInt, 4);
      AppMethodBeat.o(59462);
      return;
    }
    paramf.bz(paramInt, a(parama, false));
    a(paramf, parama, paramObject);
    AppMethodBeat.o(59462);
  }
  
  private static void a(f paramf, z.a parama, Object paramObject)
  {
    AppMethodBeat.i(59463);
    switch (1.LAc[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(59463);
      return;
      paramf.L(((Double)paramObject).doubleValue());
      AppMethodBeat.o(59463);
      return;
      paramf.cm(((Float)paramObject).floatValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aw(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aw(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aiB(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.Cv(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aiD(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.zs(((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aWH((String)paramObject);
      AppMethodBeat.o(59463);
      return;
      ((q)paramObject).a(paramf);
      AppMethodBeat.o(59463);
      return;
      paramf.b((q)paramObject);
      AppMethodBeat.o(59463);
      return;
      if ((paramObject instanceof d))
      {
        paramf.b((d)paramObject);
        AppMethodBeat.o(59463);
        return;
      }
      paramf.cU((byte[])paramObject);
      AppMethodBeat.o(59463);
      return;
      paramf.fL(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aiD(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.Cv(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aiC(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.Ct(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      if ((paramObject instanceof j.a))
      {
        paramf.aiB(((j.a)paramObject).getNumber());
        AppMethodBeat.o(59463);
        return;
      }
      paramf.aiB(((Integer)paramObject).intValue());
    }
  }
  
  public static void a(a<?> parama, Object paramObject, f paramf)
  {
    AppMethodBeat.i(59464);
    z.a locala = parama.gak();
    int i = parama.getNumber();
    if (parama.gam())
    {
      paramObject = (List)paramObject;
      if (parama.gan())
      {
        paramf.bz(i, 2);
        i = 0;
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        paramf.fL(i);
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          a(paramf, locala, parama.next());
        }
        AppMethodBeat.o(59464);
        return;
      }
      parama = paramObject.iterator();
      while (parama.hasNext()) {
        a(paramf, locala, i, parama.next());
      }
      AppMethodBeat.o(59464);
      return;
    }
    if ((paramObject instanceof l))
    {
      a(paramf, locala, i, ((l)paramObject).gay());
      AppMethodBeat.o(59464);
      return;
    }
    a(paramf, locala, i, paramObject);
    AppMethodBeat.o(59464);
  }
  
  private static void a(z.a parama, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(59456);
    if (paramObject == null)
    {
      parama = new NullPointerException();
      AppMethodBeat.o(59456);
      throw parama;
    }
    switch (1.LAb[parama.LBE.ordinal()])
    {
    }
    while (!bool)
    {
      parama = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      AppMethodBeat.o(59456);
      throw parama;
      bool = paramObject instanceof Integer;
      continue;
      bool = paramObject instanceof Long;
      continue;
      bool = paramObject instanceof Float;
      continue;
      bool = paramObject instanceof Double;
      continue;
      bool = paramObject instanceof Boolean;
      continue;
      bool = paramObject instanceof String;
      continue;
      if (((paramObject instanceof d)) || ((paramObject instanceof byte[])))
      {
        bool = true;
        continue;
        if (((paramObject instanceof Integer)) || ((paramObject instanceof j.a)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof q)) || ((paramObject instanceof l))) {
            bool = true;
          }
        }
      }
    }
    AppMethodBeat.o(59456);
  }
  
  private static int b(z.a parama, Object paramObject)
  {
    AppMethodBeat.i(59467);
    switch (1.LAc[parama.ordinal()])
    {
    default: 
      parama = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      AppMethodBeat.o(59467);
      throw parama;
    case 1: 
      ((Double)paramObject).doubleValue();
      AppMethodBeat.o(59467);
      return 8;
    case 2: 
      ((Float)paramObject).floatValue();
      AppMethodBeat.o(59467);
      return 4;
    case 3: 
      i = f.ax(((Long)paramObject).longValue());
      AppMethodBeat.o(59467);
      return i;
    case 4: 
      i = f.ax(((Long)paramObject).longValue());
      AppMethodBeat.o(59467);
      return i;
    case 5: 
      i = f.fI(((Integer)paramObject).intValue());
      AppMethodBeat.o(59467);
      return i;
    case 6: 
      ((Long)paramObject).longValue();
      AppMethodBeat.o(59467);
      return 8;
    case 7: 
      ((Integer)paramObject).intValue();
      AppMethodBeat.o(59467);
      return 4;
    case 8: 
      ((Boolean)paramObject).booleanValue();
      AppMethodBeat.o(59467);
      return 1;
    case 9: 
      i = f.bj((String)paramObject);
      AppMethodBeat.o(59467);
      return i;
    case 16: 
      i = ((q)paramObject).xS();
      AppMethodBeat.o(59467);
      return i;
    case 10: 
      if ((paramObject instanceof d))
      {
        i = f.d((d)paramObject);
        AppMethodBeat.o(59467);
        return i;
      }
      i = f.cV((byte[])paramObject);
      AppMethodBeat.o(59467);
      return i;
    case 11: 
      i = f.fM(((Integer)paramObject).intValue());
      AppMethodBeat.o(59467);
      return i;
    case 12: 
      ((Integer)paramObject).intValue();
      AppMethodBeat.o(59467);
      return 4;
    case 13: 
      ((Long)paramObject).longValue();
      AppMethodBeat.o(59467);
      return 8;
    case 14: 
      i = f.fM(f.aiE(((Integer)paramObject).intValue()));
      AppMethodBeat.o(59467);
      return i;
    case 15: 
      i = f.ax(f.Cw(((Long)paramObject).longValue()));
      AppMethodBeat.o(59467);
      return i;
    case 17: 
      if ((paramObject instanceof l))
      {
        i = f.a((l)paramObject);
        AppMethodBeat.o(59467);
        return i;
      }
      i = f.c((q)paramObject);
      AppMethodBeat.o(59467);
      return i;
    }
    if ((paramObject instanceof j.a))
    {
      i = f.fI(((j.a)paramObject).getNumber());
      AppMethodBeat.o(59467);
      return i;
    }
    int i = f.fI(((Integer)paramObject).intValue());
    AppMethodBeat.o(59467);
    return i;
  }
  
  private static int c(a<?> parama, Object paramObject)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(59468);
    z.a locala = parama.gak();
    int k = parama.getNumber();
    if (parama.gam())
    {
      if (parama.gan())
      {
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        j = f.fK(k);
        k = f.fM(i);
        AppMethodBeat.o(59468);
        return k + (j + i);
      }
      parama = ((List)paramObject).iterator();
      i = j;
      while (parama.hasNext()) {
        i += a(locala, k, parama.next());
      }
      AppMethodBeat.o(59468);
      return i;
    }
    i = a(locala, k, paramObject);
    AppMethodBeat.o(59468);
    return i;
  }
  
  private static boolean e(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    AppMethodBeat.i(59458);
    a locala = (a)paramEntry.getKey();
    if (locala.gal() == z.b.LBP)
    {
      if (locala.gam())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((q)paramEntry.next()).isInitialized());
        AppMethodBeat.o(59458);
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof q))
      {
        if (!((q)paramEntry).isInitialized())
        {
          AppMethodBeat.o(59458);
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof l))
        {
          AppMethodBeat.o(59458);
          return true;
        }
        paramEntry = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        AppMethodBeat.o(59458);
        throw paramEntry;
      }
    }
    AppMethodBeat.o(59458);
    return true;
  }
  
  private static Object fm(Object paramObject)
  {
    AppMethodBeat.i(59459);
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      AppMethodBeat.o(59459);
      return arrayOfByte;
    }
    AppMethodBeat.o(59459);
    return paramObject;
  }
  
  public static <T extends a<T>> h<T> gag()
  {
    AppMethodBeat.i(59450);
    h localh = new h();
    AppMethodBeat.o(59450);
    return localh;
  }
  
  public static <T extends a<T>> h<T> gah()
  {
    return LAa;
  }
  
  public final Object a(FieldDescriptorType paramFieldDescriptorType)
  {
    AppMethodBeat.i(59453);
    paramFieldDescriptorType = this.LzX.get(paramFieldDescriptorType);
    if ((paramFieldDescriptorType instanceof l))
    {
      paramFieldDescriptorType = ((l)paramFieldDescriptorType).gay();
      AppMethodBeat.o(59453);
      return paramFieldDescriptorType;
    }
    AppMethodBeat.o(59453);
    return paramFieldDescriptorType;
  }
  
  public final void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    AppMethodBeat.i(59454);
    if (paramFieldDescriptorType.gam())
    {
      if (!(paramObject instanceof List))
      {
        paramFieldDescriptorType = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        AppMethodBeat.o(59454);
        throw paramFieldDescriptorType;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((List)paramObject);
      paramObject = localArrayList.iterator();
      while (paramObject.hasNext())
      {
        Object localObject = paramObject.next();
        a(paramFieldDescriptorType.gak(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof l)) {
        this.LzZ = true;
      }
      this.LzX.a(paramFieldDescriptorType, paramObject);
      AppMethodBeat.o(59454);
      return;
      a(paramFieldDescriptorType.gak(), paramObject);
    }
  }
  
  public final void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    AppMethodBeat.i(59455);
    if (!paramFieldDescriptorType.gam())
    {
      paramFieldDescriptorType = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
      AppMethodBeat.o(59455);
      throw paramFieldDescriptorType;
    }
    a(paramFieldDescriptorType.gak(), paramObject);
    Object localObject = a(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.LzX.a(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (TFieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      AppMethodBeat.o(59455);
      return;
    }
  }
  
  final void f(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    AppMethodBeat.i(59460);
    a locala = (a)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
    if ((localObject1 instanceof l)) {
      paramEntry = ((l)localObject1).gay();
    }
    if (locala.gam())
    {
      Object localObject2 = a(locala);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      paramEntry = ((List)paramEntry).iterator();
      while (paramEntry.hasNext())
      {
        localObject2 = paramEntry.next();
        ((List)localObject1).add(fm(localObject2));
      }
      this.LzX.a(locala, localObject1);
      AppMethodBeat.o(59460);
      return;
    }
    if (locala.gal() == z.b.LBP)
    {
      localObject1 = a(locala);
      if (localObject1 == null)
      {
        this.LzX.a(locala, fm(paramEntry));
        AppMethodBeat.o(59460);
        return;
      }
      paramEntry = locala.a(((q)localObject1).fUT(), (q)paramEntry).fVd();
      this.LzX.a(locala, paramEntry);
      AppMethodBeat.o(59460);
      return;
    }
    this.LzX.a(locala, fm(paramEntry));
    AppMethodBeat.o(59460);
  }
  
  public final void gai()
  {
    AppMethodBeat.i(59451);
    if (this.LzY)
    {
      AppMethodBeat.o(59451);
      return;
    }
    this.LzX.gai();
    this.LzY = true;
    AppMethodBeat.o(59451);
  }
  
  public final h<FieldDescriptorType> gaj()
  {
    AppMethodBeat.i(59452);
    h localh = new h();
    int i = 0;
    while (i < this.LzX.gaF())
    {
      localObject = this.LzX.aiI(i);
      localh.a((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.LzX.gaG().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localh.a((a)localEntry.getKey(), localEntry.getValue());
    }
    localh.LzZ = this.LzZ;
    AppMethodBeat.o(59452);
    return localh;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(59457);
    int i = 0;
    while (i < this.LzX.gaF())
    {
      if (!e(this.LzX.aiI(i)))
      {
        AppMethodBeat.o(59457);
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.LzX.gaG().iterator();
    while (localIterator.hasNext()) {
      if (!e((Map.Entry)localIterator.next()))
      {
        AppMethodBeat.o(59457);
        return false;
      }
    }
    AppMethodBeat.o(59457);
    return true;
  }
  
  public final int xS()
  {
    AppMethodBeat.i(59465);
    int j = 0;
    int i = 0;
    while (j < this.LzX.gaF())
    {
      localObject = this.LzX.aiI(j);
      i += c((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.LzX.gaG().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += c((a)localEntry.getKey(), localEntry.getValue());
    }
    AppMethodBeat.o(59465);
    return i;
  }
  
  public static abstract interface a<T extends a<T>>
    extends Comparable<T>
  {
    public abstract q.a a(q.a parama, q paramq);
    
    public abstract z.a gak();
    
    public abstract z.b gal();
    
    public abstract boolean gam();
    
    public abstract boolean gan();
    
    public abstract int getNumber();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.h
 * JD-Core Version:    0.7.0.1
 */