package com.tencent.mm.sensitive.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/condition/TimeCompareCondition;", "Lcom/tencent/mm/sensitive/condition/ICondition;", "getOldTime", "Lkotlin/Function0;", "", "getNewTime", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getGetNewTime", "()Lkotlin/jvm/functions/Function0;", "getGetOldTime", "checkCondition", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements e
{
  private final String TAG;
  private final a<Long> acuZ;
  private final a<Long> acva;
  
  public f(a<Long> parama1, a<Long> parama2)
  {
    AppMethodBeat.i(240946);
    this.acuZ = parama1;
    this.acva = parama2;
    this.TAG = "TimeCompareCondition";
    AppMethodBeat.o(240946);
  }
  
  public final boolean iUe()
  {
    AppMethodBeat.i(240949);
    long l1 = ((Number)this.acuZ.invoke()).longValue();
    long l2 = ((Number)this.acva.invoke()).longValue();
    if ((l1 == 0L) || (((Number)this.acva.invoke()).longValue() > l1)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d(this.TAG, "oldTime:" + l1 + ", newTime:" + l2 + ", canUpdate:" + bool);
      AppMethodBeat.o(240949);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.a.f
 * JD-Core Version:    0.7.0.1
 */