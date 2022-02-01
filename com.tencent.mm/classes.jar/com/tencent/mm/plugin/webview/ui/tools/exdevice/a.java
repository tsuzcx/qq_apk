package com.tencent.mm.plugin.webview.ui.tools.exdevice;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.eq;
import com.tencent.mm.f.a.eq.a;
import com.tencent.mm.f.a.er;
import com.tencent.mm.f.a.er.a;
import com.tencent.mm.f.a.es;
import com.tencent.mm.f.a.es.a;
import com.tencent.mm.f.a.et;
import com.tencent.mm.f.a.et.a;
import com.tencent.mm.f.a.ew;
import com.tencent.mm.f.a.ew.a;
import com.tencent.mm.f.a.fa;
import com.tencent.mm.f.a.fr;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.aa.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements aa.a
{
  private static a QjT;
  private static String kQZ = "lan";
  public byte[] POL = null;
  public boolean PON = false;
  public a QjS;
  private int QjU = -1;
  public String fzM;
  public boolean hasInit = false;
  
  public static a gZM()
  {
    AppMethodBeat.i(80486);
    if (QjT == null) {
      QjT = new a();
    }
    a locala = QjT;
    AppMethodBeat.o(80486);
    return locala;
  }
  
  public final void gUn()
  {
    AppMethodBeat.i(80487);
    Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.PON) });
    if (this.PON)
    {
      localObject = new fr();
      ((fr)localObject).fBB.fzN = false;
      EventCenter.instance.publish((IEvent)localObject);
      this.PON = false;
    }
    this.hasInit = false;
    if (this.QjS != null)
    {
      EventCenter.instance.removeListener(this.QjS.POS);
      EventCenter.instance.removeListener(this.QjS.QjV);
      EventCenter.instance.removeListener(this.QjS.QjX);
      EventCenter.instance.removeListener(this.QjS.QjW);
      EventCenter.instance.removeListener(this.QjS.QjY);
      this.QjS = null;
    }
    this.POL = null;
    Object localObject = new fa();
    ((fa)localObject).fAS.fzN = false;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(80487);
  }
  
  public final void gUo() {}
  
  public final String getName()
  {
    return "WebViewExDeviceLanMgr";
  }
  
  public final void iZ(Context paramContext) {}
  
  public static final class a
  {
    private f POP;
    public IListener POS;
    public IListener QjV;
    public IListener QjW;
    public IListener QjX;
    public IListener QjY;
    private String fzM;
    
    public a(f paramf, String paramString)
    {
      AppMethodBeat.i(80484);
      this.POP = null;
      this.fzM = "";
      this.POS = new IListener() {};
      this.QjV = new IListener() {};
      this.QjW = new IListener() {};
      this.QjX = new IListener() {};
      this.QjY = new IListener() {};
      this.POP = paramf;
      this.fzM = paramString;
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
      if (this.POP == null)
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
          if (!(paramIEvent instanceof ew)) {
            continue;
          }
          Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
          paramIEvent = (ew)paramIEvent;
          bool = Util.isNullOrNil(paramIEvent.fAO.fzB);
          if (bool)
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.fAO.fzB);
          ((Bundle)localObject).putBoolean("exdevice_is_bound", paramIEvent.fAO.fzJ);
          this.POP.h(17, (Bundle)localObject);
        }
        catch (Exception paramIEvent)
        {
          boolean bool;
          Log.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramIEvent.getMessage() });
          continue;
          if (!(paramIEvent instanceof er)) {
            continue;
          }
          Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
          paramIEvent = (er)paramIEvent;
          if ((Util.isNullOrNil(paramIEvent.fAG.fzB)) || (Util.isNullOrNil(paramIEvent.fAG.fzM))) {
            continue;
          }
          localObject = paramIEvent.fAG.data;
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(80485);
          return true;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.fAG.fzB);
          ((Bundle)localObject).putByteArray("exdevice_data", paramIEvent.fAG.data);
          ((Bundle)localObject).putString("exdevice_brand_name", paramIEvent.fAG.fzM);
          ((Bundle)localObject).putString("exdevice_device_type", a.kQZ);
          this.POP.h(16, (Bundle)localObject);
          continue;
          if (!(paramIEvent instanceof es)) {
            continue;
          }
          Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
          paramIEvent = (es)paramIEvent;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.fAH.fzB);
          ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramIEvent.fAH.fAI);
          ((Bundle)localObject).putBoolean("exdevice_is_complete", paramIEvent.fAH.bby);
          ((Bundle)localObject).putBoolean("exdevice_is_lan_device", true);
          ((Bundle)localObject).putString("exdevice_device_type", a.kQZ);
          this.POP.h(15, (Bundle)localObject);
          continue;
          if (!(paramIEvent instanceof et)) {
            continue;
          }
          Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
          paramIEvent = (et)paramIEvent;
          localObject = new Bundle();
          if (paramIEvent.fAJ.fAK != true) {
            break;
          }
        }
        AppMethodBeat.o(80485);
        return true;
        if ((paramIEvent instanceof eq))
        {
          Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
          paramIEvent = (eq)paramIEvent;
          if (!Util.isNullOrNil(paramIEvent.fAE.fzB))
          {
            bool = this.fzM.equals(paramIEvent.fAE.fzM);
            if (bool) {}
          }
          else
          {
            AppMethodBeat.o(80485);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.fAE.fzB);
          ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramIEvent.fAE.fAF);
          ((Bundle)localObject).putString("exdevice_device_type", a.kQZ);
          this.POP.h(1004, (Bundle)localObject);
        }
        else
        {
          ((Bundle)localObject).putBoolean("exdevice_lan_state", true);
        }
      }
      for (;;)
      {
        this.POP.h(47, (Bundle)localObject);
        break;
        ((Bundle)localObject).putBoolean("exdevice_lan_state", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.exdevice.a
 * JD-Core Version:    0.7.0.1
 */