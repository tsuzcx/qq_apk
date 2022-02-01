package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public class LogoImageView
  extends ImageView
{
  MMHandler handler;
  String imagePath;
  int targetHeight;
  int targetWidth;
  String url;
  
  public LogoImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26595);
    this.url = null;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26593);
        byte[] arrayOfByte = (byte[])paramAnonymousMessage.obj;
        if ((arrayOfByte == null) || (arrayOfByte.length == 0))
        {
          Log.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
          AppMethodBeat.o(26593);
          return;
        }
        paramAnonymousMessage = BitmapUtil.decodeByteArray(arrayOfByte);
        String str = LogoImageView.a(LogoImageView.this) + g.getMessageDigest(LogoImageView.b(LogoImageView.this).getBytes());
        Log.d("MicroMsg.LogoImageView", "filePath  %s", new Object[] { str });
        u.f(str, arrayOfByte, arrayOfByte.length);
        if ((paramAnonymousMessage != null) && (LogoImageView.c(LogoImageView.this) > 0) && (LogoImageView.d(LogoImageView.this) > 0)) {
          paramAnonymousMessage = BitmapUtil.extractThumbNail(paramAnonymousMessage, LogoImageView.d(LogoImageView.this), LogoImageView.c(LogoImageView.this), true, false);
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
  
  static final class a
    implements Runnable
  {
    private MMHandler handler;
    private String url;
    
    a(String paramString, MMHandler paramMMHandler)
    {
      this.url = paramString;
      this.handler = paramMMHandler;
    }
    
    public final void run()
    {
      AppMethodBeat.i(26594);
      byte[] arrayOfByte = Util.httpGet(this.url);
      Message localMessage = Message.obtain();
      localMessage.obj = arrayOfByte;
      this.handler.sendMessage(localMessage);
      AppMethodBeat.o(26594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LogoImageView
 * JD-Core Version:    0.7.0.1
 */