package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.fts.d.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.search.b;
import com.tencent.mm.ui.widget.MMWebView;
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
  protected WebSearchView CCZ;
  private boolean CCf;
  private e CCx;
  private a CCy;
  private boolean CDa;
  private LinkedList<String> Hae;
  private boolean JfY;
  int scene;
  int type;
  private View xuw;
  
  public FTSBaseWebViewUI()
  {
    AppMethodBeat.i(210076);
    this.Hae = new LinkedList();
    AppMethodBeat.o(210076);
  }
  
  private void WY(String paramString)
  {
    AppMethodBeat.i(210081);
    this.Hae.remove(paramString);
    this.Hae.add(paramString);
    AppMethodBeat.o(210081);
  }
  
  private boolean fde()
  {
    AppMethodBeat.i(210077);
    if (this.Hae.size() <= 1)
    {
      hideVKB();
      finish();
      AppMethodBeat.o(210077);
      return true;
    }
    this.Hae.removeLast();
    String str = (String)this.Hae.getLast();
    this.CCZ.getFtsEditText().F(str, null);
    this.CCZ.getFtsEditText().ty.clearFocus();
    hideVKB();
    fdf();
    AppMethodBeat.o(210077);
    return false;
  }
  
  private void fdf()
  {
    AppMethodBeat.i(210079);
    this.handler.post(new FTSBaseWebViewUI.11(this));
    AppMethodBeat.o(210079);
  }
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164032);
    ac.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[] { paramString1, paramString2, paramb });
    if ((paramb == FTSEditTextView.b.ILv) || (paramb == FTSEditTextView.b.ILw)) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80588);
          if (FTSBaseWebViewUI.this.Cjc != null) {
            FTSBaseWebViewUI.this.Cjc.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eEZ(), 0);
          }
          AppMethodBeat.o(80588);
        }
      });
    }
    AppMethodBeat.o(164032);
  }
  
  public final h bMD()
  {
    AppMethodBeat.i(188525);
    h localh = super.bMD();
    if (localh != null) {
      localh.a(new FTSBaseWebViewUI.b(this, (byte)0));
    }
    AppMethodBeat.o(188525);
    return localh;
  }
  
  public void bvh()
  {
    AppMethodBeat.i(80603);
    super.bvh();
    String str = bs.bG(getIntent().getStringExtra("ftsQuery"), "").trim();
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.CCf = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.CDa = getIntent().getBooleanExtra("ftscaneditable", true);
    this.JfY = getIntent().getBooleanExtra("key_hide_cancel_btn", false);
    if (this.nKq != null) {
      this.nKq.setOnTouchListener(new FTSBaseWebViewUI.1(this));
    }
    this.CCZ = ((WebSearchView)findViewById(2131300038));
    this.xuw = findViewById(2131305918);
    if (this.CDa)
    {
      this.xuw.setVisibility(8);
      this.CCZ.setSearchViewListener(this);
      this.CCZ.getFtsEditText().setHint(getHint());
      this.CCZ.getFtsEditText().setFtsEditTextListener(this);
      if (this.JfY) {
        this.CCZ.getCancelBtn().setVisibility(8);
      }
      if (!bs.isNullOrNil(str))
      {
        this.CCZ.getFtsEditText().F(str, null);
        WY(str);
      }
      if (this.CCf)
      {
        this.CCZ.getFtsEditText().fte();
        this.CCZ.getFtsEditText().ftd();
      }
      if (getIntent().getBooleanExtra("key_change_search_icon", false))
      {
        this.CCZ.getSearchIcon().setVisibility(8);
        this.CCZ.getFtsEditText().ftg();
        this.CCZ.getFtsEditText().getIconView().setImageDrawable(VN(this.type));
      }
    }
    for (;;)
    {
      showOptionMenu(false);
      if (this.CAF != null) {
        this.CAF.ut(true);
      }
      if (this.nKq != null) {
        this.nKq.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            return true;
          }
        });
      }
      this.CCy.Cjc = this.Cjc;
      AppMethodBeat.o(80603);
      return;
      this.CCZ.setVisibility(8);
      str = getIntent().getStringExtra("title");
      if (!bs.isNullOrNil(str)) {
        ((TextView)findViewById(2131296979)).setText(str);
      }
      findViewById(2131297026).setOnClickListener(new FTSBaseWebViewUI.7(this));
    }
  }
  
  public boolean bvs()
  {
    AppMethodBeat.i(80614);
    ac.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onSearchKeyDown");
    if (getTotalQuery().length() > 0)
    {
      WY(getTotalQuery());
      fdf();
      hideVKB();
    }
    AppMethodBeat.o(80614);
    return false;
  }
  
  protected final void c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(210080);
    WY(paramString);
    AppMethodBeat.o(210080);
  }
  
  public final void cxG()
  {
    AppMethodBeat.i(164031);
    if (!this.CCZ.getFtsEditText().ty.hasFocus())
    {
      this.CCZ.getFtsEditText().fte();
      showVKB();
    }
    AppMethodBeat.o(164031);
  }
  
  public final void eDW()
  {
    AppMethodBeat.i(80618);
    fde();
    AppMethodBeat.o(80618);
  }
  
  protected final e eEY()
  {
    return this.CCx;
  }
  
  public final JSONArray eEZ()
  {
    AppMethodBeat.i(80615);
    Object localObject = this.CCZ.getFtsEditText().getTagList();
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
    AppMethodBeat.o(80615);
    return localJSONArray;
  }
  
  public final int eEa()
  {
    return 2131689490;
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
    String str = this.CCZ.getFtsEditText().getInEditTextQuery();
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
    String str = this.CCZ.getFtsEditText().getTotalQuery();
    AppMethodBeat.o(80605);
    return str;
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(80612);
    if (paramBoolean) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80589);
          if (FTSBaseWebViewUI.this.Cjc != null) {
            FTSBaseWebViewUI.this.Cjc.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.eEZ(), 0);
          }
          AppMethodBeat.o(80589);
        }
      });
    }
    AppMethodBeat.o(80612);
  }
  
  public void n(final int paramInt, Bundle paramBundle)
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
        this.handler.post(new FTSBaseWebViewUI.12(this, (Map)localObject1));
        AppMethodBeat.o(80616);
        return;
        localObject1 = paramBundle.getString("fts_key_json_data");
        localObject2 = paramBundle.getString("fts_key_req_id");
        boolean bool1 = paramBundle.getBoolean("fts_key_new_query", true);
        paramBundle = paramBundle.getBundle("fts_key_data");
        this.handler.post(new FTSBaseWebViewUI.13(this, paramBundle, (String)localObject1, bool1, (String)localObject2));
        AppMethodBeat.o(80616);
        return;
        paramInt = paramBundle.getInt("fts_key_ret", 0);
        paramBundle = paramBundle.getString("fts_key_data");
        this.handler.post(new FTSBaseWebViewUI.14(this, paramInt, paramBundle));
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
            if (FTSBaseWebViewUI.this.Cjc != null) {
              FTSBaseWebViewUI.this.Cjc.w(paramInt, this.meg, i);
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
        ac.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[] { localObject1, Boolean.valueOf(bool1) });
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
          if (this.CCZ == null) {}
        }
        catch (Exception localException)
        {
          if (this.CCZ != null)
          {
            if (paramBundle.size() <= 0) {
              break label677;
            }
            this.CCZ.getFtsEditText().F((String)localObject2, paramBundle);
            if (bool2) {
              WY((String)localObject2);
            }
          }
          while (bool1)
          {
            this.handler.post(new FTSBaseWebViewUI.3(this));
            if (this.CCZ != null) {
              this.CCZ.getFtsEditText().fte();
            }
            eEr();
            AppMethodBeat.o(80616);
            return;
            this.CCZ.getFtsEditText().F((String)localObject1, paramBundle);
            if (bool2) {
              WY((String)localObject1);
            }
          }
        }
      }
      this.CCZ.getFtsEditText().ty.clearFocus();
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
      this.CCx.b(paramBundle, this.scene);
      AppMethodBeat.o(80616);
      return;
    case 100001: 
      this.CCx.aP(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 61: 
      this.CCx.aQ(paramBundle);
      AppMethodBeat.o(80616);
      return;
    case 62: 
      this.CCx.aR(paramBundle);
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
        if (FTSBaseWebViewUI.this.Cjc != null)
        {
          FTSBaseWebViewUI.this.Cjc.a(paramInt, l, this.obI);
          ac.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), this.obI });
        }
        AppMethodBeat.o(80586);
      }
    });
    AppMethodBeat.o(80616);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(210078);
    if (fde()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(210078);
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(80607);
    fde();
    AppMethodBeat.o(80607);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(80619);
    this.CCZ.getFtsEditText().F("", null);
    this.handler.post(new FTSBaseWebViewUI.15(this));
    this.CCZ.getFtsEditText().ty.clearFocus();
    hideVKB();
    AppMethodBeat.o(80619);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(80613);
    if (this.CCZ != null)
    {
      if (!this.CCZ.getFtsEditText().ty.hasFocus())
      {
        this.CCZ.getFtsEditText().fte();
        showVKB();
      }
      this.CCZ.getFtsEditText().setHint(getHint());
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
    this.CCy = new a(this.nKq);
    this.CCx = new e(((com.tencent.mm.plugin.websearch.api.e)g.ab(com.tencent.mm.plugin.websearch.api.e.class)).a(getContext(), this.CCy));
    setActionbarColor(com.tencent.mm.ui.ao.aJ(getContext(), 2130968577));
    AppMethodBeat.o(80602);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80617);
    try
    {
      if (this.kYt != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_id", hashCode());
        this.kYt.w(1, localBundle);
      }
      this.CCx.onDestroy();
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
    this.CCx.onPause();
    AppMethodBeat.o(80610);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80609);
    super.onResume();
    this.CCx.onResume();
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
    int aYc;
    String userName;
    String zkN;
    
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
      int i = this.zkN.compareTo(paramObject.zkN);
      AppMethodBeat.o(80594);
      return i;
    }
    
    public final String getTagName()
    {
      return this.zkN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */