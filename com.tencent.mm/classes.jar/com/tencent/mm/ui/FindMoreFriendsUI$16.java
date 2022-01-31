package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FindMoreFriendsUI$16
  implements Runnable
{
  FindMoreFriendsUI$16(FindMoreFriendsUI paramFindMoreFriendsUI, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(29232);
    this.yWT.setVisibility(8);
    this.yWT.startAnimation(AnimationUtils.loadAnimation(this.yWI.getContext(), 2131034182));
    AppMethodBeat.o(29232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.16
 * JD-Core Version:    0.7.0.1
 */