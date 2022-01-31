package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.ui.MMActivity;

final class s$4
  implements Runnable
{
  s$4(s params) {}
  
  public final void run()
  {
    if ((this.sds.context instanceof MMActivity)) {
      ((MMActivity)this.sds.context).showVKB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.4
 * JD-Core Version:    0.7.0.1
 */