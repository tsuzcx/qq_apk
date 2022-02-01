package com.tencent.mm.ui.n.a.b.a;

import android.graphics.RectF;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.l;
import com.tencent.mm.emoji.a.f.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.n.a.g;
import com.tencent.mm.ui.n.b.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final Map<String, String> XKs;
  private static final MMHandler pLh;
  public boolean Whh;
  public String XJA;
  public String XJz;
  public RectF XKq;
  public int XKr;
  public String content;
  public String extData;
  public String fCl;
  public String fSj;
  public long msgId;
  public int msgType;
  private ca tMi;
  public long timestamp;
  
  static
  {
    AppMethodBeat.i(275577);
    XKs = new HashMap(100);
    pLh = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(275577);
  }
  
  public static f a(long paramLong, String paramString1, String paramString2, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(275570);
    if (paramLong < 0L)
    {
      Log.e("MicroMsg.MagicEmojiMsgMeta", "hy: not valid msgId");
      AppMethodBeat.o(275570);
      return null;
    }
    paramString1 = a(((n)h.ae(n.class)).eSe().Oq(paramLong), paramString1, paramString2, paramg, paramBoolean);
    AppMethodBeat.o(275570);
    return paramString1;
  }
  
  public static f a(final ca paramca, final String paramString1, String paramString2, g paramg, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(275573);
    int i;
    f localf;
    String str1;
    if (paramca.erk())
    {
      i = 49;
      Log.d("MicroMsg.MagicEmojiMsgMeta", "hy: start get msg info with msg type: %d", new Object[] { Integer.valueOf(i) });
      localf = new f();
      localf.tMi = paramca;
      localf.msgId = paramca.field_msgId;
      localf.XJz = paramString1;
      localf.content = com.tencent.mm.emoji.a.f.s(paramca);
      String str2 = localf.content;
      if (!Util.isNullOrNil(paramString1)) {
        break label260;
      }
      str1 = paramca.field_msgId;
      label110:
      localf.XJA = bq(str2, str1, paramString2);
      if (!Util.isNullOrNil(localf.XJA)) {
        break label266;
      }
    }
    for (int j = 0;; j = f.a.LF(localf.XJA))
    {
      localf.XKr = j;
      if (paramca.field_isSend != 1) {
        bool = true;
      }
      localf.Whh = bool;
      localf.timestamp = paramca.field_createTime;
      localf.fSj = a.aG(paramca);
      localf.fCl = a.aH(paramca);
      localf.msgType = i;
      localf.hXx();
      if (paramBoolean) {
        localf.XKq = ((RectF)new SyncTask() {}.exec(pLh));
      }
      if ((!paramBoolean) || (localf.XKq != null)) {
        break label283;
      }
      AppMethodBeat.o(275573);
      return null;
      i = paramca.getType();
      break;
      label260:
      str1 = paramString1;
      break label110;
      label266:
      paramString2 = com.tencent.mm.emoji.a.f.jGv;
    }
    label283:
    AppMethodBeat.o(275573);
    return localf;
  }
  
  private static String bq(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(275572);
    if (!Util.isNullOrNil(paramString3))
    {
      XKs.put(paramString2, paramString3);
      AppMethodBeat.o(275572);
      return paramString3;
    }
    if (XKs.containsKey(paramString2))
    {
      paramString1 = (String)XKs.get(paramString2);
      AppMethodBeat.o(275572);
      return paramString1;
    }
    Log.d("MicroMsg.MagicEmojiMsgMeta", "hy: get emoji that has never fired");
    paramString1 = Util.nullAsNil(b.avf(paramString1));
    XKs.put(paramString2, paramString1);
    AppMethodBeat.o(275572);
    return paramString1;
  }
  
  private void hXx()
  {
    AppMethodBeat.i(275575);
    JSONObject localJSONObject;
    if (this.tMi.erk()) {
      localJSONObject = new JSONObject();
    }
    try
    {
      int i = l.v(this.tMi);
      Log.i("MicroMsg.MagicEmojiMsgMeta", "hy: appmsg inner type is %d", new Object[] { Integer.valueOf(i) });
      localJSONObject.put("appMsgInnerType", i);
      this.extData = localJSONObject.toString();
      AppMethodBeat.o(275575);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MagicEmojiMsgMeta", localJSONException, "hy: failed getting msg inner type", new Object[0]);
      }
    }
  }
  
  public final Map<String, Object> hXw()
  {
    AppMethodBeat.i(275574);
    HashMap localHashMap1 = new HashMap(5);
    localHashMap1.put("msgId", Long.valueOf(this.msgId));
    localHashMap1.put("ID", this.XJz);
    localHashMap1.put("isFrom", Boolean.valueOf(this.Whh));
    localHashMap1.put("msgType", Integer.valueOf(this.msgType));
    localHashMap1.put("content", this.content);
    localHashMap1.put("emojiKey", this.XJA);
    localHashMap1.put("timestamp", Long.valueOf(this.timestamp));
    localHashMap1.put("fromUserName", this.fSj);
    localHashMap1.put("toUserName", this.fCl);
    localHashMap1.put("emojiConfigVersion", Integer.valueOf(this.XKr));
    localHashMap1.put("ext", this.extData);
    if (this.XKq != null)
    {
      HashMap localHashMap2 = new HashMap(4);
      localHashMap2.put("x", Float.valueOf(a.cP(this.XKq.left)));
      localHashMap2.put("y", Float.valueOf(a.cP(this.XKq.top)));
      localHashMap2.put("w", Float.valueOf(a.cP(this.XKq.width())));
      localHashMap2.put("h", Float.valueOf(a.cP(this.XKq.height())));
      localHashMap1.put("frame", localHashMap2);
    }
    AppMethodBeat.o(275574);
    return localHashMap1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(275576);
    String str = "MagicEmojiMsgMeta{msgId=" + this.msgId + ", frame=" + this.XKq + ", isFrom=" + this.Whh + ", content='" + this.content + '\'' + ", emojiKey='" + this.XJA + '\'' + ", timestamp=" + this.timestamp + ", msgType=" + this.msgType + ", emojiID='" + this.XJz + '\'' + ", fromUserName='" + this.fSj + '\'' + ", toUserName='" + this.fCl + '\'' + ", extData='" + this.extData + '\'' + ", emojiConfigVersion=" + this.XKr + ", mMsgInfo=" + this.tMi + '}';
    AppMethodBeat.o(275576);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */