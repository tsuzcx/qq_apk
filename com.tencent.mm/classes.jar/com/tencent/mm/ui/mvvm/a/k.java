package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.IStateActionResult;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SelectUserActionResult;", "Lcom/tencent/mm/sdk/statecenter/IStateActionResult;", "operation", "Lcom/tencent/mm/ui/mvvm/state/SelectUserActionResult$Operation;", "retCode", "Lcom/tencent/mm/ui/mvvm/state/SelectUserActionResult$Code;", "(Lcom/tencent/mm/ui/mvvm/state/SelectUserActionResult$Operation;Lcom/tencent/mm/ui/mvvm/state/SelectUserActionResult$Code;)V", "getOperation", "()Lcom/tencent/mm/ui/mvvm/state/SelectUserActionResult$Operation;", "getRetCode", "()Lcom/tencent/mm/ui/mvvm/state/SelectUserActionResult$Code;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Code", "Operation", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements IStateActionResult
{
  public final b afBb;
  public final a afBc;
  
  public k(b paramb, a parama)
  {
    AppMethodBeat.i(250434);
    this.afBb = paramb;
    this.afBc = parama;
    AppMethodBeat.o(250434);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof k)) {
        return false;
      }
      paramObject = (k)paramObject;
      if (this.afBb != paramObject.afBb) {
        return false;
      }
    } while (this.afBc == paramObject.afBc);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(250450);
    int i = this.afBb.hashCode();
    int j = this.afBc.hashCode();
    AppMethodBeat.o(250450);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250443);
    String str = "SelectUserActionResult(operation=" + this.afBb + ", retCode=" + this.afBc + ')';
    AppMethodBeat.o(250443);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SelectUserActionResult$Code;", "", "(Ljava/lang/String;I)V", "Success", "MaxLimit", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(250493);
      afBd = new a("Success", 0);
      afBe = new a("MaxLimit", 1);
      afBf = new a[] { afBd, afBe };
      AppMethodBeat.o(250493);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SelectUserActionResult$Operation;", "", "(Ljava/lang/String;I)V", "Add", "Remove", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(250506);
      afBg = new b("Add", 0);
      afBh = new b("Remove", 1);
      afBi = new b[] { afBg, afBh };
      AppMethodBeat.o(250506);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.k
 * JD-Core Version:    0.7.0.1
 */