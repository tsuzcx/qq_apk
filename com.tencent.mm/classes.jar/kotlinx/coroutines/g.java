package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"})
public final class g
{
  public static final <T> T a(f paramf, m<? super ak, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(204175);
    Thread localThread = Thread.currentThread();
    Object localObject;
    if ((kotlin.d.e)paramf.get((f.c)kotlin.d.e.aaAt) == null)
    {
      localObject = cv.abxO;
      localObject = cv.iRX();
    }
    for (paramf = ae.a((ak)br.abxo, paramf.plus((f)localObject));; paramf = ae.a((ak)br.abxo, paramf))
    {
      paramf = new e(paramf, localThread, (bi)localObject);
      paramf.a(am.abwA, paramf, paramm);
      paramf = paramf.iQK();
      AppMethodBeat.o(204175);
      return paramf;
      localObject = cv.abxO;
      localObject = cv.iRY();
    }
  }
  
  public static final <T> at<T> a(ak paramak, f paramf, am paramam, m<? super ak, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(117962);
    paramak = ae.a(paramak, paramf);
    if (paramam.iRf()) {}
    for (paramak = (au)new cg(paramak, paramm);; paramak = new au(paramak, true))
    {
      paramak.a(paramam, paramak, paramm);
      paramak = (at)paramak;
      AppMethodBeat.o(117962);
      return paramak;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.g
 * JD-Core Version:    0.7.0.1
 */