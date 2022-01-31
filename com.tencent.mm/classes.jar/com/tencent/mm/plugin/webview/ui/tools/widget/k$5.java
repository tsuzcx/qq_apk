package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class k$5
  extends m
{
  private m rCw = new m();
  
  k$5(k paramk) {}
  
  private m cgR()
  {
    m localm2 = this.rCv.all();
    m localm1 = localm2;
    if (localm2 == null) {
      localm1 = this.rCw;
    }
    return localm1;
  }
  
  public final boolean Cl(int paramInt)
  {
    return cgR().Cl(paramInt);
  }
  
  public final void N(Bundle paramBundle)
  {
    cgR().N(paramBundle);
  }
  
  public final void O(Bundle paramBundle)
  {
    cgR().O(paramBundle);
  }
  
  public final void SJ(String paramString)
  {
    cgR().SJ(paramString);
  }
  
  public final boolean a(c paramc)
  {
    if (this.rCv.dYF == null) {
      return true;
    }
    y.i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + this.rCv.dYF.hashCode());
    final int i = paramc.getType();
    final int j = paramc.ccZ();
    final int k = paramc.cda();
    final String str = paramc.Lg();
    final Bundle localBundle = paramc.getData();
    this.rCv.mHandler.post(new Runnable()
    {
      public final void run()
      {
        try
        {
          k localk = k.5.this.rCv;
          int i = i;
          int j = j;
          int k = k;
          if (localBundle != null) {}
          for (Bundle localBundle = localBundle;; localBundle = new Bundle())
          {
            k.a(localk, i, j, k, localBundle);
            return;
          }
          return;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.MMWebViewClient", localException.getMessage());
        }
      }
    });
    return cgR().a(paramc);
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.rCv.rvZ == null) {
      return false;
    }
    this.rCv.mHandler.post(new k.5.9(this, paramString1, paramString2, paramBundle, paramBoolean));
    cgR().a(paramString1, paramString2, paramBundle, paramBoolean);
    return false;
  }
  
  public final boolean b(int paramInt, final Bundle paramBundle)
  {
    y.i("MicroMsg.MMWebViewClient", "callback, actionCode = " + paramInt);
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.MMWebViewClient", "undefine action code!!!");
    }
    for (;;)
    {
      cgR().b(paramInt, paramBundle);
      return true;
      this.rCv.mHandler.post(new Runnable()
      {
        public final void run()
        {
          if ((k.5.this.rCv.rvZ != null) && (k.5.this.rCv.rxH != null) && (k.5.this.rCv.rxH.cdI() != null) && (k.5.this.rCv.rxH.cdI().hi(42))) {
            k.5.this.rCv.rvZ.h(paramBundle, "download_succ");
          }
        }
      });
      continue;
      this.rCv.mHandler.post(new k.5.10(this, paramBundle));
      continue;
      this.rCv.mHandler.post(new k.5.11(this, paramBundle));
      continue;
      long l = paramBundle.getLong("download_manager_downloadid");
      final int i = paramBundle.getInt("download_manager_progress");
      Object localObject = paramBundle.getString("download_manager_appid", "");
      this.rCv.mHandler.post(new k.5.12(this, (String)localObject, l, i));
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.rCv.mHandler.post(new k.5.13(this, (String)localObject, i));
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.rCv.mHandler.post(new Runnable()
      {
        public final void run()
        {
          if (k.5.this.rCv.rvZ != null) {
            k.5.this.rCv.rvZ.cW(this.rpL, i);
          }
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.rCv.mHandler.post(new k.5.15(this, (String)localObject, i));
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.rCv.mHandler.post(new Runnable()
      {
        public final void run()
        {
          if (k.5.this.rCv.rvZ != null) {
            k.5.this.rCv.rvZ.cY(this.rpL, i);
          }
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.rCv.mHandler.post(new k.5.17(this, (String)localObject, i));
      continue;
      localObject = new HashMap();
      ((Map)localObject).put("err_msg", paramBundle.getString("playResult"));
      ((Map)localObject).put("localId", paramBundle.getString("localId"));
      this.rCv.mHandler.post(new k.5.2(this, (Map)localObject));
      continue;
      localObject = new HashMap();
      ((Map)localObject).put("localId", paramBundle.getString("localId"));
      ((Map)localObject).put("err_msg", paramBundle.getString("recordResult"));
      this.rCv.mHandler.post(new k.5.3(this, (Map)localObject));
      continue;
      if (this.rCv.rvZ != null)
      {
        this.rCv.mHandler.post(new k.5.4(this, paramBundle));
        continue;
        if (this.rCv.rvZ != null)
        {
          this.rCv.mHandler.post(new k.5.5(this, paramBundle));
          continue;
          if (this.rCv.rvZ != null)
          {
            localObject = paramBundle.getString("err_msg");
            this.rCv.mHandler.post(new k.5.6(this, (String)localObject));
            continue;
            localObject = paramBundle.getString("uuid");
            i = paramBundle.getInt("major");
            int j = paramBundle.getInt("minor");
            double d1 = paramBundle.getDouble("accuracy");
            double d2 = paramBundle.getDouble("rssi");
            float f = paramBundle.getFloat("heading");
            if (this.rCv.rvZ != null)
            {
              String str = paramBundle.getString("err_msg");
              this.rCv.mHandler.post(new k.5.7(this, str, (String)localObject, i, j, d1, d2, f));
            }
          }
        }
      }
    }
  }
  
  public final String cdb()
  {
    return this.rCv.rCk;
  }
  
  public final String cdc()
  {
    return cgR().cdc();
  }
  
  public final void cde()
  {
    if (this.rCv.rvZ != null) {
      this.rCv.rvZ.cde();
    }
  }
  
  public final void cdf()
  {
    if (this.rCv.rvZ != null) {
      this.rCv.rvZ.cdf();
    }
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    cgR().e(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public final Bundle f(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 146)
    {
      Bundle localBundle = new Bundle();
      paramBundle = paramBundle.getString("_url");
      if (bk.bl(paramBundle)) {}
      do
      {
        return localBundle;
        paramBundle = this.rCv.rxH.RP(paramBundle);
      } while (paramBundle == null);
      localBundle.putParcelable("_permission_wrapper", paramBundle);
      return localBundle;
    }
    return cgR().f(paramInt, paramBundle);
  }
  
  public final void fx(String paramString1, String paramString2)
  {
    cgR().fx(paramString1, paramString2);
  }
  
  public final void fy(String paramString1, String paramString2)
  {
    cgR().fy(paramString1, paramString2);
  }
  
  public final String getCurrentUrl()
  {
    return this.rCv.cdR();
  }
  
  public final void le(boolean paramBoolean)
  {
    cgR().le(paramBoolean);
  }
  
  public final void lf(boolean paramBoolean)
  {
    cgR().lf(paramBoolean);
  }
  
  public final void lg(boolean paramBoolean)
  {
    cgR().lg(paramBoolean);
  }
  
  public final void p(int paramInt, Bundle paramBundle)
  {
    cgR().p(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.5
 * JD-Core Version:    0.7.0.1
 */