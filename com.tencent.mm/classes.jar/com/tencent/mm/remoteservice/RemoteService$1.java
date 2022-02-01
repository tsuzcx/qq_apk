package com.tencent.mm.remoteservice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Constructor;

final class RemoteService$1
  extends c.a
{
  RemoteService$1(RemoteService paramRemoteService) {}
  
  public final void a(String paramString1, String paramString2, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(152741);
    try
    {
      Object localObject = this.ackZ.getClassLoader().loadClass(paramString1);
      paramString1 = ((Class)localObject).getConstructors();
      if (paramString1.length > 0)
      {
        localObject = new Object[paramString1[0].getParameterTypes().length];
        localObject[0] = null;
      }
      for (paramString1 = (a)paramString1[0].newInstance((Object[])localObject);; paramString1 = (a)((Class)localObject).newInstance())
      {
        paramString1.ackU = paramb;
        paramString1.ackT = this.ackZ;
        paramString1.onCallback(paramString2, paramBundle, false);
        AppMethodBeat.o(152741);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.RemoveService", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(152741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.remoteservice.RemoteService.1
 * JD-Core Version:    0.7.0.1
 */