package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vfs.i;

public class LogoImageView
  extends ImageView
{
  ap handler;
  String imagePath;
  int targetHeight;
  int targetWidth;
  String url;
  
  public LogoImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26595);
    this.url = null;
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26593);
        byte[] arrayOfByte = (byte[])paramAnonymousMessage.obj;
        if ((arrayOfByte == null) || (arrayOfByte.length == 0))
        {
          ad.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
          AppMethodBeat.o(26593);
          return;
        }
        paramAnonymousMessage = com.tencent.mm.sdk.platformtools.g.cr(arrayOfByte);
        String str = LogoImageView.a(LogoImageView.this) + com.tencent.mm.b.g.getMessageDigest(LogoImageView.b(LogoImageView.this).getBytes());
        ad.d("MicroMsg.LogoImageView", "filePath  %s", new Object[] { str });
        i.f(str, arrayOfByte, arrayOfByte.length);
        if ((paramAnonymousMessage != null) && (LogoImageView.c(LogoImageView.this) > 0) && (LogoImageView.d(LogoImageView.this) > 0)) {
          paramAnonymousMessage = com.tencent.mm.sdk.platformtools.g.a(paramAnonymousMessage, LogoImageView.d(LogoImageView.this), LogoImageView.c(LogoImageView.this), true, false);
        }
        for (;;)
        {
          LogoImageView.this.setImageBitmap(paramAnonymousMessage);
          AppMethodBeat.o(26593);
          return;
        }
      }
    };
    AppMethodBeat.o(26595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LogoImageView
 * JD-Core Version:    0.7.0.1
 */