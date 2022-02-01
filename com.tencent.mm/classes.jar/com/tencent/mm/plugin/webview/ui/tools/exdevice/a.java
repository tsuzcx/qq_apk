package com.tencent.mm.plugin.webview.ui.tools.exdevice;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.ej.a;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.ek.a;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.el.a;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.em.a;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ep.a;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements y.a
{
  private static a JmC;
  private static String ics = "lan";
  public byte[] ISs = null;
  public boolean ISu = false;
  public a JmB;
  private int JmD = -1;
  public String brandName;
  public boolean hasInit = false;
  
  public static a ggx()
  {
    AppMethodBeat.i(80486);
    if (JmC == null) {
      JmC = new a();
    }
    a locala = JmC;
    AppMethodBeat.o(80486);
    return locala;
  }
  
  public final void gbt()
  {
    AppMethodBeat.i(80487);
    Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.ISu) });
    if (this.ISu)
    {
      localObject = new fk();
      ((fk)localObject).dIK.dGW = false;
      EventCenter.instance.publish((IEvent)localObject);
      this.ISu = false;
    }
    this.hasInit = false;
    if (this.JmB != null)
    {
      EventCenter.instance.removeListener(this.JmB.ISz);
      EventCenter.instance.removeListener(this.JmB.JmE);
      EventCenter.instance.removeListener(this.JmB.JmG);
      EventCenter.instance.removeListener(this.JmB.JmF);
      EventCenter.instance.removeListener(this.JmB.JmH);
      this.JmB = null;
    }
    this.ISs = null;
    Object localObject = new et();
    ((et)localObject).dIb.dGW = false;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(80487);
  }
  
  public final void gbu() {}
  
  public final String getName()
  {
    return "WebViewExDeviceLanMgr";
  }
  
  public final void hU(Context paramContext) {}
  
  public static final class a
  {
    private f ISw;
    public IListener ISz;
    public IListener JmE;
    public IListener JmF;
    public IListener JmG;
    public IListener JmH;
    private String brandName;
    
    public a(f paramf, String paramString)
    {
      AppMethodBeat.i(80484);
      this.ISw = null;
      this.brandName = "";
      this.ISz = new IListener() {};
      this.JmE = new IListener() {};
      this.JmF = new IListener() {};
      this.JmG = new IListener() {};
      this.JmH = new IListener() {};
      this.ISw = paramf;
      this.brandName = paramString;
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
      if (this.ISw == null)
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
          if (!(paramIEvent instanceof ep)) {
            continue;
          }
          Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
          paramIEvent = (ep)paramIEvent;
          bool = Util.isNullOrNil(paramIEvent.dHX.dGL);
          if (bool)
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.dHX.dGL);
          ((Bundle)localObject).putBoolean("exdevice_is_bound", paramIEvent.dHX.dGT);
          this.ISw.f(17, (Bundle)localObject);
        }
        catch (Exception paramIEvent)
        {
          boolean bool;
          Log.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramIEvent.getMessage() });
          continue;
          if (!(paramIEvent instanceof ek)) {
            continue;
          }
          Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
          paramIEvent = (ek)paramIEvent;
          if ((Util.isNullOrNil(paramIEvent.dHP.dGL)) || (Util.isNullOrNil(paramIEvent.dHP.brandName))) {
            continue;
          }
          localObject = paramIEvent.dHP.data;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(80485);
          return true;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.dHP.dGL);
          ((Bundle)localObject).putByteArray("exdevice_data", paramIEvent.dHP.data);
          ((Bundle)localObject).putString("exdevice_brand_name", paramIEvent.dHP.brandName);
          ((Bundle)localObject).putString("exdevice_device_type", a.ics);
          this.ISw.f(16, (Bundle)localObject);
          continue;
          if (!(paramIEvent instanceof el)) {
            continue;
          }
          Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
          paramIEvent = (el)paramIEvent;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.dHQ.dGL);
          ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramIEvent.dHQ.dHR);
          ((Bundle)localObject).putBoolean("exdevice_is_complete", paramIEvent.dHQ.brW);
          ((Bundle)localObject).putBoolean("exdevice_is_lan_device", true);
          ((Bundle)localObject).putString("exdevice_device_type", a.ics);
          this.ISw.f(15, (Bundle)localObject);
          continue;
          if (!(paramIEvent instanceof em)) {
            continue;
          }
          Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
          paramIEvent = (em)paramIEvent;
          localObject = new Bundle();
          if (paramIEvent.dHS.dHT != true) {
            break;
          }
        }
        AppMethodBeat.o(80485);
        return true;
        if ((paramIEvent instanceof ej))
        {
          Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
          paramIEvent = (ej)paramIEvent;
          if (!Util.isNullOrNil(paramIEvent.dHN.dGL))
          {
            bool = this.brandName.equals(paramIEvent.dHN.brandName);
            if (bool) {}
          }
          else
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.dHN.dGL);
          ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramIEvent.dHN.dHO);
          ((Bundle)localObject).putString("exdevice_device_type", a.ics);
          this.ISw.f(1004, (Bundle)localObject);
        }
        else
        {
          ((Bundle)localObject).putBoolean("exdevice_lan_state", true);
        }
      }
      for (;;)
      {
        this.ISw.f(47, (Bundle)localObject);
        break;
        ((Bundle)localObject).putBoolean("exdevice_lan_state", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.exdevice.a
 * JD-Core Version:    0.7.0.1
 */