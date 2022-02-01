package com.tencent.thumbplayer.b;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;
import java.io.FileDescriptor;

public final class b
{
  private static b ahGl = null;
  private c ahGm;
  private MediaMetadataRetriever ahGn;
  private int ahGo;
  private HandlerThread mHandlerThread;
  
  private b()
  {
    AppMethodBeat.i(227288);
    this.mHandlerThread = null;
    this.ahGm = null;
    this.ahGn = null;
    this.ahGo = 0;
    try
    {
      this.mHandlerThread = new HandlerThread("TP-SysImgCap");
      this.mHandlerThread.start();
      this.ahGm = new c(this.mHandlerThread.getLooper());
      AppMethodBeat.o(227288);
      return;
    }
    finally
    {
      g.e("TPSysPlayerImageCapture", localThrowable);
      this.ahGm = new c(Looper.getMainLooper());
      AppMethodBeat.o(227288);
    }
  }
  
  public static b kab()
  {
    try
    {
      AppMethodBeat.i(227280);
      if (ahGl == null) {
        ahGl = new b();
      }
      b localb = ahGl;
      AppMethodBeat.o(227280);
      return localb;
    }
    finally {}
  }
  
  public final int a(String paramString, FileDescriptor paramFileDescriptor, long paramLong, int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(227326);
    g.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + paramLong + ", width: " + paramInt1 + ", height: " + paramInt2);
    this.ahGo += 1;
    if ((!TextUtils.isEmpty(Build.MODEL)) && (Build.MODEL.equals("Lenovo+K900")))
    {
      g.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
      AppMethodBeat.o(227326);
      return -1;
    }
    b localb = new b((byte)0);
    localb.id = this.ahGo;
    localb.ahGp = paramFileDescriptor;
    localb.url = paramString;
    localb.cHd = paramLong;
    localb.width = paramInt1;
    localb.height = paramInt2;
    localb.ahGq = parama;
    paramString = new Message();
    paramString.what = 1;
    paramString.obj = localb;
    if (!this.ahGm.sendMessage(paramString)) {
      g.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
    }
    paramInt1 = this.ahGo;
    AppMethodBeat.o(227326);
    return paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void aHL(int paramInt);
    
    public abstract void h(int paramInt, Bitmap paramBitmap);
  }
  
  static final class b
  {
    FileDescriptor ahGp;
    protected b.a ahGq;
    long cHd;
    int height;
    int id;
    String url;
    int width;
  }
  
  final class c
    extends Handler
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(227302);
      switch (paramMessage.what)
      {
      default: 
        g.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
      }
      do
      {
        AppMethodBeat.o(227302);
        return;
        g.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
        paramMessage = (b.b)paramMessage.obj;
        b.a(b.this, paramMessage);
        AppMethodBeat.o(227302);
        return;
        g.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
      } while (b.a(b.this) == null);
      b.a(b.this).release();
      b.b(b.this);
      AppMethodBeat.o(227302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.b.b
 * JD-Core Version:    0.7.0.1
 */