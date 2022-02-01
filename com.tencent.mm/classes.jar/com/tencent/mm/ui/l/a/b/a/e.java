package com.tencent.mm.ui.l.a.b.a;

import android.graphics.RectF;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.l.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static final MMHandler mKp;
  public boolean ONW;
  public RectF Qmx;
  public String Qmy;
  public String content;
  public String dJw;
  public long timestamp;
  public int type;
  
  static
  {
    AppMethodBeat.i(234449);
    mKp = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(234449);
  }
  
  public static e a(final long paramLong, com.tencent.mm.ui.l.a.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(234446);
    Log.printDebugStack("MicroMsg.MagicEmojiMsgMeta", "hy: start create msg meta: %d, %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    if (paramLong < 0L)
    {
      Log.e("MicroMsg.MagicEmojiMsgMeta", "hy: not valid msgId");
      AppMethodBeat.o(234446);
      return null;
    }
    ca localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(paramLong);
    Log.d("MicroMsg.MagicEmojiMsgMeta", "hy: start get msg info with msg type: %d", new Object[] { Integer.valueOf(localca.getType()) });
    e locale = new e();
    locale.content = f.r(localca);
    locale.Qmy = Util.nullAsNil(b.anj(locale.content));
    boolean bool;
    String str;
    if (localca.field_isSend != 1)
    {
      bool = true;
      locale.ONW = bool;
      locale.timestamp = localca.field_createTime;
      if (localca.field_isSend != 1) {
        break label242;
      }
      str = localca.field_talker;
    }
    for (;;)
    {
      locale.dJw = str;
      locale.type = localca.getType();
      if (paramBoolean) {
        locale.Qmx = ((RectF)new SyncTask() {}.exec(mKp));
      }
      if ((!paramBoolean) || (locale.Qmx != null)) {
        break label271;
      }
      AppMethodBeat.o(234446);
      return null;
      bool = false;
      break;
      label242:
      if (ab.Eq(localca.field_talker)) {
        str = localca.field_talker;
      } else {
        str = z.aTY();
      }
    }
    label271:
    AppMethodBeat.o(234446);
    return locale;
  }
  
  public final Map<String, Object> gWU()
  {
    AppMethodBeat.i(234447);
    HashMap localHashMap1 = new HashMap(5);
    localHashMap1.put("isFrom", Boolean.valueOf(this.ONW));
    localHashMap1.put("msgType", Integer.valueOf(this.type));
    localHashMap1.put("content", this.content);
    localHashMap1.put("emojiKey", this.Qmy);
    localHashMap1.put("timestamp", Long.valueOf(this.timestamp));
    if (this.Qmx != null)
    {
      HashMap localHashMap2 = new HashMap(4);
      localHashMap2.put("x", Float.valueOf(a.cx(this.Qmx.left)));
      localHashMap2.put("y", Float.valueOf(a.cx(this.Qmx.top)));
      localHashMap2.put("w", Float.valueOf(a.cx(this.Qmx.width())));
      localHashMap2.put("h", Float.valueOf(a.cx(this.Qmx.height())));
      localHashMap1.put("frame", localHashMap2);
    }
    AppMethodBeat.o(234447);
    return localHashMap1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(234448);
    String str = "MagicEmojiMsgMeta{frame=" + this.Qmx + ", isFrom=" + this.ONW + ", content='" + this.content + '\'' + ", emojiKey='" + this.Qmy + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", toUserName='" + this.dJw + '\'' + '}';
    AppMethodBeat.o(234448);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */