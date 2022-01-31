package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;

public final class j
  implements MMActivity.a
{
  WeakReference<Context> aoB;
  c egs = null;
  b lIe = null;
  boolean rAP = false;
  int rAQ;
  j.e rAR;
  j.e rAS;
  String rAT;
  j.d rAU;
  b.a rAV = null;
  b.a rAW = null;
  com.tencent.mm.modelgeo.a.a rAX = null;
  final Runnable rAY = new j.1(this);
  int rhh;
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Context localContext = (Context)this.aoB.get();
    if ((this.rAU == null) || (localContext == null)) {}
    for (;;)
    {
      if ((this.rAP) && (this.rAU != null)) {
        this.rAU.Da(this.rhh);
      }
      this.rAP = false;
      this.rAQ = com.tencent.mm.pluginsdk.model.a.a.rTc.code;
      this.rAR = null;
      this.rAS = null;
      this.aoB = null;
      this.rAU = null;
      this.rAT = null;
      this.rAV = null;
      this.rAW = null;
      if ((this.egs != null) && (this.rAX != null)) {
        this.egs.c(this.rAX);
      }
      this.egs = null;
      this.rAX = null;
      if (this.lIe != null)
      {
        if (this.rAV != null) {
          this.lIe.a(this.rAV);
        }
        if (this.rAW != null) {
          this.lIe.a(this.rAW);
        }
      }
      this.lIe = null;
      this.rAV = null;
      this.rAW = null;
      return;
      if (!this.rAP)
      {
        y.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
      }
      else if (paramInt1 != 33)
      {
        y.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", new Object[] { Integer.valueOf(paramInt1) });
        this.rAU.onFail(this.rhh);
      }
      else if ((paramInt2 == 4097) || (paramInt2 == 0))
      {
        this.rAU.CZ(this.rhh);
      }
      else if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("selectpkg");
        if (bk.bl(paramIntent))
        {
          y.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
          this.rAU.onFail(this.rhh);
        }
        else
        {
          if (com.tencent.mm.pluginsdk.model.a.a.rTd.getPackage().equals(paramIntent)) {
            paramIntent = new j.c((byte)0);
          }
          for (;;)
          {
            paramIntent.a(localContext, this.rAR, this.rAS, this.rAT);
            this.rAU.onSuccess(this.rhh);
            break;
            if (com.tencent.mm.pluginsdk.model.a.a.rTf.getPackage().equals(paramIntent)) {
              paramIntent = new a((byte)0);
            } else if (com.tencent.mm.pluginsdk.model.a.a.rTe.getPackage().equals(paramIntent)) {
              paramIntent = new j.g((byte)0);
            } else if (com.tencent.mm.pluginsdk.model.a.a.rTg.getPackage().equals(paramIntent)) {
              paramIntent = new j.b((byte)0);
            } else {
              paramIntent = new h((byte)0);
            }
          }
        }
      }
      else
      {
        y.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", new Object[] { Integer.valueOf(paramInt2) });
        this.rAU.onFail(this.rhh);
      }
    }
  }
  
  final void cgC()
  {
    Context localContext = null;
    this.rAX = null;
    this.rAV = null;
    this.rAW = null;
    if (this.aoB == null) {}
    while (localContext == null)
    {
      return;
      localContext = (Context)this.aoB.get();
    }
    Intent localIntent = new Intent(localContext, AppChooserUI.class);
    Object localObject = new ArrayList(5);
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.a.a.rTc.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.a.a.rTd.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.a.a.rTe.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.a.a.rTf.getPackage());
    ((ArrayList)localObject).add(com.tencent.mm.pluginsdk.model.a.a.rTg.getPackage());
    localIntent.putStringArrayListExtra("targetwhitelist", (ArrayList)localObject);
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Double.valueOf(this.rAS.latitude), Double.valueOf(this.rAS.longitude) })));
    localIntent.putExtra("targetintent", (Parcelable)localObject);
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("key_map_app", this.rAQ);
    localBundle.putParcelable("key_target_intent", (Parcelable)localObject);
    localIntent.putExtra("key_recommend_params", localBundle);
    localIntent.putExtra("type", 2);
    localIntent.putExtra("title", localContext.getString(R.l.location_info_send_tip));
    ((MMActivity)localContext).b(this, localIntent, 33);
  }
  
  private static final class a
    extends j.f
  {
    private a()
    {
      super();
    }
    
    protected final void a(Context paramContext, j.e parame1, j.e parame2, String paramString)
    {
      if (paramContext == null)
      {
        super.a(paramContext, parame1, parame2, paramString);
        return;
      }
      paramString = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", new Object[] { Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) });
      parame2 = paramString;
      if (parame1 != null) {
        parame2 = paramString + String.format("origin=%f,%f", new Object[] { Double.valueOf(parame1.latitude), Double.valueOf(parame1.longitude) });
      }
      y.d("MicroMsg.OpenMapNavigator", "url " + parame2);
      try
      {
        paramContext.startActivity(Intent.parseUri(parame2 + "&src=webapp.car.carroutelistmappg.weixindrivenav", 0));
        return;
      }
      catch (URISyntaxException paramContext)
      {
        y.printErrStackTrace("MicroMsg.OpenMapNavigator", paramContext, "", new Object[0]);
      }
    }
    
    protected final String getPackageName()
    {
      return com.tencent.mm.pluginsdk.model.a.a.rTf.getPackage();
    }
  }
  
  private static final class h
    extends j.f
  {
    private h()
    {
      super();
    }
    
    protected final void a(Context paramContext, j.e parame1, j.e parame2, String paramString)
    {
      if (paramContext == null)
      {
        super.a(paramContext, parame1, parame2, paramString);
        return;
      }
      String str2 = String.format("sosomap://type=nav&tocoord=%f,%f", new Object[] { Double.valueOf(parame2.longitude), Double.valueOf(parame2.latitude) });
      String str1 = str2;
      if (parame1 != null)
      {
        str2 = str2 + String.format("fromcoord=%f,%f", new Object[] { Double.valueOf(parame1.longitude), Double.valueOf(parame1.latitude) });
        str1 = str2;
        if (!bk.bl(parame1.rBb)) {
          str1 = str2 + String.format("&from=%s", new Object[] { URLEncoder.encode(parame1.rBb) });
        }
      }
      parame1 = paramString;
      if (bk.bl(paramString)) {
        if (bk.bl(parame2.rBb)) {
          break label265;
        }
      }
      label265:
      for (parame1 = parame2.rBb;; parame1 = "地图选点")
      {
        parame1 = str1 + String.format("&to=%s", new Object[] { URLEncoder.encode(parame1) });
        parame1 = new Intent("android.intent.action.VIEW", Uri.parse(parame1 + "&referer=wx_client"));
        parame1.setPackage(com.tencent.mm.pluginsdk.model.a.a.rTc.getPackage());
        paramContext.startActivity(parame1);
        return;
      }
    }
    
    protected final String getPackageName()
    {
      return com.tencent.mm.pluginsdk.model.a.a.rTc.getPackage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j
 * JD-Core Version:    0.7.0.1
 */