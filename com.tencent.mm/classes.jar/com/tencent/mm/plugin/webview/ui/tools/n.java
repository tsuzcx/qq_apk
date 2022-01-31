package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.m.d.b;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.webview.model.ah.b;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.preload.f;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.67;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.xweb.WebView.d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class n
  extends e.a
{
  private final WeakReference<WebViewUI> uZU;
  
  public n(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(7774);
    this.uZU = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(7774);
  }
  
  private float aNP()
  {
    AppMethodBeat.i(153232);
    float f = com.tencent.mm.cc.a.dqZ();
    if ((((WebViewUI)this.uZU.get()).pOd != null) && (((WebViewUI)this.uZU.get()).pOd.getWebCoreType() == WebView.d.BEq) && (XWalkEnvironment.getUsingCustomContext())) {
      f = ((WebViewUI)this.uZU.get()).pOd.getResources().getDisplayMetrics().density;
    }
    for (;;)
    {
      AppMethodBeat.o(153232);
      return f;
    }
  }
  
  private int aio(String paramString)
  {
    AppMethodBeat.i(7793);
    int i = ((WebViewUI)this.uZU.get()).aio(paramString);
    AppMethodBeat.o(7793);
    return i;
  }
  
  private Intent getIntent()
  {
    AppMethodBeat.i(7792);
    Intent localIntent = ((WebViewUI)this.uZU.get()).getIntent();
    AppMethodBeat.o(7792);
    return localIntent;
  }
  
  public final boolean Ke(int paramInt)
  {
    AppMethodBeat.i(7777);
    al.d(new n.30(this, paramInt));
    AppMethodBeat.o(7777);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.stub.c paramc)
  {
    AppMethodBeat.i(7776);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7776);
      return false;
    }
    if ((((WebViewUI)this.uZU.get()).vfc.deS()) || (((WebViewUI)this.uZU.get()).vfd.deS()) || (((WebViewUI)this.uZU.get()).vfe.deS()) || (((WebViewUI)this.uZU.get()).vgv.dbU())) {
      al.d(new n.29(this, paramc));
    }
    AppMethodBeat.o(7776);
    return true;
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(7778);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7778);
      return false;
    }
    if (((WebViewUI)this.uZU.get()).uQS != null)
    {
      paramString1 = new n.31(this, paramString1, paramString2, paramBundle, paramBoolean);
      if (!al.isMainThread()) {
        break label90;
      }
      paramString1.run();
    }
    for (;;)
    {
      AppMethodBeat.o(7778);
      return false;
      label90:
      al.d(paramString1);
    }
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(7786);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7786);
      return;
    }
    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "IUIController, closeWindow");
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_data", paramBundle);
      ((WebViewUI)this.uZU.get()).setResult(-1, localIntent);
    }
    ((WebViewUI)this.uZU.get()).finish();
    AppMethodBeat.o(7786);
  }
  
  public final void ag(Bundle paramBundle)
  {
    AppMethodBeat.i(7795);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7795);
      return;
    }
    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "setCustomMenu");
    Object localObject = paramBundle.getStringArrayList("keys");
    ArrayList localArrayList = paramBundle.getStringArrayList("titles");
    int j = ((ArrayList)localObject).size();
    paramBundle = new ArrayList();
    int i = 0;
    while (i < j)
    {
      paramBundle.add(new d.b((String)((ArrayList)localObject).get(i), (String)localArrayList.get(i)));
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((WebViewUI)this.uZU.get()).pOd.getUrl();
      if (((WebViewUI)this.uZU.get()).vfm.containsKey(localObject)) {
        ((WebViewUI)this.uZU.get()).vfm.remove(localObject);
      }
      ((WebViewUI)this.uZU.get()).vfm.put(localObject, paramBundle);
    }
    AppMethodBeat.o(7795);
  }
  
  public final void ahL(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(7787);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7787);
      return;
    }
    try
    {
      int j = bo.getInt(paramString, 0);
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb, ex = " + paramString.getMessage());
      }
      al.d(new n.35(this, i));
      AppMethodBeat.o(7787);
    }
    if (((WebViewUI)this.uZU.get()).pOd == null)
    {
      ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb fail, viewWV is null");
      AppMethodBeat.o(7787);
      return;
    }
  }
  
  public final String dcW()
  {
    AppMethodBeat.i(7779);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7779);
      return null;
    }
    String str = ((WebViewUI)this.uZU.get()).cJr;
    AppMethodBeat.o(7779);
    return str;
  }
  
  public final String dcX()
  {
    AppMethodBeat.i(7781);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7781);
      return null;
    }
    String str = ((WebViewUI)this.uZU.get()).getIntent().getStringExtra("srcUsername");
    AppMethodBeat.o(7781);
    return str;
  }
  
  public final int dcY()
  {
    AppMethodBeat.i(7782);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7782);
      return 0;
    }
    int i = ((WebViewUI)this.uZU.get()).cNH;
    AppMethodBeat.o(7782);
    return i;
  }
  
  public final void dcZ()
  {
    AppMethodBeat.i(7785);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7785);
      return;
    }
    if (((WebViewUI)this.uZU.get()).uQS != null) {
      ((WebViewUI)this.uZU.get()).uQS.dcZ();
    }
    AppMethodBeat.o(7785);
  }
  
  public final void dda()
  {
    AppMethodBeat.i(7788);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7788);
      return;
    }
    if (((WebViewUI)this.uZU.get()).uQS != null) {
      ((WebViewUI)this.uZU.get()).uQS.dda();
    }
    AppMethodBeat.o(7788);
  }
  
  public final Bundle dm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7798);
    paramString1 = com.tencent.mm.protocal.c.anl(null);
    AppMethodBeat.o(7798);
    return paramString1;
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7789);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7789);
      return;
    }
    ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "result: ".concat(String.valueOf(paramString2)));
    if ((((WebViewUI)this.uZU.get()).vfR.iha == null) || (paramString1 == null) || (!paramString1.equals(((WebViewUI)this.uZU.get()).vfR.iha.uYi)))
    {
      AppMethodBeat.o(7789);
      return;
    }
    if (((WebViewUI)this.uZU.get()).vfR.iha != null) {
      ((WebViewUI)this.uZU.get()).vfR.iha.dcJ();
    }
    if ((paramString2 == null) || (((WebViewUI)this.uZU.get()).vfR == null))
    {
      AppMethodBeat.o(7789);
      return;
    }
    al.d(new n.36(this, paramString2, paramInt1, paramInt2));
    AppMethodBeat.o(7789);
  }
  
  public final boolean e(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(7775);
    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "callback, actionCode = ".concat(String.valueOf(paramInt)));
    Object localObject1 = (WebViewUI)this.uZU.get();
    if ((localObject1 == null) || (((WebViewUI)localObject1).isFinishing()))
    {
      AppMethodBeat.o(7775);
      return false;
    }
    Object localObject2 = ((WebViewUI)localObject1).uQS;
    Object localObject3 = ((WebViewUI)localObject1).igV;
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(7775);
      return true;
      if (!((WebViewUI)localObject1).isFinishing())
      {
        ((WebViewUI)localObject1).finish();
        continue;
        al.d(new n.1(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (k)localObject3, paramBundle));
        continue;
        al.d(new n.12(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (k)localObject3, paramBundle));
        continue;
        al.d(new n.23(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (k)localObject3, paramBundle));
        continue;
        al.d(new n.34(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (k)localObject3, paramBundle));
        continue;
        al.d(new n.45(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (k)localObject3, paramBundle));
        continue;
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(7770);
            if ((this.vdo == null) || (this.vdo.isFinishing()))
            {
              AppMethodBeat.o(7770);
              return;
            }
            if ((this.vdp != null) && (this.vdq != null) && (this.vdq.ddV() != null) && (this.vdq.ddV().jy(42))) {
              this.vdp.i(paramBundle, "download_start");
            }
            AppMethodBeat.o(7770);
          }
        });
        continue;
        long l = paramBundle.getLong("download_manager_downloadid");
        paramInt = paramBundle.getInt("download_manager_progress");
        float f = paramBundle.getFloat("download_manager_progress_float");
        al.d(new n.57(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (k)localObject3, paramBundle.getString("download_manager_appid", ""), l, paramInt, f));
        continue;
        al.d(new n.58(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (k)localObject3, paramBundle.getString("exdevice_device_id"), paramBundle.getInt("exdevice_on_state_change_state"), Boolean.valueOf(paramBundle.getBoolean("exdevice_inner_call"))));
        continue;
        al.d(new n.59(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("webview_jssdk_file_item_local_id"), paramBundle.getInt("webview_jssdk_file_item_progreess")));
        continue;
        al.d(new n.2(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("webview_jssdk_file_item_local_id"), paramBundle.getInt("webview_jssdk_file_item_progreess")));
        continue;
        al.d(new n.3(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("background_audio_state_player_state"), paramBundle.getInt("background_audio_state_player_duration"), paramBundle.getString("background_audio_state_player_src"), paramBundle.getInt("background_audio_state_player_err_code"), paramBundle.getString("background_audio_state_player_err_msg"), paramBundle.getString("background_audio_state_player_src_id")));
        continue;
        if (paramBundle != null)
        {
          paramBundle.putString("application_language", ((WebViewUI)localObject1).igU.getLanguage());
          ((WebViewUI)localObject1).vfo = WebViewUI.d.am(paramBundle);
          continue;
          al.d(new n.4(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("webview_jssdk_file_item_local_id"), paramBundle.getInt("webview_jssdk_file_item_progreess")));
          continue;
          al.d(new n.5(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("webview_jssdk_file_item_local_id"), paramBundle.getInt("webview_jssdk_file_item_progreess")));
          continue;
          al.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(7718);
              if ((this.vdo == null) || (this.vdo.isFinishing()))
              {
                AppMethodBeat.o(7718);
                return;
              }
              if (this.vdp != null) {
                this.vdp.dZ(this.vdw, this.gAL);
              }
              AppMethodBeat.o(7718);
            }
          });
          continue;
          al.d(new n.7(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("webview_jssdk_file_item_local_id"), paramBundle.getInt("webview_jssdk_file_item_progreess")));
          continue;
          localObject3 = new HashMap();
          ((Map)localObject3).put("err_msg", paramBundle.getString("playResult"));
          ((Map)localObject3).put("localId", paramBundle.getString("localId"));
          al.d(new n.8(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (Map)localObject3));
          continue;
          al.d(new n.9(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getInt("nfc_key_on_touch_errcode", 0)));
          continue;
          al.d(new n.10(this, (WebViewUI)localObject1));
          continue;
          localObject3 = new HashMap();
          ((Map)localObject3).put("localId", paramBundle.getString("localId"));
          ((Map)localObject3).put("err_msg", paramBundle.getString("recordResult"));
          al.d(new n.11(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (Map)localObject3));
          continue;
          al.d(new n.13(this, (WebViewUI)localObject1));
          continue;
          if (localObject2 != null)
          {
            al.d(new n.14(this, (WebViewUI)localObject1, paramBundle, (k)localObject3, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2));
            continue;
            Object localObject4 = paramBundle.getString("exdevice_device_id");
            boolean bool = paramBundle.getBoolean("exdevice_is_complete");
            al.d(new n.15(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (String)localObject4, paramBundle.getByteArray("exdevice_broadcast_data"), bool, paramBundle.getBoolean("exdevice_is_lan_device"), (k)localObject3));
            continue;
            localObject3 = paramBundle.getString("exdevice_device_id");
            localObject4 = paramBundle.getString("exdevice_brand_name");
            al.d(new n.16(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, (String)localObject3, paramBundle.getByteArray("exdevice_data"), (String)localObject4));
            continue;
            al.d(new n.17(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("exdevice_device_id"), paramBundle.getBoolean("exdevice_is_bound")));
            continue;
            al.d(new n.18(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getBoolean("exdevice_bt_state")));
            continue;
            al.d(new n.19(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getBoolean("exdevice_lan_state")));
            continue;
            al.d(new n.20(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("err_msg")));
            continue;
            al.d(new n.21(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("uuid"), paramBundle.getInt("major"), paramBundle.getInt("minor"), paramBundle.getDouble("accuracy"), paramBundle.getDouble("rssi"), paramBundle.getFloat("heading")));
            continue;
            if ((localObject1 != null) && (!((WebViewUI)localObject1).isFinishing()))
            {
              ((WebViewUI)localObject1).l(paramInt, paramBundle);
              continue;
              ((WebViewUI)localObject1).w(paramInt, paramBundle);
              continue;
              localObject3 = paramBundle.getStringArray("msgIds");
              localObject4 = paramBundle.getStringArray("contents");
              String[] arrayOfString = paramBundle.getStringArray("senders");
              int[] arrayOfInt = paramBundle.getIntArray("msgTypes");
              paramBundle = paramBundle.getIntArray("msgTimes");
              JSONArray localJSONArray = new JSONArray();
              if (localObject3 == null) {
                paramInt = 0;
              }
              for (;;)
              {
                int i = 0;
                label1982:
                if (i < paramInt) {
                  try
                  {
                    JSONObject localJSONObject = new JSONObject();
                    localJSONObject.put("newMsgId", localObject3[i]);
                    localJSONObject.put("content", localObject4[i]);
                    localJSONObject.put("sender", arrayOfString[i]);
                    localJSONObject.put("msgType", arrayOfInt[i]);
                    localJSONObject.put("msgTime", paramBundle[i]);
                    localJSONArray.put(localJSONObject);
                    i += 1;
                    break label1982;
                    paramInt = localObject3.length;
                  }
                  catch (JSONException localJSONException)
                  {
                    for (;;)
                    {
                      ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetMsgProofItems exception " + localJSONException.getMessage());
                    }
                  }
                }
              }
              al.d(new n.22(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, localJSONArray));
              continue;
              al.d(new n.24(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("webview_network_type")));
              continue;
              al.d(new n.25(this, (WebViewUI)localObject1, paramBundle));
              continue;
              paramBundle = paramBundle.getString("service_click_tid");
              ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, update tid = %s", new Object[] { paramBundle });
              ((WebViewUI)localObject1).vfW = paramBundle;
              ((WebViewUI)localObject1).vfX = System.currentTimeMillis();
              al.d(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(7738);
                  if ((this.vdo == null) || (this.vdo.isFinishing()))
                  {
                    AppMethodBeat.o(7738);
                    return;
                  }
                  if (this.vdo.pOd != null)
                  {
                    com.tencent.mm.plugin.normsg.a.b.pgQ.a(this.vdo.pOd, qo.class);
                    if (this.vdo.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false))
                    {
                      ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, test");
                      com.tencent.mm.sdk.b.a.ymk.l(new qo());
                    }
                  }
                  AppMethodBeat.o(7738);
                }
              });
              continue;
              localObject2 = paramBundle.getString("wxa_nick_name");
              paramBundle = paramBundle.getString("wxa_head_img_url");
              localObject1 = ((WebViewUI)localObject1).vfR;
              ab.i("MicroMsg.WebViewLongClickHelper", "onGetWXACodeInfo");
              ((i)localObject1).vcz = ((String)localObject2);
              ((i)localObject1).vcA = paramBundle;
              if (((i)localObject1).hzQ.isShowing())
              {
                ((i)localObject1).ddI();
                continue;
                al.d(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(7739);
                    if ((this.vdo == null) || (this.vdo.isFinishing()))
                    {
                      AppMethodBeat.o(7739);
                      return;
                    }
                    if (this.vdp != null)
                    {
                      com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald = this.vdp;
                      String str = this.vdK;
                      int i = this.vdL;
                      HashMap localHashMap = new HashMap();
                      localHashMap.put("postId", str);
                      localHashMap.put("result", Integer.valueOf(i));
                      al.d(new d.67(locald, i.a.b("onPublishHaowanEnd", localHashMap, locald.voB, locald.voC)));
                    }
                    AppMethodBeat.o(7739);
                  }
                });
                continue;
                al.d(new n.28(this, (WebViewUI)localObject1, (com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject2, paramBundle.getString("game_haowan_publish_post_id"), paramBundle.getFloat("game_haowan_publish_progress")));
              }
            }
          }
        }
      }
    }
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(7780);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7780);
      return null;
    }
    String str = ((WebViewUI)this.uZU.get()).dek();
    AppMethodBeat.o(7780);
    return str;
  }
  
  public final void hu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7791);
    al.d(new n.38(this, paramString1));
    AppMethodBeat.o(7791);
  }
  
  public final void hv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7797);
    al.d(new n.55(this, paramString1, paramString2));
    AppMethodBeat.o(7797);
  }
  
  public final Bundle i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7794);
    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "invokeAsResult, actionCode = ".concat(String.valueOf(paramInt)));
    Bundle localBundle = new Bundle();
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7794);
      return localBundle;
    }
    k localk = ((WebViewUI)this.uZU.get()).igV;
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(7794);
      return localBundle;
      ((WebViewUI)this.uZU.get()).vfN = true;
      continue;
      Object localObject1 = new com.tencent.mm.g.a.j();
      ((com.tencent.mm.g.a.j)localObject1).cmo.context = ((WebViewUI)this.uZU.get()).getContext();
      ((com.tencent.mm.g.a.j)localObject1).cmo.actionCode = paramInt;
      if (4003 == paramInt)
      {
        paramBundle = paramBundle.getString("apdu");
        ((com.tencent.mm.g.a.j)localObject1).cmo.cmq = paramBundle;
      }
      Object localObject2;
      boolean bool1;
      for (;;)
      {
        ((com.tencent.mm.g.a.j)localObject1).callback = new n.39(this, localBundle, (com.tencent.mm.g.a.j)localObject1);
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        break;
        if (4004 == paramInt)
        {
          localObject2 = paramBundle.getString("apdus");
          bool1 = paramBundle.getBoolean("breakIfFail", true);
          boolean bool2 = paramBundle.getBoolean("breakIfTrue", false);
          ((com.tencent.mm.g.a.j)localObject1).cmo.cmq = ((String)localObject2);
          ((com.tencent.mm.g.a.j)localObject1).cmo.cmr = bool1;
          ((com.tencent.mm.g.a.j)localObject1).cmo.cms = bool2;
        }
      }
      localBundle.putString("KPublisherId", ((WebViewUI)this.uZU.get()).cGT);
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        paramInt = aio(getIntent().getStringExtra("geta8key_username"));
        localBundle.putString("preChatName", paramBundle.getStringExtra("preChatName"));
        localBundle.putInt("preMsgIndex", paramBundle.getIntExtra("preMsgIndex", 0));
        localBundle.putString("prePublishId", paramBundle.getStringExtra("prePublishId"));
        localBundle.putString("preUsername", paramBundle.getStringExtra("preUsername"));
        localBundle.putInt("getA8KeyScene", paramInt);
        localBundle.putString("referUrl", ((WebViewUI)this.uZU.get()).uXd);
        localBundle.putString("url", ((WebViewUI)this.uZU.get()).dek());
        localBundle.putString("rawUrl", ((WebViewUI)this.uZU.get()).cJr);
        localBundle.putInt("preChatTYPE", getIntent().getIntExtra("preChatTYPE", 0));
        paramBundle = (WebViewUI)this.uZU.get();
        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).GI(paramBundle.daZ()))
        {
          localBundle.putInt("_DATA_CENTER_ITEM_SHOW_TYPE", paramBundle.vez);
          continue;
          localBundle.putString("KSessionId", ((WebViewUI)this.uZU.get()).cpW);
          localBundle.putString("KUserAgent", ((WebViewUI)this.uZU.get()).iyo);
          localBundle.putBoolean("KReportPage", ((WebViewUI)this.uZU.get()).veA);
          localBundle.putString("KUrl", ((WebViewUI)this.uZU.get()).dek());
          paramInt = aio(getIntent().getStringExtra("geta8key_username"));
          if ((paramInt == 7) || (paramInt == 56))
          {
            localBundle.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
            continue;
            paramBundle = getIntent();
            if (paramBundle != null)
            {
              localBundle.putString("publishIdPrefix", paramBundle.getStringExtra("publishIdPrefix"));
              localBundle.putString("reportSessionId", paramBundle.getStringExtra("reportSessionId"));
              continue;
              paramBundle = paramBundle.getString("_url");
              if ((!bo.isNullOrNil(paramBundle)) && (((WebViewUI)this.uZU.get()).igV != null) && (localk != null))
              {
                paramBundle = localk.agS(paramBundle);
                if (paramBundle != null)
                {
                  localBundle.putParcelable("_permission_wrapper", paramBundle);
                  continue;
                  localBundle.putInt("pay_channel", getIntent().getIntExtra("pay_channel", -1));
                  ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay channel(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)) });
                  continue;
                  localBundle.putInt("scene", getIntent().getIntExtra("scene", -1));
                  ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: Scene(%d)", new Object[] { Integer.valueOf(getIntent().getIntExtra("scene", 0)) });
                  continue;
                  paramInt = getIntent().getIntExtra("geta8key_scene", 0);
                  localBundle.putInt("geta8key_scene", paramInt);
                  ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramInt) });
                  continue;
                  if (((WebViewUI)this.uZU.get()).igU.isSDCardAvailable())
                  {
                    long l = bd.dtH();
                    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "availableSize = %d", new Object[] { Long.valueOf(l) });
                    if (l < 524288000L)
                    {
                      ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "available size not enough");
                      label1508:
                      paramInt = FactoryProxyManager.getPlayManager().init(ah.getContext(), null);
                    }
                  }
                  for (;;)
                  {
                    if (paramInt == 0)
                    {
                      if (((WebViewUI)this.uZU.get()).vfT == null)
                      {
                        ((WebViewUI)this.uZU.get()).vfT = new h((WebViewUI)this.uZU.get());
                        FactoryProxyManager.getPlayManager().setUtilsObject(((WebViewUI)this.uZU.get()).vfT);
                      }
                      i = FactoryProxyManager.getPlayManager().getLocalServerPort();
                      ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview video init result = %d, local port = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                      paramBundle = ((WebViewUI)this.uZU.get()).vfZ;
                      if ((i <= 0) || (i > 65535)) {
                        ab.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[] { Integer.valueOf(i) });
                      }
                      if (!paramBundle.uWp.contains(Integer.valueOf(i))) {
                        paramBundle.uWp.add(Integer.valueOf(i));
                      }
                    }
                    localBundle.putInt("webview_video_proxy_init", paramInt);
                    break;
                    paramBundle = new File(com.tencent.mm.plugin.webview.a.uNC);
                    bool1 = true;
                    if (!paramBundle.exists())
                    {
                      bool1 = paramBundle.mkdirs();
                      ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "create proxy cache path : %s, %b", new Object[] { paramBundle.getAbsolutePath(), Boolean.valueOf(bool1) });
                    }
                    if (!bool1) {
                      break label1508;
                    }
                    paramInt = FactoryProxyManager.getPlayManager().init(ah.getContext(), com.tencent.mm.plugin.webview.a.uNC);
                    FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
                    continue;
                    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "sdcard not available");
                    paramInt = FactoryProxyManager.getPlayManager().init(ah.getContext(), null);
                  }
                  localObject1 = paramBundle.getString("webview_video_proxy_cdn_urls");
                  localObject2 = paramBundle.getString("webview_video_proxy_fileId");
                  paramInt = paramBundle.getInt("webview_video_proxy_file_size");
                  int i = paramBundle.getInt("webview_video_proxy_file_duration");
                  int j = paramBundle.getInt("webview_video_proxy_file_type");
                  int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramInt, i);
                  paramBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
                  ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramBundle });
                  localBundle.putInt("webview_video_proxy_play_data_id", k);
                  localBundle.putString("webview_video_proxy_local_url", paramBundle);
                  continue;
                  paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                  ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramInt) });
                  if (paramInt > 0)
                  {
                    FactoryProxyManager.getPlayManager().stopPlay(paramInt);
                    continue;
                    paramInt = paramBundle.getInt("webview_video_proxy_play_state");
                    FactoryProxyManager.getPlayManager().setPlayerState(paramInt);
                    continue;
                    paramInt = paramBundle.getInt("webview_video_proxy_net_state");
                    FactoryProxyManager.getPlayManager().setNetWorkState(paramInt);
                    continue;
                    paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                    i = paramBundle.getInt("webview_video_proxy_play_remain_time");
                    FactoryProxyManager.getPlayManager().setRemainTime(paramInt, i);
                    continue;
                    paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                    i = paramBundle.getInt("webview_video_proxy_preload_duration");
                    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                    localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramInt, i));
                    continue;
                    if (paramBundle.getInt("webview_disable_bounce_scroll_top", 0) > 0)
                    {
                      al.d(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(7753);
                          if ((n.a(n.this).get() == null) || (((WebViewUI)n.a(n.this).get()).isFinishing()))
                          {
                            AppMethodBeat.o(7753);
                            return;
                          }
                          ((WebViewUI)n.a(n.this).get()).vgh.op(true);
                          AppMethodBeat.o(7753);
                        }
                      });
                      continue;
                      al.d(new n.41(this));
                      continue;
                      al.d(new n.42(this));
                      continue;
                      al.d(new n.43(this));
                      continue;
                      al.d(new n.44(this));
                      continue;
                      al.d(new n.46(this));
                      continue;
                      al.d(new n.47(this, paramBundle.getString("show_kb_placeholder"), paramBundle.getInt("show_kb_max_length")));
                      continue;
                      if ((this.uZU.get() != null) && (!((WebViewUI)this.uZU.get()).isFinishing()))
                      {
                        localBundle.putInt("height", ((WebViewUI)this.uZU.get()).daT());
                        continue;
                        localObject1 = paramBundle.getString("set_page_title_text");
                        paramBundle = paramBundle.getString("set_page_title_color");
                        localObject2 = (WebViewUI)this.uZU.get();
                        if ((com.tencent.mm.compatible.util.d.fv(21)) && (((WebViewUI)localObject2).dei())) {}
                        for (paramInt = -16777216;; paramInt = ((WebViewUI)localObject2).getResources().getColor(2131689642))
                        {
                          g.by(paramBundle, paramInt);
                          al.d(new n.48(this, (String)localObject1));
                          break;
                        }
                        localObject2 = paramBundle.getString("set_navigation_bar_buttons_text");
                        localObject1 = paramBundle.getString("set_navigation_bar_buttons_icon_data");
                        bool1 = paramBundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                        if (!bo.isNullOrNil((String)localObject1)) {}
                        for (;;)
                        {
                          try
                          {
                            localObject1 = g.aig((String)localObject1);
                            paramInt = g.by(paramBundle.getString("set_navigation_bar_buttons_left_text_color"), -16777216);
                            al.d(new n.49(this, bool1, (Bitmap)localObject1, (String)localObject2, paramBundle.getBoolean("set_navigation_bar_buttons_need_click_event", false), (int)g.aif(paramBundle.getString("set_navigation_bar_buttons_text_color")), paramInt));
                          }
                          catch (Exception localException)
                          {
                            localObject1 = null;
                            ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { localException });
                            continue;
                          }
                          localObject1 = null;
                        }
                        al.d(new n.50(this, paramBundle));
                        continue;
                        if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
                        {
                          localBundle.putBoolean("isFullScreen", false);
                        }
                        else
                        {
                          localBundle.putBoolean("isFullScreen", ((WebViewUI)this.uZU.get()).ven);
                          continue;
                          al.d(new n.51(this));
                          continue;
                          al.d(new n.52(this));
                          continue;
                          bool1 = paramBundle.getBoolean("clear_webview_cache_clear_cookie", false);
                          ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "includeCookie = %b", new Object[] { Boolean.valueOf(bool1) });
                          paramBundle = new Intent();
                          paramBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                          paramBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool1);
                          com.tencent.mm.cn.d.aX(paramBundle);
                          continue;
                          if (paramBundle.getString("enterprise_action").equals("enterprise_get_context_bizchat"))
                          {
                            localBundle.putString("enterprise_context_biz", getIntent().getStringExtra("enterprise_biz_name"));
                            localBundle.putLong("enterprise_context_bizchatid", getIntent().getLongExtra("biz_chat_chat_id", -1L));
                            continue;
                            paramInt = g.by(paramBundle.getString("key_set_bounce_background_color"), ((WebViewUI)this.uZU.get()).getResources().getColor(2131690695));
                            ((WebViewUI)this.uZU.get()).vgh.Kw(paramInt);
                            continue;
                            localObject1 = getIntent();
                            if (paramBundle != null)
                            {
                              paramInt = paramBundle.getInt("scene");
                              switch (paramInt)
                              {
                              default: 
                                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "unknown expose scene: %d", new Object[] { Integer.valueOf(paramInt) });
                              }
                              for (;;)
                              {
                                localBundle.putString("username", ((Intent)localObject1).getStringExtra("k_username"));
                                break;
                                localBundle.putStringArrayList("proof", ((Intent)localObject1).getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                continue;
                                localBundle.putString("newMsgId", String.valueOf(((Intent)localObject1).getLongExtra("k_expose_msg_id", 0L)));
                                continue;
                                if (!bo.isNullOrNil(((Intent)localObject1).getStringExtra("k_webview_img")))
                                {
                                  paramBundle = ((Intent)localObject1).getStringExtra("k_webview_img");
                                  localObject2 = e.i(paramBundle, 0, (int)e.avI(paramBundle));
                                  e.deleteFile(paramBundle);
                                  localBundle.putString("webviewImg", Base64.encodeToString((byte[])localObject2, 0));
                                }
                                if (((Intent)localObject1).getStringExtra("k_webview_html") != null) {
                                  localBundle.putString("webviewHtml", ((Intent)localObject1).getStringExtra("k_webview_html"));
                                }
                                paramBundle = new StringBuilder();
                                paramBundle.append("<exposecontent>");
                                paramBundle.append("<weburl>");
                                if (((Intent)localObject1).getStringExtra("k_expose_url") != null) {
                                  paramBundle.append(((Intent)localObject1).getStringExtra("k_expose_url"));
                                }
                                paramBundle.append("</weburl>");
                                paramBundle.append("<firstJumpUrl>");
                                if (((Intent)localObject1).getStringExtra("k_expose_raw_url") != null) {
                                  paramBundle.append(((Intent)localObject1).getStringExtra("k_expose_raw_url"));
                                }
                                paramBundle.append("</firstJumpUrl>");
                                paramBundle.append("<webscence>");
                                paramBundle.append(((Intent)localObject1).getIntExtra("k_expose_web_scene", 0));
                                paramBundle.append("</webscence>");
                                paramBundle.append("</exposecontent>");
                                localBundle.putString("url", paramBundle.toString());
                                continue;
                                localBundle.putString("newMsgId", String.valueOf(((Intent)localObject1).getLongExtra("k_expose_msg_id", 0L)));
                                localBundle.putStringArrayList("proof", ((Intent)localObject1).getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                localBundle.putInt("msgType", ((Intent)localObject1).getIntExtra("k_expose_msg_type", 0));
                              }
                              al.d(new n.53(this, paramBundle));
                              continue;
                              localBundle.putStringArray("webview_get_route_url_list", ((WebViewUI)this.uZU.get()).vfQ.dcN());
                              localBundle.putInt("webview_get_route_url_geta8key_scene", aio(getIntent().getStringExtra("geta8key_username")));
                              localBundle.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
                              continue;
                              localObject1 = ((WebViewUI)this.uZU.get()).dek();
                              localObject2 = com.tencent.xweb.b.dYg().getCookie((String)localObject1);
                              ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "url = %s, cookie = %s", new Object[] { localObject1, localObject2 });
                              localBundle.putString("cookie", (String)localObject2);
                              localBundle.putFloat("density", aNP());
                              if (paramBundle != null)
                              {
                                localBundle.putString("currentUrlPath", com.tencent.mm.plugin.webview.modeltools.j.ahC(paramBundle.getString("currentPicUrl")));
                                continue;
                                localBundle.putBoolean("from_shortcut", ((WebViewUI)this.uZU.get()).veI);
                                continue;
                                paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
                                com.tencent.mm.bq.d.b((Context)this.uZU.get(), paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", ((WebViewUI)this.uZU.get()).cGT));
                                continue;
                                localObject1 = paramBundle.getString("traceid");
                                paramBundle = paramBundle.getString("username");
                                m.vdm.hx((String)localObject1, paramBundle);
                                continue;
                                paramBundle = ((WebViewUI)this.uZU.get()).getMMTitle();
                                localObject1 = getCurrentUrl();
                                localBundle.putString("webview_current_url", (String)localObject1);
                                if (paramBundle != null) {}
                                for (paramBundle = paramBundle.toString();; paramBundle = "")
                                {
                                  localBundle.putString("webview_current_title", paramBundle);
                                  localBundle.putString("webview_current_desc", (String)localObject1);
                                  break;
                                }
                                paramBundle = ((WebViewUI)this.uZU.get()).getMMTitle();
                                localObject1 = getCurrentUrl();
                                localObject2 = getIntent();
                                if (localObject2 != null)
                                {
                                  localBundle.putString("share_report_pre_msg_url", ((Intent)localObject2).getStringExtra("share_report_pre_msg_url"));
                                  localBundle.putString("share_report_pre_msg_title", ((Intent)localObject2).getStringExtra("share_report_pre_msg_title"));
                                  localBundle.putString("share_report_pre_msg_desc", ((Intent)localObject2).getStringExtra("share_report_pre_msg_desc"));
                                  localBundle.putString("share_report_pre_msg_icon_url", ((Intent)localObject2).getStringExtra("share_report_pre_msg_icon_url"));
                                  localBundle.putString("share_report_pre_msg_appid", ((Intent)localObject2).getStringExtra("share_report_pre_msg_appid"));
                                  localBundle.putInt("share_report_from_scene", ((Intent)localObject2).getIntExtra("share_report_from_scene", 0));
                                  localBundle.putString("share_report_biz_username", ((Intent)localObject2).getStringExtra("share_report_biz_username"));
                                }
                                localBundle.putString("share_report_current_url", (String)localObject1);
                                if (paramBundle != null) {}
                                for (paramBundle = paramBundle.toString();; paramBundle = "")
                                {
                                  localBundle.putString("share_report_current_title", paramBundle);
                                  break;
                                }
                                if (((WebViewUI)this.uZU.get()).vfA)
                                {
                                  localBundle.putString("result", "not_return");
                                }
                                else
                                {
                                  localBundle.putString("full_url", bo.nullAsNil(((WebViewUI)this.uZU.get()).kdt));
                                  if ((((WebViewUI)this.uZU.get()).vfC != null) && (((WebViewUI)this.uZU.get()).vfC.size() != 0))
                                  {
                                    localBundle.putInt("set_cookie", 1);
                                    com.tencent.xweb.c.jQ(ah.getContext());
                                    paramBundle = com.tencent.xweb.b.dYg();
                                    localObject1 = ((WebViewUI)this.uZU.get()).vfC.keySet().iterator();
                                    while (((Iterator)localObject1).hasNext())
                                    {
                                      localObject2 = (String)((Iterator)localObject1).next();
                                      paramBundle.setCookie(bo.aqm(((WebViewUI)this.uZU.get()).kdt), (String)localObject2 + "=" + (String)((WebViewUI)this.uZU.get()).vfC.get(localObject2));
                                    }
                                    paramBundle.setCookie(bo.aqm(((WebViewUI)this.uZU.get()).kdt), "httponly");
                                    com.tencent.xweb.c.dYi();
                                    com.tencent.xweb.c.sync();
                                    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "cookies:%s", new Object[] { paramBundle.getCookie(bo.aqm(((WebViewUI)this.uZU.get()).kdt)) });
                                  }
                                  else
                                  {
                                    localBundle.putInt("set_cookie", 0);
                                    continue;
                                    bool1 = paramBundle.getBoolean("add_shortcut_status");
                                    if (((WebViewUI)this.uZU.get()).uQS != null)
                                    {
                                      ((WebViewUI)this.uZU.get()).uQS.oD(bool1);
                                      continue;
                                      localBundle.putBoolean("is_from_keep_top", getIntent().getBooleanExtra("is_from_keep_top", false));
                                      continue;
                                      if (((WebViewUI)this.uZU.get()).vep != null) {
                                        ((WebViewUI)this.uZU.get()).vep.disable();
                                      }
                                      ((WebViewUI)this.uZU.get()).screenOrientation = paramBundle.getInt("screen_orientation", -1);
                                      if (((WebViewUI)this.uZU.get()).screenOrientation == 1001)
                                      {
                                        ((WebViewUI)this.uZU.get()).screenOrientation = 0;
                                        if (((WebViewUI)this.uZU.get()).vep != null)
                                        {
                                          ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                                          ((WebViewUI)this.uZU.get()).vep.enable();
                                        }
                                      }
                                      for (;;)
                                      {
                                        ((WebViewUI)this.uZU.get()).setMMOrientation();
                                        break;
                                        if (((WebViewUI)this.uZU.get()).screenOrientation == 1002)
                                        {
                                          ((WebViewUI)this.uZU.get()).screenOrientation = 1;
                                          if (((WebViewUI)this.uZU.get()).vep != null)
                                          {
                                            ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                                            ((WebViewUI)this.uZU.get()).vep.enable();
                                          }
                                        }
                                      }
                                      ((WebViewUI)this.uZU.get()).ak(paramBundle);
                                      continue;
                                      localBundle.putInt("web_page_count", WebViewUI.vfJ);
                                      continue;
                                      localBundle.putString("geta8key_data_req_url", ((WebViewUI)this.uZU.get()).daZ());
                                      localBundle.putString("geta8key_data_username", getIntent().getStringExtra("geta8key_username"));
                                      localBundle.putInt("geta8key_data_scene", aio(getIntent().getStringExtra("geta8key_username")));
                                      localBundle.putInt("geta8key_data_reason", 8);
                                      if (((WebViewUI)this.uZU.get()).pOd.getIsX5Kernel()) {
                                        localBundle.putInt("geta8key_data_flag", 1);
                                      }
                                      for (;;)
                                      {
                                        this.uZU.get();
                                        localBundle.putString("geta8key_data_net_type", as.dcf());
                                        localBundle.putInt("geta8key_session_id", ((WebViewUI)this.uZU.get()).veK);
                                        localBundle.putInt("webview_binder_id", ((WebViewUI)this.uZU.get()).hashCode());
                                        localBundle.putByteArray("k_a8key_cookie", ((WebViewUI)this.uZU.get()).veN);
                                        localBundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
                                        break;
                                        localBundle.putInt("geta8key_data_flag", 0);
                                      }
                                      localObject1 = paramBundle.getString("geta8key_result_req_url");
                                      localObject2 = paramBundle.getString("geta8key_result_full_url");
                                      if (!bo.isNullOrNil((String)localObject2))
                                      {
                                        Object localObject3 = new JsapiPermissionWrapper(paramBundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                                        GeneralControlWrapper localGeneralControlWrapper = new GeneralControlWrapper(paramBundle.getInt("geta8key_result_general_ctrl_b1"));
                                        localException.a(((String)localObject2).replaceFirst("http://", "https//"), (JsapiPermissionWrapper)localObject3, localGeneralControlWrapper);
                                        String[] arrayOfString = paramBundle.getStringArray("geta8key_result_http_header_key_list");
                                        paramBundle = paramBundle.getStringArray("geta8key_result_http_header_value_list");
                                        localObject3 = new HashMap();
                                        if ((arrayOfString != null) && (paramBundle != null) && (arrayOfString.length > 0) && (paramBundle.length > 0) && (arrayOfString.length == paramBundle.length))
                                        {
                                          paramInt = 0;
                                          while (paramInt < arrayOfString.length)
                                          {
                                            ((Map)localObject3).put(arrayOfString[paramInt], paramBundle[paramInt]);
                                            paramInt += 1;
                                          }
                                        }
                                        ((WebViewUI)this.uZU.get()).b((String)localObject1, (String)localObject2, (Map)localObject3);
                                      }
                                      else
                                      {
                                        ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "updatePageAuth fail fullUrl is null");
                                        continue;
                                        localBundle.putString("full_url", ((WebViewUI)this.uZU.get()).kdt);
                                        localBundle.putString("raw_url", ((WebViewUI)this.uZU.get()).cJr);
                                        localBundle.putString("page_key", (((WebViewUI)this.uZU.get()).hashCode() & 0x7FFFFFFF) + "_" + (((WebViewUI)this.uZU.get()).cJr.hashCode() & 0x7FFFFFFF));
                                        if ((this.uZU.get() instanceof GameWebViewUI))
                                        {
                                          paramBundle = ((GameWebViewUI)this.uZU.get()).vmq;
                                          if (paramBundle != null)
                                          {
                                            localBundle.putString("comm_js_version", com.tencent.mm.plugin.wepkg.c.dkl());
                                            localBundle.putString("wepkg_version", paramBundle.dkk());
                                            localBundle.putBoolean("is_used_wepkg", paramBundle.vEy);
                                            continue;
                                            localBundle.putString("current_url", ((WebViewUI)this.uZU.get()).dek());
                                            localBundle.putString("raw_url", ((WebViewUI)this.uZU.get()).cJr);
                                            continue;
                                            if ((this.uZU.get() instanceof GameWebViewUI))
                                            {
                                              paramBundle = (GameWebViewUI)this.uZU.get();
                                              paramBundle.nkK.vnc = System.currentTimeMillis();
                                              paramBundle.nkv.ezW = 1;
                                              continue;
                                              if ((this.uZU.get() instanceof GameWebViewUI))
                                              {
                                                ((GameWebViewUI)this.uZU.get()).nkK.vnd = System.currentTimeMillis();
                                                continue;
                                                ((WebViewUI)this.uZU.get()).vfS.ddN();
                                                continue;
                                                if (((this.uZU.get() instanceof com.tencent.mm.plugin.webview.preload.a.a)) && (paramBundle != null))
                                                {
                                                  localObject1 = (com.tencent.mm.plugin.webview.preload.a.a)this.uZU.get();
                                                  paramBundle = paramBundle.getString("action");
                                                  if ("writeComment".equals(paramBundle))
                                                  {
                                                    ((com.tencent.mm.plugin.webview.preload.a.a)localObject1).aYq();
                                                  }
                                                  else if ("closeComment".equals(paramBundle))
                                                  {
                                                    ((com.tencent.mm.plugin.webview.preload.a.a)localObject1).aYr();
                                                    continue;
                                                    if (((this.uZU.get() instanceof com.tencent.mm.plugin.webview.preload.a.a)) && (paramBundle != null))
                                                    {
                                                      localObject1 = (com.tencent.mm.plugin.webview.preload.a.a)this.uZU.get();
                                                      localObject2 = paramBundle.getString("action");
                                                      if ("writeComment".equals(localObject2)) {
                                                        ((com.tencent.mm.plugin.webview.preload.a.a)localObject1).K(paramBundle);
                                                      } else if ("showToast".equals(localObject2)) {
                                                        ((com.tencent.mm.plugin.webview.preload.a.a)localObject1).L(paramBundle);
                                                      } else if ("share".equals(localObject2)) {
                                                        ((com.tencent.mm.plugin.webview.preload.a.a)localObject1).aYp();
                                                      } else if ("switchVideo".equals(localObject2)) {
                                                        ((com.tencent.mm.plugin.webview.preload.a.a)localObject1).M(paramBundle);
                                                      } else if ("createAdWebview".equals(localObject2)) {
                                                        localBundle.putBoolean("ret", ((com.tencent.mm.plugin.webview.preload.a.a)localObject1).N(paramBundle));
                                                      } else if ("closeAdWebview".equals(localObject2)) {
                                                        ((com.tencent.mm.plugin.webview.preload.a.a)localObject1).aYu();
                                                      } else if ("getMPVideoState".equals(localObject2)) {
                                                        localBundle.putAll(((com.tencent.mm.plugin.webview.preload.a.a)localObject1).aYw());
                                                      } else if ("sendMPPageData".equals(localObject2)) {
                                                        ((com.tencent.mm.plugin.webview.preload.a.a)localObject1).O(paramBundle);
                                                      } else if ("getFuncFlag".equals(localObject2)) {
                                                        localBundle.putAll(((com.tencent.mm.plugin.webview.preload.a.a)localObject1).aYs());
                                                      }
                                                    }
                                                    else if (paramBundle != null)
                                                    {
                                                      paramBundle = paramBundle.getString("action");
                                                      if ("getFuncFlag".equals(paramBundle))
                                                      {
                                                        localBundle.putAll(((WebViewUI)this.uZU.get()).vfS.ddT());
                                                      }
                                                      else if ("share".equals(paramBundle))
                                                      {
                                                        ((WebViewUI)this.uZU.get()).aYp();
                                                        continue;
                                                        if ((((WebViewUI)this.uZU.get()).vef != null) && (((WebViewUI)this.uZU.get()).vef.isShowing())) {
                                                          ((WebViewUI)this.uZU.get()).vef.dismiss();
                                                        }
                                                        if (paramBundle == null)
                                                        {
                                                          ab.w("MicroMsg.WebViewStubCallbackAIDLStub", "show dialog, data is null");
                                                        }
                                                        else
                                                        {
                                                          paramBundle.getString("title", ((WebViewUI)this.uZU.get()).getString(2131297087));
                                                          localObject1 = paramBundle.getString("message", ((WebViewUI)this.uZU.get()).getString(2131297112));
                                                          bool1 = paramBundle.getBoolean("cancelable", true);
                                                          ((WebViewUI)this.uZU.get()).vef = com.tencent.mm.ui.base.h.b((Context)this.uZU.get(), (String)localObject1, bool1, new n.54(this, paramBundle));
                                                          continue;
                                                          if ((((WebViewUI)this.uZU.get()).vef != null) && (((WebViewUI)this.uZU.get()).vef.isShowing()))
                                                          {
                                                            ((WebViewUI)this.uZU.get()).vef.dismiss();
                                                            continue;
                                                            localObject1 = new b.a();
                                                            localObject2 = new Intent();
                                                            if (paramBundle.getBoolean("isNativePage"))
                                                            {
                                                              ((Intent)localObject2).putExtras(paramBundle);
                                                              float f = aNP();
                                                              f.a((Context)this.uZU.get(), paramBundle.getString("currentInfo"), f, (Intent)localObject2, ((WebViewUI)this.uZU.get()).ven);
                                                              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1061L, 21L, 1L, false);
                                                            }
                                                            localBundle.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a((Context)this.uZU.get(), paramBundle.getString("url"), paramBundle.getInt("item_show_type"), paramBundle.getBoolean("isNativePage"), paramBundle.getInt("scene"), (Intent)localObject2, paramBundle.getInt("openType"), (b.a)localObject1));
                                                            if ((!((b.a)localObject1).success) && (((b.a)localObject1).message != null)) {
                                                              localBundle.putString("desc", ((b.a)localObject1).message);
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void om(boolean paramBoolean)
  {
    AppMethodBeat.i(7783);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7783);
      return;
    }
    boolean bool = ((WebViewUI)this.uZU.get()).getIntent().getBooleanExtra("forceHideShare", false);
    ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    al.d(new n.32(this, bool, paramBoolean));
    AppMethodBeat.o(7783);
  }
  
  public final void on(boolean paramBoolean)
  {
    AppMethodBeat.i(7784);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7784);
      return;
    }
    al.d(new n.33(this, paramBoolean));
    AppMethodBeat.o(7784);
  }
  
  public final void oo(boolean paramBoolean)
  {
    AppMethodBeat.i(7796);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7796);
      return;
    }
    ((WebViewUI)this.uZU.get()).ou(paramBoolean);
    AppMethodBeat.o(7796);
  }
  
  public final void t(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7790);
    if ((this.uZU.get() == null) || (((WebViewUI)this.uZU.get()).isFinishing()))
    {
      AppMethodBeat.o(7790);
      return;
    }
    al.d(new n.37(this, paramInt, paramBundle));
    AppMethodBeat.o(7790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */