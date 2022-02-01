package com.tencent.mm.plugin.webview.d.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.eo.a;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ep.a;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.eq.a;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.er.a;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.or.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a$a
{
  public IListener Dlh;
  public IListener ISA;
  private f ISw;
  public IListener ISx;
  public IListener ISy;
  public IListener ISz;
  private String brandName;
  
  public a$a(f paramf, String paramString)
  {
    AppMethodBeat.i(224449);
    this.ISw = null;
    this.brandName = "";
    this.ISx = new IListener() {};
    this.ISy = new IListener() {};
    this.ISz = new IListener() {};
    this.ISA = new IListener() {};
    this.Dlh = new IListener() {};
    this.ISw = paramf;
    this.brandName = paramString;
    AppMethodBeat.o(224449);
  }
  
  final boolean h(IEvent paramIEvent)
  {
    AppMethodBeat.i(224450);
    if (paramIEvent == null)
    {
      AppMethodBeat.o(224450);
      return false;
    }
    if (this.ISw == null)
    {
      Log.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
      AppMethodBeat.o(224450);
      return false;
    }
    Object localObject;
    try
    {
      if ((paramIEvent instanceof er))
      {
        Log.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
        paramIEvent = (er)paramIEvent;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.dHZ.dGL);
        ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramIEvent.dHZ.dHR);
        ((Bundle)localObject).putBoolean("exdevice_is_complete", paramIEvent.dHZ.brW);
        this.ISw.f(15, (Bundle)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(224450);
        return true;
        if (!(paramIEvent instanceof eq)) {
          break;
        }
        Log.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
        paramIEvent = (eq)paramIEvent;
        if ((!Util.isNullOrNil(paramIEvent.dHY.dGL)) && (!Util.isNullOrNil(paramIEvent.dHY.brandName)))
        {
          localObject = paramIEvent.dHY.data;
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(224450);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.dHY.dGL);
        ((Bundle)localObject).putByteArray("exdevice_data", paramIEvent.dHY.data);
        ((Bundle)localObject).putString("exdevice_brand_name", paramIEvent.dHY.brandName);
        this.ISw.f(16, (Bundle)localObject);
      }
    }
    catch (Exception paramIEvent)
    {
      do
      {
        for (;;)
        {
          Log.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramIEvent.getMessage() });
          continue;
          boolean bool;
          if ((paramIEvent instanceof ep))
          {
            Log.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
            paramIEvent = (ep)paramIEvent;
            bool = Util.isNullOrNil(paramIEvent.dHX.dGL);
            if (bool)
            {
              AppMethodBeat.o(224450);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.dHX.dGL);
            ((Bundle)localObject).putBoolean("exdevice_is_bound", paramIEvent.dHX.dGT);
            this.ISw.f(17, (Bundle)localObject);
          }
          else
          {
            if (!(paramIEvent instanceof or)) {
              break;
            }
            paramIEvent = (or)paramIEvent;
            int i = paramIEvent.dUI.op;
            if (i != 2)
            {
              AppMethodBeat.o(224450);
              return true;
            }
            if (!Util.isNullOrNil(paramIEvent.dUI.dRD))
            {
              bool = this.brandName.equals(paramIEvent.dUI.dRD);
              if (bool) {}
            }
            else
            {
              AppMethodBeat.o(224450);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.dUI.dGL);
            ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramIEvent.dUI.dHO);
            this.ISw.f(1004, (Bundle)localObject);
          }
        }
      } while (!(paramIEvent instanceof eo));
      paramIEvent = (eo)paramIEvent;
      localObject = new Bundle();
      if (paramIEvent.dHV.dHW != 12) {
        break label563;
      }
    }
    ((Bundle)localObject).putBoolean("exdevice_bt_state", true);
    for (;;)
    {
      this.ISw.f(18, (Bundle)localObject);
      break;
      label563:
      ((Bundle)localObject).putBoolean("exdevice_bt_state", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */