package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
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
  protected com.tencent.mm.plugin.fts.ui.widget.a mWO;
  int scene;
  int type;
  private e vjC;
  private com.tencent.mm.plugin.webview.fts.d.a vjD;
  private boolean vjb;
  private boolean vkf;
  
  private void cJO()
  {
    AppMethodBeat.i(8407);
    hideVKB();
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(8407);
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(8414);
    ab.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.naZ) || (paramb == FTSEditTextView.b.nba)) {
      this.handler.post(new FTSBaseWebViewUI.8(this));
    }
    AppMethodBeat.o(8414);
  }
  
  public void aMf()
  {
    AppMethodBeat.i(8406);
    super.aMf();
    String str = bo.bf(getIntent().getStringExtra("ftsQuery"), "").trim();
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.vjb = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.vkf = getIntent().getBooleanExtra("ftscaneditable", true);
    this.pOd.setWebViewClient(new FTSBaseWebViewUI.b(this, (byte)0));
    this.pOd.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(8384);
        FTSBaseWebViewUI.this.hideVKB();
        AppMethodBeat.o(8384);
        return false;
      }
    });
    if (this.vkf)
    {
      this.mWO = dd(this);
      if (this.mWO == null) {
        this.mWO = new com.tencent.mm.plugin.fts.ui.widget.a(this);
      }
      this.mWO.setSearchViewListener(this);
      this.mWO.getFtsEditText().setHint(getHint());
      this.mWO.getFtsEditText().setFtsEditTextListener(this);
      getSupportActionBar().setCustomView(this.mWO);
      if (!bo.isNullOrNil(str)) {
        this.mWO.getFtsEditText().o(str, null);
      }
      if (this.vjb)
      {
        this.mWO.getFtsEditText().bDf();
        this.mWO.getFtsEditText().bDe();
      }
    }
    showOptionMenu(false);
    if (this.vgh != null) {
      this.vgh.op(true);
    }
    this.pOd.setOnLongClickListener(new FTSBaseWebViewUI.7(this));
    this.vjD.uQS = this.uQS;
    AppMethodBeat.o(8406);
  }
  
  public boolean aMm()
  {
    AppMethodBeat.i(8417);
    ab.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onSearchKeyDown");
    if (getTotalQuery().length() > 0)
    {
      this.handler.post(new FTSBaseWebViewUI.10(this));
      hideVKB();
    }
    AppMethodBeat.o(8417);
    return false;
  }
  
  public final boolean aYR()
  {
    return false;
  }
  
  public final void aZy()
  {
    AppMethodBeat.i(8421);
    cJO();
    AppMethodBeat.o(8421);
  }
  
  public final void bCE()
  {
    AppMethodBeat.i(8411);
    if (!this.mWO.getFtsEditText().naN.hasFocus())
    {
      this.mWO.getFtsEditText().bDf();
      showVKB();
    }
    AppMethodBeat.o(8411);
  }
  
  protected com.tencent.mm.plugin.fts.ui.widget.a dd(Context paramContext)
  {
    return null;
  }
  
  public final int dep()
  {
    return 2131230737;
  }
  
  public final boolean deq()
  {
    return false;
  }
  
  public final boolean dez()
  {
    return true;
  }
  
  protected final e dfB()
  {
    return this.vjC;
  }
  
  public final JSONArray dfD()
  {
    AppMethodBeat.i(8418);
    Object localObject = this.mWO.getFtsEditText().getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FTSBaseWebViewUI.a locala = (FTSBaseWebViewUI.a)((Iterator)localObject).next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tagName", locala.smP);
        localJSONObject.put("tagType", locala.aBY);
        localJSONObject.put("userName", locala.userName);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(8418);
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
    AppMethodBeat.i(8409);
    String str = this.mWO.getFtsEditText().getInEditTextQuery();
    AppMethodBeat.o(8409);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2130969683;
  }
  
  protected final String getTotalQuery()
  {
    AppMethodBeat.i(8408);
    String str = this.mWO.getFtsEditText().getTotalQuery();
    AppMethodBeat.o(8408);
    return str;
  }
  
  public final void hQ(boolean paramBoolean)
  {
    AppMethodBeat.i(8415);
    if (paramBoolean) {
      this.handler.post(new FTSBaseWebViewUI.9(this));
    }
    AppMethodBeat.o(8415);
  }
  
  public void l(final int paramInt, Bundle paramBundle)
  {
    final int i = 0;
    AppMethodBeat.i(8419);
    Object localObject1;
    switch (paramInt)
    {
    default: 
      super.l(paramInt, paramBundle);
    case 128: 
    case 119: 
    case 120: 
    case 121: 
    case 122: 
      for (;;)
      {
        AppMethodBeat.o(8419);
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
        this.handler.post(new FTSBaseWebViewUI.11(this, (Map)localObject1));
        AppMethodBeat.o(8419);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        localObject2 = paramBundle.getString("fts_key_req_id");
        boolean bool = paramBundle.getBoolean("fts_key_new_query", true);
        paramBundle = paramBundle.getBundle("fts_key_data");
        this.handler.post(new FTSBaseWebViewUI.12(this, paramBundle, (String)localObject1, bool, (String)localObject2));
        AppMethodBeat.o(8419);
        return;
        paramInt = paramBundle.getInt("fts_key_ret", 0);
        paramBundle = paramBundle.getString("fts_key_data");
        this.handler.post(new FTSBaseWebViewUI.13(this, paramInt, paramBundle));
        AppMethodBeat.o(8419);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
        i = paramBundle.getInt("fts_key_is_cache_data", 0);
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(8396);
            if (FTSBaseWebViewUI.this.uQS != null) {
              FTSBaseWebViewUI.this.uQS.p(paramInt, this.iOH, i);
            }
            AppMethodBeat.o(8396);
          }
        });
        AppMethodBeat.o(8419);
        return;
        localObject1 = paramBundle.getString("fts_key_new_query");
        localObject2 = paramBundle.getString("fts_key_custom_query");
        bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
        Object localObject3 = paramBundle.getString("fts_key_tag_list");
        ab.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
        paramBundle = new ArrayList();
        try
        {
          if (!bo.isNullOrNil((String)localObject3))
          {
            localObject3 = new JSONArray((String)localObject3);
            paramInt = i;
            while (paramInt < ((JSONArray)localObject3).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject3).getJSONObject(paramInt);
              FTSBaseWebViewUI.a locala = new FTSBaseWebViewUI.a(this);
              locala.smP = localJSONObject.getString("tagName");
              locala.aBY = localJSONObject.getInt("tagType");
              locala.userName = localJSONObject.getString("userName");
              paramBundle.add(locala);
              paramInt += 1;
            }
          }
          if (this.mWO == null) {}
        }
        catch (Exception localException)
        {
          if (this.mWO != null)
          {
            if (paramBundle.size() <= 0) {
              break label656;
            }
            this.mWO.getFtsEditText().o((String)localObject2, paramBundle);
          }
          while (bool)
          {
            this.handler.post(new FTSBaseWebViewUI.2(this));
            if (this.mWO != null) {
              this.mWO.getFtsEditText().bDf();
            }
            deG();
            AppMethodBeat.o(8419);
            return;
            this.mWO.getFtsEditText().o((String)localObject1, paramBundle);
          }
        }
      }
      this.mWO.getFtsEditText().naN.clearFocus();
      hideVKB();
      AppMethodBeat.o(8419);
      return;
    case 124: 
      paramBundle = paramBundle.getString("fts_key_json_data");
      this.handler.post(new FTSBaseWebViewUI.3(this, paramBundle));
      AppMethodBeat.o(8419);
      return;
    case 125: 
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      this.handler.post(new FTSBaseWebViewUI.4(this, (String)localObject1, paramInt));
      AppMethodBeat.o(8419);
      return;
    case 60: 
      this.vjC.b(paramBundle, this.scene);
      AppMethodBeat.o(8419);
      return;
    case 100001: 
      this.vjC.ar(paramBundle);
      AppMethodBeat.o(8419);
      return;
    case 61: 
      this.vjC.as(paramBundle);
      AppMethodBeat.o(8419);
      return;
    case 62: 
      this.vjC.at(paramBundle);
      AppMethodBeat.o(8419);
      return;
    case 144: 
      label656:
      AppMethodBeat.o(8419);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    this.handler.post(new FTSBaseWebViewUI.5(this, paramInt, l, paramBundle));
    AppMethodBeat.o(8419);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(8410);
    cJO();
    AppMethodBeat.o(8410);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(8422);
    this.mWO.getFtsEditText().o("", null);
    this.handler.post(new FTSBaseWebViewUI.6(this));
    this.mWO.getFtsEditText().naN.clearFocus();
    hideVKB();
    AppMethodBeat.o(8422);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(8416);
    if (this.mWO != null)
    {
      if (!this.mWO.getFtsEditText().naN.hasFocus())
      {
        this.mWO.getFtsEditText().bDf();
        showVKB();
      }
      this.mWO.getFtsEditText().setHint(getHint());
    }
    AppMethodBeat.o(8416);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(8405);
    super.onCreate(paramBundle);
    this.vjD = new com.tencent.mm.plugin.webview.fts.d.a(this.pOd);
    this.vjC = new e(((h)g.E(h.class)).a(getContext(), this.vjD));
    setActionbarColor(getContext().getResources().getColor(2131690316));
    AppMethodBeat.o(8405);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(8420);
    try
    {
      if (this.igU != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.igU.r(1, localBundle);
      }
      this.vjC.onDestroy();
    }
    catch (RemoteException localRemoteException)
    {
      label51:
      break label51;
    }
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(8420);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(8413);
    super.onPause();
    this.vjC.onPause();
    AppMethodBeat.o(8413);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(8412);
    super.onResume();
    this.vjC.onResume();
    AppMethodBeat.o(8412);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */