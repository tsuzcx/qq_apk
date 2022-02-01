package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.q;

@Metadata(d1={""}, d2={"Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "(Lkotlin/reflect/KTypeParameter;)V", "equals", "", "other", "", "getAnnotatedBounds", "", "", "()[Ljava/lang/annotation/Annotation;", "getAnnotation", "T", "annotationClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "getBounds", "Ljava/lang/reflect/Type;", "()[Ljava/lang/reflect/Type;", "getDeclaredAnnotations", "getGenericDeclaration", "getName", "", "getTypeName", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class ab
  implements TypeVariable<GenericDeclaration>, aa
{
  private final v aixS;
  
  public ab(v paramv)
  {
    AppMethodBeat.i(191285);
    this.aixS = paramv;
    AppMethodBeat.o(191285);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191313);
    if (((paramObject instanceof TypeVariable)) && (s.p(getName(), ((TypeVariable)paramObject).getName())) && (s.p(getGenericDeclaration(), ((TypeVariable)paramObject).getGenericDeclaration())))
    {
      AppMethodBeat.o(191313);
      return true;
    }
    AppMethodBeat.o(191313);
    return false;
  }
  
  public final Type[] getBounds()
  {
    AppMethodBeat.i(191302);
    Object localObject2 = (Iterable)this.aixS.klF();
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(ac.b((u)((Iterator)localObject2).next()));
    }
    localObject1 = ((Collection)localObject1).toArray(new Type[0]);
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(191302);
      throw ((Throwable)localObject1);
    }
    localObject1 = (Type[])localObject1;
    AppMethodBeat.o(191302);
    return localObject1;
  }
  
  public final GenericDeclaration getGenericDeclaration()
  {
    AppMethodBeat.i(191296);
    Throwable localThrowable = (Throwable)new q("An operation is not implemented: ".concat(String.valueOf("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.aixS)));
    AppMethodBeat.o(191296);
    throw localThrowable;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(191291);
    String str = this.aixS.getName();
    AppMethodBeat.o(191291);
    return str;
  }
  
  public final String getTypeName()
  {
    AppMethodBeat.i(191307);
    String str = getName();
    AppMethodBeat.o(191307);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191319);
    int i = getName().hashCode();
    int j = getGenericDeclaration().hashCode();
    AppMethodBeat.o(191319);
    return i ^ j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191325);
    String str = getTypeName();
    AppMethodBeat.o(191325);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.ab
 * JD-Core Version:    0.7.0.1
 */