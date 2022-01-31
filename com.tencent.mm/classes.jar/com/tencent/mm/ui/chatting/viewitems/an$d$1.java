package com.tencent.mm.ui.chatting.viewitems;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.Map;

final class an$d$1
  implements Runnable
{
  an$d$1(s params) {}
  
  public final void run()
  {
    AppMethodBeat.i(33350);
    Object localObject = (WeakReference)an.d.access$000().get(this.zXA.getFileName());
    if (localObject == null)
    {
      ab.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { this.zXA.getFileName() });
      AppMethodBeat.o(33350);
      return;
    }
    localObject = (an.d)((WeakReference)localObject).get();
    if (localObject == null)
    {
      ab.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { this.zXA.getFileName() });
      AppMethodBeat.o(33350);
      return;
    }
    ((an.d)localObject).zRV.setVisibility(8);
    ((an.d)localObject).rwJ.setVisibility(8);
    ((an.d)localObject).zXD.setVisibility(0);
    int i = this.zXA.status;
    ab.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
    if ((i == 112) || (i == 122) || (i == 120))
    {
      ((an.d)localObject).zXD.setProgress(u.g(this.zXA));
      AppMethodBeat.o(33350);
      return;
    }
    ((an.d)localObject).zXD.setProgress(u.h(this.zXA));
    AppMethodBeat.o(33350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.d.1
 * JD-Core Version:    0.7.0.1
 */