package com.tencent.mm.sensitive.b;

import com.tencent.mm.sensitive.a.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/methodconfig/BaseForbiddenMethodCheck;", "T", "Lcom/tencent/mm/sensitive/methodconfig/BaseMethodMethodCheck;", "fakeValue", "(Ljava/lang/Object;)V", "getFakeValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "conditionList", "", "Lcom/tencent/mm/sensitive/condition/ICondition;", "updateReturnValue", "", "value", "", "Lkotlin/Pair;", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T>
  extends b
{
  private final T acvb;
  
  public a(T paramT)
  {
    this.acvb = paramT;
  }
  
  public final void gC(Object paramObject) {}
  
  public final r<Boolean, Object> iUf()
  {
    return new r(Boolean.FALSE, this.acvb);
  }
  
  public final List<e> iUg()
  {
    return (List)ab.aivy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.b.a
 * JD-Core Version:    0.7.0.1
 */