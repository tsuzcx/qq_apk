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
  private static b ZBi = null;
  private c ZBj;
  private MediaMetadataRetriever ZBk;
  private int ZBl;
  private HandlerThread mHandlerThread;
  
  private b()
  {
    AppMethodBeat.i(220045);
    this.mHandlerThread = null;
    this.ZBj = null;
    this.ZBk = null;
    this.ZBl = 0;
    try
    {
      this.mHandlerThread = new HandlerThread("TP-SysImgCap");
      this.mHandlerThread.start();
      this.ZBj = new c(this.mHandlerThread.getLooper());
      AppMethodBeat.o(220045);
      return;
    }
    catch (Throwable localThrowable)
    {
      g.e("TPSysPlayerImageCapture", localThrowable);
      this.ZBj = new c(Looper.getMainLooper());
      AppMethodBeat.o(220045);
    }
  }
  
  public static b iqF()
  {
    try
    {
      AppMethodBeat.i(220041);
      if (ZBi == null) {
        ZBi = new b();
      }
      b localb = ZBi;
      AppMethodBeat.o(220041);
      return localb;
    }
    finally {}
  }
  
  public final int a(String paramString, FileDescriptor paramFileDescriptor, long paramLong, int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(220052);
    g.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + paramLong + ", width: " + paramInt1 + ", height: " + paramInt2);
    this.ZBl += 1;
    if ((!TextUtils.isEmpty(Build.MODEL)) && (Build.MODEL.equals("Lenovo+K900")))
    {
      g.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
      AppMethodBeat.o(220052);
      return -1;
    }
    b localb = new b((byte)0);
    localb.id = this.ZBl;
    localb.ZBm = paramFileDescriptor;
    localb.url = paramString;
    localb.aNh = paramLong;
    localb.width = paramInt1;
    localb.height = paramInt2;
    localb.ZBn = parama;
    paramString = new Message();
    paramString.what = 1;
    paramString.obj = localb;
    if (!this.ZBj.sendMessage(paramString)) {
      g.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
    }
    paramInt1 = this.ZBl;
    AppMethodBeat.o(220052);
    return paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void aAY(int paramInt);
    
    public abstract void f(int paramInt, Bitmap paramBitmap);
  }
  
  static final class b
  {
    FileDescriptor ZBm;
    protected b.a ZBn;
    long aNh;
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
      AppMethodBeat.i(220040);
      switch (paramMessage.what)
      {
      default: 
        g.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
      }
      do
      {
        AppMethodBeat.o(220040);
        return;
        g.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
        paramMessage = (b.b)paramMessage.obj;
        b.a(b.this, paramMessage);
        AppMethodBeat.o(220040);
        return;
        g.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
      } while (b.a(b.this) == null);
      b.a(b.this).release();
      b.b(b.this);
      AppMethodBeat.o(220040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.b.b
 * JD-Core Version:    0.7.0.1
 */