package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class k$5
  extends m
{
  private m vsI;
  
  k$5(k paramk)
  {
    AppMethodBeat.i(9942);
    this.vsI = new m();
    AppMethodBeat.o(9942);
  }
  
  private m dgY()
  {
    AppMethodBeat.i(9943);
    m localm = this.vsH.aGm();
    if (localm == null)
    {
      localm = this.vsI;
      AppMethodBeat.o(9943);
      return localm;
    }
    AppMethodBeat.o(9943);
    return localm;
  }
  
  public final boolean Ke(int paramInt)
  {
    AppMethodBeat.i(9944);
    boolean bool = dgY().Ke(paramInt);
    AppMethodBeat.o(9944);
    return bool;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(9946);
    if (this.vsH.foJ == null)
    {
      AppMethodBeat.o(9946);
      return true;
    }
    ab.i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + this.vsH.foJ.hashCode());
    int i = paramc.getType();
    int j = paramc.dcV();
    int k = paramc.getErrCode();
    String str = paramc.getErrMsg();
    Bundle localBundle = paramc.getData();
    this.vsH.mHandler.post(new k.5.8(this, i, j, k, str, localBundle));
    boolean bool = dgY().a(paramc);
    AppMethodBeat.o(9946);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(9947);
    if (this.vsH.vmp == null)
    {
      AppMethodBeat.o(9947);
      return false;
    }
    this.vsH.mHandler.post(new k.5.9(this, paramString1, paramString2, paramBundle, paramBoolean));
    dgY().a(paramString1, paramString2, paramBundle, paramBoolean);
    AppMethodBeat.o(9947);
    return false;
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(9954);
    dgY().af(paramBundle);
    AppMethodBeat.o(9954);
  }
  
  public final void ag(Bundle paramBundle)
  {
    AppMethodBeat.i(9960);
    dgY().ag(paramBundle);
    AppMethodBeat.o(9960);
  }
  
  public final void ahL(String paramString)
  {
    AppMethodBeat.i(9955);
    dgY().ahL(paramString);
    AppMethodBeat.o(9955);
  }
  
  public final String dcW()
  {
    return this.vsH.vsw;
  }
  
  public final String dcX()
  {
    AppMethodBeat.i(9949);
    String str = dgY().dcX();
    AppMethodBeat.o(9949);
    return str;
  }
  
  public final void dcZ()
  {
    AppMethodBeat.i(9953);
    if (this.vsH.vmp != null) {
      this.vsH.vmp.dcZ();
    }
    AppMethodBeat.o(9953);
  }
  
  public final void dda()
  {
    AppMethodBeat.i(9957);
    if (this.vsH.vmp != null) {
      this.vsH.vmp.dda();
    }
    AppMethodBeat.o(9957);
  }
  
  public final Bundle dm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9963);
    paramString1 = dgY().dm(paramString1, paramString2);
    AppMethodBeat.o(9963);
    return paramString1;
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9958);
    dgY().e(paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(9958);
  }
  
  public final boolean e(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(9945);
    ab.i("MicroMsg.MMWebViewClient", "callback, actionCode = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.MMWebViewClient", "undefine action code!!!");
    }
    for (;;)
    {
      dgY().e(paramInt, paramBundle);
      AppMethodBeat.o(9945);
      return true;
      this.vsH.mHandler.post(new k.5.1(this, paramBundle));
      continue;
      this.vsH.mHandler.post(new k.5.10(this, paramBundle));
      continue;
      this.vsH.mHandler.post(new k.5.11(this, paramBundle));
      continue;
      long l = paramBundle.getLong("download_manager_downloadid");
      final int i = paramBundle.getInt("download_manager_progress");
      float f = paramBundle.getFloat("download_manager_progress_float");
      Object localObject = paramBundle.getString("download_manager_appid", "");
      this.vsH.mHandler.post(new k.5.12(this, (String)localObject, l, i, f));
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.vsH.mHandler.post(new k.5.13(this, (String)localObject, i));
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.vsH.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9938);
          if (k.5.this.vsH.vmp != null) {
            k.5.this.vsH.vmp.dX(this.vdw, i);
          }
          AppMethodBeat.o(9938);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.vsH.mHandler.post(new k.5.15(this, (String)localObject, i));
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.vsH.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9940);
          if (k.5.this.vsH.vmp != null) {
            k.5.this.vsH.vmp.dZ(this.vdw, i);
          }
          AppMethodBeat.o(9940);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      i = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.vsH.mHandler.post(new k.5.17(this, (String)localObject, i));
      continue;
      localObject = new HashMap();
      ((Map)localObject).put("err_msg", paramBundle.getString("playResult"));
      ((Map)localObject).put("localId", paramBundle.getString("localId"));
      this.vsH.mHandler.post(new k.5.2(this, (Map)localObject));
      continue;
      localObject = new HashMap();
      ((Map)localObject).put("localId", paramBundle.getString("localId"));
      ((Map)localObject).put("err_msg", paramBundle.getString("recordResult"));
      this.vsH.mHandler.post(new k.5.3(this, (Map)localObject));
      continue;
      if (this.vsH.vmp != null)
      {
        this.vsH.mHandler.post(new k.5.4(this, paramBundle));
        continue;
        if (this.vsH.vmp != null)
        {
          this.vsH.mHandler.post(new k.5.5(this, paramBundle));
          continue;
          if (this.vsH.vmp != null)
          {
            localObject = paramBundle.getString("err_msg");
            this.vsH.mHandler.post(new k.5.6(this, (String)localObject));
            continue;
            localObject = paramBundle.getString("uuid");
            i = paramBundle.getInt("major");
            int j = paramBundle.getInt("minor");
            double d1 = paramBundle.getDouble("accuracy");
            double d2 = paramBundle.getDouble("rssi");
            f = paramBundle.getFloat("heading");
            if (this.vsH.vmp != null)
            {
              String str = paramBundle.getString("err_msg");
              this.vsH.mHandler.post(new k.5.7(this, str, (String)localObject, i, j, d1, d2, f));
            }
          }
        }
      }
    }
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(9948);
    String str = k.c(this.vsH);
    AppMethodBeat.o(9948);
    return str;
  }
  
  public final void hu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9956);
    dgY().hu(paramString1, paramString2);
    AppMethodBeat.o(9956);
  }
  
  public final void hv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9962);
    dgY().hv(paramString1, paramString2);
    AppMethodBeat.o(9962);
  }
  
  public final Bundle i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(9959);
    if (paramInt == 146)
    {
      Bundle localBundle = new Bundle();
      paramBundle = paramBundle.getString("_url");
      if (bo.isNullOrNil(paramBundle))
      {
        AppMethodBeat.o(9959);
        return localBundle;
      }
      paramBundle = this.vsH.voA.agS(paramBundle);
      if (paramBundle == null)
      {
        AppMethodBeat.o(9959);
        return localBundle;
      }
      localBundle.putParcelable("_permission_wrapper", paramBundle);
      AppMethodBeat.o(9959);
      return localBundle;
    }
    paramBundle = dgY().i(paramInt, paramBundle);
    AppMethodBeat.o(9959);
    return paramBundle;
  }
  
  public final void om(boolean paramBoolean)
  {
    AppMethodBeat.i(9950);
    dgY().om(paramBoolean);
    AppMethodBeat.o(9950);
  }
  
  public final void on(boolean paramBoolean)
  {
    AppMethodBeat.i(9951);
    dgY().on(paramBoolean);
    AppMethodBeat.o(9951);
  }
  
  public final void oo(boolean paramBoolean)
  {
    AppMethodBeat.i(9961);
    dgY().oo(paramBoolean);
    AppMethodBeat.o(9961);
  }
  
  public final void t(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(9952);
    dgY().t(paramInt, paramBundle);
    AppMethodBeat.o(9952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.5
 * JD-Core Version:    0.7.0.1
 */