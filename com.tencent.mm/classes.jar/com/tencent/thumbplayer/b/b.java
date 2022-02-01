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
  private static b RYy = null;
  private MediaMetadataRetriever RYA;
  private int RYB;
  private c RYz;
  private HandlerThread mHandlerThread;
  
  private b()
  {
    AppMethodBeat.i(189089);
    this.mHandlerThread = null;
    this.RYz = null;
    this.RYA = null;
    this.RYB = 0;
    try
    {
      this.mHandlerThread = new HandlerThread("TP-SysImgCap");
      this.mHandlerThread.start();
      this.RYz = new c(this.mHandlerThread.getLooper());
      AppMethodBeat.o(189089);
      return;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPSysPlayerImageCapture", localThrowable);
      this.RYz = new c(Looper.getMainLooper());
      AppMethodBeat.o(189089);
    }
  }
  
  public static b hne()
  {
    try
    {
      AppMethodBeat.i(189088);
      if (RYy == null) {
        RYy = new b();
      }
      b localb = RYy;
      AppMethodBeat.o(189088);
      return localb;
    }
    finally {}
  }
  
  public final int a(String paramString, FileDescriptor paramFileDescriptor, long paramLong, int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(189090);
    g.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + paramLong + ", width: " + paramInt1 + ", height: " + paramInt2);
    this.RYB += 1;
    if ((!TextUtils.isEmpty(Build.MODEL)) && (Build.MODEL.equals("Lenovo+K900")))
    {
      g.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
      AppMethodBeat.o(189090);
      return -1;
    }
    b localb = new b((byte)0);
    localb.id = this.RYB;
    localb.RYC = paramFileDescriptor;
    localb.url = paramString;
    localb.bdG = paramLong;
    localb.width = paramInt1;
    localb.height = paramInt2;
    localb.RYD = parama;
    paramString = new Message();
    paramString.what = 1;
    paramString.obj = localb;
    if (!this.RYz.sendMessage(paramString)) {
      g.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
    }
    paramInt1 = this.RYB;
    AppMethodBeat.o(189090);
    return paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void arl(int paramInt);
    
    public abstract void f(int paramInt, Bitmap paramBitmap);
  }
  
  static final class b
  {
    FileDescriptor RYC;
    protected b.a RYD;
    long bdG;
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
      AppMethodBeat.i(189087);
      switch (paramMessage.what)
      {
      default: 
        g.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
      }
      do
      {
        AppMethodBeat.o(189087);
        return;
        g.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
        paramMessage = (b.b)paramMessage.obj;
        b.a(b.this, paramMessage);
        AppMethodBeat.o(189087);
        return;
        g.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
      } while (b.a(b.this) == null);
      b.a(b.this).release();
      b.b(b.this);
      AppMethodBeat.o(189087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.b.b
 * JD-Core Version:    0.7.0.1
 */