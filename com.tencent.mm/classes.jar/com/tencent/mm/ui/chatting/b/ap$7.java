package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class ap$7
  implements c.a
{
  ap$7(ap paramap) {}
  
  public final void b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (paramInt1 == -50002) {
      Toast.makeText(this.vtm.byx.vtz.getContext(), this.vtm.byx.vtz.getContext().getString(R.l.video_export_file_too_big), 0).show();
    }
    for (;;)
    {
      this.vtm.byx.dismissDialog();
      return;
      if (paramInt1 < 0)
      {
        Toast.makeText(this.vtm.byx.vtz.getContext(), this.vtm.byx.vtz.getContext().getString(R.l.video_export_file_error), 0).show();
      }
      else
      {
        u.c(paramString1, paramInt2, this.vtm.byx.getTalkerUserName(), paramString2);
        u.nZ(paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ap.7
 * JD-Core Version:    0.7.0.1
 */