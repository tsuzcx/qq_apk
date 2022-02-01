package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
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
  private boolean Jmy;
  View Jnb;
  protected SOSEditTextView Jnc;
  protected boolean Jnd;
  private List<c> Jne;
  protected int Jnf;
  private e Jng;
  private com.tencent.mm.plugin.webview.fts.d.a Jnh;
  boolean Jni;
  protected boolean Jnj;
  boolean Jnk;
  private BaseSOSWebViewUI.b Jnl;
  protected ImageView hNZ;
  
  public BaseSOSWebViewUI()
  {
    AppMethodBeat.i(211219);
    this.Jnf = 0;
    this.Jnj = false;
    this.Jnl = new BaseSOSWebViewUI.b(this, (byte)0);
    AppMethodBeat.o(211219);
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164030);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.QnQ) || (paramb == FTSEditTextView.b.QnR))
    {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80541);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.ggN());
          }
          AppMethodBeat.o(80541);
        }
      });
      AppMethodBeat.o(164030);
      return;
    }
    if (paramb == FTSEditTextView.b.QnS)
    {
      if (this.Jnc.vy.hasFocus())
      {
        this.Jnc.gXg();
        AppMethodBeat.o(164030);
        return;
      }
      this.Jnc.gXf();
    }
    AppMethodBeat.o(164030);
  }
  
  public final String agR(int paramInt)
  {
    AppMethodBeat.i(80571);
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "educationTab");
      Object localObject2 = this.mHh.u(2, (Bundle)localObject1);
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
  
  public boolean awE()
  {
    AppMethodBeat.i(80562);
    this.Jnc.vy.clearFocus();
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
            if (BaseSOSWebViewUI.this.ggK() != 0)
            {
              localHashMap1.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.ggK()));
              localHashMap1.put("sugId", BaseSOSWebViewUI.this.ggJ());
            }
            h localh = BaseSOSWebViewUI.this.getJsapi();
            String str1 = BaseSOSWebViewUI.this.getTotalQuery();
            String str2 = BaseSOSWebViewUI.this.getInEditTextQuery();
            JSONArray localJSONArray = BaseSOSWebViewUI.this.ggN();
            HashMap localHashMap2 = new HashMap();
            localHashMap2.putAll(localHashMap1);
            localHashMap2.put("query", str1);
            localHashMap2.put("custom", str2);
            localHashMap2.put("tagList", localJSONArray);
            localh.b("onSearchInputConfirm", localHashMap2, null);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ah.a(BaseSOSWebViewUI.this.JnD, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dVO, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.JnE);
            }
          }
          AppMethodBeat.o(80525);
        }
      });
      hideVKB();
      this.Jni = true;
      AppMethodBeat.o(80562);
      return true;
    }
    AppMethodBeat.o(80562);
    return true;
  }
  
  protected final void c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(80570);
    Log.v("MicroMsg.WebSearch.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[] { Integer.valueOf(paramInt), paramString, paramMap });
    int i = this.JnE;
    this.JnE = paramInt;
    if (i != paramInt) {
      ggE();
    }
    if (this.Jne == null) {
      this.Jne = new ArrayList();
    }
    c localc1;
    c localc2;
    if (getTotalQuery().length() > 0)
    {
      localc1 = new c();
      localc1.type = this.JnE;
      localc1.qLQ = new ArrayList(this.Jnc.getTagList());
      localc1.Jnx = this.Jnc.getInEditTextQuery();
      localc1.Jnw = this.Jnc.getTotalQuery();
      if (this.Jne.size() == 0) {
        this.Jne.add(localc1);
      }
    }
    else if ((this.Jne != null) && (!this.Jne.isEmpty()))
    {
      localc1 = (c)this.Jne.get(0);
      localc2 = new c();
      localc2.type = paramInt;
      localc2.Jnw = paramString;
      localc2.Jny = paramMap;
      if (localc1 != null)
      {
        if (localc1 != localc2) {
          break label294;
        }
        paramInt = 1;
      }
    }
    for (;;)
    {
      if (paramInt != 0) {
        localc1.Jny = paramMap;
      }
      AppMethodBeat.o(80570);
      return;
      if (localc1.equals((c)this.Jne.get(0))) {
        break;
      }
      this.Jne.add(0, localc1);
      break;
      label294:
      paramString = (c)localc2;
      if ((paramString.type == localc1.type) && (paramString.Jnw.trim().equals(localc1.Jnw.trim()))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final i cpO()
  {
    AppMethodBeat.i(211220);
    i locali = super.cpO();
    if (locali != null) {
      locali.a(this.Jnl);
    }
    AppMethodBeat.o(211220);
    return locali;
  }
  
  public final void dpw()
  {
    AppMethodBeat.i(164029);
    if (!this.Jnc.vy.hasFocus())
    {
      this.Jnc.awD();
      showVKB();
    }
    AppMethodBeat.o(164029);
  }
  
  public void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(80560);
    if ((paramBoolean) && (!Util.isNullOrNil(getTotalQuery()))) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80542);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.ggN());
          }
          AppMethodBeat.o(80542);
        }
      });
    }
    AppMethodBeat.o(80560);
  }
  
  protected void fzm()
  {
    AppMethodBeat.i(80556);
    hideVKB();
    ggR();
    if (ggC())
    {
      this.Jne.remove(0);
      final c localc = (c)this.Jne.get(0);
      this.Jnc.O(localc.Jnx, localc.qLQ);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80538);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            BaseSOSWebViewUI.this.ggD();
            BaseSOSWebViewUI.this.JnE = localc.type;
            BaseSOSWebViewUI.this.ggE();
            HashMap localHashMap = new HashMap();
            localHashMap.put("isBackButtonClick", "1");
            localHashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.ggN(), 1, localc.Jny);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ah.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dVO, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
            }
          }
          AppMethodBeat.o(80538);
        }
      });
      AppMethodBeat.o(80556);
      return;
    }
    if (this.Jni)
    {
      ggF();
      AppMethodBeat.o(80556);
      return;
    }
    finish();
    AppMethodBeat.o(80556);
  }
  
  protected String getHint()
  {
    return null;
  }
  
  protected final String getInEditTextQuery()
  {
    AppMethodBeat.i(80567);
    String str = this.Jnc.getInEditTextQuery();
    AppMethodBeat.o(80567);
    return str;
  }
  
  protected final int getScene()
  {
    return this.scene;
  }
  
  protected final int getTabType()
  {
    return this.JnE;
  }
  
  protected final String getTotalQuery()
  {
    AppMethodBeat.i(80566);
    if (this.Jnc != null)
    {
      String str = this.Jnc.getTotalQuery();
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
  
  public final boolean gfE()
  {
    return false;
  }
  
  public final boolean gfO()
  {
    return true;
  }
  
  public final boolean gfT()
  {
    return false;
  }
  
  public final void gfy()
  {
    AppMethodBeat.i(80563);
    fzm();
    AppMethodBeat.o(80563);
  }
  
  protected final boolean ggC()
  {
    AppMethodBeat.i(211221);
    if ((this.Jne != null) && (this.Jne.size() > 1))
    {
      AppMethodBeat.o(211221);
      return true;
    }
    AppMethodBeat.o(211221);
    return false;
  }
  
  protected void ggD() {}
  
  protected void ggE() {}
  
  protected void ggF()
  {
    AppMethodBeat.i(80557);
    if (!this.Jnd) {
      this.Jnc.O("", null);
    }
    hideVKB();
    this.Jnj = true;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80540);
        if (BaseSOSWebViewUI.this.getJsapi() != null) {
          BaseSOSWebViewUI.this.aD(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80539);
              Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onClickCancelBtn js api run onSOSCancelButtonClick");
              h localh = BaseSOSWebViewUI.this.getJsapi();
              int i = BaseSOSWebViewUI.this.scene;
              HashMap localHashMap = new HashMap();
              localHashMap.put("isCancelButtonClick", Integer.valueOf(1));
              localHashMap.put("isInputChange", Integer.valueOf(1));
              localHashMap.put("scene", Integer.valueOf(i));
              localh.b("onSearchInputChange", localHashMap, null);
              BaseSOSWebViewUI.this.Jnj = false;
              BaseSOSWebViewUI.this.ggG();
              AppMethodBeat.o(80539);
            }
          });
        }
        AppMethodBeat.o(80540);
      }
    });
    this.Jne = null;
    this.Jni = false;
    if (this.Jng != null) {
      this.Jng.onDestroy();
    }
    AppMethodBeat.o(80557);
  }
  
  protected void ggG() {}
  
  protected void ggH()
  {
    AppMethodBeat.i(211222);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageLoaded %b", new Object[] { Boolean.valueOf(this.IRT) });
    AppMethodBeat.o(211222);
  }
  
  protected void ggI()
  {
    AppMethodBeat.i(211223);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageStartLoad");
    AppMethodBeat.o(211223);
  }
  
  protected String ggJ()
  {
    return "";
  }
  
  protected int ggK()
  {
    return 0;
  }
  
  public final SOSEditTextView ggL()
  {
    return this.Jnc;
  }
  
  protected final e ggM()
  {
    return this.Jng;
  }
  
  public final JSONArray ggN()
  {
    AppMethodBeat.i(80568);
    Object localObject = this.Jnc.getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tagName", locala.FeZ);
        localJSONObject.put("tagType", locala.biu);
        localJSONObject.put("userName", locala.userName);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(80568);
    return localJSONArray;
  }
  
  public boolean ggO()
  {
    return false;
  }
  
  protected boolean ggP()
  {
    return true;
  }
  
  public void m(int paramInt, final Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(80565);
    switch (paramInt)
    {
    default: 
      super.m(paramInt, paramBundle);
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
              this.handler.post(new BaseSOSWebViewUI.3(this, (Map)localObject1));
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
                  Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "[handleFTSAction] onSearchDataReady");
                  BaseSOSWebViewUI.this.aD(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(211207);
                      if (BaseSOSWebViewUI.this.getJsapi() != null)
                      {
                        if ((BaseSOSWebViewUI.4.this.GkX != null) && (BaseSOSWebViewUI.4.this.GkX.getInt("isRefresh") == 1) && (BaseSOSWebViewUI.4.this.GkX.getString("widgetId") != null))
                        {
                          BaseSOSWebViewUI.this.getJsapi().lU(BaseSOSWebViewUI.4.this.GkX.getString("widgetId"), BaseSOSWebViewUI.4.this.nWD);
                          AppMethodBeat.o(211207);
                          return;
                        }
                        BaseSOSWebViewUI.this.getJsapi().j(BaseSOSWebViewUI.4.this.nWD, BaseSOSWebViewUI.4.this.Jnn, BaseSOSWebViewUI.4.this.IPc);
                      }
                      AppMethodBeat.o(211207);
                    }
                  });
                  AppMethodBeat.o(80527);
                }
              });
              AppMethodBeat.o(80565);
              return;
              aD(new BaseSOSWebViewUI.5(this, paramBundle.getString("fts_key_json_data"), paramBundle.getString("fts_key_req_id")));
              AppMethodBeat.o(80565);
              return;
              paramBundle = paramBundle.getString("data");
              this.handler.post(new BaseSOSWebViewUI.6(this, paramBundle));
              AppMethodBeat.o(80565);
              return;
              paramInt = paramBundle.getInt("fts_key_ret", 0);
              paramBundle = paramBundle.getString("fts_key_data");
              this.handler.post(new BaseSOSWebViewUI.7(this, paramInt, paramBundle));
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_json_data");
              aD(new BaseSOSWebViewUI.8(this, paramBundle.getInt("fts_key_teach_request_type", 0), (String)localObject1, paramBundle.getInt("fts_key_is_cache_data", 0)));
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
                    locala.FeZ = localJSONObject.getString("tagName");
                    locala.biu = localJSONObject.getInt("tagType");
                    locala.userName = localJSONObject.getString("userName");
                    paramBundle.add(locala);
                    paramInt += 1;
                  }
                }
                paramBundle = paramBundle.getString("fts_key_json_data");
              }
              catch (Exception localException)
              {
                if (this.Jnc != null)
                {
                  if (paramBundle.size() > 0) {
                    this.Jnc.O((String)localObject2, paramBundle);
                  }
                }
                else
                {
                  if (!bool) {
                    break label756;
                  }
                  this.handler.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(80532);
                      if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.ggN());
                      }
                      AppMethodBeat.o(80532);
                    }
                  });
                  if (this.Jnc != null) {
                    this.Jnc.awD();
                  }
                  gfU();
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.fts.b.a.a.gaG();
                  com.tencent.mm.plugin.webview.fts.b.a.a.aXY(getTotalQuery());
                  AppMethodBeat.o(80565);
                  return;
                  this.Jnc.O((String)localObject1, paramBundle);
                  break;
                  if (this.Jnc != null) {
                    this.Jnc.vy.clearFocus();
                  }
                }
              }
              this.handler.post(new BaseSOSWebViewUI.10(this, paramBundle));
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_sns_id");
              paramInt = paramBundle.getInt("fts_key_status", 0);
              this.handler.post(new BaseSOSWebViewUI.11(this, (String)localObject1, paramInt));
              AppMethodBeat.o(80565);
              return;
              if (!ggP())
              {
                Log.w("MicroMsg.WebSearch.BaseSOSWebViewUI", "current state is not search");
                AppMethodBeat.o(80565);
                return;
              }
            } while (this.Jng == null);
            this.Jng.c(paramBundle, this.scene);
            AppMethodBeat.o(80565);
            return;
          } while (this.Jng == null);
          this.Jng.bh(paramBundle);
          AppMethodBeat.o(80565);
          return;
        } while (this.Jng == null);
        this.Jng.bi(paramBundle);
        AppMethodBeat.o(80565);
        return;
      } while (this.Jng == null);
      this.Jng.bj(paramBundle);
      AppMethodBeat.o(80565);
      return;
    case 138: 
      paramBundle = paramBundle.getString("fts_key_data");
      if (!Util.isNullOrNil(paramBundle))
      {
        if ("index".equals(paramBundle))
        {
          this.Jnf = 1;
          AppMethodBeat.o(80565);
          return;
        }
        if ("result".equals(paramBundle))
        {
          this.Jnf = 2;
          AppMethodBeat.o(80565);
          return;
        }
        if ("suggestion".equals(paramBundle))
        {
          this.Jnf = 3;
          AppMethodBeat.o(80565);
          return;
        }
        if ("teach".equals(paramBundle))
        {
          this.Jnf = 4;
          AppMethodBeat.o(80565);
          return;
        }
        if ("local".equals(paramBundle))
        {
          this.Jnf = 5;
          AppMethodBeat.o(80565);
          return;
        }
        this.Jnf = 0;
        AppMethodBeat.o(80565);
        return;
      }
      this.Jnf = 0;
      AppMethodBeat.o(80565);
      return;
    case 144: 
      label756:
      AppMethodBeat.o(80565);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    this.handler.post(new BaseSOSWebViewUI.13(this, paramInt, l, paramBundle));
    AppMethodBeat.o(80565);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80569);
    fzm();
    AppMethodBeat.o(80569);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80561);
    if (this.Jnc != null)
    {
      if (!this.Jnc.vy.hasFocus())
      {
        this.Jnc.awD();
        showVKB();
      }
      this.Jnc.setHint(getHint());
    }
    AppMethodBeat.o(80561);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80552);
    super.onCreate(paramBundle);
    this.Jnd = getIntent().getBooleanExtra("ftsInitToSearch", false);
    getSupportActionBar().hide();
    this.Jmy = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.Jnb = findViewById(2131307398);
    this.Jnc = ((SOSEditTextView)findViewById(2131308292));
    this.Jnc.setFtsEditTextListener(this);
    this.Jnc.setHint(getHint());
    this.Jnc.setCancelTextViewClickListener(new BaseSOSWebViewUI.1(this));
    this.hNZ = ((ImageView)findViewById(2131297163));
    this.hNZ.setOnClickListener(new BaseSOSWebViewUI.12(this));
    this.pGj.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80536);
        BaseSOSWebViewUI.this.ggL().getEditText().clearFocus();
        BaseSOSWebViewUI.this.hideVKB();
        AppMethodBeat.o(80536);
        return false;
      }
    });
    if (this.Jmy) {
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80537);
          BaseSOSWebViewUI.this.ggL().awD();
          BaseSOSWebViewUI.this.ggL().awC();
          AppMethodBeat.o(80537);
        }
      }, 128L);
    }
    if (this.JjI != null) {
      this.JjI.zh(true);
    }
    this.pGj.setOnLongClickListener(new BaseSOSWebViewUI.16(this));
    this.Jnh = new com.tencent.mm.plugin.webview.fts.d.a(this.pGj);
    this.Jnh.IBw = this.IBw;
    this.Jng = new e(((com.tencent.mm.plugin.websearch.api.f)g.af(com.tencent.mm.plugin.websearch.api.f.class)).a(getContext(), this.Jnh));
    AppMethodBeat.o(80552);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80564);
    try
    {
      if (this.mHh != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.mHh.w(1, localBundle);
      }
      if (this.Jng != null) {
        this.Jng.onDestroy();
      }
    }
    catch (RemoteException localRemoteException)
    {
      label58:
      break label58;
    }
    hideVKB();
    this.IMH.b(this.Jnl);
    this.IMH.b(this.Jnl.Jnu);
    super.onDestroy();
    AppMethodBeat.o(80564);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80555);
    super.onPause();
    if (this.Jng != null) {
      this.Jng.onPause();
    }
    AppMethodBeat.o(80555);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80554);
    super.onResume();
    if (this.Jng != null) {
      this.Jng.onResume();
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
    String FeZ;
    int biu;
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
      int i = this.FeZ.compareTo(paramObject.FeZ);
      AppMethodBeat.o(80543);
      return i;
    }
    
    public final String getTagName()
    {
      return this.FeZ;
    }
  }
  
  final class b$a
    extends com.tencent.mm.plugin.webview.core.f
  {
    private b$a() {}
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(211210);
      Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.this.Jnm.scene), paramString });
      BaseSOSWebViewUI.this.Jnm.showOptionMenu(false);
      if ((BaseSOSWebViewUI.this.Jnm.Jnc != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.this.Jnm)))
      {
        BaseSOSWebViewUI.this.Jnm.Jnc.vy.clearFocus();
        BaseSOSWebViewUI.this.Jnm.hideVKB();
      }
      if (!BaseSOSWebViewUI.this.Jnm.IRT) {
        ah.b(BaseSOSWebViewUI.this.Jnm.scene, BaseSOSWebViewUI.this.Jnm.sessionId, BaseSOSWebViewUI.this.Jnm.dVO, BaseSOSWebViewUI.this.Jnm.query, BaseSOSWebViewUI.this.Jnm.type, "", BaseSOSWebViewUI.this.Jnm.IRT, BaseSOSWebViewUI.this.Jnm.hes);
      }
      AppMethodBeat.o(211210);
    }
    
    public final void i(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(211211);
      Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d,onPageStarted %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.this.Jnm.scene), paramString });
      BaseSOSWebViewUI.this.Jnm.showOptionMenu(false);
      if ((BaseSOSWebViewUI.this.Jnm.Jnc != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.this.Jnm)))
      {
        BaseSOSWebViewUI.this.Jnm.Jnc.vy.clearFocus();
        BaseSOSWebViewUI.this.Jnm.hideVKB();
      }
      if (!BaseSOSWebViewUI.this.Jnm.IRT) {
        ah.a(BaseSOSWebViewUI.this.Jnm.scene, BaseSOSWebViewUI.this.Jnm.sessionId, BaseSOSWebViewUI.this.Jnm.dVO, BaseSOSWebViewUI.this.Jnm.query, BaseSOSWebViewUI.this.Jnm.type, "", BaseSOSWebViewUI.this.Jnm.IRT, BaseSOSWebViewUI.this.Jnm.hes);
      }
      AppMethodBeat.o(211211);
    }
  }
  
  protected final class c
  {
    String Jnw;
    String Jnx;
    Map<String, Object> Jny;
    List<a.c> qLQ;
    int type;
    
    protected c()
    {
      AppMethodBeat.i(80550);
      this.Jnw = "";
      this.Jnx = "";
      this.Jny = new HashMap();
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
        if ((paramObject.type == this.type) && (paramObject.Jnx.equals(this.Jnx)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
 * JD-Core Version:    0.7.0.1
 */