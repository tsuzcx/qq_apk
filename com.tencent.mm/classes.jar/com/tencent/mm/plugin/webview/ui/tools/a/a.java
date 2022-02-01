package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.pluginsdk.ui.tools.w.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  implements w.a
{
  private static a BjV;
  private static String glX = "lan";
  public byte[] ASs = null;
  public boolean ASu = false;
  public a.a BjU;
  private int BjW = -1;
  public String dfM;
  public boolean hasInit = false;
  
  public static a ept()
  {
    AppMethodBeat.i(80486);
    if (BjV == null) {
      BjV = new a();
    }
    a locala = BjV;
    AppMethodBeat.o(80486);
    return locala;
  }
  
  public final void ekM()
  {
    AppMethodBeat.i(80487);
    ad.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.ASu) });
    if (this.ASu)
    {
      localObject = new fc();
      ((fc)localObject).dhC.dfN = false;
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
      this.ASu = false;
    }
    this.hasInit = false;
    if (this.BjU != null)
    {
      com.tencent.mm.sdk.b.a.ESL.d(this.BjU.ASz);
      com.tencent.mm.sdk.b.a.ESL.d(this.BjU.BjX);
      com.tencent.mm.sdk.b.a.ESL.d(this.BjU.BjZ);
      com.tencent.mm.sdk.b.a.ESL.d(this.BjU.BjY);
      com.tencent.mm.sdk.b.a.ESL.d(this.BjU.Bka);
      this.BjU = null;
    }
    this.ASs = null;
    Object localObject = new el();
    ((el)localObject).dgS.dfN = false;
    com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
    AppMethodBeat.o(80487);
  }
  
  public final void ekN() {}
  
  public final void gD(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceLanMgr";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.a
 * JD-Core Version:    0.7.0.1
 */