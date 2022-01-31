package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import com.tencent.mm.h.a.dt;
import com.tencent.mm.h.a.ec;
import com.tencent.mm.h.a.et;
import com.tencent.mm.pluginsdk.ui.tools.r.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements r.a
{
  private static String dOM = "lan";
  private static a rta;
  public String bJw;
  public boolean hasInit = false;
  public a.a rsZ;
  public byte[] rtb = null;
  private int rtc = -1;
  public boolean rtd = false;
  
  public static a cfh()
  {
    if (rta == null) {
      rta = new a();
    }
    return rta;
  }
  
  public final void cfi()
  {
    y.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.rtd) });
    if (this.rtd)
    {
      localObject = new et();
      ((et)localObject).bLm.bJx = false;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      this.rtd = false;
    }
    this.hasInit = false;
    if (this.rsZ != null)
    {
      com.tencent.mm.sdk.b.a.udP.d(this.rsZ.rte);
      com.tencent.mm.sdk.b.a.udP.d(this.rsZ.rtf);
      com.tencent.mm.sdk.b.a.udP.d(this.rsZ.rth);
      com.tencent.mm.sdk.b.a.udP.d(this.rsZ.rtg);
      com.tencent.mm.sdk.b.a.udP.d(this.rsZ.rti);
      this.rsZ = null;
    }
    this.rtb = null;
    Object localObject = new ec();
    ((ec)localObject).bKC.bJx = false;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
  }
  
  public final void cfj() {}
  
  public final void eA(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceLanMgr";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.a
 * JD-Core Version:    0.7.0.1
 */