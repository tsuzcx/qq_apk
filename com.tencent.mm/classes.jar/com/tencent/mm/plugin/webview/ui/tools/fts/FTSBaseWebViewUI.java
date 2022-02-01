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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.fts.d.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.search.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSBaseWebViewUI
  extends BaseSearchWebViewUI
  implements FTSEditTextView.a, b
{
  private boolean Jmy;
  protected WebSearchView JnL;
  private boolean JnM;
  private boolean JnN;
  private LinkedList<String> JnO;
  private FTSBaseWebViewUI.b JnP;
  private e Jng;
  private a Jnh;
  int scene;
  private View tql;
  int type;
  
  public FTSBaseWebViewUI()
  {
    AppMethodBeat.i(211237);
    this.JnO = new LinkedList();
    this.JnP = new FTSBaseWebViewUI.b(this, (byte)0);
    AppMethodBeat.o(211237);
  }
  
  private void alC(String paramString)
  {
    AppMethodBeat.i(211243);
    this.JnO.remove(paramString);
    this.JnO.add(paramString);
    AppMethodBeat.o(211243);
  }
  
  private boolean ggS()
  {
    AppMethodBeat.i(211239);
    if (this.JnO.size() <= 1)
    {
      hideVKB();
      finish();
      AppMethodBeat.o(211239);
      return true;
    }
    this.JnO.removeLast();
    String str = (String)this.JnO.getLast();
    this.JnL.getFtsEditText().O(str, null);
    this.JnL.getFtsEditText().vy.clearFocus();
    hideVKB();
    ggT();
    AppMethodBeat.o(211239);
    return false;
  }
  
  private void ggT()
  {
    AppMethodBeat.i(211241);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80590);
        int i;
        String str1;
        String str2;
        if (FTSBaseWebViewUI.this.IBw != null)
        {
          FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 0, null);
          if (!TextUtils.isEmpty(FTSBaseWebViewUI.this.getInEditTextQuery()))
          {
            i = FTSBaseWebViewUI.a(FTSBaseWebViewUI.this);
            str1 = FTSBaseWebViewUI.this.sessionId;
            str2 = FTSBaseWebViewUI.this.dVO;
            if (FTSBaseWebViewUI.this.JnE != 0) {
              break label126;
            }
          }
        }
        label126:
        for (boolean bool = true;; bool = false)
        {
          ah.a(i, str1, str2, bool, FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.b(FTSBaseWebViewUI.this));
          AppMethodBeat.o(80590);
          return;
        }
      }
    });
    AppMethodBeat.o(211241);
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164032);
    Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.QnQ) || (paramb == FTSEditTextView.b.QnR)) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80588);
          if (FTSBaseWebViewUI.this.IBw != null) {
            FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 0);
          }
          AppMethodBeat.o(80588);
        }
      });
    }
    AppMethodBeat.o(164032);
  }
  
  public boolean awE()
  {
    AppMethodBeat.i(80614);
    Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onSearchKeyDown");
    if (getTotalQuery().length() > 0)
    {
      alC(getTotalQuery());
      ggT();
      hideVKB();
    }
    AppMethodBeat.o(80614);
    return false;
  }
  
  protected final void c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(258625);
    alC(paramString);
    AppMethodBeat.o(258625);
  }
  
  public final i cpO()
  {
    AppMethodBeat.i(211238);
    i locali = super.cpO();
    if (locali != null) {
      locali.a(this.JnP);
    }
    AppMethodBeat.o(211238);
    return locali;
  }
  
  public final void dpw()
  {
    AppMethodBeat.i(164031);
    if (!this.JnL.getFtsEditText().vy.hasFocus())
    {
      this.JnL.getFtsEditText().awD();
      showVKB();
    }
    AppMethodBeat.o(164031);
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(80612);
    if (paramBoolean) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80589);
          if (FTSBaseWebViewUI.this.IBw != null) {
            FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 0);
          }
          AppMethodBeat.o(80589);
        }
      });
    }
    AppMethodBeat.o(80612);
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
    String str = this.JnL.getFtsEditText().getInEditTextQuery();
    AppMethodBeat.o(80606);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131494785;
  }
  
  protected final String getTotalQuery()
  {
    AppMethodBeat.i(80605);
    String str = this.JnL.getFtsEditText().getTotalQuery();
    AppMethodBeat.o(80605);
    return str;
  }
  
  public final int gfD()
  {
    return 2131689492;
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
    AppMethodBeat.i(80618);
    ggS();
    AppMethodBeat.o(80618);
  }
  
  protected final e ggM()
  {
    return this.Jng;
  }
  
  public final JSONArray ggN()
  {
    AppMethodBeat.i(80615);
    Object localObject = this.JnL.getFtsEditText().getTagList();
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
    AppMethodBeat.o(80615);
    return localJSONArray;
  }
  
  public void m(int paramInt, Bundle paramBundle)
  {
    int i = 0;
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
        this.handler.post(new FTSBaseWebViewUI.13(this, (Map)localObject1));
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        localObject2 = paramBundle.getString("fts_key_req_id");
        boolean bool1 = paramBundle.getBoolean("fts_key_new_query", true);
        aD(new FTSBaseWebViewUI.14(this, paramBundle.getBundle("fts_key_data"), (String)localObject1, bool1, (String)localObject2));
        AppMethodBeat.o(80616);
        return;
        paramInt = paramBundle.getInt("fts_key_ret", 0);
        paramBundle = paramBundle.getString("fts_key_data");
        this.handler.post(new FTSBaseWebViewUI.15(this, paramInt, paramBundle));
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        aD(new FTSBaseWebViewUI.2(this, paramBundle.getInt("fts_key_teach_request_type", 0), (String)localObject1, paramBundle.getInt("fts_key_is_cache_data", 0)));
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_new_query");
        localObject2 = paramBundle.getString("fts_key_custom_query");
        bool1 = paramBundle.getBoolean("fts_key_need_keyboard", false);
        Object localObject3 = paramBundle.getString("fts_key_tag_list");
        boolean bool2 = paramBundle.getBoolean("fts_key_cache", false);
        Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool1) });
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
          if (this.JnL == null) {}
        }
        catch (Exception localException)
        {
          if (this.JnL != null)
          {
            if (paramBundle.size() <= 0) {
              break label663;
            }
            this.JnL.getFtsEditText().O((String)localObject2, paramBundle);
            if (bool2) {
              alC((String)localObject2);
            }
          }
          while (bool1)
          {
            this.handler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80583);
                if (FTSBaseWebViewUI.this.IBw != null) {
                  FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 0);
                }
                AppMethodBeat.o(80583);
              }
            });
            if (this.JnL != null) {
              this.JnL.getFtsEditText().awD();
            }
            gfU();
            AppMethodBeat.o(80616);
            return;
            this.JnL.getFtsEditText().O((String)localObject1, paramBundle);
            if (bool2) {
              alC((String)localObject1);
            }
          }
        }
      }
      this.JnL.getFtsEditText().vy.clearFocus();
      hideVKB();
      AppMethodBeat.o(80616);
      return;
    case 124: 
      paramBundle = paramBundle.getString("fts_key_json_data");
      this.handler.post(new FTSBaseWebViewUI.4(this, paramBundle));
      AppMethodBeat.o(80616);
      return;
    case 125: 
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      this.handler.post(new FTSBaseWebViewUI.5(this, (String)localObject1, paramInt));
      AppMethodBeat.o(80616);
      return;
    case 60: 
      this.Jng.c(paramBundle, this.scene);
      AppMethodBeat.o(80616);
      return;
    case 100001: 
      this.Jng.bh(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 61: 
      this.Jng.bi(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 62: 
      this.Jng.bj(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 144: 
      label663:
      AppMethodBeat.o(80616);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    this.handler.post(new FTSBaseWebViewUI.6(this, paramInt, l, paramBundle));
    AppMethodBeat.o(80616);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(211240);
    if (ggS()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(211240);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(80607);
    ggS();
    AppMethodBeat.o(80607);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(80619);
    this.JnL.getFtsEditText().O("", null);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211228);
        if (FTSBaseWebViewUI.this.IBw != null) {
          FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 1);
        }
        AppMethodBeat.o(211228);
      }
    });
    this.JnL.getFtsEditText().vy.clearFocus();
    hideVKB();
    AppMethodBeat.o(80619);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80613);
    if (this.JnL != null)
    {
      if (!this.JnL.getFtsEditText().vy.hasFocus())
      {
        this.JnL.getFtsEditText().awD();
        showVKB();
      }
      this.JnL.getFtsEditText().setHint(getHint());
    }
    AppMethodBeat.o(80613);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80602);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.Jnh = new a(this.pGj);
    this.Jng = new e(((com.tencent.mm.plugin.websearch.api.f)g.af(com.tencent.mm.plugin.websearch.api.f.class)).a(getContext(), this.Jnh));
    paramBundle = Util.nullAs(getIntent().getStringExtra("ftsQuery"), "").trim();
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.Jmy = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.JnM = getIntent().getBooleanExtra("ftscaneditable", true);
    this.JnN = getIntent().getBooleanExtra("key_hide_cancel_btn", false);
    if (this.pGj != null) {
      this.pGj.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(80581);
          FTSBaseWebViewUI.this.hideVKB();
          FTSBaseWebViewUI.this.ggR();
          AppMethodBeat.o(80581);
          return false;
        }
      });
    }
    this.JnL = ((WebSearchView)findViewById(2131310381));
    this.tql = findViewById(2131309214);
    if (this.JnM)
    {
      this.tql.setVisibility(8);
      this.JnL.setSearchViewListener(this);
      this.JnL.getFtsEditText().setHint(getHint());
      this.JnL.getFtsEditText().setFtsEditTextListener(this);
      if (this.JnN) {
        this.JnL.getCancelBtn().setVisibility(8);
      }
      if (!Util.isNullOrNil(paramBundle))
      {
        this.JnL.getFtsEditText().O(paramBundle, null);
        alC(paramBundle);
      }
      if (this.Jmy)
      {
        this.JnL.getFtsEditText().awD();
        this.JnL.getFtsEditText().awC();
      }
      if (getIntent().getBooleanExtra("key_change_search_icon", false))
      {
        this.JnL.getSearchIcon().setVisibility(8);
        this.JnL.getFtsEditText().gXe();
        this.JnL.getFtsEditText().getIconView().setImageDrawable(agS(this.type));
      }
    }
    for (;;)
    {
      showOptionMenu(false);
      if (this.JjI != null) {
        this.JjI.zh(true);
      }
      if (this.pGj != null) {
        this.pGj.setOnLongClickListener(new FTSBaseWebViewUI.9(this));
      }
      this.Jnh.IBw = this.IBw;
      AppMethodBeat.o(80602);
      return;
      this.JnL.setVisibility(8);
      paramBundle = getIntent().getStringExtra("title");
      if (!Util.isNullOrNil(paramBundle)) {
        ((TextView)findViewById(2131297169)).setText(paramBundle);
      }
      findViewById(2131297163).setOnClickListener(new FTSBaseWebViewUI.8(this));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80617);
    try
    {
      if (this.mHh != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.mHh.w(1, localBundle);
      }
      this.Jng.onDestroy();
    }
    catch (RemoteException localRemoteException)
    {
      label51:
      break label51;
    }
    hideVKB();
    this.IMH.b(this.JnP);
    this.IMH.b(this.JnP.JnR);
    super.onDestroy();
    AppMethodBeat.o(80617);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80610);
    super.onPause();
    this.Jng.onPause();
    AppMethodBeat.o(80610);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80609);
    super.onResume();
    this.Jng.onResume();
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
    String FeZ;
    int biu;
    String userName;
    
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
      int i = this.FeZ.compareTo(paramObject.FeZ);
      AppMethodBeat.o(80594);
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
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(211233);
      if ((paramString2 != null) && (paramString2.equals(FTSBaseWebViewUI.this.JnQ.coX()))) {
        ar.kb(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this.JnQ), 16);
      }
      AppMethodBeat.o(211233);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(211231);
      Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageFinished %s", new Object[] { paramString });
      FTSBaseWebViewUI.this.JnQ.showOptionMenu(false);
      if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this.JnQ) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.this.JnQ)))
      {
        FTSBaseWebViewUI.c(FTSBaseWebViewUI.this.JnQ).getFtsEditText().vy.clearFocus();
        FTSBaseWebViewUI.this.JnQ.hideVKB();
      }
      AppMethodBeat.o(211231);
    }
    
    public final void i(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(211232);
      Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageStarted %s", new Object[] { paramString });
      FTSBaseWebViewUI.this.JnQ.showOptionMenu(false);
      if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this.JnQ) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.this.JnQ)))
      {
        FTSBaseWebViewUI.c(FTSBaseWebViewUI.this.JnQ).getFtsEditText().vy.clearFocus();
        FTSBaseWebViewUI.this.JnQ.hideVKB();
      }
      ar.kb(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this.JnQ), 1);
      ar.kc(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this.JnQ), 1);
      AppMethodBeat.o(211232);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */