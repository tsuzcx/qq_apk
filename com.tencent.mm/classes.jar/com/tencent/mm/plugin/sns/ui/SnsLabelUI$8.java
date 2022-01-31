package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

final class SnsLabelUI$8
  implements MenuItem.OnMenuItemClickListener
{
  SnsLabelUI$8(SnsLabelUI paramSnsLabelUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.oZN;
    String str1 = bk.c(paramMenuItem.oZz.oZV, ",");
    String str2 = bk.c(paramMenuItem.oZz.oZX, ",");
    String str3 = bk.c(paramMenuItem.oZz.oZW, ",");
    String str4 = bk.c(paramMenuItem.oZz.oZY, ",");
    if (((paramMenuItem.oZz.oZT == 2) && (paramMenuItem.oZz.oZV.size() == 0) && (paramMenuItem.oZz.oZX.size() == 0)) || ((paramMenuItem.oZz.oZT == 3) && (paramMenuItem.oZz.oZW.size() == 0) && (paramMenuItem.oZz.oZY.size() == 0))) {
      h.a(paramMenuItem, paramMenuItem.getString(i.j.sns_label_need_select_one_least), "", paramMenuItem.getString(i.j.sns_label_transform_ok), null);
    }
    for (;;)
    {
      return true;
      if (((paramMenuItem.oZz.oZT == 2) && (bk.bl(str1)) && (bk.bl(str2))) || ((paramMenuItem.oZz.oZT == 3) && (bk.bl(str3)) && (bk.bl(str4)))) {
        h.a(paramMenuItem, paramMenuItem.getString(i.j.sns_label_need_select_one_least), "", paramMenuItem.getString(i.j.sns_label_transform_ok), null);
      } else {
        paramMenuItem.bIY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.8
 * JD-Core Version:    0.7.0.1
 */