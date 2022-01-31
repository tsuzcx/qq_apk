package com.tencent.mm.pluginsdk.ui.chat;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.o;

final class i$2
  extends ak
{
  i$2(i parami, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(27956);
    paramMessage = this.vYT;
    if ((paramMessage.cxy == null) || (paramMessage.vYO == null) || (paramMessage.bitmap == null) || (paramMessage.vYP == null) || (paramMessage.kgr == null) || (paramMessage.oeJ == null))
    {
      AppMethodBeat.o(27956);
      return;
    }
    paramMessage.cxy.setImageBitmap(paramMessage.bitmap);
    int k;
    int j;
    label91:
    int i;
    label108:
    int n;
    int m;
    Rect localRect;
    if (paramMessage.vYQ)
    {
      k = 83;
      if (!paramMessage.vYQ) {
        break label237;
      }
      j = 0;
      if (paramMessage.vYR == null) {
        break label243;
      }
      i = paramMessage.vYR.getYFromBottom();
      n = j;
      m = i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localRect = af.dDk();
        if (!paramMessage.vYQ) {
          break label254;
        }
        j = 0;
      }
    }
    for (;;)
    {
      m = i + localRect.bottom;
      ab.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.bottom) });
      n = j;
      paramMessage.vYP.showAtLocation(paramMessage.kgr, k, n, m);
      new ap(new i.4(paramMessage), false).ag(10000L, 10000L);
      AppMethodBeat.o(27956);
      return;
      k = 85;
      break;
      label237:
      j = 10;
      break label91;
      label243:
      i = paramMessage.oeJ.getHeight();
      break label108;
      label254:
      j += localRect.right;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i.2
 * JD-Core Version:    0.7.0.1
 */