package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

final class m$1
  extends ak
{
  m$1(m paramm) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = 0;
    AppMethodBeat.i(62455);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62455);
      return;
      paramMessage = this.vZl;
      paramMessage.mHandler.removeMessages(20001);
      Object localObject;
      label239:
      String str;
      if (paramMessage.vZf)
      {
        localObject = paramMessage.vZh;
        ((m.b)localObject).mData = paramMessage.lnB;
        ((m.b)localObject).notifyDataSetInvalidated();
        if ((paramMessage.lnB == null) || (paramMessage.lnB.size() <= 2)) {
          break label312;
        }
        paramMessage.vZa.setWidth((int)(paramMessage.vYY * 2.5D) + paramMessage.vYZ * 2);
        if (paramMessage.vZb != null)
        {
          localObject = new int[2];
          paramMessage.vZb.getLocationInWindow((int[])localObject);
          int j = localObject[0];
          int k = (paramMessage.vZa.getWidth() - paramMessage.vZb.getWidth()) / 2;
          int m = localObject[1];
          int n = paramMessage.vZa.getHeight();
          paramMessage.vZa.showAtLocation(paramMessage.vZb, 0, j - k, m - n);
        }
        if ((paramMessage.lnB == null) || (paramMessage.lnB.size() < 3)) {
          break label374;
        }
        paramMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
        localObject = h.qsU;
        str = paramMessage.vZd;
        if (paramMessage.lnB != null) {
          break label391;
        }
      }
      for (;;)
      {
        ((h)localObject).e(10994, new Object[] { Integer.valueOf(0), str, "", Integer.valueOf(0), "", Integer.valueOf(i) });
        AppMethodBeat.o(62455);
        return;
        label312:
        if ((paramMessage.lnB != null) && (paramMessage.lnB.size() == 2))
        {
          paramMessage.vZa.setWidth(paramMessage.vYY * 2 + paramMessage.vYZ * 2);
          break;
        }
        paramMessage.vZa.setWidth(paramMessage.vYY + paramMessage.vYZ * 2);
        break;
        label374:
        paramMessage.mHandler.sendEmptyMessageDelayed(20001, 3000L);
        break label239;
        label391:
        i = paramMessage.lnB.size();
      }
      this.vZl.hide();
      AppMethodBeat.o(62455);
      return;
      removeMessages(20001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.1
 * JD-Core Version:    0.7.0.1
 */