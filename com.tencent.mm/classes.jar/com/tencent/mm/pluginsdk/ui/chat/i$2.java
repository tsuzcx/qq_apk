package com.tencent.mm.pluginsdk.ui.chat;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.o;

final class i$2
  extends ah
{
  i$2(i parami, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    paramMessage = this.sgB;
    if ((paramMessage.bQf == null) || (paramMessage.sgw == null) || (paramMessage.bitmap == null) || (paramMessage.sgx == null) || (paramMessage.khn == null) || (paramMessage.lHw == null)) {
      return;
    }
    paramMessage.bQf.setImageBitmap(paramMessage.bitmap);
    int k;
    int j;
    label79:
    int i;
    label96:
    int n;
    int m;
    Rect localRect;
    if (paramMessage.sgy)
    {
      k = 83;
      if (!paramMessage.sgy) {
        break label219;
      }
      j = 0;
      if (paramMessage.sgz == null) {
        break label225;
      }
      i = paramMessage.sgz.getYFromBottom();
      n = j;
      m = i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localRect = ak.cAg();
        if (!paramMessage.sgy) {
          break label236;
        }
        j = 0;
      }
    }
    for (;;)
    {
      m = i + localRect.bottom;
      y.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.bottom) });
      n = j;
      paramMessage.sgx.showAtLocation(paramMessage.khn, k, n, m);
      new am(new i.4(paramMessage), false).S(10000L, 10000L);
      return;
      k = 85;
      break;
      label219:
      j = 10;
      break label79;
      label225:
      i = paramMessage.lHw.getHeight();
      break label96;
      label236:
      j += localRect.right;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i.2
 * JD-Core Version:    0.7.0.1
 */