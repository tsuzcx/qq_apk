package com.tencent.mm.plugin.recordvideo.ui.editor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class MMEditorRecordButton$3
  implements Runnable
{
  MMEditorRecordButton$3(MMEditorRecordButton paramMMEditorRecordButton) {}
  
  public final void run()
  {
    AppMethodBeat.i(279914);
    Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(this.NWF)), Boolean.valueOf(MMEditorRecordButton.b(this.NWF)) });
    if (!MMEditorRecordButton.a(this.NWF))
    {
      MMEditorRecordButton.c(this.NWF);
      if (MMEditorRecordButton.d(this.NWF) != null) {
        MMEditorRecordButton.d(this.NWF);
      }
    }
    AppMethodBeat.o(279914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton.3
 * JD-Core Version:    0.7.0.1
 */