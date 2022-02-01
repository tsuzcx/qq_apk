package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.i;
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

public class FTSBaseWebViewUI
  extends BaseSearchWebViewUI
  implements FTSEditTextView.a, a.b
{
  private boolean BjR;
  private boolean BkK;
  private e Bki;
  private com.tencent.mm.plugin.webview.fts.d.a Bkj;
  protected com.tencent.mm.ui.search.a rtD;
  int scene;
  int type;
  
  private void dPr()
  {
    AppMethodBeat.i(80604);
    hideVKB();
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(80604);
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164032);
    ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.Hlc) || (paramb == FTSEditTextView.b.Hld)) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80587);
          if (FTSBaseWebViewUI.this.AQP != null) {
            FTSBaseWebViewUI.this.AQP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.epF(), 0);
          }
          AppMethodBeat.o(80587);
        }
      });
    }
    AppMethodBeat.o(164032);
  }
  
  public final h bFq()
  {
    AppMethodBeat.i(188090);
    h localh = super.bFq();
    if (localh != null) {
      localh.a(new b((byte)0));
    }
    AppMethodBeat.o(188090);
    return localh;
  }
  
  public void bol()
  {
    AppMethodBeat.i(80603);
    super.bol();
    String str = bt.by(getIntent().getStringExtra("ftsQuery"), "").trim();
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.BjR = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.BkK = getIntent().getBooleanExtra("ftscaneditable", true);
    if (this.nhy != null) {
      this.nhy.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(80581);
          FTSBaseWebViewUI.this.hideVKB();
          FTSBaseWebViewUI.this.epJ();
          AppMethodBeat.o(80581);
          return false;
        }
      });
    }
    if (this.BkK)
    {
      this.rtD = dG(this);
      if (this.rtD == null) {
        this.rtD = new com.tencent.mm.ui.search.a(this);
      }
      this.rtD.setSearchViewListener(this);
      this.rtD.getFtsEditText().setHint(getHint());
      this.rtD.getFtsEditText().setFtsEditTextListener(this);
      getSupportActionBar().setCustomView(this.rtD);
      if (!bt.isNullOrNil(str)) {
        this.rtD.getFtsEditText().J(str, null);
      }
      if (this.BjR)
      {
        this.rtD.getFtsEditText().fdj();
        this.rtD.getFtsEditText().fdi();
      }
    }
    showOptionMenu(false);
    if (this.Bis != null) {
      this.Bis.tr(true);
    }
    if (this.nhy != null) {
      this.nhy.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          return true;
        }
      });
    }
    this.Bkj.AQP = this.AQP;
    AppMethodBeat.o(80603);
  }
  
  public boolean bow()
  {
    AppMethodBeat.i(80614);
    ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onSearchKeyDown");
    if (getTotalQuery().length() > 0)
    {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80589);
          int i;
          String str1;
          String str2;
          if (FTSBaseWebViewUI.this.AQP != null)
          {
            FTSBaseWebViewUI.this.AQP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.epF(), 0, null);
            if (!TextUtils.isEmpty(FTSBaseWebViewUI.this.getInEditTextQuery()))
            {
              i = FTSBaseWebViewUI.a(FTSBaseWebViewUI.this);
              str1 = FTSBaseWebViewUI.this.sessionId;
              str2 = FTSBaseWebViewUI.this.dtw;
              if (FTSBaseWebViewUI.this.BkC != 0) {
                break label126;
              }
            }
          }
          label126:
          for (boolean bool = true;; bool = false)
          {
            z.a(i, str1, str2, bool, FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.b(FTSBaseWebViewUI.this));
            AppMethodBeat.o(80589);
            return;
          }
        }
      });
      hideVKB();
    }
    AppMethodBeat.o(80614);
    return false;
  }
  
  public final void cok()
  {
    AppMethodBeat.i(164031);
    if (!this.rtD.getFtsEditText().sz.hasFocus())
    {
      this.rtD.getFtsEditText().fdj();
      showVKB();
    }
    AppMethodBeat.o(164031);
  }
  
  protected com.tencent.mm.ui.search.a dG(Context paramContext)
  {
    return null;
  }
  
  public final void eoB()
  {
    AppMethodBeat.i(80618);
    dPr();
    AppMethodBeat.o(80618);
  }
  
  public final int eoF()
  {
    return 2131689490;
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
  
  protected final e epD()
  {
    return this.Bki;
  }
  
  public final JSONArray epF()
  {
    AppMethodBeat.i(80615);
    Object localObject = this.rtD.getFtsEditText().getTagList();
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
    AppMethodBeat.o(80615);
    return localJSONArray;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  protected String getHint()
  {
    return null;
  }
  
  protected final String getInEditTextQuery()
  {
    AppMethodBeat.i(80606);
    String str = this.rtD.getFtsEditText().getInEditTextQuery();
    AppMethodBeat.o(80606);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131494229;
  }
  
  protected final String getTotalQuery()
  {
    AppMethodBeat.i(80605);
    String str = this.rtD.getFtsEditText().getTotalQuery();
    AppMethodBeat.o(80605);
    return str;
  }
  
  public final void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(80612);
    if (paramBoolean) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80588);
          if (FTSBaseWebViewUI.this.AQP != null) {
            FTSBaseWebViewUI.this.AQP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.epF(), 0);
          }
          AppMethodBeat.o(80588);
        }
      });
    }
    AppMethodBeat.o(80612);
  }
  
  public void m(final int paramInt, final Bundle paramBundle)
  {
    final int i = 0;
    AppMethodBeat.i(80616);
    Object localObject1;
    switch (paramInt)
    {
    default: 
      super.m(paramInt, paramBundle);
    case 126: 
    case 119: 
    case 120: 
    case 121: 
    case 122: 
      for (;;)
      {
        AppMethodBeat.o(80616);
        return;
        paramBundle.getString("fts_key_json_data");
        paramBundle.getBoolean("fts_key_new_query", true);
        localObject1 = new HashMap();
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
            AppMethodBeat.i(80590);
            if (FTSBaseWebViewUI.this.AQP != null) {
              FTSBaseWebViewUI.this.AQP.bs(this.AhJ);
            }
            AppMethodBeat.o(80590);
          }
        });
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        localObject2 = paramBundle.getString("fts_key_req_id");
        final boolean bool = paramBundle.getBoolean("fts_key_new_query", true);
        paramBundle = paramBundle.getBundle("fts_key_data");
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80591);
            if (FTSBaseWebViewUI.this.AQP != null)
            {
              if ((paramBundle != null) && (paramBundle.getInt("isRefresh") == 1) && (paramBundle.getString("widgetId") != null))
              {
                FTSBaseWebViewUI.this.AQP.jV(paramBundle.getString("widgetId"), this.lCl);
                AppMethodBeat.o(80591);
                return;
              }
              FTSBaseWebViewUI.this.AQP.j(this.lCl, bool, this.APj);
            }
            AppMethodBeat.o(80591);
          }
        });
        AppMethodBeat.o(80616);
        return;
        paramInt = paramBundle.getInt("fts_key_ret", 0);
        paramBundle = paramBundle.getString("fts_key_data");
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80592);
            if (FTSBaseWebViewUI.this.AQP != null) {
              FTSBaseWebViewUI.this.AQP.cq(paramInt, paramBundle);
            }
            AppMethodBeat.o(80592);
          }
        });
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
        i = paramBundle.getInt("fts_key_is_cache_data", 0);
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80593);
            if (FTSBaseWebViewUI.this.AQP != null) {
              FTSBaseWebViewUI.this.AQP.u(paramInt, this.lCl, i);
            }
            AppMethodBeat.o(80593);
          }
        });
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_new_query");
        localObject2 = paramBundle.getString("fts_key_custom_query");
        bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
        Object localObject3 = paramBundle.getString("fts_key_tag_list");
        ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
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
          if (this.rtD == null) {}
        }
        catch (Exception localException)
        {
          if (this.rtD != null)
          {
            if (paramBundle.size() <= 0) {
              break label656;
            }
            this.rtD.getFtsEditText().J((String)localObject2, paramBundle);
          }
          while (bool)
          {
            this.handler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80582);
                if (FTSBaseWebViewUI.this.AQP != null) {
                  FTSBaseWebViewUI.this.AQP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.epF(), 0);
                }
                AppMethodBeat.o(80582);
              }
            });
            if (this.rtD != null) {
              this.rtD.getFtsEditText().fdj();
            }
            eoW();
            AppMethodBeat.o(80616);
            return;
            this.rtD.getFtsEditText().J((String)localObject1, paramBundle);
          }
        }
      }
      this.rtD.getFtsEditText().sz.clearFocus();
      hideVKB();
      AppMethodBeat.o(80616);
      return;
    case 124: 
      paramBundle = paramBundle.getString("fts_key_json_data");
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80583);
          if (FTSBaseWebViewUI.this.AQP != null) {
            FTSBaseWebViewUI.this.AQP.avX(paramBundle);
          }
          AppMethodBeat.o(80583);
        }
      });
      AppMethodBeat.o(80616);
      return;
    case 125: 
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80584);
          if (FTSBaseWebViewUI.this.AQP != null) {
            FTSBaseWebViewUI.this.AQP.fd(this.Bkp, paramInt);
          }
          AppMethodBeat.o(80584);
        }
      });
      AppMethodBeat.o(80616);
      return;
    case 60: 
      this.Bki.b(paramBundle, this.scene);
      AppMethodBeat.o(80616);
      return;
    case 100001: 
      this.Bki.aK(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 61: 
      this.Bki.aL(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 62: 
      this.Bki.aM(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 144: 
      label656:
      AppMethodBeat.o(80616);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    final long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80585);
        if (FTSBaseWebViewUI.this.AQP != null)
        {
          FTSBaseWebViewUI.this.AQP.a(paramInt, l, this.nyH);
          ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), this.nyH });
        }
        AppMethodBeat.o(80585);
      }
    });
    AppMethodBeat.o(80616);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(80607);
    dPr();
    AppMethodBeat.o(80607);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(80619);
    this.rtD.getFtsEditText().J("", null);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80586);
        if (FTSBaseWebViewUI.this.AQP != null) {
          FTSBaseWebViewUI.this.AQP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.epF(), 1);
        }
        AppMethodBeat.o(80586);
      }
    });
    this.rtD.getFtsEditText().sz.clearFocus();
    hideVKB();
    AppMethodBeat.o(80619);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80613);
    if (this.rtD != null)
    {
      if (!this.rtD.getFtsEditText().sz.hasFocus())
      {
        this.rtD.getFtsEditText().fdj();
        showVKB();
      }
      this.rtD.getFtsEditText().setHint(getHint());
    }
    AppMethodBeat.o(80613);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80602);
    super.onCreate(paramBundle);
    this.Bkj = new com.tencent.mm.plugin.webview.fts.d.a(this.nhy);
    this.Bki = new e(((com.tencent.mm.plugin.websearch.api.e)g.ab(com.tencent.mm.plugin.websearch.api.e.class)).a(getContext(), this.Bkj));
    setActionbarColor(ao.aD(getContext(), 2130968577));
    AppMethodBeat.o(80602);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80617);
    try
    {
      if (this.kxf != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.kxf.v(1, localBundle);
      }
      this.Bki.onDestroy();
    }
    catch (RemoteException localRemoteException)
    {
      label51:
      break label51;
    }
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(80617);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80610);
    super.onPause();
    this.Bki.onPause();
    AppMethodBeat.o(80610);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80609);
    super.onResume();
    this.Bki.onResume();
    AppMethodBeat.o(80609);
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
      AppMethodBeat.i(80594);
      if ((paramObject == null) || (!(paramObject instanceof a)))
      {
        AppMethodBeat.o(80594);
        return -1;
      }
      paramObject = (a)paramObject;
      int i = this.xXR.compareTo(paramObject.xXR);
      AppMethodBeat.o(80594);
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
      AppMethodBeat.i(188089);
      ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      paramString = Uri.parse(paramString);
      try
      {
        paramString = i.openRead(paramString.getQueryParameter("path"));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/*", "utf8", paramString);
          AppMethodBeat.o(188089);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        AppMethodBeat.o(188089);
      }
      return null;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(188088);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
      {
        paramWebView = aye(paramWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(188088);
        return paramWebView;
      }
      AppMethodBeat.o(188088);
      return null;
    }
    
    public final com.tencent.mm.plugin.webview.core.e ejF()
    {
      AppMethodBeat.i(188087);
      a locala = new a((byte)0);
      AppMethodBeat.o(188087);
      return locala;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.e
    {
      private a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(188086);
        if ((paramString2 != null) && (paramString2.equals(FTSBaseWebViewUI.this.bEx()))) {
          ak.ip(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 16);
        }
        AppMethodBeat.o(188086);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188084);
        ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageFinished %s", new Object[] { paramString });
        FTSBaseWebViewUI.this.showOptionMenu(false);
        if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.this)))
        {
          FTSBaseWebViewUI.c(FTSBaseWebViewUI.this).getFtsEditText().sz.clearFocus();
          FTSBaseWebViewUI.this.hideVKB();
        }
        AppMethodBeat.o(188084);
      }
      
      public final void m(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188085);
        ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageStarted %s", new Object[] { paramString });
        FTSBaseWebViewUI.this.showOptionMenu(false);
        if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.this)))
        {
          FTSBaseWebViewUI.c(FTSBaseWebViewUI.this).getFtsEditText().sz.clearFocus();
          FTSBaseWebViewUI.this.hideVKB();
        }
        ak.ip(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 1);
        ak.iq(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 1);
        AppMethodBeat.o(188085);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */