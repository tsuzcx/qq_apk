package com.tencent.mm.ui.contact.select.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/select/state/MultiSelectAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "usernameList", "", "", "sourceRequestCode", "", "(Ljava/util/List;I)V", "getSourceRequestCode", "()I", "getUsernameList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends BaseStateAction
{
  private final int aflx;
  public final List<String> maB;
  
  public a(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(253090);
    this.maB = paramList;
    this.aflx = paramInt;
    AppMethodBeat.o(253090);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(253101);
    if (this == paramObject)
    {
      AppMethodBeat.o(253101);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(253101);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.maB, paramObject.maB))
    {
      AppMethodBeat.o(253101);
      return false;
    }
    if (this.aflx != paramObject.aflx)
    {
      AppMethodBeat.o(253101);
      return false;
    }
    AppMethodBeat.o(253101);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(253097);
    int i = this.maB.hashCode();
    int j = this.aflx;
    AppMethodBeat.o(253097);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(253094);
    String str = "MultiSelectAction(usernameList=" + this.maB + ", sourceRequestCode=" + this.aflx + ')';
    AppMethodBeat.o(253094);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.select.a.a
 * JD-Core Version:    0.7.0.1
 */