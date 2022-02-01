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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
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
  implements FTSEditTextView.c, com.tencent.mm.ui.search.a
{
  private View AtJ;
  protected View NfI;
  public boolean Xcm;
  public boolean Xcn;
  public boolean Xco;
  private e Xct;
  private com.tencent.mm.plugin.webview.fts.c.a Xcu;
  private WebSearchView Xdj;
  protected View Xdk;
  private boolean Xdl;
  private boolean Xdm;
  private LinkedList<String> Xdn;
  private b Xdo;
  private int scene;
  private int type;
  
  public FTSBaseWebViewUI()
  {
    AppMethodBeat.i(296878);
    this.Xdn = new LinkedList();
    this.Xcm = true;
    this.Xcn = true;
    this.Xco = true;
    this.Xdo = new b((byte)0);
    AppMethodBeat.o(296878);
  }
  
  private void ank(String paramString)
  {
    AppMethodBeat.i(296892);
    this.Xdn.remove(paramString);
    this.Xdn.add(paramString);
    AppMethodBeat.o(296892);
  }
  
  protected static boolean iAg()
  {
    return true;
  }
  
  protected static boolean iAh()
  {
    return true;
  }
  
  private boolean iAp()
  {
    AppMethodBeat.i(296881);
    if (this.Xdn.size() <= 1)
    {
      hideVKB();
      finish();
      AppMethodBeat.o(296881);
      return true;
    }
    this.Xdn.removeLast();
    String str = (String)this.Xdn.getLast();
    this.Xdj.getFtsEditText().V(str, null);
    this.Xdj.getFtsEditText().dzv.clearFocus();
    hideVKB();
    iAr();
    AppMethodBeat.o(296881);
    return false;
  }
  
  private void iAr()
  {
    AppMethodBeat.i(296883);
    getHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80590);
        int i;
        String str1;
        String str2;
        if (FTSBaseWebViewUI.this.WlX != null)
        {
          FTSBaseWebViewUI.this.WlX.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.iAj(), 0, null);
          if (!TextUtils.isEmpty(FTSBaseWebViewUI.this.getInEditTextQuery()))
          {
            i = FTSBaseWebViewUI.a(FTSBaseWebViewUI.this);
            str1 = FTSBaseWebViewUI.this.sessionId;
            str2 = FTSBaseWebViewUI.this.hVn;
            if (FTSBaseWebViewUI.this.Xdc != 0) {
              break label126;
            }
          }
        }
        label126:
        for (boolean bool = true;; bool = false)
        {
          ai.a(i, str1, str2, bool, FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.b(FTSBaseWebViewUI.this));
          AppMethodBeat.o(80590);
          return;
        }
      }
    });
    AppMethodBeat.o(296883);
  }
  
  public boolean aWU()
  {
    AppMethodBeat.i(80614);
    Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onSearchKeyDown");
    if (getTotalQuery().length() > 0)
    {
      ank(getTotalQuery());
      iAr();
      hideVKB();
    }
    AppMethodBeat.o(80614);
    return false;
  }
  
  protected final void c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(369861);
    ank(paramString);
    AppMethodBeat.o(369861);
  }
  
  public final k dhx()
  {
    AppMethodBeat.i(296912);
    k localk = super.dhx();
    if (localk != null) {
      localk.a(this.Xdo);
    }
    AppMethodBeat.o(296912);
    return localk;
  }
  
  public final void eeU()
  {
    AppMethodBeat.i(164031);
    if (!this.Xdj.getFtsEditText().dzv.hasFocus())
    {
      this.Xdj.getFtsEditText().aWT();
      showVKB();
    }
    AppMethodBeat.o(164031);
  }
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(80612);
    if (paramBoolean) {
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80589);
          if (FTSBaseWebViewUI.this.WlX != null) {
            FTSBaseWebViewUI.this.WlX.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.iAj(), 0);
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
    String str = this.Xdj.getFtsEditText().getInEditTextQuery();
    AppMethodBeat.o(80606);
    return str;
  }
  
  public int getLayoutId()
  {
    return c.g.fts_webview_ui;
  }
  
  protected final int getScene()
  {
    return this.scene;
  }
  
  protected final String getTotalQuery()
  {
    AppMethodBeat.i(80605);
    String str = this.Xdj.getFtsEditText().getTotalQuery();
    AppMethodBeat.o(80605);
    return str;
  }
  
  protected final int getType()
  {
    return this.type;
  }
  
  protected final e iAi()
  {
    return this.Xct;
  }
  
  public final JSONArray iAj()
  {
    AppMethodBeat.i(80615);
    Object localObject = this.Xdj.getFtsEditText().getTagList();
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
    AppMethodBeat.o(80615);
    return localJSONArray;
  }
  
  protected final WebSearchView iAq()
  {
    return this.Xdj;
  }
  
  public final void iyF()
  {
    AppMethodBeat.i(80618);
    iAp();
    AppMethodBeat.o(80618);
  }
  
  public final int iyL()
  {
    return c.h.actionbar_icon_dark_back;
  }
  
  public final boolean iyM()
  {
    return false;
  }
  
  public final boolean iyZ()
  {
    return true;
  }
  
  public final boolean ize()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(296914);
    if (iAp()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(296914);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(80607);
    iAp();
    AppMethodBeat.o(80607);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(80619);
    this.Xdj.getFtsEditText().V("", null);
    getHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296876);
        if (FTSBaseWebViewUI.this.WlX != null) {
          FTSBaseWebViewUI.this.WlX.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.iAj(), 1);
        }
        AppMethodBeat.o(296876);
      }
    });
    this.Xdj.getFtsEditText().dzv.clearFocus();
    hideVKB();
    AppMethodBeat.o(80619);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80613);
    if (this.Xdj != null)
    {
      if (!this.Xdj.getFtsEditText().dzv.hasFocus())
      {
        this.Xdj.getFtsEditText().aWT();
        showVKB();
      }
      this.Xdj.getFtsEditText().setHint(getHint());
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
    this.Xcm = FTSEditTextView.jCz();
    this.Xcn = FTSEditTextView.jCA();
    this.Xco = FTSEditTextView.jCB();
    Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "initData, isSearchInputBackLast = %s, isSearchInputTypeOld = %s, isSearchInputShowCancel = %s.", new Object[] { Boolean.valueOf(this.Xcm), Boolean.valueOf(this.Xcn), Boolean.valueOf(this.Xco) });
    this.Xcu = new com.tencent.mm.plugin.webview.fts.c.a(this.sMP);
    this.Xct = new e(((f)com.tencent.mm.kernel.h.ax(f.class)).a(getContext(), this.Xcu));
    this.Xdk = findViewById(c.f.fts_search_view_container);
    paramBundle = Util.nullAs(getIntent().getStringExtra("ftsQuery"), "").trim();
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.Xdl = getIntent().getBooleanExtra("ftscaneditable", true);
    this.Xdm = getIntent().getBooleanExtra("key_hide_cancel_btn", false);
    if (this.sMP != null) {
      this.sMP.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(80581);
          FTSBaseWebViewUI.this.hideVKB();
          FTSBaseWebViewUI.this.iAo();
          AppMethodBeat.o(80581);
          return false;
        }
      });
    }
    this.Xdj = ((WebSearchView)findViewById(c.f.websearchview));
    this.AtJ = findViewById(c.f.title_container);
    this.NfI = findViewById(c.f.shadow_view);
    if (this.Xdl)
    {
      this.AtJ.setVisibility(8);
      this.Xdj.setSearchViewListener(this);
      this.Xdj.getFtsEditText().setHint(getHint());
      this.Xdj.getFtsEditText().setFtsEditTextListener(this);
      if (this.Xdm) {
        this.Xdj.getCancelBtn().setVisibility(8);
      }
      if (!Util.isNullOrNil(paramBundle))
      {
        this.Xdj.getFtsEditText().V(paramBundle, null);
        ank(paramBundle);
      }
      if (this.XbH)
      {
        this.Xdj.getFtsEditText().aWT();
        this.Xdj.getFtsEditText().aWS();
      }
      if (getIntent().getBooleanExtra("key_change_search_icon", false))
      {
        this.Xdj.getSearchIcon().setVisibility(8);
        this.Xdj.getFtsEditText().jCw();
        this.Xdj.getFtsEditText().getIconView().setImageDrawable(auD(this.type));
        this.Xdj.getFtsEditText().getIconView().setIconColor(getResources().getColor(c.c.FG_2));
      }
    }
    for (;;)
    {
      showOptionMenu(false);
      if (this.WYD != null) {
        this.WYD.IJ(true);
      }
      if (this.sMP != null) {
        this.sMP.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(296879);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(296879);
            return true;
          }
        });
      }
      this.Xcu.WlX = this.WlX;
      AppMethodBeat.o(80602);
      return;
      this.Xdj.setVisibility(8);
      paramBundle = getIntent().getStringExtra("title");
      if (!Util.isNullOrNil(paramBundle)) {
        ((TextView)findViewById(c.f.back_title_tv)).setText(paramBundle);
      }
      findViewById(c.f.back_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(296884);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          FTSBaseWebViewUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(296884);
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80617);
    try
    {
      if (this.sLC != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.sLC.B(1, localBundle);
      }
      this.Xct.onDestroy();
    }
    catch (RemoteException localRemoteException)
    {
      label51:
      break label51;
    }
    hideVKB();
    this.Wzl.b(this.Xdo);
    this.Wzl.b(this.Xdo.Xdq);
    super.onDestroy();
    AppMethodBeat.o(80617);
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(164032);
    Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramd });
    if ((paramd == FTSEditTextView.d.afCj) || (paramd == FTSEditTextView.d.afCk)) {
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80588);
          if (FTSBaseWebViewUI.this.WlX != null) {
            FTSBaseWebViewUI.this.WlX.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.iAj(), 0);
          }
          AppMethodBeat.o(80588);
        }
      });
    }
    AppMethodBeat.o(164032);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80610);
    super.onPause();
    this.Xct.onPause();
    AppMethodBeat.o(80610);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80609);
    super.onResume();
    this.Xct.onResume();
    AppMethodBeat.o(80609);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void q(final int paramInt, final Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(80616);
    Object localObject1;
    switch (paramInt)
    {
    default: 
      super.q(paramInt, paramBundle);
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
        getHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80591);
            if (FTSBaseWebViewUI.this.WlX != null) {
              FTSBaseWebViewUI.this.WlX.ci(this.tyZ);
            }
            AppMethodBeat.o(80591);
          }
        });
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        localObject2 = paramBundle.getString("fts_key_req_id");
        final boolean bool1 = paramBundle.getBoolean("fts_key_new_query", true);
        aS(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80592);
            if (FTSBaseWebViewUI.this.WlX != null)
            {
              if ((this.TKo != null) && (this.TKo.getInt("isRefresh") == 1) && (this.TKo.getString("widgetId") != null))
              {
                FTSBaseWebViewUI.this.WlX.ol(this.TKo.getString("widgetId"), this.uei);
                AppMethodBeat.o(80592);
                return;
              }
              FTSBaseWebViewUI.this.WlX.m(this.uei, bool1, this.WBF);
            }
            AppMethodBeat.o(80592);
          }
        });
        AppMethodBeat.o(80616);
        return;
        paramInt = paramBundle.getInt("fts_key_ret", 0);
        paramBundle = paramBundle.getString("fts_key_data");
        getHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80593);
            if (FTSBaseWebViewUI.this.WlX != null) {
              FTSBaseWebViewUI.this.WlX.dG(paramInt, paramBundle);
            }
            AppMethodBeat.o(80593);
          }
        });
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        aS(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80582);
            if (FTSBaseWebViewUI.this.WlX != null) {
              FTSBaseWebViewUI.this.WlX.E(this.XcG, this.uei, this.uej);
            }
            AppMethodBeat.o(80582);
          }
        });
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
              locala.RWX = localJSONObject.getString("tagName");
              locala.cLU = localJSONObject.getInt("tagType");
              locala.userName = localJSONObject.getString("userName");
              paramBundle.add(locala);
              paramInt += 1;
            }
          }
          if (this.Xdj == null) {}
        }
        catch (Exception localException)
        {
          if (this.Xdj != null)
          {
            if (paramBundle.size() <= 0) {
              break label663;
            }
            this.Xdj.getFtsEditText().V((String)localObject2, paramBundle);
            if (bool2) {
              ank((String)localObject2);
            }
          }
          while (bool1)
          {
            getHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80583);
                if (FTSBaseWebViewUI.this.WlX != null) {
                  FTSBaseWebViewUI.this.WlX.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.iAj(), 0);
                }
                AppMethodBeat.o(80583);
              }
            });
            if (this.Xdj != null) {
              this.Xdj.getFtsEditText().aWT();
            }
            izf();
            AppMethodBeat.o(80616);
            return;
            this.Xdj.getFtsEditText().V((String)localObject1, paramBundle);
            if (bool2) {
              ank((String)localObject1);
            }
          }
        }
      }
      this.Xdj.getFtsEditText().dzv.clearFocus();
      iAn();
      AppMethodBeat.o(80616);
      return;
    case 124: 
      paramBundle = paramBundle.getString("fts_key_json_data");
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80584);
          if (FTSBaseWebViewUI.this.WlX != null) {
            FTSBaseWebViewUI.this.WlX.biN(paramBundle);
          }
          AppMethodBeat.o(80584);
        }
      });
      AppMethodBeat.o(80616);
      return;
    case 125: 
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80585);
          if (FTSBaseWebViewUI.this.WlX != null) {
            FTSBaseWebViewUI.this.WlX.hY(this.XcH, paramInt);
          }
          AppMethodBeat.o(80585);
        }
      });
      AppMethodBeat.o(80616);
      return;
    case 60: 
      this.Xct.b(paramBundle, this.scene);
      AppMethodBeat.o(80616);
      return;
    case 100001: 
      this.Xct.bK(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 61: 
      this.Xct.bL(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 62: 
      this.Xct.bM(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 144: 
      label663:
      AppMethodBeat.o(80616);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    final long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    getHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80586);
        if (FTSBaseWebViewUI.this.WlX != null)
        {
          FTSBaseWebViewUI.this.WlX.a(paramInt, l, this.wzK);
          Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), this.wzK });
        }
        AppMethodBeat.o(80586);
      }
    });
    AppMethodBeat.o(80616);
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
      AppMethodBeat.i(80594);
      if ((paramObject == null) || (!(paramObject instanceof a)))
      {
        AppMethodBeat.o(80594);
        return -1;
      }
      paramObject = (a)paramObject;
      int i = this.RWX.compareTo(paramObject.RWX);
      AppMethodBeat.o(80594);
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
    a Xdq;
    
    private b()
    {
      AppMethodBeat.i(296833);
      this.Xdq = new a((byte)0);
      AppMethodBeat.o(296833);
    }
    
    private static WebResourceResponse biK(String paramString)
    {
      AppMethodBeat.i(296838);
      Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      paramString = Uri.parse(paramString);
      try
      {
        paramString = y.Lh(paramString.getQueryParameter("path"));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/*", "utf8", paramString);
          AppMethodBeat.o(296838);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        AppMethodBeat.o(296838);
      }
      return null;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(296847);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
      {
        paramWebView = biK(paramWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(296847);
        return paramWebView;
      }
      AppMethodBeat.o(296847);
      return null;
    }
    
    public final com.tencent.mm.plugin.webview.core.h isN()
    {
      return this.Xdq;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.h
    {
      private a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(296783);
        if ((paramString2 != null) && (paramString2.equals(FTSBaseWebViewUI.this.dgY()))) {
          as.nb(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 16);
        }
        AppMethodBeat.o(296783);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(296773);
        Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageFinished %s", new Object[] { paramString });
        FTSBaseWebViewUI.this.showOptionMenu(false);
        if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this) != null) && (!FTSBaseWebViewUI.this.XbH) && (FTSBaseWebViewUI.iAg()))
        {
          FTSBaseWebViewUI.c(FTSBaseWebViewUI.this).getFtsEditText().dzv.clearFocus();
          FTSBaseWebViewUI.this.hideVKB();
        }
        AppMethodBeat.o(296773);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(296780);
        Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageStarted %s", new Object[] { paramString });
        FTSBaseWebViewUI.this.showOptionMenu(false);
        if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this) != null) && (!FTSBaseWebViewUI.this.XbH) && (FTSBaseWebViewUI.iAh()))
        {
          FTSBaseWebViewUI.c(FTSBaseWebViewUI.this).getFtsEditText().dzv.clearFocus();
          FTSBaseWebViewUI.this.hideVKB();
        }
        as.nb(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 1);
        as.nc(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 1);
        AppMethodBeat.o(296780);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */