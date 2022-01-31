package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class VideoAdPlayerUI$3
  implements View.OnClickListener
{
  VideoAdPlayerUI$3(VideoAdPlayerUI paramVideoAdPlayerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39914);
    VideoAdPlayerUI localVideoAdPlayerUI = this.sdl;
    if (VideoAdPlayerUI.k(this.sdl)) {}
    for (paramView = VideoAdPlayerUI.l(this.sdl);; paramView = VideoAdPlayerUI.m(this.sdl))
    {
      h.a(localVideoAdPlayerUI, null, paramView, null, new VideoAdPlayerUI.3.1(this));
      AppMethodBeat.o(39914);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.3
 * JD-Core Version:    0.7.0.1
 */