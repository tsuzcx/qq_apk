package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/UnSelectUserAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "username", "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends BaseStateAction
{
  public final String username;
  
  public l(String paramString)
  {
    AppMethodBeat.i(250430);
    this.username = paramString;
    AppMethodBeat.o(250430);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250454);
    if (this == paramObject)
    {
      AppMethodBeat.o(250454);
      return true;
    }
    if (!(paramObject instanceof l))
    {
      AppMethodBeat.o(250454);
      return false;
    }
    paramObject = (l)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(250454);
      return false;
    }
    AppMethodBeat.o(250454);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(250446);
    int i = this.username.hashCode();
    AppMethodBeat.o(250446);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250438);
    String str = "UnSelectUserAction(username=" + this.username + ')';
    AppMethodBeat.o(250438);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.l
 * JD-Core Version:    0.7.0.1
 */