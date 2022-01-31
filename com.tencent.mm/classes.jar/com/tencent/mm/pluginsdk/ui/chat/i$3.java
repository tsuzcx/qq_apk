package com.tencent.mm.pluginsdk.ui.chat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;

final class i$3
  implements Runnable
{
  i$3(i parami, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(27957);
    i locali = this.vYT;
    Object localObject = locali.doV();
    int i;
    int j;
    int m;
    if (localObject == null)
    {
      i = 0;
      if (i != 0)
      {
        this.vYU.sendEmptyMessage(0);
        AppMethodBeat.o(27957);
      }
    }
    else
    {
      i = (int)locali.Mm(70);
      j = (int)locali.Mm(120);
      m = BackwardSupportUtil.ExifHelper.bY((String)localObject);
      if ((m != 90) && (m != 270)) {
        break label197;
      }
    }
    for (;;)
    {
      int k = (int)locali.Mm(4);
      localObject = d.d((String)localObject, i, j, true);
      if (localObject != null)
      {
        locali.bitmap = d.a(d.b((Bitmap)localObject, m), true, k);
        locali.sp.edit().putString("chattingui_recent_shown_image_path", locali.vYO.vYL).commit();
        ab.d("MicroMsg.RecentImageBubble", "check ok");
        i = 1;
        break;
      }
      ab.e("MicroMsg.RecentImageBubble", "image hits hole.");
      i = 0;
      break;
      ab.d("MicroMsg.RecentImageBubble", "check false");
      AppMethodBeat.o(27957);
      return;
      label197:
      k = i;
      i = j;
      j = k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(27958);
    String str = super.toString() + "|checkIfShow";
    AppMethodBeat.o(27958);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i.3
 * JD-Core Version:    0.7.0.1
 */