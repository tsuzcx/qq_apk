package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.fts.d.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.search.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
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
  private boolean EfM;
  protected WebSearchView EgI;
  private boolean EgJ;
  private boolean EgK;
  private LinkedList<String> EgL;
  private e Egf;
  private a Egg;
  int scene;
  int type;
  private View yJh;
  
  public FTSBaseWebViewUI()
  {
    AppMethodBeat.i(208180);
    this.EgL = new LinkedList();
    AppMethodBeat.o(208180);
  }
  
  private void aaF(String paramString)
  {
    AppMethodBeat.i(208186);
    this.EgL.remove(paramString);
    this.EgL.add(paramString);
    AppMethodBeat.o(208186);
  }
  
  private boolean eTX()
  {
    AppMethodBeat.i(208182);
    if (this.EgL.size() <= 1)
    {
      hideVKB();
      finish();
      AppMethodBeat.o(208182);
      return true;
    }
    this.EgL.removeLast();
    String str = (String)this.EgL.getLast();
    this.EgI.getFtsEditText().H(str, null);
    this.EgI.getFtsEditText().vr.clearFocus();
    hideVKB();
    eTY();
    AppMethodBeat.o(208182);
    return false;
  }
  
  private void eTY()
  {
    AppMethodBeat.i(208184);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80590);
        int i;
        String str1;
        String str2;
        if (FTSBaseWebViewUI.this.DzP != null)
        {
          FTSBaseWebViewUI.this.DzP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eTS(), 0, null);
          if (!TextUtils.isEmpty(FTSBaseWebViewUI.this.getInEditTextQuery()))
          {
            i = FTSBaseWebViewUI.a(FTSBaseWebViewUI.this);
            str1 = FTSBaseWebViewUI.this.sessionId;
            str2 = FTSBaseWebViewUI.this.dCW;
            if (FTSBaseWebViewUI.this.EgA != 0) {
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
    AppMethodBeat.o(208184);
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164032);
    ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.KCC) || (paramb == FTSEditTextView.b.KCD)) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80588);
          if (FTSBaseWebViewUI.this.DzP != null) {
            FTSBaseWebViewUI.this.DzP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eTS(), 0);
          }
          AppMethodBeat.o(80588);
        }
      });
    }
    AppMethodBeat.o(164032);
  }
  
  public final h bRd()
  {
    AppMethodBeat.i(208181);
    h localh = super.bRd();
    if (localh != null) {
      localh.a(new FTSBaseWebViewUI.b(this, (byte)0));
    }
    AppMethodBeat.o(208181);
    return localh;
  }
  
  public void bzn()
  {
    AppMethodBeat.i(80603);
    super.bzn();
    String str = bt.bI(getIntent().getStringExtra("ftsQuery"), "").trim();
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.EfM = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.EgJ = getIntent().getBooleanExtra("ftscaneditable", true);
    this.EgK = getIntent().getBooleanExtra("key_hide_cancel_btn", false);
    if (this.omW != null) {
      this.omW.setOnTouchListener(new FTSBaseWebViewUI.1(this));
    }
    this.EgI = ((WebSearchView)findViewById(2131308228));
    this.yJh = findViewById(2131305918);
    if (this.EgJ)
    {
      this.yJh.setVisibility(8);
      this.EgI.setSearchViewListener(this);
      this.EgI.getFtsEditText().setHint(getHint());
      this.EgI.getFtsEditText().setFtsEditTextListener(this);
      if (this.EgK) {
        this.EgI.getCancelBtn().setVisibility(8);
      }
      if (!bt.isNullOrNil(str))
      {
        this.EgI.getFtsEditText().H(str, null);
        aaF(str);
      }
      if (this.EfM)
      {
        this.EgI.getFtsEditText().fJS();
        this.EgI.getFtsEditText().fJR();
      }
      if (getIntent().getBooleanExtra("key_change_search_icon", false))
      {
        this.EgI.getSearchIcon().setVisibility(8);
        this.EgI.getFtsEditText().fJU();
        this.EgI.getFtsEditText().getIconView().setImageDrawable(XD(this.type));
      }
    }
    for (;;)
    {
      showOptionMenu(false);
      if (this.Een != null) {
        this.Een.ve(true);
      }
      if (this.omW != null) {
        this.omW.setOnLongClickListener(new FTSBaseWebViewUI.9(this));
      }
      this.Egg.DzP = this.DzP;
      AppMethodBeat.o(80603);
      return;
      this.EgI.setVisibility(8);
      str = getIntent().getStringExtra("title");
      if (!bt.isNullOrNil(str)) {
        ((TextView)findViewById(2131300055)).setText(str);
      }
      findViewById(2131297026).setOnClickListener(new FTSBaseWebViewUI.8(this));
    }
  }
  
  public boolean bzz()
  {
    AppMethodBeat.i(80614);
    ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onSearchKeyDown");
    if (getTotalQuery().length() > 0)
    {
      aaF(getTotalQuery());
      eTY();
      hideVKB();
    }
    AppMethodBeat.o(80614);
    return false;
  }
  
  public final void cED()
  {
    AppMethodBeat.i(164031);
    if (!this.EgI.getFtsEditText().vr.hasFocus())
    {
      this.EgI.getFtsEditText().fJS();
      showVKB();
    }
    AppMethodBeat.o(164031);
  }
  
  protected final void d(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(221648);
    aaF(paramString);
    AppMethodBeat.o(221648);
  }
  
  public final void eSO()
  {
    AppMethodBeat.i(80618);
    eTX();
    AppMethodBeat.o(80618);
  }
  
  public final int eSS()
  {
    return 2131689490;
  }
  
  public final boolean eST()
  {
    return false;
  }
  
  protected final e eTR()
  {
    return this.Egf;
  }
  
  public final JSONArray eTS()
  {
    AppMethodBeat.i(80615);
    Object localObject = this.EgI.getFtsEditText().getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tagName", locala.ACS);
        localJSONObject.put("tagType", locala.bix);
        localJSONObject.put("userName", locala.userName);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(80615);
    return localJSONArray;
  }
  
  public final boolean eTd()
  {
    return true;
  }
  
  public final boolean eTi()
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
    String str = this.EgI.getFtsEditText().getInEditTextQuery();
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
    String str = this.EgI.getFtsEditText().getTotalQuery();
    AppMethodBeat.o(80605);
    return str;
  }
  
  public final void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(80612);
    if (paramBoolean) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80589);
          if (FTSBaseWebViewUI.this.DzP != null) {
            FTSBaseWebViewUI.this.DzP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eTS(), 0);
          }
          AppMethodBeat.o(80589);
        }
      });
    }
    AppMethodBeat.o(80612);
  }
  
  public void n(int paramInt, Bundle paramBundle)
  {
    int i = 0;
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
        this.handler.post(new FTSBaseWebViewUI.13(this, (Map)localObject1));
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        localObject2 = paramBundle.getString("fts_key_req_id");
        boolean bool1 = paramBundle.getBoolean("fts_key_new_query", true);
        paramBundle = paramBundle.getBundle("fts_key_data");
        this.handler.post(new FTSBaseWebViewUI.14(this, paramBundle, (String)localObject1, bool1, (String)localObject2));
        AppMethodBeat.o(80616);
        return;
        paramInt = paramBundle.getInt("fts_key_ret", 0);
        paramBundle = paramBundle.getString("fts_key_data");
        this.handler.post(new FTSBaseWebViewUI.15(this, paramInt, paramBundle));
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
        i = paramBundle.getInt("fts_key_is_cache_data", 0);
        this.handler.post(new FTSBaseWebViewUI.2(this, paramInt, (String)localObject1, i));
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_new_query");
        localObject2 = paramBundle.getString("fts_key_custom_query");
        bool1 = paramBundle.getBoolean("fts_key_need_keyboard", false);
        Object localObject3 = paramBundle.getString("fts_key_tag_list");
        boolean bool2 = paramBundle.getBoolean("fts_key_cache", false);
        ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool1) });
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
              locala.ACS = localJSONObject.getString("tagName");
              locala.bix = localJSONObject.getInt("tagType");
              locala.userName = localJSONObject.getString("userName");
              paramBundle.add(locala);
              paramInt += 1;
            }
          }
          if (this.EgI == null) {}
        }
        catch (Exception localException)
        {
          if (this.EgI != null)
          {
            if (paramBundle.size() <= 0) {
              break label677;
            }
            this.EgI.getFtsEditText().H((String)localObject2, paramBundle);
            if (bool2) {
              aaF((String)localObject2);
            }
          }
          while (bool1)
          {
            this.handler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80583);
                if (FTSBaseWebViewUI.this.DzP != null) {
                  FTSBaseWebViewUI.this.DzP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eTS(), 0);
                }
                AppMethodBeat.o(80583);
              }
            });
            if (this.EgI != null) {
              this.EgI.getFtsEditText().fJS();
            }
            eTj();
            AppMethodBeat.o(80616);
            return;
            this.EgI.getFtsEditText().H((String)localObject1, paramBundle);
            if (bool2) {
              aaF((String)localObject1);
            }
          }
        }
      }
      this.EgI.getFtsEditText().vr.clearFocus();
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
      this.Egf.c(paramBundle, this.scene);
      AppMethodBeat.o(80616);
      return;
    case 100001: 
      this.Egf.aU(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 61: 
      this.Egf.aV(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 62: 
      this.Egf.aW(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 144: 
      label677:
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
    AppMethodBeat.i(208183);
    if (eTX()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(208183);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(80607);
    eTX();
    AppMethodBeat.o(80607);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(80619);
    this.EgI.getFtsEditText().H("", null);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208171);
        if (FTSBaseWebViewUI.this.DzP != null) {
          FTSBaseWebViewUI.this.DzP.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eTS(), 1);
        }
        AppMethodBeat.o(208171);
      }
    });
    this.EgI.getFtsEditText().vr.clearFocus();
    hideVKB();
    AppMethodBeat.o(80619);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80613);
    if (this.EgI != null)
    {
      if (!this.EgI.getFtsEditText().vr.hasFocus())
      {
        this.EgI.getFtsEditText().fJS();
        showVKB();
      }
      this.EgI.getFtsEditText().setHint(getHint());
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
    this.Egg = new a(this.omW);
    this.Egf = new e(((com.tencent.mm.plugin.websearch.api.f)g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(getContext(), this.Egg));
    setActionbarColor(getContext().getResources().getColor(2131099648));
    AppMethodBeat.o(80602);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80617);
    try
    {
      if (this.lvv != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.lvv.x(1, localBundle);
      }
      this.Egf.onDestroy();
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
    this.Egf.onPause();
    AppMethodBeat.o(80610);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80609);
    super.onResume();
    this.Egf.onResume();
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
    String ACS;
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
      int i = this.ACS.compareTo(paramObject.ACS);
      AppMethodBeat.o(80594);
      return i;
    }
    
    public final String getTagName()
    {
      return this.ACS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */