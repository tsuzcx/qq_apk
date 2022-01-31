package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
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

public class BaseSOSWebViewUI
  extends BaseSearchWebViewUI
  implements FTSEditTextView.a
{
  protected ImageButton pbT;
  protected View qFP;
  private List<BaseSOSWebViewUI.c> vjA;
  protected int vjB = 0;
  private e vjC;
  private com.tencent.mm.plugin.webview.fts.d.a vjD;
  boolean vjE;
  boolean vjF;
  private boolean vjb;
  View vjy;
  protected SOSEditTextView vjz;
  
  public final String KH(int paramInt)
  {
    AppMethodBeat.i(8378);
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "educationTab");
      Object localObject2 = this.igU.s(2, (Bundle)localObject1);
      localObject1 = ((Bundle)localObject2).getString("result");
      localObject2 = ((Bundle)localObject2).getString("result_1");
      if (localObject2 == null) {}
      for (;;)
      {
        localObject1 = new JSONObject((String)localObject1).optJSONArray("items");
        if (localObject1 != null) {
          break;
        }
        AppMethodBeat.o(8378);
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
          AppMethodBeat.o(8378);
          return localObject1;
        }
        i += 1;
      }
      return "";
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(8378);
    }
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(8366);
    ab.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.naZ) || (paramb == FTSEditTextView.b.nba))
    {
      this.handler.post(new BaseSOSWebViewUI.18(this));
      AppMethodBeat.o(8366);
      return;
    }
    if (paramb == FTSEditTextView.b.nbb)
    {
      if (this.vjz.naN.hasFocus())
      {
        this.vjz.bDk();
        AppMethodBeat.o(8366);
        return;
      }
      this.vjz.bDj();
    }
    AppMethodBeat.o(8366);
  }
  
  public void aMf()
  {
    AppMethodBeat.i(8360);
    super.aMf();
    this.vjb = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.vjy = findViewById(2131828195);
    this.vjz = ((SOSEditTextView)findViewById(2131828197));
    this.vjz.setFtsEditTextListener(this);
    this.vjz.setHint(getHint());
    this.qFP = findViewById(2131822887);
    this.qFP.setOnClickListener(new BaseSOSWebViewUI.1(this));
    this.pbT = ((ImageButton)findViewById(2131826460));
    this.pbT.setOnClickListener(new BaseSOSWebViewUI.12(this));
    this.pOd.setWebViewClient(new BaseSOSWebViewUI.b(this, (byte)0));
    this.pOd.setOnTouchListener(new BaseSOSWebViewUI.13(this));
    if (this.vjb) {
      getContentView().postDelayed(new BaseSOSWebViewUI.14(this), 128L);
    }
    if (this.vgh != null) {
      this.vgh.op(true);
    }
    this.pOd.setOnLongClickListener(new BaseSOSWebViewUI.15(this));
    this.vjD.uQS = this.uQS;
    AppMethodBeat.o(8360);
  }
  
  public boolean aMm()
  {
    AppMethodBeat.i(8369);
    this.vjz.naN.clearFocus();
    hideVKB();
    if (getTotalQuery().length() > 0)
    {
      this.handler.post(new BaseSOSWebViewUI.2(this));
      hideVKB();
      this.vjE = true;
      AppMethodBeat.o(8369);
      return true;
    }
    AppMethodBeat.o(8369);
    return true;
  }
  
  public final boolean aYR()
  {
    return false;
  }
  
  public final void aZy()
  {
    AppMethodBeat.i(8370);
    cJO();
    AppMethodBeat.o(8370);
  }
  
  protected final void b(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(8377);
    ab.v("MicroMsg.WebSearch.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[] { Integer.valueOf(paramInt), paramString, paramMap });
    int i = this.vjX;
    this.vjX = paramInt;
    if (i != paramInt) {
      dfv();
    }
    if (this.vjA == null) {
      this.vjA = new ArrayList();
    }
    BaseSOSWebViewUI.c localc1;
    BaseSOSWebViewUI.c localc2;
    if (getTotalQuery().length() > 0)
    {
      localc1 = new BaseSOSWebViewUI.c(this);
      localc1.type = this.vjX;
      localc1.lbK = new ArrayList(this.vjz.getTagList());
      localc1.vjP = this.vjz.getInEditTextQuery();
      localc1.vjO = this.vjz.getTotalQuery();
      if (this.vjA.size() == 0) {
        this.vjA.add(localc1);
      }
    }
    else if ((this.vjA != null) && (!this.vjA.isEmpty()))
    {
      localc1 = (BaseSOSWebViewUI.c)this.vjA.get(0);
      localc2 = new BaseSOSWebViewUI.c(this);
      localc2.type = paramInt;
      localc2.vjO = paramString;
      localc2.vjQ = paramMap;
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
        localc1.vjQ = paramMap;
      }
      AppMethodBeat.o(8377);
      return;
      if (localc1.equals((BaseSOSWebViewUI.c)this.vjA.get(0))) {
        break;
      }
      this.vjA.add(0, localc1);
      break;
      label297:
      paramString = (BaseSOSWebViewUI.c)localc2;
      if ((paramString.type == localc1.type) && (paramString.vjO.trim().equals(localc1.vjO.trim()))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void bCE()
  {
    AppMethodBeat.i(8365);
    if (!this.vjz.naN.hasFocus())
    {
      this.vjz.bDf();
      showVKB();
    }
    AppMethodBeat.o(8365);
  }
  
  protected final void cJO()
  {
    AppMethodBeat.i(8363);
    hideVKB();
    dfI();
    if ((this.vjA != null) && (this.vjA.size() > 1))
    {
      this.vjA.remove(0);
      BaseSOSWebViewUI.c localc = (BaseSOSWebViewUI.c)this.vjA.get(0);
      this.vjz.o(localc.vjP, localc.lbK);
      this.handler.post(new BaseSOSWebViewUI.16(this, localc));
      AppMethodBeat.o(8363);
      return;
    }
    if (this.vjE)
    {
      dfw();
      AppMethodBeat.o(8363);
      return;
    }
    finish();
    AppMethodBeat.o(8363);
  }
  
  public final boolean deq()
  {
    return false;
  }
  
  public final boolean dez()
  {
    return true;
  }
  
  public final SOSEditTextView dfA()
  {
    return this.vjz;
  }
  
  protected final e dfB()
  {
    return this.vjC;
  }
  
  protected final int dfC()
  {
    return this.vjX;
  }
  
  public final JSONArray dfD()
  {
    AppMethodBeat.i(8375);
    Object localObject = this.vjz.getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseSOSWebViewUI.a locala = (BaseSOSWebViewUI.a)((Iterator)localObject).next();
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
    AppMethodBeat.o(8375);
    return localJSONArray;
  }
  
  public boolean dfE()
  {
    return false;
  }
  
  protected boolean dfF()
  {
    return true;
  }
  
  protected void dfu() {}
  
  protected void dfv() {}
  
  protected void dfw()
  {
    AppMethodBeat.i(8364);
    this.vjz.o("", null);
    hideVKB();
    this.handler.post(new BaseSOSWebViewUI.17(this));
    this.vjA = null;
    this.vjE = false;
    this.vjC.onDestroy();
    AppMethodBeat.o(8364);
  }
  
  protected void dfx() {}
  
  protected String dfy()
  {
    return "";
  }
  
  protected int dfz()
  {
    return 0;
  }
  
  protected String getHint()
  {
    return null;
  }
  
  protected final String getInEditTextQuery()
  {
    AppMethodBeat.i(8374);
    String str = this.vjz.getInEditTextQuery();
    AppMethodBeat.o(8374);
    return str;
  }
  
  protected final int getScene()
  {
    return this.scene;
  }
  
  public final String getSessionId()
  {
    return this.cpW;
  }
  
  protected final String getTotalQuery()
  {
    AppMethodBeat.i(8373);
    if (this.vjz != null)
    {
      String str = this.vjz.getTotalQuery();
      AppMethodBeat.o(8373);
      return str;
    }
    AppMethodBeat.o(8373);
    return "";
  }
  
  protected final int getType()
  {
    return this.type;
  }
  
  public void hQ(boolean paramBoolean)
  {
    AppMethodBeat.i(8367);
    if ((paramBoolean) && (!bo.isNullOrNil(getTotalQuery()))) {
      this.handler.post(new BaseSOSWebViewUI.19(this));
    }
    AppMethodBeat.o(8367);
  }
  
  public void l(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(8372);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    switch (paramInt)
    {
    default: 
      super.l(paramInt, paramBundle);
      AppMethodBeat.o(8372);
      return;
    case 128: 
      paramBundle.getString("fts_key_json_data");
      paramBundle.getBoolean("fts_key_new_query", true);
      localObject1 = new HashMap();
      localObject2 = paramBundle.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        ((Map)localObject1).put(localObject3, paramBundle.get((String)localObject3));
      }
      this.handler.post(new BaseSOSWebViewUI.3(this, (Map)localObject1));
      AppMethodBeat.o(8372);
      return;
    case 119: 
      localObject1 = paramBundle.getString("fts_key_json_data");
      localObject2 = paramBundle.getString("fts_key_req_id");
      bool = paramBundle.getBoolean("fts_key_new_query", true);
      paramBundle = paramBundle.getBundle("fts_key_data");
      this.handler.post(new BaseSOSWebViewUI.4(this, paramBundle, (String)localObject1, bool, (String)localObject2));
      AppMethodBeat.o(8372);
      return;
    case 143: 
      paramBundle = paramBundle.getString("data");
      this.handler.post(new BaseSOSWebViewUI.5(this, paramBundle));
      AppMethodBeat.o(8372);
      return;
    case 120: 
      paramInt = paramBundle.getInt("fts_key_ret", 0);
      paramBundle = paramBundle.getString("fts_key_data");
      this.handler.post(new BaseSOSWebViewUI.6(this, paramInt, paramBundle));
      AppMethodBeat.o(8372);
      return;
    case 121: 
      localObject1 = paramBundle.getString("fts_key_json_data");
      paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
      i = paramBundle.getInt("fts_key_is_cache_data", 0);
      this.handler.post(new BaseSOSWebViewUI.7(this, paramInt, (String)localObject1, i));
      AppMethodBeat.o(8372);
      return;
    case 122: 
      localObject1 = paramBundle.getString("fts_key_new_query");
      localObject2 = paramBundle.getString("fts_key_custom_query");
      bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
      localObject3 = paramBundle.getString("fts_key_tag_list");
      ab.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
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
            BaseSOSWebViewUI.a locala = new BaseSOSWebViewUI.a(this);
            locala.smP = localJSONObject.getString("tagName");
            locala.aBY = localJSONObject.getInt("tagType");
            locala.userName = localJSONObject.getString("userName");
            paramBundle.add(locala);
            paramInt += 1;
          }
        }
        paramBundle = paramBundle.getString("fts_key_json_data");
      }
      catch (Exception localException)
      {
        if (this.vjz != null)
        {
          if (paramBundle.size() > 0) {
            this.vjz.o((String)localObject2, paramBundle);
          }
        }
        else
        {
          if (!bool) {
            break label723;
          }
          this.handler.post(new BaseSOSWebViewUI.8(this));
          if (this.vjz != null) {
            this.vjz.bDf();
          }
          deG();
        }
        for (;;)
        {
          com.tencent.mm.plugin.webview.fts.b.a.a.daG();
          com.tencent.mm.plugin.webview.fts.b.a.a.agL(getTotalQuery());
          AppMethodBeat.o(8372);
          return;
          this.vjz.o((String)localObject1, paramBundle);
          break;
          if (this.vjz != null) {
            this.vjz.naN.clearFocus();
          }
        }
      }
    case 124: 
      this.handler.post(new BaseSOSWebViewUI.9(this, paramBundle));
      AppMethodBeat.o(8372);
      return;
    case 125: 
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      this.handler.post(new BaseSOSWebViewUI.10(this, (String)localObject1, paramInt));
      AppMethodBeat.o(8372);
      return;
    case 60: 
      if (!dfF())
      {
        ab.w("MicroMsg.WebSearch.BaseSOSWebViewUI", "current state is not search");
        AppMethodBeat.o(8372);
        return;
      }
      this.vjC.b(paramBundle, this.scene);
      AppMethodBeat.o(8372);
      return;
    case 100001: 
      this.vjC.ar(paramBundle);
      AppMethodBeat.o(8372);
      return;
    case 61: 
      this.vjC.as(paramBundle);
      AppMethodBeat.o(8372);
      return;
    case 62: 
      this.vjC.at(paramBundle);
      AppMethodBeat.o(8372);
      return;
    case 138: 
      paramBundle = paramBundle.getString("fts_key_data");
      if (!bo.isNullOrNil(paramBundle))
      {
        if ("index".equals(paramBundle))
        {
          this.vjB = 1;
          AppMethodBeat.o(8372);
          return;
        }
        if ("result".equals(paramBundle))
        {
          this.vjB = 2;
          AppMethodBeat.o(8372);
          return;
        }
        if ("suggestion".equals(paramBundle))
        {
          this.vjB = 3;
          AppMethodBeat.o(8372);
          return;
        }
        if ("teach".equals(paramBundle))
        {
          this.vjB = 4;
          AppMethodBeat.o(8372);
          return;
        }
        if ("local".equals(paramBundle))
        {
          this.vjB = 5;
          AppMethodBeat.o(8372);
          return;
        }
        this.vjB = 0;
        AppMethodBeat.o(8372);
        return;
      }
      this.vjB = 0;
      AppMethodBeat.o(8372);
      return;
    case 144: 
      label723:
      AppMethodBeat.o(8372);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    this.handler.post(new BaseSOSWebViewUI.11(this, paramInt, l, paramBundle));
    AppMethodBeat.o(8372);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(8376);
    cJO();
    AppMethodBeat.o(8376);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(8368);
    if (this.vjz != null)
    {
      if (!this.vjz.naN.hasFocus())
      {
        this.vjz.bDf();
        showVKB();
      }
      this.vjz.setHint(getHint());
    }
    AppMethodBeat.o(8368);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(8359);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    this.vjD = new com.tencent.mm.plugin.webview.fts.d.a(this.pOd);
    this.vjC = new e(((h)g.E(h.class)).a(getContext(), this.vjD));
    AppMethodBeat.o(8359);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(8371);
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
    AppMethodBeat.o(8371);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(8362);
    super.onPause();
    this.vjC.onPause();
    AppMethodBeat.o(8362);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(8361);
    super.onResume();
    this.vjC.onResume();
    AppMethodBeat.o(8361);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
 * JD-Core Version:    0.7.0.1
 */