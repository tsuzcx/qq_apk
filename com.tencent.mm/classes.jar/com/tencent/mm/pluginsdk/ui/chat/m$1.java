package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

final class m$1
  extends ah
{
  m$1(m paramm) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = 0;
    switch (paramMessage.what)
    {
    default: 
    case 20003: 
      do
      {
        return;
        paramMessage = this.sgS;
        paramMessage.mHandler.removeMessages(20001);
      } while (!paramMessage.sgM);
      Object localObject = paramMessage.sgO;
      ((m.b)localObject).mData = paramMessage.jeL;
      ((m.b)localObject).notifyDataSetInvalidated();
      String str;
      if ((paramMessage.jeL != null) && (paramMessage.jeL.size() > 2))
      {
        paramMessage.sgH.setWidth((int)(paramMessage.sgF * 2.5D) + paramMessage.sgG * 2);
        paramMessage.cnO();
        if ((paramMessage.jeL == null) || (paramMessage.jeL.size() < 3)) {
          break label278;
        }
        paramMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
        localObject = h.nFQ;
        str = paramMessage.sgK;
        if (paramMessage.jeL != null) {
          break label295;
        }
      }
      for (;;)
      {
        ((h)localObject).f(10994, new Object[] { Integer.valueOf(0), str, "", Integer.valueOf(0), "", Integer.valueOf(i) });
        return;
        if ((paramMessage.jeL != null) && (paramMessage.jeL.size() == 2))
        {
          paramMessage.sgH.setWidth(paramMessage.sgF * 2 + paramMessage.sgG * 2);
          break;
        }
        paramMessage.sgH.setWidth(paramMessage.sgF + paramMessage.sgG * 2);
        break;
        paramMessage.mHandler.sendEmptyMessageDelayed(20001, 3000L);
        break label150;
        i = paramMessage.jeL.size();
      }
    case 20001: 
      label150:
      label295:
      this.sgS.hide();
      label278:
      return;
    }
    removeMessages(20001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.1
 * JD-Core Version:    0.7.0.1
 */