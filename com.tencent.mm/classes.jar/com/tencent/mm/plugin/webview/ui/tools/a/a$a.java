package com.tencent.mm.plugin.webview.ui.tools.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.a;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.a;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ed.a;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ee.a;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.eh.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a$a
{
  private f ASw;
  public c ASz;
  public c BjX;
  public c BjY;
  public c BjZ;
  public c Bka;
  private String dfM;
  
  public a$a(f paramf, String paramString)
  {
    AppMethodBeat.i(80484);
    this.ASw = null;
    this.dfM = "";
    this.ASz = new c() {};
    this.BjX = new c() {};
    this.BjY = new c() {};
    this.BjZ = new c() {};
    this.Bka = new c() {};
    this.ASw = paramf;
    this.dfM = paramString;
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
    if (this.ASw == null)
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
        if (!(paramb instanceof eh)) {
          continue;
        }
        ad.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
        paramb = (eh)paramb;
        bool = bt.isNullOrNil(paramb.dgO.cLR);
        if (bool)
        {
          AppMethodBeat.o(80485);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dgO.cLR);
        ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.dgO.dfJ);
        this.ASw.f(17, (Bundle)localObject);
      }
      catch (Exception paramb)
      {
        boolean bool;
        ad.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
        continue;
        if (!(paramb instanceof ec)) {
          continue;
        }
        ad.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
        paramb = (ec)paramb;
        if ((bt.isNullOrNil(paramb.dgG.cLR)) || (bt.isNullOrNil(paramb.dgG.dfM))) {
          continue;
        }
        localObject = paramb.dgG.data;
        if (localObject != null) {
          continue;
        }
        AppMethodBeat.o(80485);
        return true;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dgG.cLR);
        ((Bundle)localObject).putByteArray("exdevice_data", paramb.dgG.data);
        ((Bundle)localObject).putString("exdevice_brand_name", paramb.dgG.dfM);
        ((Bundle)localObject).putString("exdevice_device_type", a.access$100());
        this.ASw.f(16, (Bundle)localObject);
        continue;
        if (!(paramb instanceof ed)) {
          continue;
        }
        ad.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
        paramb = (ed)paramb;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dgH.cLR);
        ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.dgH.dgI);
        ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.dgH.bhb);
        ((Bundle)localObject).putBoolean("exdevice_is_lan_device", true);
        ((Bundle)localObject).putString("exdevice_device_type", a.access$100());
        this.ASw.f(15, (Bundle)localObject);
        continue;
        if (!(paramb instanceof ee)) {
          continue;
        }
        ad.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
        paramb = (ee)paramb;
        localObject = new Bundle();
        if (paramb.dgJ.dgK != true) {
          break;
        }
      }
      AppMethodBeat.o(80485);
      return true;
      if ((paramb instanceof eb))
      {
        ad.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
        paramb = (eb)paramb;
        if (!bt.isNullOrNil(paramb.dgE.cLR))
        {
          bool = this.dfM.equals(paramb.dgE.dfM);
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(80485);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dgE.cLR);
        ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.dgE.dgF);
        ((Bundle)localObject).putString("exdevice_device_type", a.access$100());
        this.ASw.f(1004, (Bundle)localObject);
      }
      else
      {
        ((Bundle)localObject).putBoolean("exdevice_lan_state", true);
      }
    }
    for (;;)
    {
      this.ASw.f(47, (Bundle)localObject);
      break;
      ((Bundle)localObject).putBoolean("exdevice_lan_state", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.a.a
 * JD-Core Version:    0.7.0.1
 */