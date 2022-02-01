package com.tencent.mm.plugin.webview.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.eu.b;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.fa.b;
import com.tencent.mm.pluginsdk.ui.tools.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements y.a
{
  private static a ISr;
  private static final byte[] rAD = { -2, 1, 1 };
  public a.a ISq;
  public byte[] ISs = null;
  public int ISt = -1;
  public boolean ISu = false;
  public boolean ISv = false;
  public String brandName;
  public boolean hasInit = false;
  
  public static boolean cz(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 9) && (paramArrayOfByte[(paramArrayOfByte.length - 7)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 8)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 9)] == -2);
  }
  
  public static a gbs()
  {
    AppMethodBeat.i(224451);
    if (ISr == null) {
      ISr = new a();
    }
    a locala = ISr;
    AppMethodBeat.o(224451);
    return locala;
  }
  
  public final void gbt()
  {
    AppMethodBeat.i(224452);
    Log.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.ISu) });
    if (this.ISu)
    {
      localObject = new eu();
      ((eu)localObject).dIc.dGW = false;
      ((eu)localObject).dIc.brandName = this.brandName;
      EventCenter.instance.publish((IEvent)localObject);
      if (!((eu)localObject).dId.dGX) {
        Log.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
      }
      this.ISu = false;
    }
    this.hasInit = false;
    if (this.ISq != null)
    {
      EventCenter.instance.removeListener(this.ISq.ISx);
      EventCenter.instance.removeListener(this.ISq.ISy);
      EventCenter.instance.removeListener(this.ISq.ISA);
      EventCenter.instance.removeListener(this.ISq.ISz);
      EventCenter.instance.removeListener(this.ISq.Dlh);
      this.ISq = null;
    }
    this.ISs = null;
    Object localObject = new fa();
    ((fa)localObject).dIs.dGL = "";
    ((fa)localObject).dIs.direction = 0;
    ((fa)localObject).dIs.clear = true;
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[] { Boolean.valueOf(((fa)localObject).dIt.dGX) });
    AppMethodBeat.o(224452);
  }
  
  public final void gbu() {}
  
  public final String getName()
  {
    return "WebViewExDeviceMgr";
  }
  
  public final void hU(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.a.a
 * JD-Core Version:    0.7.0.1
 */