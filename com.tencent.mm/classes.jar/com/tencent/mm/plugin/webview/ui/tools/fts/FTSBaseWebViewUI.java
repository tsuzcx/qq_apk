package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.a;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
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

public class FTSBaseWebViewUI
  extends BaseSearchWebViewUI
  implements FTSEditTextView.a, a.a
{
  public com.tencent.mm.plugin.fts.ui.widget.a kAW;
  private boolean rsV;
  private boolean rtU;
  private e rtw;
  private com.tencent.mm.plugin.webview.fts.d.a rtx;
  int scene;
  int type;
  
  private void bOb()
  {
    XM();
    finish();
    overridePendingTransition(0, 0);
  }
  
  protected static boolean cfs()
  {
    return true;
  }
  
  protected static boolean cft()
  {
    return true;
  }
  
  public void a(String paramString1, String paramString2, List<a.b> paramList, FTSEditTextView.b paramb)
  {
    y.i("MicroMsg.FTS.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.kEB) || (paramb == FTSEditTextView.b.kEC)) {
      this.handler.post(new FTSBaseWebViewUI.7(this));
    }
  }
  
  public final void aWb()
  {
    if (!this.kAW.getFtsEditText().kEp.hasFocus())
    {
      this.kAW.getFtsEditText().aWy();
      showVKB();
    }
  }
  
  public void aoX()
  {
    super.aoX();
    String str = bk.aM(getIntent().getStringExtra("ftsQuery"), "").trim();
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.rsV = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.rtU = getIntent().getBooleanExtra("ftscaneditable", true);
    this.niQ.setWebViewClient(new FTSBaseWebViewUI.b(this, (byte)0));
    this.niQ.setOnTouchListener(new FTSBaseWebViewUI.1(this));
    if (this.rtU)
    {
      this.kAW = new com.tencent.mm.plugin.fts.ui.widget.a(this);
      this.kAW.setSearchViewListener(this);
      this.kAW.getFtsEditText().setHint(getHint());
      this.kAW.getFtsEditText().setFtsEditTextListener(this);
      getSupportActionBar().setCustomView(this.kAW);
      if (!bk.bl(str)) {
        this.kAW.getFtsEditText().n(str, null);
      }
      if (this.rsV)
      {
        this.kAW.getFtsEditText().aWy();
        this.kAW.getFtsEditText().aWx();
      }
    }
    showOptionMenu(false);
    if (this.rpn != null) {
      this.rpn.lh(true);
    }
    this.niQ.setOnLongClickListener(new FTSBaseWebViewUI.6(this));
    this.rtx.rbk = this.rbk;
  }
  
  public boolean apb()
  {
    y.i("MicroMsg.FTS.FTSBaseWebViewUI", "onSearchKeyDown");
    if (getTotalQuery().length() > 0)
    {
      this.handler.post(new FTSBaseWebViewUI.9(this));
      XM();
    }
    return false;
  }
  
  protected final void cdU()
  {
    bOb();
  }
  
  protected final int cdZ()
  {
    return R.k.actionbar_icon_dark_back;
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
  
  protected final e cfu()
  {
    return this.rtw;
  }
  
  public final JSONArray cfw()
  {
    Object localObject = this.kAW.getFtsEditText().getTagList();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FTSBaseWebViewUI.a locala = (FTSBaseWebViewUI.a)((Iterator)localObject).next();
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
  
  public String getHint()
  {
    return null;
  }
  
  protected final String getInEditTextQuery()
  {
    return this.kAW.getFtsEditText().getInEditTextQuery();
  }
  
  protected final int getLayoutId()
  {
    return R.i.fts_webview_ui;
  }
  
  protected final String getTotalQuery()
  {
    return this.kAW.getFtsEditText().getTotalQuery();
  }
  
  public final void gn(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.handler.post(new FTSBaseWebViewUI.8(this));
    }
  }
  
  public void i(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    switch (paramInt)
    {
    default: 
      super.i(paramInt, paramBundle);
    case 144: 
    case 128: 
    case 119: 
    case 120: 
    case 121: 
    case 122: 
      for (;;)
      {
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
        this.handler.post(new FTSBaseWebViewUI.10(this, (Map)localObject1));
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        localObject2 = paramBundle.getString("fts_key_req_id");
        boolean bool = paramBundle.getBoolean("fts_key_new_query", true);
        paramBundle = paramBundle.getBundle("fts_key_data");
        this.handler.post(new FTSBaseWebViewUI.11(this, paramBundle, (String)localObject1, bool, (String)localObject2));
        return;
        paramInt = paramBundle.getInt("fts_key_ret", 0);
        paramBundle = paramBundle.getString("fts_key_data");
        this.handler.post(new FTSBaseWebViewUI.12(this, paramInt, paramBundle));
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
        i = paramBundle.getInt("fts_key_is_cache_data", 0);
        this.handler.post(new FTSBaseWebViewUI.13(this, paramInt, (String)localObject1, i));
        return;
        localObject1 = paramBundle.getString("fts_key_new_query");
        localObject2 = paramBundle.getString("fts_key_custom_query");
        bool = paramBundle.getBoolean("fts_key_need_keyboard", false);
        Object localObject3 = paramBundle.getString("fts_key_tag_list");
        y.i("MicroMsg.FTS.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool) });
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
              FTSBaseWebViewUI.a locala = new FTSBaseWebViewUI.a(this);
              locala.rtH = localJSONObject.getString("tagName");
              locala.rtI = localJSONObject.getInt("tagType");
              locala.userName = localJSONObject.getString("userName");
              paramBundle.add(locala);
              paramInt += 1;
            }
          }
          if (this.kAW == null) {}
        }
        catch (Exception localException)
        {
          if (this.kAW != null)
          {
            if (paramBundle.size() <= 0) {
              break label604;
            }
            this.kAW.getFtsEditText().n((String)localObject2, paramBundle);
          }
          while (bool)
          {
            this.handler.post(new FTSBaseWebViewUI.2(this));
            if (this.kAW != null) {
              this.kAW.getFtsEditText().aWy();
            }
            ceA();
            return;
            this.kAW.getFtsEditText().n((String)localObject1, paramBundle);
          }
        }
      }
      this.kAW.getFtsEditText().kEp.clearFocus();
      XM();
      return;
    case 124: 
      paramBundle = paramBundle.getString("fts_key_json_data");
      this.handler.post(new FTSBaseWebViewUI.3(this, paramBundle));
      return;
    case 125: 
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      this.handler.post(new FTSBaseWebViewUI.4(this, (String)localObject1, paramInt));
      return;
    case 60: 
      this.rtw.b(paramBundle, this.scene);
      return;
    case 100001: 
      this.rtw.aa(paramBundle);
      return;
    case 61: 
      label604:
      this.rtw.ab(paramBundle);
      return;
    }
    this.rtw.ac(paramBundle);
  }
  
  public void onClickBackBtn(View paramView)
  {
    bOb();
  }
  
  public void onClickCancelBtn(View paramView)
  {
    this.kAW.getFtsEditText().n("", null);
    this.handler.post(new FTSBaseWebViewUI.5(this));
    this.kAW.getFtsEditText().kEp.clearFocus();
    XM();
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    if (this.kAW != null)
    {
      if (!this.kAW.getFtsEditText().kEp.hasFocus())
      {
        this.kAW.getFtsEditText().aWy();
        showVKB();
      }
      this.kAW.getFtsEditText().setHint(getHint());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.rtx = new com.tencent.mm.plugin.webview.fts.d.a(this.niQ);
    this.rtw = new e(((h)com.tencent.mm.kernel.g.r(h.class)).a(this.mController.uMN, this.rtx));
    ta(this.mController.uMN.getResources().getColor(R.e.normal_actionbar_color));
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
  
  public void onResume()
  {
    super.onResume();
    this.rtw.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */