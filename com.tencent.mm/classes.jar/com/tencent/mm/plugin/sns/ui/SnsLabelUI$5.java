package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;

final class SnsLabelUI$5
  implements ExpandableListView.OnGroupClickListener
{
  SnsLabelUI$5(SnsLabelUI paramSnsLabelUI) {}
  
  public final boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(39015);
    int i = SnsLabelUI.a(this.rSh).rSq;
    ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (paramInt > 1)
    {
      if ((SnsLabelUI.b(this.rSh) != null) && (SnsLabelUI.b(this.rSh).size() != 0) && (SnsLabelUI.cvA() == 0))
      {
        SnsLabelUI.a(this.rSh, paramInt);
        SnsLabelUI.c(this.rSh);
        ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
        AppMethodBeat.o(39015);
        return true;
      }
      if (SnsLabelUI.d(this.rSh))
      {
        SnsLabelUI.e(this.rSh);
        SnsLabelUI.a(this.rSh, paramInt);
        SnsLabelUI.a(this.rSh, h.b(this.rSh, this.rSh.getString(2131303858), false, null));
        ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
        AppMethodBeat.o(39015);
        return true;
      }
      if ((SnsLabelUI.a(this.rSh).rSp == null) || (SnsLabelUI.a(this.rSh).rSp.size() == 0))
      {
        SnsLabelUI.a(this.rSh, paramInt);
        SnsLabelUI.f(this.rSh);
        ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
        AppMethodBeat.o(39015);
        return true;
      }
      if (i == paramInt)
      {
        if (SnsLabelUI.g(this.rSh).isGroupExpanded(paramInt)) {
          SnsLabelUI.g(this.rSh).Rp(paramInt);
        }
        for (;;)
        {
          SnsLabelUI.a(this.rSh).rSq = paramInt;
          AppMethodBeat.o(39015);
          return true;
          SnsLabelUI.g(this.rSh).Ro(paramInt);
        }
      }
      if (i == 2)
      {
        SnsLabelUI.g(this.rSh).collapseGroup(2);
        SnsLabelUI.a(this.rSh).rSs.clear();
        SnsLabelUI.a(this.rSh).rSu.clear();
      }
      for (;;)
      {
        SnsLabelUI.g(this.rSh).post(new SnsLabelUI.5.1(this, paramInt));
        break;
        if (i == 3)
        {
          SnsLabelUI.g(this.rSh).collapseGroup(3);
          SnsLabelUI.a(this.rSh).rSt.clear();
          SnsLabelUI.a(this.rSh).rSv.clear();
        }
      }
    }
    if (i > 1) {
      SnsLabelUI.g(this.rSh).Rp(i);
    }
    SnsLabelUI.a(this.rSh).rSq = paramInt;
    AppMethodBeat.o(39015);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.5
 * JD-Core Version:    0.7.0.1
 */