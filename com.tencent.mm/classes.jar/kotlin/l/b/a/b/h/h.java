package kotlin.l.b.a.b.h;

import TFieldDescriptorType;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;

public final class h<FieldDescriptorType extends h.a<FieldDescriptorType>>
{
  private static final h abgl;
  final w<FieldDescriptorType, Object> abgk;
  private boolean bWA;
  boolean bWB;
  
  static
  {
    AppMethodBeat.i(59470);
    abgl = new h((byte)0);
    AppMethodBeat.o(59470);
  }
  
  private h()
  {
    AppMethodBeat.i(59448);
    this.bWB = false;
    this.abgk = w.aFy(16);
    AppMethodBeat.o(59448);
  }
  
  private h(byte paramByte)
  {
    AppMethodBeat.i(59449);
    this.bWB = false;
    this.abgk = w.aFy(0);
    Al();
    AppMethodBeat.o(59449);
  }
  
  private static int a(aa.a parama, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(59466);
    int i = f.gL(paramInt);
    paramInt = i;
    if (parama == aa.a.abhb) {
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
    return parama.ccy;
  }
  
  public static Object a(e parame, aa.a parama)
  {
    AppMethodBeat.i(59461);
    long l;
    int i;
    switch (1.bWE[parama.ordinal()])
    {
    default: 
      parame = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      AppMethodBeat.o(59461);
      throw parame;
    case 1: 
      double d = Double.longBitsToDouble(parame.AP());
      AppMethodBeat.o(59461);
      return Double.valueOf(d);
    case 2: 
      float f = Float.intBitsToFloat(parame.AO());
      AppMethodBeat.o(59461);
      return Float.valueOf(f);
    case 3: 
      l = parame.AN();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 4: 
      l = parame.AN();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 5: 
      i = parame.AK();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 6: 
      l = parame.AP();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 7: 
      i = parame.AO();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 8: 
      boolean bool = parame.AB();
      AppMethodBeat.o(59461);
      return Boolean.valueOf(bool);
    case 9: 
      i = parame.AK();
      if ((i <= parame.bufferSize - parame.ccP) && (i > 0))
      {
        parama = new String(parame.buffer, parame.ccP, i, "UTF-8");
        parame.ccP = (i + parame.ccP);
        AppMethodBeat.o(59461);
        return parama;
      }
      if (i == 0)
      {
        AppMethodBeat.o(59461);
        return "";
      }
      parame = new String(parame.aFt(i), "UTF-8");
      AppMethodBeat.o(59461);
      return parame;
    case 10: 
      parame = parame.iNL();
      AppMethodBeat.o(59461);
      return parame;
    case 11: 
      i = parame.AK();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 12: 
      i = parame.AO();
      AppMethodBeat.o(59461);
      return Integer.valueOf(i);
    case 13: 
      l = parame.AP();
      AppMethodBeat.o(59461);
      return Long.valueOf(l);
    case 14: 
      i = parame.AK();
      int j = -(i & 0x1);
      AppMethodBeat.o(59461);
      return Integer.valueOf(j ^ i >>> 1);
    case 15: 
      l = e.Xx(parame.AN());
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
    switch (1.bWD[parama.abhk.ordinal()])
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
    if (parama == aa.a.abhb)
    {
      parama = (r)paramObject;
      paramf.bI(paramInt, 3);
      parama.a(paramf);
      paramf.bI(paramInt, 4);
      AppMethodBeat.o(59462);
      return;
    }
    paramf.bI(paramInt, a(parama, false));
    a(paramf, parama, paramObject);
    AppMethodBeat.o(59462);
  }
  
  private static void a(f paramf, aa.a parama, Object paramObject)
  {
    AppMethodBeat.i(59463);
    switch (1.bWE[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(59463);
      return;
      paramf.f(((Double)paramObject).doubleValue());
      AppMethodBeat.o(59463);
      return;
      paramf.ac(((Float)paramObject).floatValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aN(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aN(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.gD(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.Xz(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aFv(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.br(((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(59463);
      return;
      paramf.cu((String)paramObject);
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
      paramf.dH((byte[])paramObject);
      AppMethodBeat.o(59463);
      return;
      paramf.hT(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aFv(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.Xz(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      paramf.gF(((Integer)paramObject).intValue());
      AppMethodBeat.o(59463);
      return;
      paramf.aB(((Long)paramObject).longValue());
      AppMethodBeat.o(59463);
      return;
      if ((paramObject instanceof k.a))
      {
        paramf.gD(((k.a)paramObject).getNumber());
        AppMethodBeat.o(59463);
        return;
      }
      paramf.gD(((Integer)paramObject).intValue());
    }
  }
  
  public static void a(h.a<?> parama, Object paramObject, f paramf)
  {
    AppMethodBeat.i(59464);
    aa.a locala = parama.iNS();
    int i = parama.getNumber();
    if (parama.Hp())
    {
      paramObject = (List)paramObject;
      if (parama.Hq())
      {
        paramf.bI(i, 2);
        i = 0;
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        paramf.hT(i);
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
  
  private static Object an(Object paramObject)
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
  
  private static int b(aa.a parama, Object paramObject)
  {
    AppMethodBeat.i(59467);
    switch (1.bWE[parama.ordinal()])
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
      i = f.aO(((Long)paramObject).longValue());
      AppMethodBeat.o(59467);
      return i;
    case 4: 
      i = f.aO(((Long)paramObject).longValue());
      AppMethodBeat.o(59467);
      return i;
    case 5: 
      i = f.gM(((Integer)paramObject).intValue());
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
      i = f.cv((String)paramObject);
      AppMethodBeat.o(59467);
      return i;
    case 16: 
      i = ((r)paramObject).Ad();
      AppMethodBeat.o(59467);
      return i;
    case 10: 
      if ((paramObject instanceof d))
      {
        i = f.d((d)paramObject);
        AppMethodBeat.o(59467);
        return i;
      }
      i = f.B((byte[])paramObject);
      AppMethodBeat.o(59467);
      return i;
    case 11: 
      i = f.gR(((Integer)paramObject).intValue());
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
      i = f.gR(f.gQ(((Integer)paramObject).intValue()));
      AppMethodBeat.o(59467);
      return i;
    case 15: 
      i = f.aO(f.aG(((Long)paramObject).longValue()));
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
      i = f.gM(((k.a)paramObject).getNumber());
      AppMethodBeat.o(59467);
      return i;
    }
    int i = f.gM(((Integer)paramObject).intValue());
    AppMethodBeat.o(59467);
    return i;
  }
  
  private static boolean b(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    AppMethodBeat.i(59458);
    h.a locala = (h.a)paramEntry.getKey();
    if (locala.iNT() == aa.b.abhu)
    {
      if (locala.Hp())
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
  
  public static int c(h.a<?> parama, Object paramObject)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(59468);
    aa.a locala = parama.iNS();
    int k = parama.getNumber();
    if (parama.Hp())
    {
      if (parama.Hq())
      {
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        j = f.gL(k);
        k = f.gR(i);
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
  
  public static <T extends h.a<T>> h<T> iNP()
  {
    AppMethodBeat.i(59450);
    h localh = new h();
    AppMethodBeat.o(59450);
    return localh;
  }
  
  public static <T extends h.a<T>> h<T> iNQ()
  {
    return abgl;
  }
  
  public final void Al()
  {
    AppMethodBeat.i(59451);
    if (this.bWA)
    {
      AppMethodBeat.o(59451);
      return;
    }
    this.abgk.Al();
    this.bWA = true;
    AppMethodBeat.o(59451);
  }
  
  public final void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    AppMethodBeat.i(59454);
    if (paramFieldDescriptorType.Hp())
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
        a(paramFieldDescriptorType.iNS(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof m)) {
        this.bWB = true;
      }
      this.abgk.a(paramFieldDescriptorType, paramObject);
      AppMethodBeat.o(59454);
      return;
      a(paramFieldDescriptorType.iNS(), paramObject);
    }
  }
  
  public final boolean a(FieldDescriptorType paramFieldDescriptorType)
  {
    AppMethodBeat.i(268039);
    if (paramFieldDescriptorType.Hp())
    {
      paramFieldDescriptorType = new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
      AppMethodBeat.o(268039);
      throw paramFieldDescriptorType;
    }
    if (this.abgk.get(paramFieldDescriptorType) != null)
    {
      AppMethodBeat.o(268039);
      return true;
    }
    AppMethodBeat.o(268039);
    return false;
  }
  
  public final Object b(FieldDescriptorType paramFieldDescriptorType)
  {
    AppMethodBeat.i(59453);
    paramFieldDescriptorType = this.abgk.get(paramFieldDescriptorType);
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
    if (!paramFieldDescriptorType.Hp())
    {
      paramFieldDescriptorType = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
      AppMethodBeat.o(59455);
      throw paramFieldDescriptorType;
    }
    a(paramFieldDescriptorType.iNS(), paramObject);
    Object localObject = b(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.abgk.a(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (TFieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      AppMethodBeat.o(59455);
      return;
    }
  }
  
  final void c(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    AppMethodBeat.i(59460);
    h.a locala = (h.a)paramEntry.getKey();
    Object localObject2 = paramEntry.getValue();
    if ((localObject2 instanceof m))
    {
      AppMethodBeat.o(59460);
      throw null;
    }
    if (locala.Hp())
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
        ((List)paramEntry).add(an(localObject2));
      }
      this.abgk.a(locala, paramEntry);
      AppMethodBeat.o(59460);
      return;
    }
    if (locala.iNT() == aa.b.abhu)
    {
      paramEntry = b(locala);
      if (paramEntry == null)
      {
        this.abgk.a(locala, an(localObject2));
        AppMethodBeat.o(59460);
        return;
      }
      paramEntry = locala.a(((r)paramEntry).iIP(), (r)localObject2).iJa();
      this.abgk.a(locala, paramEntry);
      AppMethodBeat.o(59460);
      return;
    }
    this.abgk.a(locala, an(localObject2));
    AppMethodBeat.o(59460);
  }
  
  public final h<FieldDescriptorType> iNR()
  {
    AppMethodBeat.i(59452);
    h localh = new h();
    int i = 0;
    while (i < this.abgk.IX())
    {
      localObject = this.abgk.hD(i);
      localh.a((h.a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.abgk.IY().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localh.a((h.a)localEntry.getKey(), localEntry.getValue());
    }
    localh.bWB = this.bWB;
    AppMethodBeat.o(59452);
    return localh;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(59457);
    int i = 0;
    while (i < this.abgk.IX())
    {
      if (!b(this.abgk.hD(i)))
      {
        AppMethodBeat.o(59457);
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.abgk.IY().iterator();
    while (localIterator.hasNext()) {
      if (!b((Map.Entry)localIterator.next()))
      {
        AppMethodBeat.o(59457);
        return false;
      }
    }
    AppMethodBeat.o(59457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.h.h
 * JD-Core Version:    0.7.0.1
 */