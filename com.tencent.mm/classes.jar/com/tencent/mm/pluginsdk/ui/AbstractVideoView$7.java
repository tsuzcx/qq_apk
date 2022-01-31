package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AbstractVideoView$7
  implements View.OnClickListener
{
  AbstractVideoView$7(AbstractVideoView paramAbstractVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(117940);
    ab.i(this.vPL.TAG, "%s seek bar play button on click ", new Object[] { this.vPL.bas() });
    paramView = this.vPL;
    if (paramView.kvG != null)
    {
      if (paramView.isPlaying())
      {
        paramView.pause();
        AppMethodBeat.o(117940);
        return;
      }
      if (bo.isNullOrNil(paramView.kvG.getVideoPath()))
      {
        paramView.start();
        AppMethodBeat.o(117940);
        return;
      }
      paramView.play();
    }
    AppMethodBeat.o(117940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.7
 * JD-Core Version:    0.7.0.1
 */