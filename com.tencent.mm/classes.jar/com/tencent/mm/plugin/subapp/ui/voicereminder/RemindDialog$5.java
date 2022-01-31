package com.tencent.mm.plugin.subapp.ui.voicereminder;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.a.c;
import java.util.Iterator;
import java.util.List;

final class RemindDialog$5
  implements Runnable
{
  RemindDialog$5(RemindDialog paramRemindDialog) {}
  
  public final void run()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = RemindDialog.a(this.pyj).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (bk.bl(str)) {
        localStringBuffer.append("\n\n");
      } else {
        localStringBuffer.append(str + "\n\n");
      }
    }
    if (RemindDialog.d(this.pyj) != null) {
      RemindDialog.d(this.pyj).setMessage(localStringBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.5
 * JD-Core Version:    0.7.0.1
 */