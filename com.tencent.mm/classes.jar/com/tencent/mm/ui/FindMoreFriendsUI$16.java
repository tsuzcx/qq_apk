package com.tencent.mm.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class FindMoreFriendsUI$16
  implements Runnable
{
  int nrQ = 0;
  
  FindMoreFriendsUI$16(FindMoreFriendsUI paramFindMoreFriendsUI, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(249101);
    if (this.adyF.getView() == null)
    {
      AppMethodBeat.o(249101);
      return;
    }
    int i = bf.fs(this.adyF.getContext());
    int j = bf.I(this.adyF.getContext(), -1);
    if (j <= 0) {
      if (this.nrQ < 2)
      {
        Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight again!");
        this.adyF.getView().post(this);
        this.nrQ += 1;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.nrQ), Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(249101);
      return;
      Log.e("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight finally!");
      break;
      int k = FindMoreFriendsUI.h(this.adyF);
      if (k != this.adyF.getView().getPaddingTop())
      {
        Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.adyF.getView().getPaddingTop()) });
        this.adyF.getView().setPadding(0, k, 0, this.uU.getHeight());
      }
      else
      {
        Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.16
 * JD-Core Version:    0.7.0.1
 */