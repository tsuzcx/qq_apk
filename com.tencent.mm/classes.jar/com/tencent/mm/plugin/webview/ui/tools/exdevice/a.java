package com.tencent.mm.plugin.webview.ui.tools.exdevice;

import android.content.Context;
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
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.em.a;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.w.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  implements w.a
{
  private static a ExT;
  private static String hjv = "lan";
  public byte[] EfJ = null;
  public boolean EfL = false;
  public a ExS;
  private int ExU = -1;
  public String dpI;
  public boolean hasInit = false;
  
  public static a eXt()
  {
    AppMethodBeat.i(80486);
    if (ExT == null) {
      ExT = new a();
    }
    a locala = ExT;
    AppMethodBeat.o(80486);
    return locala;
  }
  
  public final void eSH()
  {
    AppMethodBeat.i(80487);
    ae.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.EfL) });
    if (this.EfL)
    {
      localObject = new fh();
      ((fh)localObject).dry.dpJ = false;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
      this.EfL = false;
    }
    this.hasInit = false;
    if (this.ExS != null)
    {
      com.tencent.mm.sdk.b.a.IvT.d(this.ExS.EfQ);
      com.tencent.mm.sdk.b.a.IvT.d(this.ExS.ExV);
      com.tencent.mm.sdk.b.a.IvT.d(this.ExS.ExX);
      com.tencent.mm.sdk.b.a.IvT.d(this.ExS.ExW);
      com.tencent.mm.sdk.b.a.IvT.d(this.ExS.ExY);
      this.ExS = null;
    }
    this.EfJ = null;
    Object localObject = new eq();
    ((eq)localObject).dqO.dpJ = false;
    com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
    AppMethodBeat.o(80487);
  }
  
  public final void eSI() {}
  
  public final void gZ(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceLanMgr";
  }
  
  public static final class a
  {
    private f EfN;
    public c EfQ;
    public c ExV;
    public c ExW;
    public c ExX;
    public c ExY;
    private String dpI;
    
    public a(f paramf, String paramString)
    {
      AppMethodBeat.i(80484);
      this.EfN = null;
      this.dpI = "";
      this.EfQ = new c() {};
      this.ExV = new c() {};
      this.ExW = new c() {};
      this.ExX = new c() {};
      this.ExY = new c() {};
      this.EfN = paramf;
      this.dpI = paramString;
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
      if (this.EfN == null)
      {
        ae.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
        AppMethodBeat.o(80485);
        return false;
      }
      Object localObject;
      for (;;)
      {
        try
        {
          if (!(paramb instanceof em)) {
            continue;
          }
          ae.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
          paramb = (em)paramb;
          bool = bu.isNullOrNil(paramb.dqK.cVh);
          if (bool)
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dqK.cVh);
          ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.dqK.dpF);
          this.EfN.g(17, (Bundle)localObject);
        }
        catch (Exception paramb)
        {
          boolean bool;
          ae.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
          continue;
          if (!(paramb instanceof eh)) {
            continue;
          }
          ae.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
          paramb = (eh)paramb;
          if ((bu.isNullOrNil(paramb.dqC.cVh)) || (bu.isNullOrNil(paramb.dqC.dpI))) {
            continue;
          }
          localObject = paramb.dqC.data;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(80485);
          return true;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dqC.cVh);
          ((Bundle)localObject).putByteArray("exdevice_data", paramb.dqC.data);
          ((Bundle)localObject).putString("exdevice_brand_name", paramb.dqC.dpI);
          ((Bundle)localObject).putString("exdevice_device_type", a.hjv);
          this.EfN.g(16, (Bundle)localObject);
          continue;
          if (!(paramb instanceof ei)) {
            continue;
          }
          ae.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
          paramb = (ei)paramb;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dqD.cVh);
          ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.dqD.dqE);
          ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.dqD.bsb);
          ((Bundle)localObject).putBoolean("exdevice_is_lan_device", true);
          ((Bundle)localObject).putString("exdevice_device_type", a.hjv);
          this.EfN.g(15, (Bundle)localObject);
          continue;
          if (!(paramb instanceof ej)) {
            continue;
          }
          ae.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
          paramb = (ej)paramb;
          localObject = new Bundle();
          if (paramb.dqF.dqG != true) {
            break;
          }
        }
        AppMethodBeat.o(80485);
        return true;
        if ((paramb instanceof eg))
        {
          ae.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
          paramb = (eg)paramb;
          if (!bu.isNullOrNil(paramb.dqA.cVh))
          {
            bool = this.dpI.equals(paramb.dqA.dpI);
            if (bool) {}
          }
          else
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dqA.cVh);
          ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.dqA.dqB);
          ((Bundle)localObject).putString("exdevice_device_type", a.hjv);
          this.EfN.g(1004, (Bundle)localObject);
        }
        else
        {
          ((Bundle)localObject).putBoolean("exdevice_lan_state", true);
        }
      }
      for (;;)
      {
        this.EfN.g(47, (Bundle)localObject);
        break;
        ((Bundle)localObject).putBoolean("exdevice_lan_state", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.exdevice.a
 * JD-Core Version:    0.7.0.1
 */