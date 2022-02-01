package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
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
  boolean CCA;
  private boolean CCf;
  View CCt;
  protected SOSEditTextView CCu;
  private List<c> CCv;
  protected int CCw = 0;
  private e CCx;
  private com.tencent.mm.plugin.webview.fts.d.a CCy;
  boolean CCz;
  protected boolean Had = false;
  protected View ucS;
  
  public final String VM(int paramInt)
  {
    AppMethodBeat.i(80571);
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "educationTab");
      Object localObject2 = this.kYt.t(2, (Bundle)localObject1);
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
    ac.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.ILv) || (paramb == FTSEditTextView.b.ILw))
    {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80541);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eEZ());
          }
          AppMethodBeat.o(80541);
        }
      });
      AppMethodBeat.o(164030);
      return;
    }
    if (paramb == FTSEditTextView.b.ILx)
    {
      if (this.CCu.ty.hasFocus())
      {
        this.CCu.fti();
        AppMethodBeat.o(164030);
        return;
      }
      this.CCu.fth();
    }
    AppMethodBeat.o(164030);
  }
  
  public final h bMD()
  {
    AppMethodBeat.i(188512);
    h localh = super.bMD();
    if (localh != null) {
      localh.a(new BaseSOSWebViewUI.b(this, (byte)0));
    }
    AppMethodBeat.o(188512);
    return localh;
  }
  
  public void bvh()
  {
    AppMethodBeat.i(80553);
    super.bvh();
    this.CCf = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.CCt = findViewById(2131304427);
    this.CCu = ((SOSEditTextView)findViewById(2131305115));
    this.CCu.setFtsEditTextListener(this);
    this.CCu.setHint(getHint());
    this.CCu.setCancelTextViewClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80524);
        BaseSOSWebViewUI.this.eET();
        AppMethodBeat.o(80524);
      }
    });
    this.ucS = findViewById(2131297026);
    this.ucS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80535);
        BaseSOSWebViewUI.this.edR();
        AppMethodBeat.o(80535);
      }
    });
    this.nKq.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80536);
        BaseSOSWebViewUI.this.eEX().getEditText().clearFocus();
        BaseSOSWebViewUI.this.hideVKB();
        AppMethodBeat.o(80536);
        return false;
      }
    });
    if (this.CCf) {
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80537);
          BaseSOSWebViewUI.this.eEX().fte();
          BaseSOSWebViewUI.this.eEX().ftd();
          AppMethodBeat.o(80537);
        }
      }, 128L);
    }
    if (this.CAF != null) {
      this.CAF.ut(true);
    }
    this.nKq.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        return true;
      }
    });
    this.CCy = new com.tencent.mm.plugin.webview.fts.d.a(this.nKq);
    this.CCy.Cjc = this.Cjc;
    this.CCx = new e(((com.tencent.mm.plugin.websearch.api.e)g.ab(com.tencent.mm.plugin.websearch.api.e.class)).a(getContext(), this.CCy));
    AppMethodBeat.o(80553);
  }
  
  public boolean bvs()
  {
    AppMethodBeat.i(80562);
    this.CCu.ty.clearFocus();
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
            if (BaseSOSWebViewUI.this.eEW() != 0)
            {
              localHashMap1.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.eEW()));
              localHashMap1.put("sugId", BaseSOSWebViewUI.this.eEV());
            }
            f localf = BaseSOSWebViewUI.this.getJsapi();
            String str1 = BaseSOSWebViewUI.this.getTotalQuery();
            String str2 = BaseSOSWebViewUI.this.getInEditTextQuery();
            JSONArray localJSONArray = BaseSOSWebViewUI.this.eEZ();
            HashMap localHashMap2 = new HashMap();
            localHashMap2.putAll(localHashMap1);
            localHashMap2.put("query", str1);
            localHashMap2.put("custom", str2);
            localHashMap2.put("tagList", localJSONArray);
            localf.b("onSearchInputConfirm", localHashMap2, null);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              y.a(BaseSOSWebViewUI.this.CCQ, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.drf, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.CCR);
            }
          }
          AppMethodBeat.o(80525);
        }
      });
      hideVKB();
      this.CCz = true;
      AppMethodBeat.o(80562);
      return true;
    }
    AppMethodBeat.o(80562);
    return true;
  }
  
  protected final void c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(80570);
    ac.v("MicroMsg.WebSearch.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[] { Integer.valueOf(paramInt), paramString, paramMap });
    int i = this.CCR;
    this.CCR = paramInt;
    if (i != paramInt) {
      eES();
    }
    if (this.CCv == null) {
      this.CCv = new ArrayList();
    }
    c localc1;
    c localc2;
    if (getTotalQuery().length() > 0)
    {
      localc1 = new c();
      localc1.type = this.CCR;
      localc1.oMl = new ArrayList(this.CCu.getTagList());
      localc1.CCK = this.CCu.getInEditTextQuery();
      localc1.CCJ = this.CCu.getTotalQuery();
      if (this.CCv.size() == 0) {
        this.CCv.add(localc1);
      }
    }
    else if ((this.CCv != null) && (!this.CCv.isEmpty()))
    {
      localc1 = (c)this.CCv.get(0);
      localc2 = new c();
      localc2.type = paramInt;
      localc2.CCJ = paramString;
      localc2.CCL = paramMap;
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
        localc1.CCL = paramMap;
      }
      AppMethodBeat.o(80570);
      return;
      if (localc1.equals((c)this.CCv.get(0))) {
        break;
      }
      this.CCv.add(0, localc1);
      break;
      label297:
      paramString = (c)localc2;
      if ((paramString.type == localc1.type) && (paramString.CCJ.trim().equals(localc1.CCJ.trim()))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  protected final int cvi()
  {
    return this.CCR;
  }
  
  public final void cxG()
  {
    AppMethodBeat.i(164029);
    if (!this.CCu.ty.hasFocus())
    {
      this.CCu.fte();
      showVKB();
    }
    AppMethodBeat.o(164029);
  }
  
  public final void eDW()
  {
    AppMethodBeat.i(80563);
    edR();
    AppMethodBeat.o(80563);
  }
  
  protected void eER() {}
  
  protected void eES() {}
  
  protected void eET()
  {
    AppMethodBeat.i(80557);
    this.CCu.F("", null);
    hideVKB();
    this.Had = true;
    this.handler.post(new BaseSOSWebViewUI.17(this));
    this.CCv = null;
    this.CCz = false;
    if (this.CCx != null) {
      this.CCx.onDestroy();
    }
    AppMethodBeat.o(80557);
  }
  
  protected void eEU()
  {
    AppMethodBeat.i(210073);
    ac.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageLoaded %b", new Object[] { Boolean.valueOf(this.Ckh) });
    AppMethodBeat.o(210073);
  }
  
  protected String eEV()
  {
    return "";
  }
  
  protected int eEW()
  {
    return 0;
  }
  
  public final SOSEditTextView eEX()
  {
    return this.CCu;
  }
  
  protected final e eEY()
  {
    return this.CCx;
  }
  
  public final JSONArray eEZ()
  {
    AppMethodBeat.i(80568);
    Object localObject = this.CCu.getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tagName", locala.zkN);
        localJSONObject.put("tagType", locala.aYc);
        localJSONObject.put("userName", locala.userName);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(80568);
    return localJSONArray;
  }
  
  public final boolean eEb()
  {
    return false;
  }
  
  public final boolean eEl()
  {
    return true;
  }
  
  public final boolean eEq()
  {
    return false;
  }
  
  public boolean eFa()
  {
    return false;
  }
  
  protected boolean eFb()
  {
    return true;
  }
  
  protected final void edR()
  {
    AppMethodBeat.i(80556);
    hideVKB();
    eFd();
    if ((this.CCv != null) && (this.CCv.size() > 1))
    {
      this.CCv.remove(0);
      final c localc = (c)this.CCv.get(0);
      this.CCu.F(localc.CCK, localc.oMl);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80538);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            BaseSOSWebViewUI.this.eER();
            BaseSOSWebViewUI.this.CCR = localc.type;
            BaseSOSWebViewUI.this.eES();
            HashMap localHashMap = new HashMap();
            localHashMap.put("isBackButtonClick", "1");
            localHashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eEZ(), 1, localc.CCL);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              y.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.drf, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
            }
          }
          AppMethodBeat.o(80538);
        }
      });
      AppMethodBeat.o(80556);
      return;
    }
    if (this.CCz)
    {
      eET();
      AppMethodBeat.o(80556);
      return;
    }
    finish();
    AppMethodBeat.o(80556);
  }
  
  protected void fdd() {}
  
  protected String getHint()
  {
    return null;
  }
  
  protected final String getInEditTextQuery()
  {
    AppMethodBeat.i(80567);
    String str = this.CCu.getInEditTextQuery();
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
    if (this.CCu != null)
    {
      String str = this.CCu.getTotalQuery();
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
  
  public void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(80560);
    if ((paramBoolean) && (!bs.isNullOrNil(getTotalQuery()))) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80542);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eEZ());
          }
          AppMethodBeat.o(80542);
        }
      });
    }
    AppMethodBeat.o(80560);
  }
  
  public void n(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(80565);
    switch (paramInt)
    {
    default: 
      super.n(paramInt, paramBundle);
    case 126: 
    case 119: 
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
              boolean bool = paramBundle.getBoolean("fts_key_new_query", true);
              paramBundle = paramBundle.getBundle("fts_key_data");
              this.handler.post(new BaseSOSWebViewUI.4(this, paramBundle, (String)localObject1, bool, (String)localObject2));
              AppMethodBeat.o(80565);
              return;
              paramBundle = paramBundle.getString("data");
              this.handler.post(new BaseSOSWebViewUI.5(this, paramBundle));
              AppMethodBeat.o(80565);
              return;
              paramInt = paramBundle.getInt("fts_key_ret", 0);
              paramBundle = paramBundle.getString("fts_key_data");
              this.handler.post(new BaseSOSWebViewUI.6(this, paramInt, paramBundle));
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_json_data");
              paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
              i = paramBundle.getInt("fts_key_is_cache_data", 0);
              this.handler.post(new BaseSOSWebViewUI.7(this, paramInt, (String)localObject1, i));
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_new_query");
              localObject2 = paramBundle.getString("fts_key_custom_query");
              bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
              Object localObject3 = paramBundle.getString("fts_key_tag_list");
              ac.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
              paramBundle = new ArrayList();
              try
              {
                if (!bs.isNullOrNil((String)localObject3))
                {
                  localObject3 = new JSONArray((String)localObject3);
                  paramInt = i;
                  while (paramInt < ((JSONArray)localObject3).length())
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject3).getJSONObject(paramInt);
                    a locala = new a();
                    locala.zkN = localJSONObject.getString("tagName");
                    locala.aYc = localJSONObject.getInt("tagType");
                    locala.userName = localJSONObject.getString("userName");
                    paramBundle.add(locala);
                    paramInt += 1;
                  }
                }
                paramBundle = paramBundle.getString("fts_key_json_data");
              }
              catch (Exception localException)
              {
                if (this.CCu != null)
                {
                  if (paramBundle.size() > 0) {
                    this.CCu.F((String)localObject2, paramBundle);
                  }
                }
                else
                {
                  if (!bool) {
                    break label723;
                  }
                  this.handler.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(80531);
                      if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eEZ());
                      }
                      AppMethodBeat.o(80531);
                    }
                  });
                  if (this.CCu != null) {
                    this.CCu.fte();
                  }
                  eEr();
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.fts.b.a.a.ezu();
                  com.tencent.mm.plugin.webview.fts.b.a.a.aBh(getTotalQuery());
                  AppMethodBeat.o(80565);
                  return;
                  this.CCu.F((String)localObject1, paramBundle);
                  break;
                  if (this.CCu != null) {
                    this.CCu.ty.clearFocus();
                  }
                }
              }
              this.handler.post(new BaseSOSWebViewUI.9(this, paramBundle));
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_sns_id");
              paramInt = paramBundle.getInt("fts_key_status", 0);
              this.handler.post(new BaseSOSWebViewUI.10(this, (String)localObject1, paramInt));
              AppMethodBeat.o(80565);
              return;
              if (!eFb())
              {
                ac.w("MicroMsg.WebSearch.BaseSOSWebViewUI", "current state is not search");
                AppMethodBeat.o(80565);
                return;
              }
            } while (this.CCx == null);
            this.CCx.b(paramBundle, this.scene);
            AppMethodBeat.o(80565);
            return;
          } while (this.CCx == null);
          this.CCx.aP(paramBundle);
          AppMethodBeat.o(80565);
          return;
        } while (this.CCx == null);
        this.CCx.aQ(paramBundle);
        AppMethodBeat.o(80565);
        return;
      } while (this.CCx == null);
      this.CCx.aR(paramBundle);
      AppMethodBeat.o(80565);
      return;
    case 138: 
      paramBundle = paramBundle.getString("fts_key_data");
      if (!bs.isNullOrNil(paramBundle))
      {
        if ("index".equals(paramBundle))
        {
          this.CCw = 1;
          AppMethodBeat.o(80565);
          return;
        }
        if ("result".equals(paramBundle))
        {
          this.CCw = 2;
          AppMethodBeat.o(80565);
          return;
        }
        if ("suggestion".equals(paramBundle))
        {
          this.CCw = 3;
          AppMethodBeat.o(80565);
          return;
        }
        if ("teach".equals(paramBundle))
        {
          this.CCw = 4;
          AppMethodBeat.o(80565);
          return;
        }
        if ("local".equals(paramBundle))
        {
          this.CCw = 5;
          AppMethodBeat.o(80565);
          return;
        }
        this.CCw = 0;
        AppMethodBeat.o(80565);
        return;
      }
      this.CCw = 0;
      AppMethodBeat.o(80565);
      return;
    case 144: 
      label723:
      AppMethodBeat.o(80565);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    this.handler.post(new BaseSOSWebViewUI.11(this, paramInt, l, paramBundle));
    AppMethodBeat.o(80565);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80569);
    edR();
    AppMethodBeat.o(80569);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80561);
    if (this.CCu != null)
    {
      if (!this.CCu.ty.hasFocus())
      {
        this.CCu.fte();
        showVKB();
      }
      this.CCu.setHint(getHint());
    }
    AppMethodBeat.o(80561);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80552);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    AppMethodBeat.o(80552);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80564);
    try
    {
      if (this.kYt != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.kYt.w(1, localBundle);
      }
      if (this.CCx != null) {
        this.CCx.onDestroy();
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
    if (this.CCx != null) {
      this.CCx.onPause();
    }
    AppMethodBeat.o(80555);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80554);
    super.onResume();
    if (this.CCx != null) {
      this.CCx.onResume();
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
    int aYc;
    String userName;
    String zkN;
    
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
      int i = this.zkN.compareTo(paramObject.zkN);
      AppMethodBeat.o(80543);
      return i;
    }
    
    public final String getTagName()
    {
      return this.zkN;
    }
  }
  
  protected final class c
  {
    String CCJ;
    String CCK;
    Map<String, Object> CCL;
    List<a.c> oMl;
    int type;
    
    protected c()
    {
      AppMethodBeat.i(80550);
      this.CCJ = "";
      this.CCK = "";
      this.CCL = new HashMap();
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
        if ((paramObject.type == this.type) && (paramObject.CCK.equals(this.CCK)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
 * JD-Core Version:    0.7.0.1
 */