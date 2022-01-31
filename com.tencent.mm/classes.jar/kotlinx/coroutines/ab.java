package kotlinx.coroutines;

import a.c.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/CoroutineName;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Key", "kotlinx-coroutines-core"})
public final class ab
  extends a
{
  public static final ab.a CHA;
  final String name;
  
  static
  {
    AppMethodBeat.i(118495);
    CHA = new ab.a((byte)0);
    AppMethodBeat.o(118495);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118497);
    if (this != paramObject)
    {
      if ((paramObject instanceof ab))
      {
        paramObject = (ab)paramObject;
        if (!j.e(this.name, paramObject.name)) {}
      }
    }
    else
    {
      AppMethodBeat.o(118497);
      return true;
    }
    AppMethodBeat.o(118497);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118496);
    String str = this.name;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(118496);
      return i;
    }
    AppMethodBeat.o(118496);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118494);
    String str = "CoroutineName(" + this.name + ')';
    AppMethodBeat.o(118494);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ab
 * JD-Core Version:    0.7.0.1
 */