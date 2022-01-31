package com.tencent.mm.plugin.nearlife.ui;

import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class LogoImageView$1
  extends ah
{
  LogoImageView$1(LogoImageView paramLogoImageView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    byte[] arrayOfByte = (byte[])paramMessage.obj;
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      y.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
      return;
    }
    paramMessage = c.bu(arrayOfByte);
    String str = LogoImageView.a(this.mFn) + g.o(LogoImageView.b(this.mFn).getBytes());
    y.d("MicroMsg.LogoImageView", "filePath  %s", new Object[] { str });
    e.b(str, arrayOfByte, arrayOfByte.length);
    if ((paramMessage != null) && (LogoImageView.c(this.mFn) > 0) && (LogoImageView.d(this.mFn) > 0)) {
      paramMessage = c.a(paramMessage, LogoImageView.d(this.mFn), LogoImageView.c(this.mFn), true, false);
    }
    for (;;)
    {
      this.mFn.setImageBitmap(paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LogoImageView.1
 * JD-Core Version:    0.7.0.1
 */