package kotlin.i;

import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.k;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/properties/ObservableProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "beforeChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"})
public abstract class b<T>
  implements c<Object, T>
{
  private T value;
  
  public b(T paramT)
  {
    this.value = paramT;
  }
  
  public final T a(k<?> paramk)
  {
    p.h(paramk, "property");
    return this.value;
  }
  
  public final void a(k<?> paramk, T paramT)
  {
    p.h(paramk, "property");
    Object localObject = this.value;
    b(paramk);
    this.value = paramT;
    a(paramk, localObject, paramT);
  }
  
  protected void a(k<?> paramk, T paramT1, T paramT2)
  {
    p.h(paramk, "property");
  }
  
  protected boolean b(k<?> paramk)
  {
    p.h(paramk, "property");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.i.b
 * JD-Core Version:    0.7.0.1
 */