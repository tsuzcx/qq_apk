package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

final class SelectContactUI$15
  implements View.OnClickListener
{
  SelectContactUI$15(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33864);
    paramView = new Intent(this.Afg.getIntent());
    paramView.setClass(this.Afg.getContext(), OpenIMSelectContactUI.class);
    paramView.removeExtra("titile");
    paramView.putExtra("openim_appid", "3552365301");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = SelectContactUI.d(this.Afg).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (ad.arf(str)) {
        localArrayList.add(str);
      }
    }
    paramView.putExtra("already_select_contact", bo.d(localArrayList, ","));
    this.Afg.startActivityForResult(paramView, 5);
    AppMethodBeat.o(33864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.15
 * JD-Core Version:    0.7.0.1
 */