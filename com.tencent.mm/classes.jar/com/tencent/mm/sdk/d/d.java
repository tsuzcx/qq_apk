package com.tencent.mm.sdk.d;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class d
{
  public String mName;
  public volatile d.c ujd;
  volatile HandlerThread uje;
  
  public d(String paramString, Looper paramLooper)
  {
    this.mName = paramString;
    this.ujd = new d.c(paramLooper, this, (byte)0);
  }
  
  private Message obtainMessage(int paramInt)
  {
    return Message.obtain(this.ujd, paramInt);
  }
  
  public final void Ff(int paramInt)
  {
    d.c localc = this.ujd;
    if (localc == null) {
      return;
    }
    localc.sendMessage(obtainMessage(paramInt));
  }
  
  public final void Fg(int paramInt)
  {
    d.c localc = this.ujd;
    if (localc == null) {
      return;
    }
    localc.sendMessageAtFrontOfQueue(obtainMessage(paramInt));
  }
  
  public final void a(c paramc)
  {
    d.c.a(this.ujd, paramc);
  }
  
  public void abD() {}
  
  public final void b(a parama)
  {
    d.c.a(this.ujd, parama);
  }
  
  public final void b(c paramc)
  {
    d.c.b(this.ujd, paramc);
  }
  
  public final Message csk()
  {
    d.c localc = this.ujd;
    if (localc == null) {
      return null;
    }
    return d.c.b(localc);
  }
  
  public final a csl()
  {
    d.c localc = this.ujd;
    if (localc == null) {
      return null;
    }
    return d.c.c(localc);
  }
  
  public boolean e(Message paramMessage)
  {
    return true;
  }
  
  public void f(Message paramMessage)
  {
    if (d.c.d(this.ujd)) {
      new StringBuilder(" - unhandledMessage: msg.what=").append(paramMessage.what);
    }
  }
  
  public final void quit()
  {
    d.c localc = this.ujd;
    if (localc == null) {
      return;
    }
    d.c.e(localc);
  }
  
  public void start()
  {
    d.c localc = this.ujd;
    if (localc == null) {
      return;
    }
    d.c.g(localc);
  }
  
  private final class c$b
    extends c
  {
    private c$b() {}
    
    public final boolean g(Message paramMessage)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d
 * JD-Core Version:    0.7.0.1
 */