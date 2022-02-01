package com.tencent.mm.ui.l.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.l.a.b.a.e;
import com.tencent.mm.ui.l.a.g;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends s
{
  private static final int CTRL_INDEX = -2;
  public static final String NAME = "MagicEmojiSent";
  
  private static void a(Map<String, Object> paramMap, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(234451);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("sessionID", paramString1);
    localHashMap.put("toChatName", paramString2);
    localHashMap.put("messageTimestamp", Long.valueOf(paramLong));
    paramMap.put("reportInfo", localHashMap);
    AppMethodBeat.o(234451);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, g paramg)
  {
    AppMethodBeat.i(234450);
    e locale = e.a(paramLong1, paramg, true);
    if (locale != null)
    {
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("msgId", Long.valueOf(paramLong1));
      localHashMap.put("msgMeta", locale.gWU());
      a(localHashMap, paramString, locale.dJw, paramLong2);
      if (BuildInfo.DEBUG) {
        Log.d("MicroMsg.JsEventOnMagicEmojiMsgCome", "hy: publish msg meta %s", new Object[] { locale.toString() });
      }
      g(paramg).K(localHashMap).bEo();
      AppMethodBeat.o(234450);
      return;
    }
    Log.e("MicroMsg.JsEventOnMagicEmojiMsgCome", "hy: not found the msg or convert failed!");
    AppMethodBeat.o(234450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */