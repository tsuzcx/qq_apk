package com.tencent.mm.plugin.recordvideo.ui.editor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class MMEditorRecordButton$4
  implements Runnable
{
  MMEditorRecordButton$4(MMEditorRecordButton paramMMEditorRecordButton) {}
  
  public final void run()
  {
    AppMethodBeat.i(279921);
    Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.e(this.NWF)) });
    if (MMEditorRecordButton.e(this.NWF)) {
      MMEditorRecordButton.f(this.NWF);
    }
    AppMethodBeat.o(279921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton.4
 * JD-Core Version:    0.7.0.1
 */