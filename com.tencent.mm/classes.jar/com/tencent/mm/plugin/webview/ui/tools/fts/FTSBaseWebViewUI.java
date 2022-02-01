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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.o;
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
  implements FTSEditTextView.a, com.tencent.mm.ui.search.b
{
  private boolean ExP;
  protected WebSearchView EyL;
  private boolean EyM;
  private boolean EyN;
  private LinkedList<String> EyO;
  private e Eyi;
  private com.tencent.mm.plugin.webview.fts.d.a Eyj;
  int scene;
  int type;
  private View yZr;
  
  public FTSBaseWebViewUI()
  {
    AppMethodBeat.i(198359);
    this.EyO = new LinkedList();
    AppMethodBeat.o(198359);
  }
  
  private void abw(String paramString)
  {
    AppMethodBeat.i(198365);
    this.EyO.remove(paramString);
    this.EyO.add(paramString);
    AppMethodBeat.o(198365);
  }
  
  private boolean eXK()
  {
    AppMethodBeat.i(198361);
    if (this.EyO.size() <= 1)
    {
      hideVKB();
      finish();
      AppMethodBeat.o(198361);
      return true;
    }
    this.EyO.removeLast();
    String str = (String)this.EyO.getLast();
    this.EyL.getFtsEditText().I(str, null);
    this.EyL.getFtsEditText().vr.clearFocus();
    hideVKB();
    eXL();
    AppMethodBeat.o(198361);
    return false;
  }
  
  private void eXL()
  {
    AppMethodBeat.i(198363);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80590);
        int i;
        String str1;
        String str2;
        if (FTSBaseWebViewUI.this.DRx != null)
        {
          FTSBaseWebViewUI.this.DRx.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eXF(), 0, null);
          if (!TextUtils.isEmpty(FTSBaseWebViewUI.this.getInEditTextQuery()))
          {
            i = FTSBaseWebViewUI.a(FTSBaseWebViewUI.this);
            str1 = FTSBaseWebViewUI.this.sessionId;
            str2 = FTSBaseWebViewUI.this.dEb;
            if (FTSBaseWebViewUI.this.EyD != 0) {
              break label126;
            }
          }
        }
        label126:
        for (boolean bool = true;; bool = false)
        {
          ac.a(i, str1, str2, bool, FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.b(FTSBaseWebViewUI.this));
          AppMethodBeat.o(80590);
          return;
        }
      }
    });
    AppMethodBeat.o(198363);
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164032);
    ae.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.KYW) || (paramb == FTSEditTextView.b.KYX)) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80588);
          if (FTSBaseWebViewUI.this.DRx != null) {
            FTSBaseWebViewUI.this.DRx.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eXF(), 0);
          }
          AppMethodBeat.o(80588);
        }
      });
    }
    AppMethodBeat.o(164032);
  }
  
  public void bAi()
  {
    AppMethodBeat.i(80603);
    super.bAi();
    String str = bu.bI(getIntent().getStringExtra("ftsQuery"), "").trim();
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.ExP = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.EyM = getIntent().getBooleanExtra("ftscaneditable", true);
    this.EyN = getIntent().getBooleanExtra("key_hide_cancel_btn", false);
    if (this.osM != null) {
      this.osM.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(80581);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          FTSBaseWebViewUI.this.hideVKB();
          FTSBaseWebViewUI.this.eXJ();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(80581);
          return false;
        }
      });
    }
    this.EyL = ((WebSearchView)findViewById(2131308228));
    this.yZr = findViewById(2131305918);
    if (this.EyM)
    {
      this.yZr.setVisibility(8);
      this.EyL.setSearchViewListener(this);
      this.EyL.getFtsEditText().setHint(getHint());
      this.EyL.getFtsEditText().setFtsEditTextListener(this);
      if (this.EyN) {
        this.EyL.getCancelBtn().setVisibility(8);
      }
      if (!bu.isNullOrNil(str))
      {
        this.EyL.getFtsEditText().I(str, null);
        abw(str);
      }
      if (this.ExP)
      {
        this.EyL.getFtsEditText().fOj();
        this.EyL.getFtsEditText().fOi();
      }
      if (getIntent().getBooleanExtra("key_change_search_icon", false))
      {
        this.EyL.getSearchIcon().setVisibility(8);
        this.EyL.getFtsEditText().fOl();
        this.EyL.getFtsEditText().getIconView().setImageDrawable(Yj(this.type));
      }
    }
    for (;;)
    {
      showOptionMenu(false);
      if (this.Ewp != null) {
        this.Ewp.vm(true);
      }
      if (this.osM != null) {
        this.osM.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198352);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(198352);
            return true;
          }
        });
      }
      this.Eyj.DRx = this.DRx;
      AppMethodBeat.o(80603);
      return;
      this.EyL.setVisibility(8);
      str = getIntent().getStringExtra("title");
      if (!bu.isNullOrNil(str)) {
        ((TextView)findViewById(2131300055)).setText(str);
      }
      findViewById(2131297026).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198351);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          FTSBaseWebViewUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198351);
        }
      });
    }
  }
  
  public boolean bAu()
  {
    AppMethodBeat.i(80614);
    ae.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onSearchKeyDown");
    if (getTotalQuery().length() > 0)
    {
      abw(getTotalQuery());
      eXL();
      hideVKB();
    }
    AppMethodBeat.o(80614);
    return false;
  }
  
  public final h bSe()
  {
    AppMethodBeat.i(198360);
    h localh = super.bSe();
    if (localh != null) {
      localh.a(new b((byte)0));
    }
    AppMethodBeat.o(198360);
    return localh;
  }
  
  public final void cGz()
  {
    AppMethodBeat.i(164031);
    if (!this.EyL.getFtsEditText().vr.hasFocus())
    {
      this.EyL.getFtsEditText().fOj();
      showVKB();
    }
    AppMethodBeat.o(164031);
  }
  
  protected final void d(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(224331);
    abw(paramString);
    AppMethodBeat.o(224331);
  }
  
  public final void eWA()
  {
    AppMethodBeat.i(80618);
    eXK();
    AppMethodBeat.o(80618);
  }
  
  public final int eWF()
  {
    return 2131689490;
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
  
  protected final e eXE()
  {
    return this.Eyi;
  }
  
  public final JSONArray eXF()
  {
    AppMethodBeat.i(80615);
    Object localObject = this.EyL.getFtsEditText().getTagList();
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
    String str = this.EyL.getFtsEditText().getInEditTextQuery();
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
    String str = this.EyL.getFtsEditText().getTotalQuery();
    AppMethodBeat.o(80605);
    return str;
  }
  
  public final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(80612);
    if (paramBoolean) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80589);
          if (FTSBaseWebViewUI.this.DRx != null) {
            FTSBaseWebViewUI.this.DRx.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eXF(), 0);
          }
          AppMethodBeat.o(80589);
        }
      });
    }
    AppMethodBeat.o(80612);
  }
  
  public void n(final int paramInt, final Bundle paramBundle)
  {
    final int i = 0;
    AppMethodBeat.i(80616);
    Object localObject1;
    switch (paramInt)
    {
    default: 
      super.n(paramInt, paramBundle);
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
            AppMethodBeat.i(80591);
            if (FTSBaseWebViewUI.this.DRx != null) {
              FTSBaseWebViewUI.this.DRx.bG(this.mhV);
            }
            AppMethodBeat.o(80591);
          }
        });
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        localObject2 = paramBundle.getString("fts_key_req_id");
        final boolean bool1 = paramBundle.getBoolean("fts_key_new_query", true);
        paramBundle = paramBundle.getBundle("fts_key_data");
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80592);
            if (FTSBaseWebViewUI.this.DRx != null)
            {
              if ((paramBundle != null) && (paramBundle.getInt("isRefresh") == 1) && (paramBundle.getString("widgetId") != null))
              {
                FTSBaseWebViewUI.this.DRx.kW(paramBundle.getString("widgetId"), this.mJE);
                AppMethodBeat.o(80592);
                return;
              }
              FTSBaseWebViewUI.this.DRx.j(this.mJE, bool1, this.EcE);
            }
            AppMethodBeat.o(80592);
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
            AppMethodBeat.i(80593);
            if (FTSBaseWebViewUI.this.DRx != null) {
              FTSBaseWebViewUI.this.DRx.cz(paramInt, paramBundle);
            }
            AppMethodBeat.o(80593);
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
            AppMethodBeat.i(80582);
            if (FTSBaseWebViewUI.this.DRx != null) {
              FTSBaseWebViewUI.this.DRx.v(paramInt, this.mJE, i);
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
        ae.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool1) });
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
          if (this.EyL == null) {}
        }
        catch (Exception localException)
        {
          if (this.EyL != null)
          {
            if (paramBundle.size() <= 0) {
              break label677;
            }
            this.EyL.getFtsEditText().I((String)localObject2, paramBundle);
            if (bool2) {
              abw((String)localObject2);
            }
          }
          while (bool1)
          {
            this.handler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80583);
                if (FTSBaseWebViewUI.this.DRx != null) {
                  FTSBaseWebViewUI.this.DRx.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eXF(), 0);
                }
                AppMethodBeat.o(80583);
              }
            });
            if (this.EyL != null) {
              this.EyL.getFtsEditText().fOj();
            }
            eWW();
            AppMethodBeat.o(80616);
            return;
            this.EyL.getFtsEditText().I((String)localObject1, paramBundle);
            if (bool2) {
              abw((String)localObject1);
            }
          }
        }
      }
      this.EyL.getFtsEditText().vr.clearFocus();
      hideVKB();
      AppMethodBeat.o(80616);
      return;
    case 124: 
      paramBundle = paramBundle.getString("fts_key_json_data");
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80584);
          if (FTSBaseWebViewUI.this.DRx != null) {
            FTSBaseWebViewUI.this.DRx.aIf(paramBundle);
          }
          AppMethodBeat.o(80584);
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
          AppMethodBeat.i(80585);
          if (FTSBaseWebViewUI.this.DRx != null) {
            FTSBaseWebViewUI.this.DRx.fT(this.Eyq, paramInt);
          }
          AppMethodBeat.o(80585);
        }
      });
      AppMethodBeat.o(80616);
      return;
    case 60: 
      this.Eyi.c(paramBundle, this.scene);
      AppMethodBeat.o(80616);
      return;
    case 100001: 
      this.Eyi.aV(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 61: 
      this.Eyi.aW(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 62: 
      this.Eyi.aX(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 144: 
      label677:
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
        AppMethodBeat.i(80586);
        if (FTSBaseWebViewUI.this.DRx != null)
        {
          FTSBaseWebViewUI.this.DRx.a(paramInt, l, this.oLD);
          ae.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), this.oLD });
        }
        AppMethodBeat.o(80586);
      }
    });
    AppMethodBeat.o(80616);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(198362);
    if (eXK()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(198362);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(80607);
    eXK();
    AppMethodBeat.o(80607);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(80619);
    this.EyL.getFtsEditText().I("", null);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198350);
        if (FTSBaseWebViewUI.this.DRx != null) {
          FTSBaseWebViewUI.this.DRx.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eXF(), 1);
        }
        AppMethodBeat.o(198350);
      }
    });
    this.EyL.getFtsEditText().vr.clearFocus();
    hideVKB();
    AppMethodBeat.o(80619);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80613);
    if (this.EyL != null)
    {
      if (!this.EyL.getFtsEditText().vr.hasFocus())
      {
        this.EyL.getFtsEditText().fOj();
        showVKB();
      }
      this.EyL.getFtsEditText().setHint(getHint());
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
    this.Eyj = new com.tencent.mm.plugin.webview.fts.d.a(this.osM);
    this.Eyi = new e(((com.tencent.mm.plugin.websearch.api.f)g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(getContext(), this.Eyj));
    AppMethodBeat.o(80602);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80617);
    try
    {
      if (this.lzT != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.lzT.x(1, localBundle);
      }
      this.Eyi.onDestroy();
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
    this.Eyi.onPause();
    AppMethodBeat.o(80610);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80609);
    super.onResume();
    this.Eyi.onResume();
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
    String AUt;
    int bix;
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
      int i = this.AUt.compareTo(paramObject.AUt);
      AppMethodBeat.o(80594);
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
      AppMethodBeat.i(198358);
      ae.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      paramString = Uri.parse(paramString);
      try
      {
        paramString = o.openRead(paramString.getQueryParameter("path"));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/*", "utf8", paramString);
          AppMethodBeat.o(198358);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        AppMethodBeat.o(198358);
      }
      return null;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(198357);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
      {
        paramWebView = aKp(paramWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(198357);
        return paramWebView;
      }
      AppMethodBeat.o(198357);
      return null;
    }
    
    public final com.tencent.mm.plugin.webview.core.e eRA()
    {
      AppMethodBeat.i(198356);
      a locala = new a((byte)0);
      AppMethodBeat.o(198356);
      return locala;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.e
    {
      private a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(198355);
        if ((paramString2 != null) && (paramString2.equals(FTSBaseWebViewUI.this.bRn()))) {
          am.iV(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 16);
        }
        AppMethodBeat.o(198355);
      }
      
      public final void aHE(String paramString)
      {
        AppMethodBeat.i(198354);
        ae.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageStarted %s", new Object[] { paramString });
        FTSBaseWebViewUI.this.showOptionMenu(false);
        if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.this)))
        {
          FTSBaseWebViewUI.c(FTSBaseWebViewUI.this).getFtsEditText().vr.clearFocus();
          FTSBaseWebViewUI.this.hideVKB();
        }
        am.iV(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 1);
        am.iW(FTSBaseWebViewUI.a(FTSBaseWebViewUI.this), 1);
        AppMethodBeat.o(198354);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(198353);
        ae.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageFinished %s", new Object[] { paramString });
        FTSBaseWebViewUI.this.showOptionMenu(false);
        if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.this) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.this)))
        {
          FTSBaseWebViewUI.c(FTSBaseWebViewUI.this).getFtsEditText().vr.clearFocus();
          FTSBaseWebViewUI.this.hideVKB();
        }
        AppMethodBeat.o(198353);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */