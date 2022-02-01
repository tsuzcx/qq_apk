package com.tencent.mm.plugin.webview.c.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.eh.a;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.ei.a;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.ej.a;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.ek.a;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.en.b;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.et.b;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.nq.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.w.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  implements w.a
{
  private static a CkE;
  private static final byte[] pzy = { -2, 1, 1 };
  public a CkD;
  public byte[] CkF = null;
  public int CkG = -1;
  public boolean CkH = false;
  public boolean CkI = false;
  public String ddh;
  public boolean hasInit = false;
  
  public static boolean bY(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length >= 9) && (paramArrayOfByte[(paramArrayOfByte.length - 7)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 8)] == 1) && (paramArrayOfByte[(paramArrayOfByte.length - 9)] == -2);
  }
  
  public static a eAh()
  {
    AppMethodBeat.i(205341);
    if (CkE == null) {
      CkE = new a();
    }
    a locala = CkE;
    AppMethodBeat.o(205341);
    return locala;
  }
  
  public final void eAi()
  {
    AppMethodBeat.i(205342);
    ac.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[] { Boolean.valueOf(this.CkH) });
    if (this.CkH)
    {
      localObject = new en();
      ((en)localObject).deo.ddi = false;
      ((en)localObject).deo.ddh = this.ddh;
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
      if (!((en)localObject).dep.ddj) {
        ac.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
      }
      this.CkH = false;
    }
    this.hasInit = false;
    if (this.CkD != null)
    {
      com.tencent.mm.sdk.b.a.GpY.d(this.CkD.CkK);
      com.tencent.mm.sdk.b.a.GpY.d(this.CkD.CkL);
      com.tencent.mm.sdk.b.a.GpY.d(this.CkD.CkN);
      com.tencent.mm.sdk.b.a.GpY.d(this.CkD.CkM);
      com.tencent.mm.sdk.b.a.GpY.d(this.CkD.xBw);
      this.CkD = null;
    }
    this.CkF = null;
    Object localObject = new et();
    ((et)localObject).deF.cIZ = "";
    ((et)localObject).deF.direction = 0;
    ((et)localObject).deF.clear = true;
    com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
    ac.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[] { Boolean.valueOf(((et)localObject).deG.ddj) });
    AppMethodBeat.o(205342);
  }
  
  public final void eAj() {}
  
  public final void gO(Context paramContext) {}
  
  public final String getName()
  {
    return "WebViewExDeviceMgr";
  }
  
  public static final class a
  {
    private f CkJ;
    public c CkK;
    public c CkL;
    public c CkM;
    public c CkN;
    private String ddh;
    public c xBw;
    
    public a(f paramf, String paramString)
    {
      AppMethodBeat.i(205339);
      this.CkJ = null;
      this.ddh = "";
      this.CkK = new c() {};
      this.CkL = new c() {};
      this.CkM = new c() {};
      this.CkN = new c() {};
      this.xBw = new c() {};
      this.CkJ = paramf;
      this.ddh = paramString;
      AppMethodBeat.o(205339);
    }
    
    final boolean g(b paramb)
    {
      AppMethodBeat.i(205340);
      if (paramb == null)
      {
        AppMethodBeat.o(205340);
        return false;
      }
      if (this.CkJ == null)
      {
        ac.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
        AppMethodBeat.o(205340);
        return false;
      }
      Object localObject;
      try
      {
        if ((paramb instanceof ek))
        {
          ac.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
          paramb = (ek)paramb;
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.del.cIZ);
          ((Bundle)localObject).putByteArray("exdevice_broadcast_data", paramb.del.ded);
          ((Bundle)localObject).putBoolean("exdevice_is_complete", paramb.del.bhH);
          this.CkJ.g(15, (Bundle)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(205340);
          return true;
          if (!(paramb instanceof ej)) {
            break;
          }
          ac.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
          paramb = (ej)paramb;
          if ((!bs.isNullOrNil(paramb.dek.cIZ)) && (!bs.isNullOrNil(paramb.dek.ddh)))
          {
            localObject = paramb.dek.data;
            if (localObject != null) {}
          }
          else
          {
            AppMethodBeat.o(205340);
            return true;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("exdevice_device_id", paramb.dek.cIZ);
          ((Bundle)localObject).putByteArray("exdevice_data", paramb.dek.data);
          ((Bundle)localObject).putString("exdevice_brand_name", paramb.dek.ddh);
          this.CkJ.g(16, (Bundle)localObject);
        }
      }
      catch (Exception paramb)
      {
        do
        {
          for (;;)
          {
            ac.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", new Object[] { paramb.getMessage() });
            continue;
            boolean bool;
            if ((paramb instanceof ei))
            {
              ac.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
              paramb = (ei)paramb;
              bool = bs.isNullOrNil(paramb.dej.cIZ);
              if (bool)
              {
                AppMethodBeat.o(205340);
                return true;
              }
              localObject = new Bundle();
              ((Bundle)localObject).putString("exdevice_device_id", paramb.dej.cIZ);
              ((Bundle)localObject).putBoolean("exdevice_is_bound", paramb.dej.dde);
              this.CkJ.g(17, (Bundle)localObject);
            }
            else
            {
              if (!(paramb instanceof nq)) {
                break;
              }
              paramb = (nq)paramb;
              int i = paramb.dqa.op;
              if (i != 2)
              {
                AppMethodBeat.o(205340);
                return true;
              }
              if (!bs.isNullOrNil(paramb.dqa.dmX))
              {
                bool = this.ddh.equals(paramb.dqa.dmX);
                if (bool) {}
              }
              else
              {
                AppMethodBeat.o(205340);
                return true;
              }
              localObject = new Bundle();
              ((Bundle)localObject).putString("exdevice_device_id", paramb.dqa.cIZ);
              ((Bundle)localObject).putInt("exdevice_on_state_change_state", paramb.dqa.dea);
              this.CkJ.g(1004, (Bundle)localObject);
            }
          }
        } while (!(paramb instanceof eh));
        paramb = (eh)paramb;
        localObject = new Bundle();
        if (paramb.deh.dei != 12) {
          break label563;
        }
      }
      ((Bundle)localObject).putBoolean("exdevice_bt_state", true);
      for (;;)
      {
        this.CkJ.g(18, (Bundle)localObject);
        break;
        label563:
        ((Bundle)localObject).putBoolean("exdevice_bt_state", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a.a
 * JD-Core Version:    0.7.0.1
 */