package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class SnsAddressUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SnsAddressUI$1(SnsAddressUI paramSnsAddressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    ArrayList localArrayList = bk.G((String[])SnsAddressUI.a(this.vNN).toArray(new String[0]));
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      paramMenuItem.putExtra("Select_Contact", "");
    }
    for (;;)
    {
      this.vNN.setResult(-1, paramMenuItem);
      this.vNN.finish();
      ai.l(new SnsAddressUI.1.1(this), 100L);
      this.vNN.XM();
      return true;
      paramMenuItem.putExtra("Select_Contact", bk.c(localArrayList, ","));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI.1
 * JD-Core Version:    0.7.0.1
 */