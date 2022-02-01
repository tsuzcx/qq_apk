package com.tencent.mm.ui.n.b;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.emoji.a.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.l;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.u;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  private static final Map<String, String> afxl;
  public RectF afxi;
  public String afxj;
  public int afxk;
  public String content;
  public String extData;
  public boolean hBF;
  public String hHa;
  public String hYg;
  public String mhR;
  public long msgId;
  public int msgType;
  public long timestamp;
  private cc wPy;
  
  static
  {
    AppMethodBeat.i(249872);
    afxl = new HashMap(100);
    AppMethodBeat.o(249872);
  }
  
  private static RectF a(cc paramcc, String paramString, boolean paramBoolean, com.tencent.mm.ui.chatting.d.a parama, View paramView)
  {
    AppMethodBeat.i(249861);
    c.a locala = com.tencent.mm.ui.n.c.a.a(parama, paramcc.field_msgId);
    if (locala == null)
    {
      Log.w("MicroMsg.MagicEmojiMsgMeta", "hy: msg item not found!");
      AppMethodBeat.o(249861);
      return null;
    }
    int[] arrayOfInt = com.tencent.mm.ui.n.c.a.lX(paramView);
    int j;
    if (Util.isNullOrNil(paramString))
    {
      paramString = locala.getMainContainerView();
      if (paramString == null)
      {
        Log.i("MicroMsg.MagicEmojiMsgMeta", "hy: not having main view");
        AppMethodBeat.o(249861);
        return null;
      }
      paramcc = com.tencent.mm.ui.n.c.a.lX(paramString);
      j = paramString.getWidth();
    }
    for (int i = paramString.getHeight();; i = (int)paramString.height())
    {
      paramString = new Point(paramView.getWidth(), paramView.getHeight());
      int k = arrayOfInt[0];
      int m = arrayOfInt[1];
      int n = arrayOfInt[0];
      int i1 = paramString.x;
      int i2 = arrayOfInt[1];
      paramString = new Rect(k, m, n + i1, paramString.y + i2);
      if (new Rect(paramcc[0], paramcc[1], paramcc[0] + j, paramcc[1] + i).intersect(paramString)) {
        break;
      }
      Log.w("MicroMsg.MagicEmojiMsgMeta", "hy: main view not in the window location");
      AppMethodBeat.o(249861);
      return null;
      paramString = ((u)parama.cm(u.class)).jrZ().b(paramcc.field_msgId, paramString);
      paramcc = new int[2];
      paramcc[0] = ((int)paramString.left);
      paramcc[1] = ((int)paramString.top);
      j = (int)paramString.width();
    }
    if ((arrayOfInt.length >= 2) && (paramcc.length >= 2))
    {
      float f1 = paramcc[0] - arrayOfInt[0];
      float f2 = paramcc[1] - arrayOfInt[1];
      paramcc = new RectF(f1, f2, j + f1, i + f2);
      AppMethodBeat.o(249861);
      return paramcc;
    }
    Log.w("MicroMsg.MagicEmojiMsgMeta", "hy: window or view lost");
    AppMethodBeat.o(249861);
    return null;
  }
  
  public static i a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, com.tencent.mm.ui.chatting.d.a parama, View paramView)
  {
    AppMethodBeat.i(249836);
    if (paramLong < 0L)
    {
      Log.e("MicroMsg.MagicEmojiMsgMeta", "hy: not valid msgId");
      AppMethodBeat.o(249836);
      return null;
    }
    cc localcc = ((n)h.ax(n.class)).gaZ().sl(paramLong);
    if (localcc == null)
    {
      Log.w("MicroMsg.MagicEmojiMsgMeta", "hy: msg %d lost", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(249836);
      return null;
    }
    paramString1 = a(localcc, paramString1, paramString2, paramBoolean, parama, paramView);
    AppMethodBeat.o(249836);
    return paramString1;
  }
  
  public static i a(cc paramcc, String paramString1, String paramString2, boolean paramBoolean, com.tencent.mm.ui.chatting.d.a parama, View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(249849);
    int i;
    i locali;
    String str1;
    if (paramcc.fxR())
    {
      i = 49;
      Log.d("MicroMsg.MagicEmojiMsgMeta", "hy: start get msg info with msg type: %d", new Object[] { Integer.valueOf(i) });
      locali = new i();
      locali.wPy = paramcc;
      locali.msgId = paramcc.field_msgId;
      locali.afxj = paramString1;
      locali.content = f.s(paramcc);
      String str2 = locali.content;
      if (!Util.isNullOrNil(paramString1)) {
        break label236;
      }
      str1 = paramcc.field_msgId;
      label110:
      locali.mhR = bM(str2, str1, paramString2);
      if (!Util.isNullOrNil(locali.mhR)) {
        break label242;
      }
    }
    for (int j = 0;; j = f.a.El(locali.mhR))
    {
      locali.afxk = j;
      if (paramcc.field_isSend != 1) {
        bool = true;
      }
      locali.hBF = bool;
      locali.timestamp = paramcc.getCreateTime();
      locali.hYg = com.tencent.mm.ui.n.c.a.aU(paramcc);
      locali.hHa = com.tencent.mm.ui.n.c.a.aV(paramcc);
      locali.msgType = i;
      locali.jBI();
      if (!paramBoolean) {
        break label265;
      }
      paramcc = a(paramcc, paramString1, true, parama, paramView);
      if (paramcc != null) {
        break label259;
      }
      AppMethodBeat.o(249849);
      return null;
      i = paramcc.getType();
      break;
      label236:
      str1 = paramString1;
      break label110;
      label242:
      paramString2 = f.mfZ;
    }
    label259:
    locali.afxi = paramcc;
    label265:
    AppMethodBeat.o(249849);
    return locali;
  }
  
  private static String bM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(249828);
    if (!Util.isNullOrNil(paramString3))
    {
      afxl.put(paramString2, paramString3);
      AppMethodBeat.o(249828);
      return paramString3;
    }
    if (afxl.containsKey(paramString2))
    {
      paramString1 = (String)afxl.get(paramString2);
      AppMethodBeat.o(249828);
      return paramString1;
    }
    Log.d("MicroMsg.MagicEmojiMsgMeta", "hy: get emoji that has never fired");
    paramString1 = Util.nullAsNil(d.apf(paramString1));
    afxl.put(paramString2, paramString1);
    AppMethodBeat.o(249828);
    return paramString1;
  }
  
  private void jBI()
  {
    AppMethodBeat.i(249866);
    JSONObject localJSONObject;
    if (this.wPy.fxR()) {
      localJSONObject = new JSONObject();
    }
    try
    {
      int i = l.v(this.wPy);
      Log.i("MicroMsg.MagicEmojiMsgMeta", "hy: appmsg inner type is %d", new Object[] { Integer.valueOf(i) });
      localJSONObject.put("appMsgInnerType", i);
      this.extData = localJSONObject.toString();
      AppMethodBeat.o(249866);
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
  
  public final Map<String, Object> jBH()
  {
    AppMethodBeat.i(249877);
    HashMap localHashMap1 = new HashMap(5);
    localHashMap1.put("msgId", Long.valueOf(this.msgId));
    localHashMap1.put("ID", this.afxj);
    localHashMap1.put("isFrom", Boolean.valueOf(this.hBF));
    localHashMap1.put("msgType", Integer.valueOf(this.msgType));
    localHashMap1.put("content", this.content);
    localHashMap1.put("emojiKey", this.mhR);
    localHashMap1.put("timestamp", Long.valueOf(this.timestamp));
    localHashMap1.put("fromUserName", this.hYg);
    localHashMap1.put("toUserName", this.hHa);
    localHashMap1.put("emojiConfigVersion", Integer.valueOf(this.afxk));
    localHashMap1.put("ext", this.extData);
    if (this.afxi != null)
    {
      HashMap localHashMap2 = new HashMap(4);
      localHashMap2.put("x", Float.valueOf(com.tencent.mm.ui.n.c.a.ec(this.afxi.left)));
      localHashMap2.put("y", Float.valueOf(com.tencent.mm.ui.n.c.a.ec(this.afxi.top)));
      localHashMap2.put("w", Float.valueOf(com.tencent.mm.ui.n.c.a.ec(this.afxi.width())));
      localHashMap2.put("h", Float.valueOf(com.tencent.mm.ui.n.c.a.ec(this.afxi.height())));
      localHashMap1.put("frame", localHashMap2);
    }
    AppMethodBeat.o(249877);
    return localHashMap1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(249882);
    String str = "MagicEmojiMsgMeta{msgId=" + this.msgId + ", frame=" + this.afxi + ", isFrom=" + this.hBF + ", content='" + this.content + '\'' + ", emojiKey='" + this.mhR + '\'' + ", timestamp=" + this.timestamp + ", msgType=" + this.msgType + ", emojiID='" + this.afxj + '\'' + ", fromUserName='" + this.hYg + '\'' + ", toUserName='" + this.hHa + '\'' + ", extData='" + this.extData + '\'' + ", emojiConfigVersion=" + this.afxk + ", mMsgInfo=" + this.wPy + '}';
    AppMethodBeat.o(249882);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.i
 * JD-Core Version:    0.7.0.1
 */