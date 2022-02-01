package com.tencent.mm.plugin.sns.ad.remote.ipc.impl;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.sns.ad.remote.ipc.a, com.tencent.mm.plugin.sns.ad.remote.ipc.b
{
  public com.tencent.mm.plugin.sns.ad.remote.a.b JGX;
  public com.tencent.mm.plugin.sns.ad.remote.a.a JGY;
  public IPCRemoteProxy JGZ;
  
  static Object aYD(String paramString)
  {
    AppMethodBeat.i(197122);
    try
    {
      paramString = Class.forName(paramString).newInstance();
      AppMethodBeat.o(197122);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(197122);
    }
    return null;
  }
  
  public final Bundle aw(Bundle paramBundle)
  {
    AppMethodBeat.i(197116);
    if (paramBundle != null)
    {
      if (this.JGX != null) {}
      for (String str = this.JGX.getClass().getName();; str = "")
      {
        paramBundle.putCharSequence("key_server_class", str);
        if (this.JGZ == null) {
          break;
        }
        paramBundle = this.JGZ.REMOTE_CALL("calledOnServer", new Object[] { getClass().getName(), paramBundle });
        if (!(paramBundle instanceof Bundle)) {
          break;
        }
        paramBundle = (Bundle)paramBundle;
        AppMethodBeat.o(197116);
        return paramBundle;
      }
      AppMethodBeat.o(197116);
      return null;
    }
    Log.w("SimpleRemoteRequest", "the input args is null, are you sure?");
    AppMethodBeat.o(197116);
    return null;
  }
  
  public final void ax(Bundle paramBundle)
  {
    AppMethodBeat.i(197118);
    if (this.JGZ != null) {
      this.JGZ.CLIENT_CALL("callbackFromServer", new Object[] { paramBundle });
    }
    AppMethodBeat.o(197118);
  }
  
  final boolean fLb()
  {
    AppMethodBeat.i(197126);
    Object localObject1 = this.JGY;
    if (localObject1 == null)
    {
      AppMethodBeat.o(197126);
      return false;
    }
    try
    {
      Object localObject2 = com.tencent.mm.plugin.sns.ad.remote.a.a.class.getMethods();
      boolean bool = d.w((Object[])localObject2);
      if (bool)
      {
        AppMethodBeat.o(197126);
        return false;
      }
      localObject2 = localObject2[0].getName();
      localObject1 = localObject1.getClass().getMethod((String)localObject2, new Class[] { Bundle.class });
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.sns.ad.remote.b)((Method)localObject1).getAnnotation(com.tencent.mm.plugin.sns.ad.remote.b.class);
        if (localObject1 != null)
        {
          bool = ((com.tencent.mm.plugin.sns.ad.remote.b)localObject1).fLa();
          AppMethodBeat.o(197126);
          return bool;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197126);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.remote.ipc.impl.a
 * JD-Core Version:    0.7.0.1
 */