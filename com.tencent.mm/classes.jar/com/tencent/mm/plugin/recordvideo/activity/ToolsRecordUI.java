package com.tencent.mm.plugin.recordvideo.activity;

import a.l;
import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/activity/ToolsRecordUI;", "Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "()V", "plugin-recordvideo_release"})
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