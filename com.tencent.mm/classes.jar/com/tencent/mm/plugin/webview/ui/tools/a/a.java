package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.pluginsdk.ui.tools.t.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  implements t.a
{
  private static String eQs = "lan";
  private static a vjg;
  public String cqQ;
  public boolean hasInit = false;
  public a.a vjf;
  public byte[] vjh = null;
  private int vji = -1;
  public boolean vjj = false;
  
  public static a dfq()
  {
    AppMethodBeat.i(8315);
    if (vjg == null) {
      vjg = new a();
    }
    a locala = vjg;
    AppMethodBeat.o(8315);
    return locala;
  }
  
  public final void dfr()
  {
    AppMethodBeat.i(8316);
    ab.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.vjj) });
    if (this.vjj)
    {
      localObject = new ew();
      ((ew)localObject).csG.cqR = false;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      this.vjj = false;
    }
    this.hasInit = false;
    if (this.vjf != null)
    {
      com.tencent.mm.sdk.b.a.ymk.d(this.vjf.vjk);
      com.tencent.mm.sdk.b.a.ymk.d(this.vjf.vjl);
      com.tencent.mm.sdk.b.a.ymk.d(this.vjf.vjn);
      com.tencent.mm.sdk.b.a.ymk.d(this.vjf.vjm);
      com.tencent.mm.sdk.b.a.ymk.d(this.vjf.vjo);
      this.vjf = null;
    }
    this.vjh = null;
    Object localObject = new ef();
    ((ef)localObject).crW.cqR = false;
    com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    AppMethodBeat.o(8316);
  }
  
  public final void dfs() {}
  
  public final void fz(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceLanMgr";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.a
 * JD-Core Version:    0.7.0.1
 */