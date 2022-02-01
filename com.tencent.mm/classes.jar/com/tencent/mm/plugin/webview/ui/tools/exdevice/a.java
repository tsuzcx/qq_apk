package com.tencent.mm.plugin.webview.ui.tools.exdevice;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.a;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.eg.a;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.eh.a;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.ei.a;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.el.a;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.w.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  implements w.a
{
  private static a EfQ;
  private static String hgH = "lan";
  public byte[] DNK = null;
  public boolean DNM = false;
  public a EfP;
  private int EfR = -1;
  public String doD;
  public boolean hasInit = false;
  
  public static a eTG()
  {
    AppMethodBeat.i(80486);
    if (EfQ == null) {
      EfQ = new a();
    }
    a locala = EfQ;
    AppMethodBeat.o(80486);
    return locala;
  }
  
  public final void eOW()
  {
    AppMethodBeat.i(80487);
    ad.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.DNM) });
    if (this.DNM)
    {
      localObject = new fg();
      ((fg)localObject).dqt.doE = false;
      com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
      this.DNM = false;
    }
    this.hasInit = false;
    if (this.EfP != null)
    {
      com.tencent.mm.sdk.b.a.IbL.d(this.EfP.DNR);
      com.tencent.mm.sdk.b.a.IbL.d(this.EfP.EfS);
      com.tencent.mm.sdk.b.a.IbL.d(this.EfP.EfU);
      com.tencent.mm.sdk.b.a.IbL.d(this.EfP.EfT);
      com.tencent.mm.sdk.b.a.IbL.d(this.EfP.EfV);
      this.EfP = null;
    }
    this.DNK = null;
    Object localObject = new ep();
    ((ep)localObject).dpJ.doE = false;
    com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
    AppMethodBeat.o(80487);
  }
  
  public final void eOX() {}
  
  public final void gT(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceLanMgr";
  }
  
  public static final class a
  {
    private f DNO;
    public c DNR;
    public c EfS;
    public c EfT;
    public c EfU;
    public c EfV;
    private String doD;
    
    public a(f paramf, String paramString)
    {
      AppMethodBeat.i(80484);
      this.DNO = null;
      this.doD = "";
      this.DNR = new c() {};
      this.EfS = new c() {};
      this.EfT = new c() {};
      this.EfU = new c() {};
      this.EfV = new c() {};
      this.DNO = paramf;
      this.doD = paramString;
      AppMethodBeat.o(80484);
    }
    
    final boolean g(b paramb)
    {
      AppMethodBeat.i(80485);
      if (paramb == null)
      {
        AppMethodBeat.o(80485);
        return false;
      }
      if (this.DNO == null)
      {
        ad.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
        AppMethodBeat.o(80485);
        return false;
      }
      Object localObject;
      for (;;)
      {
        try
        {
          if (!(paramb instanceof el)) {
            continue;
          }
          ad.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
          paramb = (el)paramb;
          bool = bt.isNullOrNil(paramb.dpF.cUi);
          if (bool)
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dpF.cUi);
          ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.dpF.doA);
          this.DNO.g(17, (Bundle)localObject);
        }
        catch (Exception paramb)
        {
          boolean bool;
          ad.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
          continue;
          if (!(paramb instanceof eg)) {
            continue;
          }
          ad.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
          paramb = (eg)paramb;
          if ((bt.isNullOrNil(paramb.dpx.cUi)) || (bt.isNullOrNil(paramb.dpx.doD))) {
            continue;
          }
          localObject = paramb.dpx.data;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(80485);
          return true;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dpx.cUi);
          ((Bundle)localObject).putByteArray("exdevice_data", paramb.dpx.data);
          ((Bundle)localObject).putString("exdevice_brand_name", paramb.dpx.doD);
          ((Bundle)localObject).putString("exdevice_device_type", a.hgH);
          this.DNO.g(16, (Bundle)localObject);
          continue;
          if (!(paramb instanceof eh)) {
            continue;
          }
          ad.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
          paramb = (eh)paramb;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dpy.cUi);
          ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.dpy.dpz);
          ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.dpy.bsb);
          ((Bundle)localObject).putBoolean("exdevice_is_lan_device", true);
          ((Bundle)localObject).putString("exdevice_device_type", a.hgH);
          this.DNO.g(15, (Bundle)localObject);
          continue;
          if (!(paramb instanceof ei)) {
            continue;
          }
          ad.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
          paramb = (ei)paramb;
          localObject = new Bundle();
          if (paramb.dpA.dpB != true) {
            break;
          }
        }
        AppMethodBeat.o(80485);
        return true;
        if ((paramb instanceof ef))
        {
          ad.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
          paramb = (ef)paramb;
          if (!bt.isNullOrNil(paramb.dpv.cUi))
          {
            bool = this.doD.equals(paramb.dpv.doD);
            if (bool) {}
          }
          else
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dpv.cUi);
          ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.dpv.dpw);
          ((Bundle)localObject).putString("exdevice_device_type", a.hgH);
          this.DNO.g(1004, (Bundle)localObject);
        }
        else
        {
          ((Bundle)localObject).putBoolean("exdevice_lan_state", true);
        }
      }
      for (;;)
      {
        this.DNO.g(47, (Bundle)localObject);
        break;
        ((Bundle)localObject).putBoolean("exdevice_lan_state", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.exdevice.a
 * JD-Core Version:    0.7.0.1
 */