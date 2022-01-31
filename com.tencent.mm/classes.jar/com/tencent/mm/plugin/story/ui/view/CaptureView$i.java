package com.tencent.mm.plugin.story.ui.view;

import a.f.a.b;
import a.l;
import android.graphics.Color;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.media.widget.camerarecordview.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.story.c.a.c;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/CaptureView$initCaptureButton$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-story_release"})
public final class CaptureView$i
  implements MMSightRecordButton.b
{
  public final void boX()
  {
    AppMethodBeat.i(110314);
    if (!CaptureView.b(this.sLm).c((b)new CaptureView.i.b(this))) {
      CaptureView.a(this.sLm, 2131304174);
    }
    CaptureView.d(this.sLm).setVisibility(0);
    CaptureView.e(this.sLm).setVisibility(0);
    AppMethodBeat.o(110314);
  }
  
  public final void boY()
  {
    AppMethodBeat.i(110312);
    Object localObject = new int[2];
    CaptureView.a(this.sLm).getLocationOnScreen((int[])localObject);
    CaptureView.b(this.sLm).kk(localObject[1]);
    CaptureView.c(this.sLm);
    localObject = i.sFa;
    i.FR(2);
    localObject = i.sFa;
    i.cDm().FU();
    AppMethodBeat.o(110312);
  }
  
  public final void hH()
  {
    AppMethodBeat.i(110313);
    c.a locala = (c.a)c.srQ.Uw();
    CaptureView.a(this.sLm).a(locala.qbq.duration * 1000, Color.parseColor("#0E9CE6"), (MMSightCircularProgressBar.a)new CaptureView.i.a(this));
    a.a(CaptureView.b(this.sLm));
    CaptureView.d(this.sLm).setVisibility(8);
    CaptureView.e(this.sLm).setVisibility(8);
    CaptureView.a(this.sLm, bo.yB());
    AppMethodBeat.o(110313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CaptureView.i
 * JD-Core Version:    0.7.0.1
 */