package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/UndispatchedEventLoop$EventLoop;", "", "isActive", "", "queue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(ZLkotlinx/coroutines/internal/ArrayQueue;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"})
public final class bu$a
{
  public final b<Runnable> CIH;
  public boolean isActive;
  
  private bu$a(b<Runnable> paramb)
  {
    AppMethodBeat.i(118482);
    this.isActive = false;
    this.CIH = paramb;
    AppMethodBeat.o(118482);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118486);
    if (this != paramObject)
    {
      if (!(paramObject instanceof a)) {
        break label65;
      }
      paramObject = (a)paramObject;
      if (this.isActive != paramObject.isActive) {
        break label60;
      }
    }
    label60:
    for (int i = 1; (i != 0) && (j.e(this.CIH, paramObject.CIH)); i = 0)
    {
      AppMethodBeat.o(118486);
      return true;
    }
    label65:
    AppMethodBeat.o(118486);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118484);
    String str = "EventLoop(isActive=" + this.isActive + ", queue=" + this.CIH + ")";
    AppMethodBeat.o(118484);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bu.a
 * JD-Core Version:    0.7.0.1
 */