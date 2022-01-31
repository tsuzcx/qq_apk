package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import com.tencent.mm.ui.s;
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
  protected ImageButton mBP;
  protected View nRR;
  private boolean rsV;
  View rts;
  protected SOSEditTextView rtt;
  private List<BaseSOSWebViewUI.c> rtu;
  protected int rtv = 0;
  private e rtw;
  private com.tencent.mm.plugin.webview.fts.d.a rtx;
  boolean rty;
  boolean rtz;
  
  protected static boolean cfs()
  {
    return true;
  }
  
  protected static boolean cft()
  {
    return true;
  }
  
  public final String CO(int paramInt)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      int i;
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "educationTab");
        localObject3 = this.gGn.o(2, (Bundle)localObject1);
        localObject1 = ((Bundle)localObject3).getString("result");
        localObject3 = ((Bundle)localObject3).getString("result_1");
        if (localObject3 != null) {
          break label119;
        }
        localObject1 = new JSONObject((String)localObject1).optJSONArray("items");
        if (localObject1 != null) {
          break label125;
        }
        return "";
      }
      catch (Exception localException) {}
      if (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        if (((JSONObject)localObject3).optInt("businessType") == paramInt)
        {
          localObject1 = ((JSONObject)localObject3).optString("hotword");
          return localObject1;
        }
        i += 1;
      }
      else
      {
        return "";
        label119:
        Object localObject2 = localObject3;
        continue;
        label125:
        i = 0;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, List<a.b> paramList, FTSEditTextView.b paramb)
  {
    y.i("MicroMsg.FTS.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.kEB) || (paramb == FTSEditTextView.b.kEC)) {
      this.handler.post(new BaseSOSWebViewUI.17(this));
    }
    while (paramb != FTSEditTextView.b.kED) {
      return;
    }
    if (this.rtt.kEp.hasFocus())
    {
      this.rtt.aWD();
      return;
    }
    this.rtt.aWC();
  }
  
  public final void aWb()
  {
    if (!this.rtt.kEp.hasFocus())
    {
      this.rtt.aWy();
      showVKB();
    }
  }
  
  protected final int aZY()
  {
    return this.scene;
  }
  
  protected void aoX()
  {
    super.aoX();
    this.rsV = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.rts = findViewById(R.h.search_input_layout);
    this.rtt = ((SOSEditTextView)findViewById(R.h.sos_edittext));
    this.rtt.setFtsEditTextListener(this);
    this.rtt.setHint(getHint());
    this.nRR = findViewById(R.h.cancel_btn);
    this.nRR.setOnClickListener(new BaseSOSWebViewUI.1(this));
    this.mBP = ((ImageButton)findViewById(R.h.back_btn));
    this.mBP.setOnClickListener(new BaseSOSWebViewUI.11(this));
    this.niQ.setWebViewClient(new BaseSOSWebViewUI.b(this, (byte)0));
    this.niQ.setOnTouchListener(new BaseSOSWebViewUI.12(this));
    if (this.rsV) {
      this.mController.contentView.postDelayed(new BaseSOSWebViewUI.13(this), 128L);
    }
    if (this.rpn != null) {
      this.rpn.lh(true);
    }
    this.niQ.setOnLongClickListener(new BaseSOSWebViewUI.14(this));
    this.rtx.rbk = this.rbk;
  }
  
  public boolean apb()
  {
    this.rtt.kEp.clearFocus();
    XM();
    if (getTotalQuery().length() > 0)
    {
      this.handler.post(new BaseSOSWebViewUI.2(this));
      XM();
      this.rty = true;
    }
    return true;
  }
  
  protected final void b(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    y.v("MicroMsg.FTS.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[] { Integer.valueOf(paramInt), paramString, paramMap });
    this.rtQ = paramInt;
    if (this.rtu == null) {
      this.rtu = new ArrayList();
    }
    BaseSOSWebViewUI.c localc1;
    BaseSOSWebViewUI.c localc2;
    if (getTotalQuery().length() > 0)
    {
      localc1 = new BaseSOSWebViewUI.c(this);
      localc1.type = this.rtQ;
      localc1.iSZ = new ArrayList(this.rtt.getTagList());
      localc1.rtK = this.rtt.getInEditTextQuery();
      localc1.rtJ = this.rtt.getTotalQuery();
      if (this.rtu.size() == 0) {
        this.rtu.add(localc1);
      }
    }
    else if ((this.rtu != null) && (!this.rtu.isEmpty()))
    {
      localc1 = (BaseSOSWebViewUI.c)this.rtu.get(0);
      localc2 = new BaseSOSWebViewUI.c(this);
      localc2.type = paramInt;
      localc2.rtJ = paramString;
      localc2.rtL = paramMap;
      if (localc1 != null)
      {
        if (localc1 != localc2) {
          break label269;
        }
        paramInt = 1;
      }
    }
    for (;;)
    {
      if (paramInt != 0) {
        localc1.rtL = paramMap;
      }
      return;
      if (localc1.equals((BaseSOSWebViewUI.c)this.rtu.get(0))) {
        break;
      }
      this.rtu.add(0, localc1);
      break;
      label269:
      paramString = (BaseSOSWebViewUI.c)localc2;
      if ((paramString.type == localc1.type) && (paramString.rtJ.trim().equals(localc1.rtJ.trim()))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  protected final void bOb()
  {
    XM();
    if ((this.rtu != null) && (this.rtu.size() > 1))
    {
      this.rtu.remove(0);
      BaseSOSWebViewUI.c localc = (BaseSOSWebViewUI.c)this.rtu.get(0);
      this.rtt.n(localc.rtK, localc.iSZ);
      this.handler.post(new BaseSOSWebViewUI.15(this, localc));
      return;
    }
    if (this.rty)
    {
      cfn();
      return;
    }
    finish();
  }
  
  protected final void cdU()
  {
    bOb();
  }
  
  protected final boolean ceb()
  {
    return false;
  }
  
  protected final boolean cer()
  {
    return true;
  }
  
  protected final boolean cey()
  {
    return false;
  }
  
  protected void cfl() {}
  
  protected void cfm() {}
  
  protected void cfn()
  {
    this.rtt.n("", null);
    XM();
    this.handler.post(new BaseSOSWebViewUI.16(this));
    this.rtu = null;
    this.rty = false;
    this.rtw.onDestroy();
  }
  
  protected void cfo() {}
  
  protected String cfp()
  {
    return "";
  }
  
  protected int cfq()
  {
    return 0;
  }
  
  public final SOSEditTextView cfr()
  {
    return this.rtt;
  }
  
  protected final e cfu()
  {
    return this.rtw;
  }
  
  protected final int cfv()
  {
    return this.rtQ;
  }
  
  public final JSONArray cfw()
  {
    Object localObject = this.rtt.getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseSOSWebViewUI.a locala = (BaseSOSWebViewUI.a)((Iterator)localObject).next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tagName", locala.rtH);
        localJSONObject.put("tagType", locala.rtI);
        localJSONObject.put("userName", locala.userName);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
    }
    return localJSONArray;
  }
  
  protected boolean cfx()
  {
    return true;
  }
  
  public String getHint()
  {
    return null;
  }
  
  protected final String getInEditTextQuery()
  {
    return this.rtt.getInEditTextQuery();
  }
  
  public final String getSessionId()
  {
    return this.bIB;
  }
  
  protected final String getTotalQuery()
  {
    if (this.rtt != null) {
      return this.rtt.getTotalQuery();
    }
    return "";
  }
  
  protected final int getType()
  {
    return this.type;
  }
  
  public void gn(boolean paramBoolean)
  {
    if ((paramBoolean) && (!bk.bl(getTotalQuery()))) {
      this.handler.post(new BaseSOSWebViewUI.18(this));
    }
  }
  
  protected void i(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    switch (paramInt)
    {
    default: 
      super.i(paramInt, paramBundle);
    case 144: 
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
      return;
    case 119: 
      localObject1 = paramBundle.getString("fts_key_json_data");
      localObject2 = paramBundle.getString("fts_key_req_id");
      bool = paramBundle.getBoolean("fts_key_new_query", true);
      paramBundle = paramBundle.getBundle("fts_key_data");
      this.handler.post(new BaseSOSWebViewUI.4(this, paramBundle, (String)localObject1, bool, (String)localObject2));
      return;
    case 143: 
      paramBundle = paramBundle.getString("data");
      this.handler.post(new BaseSOSWebViewUI.5(this, paramBundle));
      return;
    case 120: 
      paramInt = paramBundle.getInt("fts_key_ret", 0);
      paramBundle = paramBundle.getString("fts_key_data");
      this.handler.post(new BaseSOSWebViewUI.6(this, paramInt, paramBundle));
      return;
    case 121: 
      localObject1 = paramBundle.getString("fts_key_json_data");
      paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
      i = paramBundle.getInt("fts_key_is_cache_data", 0);
      this.handler.post(new BaseSOSWebViewUI.7(this, paramInt, (String)localObject1, i));
      return;
    case 122: 
      localObject1 = paramBundle.getString("fts_key_new_query");
      localObject2 = paramBundle.getString("fts_key_custom_query");
      bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
      localObject3 = paramBundle.getString("fts_key_tag_list");
      y.i("MicroMsg.FTS.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
      paramBundle = new ArrayList();
      try
      {
        if (!bk.bl((String)localObject3))
        {
          localObject3 = new JSONArray((String)localObject3);
          paramInt = i;
          while (paramInt < ((JSONArray)localObject3).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject3).getJSONObject(paramInt);
            BaseSOSWebViewUI.a locala = new BaseSOSWebViewUI.a(this);
            locala.rtH = localJSONObject.getString("tagName");
            locala.rtI = localJSONObject.getInt("tagType");
            locala.userName = localJSONObject.getString("userName");
            paramBundle.add(locala);
            paramInt += 1;
          }
        }
        paramBundle = paramBundle.getString("fts_key_json_data");
      }
      catch (Exception localException)
      {
        if (this.rtt != null)
        {
          if (paramBundle.size() > 0) {
            this.rtt.n((String)localObject2, paramBundle);
          }
        }
        else
        {
          if (!bool) {
            break label665;
          }
          this.handler.post(new BaseSOSWebViewUI.8(this));
          if (this.rtt != null) {
            this.rtt.aWy();
          }
          ceA();
        }
        for (;;)
        {
          com.tencent.mm.plugin.webview.fts.b.a.a.caH();
          com.tencent.mm.plugin.webview.fts.b.a.a.RI(getTotalQuery());
          return;
          this.rtt.n((String)localObject1, paramBundle);
          break;
          if (this.rtt != null) {
            this.rtt.kEp.clearFocus();
          }
        }
      }
    case 124: 
      this.handler.post(new BaseSOSWebViewUI.9(this, paramBundle));
      return;
    case 125: 
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      this.handler.post(new BaseSOSWebViewUI.10(this, (String)localObject1, paramInt));
      return;
    case 60: 
      if (!cfx())
      {
        y.w("MicroMsg.FTS.BaseSOSWebViewUI", "current state is not search");
        return;
      }
      this.rtw.b(paramBundle, this.scene);
      return;
    case 100001: 
      this.rtw.aa(paramBundle);
      return;
    case 61: 
      this.rtw.ab(paramBundle);
      return;
    case 62: 
      label665:
      this.rtw.ac(paramBundle);
      return;
    }
    paramBundle = paramBundle.getString("fts_key_data");
    if (!bk.bl(paramBundle))
    {
      if ("index".equals(paramBundle))
      {
        this.rtv = 1;
        return;
      }
      if ("result".equals(paramBundle))
      {
        this.rtv = 2;
        return;
      }
      if ("suggestion".equals(paramBundle))
      {
        this.rtv = 3;
        return;
      }
      if ("teach".equals(paramBundle))
      {
        this.rtv = 4;
        return;
      }
      if ("local".equals(paramBundle))
      {
        this.rtv = 5;
        return;
      }
      this.rtv = 0;
      return;
    }
    this.rtv = 0;
  }
  
  public void onBackPressed()
  {
    bOb();
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    if (this.rtt != null)
    {
      if (!this.rtt.kEp.hasFocus())
      {
        this.rtt.aWy();
        showVKB();
      }
      this.rtt.setHint(getHint());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    this.rtx = new com.tencent.mm.plugin.webview.fts.d.a(this.niQ);
    this.rtw = new e(((h)com.tencent.mm.kernel.g.r(h.class)).a(this.mController.uMN, this.rtx));
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.gGn != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.gGn.i(1, localBundle);
      }
      this.rtw.onDestroy();
    }
    catch (RemoteException localRemoteException)
    {
      label44:
      break label44;
    }
    XM();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.rtw.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.rtw.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
 * JD-Core Version:    0.7.0.1
 */