package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;

final class VideoRecorderUI$7
  implements View.OnClickListener
{
  VideoRecorderUI$7(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25652);
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      t.ii(this.tbs);
      AppMethodBeat.o(25652);
      return;
    }
    if (VideoRecorderUI.k(this.tbs))
    {
      VideoRecorderUI.d(this.tbs);
      AppMethodBeat.o(25652);
      return;
    }
    if (VideoRecorderUI.l(this.tbs))
    {
      h.a(this.tbs, this.tbs.getString(2131304533), this.tbs.getString(2131297087), new VideoRecorderUI.7.1(this), new VideoRecorderUI.7.2(this));
      AppMethodBeat.o(25652);
      return;
    }
    VideoRecorderUI.m(this.tbs).setImageResource(2130840667);
    VideoRecorderUI.n(this.tbs);
    AppMethodBeat.o(25652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.7
 * JD-Core Version:    0.7.0.1
 */