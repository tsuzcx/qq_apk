package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.protocal.protobuf.esy;

public final class l
  extends f
{
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final int getLayoutId()
  {
    return c.e.top_story_fs_v_video_control_bar;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126405);
    super.init();
    findViewById(c.d.divider).setVisibility(8);
    this.Nbx.setVisibility(8);
    this.Nbw.setVisibility(8);
    this.Nbv.setVisibility(8);
    findViewById(c.d.source_root).setVisibility(8);
    AppMethodBeat.o(126405);
  }
  
  public final void n(esy paramesy)
  {
    AppMethodBeat.i(126406);
    super.n(paramesy);
    findViewById(c.d.divider).setVisibility(8);
    this.Nbx.setVisibility(8);
    this.Nbw.setVisibility(8);
    this.Nbv.setVisibility(8);
    findViewById(c.d.source_root).setVisibility(8);
    AppMethodBeat.o(126406);
  }
  
  public final void setOnUpdateProgressLenListener(f.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.l
 * JD-Core Version:    0.7.0.1
 */