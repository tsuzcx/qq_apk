package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.j.40;
import com.tencent.mm.plugin.webview.jsapi.j.47;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.n;
import com.tencent.mm.plugin.webview.ui.tools.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
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
  implements FTSEditTextView.c
{
  protected boolean WoH;
  protected boolean WoS;
  View Xcd;
  private View Xce;
  protected View Xcf;
  protected View Xcg;
  protected SOSEditTextView Xch;
  protected boolean Xci;
  protected boolean Xcj;
  protected boolean Xck;
  protected boolean Xcl;
  protected boolean Xcm;
  protected boolean Xcn;
  protected boolean Xco;
  protected boolean Xcp;
  private List<c> Xcq;
  protected boolean Xcr;
  protected int Xcs;
  private e Xct;
  private com.tencent.mm.plugin.webview.fts.c.a Xcu;
  protected int Xcv;
  boolean Xcw;
  protected boolean Xcx;
  private boolean Xcy;
  private b Xcz;
  protected ImageView nfU;
  
  public BaseSOSWebViewUI()
  {
    AppMethodBeat.i(296792);
    this.Xck = false;
    this.Xcl = false;
    this.Xcm = true;
    this.Xcn = true;
    this.Xco = true;
    this.Xcp = false;
    this.Xcr = false;
    this.Xcs = 0;
    this.WoS = false;
    this.Xcv = 0;
    this.Xcx = false;
    this.Xcz = new b((byte)0);
    AppMethodBeat.o(296792);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(296809);
    com.tencent.threadpool.h.ahAA.bm(new BaseSOSWebViewUI.19(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramLong, paramString5));
    AppMethodBeat.o(296809);
  }
  
  protected static boolean iAg()
  {
    return true;
  }
  
  protected static boolean iAh()
  {
    return true;
  }
  
  public boolean aWU()
  {
    AppMethodBeat.i(80562);
    this.Xch.dzv.clearFocus();
    hideVKB();
    if (getTotalQuery().length() > 0)
    {
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80530);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            HashMap localHashMap1 = new HashMap();
            if (BaseSOSWebViewUI.this.iAd() != 0)
            {
              localHashMap1.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.iAd()));
              localHashMap1.put("sugId", BaseSOSWebViewUI.this.iAc());
            }
            j localj = BaseSOSWebViewUI.this.getJsapi();
            String str1 = BaseSOSWebViewUI.this.getTotalQuery();
            String str2 = BaseSOSWebViewUI.this.getInEditTextQuery();
            JSONArray localJSONArray = BaseSOSWebViewUI.this.iAj();
            HashMap localHashMap2 = new HashMap();
            localHashMap2.putAll(localHashMap1);
            localHashMap2.put("query", str1);
            localHashMap2.put("custom", str2);
            localHashMap2.put("tagList", localJSONArray);
            localj.b("onSearchInputConfirm", localHashMap2, null);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ai.a(BaseSOSWebViewUI.this.Xdb, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.hVn, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.Xdc);
            }
          }
          AppMethodBeat.o(80530);
        }
      });
      hideVKB();
      this.Xcw = true;
      AppMethodBeat.o(80562);
      return true;
    }
    AppMethodBeat.o(80562);
    return true;
  }
  
  public final String auC(int paramInt)
  {
    AppMethodBeat.i(80571);
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "educationTab");
      Object localObject2 = this.sLC.z(2, (Bundle)localObject1);
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
    int i = this.Xdc;
    this.Xdc = paramInt;
    if (i != paramInt) {
      izX();
    }
    if (this.Xcq == null) {
      this.Xcq = new ArrayList();
    }
    c localc1;
    c localc2;
    if (getTotalQuery().length() > 0)
    {
      localc1 = new c();
      localc1.type = this.Xdc;
      localc1.xtu = new ArrayList(this.Xch.getTagList());
      localc1.XcV = this.Xch.getInEditTextQuery();
      localc1.XcU = this.Xch.getTotalQuery();
      if (this.Xcq.size() == 0) {
        this.Xcq.add(localc1);
      }
    }
    else if ((this.Xcq != null) && (!this.Xcq.isEmpty()))
    {
      localc1 = (c)this.Xcq.get(0);
      localc2 = new c();
      localc2.type = paramInt;
      localc2.XcU = paramString;
      localc2.XcW = paramMap;
      if (localc1 != null)
      {
        if (localc1 != localc2) {
          break label298;
        }
        paramInt = 1;
      }
    }
    for (;;)
    {
      if (paramInt != 0) {
        localc1.XcW = paramMap;
      }
      AppMethodBeat.o(80570);
      return;
      if (localc1.equals((c)this.Xcq.get(0))) {
        break;
      }
      this.Xcq.add(0, localc1);
      break;
      label298:
      paramString = (c)localc2;
      if ((paramString.type == localc1.type) && (paramString.XcU.trim().equals(localc1.XcU.trim()))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void cp(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(296854);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "openSearchWebView %s", new Object[] { paramMap.toString() });
    int i = aj.c(paramMap, "type", 0);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("toViewType", "suggestion");
    Object localObject2 = n.afS(new JSONObject((Map)localObject1).toString());
    localObject1 = (String)paramMap.get("tagId");
    String str2 = (String)paramMap.get("sessionId");
    int j = aj.c(paramMap, "scene", 0);
    String str1 = this.Xch.getInEditTextQuery();
    String str3 = aj.au(paramMap, "searchId");
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsQuery", str1);
    localIntent.putExtra("ftsType", i);
    localIntent.putExtra("ftsbizscene", j);
    localObject2 = aj.a(j, false, i, (String)localObject2);
    ((Map)localObject2).put("query", n.afS(str1));
    ((Map)localObject2).put("searchId", str3);
    ((Map)localObject2).put("isHomePage", "1");
    ((Map)localObject2).put("isSug", "1");
    if (!TextUtils.isEmpty(str2))
    {
      ((Map)localObject2).put("sessionId", str2);
      localIntent.putExtra("sessionId", str2);
    }
    paramMap = (String)paramMap.get("subSessionId");
    ((Map)localObject2).put("subSessionId", paramMap);
    localIntent.putExtra("subSessionId", paramMap);
    localIntent.putExtra("rawUrl", com.tencent.mm.plugin.webview.fts.c.bS((Map)localObject2));
    localIntent.putExtra("ftsQuery", str1);
    localIntent.putExtra("tabId", (String)localObject1);
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("key_search_icon_and_hint_fix_default", true);
    localIntent.putExtra("ftsInitToSearch", true);
    localIntent.putExtra("hideSearchInput", false);
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
    AppMethodBeat.o(296854);
  }
  
  public final k dhx()
  {
    AppMethodBeat.i(296860);
    k localk = super.dhx();
    if (localk != null) {
      localk.a(this.Xcz);
    }
    AppMethodBeat.o(296860);
    return localk;
  }
  
  public final void eeU()
  {
    AppMethodBeat.i(164029);
    if (!this.Xch.dzv.hasFocus())
    {
      this.Xch.aWT();
      showVKB();
    }
    AppMethodBeat.o(164029);
  }
  
  public void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(80560);
    if ((paramBoolean) && (!Util.isNullOrNil(getTotalQuery())))
    {
      Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "needSosEditTextToBeTouchOnly = %s.", new Object[] { Boolean.valueOf(this.WoS) });
      if (this.WoS)
      {
        AppMethodBeat.o(80560);
        return;
      }
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80529);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.iAj());
          }
          AppMethodBeat.o(80529);
        }
      });
    }
    AppMethodBeat.o(80560);
  }
  
  protected String getHint()
  {
    return null;
  }
  
  protected final String getInEditTextQuery()
  {
    AppMethodBeat.i(80567);
    String str = this.Xch.getInEditTextQuery();
    AppMethodBeat.o(80567);
    return str;
  }
  
  protected final int getScene()
  {
    return this.scene;
  }
  
  protected final int getTabType()
  {
    return this.Xdc;
  }
  
  protected final String getTotalQuery()
  {
    AppMethodBeat.i(80566);
    if (this.Xch != null)
    {
      String str = this.Xch.getTotalQuery();
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
  
  protected void hOk()
  {
    AppMethodBeat.i(80556);
    hideVKB();
    iAo();
    if (izU())
    {
      this.Xcq.remove(0);
      final c localc = (c)this.Xcq.get(0);
      this.Xch.V(localc.XcV, localc.xtu);
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80526);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            BaseSOSWebViewUI.this.izW();
            BaseSOSWebViewUI.this.Xdc = localc.type;
            BaseSOSWebViewUI.this.izX();
            HashMap localHashMap = new HashMap();
            localHashMap.put("isBackButtonClick", "1");
            localHashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.iAj(), 1, localc.XcW);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ai.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.hVn, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
            }
          }
          AppMethodBeat.o(80526);
        }
      });
      AppMethodBeat.o(80556);
      return;
    }
    if (this.Xcw)
    {
      izY();
      AppMethodBeat.o(80556);
      return;
    }
    finish();
    AppMethodBeat.o(80556);
  }
  
  protected void iAa()
  {
    AppMethodBeat.i(296933);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageLoaded %b", new Object[] { Boolean.valueOf(this.WEv) });
    AppMethodBeat.o(296933);
  }
  
  protected void iAb()
  {
    AppMethodBeat.i(296937);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageStartLoad");
    AppMethodBeat.o(296937);
  }
  
  protected String iAc()
  {
    return "";
  }
  
  protected int iAd()
  {
    return 0;
  }
  
  public final SOSEditTextView iAe()
  {
    return this.Xch;
  }
  
  protected final boolean iAf()
  {
    return this.Xcy;
  }
  
  protected final e iAi()
  {
    return this.Xct;
  }
  
  public final JSONArray iAj()
  {
    AppMethodBeat.i(80568);
    Object localObject = this.Xch.getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tagName", locala.RWX);
        localJSONObject.put("tagType", locala.cLU);
        localJSONObject.put("userName", locala.userName);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(80568);
    return localJSONArray;
  }
  
  public boolean iAk()
  {
    return false;
  }
  
  protected boolean iAl()
  {
    return true;
  }
  
  public final void iyF()
  {
    AppMethodBeat.i(80563);
    hOk();
    AppMethodBeat.o(80563);
  }
  
  public final boolean iyM()
  {
    return false;
  }
  
  public final boolean iyZ()
  {
    return true;
  }
  
  protected final void izT()
  {
    AppMethodBeat.i(296840);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80542);
        BaseSOSWebViewUI.this.cp(this.sNf);
        AppMethodBeat.o(80542);
      }
    });
    AppMethodBeat.o(296840);
  }
  
  protected final boolean izU()
  {
    AppMethodBeat.i(296867);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "isBackToHistory, forceClose = %s, isHomePage = %s", new Object[] { Boolean.valueOf(this.Xcr), Boolean.valueOf(this.WoH) });
    if ((this.Xcr) && (this.WoH))
    {
      AppMethodBeat.o(296867);
      return false;
    }
    if ((this.Xcq != null) && (this.Xcq.size() > 1))
    {
      AppMethodBeat.o(296867);
      return true;
    }
    AppMethodBeat.o(296867);
    return false;
  }
  
  public final void izV()
  {
    this.Xcr = true;
  }
  
  protected void izW() {}
  
  protected void izX() {}
  
  protected void izY()
  {
    AppMethodBeat.i(80557);
    if (!this.Xci) {
      this.Xch.V("", null);
    }
    hideVKB();
    this.Xcx = true;
    getHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80527);
        if (BaseSOSWebViewUI.this.getJsapi() != null) {
          BaseSOSWebViewUI.this.aS(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(296768);
              Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onClickCancelBtn js api run onSOSCancelButtonClick");
              j localj = BaseSOSWebViewUI.this.getJsapi();
              int i = BaseSOSWebViewUI.this.scene;
              HashMap localHashMap = new HashMap();
              localHashMap.put("isCancelButtonClick", Integer.valueOf(1));
              localHashMap.put("isInputChange", Integer.valueOf(1));
              localHashMap.put("scene", Integer.valueOf(i));
              localj.b("onSearchInputChange", localHashMap, null);
              BaseSOSWebViewUI.this.Xcx = false;
              BaseSOSWebViewUI.this.izZ();
              AppMethodBeat.o(296768);
            }
          });
        }
        AppMethodBeat.o(80527);
      }
    });
    this.Xcq = null;
    this.Xcw = false;
    if (this.Xct != null) {
      this.Xct.onDestroy();
    }
    AppMethodBeat.o(80557);
  }
  
  protected void izZ() {}
  
  public final boolean ize()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80569);
    hOk();
    AppMethodBeat.o(80569);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80561);
    if (this.Xch != null)
    {
      if (!this.Xch.dzv.hasFocus())
      {
        this.Xch.aWT();
        showVKB();
      }
      this.Xch.setHint(getHint());
    }
    AppMethodBeat.o(80561);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80552);
    super.onCreate(paramBundle);
    this.Xci = getIntent().getBooleanExtra("ftsInitToSearch", false);
    this.Xcj = getIntent().getBooleanExtra("ftsNeedShowCamera", true);
    this.WoH = "1".equals(iAE().get("isHomePage"));
    this.WoS = getIntent().getBooleanExtra("fts_need_sos_edittext_tobe_touch_only", false);
    getSupportActionBar().hide();
    this.Xce = findViewById(c.f.search_sos_editext_mask);
    this.Xcf = findViewById(c.f.search_input_background);
    this.Xcg = findViewById(c.f.search_bar_underline);
    this.Xcd = findViewById(c.f.search_input_layout);
    this.Xch = ((SOSEditTextView)findViewById(c.f.sos_edittext));
    this.Xch.setFtsEditTextListener(this);
    this.Xch.setHint(getHint());
    this.Xch.setCancelTextViewClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80524);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        BaseSOSWebViewUI.this.izY();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(80524);
      }
    });
    this.nfU = ((ImageView)findViewById(c.f.back_btn));
    if (this.WoS)
    {
      this.Xcg.setVisibility(8);
      this.Xch.setFocusable(false);
      this.Xch.dzv.clearFocus();
      if (this.Xcf != null) {
        this.Xcf.setVisibility(0);
      }
      if (this.Xce != null)
      {
        this.Xce.setVisibility(0);
        this.Xce.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80535);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            BaseSOSWebViewUI.this.izT();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80535);
          }
        });
        this.Xch.setCancelTextViewCallback(new SOSEditTextView.a()
        {
          public final boolean z(int paramAnonymousInt, View paramAnonymousView)
          {
            AppMethodBeat.i(296864);
            BaseSOSWebViewUI.a(BaseSOSWebViewUI.this, paramAnonymousInt, paramAnonymousView);
            AppMethodBeat.o(296864);
            return false;
          }
        });
      }
      this.Xch.setForceDisable(true);
      this.Xch.jCx();
      if (this.Xcd != null) {
        this.Xcd.setBackgroundDrawable(getResources().getDrawable(c.e.sos_round_search_bg));
      }
      if (this.Xch.getSearchBarCancelTextContainer() != null) {
        this.Xch.getSearchBarCancelTextContainer().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80537);
            BaseSOSWebViewUI.a(BaseSOSWebViewUI.this, BaseSOSWebViewUI.this.Xch.getSearchBarCancelTextContainer().getVisibility(), BaseSOSWebViewUI.this.Xch.getSearchBarCancelTextContainer());
            AppMethodBeat.o(80537);
          }
        }, 200L);
      }
      Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "searchInputLayout = " + this.Xcd + ", searchSosEditextMask = " + this.Xce);
    }
    for (;;)
    {
      this.nfU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(296869);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          BaseSOSWebViewUI.this.hOk();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(296869);
        }
      });
      this.sMP.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(296868);
          BaseSOSWebViewUI.this.iAe().getEditText().clearFocus();
          BaseSOSWebViewUI.this.hideVKB();
          AppMethodBeat.o(296868);
          return false;
        }
      });
      if (this.XbH) {
        getContentView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80540);
            BaseSOSWebViewUI.this.iAe().aWT();
            BaseSOSWebViewUI.this.iAe().aWS();
            AppMethodBeat.o(80540);
          }
        }, 128L);
      }
      Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "oncreate isNeedShowCamera = " + this.Xcj);
      if (!this.Xcj)
      {
        this.Xch.setNeedForceHideCameraIcon(true);
        this.Xch.setCommonRightImageButtonVisibile(8);
      }
      if (this.WYD != null) {
        this.WYD.IJ(true);
      }
      this.sMP.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(296870);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(296870);
          return true;
        }
      });
      this.Xcu = new com.tencent.mm.plugin.webview.fts.c.a(this.sMP);
      this.Xcu.WlX = this.WlX;
      this.Xct = new e(((f)com.tencent.mm.kernel.h.ax(f.class)).a(getContext(), this.Xcu));
      AppMethodBeat.o(80552);
      return;
      if (this.Xce != null) {
        this.Xce.setVisibility(8);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80564);
    try
    {
      if (this.sLC != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.sLC.B(1, localBundle);
      }
      if (this.Xct != null) {
        this.Xct.onDestroy();
      }
    }
    catch (RemoteException localRemoteException)
    {
      label58:
      break label58;
    }
    hideVKB();
    this.Wzl.b(this.Xcz);
    this.Wzl.b(this.Xcz.XcS);
    super.onDestroy();
    AppMethodBeat.o(80564);
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(164030);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onEditTextChange %s %s %s %s", new Object[] { paramString1, paramString2, paramd, Boolean.valueOf(this.WoS) });
    if ((paramd == FTSEditTextView.d.afCj) || (paramd == FTSEditTextView.d.afCk))
    {
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80528);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.iAj());
          }
          AppMethodBeat.o(80528);
        }
      });
      AppMethodBeat.o(164030);
      return;
    }
    if (paramd == FTSEditTextView.d.afCl)
    {
      if (this.Xch.dzv.hasFocus())
      {
        this.Xch.jCy();
        AppMethodBeat.o(164030);
        return;
      }
      this.Xch.jCx();
    }
    AppMethodBeat.o(164030);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80555);
    super.onPause();
    if (this.Xct != null) {
      this.Xct.onPause();
    }
    AppMethodBeat.o(80555);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80554);
    super.onResume();
    if (this.Xct != null) {
      this.Xct.onResume();
    }
    AppMethodBeat.o(80554);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void q(final int paramInt, final Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(80565);
    switch (paramInt)
    {
    default: 
      super.q(paramInt, paramBundle);
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
              getHandler().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80531);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().ci(this.tyZ);
                  }
                  AppMethodBeat.o(80531);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_json_data");
              localObject2 = paramBundle.getString("fts_key_req_id");
              final boolean bool = paramBundle.getBoolean("fts_key_new_query", true);
              paramBundle = paramBundle.getBundle("fts_key_data");
              getHandler().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80532);
                  Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "[handleFTSAction] onSearchDataReady");
                  BaseSOSWebViewUI.this.aS(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(296928);
                      if (BaseSOSWebViewUI.this.getJsapi() != null)
                      {
                        if ((BaseSOSWebViewUI.9.this.TKo != null) && (BaseSOSWebViewUI.9.this.TKo.getInt("isRefresh") == 1) && (BaseSOSWebViewUI.9.this.TKo.getString("widgetId") != null))
                        {
                          BaseSOSWebViewUI.this.getJsapi().ol(BaseSOSWebViewUI.9.this.TKo.getString("widgetId"), BaseSOSWebViewUI.9.this.uei);
                          AppMethodBeat.o(296928);
                          return;
                        }
                        BaseSOSWebViewUI.this.getJsapi().m(BaseSOSWebViewUI.9.this.uei, BaseSOSWebViewUI.9.this.XcE, BaseSOSWebViewUI.9.this.WBF);
                      }
                      AppMethodBeat.o(296928);
                    }
                  });
                  AppMethodBeat.o(80532);
                }
              });
              AppMethodBeat.o(80565);
              return;
              aS(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80533);
                  if (BaseSOSWebViewUI.this.getJsapi() != null)
                  {
                    j localj = BaseSOSWebViewUI.this.getJsapi();
                    String str1 = this.uei;
                    String str2 = this.WBF;
                    if (!localj.UcS)
                    {
                      Log.e("MicroMsg.JsApiHandler", "onChatSearchDataReady fail, not ready");
                      AppMethodBeat.o(80533);
                      return;
                    }
                    Log.i("MicroMsg.JsApiHandler", "onChatSearchDataReady success, ready");
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("json", str1);
                    localHashMap.put("requestId", str2);
                    MMHandlerThread.postToMainThread(new j.47(localj, p.a.b("onChatSearchDataReady", localHashMap, localj.WDI, localj.KQY)));
                  }
                  AppMethodBeat.o(80533);
                }
              });
              AppMethodBeat.o(80565);
              return;
              paramBundle = paramBundle.getString("data");
              getHandler().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80534);
                  if (BaseSOSWebViewUI.this.getJsapi() != null)
                  {
                    j localj = BaseSOSWebViewUI.this.getJsapi();
                    String str = paramBundle;
                    if (!localj.UcS)
                    {
                      Log.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
                      AppMethodBeat.o(80534);
                      return;
                    }
                    Log.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                    try
                    {
                      MMHandlerThread.postToMainThread(new j.40(localj, p.a.a("onSearchHistoryReady", new JSONObject(str), localj.WDI, localj.KQY)));
                      AppMethodBeat.o(80534);
                      return;
                    }
                    catch (JSONException localJSONException)
                    {
                      Log.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException, "", new Object[0]);
                    }
                  }
                  AppMethodBeat.o(80534);
                }
              });
              AppMethodBeat.o(80565);
              return;
              paramInt = paramBundle.getInt("fts_key_ret", 0);
              paramBundle = paramBundle.getString("fts_key_data");
              getHandler().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(296889);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().dG(paramInt, paramBundle);
                  }
                  AppMethodBeat.o(296889);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_json_data");
              aS(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(296887);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().E(this.XcG, this.uei, this.uej);
                  }
                  AppMethodBeat.o(296887);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_new_query");
              localObject2 = paramBundle.getString("fts_key_custom_query");
              bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
              Object localObject3 = paramBundle.getString("fts_key_tag_list");
              Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b, needSosEditTextToBeTouchOnly %b", new Object[] { localObject1, Boolean.valueOf(bool), Boolean.valueOf(this.WoS) });
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
                    locala.RWX = localJSONObject.getString("tagName");
                    locala.cLU = localJSONObject.getInt("tagType");
                    locala.userName = localJSONObject.getString("userName");
                    paramBundle.add(locala);
                    paramInt += 1;
                  }
                }
                paramBundle = paramBundle.getString("fts_key_json_data");
              }
              catch (Exception localException)
              {
                if (this.Xch != null)
                {
                  if (paramBundle.size() > 0) {
                    this.Xch.V((String)localObject2, paramBundle);
                  }
                }
                else
                {
                  if (!bool) {
                    break label767;
                  }
                  getHandler().post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(296893);
                      if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.iAj());
                      }
                      AppMethodBeat.o(296893);
                    }
                  });
                  if (this.Xch != null) {
                    this.Xch.aWT();
                  }
                  izf();
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.fts.a.a.a.itg();
                  com.tencent.mm.plugin.webview.fts.a.a.a.bjG(getTotalQuery());
                  AppMethodBeat.o(80565);
                  return;
                  this.Xch.V((String)localObject1, paramBundle);
                  break;
                  if (this.Xch != null) {
                    this.Xch.dzv.clearFocus();
                  }
                }
              }
              getHandler().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(296894);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().biN(paramBundle);
                  }
                  AppMethodBeat.o(296894);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_sns_id");
              paramInt = paramBundle.getInt("fts_key_status", 0);
              getHandler().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(296880);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().hY(this.XcH, paramInt);
                  }
                  AppMethodBeat.o(296880);
                }
              });
              AppMethodBeat.o(80565);
              return;
              if (!iAl())
              {
                Log.w("MicroMsg.WebSearch.BaseSOSWebViewUI", "current state is not search");
                AppMethodBeat.o(80565);
                return;
              }
            } while (this.Xct == null);
            this.Xct.b(paramBundle, this.scene);
            AppMethodBeat.o(80565);
            return;
          } while (this.Xct == null);
          this.Xct.bK(paramBundle);
          AppMethodBeat.o(80565);
          return;
        } while (this.Xct == null);
        this.Xct.bL(paramBundle);
        AppMethodBeat.o(80565);
        return;
      } while (this.Xct == null);
      this.Xct.bM(paramBundle);
      AppMethodBeat.o(80565);
      return;
    case 138: 
      paramBundle = paramBundle.getString("fts_key_data");
      if (!Util.isNullOrNil(paramBundle))
      {
        if ("index".equals(paramBundle))
        {
          this.Xcs = 1;
          AppMethodBeat.o(80565);
          return;
        }
        if ("result".equals(paramBundle))
        {
          this.Xcs = 2;
          AppMethodBeat.o(80565);
          return;
        }
        if ("suggestion".equals(paramBundle))
        {
          this.Xcs = 3;
          AppMethodBeat.o(80565);
          return;
        }
        if ("teach".equals(paramBundle))
        {
          this.Xcs = 4;
          AppMethodBeat.o(80565);
          return;
        }
        if ("local".equals(paramBundle))
        {
          this.Xcs = 5;
          AppMethodBeat.o(80565);
          return;
        }
        this.Xcs = 0;
        AppMethodBeat.o(80565);
        return;
      }
      this.Xcs = 0;
      AppMethodBeat.o(80565);
      return;
    case 144: 
      label767:
      AppMethodBeat.o(80565);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    final long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    getHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296874);
        if (BaseSOSWebViewUI.this.WlX != null)
        {
          BaseSOSWebViewUI.this.WlX.a(paramInt, l, this.wzK);
          Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), this.wzK });
        }
        AppMethodBeat.o(296874);
      }
    });
    AppMethodBeat.o(80565);
  }
  
  public final class a
    implements FTSSearchView.c
  {
    String RWX;
    int cLU;
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
      int i = this.RWX.compareTo(paramObject.RWX);
      AppMethodBeat.o(80543);
      return i;
    }
    
    public final String getTagName()
    {
      return this.RWX;
    }
  }
  
  final class b
    extends m
  {
    a XcS;
    
    private b()
    {
      AppMethodBeat.i(296871);
      this.XcS = new a((byte)0);
      AppMethodBeat.o(296871);
    }
    
    private static WebResourceResponse biK(String paramString)
    {
      AppMethodBeat.i(296877);
      Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      paramString = Uri.parse(paramString);
      try
      {
        paramString = y.Lh(paramString.getQueryParameter("path"));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/*", "utf8", paramString);
          AppMethodBeat.o(296877);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        AppMethodBeat.o(296877);
      }
      return null;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(296895);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
      {
        paramWebView = biK(paramWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(296895);
        return paramWebView;
      }
      AppMethodBeat.o(296895);
      return null;
    }
    
    public final boolean bjv(String paramString)
    {
      AppMethodBeat.i(296882);
      if (BaseSOSWebViewUI.this.WEv)
      {
        AppMethodBeat.o(296882);
        return true;
      }
      boolean bool = super.bjv(paramString);
      AppMethodBeat.o(296882);
      return bool;
    }
    
    public final l cxU()
    {
      AppMethodBeat.i(296891);
      b localb = new b((byte)0);
      AppMethodBeat.o(296891);
      return localb;
    }
    
    public final boolean f(String paramString, Intent paramIntent)
    {
      AppMethodBeat.i(296886);
      BaseSOSWebViewUI.this.iAb();
      boolean bool = super.f(paramString, paramIntent);
      AppMethodBeat.o(296886);
      return bool;
    }
    
    public final com.tencent.mm.plugin.webview.core.h isN()
    {
      return this.XcS;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.h
    {
      private a() {}
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(296968);
        Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.this.scene), paramString });
        BaseSOSWebViewUI.this.showOptionMenu(false);
        if ((BaseSOSWebViewUI.this.Xch != null) && (!BaseSOSWebViewUI.this.XbH) && (BaseSOSWebViewUI.iAg()))
        {
          BaseSOSWebViewUI.this.Xch.dzv.clearFocus();
          BaseSOSWebViewUI.this.hideVKB();
        }
        if (!BaseSOSWebViewUI.this.WEv) {
          ai.b(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.hVn, true, BaseSOSWebViewUI.this.query, BaseSOSWebViewUI.this.type, "", BaseSOSWebViewUI.this.WEv, BaseSOSWebViewUI.this.mpa);
        }
        AppMethodBeat.o(296968);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(296975);
        Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d,onPageStarted %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.this.scene), paramString });
        BaseSOSWebViewUI.this.showOptionMenu(false);
        if ((BaseSOSWebViewUI.this.Xch != null) && (!BaseSOSWebViewUI.this.XbH) && (BaseSOSWebViewUI.iAh()))
        {
          BaseSOSWebViewUI.this.Xch.dzv.clearFocus();
          BaseSOSWebViewUI.this.hideVKB();
        }
        if (!BaseSOSWebViewUI.this.WEv) {
          ai.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.hVn, true, BaseSOSWebViewUI.this.query, BaseSOSWebViewUI.this.type, "", BaseSOSWebViewUI.this.WEv, BaseSOSWebViewUI.this.mpa);
        }
        AppMethodBeat.o(296975);
      }
    }
    
    final class b
      extends l
    {
      private b() {}
      
      public final void cxT()
      {
        AppMethodBeat.i(296958);
        BaseSOSWebViewUI.b(BaseSOSWebViewUI.this);
        BaseSOSWebViewUI.this.iAa();
        AppMethodBeat.o(296958);
      }
    }
  }
  
  protected final class c
  {
    String XcU;
    String XcV;
    Map<String, Object> XcW;
    int type;
    List<FTSSearchView.c> xtu;
    
    protected c()
    {
      AppMethodBeat.i(80550);
      this.XcU = "";
      this.XcV = "";
      this.XcW = new HashMap();
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
        if ((paramObject.type == this.type) && (paramObject.XcV.equals(this.XcV)))
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