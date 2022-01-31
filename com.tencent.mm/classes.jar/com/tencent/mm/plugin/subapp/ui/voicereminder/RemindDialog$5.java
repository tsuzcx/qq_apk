package com.tencent.mm.plugin.subapp.ui.voicereminder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.c;
import java.util.Iterator;
import java.util.List;

final class RemindDialog$5
  implements Runnable
{
  RemindDialog$5(RemindDialog paramRemindDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(25563);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = RemindDialog.a(this.sZX).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (bo.isNullOrNil(str)) {
        localStringBuffer.append("\n\n");
      } else {
        localStringBuffer.append(str + "\n\n");
      }
    }
    if (RemindDialog.d(this.sZX) != null) {
      RemindDialog.d(this.sZX).setMessage(localStringBuffer);
    }
    AppMethodBeat.o(25563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.5
 * JD-Core Version:    0.7.0.1
 */