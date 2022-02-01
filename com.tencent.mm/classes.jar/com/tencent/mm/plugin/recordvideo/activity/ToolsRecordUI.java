package com.tencent.mm.plugin.recordvideo.activity;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/activity/ToolsRecordUI;", "Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "()V", "plugin-recordvideo_release"})
public final class ToolsRecordUI
  extends MMRecordUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.ToolsRecordUI
 * JD-Core Version:    0.7.0.1
 */