package com.tencent.mm.ui.chatting.viewitems;

import android.widget.ImageView;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.Map;

final class ak$d$1
  implements Runnable
{
  ak$d$1(s params) {}
  
  public final void run()
  {
    Object localObject = (WeakReference)ak.d.aiY().get(this.vwS.getFileName());
    if (localObject == null)
    {
      y.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { this.vwS.getFileName() });
      return;
    }
    localObject = (ak.d)((WeakReference)localObject).get();
    if (localObject == null)
    {
      y.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { this.vwS.getFileName() });
      return;
    }
    ((ak.d)localObject).vBw.setVisibility(8);
    ((ak.d)localObject).oGT.setVisibility(8);
    ((ak.d)localObject).vGi.setVisibility(0);
    int i = this.vwS.status;
    y.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : " + i);
    if ((i == 112) || (i == 122) || (i == 120))
    {
      ((ak.d)localObject).vGi.setProgress(u.g(this.vwS));
      return;
    }
    ((ak.d)localObject).vGi.setProgress(u.h(this.vwS));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.d.1
 * JD-Core Version:    0.7.0.1
 */