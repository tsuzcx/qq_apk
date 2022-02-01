package d.i;

import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/properties/ObservableProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "beforeChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"})
public abstract class b<T>
  implements c<Object, T>
{
  private T value;
  
  public b(T paramT)
  {
    this.value = paramT;
  }
  
  public final T a(d.l.k<?> paramk)
  {
    d.g.b.k.h(paramk, "property");
    return this.value;
  }
  
  public final void a(d.l.k<?> paramk, T paramT)
  {
    d.g.b.k.h(paramk, "property");
    Object localObject = this.value;
    b(paramk);
    this.value = paramT;
    a(paramk, localObject, paramT);
  }
  
  protected void a(d.l.k<?> paramk, T paramT1, T paramT2)
  {
    d.g.b.k.h(paramk, "property");
  }
  
  protected boolean b(d.l.k<?> paramk)
  {
    d.g.b.k.h(paramk, "property");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.i.b
 * JD-Core Version:    0.7.0.1
 */