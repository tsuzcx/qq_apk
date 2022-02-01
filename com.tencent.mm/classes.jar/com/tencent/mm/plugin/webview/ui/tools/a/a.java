package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.a;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ed.a;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ee.a;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.a;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.ei.a;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.w.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  implements w.a
{
  private static a CCj;
  private static String gMK = "lan";
  public a CCi;
  private int CCk = -1;
  public byte[] CkF = null;
  public boolean CkH = false;
  public String ddh;
  public boolean hasInit = false;
  
  public static a eEO()
  {
    AppMethodBeat.i(80486);
    if (CCj == null) {
      CCj = new a();
    }
    a locala = CCj;
    AppMethodBeat.o(80486);
    return locala;
  }
  
  public final void eAi()
  {
    AppMethodBeat.i(80487);
    ac.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.CkH) });
    if (this.CkH)
    {
      localObject = new fd();
      ((fd)localObject).deX.ddi = false;
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
      this.CkH = false;
    }
    this.hasInit = false;
    if (this.CCi != null)
    {
      com.tencent.mm.sdk.b.a.GpY.d(this.CCi.CkM);
      com.tencent.mm.sdk.b.a.GpY.d(this.CCi.CCl);
      com.tencent.mm.sdk.b.a.GpY.d(this.CCi.CCn);
      com.tencent.mm.sdk.b.a.GpY.d(this.CCi.CCm);
      com.tencent.mm.sdk.b.a.GpY.d(this.CCi.CCo);
      this.CCi = null;
    }
    this.CkF = null;
    Object localObject = new em();
    ((em)localObject).den.ddi = false;
    com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
    AppMethodBeat.o(80487);
  }
  
  public final void eAj() {}
  
  public final void gO(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceLanMgr";
  }
  
  public static final class a
  {
    public c CCl;
    public c CCm;
    public c CCn;
    public c CCo;
    private f CkJ;
    public c CkM;
    private String ddh;
    
    public a(f paramf, String paramString)
    {
      AppMethodBeat.i(80484);
      this.CkJ = null;
      this.ddh = "";
      this.CkM = new c() {};
      this.CCl = new c() {};
      this.CCm = new c() {};
      this.CCn = new c() {};
      this.CCo = new c() {};
      this.CkJ = paramf;
      this.ddh = paramString;
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
      if (this.CkJ == null)
      {
        ac.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
        AppMethodBeat.o(80485);
        return false;
      }
      Object localObject;
      for (;;)
      {
        try
        {
          if (!(paramb instanceof ei)) {
            continue;
          }
          ac.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
          paramb = (ei)paramb;
          bool = bs.isNullOrNil(paramb.dej.cIZ);
          if (bool)
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dej.cIZ);
          ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.dej.dde);
          this.CkJ.g(17, (Bundle)localObject);
        }
        catch (Exception paramb)
        {
          boolean bool;
          ac.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
          continue;
          if (!(paramb instanceof ed)) {
            continue;
          }
          ac.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
          paramb = (ed)paramb;
          if ((bs.isNullOrNil(paramb.deb.cIZ)) || (bs.isNullOrNil(paramb.deb.ddh))) {
            continue;
          }
          localObject = paramb.deb.data;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(80485);
          return true;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.deb.cIZ);
          ((Bundle)localObject).putByteArray("exdevice_data", paramb.deb.data);
          ((Bundle)localObject).putString("exdevice_brand_name", paramb.deb.ddh);
          ((Bundle)localObject).putString("exdevice_device_type", a.gMK);
          this.CkJ.g(16, (Bundle)localObject);
          continue;
          if (!(paramb instanceof ee)) {
            continue;
          }
          ac.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
          paramb = (ee)paramb;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dec.cIZ);
          ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.dec.ded);
          ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.dec.bhH);
          ((Bundle)localObject).putBoolean("exdevice_is_lan_device", true);
          ((Bundle)localObject).putString("exdevice_device_type", a.gMK);
          this.CkJ.g(15, (Bundle)localObject);
          continue;
          if (!(paramb instanceof ef)) {
            continue;
          }
          ac.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
          paramb = (ef)paramb;
          localObject = new Bundle();
          if (paramb.dee.def != true) {
            break;
          }
        }
        AppMethodBeat.o(80485);
        return true;
        if ((paramb instanceof ec))
        {
          ac.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
          paramb = (ec)paramb;
          if (!bs.isNullOrNil(paramb.ddZ.cIZ))
          {
            bool = this.ddh.equals(paramb.ddZ.ddh);
            if (bool) {}
          }
          else
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.ddZ.cIZ);
          ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.ddZ.dea);
          ((Bundle)localObject).putString("exdevice_device_type", a.gMK);
          this.CkJ.g(1004, (Bundle)localObject);
        }
        else
        {
          ((Bundle)localObject).putBoolean("exdevice_lan_state", true);
        }
      }
      for (;;)
      {
        this.CkJ.g(47, (Bundle)localObject);
        break;
        ((Bundle)localObject).putBoolean("exdevice_lan_state", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.a
 * JD-Core Version:    0.7.0.1
 */