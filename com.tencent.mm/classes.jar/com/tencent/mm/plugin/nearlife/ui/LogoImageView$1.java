package com.tencent.mm.plugin.nearlife.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;

final class LogoImageView$1
  extends ak
{
  LogoImageView$1(LogoImageView paramLogoImageView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(22968);
    byte[] arrayOfByte = (byte[])paramMessage.obj;
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ab.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
      AppMethodBeat.o(22968);
      return;
    }
    paramMessage = d.bT(arrayOfByte);
    String str = LogoImageView.a(this.pft) + g.w(LogoImageView.b(this.pft).getBytes());
    ab.d("MicroMsg.LogoImageView", "filePath  %s", new Object[] { str });
    e.b(str, arrayOfByte, arrayOfByte.length);
    if ((paramMessage != null) && (LogoImageView.c(this.pft) > 0) && (LogoImageView.d(this.pft) > 0)) {
      paramMessage = d.a(paramMessage, LogoImageView.d(this.pft), LogoImageView.c(this.pft), true, false);
    }
    for (;;)
    {
      this.pft.setImageBitmap(paramMessage);
      AppMethodBeat.o(22968);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LogoImageView.1
 * JD-Core Version:    0.7.0.1
 */