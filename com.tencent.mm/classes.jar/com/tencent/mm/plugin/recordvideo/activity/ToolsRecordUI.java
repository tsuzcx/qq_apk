package com.tencent.mm.plugin.recordvideo.activity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/activity/ToolsRecordUI;", "Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "()V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ToolsRecordUI
  extends MMRecordUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.ToolsRecordUI
 * JD-Core Version:    0.7.0.1
 */