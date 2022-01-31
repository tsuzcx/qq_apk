package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "isActive", "()Z", "isCancelling", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"})
final class bg$b
  implements ay
{
  final bk CIg;
  volatile Object CIs;
  public volatile boolean CIt;
  public volatile Throwable CIu;
  
  public bg$b(bk parambk, Throwable paramThrowable)
  {
    AppMethodBeat.i(118538);
    this.CIg = parambk;
    this.CIt = false;
    this.CIu = paramThrowable;
    AppMethodBeat.o(118538);
  }
  
  static ArrayList<Throwable> epW()
  {
    AppMethodBeat.i(118536);
    ArrayList localArrayList = new ArrayList(4);
    AppMethodBeat.o(118536);
    return localArrayList;
  }
  
  public final void B(Throwable paramThrowable)
  {
    AppMethodBeat.i(118535);
    j.q(paramThrowable, "exception");
    Object localObject = this.CIu;
    if (localObject == null)
    {
      this.CIu = paramThrowable;
      AppMethodBeat.o(118535);
      return;
    }
    if (paramThrowable == localObject)
    {
      AppMethodBeat.o(118535);
      return;
    }
    localObject = this.CIs;
    if (localObject == null)
    {
      this.CIs = paramThrowable;
      AppMethodBeat.o(118535);
      return;
    }
    if ((localObject instanceof Throwable))
    {
      if (paramThrowable == localObject)
      {
        AppMethodBeat.o(118535);
        return;
      }
      ArrayList localArrayList = epW();
      localArrayList.add(localObject);
      localArrayList.add(paramThrowable);
      this.CIs = localArrayList;
      AppMethodBeat.o(118535);
      return;
    }
    if ((localObject instanceof ArrayList))
    {
      if (localObject == null)
      {
        paramThrowable = new v("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
        AppMethodBeat.o(118535);
        throw paramThrowable;
      }
      ((ArrayList)localObject).add(paramThrowable);
      AppMethodBeat.o(118535);
      return;
    }
    paramThrowable = (Throwable)new IllegalStateException("State is ".concat(String.valueOf(localObject)).toString());
    AppMethodBeat.o(118535);
    throw paramThrowable;
  }
  
  public final bk epJ()
  {
    return this.CIg;
  }
  
  public final boolean epV()
  {
    return this.CIu != null;
  }
  
  public final boolean isActive()
  {
    return this.CIu == null;
  }
  
  public final boolean isSealed()
  {
    AppMethodBeat.i(118534);
    if (this.CIs == bh.epX())
    {
      AppMethodBeat.o(118534);
      return true;
    }
    AppMethodBeat.o(118534);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118537);
    String str = "Finishing[cancelling=" + epV() + ", completing=" + this.CIt + ", rootCause=" + this.CIu + ", exceptions=" + this.CIs + ", list=" + this.CIg + ']';
    AppMethodBeat.o(118537);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bg.b
 * JD-Core Version:    0.7.0.1
 */