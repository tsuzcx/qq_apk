package com.tencent.mm.ui.contact;

import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

final class AddressUI$a$7
  implements VerticalScrollBar.a
{
  AddressUI$a$7(AddressUI.a parama) {}
  
  public final void eU(String paramString)
  {
    int i = 0;
    if (this.vJs.getString(R.l.scroll_bar_search).equals(paramString)) {
      AddressUI.a.c(this.vJs).setSelection(0);
    }
    Object localObject;
    do
    {
      return;
      localObject = AddressUI.a.a(this.vJs);
      y.v("MicroMsg.AddressAdapter", "getSections");
      localObject = ((a)localObject).vIy;
    } while (localObject == null);
    if ("↑".equals(paramString))
    {
      AddressUI.a.c(this.vJs).setSelection(0);
      return;
    }
    if ("☆".equals(paramString))
    {
      AddressUI.a.c(this.vJs).setSelection(AddressUI.a.c(this.vJs).getHeaderViewsCount());
      return;
    }
    do
    {
      i += 1;
      if ((i >= localObject.length) || (localObject[i] == null)) {
        break;
      }
    } while (!localObject[i].equals(paramString));
    i = AddressUI.a.a(this.vJs).getPositionForSection(i);
    AddressUI.a.c(this.vJs).setSelection(i + AddressUI.a.c(this.vJs).getHeaderViewsCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.a.7
 * JD-Core Version:    0.7.0.1
 */