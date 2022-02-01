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
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.c.f.37;
import com.tencent.mm.plugin.webview.c.f.39;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.o;
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
  private boolean ExP;
  View Eyd;
  protected SOSEditTextView Eye;
  protected boolean Eyf;
  private List<c> Eyg;
  protected int Eyh = 0;
  private e Eyi;
  private com.tencent.mm.plugin.webview.fts.d.a Eyj;
  boolean Eyk;
  protected boolean Eyl = false;
  boolean Eym;
  protected ImageView gVf;
  
  public final String Yi(int paramInt)
  {
    AppMethodBeat.i(80571);
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "educationTab");
      Object localObject2 = this.lzT.v(2, (Bundle)localObject1);
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
    ae.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.KYW) || (paramb == FTSEditTextView.b.KYX))
    {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80541);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eXF());
          }
          AppMethodBeat.o(80541);
        }
      });
      AppMethodBeat.o(164030);
      return;
    }
    if (paramb == FTSEditTextView.b.KYY)
    {
      if (this.Eye.vr.hasFocus())
      {
        this.Eye.fOn();
        AppMethodBeat.o(164030);
        return;
      }
      this.Eye.fOm();
    }
    AppMethodBeat.o(164030);
  }
  
  public void bAi()
  {
    AppMethodBeat.i(80553);
    super.bAi();
    this.ExP = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.Eyd = findViewById(2131304427);
    this.Eye = ((SOSEditTextView)findViewById(2131305115));
    this.Eye.setFtsEditTextListener(this);
    this.Eye.setHint(getHint());
    this.Eye.setCancelTextViewClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80524);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        BaseSOSWebViewUI.this.eXy();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(80524);
      }
    });
    this.gVf = ((ImageView)findViewById(2131297026));
    this.gVf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80535);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        BaseSOSWebViewUI.this.etQ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(80535);
      }
    });
    this.osM.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80536);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        BaseSOSWebViewUI.this.eXD().getEditText().clearFocus();
        BaseSOSWebViewUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(80536);
        return false;
      }
    });
    if (this.ExP) {
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80537);
          BaseSOSWebViewUI.this.eXD().fOj();
          BaseSOSWebViewUI.this.eXD().fOi();
          AppMethodBeat.o(80537);
        }
      }, 128L);
    }
    if (this.Ewp != null) {
      this.Ewp.vm(true);
    }
    this.osM.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198332);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(198332);
        return true;
      }
    });
    this.Eyj = new com.tencent.mm.plugin.webview.fts.d.a(this.osM);
    this.Eyj.DRx = this.DRx;
    this.Eyi = new e(((com.tencent.mm.plugin.websearch.api.f)g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(getContext(), this.Eyj));
    AppMethodBeat.o(80553);
  }
  
  public boolean bAu()
  {
    AppMethodBeat.i(80562);
    this.Eye.vr.clearFocus();
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
            if (BaseSOSWebViewUI.this.eXC() != 0)
            {
              localHashMap1.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.eXC()));
              localHashMap1.put("sugId", BaseSOSWebViewUI.this.eXB());
            }
            com.tencent.mm.plugin.webview.c.f localf = BaseSOSWebViewUI.this.getJsapi();
            String str1 = BaseSOSWebViewUI.this.getTotalQuery();
            String str2 = BaseSOSWebViewUI.this.getInEditTextQuery();
            JSONArray localJSONArray = BaseSOSWebViewUI.this.eXF();
            HashMap localHashMap2 = new HashMap();
            localHashMap2.putAll(localHashMap1);
            localHashMap2.put("query", str1);
            localHashMap2.put("custom", str2);
            localHashMap2.put("tagList", localJSONArray);
            localf.b("onSearchInputConfirm", localHashMap2, null);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ac.a(BaseSOSWebViewUI.this.EyC, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dEb, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.EyD);
            }
          }
          AppMethodBeat.o(80525);
        }
      });
      hideVKB();
      this.Eyk = true;
      AppMethodBeat.o(80562);
      return true;
    }
    AppMethodBeat.o(80562);
    return true;
  }
  
  public final h bSe()
  {
    AppMethodBeat.i(198341);
    h localh = super.bSe();
    if (localh != null) {
      localh.a(new b((byte)0));
    }
    AppMethodBeat.o(198341);
    return localh;
  }
  
  protected final int cDl()
  {
    return this.EyD;
  }
  
  public final void cGz()
  {
    AppMethodBeat.i(164029);
    if (!this.Eye.vr.hasFocus())
    {
      this.Eye.fOj();
      showVKB();
    }
    AppMethodBeat.o(164029);
  }
  
  protected final void d(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(80570);
    ae.v("MicroMsg.WebSearch.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[] { Integer.valueOf(paramInt), paramString, paramMap });
    int i = this.EyD;
    this.EyD = paramInt;
    if (i != paramInt) {
      eXx();
    }
    if (this.Eyg == null) {
      this.Eyg = new ArrayList();
    }
    c localc1;
    c localc2;
    if (getTotalQuery().length() > 0)
    {
      localc1 = new c();
      localc1.type = this.EyD;
      localc1.pwz = new ArrayList(this.Eye.getTagList());
      localc1.Eyw = this.Eye.getInEditTextQuery();
      localc1.Eyv = this.Eye.getTotalQuery();
      if (this.Eyg.size() == 0) {
        this.Eyg.add(localc1);
      }
    }
    else if ((this.Eyg != null) && (!this.Eyg.isEmpty()))
    {
      localc1 = (c)this.Eyg.get(0);
      localc2 = new c();
      localc2.type = paramInt;
      localc2.Eyv = paramString;
      localc2.Eyx = paramMap;
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
        localc1.Eyx = paramMap;
      }
      AppMethodBeat.o(80570);
      return;
      if (localc1.equals((c)this.Eyg.get(0))) {
        break;
      }
      this.Eyg.add(0, localc1);
      break;
      label297:
      paramString = (c)localc2;
      if ((paramString.type == localc1.type) && (paramString.Eyv.trim().equals(localc1.Eyv.trim()))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void eWA()
  {
    AppMethodBeat.i(80563);
    etQ();
    AppMethodBeat.o(80563);
  }
  
  public final boolean eWG()
  {
    return false;
  }
  
  public final boolean eWQ()
  {
    return true;
  }
  
  public final boolean eWV()
  {
    return false;
  }
  
  protected void eXA()
  {
    AppMethodBeat.i(198342);
    ae.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageLoaded %b", new Object[] { Boolean.valueOf(this.Efm) });
    AppMethodBeat.o(198342);
  }
  
  protected String eXB()
  {
    return "";
  }
  
  protected int eXC()
  {
    return 0;
  }
  
  public final SOSEditTextView eXD()
  {
    return this.Eye;
  }
  
  protected final e eXE()
  {
    return this.Eyi;
  }
  
  public final JSONArray eXF()
  {
    AppMethodBeat.i(80568);
    Object localObject = this.Eye.getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tagName", locala.AUt);
        localJSONObject.put("tagType", locala.bix);
        localJSONObject.put("userName", locala.userName);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(80568);
    return localJSONArray;
  }
  
  public boolean eXG()
  {
    return false;
  }
  
  protected boolean eXH()
  {
    return true;
  }
  
  protected void eXw() {}
  
  protected void eXx() {}
  
  protected void eXy()
  {
    AppMethodBeat.i(80557);
    if (!this.Eyf) {
      this.Eye.I("", null);
    }
    hideVKB();
    this.Eyl = true;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80540);
        if (BaseSOSWebViewUI.this.getJsapi() != null) {
          BaseSOSWebViewUI.this.at(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80539);
              ae.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onClickCancelBtn js api run onSOSCancelButtonClick");
              com.tencent.mm.plugin.webview.c.f localf = BaseSOSWebViewUI.this.getJsapi();
              int i = BaseSOSWebViewUI.this.scene;
              HashMap localHashMap = new HashMap();
              localHashMap.put("isCancelButtonClick", Integer.valueOf(1));
              localHashMap.put("isInputChange", Integer.valueOf(1));
              localHashMap.put("scene", Integer.valueOf(i));
              localf.b("onSearchInputChange", localHashMap, null);
              BaseSOSWebViewUI.this.Eyl = false;
              BaseSOSWebViewUI.this.eXz();
              AppMethodBeat.o(80539);
            }
          });
        }
        AppMethodBeat.o(80540);
      }
    });
    this.Eyg = null;
    this.Eyk = false;
    if (this.Eyi != null) {
      this.Eyi.onDestroy();
    }
    AppMethodBeat.o(80557);
  }
  
  protected void eXz() {}
  
  protected final void etQ()
  {
    AppMethodBeat.i(80556);
    hideVKB();
    eXJ();
    if ((this.Eyg != null) && (this.Eyg.size() > 1))
    {
      this.Eyg.remove(0);
      final c localc = (c)this.Eyg.get(0);
      this.Eye.I(localc.Eyw, localc.pwz);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80538);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            BaseSOSWebViewUI.this.eXw();
            BaseSOSWebViewUI.this.EyD = localc.type;
            BaseSOSWebViewUI.this.eXx();
            HashMap localHashMap = new HashMap();
            localHashMap.put("isBackButtonClick", "1");
            localHashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eXF(), 1, localc.Eyx);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ac.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dEb, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
            }
          }
          AppMethodBeat.o(80538);
        }
      });
      AppMethodBeat.o(80556);
      return;
    }
    if (this.Eyk)
    {
      eXy();
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
    String str = this.Eye.getInEditTextQuery();
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
    if (this.Eye != null)
    {
      String str = this.Eye.getTotalQuery();
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
  
  public void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(80560);
    if ((paramBoolean) && (!bu.isNullOrNil(getTotalQuery()))) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80542);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eXF());
          }
          AppMethodBeat.o(80542);
        }
      });
    }
    AppMethodBeat.o(80560);
  }
  
  public void n(final int paramInt, final Bundle paramBundle)
  {
    final int i = 0;
    AppMethodBeat.i(80565);
    switch (paramInt)
    {
    default: 
      super.n(paramInt, paramBundle);
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
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80526);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().bG(this.mhV);
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
                      BaseSOSWebViewUI.this.getJsapi().kW(paramBundle.getString("widgetId"), this.mJE);
                      AppMethodBeat.o(80527);
                      return;
                    }
                    BaseSOSWebViewUI.this.getJsapi().j(this.mJE, bool, this.EcE);
                  }
                  AppMethodBeat.o(80527);
                }
              });
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_json_data");
              paramBundle = paramBundle.getString("fts_key_req_id");
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80528);
                  if (BaseSOSWebViewUI.this.getJsapi() != null)
                  {
                    com.tencent.mm.plugin.webview.c.f localf = BaseSOSWebViewUI.this.getJsapi();
                    String str1 = this.mJE;
                    String str2 = paramBundle;
                    if (!localf.BZx)
                    {
                      ae.e("MicroMsg.JsApiHandler", "onChatSearchDataReady fail, not ready");
                      AppMethodBeat.o(80528);
                      return;
                    }
                    ae.i("MicroMsg.JsApiHandler", "onChatSearchDataReady success, ready");
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("json", str1);
                    localHashMap.put("requestId", str2);
                    ar.f(new f.39(localf, l.a.b("onChatSearchDataReady", localHashMap, localf.EeC, localf.vVT)));
                  }
                  AppMethodBeat.o(80528);
                }
              });
              AppMethodBeat.o(80565);
              return;
              paramBundle = paramBundle.getString("data");
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80529);
                  if (BaseSOSWebViewUI.this.getJsapi() != null)
                  {
                    com.tencent.mm.plugin.webview.c.f localf = BaseSOSWebViewUI.this.getJsapi();
                    String str = paramBundle;
                    if (!localf.BZx)
                    {
                      ae.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
                      AppMethodBeat.o(80529);
                      return;
                    }
                    ae.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                    try
                    {
                      ar.f(new f.37(localf, l.a.a("onSearchHistoryReady", new JSONObject(str), localf.EeC, localf.vVT)));
                      AppMethodBeat.o(80529);
                      return;
                    }
                    catch (JSONException localJSONException)
                    {
                      ae.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException, "", new Object[0]);
                    }
                  }
                  AppMethodBeat.o(80529);
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
                  AppMethodBeat.i(80530);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().cz(paramInt, paramBundle);
                  }
                  AppMethodBeat.o(80530);
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
                  AppMethodBeat.i(80531);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().v(paramInt, this.mJE, i);
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
              ae.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
              paramBundle = new ArrayList();
              try
              {
                if (!bu.isNullOrNil((String)localObject3))
                {
                  localObject3 = new JSONArray((String)localObject3);
                  paramInt = i;
                  while (paramInt < ((JSONArray)localObject3).length())
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject3).getJSONObject(paramInt);
                    a locala = new a();
                    locala.AUt = localJSONObject.getString("tagName");
                    locala.bix = localJSONObject.getInt("tagType");
                    locala.userName = localJSONObject.getString("userName");
                    paramBundle.add(locala);
                    paramInt += 1;
                  }
                }
                paramBundle = paramBundle.getString("fts_key_json_data");
              }
              catch (Exception localException)
              {
                if (this.Eye != null)
                {
                  if (paramBundle.size() > 0) {
                    this.Eye.I((String)localObject2, paramBundle);
                  }
                }
                else
                {
                  if (!bool) {
                    break label774;
                  }
                  this.handler.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(80532);
                      if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eXF());
                      }
                      AppMethodBeat.o(80532);
                    }
                  });
                  if (this.Eye != null) {
                    this.Eye.fOj();
                  }
                  eWW();
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.fts.b.a.a.eRU();
                  com.tencent.mm.plugin.webview.fts.b.a.a.aHW(getTotalQuery());
                  AppMethodBeat.o(80565);
                  return;
                  this.Eye.I((String)localObject1, paramBundle);
                  break;
                  if (this.Eye != null) {
                    this.Eye.vr.clearFocus();
                  }
                }
              }
              this.handler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80533);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().aIf(paramBundle);
                  }
                  AppMethodBeat.o(80533);
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
                  AppMethodBeat.i(80534);
                  if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.getJsapi().fT(this.Eyq, paramInt);
                  }
                  AppMethodBeat.o(80534);
                }
              });
              AppMethodBeat.o(80565);
              return;
              if (!eXH())
              {
                ae.w("MicroMsg.WebSearch.BaseSOSWebViewUI", "current state is not search");
                AppMethodBeat.o(80565);
                return;
              }
            } while (this.Eyi == null);
            this.Eyi.c(paramBundle, this.scene);
            AppMethodBeat.o(80565);
            return;
          } while (this.Eyi == null);
          this.Eyi.aV(paramBundle);
          AppMethodBeat.o(80565);
          return;
        } while (this.Eyi == null);
        this.Eyi.aW(paramBundle);
        AppMethodBeat.o(80565);
        return;
      } while (this.Eyi == null);
      this.Eyi.aX(paramBundle);
      AppMethodBeat.o(80565);
      return;
    case 138: 
      paramBundle = paramBundle.getString("fts_key_data");
      if (!bu.isNullOrNil(paramBundle))
      {
        if ("index".equals(paramBundle))
        {
          this.Eyh = 1;
          AppMethodBeat.o(80565);
          return;
        }
        if ("result".equals(paramBundle))
        {
          this.Eyh = 2;
          AppMethodBeat.o(80565);
          return;
        }
        if ("suggestion".equals(paramBundle))
        {
          this.Eyh = 3;
          AppMethodBeat.o(80565);
          return;
        }
        if ("teach".equals(paramBundle))
        {
          this.Eyh = 4;
          AppMethodBeat.o(80565);
          return;
        }
        if ("local".equals(paramBundle))
        {
          this.Eyh = 5;
          AppMethodBeat.o(80565);
          return;
        }
        this.Eyh = 0;
        AppMethodBeat.o(80565);
        return;
      }
      this.Eyh = 0;
      AppMethodBeat.o(80565);
      return;
    case 144: 
      label774:
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
        AppMethodBeat.i(198331);
        if (BaseSOSWebViewUI.this.DRx != null)
        {
          BaseSOSWebViewUI.this.DRx.a(paramInt, l, this.oLD);
          ae.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), this.oLD });
        }
        AppMethodBeat.o(198331);
      }
    });
    AppMethodBeat.o(80565);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80569);
    etQ();
    AppMethodBeat.o(80569);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80561);
    if (this.Eye != null)
    {
      if (!this.Eye.vr.hasFocus())
      {
        this.Eye.fOj();
        showVKB();
      }
      this.Eye.setHint(getHint());
    }
    AppMethodBeat.o(80561);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80552);
    super.onCreate(paramBundle);
    this.Eyf = getIntent().getBooleanExtra("ftsInitToSearch", false);
    getSupportActionBar().hide();
    AppMethodBeat.o(80552);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80564);
    try
    {
      if (this.lzT != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.lzT.x(1, localBundle);
      }
      if (this.Eyi != null) {
        this.Eyi.onDestroy();
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
    if (this.Eyi != null) {
      this.Eyi.onPause();
    }
    AppMethodBeat.o(80555);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80554);
    super.onResume();
    if (this.Eyi != null) {
      this.Eyi.onResume();
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
    String AUt;
    int bix;
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
      int i = this.AUt.compareTo(paramObject.AUt);
      AppMethodBeat.o(80543);
      return i;
    }
    
    public final String getTagName()
    {
      return this.AUt;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.webview.core.j
  {
    private b() {}
    
    private static WebResourceResponse aKp(String paramString)
    {
      AppMethodBeat.i(198340);
      ae.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      paramString = Uri.parse(paramString);
      try
      {
        paramString = o.openRead(paramString.getQueryParameter("path"));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/*", "utf8", paramString);
          AppMethodBeat.o(198340);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        AppMethodBeat.o(198340);
      }
      return null;
    }
    
    public final boolean aHQ(String paramString)
    {
      AppMethodBeat.i(198336);
      if (BaseSOSWebViewUI.this.Efm)
      {
        AppMethodBeat.o(198336);
        return true;
      }
      boolean bool = super.aHQ(paramString);
      AppMethodBeat.o(198336);
      return bool;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(198339);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
      {
        paramWebView = aKp(paramWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(198339);
        return paramWebView;
      }
      AppMethodBeat.o(198339);
      return null;
    }
    
    public final com.tencent.mm.plugin.webview.core.e eRA()
    {
      AppMethodBeat.i(198337);
      a locala = new a((byte)0);
      AppMethodBeat.o(198337);
      return locala;
    }
    
    public final i eRB()
    {
      AppMethodBeat.i(198338);
      b localb = new b((byte)0);
      AppMethodBeat.o(198338);
      return localb;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.e
    {
      private a() {}
      
      public final void aHE(String paramString)
      {
        AppMethodBeat.i(198334);
        ae.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onPageStarted %s", new Object[] { paramString });
        BaseSOSWebViewUI.this.showOptionMenu(false);
        if ((BaseSOSWebViewUI.this.Eye != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.this)))
        {
          BaseSOSWebViewUI.this.Eye.vr.clearFocus();
          BaseSOSWebViewUI.this.hideVKB();
        }
        AppMethodBeat.o(198334);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(198333);
        ae.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.this.scene), paramString });
        BaseSOSWebViewUI.this.showOptionMenu(false);
        if ((BaseSOSWebViewUI.this.Eye != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.this)))
        {
          BaseSOSWebViewUI.this.Eye.vr.clearFocus();
          BaseSOSWebViewUI.this.hideVKB();
        }
        AppMethodBeat.o(198333);
      }
    }
    
    final class b
      extends i
    {
      private b() {}
      
      public final void bSg()
      {
        AppMethodBeat.i(198335);
        BaseSOSWebViewUI.b(BaseSOSWebViewUI.this);
        BaseSOSWebViewUI.this.eXA();
        AppMethodBeat.o(198335);
      }
    }
  }
  
  protected final class c
  {
    String Eyv;
    String Eyw;
    Map<String, Object> Eyx;
    List<a.c> pwz;
    int type;
    
    protected c()
    {
      AppMethodBeat.i(80550);
      this.Eyv = "";
      this.Eyw = "";
      this.Eyx = new HashMap();
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
        if ((paramObject.type == this.type) && (paramObject.Eyw.equals(this.Eyw)))
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