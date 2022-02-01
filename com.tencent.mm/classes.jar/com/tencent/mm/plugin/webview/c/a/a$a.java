package com.tencent.mm.plugin.webview.c.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.el.a;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.em.a;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.en.a;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.eo.a;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.a.nz.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a$a
{
  private f EfN;
  public c EfO;
  public c EfP;
  public c EfQ;
  public c EfR;
  private String dpI;
  public c zgq;
  
  public a$a(f paramf, String paramString)
  {
    AppMethodBeat.i(213770);
    this.EfN = null;
    this.dpI = "";
    this.EfO = new c() {};
    this.EfP = new c() {};
    this.EfQ = new c() {};
    this.EfR = new c() {};
    this.zgq = new c() {};
    this.EfN = paramf;
    this.dpI = paramString;
    AppMethodBeat.o(213770);
  }
  
  final boolean g(b paramb)
  {
    AppMethodBeat.i(213771);
    if (paramb == null)
    {
      AppMethodBeat.o(213771);
      return false;
    }
    if (this.EfN == null)
    {
      ae.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
      AppMethodBeat.o(213771);
      return false;
    }
    Object localObject;
    try
    {
      if ((paramb instanceof eo))
      {
        ae.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
        paramb = (eo)paramb;
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dqM.cVh);
        ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.dqM.dqE);
        ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.dqM.bsb);
        this.EfN.g(15, (Bundle)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(213771);
        return true;
        if (!(paramb instanceof en)) {
          break;
        }
        ae.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
        paramb = (en)paramb;
        if ((!bu.isNullOrNil(paramb.dqL.cVh)) && (!bu.isNullOrNil(paramb.dqL.dpI)))
        {
          localObject = paramb.dqL.data;
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(213771);
          return true;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("exdevice_device_id", paramb.dqL.cVh);
        ((Bundle)localObject).putByteArray("exdevice_data", paramb.dqL.data);
        ((Bundle)localObject).putString("exdevice_brand_name", paramb.dqL.dpI);
        this.EfN.g(16, (Bundle)localObject);
      }
    }
    catch (Exception paramb)
    {
      do
      {
        for (;;)
        {
          ae.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
          continue;
          boolean bool;
          if ((paramb instanceof em))
          {
            ae.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
            paramb = (em)paramb;
            bool = bu.isNullOrNil(paramb.dqK.cVh);
            if (bool)
            {
              AppMethodBeat.o(213771);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramb.dqK.cVh);
            ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.dqK.dpF);
            this.EfN.g(17, (Bundle)localObject);
          }
          else
          {
            if (!(paramb instanceof nz)) {
              break;
            }
            paramb = (nz)paramb;
            int i = paramb.dCS.op;
            if (i != 2)
            {
              AppMethodBeat.o(213771);
              return true;
            }
            if (!bu.isNullOrNil(paramb.dCS.dzQ))
            {
              bool = this.dpI.equals(paramb.dCS.dzQ);
              if (bool) {}
            }
            else
            {
              AppMethodBeat.o(213771);
              return true;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putString("exdevice_device_id", paramb.dCS.cVh);
            ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.dCS.dqB);
            this.EfN.g(1004, (Bundle)localObject);
          }
        }
      } while (!(paramb instanceof el));
      paramb = (el)paramb;
      localObject = new Bundle();
      if (paramb.dqI.dqJ != 12) {
        break label563;
      }
    }
    ((Bundle)localObject).putBoolean("exdevice_bt_state", true);
    for (;;)
    {
      this.EfN.g(18, (Bundle)localObject);
      break;
      label563:
      ((Bundle)localObject).putBoolean("exdevice_bt_state", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */