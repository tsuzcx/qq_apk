package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.36;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
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
  implements FTSEditTextView.a
{
  private boolean BjR;
  View Bke;
  protected SOSEditTextView Bkf;
  private List<c> Bkg;
  protected int Bkh = 0;
  private e Bki;
  private com.tencent.mm.plugin.webview.fts.d.a Bkj;
  boolean Bkk;
  boolean Bkl;
  protected View sUG;
  
  public final String TE(int paramInt)
  {
    AppMethodBeat.i(80571);
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "educationTab");
      Object localObject2 = this.kxf.s(2, (Bundle)localObject1);
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
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164030);
    ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.Hlc) || (paramb == FTSEditTextView.b.Hld))
    {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80541);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.epF());
          }
          AppMethodBeat.o(80541);
        }
      });
      AppMethodBeat.o(164030);
      return;
    }
    if (paramb == FTSEditTextView.b.Hle)
    {
      if (this.Bkf.sz.hasFocus())
      {
        this.Bkf.fdn();
        AppMethodBeat.o(164030);
        return;
      }
      this.Bkf.fdm();
    }
    AppMethodBeat.o(164030);
  }
  
  public final h bFq()
  {
    AppMethodBeat.i(188077);
    h localh = super.bFq();
    if (localh != null) {
      localh.a(new b((byte)0));
    }
    AppMethodBeat.o(188077);
    return localh;
  }
  
  public void bol()
  {
    AppMethodBeat.i(80553);
    super.bol();
    this.BjR = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.Bke = findViewById(2131304427);
    this.Bkf = ((SOSEditTextView)findViewById(2131305115));
    this.Bkf.setFtsEditTextListener(this);
    this.Bkf.setHint(getHint());
    this.Bkf.setCancelTextViewClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80524);
        BaseSOSWebViewUI.this.epy();
        AppMethodBeat.o(80524);
      }
    });
    this.sUG = findViewById(2131297026);
    this.sUG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80535);
        BaseSOSWebViewUI.this.dPr();
        AppMethodBeat.o(80535);
      }
    });
    this.nhy.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80536);
        BaseSOSWebViewUI.this.epC().getEditText().clearFocus();
        BaseSOSWebViewUI.this.hideVKB();
        AppMethodBeat.o(80536);
        return false;
      }
    });
    if (this.BjR) {
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80537);
          BaseSOSWebViewUI.this.epC().fdj();
          BaseSOSWebViewUI.this.epC().fdi();
          AppMethodBeat.o(80537);
        }
      }, 128L);
    }
    if (this.Bis != null) {
      this.Bis.tr(true);
    }
    this.nhy.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        return true;
      }
    });
    this.Bkj = new com.tencent.mm.plugin.webview.fts.d.a(this.nhy);
    this.Bkj.AQP = this.AQP;
    this.Bki = new e(((com.tencent.mm.plugin.websearch.api.e)g.ab(com.tencent.mm.plugin.websearch.api.e.class)).a(getContext(), this.Bkj));
    AppMethodBeat.o(80553);
  }
  
  public boolean bow()
  {
    AppMethodBeat.i(80562);
    this.Bkf.sz.clearFocus();
    hideVKB();
    if (getTotalQuery().length() > 0)
    {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80525);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            HashMap localHashMap1 = new HashMap();
            if (BaseSOSWebViewUI.this.epB() != 0)
            {
              localHashMap1.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.epB()));
              localHashMap1.put("sugId", BaseSOSWebViewUI.this.epA());
            }
            f localf = BaseSOSWebViewUI.this.getJsapi();
            String str1 = BaseSOSWebViewUI.this.getTotalQuery();
            String str2 = BaseSOSWebViewUI.this.getInEditTextQuery();
            JSONArray localJSONArray = BaseSOSWebViewUI.this.epF();
            HashMap localHashMap2 = new HashMap();
            localHashMap2.putAll(localHashMap1);
            localHashMap2.put("query", str1);
            localHashMap2.put("custom", str2);
            localHashMap2.put("tagList", localJSONArray);
            localf.b("onSearchInputConfirm", localHashMap2, null);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              z.a(BaseSOSWebViewUI.this.BkB, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dtw, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.BkC);
            }
          }
          AppMethodBeat.o(80525);
        }
      });
      hideVKB();
      this.Bkk = true;
      AppMethodBeat.o(80562);
      return true;
    }
    AppMethodBeat.o(80562);
    return true;
  }
  
  protected final void c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(80570);
    ad.v("MicroMsg.WebSearch.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[] { Integer.valueOf(paramInt), paramString, paramMap });
    int i = this.BkC;
    this.BkC = paramInt;
    if (i != paramInt) {
      epx();
    }
    if (this.Bkg == null) {
      this.Bkg = new ArrayList();
    }
    c localc1;
    c localc2;
    if (getTotalQuery().length() > 0)
    {
      localc1 = new c();
      localc1.type = this.BkC;
      localc1.oiL = new ArrayList(this.Bkf.getTagList());
      localc1.Bkv = this.Bkf.getInEditTextQuery();
      localc1.Bku = this.Bkf.getTotalQuery();
      if (this.Bkg.size() == 0) {
        this.Bkg.add(localc1);
      }
    }
    else if ((this.Bkg != null) && (!this.Bkg.isEmpty()))
    {
      localc1 = (c)this.Bkg.get(0);
      localc2 = new c();
      localc2.type = paramInt;
      localc2.Bku = paramString;
      localc2.Bkw = paramMap;
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
        localc1.Bkw = paramMap;
      }
      AppMethodBeat.o(80570);
      return;
      if (localc1.equals((c)this.Bkg.get(0))) {
        break;
      }
      this.Bkg.add(0, localc1);
      break;
      label297:
      paramString = (c)localc2;
      if ((paramString.type == localc1.type) && (paramString.Bku.trim().equals(localc1.Bku.trim()))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void cok()
  {
    AppMethodBeat.i(164029);
    if (!this.Bkf.sz.hasFocus())
    {
      this.Bkf.fdj();
      showVKB();
    }
    AppMethodBeat.o(164029);
  }
  
  protected final void dPr()
  {
    AppMethodBeat.i(80556);
    hideVKB();
    epJ();
    if ((this.Bkg != null) && (this.Bkg.size() > 1))
    {
      this.Bkg.remove(0);
      final c localc = (c)this.Bkg.get(0);
      this.Bkf.J(localc.Bkv, localc.oiL);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80538);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            BaseSOSWebViewUI.this.epw();
            BaseSOSWebViewUI.this.BkC = localc.type;
            BaseSOSWebViewUI.this.epx();
            HashMap localHashMap = new HashMap();
            localHashMap.put("isBackButtonClick", "1");
            localHashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.epF(), 1, localc.Bkw);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              z.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dtw, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
            }
          }
          AppMethodBeat.o(80538);
        }
      });
      AppMethodBeat.o(80556);
      return;
    }
    if (this.Bkk)
    {
      epy();
      AppMethodBeat.o(80556);
      return;
    }
    finish();
    AppMethodBeat.o(80556);
  }
  
  public final void eoB()
  {
    AppMethodBeat.i(80563);
    dPr();
    AppMethodBeat.o(80563);
  }
  
  public final boolean eoG()
  {
    return false;
  }
  
  public final boolean eoQ()
  {
    return true;
  }
  
  public final boolean eoV()
  {
    return false;
  }
  
  protected String epA()
  {
    return "";
  }
  
  protected int epB()
  {
    return 0;
  }
  
  public final SOSEditTextView epC()
  {
    return this.Bkf;
  }
  
  protected final e epD()
  {
    return this.Bki;
  }
  
  protected final int epE()
  {
    return this.BkC;
  }
  
  public final JSONArray epF()
  {
    AppMethodBeat.i(80568);
    Object localObject = this.Bkf.getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tagName", locala.xXR);
        localJSONObject.put("tagType", locala.aXq);
        localJSONObject.put("userName", locala.userName);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(80568);
    return localJSONArray;
  }
  
  public boolean epG()
  {
    return false;
  }
  
  protected boolean epH()
  {
    return true;
  }
  
  protected void epw() {}
  
  protected void epx() {}
  
  protected void epy()
  {
    AppMethodBeat.i(80557);
    this.Bkf.J("", null);
    hideVKB();
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80540);
        if (BaseSOSWebViewUI.this.getJsapi() != null) {
          BaseSOSWebViewUI.this.au(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80539);
              f localf = BaseSOSWebViewUI.this.getJsapi();
              int i = BaseSOSWebViewUI.this.scene;
              HashMap localHashMap = new HashMap();
              localHashMap.put("isCancelButtonClick", Integer.valueOf(1));
              localHashMap.put("isInputChange", Integer.valueOf(1));
              localHashMap.put("scene", Integer.valueOf(i));
              localf.b("onSearchInputChange", localHashMap, null);
              AppMethodBeat.o(80539);
            }
          });
        }
        AppMethodBeat.o(80540);
      }
    });
    this.Bkg = null;
    this.Bkk = false;
    if (this.Bki != null) {
      this.Bki.onDestroy();
    }
    AppMethodBeat.o(80557);
  }
  
  protected void epz() {}
  
  protected String getHint()
  {
    return null;
  }
  
  protected final String getInEditTextQuery()
  {
    AppMethodBeat.i(80567);
    String str = this.Bkf.getInEditTextQuery();
    AppMethodBeat.o(80567);
    return str;
  }
  
  protected final int getScene()
  {
    return this.scene;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  protected final String getTotalQuery()
  {
    AppMethodBeat.i(80566);
    if (this.Bkf != null)
    {
      String str = this.Bkf.getTotalQuery();
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
  
  public void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(80560);
    if ((paramBoolean) && (!bt.isNullOrNil(getTotalQuery()))) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80542);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.epF());
          }
          AppMethodBeat.o(80542);
        }
      });
    }
    AppMethodBeat.o(80560);
  }
  
  public void m(final int paramInt, final Bundle paramBundle)
  {
    final int i = 0;
    AppMethodBeat.i(80565);
    switch (paramInt)
    {
    default: 
      super.m(paramInt, paramBundle);
    case 126: 
    case 119: 
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
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80526);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().bs(this.AhJ);
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
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80527);
                  if (BaseSOSWebViewUI.this.getJsapi() != null)
                  {
                    if ((paramBundle != null) && (paramBundle.getInt("isRefresh") == 1) && (paramBundle.getString("widgetId") != null))
                    {
                      BaseSOSWebViewUI.this.getJsapi().jV(paramBundle.getString("widgetId"), this.lCl);
                      AppMethodBeat.o(80527);
                      return;
                    }
                    BaseSOSWebViewUI.this.getJsapi().j(this.lCl, bool, this.APj);
                  }
                  AppMethodBeat.o(80527);
                }
              });
              AppMethodBeat.o(80565);
              return;
              paramBundle = paramBundle.getString("data");
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80528);
                  if (BaseSOSWebViewUI.this.getJsapi() != null)
                  {
                    f localf = BaseSOSWebViewUI.this.getJsapi();
                    String str = paramBundle;
                    if (!localf.yZR)
                    {
                      ad.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
                      AppMethodBeat.o(80528);
                      return;
                    }
                    ad.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                    try
                    {
                      aq.f(new f.36(localf, l.a.a("onSearchHistoryReady", new JSONObject(str), localf.ARm, localf.ARn)));
                      AppMethodBeat.o(80528);
                      return;
                    }
                    catch (JSONException localJSONException)
                    {
                      ad.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException, "", new Object[0]);
                    }
                  }
                  AppMethodBeat.o(80528);
                }
              });
              AppMethodBeat.o(80565);
              return;
              paramInt = paramBundle.getInt("fts_key_ret", 0);
              paramBundle = paramBundle.getString("fts_key_data");
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80529);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().cq(paramInt, paramBundle);
                  }
                  AppMethodBeat.o(80529);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_json_data");
              paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
              i = paramBundle.getInt("fts_key_is_cache_data", 0);
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80530);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().u(paramInt, this.lCl, i);
                  }
                  AppMethodBeat.o(80530);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_new_query");
              localObject2 = paramBundle.getString("fts_key_custom_query");
              bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
              Object localObject3 = paramBundle.getString("fts_key_tag_list");
              ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
              paramBundle = new ArrayList();
              try
              {
                if (!bt.isNullOrNil((String)localObject3))
                {
                  localObject3 = new JSONArray((String)localObject3);
                  paramInt = i;
                  while (paramInt < ((JSONArray)localObject3).length())
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject3).getJSONObject(paramInt);
                    a locala = new a();
                    locala.xXR = localJSONObject.getString("tagName");
                    locala.aXq = localJSONObject.getInt("tagType");
                    locala.userName = localJSONObject.getString("userName");
                    paramBundle.add(locala);
                    paramInt += 1;
                  }
                }
                paramBundle = paramBundle.getString("fts_key_json_data");
              }
              catch (Exception localException)
              {
                if (this.Bkf != null)
                {
                  if (paramBundle.size() > 0) {
                    this.Bkf.J((String)localObject2, paramBundle);
                  }
                }
                else
                {
                  if (!bool) {
                    break label723;
                  }
                  this.handler.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(80531);
                      if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.epF());
                      }
                      AppMethodBeat.o(80531);
                    }
                  });
                  if (this.Bkf != null) {
                    this.Bkf.fdj();
                  }
                  eoW();
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.fts.b.a.a.ejZ();
                  com.tencent.mm.plugin.webview.fts.b.a.a.avP(getTotalQuery());
                  AppMethodBeat.o(80565);
                  return;
                  this.Bkf.J((String)localObject1, paramBundle);
                  break;
                  if (this.Bkf != null) {
                    this.Bkf.sz.clearFocus();
                  }
                }
              }
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80532);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().avX(paramBundle);
                  }
                  AppMethodBeat.o(80532);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_sns_id");
              paramInt = paramBundle.getInt("fts_key_status", 0);
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80533);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().fd(this.Bkp, paramInt);
                  }
                  AppMethodBeat.o(80533);
                }
              });
              AppMethodBeat.o(80565);
              return;
              if (!epH())
              {
                ad.w("MicroMsg.WebSearch.BaseSOSWebViewUI", "current state is not search");
                AppMethodBeat.o(80565);
                return;
              }
            } while (this.Bki == null);
            this.Bki.b(paramBundle, this.scene);
            AppMethodBeat.o(80565);
            return;
          } while (this.Bki == null);
          this.Bki.aK(paramBundle);
          AppMethodBeat.o(80565);
          return;
        } while (this.Bki == null);
        this.Bki.aL(paramBundle);
        AppMethodBeat.o(80565);
        return;
      } while (this.Bki == null);
      this.Bki.aM(paramBundle);
      AppMethodBeat.o(80565);
      return;
    case 138: 
      paramBundle = paramBundle.getString("fts_key_data");
      if (!bt.isNullOrNil(paramBundle))
      {
        if ("index".equals(paramBundle))
        {
          this.Bkh = 1;
          AppMethodBeat.o(80565);
          return;
        }
        if ("result".equals(paramBundle))
        {
          this.Bkh = 2;
          AppMethodBeat.o(80565);
          return;
        }
        if ("suggestion".equals(paramBundle))
        {
          this.Bkh = 3;
          AppMethodBeat.o(80565);
          return;
        }
        if ("teach".equals(paramBundle))
        {
          this.Bkh = 4;
          AppMethodBeat.o(80565);
          return;
        }
        if ("local".equals(paramBundle))
        {
          this.Bkh = 5;
          AppMethodBeat.o(80565);
          return;
        }
        this.Bkh = 0;
        AppMethodBeat.o(80565);
        return;
      }
      this.Bkh = 0;
      AppMethodBeat.o(80565);
      return;
    case 144: 
      label723:
      AppMethodBeat.o(80565);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    final long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80534);
        if (BaseSOSWebViewUI.this.AQP != null)
        {
          BaseSOSWebViewUI.this.AQP.a(paramInt, l, this.nyH);
          ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), this.nyH });
        }
        AppMethodBeat.o(80534);
      }
    });
    AppMethodBeat.o(80565);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80569);
    dPr();
    AppMethodBeat.o(80569);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80561);
    if (this.Bkf != null)
    {
      if (!this.Bkf.sz.hasFocus())
      {
        this.Bkf.fdj();
        showVKB();
      }
      this.Bkf.setHint(getHint());
    }
    AppMethodBeat.o(80561);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80552);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    AppMethodBeat.o(80552);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80564);
    try
    {
      if (this.kxf != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.kxf.v(1, localBundle);
      }
      if (this.Bki != null) {
        this.Bki.onDestroy();
      }
    }
    catch (RemoteException localRemoteException)
    {
      label58:
      break label58;
    }
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(80564);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80555);
    super.onPause();
    if (this.Bki != null) {
      this.Bki.onPause();
    }
    AppMethodBeat.o(80555);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80554);
    super.onResume();
    if (this.Bki != null) {
      this.Bki.onResume();
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
    int aXq;
    String userName;
    String xXR;
    
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
      int i = this.xXR.compareTo(paramObject.xXR);
      AppMethodBeat.o(80543);
      return i;
    }
    
    public final String getTagName()
    {
      return this.xXR;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.webview.core.j
  {
    private b() {}
    
    private static WebResourceResponse aye(String paramString)
    {
      AppMethodBeat.i(188076);
      ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      paramString = Uri.parse(paramString);
      try
      {
        paramString = com.tencent.mm.vfs.i.openRead(paramString.getQueryParameter("path"));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/*", "utf8", paramString);
          AppMethodBeat.o(188076);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        AppMethodBeat.o(188076);
      }
      return null;
    }
    
    public final boolean avJ(String paramString)
    {
      AppMethodBeat.i(188072);
      if (BaseSOSWebViewUI.this.ARU)
      {
        AppMethodBeat.o(188072);
        return true;
      }
      boolean bool = super.avJ(paramString);
      AppMethodBeat.o(188072);
      return bool;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(188075);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
      {
        paramWebView = aye(paramWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(188075);
        return paramWebView;
      }
      AppMethodBeat.o(188075);
      return null;
    }
    
    public final com.tencent.mm.plugin.webview.core.e ejF()
    {
      AppMethodBeat.i(188073);
      a locala = new a((byte)0);
      AppMethodBeat.o(188073);
      return locala;
    }
    
    public final com.tencent.mm.plugin.webview.core.i ejG()
    {
      AppMethodBeat.i(188074);
      b localb = new b((byte)0);
      AppMethodBeat.o(188074);
      return localb;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.e
    {
      private a() {}
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188069);
        ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.this.scene), paramString });
        BaseSOSWebViewUI.this.showOptionMenu(false);
        if ((BaseSOSWebViewUI.this.Bkf != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.this)))
        {
          BaseSOSWebViewUI.this.Bkf.sz.clearFocus();
          BaseSOSWebViewUI.this.hideVKB();
        }
        AppMethodBeat.o(188069);
      }
      
      public final void m(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188070);
        ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onPageStarted %s", new Object[] { paramString });
        BaseSOSWebViewUI.this.showOptionMenu(false);
        if ((BaseSOSWebViewUI.this.Bkf != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.this)))
        {
          BaseSOSWebViewUI.this.Bkf.sz.clearFocus();
          BaseSOSWebViewUI.this.hideVKB();
        }
        AppMethodBeat.o(188070);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.i
    {
      private b() {}
      
      public final void bFs()
      {
        AppMethodBeat.i(188071);
        BaseSOSWebViewUI.b(BaseSOSWebViewUI.this);
        BaseSOSWebViewUI.this.epz();
        AppMethodBeat.o(188071);
      }
    }
  }
  
  protected final class c
  {
    String Bku;
    String Bkv;
    Map<String, Object> Bkw;
    List<a.c> oiL;
    int type;
    
    protected c()
    {
      AppMethodBeat.i(80550);
      this.Bku = "";
      this.Bkv = "";
      this.Bkw = new HashMap();
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
        if ((paramObject.type == this.type) && (paramObject.Bkv.equals(this.Bkv)))
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