package com.tencent.mm.plugin.webview.d.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ev;
import com.tencent.mm.f.a.ev.a;
import com.tencent.mm.f.a.ew;
import com.tencent.mm.f.a.ew.a;
import com.tencent.mm.f.a.ex;
import com.tencent.mm.f.a.ex.a;
import com.tencent.mm.f.a.ey;
import com.tencent.mm.f.a.ey.a;
import com.tencent.mm.f.a.po;
import com.tencent.mm.f.a.po.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a$a
{
  public IListener JqJ;
  private f POP;
  public IListener POQ;
  public IListener POR;
  public IListener POS;
  public IListener POT;
  private String fzM;
  
  public a$a(f paramf, String paramString)
  {
    AppMethodBeat.i(206853);
    this.POP = null;
    this.fzM = "";
    this.POQ = new IListener() {};
    this.POR = new IListener() {};
    this.POS = new IListener() {};
    this.POT = new IListener() {};
    this.JqJ = new IListener() {};
    this.POP = paramf;
    this.fzM = paramString;
    AppMethodBeat.o(206853);
  }
  
  final boolean h(IEvent paramIEvent)
  {
    AppMethodBeat.i(206854);
    if (paramIEvent == null)
    {
      AppMethodBeat.o(206854);
      return false;
    }
    if (this.POP == null)
    {
      Log.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
      AppMethodBeat.o(206854);
      return false;
    }
    Object localObject;
    try
    {
      if ((paramIEvent instanceof ey))
      {
        Log.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
        paramIEvent = (ey)paramIEvent;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.fAQ.fzB);
        ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramIEvent.fAQ.fAI);
        ((Bundle)localObject).putBoolean("exdevice_is_complete", paramIEvent.fAQ.bby);
        this.POP.h(15, (Bundle)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(206854);
        return true;
        if (!(paramIEvent instanceof ex)) {
          break;
        }
        Log.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
        paramIEvent = (ex)paramIEvent;
        if ((!Util.isNullOrNil(paramIEvent.fAP.fzB)) && (!Util.isNullOrNil(paramIEvent.fAP.fzM)))
        {
          localObject = paramIEvent.fAP.data;
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(206854);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.fAP.fzB);
        ((Bundle)localObject).putByteArray("exdevice_data", paramIEvent.fAP.data);
        ((Bundle)localObject).putString("exdevice_brand_name", paramIEvent.fAP.fzM);
        this.POP.h(16, (Bundle)localObject);
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
          if ((paramIEvent instanceof ew))
          {
            Log.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
            paramIEvent = (ew)paramIEvent;
            bool = Util.isNullOrNil(paramIEvent.fAO.fzB);
            if (bool)
            {
              AppMethodBeat.o(206854);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.fAO.fzB);
            ((Bundle)localObject).putBoolean("exdevice_is_bound", paramIEvent.fAO.fzJ);
            this.POP.h(17, (Bundle)localObject);
          }
          else
          {
            if (!(paramIEvent instanceof po)) {
              break;
            }
            paramIEvent = (po)paramIEvent;
            int i = paramIEvent.fOk.op;
            if (i != 2)
            {
              AppMethodBeat.o(206854);
              return true;
            }
            if (!Util.isNullOrNil(paramIEvent.fOk.fKT))
            {
              bool = this.fzM.equals(paramIEvent.fOk.fKT);
              if (bool) {}
            }
            else
            {
              AppMethodBeat.o(206854);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.fOk.fzB);
            ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramIEvent.fOk.fAF);
            this.POP.h(1004, (Bundle)localObject);
          }
        }
      } while (!(paramIEvent instanceof ev));
      paramIEvent = (ev)paramIEvent;
      localObject = new Bundle();
      if (paramIEvent.fAM.fAN != 12) {
        break label563;
      }
    }
    ((Bundle)localObject).putBoolean("exdevice_bt_state", true);
    for (;;)
    {
      this.POP.h(18, (Bundle)localObject);
      break;
      label563:
      ((Bundle)localObject).putBoolean("exdevice_bt_state", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */