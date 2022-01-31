package com.tencent.mm.sdk.d;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
{
  public String mName;
  public volatile d.c yrd;
  volatile HandlerThread yre;
  
  protected d(String paramString, Looper paramLooper)
  {
    AppMethodBeat.i(52473);
    this.mName = paramString;
    this.yrd = new d.c(paramLooper, this, (byte)0);
    AppMethodBeat.o(52473);
  }
  
  protected final void Nh(int paramInt)
  {
    AppMethodBeat.i(52482);
    d.c localc = this.yrd;
    if (localc == null)
    {
      AppMethodBeat.o(52482);
      return;
    }
    localc.sendMessageAtFrontOfQueue(obtainMessage(paramInt));
    AppMethodBeat.o(52482);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(52474);
    d.c.a(this.yrd, paramc);
    AppMethodBeat.o(52474);
  }
  
  protected void avu() {}
  
  public final void b(a parama)
  {
    AppMethodBeat.i(52478);
    d.c.a(this.yrd, parama);
    AppMethodBeat.o(52478);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(52475);
    d.c.b(this.yrd, paramc);
    AppMethodBeat.o(52475);
  }
  
  protected final Message duh()
  {
    AppMethodBeat.i(52476);
    Object localObject = this.yrd;
    if (localObject == null)
    {
      AppMethodBeat.o(52476);
      return null;
    }
    localObject = d.c.b((d.c)localObject);
    AppMethodBeat.o(52476);
    return localObject;
  }
  
  public final a dui()
  {
    AppMethodBeat.i(52477);
    Object localObject = this.yrd;
    if (localObject == null)
    {
      AppMethodBeat.o(52477);
      return null;
    }
    localObject = d.c.c((d.c)localObject);
    AppMethodBeat.o(52477);
    return localObject;
  }
  
  protected final void duj()
  {
    AppMethodBeat.i(141970);
    d.c localc = this.yrd;
    if (localc == null)
    {
      AppMethodBeat.o(141970);
      return;
    }
    d.c.f(localc);
    AppMethodBeat.o(141970);
  }
  
  protected boolean i(Message paramMessage)
  {
    return true;
  }
  
  protected void j(Message paramMessage)
  {
    AppMethodBeat.i(52479);
    if (d.c.d(this.yrd)) {
      yQ(" - unhandledMessage: msg.what=" + paramMessage.what);
    }
    AppMethodBeat.o(52479);
  }
  
  protected void log(String paramString) {}
  
  public final Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(52480);
    Message localMessage = Message.obtain(this.yrd, paramInt);
    AppMethodBeat.o(52480);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(141969);
    paramObject = Message.obtain(this.yrd, paramInt, paramObject);
    AppMethodBeat.o(141969);
    return paramObject;
  }
  
  public final void pP(boolean paramBoolean)
  {
    AppMethodBeat.i(141971);
    d.c localc = this.yrd;
    if (localc == null)
    {
      AppMethodBeat.o(141971);
      return;
    }
    d.c.a(localc, paramBoolean);
    AppMethodBeat.o(141971);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(52483);
    d.c localc = this.yrd;
    if (localc == null)
    {
      AppMethodBeat.o(52483);
      return;
    }
    d.c.e(localc);
    AppMethodBeat.o(52483);
  }
  
  public final void sendMessage(int paramInt)
  {
    AppMethodBeat.i(52481);
    d.c localc = this.yrd;
    if (localc == null)
    {
      AppMethodBeat.o(52481);
      return;
    }
    localc.sendMessage(obtainMessage(paramInt));
    AppMethodBeat.o(52481);
  }
  
  public void start()
  {
    AppMethodBeat.i(52484);
    d.c localc = this.yrd;
    if (localc == null)
    {
      AppMethodBeat.o(52484);
      return;
    }
    d.c.g(localc);
    AppMethodBeat.o(52484);
  }
  
  protected void yQ(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d
 * JD-Core Version:    0.7.0.1
 */