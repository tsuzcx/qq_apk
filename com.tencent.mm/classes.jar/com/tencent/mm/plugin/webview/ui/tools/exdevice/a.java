package com.tencent.mm.plugin.webview.ui.tools.exdevice;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.fb;
import com.tencent.mm.autogen.a.fb.a;
import com.tencent.mm.autogen.a.fc;
import com.tencent.mm.autogen.a.fc.a;
import com.tencent.mm.autogen.a.fd;
import com.tencent.mm.autogen.a.fd.a;
import com.tencent.mm.autogen.a.fe;
import com.tencent.mm.autogen.a.fe.a;
import com.tencent.mm.autogen.a.fh;
import com.tencent.mm.autogen.a.fh.a;
import com.tencent.mm.autogen.a.fl;
import com.tencent.mm.autogen.a.gc;
import com.tencent.mm.pluginsdk.ui.tools.z.a;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements z.a
{
  private static a XbL;
  private static String nsC = "lan";
  public byte[] WEX = null;
  public boolean WEZ = false;
  public a XbK;
  private int XbM = -1;
  public String hEy;
  public boolean hasInit = false;
  
  public static a izP()
  {
    AppMethodBeat.i(80486);
    if (XbL == null) {
      XbL = new a();
    }
    a locala = XbL;
    AppMethodBeat.o(80486);
    return locala;
  }
  
  public final String getName()
  {
    return "WebViewExDeviceLanMgr";
  }
  
  public final void itU()
  {
    AppMethodBeat.i(80487);
    Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.WEZ) });
    if (this.WEZ)
    {
      localObject = new gc();
      ((gc)localObject).hGq.hEz = false;
      ((gc)localObject).publish();
      this.WEZ = false;
    }
    this.hasInit = false;
    if (this.XbK != null)
    {
      this.XbK.WFe.dead();
      this.XbK.XbN.dead();
      this.XbK.XbP.dead();
      this.XbK.XbO.dead();
      this.XbK.XbQ.dead();
      this.XbK = null;
    }
    this.WEX = null;
    Object localObject = new fl();
    ((fl)localObject).hFF.hEz = false;
    ((fl)localObject).publish();
    AppMethodBeat.o(80487);
  }
  
  public final void itV() {}
  
  public final void kP(Context paramContext) {}
  
  public static final class a
  {
    private com.tencent.mm.plugin.webview.stub.f WFb;
    public IListener WFe;
    public IListener XbN;
    public IListener XbO;
    public IListener XbP;
    public IListener XbQ;
    private String hEy;
    
    public a(com.tencent.mm.plugin.webview.stub.f paramf, String paramString)
    {
      AppMethodBeat.i(80484);
      this.WFb = null;
      this.hEy = "";
      this.WFe = new WebViewExDeviceLanMgr.WVExDeviceEventListener.1(this, com.tencent.mm.app.f.hfK);
      this.XbN = new WebViewExDeviceLanMgr.WVExDeviceEventListener.2(this, com.tencent.mm.app.f.hfK);
      this.XbO = new WebViewExDeviceLanMgr.WVExDeviceEventListener.3(this, com.tencent.mm.app.f.hfK);
      this.XbP = new WebViewExDeviceLanMgr.WVExDeviceEventListener.4(this, com.tencent.mm.app.f.hfK);
      this.XbQ = new WebViewExDeviceLanMgr.WVExDeviceEventListener.5(this, com.tencent.mm.app.f.hfK);
      this.WFb = paramf;
      this.hEy = paramString;
      AppMethodBeat.o(80484);
    }
    
    final boolean h(IEvent paramIEvent)
    {
      AppMethodBeat.i(80485);
      if (paramIEvent == null)
      {
        AppMethodBeat.o(80485);
        return false;
      }
      if (this.WFb == null)
      {
        Log.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
        AppMethodBeat.o(80485);
        return false;
      }
      Object localObject;
      for (;;)
      {
        try
        {
          if (!(paramIEvent instanceof fh)) {
            continue;
          }
          Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
          paramIEvent = (fh)paramIEvent;
          bool = Util.isNullOrNil(paramIEvent.hFB.hEl);
          if (bool)
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.hFB.hEl);
          ((Bundle)localObject).putBoolean("exdevice_is_bound", paramIEvent.hFB.hEv);
          this.WFb.i(17, (Bundle)localObject);
        }
        catch (Exception paramIEvent)
        {
          boolean bool;
          Log.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramIEvent.getMessage() });
          continue;
          if (!(paramIEvent instanceof fc)) {
            continue;
          }
          Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
          paramIEvent = (fc)paramIEvent;
          if ((Util.isNullOrNil(paramIEvent.hFt.hEl)) || (Util.isNullOrNil(paramIEvent.hFt.hEy))) {
            continue;
          }
          localObject = paramIEvent.hFt.data;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(80485);
          return true;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.hFt.hEl);
          ((Bundle)localObject).putByteArray("exdevice_data", paramIEvent.hFt.data);
          ((Bundle)localObject).putString("exdevice_brand_name", paramIEvent.hFt.hEy);
          ((Bundle)localObject).putString("exdevice_device_type", a.nsC);
          this.WFb.i(16, (Bundle)localObject);
          continue;
          if (!(paramIEvent instanceof fd)) {
            continue;
          }
          Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
          paramIEvent = (fd)paramIEvent;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.hFu.hEl);
          ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramIEvent.hFu.hFv);
          ((Bundle)localObject).putBoolean("exdevice_is_complete", paramIEvent.hFu.cVt);
          ((Bundle)localObject).putBoolean("exdevice_is_lan_device", true);
          ((Bundle)localObject).putString("exdevice_device_type", a.nsC);
          this.WFb.i(15, (Bundle)localObject);
          continue;
          if (!(paramIEvent instanceof fe)) {
            continue;
          }
          Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
          paramIEvent = (fe)paramIEvent;
          localObject = new Bundle();
          if (paramIEvent.hFw.hFx != true) {
            break;
          }
        }
        AppMethodBeat.o(80485);
        return true;
        if ((paramIEvent instanceof fb))
        {
          Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
          paramIEvent = (fb)paramIEvent;
          if (!Util.isNullOrNil(paramIEvent.hFr.hEl))
          {
            bool = this.hEy.equals(paramIEvent.hFr.hEy);
            if (bool) {}
          }
          else
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.hFr.hEl);
          ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramIEvent.hFr.hFs);
          ((Bundle)localObject).putString("exdevice_device_type", a.nsC);
          this.WFb.i(1004, (Bundle)localObject);
        }
        else
        {
          ((Bundle)localObject).putBoolean("exdevice_lan_state", true);
        }
      }
      for (;;)
      {
        this.WFb.i(47, (Bundle)localObject);
        break;
        ((Bundle)localObject).putBoolean("exdevice_lan_state", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.exdevice.a
 * JD-Core Version:    0.7.0.1
 */