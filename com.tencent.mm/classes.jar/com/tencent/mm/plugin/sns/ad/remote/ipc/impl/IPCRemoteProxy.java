package com.tencent.mm.plugin.sns.ad.remote.ipc.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class IPCRemoteProxy
  extends com.tencent.mm.remoteservice.a
{
  private a JGW;
  
  public IPCRemoteProxy(com.tencent.mm.remoteservice.d paramd, a parama)
  {
    super(paramd);
    this.JGW = parama;
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(247800);
    Object localObject1;
    if (!paramBoolean) {
      try
      {
        localObject1 = new a();
        ((a)localObject1).JGZ = this;
        paramString = getArgs(paramBundle);
        int i;
        Object localObject2;
        if (com.tencent.mm.plugin.sns.ad.i.d.x(paramString))
        {
          int j = paramString.length;
          i = 0;
          if (i < j)
          {
            localObject2 = paramString[i];
            if ((localObject2 instanceof Bundle))
            {
              paramString = (Bundle)localObject2;
              label71:
              if (paramString != null)
              {
                paramString.setClassLoader(getClass().getClassLoader());
                if (paramString == null) {
                  break label192;
                }
                paramString.setClassLoader(localObject1.getClass().getClassLoader());
                localObject2 = com.tencent.mm.plugin.sns.ad.i.h.getString(paramString, "key_server_class");
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break label192;
                }
                localObject2 = a.aYD((String)localObject2);
                if (!(localObject2 instanceof com.tencent.mm.plugin.sns.ad.remote.a.b)) {
                  break label185;
                }
                Log.d("SimpleRemoteRequest", "the object is IOnIPCServerCall, the onServer is called.");
              }
            }
          }
        }
        label185:
        label192:
        for (paramString = ((com.tencent.mm.plugin.sns.ad.remote.a.b)localObject2).a((com.tencent.mm.plugin.sns.ad.remote.ipc.b)localObject1, paramString);; paramString = null)
        {
          if (paramString != null) {
            paramBundle.putBundle("result_key", paramString);
          }
          AppMethodBeat.o(247800);
          return;
          i += 1;
          break;
          paramString = null;
          break label71;
          Log.w("SimpleRemoteRequest", "the object is not IOnIPCServerCall");
        }
        try
        {
          paramBundle = getArgs(paramBundle);
          if (this.JGW == null) {
            break label303;
          }
          paramString = this.JGW;
          paramBundle = (Bundle)paramBundle[0];
          localObject1 = paramString.JGY;
          if ((paramBundle == null) || (localObject1 == null)) {
            break label303;
          }
          paramBundle.setClassLoader(paramString.getClass().getClassLoader());
          if (paramString.fLb())
          {
            com.tencent.e.h.ZvG.bc(new a.1(paramString, (com.tencent.mm.plugin.sns.ad.remote.a.a)localObject1, paramBundle));
            AppMethodBeat.o(247800);
            return;
          }
        }
        catch (Exception paramString)
        {
          AppMethodBeat.o(247800);
          return;
        }
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(247800);
        return;
      }
    }
    ((com.tencent.mm.plugin.sns.ad.remote.a.a)localObject1).av(paramBundle);
    label303:
    AppMethodBeat.o(247800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.remote.ipc.impl.IPCRemoteProxy
 * JD-Core Version:    0.7.0.1
 */