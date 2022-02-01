package com.tencent.mm.plugin.webview.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.em.b;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.es.b;
import com.tencent.mm.pluginsdk.ui.tools.w.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  implements w.a
{
  private static a ASr;
  private static final byte[] oWn = { -2, 1, 1 };
  public a.a ASq;
  public byte[] ASs = null;
  public int ASt = -1;
  public boolean ASu = false;
  public boolean ASv = false;
  public String dfM;
  public boolean hasInit = false;
  
  public static boolean bZ(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 9) && (paramArrayOfByte[(paramArrayOfByte.length - 7)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 8)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 9)] == -2);
  }
  
  public static a ekL()
  {
    AppMethodBeat.i(189712);
    if (ASr == null) {
      ASr = new a();
    }
    a locala = ASr;
    AppMethodBeat.o(189712);
    return locala;
  }
  
  public final void ekM()
  {
    AppMethodBeat.i(189713);
    ad.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.ASu) });
    if (this.ASu)
    {
      localObject = new em();
      ((em)localObject).dgT.dfN = false;
      ((em)localObject).dgT.dfM = this.dfM;
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
      if (!((em)localObject).dgU.dfO) {
        ad.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
      }
      this.ASu = false;
    }
    this.hasInit = false;
    if (this.ASq != null)
    {
      com.tencent.mm.sdk.b.a.ESL.d(this.ASq.ASx);
      com.tencent.mm.sdk.b.a.ESL.d(this.ASq.ASy);
      com.tencent.mm.sdk.b.a.ESL.d(this.ASq.ASA);
      com.tencent.mm.sdk.b.a.ESL.d(this.ASq.ASz);
      com.tencent.mm.sdk.b.a.ESL.d(this.ASq.wqf);
      this.ASq = null;
    }
    this.ASs = null;
    Object localObject = new es();
    ((es)localObject).dhk.cLR = "";
    ((es)localObject).dhk.direction = 0;
    ((es)localObject).dhk.clear = true;
    com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
    ad.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[] { Boolean.valueOf(((es)localObject).dhl.dfO) });
    AppMethodBeat.o(189713);
  }
  
  public final void ekN() {}
  
  public final void gD(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceMgr";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a.a
 * JD-Core Version:    0.7.0.1
 */