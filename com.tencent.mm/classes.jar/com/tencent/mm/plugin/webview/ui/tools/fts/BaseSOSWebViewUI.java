package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.d.h.39;
import com.tencent.mm.plugin.webview.d.h.46;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseSOSWebViewUI
  extends BaseSearchWebViewUI
  implements FTSEditTextView.b
{
  protected boolean QkA;
  private boolean QkB;
  private b QkC;
  View Qks;
  protected SOSEditTextView Qkt;
  protected boolean Qku;
  private List<c> Qkv;
  protected int Qkw;
  private e Qkx;
  private com.tencent.mm.plugin.webview.fts.d.a Qky;
  boolean Qkz;
  protected ImageView kCv;
  
  public BaseSOSWebViewUI()
  {
    AppMethodBeat.i(265834);
    this.Qkw = 0;
    this.QkA = false;
    this.QkC = new b((byte)0);
    AppMethodBeat.o(265834);
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(164030);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramc });
    if ((paramc == FTSEditTextView.c.XLV) || (paramc == FTSEditTextView.c.XLW))
    {
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80541);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.had());
          }
          AppMethodBeat.o(80541);
        }
      });
      AppMethodBeat.o(164030);
      return;
    }
    if (paramc == FTSEditTextView.c.XLX)
    {
      if (this.Qkt.bGw.hasFocus())
      {
        this.Qkt.hXR();
        AppMethodBeat.o(164030);
        return;
      }
      this.Qkt.hXQ();
    }
    AppMethodBeat.o(164030);
  }
  
  public boolean aDV()
  {
    AppMethodBeat.i(80562);
    this.Qkt.bGw.clearFocus();
    hideVKB();
    if (getTotalQuery().length() > 0)
    {
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80525);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            HashMap localHashMap1 = new HashMap();
            if (BaseSOSWebViewUI.this.gZZ() != 0)
            {
              localHashMap1.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.gZZ()));
              localHashMap1.put("sugId", BaseSOSWebViewUI.this.gZY());
            }
            com.tencent.mm.plugin.webview.d.h localh = BaseSOSWebViewUI.this.getJsapi();
            String str1 = BaseSOSWebViewUI.this.getTotalQuery();
            String str2 = BaseSOSWebViewUI.this.getInEditTextQuery();
            JSONArray localJSONArray = BaseSOSWebViewUI.this.had();
            HashMap localHashMap2 = new HashMap();
            localHashMap2.putAll(localHashMap1);
            localHashMap2.put("query", str1);
            localHashMap2.put("custom", str2);
            localHashMap2.put("tagList", localJSONArray);
            localh.b("onSearchInputConfirm", localHashMap2, null);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ah.a(BaseSOSWebViewUI.this.QkU, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.fPs, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.QkV);
            }
          }
          AppMethodBeat.o(80525);
        }
      });
      hideVKB();
      this.Qkz = true;
      AppMethodBeat.o(80562);
      return true;
    }
    AppMethodBeat.o(80562);
    return true;
  }
  
  public final String aoI(int paramInt)
  {
    AppMethodBeat.i(80571);
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "educationTab");
      Object localObject2 = this.pGC.w(2, (Bundle)localObject1);
      localObject1 = ((Bundle)localObject2).getString("result");
      localObject2 = ((Bundle)localObject2).getString("result_1");
      if (localObject2 == null) {}
      for (;;)
      {
        localObject1 = new JSONObject((String)localObject1).optJSONArray("items");
        if (localObject1 != null) {
          break;
        }
        AppMethodBeat.o(80571);
        return "";
        localObject1 = localObject2;
      }
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (((JSONObject)localObject2).optInt("businessType") == paramInt)
        {
          localObject1 = ((JSONObject)localObject2).optString("hotword");
          AppMethodBeat.o(80571);
          return localObject1;
        }
        i += 1;
      }
      return "";
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(80571);
    }
  }
  
  protected final void c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(80570);
    Log.v("MicroMsg.WebSearch.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[] { Integer.valueOf(paramInt), paramString, paramMap });
    int i = this.QkV;
    this.QkV = paramInt;
    if (i != paramInt) {
      gZT();
    }
    if (this.Qkv == null) {
      this.Qkv = new ArrayList();
    }
    c localc1;
    c localc2;
    if (getTotalQuery().length() > 0)
    {
      localc1 = new c();
      localc1.type = this.QkV;
      localc1.unc = new ArrayList(this.Qkt.getTagList());
      localc1.QkO = this.Qkt.getInEditTextQuery();
      localc1.QkN = this.Qkt.getTotalQuery();
      if (this.Qkv.size() == 0) {
        this.Qkv.add(localc1);
      }
    }
    else if ((this.Qkv != null) && (!this.Qkv.isEmpty()))
    {
      localc1 = (c)this.Qkv.get(0);
      localc2 = new c();
      localc2.type = paramInt;
      localc2.QkN = paramString;
      localc2.QkP = paramMap;
      if (localc1 != null)
      {
        if (localc1 != localc2) {
          break label297;
        }
        paramInt = 1;
      }
    }
    for (;;)
    {
      if (paramInt != 0) {
        localc1.QkP = paramMap;
      }
      AppMethodBeat.o(80570);
      return;
      if (localc1.equals((c)this.Qkv.get(0))) {
        break;
      }
      this.Qkv.add(0, localc1);
      break;
      label297:
      paramString = (c)localc2;
      if ((paramString.type == localc1.type) && (paramString.QkN.trim().equals(localc1.QkN.trim()))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final i cDV()
  {
    AppMethodBeat.i(265835);
    i locali = super.cDV();
    if (locali != null) {
      locali.a(this.QkC);
    }
    AppMethodBeat.o(265835);
    return locali;
  }
  
  public final void dvg()
  {
    AppMethodBeat.i(164029);
    if (!this.Qkt.bGw.hasFocus())
    {
      this.Qkt.aDU();
      showVKB();
    }
    AppMethodBeat.o(164029);
  }
  
  public void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(80560);
    if ((paramBoolean) && (!Util.isNullOrNil(getTotalQuery()))) {
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80542);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.had());
          }
          AppMethodBeat.o(80542);
        }
      });
    }
    AppMethodBeat.o(80560);
  }
  
  public final void gYI()
  {
    AppMethodBeat.i(80563);
    grl();
    AppMethodBeat.o(80563);
  }
  
  public final boolean gYP()
  {
    return false;
  }
  
  public final boolean gYZ()
  {
    return true;
  }
  
  protected final boolean gZR()
  {
    AppMethodBeat.i(265837);
    if ((this.Qkv != null) && (this.Qkv.size() > 1))
    {
      AppMethodBeat.o(265837);
      return true;
    }
    AppMethodBeat.o(265837);
    return false;
  }
  
  protected void gZS() {}
  
  protected void gZT() {}
  
  protected void gZU()
  {
    AppMethodBeat.i(80557);
    if (!this.Qku) {
      this.Qkt.O("", null);
    }
    hideVKB();
    this.QkA = true;
    btS().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80540);
        if (BaseSOSWebViewUI.this.getJsapi() != null) {
          BaseSOSWebViewUI.this.aJ(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80539);
              Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onClickCancelBtn js api run onSOSCancelButtonClick");
              com.tencent.mm.plugin.webview.d.h localh = BaseSOSWebViewUI.this.getJsapi();
              int i = BaseSOSWebViewUI.this.scene;
              HashMap localHashMap = new HashMap();
              localHashMap.put("isCancelButtonClick", Integer.valueOf(1));
              localHashMap.put("isInputChange", Integer.valueOf(1));
              localHashMap.put("scene", Integer.valueOf(i));
              localh.b("onSearchInputChange", localHashMap, null);
              BaseSOSWebViewUI.this.QkA = false;
              BaseSOSWebViewUI.this.gZV();
              AppMethodBeat.o(80539);
            }
          });
        }
        AppMethodBeat.o(80540);
      }
    });
    this.Qkv = null;
    this.Qkz = false;
    if (this.Qkx != null) {
      this.Qkx.onDestroy();
    }
    AppMethodBeat.o(80557);
  }
  
  protected void gZV() {}
  
  protected void gZW()
  {
    AppMethodBeat.i(265840);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageLoaded %b", new Object[] { Boolean.valueOf(this.POj) });
    AppMethodBeat.o(265840);
  }
  
  protected void gZX()
  {
    AppMethodBeat.i(265841);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageStartLoad");
    AppMethodBeat.o(265841);
  }
  
  protected String gZY()
  {
    return "";
  }
  
  protected int gZZ()
  {
    return 0;
  }
  
  public final boolean gZe()
  {
    return false;
  }
  
  protected String getHint()
  {
    return null;
  }
  
  protected final String getInEditTextQuery()
  {
    AppMethodBeat.i(80567);
    String str = this.Qkt.getInEditTextQuery();
    AppMethodBeat.o(80567);
    return str;
  }
  
  protected final int getScene()
  {
    return this.scene;
  }
  
  protected final int getTabType()
  {
    return this.QkV;
  }
  
  protected final String getTotalQuery()
  {
    AppMethodBeat.i(80566);
    if (this.Qkt != null)
    {
      String str = this.Qkt.getTotalQuery();
      AppMethodBeat.o(80566);
      return str;
    }
    AppMethodBeat.o(80566);
    return "";
  }
  
  protected final int getType()
  {
    return this.type;
  }
  
  protected void grl()
  {
    AppMethodBeat.i(80556);
    hideVKB();
    hai();
    if (gZR())
    {
      this.Qkv.remove(0);
      final c localc = (c)this.Qkv.get(0);
      this.Qkt.O(localc.QkO, localc.unc);
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80538);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            BaseSOSWebViewUI.this.gZS();
            BaseSOSWebViewUI.this.QkV = localc.type;
            BaseSOSWebViewUI.this.gZT();
            HashMap localHashMap = new HashMap();
            localHashMap.put("isBackButtonClick", "1");
            localHashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.had(), 1, localc.QkP);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ah.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.fPs, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
            }
          }
          AppMethodBeat.o(80538);
        }
      });
      AppMethodBeat.o(80556);
      return;
    }
    if (this.Qkz)
    {
      gZU();
      AppMethodBeat.o(80556);
      return;
    }
    finish();
    AppMethodBeat.o(80556);
  }
  
  public final SOSEditTextView haa()
  {
    return this.Qkt;
  }
  
  protected final boolean hab()
  {
    return this.QkB;
  }
  
  protected final e hac()
  {
    return this.Qkx;
  }
  
  public final JSONArray had()
  {
    AppMethodBeat.i(80568);
    Object localObject = this.Qkt.getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tagName", locala.LtE);
        localJSONObject.put("tagType", locala.aRY);
        localJSONObject.put("userName", locala.userName);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(80568);
    return localJSONArray;
  }
  
  public boolean hae()
  {
    return false;
  }
  
  protected boolean haf()
  {
    return true;
  }
  
  public void o(final int paramInt, final Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(80565);
    switch (paramInt)
    {
    default: 
      super.o(paramInt, paramBundle);
    case 126: 
    case 119: 
    case 127: 
    case 143: 
    case 120: 
    case 121: 
    case 122: 
    case 124: 
    case 125: 
    case 60: 
    case 100001: 
    case 61: 
    case 62: 
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(80565);
              return;
              paramBundle.getString("fts_key_json_data");
              paramBundle.getBoolean("fts_key_new_query", true);
              Object localObject1 = new HashMap();
              Object localObject2 = paramBundle.keySet().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                ((Map)localObject1).put(localObject3, paramBundle.get((String)localObject3));
              }
              btS().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80526);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().bP(this.quj);
                  }
                  AppMethodBeat.o(80526);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_json_data");
              localObject2 = paramBundle.getString("fts_key_req_id");
              final boolean bool = paramBundle.getBoolean("fts_key_new_query", true);
              paramBundle = paramBundle.getBundle("fts_key_data");
              btS().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80527);
                  Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "[handleFTSAction] onSearchDataReady");
                  BaseSOSWebViewUI.this.aJ(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(265818);
                      if (BaseSOSWebViewUI.this.getJsapi() != null)
                      {
                        if ((BaseSOSWebViewUI.4.this.MXK != null) && (BaseSOSWebViewUI.4.this.MXK.getInt("isRefresh") == 1) && (BaseSOSWebViewUI.4.this.MXK.getString("widgetId") != null))
                        {
                          BaseSOSWebViewUI.this.getJsapi().mv(BaseSOSWebViewUI.4.this.MXK.getString("widgetId"), BaseSOSWebViewUI.4.this.qYf);
                          AppMethodBeat.o(265818);
                          return;
                        }
                        BaseSOSWebViewUI.this.getJsapi().i(BaseSOSWebViewUI.4.this.qYf, BaseSOSWebViewUI.4.this.QkE, BaseSOSWebViewUI.4.this.PLs);
                      }
                      AppMethodBeat.o(265818);
                    }
                  });
                  AppMethodBeat.o(80527);
                }
              });
              AppMethodBeat.o(80565);
              return;
              aJ(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80528);
                  if (BaseSOSWebViewUI.this.getJsapi() != null)
                  {
                    com.tencent.mm.plugin.webview.d.h localh = BaseSOSWebViewUI.this.getJsapi();
                    String str1 = this.qYf;
                    String str2 = this.PLs;
                    if (!localh.NoX)
                    {
                      Log.e("MicroMsg.JsApiHandler", "onChatSearchDataReady fail, not ready");
                      AppMethodBeat.o(80528);
                      return;
                    }
                    Log.i("MicroMsg.JsApiHandler", "onChatSearchDataReady success, ready");
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("json", str1);
                    localHashMap.put("requestId", str2);
                    MMHandlerThread.postToMainThread(new h.46(localh, n.a.b("onChatSearchDataReady", localHashMap, localh.PNx, localh.EVx)));
                  }
                  AppMethodBeat.o(80528);
                }
              });
              AppMethodBeat.o(80565);
              return;
              paramBundle = paramBundle.getString("data");
              btS().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80529);
                  if (BaseSOSWebViewUI.this.getJsapi() != null)
                  {
                    com.tencent.mm.plugin.webview.d.h localh = BaseSOSWebViewUI.this.getJsapi();
                    String str = paramBundle;
                    if (!localh.NoX)
                    {
                      Log.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
                      AppMethodBeat.o(80529);
                      return;
                    }
                    Log.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                    try
                    {
                      MMHandlerThread.postToMainThread(new h.39(localh, n.a.a("onSearchHistoryReady", new JSONObject(str), localh.PNx, localh.EVx)));
                      AppMethodBeat.o(80529);
                      return;
                    }
                    catch (JSONException localJSONException)
                    {
                      Log.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException, "", new Object[0]);
                    }
                  }
                  AppMethodBeat.o(80529);
                }
              });
              AppMethodBeat.o(80565);
              return;
              paramInt = paramBundle.getInt("fts_key_ret", 0);
              paramBundle = paramBundle.getString("fts_key_data");
              btS().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80530);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().cQ(paramInt, paramBundle);
                  }
                  AppMethodBeat.o(80530);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_json_data");
              aJ(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80531);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().z(this.QkG, this.qYf, this.qYg);
                  }
                  AppMethodBeat.o(80531);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_new_query");
              localObject2 = paramBundle.getString("fts_key_custom_query");
              bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
              Object localObject3 = paramBundle.getString("fts_key_tag_list");
              Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
              paramBundle = new ArrayList();
              try
              {
                if (!Util.isNullOrNil((String)localObject3))
                {
                  localObject3 = new JSONArray((String)localObject3);
                  paramInt = i;
                  while (paramInt < ((JSONArray)localObject3).length())
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject3).getJSONObject(paramInt);
                    a locala = new a();
                    locala.LtE = localJSONObject.getString("tagName");
                    locala.aRY = localJSONObject.getInt("tagType");
                    locala.userName = localJSONObject.getString("userName");
                    paramBundle.add(locala);
                    paramInt += 1;
                  }
                }
                paramBundle = paramBundle.getString("fts_key_json_data");
              }
              catch (Exception localException)
              {
                if (this.Qkt != null)
                {
                  if (paramBundle.size() > 0) {
                    this.Qkt.O((String)localObject2, paramBundle);
                  }
                }
                else
                {
                  if (!bool) {
                    break label756;
                  }
                  btS().post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(80532);
                      if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.had());
                      }
                      AppMethodBeat.o(80532);
                    }
                  });
                  if (this.Qkt != null) {
                    this.Qkt.aDU();
                  }
                  gZf();
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.fts.b.a.a.gTy();
                  com.tencent.mm.plugin.webview.fts.b.a.a.bjT(getTotalQuery());
                  AppMethodBeat.o(80565);
                  return;
                  this.Qkt.O((String)localObject1, paramBundle);
                  break;
                  if (this.Qkt != null) {
                    this.Qkt.bGw.clearFocus();
                  }
                }
              }
              btS().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80533);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().biX(paramBundle);
                  }
                  AppMethodBeat.o(80533);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_sns_id");
              paramInt = paramBundle.getInt("fts_key_status", 0);
              btS().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80534);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().gY(this.QkH, paramInt);
                  }
                  AppMethodBeat.o(80534);
                }
              });
              AppMethodBeat.o(80565);
              return;
              if (!haf())
              {
                Log.w("MicroMsg.WebSearch.BaseSOSWebViewUI", "current state is not search");
                AppMethodBeat.o(80565);
                return;
              }
            } while (this.Qkx == null);
            this.Qkx.c(paramBundle, this.scene);
            AppMethodBeat.o(80565);
            return;
          } while (this.Qkx == null);
          this.Qkx.bf(paramBundle);
          AppMethodBeat.o(80565);
          return;
        } while (this.Qkx == null);
        this.Qkx.bg(paramBundle);
        AppMethodBeat.o(80565);
        return;
      } while (this.Qkx == null);
      this.Qkx.bh(paramBundle);
      AppMethodBeat.o(80565);
      return;
    case 138: 
      paramBundle = paramBundle.getString("fts_key_data");
      if (!Util.isNullOrNil(paramBundle))
      {
        if ("index".equals(paramBundle))
        {
          this.Qkw = 1;
          AppMethodBeat.o(80565);
          return;
        }
        if ("result".equals(paramBundle))
        {
          this.Qkw = 2;
          AppMethodBeat.o(80565);
          return;
        }
        if ("suggestion".equals(paramBundle))
        {
          this.Qkw = 3;
          AppMethodBeat.o(80565);
          return;
        }
        if ("teach".equals(paramBundle))
        {
          this.Qkw = 4;
          AppMethodBeat.o(80565);
          return;
        }
        if ("local".equals(paramBundle))
        {
          this.Qkw = 5;
          AppMethodBeat.o(80565);
          return;
        }
        this.Qkw = 0;
        AppMethodBeat.o(80565);
        return;
      }
      this.Qkw = 0;
      AppMethodBeat.o(80565);
      return;
    case 144: 
      label756:
      AppMethodBeat.o(80565);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    final long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    btS().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(248611);
        if (BaseSOSWebViewUI.this.PvJ != null)
        {
          BaseSOSWebViewUI.this.PvJ.a(paramInt, l, this.tvn);
          Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), this.tvn });
        }
        AppMethodBeat.o(248611);
      }
    });
    AppMethodBeat.o(80565);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80569);
    grl();
    AppMethodBeat.o(80569);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80561);
    if (this.Qkt != null)
    {
      if (!this.Qkt.bGw.hasFocus())
      {
        this.Qkt.aDU();
        showVKB();
      }
      this.Qkt.setHint(getHint());
    }
    AppMethodBeat.o(80561);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80552);
    super.onCreate(paramBundle);
    this.Qku = getIntent().getBooleanExtra("ftsInitToSearch", false);
    getSupportActionBar().hide();
    this.Qks = findViewById(c.f.search_input_layout);
    this.Qkt = ((SOSEditTextView)findViewById(c.f.sos_edittext));
    this.Qkt.setFtsEditTextListener(this);
    this.Qkt.setHint(getHint());
    this.Qkt.setCancelTextViewClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80524);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        BaseSOSWebViewUI.this.gZU();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(80524);
      }
    });
    this.kCv = ((ImageView)findViewById(c.f.back_btn));
    this.kCv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80535);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        BaseSOSWebViewUI.this.grl();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(80535);
      }
    });
    this.pHS.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80536);
        BaseSOSWebViewUI.this.haa().getEditText().clearFocus();
        BaseSOSWebViewUI.this.hideVKB();
        AppMethodBeat.o(80536);
        return false;
      }
    });
    if (this.QjP) {
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80537);
          BaseSOSWebViewUI.this.haa().aDU();
          BaseSOSWebViewUI.this.haa().aDT();
          AppMethodBeat.o(80537);
        }
      }, 128L);
    }
    if (this.QgG != null) {
      this.QgG.Dc(true);
    }
    this.pHS.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(223458);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(223458);
        return true;
      }
    });
    this.Qky = new com.tencent.mm.plugin.webview.fts.d.a(this.pHS);
    this.Qky.PvJ = this.PvJ;
    this.Qkx = new e(((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.f.class)).a(getContext(), this.Qky));
    AppMethodBeat.o(80552);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80564);
    try
    {
      if (this.pGC != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.pGC.y(1, localBundle);
      }
      if (this.Qkx != null) {
        this.Qkx.onDestroy();
      }
    }
    catch (RemoteException localRemoteException)
    {
      label58:
      break label58;
    }
    hideVKB();
    this.PIQ.b(this.QkC);
    this.PIQ.b(this.QkC.QkL);
    super.onDestroy();
    AppMethodBeat.o(80564);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80555);
    super.onPause();
    if (this.Qkx != null) {
      this.Qkx.onPause();
    }
    AppMethodBeat.o(80555);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80554);
    super.onResume();
    if (this.Qkx != null) {
      this.Qkx.onResume();
    }
    AppMethodBeat.o(80554);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    implements a.c
  {
    String LtE;
    int aRY;
    String userName;
    
    public a() {}
    
    public final int compareTo(Object paramObject)
    {
      AppMethodBeat.i(80543);
      if ((paramObject == null) || (!(paramObject instanceof FTSBaseWebViewUI.a)))
      {
        AppMethodBeat.o(80543);
        return -1;
      }
      paramObject = (FTSBaseWebViewUI.a)paramObject;
      int i = this.LtE.compareTo(paramObject.LtE);
      AppMethodBeat.o(80543);
      return i;
    }
    
    public final String getTagName()
    {
      return this.LtE;
    }
  }
  
  final class b
    extends k
  {
    a QkL;
    
    private b()
    {
      AppMethodBeat.i(220441);
      this.QkL = new a((byte)0);
      AppMethodBeat.o(220441);
    }
    
    private static WebResourceResponse bjb(String paramString)
    {
      AppMethodBeat.i(220463);
      Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      paramString = Uri.parse(paramString);
      try
      {
        paramString = u.Tf(paramString.getQueryParameter("path"));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/*", "utf8", paramString);
          AppMethodBeat.o(220463);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        AppMethodBeat.o(220463);
      }
      return null;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(220458);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
      {
        paramWebView = bjb(paramWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(220458);
        return paramWebView;
      }
      AppMethodBeat.o(220458);
      return null;
    }
    
    public final j bXJ()
    {
      AppMethodBeat.i(220455);
      b localb = new b((byte)0);
      AppMethodBeat.o(220455);
      return localb;
    }
    
    public final boolean bjJ(String paramString)
    {
      AppMethodBeat.i(220446);
      if (BaseSOSWebViewUI.this.POj)
      {
        AppMethodBeat.o(220446);
        return true;
      }
      boolean bool = super.bjJ(paramString);
      AppMethodBeat.o(220446);
      return bool;
    }
    
    public final boolean e(String paramString, Intent paramIntent)
    {
      AppMethodBeat.i(220450);
      BaseSOSWebViewUI.this.gZX();
      boolean bool = super.e(paramString, paramIntent);
      AppMethodBeat.o(220450);
      return bool;
    }
    
    public final com.tencent.mm.plugin.webview.core.f gTb()
    {
      return this.QkL;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.f
    {
      private a() {}
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(228892);
        Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.this.scene), paramString });
        BaseSOSWebViewUI.this.showOptionMenu(false);
        if ((BaseSOSWebViewUI.this.Qkt != null) && (!BaseSOSWebViewUI.this.QjP))
        {
          BaseSOSWebViewUI.this.Qkt.bGw.clearFocus();
          BaseSOSWebViewUI.this.hideVKB();
        }
        if (!BaseSOSWebViewUI.this.POj) {
          ah.b(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.fPs, BaseSOSWebViewUI.this.query, BaseSOSWebViewUI.this.type, "", BaseSOSWebViewUI.this.POj, BaseSOSWebViewUI.this.jQi);
        }
        AppMethodBeat.o(228892);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(228898);
        Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d,onPageStarted %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.this.scene), paramString });
        BaseSOSWebViewUI.this.showOptionMenu(false);
        if ((BaseSOSWebViewUI.this.Qkt != null) && (!BaseSOSWebViewUI.this.QjP))
        {
          BaseSOSWebViewUI.this.Qkt.bGw.clearFocus();
          BaseSOSWebViewUI.this.hideVKB();
        }
        if (!BaseSOSWebViewUI.this.POj) {
          ah.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.fPs, BaseSOSWebViewUI.this.query, BaseSOSWebViewUI.this.type, "", BaseSOSWebViewUI.this.POj, BaseSOSWebViewUI.this.jQi);
        }
        AppMethodBeat.o(228898);
      }
    }
    
    final class b
      extends j
    {
      private b() {}
      
      public final void bXI()
      {
        AppMethodBeat.i(223498);
        BaseSOSWebViewUI.a(BaseSOSWebViewUI.this);
        BaseSOSWebViewUI.this.gZW();
        AppMethodBeat.o(223498);
      }
    }
  }
  
  protected final class c
  {
    String QkN;
    String QkO;
    Map<String, Object> QkP;
    int type;
    List<a.c> unc;
    
    protected c()
    {
      AppMethodBeat.i(80550);
      this.QkN = "";
      this.QkO = "";
      this.QkP = new HashMap();
      AppMethodBeat.o(80550);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(80551);
      if (this == paramObject)
      {
        AppMethodBeat.o(80551);
        return true;
      }
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((paramObject.type == this.type) && (paramObject.QkO.equals(this.QkO)))
        {
          AppMethodBeat.o(80551);
          return true;
        }
        AppMethodBeat.o(80551);
        return false;
      }
      AppMethodBeat.o(80551);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
 * JD-Core Version:    0.7.0.1
 */