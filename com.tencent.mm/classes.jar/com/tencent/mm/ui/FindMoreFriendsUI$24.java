package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FindMoreFriendsUI$24
  implements Runnable
{
  FindMoreFriendsUI$24(FindMoreFriendsUI paramFindMoreFriendsUI, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(33063);
    this.Hjf.setVisibility(8);
    this.Hjf.startAnimation(AnimationUtils.loadAnimation(this.HiV.getContext(), 2130772048));
    AppMethodBeat.o(33063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.24
 * JD-Core Version:    0.7.0.1
 */