package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class SnsAddressUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SnsAddressUI$1(SnsAddressUI paramSnsAddressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33923);
    paramMenuItem = new Intent();
    ArrayList localArrayList = bo.P((String[])SnsAddressUI.a(this.Afv).toArray(new String[0]));
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      paramMenuItem.putExtra("Select_Contact", "");
    }
    for (;;)
    {
      this.Afv.setResult(-1, paramMenuItem);
      this.Afv.finish();
      al.p(new SnsAddressUI.1.1(this), 100L);
      this.Afv.hideVKB();
      AppMethodBeat.o(33923);
      return true;
      paramMenuItem.putExtra("Select_Contact", bo.d(localArrayList, ","));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI.1
 * JD-Core Version:    0.7.0.1
 */