package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;

final class SnsLabelUI$5
  implements ExpandableListView.OnGroupClickListener
{
  SnsLabelUI$5(SnsLabelUI paramSnsLabelUI) {}
  
  public final boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    int i = SnsLabelUI.a(this.oZN).oZT;
    y.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (paramInt > 1)
    {
      if ((SnsLabelUI.b(this.oZN) != null) && (SnsLabelUI.b(this.oZN).size() != 0) && (SnsLabelUI.bJd() == 0))
      {
        SnsLabelUI.a(this.oZN, paramInt);
        SnsLabelUI.c(this.oZN);
        y.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
        return true;
      }
      if (SnsLabelUI.d(this.oZN))
      {
        SnsLabelUI.e(this.oZN);
        SnsLabelUI.a(this.oZN, paramInt);
        SnsLabelUI.a(this.oZN, h.b(this.oZN, this.oZN.getString(i.j.sns_label_is_transforming), false, null));
        y.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
        return true;
      }
      if ((SnsLabelUI.a(this.oZN).oZS == null) || (SnsLabelUI.a(this.oZN).oZS.size() == 0))
      {
        SnsLabelUI.a(this.oZN, paramInt);
        SnsLabelUI.f(this.oZN);
        y.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
        return true;
      }
      if (i == paramInt)
      {
        if (SnsLabelUI.g(this.oZN).isGroupExpanded(paramInt)) {
          SnsLabelUI.g(this.oZN).Ix(paramInt);
        }
        for (;;)
        {
          SnsLabelUI.a(this.oZN).oZT = paramInt;
          return true;
          SnsLabelUI.g(this.oZN).Iw(paramInt);
        }
      }
      if (i == 2)
      {
        SnsLabelUI.g(this.oZN).collapseGroup(2);
        SnsLabelUI.a(this.oZN).oZV.clear();
        SnsLabelUI.a(this.oZN).oZX.clear();
      }
      for (;;)
      {
        SnsLabelUI.g(this.oZN).post(new SnsLabelUI.5.1(this, paramInt));
        break;
        if (i == 3)
        {
          SnsLabelUI.g(this.oZN).collapseGroup(3);
          SnsLabelUI.a(this.oZN).oZW.clear();
          SnsLabelUI.a(this.oZN).oZY.clear();
        }
      }
    }
    if (i > 1) {
      SnsLabelUI.g(this.oZN).Ix(i);
    }
    SnsLabelUI.a(this.oZN).oZT = paramInt;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.5
 * JD-Core Version:    0.7.0.1
 */