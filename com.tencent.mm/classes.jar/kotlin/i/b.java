package kotlin.i;

import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/properties/ObservableProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "beforeChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"})
public abstract class b<T>
  implements c<Object, T>
{
  private T value;
  
  public b(T paramT)
  {
    this.value = paramT;
  }
  
  public final T a(n<?> paramn)
  {
    p.k(paramn, "property");
    return this.value;
  }
  
  public final void a(n<?> paramn, T paramT)
  {
    p.k(paramn, "property");
    Object localObject = this.value;
    b(paramn);
    this.value = paramT;
    a(paramn, localObject, paramT);
  }
  
  protected void a(n<?> paramn, T paramT1, T paramT2)
  {
    p.k(paramn, "property");
  }
  
  protected boolean b(n<?> paramn)
  {
    p.k(paramn, "property");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.i.b
 * JD-Core Version:    0.7.0.1
 */