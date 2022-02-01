package com.tencent.mm.ui.n.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.n.a.b.a.f;
import com.tencent.mm.ui.n.a.g;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends r
{
  private static final int CTRL_INDEX = -2;
  public static final String NAME = "MagicEmojiSent";
  
  private static void a(Map<String, Object> paramMap, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(290463);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("sessionID", paramString1);
    localHashMap.put("toChatName", paramString2);
    localHashMap.put("messageTimestamp", Long.valueOf(paramLong));
    paramMap.put("reportInfo", localHashMap);
    AppMethodBeat.o(290463);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, g paramg)
  {
    AppMethodBeat.i(290462);
    paramString1 = f.a(paramLong1, paramString1, paramString2, paramg, true);
    if (paramString1 != null)
    {
      paramString2 = new HashMap(2);
      paramString2.put("msgId", Long.valueOf(paramLong1));
      paramString2.put("scene", Integer.valueOf(1));
      paramString2.put("msgMeta", paramString1.hXw());
      paramString2.put("sentTime", Long.valueOf(paramLong2));
      a(paramString2, paramString3, paramString1.fCl, paramLong2);
      if (BuildInfo.DEBUG) {
        Log.d("MicroMsg.JsEventOnMagicEmojiMsgCome", "hy: publish msg meta %s", new Object[] { paramString1.toString() });
      }
      i(paramg).D(paramString2).bPO();
      AppMethodBeat.o(290462);
      return;
    }
    Log.e("MicroMsg.JsEventOnMagicEmojiMsgCome", "hy: not found the msg or convert failed!");
    AppMethodBeat.o(290462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */