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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginMobileVerify
  extends f
  implements a
{
  private Map<String, a.a> callbacks;
  
  public PluginMobileVerify()
  {
    AppMethodBeat.i(193580);
    this.callbacks = new ConcurrentHashMap();
    AppMethodBeat.o(193580);
  }
  
  public void execute(g paramg) {}
  
  public a.a getCallback(String paramString)
  {
    AppMethodBeat.i(193581);
    paramString = (a.a)this.callbacks.get(paramString);
    AppMethodBeat.o(193581);
    return paramString;
  }
  
  public void getMobileToken(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(193582);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.PluginMobileVerify", "sessionId  is empty!");
      paramString2 = new Bundle();
      paramString2.putString("session", paramString1);
      parama.x(paramString2);
      AppMethodBeat.o(193582);
      return;
    }
    ad.i("MicroMsg.PluginMobileVerify", "getMobileNumber %s, callback %s", new Object[] { paramString1, parama });
    if (parama != null) {
      this.callbacks.put(paramString1, parama);
    }
    h.Iye.aP(new b(paramString1, paramString2));
    AppMethodBeat.o(193582);
  }
  
  public void removeCallback(String paramString)
  {
    AppMethodBeat.i(193583);
    this.callbacks.remove(paramString);
    AppMethodBeat.o(193583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mobile.verify.PluginMobileVerify
 * JD-Core Version:    0.7.0.1
 */