package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$TouchCallback;", "onDoubleClick", "", "onTouchDown", "x", "", "y", "onZoomIn", "onZoomOut", "plugin-recordvideo_release"})
public final class u$1
  implements MMSightCaptureTouchView.a
{
  u$1(d paramd) {}
  
  public final void T(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150716);
    Bundle localBundle = new Bundle();
    localBundle.putFloat("PARAM_POINT_X", paramFloat1);
    localBundle.putFloat("PARAM_POINT_Y", paramFloat2);
    this.qcL.a(d.c.qeo, localBundle);
    u.a(this.qcY).Z(paramFloat1, paramFloat2);
    AppMethodBeat.o(150716);
  }
  
  public final void asQ()
  {
    AppMethodBeat.i(150718);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
    localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
    this.qcL.a(d.c.qem, localBundle);
    AppMethodBeat.o(150718);
  }
  
  public final void asR()
  {
    AppMethodBeat.i(150719);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
    localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
    this.qcL.a(d.c.qem, localBundle);
    AppMethodBeat.o(150719);
  }
  
  public final void bpb()
  {
    AppMethodBeat.i(150717);
    if (bo.av(u.b(this.qcY)) < 1000L)
    {
      AppMethodBeat.o(150717);
      return;
    }
    u.a(this.qcY, bo.yB());
    d.b.a(this.qcL, d.c.qen);
    AppMethodBeat.o(150717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.u.1
 * JD-Core Version:    0.7.0.1
 */