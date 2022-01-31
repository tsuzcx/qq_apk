package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class OpenIMAddressUI$OpenIMAddressUIFragment$12
  implements MMSlideDelView.c
{
  OpenIMAddressUI$OpenIMAddressUIFragment$12(OpenIMAddressUI.OpenIMAddressUIFragment paramOpenIMAddressUIFragment) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(33777);
    int i = OpenIMAddressUI.OpenIMAddressUIFragment.c(this.Aes).getPositionForView(paramView);
    AppMethodBeat.o(33777);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.12
 * JD-Core Version:    0.7.0.1
 */