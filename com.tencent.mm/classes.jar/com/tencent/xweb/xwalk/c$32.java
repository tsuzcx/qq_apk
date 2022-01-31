package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.q;

final class c$32
  implements View.OnClickListener
{
  c$32(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(139558);
    boolean bool;
    if (!q.dYn().BDS)
    {
      bool = true;
      q.dYn().setShowFps(bool);
      c.b(this.BIO.BID);
      if (!bool) {
        break label60;
      }
    }
    label60:
    for (paramView = "打开显示fps";; paramView = "关闭显示fps")
    {
      this.BIO.cA(paramView, false);
      AppMethodBeat.o(139558);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.32
 * JD-Core Version:    0.7.0.1
 */