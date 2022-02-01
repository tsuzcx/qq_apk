package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflection"})
final class af
{
  private final int TbM;
  ClassLoader TbN;
  private final WeakReference<ClassLoader> nsR;
  
  public af(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(56567);
    this.nsR = new WeakReference(paramClassLoader);
    this.TbM = System.identityHashCode(paramClassLoader);
    this.TbN = paramClassLoader;
    AppMethodBeat.o(56567);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56565);
    if (((paramObject instanceof af)) && ((ClassLoader)this.nsR.get() == (ClassLoader)((af)paramObject).nsR.get()))
    {
      AppMethodBeat.o(56565);
      return true;
    }
    AppMethodBeat.o(56565);
    return false;
  }
  
  public final int hashCode()
  {
    return this.TbM;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56566);
    Object localObject = (ClassLoader)this.nsR.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.l.b.a.af
 * JD-Core Version:    0.7.0.1
 */