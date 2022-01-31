package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$a
{
  boolean csk;
  boolean isRunning;
  private b uOk;
  private String uOl;
  private long uOm;
  
  private a$a(a parama) {}
  
  private static String dL(String paramString, int paramInt)
  {
    AppMethodBeat.i(5651);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(paramInt);
    paramString = com.tencent.mm.a.g.w(localStringBuffer.toString().getBytes());
    AppMethodBeat.o(5651);
    return paramString;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(5652);
    if (bo.isNullOrNil(paramString1))
    {
      if (paramString2 == null) {}
      for (paramString2 = "";; paramString2 = paramString2.toString())
      {
        ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "error query:%s type:%d pagebuf:%s ", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
        AppMethodBeat.o(5652);
        return;
      }
    }
    String str = dL(paramString1, paramInt1);
    if ((!bo.isNullOrNil(this.uOl)) && (this.uOl.equals(str)) && (System.currentTimeMillis() - this.uOm <= 8000L) && (bo.isNullOrNil(paramString2)))
    {
      if (this.csk)
      {
        ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[] { paramString1 });
        h.KW(paramInt2).a(this.uOk.dax().xKp, true, aa.b(this.uOk.dax().xaZ), this.uOk.dax().xbc);
        AppMethodBeat.o(5652);
        return;
      }
      if (this.isRunning)
      {
        if (this.uOk != null) {
          this.uOk.uOn = paramInt2;
        }
        ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
        AppMethodBeat.o(5652);
        return;
      }
      ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
    }
    ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[] { paramString1, str, Integer.valueOf(paramInt2) });
    if (this.uOk != null) {
      com.tencent.mm.kernel.g.Rc().a(this.uOk);
    }
    this.uOl = str;
    this.uOm = System.currentTimeMillis();
    this.isRunning = true;
    this.csk = false;
    com.tencent.mm.kernel.g.Rc().a(234, this.uOj);
    this.uOk = new b(paramInt1, paramString1, paramString2.getBytes(), paramInt2, paramLong);
    com.tencent.mm.kernel.g.Rc().a(this.uOk, 0);
    AppMethodBeat.o(5652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a.a
 * JD-Core Version:    0.7.0.1
 */