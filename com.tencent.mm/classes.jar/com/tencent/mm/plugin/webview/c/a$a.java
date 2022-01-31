package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$a
{
  boolean bKQ;
  boolean isRunning;
  private b qYE;
  private String qYF;
  private long qYG;
  
  private a$a(a parama) {}
  
  public final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong)
  {
    if (bk.bl(paramString1))
    {
      if (paramString2 == null) {}
      for (paramString2 = "";; paramString2 = paramString2.toString())
      {
        y.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "error query:%s type:%d pagebuf:%s ", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
        return;
      }
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(paramString1);
    ((StringBuffer)localObject).append(paramInt1);
    localObject = com.tencent.mm.a.g.o(((StringBuffer)localObject).toString().getBytes());
    if ((!bk.bl(this.qYF)) && (this.qYF.equals(localObject)) && (System.currentTimeMillis() - this.qYG <= 8000L) && (bk.bl(paramString2)))
    {
      if (this.bKQ)
      {
        y.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[] { paramString1 });
        h.Db(paramInt2).a(this.qYE.cax().tGA, true, aa.b(this.qYE.cax().tcI), this.qYE.cax().tcL);
        return;
      }
      if (this.isRunning)
      {
        if (this.qYE != null) {
          this.qYE.qYH = paramInt2;
        }
        y.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
        return;
      }
      y.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
    }
    y.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[] { paramString1, localObject, Integer.valueOf(paramInt2) });
    if (this.qYE != null) {
      au.Dk().c(this.qYE);
    }
    this.qYF = ((String)localObject);
    this.qYG = System.currentTimeMillis();
    this.isRunning = true;
    this.bKQ = false;
    au.Dk().a(234, this.qYD);
    this.qYE = new b(paramInt1, paramString1, paramString2.getBytes(), paramInt2, paramLong);
    au.Dk().a(this.qYE, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a.a
 * JD-Core Version:    0.7.0.1
 */