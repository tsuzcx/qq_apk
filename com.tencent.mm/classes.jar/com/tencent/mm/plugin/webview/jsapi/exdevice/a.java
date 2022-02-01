package com.tencent.mm.plugin.webview.jsapi.exdevice;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.fg;
import com.tencent.mm.autogen.a.fg.a;
import com.tencent.mm.autogen.a.fh;
import com.tencent.mm.autogen.a.fh.a;
import com.tencent.mm.autogen.a.fi;
import com.tencent.mm.autogen.a.fi.a;
import com.tencent.mm.autogen.a.fj;
import com.tencent.mm.autogen.a.fj.a;
import com.tencent.mm.autogen.a.fm;
import com.tencent.mm.autogen.a.fm.b;
import com.tencent.mm.autogen.a.fs;
import com.tencent.mm.autogen.a.fs.b;
import com.tencent.mm.autogen.a.rb;
import com.tencent.mm.autogen.a.rb.a;
import com.tencent.mm.pluginsdk.ui.tools.z.a;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements z.a
{
  private static a WEW;
  private static final byte[] ysk = { -2, 1, 1 };
  public a WEV;
  public byte[] WEX = null;
  public int WEY = -1;
  public boolean WEZ = false;
  public boolean WFa = false;
  public String hEy;
  public boolean hasInit = false;
  
  public static boolean cT(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 9) && (paramArrayOfByte[(paramArrayOfByte.length - 7)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 8)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 9)] == -2);
  }
  
  public static a itT()
  {
    AppMethodBeat.i(295364);
    if (WEW == null) {
      WEW = new a();
    }
    a locala = WEW;
    AppMethodBeat.o(295364);
    return locala;
  }
  
  public final String getName()
  {
    return "WebViewExDeviceMgr";
  }
  
  public final void itU()
  {
    AppMethodBeat.i(295385);
    Log.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.WEZ) });
    if (this.WEZ)
    {
      localObject = new fm();
      ((fm)localObject).hFG.hEz = false;
      ((fm)localObject).hFG.hEy = this.hEy;
      ((fm)localObject).publish();
      if (!((fm)localObject).hFH.hEn) {
        Log.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
      }
      this.WEZ = false;
    }
    this.hasInit = false;
    if (this.WEV != null)
    {
      this.WEV.WFc.dead();
      this.WEV.WFd.dead();
      this.WEV.WFf.dead();
      this.WEV.WFe.dead();
      this.WEV.WFg.dead();
      this.WEV = null;
    }
    this.WEX = null;
    Object localObject = new fs();
    ((fs)localObject).hFY.hEl = "";
    ((fs)localObject).hFY.direction = 0;
    ((fs)localObject).hFY.clear = true;
    ((fs)localObject).publish();
    Log.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[] { Boolean.valueOf(((fs)localObject).hFZ.hEn) });
    AppMethodBeat.o(295385);
  }
  
  public final void itV() {}
  
  public final void kP(Context paramContext) {}
  
  public static final class a
  {
    private com.tencent.mm.plugin.webview.stub.f WFb;
    public IListener WFc;
    public IListener WFd;
    public IListener WFe;
    public IListener WFf;
    public IListener WFg;
    private String hEy;
    
    public a(com.tencent.mm.plugin.webview.stub.f paramf, String paramString)
    {
      AppMethodBeat.i(295359);
      this.WFb = null;
      this.hEy = "";
      this.WFc = new WebViewExDeviceMgr.WVExDeviceEventListener.1(this, com.tencent.mm.app.f.hfK);
      this.WFd = new WebViewExDeviceMgr.WVExDeviceEventListener.2(this, com.tencent.mm.app.f.hfK);
      this.WFe = new WebViewExDeviceMgr.WVExDeviceEventListener.3(this, com.tencent.mm.app.f.hfK);
      this.WFf = new WebViewExDeviceMgr.WVExDeviceEventListener.4(this, com.tencent.mm.app.f.hfK);
      this.WFg = new WebViewExDeviceMgr.WVExDeviceEventListener.5(this, com.tencent.mm.app.f.hfK);
      this.WFb = paramf;
      this.hEy = paramString;
      AppMethodBeat.o(295359);
    }
    
    final boolean h(IEvent paramIEvent)
    {
      AppMethodBeat.i(295373);
      if (paramIEvent == null)
      {
        AppMethodBeat.o(295373);
        return false;
      }
      if (this.WFb == null)
      {
        Log.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
        AppMethodBeat.o(295373);
        return false;
      }
      Object localObject;
      try
      {
        if ((paramIEvent instanceof fj))
        {
          Log.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
          paramIEvent = (fj)paramIEvent;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.hFD.hEl);
          ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramIEvent.hFD.hFv);
          ((Bundle)localObject).putBoolean("exdevice_is_complete", paramIEvent.hFD.cVt);
          this.WFb.i(15, (Bundle)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(295373);
          return true;
          if (!(paramIEvent instanceof fi)) {
            break;
          }
          Log.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
          paramIEvent = (fi)paramIEvent;
          if ((!Util.isNullOrNil(paramIEvent.hFC.hEl)) && (!Util.isNullOrNil(paramIEvent.hFC.hEy)))
          {
            localObject = paramIEvent.hFC.data;
            if (localObject != null) {}
          }
          else
          {
            AppMethodBeat.o(295373);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.hFC.hEl);
          ((Bundle)localObject).putByteArray("exdevice_data", paramIEvent.hFC.data);
          ((Bundle)localObject).putString("exdevice_brand_name", paramIEvent.hFC.hEy);
          this.WFb.i(16, (Bundle)localObject);
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
            if ((paramIEvent instanceof fh))
            {
              Log.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
              paramIEvent = (fh)paramIEvent;
              bool = Util.isNullOrNil(paramIEvent.hFB.hEl);
              if (bool)
              {
                AppMethodBeat.o(295373);
                return true;
              }
              localObject = new Bundle();
              ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.hFB.hEl);
              ((Bundle)localObject).putBoolean("exdevice_is_bound", paramIEvent.hFB.hEv);
              this.WFb.i(17, (Bundle)localObject);
            }
            else
            {
              if (!(paramIEvent instanceof rb)) {
                break;
              }
              paramIEvent = (rb)paramIEvent;
              int i = paramIEvent.hUc.op;
              if (i != 2)
              {
                AppMethodBeat.o(295373);
                return true;
              }
              if (!Util.isNullOrNil(paramIEvent.hUc.hQA))
              {
                bool = this.hEy.equals(paramIEvent.hUc.hQA);
                if (bool) {}
              }
              else
              {
                AppMethodBeat.o(295373);
                return true;
              }
              localObject = new Bundle();
              ((Bundle)localObject).putString("exdevice_device_id", paramIEvent.hUc.hEl);
              ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramIEvent.hUc.hFs);
              this.WFb.i(1004, (Bundle)localObject);
            }
          }
        } while (!(paramIEvent instanceof fg));
        paramIEvent = (fg)paramIEvent;
        localObject = new Bundle();
        if (paramIEvent.hFz.hFA != 12) {
          break label563;
        }
      }
      ((Bundle)localObject).putBoolean("exdevice_bt_state", true);
      for (;;)
      {
        this.WFb.i(18, (Bundle)localObject);
        break;
        label563:
        ((Bundle)localObject).putBoolean("exdevice_bt_state", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.exdevice.a
 * JD-Core Version:    0.7.0.1
 */