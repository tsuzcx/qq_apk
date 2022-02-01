package com.tencent.mm.sensitive.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.a.a;
import com.tencent.mm.sensitive.a.c;
import com.tencent.mm.sensitive.a.e;
import com.tencent.mm.sensitive.b.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/methodconfig/method/QueryIntentActivitiesCheck;", "Lcom/tencent/mm/sensitive/methodconfig/BaseMethodMethodCheck;", "()V", "conditionList", "", "Lcom/tencent/mm/sensitive/condition/ICondition;", "getConditionList", "()Ljava/util/List;", "methodName", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends b
{
  private final List<e> acvs;
  
  public l()
  {
    AppMethodBeat.i(241066);
    this.acvs = p.listOf(new e[] { (e)new a(), (e)new c() });
    AppMethodBeat.o(241066);
  }
  
  public final List<e> iUg()
  {
    return this.acvs;
  }
  
  public final String iUh()
  {
    return "queryIntentActivities";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.b.a.l
 * JD-Core Version:    0.7.0.1
 */