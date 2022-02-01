package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class j<E>
  extends e<E>
{
  private static final Object[] aivn;
  public static final a aivo;
  private int aivl;
  private Object[] aivm = aivn;
  private int size;
  
  static
  {
    AppMethodBeat.i(191157);
    aivo = new a((byte)0);
    aivn = new Object[0];
    AppMethodBeat.o(191157);
  }
  
  private final int aKe(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= this.aivm.length) {
      i = paramInt - this.aivm.length;
    }
    return i;
  }
  
  private final int aKf(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + this.aivm.length;
    }
    return i;
  }
  
  private final int aKg(int paramInt)
  {
    AppMethodBeat.i(191136);
    if (paramInt == k.ad(this.aivm))
    {
      AppMethodBeat.o(191136);
      return 0;
    }
    AppMethodBeat.o(191136);
    return paramInt + 1;
  }
  
  private final int aKh(int paramInt)
  {
    AppMethodBeat.i(191140);
    if (paramInt == 0)
    {
      paramInt = k.ad(this.aivm);
      AppMethodBeat.o(191140);
      return paramInt;
    }
    AppMethodBeat.o(191140);
    return paramInt - 1;
  }
  
  private final void b(int paramInt, Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(191150);
    Iterator localIterator = paramCollection.iterator();
    int i = this.aivm.length;
    while ((paramInt < i) && (localIterator.hasNext()))
    {
      this.aivm[paramInt] = localIterator.next();
      paramInt += 1;
    }
    paramInt = 0;
    i = this.aivl;
    while ((paramInt < i) && (localIterator.hasNext()))
    {
      this.aivm[paramInt] = localIterator.next();
      paramInt += 1;
    }
    this.size = (size() + paramCollection.size());
    AppMethodBeat.o(191150);
  }
  
  private final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191121);
    if (paramInt < 0)
    {
      localObject = (Throwable)new IllegalStateException("Deque is too big.");
      AppMethodBeat.o(191121);
      throw ((Throwable)localObject);
    }
    if (paramInt <= this.aivm.length)
    {
      AppMethodBeat.o(191121);
      return;
    }
    if (this.aivm == aivn)
    {
      this.aivm = new Object[kotlin.k.k.qu(paramInt, 10)];
      AppMethodBeat.o(191121);
      return;
    }
    Object localObject = new Object[a.ql(this.aivm.length, paramInt)];
    k.a(this.aivm, (Object[])localObject, 0, this.aivl, this.aivm.length);
    k.a(this.aivm, (Object[])localObject, this.aivm.length - this.aivl, 0, this.aivl);
    this.aivl = 0;
    this.aivm = ((Object[])localObject);
    AppMethodBeat.o(191121);
  }
  
  private E kkU()
  {
    AppMethodBeat.i(191146);
    if (isEmpty())
    {
      localObject = (Throwable)new NoSuchElementException("ArrayDeque is empty.");
      AppMethodBeat.o(191146);
      throw ((Throwable)localObject);
    }
    int i = this.aivl;
    Object localObject = this.aivm[i];
    this.aivm[this.aivl] = null;
    this.aivl = aKg(this.aivl);
    this.size = (size() - 1);
    AppMethodBeat.o(191146);
    return localObject;
  }
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(191187);
    Object localObject = b.aivb;
    b.a.qk(paramInt, size());
    if (paramInt == size())
    {
      hr(paramE);
      AppMethodBeat.o(191187);
      return;
    }
    if (paramInt == 0)
    {
      ensureCapacity(size() + 1);
      this.aivl = aKh(this.aivl);
      this.aivm[this.aivl] = paramE;
      this.size = (size() + 1);
      AppMethodBeat.o(191187);
      return;
    }
    ensureCapacity(size() + 1);
    int i = aKe(this.aivl + paramInt);
    if (paramInt < size() + 1 >> 1)
    {
      paramInt = aKh(i);
      i = aKh(this.aivl);
      if (paramInt >= this.aivl)
      {
        localObject = this.aivm;
        localObject[i] = localObject[this.aivl];
        k.a(this.aivm, this.aivm, this.aivl, this.aivl + 1, paramInt + 1);
      }
      for (;;)
      {
        this.aivm[paramInt] = paramE;
        this.aivl = i;
        this.size = (size() + 1);
        AppMethodBeat.o(191187);
        return;
        k.a(this.aivm, this.aivm, this.aivl - 1, this.aivl, this.aivm.length);
        this.aivm[(this.aivm.length - 1)] = this.aivm[0];
        k.a(this.aivm, this.aivm, 0, 1, paramInt + 1);
      }
    }
    paramInt = aKe(size() + this.aivl);
    if (i < paramInt) {
      k.a(this.aivm, this.aivm, i + 1, i, paramInt);
    }
    for (;;)
    {
      this.aivm[i] = paramE;
      break;
      k.a(this.aivm, this.aivm, 1, 0, paramInt);
      this.aivm[0] = this.aivm[(this.aivm.length - 1)];
      k.a(this.aivm, this.aivm, i + 1, i, this.aivm.length - 1);
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(191182);
    hr(paramE);
    AppMethodBeat.o(191182);
    return true;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(191197);
    s.u(paramCollection, "elements");
    b.a locala = b.aivb;
    b.a.qk(paramInt, size());
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(191197);
      return false;
    }
    if (paramInt == size())
    {
      boolean bool = addAll(paramCollection);
      AppMethodBeat.o(191197);
      return bool;
    }
    ensureCapacity(size() + paramCollection.size());
    int k = aKe(size() + this.aivl);
    int i = aKe(this.aivl + paramInt);
    int j = paramCollection.size();
    if (paramInt < size() + 1 >> 1)
    {
      paramInt = this.aivl - j;
      if (i >= this.aivl) {
        if (paramInt >= 0) {
          k.a(this.aivm, this.aivm, paramInt, this.aivl, i);
        }
      }
      for (;;)
      {
        this.aivl = paramInt;
        b(aKf(i - j), paramCollection);
        AppMethodBeat.o(191197);
        return true;
        paramInt += this.aivm.length;
        k = this.aivl;
        int m = this.aivm.length - paramInt;
        if (m >= i - k)
        {
          k.a(this.aivm, this.aivm, paramInt, this.aivl, i);
        }
        else
        {
          k.a(this.aivm, this.aivm, paramInt, this.aivl, this.aivl + m);
          k.a(this.aivm, this.aivm, 0, m + this.aivl, i);
          continue;
          k.a(this.aivm, this.aivm, paramInt, this.aivl, this.aivm.length);
          if (j >= i)
          {
            k.a(this.aivm, this.aivm, this.aivm.length - j, 0, i);
          }
          else
          {
            k.a(this.aivm, this.aivm, this.aivm.length - j, 0, j);
            k.a(this.aivm, this.aivm, 0, j, i);
          }
        }
      }
    }
    paramInt = i + j;
    if (i < k) {
      if (k + j <= this.aivm.length) {
        k.a(this.aivm, this.aivm, paramInt, i, k);
      }
    }
    for (;;)
    {
      b(i, paramCollection);
      break;
      if (paramInt >= this.aivm.length)
      {
        k.a(this.aivm, this.aivm, paramInt - this.aivm.length, i, k);
      }
      else
      {
        j = j + k - this.aivm.length;
        k.a(this.aivm, this.aivm, 0, k - j, k);
        k.a(this.aivm, this.aivm, paramInt, i, k - j);
        continue;
        k.a(this.aivm, this.aivm, j, 0, k);
        if (paramInt >= this.aivm.length)
        {
          k.a(this.aivm, this.aivm, paramInt - this.aivm.length, i, this.aivm.length);
        }
        else
        {
          k.a(this.aivm, this.aivm, 0, this.aivm.length - j, this.aivm.length);
          k.a(this.aivm, this.aivm, paramInt, i, this.aivm.length - j);
        }
      }
    }
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(191191);
    s.u(paramCollection, "elements");
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(191191);
      return false;
    }
    ensureCapacity(size() + paramCollection.size());
    b(aKe(size() + this.aivl), paramCollection);
    AppMethodBeat.o(191191);
    return true;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191261);
    int j = aKe(size() + this.aivl);
    if (this.aivl < j) {
      k.a(this.aivm, null, this.aivl, j);
    }
    label104:
    for (;;)
    {
      this.aivl = 0;
      this.size = 0;
      AppMethodBeat.o(191261);
      return;
      if (!isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label104;
        }
        k.a(this.aivm, null, this.aivl, this.aivm.length);
        k.a(this.aivm, null, 0, j);
        break;
      }
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(191215);
    if (indexOf(paramObject) != -1)
    {
      AppMethodBeat.o(191215);
      return true;
    }
    AppMethodBeat.o(191215);
    return false;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(191203);
    Object localObject = b.aivb;
    b.a.qj(paramInt, size());
    paramInt = aKe(this.aivl + paramInt);
    localObject = this.aivm[paramInt];
    AppMethodBeat.o(191203);
    return localObject;
  }
  
  public final int getSize()
  {
    return this.size;
  }
  
  public final void hr(E paramE)
  {
    AppMethodBeat.i(191167);
    ensureCapacity(size() + 1);
    this.aivm[aKe(size() + this.aivl)] = paramE;
    this.size = (size() + 1);
    AppMethodBeat.o(191167);
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(191222);
    int j = aKe(size() + this.aivl);
    int i;
    if (this.aivl < j)
    {
      i = this.aivl;
      while (i < j)
      {
        if (s.p(paramObject, this.aivm[i]))
        {
          j = this.aivl;
          AppMethodBeat.o(191222);
          return i - j;
        }
        i += 1;
      }
    }
    if (this.aivl >= j)
    {
      i = this.aivl;
      int k = this.aivm.length;
      while (i < k)
      {
        if (s.p(paramObject, this.aivm[i]))
        {
          j = this.aivl;
          AppMethodBeat.o(191222);
          return i - j;
        }
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        if (s.p(paramObject, this.aivm[i]))
        {
          j = this.aivm.length;
          k = this.aivl;
          AppMethodBeat.o(191222);
          return i + j - k;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(191222);
    return -1;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(191162);
    if (size() == 0)
    {
      AppMethodBeat.o(191162);
      return true;
    }
    AppMethodBeat.o(191162);
    return false;
  }
  
  public final E kkV()
  {
    AppMethodBeat.i(191174);
    if (isEmpty())
    {
      AppMethodBeat.o(191174);
      return null;
    }
    Object localObject = kkU();
    AppMethodBeat.o(191174);
    return localObject;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(191228);
    int i = aKe(size() + this.aivl);
    int j;
    if (this.aivl < i)
    {
      i -= 1;
      j = this.aivl;
      if (i >= j) {
        for (;;)
        {
          if (s.p(paramObject, this.aivm[i]))
          {
            j = this.aivl;
            AppMethodBeat.o(191228);
            return i - j;
          }
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
    }
    else if (this.aivl > i)
    {
      i -= 1;
      while (i >= 0)
      {
        if (s.p(paramObject, this.aivm[i]))
        {
          j = this.aivm.length;
          int k = this.aivl;
          AppMethodBeat.o(191228);
          return i + j - k;
        }
        i -= 1;
      }
      i = k.ad(this.aivm);
      j = this.aivl;
      if (i >= j) {
        for (;;)
        {
          if (s.p(paramObject, this.aivm[i]))
          {
            j = this.aivl;
            AppMethodBeat.o(191228);
            return i - j;
          }
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
    }
    AppMethodBeat.o(191228);
    return -1;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(191232);
    int i = indexOf(paramObject);
    if (i == -1)
    {
      AppMethodBeat.o(191232);
      return false;
    }
    remove(i);
    AppMethodBeat.o(191232);
    return true;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191248);
    s.u(paramCollection, "elements");
    if (!isEmpty()) {
      if (this.aivm.length != 0) {
        break label41;
      }
    }
    label41:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(191248);
      return false;
    }
    int m = aKe(size() + this.aivl);
    i = this.aivl;
    int j;
    boolean bool;
    Object localObject;
    int k;
    label111:
    Object[] arrayOfObject;
    if (this.aivl < m)
    {
      j = this.aivl;
      bool = false;
      if (j < m)
      {
        localObject = this.aivm[j];
        if (!paramCollection.contains(localObject))
        {
          k = 1;
          if (k == 0) {
            break label149;
          }
          arrayOfObject = this.aivm;
          k = i + 1;
          arrayOfObject[i] = localObject;
          i = k;
        }
        for (;;)
        {
          j += 1;
          break;
          k = 0;
          break label111;
          label149:
          bool = true;
        }
      }
      k.a(this.aivm, null, i, m);
    }
    for (;;)
    {
      if (bool) {
        this.size = aKf(i - this.aivl);
      }
      AppMethodBeat.o(191248);
      return bool;
      j = this.aivl;
      int n = this.aivm.length;
      bool = false;
      if (j < n)
      {
        localObject = this.aivm[j];
        this.aivm[j] = null;
        if (!paramCollection.contains(localObject))
        {
          k = 1;
          label244:
          if (k == 0) {
            break label282;
          }
          arrayOfObject = this.aivm;
          k = i + 1;
          arrayOfObject[i] = localObject;
          i = k;
        }
        for (;;)
        {
          j += 1;
          break;
          k = 0;
          break label244;
          label282:
          bool = true;
        }
      }
      i = aKe(i);
      j = 0;
      if (j < m)
      {
        localObject = this.aivm[j];
        this.aivm[j] = null;
        if (!paramCollection.contains(localObject))
        {
          k = 1;
          label331:
          if (k == 0) {
            break label363;
          }
          this.aivm[i] = localObject;
          i = aKg(i);
        }
        for (;;)
        {
          j += 1;
          break;
          k = 0;
          break label331;
          label363:
          bool = true;
        }
      }
    }
  }
  
  public final E removeAt(int paramInt)
  {
    AppMethodBeat.i(191239);
    Object localObject = b.aivb;
    b.a.qj(paramInt, size());
    if (paramInt == p.oE(this))
    {
      if (isEmpty())
      {
        localObject = (Throwable)new NoSuchElementException("ArrayDeque is empty.");
        AppMethodBeat.o(191239);
        throw ((Throwable)localObject);
      }
      paramInt = aKe(p.oE(this) + this.aivl);
      localObject = this.aivm[paramInt];
      this.aivm[paramInt] = null;
      this.size = (size() - 1);
      AppMethodBeat.o(191239);
      return localObject;
    }
    if (paramInt == 0)
    {
      localObject = kkU();
      AppMethodBeat.o(191239);
      return localObject;
    }
    int i = aKe(this.aivl + paramInt);
    localObject = this.aivm[i];
    if (paramInt < size() >> 1)
    {
      if (i >= this.aivl) {
        k.a(this.aivm, this.aivm, this.aivl + 1, this.aivl, i);
      }
      for (;;)
      {
        this.aivm[this.aivl] = null;
        this.aivl = aKg(this.aivl);
        this.size = (size() - 1);
        AppMethodBeat.o(191239);
        return localObject;
        k.a(this.aivm, this.aivm, 1, 0, i);
        this.aivm[0] = this.aivm[(this.aivm.length - 1)];
        k.a(this.aivm, this.aivm, this.aivl + 1, this.aivl, this.aivm.length - 1);
      }
    }
    paramInt = aKe(p.oE(this) + this.aivl);
    if (i <= paramInt) {
      k.a(this.aivm, this.aivm, i, i + 1, paramInt + 1);
    }
    for (;;)
    {
      this.aivm[paramInt] = null;
      break;
      k.a(this.aivm, this.aivm, i, i + 1, this.aivm.length);
      this.aivm[(this.aivm.length - 1)] = this.aivm[0];
      k.a(this.aivm, this.aivm, 0, 1, paramInt + 1);
    }
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    int k = 0;
    AppMethodBeat.i(191254);
    s.u(paramCollection, "elements");
    if (!isEmpty()) {
      if (this.aivm.length != 0) {
        break label44;
      }
    }
    label44:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(191254);
      return false;
    }
    int n = aKe(size() + this.aivl);
    i = this.aivl;
    int j;
    boolean bool;
    Object localObject;
    Object[] arrayOfObject;
    if (this.aivl < n)
    {
      j = this.aivl;
      bool = false;
      if (j < n)
      {
        localObject = this.aivm[j];
        if (paramCollection.contains(localObject))
        {
          arrayOfObject = this.aivm;
          k = i + 1;
          arrayOfObject[i] = localObject;
          i = k;
        }
        for (;;)
        {
          j += 1;
          break;
          bool = true;
        }
      }
      k.a(this.aivm, null, i, n);
    }
    for (;;)
    {
      if (bool) {
        this.size = aKf(i - this.aivl);
      }
      AppMethodBeat.o(191254);
      return bool;
      j = this.aivl;
      int i1 = this.aivm.length;
      bool = false;
      if (j < i1)
      {
        localObject = this.aivm[j];
        this.aivm[j] = null;
        if (paramCollection.contains(localObject))
        {
          arrayOfObject = this.aivm;
          int m = i + 1;
          arrayOfObject[i] = localObject;
          i = m;
        }
        for (;;)
        {
          j += 1;
          break;
          bool = true;
        }
      }
      i = aKe(i);
      j = k;
      if (j < n)
      {
        localObject = this.aivm[j];
        this.aivm[j] = null;
        if (paramCollection.contains(localObject))
        {
          this.aivm[i] = localObject;
          i = aKg(i);
        }
        for (;;)
        {
          j += 1;
          break;
          bool = true;
        }
      }
    }
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(191211);
    Object localObject = b.aivb;
    b.a.qj(paramInt, size());
    paramInt = aKe(this.aivl + paramInt);
    localObject = this.aivm[paramInt];
    this.aivm[paramInt] = paramE;
    AppMethodBeat.o(191211);
    return localObject;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(191274);
    Object[] arrayOfObject = toArray(new Object[size()]);
    AppMethodBeat.o(191274);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(191266);
    s.u(paramArrayOfT, "array");
    if (paramArrayOfT.length >= size()) {}
    int i;
    while (paramArrayOfT == null)
    {
      paramArrayOfT = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(191266);
      throw paramArrayOfT;
      i = size();
      s.u(paramArrayOfT, "reference");
      paramArrayOfT = Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
      if (paramArrayOfT == null)
      {
        paramArrayOfT = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(191266);
        throw paramArrayOfT;
      }
      paramArrayOfT = (Object[])paramArrayOfT;
    }
    int j = aKe(size() + this.aivl);
    if (this.aivl < j) {
      k.a(this.aivm, paramArrayOfT, 0, this.aivl, j, 2);
    }
    label238:
    for (;;)
    {
      if (paramArrayOfT.length > size()) {
        paramArrayOfT[size()] = null;
      }
      if (paramArrayOfT != null) {
        break;
      }
      paramArrayOfT = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(191266);
      throw paramArrayOfT;
      if (!isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label238;
        }
        k.a(this.aivm, paramArrayOfT, 0, this.aivl, this.aivm.length);
        k.a(this.aivm, paramArrayOfT, this.aivm.length - this.aivl, 0, j);
        break;
      }
    }
    AppMethodBeat.o(191266);
    return paramArrayOfT;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
  {
    public static int ql(int paramInt1, int paramInt2)
    {
      int i = 2147483639;
      int j = (paramInt1 >> 1) + paramInt1;
      paramInt1 = j;
      if (j - paramInt2 < 0) {
        paramInt1 = paramInt2;
      }
      if (paramInt1 - 2147483639 > 0)
      {
        paramInt1 = i;
        if (paramInt2 > 2147483639) {
          paramInt1 = 2147483647;
        }
        return paramInt1;
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.a.j
 * JD-Core Version:    0.7.0.1
 */