package com.tencent.mm.plugin.webview.ui.tools.a;

import android.os.Bundle;
import com.tencent.mm.h.a.dx;
import com.tencent.mm.h.a.dx.a;
import com.tencent.mm.h.a.dy;
import com.tencent.mm.h.a.dy.a;
import com.tencent.mm.h.a.dz;
import com.tencent.mm.h.a.dz.a;
import com.tencent.mm.h.a.ea;
import com.tencent.mm.h.a.ea.a;
import com.tencent.mm.h.a.lg;
import com.tencent.mm.h.a.lg.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b$a
{
  private String bJw = "";
  public c odk = new b.a.5(this);
  private e rgh = null;
  public c rte = new b.a.3(this);
  public c rto = new b.a.1(this);
  public c rtp = new b.a.2(this);
  public c rtq = new b.a.4(this);
  
  public b$a(e parame, String paramString)
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
      y.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
      return false;
    }
    Bundle localBundle;
    try
    {
      if ((paramb instanceof ea))
      {
        y.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
        paramb = (ea)paramb;
        localBundle = new Bundle();
        localBundle.putString("exdevice_device_id", paramb.bKA.bwK);
        localBundle.putByteArray("exdevice_broadcast_data", paramb.bKA.bKs);
        localBundle.putBoolean("exdevice_is_complete", paramb.bKA.aES);
        this.rgh.b(15, localBundle);
      }
      else if ((paramb instanceof dz))
      {
        y.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
        paramb = (dz)paramb;
        if ((bk.bl(paramb.bKz.bwK)) || (bk.bl(paramb.bKz.bJw)) || (paramb.bKz.data == null)) {
          break label507;
        }
        localBundle = new Bundle();
        localBundle.putString("exdevice_device_id", paramb.bKz.bwK);
        localBundle.putByteArray("exdevice_data", paramb.bKz.data);
        localBundle.putString("exdevice_brand_name", paramb.bKz.bJw);
        this.rgh.b(16, localBundle);
      }
    }
    catch (Exception paramb)
    {
      y.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
    }
    if ((paramb instanceof dy))
    {
      y.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
      paramb = (dy)paramb;
      if (bk.bl(paramb.bKy.bwK)) {
        return true;
      }
      localBundle = new Bundle();
      localBundle.putString("exdevice_device_id", paramb.bKy.bwK);
      localBundle.putBoolean("exdevice_is_bound", paramb.bKy.bJt);
      this.rgh.b(17, localBundle);
    }
    else if ((paramb instanceof lg))
    {
      paramb = (lg)paramb;
      if (paramb.bUl.op != 2) {
        return true;
      }
      if ((bk.bl(paramb.bUl.bRF)) || (!this.bJw.equals(paramb.bUl.bRF))) {
        break label509;
      }
      localBundle = new Bundle();
      localBundle.putString("exdevice_device_id", paramb.bUl.bwK);
      localBundle.putInt("exdevice_on_state_change_state", paramb.bUl.bKp);
      this.rgh.b(1004, localBundle);
    }
    else if ((paramb instanceof dx))
    {
      paramb = (dx)paramb;
      localBundle = new Bundle();
      if (paramb.bKw.bKx == 12) {
        localBundle.putBoolean("exdevice_bt_state", true);
      }
      for (;;)
      {
        this.rgh.b(18, localBundle);
        break;
        localBundle.putBoolean("exdevice_bt_state", false);
      }
    }
    return true;
    label507:
    return true;
    label509:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a.b.a
 * JD-Core Version:    0.7.0.1
 */