package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.webview.luggage.ipc.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;

class h$e
  implements c
{
  public final void a(Context paramContext, Bundle paramBundle, final com.tencent.mm.plugin.webview.luggage.ipc.a parama)
  {
    AppMethodBeat.i(6143);
    Object localObject = paramBundle.getString("img_path");
    if (r.aoY((String)localObject))
    {
      paramBundle = com.tencent.mm.a.g.getMD5((String)localObject);
      paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramBundle);
      if ((paramBundle != null) && (paramBundle.dzn())) {
        break label414;
      }
      paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
      ah.getContext();
      paramBundle = paramBundle.Kv((String)localObject);
      paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramBundle);
    }
    label259:
    label408:
    label414:
    for (;;)
    {
      int i;
      if (paramBundle == null)
      {
        i = 0;
        if (paramBundle != null) {
          break label259;
        }
        label117:
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        if (((com.tencent.mm.sdk.platformtools.d.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= b.MV())) && (localOptions.outWidth <= b.MV())) {
          break label408;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i > b.MW()) || (j != 0))
        {
          h.a(paramContext, paramContext.getString(2131299130), "", paramContext.getString(2131300718), null);
          h.a(paramContext, paramContext.getString(2131299130), "", paramContext.getString(2131300718), "", false, new DialogInterface.OnClickListener()new h.e.2
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(6141);
              parama.o(null);
              AppMethodBeat.o(6141);
            }
          }, new h.e.2(this, parama));
          AppMethodBeat.o(6143);
          return;
          i = e.cM(paramBundle.dQB());
          break;
          localObject = paramBundle.dQB();
          break label117;
        }
        localObject = new Intent();
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.Al();; paramBundle = "")
        {
          ((Intent)localObject).putExtra("Retr_File_Name", paramBundle);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
          com.tencent.mm.plugin.webview.a.a.gmO.k((Intent)localObject, paramContext);
          parama.o(null);
          AppMethodBeat.o(6143);
          return;
        }
        paramBundle = new Intent();
        paramBundle.putExtra("Retr_File_Name", (String)localObject);
        paramBundle.putExtra("Retr_Compress_Type", 0);
        paramBundle.putExtra("Retr_Msg_Type", 0);
        paramBundle.addFlags(268435456);
        com.tencent.mm.plugin.webview.a.a.gmO.k(paramBundle, paramContext);
        parama.o(null);
        AppMethodBeat.o(6143);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.e
 * JD-Core Version:    0.7.0.1
 */