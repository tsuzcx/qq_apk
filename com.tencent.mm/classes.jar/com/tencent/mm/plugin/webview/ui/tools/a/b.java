package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import com.tencent.mm.h.a.dz;
import com.tencent.mm.h.a.ea;
import com.tencent.mm.h.a.ed;
import com.tencent.mm.h.a.ed.b;
import com.tencent.mm.h.a.ej;
import com.tencent.mm.h.a.ej.b;
import com.tencent.mm.h.a.lg;
import com.tencent.mm.pluginsdk.ui.tools.r.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements r.a
{
  private static final byte[] jwd = { -2, 1, 1 };
  private static b rtl;
  public String bJw;
  public boolean hasInit = false;
  public byte[] rtb = null;
  public boolean rtd = false;
  public b.a rtk;
  public int rtm = -1;
  public boolean rtn = false;
  
  public static boolean bg(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 9) && (paramArrayOfByte[(paramArrayOfByte.length - 7)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 8)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 9)] == -2);
  }
  
  public static b cfk()
  {
    if (rtl == null) {
      rtl = new b();
    }
    return rtl;
  }
  
  public final void cfi()
  {
    y.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.rtd) });
    if (this.rtd)
    {
      localObject = new ed();
      ((ed)localObject).bKD.bJx = false;
      ((ed)localObject).bKD.bJw = this.bJw;
      a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      if (!((ed)localObject).bKE.bJy) {
        y.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
      }
      this.rtd = false;
    }
    this.hasInit = false;
    if (this.rtk != null)
    {
      a.udP.d(this.rtk.rto);
      a.udP.d(this.rtk.rtp);
      a.udP.d(this.rtk.rtq);
      a.udP.d(this.rtk.rte);
      a.udP.d(this.rtk.odk);
      this.rtk = null;
    }
    this.rtb = null;
    Object localObject = new ej();
    ((ej)localObject).bKU.bwK = "";
    ((ej)localObject).bKU.direction = 0;
    ((ej)localObject).bKU.clear = true;
    a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    y.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[] { Boolean.valueOf(((ej)localObject).bKV.bJy) });
  }
  
  public final void cfj() {}
  
  public final void eA(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceMgr";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.b
 * JD-Core Version:    0.7.0.1
 */