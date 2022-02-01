package com.tencent.mm.sensitive.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.a.e;
import com.tencent.mm.sensitive.b.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/methodconfig/method/AddPrimaryChangedListenerCheck;", "Lcom/tencent/mm/sensitive/methodconfig/BaseMethodMethodCheck;", "()V", "condition", "Lcom/tencent/mm/sensitive/condition/AccountReadyCondition;", "getCondition", "()Lcom/tencent/mm/sensitive/condition/AccountReadyCondition;", "conditionList", "", "Lcom/tencent/mm/sensitive/condition/ICondition;", "methodName", "", "value", "Lkotlin/Pair;", "", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  private final com.tencent.mm.sensitive.a.a acvr;
  
  public a()
  {
    AppMethodBeat.i(241068);
    this.acvr = new com.tencent.mm.sensitive.a.a();
    AppMethodBeat.o(241068);
  }
  
  public final r<Boolean, Object> iUf()
  {
    AppMethodBeat.i(241084);
    r localr = new r(Boolean.valueOf(this.acvr.iUe()), null);
    AppMethodBeat.o(241084);
    return localr;
  }
  
  public final List<e> iUg()
  {
    AppMethodBeat.i(241078);
    List localList = p.listOf(this.acvr);
    AppMethodBeat.o(241078);
    return localList;
  }
  
  public final String iUh()
  {
    return "addPrimaryClipChangedListener";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.b.a.a
 * JD-Core Version:    0.7.0.1
 */