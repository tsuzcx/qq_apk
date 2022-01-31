package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.ui.MMActivity.a;
import java.util.Iterator;
import java.util.List;

final class bb$2
  implements MMActivity.a
{
  bb$2(bb parambb, Context paramContext, bh.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6378);
    ab.i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == (this.uTV.hashCode() & 0xFFFF)) {
      ab.i("MicroMsg.JsApiShareEmotion", "share emmotion resultCode: %d", new Object[] { Integer.valueOf(paramInt2) });
    }
    String str1;
    Object localObject2;
    Object localObject1;
    String str2;
    switch (paramInt2)
    {
    default: 
      this.lax.c(null, null);
      AppMethodBeat.o(6378);
      return;
    case -1: 
      str1 = bo.bf(paramIntent.getStringExtra("Select_Conv_User"), "");
      localObject2 = bo.bf(paramIntent.getStringExtra("emoji_thumb_path"), "");
      localObject1 = i.getEmojiStorageMgr().yNn.asP((String)localObject2);
      if (localObject1 == null)
      {
        str2 = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", (String)localObject2);
        if (e.cN(str2)) {
          if (r.aoY(str2))
          {
            paramInt1 = EmojiInfo.yPo;
            localObject1 = i.getEmojiStorageMgr().yNn.b((String)localObject2, "", EmojiInfo.yPg, paramInt1, e.cM(str2), null, "");
          }
        }
      }
      break;
    }
    for (;;)
    {
      localObject2 = bo.P(bo.bf(str1, "").split(",")).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          str2 = (String)((Iterator)localObject2).next();
          if (localObject1 != null)
          {
            i.blp().a(str2, (EmojiInfo)localObject1, null);
            continue;
            paramInt1 = EmojiInfo.yPn;
            break;
          }
        }
      }
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      if (!bo.isNullOrNil(paramIntent))
      {
        localObject1 = new qj();
        ((qj)localObject1).cGX.cGY = str1;
        ((qj)localObject1).cGX.content = paramIntent;
        ((qj)localObject1).cGX.type = t.oF(str1);
        ((qj)localObject1).cGX.flags = 0;
        a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      com.tencent.mm.ui.base.h.bO(this.val$context, this.val$context.getResources().getString(2131297076));
      break;
      this.lax.c(null, null);
      AppMethodBeat.o(6378);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bb.2
 * JD-Core Version:    0.7.0.1
 */