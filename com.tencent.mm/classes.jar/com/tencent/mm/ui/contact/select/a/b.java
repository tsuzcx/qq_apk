package com.tencent.mm.ui.contact.select.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/select/state/OpenImSelectAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "selectList", "", "", "cancelList", "(Ljava/util/List;Ljava/util/List;)V", "getCancelList", "()Ljava/util/List;", "getSelectList", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends BaseStateAction
{
  public final List<String> GMh;
  public final List<String> afly;
  
  public b(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(253091);
    this.GMh = paramList1;
    this.afly = paramList2;
    AppMethodBeat.o(253091);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(253105);
    if (this == paramObject)
    {
      AppMethodBeat.o(253105);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(253105);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.GMh, paramObject.GMh))
    {
      AppMethodBeat.o(253105);
      return false;
    }
    if (!s.p(this.afly, paramObject.afly))
    {
      AppMethodBeat.o(253105);
      return false;
    }
    AppMethodBeat.o(253105);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(253099);
    int i = this.GMh.hashCode();
    int j = this.afly.hashCode();
    AppMethodBeat.o(253099);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(253096);
    String str = "OpenImSelectAction(selectList=" + this.GMh + ", cancelList=" + this.afly + ')';
    AppMethodBeat.o(253096);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.select.a.b
 * JD-Core Version:    0.7.0.1
 */