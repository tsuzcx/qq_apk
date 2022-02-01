package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
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
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.d.h.36;
import com.tencent.mm.plugin.webview.d.h.38;
import com.tencent.mm.plugin.webview.d.h.41;
import com.tencent.mm.plugin.webview.d.h.47;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.u;
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
  protected boolean QjP;
  protected boolean QkQ;
  private com.tencent.mm.plugin.webview.fts.c.b QkR;
  private Set<b.a> QkS = new HashSet();
  RelativeLayout QkT;
  protected int QkU;
  protected int QkV;
  protected String QkW;
  protected boolean QkX;
  private Runnable QkY;
  protected String jQi;
  protected View jkB;
  private SmileyPanel kFp;
  private View qGl;
  protected String query;
  protected int scene;
  protected int type;
  
  private String D(EmojiInfo paramEmojiInfo)
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
      localObject2 = this.pGC.y(7, (Bundle)localObject1);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label93:
      break label93;
    }
    localObject2 = ((Bundle)localObject1).getString("emojiPath");
    if (!paramEmojiInfo.Qv())
    {
      localObject1 = localObject2;
      if (paramEmojiInfo.field_catalog != EmojiGroupInfo.YCv) {}
    }
    else
    {
      localObject1 = (String)localObject2 + "_fts";
    }
    return localObject1;
  }
  
  private static int bd(Bundle paramBundle)
  {
    return Util.safeParseInt(paramBundle.getString("playerId"));
  }
  
  private void be(Bundle paramBundle)
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
        paramBundle.putInt("actionSheetId", ((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.f.class)).a(this, str1, str2, localArrayList, new ae()
        {
          public final void lq(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(80579);
            if (BaseSearchWebViewUI.this.getJsapi() != null)
            {
              com.tencent.mm.plugin.webview.d.h localh = BaseSearchWebViewUI.this.getJsapi();
              if (!localh.NoX)
              {
                Log.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
                AppMethodBeat.o(80579);
                return;
              }
              Log.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
              HashMap localHashMap = new HashMap();
              localHashMap.put("index", Integer.valueOf(paramAnonymousInt1));
              localHashMap.put("actionSheetId", Integer.valueOf(paramAnonymousInt2));
              MMHandlerThread.postToMainThread(new h.36(localh, n.a.b("onSearchActionSheetClick", localHashMap, localh.PNx, localh.EVx)));
            }
            AppMethodBeat.o(80579);
          }
        }));
      }
    }
  }
  
  private void ewK()
  {
    if (this.jkB != null)
    {
      this.jkB.setVisibility(8);
      if (this.QkY != null)
      {
        btS().removeCallbacks(this.QkY);
        this.QkY = null;
      }
    }
  }
  
  public final void a(b.a parama)
  {
    this.QkS.add(parama);
  }
  
  protected Drawable aoJ(int paramInt)
  {
    int i = c.h.icons_outlined_wechat_search_one_search;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return au.e(getResources().getDrawable(paramInt), c.c.FG_2);
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
  
  protected final void bXI()
  {
    super.bXI();
    Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready");
    ah.gQE();
  }
  
  protected void c(int paramInt, String paramString, Map<String, Object> paramMap) {}
  
  public void cjK()
  {
    super.cjK();
    if (this.QkR == null) {
      this.QkR = new com.tencent.mm.plugin.webview.fts.c.b(getContext(), this.pHS, this);
    }
    this.QkR.PvJ = getJsapi();
    if (this.pGC != null) {
      try
      {
        this.pGC.l(51, new Bundle());
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
  
  public final boolean cjM()
  {
    return true;
  }
  
  public final void gTG()
  {
    if (this.qGl == null) {}
    for (;;)
    {
      return;
      Object localObject = (ViewGroup)getWindow().getDecorView();
      ((ViewGroup)localObject).setSystemUiVisibility(0);
      ((ViewGroup)localObject).removeView(this.qGl);
      getWindow().clearFlags(1024);
      if (getRequestedOrientation() == 0) {
        setRequestedOrientation(1);
      }
      this.qGl = null;
      localObject = this.QkS.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).PS();
      }
    }
  }
  
  protected e hac()
  {
    return null;
  }
  
  protected final void hag()
  {
    super.hag();
    int i = this.scene;
    String str1 = this.sessionId;
    String str2 = this.fPs;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ah.a(i, str1, str2, bool, this.query, this.type, this.QkW, this.POj);
      return;
    }
  }
  
  public final void hah()
  {
    if ((this.QfI) || (!this.QjP)) {
      super.hideVKB();
    }
  }
  
  public final void hai()
  {
    if (this.QkT != null) {
      this.QkT.setVisibility(8);
    }
    if (this.kFp != null) {
      this.kFp.hjr();
    }
  }
  
  public void o(final int paramInt, final Bundle paramBundle)
  {
    boolean bool2 = true;
    final boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      super.o(paramInt, paramBundle);
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
                  if (!paramBundle.NoX)
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
                MMHandlerThread.postToMainThread(new h.38(paramBundle, n.a.a("onGetMatchContactList", (JSONObject)localObject1, paramBundle.PNx, paramBundle.EVx)));
                return;
                be(paramBundle);
                return;
                localObject1 = com.tencent.mm.plugin.websearch.widget.view.a.gRO();
                paramInt = paramBundle.getInt("actionSheetId");
                paramBundle = (com.tencent.mm.ui.widget.a.e)((com.tencent.mm.plugin.websearch.widget.view.a)localObject1).PCO.remove(Integer.valueOf(paramInt));
              } while (paramBundle == null);
              paramBundle.bYF();
              return;
              localObject1 = hac();
              if (localObject1 != null)
              {
                paramInt = paramBundle.getInt("x", -1);
                int i = paramBundle.getInt("y", -1);
                localObject2 = paramBundle.getString("widgetId");
                paramBundle = paramBundle.getString("eventId");
                ((e)localObject1).PCW.h(paramInt, i, (String)localObject2, paramBundle);
                return;
              }
              Log.e("MicroMsg.WebSearch.BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
              getJsapi().b(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
              return;
              localObject1 = this.QkR;
            } while (localObject1 == null);
            ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).U(bd(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
            return;
            localObject1 = this.QkR;
          } while (localObject1 == null);
          ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).V(bd(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
          return;
          localObject1 = this.QkR;
        } while (localObject1 == null);
        ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).anG(bd(paramBundle));
        return;
        localObject1 = this.QkR;
      } while (localObject1 == null);
      ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).cS(bd(paramBundle), paramBundle.getString("type"));
      return;
    case 145: 
      localObject1 = getJsapi();
      if (!((com.tencent.mm.plugin.webview.d.h)localObject1).NoX)
      {
        Log.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
        return;
      }
      Log.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
      localObject2 = new HashMap();
      ((Map)localObject2).put("json", paramBundle.getString("json"));
      ((Map)localObject2).put("searchId", paramBundle.getString("searchId"));
      ((Map)localObject2).put("poiId", paramBundle.getString("poiId"));
      MMHandlerThread.postToMainThread(new h.47((com.tencent.mm.plugin.webview.d.h)localObject1, n.a.b("onGetPoiInfoReturn", (Map)localObject2, ((com.tencent.mm.plugin.webview.d.h)localObject1).PNx, ((com.tencent.mm.plugin.webview.d.h)localObject1).EVx)));
      return;
    case 148: 
      localObject1 = paramBundle.getString("title", "");
      localObject2 = paramBundle.getString("icon", "");
      paramInt = paramBundle.getInt("duration", 500);
      if (paramBundle.getInt("mask", 0) > 0) {}
      for (;;)
      {
        btS().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(214598);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cWz, this.pmp, paramInt, bool1);
            AppMethodBeat.o(214598);
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
        btS().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80573);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cWz, "loading", -1, bool1);
            AppMethodBeat.o(80573);
          }
        });
        return;
      }
    case 150: 
      ewK();
      return;
    case 151: 
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "GOTO_EMOTICON");
      hideVKB();
      paramBundle = paramBundle.getString("requestId");
      if (this.kFp == null)
      {
        this.kFp = ad.bB(this);
        this.kFp.setEntranceScene(ChatFooterPanel.Rck);
        this.kFp.setVisibility(0);
        this.kFp.setShowSmiley(false);
        this.kFp.onResume();
        localObject1 = new RelativeLayout.LayoutParams(-1, ad.bC(this));
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.QkT.addView(this.kFp, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new TextView(getApplicationContext());
        ((TextView)localObject1).setBackgroundColor(com.tencent.mm.ci.a.w(this, c.c.BW_93));
        ((TextView)localObject1).setPadding(0, com.tencent.mm.ci.a.aZ(this, c.d.Edge_2A), 0, com.tencent.mm.ci.a.aZ(this, c.d.Edge_2A));
        ((TextView)localObject1).setTextColor(com.tencent.mm.ci.a.w(this, c.c.hint_text_color));
        ((TextView)localObject1).setTextSize(15.0F);
        ((TextView)localObject1).setText(c.i.search_emoji_header);
        ((TextView)localObject1).setGravity(17);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ad.bC(this);
        this.QkT.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = ad.aaf();
        ((ac)localObject1).faJ = new ac.a()
        {
          public final void a(final r paramAnonymousr)
          {
            AppMethodBeat.i(219352);
            final String str1 = BaseSearchWebViewUI.this.QkU + ";" + BaseSearchWebViewUI.this.sessionId + ";" + paramBundle;
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this).set16029ExtraInfo(str1);
            paramAnonymousr = (EmojiInfo)paramAnonymousr;
            str1 = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymousr);
            Object localObject1;
            if ((paramAnonymousr.Qv()) || (paramAnonymousr.field_catalog == EmojiGroupInfo.YCv))
            {
              Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "emoji is system emoji %s", new Object[] { Integer.valueOf(paramAnonymousr.field_catalog) });
              if (!u.agG(str1))
              {
                localObject1 = paramAnonymousr.C(BaseSearchWebViewUI.this, 480);
                if (localObject1 == null) {}
              }
            }
            try
            {
              BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 80, Bitmap.CompressFormat.PNG, str1, false);
              Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "save emoji bitmap %d %s", new Object[] { Long.valueOf(u.bBQ(str1)), str1 });
              str1 = "weixin://fts/emoji?path=".concat(String.valueOf(str1));
              localObject1 = paramAnonymousr.field_md5;
              final String str2 = paramAnonymousr.field_aeskey;
              final String str3 = paramAnonymousr.field_encrypturl;
              boolean bool = paramAnonymousr.hBp();
              i = 0;
              if (com.tencent.mm.plugin.emoji.i.b.y(paramAnonymousr))
              {
                i = 1;
                Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSelectedEmoji %s %s %b", new Object[] { localObject1, str1, Boolean.valueOf(bool) });
                Object localObject2 = BaseSearchWebViewUI.this.getJsapi();
                if (!bool) {
                  break label386;
                }
                j = 0;
                ((com.tencent.mm.plugin.webview.d.h)localObject2).a((String)localObject1, str1, i, j, str3, str2);
                if (!bool)
                {
                  localObject2 = com.tencent.mm.emoji.loader.e.jGI;
                  com.tencent.mm.emoji.loader.e.a(paramAnonymousr, new i.a()
                  {
                    public final void ep(boolean paramAnonymous2Boolean)
                    {
                      int i = 0;
                      AppMethodBeat.i(261995);
                      if (paramAnonymous2Boolean)
                      {
                        Object localObject = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymousr);
                        Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s emojiPath %s exist %b", new Object[] { this.lQU, str1, localObject, Boolean.valueOf(u.agG((String)localObject)) });
                        localObject = BaseSearchWebViewUI.this.getJsapi();
                        String str1 = this.lQU;
                        String str2 = str1;
                        int j = i;
                        if (paramAnonymous2Boolean) {}
                        for (;;)
                        {
                          ((com.tencent.mm.plugin.webview.d.h)localObject).a(str1, str2, j, i, str3, str2);
                          AppMethodBeat.o(261995);
                          return;
                          i = 1;
                        }
                      }
                      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s fail", new Object[] { this.lQU, str1 });
                      AppMethodBeat.o(261995);
                    }
                  });
                }
                BaseSearchWebViewUI.this.QkT.setVisibility(8);
                AppMethodBeat.o(219352);
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
                if (com.tencent.mm.plugin.emoji.i.b.z(paramAnonymousr))
                {
                  i = 2;
                }
                else if (com.tencent.mm.plugin.emoji.i.b.x(paramAnonymousr))
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
        this.kFp.setCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      }
      this.QkT.setVisibility(0);
      return;
    case 152: 
      paramInt = paramBundle.getInt("fts_key_ret_code");
      localObject1 = paramBundle.getString("fts_key_err_msg");
      paramBundle = paramBundle.getString("fts_key_json_data", "");
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221424);
          BaseSearchWebViewUI.this.getJsapi().i(paramInt, this.val$errMsg, paramBundle, "", "onSimilarEmoticonReady");
          Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "wxaapp_opsearch resp, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(paramInt), this.val$errMsg, paramBundle });
          AppMethodBeat.o(221424);
        }
      });
      return;
    case 153: 
      paramInt = paramBundle.getInt("fts_key_ret_code");
      localObject1 = paramBundle.getString("fts_key_err_msg");
      localObject2 = paramBundle.getString("fts_key_json_data", "");
      paramBundle = paramBundle.getString("fts_key_id", "");
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80577);
          BaseSearchWebViewUI.this.getJsapi().i(paramInt, this.val$errMsg, this.tvn, paramBundle, "onSearchWebQueryReady");
          Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSearchWebQueryReady, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(paramInt), this.val$errMsg, this.tvn });
          AppMethodBeat.o(80577);
        }
      });
      return;
    }
    paramBundle = paramBundle.getString("fts_key_json_data", "");
    btS().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80578);
        com.tencent.mm.plugin.webview.d.h localh = BaseSearchWebViewUI.this.getJsapi();
        String str = paramBundle;
        if (!localh.NoX) {
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
          MMHandlerThread.postToMainThread(new h.41(localh, n.a.b("onCurrentLocationReady", localHashMap, localh.PNx, localh.EVx)));
        }
      }
    });
  }
  
  public void onBackPressed()
  {
    hai();
    Iterator localIterator = this.QkS.iterator();
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
      this.QkQ = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
    }
    if (this.QkR == null) {
      this.QkR = new com.tencent.mm.plugin.webview.fts.c.b(getContext(), this.pHS, this);
    }
    this.QjP = getIntent().getBooleanExtra("ftsneedkeyboard", false);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.QkU = this.scene;
    this.QkX = getIntent().getBooleanExtra("key_search_icon_and_hint_fix_default", false);
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.query = getIntent().getStringExtra("ftsQuery");
    this.QkW = getIntent().getStringExtra("tabId");
    this.jQi = getIntent().getStringExtra("searchId");
    this.QkV = this.type;
    int i = this.scene;
    paramBundle = this.sessionId;
    String str = this.fPs;
    if (this.type == 0) {
      bool = true;
    }
    ah.a(i, paramBundle, str, bool, this.query, this.type, this.QkW, this.POj, this.jQi);
    if (!ai.o(this, this.scene)) {
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "request for grant location permission");
    }
    for (;;)
    {
      paramBundle = View.inflate(this, c.g.search_loading_dialog_layout, null);
      paramBundle.setBackgroundResource(c.c.transparent);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jkB = paramBundle;
      if ((this.jkB != null) && ((getContentView() instanceof ViewGroup))) {
        ((ViewGroup)getContentView()).addView(this.jkB);
      }
      ewK();
      this.QkT = ((RelativeLayout)findViewById(c.f.emoji_panel_layout));
      return;
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "has location permission");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.QkS.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).onDestroy();
    }
    this.QkS.clear();
    int i = this.scene;
    localObject = this.sessionId;
    String str = this.fPs;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ah.a(i, (String)localObject, str, bool, this.query, this.type, this.POj);
      Log.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "onDestroy");
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator;
    if (paramInt == 25)
    {
      localIterator = this.QkS.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).gTE();
      }
    }
    if (paramInt == 24)
    {
      localIterator = this.QkS.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).gTF();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.QkS.iterator();
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
    Iterator localIterator = this.QkS.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void y(View paramView, boolean paramBoolean)
  {
    gTG();
    this.qGl = paramView;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (com.tencent.mm.compatible.util.d.qW(19)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */