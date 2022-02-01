package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflection"})
final class af
{
  private final int Nme;
  ClassLoader Nmf;
  private final WeakReference<ClassLoader> mix;
  
  public af(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(56567);
    this.mix = new WeakReference(paramClassLoader);
    this.Nme = System.identityHashCode(paramClassLoader);
    this.Nmf = paramClassLoader;
    AppMethodBeat.o(56567);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56565);
    if (((paramObject instanceof af)) && ((ClassLoader)this.mix.get() == (ClassLoader)((af)paramObject).mix.get()))
    {
      AppMethodBeat.o(56565);
      return true;
    }
    AppMethodBeat.o(56565);
    return false;
  }
  
  public final int hashCode()
  {
    return this.Nme;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56566);
    Object localObject = (ClassLoader)this.mix.get();
    if (localObject != null)
    {
      String str = ((ClassLoader)localObject).toString();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "<null>";
    }
    AppMethodBeat.o(56566);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.af
 * JD-Core Version:    0.7.0.1
 */