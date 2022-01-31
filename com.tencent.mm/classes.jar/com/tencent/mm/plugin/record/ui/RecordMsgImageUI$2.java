package com.tencent.mm.plugin.record.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Iterator;
import java.util.List;

final class RecordMsgImageUI$2
  implements Runnable
{
  RecordMsgImageUI$2(RecordMsgImageUI paramRecordMsgImageUI, List paramList, String paramString, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(24295);
    Iterator localIterator = this.pZO.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      g.bPJ().a(this.pZV.getContext(), str, RecordMsgImageUI.j(this.pZV), 0, "", "");
      g.bPJ().fh(this.mxS, str);
    }
    al.d(this.bZt);
    AppMethodBeat.o(24295);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153609);
    String str = super.toString() + "|onActivityResult";
    AppMethodBeat.o(153609);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI.2
 * JD-Core Version:    0.7.0.1
 */