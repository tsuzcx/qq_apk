package com.tencent.mm.plugin.webview.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.er.b;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.g.a.ex.b;
import com.tencent.mm.pluginsdk.ui.tools.w.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  implements w.a
{
  private static a EfI;
  private static final byte[] qjI = { -2, 1, 1 };
  public a.a EfH;
  public byte[] EfJ = null;
  public int EfK = -1;
  public boolean EfL = false;
  public boolean EfM = false;
  public String dpI;
  public boolean hasInit = false;
  
  public static boolean ci(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 9) && (paramArrayOfByte[(paramArrayOfByte.length - 7)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 8)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 9)] == -2);
  }
  
  public static a eSG()
  {
    AppMethodBeat.i(213772);
    if (EfI == null) {
      EfI = new a();
    }
    a locala = EfI;
    AppMethodBeat.o(213772);
    return locala;
  }
  
  public final void eSH()
  {
    AppMethodBeat.i(213773);
    ae.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.EfL) });
    if (this.EfL)
    {
      localObject = new er();
      ((er)localObject).dqP.dpJ = false;
      ((er)localObject).dqP.dpI = this.dpI;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
      if (!((er)localObject).dqQ.dpK) {
        ae.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
      }
      this.EfL = false;
    }
    this.hasInit = false;
    if (this.EfH != null)
    {
      com.tencent.mm.sdk.b.a.IvT.d(this.EfH.EfO);
      com.tencent.mm.sdk.b.a.IvT.d(this.EfH.EfP);
      com.tencent.mm.sdk.b.a.IvT.d(this.EfH.EfR);
      com.tencent.mm.sdk.b.a.IvT.d(this.EfH.EfQ);
      com.tencent.mm.sdk.b.a.IvT.d(this.EfH.zgq);
      this.EfH = null;
    }
    this.EfJ = null;
    Object localObject = new ex();
    ((ex)localObject).drg.cVh = "";
    ((ex)localObject).drg.direction = 0;
    ((ex)localObject).drg.clear = true;
    com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
    ae.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[] { Boolean.valueOf(((ex)localObject).drh.dpK) });
    AppMethodBeat.o(213773);
  }
  
  public final void eSI() {}
  
  public final void gZ(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceMgr";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a.a
 * JD-Core Version:    0.7.0.1
 */