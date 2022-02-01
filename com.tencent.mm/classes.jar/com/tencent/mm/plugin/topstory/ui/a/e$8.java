package com.tencent.mm.plugin.topstory.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.r.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;

final class e$8
  implements r.a
{
  e$8(e parame, WeakReference paramWeakReference) {}
  
  public final void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(236410);
    paramBitmap = (Context)this.GqB.get();
    if (paramBitmap == null)
    {
      AppMethodBeat.o(236410);
      return;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (s.YS(paramString2))) {
      if (ImgUtil.isGif(paramString2))
      {
        paramString1 = com.tencent.mm.b.g.getMD5(paramString2);
        paramString1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramString1);
        if ((paramString1 != null) && (paramString1.hRx())) {
          break label403;
        }
        paramString1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
        MMApplicationContext.getContext();
        paramString1 = paramString1.amn(paramString2);
        paramString1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramString1);
      }
    }
    label403:
    for (;;)
    {
      long l;
      int i;
      if (paramString1 == null)
      {
        l = 0L;
        i = 0;
        if (paramString1 != null) {
          break label283;
        }
      }
      for (;;)
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        if (((BitmapUtil.decodeFile(paramString2, localOptions) != null) && (localOptions.outHeight > com.tencent.mm.n.c.aqo())) || (localOptions.outWidth > com.tencent.mm.n.c.aqo())) {
          i = 1;
        }
        if ((l <= com.tencent.mm.n.c.aqp()) && (i == 0)) {
          break label291;
        }
        h.a(paramBitmap, paramBitmap.getString(2131758534), "", paramBitmap.getString(2131761757), null);
        h.a(paramBitmap, paramBitmap.getString(2131758534), "", paramBitmap.getString(2131761757), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(236410);
        return;
        l = s.boW(paramString1.hRM());
        break;
        label283:
        paramString2 = paramString1.hRM();
      }
      label291:
      paramString2 = new Intent();
      if (paramString1 != null) {}
      for (paramString1 = paramString1.getMd5();; paramString1 = "")
      {
        paramString2.putExtra("Retr_File_Name", paramString1);
        paramString2.putExtra("Retr_Msg_Type", 5);
        paramString2.putExtra("Retr_MsgImgScene", 1);
        com.tencent.mm.br.c.f(paramBitmap, ".ui.transmit.MsgRetransmitUI", paramString2);
        AppMethodBeat.o(236410);
        return;
      }
      paramString1 = new Intent();
      paramString1.putExtra("Retr_File_Name", paramString2);
      paramString1.putExtra("Retr_Compress_Type", 0);
      paramString1.putExtra("Retr_Msg_Type", 0);
      paramString1.addFlags(268435456);
      com.tencent.mm.br.c.f(paramBitmap, ".ui.transmit.MsgRetransmitUI", paramString1);
      AppMethodBeat.o(236410);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.e.8
 * JD-Core Version:    0.7.0.1
 */