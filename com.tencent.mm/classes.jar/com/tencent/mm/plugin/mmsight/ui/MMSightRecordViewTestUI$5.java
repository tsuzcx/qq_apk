package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Point;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;

final class MMSightRecordViewTestUI$5
  implements Runnable
{
  MMSightRecordViewTestUI$5(MMSightRecordViewTestUI paramMMSightRecordViewTestUI, TextView paramTextView) {}
  
  public final void run()
  {
    AppMethodBeat.i(55123);
    this.oOo.setText("");
    this.oOo.append(String.format("picture size: %s, ratio: %s\n", new Object[] { MMSightRecordViewTestUI.a(this.oOk).getPictureSize(), Float.valueOf(Math.min(MMSightRecordViewTestUI.a(this.oOk).getPictureSize().x, MMSightRecordViewTestUI.a(this.oOk).getPictureSize().y) / Math.max(MMSightRecordViewTestUI.a(this.oOk).getPictureSize().x, MMSightRecordViewTestUI.a(this.oOk).getPictureSize().y)) }));
    this.oOo.append(String.format("video size: %s, ratio: %s\n", new Object[] { MMSightRecordViewTestUI.a(this.oOk).getVideoSize(), Float.valueOf(Math.min(MMSightRecordViewTestUI.a(this.oOk).getVideoSize().x, MMSightRecordViewTestUI.a(this.oOk).getVideoSize().y) / Math.max(MMSightRecordViewTestUI.a(this.oOk).getVideoSize().x, MMSightRecordViewTestUI.a(this.oOk).getVideoSize().y)) }));
    this.oOo.append(String.format("preview size limit: %s\n", new Object[] { Integer.valueOf(MMSightRecordViewTestUI.b(this.oOk)) }));
    this.oOo.append(String.format("display ratio: %s\n", new Object[] { Float.valueOf(MMSightRecordViewTestUI.c(this.oOk)) }));
    this.oOo.append(String.format("view size: %s, ratio: %s\n", new Object[] { new Point(MMSightRecordViewTestUI.a(this.oOk).getWidth(), MMSightRecordViewTestUI.a(this.oOk).getHeight()), Float.valueOf(MMSightRecordViewTestUI.a(this.oOk).getWidth() / MMSightRecordViewTestUI.a(this.oOk).getHeight()) }));
    AppMethodBeat.o(55123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.5
 * JD-Core Version:    0.7.0.1
 */