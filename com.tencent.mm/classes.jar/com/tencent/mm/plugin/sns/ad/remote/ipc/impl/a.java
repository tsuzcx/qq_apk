package com.tencent.mm.plugin.sns.ad.remote.ipc.impl;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.sns.ad.remote.ipc.a, com.tencent.mm.plugin.sns.ad.remote.ipc.b
{
  public com.tencent.mm.plugin.sns.ad.remote.a.b Dxq;
  public com.tencent.mm.plugin.sns.ad.remote.a.a Dxr;
  public IPCRemoteProxy Dxs;
  
  static Object aNN(String paramString)
  {
    AppMethodBeat.i(202067);
    try
    {
      paramString = Class.forName(paramString).newInstance();
      AppMethodBeat.o(202067);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202067);
    }
    return null;
  }
  
  public final Bundle aA(Bundle paramBundle)
  {
    AppMethodBeat.i(202065);
    if (paramBundle != null)
    {
      if (this.Dxq != null) {}
      for (String str = this.Dxq.getClass().getName();; str = "")
      {
        paramBundle.putCharSequence("key_server_class", str);
        if (this.Dxs == null) {
          break;
        }
        paramBundle = this.Dxs.REMOTE_CALL("calledOnServer", new Object[] { getClass().getName(), paramBundle });
        if (!(paramBundle instanceof Bundle)) {
          break;
        }
        paramBundle = (Bundle)paramBundle;
        AppMethodBeat.o(202065);
        return paramBundle;
      }
      AppMethodBeat.o(202065);
      return null;
    }
    Log.w("SimpleRemoteRequest", "the input args is null, are you sure?");
    AppMethodBeat.o(202065);
    return null;
  }
  
  public final void aB(Bundle paramBundle)
  {
    AppMethodBeat.i(202066);
    if (this.Dxs != null) {
      this.Dxs.CLIENT_CALL("callbackFromServer", new Object[] { paramBundle });
    }
    AppMethodBeat.o(202066);
  }
  
  final boolean eXA()
  {
    AppMethodBeat.i(202068);
    Object localObject1 = this.Dxr;
    if (localObject1 == null)
    {
      AppMethodBeat.o(202068);
      return false;
    }
    try
    {
      Object localObject2 = com.tencent.mm.plugin.sns.ad.remote.a.a.class.getMethods();
      boolean bool = c.w((Object[])localObject2);
      if (bool)
      {
        AppMethodBeat.o(202068);
        return false;
      }
      localObject2 = localObject2[0].getName();
      localObject1 = localObject1.getClass().getMethod((String)localObject2, new Class[] { Bundle.class });
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.sns.ad.remote.b)((Method)localObject1).getAnnotation(com.tencent.mm.plugin.sns.ad.remote.b.class);
        if (localObject1 != null)
        {
          bool = ((com.tencent.mm.plugin.sns.ad.remote.b)localObject1).eXz();
          AppMethodBeat.o(202068);
          return bool;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202068);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.remote.ipc.impl.a
 * JD-Core Version:    0.7.0.1
 */