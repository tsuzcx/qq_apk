package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import com.tencent.mm.ui.mvvm.item.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SearchMoreClickAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "item", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "(Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;)V", "getItem", "()Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends BaseStateAction
{
  public final b afAU;
  
  public e(b paramb)
  {
    AppMethodBeat.i(250442);
    this.afAU = paramb;
    AppMethodBeat.o(250442);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250463);
    if (this == paramObject)
    {
      AppMethodBeat.o(250463);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(250463);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.afAU, paramObject.afAU))
    {
      AppMethodBeat.o(250463);
      return false;
    }
    AppMethodBeat.o(250463);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(250456);
    int i = this.afAU.hashCode();
    AppMethodBeat.o(250456);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250449);
    String str = "SearchMoreClickAction(item=" + this.afAU + ')';
    AppMethodBeat.o(250449);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.e
 * JD-Core Version:    0.7.0.1
 */