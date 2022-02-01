package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflection"}, k=1, mv={1, 5, 1})
final class ak
{
  ClassLoader aiAy;
  private final int coC;
  private final WeakReference<ClassLoader> tzB;
  
  public ak(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(56567);
    this.tzB = new WeakReference(paramClassLoader);
    this.coC = System.identityHashCode(paramClassLoader);
    this.aiAy = paramClassLoader;
    AppMethodBeat.o(56567);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56565);
    if (((paramObject instanceof ak)) && ((ClassLoader)this.tzB.get() == (ClassLoader)((ak)paramObject).tzB.get()))
    {
      AppMethodBeat.o(56565);
      return true;
    }
    AppMethodBeat.o(56565);
    return false;
  }
  
  public final int hashCode()
  {
    return this.coC;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56566);
    Object localObject = (ClassLoader)this.tzB.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.ak
 * JD-Core Version:    0.7.0.1
 */