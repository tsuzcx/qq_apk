package com.tencent.mm.plugin.webview.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.fb;
import com.tencent.mm.f.a.fb.b;
import com.tencent.mm.f.a.fh;
import com.tencent.mm.f.a.fh.b;
import com.tencent.mm.pluginsdk.ui.tools.aa.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements aa.a
{
  private static a POK;
  private static final byte[] vgk = { -2, 1, 1 };
  public a.a POJ;
  public byte[] POL = null;
  public int POM = -1;
  public boolean PON = false;
  public boolean POO = false;
  public String fzM;
  public boolean hasInit = false;
  
  public static boolean cQ(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 9) && (paramArrayOfByte[(paramArrayOfByte.length - 7)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 8)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 9)] == -2);
  }
  
  public static a gUm()
  {
    AppMethodBeat.i(207482);
    if (POK == null) {
      POK = new a();
    }
    a locala = POK;
    AppMethodBeat.o(207482);
    return locala;
  }
  
  public final void gUn()
  {
    AppMethodBeat.i(207484);
    Log.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.PON) });
    if (this.PON)
    {
      localObject = new fb();
      ((fb)localObject).fAT.fzN = false;
      ((fb)localObject).fAT.fzM = this.fzM;
      EventCenter.instance.publish((IEvent)localObject);
      if (!((fb)localObject).fAU.fzO) {
        Log.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
      }
      this.PON = false;
    }
    this.hasInit = false;
    if (this.POJ != null)
    {
      EventCenter.instance.removeListener(this.POJ.POQ);
      EventCenter.instance.removeListener(this.POJ.POR);
      EventCenter.instance.removeListener(this.POJ.POT);
      EventCenter.instance.removeListener(this.POJ.POS);
      EventCenter.instance.removeListener(this.POJ.JqJ);
      this.POJ = null;
    }
    this.POL = null;
    Object localObject = new fh();
    ((fh)localObject).fBj.fzB = "";
    ((fh)localObject).fBj.direction = 0;
    ((fh)localObject).fBj.clear = true;
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[] { Boolean.valueOf(((fh)localObject).fBk.fzO) });
    AppMethodBeat.o(207484);
  }
  
  public final void gUo() {}
  
  public final String getName()
  {
    return "WebViewExDeviceMgr";
  }
  
  public final void iZ(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.a.a
 * JD-Core Version:    0.7.0.1
 */