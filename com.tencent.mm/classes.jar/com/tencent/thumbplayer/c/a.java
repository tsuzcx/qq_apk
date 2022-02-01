package com.tencent.thumbplayer.c;

import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.d;
import java.io.FileDescriptor;

public final class a
{
  private static a LZS = null;
  private c LZT;
  private MediaMetadataRetriever LZU;
  private int LZV;
  private HandlerThread mHandlerThread;
  
  private a()
  {
    AppMethodBeat.i(191863);
    this.mHandlerThread = null;
    this.LZT = null;
    this.LZU = null;
    this.LZV = 0;
    try
    {
      this.mHandlerThread = new HandlerThread("TP-SysImgCap");
      this.mHandlerThread.start();
      this.LZT = new c(this.mHandlerThread.getLooper());
      AppMethodBeat.o(191863);
      return;
    }
    catch (Throwable localThrowable)
    {
      d.e("TPSysPlayerImageCapture", localThrowable);
      this.LZT = new c(Looper.getMainLooper());
      AppMethodBeat.o(191863);
    }
  }
  
  public static a fWK()
  {
    try
    {
      AppMethodBeat.i(191862);
      if (LZS == null) {
        LZS = new a();
      }
      a locala = LZS;
      AppMethodBeat.o(191862);
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString, FileDescriptor paramFileDescriptor, long paramLong, int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(191864);
    d.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + paramLong + ", width: " + paramInt1 + ", height: " + paramInt2);
    this.LZV += 1;
    if ((!TextUtils.isEmpty(Build.MODEL)) && (Build.MODEL.equals("Lenovo+K900")))
    {
      d.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
      AppMethodBeat.o(191864);
      return -1;
    }
    b localb = new b((byte)0);
    localb.id = this.LZV;
    localb.LZW = paramFileDescriptor;
    localb.url = paramString;
    localb.bdJ = paramLong;
    localb.width = paramInt1;
    localb.height = paramInt2;
    localb.LZX = parama;
    paramString = new Message();
    paramString.what = 1;
    paramString.obj = localb;
    if (!this.LZT.sendMessage(paramString)) {
      d.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
    }
    paramInt1 = this.LZV;
    AppMethodBeat.o(191864);
    return paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void ahj(int paramInt);
    
    public abstract void ahk(int paramInt);
  }
  
  static final class b
  {
    FileDescriptor LZW;
    protected a.a LZX;
    long bdJ;
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
      AppMethodBeat.i(191861);
      switch (paramMessage.what)
      {
      default: 
        d.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
      }
      do
      {
        AppMethodBeat.o(191861);
        return;
        d.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
        paramMessage = (a.b)paramMessage.obj;
        a.a(a.this, paramMessage);
        AppMethodBeat.o(191861);
        return;
        d.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
      } while (a.a(a.this) == null);
      a.a(a.this).release();
      a.b(a.this);
      AppMethodBeat.o(191861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.a
 * JD-Core Version:    0.7.0.1
 */