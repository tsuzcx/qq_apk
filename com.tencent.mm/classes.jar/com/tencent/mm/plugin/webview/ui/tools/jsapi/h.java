package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;

public final class h
  implements MMActivity.a
{
  int EFN;
  boolean EFO;
  int EFP;
  e EFQ;
  e EFR;
  String EFS;
  d EFT;
  com.tencent.mm.modelgeo.c.a EFU;
  com.tencent.mm.modelgeo.c.a EFV;
  b.a EFW;
  final Runnable EFX;
  WeakReference<Context> aWN;
  d hTg;
  c vri;
  
  h()
  {
    AppMethodBeat.i(82045);
    this.EFO = false;
    this.vri = null;
    this.EFU = null;
    this.EFV = null;
    this.hTg = null;
    this.EFW = null;
    this.EFX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(82029);
        if ((h.this.EFW == null) || (h.this.hTg == null))
        {
          AppMethodBeat.o(82029);
          return;
        }
        h.this.vri.a(h.this.EFU);
        h.this.hTg.c(h.this.EFW);
        h.this.EFW.a(false, 0.0F, 0.0F, 0, 0.0D, 0.0D);
        AppMethodBeat.o(82029);
      }
    };
    AppMethodBeat.o(82045);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(82044);
    Context localContext = (Context)this.aWN.get();
    if ((this.EFT == null) || (localContext == null)) {}
    for (;;)
    {
      if ((this.EFO) && (this.EFT != null)) {
        this.EFT.Ys(this.EFN);
      }
      this.EFO = false;
      this.EFP = com.tencent.mm.pluginsdk.model.c.a.Fea.code;
      this.EFQ = null;
      this.EFR = null;
      this.aWN = null;
      this.EFT = null;
      this.EFS = null;
      this.EFU = null;
      this.EFV = null;
      if ((this.hTg != null) && (this.EFW != null)) {
        this.hTg.c(this.EFW);
      }
      this.hTg = null;
      this.EFW = null;
      if (this.vri != null)
      {
        if (this.EFU != null) {
          this.vri.a(this.EFU);
        }
        if (this.EFV != null) {
          this.vri.a(this.EFV);
        }
      }
      this.vri = null;
      this.EFU = null;
      this.EFV = null;
      AppMethodBeat.o(82044);
      return;
      if (!this.EFO)
      {
        ae.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
      }
      else if (paramInt1 != 33)
      {
        ae.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", new Object[] { Integer.valueOf(paramInt1) });
        this.EFT.onFail(this.EFN);
      }
      else if ((paramInt2 == 4097) || (paramInt2 == 0))
      {
        this.EFT.Yr(this.EFN);
      }
      else if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("selectpkg");
        if (bu.isNullOrNil(paramIntent))
        {
          ae.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
          this.EFT.onFail(this.EFN);
        }
        else
        {
          if (com.tencent.mm.pluginsdk.model.c.a.Feb.getPackage().equals(paramIntent)) {
            paramIntent = new c((byte)0);
          }
          for (;;)
          {
            paramIntent.a(localContext, this.EFQ, this.EFR, this.EFS);
            this.EFT.onSuccess(this.EFN);
            break;
            if (com.tencent.mm.pluginsdk.model.c.a.Fed.getPackage().equals(paramIntent)) {
              paramIntent = new a((byte)0);
            } else if (com.tencent.mm.pluginsdk.model.c.a.Fec.getPackage().equals(paramIntent)) {
              paramIntent = new g((byte)0);
            } else if (com.tencent.mm.pluginsdk.model.c.a.Fee.getPackage().equals(paramIntent)) {
              paramIntent = new b((byte)0);
            } else {
              paramIntent = new h((byte)0);
            }
          }
        }
      }
      else
      {
        ae.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", new Object[] { Integer.valueOf(paramInt2) });
        this.EFT.onFail(this.EFN);
      }
    }
  }
  
  final void eYB()
  {
    Context localContext = null;
    AppMethodBeat.i(82046);
    this.EFW = null;
    this.EFU = null;
    this.EFV = null;
    if (this.aWN == null) {}
    while (localContext == null)
    {
      AppMethodBeat.o(82046);
      return;
      localContext = (Context)this.aWN.get();
    }
    Intent localIntent = new Intent(localContext, AppChooserUI.class);
    Object localObject = new ArrayList(5);
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.Fea.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.Feb.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.Fec.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.Fed.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.Fee.getPackage());
    localIntent.putStringArrayListExtra("targetwhitelist", (ArrayList)localObject);
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Double.valueOf(this.EFR.latitude), Double.valueOf(this.EFR.longitude) })));
    localIntent.putExtra("targetintent", (Parcelable)localObject);
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("key_map_app", this.EFP);
    localBundle.putParcelable("key_target_intent", (Parcelable)localObject);
    localIntent.putExtra("key_recommend_params", localBundle);
    localIntent.putExtra("type", 2);
    localIntent.putExtra("title", localContext.getString(2131766276));
    ((MMActivity)localContext).mmStartActivityForResult(this, localIntent, 33);
    AppMethodBeat.o(82046);
  }
  
  static final class a
    extends h.f
  {
    private a()
    {
      super();
    }
    
    protected final void a(Context paramContext, h.e parame1, h.e parame2, String paramString)
    {
      AppMethodBeat.i(82034);
      if (paramContext == null)
      {
        super.a(paramContext, parame1, parame2, paramString);
        AppMethodBeat.o(82034);
        return;
      }
      paramString = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", new Object[] { Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) });
      parame2 = paramString;
      if (parame1 != null) {
        parame2 = paramString + String.format("origin=%f,%f", new Object[] { Double.valueOf(parame1.latitude), Double.valueOf(parame1.longitude) });
      }
      ae.d("MicroMsg.OpenMapNavigator", "url ".concat(String.valueOf(parame2)));
      try
      {
        parame1 = new Intent("android.intent.action.VIEW", Uri.parse(parame2 + "&src=webapp.car.carroutelistmappg.weixindrivenav"));
        parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahE(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$BaiduNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parame1.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$BaiduNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(82034);
        return;
      }
      catch (Exception paramContext)
      {
        ae.printErrStackTrace("MicroMsg.OpenMapNavigator", paramContext, "", new Object[0]);
        AppMethodBeat.o(82034);
      }
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(82035);
      String str = com.tencent.mm.pluginsdk.model.c.a.Fed.getPackage();
      AppMethodBeat.o(82035);
      return str;
    }
  }
  
  static final class b
    extends h.f
  {
    private b()
    {
      super();
    }
    
    protected final void a(Context paramContext, h.e parame1, h.e parame2, String paramString)
    {
      AppMethodBeat.i(82036);
      if (paramContext == null)
      {
        super.a(paramContext, parame1, parame2, paramString);
        AppMethodBeat.o(82036);
        return;
      }
      parame1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[] { "MicroMessager", Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) })));
      parame1.addCategory("android.intent.category.DEFAULT");
      parame1.setPackage(com.tencent.mm.pluginsdk.model.c.a.Fee.getPackage());
      parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahE(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GaodeNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parame1.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GaodeNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(82036);
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(224332);
      String str = com.tencent.mm.pluginsdk.model.c.a.Fee.getPackage();
      AppMethodBeat.o(224332);
      return str;
    }
  }
  
  static final class c
    extends h.f
  {
    private c()
    {
      super();
    }
    
    protected final void a(Context paramContext, h.e parame1, h.e parame2, String paramString)
    {
      AppMethodBeat.i(82038);
      if (paramContext == null)
      {
        super.a(paramContext, parame1, parame2, paramString);
        AppMethodBeat.o(82038);
        return;
      }
      paramString = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", new Object[] { Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) });
      parame2 = paramString;
      if (parame1 != null) {
        parame2 = paramString + String.format("&saddr=%f,%f", new Object[] { Double.valueOf(parame1.latitude), Double.valueOf(parame1.longitude) });
      }
      parame1 = new Intent("android.intent.action.VIEW", Uri.parse(parame2));
      parame1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahE(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GoogleNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parame1.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GoogleNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(82038);
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(82039);
      String str = com.tencent.mm.pluginsdk.model.c.a.Feb.getPackage();
      AppMethodBeat.o(82039);
      return str;
    }
  }
  
  static abstract interface d
  {
    public abstract void Yr(int paramInt);
    
    public abstract void Ys(int paramInt);
    
    public abstract void onFail(int paramInt);
    
    public abstract void onSuccess(int paramInt);
  }
  
  static final class e
  {
    String EGa;
    double latitude;
    double longitude;
    
    private e(double paramDouble1, double paramDouble2)
    {
      this.latitude = paramDouble1;
      this.longitude = paramDouble2;
      this.EGa = null;
    }
  }
  
  static abstract class f
  {
    protected void a(Context paramContext, h.e parame1, h.e parame2, String paramString)
    {
      if (paramContext == null) {
        return;
      }
      parame1 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + parame2.latitude + "," + parame2.longitude));
      parame1.setPackage(getPackageName());
      parame1.addFlags(268435456);
      parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahE(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$NavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parame1.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$NavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    
    protected abstract String getPackageName();
  }
  
  static final class g
    extends h.f
  {
    private g()
    {
      super();
    }
    
    protected final void a(Context paramContext, h.e parame1, h.e parame2, String paramString)
    {
      AppMethodBeat.i(82040);
      if (paramContext == null)
      {
        super.a(paramContext, parame1, parame2, paramString);
        AppMethodBeat.o(82040);
        return;
      }
      Object localObject = String.format("wechatnav://type=nav&tocoord=%f,%f", new Object[] { Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) });
      if (parame1 != null)
      {
        String str = (String)localObject + String.format("&fromcoord=%f,%f", new Object[] { Double.valueOf(parame1.latitude), Double.valueOf(parame1.longitude) });
        localObject = str;
        if (!bu.isNullOrNil(parame1.EGa)) {
          localObject = str + String.format("&from=%s", new Object[] { URLEncoder.encode(parame1.EGa) });
        }
        parame1 = paramString;
        if (bu.isNullOrNil(paramString)) {
          if (bu.isNullOrNil(parame2.EGa)) {
            break label345;
          }
        }
      }
      label345:
      for (parame1 = parame2.EGa;; parame1 = "目的地")
      {
        parame1 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject + String.format("&to=%s", new Object[] { parame1 })));
        parame1.setPackage(com.tencent.mm.pluginsdk.model.c.a.Fec.getPackage());
        parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahE(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$SogouNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parame1.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$SogouNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(82040);
        return;
        localObject = (String)localObject + String.format("&from=%s", new Object[] { "我的位置" });
        break;
      }
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(224333);
      String str = com.tencent.mm.pluginsdk.model.c.a.Fec.getPackage();
      AppMethodBeat.o(224333);
      return str;
    }
  }
  
  static final class h
    extends h.f
  {
    private h()
    {
      super();
    }
    
    protected final void a(Context paramContext, h.e parame1, h.e parame2, String paramString)
    {
      AppMethodBeat.i(82042);
      if (paramContext == null)
      {
        super.a(paramContext, parame1, parame2, paramString);
        AppMethodBeat.o(82042);
        return;
      }
      String str2 = String.format("sosomap://type=nav&tocoord=%f,%f", new Object[] { Double.valueOf(parame2.longitude), Double.valueOf(parame2.latitude) });
      String str1 = str2;
      if (parame1 != null)
      {
        str2 = str2 + String.format("fromcoord=%f,%f", new Object[] { Double.valueOf(parame1.longitude), Double.valueOf(parame1.latitude) });
        str1 = str2;
        if (!bu.isNullOrNil(parame1.EGa)) {
          str1 = str2 + String.format("&from=%s", new Object[] { URLEncoder.encode(parame1.EGa) });
        }
      }
      parame1 = paramString;
      if (bu.isNullOrNil(paramString)) {
        if (bu.isNullOrNil(parame2.EGa)) {
          break label335;
        }
      }
      label335:
      for (parame1 = parame2.EGa;; parame1 = "地图选点")
      {
        parame1 = str1 + String.format("&to=%s", new Object[] { URLEncoder.encode(parame1) });
        parame1 = new Intent("android.intent.action.VIEW", Uri.parse(parame1 + "&referer=wx_client"));
        parame1.setPackage(com.tencent.mm.pluginsdk.model.c.a.Fea.getPackage());
        parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahE(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$TencentNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parame1.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$TencentNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(82042);
        return;
      }
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(224334);
      String str = com.tencent.mm.pluginsdk.model.c.a.Fea.getPackage();
      AppMethodBeat.o(224334);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.h
 * JD-Core Version:    0.7.0.1
 */