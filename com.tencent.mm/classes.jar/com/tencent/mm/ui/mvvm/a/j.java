package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import com.tencent.mm.ui.mvvm.item.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SelectUserAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "item", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "position", "", "(Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;I)V", "getItem", "()Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends BaseStateAction
{
  public final b afAU;
  private final int position;
  
  public j(b paramb, int paramInt)
  {
    AppMethodBeat.i(250469);
    this.afAU = paramb;
    this.position = paramInt;
    AppMethodBeat.o(250469);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250489);
    if (this == paramObject)
    {
      AppMethodBeat.o(250489);
      return true;
    }
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(250489);
      return false;
    }
    paramObject = (j)paramObject;
    if (!s.p(this.afAU, paramObject.afAU))
    {
      AppMethodBeat.o(250489);
      return false;
    }
    if (this.position != paramObject.position)
    {
      AppMethodBeat.o(250489);
      return false;
    }
    AppMethodBeat.o(250489);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(250481);
    int i = this.afAU.hashCode();
    int j = this.position;
    AppMethodBeat.o(250481);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250474);
    String str = "SelectUserAction(item=" + this.afAU + ", position=" + this.position + ')';
    AppMethodBeat.o(250474);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.j
 * JD-Core Version:    0.7.0.1
 */