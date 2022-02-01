package com.tencent.mm.sensitive.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.a.d;
import com.tencent.mm.sensitive.a.e;
import com.tencent.mm.sensitive.b.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/methodconfig/method/GetSerialForPkgCheck;", "Lcom/tencent/mm/sensitive/methodconfig/BaseMethodMethodCheck;", "()V", "conditionList", "", "Lcom/tencent/mm/sensitive/condition/ICondition;", "getConditionList", "()Ljava/util/List;", "methodName", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends b
{
  private final List<e> acvs;
  
  public h()
  {
    AppMethodBeat.i(241088);
    this.acvs = p.listOf(new d(3600000L));
    AppMethodBeat.o(241088);
  }
  
  public final List<e> iUg()
  {
    return this.acvs;
  }
  
  public final String iUh()
  {
    return "getSerialForPackage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.b.a.h
 * JD-Core Version:    0.7.0.1
 */