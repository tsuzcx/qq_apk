package com.tencent.mm.plugin.webview.c.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.eg.a;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.eh.a;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.ei.a;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.ej.a;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.nh.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a$a
{
  public c ASA;
  private f ASw;
  public c ASx;
  public c ASy;
  public c ASz;
  private String dfM;
  public c wqf;
  
  public a$a(f paramf, String paramString)
  {
    AppMethodBeat.i(189710);
    this.ASw = null;
    this.dfM = "";
    this.ASx = new c() {};
    this.ASy = new c() {};
    this.ASz = new c() {};
    this.ASA = new c() {};
    this.wqf = new c() {};
    this.ASw = paramf;
    this.dfM = paramString;
    AppMethodBeat.o(189710);
  }
  
  final boolean g(b paramb)
  {
    AppMethodBeat.i(189711);
    if (paramb == null)
    {
      AppMethodBeat.o(189711);
      return false;
    }
    if (this.ASw == null)
    {
      ad.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
      AppMethodBeat.o(189711);
      return false;
    }
    Object localObject;
    try
    {
      if ((paramb instanceof ej))
      {
        ad.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
        paramb = (ej)paramb;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dgQ.cLR);
        ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.dgQ.dgI);
        ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.dgQ.bhb);
        this.ASw.f(15, (Bundle)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(189711);
        return true;
        if (!(paramb instanceof ei)) {
          break;
        }
        ad.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
        paramb = (ei)paramb;
        if ((!bt.isNullOrNil(paramb.dgP.cLR)) && (!bt.isNullOrNil(paramb.dgP.dfM)))
        {
          localObject = paramb.dgP.data;
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(189711);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dgP.cLR);
        ((Bundle)localObject).putByteArray("exdevice_data", paramb.dgP.data);
        ((Bundle)localObject).putString("exdevice_brand_name", paramb.dgP.dfM);
        this.ASw.f(16, (Bundle)localObject);
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
          if ((paramb instanceof eh))
          {
            ad.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
            paramb = (eh)paramb;
            bool = bt.isNullOrNil(paramb.dgO.cLR);
            if (bool)
            {
              AppMethodBeat.o(189711);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramb.dgO.cLR);
            ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.dgO.dfJ);
            this.ASw.f(17, (Bundle)localObject);
          }
          else
          {
            if (!(paramb instanceof nh)) {
              break;
            }
            paramb = (nh)paramb;
            int i = paramb.dsp.op;
            if (i != 2)
            {
              AppMethodBeat.o(189711);
              return true;
            }
            if (!bt.isNullOrNil(paramb.dsp.dpn))
            {
              bool = this.dfM.equals(paramb.dsp.dpn);
              if (bool) {}
            }
            else
            {
              AppMethodBeat.o(189711);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramb.dsp.cLR);
            ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.dsp.dgF);
            this.ASw.f(1004, (Bundle)localObject);
          }
        }
      } while (!(paramb instanceof eg));
      paramb = (eg)paramb;
      localObject = new Bundle();
      if (paramb.dgM.dgN != 12) {
        break label563;
      }
    }
    ((Bundle)localObject).putBoolean("exdevice_bt_state", true);
    for (;;)
    {
      this.ASw.f(18, (Bundle)localObject);
      break;
      label563:
      ((Bundle)localObject).putBoolean("exdevice_bt_state", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */