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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  private boolean EfM;
  View Ega;
  protected SOSEditTextView Egb;
  protected boolean Egc;
  private List<c> Egd;
  protected int Ege = 0;
  private e Egf;
  private com.tencent.mm.plugin.webview.fts.d.a Egg;
  boolean Egh;
  protected boolean Egi = false;
  boolean Egj;
  protected ImageView gSx;
  
  public final String XC(int paramInt)
  {
    AppMethodBeat.i(80571);
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "educationTab");
      Object localObject2 = this.lvv.v(2, (Bundle)localObject1);
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
    ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.KCC) || (paramb == FTSEditTextView.b.KCD))
    {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80541);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eTS());
          }
          AppMethodBeat.o(80541);
        }
      });
      AppMethodBeat.o(164030);
      return;
    }
    if (paramb == FTSEditTextView.b.KCE)
    {
      if (this.Egb.vr.hasFocus())
      {
        this.Egb.fJW();
        AppMethodBeat.o(164030);
        return;
      }
      this.Egb.fJV();
    }
    AppMethodBeat.o(164030);
  }
  
  public final h bRd()
  {
    AppMethodBeat.i(208162);
    h localh = super.bRd();
    if (localh != null) {
      localh.a(new BaseSOSWebViewUI.b(this, (byte)0));
    }
    AppMethodBeat.o(208162);
    return localh;
  }
  
  public void bzn()
  {
    AppMethodBeat.i(80553);
    super.bzn();
    this.EfM = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.Ega = findViewById(2131304427);
    this.Egb = ((SOSEditTextView)findViewById(2131305115));
    this.Egb.setFtsEditTextListener(this);
    this.Egb.setHint(getHint());
    this.Egb.setCancelTextViewClickListener(new BaseSOSWebViewUI.1(this));
    this.gSx = ((ImageView)findViewById(2131297026));
    this.gSx.setOnClickListener(new BaseSOSWebViewUI.12(this));
    this.omW.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80536);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        BaseSOSWebViewUI.this.eTQ().getEditText().clearFocus();
        BaseSOSWebViewUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(80536);
        return false;
      }
    });
    if (this.EfM) {
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80537);
          BaseSOSWebViewUI.this.eTQ().fJS();
          BaseSOSWebViewUI.this.eTQ().fJR();
          AppMethodBeat.o(80537);
        }
      }, 128L);
    }
    if (this.Een != null) {
      this.Een.ve(true);
    }
    this.omW.setOnLongClickListener(new BaseSOSWebViewUI.16(this));
    this.Egg = new com.tencent.mm.plugin.webview.fts.d.a(this.omW);
    this.Egg.DzP = this.DzP;
    this.Egf = new e(((com.tencent.mm.plugin.websearch.api.f)g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(getContext(), this.Egg));
    AppMethodBeat.o(80553);
  }
  
  public boolean bzz()
  {
    AppMethodBeat.i(80562);
    this.Egb.vr.clearFocus();
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
            if (BaseSOSWebViewUI.this.eTP() != 0)
            {
              localHashMap1.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.eTP()));
              localHashMap1.put("sugId", BaseSOSWebViewUI.this.eTO());
            }
            com.tencent.mm.plugin.webview.c.f localf = BaseSOSWebViewUI.this.getJsapi();
            String str1 = BaseSOSWebViewUI.this.getTotalQuery();
            String str2 = BaseSOSWebViewUI.this.getInEditTextQuery();
            JSONArray localJSONArray = BaseSOSWebViewUI.this.eTS();
            HashMap localHashMap2 = new HashMap();
            localHashMap2.putAll(localHashMap1);
            localHashMap2.put("query", str1);
            localHashMap2.put("custom", str2);
            localHashMap2.put("tagList", localJSONArray);
            localf.b("onSearchInputConfirm", localHashMap2, null);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ac.a(BaseSOSWebViewUI.this.Egz, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dCW, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.EgA);
            }
          }
          AppMethodBeat.o(80525);
        }
      });
      hideVKB();
      this.Egh = true;
      AppMethodBeat.o(80562);
      return true;
    }
    AppMethodBeat.o(80562);
    return true;
  }
  
  protected final int cBz()
  {
    return this.EgA;
  }
  
  public final void cED()
  {
    AppMethodBeat.i(164029);
    if (!this.Egb.vr.hasFocus())
    {
      this.Egb.fJS();
      showVKB();
    }
    AppMethodBeat.o(164029);
  }
  
  protected final void d(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(80570);
    ad.v("MicroMsg.WebSearch.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[] { Integer.valueOf(paramInt), paramString, paramMap });
    int i = this.EgA;
    this.EgA = paramInt;
    if (i != paramInt) {
      eTK();
    }
    if (this.Egd == null) {
      this.Egd = new ArrayList();
    }
    c localc1;
    c localc2;
    if (getTotalQuery().length() > 0)
    {
      localc1 = new c();
      localc1.type = this.EgA;
      localc1.ppT = new ArrayList(this.Egb.getTagList());
      localc1.Egt = this.Egb.getInEditTextQuery();
      localc1.Egs = this.Egb.getTotalQuery();
      if (this.Egd.size() == 0) {
        this.Egd.add(localc1);
      }
    }
    else if ((this.Egd != null) && (!this.Egd.isEmpty()))
    {
      localc1 = (c)this.Egd.get(0);
      localc2 = new c();
      localc2.type = paramInt;
      localc2.Egs = paramString;
      localc2.Egu = paramMap;
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
        localc1.Egu = paramMap;
      }
      AppMethodBeat.o(80570);
      return;
      if (localc1.equals((c)this.Egd.get(0))) {
        break;
      }
      this.Egd.add(0, localc1);
      break;
      label297:
      paramString = (c)localc2;
      if ((paramString.type == localc1.type) && (paramString.Egs.trim().equals(localc1.Egs.trim()))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void eSO()
  {
    AppMethodBeat.i(80563);
    eqj();
    AppMethodBeat.o(80563);
  }
  
  public final boolean eST()
  {
    return false;
  }
  
  protected void eTJ() {}
  
  protected void eTK() {}
  
  protected void eTL()
  {
    AppMethodBeat.i(80557);
    if (!this.Egc) {
      this.Egb.H("", null);
    }
    hideVKB();
    this.Egi = true;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80540);
        if (BaseSOSWebViewUI.this.getJsapi() != null) {
          BaseSOSWebViewUI.this.av(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80539);
              ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onClickCancelBtn js api run onSOSCancelButtonClick");
              com.tencent.mm.plugin.webview.c.f localf = BaseSOSWebViewUI.this.getJsapi();
              int i = BaseSOSWebViewUI.this.scene;
              HashMap localHashMap = new HashMap();
              localHashMap.put("isCancelButtonClick", Integer.valueOf(1));
              localHashMap.put("isInputChange", Integer.valueOf(1));
              localHashMap.put("scene", Integer.valueOf(i));
              localf.b("onSearchInputChange", localHashMap, null);
              BaseSOSWebViewUI.this.Egi = false;
              BaseSOSWebViewUI.this.eTM();
              AppMethodBeat.o(80539);
            }
          });
        }
        AppMethodBeat.o(80540);
      }
    });
    this.Egd = null;
    this.Egh = false;
    if (this.Egf != null) {
      this.Egf.onDestroy();
    }
    AppMethodBeat.o(80557);
  }
  
  protected void eTM() {}
  
  protected void eTN()
  {
    AppMethodBeat.i(208163);
    ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageLoaded %b", new Object[] { Boolean.valueOf(this.DNn) });
    AppMethodBeat.o(208163);
  }
  
  protected String eTO()
  {
    return "";
  }
  
  protected int eTP()
  {
    return 0;
  }
  
  public final SOSEditTextView eTQ()
  {
    return this.Egb;
  }
  
  protected final e eTR()
  {
    return this.Egf;
  }
  
  public final JSONArray eTS()
  {
    AppMethodBeat.i(80568);
    Object localObject = this.Egb.getTagList();
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
    AppMethodBeat.o(80568);
    return localJSONArray;
  }
  
  public boolean eTT()
  {
    return false;
  }
  
  protected boolean eTU()
  {
    return true;
  }
  
  public final boolean eTd()
  {
    return true;
  }
  
  public final boolean eTi()
  {
    return false;
  }
  
  protected final void eqj()
  {
    AppMethodBeat.i(80556);
    hideVKB();
    eTW();
    if ((this.Egd != null) && (this.Egd.size() > 1))
    {
      this.Egd.remove(0);
      final c localc = (c)this.Egd.get(0);
      this.Egb.H(localc.Egt, localc.ppT);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80538);
          if (BaseSOSWebViewUI.this.getJsapi() != null)
          {
            BaseSOSWebViewUI.this.eTJ();
            BaseSOSWebViewUI.this.EgA = localc.type;
            BaseSOSWebViewUI.this.eTK();
            HashMap localHashMap = new HashMap();
            localHashMap.put("isBackButtonClick", "1");
            localHashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eTS(), 1, localc.Egu);
            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
              ac.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dCW, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
            }
          }
          AppMethodBeat.o(80538);
        }
      });
      AppMethodBeat.o(80556);
      return;
    }
    if (this.Egh)
    {
      eTL();
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
    String str = this.Egb.getInEditTextQuery();
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
    if (this.Egb != null)
    {
      String str = this.Egb.getTotalQuery();
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
  
  public void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(80560);
    if ((paramBoolean) && (!bt.isNullOrNil(getTotalQuery()))) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80542);
          if (BaseSOSWebViewUI.this.getJsapi() != null) {
            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eTS());
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
              localObject1 = paramBundle.getString("fts_key_json_data");
              paramBundle = paramBundle.getString("fts_key_req_id");
              this.handler.post(new BaseSOSWebViewUI.5(this, (String)localObject1, paramBundle));
              AppMethodBeat.o(80565);
              return;
              paramBundle = paramBundle.getString("data");
              this.handler.post(new BaseSOSWebViewUI.6(this, paramBundle));
              AppMethodBeat.o(80565);
              return;
              paramInt = paramBundle.getInt("fts_key_ret", 0);
              paramBundle = paramBundle.getString("fts_key_data");
              this.handler.post(new BaseSOSWebViewUI.7(this, paramInt, paramBundle));
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_json_data");
              paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
              i = paramBundle.getInt("fts_key_is_cache_data", 0);
              this.handler.post(new BaseSOSWebViewUI.8(this, paramInt, (String)localObject1, i));
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_new_query");
              localObject2 = paramBundle.getString("fts_key_custom_query");
              bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
              Object localObject3 = paramBundle.getString("fts_key_tag_list");
              ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
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
                paramBundle = paramBundle.getString("fts_key_json_data");
              }
              catch (Exception localException)
              {
                if (this.Egb != null)
                {
                  if (paramBundle.size() > 0) {
                    this.Egb.H((String)localObject2, paramBundle);
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
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.eTS());
                      }
                      AppMethodBeat.o(80532);
                    }
                  });
                  if (this.Egb != null) {
                    this.Egb.fJS();
                  }
                  eTj();
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.fts.b.a.a.eOj();
                  com.tencent.mm.plugin.webview.fts.b.a.a.aGC(getTotalQuery());
                  AppMethodBeat.o(80565);
                  return;
                  this.Egb.H((String)localObject1, paramBundle);
                  break;
                  if (this.Egb != null) {
                    this.Egb.vr.clearFocus();
                  }
                }
              }
              this.handler.post(new BaseSOSWebViewUI.10(this, paramBundle));
              AppMethodBeat.o(80565);
              return;
              localObject1 = paramBundle.getString("fts_key_sns_id");
              paramInt = paramBundle.getInt("fts_key_status", 0);
              this.handler.post(new BaseSOSWebViewUI.11(this, (String)localObject1, paramInt));
              AppMethodBeat.o(80565);
              return;
              if (!eTU())
              {
                ad.w("MicroMsg.WebSearch.BaseSOSWebViewUI", "current state is not search");
                AppMethodBeat.o(80565);
                return;
              }
            } while (this.Egf == null);
            this.Egf.c(paramBundle, this.scene);
            AppMethodBeat.o(80565);
            return;
          } while (this.Egf == null);
          this.Egf.aU(paramBundle);
          AppMethodBeat.o(80565);
          return;
        } while (this.Egf == null);
        this.Egf.aV(paramBundle);
        AppMethodBeat.o(80565);
        return;
      } while (this.Egf == null);
      this.Egf.aW(paramBundle);
      AppMethodBeat.o(80565);
      return;
    case 138: 
      paramBundle = paramBundle.getString("fts_key_data");
      if (!bt.isNullOrNil(paramBundle))
      {
        if ("index".equals(paramBundle))
        {
          this.Ege = 1;
          AppMethodBeat.o(80565);
          return;
        }
        if ("result".equals(paramBundle))
        {
          this.Ege = 2;
          AppMethodBeat.o(80565);
          return;
        }
        if ("suggestion".equals(paramBundle))
        {
          this.Ege = 3;
          AppMethodBeat.o(80565);
          return;
        }
        if ("teach".equals(paramBundle))
        {
          this.Ege = 4;
          AppMethodBeat.o(80565);
          return;
        }
        if ("local".equals(paramBundle))
        {
          this.Ege = 5;
          AppMethodBeat.o(80565);
          return;
        }
        this.Ege = 0;
        AppMethodBeat.o(80565);
        return;
      }
      this.Ege = 0;
      AppMethodBeat.o(80565);
      return;
    case 144: 
      label774:
      AppMethodBeat.o(80565);
      return;
    }
    paramInt = paramBundle.getInt("ret");
    long l = paramBundle.getLong("reqId");
    paramBundle = paramBundle.getString("json", "");
    this.handler.post(new BaseSOSWebViewUI.13(this, paramInt, l, paramBundle));
    AppMethodBeat.o(80565);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80569);
    eqj();
    AppMethodBeat.o(80569);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80561);
    if (this.Egb != null)
    {
      if (!this.Egb.vr.hasFocus())
      {
        this.Egb.fJS();
        showVKB();
      }
      this.Egb.setHint(getHint());
    }
    AppMethodBeat.o(80561);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80552);
    super.onCreate(paramBundle);
    this.Egc = getIntent().getBooleanExtra("ftsInitToSearch", false);
    getSupportActionBar().hide();
    AppMethodBeat.o(80552);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80564);
    try
    {
      if (this.lvv != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.lvv.x(1, localBundle);
      }
      if (this.Egf != null) {
        this.Egf.onDestroy();
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
    if (this.Egf != null) {
      this.Egf.onPause();
    }
    AppMethodBeat.o(80555);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80554);
    super.onResume();
    if (this.Egf != null) {
      this.Egf.onResume();
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
    String ACS;
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
      int i = this.ACS.compareTo(paramObject.ACS);
      AppMethodBeat.o(80543);
      return i;
    }
    
    public final String getTagName()
    {
      return this.ACS;
    }
  }
  
  protected final class c
  {
    String Egs;
    String Egt;
    Map<String, Object> Egu;
    List<a.c> ppT;
    int type;
    
    protected c()
    {
      AppMethodBeat.i(80550);
      this.Egs = "";
      this.Egt = "";
      this.Egu = new HashMap();
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
        if ((paramObject.type == this.type) && (paramObject.Egt.equals(this.Egt)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
 * JD-Core Version:    0.7.0.1
 */