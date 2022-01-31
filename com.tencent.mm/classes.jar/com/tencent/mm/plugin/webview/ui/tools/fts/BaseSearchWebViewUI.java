package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.u;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.fts.c.b;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.58;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseSearchWebViewUI
  extends LoadDataWebviewUI
  implements b.b
{
  protected View ejC;
  protected String hng;
  private View ivh;
  protected String query;
  protected int scene;
  protected int type;
  protected boolean vjR;
  private b vjS;
  private Set<b.a> vjT = new HashSet();
  RelativeLayout vjU;
  private SmileyPanel vjV;
  protected int vjW;
  protected int vjX;
  protected String vjY;
  protected List<Runnable> vjZ;
  private Runnable vka;
  
  private String E(EmojiInfo paramEmojiInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("md5", paramEmojiInfo.field_md5);
    localBundle.putString("designerId", paramEmojiInfo.field_designerID);
    localBundle.putString("aeskey", paramEmojiInfo.field_aeskey);
    localBundle.putString("encryptUrl", paramEmojiInfo.field_encrypturl);
    localBundle.putString("productId", paramEmojiInfo.field_groupId);
    localBundle.putString("name", paramEmojiInfo.field_name);
    localBundle.putString("thumbUrl", paramEmojiInfo.field_thumbUrl);
    try
    {
      paramEmojiInfo = this.igU.r(7, localBundle);
      return paramEmojiInfo.getString("emojiPath");
    }
    catch (Exception paramEmojiInfo)
    {
      for (;;)
      {
        paramEmojiInfo = localBundle;
      }
    }
  }
  
  private static int ap(Bundle paramBundle)
  {
    return bo.apV(paramBundle.getString("playerId"));
  }
  
  private void aq(Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("desc");
    String str3 = paramBundle.getString("items");
    try
    {
      JSONArray localJSONArray = new JSONArray(str3);
      int i = 0;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        y localy;
        if (localJSONObject != null)
        {
          localy = new y();
          localy.iconUrl = localJSONObject.optString("icon");
          localy.title = localJSONObject.optString("title");
          if (localJSONObject.optInt("selected") != 1) {
            break label154;
          }
        }
        label154:
        for (boolean bool = true;; bool = false)
        {
          localy.gDG = bool;
          localy.desc = localJSONObject.optString("desc");
          localArrayList.add(localy);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.WebSearch.BaseSearchWebViewUI", bo.l(localJSONException));
      ab.v("MicroMsg.WebSearch.BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[] { str1, str2, str3 });
      if (!localArrayList.isEmpty()) {
        paramBundle.putInt("actionSheetId", ((h)g.E(h.class)).a(this, str1, str2, localArrayList, new BaseSearchWebViewUI.6(this)));
      }
    }
  }
  
  private void bFB()
  {
    if (this.ejC != null)
    {
      this.ejC.setVisibility(8);
      if (this.vka != null)
      {
        this.handler.removeCallbacks(this.vka);
        this.vka = null;
      }
    }
  }
  
  private void dfH()
  {
    if ((this.vjZ != null) && (!this.vjZ.isEmpty()))
    {
      Object localObject = new ArrayList(this.vjZ);
      ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready callback, running jsapi count %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      this.vjZ.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
  }
  
  protected final void Y(Runnable paramRunnable)
  {
    if ((getJsapi() != null) && (getJsapi().ready))
    {
      paramRunnable.run();
      return;
    }
    ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi not ready, waiting");
    if (this.vjZ == null) {
      this.vjZ = new ArrayList();
    }
    this.vjZ.add(paramRunnable);
  }
  
  public final void a(b.a parama)
  {
    this.vjT.add(parama);
  }
  
  public void aMf()
  {
    super.aMf();
    this.vjS.uQS = getJsapi();
    if ((getJsapi() != null) && (!getJsapi().ready))
    {
      getJsapi().a(new BaseSearchWebViewUI.1(this));
      if (this.igU == null) {
        break label125;
      }
    }
    for (;;)
    {
      try
      {
        this.igU.i(51, new Bundle());
        this.vjU = ((RelativeLayout)findViewById(2131824417));
        return;
        dfH();
        ab.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready");
        z.cZj();
      }
      catch (RemoteException localRemoteException)
      {
        ab.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      label125:
      ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
    }
  }
  
  public final boolean aMh()
  {
    return true;
  }
  
  protected void b(int paramInt, String paramString, Map<String, Object> paramMap) {}
  
  public final void daO()
  {
    if (this.ivh == null) {}
    for (;;)
    {
      return;
      Object localObject = (ViewGroup)getWindow().getDecorView();
      ((ViewGroup)localObject).setSystemUiVisibility(0);
      ((ViewGroup)localObject).removeView(this.ivh);
      getWindow().clearFlags(1024);
      if (getRequestedOrientation() == 0) {
        setRequestedOrientation(1);
      }
      this.ivh = null;
      localObject = this.vjT.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).aDk();
      }
    }
  }
  
  protected e dfB()
  {
    return null;
  }
  
  protected final void dfG()
  {
    super.dfG();
    int i = this.scene;
    String str1 = this.cpW;
    String str2 = this.cCW;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      z.a(i, str1, str2, bool, this.query, this.type, this.vjY, this.vlr);
      return;
    }
  }
  
  public final void dfI()
  {
    if (this.vjU != null) {
      this.vjU.setVisibility(8);
    }
    if (this.vjV != null) {
      this.vjV.AE();
    }
  }
  
  public void l(final int paramInt, final Bundle paramBundle)
  {
    boolean bool2 = true;
    final boolean bool1 = true;
    switch (paramInt)
    {
    default: 
      super.l(paramInt, paramBundle);
    case 135: 
    case 137: 
    case 133: 
    case 134: 
    case 100002: 
    case 200000: 
    case 200001: 
    case 200002: 
    case 200003: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                b(paramBundle.getInt("FTS_KEY_onStartWebSearch_type", 0), paramBundle.getString("FTS_KEY_onStartWebSearch_query"), (Map)paramBundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                return;
                paramBundle = paramBundle.getString("fts_key_json_data");
              } while (getJsapi() == null);
              try
              {
                getJsapi().aU(new JSONObject(paramBundle));
                return;
              }
              catch (JSONException paramBundle)
              {
                ab.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", paramBundle, "", new Object[0]);
                return;
              }
              aq(paramBundle);
              return;
              com.tencent.mm.plugin.websearch.widget.view.a.daf().JA(paramBundle.getInt("actionSheetId"));
              return;
              localObject = dfB();
              if (localObject != null)
              {
                ((e)localObject).au(paramBundle);
                return;
              }
              ab.e("MicroMsg.WebSearch.BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
              getJsapi().a(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
              return;
              localObject = this.vjS;
            } while (localObject == null);
            ((com.tencent.mm.plugin.webview.fts.c.e)localObject).F(ap(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
            return;
            localObject = this.vjS;
          } while (localObject == null);
          ((com.tencent.mm.plugin.webview.fts.c.e)localObject).G(ap(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
          return;
          localObject = this.vjS;
        } while (localObject == null);
        ((com.tencent.mm.plugin.webview.fts.c.e)localObject).JO(ap(paramBundle));
        return;
        localObject = this.vjS;
      } while (localObject == null);
      ((com.tencent.mm.plugin.webview.fts.c.e)localObject).bC(ap(paramBundle), paramBundle.getString("type"));
      return;
    case 145: 
      getJsapi().ay(paramBundle);
      return;
    case 148: 
      localObject = paramBundle.getString("title", "");
      final String str = paramBundle.getString("icon", "");
      paramInt = paramBundle.getInt("duration", 500);
      if (paramBundle.getInt("mask", 0) > 0) {}
      for (;;)
      {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(8380);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cbK, str, paramInt, bool1);
            AppMethodBeat.o(8380);
          }
        });
        return;
        bool1 = false;
      }
    case 149: 
      localObject = paramBundle.getString("title", "");
      if (paramBundle.getInt("mask", 0) > 0) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(8381);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cbK, "loading", -1, bool1);
            AppMethodBeat.o(8381);
          }
        });
        return;
      }
    case 150: 
      bFB();
      return;
    case 151: 
      ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "GOTO_EMOTICON");
      hideVKB();
      if (this.vjV == null)
      {
        this.vjV = u.aW(this);
        this.vjV.setEntranceScene(ChatFooterPanel.vQx);
        this.vjV.setBackgroundResource(2131690709);
        this.vjV.setVisibility(0);
        this.vjV.AA();
        this.vjV.bo(true);
        this.vjV.j(true, true);
        this.vjV.onResume();
        paramBundle = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this, 300));
        paramBundle.addRule(12);
        this.vjU.addView(this.vjV, paramBundle);
        paramBundle = u.AF();
        paramBundle.bWo = new BaseSearchWebViewUI.4(this);
        this.vjV.setCallback(paramBundle);
      }
      this.vjU.setVisibility(0);
      return;
    }
    paramInt = paramBundle.getInt("fts_key_ret_code");
    Object localObject = paramBundle.getString("fts_key_err_msg");
    paramBundle = paramBundle.getString("fts_key_json_data", "");
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153283);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald = BaseSearchWebViewUI.this.getJsapi();
        int i = paramInt;
        String str1 = this.ftO;
        String str2 = paramBundle;
        if (!locald.ready) {
          ab.e("MicroMsg.JsApiHandler", "onSimilarEmoticonReady fail, not ready");
        }
        for (;;)
        {
          ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "wxaapp_opsearch resp, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(paramInt), this.ftO, paramBundle });
          AppMethodBeat.o(153283);
          return;
          ab.i("MicroMsg.JsApiHandler", "onSimilarEmoticonReady success, ready");
          HashMap localHashMap = new HashMap();
          localHashMap.put("retCode", Integer.valueOf(i));
          localHashMap.put("errMsg", str1);
          localHashMap.put("json", str2);
          al.d(new d.58(locald, i.a.b("onSimilarEmoticonReady", localHashMap, locald.voB, locald.voC)));
        }
      }
    });
  }
  
  public void onBackPressed()
  {
    dfI();
    Iterator localIterator = this.vjT.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((b.a)localIterator.next()).onBackPressed() | bool) {}
    if (!bool) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    if (getIntent() != null) {
      this.vjR = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
    }
    this.vjS = new b(getContext(), this.pOd, this);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.vjW = this.scene;
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.query = getIntent().getStringExtra("ftsQuery");
    this.vjY = getIntent().getStringExtra("tabId");
    this.hng = getIntent().getStringExtra("searchId");
    this.vjX = this.type;
    int i = this.scene;
    paramBundle = this.cpW;
    String str = this.cCW;
    if (this.type == 0) {
      bool = true;
    }
    z.a(i, paramBundle, str, bool, this.query, this.type, this.vjY, this.vlr, this.hng);
    if (!aa.l(this, this.scene)) {
      ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "request for grant location permission");
    }
    for (;;)
    {
      paramBundle = View.inflate(this, 2130970629, null);
      paramBundle.setBackgroundResource(2131690605);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.ejC = paramBundle;
      if ((this.ejC != null) && ((getContentView() instanceof ViewGroup))) {
        ((ViewGroup)getContentView()).addView(this.ejC);
      }
      bFB();
      return;
      ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "has location permission");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.vjT.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).onDestroy();
    }
    this.vjT.clear();
    int i = this.scene;
    localObject = this.cpW;
    String str = this.cCW;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      z.a(i, (String)localObject, str, bool, this.query, this.type, this.vlr);
      ab.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "onDestroy");
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator;
    if (paramInt == 25)
    {
      localIterator = this.vjT.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).daM();
      }
    }
    if (paramInt == 24)
    {
      localIterator = this.vjT.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).daN();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.vjT.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onBackground();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length > 0) {}
    for (paramArrayOfString = paramArrayOfInt[0];; paramArrayOfString = "")
    {
      ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onRequestPermissionsResult, granted ? %s", new Object[] { paramArrayOfString });
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.vjT.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void t(View paramView, boolean paramBoolean)
  {
    daO();
    this.ivh = paramView;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (com.tencent.mm.compatible.util.d.fw(19)) {
      localViewGroup.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(1024);
      if (paramBoolean) {
        setRequestedOrientation(0);
      }
      return;
      localViewGroup.setSystemUiVisibility(4098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */