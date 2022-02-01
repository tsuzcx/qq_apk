package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;

final class SnsUserUI$18
  implements Runnable
{
  SnsUserUI$18(SnsUserUI paramSnsUserUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(203802);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    int j = KeyBoardUtil.getStatusHeight(this.EQA);
    if (KeyBoardUtil.isPortOrientation(this.EQA)) {}
    for (int i = this.EQA.getResources().getDimensionPixelSize(2131165256);; i = this.EQA.getResources().getDimensionPixelSize(2131165255))
    {
      localLayoutParams.topMargin = (i + j);
      SnsUserUI.p(this.EQA).setLayoutParams(localLayoutParams);
      AppMethodBeat.o(203802);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.18
 * JD-Core Version:    0.7.0.1
 */