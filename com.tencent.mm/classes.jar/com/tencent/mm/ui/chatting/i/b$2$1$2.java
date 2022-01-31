package com.tencent.mm.ui.chatting.i;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.e.b.b;
import java.util.ArrayList;

final class b$2$1$2
  implements Runnable
{
  b$2$1$2(b.2.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(32528);
    if (this.zPh.zPg.zPf.zPc != null)
    {
      this.zPh.zPg.zPf.zPd.ajb.notifyChanged();
      this.zPh.zPg.zPf.zPc.co(this.zPh.zPg.zDO, this.zPh.zPg.zPf.iVH.isEmpty());
    }
    AppMethodBeat.o(32528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.b.2.1.2
 * JD-Core Version:    0.7.0.1
 */