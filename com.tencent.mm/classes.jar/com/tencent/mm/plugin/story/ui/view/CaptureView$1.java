package com.tencent.mm.plugin.story.ui.view;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/CaptureView$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$TouchCallback;", "onDoubleClick", "", "onTouchDown", "x", "", "y", "onZoomIn", "onZoomOut", "plugin-story_release"})
public final class CaptureView$1
  implements MMSightCaptureTouchView.a
{
  public final void T(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(110295);
    CaptureView.b(this.sLm).b(paramFloat1, paramFloat2, CaptureView.h(this.sLm).getWidth(), CaptureView.h(this.sLm).getHeight());
    CaptureView.i(this.sLm).Z(paramFloat1, paramFloat2);
    AppMethodBeat.o(110295);
  }
  
  public final void asQ()
  {
    AppMethodBeat.i(110297);
    CaptureView.b(this.sLm).a(true, false, 1);
    AppMethodBeat.o(110297);
  }
  
  public final void asR()
  {
    AppMethodBeat.i(110298);
    CaptureView.b(this.sLm).a(false, false, 1);
    AppMethodBeat.o(110298);
  }
  
  public final void bpb()
  {
    AppMethodBeat.i(110296);
    if (bo.av(CaptureView.j(this.sLm)) < 1000L)
    {
      AppMethodBeat.o(110296);
      return;
    }
    CaptureView.b(this.sLm).WW();
    CaptureView.a(this.sLm, CaptureView.b(this.sLm).WN());
    AppMethodBeat.o(110296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CaptureView.1
 * JD-Core Version:    0.7.0.1
 */