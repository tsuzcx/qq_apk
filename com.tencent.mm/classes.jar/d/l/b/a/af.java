package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflection"})
final class af
{
  private final int MOZ;
  ClassLoader MPa;
  private final WeakReference<ClassLoader> med;
  
  public af(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(56567);
    this.med = new WeakReference(paramClassLoader);
    this.MOZ = System.identityHashCode(paramClassLoader);
    this.MPa = paramClassLoader;
    AppMethodBeat.o(56567);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56565);
    if (((paramObject instanceof af)) && ((ClassLoader)this.med.get() == (ClassLoader)((af)paramObject).med.get()))
    {
      AppMethodBeat.o(56565);
      return true;
    }
    AppMethodBeat.o(56565);
    return false;
  }
  
  public final int hashCode()
  {
    return this.MOZ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56566);
    Object localObject = (ClassLoader)this.med.get();
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