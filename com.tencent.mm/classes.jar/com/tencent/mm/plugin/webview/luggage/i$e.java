package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;

class i$e
  implements com.tencent.mm.plugin.webview.luggage.ipc.d
{
  public final void a(Context paramContext, Bundle paramBundle, final com.tencent.mm.plugin.webview.luggage.ipc.b paramb)
  {
    Object localObject = paramBundle.getString("img_path");
    if (o.Za((String)localObject))
    {
      paramBundle = com.tencent.mm.a.g.bQ((String)localObject);
      paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramBundle);
      if ((paramBundle != null) && (paramBundle.cwz())) {
        break label388;
      }
      paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Au((String)localObject);
      paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramBundle);
    }
    label388:
    for (;;)
    {
      int i;
      if (paramBundle == null)
      {
        i = 0;
        if (paramBundle != null) {
          break label245;
        }
        label105:
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        if (((c.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.m.b.Ag())) && (localOptions.outWidth <= com.tencent.mm.m.b.Ag())) {
          break label382;
        }
      }
      label245:
      label382:
      for (int j = 1;; j = 0)
      {
        if ((i > com.tencent.mm.m.b.Ah()) || (j != 0))
        {
          h.a(paramContext, paramContext.getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", paramContext.getString(R.l.i_know_it), null);
          h.a(paramContext, paramContext.getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", paramContext.getString(R.l.i_know_it), "", false, new i.e.1(this, paramb), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              paramb.g(null);
            }
          });
          return;
          i = e.bJ(paramBundle.cwL());
          break;
          localObject = paramBundle.cwL();
          break label105;
        }
        localObject = new Intent();
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.Wv();; paramBundle = "")
        {
          ((Intent)localObject).putExtra("Retr_File_Name", paramBundle);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
          a.eUR.l((Intent)localObject, paramContext);
          paramb.g(null);
          return;
        }
        paramBundle = new Intent();
        paramBundle.putExtra("Retr_File_Name", (String)localObject);
        paramBundle.putExtra("Retr_Compress_Type", 0);
        paramBundle.putExtra("Retr_Msg_Type", 0);
        paramBundle.addFlags(268435456);
        a.eUR.l(paramBundle, paramContext);
        paramb.g(null);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.e
 * JD-Core Version:    0.7.0.1
 */