package kotlin.i;

import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lkotlin/properties/ObservableProperty;", "V", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "beforeChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class b<V>
  implements c<Object, V>
{
  private V value;
  
  public b(V paramV)
  {
    this.value = paramV;
  }
  
  public final V a(o<?> paramo)
  {
    s.u(paramo, "property");
    return this.value;
  }
  
  public final void a(o<?> paramo, V paramV)
  {
    s.u(paramo, "property");
    Object localObject = this.value;
    if (!b(paramo)) {
      return;
    }
    this.value = paramV;
    a(paramo, localObject, paramV);
  }
  
  protected void a(o<?> paramo, V paramV1, V paramV2)
  {
    s.u(paramo, "property");
  }
  
  protected boolean b(o<?> paramo)
  {
    s.u(paramo, "property");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.i.b
 * JD-Core Version:    0.7.0.1
 */