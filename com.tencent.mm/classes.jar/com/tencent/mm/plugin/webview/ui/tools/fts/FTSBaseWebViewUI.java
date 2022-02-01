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
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.u;
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
  implements FTSEditTextView.b, com.tencent.mm.ui.search.b
{
  private e Qkx;
  private com.tencent.mm.plugin.webview.fts.d.a Qky;
  private WebSearchView Qld;
  private boolean Qle;
  private boolean Qlf;
  private LinkedList<String> Qlg;
  private b Qlh;
  private int scene;
  private int type;
  private View wWQ;
  
  public FTSBaseWebViewUI()
  {
    AppMethodBeat.i(267310);
    this.Qlg = new LinkedList();
    this.Qlh = new b((byte)0);
    AppMethodBeat.o(267310);
  }
  
  private void atv(String paramString)
  {
    AppMethodBeat.i(267318);
    this.Qlg.remove(paramString);
    this.Qlg.add(paramString);
    AppMethodBeat.o(267318);
  }
  
  private boolean haj()
  {
    AppMethodBeat.i(267314);
    if (this.Qlg.size() <= 1)
    {
      hideVKB();
      finish();
      AppMethodBeat.o(267314);
      return true;
    }
    this.Qlg.removeLast();
    String str = (String)this.Qlg.getLast();
    this.Qld.getFtsEditText().O(str, null);
    this.Qld.getFtsEditText().bGw.clearFocus();
    hideVKB();
    hal();
    AppMethodBeat.o(267314);
    return false;
  }
  
  private void hal()
  {
    AppMethodBeat.i(267316);
    btS().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80590);
        int i;
        String str1;
        String str2;
        if (FTSBaseWebViewUI.this.PvJ != null)
        {
          FTSBaseWebViewUI.this.PvJ.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.had(), 0, null);
          if (!TextUtils.isEmpty(FTSBaseWebViewUI.this.getInEditTextQuery()))
          {
            i = FTSBaseWebViewUI.a(FTSBaseWebViewUI.this);
            str1 = FTSBaseWebViewUI.this.sessionId;
            str2 = FTSBaseWebViewUI.this.fPs;
            if (FTSBaseWebViewUI.this.QkV != 0) {
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
    AppMethodBeat.o(267316);
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(164032);
    Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramc });
    if ((paramc == FTSEditTextView.c.XLV) || (paramc == FTSEditTextView.c.XLW)) {
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80588);
          if (FTSBaseWebViewUI.this.PvJ != null) {
            FTSBaseWebViewUI.this.PvJ.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.had(), 0);
          }
          AppMethodBeat.o(80588);
        }
      });
    }
    AppMethodBeat.o(164032);
  }
  
  public boolean aDV()
  {
    AppMethodBeat.i(80614);
    Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onSearchKeyDown");
    if (getTotalQuery().length() > 0)
    {
      atv(getTotalQuery());
      hal();
      hideVKB();
    }
    AppMethodBeat.o(80614);
    return false;
  }
  
  protected final void c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(293242);
    atv(paramString);
    AppMethodBeat.o(293242);
  }
  
  public final i cDV()
  {
    AppMethodBeat.i(267313);
    i locali = super.cDV();
    if (locali != null) {
      locali.a(this.Qlh);
    }
    AppMethodBeat.o(267313);
    return locali;
  }
  
  public final void dvg()
  {
    AppMethodBeat.i(164031);
    if (!this.Qld.getFtsEditText().bGw.hasFocus())
    {
      this.Qld.getFtsEditText().aDU();
      showVKB();
    }
    AppMethodBeat.o(164031);
  }
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(80612);
    if (paramBoolean) {
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80589);
          if (FTSBaseWebViewUI.this.PvJ != null) {
            FTSBaseWebViewUI.this.PvJ.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.had(), 0);
          }
          AppMethodBeat.o(80589);
        }
      });
    }
    AppMethodBeat.o(80612);
  }
  
  public final void gYI()
  {
    AppMethodBeat.i(80618);
    haj();
    AppMethodBeat.o(80618);
  }
  
  public final int gYO()
  {
    return c.h.actionbar_icon_dark_back;
  }
  
  public final boolean gYP()
  {
    return false;
  }
  
  public final boolean gYZ()
  {
    return true;
  }
  
  public final boolean gZe()
  {
    return false;
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
    String str = this.Qld.getFtsEditText().getInEditTextQuery();
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
    String str = this.Qld.getFtsEditText().getTotalQuery();
    AppMethodBeat.o(80605);
    return str;
  }
  
  protected final int getType()
  {
    return this.type;
  }
  
  protected final e hac()
  {
    return this.Qkx;
  }
  
  public final JSONArray had()
  {
    AppMethodBeat.i(80615);
    Object localObject = this.Qld.getFtsEditText().getTagList();
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
    AppMethodBeat.o(80615);
    return localJSONArray;
  }
  
  protected final WebSearchView hak()
  {
    return this.Qld;
  }
  
  public void o(final int paramInt, final Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(80616);
    Object localObject1;
    switch (paramInt)
    {
    default: 
      super.o(paramInt, paramBundle);
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
        btS().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80591);
            if (FTSBaseWebViewUI.this.PvJ != null) {
              FTSBaseWebViewUI.this.PvJ.bP(this.quj);
            }
            AppMethodBeat.o(80591);
          }
        });
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        localObject2 = paramBundle.getString("fts_key_req_id");
        final boolean bool1 = paramBundle.getBoolean("fts_key_new_query", true);
        aJ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80592);
            if (FTSBaseWebViewUI.this.PvJ != null)
            {
              if ((this.MXK != null) && (this.MXK.getInt("isRefresh") == 1) && (this.MXK.getString("widgetId") != null))
              {
                FTSBaseWebViewUI.this.PvJ.mv(this.MXK.getString("widgetId"), this.qYf);
                AppMethodBeat.o(80592);
                return;
              }
              FTSBaseWebViewUI.this.PvJ.i(this.qYf, bool1, this.PLs);
            }
            AppMethodBeat.o(80592);
          }
        });
        AppMethodBeat.o(80616);
        return;
        paramInt = paramBundle.getInt("fts_key_ret", 0);
        paramBundle = paramBundle.getString("fts_key_data");
        btS().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80593);
            if (FTSBaseWebViewUI.this.PvJ != null) {
              FTSBaseWebViewUI.this.PvJ.cQ(paramInt, paramBundle);
            }
            AppMethodBeat.o(80593);
          }
        });
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        aJ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80582);
            if (FTSBaseWebViewUI.this.PvJ != null) {
              FTSBaseWebViewUI.this.PvJ.z(this.QkG, this.qYf, this.qYg);
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
              locala.LtE = localJSONObject.getString("tagName");
              locala.aRY = localJSONObject.getInt("tagType");
              locala.userName = localJSONObject.getString("userName");
              paramBundle.add(locala);
              paramInt += 1;
            }
          }
          if (this.Qld == null) {}
        }
        catch (Exception localException)
        {
          if (this.Qld != null)
          {
            if (paramBundle.size() <= 0) {
              break label663;
            }
            this.Qld.getFtsEditText().O((String)localObject2, paramBundle);
            if (bool2) {
              atv((String)localObject2);
            }
          }
          while (bool1)
          {
            btS().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80583);
                if (FTSBaseWebViewUI.this.PvJ != null) {
                  FTSBaseWebViewUI.this.PvJ.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.had(), 0);
                }
                AppMethodBeat.o(80583);
              }
            });
            if (this.Qld != null) {
              this.Qld.getFtsEditText().aDU();
            }
            gZf();
            AppMethodBeat.o(80616);
            return;
            this.Qld.getFtsEditText().O((String)localObject1, paramBundle);
            if (bool2) {
              atv((String)localObject1);
            }
          }
        }
      }
      this.Qld.getFtsEditText().bGw.clearFocus();
      hah();
      AppMethodBeat.o(80616);
      return;
    case 124: 
      paramBundle = paramBundle.getString("fts_key_json_data");
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80584);
          if (FTSBaseWebViewUI.this.PvJ != null) {
            FTSBaseWebViewUI.this.PvJ.biX(paramBundle);
          }
          AppMethodBeat.o(80584);
        }
      });
      AppMethodBeat.o(80616);
      return;
    case 125: 
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80585);
          if (FTSBaseWebViewUI.this.PvJ != null) {
            FTSBaseWebViewUI.this.PvJ.gY(this.QkH, paramInt);
          }
          AppMethodBeat.o(80585);
        }
      });
      AppMethodBeat.o(80616);
      return;
    case 60: 
      this.Qkx.c(paramBundle, this.scene);
      AppMethodBeat.o(80616);
      return;
    case 100001: 
      this.Qkx.bf(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 61: 
      this.Qkx.bg(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 62: 
      this.Qkx.bh(paramBundle);
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
    btS().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80586);
        if (FTSBaseWebViewUI.this.PvJ != null)
        {
          FTSBaseWebViewUI.this.PvJ.a(paramInt, l, this.tvn);
          Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), this.tvn });
        }
        AppMethodBeat.o(80586);
      }
    });
    AppMethodBeat.o(80616);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(267315);
    if (haj()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(267315);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(80607);
    haj();
    AppMethodBeat.o(80607);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(80619);
    this.Qld.getFtsEditText().O("", null);
    btS().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(251522);
        if (FTSBaseWebViewUI.this.PvJ != null) {
          FTSBaseWebViewUI.this.PvJ.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.had(), 1);
        }
        AppMethodBeat.o(251522);
      }
    });
    this.Qld.getFtsEditText().bGw.clearFocus();
    hideVKB();
    AppMethodBeat.o(80619);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80613);
    if (this.Qld != null)
    {
      if (!this.Qld.getFtsEditText().bGw.hasFocus())
      {
        this.Qld.getFtsEditText().aDU();
        showVKB();
      }
      this.Qld.getFtsEditText().setHint(getHint());
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
    this.Qky = new com.tencent.mm.plugin.webview.fts.d.a(this.pHS);
    this.Qkx = new e(((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.f.class)).a(getContext(), this.Qky));
    paramBundle = Util.nullAs(getIntent().getStringExtra("ftsQuery"), "").trim();
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.Qle = getIntent().getBooleanExtra("ftscaneditable", true);
    this.Qlf = getIntent().getBooleanExtra("key_hide_cancel_btn", false);
    if (this.pHS != null) {
      this.pHS.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(80581);
          FTSBaseWebViewUI.this.hideVKB();
          FTSBaseWebViewUI.this.hai();
          AppMethodBeat.o(80581);
          return false;
        }
      });
    }
    this.Qld = ((WebSearchView)findViewById(c.f.websearchview));
    this.wWQ = findViewById(c.f.title_container);
    if (this.Qle)
    {
      this.wWQ.setVisibility(8);
      this.Qld.setSearchViewListener(this);
      this.Qld.getFtsEditText().setHint(getHint());
      this.Qld.getFtsEditText().setFtsEditTextListener(this);
      if (this.Qlf) {
        this.Qld.getCancelBtn().setVisibility(8);
      }
      if (!Util.isNullOrNil(paramBundle))
      {
        this.Qld.getFtsEditText().O(paramBundle, null);
        atv(paramBundle);
      }
      if (this.QjP)
      {
        this.Qld.getFtsEditText().aDU();
        this.Qld.getFtsEditText().aDT();
      }
      if (getIntent().getBooleanExtra("key_change_search_icon", false))
      {
        this.Qld.getSearchIcon().setVisibility(8);
        this.Qld.getFtsEditText().hXP();
        this.Qld.getFtsEditText().getIconView().setImageDrawable(aoJ(this.type));
      }
    }
    for (;;)
    {
      showOptionMenu(false);
      if (this.QgG != null) {
        this.QgG.Dc(true);
      }
      if (this.pHS != null) {
        this.pHS.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(258278);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(258278);
            return true;
          }
        });
      }
      this.Qky.PvJ = this.PvJ;
      AppMethodBeat.o(80602);
      return;
      this.Qld.setVisibility(8);
      paramBundle = getIntent().getStringExtra("title");
      if (!Util.isNullOrNil(paramBundle)) {
        ((TextView)findViewById(c.f.back_title_tv)).setText(paramBundle);
      }
      findViewById(c.f.back_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(265454);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FTSBaseWebViewUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(265454);
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80617);
    try
    {
      if (this.pGC != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.pGC.y(1, localBundle);
      }
      this.Qkx.onDestroy();
    }
    catch (RemoteException localRemoteException)
    {
      label51:
      break label51;
    }
    hideVKB();
    this.PIQ.b(this.Qlh);
    this.PIQ.b(this.Qlh.Qlj);
    super.onDestroy();
    AppMethodBeat.o(80617);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80610);
    super.onPause();
    this.Qkx.onPause();
    AppMethodBeat.o(80610);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80609);
    super.onResume();
    this.Qkx.onResume();
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
    String LtE;
    int aRY;
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
      int i = this.LtE.compareTo(paramObject.LtE);
      AppMethodBeat.o(80594);
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
    a Qlj;
    
    private b()
    {
      AppMethodBeat.i(239854);
      this.Qlj = new a((byte)0);
      AppMethodBeat.o(239854);
    }
    
    private static WebResourceResponse bjb(String paramString)
    {
      AppMethodBeat.i(239863);
      Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      paramString = Uri.parse(paramString);
      try
      {
        paramString = u.Tf(paramString.getQueryParameter("path"));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/*", "utf8", paramString);
          AppMethodBeat.o(239863);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        AppMethodBeat.o(239863);
      }
      return null;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(239862);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
      {
        paramWebView = bjb(paramWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(239862);
        return paramWebView;
      }
      AppMethodBeat.o(239862);
      return null;
    }
    
    public final com.tencent.mm.plugin.webview.core.f gTb()
    {
      return this.Qlj;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.f
    {
      private a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(244305);
        if ((paramString2 != null) && (paramString2.equals(FTSBaseWebViewUI.this.cDu()))) {
          ar.lr(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 16);
        }
        AppMethodBeat.o(244305);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(244302);
        Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageFinished %s", new Object[] { paramString });
        FTSBaseWebViewUI.this.showOptionMenu(false);
        if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this) != null) && (!FTSBaseWebViewUI.this.QjP))
        {
          FTSBaseWebViewUI.c(FTSBaseWebViewUI.this).getFtsEditText().bGw.clearFocus();
          FTSBaseWebViewUI.this.hideVKB();
        }
        AppMethodBeat.o(244302);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(244303);
        Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageStarted %s", new Object[] { paramString });
        FTSBaseWebViewUI.this.showOptionMenu(false);
        if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this) != null) && (!FTSBaseWebViewUI.this.QjP))
        {
          FTSBaseWebViewUI.c(FTSBaseWebViewUI.this).getFtsEditText().bGw.clearFocus();
          FTSBaseWebViewUI.this.hideVKB();
        }
        ar.lr(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 1);
        ar.ls(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 1);
        AppMethodBeat.o(244303);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */