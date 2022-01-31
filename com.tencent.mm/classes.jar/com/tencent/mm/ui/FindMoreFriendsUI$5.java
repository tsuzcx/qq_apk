package com.tencent.mm.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FindMoreFriendsUI$5
  implements Runnable
{
  int ePG = 0;
  
  FindMoreFriendsUI$5(FindMoreFriendsUI paramFindMoreFriendsUI, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(29211);
    if (this.yWI.getView() == null)
    {
      AppMethodBeat.o(29211);
      return;
    }
    int i = am.di(this.yWI.getContext());
    int j = am.K(this.yWI.getContext(), -1);
    if (j <= 0) {
      if (this.ePG < 2)
      {
        ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight again!");
        this.yWI.getView().post(this);
        this.ePG += 1;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.ePG), Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(29211);
      return;
      ab.e("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight finally!");
      break;
      int k = FindMoreFriendsUI.i(this.yWI);
      if (k != this.yWI.getView().getPaddingTop())
      {
        ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.yWI.getView().getPaddingTop()) });
        this.yWI.getView().setPadding(0, k, 0, this.alj.getHeight());
      }
      else
      {
        ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.5
 * JD-Core Version:    0.7.0.1
 */