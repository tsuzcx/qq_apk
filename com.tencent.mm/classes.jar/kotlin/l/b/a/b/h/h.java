package kotlin.l.b.a.b.h;

import TFieldDescriptorType;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;

final class h<FieldDescriptorType extends a<FieldDescriptorType>>
{
  private static final h ajfc;
  final w<FieldDescriptorType, Object> ajfb;
  private boolean bRu;
  boolean dQo;
  
  static
  {
    AppMethodBeat.i(59470);
    ajfc = new h((byte)0);
    AppMethodBeat.o(59470);
  }
  
  private h()
  {
    AppMethodBeat.i(59448);
    this.dQo = false;
    this.ajfb = w.aMm(16);
    AppMethodBeat.o(59448);
  }
  
  private h(byte paramByte)
  {
    AppMethodBeat.i(59449);
    this.dQo = false;
    this.ajfb = w.aMm(0);
    ZP();
    AppMethodBeat.o(59449);
  }
  
  private static int a(aa.a parama, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(59466);
    int i = f.ko(paramInt);
    paramInt = i;
    if (parama == aa.a.ajfO) {
      paramInt = i * 2;
    }
    i = b(parama, paramObject);
    AppMethodBeat.o(59466);
    return paramInt + i;
  }
  
  static int a(aa.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return parama.dWZ;
  }
  
  public static Object a(e parame, aa.a parama)
  {
    AppMethodBeat.i(59461);
    long l;
    int i;
    switch (1.dJl[parama.ordinal()])
    {
    default: 
      parame = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      AppMethodBeat.o(59461);
      throw parame;
    case 1: 
      double d = Double.longBitsToDouble(parame.aay());
      AppMethodBeat.o(59461);
      return Double.valueOf(d);
    case 2: 
      float f = Float.intBitsToFloat(parame.aax());
      AppMethodBeat.o(59461);
      return Float.valueOf(f);
    case 3: 
      l = parame.aaw();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 4: 
      l = parame.aaw();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 5: 
      i = parame.aar();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 6: 
      l = parame.aay();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 7: 
      i = parame.aax();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 8: 
      boolean bool = parame.aai();
      AppMethodBeat.o(59461);
      return Boolean.valueOf(bool);
    case 9: 
      i = parame.aar();
      if ((i <= parame.bufferSize - parame.dXt) && (i > 0))
      {
        parama = new String(parame.buffer, parame.dXt, i, "UTF-8");
        parame.dXt = (i + parame.dXt);
        AppMethodBeat.o(59461);
        return parama;
      }
      if (i == 0)
      {
        AppMethodBeat.o(59461);
        return "";
      }
      parame = new String(parame.aMi(i), "UTF-8");
      AppMethodBeat.o(59461);
      return parame;
    case 10: 
      parame = parame.kyd();
      AppMethodBeat.o(59461);
      return parame;
    case 11: 
      i = parame.aar();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 12: 
      i = parame.aax();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 13: 
      l = parame.aay();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 14: 
      i = parame.aar();
      int j = -(i & 0x1);
      AppMethodBeat.o(59461);
      return Integer.valueOf(j ^ i >>> 1);
    case 15: 
      l = e.cO(parame.aaw());
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
  
  private static void a(aa.a parama, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(59456);
    if (paramObject == null)
    {
      parama = new NullPointerException();
      AppMethodBeat.o(59456);
      throw parama;
    }
    switch (1.dQq[parama.ajfX.ordinal()])
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
        if (((paramObject instanceof Integer)) || ((paramObject instanceof k.a)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof r)) || ((paramObject instanceof m))) {
            bool = true;
          }
        }
      }
    }
    AppMethodBeat.o(59456);
  }
  
  private static void a(f paramf, aa.a parama, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(59462);
    if (parama == aa.a.ajfO)
    {
      parama = (r)paramObject;
      paramf.cE(paramInt, 3);
      parama.a(paramf);
      paramf.cE(paramInt, 4);
      AppMethodBeat.o(59462);
      return;
    }
    paramf.cE(paramInt, a(parama, false));
    a(paramf, parama, paramObject);
    AppMethodBeat.o(59462);
  }
  
  private static void a(f paramf, aa.a parama, Object paramObject)
  {
    AppMethodBeat.i(59463);
    switch (1.dJl[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(59463);
      return;
      paramf.u(((Double)paramObject).doubleValue());
      AppMethodBeat.o(59463);
      return;
      paramf.bd(((Float)paramObject).floatValue());
      AppMethodBeat.o(59463);
      return;
      paramf.dg(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.dg(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.kd(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.BJ(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aMj(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.bZ(((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(59463);
      return;
      paramf.dT((String)paramObject);
      AppMethodBeat.o(59463);
      return;
      ((r)paramObject).a(paramf);
      AppMethodBeat.o(59463);
      return;
      paramf.b((r)paramObject);
      AppMethodBeat.o(59463);
      return;
      if ((paramObject instanceof d))
      {
        paramf.b((d)paramObject);
        AppMethodBeat.o(59463);
        return;
      }
      paramf.dK((byte[])paramObject);
      AppMethodBeat.o(59463);
      return;
      paramf.lI(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aMj(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.BJ(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.kf(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.cQ(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      if ((paramObject instanceof k.a))
      {
        paramf.kd(((k.a)paramObject).getNumber());
        AppMethodBeat.o(59463);
        return;
      }
      paramf.kd(((Integer)paramObject).intValue());
    }
  }
  
  public static void a(a<?> parama, Object paramObject, f paramf)
  {
    AppMethodBeat.i(59464);
    aa.a locala = parama.kyk();
    int i = parama.getNumber();
    if (parama.ahl())
    {
      paramObject = (List)paramObject;
      if (parama.ahm())
      {
        paramf.cE(i, 2);
        i = 0;
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        paramf.lI(i);
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
    if ((paramObject instanceof m))
    {
      AppMethodBeat.o(59464);
      throw null;
    }
    a(paramf, locala, i, paramObject);
    AppMethodBeat.o(59464);
  }
  
  private static int b(aa.a parama, Object paramObject)
  {
    AppMethodBeat.i(59467);
    switch (1.dJl[parama.ordinal()])
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
      i = f.dh(((Long)paramObject).longValue());
      AppMethodBeat.o(59467);
      return i;
    case 4: 
      i = f.dh(((Long)paramObject).longValue());
      AppMethodBeat.o(59467);
      return i;
    case 5: 
      i = f.kp(((Integer)paramObject).intValue());
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
      i = f.dU((String)paramObject);
      AppMethodBeat.o(59467);
      return i;
    case 16: 
      i = ((r)paramObject).getSerializedSize();
      AppMethodBeat.o(59467);
      return i;
    case 10: 
      if ((paramObject instanceof d))
      {
        i = f.d((d)paramObject);
        AppMethodBeat.o(59467);
        return i;
      }
      i = f.D((byte[])paramObject);
      AppMethodBeat.o(59467);
      return i;
    case 11: 
      i = f.kv(((Integer)paramObject).intValue());
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
      i = f.kv(f.ku(((Integer)paramObject).intValue()));
      AppMethodBeat.o(59467);
      return i;
    case 15: 
      i = f.dh(f.cV(((Long)paramObject).longValue()));
      AppMethodBeat.o(59467);
      return i;
    case 17: 
      if ((paramObject instanceof m))
      {
        AppMethodBeat.o(59467);
        throw null;
      }
      i = f.c((r)paramObject);
      AppMethodBeat.o(59467);
      return i;
    }
    if ((paramObject instanceof k.a))
    {
      i = f.kp(((k.a)paramObject).getNumber());
      AppMethodBeat.o(59467);
      return i;
    }
    int i = f.kp(((Integer)paramObject).intValue());
    AppMethodBeat.o(59467);
    return i;
  }
  
  private static Object bv(Object paramObject)
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
  
  public static int c(a<?> parama, Object paramObject)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(59468);
    aa.a locala = parama.kyk();
    int k = parama.getNumber();
    if (parama.ahl())
    {
      if (parama.ahm())
      {
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        j = f.ko(k);
        k = f.kv(i);
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
  
  private static boolean f(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    AppMethodBeat.i(59458);
    a locala = (a)paramEntry.getKey();
    if (locala.kyl() == aa.b.ajgh)
    {
      if (locala.ahl())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((r)paramEntry.next()).isInitialized());
        AppMethodBeat.o(59458);
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof r))
      {
        if (!((r)paramEntry).isInitialized())
        {
          AppMethodBeat.o(59458);
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof m))
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
  
  public static <T extends a<T>> h<T> kyh()
  {
    AppMethodBeat.i(59450);
    h localh = new h();
    AppMethodBeat.o(59450);
    return localh;
  }
  
  public static <T extends a<T>> h<T> kyi()
  {
    return ajfc;
  }
  
  public final void ZP()
  {
    AppMethodBeat.i(59451);
    if (this.bRu)
    {
      AppMethodBeat.o(59451);
      return;
    }
    this.ajfb.ZP();
    this.bRu = true;
    AppMethodBeat.o(59451);
  }
  
  public final Object a(FieldDescriptorType paramFieldDescriptorType, int paramInt)
  {
    AppMethodBeat.i(191763);
    if (!paramFieldDescriptorType.ahl())
    {
      paramFieldDescriptorType = new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      AppMethodBeat.o(191763);
      throw paramFieldDescriptorType;
    }
    paramFieldDescriptorType = b(paramFieldDescriptorType);
    if (paramFieldDescriptorType == null)
    {
      paramFieldDescriptorType = new IndexOutOfBoundsException();
      AppMethodBeat.o(191763);
      throw paramFieldDescriptorType;
    }
    paramFieldDescriptorType = ((List)paramFieldDescriptorType).get(paramInt);
    AppMethodBeat.o(191763);
    return paramFieldDescriptorType;
  }
  
  public final void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    AppMethodBeat.i(59454);
    if (paramFieldDescriptorType.ahl())
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
        a(paramFieldDescriptorType.kyk(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof m)) {
        this.dQo = true;
      }
      this.ajfb.a(paramFieldDescriptorType, paramObject);
      AppMethodBeat.o(59454);
      return;
      a(paramFieldDescriptorType.kyk(), paramObject);
    }
  }
  
  public final boolean a(FieldDescriptorType paramFieldDescriptorType)
  {
    AppMethodBeat.i(191756);
    if (paramFieldDescriptorType.ahl())
    {
      paramFieldDescriptorType = new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
      AppMethodBeat.o(191756);
      throw paramFieldDescriptorType;
    }
    if (this.ajfb.get(paramFieldDescriptorType) != null)
    {
      AppMethodBeat.o(191756);
      return true;
    }
    AppMethodBeat.o(191756);
    return false;
  }
  
  public final Object b(FieldDescriptorType paramFieldDescriptorType)
  {
    AppMethodBeat.i(59453);
    paramFieldDescriptorType = this.ajfb.get(paramFieldDescriptorType);
    if ((paramFieldDescriptorType instanceof m))
    {
      AppMethodBeat.o(59453);
      throw null;
    }
    AppMethodBeat.o(59453);
    return paramFieldDescriptorType;
  }
  
  public final void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    AppMethodBeat.i(59455);
    if (!paramFieldDescriptorType.ahl())
    {
      paramFieldDescriptorType = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
      AppMethodBeat.o(59455);
      throw paramFieldDescriptorType;
    }
    a(paramFieldDescriptorType.kyk(), paramObject);
    Object localObject = b(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.ajfb.a(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (TFieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      AppMethodBeat.o(59455);
      return;
    }
  }
  
  public final int c(FieldDescriptorType paramFieldDescriptorType)
  {
    AppMethodBeat.i(191761);
    if (!paramFieldDescriptorType.ahl())
    {
      paramFieldDescriptorType = new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      AppMethodBeat.o(191761);
      throw paramFieldDescriptorType;
    }
    paramFieldDescriptorType = b(paramFieldDescriptorType);
    if (paramFieldDescriptorType == null)
    {
      AppMethodBeat.o(191761);
      return 0;
    }
    int i = ((List)paramFieldDescriptorType).size();
    AppMethodBeat.o(191761);
    return i;
  }
  
  final void g(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    AppMethodBeat.i(59460);
    a locala = (a)paramEntry.getKey();
    Object localObject2 = paramEntry.getValue();
    if ((localObject2 instanceof m))
    {
      AppMethodBeat.o(59460);
      throw null;
    }
    if (locala.ahl())
    {
      Object localObject1 = b(locala);
      paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
      if (localObject1 == null) {
        paramEntry = new ArrayList();
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        ((List)paramEntry).add(bv(localObject2));
      }
      this.ajfb.a(locala, paramEntry);
      AppMethodBeat.o(59460);
      return;
    }
    if (locala.kyl() == aa.b.ajgh)
    {
      paramEntry = b(locala);
      if (paramEntry == null)
      {
        this.ajfb.a(locala, bv(localObject2));
        AppMethodBeat.o(59460);
        return;
      }
      paramEntry = locala.a(((r)paramEntry).kth(), (r)localObject2).kts();
      this.ajfb.a(locala, paramEntry);
      AppMethodBeat.o(59460);
      return;
    }
    this.ajfb.a(locala, bv(localObject2));
    AppMethodBeat.o(59460);
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(59457);
    int i = 0;
    while (i < this.ajfb.ajq())
    {
      if (!f(this.ajfb.lt(i)))
      {
        AppMethodBeat.o(59457);
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.ajfb.ajr().iterator();
    while (localIterator.hasNext()) {
      if (!f((Map.Entry)localIterator.next()))
      {
        AppMethodBeat.o(59457);
        return false;
      }
    }
    AppMethodBeat.o(59457);
    return true;
  }
  
  public final h<FieldDescriptorType> kyj()
  {
    AppMethodBeat.i(59452);
    h localh = new h();
    int i = 0;
    while (i < this.ajfb.ajq())
    {
      localObject = this.ajfb.lt(i);
      localh.a((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.ajfb.ajr().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localh.a((a)localEntry.getKey(), localEntry.getValue());
    }
    localh.dQo = this.dQo;
    AppMethodBeat.o(59452);
    return localh;
  }
  
  public static abstract interface a<T extends a<T>>
    extends Comparable<T>
  {
    public abstract r.a a(r.a parama, r paramr);
    
    public abstract boolean ahl();
    
    public abstract boolean ahm();
    
    public abstract int getNumber();
    
    public abstract aa.a kyk();
    
    public abstract aa.b kyl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.h
 * JD-Core Version:    0.7.0.1
 */