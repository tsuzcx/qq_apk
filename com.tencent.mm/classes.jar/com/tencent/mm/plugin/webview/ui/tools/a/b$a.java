package com.tencent.mm.plugin.webview.ui.tools.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.ea.a;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.a;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.a;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ed.a;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.lv.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b$a
{
  private String cqQ;
  public c qRq;
  private e uWu;
  public c vjk;
  public c vju;
  public c vjv;
  public c vjw;
  
  public b$a(e parame, String paramString)
  {
    AppMethodBeat.i(8327);
    this.uWu = null;
    this.cqQ = "";
    this.vju = new b.a.1(this);
    this.vjv = new b.a.2(this);
    this.vjk = new b.a.3(this);
    this.vjw = new b.a.4(this);
    this.qRq = new b.a.5(this);
    this.uWu = parame;
    this.cqQ = paramString;
    AppMethodBeat.o(8327);
  }
  
  final boolean g(b paramb)
  {
    AppMethodBeat.i(8328);
    if (paramb == null)
    {
      AppMethodBeat.o(8328);
      return false;
    }
    if (this.uWu == null)
    {
      ab.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
      AppMethodBeat.o(8328);
      return false;
    }
    Object localObject;
    try
    {
      if ((paramb instanceof ed))
      {
        ab.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
        paramb = (ed)paramb;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.crU.bYu);
        ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.crU.crM);
        ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.crU.aLC);
        this.uWu.e(15, (Bundle)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(8328);
        return true;
        if (!(paramb instanceof ec)) {
          break;
        }
        ab.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
        paramb = (ec)paramb;
        if ((!bo.isNullOrNil(paramb.crT.bYu)) && (!bo.isNullOrNil(paramb.crT.cqQ)))
        {
          localObject = paramb.crT.data;
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(8328);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.crT.bYu);
        ((Bundle)localObject).putByteArray("exdevice_data", paramb.crT.data);
        ((Bundle)localObject).putString("exdevice_brand_name", paramb.crT.cqQ);
        this.uWu.e(16, (Bundle)localObject);
      }
    }
    catch (Exception paramb)
    {
      do
      {
        for (;;)
        {
          ab.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
          continue;
          boolean bool;
          if ((paramb instanceof eb))
          {
            ab.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
            paramb = (eb)paramb;
            bool = bo.isNullOrNil(paramb.crS.bYu);
            if (bool)
            {
              AppMethodBeat.o(8328);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramb.crS.bYu);
            ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.crS.cqN);
            this.uWu.e(17, (Bundle)localObject);
          }
          else
          {
            if (!(paramb instanceof lv)) {
              break;
            }
            paramb = (lv)paramb;
            int i = paramb.cBR.op;
            if (i != 2)
            {
              AppMethodBeat.o(8328);
              return true;
            }
            if (!bo.isNullOrNil(paramb.cBR.czh))
            {
              bool = this.cqQ.equals(paramb.cBR.czh);
              if (bool) {}
            }
            else
            {
              AppMethodBeat.o(8328);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramb.cBR.bYu);
            ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.cBR.crJ);
            this.uWu.e(1004, (Bundle)localObject);
          }
        }
      } while (!(paramb instanceof ea));
      paramb = (ea)paramb;
      localObject = new Bundle();
      if (paramb.crQ.crR != 12) {
        break label571;
      }
    }
    ((Bundle)localObject).putBoolean("exdevice_bt_state", true);
    for (;;)
    {
      this.uWu.e(18, (Bundle)localObject);
      break;
      label571:
      ((Bundle)localObject).putBoolean("exdevice_bt_state", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.b.a
 * JD-Core Version:    0.7.0.1
 */