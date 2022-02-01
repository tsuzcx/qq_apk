package com.tencent.mm.plugin.recordvideo.plugin;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-recordvideo_release"})
public final class w$g
  implements MMSightRecordButton.c
{
  public final void AW(int paramInt)
  {
    AppMethodBeat.i(204116);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
    localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
    this.vle.vjo.a(d.c.vnv, localBundle);
    AppMethodBeat.o(204116);
  }
  
  public final void AX(int paramInt)
  {
    AppMethodBeat.i(204117);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
    localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
    this.vle.vjo.a(d.c.vnv, localBundle);
    AppMethodBeat.o(204117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.w.g
 * JD-Core Version:    0.7.0.1
 */