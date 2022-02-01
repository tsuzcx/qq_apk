package com.tencent.thumbplayer.c;

import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.f;
import java.io.FileDescriptor;

public final class a
{
  private static a KgC = null;
  private c KgD;
  private MediaMetadataRetriever KgE;
  private int KgF;
  private HandlerThread mHandlerThread;
  
  private a()
  {
    AppMethodBeat.i(187842);
    this.mHandlerThread = null;
    this.KgD = null;
    this.KgE = null;
    this.KgF = 0;
    try
    {
      this.mHandlerThread = new HandlerThread("TP-SysImgCap");
      this.mHandlerThread.start();
      this.KgD = new c(this.mHandlerThread.getLooper());
      AppMethodBeat.o(187842);
      return;
    }
    catch (Throwable localThrowable)
    {
      f.e("TPSysPlayerImageCapture", localThrowable);
      this.KgD = new c(Looper.getMainLooper());
      AppMethodBeat.o(187842);
    }
  }
  
  public static a fFv()
  {
    try
    {
      AppMethodBeat.i(187841);
      if (KgC == null) {
        KgC = new a();
      }
      a locala = KgC;
      AppMethodBeat.o(187841);
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString, FileDescriptor paramFileDescriptor, long paramLong, int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(187843);
    f.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + paramLong + ", width: " + paramInt1 + ", height: " + paramInt2);
    this.KgF += 1;
    if ((!TextUtils.isEmpty(Build.MODEL)) && (Build.MODEL.equals("Lenovo+K900")))
    {
      f.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
      AppMethodBeat.o(187843);
      return -1;
    }
    b localb = new b((byte)0);
    localb.id = this.KgF;
    localb.KgG = paramFileDescriptor;
    localb.url = paramString;
    localb.aTp = paramLong;
    localb.width = paramInt1;
    localb.height = paramInt2;
    localb.KgH = parama;
    paramString = new Message();
    paramString.what = 1;
    paramString.obj = localb;
    if (!this.KgD.sendMessage(paramString)) {
      f.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
    }
    paramInt1 = this.KgF;
    AppMethodBeat.o(187843);
    return paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void aeJ(int paramInt);
    
    public abstract void aeK(int paramInt);
  }
  
  static final class b
  {
    FileDescriptor KgG;
    protected a.a KgH;
    long aTp;
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
      AppMethodBeat.i(187840);
      switch (paramMessage.what)
      {
      default: 
        f.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
      }
      do
      {
        AppMethodBeat.o(187840);
        return;
        f.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
        paramMessage = (a.b)paramMessage.obj;
        a.a(a.this, paramMessage);
        AppMethodBeat.o(187840);
        return;
        f.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
      } while (a.a(a.this) == null);
      a.a(a.this).release();
      a.b(a.this);
      AppMethodBeat.o(187840);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.c.a
 * JD-Core Version:    0.7.0.1
 */