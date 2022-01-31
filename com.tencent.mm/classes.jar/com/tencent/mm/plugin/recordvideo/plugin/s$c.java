package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.recordvideo.c.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnablePicture$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-recordvideo_release"})
public final class s$c
  implements MMSightRecordButton.b
{
  public final void boX()
  {
    AppMethodBeat.i(150704);
    d.b.a(this.qcT.qbI, d.c.qeq);
    AppMethodBeat.o(150704);
  }
  
  public final void boY()
  {
    AppMethodBeat.i(150702);
    Object localObject = new int[2];
    this.qcT.oPm.getLocationOnScreen((int[])localObject);
    Bundle localBundle = new Bundle();
    localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT", localObject[1]);
    this.qcT.qbI.a(d.c.qel, localBundle);
    this.qcT.lyj.animate().alpha(0.0F).withEndAction((Runnable)new s.c.b(this)).start();
    localObject = b.qfu;
    b.Cs(2);
    AppMethodBeat.o(150702);
  }
  
  public final void hH()
  {
    AppMethodBeat.i(150703);
    d.b.a(this.qcT.qbI, d.c.qep);
    MMSightRecordButton localMMSightRecordButton = this.qcT.oPm;
    int i = this.qcT.qcP;
    Context localContext = this.qcT.odi.getContext();
    j.p(localContext, "layout.context");
    localMMSightRecordButton.a(i, localContext.getResources().getColor(2131690701), (MMSightCircularProgressBar.a)new s.c.a(this));
    AppMethodBeat.o(150703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s.c
 * JD-Core Version:    0.7.0.1
 */