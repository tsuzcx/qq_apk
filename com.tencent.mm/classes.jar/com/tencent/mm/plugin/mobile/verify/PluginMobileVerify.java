package com.tencent.mm.plugin.mobile.verify;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.mobile.verify.a.a;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.plugin.mobile.verify.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginMobileVerify
  extends f
  implements a
{
  private Map<String, a.a> Lfc;
  
  public PluginMobileVerify()
  {
    AppMethodBeat.i(260322);
    this.Lfc = new ConcurrentHashMap();
    AppMethodBeat.o(260322);
  }
  
  public void execute(g paramg) {}
  
  public a.a getCallback(String paramString)
  {
    AppMethodBeat.i(260324);
    paramString = (a.a)this.Lfc.get(paramString);
    AppMethodBeat.o(260324);
    return paramString;
  }
  
  public void getMobileToken(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(260328);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.PluginMobileVerify", "sessionId  is empty!");
      paramString2 = new Bundle();
      paramString2.putString("session", paramString1);
      parama.U(paramString2);
      AppMethodBeat.o(260328);
      return;
    }
    Log.i("MicroMsg.PluginMobileVerify", "getMobileNumber %s, callback %s", new Object[] { paramString1, parama });
    if (parama != null) {
      this.Lfc.put(paramString1, parama);
    }
    h.ahAA.bm(new b(paramString1, paramString2));
    AppMethodBeat.o(260328);
  }
  
  public void removeCallback(String paramString)
  {
    AppMethodBeat.i(260330);
    this.Lfc.remove(paramString);
    AppMethodBeat.o(260330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mobile.verify.PluginMobileVerify
 * JD-Core Version:    0.7.0.1
 */