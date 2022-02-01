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
  private static a MwN = null;
  private c MwO;
  private MediaMetadataRetriever MwP;
  private int MwQ;
  private HandlerThread mHandlerThread;
  
  private a()
  {
    AppMethodBeat.i(194541);
    this.mHandlerThread = null;
    this.MwO = null;
    this.MwP = null;
    this.MwQ = 0;
    try
    {
      this.mHandlerThread = new HandlerThread("TP-SysImgCap");
      this.mHandlerThread.start();
      this.MwO = new c(this.mHandlerThread.getLooper());
      AppMethodBeat.o(194541);
      return;
    }
    catch (Throwable localThrowable)
    {
      d.e("TPSysPlayerImageCapture", localThrowable);
      this.MwO = new c(Looper.getMainLooper());
      AppMethodBeat.o(194541);
    }
  }
  
  public static a gbj()
  {
    try
    {
      AppMethodBeat.i(194540);
      if (MwN == null) {
        MwN = new a();
      }
      a locala = MwN;
      AppMethodBeat.o(194540);
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString, FileDescriptor paramFileDescriptor, long paramLong, int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(194542);
    d.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + paramLong + ", width: " + paramInt1 + ", height: " + paramInt2);
    this.MwQ += 1;
    if ((!TextUtils.isEmpty(Build.MODEL)) && (Build.MODEL.equals("Lenovo+K900")))
    {
      d.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
      AppMethodBeat.o(194542);
      return -1;
    }
    b localb = new b((byte)0);
    localb.id = this.MwQ;
    localb.MwR = paramFileDescriptor;
    localb.url = paramString;
    localb.bdJ = paramLong;
    localb.width = paramInt1;
    localb.height = paramInt2;
    localb.MwS = parama;
    paramString = new Message();
    paramString.what = 1;
    paramString.obj = localb;
    if (!this.MwO.sendMessage(paramString)) {
      d.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
    }
    paramInt1 = this.MwQ;
    AppMethodBeat.o(194542);
    return paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void ahS(int paramInt);
    
    public abstract void ahT(int paramInt);
  }
  
  static final class b
  {
    FileDescriptor MwR;
    protected a.a MwS;
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
      AppMethodBeat.i(194539);
      switch (paramMessage.what)
      {
      default: 
        d.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
      }
      do
      {
        AppMethodBeat.o(194539);
        return;
        d.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
        paramMessage = (a.b)paramMessage.obj;
        a.a(a.this, paramMessage);
        AppMethodBeat.o(194539);
        return;
        d.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
      } while (a.a(a.this) == null);
      a.a(a.this).release();
      a.b(a.this);
      AppMethodBeat.o(194539);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.a
 * JD-Core Version:    0.7.0.1
 */