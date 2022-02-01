package com.tencent.mm.plugin.webview.c.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.ek.a;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.el.a;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.em.a;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.en.a;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a$a
{
  private f DNO;
  public c DNP;
  public c DNQ;
  public c DNR;
  public c DNS;
  private String doD;
  public c yQg;
  
  public a$a(f paramf, String paramString)
  {
    AppMethodBeat.i(213941);
    this.DNO = null;
    this.doD = "";
    this.DNP = new c() {};
    this.DNQ = new c() {};
    this.DNR = new c() {};
    this.DNS = new c() {};
    this.yQg = new c() {};
    this.DNO = paramf;
    this.doD = paramString;
    AppMethodBeat.o(213941);
  }
  
  final boolean g(b paramb)
  {
    AppMethodBeat.i(213942);
    if (paramb == null)
    {
      AppMethodBeat.o(213942);
      return false;
    }
    if (this.DNO == null)
    {
      ad.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
      AppMethodBeat.o(213942);
      return false;
    }
    Object localObject;
    try
    {
      if ((paramb instanceof en))
      {
        ad.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
        paramb = (en)paramb;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dpH.cUi);
        ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.dpH.dpz);
        ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.dpH.bsb);
        this.DNO.g(15, (Bundle)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(213942);
        return true;
        if (!(paramb instanceof em)) {
          break;
        }
        ad.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
        paramb = (em)paramb;
        if ((!bt.isNullOrNil(paramb.dpG.cUi)) && (!bt.isNullOrNil(paramb.dpG.doD)))
        {
          localObject = paramb.dpG.data;
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(213942);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dpG.cUi);
        ((Bundle)localObject).putByteArray("exdevice_data", paramb.dpG.data);
        ((Bundle)localObject).putString("exdevice_brand_name", paramb.dpG.doD);
        this.DNO.g(16, (Bundle)localObject);
      }
    }
    catch (Exception paramb)
    {
      do
      {
        for (;;)
        {
          ad.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
          continue;
          boolean bool;
          if ((paramb instanceof el))
          {
            ad.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
            paramb = (el)paramb;
            bool = bt.isNullOrNil(paramb.dpF.cUi);
            if (bool)
            {
              AppMethodBeat.o(213942);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramb.dpF.cUi);
            ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.dpF.doA);
            this.DNO.g(17, (Bundle)localObject);
          }
          else
          {
            if (!(paramb instanceof ny)) {
              break;
            }
            paramb = (ny)paramb;
            int i = paramb.dBN.op;
            if (i != 2)
            {
              AppMethodBeat.o(213942);
              return true;
            }
            if (!bt.isNullOrNil(paramb.dBN.dyL))
            {
              bool = this.doD.equals(paramb.dBN.dyL);
              if (bool) {}
            }
            else
            {
              AppMethodBeat.o(213942);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramb.dBN.cUi);
            ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.dBN.dpw);
            this.DNO.g(1004, (Bundle)localObject);
          }
        }
      } while (!(paramb instanceof ek));
      paramb = (ek)paramb;
      localObject = new Bundle();
      if (paramb.dpD.dpE != 12) {
        break label563;
      }
    }
    ((Bundle)localObject).putBoolean("exdevice_bt_state", true);
    for (;;)
    {
      this.DNO.g(18, (Bundle)localObject);
      break;
      label563:
      ((Bundle)localObject).putBoolean("exdevice_bt_state", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */