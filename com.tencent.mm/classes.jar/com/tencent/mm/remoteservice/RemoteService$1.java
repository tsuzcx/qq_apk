package com.tencent.mm.remoteservice;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Constructor;

final class RemoteService$1
  extends c.a
{
  RemoteService$1(RemoteService paramRemoteService) {}
  
  public final void a(String paramString1, String paramString2, Bundle paramBundle, b paramb)
  {
    try
    {
      Object localObject = this.uaD.getClassLoader().loadClass(paramString1);
      paramString1 = ((Class)localObject).getConstructors();
      if (paramString1.length > 0)
      {
        localObject = new Object[paramString1[0].getParameterTypes().length];
        localObject[0] = null;
      }
      for (paramString1 = (a)paramString1[0].newInstance((Object[])localObject);; paramString1 = (a)((Class)localObject).newInstance())
      {
        paramString1.uaA = paramb;
        paramString1.uaz = this.uaD;
        paramString1.onCallback(paramString2, paramBundle, false);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      y.e("MicroMsg.RemoveService", "exception:%s", new Object[] { bk.j(paramString1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.remoteservice.RemoteService.1
 * JD-Core Version:    0.7.0.1
 */