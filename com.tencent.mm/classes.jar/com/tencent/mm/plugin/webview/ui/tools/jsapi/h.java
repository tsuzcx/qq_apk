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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;

public final class h
  implements MMActivity.a
{
  int EnJ;
  boolean EnK;
  int EnL;
  e EnM;
  e EnN;
  String EnO;
  d EnP;
  com.tencent.mm.modelgeo.c.a EnQ;
  com.tencent.mm.modelgeo.c.a EnR;
  b.a EnS;
  final Runnable EnT;
  WeakReference<Context> aWN;
  d hQo;
  c vfb;
  
  h()
  {
    AppMethodBeat.i(82045);
    this.EnK = false;
    this.vfb = null;
    this.EnQ = null;
    this.EnR = null;
    this.hQo = null;
    this.EnS = null;
    this.EnT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(82029);
        if ((h.this.EnS == null) || (h.this.hQo == null))
        {
          AppMethodBeat.o(82029);
          return;
        }
        h.this.vfb.a(h.this.EnQ);
        h.this.hQo.c(h.this.EnS);
        h.this.EnS.a(false, 0.0F, 0.0F, 0, 0.0D, 0.0D);
        AppMethodBeat.o(82029);
      }
    };
    AppMethodBeat.o(82045);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(82044);
    Context localContext = (Context)this.aWN.get();
    if ((this.EnP == null) || (localContext == null)) {}
    for (;;)
    {
      if ((this.EnK) && (this.EnP != null)) {
        this.EnP.XM(this.EnJ);
      }
      this.EnK = false;
      this.EnL = com.tencent.mm.pluginsdk.model.c.a.ELC.code;
      this.EnM = null;
      this.EnN = null;
      this.aWN = null;
      this.EnP = null;
      this.EnO = null;
      this.EnQ = null;
      this.EnR = null;
      if ((this.hQo != null) && (this.EnS != null)) {
        this.hQo.c(this.EnS);
      }
      this.hQo = null;
      this.EnS = null;
      if (this.vfb != null)
      {
        if (this.EnQ != null) {
          this.vfb.a(this.EnQ);
        }
        if (this.EnR != null) {
          this.vfb.a(this.EnR);
        }
      }
      this.vfb = null;
      this.EnQ = null;
      this.EnR = null;
      AppMethodBeat.o(82044);
      return;
      if (!this.EnK)
      {
        ad.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
      }
      else if (paramInt1 != 33)
      {
        ad.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", new Object[] { Integer.valueOf(paramInt1) });
        this.EnP.onFail(this.EnJ);
      }
      else if ((paramInt2 == 4097) || (paramInt2 == 0))
      {
        this.EnP.XL(this.EnJ);
      }
      else if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("selectpkg");
        if (bt.isNullOrNil(paramIntent))
        {
          ad.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
          this.EnP.onFail(this.EnJ);
        }
        else
        {
          if (com.tencent.mm.pluginsdk.model.c.a.ELD.getPackage().equals(paramIntent)) {
            paramIntent = new c((byte)0);
          }
          for (;;)
          {
            paramIntent.a(localContext, this.EnM, this.EnN, this.EnO);
            this.EnP.onSuccess(this.EnJ);
            break;
            if (com.tencent.mm.pluginsdk.model.c.a.ELF.getPackage().equals(paramIntent)) {
              paramIntent = new a((byte)0);
            } else if (com.tencent.mm.pluginsdk.model.c.a.ELE.getPackage().equals(paramIntent)) {
              paramIntent = new g((byte)0);
            } else if (com.tencent.mm.pluginsdk.model.c.a.ELG.getPackage().equals(paramIntent)) {
              paramIntent = new b((byte)0);
            } else {
              paramIntent = new h((byte)0);
            }
          }
        }
      }
      else
      {
        ad.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", new Object[] { Integer.valueOf(paramInt2) });
        this.EnP.onFail(this.EnJ);
      }
    }
  }
  
  final void eUO()
  {
    Context localContext = null;
    AppMethodBeat.i(82046);
    this.EnS = null;
    this.EnQ = null;
    this.EnR = null;
    if (this.aWN == null) {}
    while (localContext == null)
    {
      AppMethodBeat.o(82046);
      return;
      localContext = (Context)this.aWN.get();
    }
    Intent localIntent = new Intent(localContext, AppChooserUI.class);
    Object localObject = new ArrayList(5);
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.ELC.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.ELD.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.ELE.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.ELF.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.c.a.ELG.getPackage());
    localIntent.putStringArrayListExtra("targetwhitelist", (ArrayList)localObject);
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Double.valueOf(this.EnN.latitude), Double.valueOf(this.EnN.longitude) })));
    localIntent.putExtra("targetintent", (Parcelable)localObject);
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("key_map_app", this.EnL);
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
      ad.d("MicroMsg.OpenMapNavigator", "url ".concat(String.valueOf(parame2)));
      try
      {
        parame1 = new Intent("android.intent.action.VIEW", Uri.parse(parame2 + "&src=webapp.car.carroutelistmappg.weixindrivenav"));
        parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahp(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$BaiduNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parame1.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$BaiduNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(82034);
        return;
      }
      catch (Exception paramContext)
      {
        ad.printErrStackTrace("MicroMsg.OpenMapNavigator", paramContext, "", new Object[0]);
        AppMethodBeat.o(82034);
      }
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(82035);
      String str = com.tencent.mm.pluginsdk.model.c.a.ELF.getPackage();
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
      parame1.setPackage(com.tencent.mm.pluginsdk.model.c.a.ELG.getPackage());
      parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahp(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GaodeNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parame1.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GaodeNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(82036);
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(221661);
      String str = com.tencent.mm.pluginsdk.model.c.a.ELG.getPackage();
      AppMethodBeat.o(221661);
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
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahp(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GoogleNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parame1.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$GoogleNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(82038);
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(82039);
      String str = com.tencent.mm.pluginsdk.model.c.a.ELD.getPackage();
      AppMethodBeat.o(82039);
      return str;
    }
  }
  
  static abstract interface d
  {
    public abstract void XL(int paramInt);
    
    public abstract void XM(int paramInt);
    
    public abstract void onFail(int paramInt);
    
    public abstract void onSuccess(int paramInt);
  }
  
  static final class e
  {
    String EnW;
    double latitude;
    double longitude;
    
    private e(double paramDouble1, double paramDouble2)
    {
      this.latitude = paramDouble1;
      this.longitude = paramDouble2;
      this.EnW = null;
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
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahp(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$NavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parame1.mq(0));
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
        if (!bt.isNullOrNil(parame1.EnW)) {
          localObject = str + String.format("&from=%s", new Object[] { URLEncoder.encode(parame1.EnW) });
        }
        parame1 = paramString;
        if (bt.isNullOrNil(paramString)) {
          if (bt.isNullOrNil(parame2.EnW)) {
            break label345;
          }
        }
      }
      label345:
      for (parame1 = parame2.EnW;; parame1 = "目的地")
      {
        parame1 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject + String.format("&to=%s", new Object[] { parame1 })));
        parame1.setPackage(com.tencent.mm.pluginsdk.model.c.a.ELE.getPackage());
        parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahp(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$SogouNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parame1.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$SogouNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(82040);
        return;
        localObject = (String)localObject + String.format("&from=%s", new Object[] { "我的位置" });
        break;
      }
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(221662);
      String str = com.tencent.mm.pluginsdk.model.c.a.ELE.getPackage();
      AppMethodBeat.o(221662);
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
        if (!bt.isNullOrNil(parame1.EnW)) {
          str1 = str2 + String.format("&from=%s", new Object[] { URLEncoder.encode(parame1.EnW) });
        }
      }
      parame1 = paramString;
      if (bt.isNullOrNil(paramString)) {
        if (bt.isNullOrNil(parame2.EnW)) {
          break label335;
        }
      }
      label335:
      for (parame1 = parame2.EnW;; parame1 = "地图选点")
      {
        parame1 = str1 + String.format("&to=%s", new Object[] { URLEncoder.encode(parame1) });
        parame1 = new Intent("android.intent.action.VIEW", Uri.parse(parame1 + "&referer=wx_client"));
        parame1.setPackage(com.tencent.mm.pluginsdk.model.c.a.ELC.getPackage());
        parame1 = new com.tencent.mm.hellhoundlib.b.a().bc(parame1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parame1.ahp(), "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$TencentNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parame1.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$TencentNavigateJumper", "goNavigate", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/OpenMapNavigator$Location;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(82042);
        return;
      }
    }
    
    protected final String getPackageName()
    {
      AppMethodBeat.i(221663);
      String str = com.tencent.mm.pluginsdk.model.c.a.ELC.getPackage();
      AppMethodBeat.o(221663);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.h
 * JD-Core Version:    0.7.0.1
 */