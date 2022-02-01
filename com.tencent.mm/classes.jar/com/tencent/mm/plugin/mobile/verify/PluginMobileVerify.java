package com.tencent.mm.plugin.mobile.verify;

import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.mobile.verify.a.a;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.plugin.mobile.verify.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginMobileVerify
  extends f
  implements a
{
  private Map<String, a.a> callbacks;
  
  public PluginMobileVerify()
  {
    AppMethodBeat.i(224125);
    this.callbacks = new ConcurrentHashMap();
    AppMethodBeat.o(224125);
  }
  
  public void execute(g paramg) {}
  
  public a.a getCallback(String paramString)
  {
    AppMethodBeat.i(224126);
    paramString = (a.a)this.callbacks.get(paramString);
    AppMethodBeat.o(224126);
    return paramString;
  }
  
  public void getMobileToken(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(224127);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.PluginMobileVerify", "sessionId  is empty!");
      paramString2 = new Bundle();
      paramString2.putString("session", paramString1);
      parama.F(paramString2);
      AppMethodBeat.o(224127);
      return;
    }
    Log.i("MicroMsg.PluginMobileVerify", "getMobileNumber %s, callback %s", new Object[] { paramString1, parama });
    if (parama != null) {
      this.callbacks.put(paramString1, parama);
    }
    h.RTc.aX(new b(paramString1, paramString2));
    AppMethodBeat.o(224127);
  }
  
  public void removeCallback(String paramString)
  {
    AppMethodBeat.i(224128);
    this.callbacks.remove(paramString);
    AppMethodBeat.o(224128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mobile.verify.PluginMobileVerify
 * JD-Core Version:    0.7.0.1
 */