package com.tencent.mm.plugin.record.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

final class RecordMsgImageUI$7
  implements MMGestureGallery.c
{
  RecordMsgImageUI$7(RecordMsgImageUI paramRecordMsgImageUI) {}
  
  public final void bxv()
  {
    AppMethodBeat.i(24299);
    v.b localb = v.aae().z("basescanui@datacenter", true);
    localb.i("key_basescanui_screen_x", Integer.valueOf(RecordMsgImageUI.d(this.pZV).getXDown()));
    localb.i("key_basescanui_screen_y", Integer.valueOf(RecordMsgImageUI.d(this.pZV).getYDown()));
    RecordMsgImageUI.e(this.pZV);
    AppMethodBeat.o(24299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI.7
 * JD-Core Version:    0.7.0.1
 */