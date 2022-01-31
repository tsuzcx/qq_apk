package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.ui.MMActivity.a;
import java.util.Iterator;
import java.util.List;

final class aq$2
  implements MMActivity.a
{
  aq$2(aq paramaq, aw.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == (this.rdS.hashCode() & 0xFFFF)) {
      y.i("MicroMsg.JsApiShareEmotion", "share emmotion resultCode: %d", new Object[] { Integer.valueOf(paramInt2) });
    }
    Object localObject;
    String str1;
    switch (paramInt2)
    {
    default: 
      this.iRN.e(null, null);
      return;
    case -1: 
      localObject = bk.aM(paramIntent.getStringExtra("Select_Conv_User"), "");
      str1 = bk.aM(paramIntent.getStringExtra("emoji_thumb_path"), "");
      paramIntent = i.getEmojiStorageMgr().uBb.acC(str1);
      if (paramIntent == null)
      {
        au.Hx();
        String str2 = EmojiLogic.J(c.FL(), "", str1);
        if (e.bK(str2)) {
          if (o.Za(str2))
          {
            paramInt1 = EmojiInfo.uDb;
            paramIntent = i.getEmojiStorageMgr().uBb.c(str1, "", EmojiInfo.uCT, paramInt1, e.bJ(str2), "");
          }
        }
      }
      break;
    }
    for (;;)
    {
      localObject = bk.G(bk.aM((String)localObject, "").split(",")).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          if (paramIntent != null)
          {
            i.aHP().a(str1, paramIntent, null);
            continue;
            paramInt1 = EmojiInfo.uDa;
            break;
          }
        }
      }
      this.iRN.e(null, null);
      return;
      this.iRN.e(null, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aq.2
 * JD-Core Version:    0.7.0.1
 */