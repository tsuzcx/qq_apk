package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ad;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.h.38;
import com.tencent.mm.plugin.webview.d.h.47;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.fts.c.b;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
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
  extends PreLoadWebViewUI
  implements b.b
{
  private b JnA;
  private Set<b.a> JnB = new HashSet();
  RelativeLayout JnC;
  protected int JnD;
  protected int JnE;
  protected String JnF;
  private Runnable JnG;
  protected boolean Jnz;
  protected View gAy;
  private SmileyPanel hQS;
  protected String hes;
  private View nEb;
  protected String query;
  protected int scene;
  protected int type;
  
  private String C(EmojiInfo paramEmojiInfo)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("md5", paramEmojiInfo.field_md5);
    ((Bundle)localObject1).putString("designerId", paramEmojiInfo.field_designerID);
    ((Bundle)localObject1).putString("aeskey", paramEmojiInfo.field_aeskey);
    ((Bundle)localObject1).putString("encryptUrl", paramEmojiInfo.field_encrypturl);
    ((Bundle)localObject1).putString("productId", paramEmojiInfo.field_groupId);
    ((Bundle)localObject1).putString("name", paramEmojiInfo.field_name);
    ((Bundle)localObject1).putString("thumbUrl", paramEmojiInfo.field_thumbUrl);
    try
    {
      localObject2 = this.mHh.w(7, (Bundle)localObject1);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label93:
      break label93;
    }
    localObject2 = ((Bundle)localObject1).getString("emojiPath");
    if (!paramEmojiInfo.NA())
    {
      localObject1 = localObject2;
      if (paramEmojiInfo.field_catalog != EmojiGroupInfo.Uun) {}
    }
    else
    {
      localObject1 = (String)localObject2 + "_fts";
    }
    return localObject1;
  }
  
  private static int bf(Bundle paramBundle)
  {
    return Util.safeParseInt(paramBundle.getString("playerId"));
  }
  
  private void bg(Bundle paramBundle)
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
        af localaf;
        if (localJSONObject != null)
        {
          localaf = new af();
          localaf.iconUrl = localJSONObject.optString("icon");
          localaf.title = localJSONObject.optString("title");
          if (localJSONObject.optInt("selected") != 1) {
            break label156;
          }
        }
        label156:
        for (boolean bool = true;; bool = false)
        {
          localaf.isSelected = bool;
          localaf.desc = localJSONObject.optString("desc");
          localArrayList.add(localaf);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.WebSearch.BaseSearchWebViewUI", Util.stackTraceToString(localJSONException));
      Log.v("MicroMsg.WebSearch.BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[] { str1, str2, str3 });
      if (!localArrayList.isEmpty()) {
        paramBundle.putInt("actionSheetId", ((com.tencent.mm.plugin.websearch.api.f)g.af(com.tencent.mm.plugin.websearch.api.f.class)).a(this, str1, str2, localArrayList, new BaseSearchWebViewUI.7(this)));
      }
    }
  }
  
  private void dTO()
  {
    if (this.gAy != null)
    {
      this.gAy.setVisibility(8);
      if (this.JnG != null)
      {
        this.handler.removeCallbacks(this.JnG);
        this.JnG = null;
      }
    }
  }
  
  public final void a(b.a parama)
  {
    this.JnB.add(parama);
  }
  
  protected final Drawable agS(int paramInt)
  {
    int i = 2131690938;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return getResources().getDrawable(paramInt);
      paramInt = 2131691756;
      continue;
      paramInt = 2131691763;
      continue;
      paramInt = 2131691759;
      continue;
      paramInt = 2131691754;
      continue;
      paramInt = 2131691758;
      continue;
      paramInt = 2131691755;
      continue;
      paramInt = 2131691765;
      continue;
      paramInt = 2131691757;
      continue;
      paramInt = 2131691762;
      continue;
      paramInt = 2131691760;
      continue;
      paramInt = 2131691761;
      continue;
      paramInt = 2131691766;
    }
  }
  
  public void bXg()
  {
    super.bXg();
    if (this.JnA == null) {
      this.JnA = new b(getContext(), this.pGj, this);
    }
    this.JnA.IBw = getJsapi();
    if (this.mHh != null) {
      try
      {
        this.mHh.j(51, new Bundle());
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localRemoteException, "", new Object[0]);
        return;
      }
    }
    Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
  }
  
  public final boolean bXi()
  {
    return true;
  }
  
  protected void c(int paramInt, String paramString, Map<String, Object> paramMap) {}
  
  protected final void cpR()
  {
    super.cpR();
    Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready");
    ah.fXT();
  }
  
  public final void gaO()
  {
    if (this.nEb == null) {}
    for (;;)
    {
      return;
      Object localObject = (ViewGroup)getWindow().getDecorView();
      ((ViewGroup)localObject).setSystemUiVisibility(0);
      ((ViewGroup)localObject).removeView(this.nEb);
      getWindow().clearFlags(1024);
      if (getRequestedOrientation() == 0) {
        setRequestedOrientation(1);
      }
      this.nEb = null;
      localObject = this.JnB.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).Na();
      }
    }
  }
  
  protected e ggM()
  {
    return null;
  }
  
  protected final void ggQ()
  {
    super.ggQ();
    int i = this.scene;
    String str1 = this.sessionId;
    String str2 = this.dVO;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ah.a(i, str1, str2, bool, this.query, this.type, this.JnF, this.IRT);
      return;
    }
  }
  
  public final void ggR()
  {
    if (this.JnC != null) {
      this.JnC.setVisibility(8);
    }
    if (this.hQS != null) {
      this.hQS.goF();
    }
  }
  
  public void m(final int paramInt, Bundle paramBundle)
  {
    boolean bool2 = true;
    final boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      super.m(paramInt, paramBundle);
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
                do
                {
                  return;
                  c(paramBundle.getInt("FTS_KEY_onStartWebSearch_type", 0), paramBundle.getString("FTS_KEY_onStartWebSearch_query"), (Map)paramBundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                  return;
                  localObject1 = paramBundle.getString("fts_key_json_data");
                } while (getJsapi() == null);
                try
                {
                  paramBundle = getJsapi();
                  localObject1 = new JSONObject((String)localObject1);
                  if (!paramBundle.GBl)
                  {
                    Log.e("MicroMsg.JsApiHandler", "not ready");
                    return;
                  }
                }
                catch (JSONException paramBundle)
                {
                  Log.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", paramBundle, "", new Object[0]);
                  return;
                }
                MMHandlerThread.postToMainThread(new h.38(paramBundle, n.a.a("onGetMatchContactList", (JSONObject)localObject1, paramBundle.IRj, paramBundle.zpY)));
                return;
                bg(paramBundle);
                return;
                localObject1 = com.tencent.mm.plugin.websearch.widget.view.a.fYZ();
                paramInt = paramBundle.getInt("actionSheetId");
                paramBundle = (com.tencent.mm.ui.widget.a.e)((com.tencent.mm.plugin.websearch.widget.view.a)localObject1).IIt.remove(Integer.valueOf(paramInt));
              } while (paramBundle == null);
              paramBundle.bMo();
              return;
              localObject1 = ggM();
              if (localObject1 != null)
              {
                paramInt = paramBundle.getInt("x", -1);
                int i = paramBundle.getInt("y", -1);
                localObject2 = paramBundle.getString("widgetId");
                paramBundle = paramBundle.getString("eventId");
                ((e)localObject1).IIH.g(paramInt, i, (String)localObject2, paramBundle);
                return;
              }
              Log.e("MicroMsg.WebSearch.BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
              getJsapi().b(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
              return;
              localObject1 = this.JnA;
            } while (localObject1 == null);
            ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).Q(bf(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
            return;
            localObject1 = this.JnA;
          } while (localObject1 == null);
          ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).R(bf(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
          return;
          localObject1 = this.JnA;
        } while (localObject1 == null);
        ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).afS(bf(paramBundle));
        return;
        localObject1 = this.JnA;
      } while (localObject1 == null);
      ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).cS(bf(paramBundle), paramBundle.getString("type"));
      return;
    case 145: 
      localObject1 = getJsapi();
      if (!((h)localObject1).GBl)
      {
        Log.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
        return;
      }
      Log.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
      localObject2 = new HashMap();
      ((Map)localObject2).put("json", paramBundle.getString("json"));
      ((Map)localObject2).put("searchId", paramBundle.getString("searchId"));
      ((Map)localObject2).put("poiId", paramBundle.getString("poiId"));
      MMHandlerThread.postToMainThread(new h.47((h)localObject1, n.a.b("onGetPoiInfoReturn", (Map)localObject2, ((h)localObject1).IRj, ((h)localObject1).zpY)));
      return;
    case 148: 
      localObject1 = paramBundle.getString("title", "");
      localObject2 = paramBundle.getString("icon", "");
      paramInt = paramBundle.getInt("duration", 500);
      if (paramBundle.getInt("mask", 0) > 0) {}
      for (;;)
      {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(211224);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.dqb, this.mok, paramInt, bool1);
            AppMethodBeat.o(211224);
          }
        });
        return;
        bool1 = false;
      }
    case 149: 
      localObject1 = paramBundle.getString("title", "");
      if (paramBundle.getInt("mask", 0) > 0) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80573);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.dqb, "loading", -1, bool1);
            AppMethodBeat.o(80573);
          }
        });
        return;
      }
    case 150: 
      dTO();
      return;
    case 151: 
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "GOTO_EMOTICON");
      hideVKB();
      paramBundle = paramBundle.getString("requestId");
      if (this.hQS == null)
      {
        this.hQS = ad.bC(this);
        this.hQS.setEntranceScene(ChatFooterPanel.KbF);
        this.hQS.setVisibility(0);
        this.hQS.setShowSmiley(false);
        this.hQS.onResume();
        localObject1 = new RelativeLayout.LayoutParams(-1, ad.bD(this));
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.JnC.addView(this.hQS, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new TextView(getApplicationContext());
        ((TextView)localObject1).setBackgroundColor(com.tencent.mm.cb.a.n(this, 2131099689));
        ((TextView)localObject1).setPadding(0, com.tencent.mm.cb.a.aH(this, 2131165296), 0, com.tencent.mm.cb.a.aH(this, 2131165296));
        ((TextView)localObject1).setTextColor(com.tencent.mm.cb.a.n(this, 2131100594));
        ((TextView)localObject1).setTextSize(15.0F);
        ((TextView)localObject1).setText(2131765079);
        ((TextView)localObject1).setGravity(17);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ad.bD(this);
        this.JnC.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = ad.VK();
        ((ac)localObject1).djc = new BaseSearchWebViewUI.3(this, paramBundle);
        this.hQS.setCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      }
      this.JnC.setVisibility(0);
      return;
    case 152: 
      paramInt = paramBundle.getInt("fts_key_ret_code");
      localObject1 = paramBundle.getString("fts_key_err_msg");
      paramBundle = paramBundle.getString("fts_key_json_data", "");
      this.handler.post(new BaseSearchWebViewUI.4(this, paramInt, (String)localObject1, paramBundle));
      return;
    case 153: 
      paramInt = paramBundle.getInt("fts_key_ret_code");
      localObject1 = paramBundle.getString("fts_key_err_msg");
      localObject2 = paramBundle.getString("fts_key_json_data", "");
      paramBundle = paramBundle.getString("fts_key_id", "");
      this.handler.post(new BaseSearchWebViewUI.5(this, paramInt, (String)localObject1, (String)localObject2, paramBundle));
      return;
    }
    paramBundle = paramBundle.getString("fts_key_json_data", "");
    this.handler.post(new BaseSearchWebViewUI.6(this, paramBundle));
  }
  
  public void onBackPressed()
  {
    ggR();
    Iterator localIterator = this.JnB.iterator();
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
      this.Jnz = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
    }
    if (this.JnA == null) {
      this.JnA = new b(getContext(), this.pGj, this);
    }
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.JnD = this.scene;
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.query = getIntent().getStringExtra("ftsQuery");
    this.JnF = getIntent().getStringExtra("tabId");
    this.hes = getIntent().getStringExtra("searchId");
    this.JnE = this.type;
    int i = this.scene;
    paramBundle = this.sessionId;
    String str = this.dVO;
    if (this.type == 0) {
      bool = true;
    }
    ah.a(i, paramBundle, str, bool, this.query, this.type, this.JnF, this.IRT, this.hes);
    if (!ai.n(this, this.scene)) {
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "request for grant location permission");
    }
    for (;;)
    {
      paramBundle = View.inflate(this, 2131496185, null);
      paramBundle.setBackgroundResource(2131101287);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.gAy = paramBundle;
      if ((this.gAy != null) && ((getContentView() instanceof ViewGroup))) {
        ((ViewGroup)getContentView()).addView(this.gAy);
      }
      dTO();
      this.JnC = ((RelativeLayout)findViewById(2131300014));
      return;
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "has location permission");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.JnB.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).onDestroy();
    }
    this.JnB.clear();
    int i = this.scene;
    localObject = this.sessionId;
    String str = this.dVO;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ah.a(i, (String)localObject, str, bool, this.query, this.type, this.IRT);
      Log.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "onDestroy");
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator;
    if (paramInt == 25)
    {
      localIterator = this.JnB.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).gaM();
      }
    }
    if (paramInt == 24)
    {
      localIterator = this.JnB.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).gaN();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.JnB.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onBackground();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length > 0) {}
    for (paramArrayOfString = paramArrayOfInt[0];; paramArrayOfString = "")
    {
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onRequestPermissionsResult, granted ? %s", new Object[] { paramArrayOfString });
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.JnB.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void w(View paramView, boolean paramBoolean)
  {
    gaO();
    this.nEb = paramView;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (com.tencent.mm.compatible.util.d.oE(19)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */