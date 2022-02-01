package com.tencent.mm.plugin.mobile.verify;

import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.mobile.verify.a.a;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.plugin.mobile.verify.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginMobileVerify
  extends f
  implements a
{
  private Map<String, a.a> callbacks;
  
  public PluginMobileVerify()
  {
    AppMethodBeat.i(221130);
    this.callbacks = new ConcurrentHashMap();
    AppMethodBeat.o(221130);
  }
  
  public void execute(g paramg) {}
  
  public a.a getCallback(String paramString)
  {
    AppMethodBeat.i(221131);
    paramString = (a.a)this.callbacks.get(paramString);
    AppMethodBeat.o(221131);
    return paramString;
  }
  
  public void getMobileToken(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(221132);
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.PluginMobileVerify", "sessionId  is empty!");
      paramString2 = new Bundle();
      paramString2.putString("session", paramString1);
      parama.z(paramString2);
      AppMethodBeat.o(221132);
      return;
    }
    ae.i("MicroMsg.PluginMobileVerify", "getMobileNumber %s, callback %s", new Object[] { paramString1, parama });
    if (parama != null) {
      this.callbacks.put(paramString1, parama);
    }
    h.MqF.aO(new b(paramString1, paramString2));
    AppMethodBeat.o(221132);
  }
  
  public void removeCallback(String paramString)
  {
    AppMethodBeat.i(221133);
    this.callbacks.remove(paramString);
    AppMethodBeat.o(221133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mobile.verify.PluginMobileVerify
 * JD-Core Version:    0.7.0.1
 */