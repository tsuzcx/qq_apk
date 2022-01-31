package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.eg.b;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.em.b;
import com.tencent.mm.pluginsdk.ui.tools.t.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  implements t.a
{
  private static final byte[] lFC = { -2, 1, 1 };
  private static b vjr;
  public String cqQ;
  public boolean hasInit = false;
  public byte[] vjh = null;
  public boolean vjj = false;
  public b.a vjq;
  public int vjs = -1;
  public boolean vjt = false;
  
  public static boolean bH(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 9) && (paramArrayOfByte[(paramArrayOfByte.length - 7)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 8)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 9)] == -2);
  }
  
  public static b dft()
  {
    AppMethodBeat.i(8329);
    if (vjr == null) {
      vjr = new b();
    }
    b localb = vjr;
    AppMethodBeat.o(8329);
    return localb;
  }
  
  public final void dfr()
  {
    AppMethodBeat.i(8330);
    ab.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.vjj) });
    if (this.vjj)
    {
      localObject = new eg();
      ((eg)localObject).crX.cqR = false;
      ((eg)localObject).crX.cqQ = this.cqQ;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if (!((eg)localObject).crY.cqS) {
        ab.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
      }
      this.vjj = false;
    }
    this.hasInit = false;
    if (this.vjq != null)
    {
      a.ymk.d(this.vjq.vju);
      a.ymk.d(this.vjq.vjv);
      a.ymk.d(this.vjq.vjw);
      a.ymk.d(this.vjq.vjk);
      a.ymk.d(this.vjq.qRq);
      this.vjq = null;
    }
    this.vjh = null;
    Object localObject = new em();
    ((em)localObject).cso.bYu = "";
    ((em)localObject).cso.direction = 0;
    ((em)localObject).cso.clear = true;
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    ab.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[] { Boolean.valueOf(((em)localObject).csp.cqS) });
    AppMethodBeat.o(8330);
  }
  
  public final void dfs() {}
  
  public final void fz(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceMgr";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.b
 * JD-Core Version:    0.7.0.1
 */