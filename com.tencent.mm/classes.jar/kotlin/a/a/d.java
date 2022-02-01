package kotlin.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.a.g.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "isReadOnly", "", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "<set-?>", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeKeyAt", "index", "removeValue", "element", "removeValue$kotlin_stdlib", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class d<K, V>
  implements Map<K, V>, kotlin.g.b.a.g
{
  private static final a aivR;
  private boolean aivE;
  private int aivI;
  private f<K> aivJ;
  private g<V> aivK;
  private e<K, V> aivL;
  private K[] aivM;
  V[] aivN;
  private int[] aivO;
  private int[] aivP;
  private int aivQ;
  private int length;
  private int size;
  
  static
  {
    AppMethodBeat.i(191133);
    aivR = new a((byte)0);
    AppMethodBeat.o(191133);
  }
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    this(c.aKk(8), new int[8], new int[a.aKp(8)]);
    AppMethodBeat.i(191128);
    AppMethodBeat.o(191128);
  }
  
  private d(K[] paramArrayOfK, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(191117);
    this.aivM = paramArrayOfK;
    this.aivN = null;
    this.aivO = paramArrayOfInt1;
    this.aivP = paramArrayOfInt2;
    this.aivQ = 2;
    this.length = 0;
    this.aivI = (Integer.numberOfLeadingZeros(this.aivP.length) + 1);
    AppMethodBeat.o(191117);
  }
  
  private final void aKl(int paramInt)
  {
    AppMethodBeat.i(191042);
    ensureCapacity(this.length + paramInt);
    AppMethodBeat.o(191042);
  }
  
  private final boolean aKm(int paramInt)
  {
    AppMethodBeat.i(191104);
    int i = bO(this.aivM[paramInt]);
    int j = this.aivQ;
    for (;;)
    {
      if (this.aivP[i] == 0)
      {
        this.aivP[i] = (paramInt + 1);
        this.aivO[paramInt] = i;
        AppMethodBeat.o(191104);
        return true;
      }
      j -= 1;
      if (j < 0)
      {
        AppMethodBeat.o(191104);
        return false;
      }
      if (i == 0) {
        i = this.aivP.length - 1;
      } else {
        i -= 1;
      }
    }
  }
  
  private final void aKo(int paramInt)
  {
    AppMethodBeat.i(191111);
    int k = kotlin.k.k.qv(this.aivQ * 2, this.aivP.length / 2);
    int i = 0;
    int j = paramInt;
    int m = paramInt;
    for (;;)
    {
      paramInt = j - 1;
      if (j == 0) {
        paramInt = this.aivP.length - 1;
      }
      int n = i + 1;
      if (n > this.aivQ)
      {
        this.aivP[m] = 0;
        AppMethodBeat.o(191111);
        return;
      }
      int i1 = this.aivP[paramInt];
      if (i1 == 0)
      {
        this.aivP[m] = 0;
        AppMethodBeat.o(191111);
        return;
      }
      if (i1 < 0)
      {
        this.aivP[m] = -1;
        i = 0;
        j = paramInt;
      }
      for (;;)
      {
        k -= 1;
        if (k >= 0) {
          break;
        }
        this.aivP[j] = -1;
        AppMethodBeat.o(191111);
        return;
        i = n;
        j = m;
        if ((bO(this.aivM[(i1 - 1)]) - paramInt & this.aivP.length - 1) >= n)
        {
          this.aivP[m] = i1;
          this.aivO[(i1 - 1)] = m;
          i = 0;
          j = paramInt;
        }
      }
      m = j;
      j = paramInt;
    }
  }
  
  private final int bO(K paramK)
  {
    AppMethodBeat.i(191079);
    if (paramK != null) {}
    for (int i = paramK.hashCode();; i = 0)
    {
      int j = this.aivI;
      AppMethodBeat.o(191079);
      return i * -1640531527 >>> j;
    }
  }
  
  private final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191056);
    int i;
    if (paramInt > this.aivM.length)
    {
      i = this.aivM.length * 3 / 2;
      if (paramInt <= i) {
        break label149;
      }
    }
    for (;;)
    {
      this.aivM = c.n(this.aivM, paramInt);
      Object localObject = this.aivN;
      if (localObject != null) {}
      for (localObject = c.n((Object[])localObject, paramInt);; localObject = null)
      {
        this.aivN = ((Object[])localObject);
        localObject = Arrays.copyOf(this.aivO, paramInt);
        s.s(localObject, "java.util.Arrays.copyOf(this, newSize)");
        this.aivO = ((int[])localObject);
        paramInt = a.aKp(paramInt);
        if (paramInt <= this.aivP.length) {
          break;
        }
        lV(paramInt);
        AppMethodBeat.o(191056);
        return;
      }
      if (this.length + paramInt - size() > this.aivM.length) {
        lV(this.aivP.length);
      }
      AppMethodBeat.o(191056);
      return;
      label149:
      paramInt = i;
    }
  }
  
  private final V[] kld()
  {
    AppMethodBeat.i(191067);
    Object[] arrayOfObject = this.aivN;
    if (arrayOfObject != null)
    {
      AppMethodBeat.o(191067);
      return arrayOfObject;
    }
    arrayOfObject = c.aKk(this.aivM.length);
    this.aivN = arrayOfObject;
    AppMethodBeat.o(191067);
    return arrayOfObject;
  }
  
  private final void kle()
  {
    AppMethodBeat.i(191087);
    Object[] arrayOfObject1 = this.aivN;
    int j = 0;
    int i = 0;
    while (i < this.length)
    {
      int k = j;
      if (this.aivO[i] >= 0)
      {
        Object[] arrayOfObject2 = this.aivM;
        arrayOfObject2[j] = arrayOfObject2[i];
        if (arrayOfObject1 != null) {
          arrayOfObject1[j] = arrayOfObject1[i];
        }
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    c.f(this.aivM, j, this.length);
    if (arrayOfObject1 != null) {
      c.f(arrayOfObject1, j, this.length);
    }
    this.length = j;
    AppMethodBeat.o(191087);
  }
  
  private final void lV(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(191094);
    if (this.length > size()) {
      kle();
    }
    if (paramInt != this.aivP.length)
    {
      this.aivP = new int[paramInt];
      this.aivI = (Integer.numberOfLeadingZeros(paramInt) + 1);
      paramInt = i;
    }
    while (paramInt < this.length) {
      if (!aKm(paramInt))
      {
        Throwable localThrowable = (Throwable)new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
        AppMethodBeat.o(191094);
        throw localThrowable;
        kotlin.a.k.m(this.aivP, 0, this.aivP.length);
        paramInt = i;
      }
      else
      {
        paramInt += 1;
      }
    }
    AppMethodBeat.o(191094);
  }
  
  public final boolean K(Collection<?> paramCollection)
  {
    AppMethodBeat.i(191310);
    s.u(paramCollection, "m");
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (localObject != null) {}
      try
      {
        if (!n((Map.Entry)localObject))
        {
          AppMethodBeat.o(191310);
          return false;
        }
      }
      catch (ClassCastException paramCollection)
      {
        AppMethodBeat.o(191310);
        return false;
      }
    }
    AppMethodBeat.o(191310);
    return true;
  }
  
  final void aKn(int paramInt)
  {
    AppMethodBeat.i(191297);
    c.o(this.aivM, paramInt);
    aKo(this.aivO[paramInt]);
    this.aivO[paramInt] = -1;
    this.size = (size() - 1);
    AppMethodBeat.o(191297);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191214);
    klc();
    int j = this.length - 1;
    if (j >= 0)
    {
      int i = 0;
      for (;;)
      {
        int k = this.aivO[i];
        if (k >= 0)
        {
          this.aivP[k] = 0;
          this.aivO[i] = -1;
        }
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    c.f(this.aivM, 0, this.length);
    Object[] arrayOfObject = this.aivN;
    if (arrayOfObject != null) {
      c.f(arrayOfObject, 0, this.length);
    }
    this.size = 0;
    this.length = 0;
    AppMethodBeat.o(191214);
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(191176);
    if (ht(paramObject) >= 0)
    {
      AppMethodBeat.o(191176);
      return true;
    }
    AppMethodBeat.o(191176);
    return false;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(191183);
    if (hu(paramObject) >= 0)
    {
      AppMethodBeat.o(191183);
      return true;
    }
    AppMethodBeat.o(191183);
    return false;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    AppMethodBeat.i(191233);
    Object localObject = this.aivL;
    if (localObject == null)
    {
      localObject = new e(this);
      this.aivL = ((e)localObject);
      localObject = (Set)localObject;
      AppMethodBeat.o(191233);
      return localObject;
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(191233);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191241);
    if (paramObject != (d)this)
    {
      if (!(paramObject instanceof Map)) {
        break label74;
      }
      paramObject = (Map)paramObject;
      if ((size() != paramObject.size()) || (!K((Collection)paramObject.entrySet()))) {
        break label69;
      }
    }
    label69:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(191241);
      return true;
    }
    label74:
    AppMethodBeat.o(191241);
    return false;
  }
  
  public final V get(Object paramObject)
  {
    AppMethodBeat.i(191188);
    int i = ht(paramObject);
    if (i < 0)
    {
      AppMethodBeat.o(191188);
      return null;
    }
    paramObject = this.aivN;
    s.checkNotNull(paramObject);
    paramObject = paramObject[i];
    AppMethodBeat.o(191188);
    return paramObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191249);
    Object localObject1 = klg();
    int i = 0;
    if (((b)localObject1).hasNext())
    {
      if (((d)localObject1).index >= ((d)localObject1).aivS.length)
      {
        localObject1 = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(191249);
        throw ((Throwable)localObject1);
      }
      int j = ((d)localObject1).index;
      ((d)localObject1).index = (j + 1);
      ((d)localObject1).lastIndex = j;
      Object localObject2 = localObject1.aivS.aivM[localObject1.lastIndex];
      if (localObject2 != null)
      {
        j = localObject2.hashCode();
        label106:
        localObject2 = ((d)localObject1).aivS.aivN;
        s.checkNotNull(localObject2);
        localObject2 = localObject2[localObject1.lastIndex];
        if (localObject2 == null) {
          break label161;
        }
      }
      label161:
      for (int k = localObject2.hashCode();; k = 0)
      {
        ((b)localObject1).klh();
        i += (j ^ k);
        break;
        j = 0;
        break label106;
      }
    }
    AppMethodBeat.o(191249);
    return i;
  }
  
  final int ht(K paramK)
  {
    AppMethodBeat.i(191271);
    int i = bO(paramK);
    int j = this.aivQ;
    for (;;)
    {
      int k = this.aivP[i];
      if (k == 0)
      {
        AppMethodBeat.o(191271);
        return -1;
      }
      if ((k > 0) && (s.p(this.aivM[(k - 1)], paramK)))
      {
        AppMethodBeat.o(191271);
        return k - 1;
      }
      j -= 1;
      if (j < 0)
      {
        AppMethodBeat.o(191271);
        return -1;
      }
      if (i == 0) {
        i = this.aivP.length - 1;
      } else {
        i -= 1;
      }
    }
  }
  
  final int hu(V paramV)
  {
    AppMethodBeat.i(191277);
    int i = this.length;
    int j;
    Object[] arrayOfObject;
    do
    {
      do
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
      } while (this.aivO[j] < 0);
      arrayOfObject = this.aivN;
      s.checkNotNull(arrayOfObject);
      i = j;
    } while (!s.p(arrayOfObject[j], paramV));
    AppMethodBeat.o(191277);
    return j;
    AppMethodBeat.o(191277);
    return -1;
  }
  
  public final int hv(K paramK)
  {
    AppMethodBeat.i(191284);
    klc();
    int i = bO(paramK);
    int k = kotlin.k.k.qv(this.aivQ * 2, this.aivP.length / 2);
    int j = 0;
    for (;;)
    {
      int m = this.aivP[i];
      if (m <= 0)
      {
        if (this.length >= this.aivM.length)
        {
          aKl(1);
          break;
        }
        k = this.length;
        this.length = (k + 1);
        this.aivM[k] = paramK;
        this.aivO[k] = i;
        this.aivP[i] = (k + 1);
        this.size = (size() + 1);
        if (j > this.aivQ) {
          this.aivQ = j;
        }
        AppMethodBeat.o(191284);
        return k;
      }
      if (s.p(this.aivM[(m - 1)], paramK))
      {
        i = -m;
        AppMethodBeat.o(191284);
        return i;
      }
      j += 1;
      if (j > k)
      {
        lV(this.aivP.length * 2);
        break;
      }
      if (i == 0) {
        i = this.aivP.length - 1;
      } else {
        i -= 1;
      }
    }
  }
  
  public final int hw(K paramK)
  {
    AppMethodBeat.i(191293);
    klc();
    int i = ht(paramK);
    if (i < 0)
    {
      AppMethodBeat.o(191293);
      return -1;
    }
    aKn(i);
    AppMethodBeat.o(191293);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(191169);
    if (size() == 0)
    {
      AppMethodBeat.o(191169);
      return true;
    }
    AppMethodBeat.o(191169);
    return false;
  }
  
  public final Set<K> keySet()
  {
    AppMethodBeat.i(191221);
    Object localObject = this.aivJ;
    if (localObject == null)
    {
      localObject = new f(this);
      this.aivJ = ((f)localObject);
      localObject = (Set)localObject;
      AppMethodBeat.o(191221);
      return localObject;
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(191221);
    return localObject;
  }
  
  public final Map<K, V> klb()
  {
    AppMethodBeat.i(191164);
    klc();
    this.aivE = true;
    Map localMap = (Map)this;
    AppMethodBeat.o(191164);
    return localMap;
  }
  
  public final void klc()
  {
    AppMethodBeat.i(191264);
    if (this.aivE)
    {
      Throwable localThrowable = (Throwable)new UnsupportedOperationException();
      AppMethodBeat.o(191264);
      throw localThrowable;
    }
    AppMethodBeat.o(191264);
  }
  
  public final e<K, V> klf()
  {
    AppMethodBeat.i(191317);
    e locale = new e(this);
    AppMethodBeat.o(191317);
    return locale;
  }
  
  public final b<K, V> klg()
  {
    AppMethodBeat.i(191322);
    b localb = new b(this);
    AppMethodBeat.o(191322);
    return localb;
  }
  
  public final boolean n(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(191304);
    s.u(paramEntry, "entry");
    int i = ht(paramEntry.getKey());
    if (i < 0)
    {
      AppMethodBeat.o(191304);
      return false;
    }
    Object[] arrayOfObject = this.aivN;
    s.checkNotNull(arrayOfObject);
    boolean bool = s.p(arrayOfObject[i], paramEntry.getValue());
    AppMethodBeat.o(191304);
    return bool;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(191194);
    klc();
    int i = hv(paramK);
    paramK = kld();
    if (i < 0)
    {
      V ? = paramK[(-i - 1)];
      paramK[(-i - 1)] = paramV;
      AppMethodBeat.o(191194);
      return ?;
    }
    paramK[i] = paramV;
    AppMethodBeat.o(191194);
    return null;
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(191202);
    s.u(paramMap, "from");
    klc();
    paramMap = (Collection)paramMap.entrySet();
    if (!paramMap.isEmpty())
    {
      aKl(paramMap.size());
      paramMap = paramMap.iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        int i = hv(localEntry.getKey());
        Object[] arrayOfObject = kld();
        if (i >= 0)
        {
          arrayOfObject[i] = localEntry.getValue();
        }
        else
        {
          Object localObject = arrayOfObject[(-i - 1)];
          if ((s.p(localEntry.getValue(), localObject) ^ true)) {
            arrayOfObject[(-i - 1)] = localEntry.getValue();
          }
        }
      }
    }
    AppMethodBeat.o(191202);
  }
  
  public final V remove(Object paramObject)
  {
    AppMethodBeat.i(191208);
    int i = hw(paramObject);
    if (i < 0)
    {
      AppMethodBeat.o(191208);
      return null;
    }
    paramObject = this.aivN;
    s.checkNotNull(paramObject);
    V ? = paramObject[i];
    c.o(paramObject, i);
    AppMethodBeat.o(191208);
    return ?;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191256);
    Object localObject1 = new StringBuilder(size() * 3 + 2);
    ((StringBuilder)localObject1).append("{");
    int i = 0;
    b localb = klg();
    if (localb.hasNext())
    {
      if (i > 0) {
        ((StringBuilder)localObject1).append(", ");
      }
      s.u(localObject1, "sb");
      if (localb.index >= localb.aivS.length)
      {
        localObject1 = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(191256);
        throw ((Throwable)localObject1);
      }
      int j = localb.index;
      localb.index = (j + 1);
      localb.lastIndex = j;
      Object localObject2 = localb.aivS.aivM[localb.lastIndex];
      if (s.p(localObject2, localb.aivS))
      {
        ((StringBuilder)localObject1).append("(this Map)");
        label157:
        ((StringBuilder)localObject1).append('=');
        localObject2 = localb.aivS.aivN;
        s.checkNotNull(localObject2);
        localObject2 = localObject2[localb.lastIndex];
        if (!s.p(localObject2, localb.aivS)) {
          break label232;
        }
        ((StringBuilder)localObject1).append("(this Map)");
      }
      for (;;)
      {
        localb.klh();
        i += 1;
        break;
        ((StringBuilder)localObject1).append(localObject2);
        break label157;
        label232:
        ((StringBuilder)localObject1).append(localObject2);
      }
    }
    ((StringBuilder)localObject1).append("}");
    localObject1 = ((StringBuilder)localObject1).toString();
    s.s(localObject1, "sb.toString()");
    AppMethodBeat.o(191256);
    return localObject1;
  }
  
  public final Collection<V> values()
  {
    AppMethodBeat.i(191229);
    Object localObject = this.aivK;
    if (localObject == null)
    {
      localObject = new g(this);
      this.aivK = ((g)localObject);
      localObject = (Collection)localObject;
      AppMethodBeat.o(191229);
      return localObject;
    }
    localObject = (Collection)localObject;
    AppMethodBeat.o(191229);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a
  {
    static int aKp(int paramInt)
    {
      AppMethodBeat.i(191074);
      paramInt = Integer.highestOneBit(kotlin.k.k.qu(paramInt, 1) * 3);
      AppMethodBeat.o(191074);
      return paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class b<K, V>
    extends d.d<K, V>
    implements Iterator<Map.Entry<K, V>>, kotlin.g.b.a.d
  {
    public b(d<K, V> paramd)
    {
      super();
      AppMethodBeat.i(191049);
      AppMethodBeat.o(191049);
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class c<K, V>
    implements Map.Entry<K, V>, g.a
  {
    private final d<K, V> aivS;
    private final int index;
    
    public c(d<K, V> paramd, int paramInt)
    {
      AppMethodBeat.i(191046);
      this.aivS = paramd;
      this.index = paramInt;
      AppMethodBeat.o(191046);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(191085);
      if (((paramObject instanceof Map.Entry)) && (s.p(((Map.Entry)paramObject).getKey(), getKey())) && (s.p(((Map.Entry)paramObject).getValue(), getValue())))
      {
        AppMethodBeat.o(191085);
        return true;
      }
      AppMethodBeat.o(191085);
      return false;
    }
    
    public final K getKey()
    {
      AppMethodBeat.i(191057);
      Object localObject = d.c(this.aivS)[this.index];
      AppMethodBeat.o(191057);
      return localObject;
    }
    
    public final V getValue()
    {
      AppMethodBeat.i(191068);
      Object localObject = d.d(this.aivS);
      s.checkNotNull(localObject);
      localObject = localObject[this.index];
      AppMethodBeat.o(191068);
      return localObject;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(191092);
      Object localObject = getKey();
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = getValue();
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(191092);
        return i ^ j;
      }
    }
    
    public final V setValue(V paramV)
    {
      AppMethodBeat.i(191078);
      this.aivS.klc();
      Object[] arrayOfObject = d.e(this.aivS);
      Object localObject = arrayOfObject[this.index];
      arrayOfObject[this.index] = paramV;
      AppMethodBeat.o(191078);
      return localObject;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(191102);
      String str = getKey() + '=' + getValue();
      AppMethodBeat.o(191102);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "hasNext", "", "initNext", "", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static class d<K, V>
  {
    final d<K, V> aivS;
    int index;
    int lastIndex;
    
    public d(d<K, V> paramd)
    {
      AppMethodBeat.i(191069);
      this.aivS = paramd;
      this.lastIndex = -1;
      klh();
      AppMethodBeat.o(191069);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(191088);
      if (this.index < d.a(this.aivS))
      {
        AppMethodBeat.o(191088);
        return true;
      }
      AppMethodBeat.o(191088);
      return false;
    }
    
    public final void klh()
    {
      AppMethodBeat.i(191080);
      while ((this.index < d.a(this.aivS)) && (d.b(this.aivS)[this.index] < 0)) {
        this.index += 1;
      }
      AppMethodBeat.o(191080);
    }
    
    public final void remove()
    {
      AppMethodBeat.i(191096);
      if (this.lastIndex != -1) {}
      for (int i = 1; i == 0; i = 0)
      {
        Throwable localThrowable = (Throwable)new IllegalStateException("Call next() before removing element from the iterator.".toString());
        AppMethodBeat.o(191096);
        throw localThrowable;
      }
      this.aivS.klc();
      d.a(this.aivS, this.lastIndex);
      this.lastIndex = -1;
      AppMethodBeat.o(191096);
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class e<K, V>
    extends d.d<K, V>
    implements Iterator<K>, kotlin.g.b.a.d
  {
    public e(d<K, V> paramd)
    {
      super();
      AppMethodBeat.i(191062);
      AppMethodBeat.o(191062);
    }
    
    public final K next()
    {
      AppMethodBeat.i(191077);
      if (this.index >= d.a(this.aivS))
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(191077);
        throw ((Throwable)localObject);
      }
      int i = this.index;
      this.index = (i + 1);
      this.lastIndex = i;
      Object localObject = d.c(this.aivS)[this.lastIndex];
      klh();
      AppMethodBeat.o(191077);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class f<K, V>
    extends d.d<K, V>
    implements Iterator<V>, kotlin.g.b.a.d
  {
    public f(d<K, V> paramd)
    {
      super();
      AppMethodBeat.i(191040);
      AppMethodBeat.o(191040);
    }
    
    public final V next()
    {
      AppMethodBeat.i(191052);
      if (this.index >= d.a(this.aivS))
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(191052);
        throw ((Throwable)localObject);
      }
      int i = this.index;
      this.index = (i + 1);
      this.lastIndex = i;
      Object localObject = d.d(this.aivS);
      s.checkNotNull(localObject);
      localObject = localObject[this.lastIndex];
      klh();
      AppMethodBeat.o(191052);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.a.a.d
 * JD-Core Version:    0.7.0.1
 */