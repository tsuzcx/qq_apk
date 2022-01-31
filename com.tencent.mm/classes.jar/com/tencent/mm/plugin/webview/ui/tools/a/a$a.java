package com.tencent.mm.plugin.webview.ui.tools.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dv.a;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dw.a;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.a;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dy.a;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a$a
{
  private String cqQ;
  private e uWu;
  public c vjk;
  public c vjl;
  public c vjm;
  public c vjn;
  public c vjo;
  
  public a$a(e parame, String paramString)
  {
    AppMethodBeat.i(8313);
    this.uWu = null;
    this.cqQ = "";
    this.vjk = new a.a.1(this);
    this.vjl = new a.a.2(this);
    this.vjm = new a.a.3(this);
    this.vjn = new a.a.4(this);
    this.vjo = new a.a.5(this);
    this.uWu = parame;
    this.cqQ = paramString;
    AppMethodBeat.o(8313);
  }
  
  final boolean g(b paramb)
  {
    AppMethodBeat.i(8314);
    if (paramb == null)
    {
      AppMethodBeat.o(8314);
      return false;
    }
    if (this.uWu == null)
    {
      ab.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
      AppMethodBeat.o(8314);
      return false;
    }
    Object localObject;
    for (;;)
    {
      try
      {
        if (!(paramb instanceof eb)) {
          continue;
        }
        ab.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
        paramb = (eb)paramb;
        bool = bo.isNullOrNil(paramb.crS.bYu);
        if (bool)
        {
          AppMethodBeat.o(8314);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.crS.bYu);
        ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.crS.cqN);
        this.uWu.e(17, (Bundle)localObject);
      }
      catch (Exception paramb)
      {
        boolean bool;
        ab.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
        continue;
        if (!(paramb instanceof dw)) {
          continue;
        }
        ab.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
        paramb = (dw)paramb;
        if ((bo.isNullOrNil(paramb.crK.bYu)) || (bo.isNullOrNil(paramb.crK.cqQ))) {
          continue;
        }
        localObject = paramb.crK.data;
        if (localObject != null) {
          continue;
        }
        AppMethodBeat.o(8314);
        return true;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.crK.bYu);
        ((Bundle)localObject).putByteArray("exdevice_data", paramb.crK.data);
        ((Bundle)localObject).putString("exdevice_brand_name", paramb.crK.cqQ);
        ((Bundle)localObject).putString("exdevice_device_type", a.access$100());
        this.uWu.e(16, (Bundle)localObject);
        continue;
        if (!(paramb instanceof dx)) {
          continue;
        }
        ab.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
        paramb = (dx)paramb;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.crL.bYu);
        ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.crL.crM);
        ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.crL.aLC);
        ((Bundle)localObject).putBoolean("exdevice_is_lan_device", true);
        ((Bundle)localObject).putString("exdevice_device_type", a.access$100());
        this.uWu.e(15, (Bundle)localObject);
        continue;
        if (!(paramb instanceof dy)) {
          continue;
        }
        ab.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
        paramb = (dy)paramb;
        localObject = new Bundle();
        if (paramb.crN.crO != true) {
          break;
        }
      }
      AppMethodBeat.o(8314);
      return true;
      if ((paramb instanceof dv))
      {
        ab.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
        paramb = (dv)paramb;
        if (!bo.isNullOrNil(paramb.crI.bYu))
        {
          bool = this.cqQ.equals(paramb.crI.cqQ);
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(8314);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.crI.bYu);
        ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.crI.crJ);
        ((Bundle)localObject).putString("exdevice_device_type", a.access$100());
        this.uWu.e(1004, (Bundle)localObject);
      }
      else
      {
        ((Bundle)localObject).putBoolean("exdevice_lan_state", true);
      }
    }
    for (;;)
    {
      this.uWu.e(47, (Bundle)localObject);
      break;
      ((Bundle)localObject).putBoolean("exdevice_lan_state", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.a.a
 * JD-Core Version:    0.7.0.1
 */