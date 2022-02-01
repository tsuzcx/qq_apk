package d.i;

import d.g.b.p;
import d.l;
import d.l.k;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/properties/ObservableProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "beforeChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.i.b
 * JD-Core Version:    0.7.0.1
 */