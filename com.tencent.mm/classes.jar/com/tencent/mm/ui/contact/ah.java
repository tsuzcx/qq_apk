package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/RecentForwardItemConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "data", "Lcom/tencent/mm/ui/contact/RecentForwardItemData;", "(Lcom/tencent/mm/ui/contact/RecentForwardItemData;)V", "getData", "()Lcom/tencent/mm/ui/contact/RecentForwardItemData;", "getItemId", "", "getItemType", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  implements a
{
  public final ai afhj;
  
  public ah(ai paramai)
  {
    AppMethodBeat.i(252792);
    this.afhj = paramai;
    AppMethodBeat.o(252792);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(252795);
    long l = this.afhj.hashCode();
    AppMethodBeat.o(252795);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ah
 * JD-Core Version:    0.7.0.1
 */