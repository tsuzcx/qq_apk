package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

final class SelectContactUI$14
  implements View.OnClickListener
{
  SelectContactUI$14(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.vNB.getIntent());
    paramView.setClass(this.vNB.mController.uMN, OpenIMSelectContactUI.class);
    paramView.removeExtra("titile");
    paramView.putExtra("openim_appid", "3552365301");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = SelectContactUI.c(this.vNB).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (ad.aaU(str)) {
        localArrayList.add(str);
      }
    }
    paramView.putExtra("already_select_contact", bk.c(localArrayList, ","));
    this.vNB.startActivityForResult(paramView, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.14
 * JD-Core Version:    0.7.0.1
 */