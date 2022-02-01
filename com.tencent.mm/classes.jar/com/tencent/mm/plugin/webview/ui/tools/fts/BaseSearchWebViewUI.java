package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.tencent.mm.api.ad;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.ae;
import com.tencent.mm.api.t;
import com.tencent.mm.emoji.b.d.h.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.fts.b.b.a;
import com.tencent.mm.plugin.webview.fts.b.b.b;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.j.37;
import com.tencent.mm.plugin.webview.jsapi.j.39;
import com.tencent.mm.plugin.webview.jsapi.j.42;
import com.tencent.mm.plugin.webview.jsapi.j.48;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.y;
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
  protected boolean XbH;
  protected boolean XcX;
  private com.tencent.mm.plugin.webview.fts.b.b XcY;
  private Set<b.a> XcZ = new HashSet();
  RelativeLayout Xda;
  protected int Xdb;
  protected int Xdc;
  protected String Xdd;
  protected boolean Xde;
  private Runnable Xdf;
  protected View lNf;
  protected String mpa;
  private SmileyPanel niv;
  protected String query;
  protected int scene;
  private View tKX;
  protected int type;
  
  private String E(EmojiInfo paramEmojiInfo)
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
      localObject2 = this.sLC.B(7, (Bundle)localObject1);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label93:
      break label93;
    }
    localObject2 = ((Bundle)localObject1).getString("emojiPath");
    if (!paramEmojiInfo.aqJ())
    {
      localObject1 = localObject2;
      if (paramEmojiInfo.field_catalog != EmojiGroupInfo.aklE) {}
    }
    else
    {
      localObject1 = (String)localObject2 + "_fts";
    }
    return localObject1;
  }
  
  private static int bI(Bundle paramBundle)
  {
    return Util.safeParseInt(paramBundle.getString("playerId"));
  }
  
  private void bJ(Bundle paramBundle)
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
        ag localag;
        if (localJSONObject != null)
        {
          localag = new ag();
          localag.iconUrl = localJSONObject.optString("icon");
          localag.title = localJSONObject.optString("title");
          if (localJSONObject.optInt("selected") != 1) {
            break label156;
          }
        }
        label156:
        for (boolean bool = true;; bool = false)
        {
          localag.isSelected = bool;
          localag.desc = localJSONObject.optString("desc");
          localArrayList.add(localag);
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
        paramBundle.putInt("actionSheetId", ((com.tencent.mm.plugin.websearch.api.f)h.ax(com.tencent.mm.plugin.websearch.api.f.class)).a(this, str1, str2, localArrayList, new af()
        {
          public final void na(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(80579);
            if (BaseSearchWebViewUI.this.getJsapi() != null)
            {
              j localj = BaseSearchWebViewUI.this.getJsapi();
              if (!localj.UcS)
              {
                Log.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
                AppMethodBeat.o(80579);
                return;
              }
              Log.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
              HashMap localHashMap = new HashMap();
              localHashMap.put("index", Integer.valueOf(paramAnonymousInt1));
              localHashMap.put("actionSheetId", Integer.valueOf(paramAnonymousInt2));
              MMHandlerThread.postToMainThread(new j.37(localj, p.a.b("onSearchActionSheetClick", localHashMap, localj.WDI, localj.KQY)));
            }
            AppMethodBeat.o(80579);
          }
        }));
      }
    }
  }
  
  private void fEC()
  {
    if (this.lNf != null)
    {
      this.lNf.setVisibility(8);
      if (this.Xdf != null)
      {
        getHandler().removeCallbacks(this.Xdf);
        this.Xdf = null;
      }
    }
  }
  
  private static void jdMethod_if(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_image_path", paramString);
    localBundle.putInt("key_img_source", paramInt);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, null);
  }
  
  public final void E(View paramView, boolean paramBoolean)
  {
    ito();
    this.tKX = paramView;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (com.tencent.mm.compatible.util.d.rc(19)) {
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
  
  public final void a(b.a parama)
  {
    this.XcZ.add(parama);
  }
  
  protected Drawable auD(int paramInt)
  {
    int i = c.h.icons_outlined_wechat_search_one_search;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return getResources().getDrawable(paramInt);
      paramInt = c.h.websearch_icon_baike;
      continue;
      paramInt = c.h.websearch_icon_question;
      continue;
      paramInt = c.h.websearch_icon_movie;
      continue;
      paramInt = c.h.websearch_icon_acount;
      continue;
      paramInt = c.h.websearch_icon_moment;
      continue;
      paramInt = c.h.websearch_icon_article;
      continue;
      paramInt = c.h.websearch_icon_weapp;
      continue;
      paramInt = c.h.websearch_icon_emoji;
      continue;
      paramInt = c.h.websearch_icon_product;
      continue;
      paramInt = c.h.websearch_icon_music;
      continue;
      paramInt = c.h.websearch_icon_novel;
      continue;
      paramInt = c.h.websearch_icon_webpage;
    }
  }
  
  protected void c(int paramInt, String paramString, Map<String, Object> paramMap) {}
  
  public void cKX()
  {
    super.cKX();
    if (this.XcY == null) {
      this.XcY = new com.tencent.mm.plugin.webview.fts.b.b(getContext(), this.sMP, this);
    }
    this.XcY.WlX = getJsapi();
  }
  
  public final boolean cKZ()
  {
    return true;
  }
  
  protected final void cxT()
  {
    super.cxT();
    Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready");
    ai.ipN();
  }
  
  protected e iAi()
  {
    return null;
  }
  
  public boolean iAk()
  {
    return false;
  }
  
  protected final void iAm()
  {
    super.iAm();
    int i = this.scene;
    String str1 = this.sessionId;
    String str2 = this.hVn;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ai.a(i, str1, str2, bool, this.query, this.type, this.Xdd, this.WEv);
      return;
    }
  }
  
  public final void iAn()
  {
    if ((this.WXG) || (!this.XbH)) {
      super.hideVKB();
    }
  }
  
  public final void iAo()
  {
    if (this.Xda != null) {
      this.Xda.setVisibility(8);
    }
    if (this.niv != null) {
      this.niv.iKj();
    }
  }
  
  public final void ito()
  {
    if (this.tKX == null) {}
    for (;;)
    {
      return;
      Object localObject = (ViewGroup)getWindow().getDecorView();
      ((ViewGroup)localObject).setSystemUiVisibility(0);
      ((ViewGroup)localObject).removeView(this.tKX);
      getWindow().clearFlags(1024);
      if (getRequestedOrientation() == 0) {
        setRequestedOrientation(1);
      }
      this.tKX = null;
      localObject = this.XcZ.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).aqb();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2;
    boolean bool1;
    if (paramInt1 == 101)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {
          Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onActivityResult, data = null.");
        }
      }
      else {
        return;
      }
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      if (paramIntent == null)
      {
        Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onActivityResult, model = null.");
        return;
      }
      bool2 = iAk();
      if (paramIntent.gHE() == null) {
        break label214;
      }
      paramInt2 = ((Integer)paramIntent.gHE().J("KEY_MEDIA_SOURCE_INT", Integer.valueOf(-1))).intValue();
      if ((paramInt2 != 1) && (paramInt2 != 2))
      {
        bool1 = true;
        jdMethod_if(paramIntent.thumbPath, 0);
      }
    }
    for (;;)
    {
      if (bool2) {
        if (bool1) {
          paramInt1 = 21;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "isSearchState = %b, source = %d, isFromAlbum = %b, model.getReportInfo() = %s, type = %d.", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(paramInt1), Boolean.valueOf(bool1), paramIntent.gHE(), Integer.valueOf(paramInt2) });
        jdMethod_if(paramIntent.thumbPath, paramInt1);
        return;
        bool1 = false;
        break;
        paramInt1 = 20;
        continue;
        if (bool1) {
          paramInt1 = 19;
        } else {
          paramInt1 = 18;
        }
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label214:
      paramInt2 = 0;
      bool1 = true;
    }
  }
  
  public void onBackPressed()
  {
    iAo();
    Iterator localIterator = this.XcZ.iterator();
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
      this.XcX = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
    }
    if (this.XcY == null) {
      this.XcY = new com.tencent.mm.plugin.webview.fts.b.b(getContext(), this.sMP, this);
    }
    this.XbH = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.Xdb = this.scene;
    this.Xde = getIntent().getBooleanExtra("key_search_icon_and_hint_fix_default", false);
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.query = getIntent().getStringExtra("ftsQuery");
    this.Xdd = getIntent().getStringExtra("tabId");
    this.mpa = getIntent().getStringExtra("searchId");
    this.Xdc = this.type;
    int i = this.scene;
    paramBundle = this.sessionId;
    String str = this.hVn;
    if (this.type == 0) {
      bool = true;
    }
    ai.c(i, paramBundle, str, bool, this.query, this.type, this.Xdd, this.WEv, this.mpa);
    paramBundle = View.inflate(this, c.g.search_loading_dialog_layout, null);
    paramBundle.setBackgroundResource(c.c.transparent);
    paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.lNf = paramBundle;
    if ((this.lNf != null) && ((getContentView() instanceof ViewGroup))) {
      ((ViewGroup)getContentView()).addView(this.lNf);
    }
    fEC();
    this.Xda = ((RelativeLayout)findViewById(c.f.emoji_panel_layout));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.XcZ.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).onDestroy();
    }
    this.XcZ.clear();
    int i = this.scene;
    localObject = this.sessionId;
    String str = this.hVn;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ai.a(i, (String)localObject, str, bool, this.query, this.type, this.WEv);
      Log.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "onDestroy");
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator;
    if (paramInt == 25)
    {
      localIterator = this.XcZ.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).itm();
      }
    }
    if (paramInt == 24)
    {
      localIterator = this.XcZ.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).itn();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.XcZ.iterator();
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
    Iterator localIterator = this.XcZ.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void q(final int paramInt, final Bundle paramBundle)
  {
    boolean bool2 = true;
    final boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      super.q(paramInt, paramBundle);
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
                  if (com.tencent.mm.pluginsdk.permission.b.c(this, new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 73))
                  {
                    if (!aj.a(this, this.scene, getString(c.i.websearch_request_location_permission_reason), getString(c.i.app_to_authorize)))
                    {
                      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "request for grant location permission");
                      return;
                    }
                    Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "has location permission");
                    return;
                  }
                  Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "cannot request permission");
                  return;
                  localObject1 = paramBundle.getString("fts_key_json_data");
                } while (getJsapi() == null);
                try
                {
                  paramBundle = getJsapi();
                  localObject1 = new JSONObject((String)localObject1);
                  if (!paramBundle.UcS)
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
                MMHandlerThread.postToMainThread(new j.39(paramBundle, p.a.a("onGetMatchContactList", (JSONObject)localObject1, paramBundle.WDI, paramBundle.KQY)));
                return;
                bJ(paramBundle);
                return;
                localObject1 = com.tencent.mm.plugin.websearch.widget.view.a.irf();
                paramInt = paramBundle.getInt("actionSheetId");
                paramBundle = (com.tencent.mm.ui.widget.a.f)((com.tencent.mm.plugin.websearch.widget.view.a)localObject1).Wtt.remove(Integer.valueOf(paramInt));
              } while (paramBundle == null);
              paramBundle.cyW();
              return;
              localObject1 = iAi();
              if (localObject1 != null)
              {
                paramInt = paramBundle.getInt("x", -1);
                int i = paramBundle.getInt("y", -1);
                localObject2 = paramBundle.getString("widgetId");
                paramBundle = paramBundle.getString("eventId");
                ((e)localObject1).WtB.i(paramInt, i, (String)localObject2, paramBundle);
                return;
              }
              Log.e("MicroMsg.WebSearch.BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
              getJsapi().c(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
              return;
              localObject1 = this.XcY;
            } while (localObject1 == null);
            ((com.tencent.mm.plugin.webview.fts.b.e)localObject1).X(bI(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
            return;
            localObject1 = this.XcY;
          } while (localObject1 == null);
          ((com.tencent.mm.plugin.webview.fts.b.e)localObject1).Y(bI(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
          return;
          localObject1 = this.XcY;
        } while (localObject1 == null);
        ((com.tencent.mm.plugin.webview.fts.b.e)localObject1).atA(bI(paramBundle));
        return;
        localObject1 = this.XcY;
      } while (localObject1 == null);
      ((com.tencent.mm.plugin.webview.fts.b.e)localObject1).dJ(bI(paramBundle), paramBundle.getString("type"));
      return;
    case 145: 
      localObject1 = getJsapi();
      if (!((j)localObject1).UcS)
      {
        Log.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
        return;
      }
      Log.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
      localObject2 = new HashMap();
      ((Map)localObject2).put("json", paramBundle.getString("json"));
      ((Map)localObject2).put("searchId", paramBundle.getString("searchId"));
      ((Map)localObject2).put("poiId", paramBundle.getString("poiId"));
      MMHandlerThread.postToMainThread(new j.48((j)localObject1, p.a.b("onGetPoiInfoReturn", (Map)localObject2, ((j)localObject1).WDI, ((j)localObject1).KQY)));
      return;
    case 148: 
      localObject1 = paramBundle.getString("title", "");
      localObject2 = paramBundle.getString("icon", "");
      paramInt = paramBundle.getInt("duration", 500);
      if (paramBundle.getInt("mask", 0) > 0) {}
      for (;;)
      {
        getHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(296861);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.eSG, this.sri, paramInt, bool1);
            AppMethodBeat.o(296861);
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
        getHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80573);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.eSG, "loading", -1, bool1);
            AppMethodBeat.o(80573);
          }
        });
        return;
      }
    case 150: 
      fEC();
      return;
    case 151: 
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "GOTO_EMOTICON");
      hideVKB();
      paramBundle = paramBundle.getString("requestId");
      if (this.niv == null)
      {
        this.niv = ae.co(this);
        this.niv.setEntranceScene(ChatFooterPanel.XYp);
        this.niv.setVisibility(0);
        this.niv.setShowSmiley(false);
        this.niv.onResume();
        localObject1 = new RelativeLayout.LayoutParams(-1, ae.cp(this));
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.Xda.addView(this.niv, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new TextView(getApplicationContext());
        ((TextView)localObject1).setBackgroundColor(com.tencent.mm.cd.a.w(this, c.c.BW_93));
        ((TextView)localObject1).setPadding(0, com.tencent.mm.cd.a.bs(this, c.d.Edge_2A), 0, com.tencent.mm.cd.a.bs(this, c.d.Edge_2A));
        ((TextView)localObject1).setTextColor(com.tencent.mm.cd.a.w(this, c.c.hint_text_color));
        ((TextView)localObject1).setTextSize(15.0F);
        ((TextView)localObject1).setText(c.i.search_emoji_header);
        ((TextView)localObject1).setGravity(17);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ae.cp(this);
        this.Xda.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = ae.aBJ();
        ((ad)localObject1).hej = new ad.a()
        {
          public final void a(final t paramAnonymoust)
          {
            AppMethodBeat.i(296848);
            final String str1 = BaseSearchWebViewUI.this.Xdb + ";" + BaseSearchWebViewUI.this.sessionId + ";" + paramBundle;
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this).set16029ExtraInfo(str1);
            paramAnonymoust = (EmojiInfo)paramAnonymoust;
            str1 = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymoust);
            Object localObject1;
            if ((paramAnonymoust.aqJ()) || (paramAnonymoust.field_catalog == EmojiGroupInfo.aklE))
            {
              Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "emoji is system emoji %s", new Object[] { Integer.valueOf(paramAnonymoust.field_catalog) });
              if (!y.ZC(str1))
              {
                localObject1 = paramAnonymoust.F(BaseSearchWebViewUI.this, 480);
                if (localObject1 == null) {}
              }
            }
            try
            {
              BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 80, Bitmap.CompressFormat.PNG, str1, false);
              Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "save emoji bitmap %d %s", new Object[] { Long.valueOf(y.bEl(str1)), str1 });
              str1 = "weixin://fts/emoji?path=".concat(String.valueOf(str1));
              localObject1 = paramAnonymoust.field_md5;
              final String str2 = paramAnonymoust.field_aeskey;
              final String str3 = paramAnonymoust.field_encrypturl;
              boolean bool = paramAnonymoust.kLZ();
              i = 0;
              if (com.tencent.mm.plugin.emoji.g.d.y(paramAnonymoust))
              {
                i = 1;
                Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSelectedEmoji %s %s %b", new Object[] { localObject1, str1, Boolean.valueOf(bool) });
                Object localObject2 = BaseSearchWebViewUI.this.getJsapi();
                if (!bool) {
                  break label386;
                }
                j = 0;
                ((j)localObject2).a((String)localObject1, str1, i, j, str3, str2);
                if (!bool)
                {
                  localObject2 = com.tencent.mm.emoji.b.e.mgl;
                  com.tencent.mm.emoji.b.e.a(paramAnonymoust, new h.a()
                  {
                    public final void onResult(boolean paramAnonymous2Boolean)
                    {
                      int i = 0;
                      AppMethodBeat.i(296947);
                      if (paramAnonymous2Boolean)
                      {
                        Object localObject = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymoust);
                        Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s emojiPath %s exist %b", new Object[] { this.oJE, str1, localObject, Boolean.valueOf(y.ZC((String)localObject)) });
                        localObject = BaseSearchWebViewUI.this.getJsapi();
                        String str1 = this.oJE;
                        String str2 = str1;
                        int j = i;
                        if (paramAnonymous2Boolean) {}
                        for (;;)
                        {
                          ((j)localObject).a(str1, str2, j, i, str3, str2);
                          AppMethodBeat.o(296947);
                          return;
                          i = 1;
                        }
                      }
                      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s fail", new Object[] { this.oJE, str1 });
                      AppMethodBeat.o(296947);
                    }
                  });
                }
                BaseSearchWebViewUI.this.Xda.setVisibility(8);
                AppMethodBeat.o(296848);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                final int i;
                int j;
                Log.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localException, "SaveEmojiBitmap", new Object[0]);
                continue;
                if (com.tencent.mm.plugin.emoji.g.d.z(paramAnonymoust))
                {
                  i = 2;
                }
                else if (com.tencent.mm.plugin.emoji.g.d.x(paramAnonymoust))
                {
                  i = 3;
                  continue;
                  label386:
                  j = 1;
                }
              }
            }
          }
          
          public final void onHide() {}
        };
        this.niv.setCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      }
      this.Xda.setVisibility(0);
      return;
    case 152: 
      paramInt = paramBundle.getInt("fts_key_ret_code");
      localObject1 = paramBundle.getString("fts_key_err_msg");
      paramBundle = paramBundle.getString("fts_key_json_data", "");
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(296856);
          BaseSearchWebViewUI.this.getJsapi().k(paramInt, this.val$errMsg, paramBundle, "", "onSimilarEmoticonReady");
          Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "wxaapp_opsearch resp, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(paramInt), this.val$errMsg, paramBundle });
          AppMethodBeat.o(296856);
        }
      });
      return;
    case 153: 
      paramInt = paramBundle.getInt("fts_key_ret_code");
      localObject1 = paramBundle.getString("fts_key_err_msg");
      localObject2 = paramBundle.getString("fts_key_json_data", "");
      paramBundle = paramBundle.getString("fts_key_id", "");
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80577);
          BaseSearchWebViewUI.this.getJsapi().k(paramInt, this.val$errMsg, this.wzK, paramBundle, "onSearchWebQueryReady");
          Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSearchWebQueryReady, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(paramInt), this.val$errMsg, this.wzK });
          AppMethodBeat.o(80577);
        }
      });
      return;
    }
    paramBundle = paramBundle.getString("fts_key_json_data", "");
    getHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80578);
        j localj = BaseSearchWebViewUI.this.getJsapi();
        String str = paramBundle;
        if (!localj.UcS) {
          Log.e("MicroMsg.JsApiHandler", "onCurrentLocationReady fail, not ready");
        }
        for (;;)
        {
          Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onCurrentLocationReady, json = %s", new Object[] { paramBundle });
          AppMethodBeat.o(80578);
          return;
          Log.i("MicroMsg.JsApiHandler", "onCurrentLocationReady success, ready");
          HashMap localHashMap = new HashMap();
          localHashMap.put("json", str);
          MMHandlerThread.postToMainThread(new j.42(localj, p.a.b("onCurrentLocationReady", localHashMap, localj.WDI, localj.KQY)));
        }
      }
    });
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements c<Bundle, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */