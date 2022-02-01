package com.tencent.mm.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Constructor;

public class RemoteService
  extends Service
{
  private c.a UQb;
  
  public RemoteService()
  {
    AppMethodBeat.i(152742);
    this.UQb = new c.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, Bundle paramAnonymousBundle, b paramAnonymousb)
      {
        AppMethodBeat.i(152741);
        try
        {
          Object localObject = RemoteService.this.getClassLoader().loadClass(paramAnonymousString1);
          paramAnonymousString1 = ((Class)localObject).getConstructors();
          if (paramAnonymousString1.length > 0)
          {
            localObject = new Object[paramAnonymousString1[0].getParameterTypes().length];
            localObject[0] = null;
          }
          for (paramAnonymousString1 = (a)paramAnonymousString1[0].newInstance((Object[])localObject);; paramAnonymousString1 = (a)((Class)localObject).newInstance())
          {
            paramAnonymousString1.UPX = paramAnonymousb;
            paramAnonymousString1.UPW = RemoteService.this;
            paramAnonymousString1.onCallback(paramAnonymousString2, paramAnonymousBundle, false);
            AppMethodBeat.o(152741);
            return;
          }
          return;
        }
        catch (Exception paramAnonymousString1)
        {
          Log.e("MicroMsg.RemoveService", "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString1) });
          AppMethodBeat.o(152741);
        }
      }
    };
    AppMethodBeat.o(152742);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(152743);
    new StringBuilder("onBind, threadId:").append(Thread.currentThread().getId());
    paramIntent = this.UQb;
    AppMethodBeat.o(152743);
    return paramIntent;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(152746);
    new StringBuilder("onDestroy, threadId:").append(Thread.currentThread().getId());
    super.onDestroy();
    AppMethodBeat.o(152746);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(152744);
    new StringBuilder("onRebind, threadId:").append(Thread.currentThread().getId());
    super.onRebind(paramIntent);
    AppMethodBeat.o(152744);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(152745);
    new StringBuilder("onUnbind, threadId:").append(Thread.currentThread().getId());
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(152745);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.remoteservice.RemoteService
 * JD-Core Version:    0.7.0.1
 */