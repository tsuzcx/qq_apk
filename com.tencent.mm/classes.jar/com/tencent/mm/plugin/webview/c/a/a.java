package com.tencent.mm.plugin.webview.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.eq.b;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.g.a.ew.b;
import com.tencent.mm.pluginsdk.ui.tools.w.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  implements w.a
{
  private static a DNJ;
  private static final byte[] qdd = { -2, 1, 1 };
  public a.a DNI;
  public byte[] DNK = null;
  public int DNL = -1;
  public boolean DNM = false;
  public boolean DNN = false;
  public String doD;
  public boolean hasInit = false;
  
  public static boolean cf(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 9) && (paramArrayOfByte[(paramArrayOfByte.length - 7)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 8)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 9)] == -2);
  }
  
  public static a eOV()
  {
    AppMethodBeat.i(213943);
    if (DNJ == null) {
      DNJ = new a();
    }
    a locala = DNJ;
    AppMethodBeat.o(213943);
    return locala;
  }
  
  public final void eOW()
  {
    AppMethodBeat.i(213944);
    ad.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.DNM) });
    if (this.DNM)
    {
      localObject = new eq();
      ((eq)localObject).dpK.doE = false;
      ((eq)localObject).dpK.doD = this.doD;
      com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
      if (!((eq)localObject).dpL.doF) {
        ad.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
      }
      this.DNM = false;
    }
    this.hasInit = false;
    if (this.DNI != null)
    {
      com.tencent.mm.sdk.b.a.IbL.d(this.DNI.DNP);
      com.tencent.mm.sdk.b.a.IbL.d(this.DNI.DNQ);
      com.tencent.mm.sdk.b.a.IbL.d(this.DNI.DNS);
      com.tencent.mm.sdk.b.a.IbL.d(this.DNI.DNR);
      com.tencent.mm.sdk.b.a.IbL.d(this.DNI.yQg);
      this.DNI = null;
    }
    this.DNK = null;
    Object localObject = new ew();
    ((ew)localObject).dqb.cUi = "";
    ((ew)localObject).dqb.direction = 0;
    ((ew)localObject).dqb.clear = true;
    com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
    ad.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[] { Boolean.valueOf(((ew)localObject).dqc.doF) });
    AppMethodBeat.o(213944);
  }
  
  public final void eOX() {}
  
  public final void gT(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceMgr";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a.a
 * JD-Core Version:    0.7.0.1
 */