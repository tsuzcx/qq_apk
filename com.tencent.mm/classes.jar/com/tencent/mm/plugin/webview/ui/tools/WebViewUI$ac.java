package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.R.e;
import com.tencent.mm.h.a.j;
import com.tencent.mm.h.a.j.b;
import com.tencent.mm.m.d.b;
import com.tencent.mm.plugin.webview.model.ac.b;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.modeltools.l;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.4;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.j;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebViewUI$ac
  extends e.a
{
  public WebViewUI$ac(WebViewUI paramWebViewUI) {}
  
  public final boolean Cl(int paramInt)
  {
    WebViewUI.a(this.rpH).post(new WebViewUI.ac.25(this, paramInt));
    return true;
  }
  
  public final void N(Bundle paramBundle)
  {
    y.i("MicroMsg.WebViewUI", "IUIController, closeWindow");
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_data", paramBundle);
      this.rpH.setResult(-1, localIntent);
    }
    this.rpH.finish();
  }
  
  public final void O(Bundle paramBundle)
  {
    y.i("MicroMsg.WebViewUI", "setCustomMenu");
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
      localObject = this.rpH.niQ.getUrl();
      if (WebViewUI.z(this.rpH).containsKey(localObject)) {
        WebViewUI.z(this.rpH).remove(localObject);
      }
      WebViewUI.z(this.rpH).put(localObject, paramBundle);
    }
  }
  
  public final void SJ(String paramString)
  {
    final int i = 0;
    try
    {
      int j = bk.getInt(paramString, 0);
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.WebViewUI", "setFontSizeCb, ex = " + paramString.getMessage());
      }
      WebViewUI.a(this.rpH).post(new Runnable()
      {
        public final void run()
        {
          WebViewUI.a(WebViewUI.ac.this.rpH, i);
        }
      });
    }
    if (this.rpH.niQ == null)
    {
      y.e("MicroMsg.WebViewUI", "setFontSizeCb fail, viewWV is null");
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.stub.c paramc)
  {
    if ((this.rpH.roi.ceN()) || (this.rpH.roj.ceN()) || (this.rpH.rok.ceN()) || (WebViewUI.b(this.rpH).cbR())) {
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.24(this, paramc));
    }
    return true;
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.rpH.rbk != null) {
      this.rpH.runOnUiThread(new WebViewUI.ac.26(this, paramString1, paramString2, paramBundle, paramBoolean));
    }
    return false;
  }
  
  public final boolean b(int paramInt, final Bundle paramBundle)
  {
    y.i("MicroMsg.WebViewUI", "callback, actionCode = " + paramInt);
    Object localObject1;
    boolean bool1;
    Object localObject2;
    int i;
    Object localObject3;
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.WebViewUI", "undefine action code!!!");
    case 1001: 
    case 1002: 
    case 1003: 
    case 1008: 
    case 1007: 
    case 1004: 
    case 2011: 
    case 2003: 
    case 2100: 
    case 13: 
    case 2004: 
    case 2005: 
    case 2006: 
    case 2010: 
    case 2002: 
    case 4007: 
    case 2007: 
    case 2008: 
    case 2009: 
    case 1006: 
      do
      {
        do
        {
          do
          {
            return true;
          } while (this.rpH.isFinishing());
          this.rpH.finish();
          return true;
          WebViewUI.a(this.rpH).post(new WebViewUI.ac.1(this, paramBundle));
          return true;
          WebViewUI.a(this.rpH).post(new WebViewUI.ac.12(this, paramBundle));
          return true;
          WebViewUI.a(this.rpH).post(new WebViewUI.ac.23(this, paramBundle));
          return true;
          long l = paramBundle.getLong("download_manager_downloadid");
          paramInt = paramBundle.getInt("download_manager_progress");
          paramBundle = paramBundle.getString("download_manager_appid", "");
          WebViewUI.a(this.rpH).post(new WebViewUI.ac.34(this, paramBundle, l, paramInt));
          return true;
          localObject1 = paramBundle.getString("exdevice_device_id");
          paramInt = paramBundle.getInt("exdevice_on_state_change_state");
          bool1 = paramBundle.getBoolean("exdevice_inner_call");
          WebViewUI.a(this.rpH).post(new WebViewUI.ac.45(this, (String)localObject1, paramInt, Boolean.valueOf(bool1)));
          return true;
          localObject1 = paramBundle.getString("webview_jssdk_file_item_local_id");
          paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
          WebViewUI.a(this.rpH).post(new WebViewUI.ac.51(this, (String)localObject1, paramInt));
          return true;
          localObject1 = paramBundle.getString("webview_jssdk_file_item_local_id");
          paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
          WebViewUI.a(this.rpH).post(new WebViewUI.ac.52(this, (String)localObject1, paramInt));
          return true;
          localObject1 = paramBundle.getString("background_audio_state_player_state");
          paramInt = paramBundle.getInt("background_audio_state_player_duration");
          localObject2 = paramBundle.getString("background_audio_state_player_src");
          i = paramBundle.getInt("background_audio_state_player_err_code");
          localObject3 = paramBundle.getString("background_audio_state_player_err_msg");
          paramBundle = paramBundle.getString("background_audio_state_player_src_id");
          WebViewUI.a(this.rpH).post(new WebViewUI.ac.53(this, (String)localObject1, paramInt, (String)localObject2, i, (String)localObject3, paramBundle));
          return true;
        } while (paramBundle == null);
        paramBundle.putString("application_language", this.rpH.gGn.getLanguage());
        WebViewUI.a(this.rpH, WebViewUI.d.V(paramBundle));
        return true;
        localObject1 = paramBundle.getString("webview_jssdk_file_item_local_id");
        paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
        WebViewUI.a(this.rpH).post(new WebViewUI.ac.54(this, (String)localObject1, paramInt));
        return true;
        localObject1 = paramBundle.getString("webview_jssdk_file_item_local_id");
        paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
        WebViewUI.a(this.rpH).post(new WebViewUI.ac.2(this, (String)localObject1, paramInt));
        return true;
        localObject1 = paramBundle.getString("webview_jssdk_file_item_local_id");
        paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
        WebViewUI.a(this.rpH).post(new WebViewUI.ac.3(this, (String)localObject1, paramInt));
        return true;
        localObject1 = paramBundle.getString("webview_jssdk_file_item_local_id");
        paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
        WebViewUI.a(this.rpH).post(new WebViewUI.ac.4(this, (String)localObject1, paramInt));
        return true;
        localObject1 = new HashMap();
        ((Map)localObject1).put("err_msg", paramBundle.getString("playResult"));
        ((Map)localObject1).put("localId", paramBundle.getString("localId"));
        WebViewUI.a(this.rpH).post(new WebViewUI.ac.5(this, (Map)localObject1));
        return true;
        paramInt = paramBundle.getInt("nfc_key_on_touch_errcode", 0);
        WebViewUI.a(this.rpH).post(new WebViewUI.ac.6(this, paramInt));
        return true;
        WebViewUI.a(this.rpH).post(new WebViewUI.ac.7(this));
        return true;
        localObject1 = new HashMap();
        ((Map)localObject1).put("localId", paramBundle.getString("localId"));
        ((Map)localObject1).put("err_msg", paramBundle.getString("recordResult"));
        WebViewUI.a(this.rpH).post(new WebViewUI.ac.8(this, (Map)localObject1));
        return true;
        WebViewUI.a(this.rpH).post(new WebViewUI.ac.9(this));
        return true;
      } while (this.rpH.rbk == null);
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.10(this, paramBundle));
      return true;
    case 15: 
      localObject1 = paramBundle.getString("exdevice_device_id");
      bool1 = paramBundle.getBoolean("exdevice_is_complete");
      localObject2 = paramBundle.getByteArray("exdevice_broadcast_data");
      boolean bool2 = paramBundle.getBoolean("exdevice_is_lan_device");
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.11(this, (String)localObject1, (byte[])localObject2, bool1, bool2));
      return true;
    case 16: 
      localObject1 = paramBundle.getString("exdevice_device_id");
      localObject2 = paramBundle.getString("exdevice_brand_name");
      paramBundle = paramBundle.getByteArray("exdevice_data");
      WebViewUI.a(this.rpH).post(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald;
          String str;
          byte[] arrayOfByte;
          if (WebViewUI.ac.this.rpH.rbk != null)
          {
            locald = WebViewUI.ac.this.rpH.rbk;
            str = this.rpN;
            arrayOfByte = paramBundle;
            localObject = this.jtL;
            if (!locald.ready) {
              y.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
            }
          }
          else
          {
            return;
          }
          y.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", new Object[] { str, localObject });
          if ((bk.bl(str)) || (bk.bl((String)localObject)) || (arrayOfByte == null))
          {
            y.e("MicroMsg.JsApiHandler", "parameter error!!!");
            return;
          }
          Object localObject = new HashMap();
          ((Map)localObject).put("deviceId", str);
          ((Map)localObject).put("base64Data", Base64.encodeToString(arrayOfByte, 2));
          ai.d(new d.4(locald, i.a.a("onReceiveDataFromWXDevice", (Map)localObject, locald.rxI, locald.rxJ)));
        }
      });
      return true;
    case 17: 
      localObject1 = paramBundle.getString("exdevice_device_id");
      bool1 = paramBundle.getBoolean("exdevice_is_bound");
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.14(this, (String)localObject1, bool1));
      return true;
    case 18: 
      bool1 = paramBundle.getBoolean("exdevice_bt_state");
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.15(this, bool1));
      return true;
    case 47: 
      bool1 = paramBundle.getBoolean("exdevice_lan_state");
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.16(this, bool1));
      return true;
    case 40001: 
      paramBundle = paramBundle.getString("err_msg");
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.17(this, paramBundle));
      return true;
    case 40002: 
      localObject1 = paramBundle.getString("uuid");
      paramInt = paramBundle.getInt("major");
      i = paramBundle.getInt("minor");
      double d1 = paramBundle.getDouble("accuracy");
      double d2 = paramBundle.getDouble("rssi");
      float f = paramBundle.getFloat("heading");
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.18(this, (String)localObject1, paramInt, i, d1, d2, f));
      return true;
    case 60: 
    case 61: 
    case 62: 
    case 119: 
    case 120: 
    case 121: 
    case 122: 
    case 123: 
    case 124: 
    case 125: 
    case 126: 
    case 127: 
    case 128: 
    case 130: 
    case 133: 
    case 134: 
    case 135: 
    case 136: 
    case 137: 
    case 138: 
    case 142: 
    case 143: 
    case 144: 
    case 145: 
    case 100001: 
    case 100002: 
    case 200000: 
    case 200001: 
    case 200002: 
    case 200003: 
      this.rpH.i(paramInt, paramBundle);
      return true;
    case 80001: 
    case 80002: 
      this.rpH.s(paramInt, paramBundle);
      return true;
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
      WebViewUI.cez();
      return true;
    case 48: 
      localObject1 = paramBundle.getStringArray("msgIds");
      localObject2 = paramBundle.getStringArray("contents");
      localObject3 = paramBundle.getStringArray("senders");
      int[] arrayOfInt = paramBundle.getIntArray("msgTypes");
      paramBundle = paramBundle.getIntArray("msgTimes");
      JSONArray localJSONArray = new JSONArray();
      if (localObject1 == null) {
        paramInt = 0;
      }
      for (;;)
      {
        i = 0;
        if (i < paramInt) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("newMsgId", localObject1[i]);
            localJSONObject.put("content", localObject2[i]);
            localJSONObject.put("sender", localObject3[i]);
            localJSONObject.put("msgType", arrayOfInt[i]);
            localJSONObject.put("msgTime", paramBundle[i]);
            localJSONArray.put(localJSONObject);
            i += 1;
            break label1946;
            paramInt = localObject1.length;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              y.e("MicroMsg.WebViewUI", "GetMsgProofItems exception " + localJSONException.getMessage());
            }
          }
        }
      }
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.19(this, localJSONArray));
      return true;
    case 90: 
      paramBundle = paramBundle.getString("webview_network_type");
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.20(this, paramBundle));
      return true;
    case 71: 
    case 72: 
      label1946:
      WebViewUI.a(this.rpH).post(new WebViewUI.ac.21(this, paramBundle));
      return true;
    }
    paramBundle = paramBundle.getString("service_click_tid");
    y.i("MicroMsg.WebViewUI", "on service click, update tid = %s", new Object[] { paramBundle });
    WebViewUI.a(this.rpH, paramBundle);
    WebViewUI.a(this.rpH, System.currentTimeMillis());
    WebViewUI.a(this.rpH).post(new WebViewUI.ac.22(this));
    return true;
  }
  
  public final String cdb()
  {
    return this.rpH.caS;
  }
  
  public final String cdc()
  {
    return this.rpH.getIntent().getStringExtra("srcUsername");
  }
  
  public final int cdd()
  {
    return WebViewUI.d(this.rpH);
  }
  
  public final void cde()
  {
    if (this.rpH.rbk != null) {
      this.rpH.rbk.cde();
    }
  }
  
  public final void cdf()
  {
    if (this.rpH.rbk != null) {
      this.rpH.rbk.cdf();
    }
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.WebViewUI", "result: " + paramString2);
    if ((this.rpH.gGt == null) || (paramString1 == null) || (!paramString1.equals(this.rpH.gGt.riI))) {}
    do
    {
      return;
      if (this.rpH.gGt != null) {
        this.rpH.gGt.ccQ();
      }
      this.rpH.gGr = paramInt1;
      this.rpH.gGs = paramInt2;
    } while ((paramString2 == null) || (this.rpH.gGp == null));
    WebViewUI.a(this.rpH).post(new WebViewUI.ac.30(this, paramString2));
  }
  
  public final Bundle f(final int paramInt, final Bundle paramBundle)
  {
    y.i("MicroMsg.WebViewUI", "invokeAsResult, actionCode = " + paramInt);
    final Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.WebViewUI", "undefine action code!!!");
    }
    for (;;)
    {
      return localBundle;
      Object localObject1 = new j();
      ((j)localObject1).bFd.context = this.rpH.mController.uMN;
      ((j)localObject1).bFd.actionCode = paramInt;
      if (4003 == paramInt)
      {
        paramBundle = paramBundle.getString("apdu");
        ((j)localObject1).bFd.bFf = paramBundle;
      }
      Object localObject2;
      final boolean bool1;
      for (;;)
      {
        ((j)localObject1).bFJ = new Runnable()
        {
          public final void run()
          {
            localBundle.putAll(this.rqD.bFe.bFi);
          }
        };
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        break;
        if (4004 == paramInt)
        {
          localObject2 = paramBundle.getString("apdus");
          bool1 = paramBundle.getBoolean("breakIfFail", true);
          boolean bool2 = paramBundle.getBoolean("breakIfTrue", false);
          ((j)localObject1).bFd.bFf = ((String)localObject2);
          ((j)localObject1).bFd.bFg = bool1;
          ((j)localObject1).bFd.bFh = bool2;
        }
      }
      localBundle.putString("KPublisherId", this.rpH.bYM);
      paramBundle = this.rpH.getIntent();
      if (paramBundle != null)
      {
        localObject1 = this.rpH.getIntent().getStringExtra("geta8key_username");
        paramInt = WebViewUI.b(this.rpH, (String)localObject1);
        localBundle.putString("preChatName", paramBundle.getStringExtra("preChatName"));
        localBundle.putInt("preMsgIndex", paramBundle.getIntExtra("preMsgIndex", 0));
        localBundle.putString("prePublishId", paramBundle.getStringExtra("prePublishId"));
        localBundle.putString("preUsername", paramBundle.getStringExtra("preUsername"));
        localBundle.putInt("getA8KeyScene", paramInt);
        localBundle.putString("referUrl", WebViewUI.i(this.rpH));
        continue;
        localBundle.putString("KSessionId", WebViewUI.j(this.rpH));
        localBundle.putString("KUserAgent", WebViewUI.k(this.rpH));
        localBundle.putBoolean("KReportPage", this.rpH.rnJ);
        localBundle.putString("KUrl", WebViewUI.l(this.rpH));
        paramInt = WebViewUI.b(this.rpH, this.rpH.getIntent().getStringExtra("geta8key_username"));
        if ((paramInt == 7) || (paramInt == 56))
        {
          localBundle.putString("geta8key_username", this.rpH.getIntent().getStringExtra("geta8key_username"));
          continue;
          paramBundle = this.rpH.getIntent();
          if (paramBundle != null)
          {
            localBundle.putString("publishIdPrefix", paramBundle.getStringExtra("publishIdPrefix"));
            localBundle.putString("reportSessionId", paramBundle.getStringExtra("reportSessionId"));
            continue;
            paramBundle = paramBundle.getString("_url");
            if ((!bk.bl(paramBundle)) && (this.rpH.gGo != null) && (this.rpH.gGo != null))
            {
              paramBundle = this.rpH.gGo.RP(paramBundle);
              if (paramBundle != null)
              {
                localBundle.putParcelable("_permission_wrapper", paramBundle);
                continue;
                localBundle.putInt("pay_channel", this.rpH.getIntent().getIntExtra("pay_channel", -1));
                y.i("MicroMsg.WebViewUI", "key value: pay channel(%d)", new Object[] { Integer.valueOf(this.rpH.getIntent().getIntExtra("pay_channel", -1)) });
                continue;
                localBundle.putInt("scene", this.rpH.getIntent().getIntExtra("scene", -1));
                y.i("MicroMsg.WebViewUI", "Key value: Scene(%d)", new Object[] { Integer.valueOf(this.rpH.getIntent().getIntExtra("scene", 0)) });
                continue;
                paramInt = this.rpH.getIntent().getIntExtra("geta8key_scene", 0);
                localBundle.putInt("geta8key_scene", paramInt);
                y.i("MicroMsg.WebViewUI", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramInt) });
                continue;
                if (this.rpH.gGn.isSDCardAvailable())
                {
                  long l = az.crH();
                  y.i("MicroMsg.WebViewUI", "availableSize = %d", new Object[] { Long.valueOf(l) });
                  if (l < 524288000L)
                  {
                    y.e("MicroMsg.WebViewUI", "available size not enough");
                    label1242:
                    paramInt = FactoryProxyManager.getPlayManager().init(this.rpH, null);
                  }
                }
                for (;;)
                {
                  if (paramInt == 0)
                  {
                    if (WebViewUI.ceC() == null)
                    {
                      WebViewUI.a(new WebViewUI.y(this.rpH, (byte)0));
                      FactoryProxyManager.getPlayManager().setUtilsObject(WebViewUI.ceC());
                    }
                    i = FactoryProxyManager.getPlayManager().getLocalServerPort();
                    y.i("MicroMsg.WebViewUI", "webview video init result = %d, local port = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                    paramBundle = WebViewUI.m(this.rpH);
                    if ((i <= 0) || (i > 65535)) {
                      y.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[] { Integer.valueOf(i) });
                    }
                    if (!paramBundle.rgc.contains(Integer.valueOf(i))) {
                      paramBundle.rgc.add(Integer.valueOf(i));
                    }
                  }
                  localBundle.putInt("webview_video_proxy_init", paramInt);
                  break;
                  paramBundle = new File(com.tencent.mm.plugin.webview.a.qYp);
                  bool1 = true;
                  if (!paramBundle.exists())
                  {
                    bool1 = paramBundle.mkdirs();
                    y.i("MicroMsg.WebViewUI", "create proxy cache path : %s, %b", new Object[] { paramBundle.getAbsolutePath(), Boolean.valueOf(bool1) });
                  }
                  if (!bool1) {
                    break label1242;
                  }
                  paramInt = FactoryProxyManager.getPlayManager().init(this.rpH, com.tencent.mm.plugin.webview.a.qYp);
                  FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
                  continue;
                  y.i("MicroMsg.WebViewUI", "sdcard not available");
                  paramInt = FactoryProxyManager.getPlayManager().init(this.rpH, null);
                }
                localObject1 = paramBundle.getString("webview_video_proxy_cdn_urls");
                localObject2 = paramBundle.getString("webview_video_proxy_fileId");
                paramInt = paramBundle.getInt("webview_video_proxy_file_size");
                int i = paramBundle.getInt("webview_video_proxy_file_duration");
                int j = paramBundle.getInt("webview_video_proxy_file_type");
                int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramInt, i);
                paramBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
                y.i("MicroMsg.WebViewUI", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramBundle });
                localBundle.putInt("webview_video_proxy_play_data_id", k);
                localBundle.putString("webview_video_proxy_local_url", paramBundle);
                continue;
                paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
                y.i("MicroMsg.WebViewUI", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramInt) });
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
                  y.i("MicroMsg.WebViewUI", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                  localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramInt, i));
                  continue;
                  if (paramBundle.getInt("webview_disable_bounce_scroll_top", 0) > 0)
                  {
                    this.rpH.runOnUiThread(new WebViewUI.ac.35(this));
                    continue;
                    this.rpH.runOnUiThread(new WebViewUI.ac.36(this));
                    continue;
                    this.rpH.runOnUiThread(new WebViewUI.ac.37(this));
                    continue;
                    this.rpH.runOnUiThread(new WebViewUI.ac.38(this));
                    continue;
                    this.rpH.runOnUiThread(new WebViewUI.ac.39(this));
                    continue;
                    this.rpH.runOnUiThread(new WebViewUI.ac.40(this));
                    continue;
                    localObject1 = paramBundle.getString("show_kb_placeholder");
                    paramInt = paramBundle.getInt("show_kb_max_length");
                    this.rpH.runOnUiThread(new WebViewUI.ac.41(this, (String)localObject1, paramInt));
                    continue;
                    this.rpH.runOnUiThread(new WebViewUI.ac.42(this, localBundle));
                    continue;
                    localObject1 = paramBundle.getString("set_page_title_text");
                    paramBundle = paramBundle.getString("set_page_title_color");
                    localObject2 = this.rpH;
                    if ((com.tencent.mm.compatible.util.d.gF(21)) && (((WebViewUI)localObject2).bad())) {}
                    for (paramInt = -16777216;; paramInt = ((WebViewUI)localObject2).getResources().getColor(R.e.action_bar_tittle_color))
                    {
                      e.bb(paramBundle, paramInt);
                      this.rpH.runOnUiThread(new WebViewUI.ac.43(this, (String)localObject1));
                      break;
                    }
                    localObject2 = paramBundle.getString("set_navigation_bar_buttons_text");
                    localObject1 = paramBundle.getString("set_navigation_bar_buttons_icon_data");
                    bool1 = paramBundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                    if (!bk.bl((String)localObject1)) {}
                    for (;;)
                    {
                      try
                      {
                        localObject1 = e.Te((String)localObject1);
                        paramInt = e.bb(paramBundle.getString("set_navigation_bar_buttons_left_text_color"), -1);
                        this.rpH.runOnUiThread(new Runnable()
                        {
                          public final void run()
                          {
                            if (bool1)
                            {
                              WebViewUI.ac.this.rpH.lm(true);
                              return;
                            }
                            Boolean localBoolean = null;
                            String str = WebViewUI.ac.this.rpH.cdR();
                            if (!bk.bl(str)) {
                              localBoolean = (Boolean)WebViewUI.r(WebViewUI.ac.this.rpH).get(str);
                            }
                            boolean bool;
                            if (localBoolean == null)
                            {
                              bool = false;
                              WebViewUI.ac.this.rpH.lm(Boolean.valueOf(bool).booleanValue());
                              if ((this.wuG == null) || (this.wuG.isRecycled())) {
                                break label155;
                              }
                              WebViewUI.ac.this.rpH.b(this.dAG, new BitmapDrawable(WebViewUI.ac.this.rpH.getResources(), this.wuG));
                            }
                            for (;;)
                            {
                              WebViewUI.ac.this.rpH.CG(paramInt);
                              return;
                              bool = localBoolean.booleanValue();
                              break;
                              label155:
                              if (!bk.bl(this.dAG)) {
                                WebViewUI.ac.this.rpH.addTextOptionMenu(0, this.dAG, new WebViewUI.ac.44.1(this));
                              }
                            }
                          }
                        });
                      }
                      catch (Exception localException)
                      {
                        localObject1 = null;
                        y.e("MicroMsg.WebViewUI", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { localException });
                        continue;
                      }
                      localObject1 = null;
                    }
                    this.rpH.runOnUiThread(new Runnable()
                    {
                      public final void run()
                      {
                        boolean bool = paramBundle.getBoolean("enable_fullscreen_params_enable", false);
                        if (WebViewUI.ac.this.rpH.getIntent() != null) {
                          WebViewUI.ac.this.rpH.getIntent().removeExtra("show_full_screen");
                        }
                        WebViewUI.b(WebViewUI.ac.this.rpH, bool);
                      }
                    });
                    continue;
                    this.rpH.runOnUiThread(new WebViewUI.ac.47(this));
                    continue;
                    this.rpH.runOnUiThread(new WebViewUI.ac.48(this));
                    continue;
                    bool1 = paramBundle.getBoolean("clear_webview_cache_clear_cookie", false);
                    y.i("MicroMsg.WebViewUI", "includeCookie = %b", new Object[] { Boolean.valueOf(bool1) });
                    paramBundle = new Intent();
                    paramBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    paramBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool1);
                    com.tencent.mm.cl.b.av(paramBundle);
                    continue;
                    if (paramBundle.getString("enterprise_action").equals("enterprise_get_context_bizchat"))
                    {
                      localBundle.putString("enterprise_context_biz", this.rpH.getIntent().getStringExtra("enterprise_biz_name"));
                      localBundle.putLong("enterprise_context_bizchatid", this.rpH.getIntent().getLongExtra("biz_chat_chat_id", -1L));
                      continue;
                      paramInt = e.bb(paramBundle.getString("key_set_bounce_background_color"), this.rpH.getResources().getColor(R.e.webview_logo_bg_color));
                      WebViewUI.n(this.rpH).CC(paramInt);
                      continue;
                      localObject1 = this.rpH.getIntent();
                      if (paramBundle != null)
                      {
                        paramInt = paramBundle.getInt("scene");
                        switch (paramInt)
                        {
                        default: 
                          y.d("MicroMsg.WebViewUI", "unknown expose scene: %d", new Object[] { Integer.valueOf(paramInt) });
                          return localBundle;
                        case 1: 
                        case 2: 
                        case 3: 
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: 
                        case 37: 
                        case 45: 
                          localBundle.putStringArrayList("content", ((Intent)localObject1).getStringArrayListExtra("k_outside_expose_proof_item_list"));
                        }
                        for (;;)
                        {
                          localBundle.putString("username", ((Intent)localObject1).getStringExtra("k_username"));
                          break;
                          localBundle.putString("newMsgId", String.valueOf(((Intent)localObject1).getLongExtra("k_expose_msg_id", 0L)));
                          continue;
                          paramBundle = new StringBuilder();
                          paramBundle.append("<exposecontent>");
                          paramBundle.append("<weburl>");
                          if (((Intent)localObject1).getStringExtra("k_expose_current_url") != null) {
                            paramBundle.append(((Intent)localObject1).getStringExtra("k_expose_current_url"));
                          }
                          paramBundle.append("</weburl>");
                          paramBundle.append("<webscence>");
                          paramBundle.append(WebViewUI.b(this.rpH, this.rpH.getIntent().getStringExtra("geta8key_username")));
                          paramBundle.append("</webscence>");
                          paramBundle.append("</exposecontent>");
                          localBundle.putString("content", paramBundle.toString());
                          continue;
                          localBundle.putString("newMsgId", String.valueOf(((Intent)localObject1).getLongExtra("k_expose_msg_id", 0L)));
                          localBundle.putStringArrayList("content", ((Intent)localObject1).getStringArrayListExtra("k_outside_expose_proof_item_list"));
                          localBundle.putInt("msgType", ((Intent)localObject1).getIntExtra("k_expose_msg_type", 0));
                        }
                        this.rpH.runOnUiThread(new WebViewUI.ac.49(this, paramBundle));
                        continue;
                        localBundle.putStringArray("webview_get_route_url_list", WebViewUI.t(this.rpH).ccS());
                        localBundle.putInt("webview_get_route_url_geta8key_scene", WebViewUI.b(this.rpH, this.rpH.getIntent().getStringExtra("geta8key_username")));
                        localBundle.putString("geta8key_username", this.rpH.getIntent().getStringExtra("geta8key_username"));
                        continue;
                        paramBundle = this.rpH.cdR();
                        localObject1 = com.tencent.xweb.b.cSe().getCookie(paramBundle);
                        y.i("MicroMsg.WebViewUI", "url = %s, cookie = %s", new Object[] { paramBundle, localObject1 });
                        localBundle.putString("cookie", (String)localObject1);
                        continue;
                        localBundle.putBoolean("from_shortcut", WebViewUI.u(this.rpH));
                        continue;
                        paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
                        com.tencent.mm.br.d.b(this.rpH, paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", this.rpH.bYM));
                        continue;
                        localObject1 = paramBundle.getString("traceid");
                        paramBundle = paramBundle.getString("username");
                        h.rnm.fA((String)localObject1, paramBundle);
                        continue;
                        paramBundle = this.rpH.mController.getMMTitle();
                        localObject1 = getCurrentUrl();
                        localBundle.putString("webview_current_url", (String)localObject1);
                        if (paramBundle != null) {}
                        for (paramBundle = paramBundle.toString();; paramBundle = "")
                        {
                          localBundle.putString("webview_current_title", paramBundle);
                          localBundle.putString("webview_current_desc", (String)localObject1);
                          break;
                        }
                        paramBundle = this.rpH.mController.getMMTitle();
                        localObject1 = getCurrentUrl();
                        localObject2 = this.rpH.getIntent();
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
                        if (WebViewUI.v(this.rpH))
                        {
                          localBundle.putString("result", "not_return");
                        }
                        else
                        {
                          localBundle.putString("full_url", bk.pm(this.rpH.kpt));
                          if ((WebViewUI.w(this.rpH) != null) && (WebViewUI.w(this.rpH).size() != 0))
                          {
                            localBundle.putInt("set_cookie", 1);
                            com.tencent.xweb.c.il(ae.getContext());
                            paramBundle = com.tencent.xweb.b.cSe();
                            localObject1 = WebViewUI.w(this.rpH).keySet().iterator();
                            while (((Iterator)localObject1).hasNext())
                            {
                              localObject2 = (String)((Iterator)localObject1).next();
                              paramBundle.setCookie(bk.aai(this.rpH.kpt), (String)localObject2 + "=" + (String)WebViewUI.w(this.rpH).get(localObject2));
                            }
                            paramBundle.setCookie(bk.aai(this.rpH.kpt), "httponly");
                            com.tencent.xweb.c.cSg();
                            com.tencent.xweb.c.sync();
                            y.i("MicroMsg.WebViewUI", "cookies:%s", new Object[] { paramBundle.getCookie(bk.aai(this.rpH.kpt)) });
                          }
                          else
                          {
                            localBundle.putInt("set_cookie", 0);
                            continue;
                            bool1 = paramBundle.getBoolean("add_shortcut_status");
                            if (this.rpH.rbk != null)
                            {
                              this.rpH.rbk.lt(bool1);
                              continue;
                              localBundle.putBoolean("is_from_keep_top", this.rpH.getIntent().getBooleanExtra("is_from_keep_top", false));
                              continue;
                              if (this.rpH.gAS != null) {
                                this.rpH.gAS.disable();
                              }
                              this.rpH.screenOrientation = paramBundle.getInt("screen_orientation", -1);
                              if (this.rpH.screenOrientation == 1001)
                              {
                                this.rpH.screenOrientation = 0;
                                if (this.rpH.gAS != null)
                                {
                                  y.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                                  this.rpH.gAS.enable();
                                }
                              }
                              for (;;)
                              {
                                this.rpH.ahA();
                                break;
                                if (this.rpH.screenOrientation == 1002)
                                {
                                  this.rpH.screenOrientation = 1;
                                  if (this.rpH.gAS != null)
                                  {
                                    y.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                                    this.rpH.gAS.enable();
                                  }
                                }
                              }
                              this.rpH.S(paramBundle);
                              continue;
                              localBundle.putInt("web_page_count", WebViewUI.ceD());
                              continue;
                              localBundle.putString("geta8key_data_req_url", this.rpH.caV());
                              localBundle.putString("geta8key_data_username", this.rpH.getIntent().getStringExtra("geta8key_username"));
                              localBundle.putInt("geta8key_data_scene", WebViewUI.b(this.rpH, this.rpH.getIntent().getStringExtra("geta8key_username")));
                              localBundle.putInt("geta8key_data_reason", 8);
                              if (this.rpH.niQ.getIsX5Kernel()) {
                                localBundle.putInt("geta8key_data_flag", 1);
                              }
                              for (;;)
                              {
                                paramBundle = this.rpH.rfg;
                                localBundle.putString("geta8key_data_net_type", an.ccc());
                                localBundle.putInt("geta8key_session_id", WebViewUI.x(this.rpH));
                                localBundle.putInt("webview_binder_id", this.rpH.hashCode());
                                localBundle.putByteArray("k_a8key_cookie", WebViewUI.y(this.rpH));
                                localBundle.putString("geta8key_data_appid", this.rpH.getIntent().getStringExtra("geta8key_open_webview_appid"));
                                break;
                                localBundle.putInt("geta8key_data_flag", 0);
                              }
                              localObject1 = paramBundle.getString("geta8key_result_req_url");
                              localObject2 = paramBundle.getString("geta8key_result_full_url");
                              if (!bk.bl((String)localObject2))
                              {
                                Object localObject3 = new JsapiPermissionWrapper(paramBundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                                Object localObject4 = new GeneralControlWrapper(paramBundle.getInt("geta8key_result_general_ctrl_b1"));
                                this.rpH.gGo.a(((String)localObject2).replaceFirst("http://", "https//"), (JsapiPermissionWrapper)localObject3, (GeneralControlWrapper)localObject4);
                                localObject3 = paramBundle.getStringArray("geta8key_result_http_header_key_list");
                                paramBundle = paramBundle.getStringArray("geta8key_result_http_header_value_list");
                                localObject4 = new HashMap();
                                if ((localObject3 != null) && (paramBundle != null) && (localObject3.length > 0) && (paramBundle.length > 0) && (localObject3.length == paramBundle.length))
                                {
                                  paramInt = 0;
                                  while (paramInt < localObject3.length)
                                  {
                                    ((Map)localObject4).put(localObject3[paramInt], paramBundle[paramInt]);
                                    paramInt += 1;
                                  }
                                }
                                this.rpH.g((String)localObject1, (String)localObject2, (Map)localObject4);
                              }
                              else
                              {
                                y.e("MicroMsg.WebViewUI", "updatePageAuth fail fullUrl is null");
                                continue;
                                paramBundle = paramBundle.getString(e.j.uIa, "");
                                this.rpH.Ti(paramBundle);
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
  
  public final void fx(String paramString1, String paramString2)
  {
    WebViewUI.a(this.rpH).post(new WebViewUI.ac.32(this, paramString1));
  }
  
  public final void fy(final String paramString1, final String paramString2)
  {
    WebViewUI.a(this.rpH).post(new Runnable()
    {
      public final void run()
      {
        if (!bk.bl(paramString1))
        {
          if (!bk.bl(paramString2)) {
            WebViewUI.ac.this.rpH.getIntent().putExtra("view_port_code", paramString2);
          }
          WebViewUI.ac.this.rpH.b(paramString1, null, false);
        }
      }
    });
  }
  
  public final String getCurrentUrl()
  {
    return this.rpH.cdR();
  }
  
  public final void le(boolean paramBoolean)
  {
    boolean bool = this.rpH.getIntent().getBooleanExtra("forceHideShare", false);
    y.d("MicroMsg.WebViewUI", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    WebViewUI.a(this.rpH).post(new WebViewUI.ac.27(this, bool, paramBoolean));
  }
  
  public final void lf(boolean paramBoolean)
  {
    WebViewUI.a(this.rpH).post(new WebViewUI.ac.28(this, paramBoolean));
  }
  
  public final void lg(boolean paramBoolean)
  {
    this.rpH.lm(paramBoolean);
  }
  
  public final void p(int paramInt, Bundle paramBundle)
  {
    WebViewUI.a(this.rpH).post(new WebViewUI.ac.31(this, paramInt, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac
 * JD-Core Version:    0.7.0.1
 */