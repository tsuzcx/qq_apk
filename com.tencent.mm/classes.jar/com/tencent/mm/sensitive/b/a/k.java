package com.tencent.mm.sensitive.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.a.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/methodconfig/method/ListenForSubscriberCheck;", "Lcom/tencent/mm/sensitive/methodconfig/BaseMethodMethodCheck;", "()V", "conditionList", "Lcom/tencent/mm/sensitive/condition/BuildOsVersionCondition;", "getConditionList", "()Lcom/tencent/mm/sensitive/condition/BuildOsVersionCondition;", "", "Lcom/tencent/mm/sensitive/condition/ICondition;", "methodName", "", "value", "Lkotlin/Pair;", "", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends com.tencent.mm.sensitive.b.b
{
  private final com.tencent.mm.sensitive.a.b acvv;
  
  public k()
  {
    AppMethodBeat.i(241062);
    this.acvv = new com.tencent.mm.sensitive.a.b();
    AppMethodBeat.o(241062);
  }
  
  public final r<Boolean, Object> iUf()
  {
    AppMethodBeat.i(241081);
    r localr = new r(Boolean.valueOf(this.acvv.iUe()), null);
    AppMethodBeat.o(241081);
    return localr;
  }
  
  public final List<e> iUg()
  {
    AppMethodBeat.i(241075);
    List localList = p.listOf(this.acvv);
    AppMethodBeat.o(241075);
    return localList;
  }
  
  public final String iUh()
  {
    return "listenForSubscriber";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.b.a.k
 * JD-Core Version:    0.7.0.1
 */