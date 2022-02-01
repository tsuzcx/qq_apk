package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SelectConfirmAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "usernameList", "", "", "sourceRequestCode", "", "(Ljava/util/List;I)V", "getSourceRequestCode", "()I", "getUsernameList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends BaseStateAction
{
  public final int aflx;
  public final List<String> maB;
  
  public h(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(250473);
    this.maB = paramList;
    this.aflx = paramInt;
    AppMethodBeat.o(250473);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250494);
    if (this == paramObject)
    {
      AppMethodBeat.o(250494);
      return true;
    }
    if (!(paramObject instanceof h))
    {
      AppMethodBeat.o(250494);
      return false;
    }
    paramObject = (h)paramObject;
    if (!s.p(this.maB, paramObject.maB))
    {
      AppMethodBeat.o(250494);
      return false;
    }
    if (this.aflx != paramObject.aflx)
    {
      AppMethodBeat.o(250494);
      return false;
    }
    AppMethodBeat.o(250494);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(250486);
    int i = this.maB.hashCode();
    int j = this.aflx;
    AppMethodBeat.o(250486);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250479);
    String str = "SelectConfirmAction(usernameList=" + this.maB + ", sourceRequestCode=" + this.aflx + ')';
    AppMethodBeat.o(250479);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.h
 * JD-Core Version:    0.7.0.1
 */