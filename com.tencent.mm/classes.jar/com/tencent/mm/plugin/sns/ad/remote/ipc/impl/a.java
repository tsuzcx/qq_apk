package com.tencent.mm.plugin.sns.ad.remote.ipc.impl;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.sns.ad.remote.ipc.a, com.tencent.mm.plugin.sns.ad.remote.ipc.b
{
  public com.tencent.mm.plugin.sns.ad.remote.a.b PXX;
  public com.tencent.mm.plugin.sns.ad.remote.a.a PXY;
  public IPCRemoteProxy PXZ;
  
  static Object aWH(String paramString)
  {
    AppMethodBeat.i(309664);
    try
    {
      paramString = Class.forName(paramString).newInstance();
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(309664);
    }
    return null;
  }
  
  public final Bundle aX(Bundle paramBundle)
  {
    AppMethodBeat.i(309667);
    if (paramBundle != null)
    {
      if (this.PXX != null) {}
      for (String str = this.PXX.getClass().getName();; str = "")
      {
        paramBundle.putCharSequence("key_server_class", str);
        if (this.PXZ == null) {
          break;
        }
        paramBundle = this.PXZ.REMOTE_CALL("calledOnServer", new Object[] { getClass().getName(), paramBundle });
        if (!(paramBundle instanceof Bundle)) {
          break;
        }
        paramBundle = (Bundle)paramBundle;
        AppMethodBeat.o(309667);
        return paramBundle;
      }
      AppMethodBeat.o(309667);
      return null;
    }
    Log.w("SimpleRemoteRequest", "the input args is null, are you sure?");
    AppMethodBeat.o(309667);
    return null;
  }
  
  public final void aY(Bundle paramBundle)
  {
    AppMethodBeat.i(309671);
    if (this.PXZ != null) {
      this.PXZ.CLIENT_CALL("callbackFromServer", new Object[] { paramBundle });
    }
    AppMethodBeat.o(309671);
  }
  
  final boolean hbs()
  {
    AppMethodBeat.i(309678);
    Object localObject1 = this.PXY;
    if (localObject1 == null)
    {
      AppMethodBeat.o(309678);
      return false;
    }
    try
    {
      Object localObject3 = com.tencent.mm.plugin.sns.ad.remote.a.a.class.getMethods();
      boolean bool = d.y((Object[])localObject3);
      if (bool) {
        return false;
      }
      localObject3 = localObject3[0].getName();
      localObject1 = localObject1.getClass().getMethod((String)localObject3, new Class[] { Bundle.class });
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.sns.ad.remote.b)((Method)localObject1).getAnnotation(com.tencent.mm.plugin.sns.ad.remote.b.class);
        if (localObject1 != null)
        {
          bool = ((com.tencent.mm.plugin.sns.ad.remote.b)localObject1).hbr();
          return bool;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(309678);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.remote.ipc.impl.a
 * JD-Core Version:    0.7.0.1
 */