package com.tencent.mm.pluginsdk.ui.chat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class i$3
  implements Runnable
{
  i$3(i parami, ah paramah) {}
  
  public final void run()
  {
    int m = 1;
    i locali = this.sgB;
    Object localObject = locali.cnN();
    int i;
    int j;
    int n;
    if (localObject == null)
    {
      i = 0;
      if (i != 0) {
        this.sgC.sendEmptyMessage(0);
      }
    }
    else
    {
      i = (int)locali.Eo(70);
      j = (int)locali.Eo(120);
      n = BackwardSupportUtil.ExifHelper.YS((String)localObject);
      if ((n != 90) && (n != 270)) {
        break label185;
      }
    }
    for (;;)
    {
      int k = (int)locali.Eo(4);
      localObject = c.a((String)localObject, i, j, true, null, 0);
      if (localObject != null)
      {
        locali.bitmap = c.a(c.b((Bitmap)localObject, n), true, k);
        locali.dnD.edit().putString("chattingui_recent_shown_image_path", locali.sgw.sgu).commit();
        y.d("MicroMsg.RecentImageBubble", "check ok");
        i = m;
        break;
      }
      y.e("MicroMsg.RecentImageBubble", "image hits hole.");
      i = 0;
      break;
      y.d("MicroMsg.RecentImageBubble", "check false");
      return;
      label185:
      k = i;
      i = j;
      j = k;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|checkIfShow";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i.3
 * JD-Core Version:    0.7.0.1
 */