package com.tencent.mm.sensitive.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.a.e;
import com.tencent.mm.sensitive.a.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/methodconfig/method/GetConnectionInfoCheck;", "Lcom/tencent/mm/sensitive/methodconfig/BaseMethodMethodCheck;", "()V", "conditionList", "", "Lcom/tencent/mm/sensitive/condition/ICondition;", "getConditionList", "()Ljava/util/List;", "methodName", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.sensitive.b.b
{
  private final List<e> acvs;
  
  public b()
  {
    AppMethodBeat.i(241080);
    this.acvs = p.listOf(new f((a)new a(this), (a)b.acvu));
    AppMethodBeat.o(241080);
  }
  
  public final List<e> iUg()
  {
    return this.acvs;
  }
  
  public final String iUh()
  {
    return "getConnectionInfo";
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Long>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Long>
  {
    public static final b acvu;
    
    static
    {
      AppMethodBeat.i(241092);
      acvu = new b();
      AppMethodBeat.o(241092);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.b.a.b
 * JD-Core Version:    0.7.0.1
 */