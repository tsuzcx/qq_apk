package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.List;

final class RecordMsgImageUI$11
  implements Runnable
{
  RecordMsgImageUI$11(RecordMsgImageUI paramRecordMsgImageUI, List paramList, String paramString, Runnable paramRunnable) {}
  
  public final void run()
  {
    Iterator localIterator = this.nuf.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      g.bhI().a(this.nuo.mController.uMN, str, RecordMsgImageUI.j(this.nuo), 0, "", "");
      g.bhI().dO(this.kdi, str);
    }
    ai.d(this.bxs);
  }
  
  public final String toString()
  {
    return super.toString() + "|onActivityResult";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI.11
 * JD-Core Version:    0.7.0.1
 */