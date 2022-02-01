package kotlin.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.a.j.a;
import kotlin.a.k;
import kotlin.g.b.a.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "Itr", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class b<E>
  extends e<E>
  implements List<E>, RandomAccess
{
  private E[] aivD;
  public boolean aivE;
  public final b<E> aivF;
  private final b<E> aivG;
  private int length;
  private int offset;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    this(c.aKk(10), 0, 0, false, null, null);
    AppMethodBeat.i(191127);
    AppMethodBeat.o(191127);
  }
  
  private b(E[] paramArrayOfE, int paramInt1, int paramInt2, boolean paramBoolean, b<E> paramb1, b<E> paramb2)
  {
    this.aivD = paramArrayOfE;
    this.offset = paramInt1;
    this.length = paramInt2;
    this.aivE = paramBoolean;
    this.aivF = paramb1;
    this.aivG = paramb2;
  }
  
  private final void V(int paramInt, E paramE)
  {
    AppMethodBeat.i(191061);
    if (this.aivF != null)
    {
      this.aivF.V(paramInt, paramE);
      this.aivD = this.aivF.aivD;
      this.length += 1;
      AppMethodBeat.o(191061);
      return;
    }
    qn(paramInt, 1);
    this.aivD[paramInt] = paramE;
    AppMethodBeat.o(191061);
  }
  
  private final int a(int paramInt1, int paramInt2, Collection<? extends E> paramCollection, boolean paramBoolean)
  {
    AppMethodBeat.i(191106);
    if (this.aivF != null)
    {
      paramInt1 = this.aivF.a(paramInt1, paramInt2, paramCollection, paramBoolean);
      this.length -= paramInt1;
      AppMethodBeat.o(191106);
      return paramInt1;
    }
    int j = 0;
    int i = 0;
    while (i < paramInt2) {
      if (paramCollection.contains(this.aivD[(paramInt1 + i)]) == paramBoolean)
      {
        this.aivD[(j + paramInt1)] = this.aivD[(i + paramInt1)];
        j += 1;
        i += 1;
      }
      else
      {
        i += 1;
      }
    }
    i = paramInt2 - j;
    k.a(this.aivD, this.aivD, j + paramInt1, paramInt1 + paramInt2, this.length);
    c.f(this.aivD, this.length - i, this.length);
    this.length -= i;
    AppMethodBeat.o(191106);
    return i;
  }
  
  private final void a(int paramInt1, Collection<? extends E> paramCollection, int paramInt2)
  {
    AppMethodBeat.i(191073);
    if (this.aivF != null)
    {
      this.aivF.a(paramInt1, paramCollection, paramInt2);
      this.aivD = this.aivF.aivD;
      this.length += paramInt2;
      AppMethodBeat.o(191073);
      return;
    }
    qn(paramInt1, paramInt2);
    int i = 0;
    paramCollection = paramCollection.iterator();
    while (i < paramInt2)
    {
      this.aivD[(paramInt1 + i)] = paramCollection.next();
      i += 1;
    }
    AppMethodBeat.o(191073);
  }
  
  private final E aKj(int paramInt)
  {
    AppMethodBeat.i(191083);
    if (this.aivF != null)
    {
      localObject = this.aivF.aKj(paramInt);
      this.length -= 1;
      AppMethodBeat.o(191083);
      return localObject;
    }
    Object localObject = this.aivD[paramInt];
    k.a(this.aivD, this.aivD, paramInt, paramInt + 1, this.offset + this.length);
    c.o(this.aivD, this.offset + this.length - 1);
    this.length -= 1;
    AppMethodBeat.o(191083);
    return localObject;
  }
  
  private final void qn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191050);
    int i = this.length + paramInt2;
    Object localObject;
    if (this.aivF != null)
    {
      localObject = (Throwable)new IllegalStateException();
      AppMethodBeat.o(191050);
      throw ((Throwable)localObject);
    }
    if (i > this.aivD.length)
    {
      localObject = j.aivo;
      i = j.a.ql(this.aivD.length, i);
      this.aivD = c.n(this.aivD, i);
    }
    k.a(this.aivD, this.aivD, paramInt1 + paramInt2, paramInt1, this.offset + this.length);
    this.length += paramInt2;
    AppMethodBeat.o(191050);
  }
  
  private final void qo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191095);
    if (this.aivF != null) {
      this.aivF.qo(paramInt1, paramInt2);
    }
    for (;;)
    {
      this.length -= paramInt2;
      AppMethodBeat.o(191095);
      return;
      k.a(this.aivD, this.aivD, paramInt1, paramInt1 + paramInt2, this.length);
      c.f(this.aivD, this.length - paramInt2, this.length);
    }
  }
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(191205);
    kla();
    kotlin.a.b.a locala = kotlin.a.b.aivb;
    kotlin.a.b.a.qk(paramInt, this.length);
    V(this.offset + paramInt, paramE);
    AppMethodBeat.o(191205);
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(191199);
    kla();
    V(this.offset + this.length, paramE);
    AppMethodBeat.o(191199);
    return true;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(191219);
    s.u(paramCollection, "elements");
    kla();
    kotlin.a.b.a locala = kotlin.a.b.aivb;
    kotlin.a.b.a.qk(paramInt, this.length);
    int i = paramCollection.size();
    a(this.offset + paramInt, paramCollection, i);
    if (i > 0)
    {
      AppMethodBeat.o(191219);
      return true;
    }
    AppMethodBeat.o(191219);
    return false;
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(191213);
    s.u(paramCollection, "elements");
    kla();
    int i = paramCollection.size();
    a(this.offset + this.length, paramCollection, i);
    if (i > 0)
    {
      AppMethodBeat.o(191213);
      return true;
    }
    AppMethodBeat.o(191213);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191226);
    kla();
    qo(this.offset, this.length);
    AppMethodBeat.o(191226);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191290);
    Object[] arrayOfObject;
    int j;
    int k;
    int i;
    if (paramObject != (b)this)
    {
      if (!(paramObject instanceof List)) {
        break label112;
      }
      paramObject = (List)paramObject;
      arrayOfObject = this.aivD;
      j = this.offset;
      k = this.length;
      if (k == paramObject.size()) {
        break label66;
      }
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(191290);
      return true;
      label66:
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label107;
        }
        if ((s.p(arrayOfObject[(j + i)], paramObject.get(i)) ^ true))
        {
          i = 0;
          break;
        }
        i += 1;
      }
      label107:
      i = 1;
    }
    label112:
    AppMethodBeat.o(191290);
    return false;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(191154);
    Object localObject = kotlin.a.b.aivb;
    kotlin.a.b.a.qj(paramInt, this.length);
    localObject = this.aivD[(this.offset + paramInt)];
    AppMethodBeat.o(191154);
    return localObject;
  }
  
  public final int getSize()
  {
    return this.length;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191298);
    Object[] arrayOfObject = this.aivD;
    int m = this.offset;
    int n = this.length;
    int i = 0;
    int j = 1;
    if (i < n)
    {
      Object localObject = arrayOfObject[(m + i)];
      if (localObject != null) {}
      for (int k = localObject.hashCode();; k = 0)
      {
        j = j * 31 + k;
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(191298);
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(191163);
    int i = 0;
    while (i < this.length)
    {
      if (s.p(this.aivD[(this.offset + i)], paramObject))
      {
        AppMethodBeat.o(191163);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(191163);
    return -1;
  }
  
  public final boolean isEmpty()
  {
    return this.length == 0;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(191178);
    Iterator localIterator = (Iterator)new a(this, 0);
    AppMethodBeat.o(191178);
    return localIterator;
  }
  
  public final void kla()
  {
    AppMethodBeat.i(191312);
    if ((this.aivE) || ((this.aivG != null) && (this.aivG.aivE)))
    {
      Throwable localThrowable = (Throwable)new UnsupportedOperationException();
      AppMethodBeat.o(191312);
      throw localThrowable;
    }
    AppMethodBeat.o(191312);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(191172);
    int i = this.length - 1;
    while (i >= 0)
    {
      if (s.p(this.aivD[(this.offset + i)], paramObject))
      {
        AppMethodBeat.o(191172);
        return i;
      }
      i -= 1;
    }
    AppMethodBeat.o(191172);
    return -1;
  }
  
  public final ListIterator<E> listIterator()
  {
    AppMethodBeat.i(191186);
    ListIterator localListIterator = (ListIterator)new a(this, 0);
    AppMethodBeat.o(191186);
    return localListIterator;
  }
  
  public final ListIterator<E> listIterator(int paramInt)
  {
    AppMethodBeat.i(191192);
    Object localObject = kotlin.a.b.aivb;
    kotlin.a.b.a.qk(paramInt, this.length);
    localObject = (ListIterator)new a(this, paramInt);
    AppMethodBeat.o(191192);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(191243);
    kla();
    int i = indexOf(paramObject);
    if (i >= 0) {
      remove(i);
    }
    if (i >= 0)
    {
      AppMethodBeat.o(191243);
      return true;
    }
    AppMethodBeat.o(191243);
    return false;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191250);
    s.u(paramCollection, "elements");
    kla();
    if (a(this.offset, this.length, paramCollection, false) > 0)
    {
      AppMethodBeat.o(191250);
      return true;
    }
    AppMethodBeat.o(191250);
    return false;
  }
  
  public final E removeAt(int paramInt)
  {
    AppMethodBeat.i(191234);
    kla();
    Object localObject = kotlin.a.b.aivb;
    kotlin.a.b.a.qj(paramInt, this.length);
    localObject = aKj(this.offset + paramInt);
    AppMethodBeat.o(191234);
    return localObject;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191259);
    s.u(paramCollection, "elements");
    kla();
    if (a(this.offset, this.length, paramCollection, true) > 0)
    {
      AppMethodBeat.o(191259);
      return true;
    }
    AppMethodBeat.o(191259);
    return false;
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(191160);
    kla();
    Object localObject = kotlin.a.b.aivb;
    kotlin.a.b.a.qj(paramInt, this.length);
    localObject = this.aivD[(this.offset + paramInt)];
    this.aivD[(this.offset + paramInt)] = paramE;
    AppMethodBeat.o(191160);
    return localObject;
  }
  
  public final List<E> subList(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191265);
    Object localObject = kotlin.a.b.aivb;
    kotlin.a.b.a.bM(paramInt1, paramInt2, this.length);
    Object[] arrayOfObject = this.aivD;
    int i = this.offset;
    boolean bool = this.aivE;
    b localb = this.aivG;
    localObject = localb;
    if (localb == null) {
      localObject = this;
    }
    localObject = (List)new b(arrayOfObject, i + paramInt1, paramInt2 - paramInt1, bool, this, (b)localObject);
    AppMethodBeat.o(191265);
    return localObject;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(191283);
    Object localObject = k.e(this.aivD, this.offset, this.offset + this.length);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(191283);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(191283);
    return localObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(191275);
    s.u(paramArrayOfT, "destination");
    if (paramArrayOfT.length < this.length)
    {
      paramArrayOfT = Arrays.copyOfRange(this.aivD, this.offset, this.offset + this.length, paramArrayOfT.getClass());
      s.s(paramArrayOfT, "java.util.Arrays.copyOfR…h, destination.javaClass)");
      AppMethodBeat.o(191275);
      return paramArrayOfT;
    }
    Object[] arrayOfObject = this.aivD;
    if (arrayOfObject == null)
    {
      paramArrayOfT = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(191275);
      throw paramArrayOfT;
    }
    k.a(arrayOfObject, paramArrayOfT, 0, this.offset, this.offset + this.length);
    if (paramArrayOfT.length > this.length) {
      paramArrayOfT[this.length] = null;
    }
    AppMethodBeat.o(191275);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191306);
    Object localObject = this.aivD;
    int j = this.offset;
    int k = this.length;
    StringBuilder localStringBuilder = new StringBuilder(k * 3 + 2);
    localStringBuilder.append("[");
    int i = 0;
    while (i < k)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(localObject[(j + i)]);
      i += 1;
    }
    localStringBuilder.append("]");
    localObject = localStringBuilder.toString();
    s.s(localObject, "sb.toString()");
    AppMethodBeat.o(191306);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a<E>
    implements ListIterator<E>, f
  {
    private final b<E> aivH;
    private int index;
    private int lastIndex;
    
    public a(b<E> paramb, int paramInt)
    {
      AppMethodBeat.i(191048);
      this.aivH = paramb;
      this.index = paramInt;
      this.lastIndex = -1;
      AppMethodBeat.o(191048);
    }
    
    public final void add(E paramE)
    {
      AppMethodBeat.i(191120);
      b localb = this.aivH;
      int i = this.index;
      this.index = (i + 1);
      localb.add(i, paramE);
      this.lastIndex = -1;
      AppMethodBeat.o(191120);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(191071);
      if (this.index < b.a(this.aivH))
      {
        AppMethodBeat.o(191071);
        return true;
      }
      AppMethodBeat.o(191071);
      return false;
    }
    
    public final boolean hasPrevious()
    {
      return this.index > 0;
    }
    
    public final E next()
    {
      AppMethodBeat.i(191107);
      if (this.index >= b.a(this.aivH))
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(191107);
        throw ((Throwable)localObject);
      }
      int i = this.index;
      this.index = (i + 1);
      this.lastIndex = i;
      Object localObject = b.b(this.aivH)[(b.c(this.aivH) + this.lastIndex)];
      AppMethodBeat.o(191107);
      return localObject;
    }
    
    public final int nextIndex()
    {
      return this.index;
    }
    
    public final E previous()
    {
      AppMethodBeat.i(191100);
      if (this.index <= 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(191100);
        throw ((Throwable)localObject);
      }
      this.index -= 1;
      this.lastIndex = this.index;
      Object localObject = b.b(this.aivH)[(b.c(this.aivH) + this.lastIndex)];
      AppMethodBeat.o(191100);
      return localObject;
    }
    
    public final int previousIndex()
    {
      return this.index - 1;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(191129);
      if (this.lastIndex != -1) {}
      for (int i = 1; i == 0; i = 0)
      {
        Throwable localThrowable = (Throwable)new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        AppMethodBeat.o(191129);
        throw localThrowable;
      }
      this.aivH.remove(this.lastIndex);
      this.index = this.lastIndex;
      this.lastIndex = -1;
      AppMethodBeat.o(191129);
    }
    
    public final void set(E paramE)
    {
      AppMethodBeat.i(191115);
      if (this.lastIndex != -1) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramE = (Throwable)new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        AppMethodBeat.o(191115);
        throw paramE;
      }
      this.aivH.set(this.lastIndex, paramE);
      AppMethodBeat.o(191115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.a.a.b
 * JD-Core Version:    0.7.0.1
 */