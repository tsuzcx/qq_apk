package com.tencent.mm.plugin.webview.ui.tools.a;

import android.os.Bundle;
import com.tencent.mm.h.a.ds;
import com.tencent.mm.h.a.ds.a;
import com.tencent.mm.h.a.dt;
import com.tencent.mm.h.a.dt.a;
import com.tencent.mm.h.a.du;
import com.tencent.mm.h.a.du.a;
import com.tencent.mm.h.a.dv;
import com.tencent.mm.h.a.dv.a;
import com.tencent.mm.h.a.dy;
import com.tencent.mm.h.a.dy.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a$a
{
  private String bJw = "";
  private e rgh = null;
  public c rte = new c() {};
  public c rtf = new a.a.2(this);
  public c rtg = new a.a.3(this);
  public c rth = new a.a.4(this);
  public c rti = new a.a.5(this);
  
  public a$a(e parame, String paramString)
  {
    this.rgh = parame;
    this.bJw = paramString;
  }
  
  final boolean h(b paramb)
  {
    if (paramb == null) {
      return false;
    }
    if (this.rgh == null)
    {
      y.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
      return false;
    }
    Bundle localBundle;
    try
    {
      if ((paramb instanceof dy))
      {
        y.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
        paramb = (dy)paramb;
        if (bk.bl(paramb.bKy.bwK)) {
          return true;
        }
        localBundle = new Bundle();
        localBundle.putString("exdevice_device_id", paramb.bKy.bwK);
        localBundle.putBoolean("exdevice_is_bound", paramb.bKy.bJt);
        this.rgh.b(17, localBundle);
      }
      else if ((paramb instanceof ds))
      {
        y.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
        paramb = (ds)paramb;
        if ((bk.bl(paramb.bKo.bwK)) || (!this.bJw.equals(paramb.bKo.bJw))) {
          break label541;
        }
        localBundle = new Bundle();
        localBundle.putString("exdevice_device_id", paramb.bKo.bwK);
        localBundle.putInt("exdevice_on_state_change_state", paramb.bKo.bKp);
        localBundle.putString("exdevice_device_type", a.access$100());
        this.rgh.b(1004, localBundle);
      }
    }
    catch (Exception paramb)
    {
      y.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
    }
    if ((paramb instanceof dt))
    {
      y.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
      paramb = (dt)paramb;
      if ((bk.bl(paramb.bKq.bwK)) || (bk.bl(paramb.bKq.bJw)) || (paramb.bKq.data == null)) {
        break label543;
      }
      localBundle = new Bundle();
      localBundle.putString("exdevice_device_id", paramb.bKq.bwK);
      localBundle.putByteArray("exdevice_data", paramb.bKq.data);
      localBundle.putString("exdevice_brand_name", paramb.bKq.bJw);
      localBundle.putString("exdevice_device_type", a.access$100());
      this.rgh.b(16, localBundle);
    }
    else if ((paramb instanceof du))
    {
      y.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
      paramb = (du)paramb;
      localBundle = new Bundle();
      localBundle.putString("exdevice_device_id", paramb.bKr.bwK);
      localBundle.putByteArray("exdevice_broadcast_data", paramb.bKr.bKs);
      localBundle.putBoolean("exdevice_is_complete", paramb.bKr.aES);
      localBundle.putBoolean("exdevice_is_lan_device", true);
      localBundle.putString("exdevice_device_type", a.access$100());
      this.rgh.b(15, localBundle);
    }
    else if ((paramb instanceof dv))
    {
      y.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
      paramb = (dv)paramb;
      localBundle = new Bundle();
      if (paramb.bKt.bKu == true) {
        localBundle.putBoolean("exdevice_lan_state", true);
      }
      for (;;)
      {
        this.rgh.b(47, localBundle);
        break;
        localBundle.putBoolean("exdevice_lan_state", false);
      }
    }
    return true;
    label541:
    return true;
    label543:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.a.a
 * JD-Core Version:    0.7.0.1
 */