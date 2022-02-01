package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;

final class FindMoreFriendsUI$34
  implements Runnable
{
  FindMoreFriendsUI$34(FindMoreFriendsUI paramFindMoreFriendsUI, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(249737);
    this.adyP.setVisibility(8);
    this.adyP.startAnimation(AnimationUtils.loadAnimation(this.adyF.getContext(), R.a.fast_faded_out));
    AppMethodBeat.o(249737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.34
 * JD-Core Version:    0.7.0.1
 */