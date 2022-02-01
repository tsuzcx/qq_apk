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
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.p;
import com.tencent.mm.api.z;
import com.tencent.mm.api.z.a;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.webview.c.f.36;
import com.tencent.mm.plugin.webview.c.f.40;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;
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
  protected int EgA;
  protected String EgB;
  protected List<Runnable> EgC;
  private Runnable EgD;
  protected boolean Egv;
  private com.tencent.mm.plugin.webview.fts.c.b Egw;
  private Set<b.a> Egx = new HashSet();
  RelativeLayout Egy;
  protected int Egz;
  protected View fTl;
  private SmileyPanel gVn;
  protected String keN;
  private View mov;
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
      localObject2 = this.lvv.x(7, (Bundle)localObject1);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label93:
      break label93;
    }
    localObject2 = ((Bundle)localObject1).getString("emojiPath");
    if (!paramEmojiInfo.Eb())
    {
      localObject1 = localObject2;
      if (paramEmojiInfo.field_catalog != EmojiGroupInfo.OeL) {}
    }
    else
    {
      localObject1 = (String)localObject2 + "_fts";
    }
    return localObject1;
  }
  
  private static int aS(Bundle paramBundle)
  {
    return bt.aRe(paramBundle.getString("playerId"));
  }
  
  private void aT(Bundle paramBundle)
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
        ab localab;
        if (localJSONObject != null)
        {
          localab = new ab();
          localab.iconUrl = localJSONObject.optString("icon");
          localab.title = localJSONObject.optString("title");
          if (localJSONObject.optInt("selected") != 1) {
            break label156;
          }
        }
        label156:
        for (boolean bool = true;; bool = false)
        {
          localab.isSelected = bool;
          localab.desc = localJSONObject.optString("desc");
          localArrayList.add(localab);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.BaseSearchWebViewUI", bt.n(localJSONException));
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[] { str1, str2, str3 });
      if (!localArrayList.isEmpty()) {
        paramBundle.putInt("actionSheetId", ((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(this, str1, str2, localArrayList, new BaseSearchWebViewUI.6(this)));
      }
    }
  }
  
  private void cXv()
  {
    if (this.fTl != null)
    {
      this.fTl.setVisibility(8);
      if (this.EgD != null)
      {
        this.handler.removeCallbacks(this.EgD);
        this.EgD = null;
      }
    }
  }
  
  protected final Drawable XD(int paramInt)
  {
    int i = 2131691594;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return getResources().getDrawable(paramInt);
      paramInt = 2131691419;
      continue;
      paramInt = 2131691426;
      continue;
      paramInt = 2131691422;
      continue;
      paramInt = 2131691417;
      continue;
      paramInt = 2131691421;
      continue;
      paramInt = 2131691418;
      continue;
      paramInt = 2131691428;
      continue;
      paramInt = 2131691420;
      continue;
      paramInt = 2131691425;
      continue;
      paramInt = 2131691423;
      continue;
      paramInt = 2131691424;
      continue;
      paramInt = 2131691429;
    }
  }
  
  public final void a(b.a parama)
  {
    this.Egx.add(parama);
  }
  
  protected final void av(Runnable paramRunnable)
  {
    if ((getJsapi() != null) && (getJsapi().BHY))
    {
      paramRunnable.run();
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi not ready, waiting");
    if (this.EgC == null) {
      this.EgC = new ArrayList();
    }
    this.EgC.add(paramRunnable);
  }
  
  protected final void bRf()
  {
    super.bRf();
    if ((this.EgC != null) && (!this.EgC.isEmpty()))
    {
      Object localObject = new ArrayList(this.EgC);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready callback, running jsapi count %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      this.EgC.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready");
    ac.eLZ();
  }
  
  public void bzn()
  {
    super.bzn();
    if (this.Egw == null) {
      this.Egw = new com.tencent.mm.plugin.webview.fts.c.b(getContext(), this.omW, this);
    }
    this.Egw.DzP = getJsapi();
    if (this.lvv != null) {}
    for (;;)
    {
      try
      {
        this.lvv.k(51, new Bundle());
        this.Egy = ((RelativeLayout)findViewById(2131299401));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
    }
  }
  
  public final boolean bzp()
  {
    return true;
  }
  
  protected void d(int paramInt, String paramString, Map<String, Object> paramMap) {}
  
  public final void eOr()
  {
    if (this.mov == null) {}
    for (;;)
    {
      return;
      Object localObject = (ViewGroup)getWindow().getDecorView();
      ((ViewGroup)localObject).setSystemUiVisibility(0);
      ((ViewGroup)localObject).removeView(this.mov);
      getWindow().clearFlags(1024);
      if (getRequestedOrientation() == 0) {
        setRequestedOrientation(1);
      }
      this.mov = null;
      localObject = this.Egx.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).DA();
      }
    }
  }
  
  protected e eTR()
  {
    return null;
  }
  
  protected final void eTV()
  {
    super.eTV();
    int i = this.scene;
    String str1 = this.sessionId;
    String str2 = this.dCW;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.a(i, str1, str2, bool, this.query, this.type, this.EgB, this.DNn);
      return;
    }
  }
  
  public final void eTW()
  {
    if (this.Egy != null) {
      this.Egy.setVisibility(8);
    }
    if (this.gVn != null) {
      this.gVn.fbI();
    }
  }
  
  public void n(final int paramInt, final Bundle paramBundle)
  {
    boolean bool2 = true;
    final boolean bool1 = true;
    switch (paramInt)
    {
    default: 
      super.n(paramInt, paramBundle);
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
                  d(paramBundle.getInt("FTS_KEY_onStartWebSearch_type", 0), paramBundle.getString("FTS_KEY_onStartWebSearch_query"), (Map)paramBundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                  return;
                  localObject1 = paramBundle.getString("fts_key_json_data");
                } while (getJsapi() == null);
                try
                {
                  paramBundle = getJsapi();
                  localObject1 = new JSONObject((String)localObject1);
                  if (!paramBundle.BHY)
                  {
                    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.JsApiHandler", "not ready");
                    return;
                  }
                }
                catch (JSONException paramBundle)
                {
                  com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", paramBundle, "", new Object[0]);
                  return;
                }
                aq.f(new f.36(paramBundle, l.a.a("onGetMatchContactList", (JSONObject)localObject1, paramBundle.DMD, paramBundle.vJP)));
                return;
                aT(paramBundle);
                return;
                localObject1 = com.tencent.mm.plugin.websearch.widget.view.a.eMP();
                paramInt = paramBundle.getInt("actionSheetId");
                paramBundle = (com.tencent.mm.ui.widget.a.e)((com.tencent.mm.plugin.websearch.widget.view.a)localObject1).DEE.remove(Integer.valueOf(paramInt));
              } while (paramBundle == null);
              paramBundle.bpT();
              return;
              localObject1 = eTR();
              if (localObject1 != null)
              {
                paramInt = paramBundle.getInt("x", -1);
                int i = paramBundle.getInt("y", -1);
                localObject2 = paramBundle.getString("widgetId");
                paramBundle = paramBundle.getString("eventId");
                ((e)localObject1).DES.h(paramInt, i, (String)localObject2, paramBundle);
                return;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
              getJsapi().a(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
              return;
              localObject1 = this.Egw;
            } while (localObject1 == null);
            ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).O(aS(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
            return;
            localObject1 = this.Egw;
          } while (localObject1 == null);
          ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).P(aS(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
          return;
          localObject1 = this.Egw;
        } while (localObject1 == null);
        ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).WC(aS(paramBundle));
        return;
        localObject1 = this.Egw;
      } while (localObject1 == null);
      ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).cy(aS(paramBundle), paramBundle.getString("type"));
      return;
    case 145: 
      localObject1 = getJsapi();
      if (!((com.tencent.mm.plugin.webview.c.f)localObject1).BHY)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
      localObject2 = new HashMap();
      ((Map)localObject2).put("json", paramBundle.getString("json"));
      ((Map)localObject2).put("searchId", paramBundle.getString("searchId"));
      ((Map)localObject2).put("poiId", paramBundle.getString("poiId"));
      aq.f(new f.40((com.tencent.mm.plugin.webview.c.f)localObject1, l.a.b("onGetPoiInfoReturn", (Map)localObject2, ((com.tencent.mm.plugin.webview.c.f)localObject1).DMD, ((com.tencent.mm.plugin.webview.c.f)localObject1).vJP)));
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
            AppMethodBeat.i(208164);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cYy, this.leS, paramInt, bool1);
            AppMethodBeat.o(208164);
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
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cYy, "loading", -1, bool1);
            AppMethodBeat.o(80573);
          }
        });
        return;
      }
    case 150: 
      cXv();
      return;
    case 151: 
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "GOTO_EMOTICON");
      hideVKB();
      paramBundle = paramBundle.getString("requestId");
      if (this.gVn == null)
      {
        this.gVn = aa.bh(this);
        this.gVn.setEntranceScene(ChatFooterPanel.ESs);
        this.gVn.setVisibility(0);
        this.gVn.setShowSmiley(false);
        this.gVn.onResume();
        localObject1 = new RelativeLayout.LayoutParams(-1, aa.bi(this));
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.Egy.addView(this.gVn, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new TextView(getApplicationContext());
        ((TextView)localObject1).setBackgroundColor(com.tencent.mm.cc.a.n(this, 2131099679));
        ((TextView)localObject1).setPadding(0, com.tencent.mm.cc.a.ay(this, 2131165289), 0, com.tencent.mm.cc.a.ay(this, 2131165289));
        ((TextView)localObject1).setTextColor(com.tencent.mm.cc.a.n(this, 2131100490));
        ((TextView)localObject1).setTextSize(15.0F);
        ((TextView)localObject1).setText(2131762943);
        ((TextView)localObject1).setGravity(17);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aa.bi(this);
        this.Egy.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = aa.Lo();
        ((z)localObject1).cRW = new z.a()
        {
          public final void a(final p paramAnonymousp)
          {
            AppMethodBeat.i(208166);
            final String str1 = BaseSearchWebViewUI.this.Egz + ";" + BaseSearchWebViewUI.this.sessionId + ";" + paramBundle;
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this).set16029ExtraInfo(str1);
            paramAnonymousp = (EmojiInfo)paramAnonymousp;
            str1 = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymousp);
            Object localObject1;
            if ((paramAnonymousp.Eb()) || (paramAnonymousp.field_catalog == EmojiGroupInfo.OeL))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "emoji is system emoji %s", new Object[] { Integer.valueOf(paramAnonymousp.field_catalog) });
              if (!i.fv(str1))
              {
                localObject1 = paramAnonymousp.z(BaseSearchWebViewUI.this, 480);
                if (localObject1 == null) {}
              }
            }
            try
            {
              com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject1, 80, Bitmap.CompressFormat.PNG, str1, false);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "save emoji bitmap %d %s", new Object[] { Long.valueOf(i.aYo(str1)), str1 });
              str1 = "weixin://fts/emoji?path=".concat(String.valueOf(str1));
              localObject1 = paramAnonymousp.field_md5;
              final String str2 = paramAnonymousp.field_aeskey;
              final String str3 = paramAnonymousp.field_encrypturl;
              boolean bool = paramAnonymousp.fOu();
              i = 0;
              if (com.tencent.mm.plugin.emoji.h.b.x(paramAnonymousp))
              {
                i = 1;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSelectedEmoji %s %s %b", new Object[] { localObject1, str1, Boolean.valueOf(bool) });
                Object localObject2 = BaseSearchWebViewUI.this.getJsapi();
                if (!bool) {
                  break label386;
                }
                j = 0;
                ((com.tencent.mm.plugin.webview.c.f)localObject2).a((String)localObject1, str1, i, j, str3, str2);
                if (!bool)
                {
                  localObject2 = com.tencent.mm.emoji.loader.e.giz;
                  com.tencent.mm.emoji.loader.e.a(paramAnonymousp, new i.a()
                  {
                    public final void dg(boolean paramAnonymous2Boolean)
                    {
                      int i = 0;
                      AppMethodBeat.i(208165);
                      if (paramAnonymous2Boolean)
                      {
                        Object localObject = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymousp);
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s emojiPath %s exist %b", new Object[] { this.lxP, str1, localObject, Boolean.valueOf(i.fv((String)localObject)) });
                        localObject = BaseSearchWebViewUI.this.getJsapi();
                        String str1 = this.lxP;
                        String str2 = str1;
                        int j = i;
                        if (paramAnonymous2Boolean) {}
                        for (;;)
                        {
                          ((com.tencent.mm.plugin.webview.c.f)localObject).a(str1, str2, j, i, str3, str2);
                          AppMethodBeat.o(208165);
                          return;
                          i = 1;
                        }
                      }
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s fail", new Object[] { this.lxP, str1 });
                      AppMethodBeat.o(208165);
                    }
                  });
                }
                BaseSearchWebViewUI.this.Egy.setVisibility(8);
                AppMethodBeat.o(208166);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                final int i;
                int j;
                com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localException, "SaveEmojiBitmap", new Object[0]);
                continue;
                if (com.tencent.mm.plugin.emoji.h.b.y(paramAnonymousp))
                {
                  i = 2;
                }
                else if (com.tencent.mm.plugin.emoji.h.b.w(paramAnonymousp))
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
        this.gVn.setCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      }
      this.Egy.setVisibility(0);
      return;
    case 152: 
      paramInt = paramBundle.getInt("fts_key_ret_code");
      localObject1 = paramBundle.getString("fts_key_err_msg");
      paramBundle = paramBundle.getString("fts_key_json_data", "");
      this.handler.post(new BaseSearchWebViewUI.4(this, paramInt, (String)localObject1, paramBundle));
      return;
    }
    paramInt = paramBundle.getInt("fts_key_ret_code");
    Object localObject1 = paramBundle.getString("fts_key_err_msg");
    Object localObject2 = paramBundle.getString("fts_key_json_data", "");
    paramBundle = paramBundle.getString("fts_key_id", "");
    this.handler.post(new BaseSearchWebViewUI.5(this, paramInt, (String)localObject1, (String)localObject2, paramBundle));
  }
  
  public void onBackPressed()
  {
    eTW();
    Iterator localIterator = this.Egx.iterator();
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
      this.Egv = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
    }
    if (this.Egw == null) {
      this.Egw = new com.tencent.mm.plugin.webview.fts.c.b(getContext(), this.omW, this);
    }
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.Egz = this.scene;
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.query = getIntent().getStringExtra("ftsQuery");
    this.EgB = getIntent().getStringExtra("tabId");
    this.keN = getIntent().getStringExtra("searchId");
    this.EgA = this.type;
    int i = this.scene;
    paramBundle = this.sessionId;
    String str = this.dCW;
    if (this.type == 0) {
      bool = true;
    }
    ac.a(i, paramBundle, str, bool, this.query, this.type, this.EgB, this.DNn, this.keN);
    if (!com.tencent.mm.plugin.websearch.api.ad.n(this, this.scene)) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "request for grant location permission");
    }
    for (;;)
    {
      paramBundle = View.inflate(this, 2131495324, null);
      paramBundle.setBackgroundResource(2131101053);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.fTl = paramBundle;
      if ((this.fTl != null) && ((getContentView() instanceof ViewGroup))) {
        ((ViewGroup)getContentView()).addView(this.fTl);
      }
      cXv();
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "has location permission");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.Egx.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).onDestroy();
    }
    this.Egx.clear();
    int i = this.scene;
    localObject = this.sessionId;
    String str = this.dCW;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.a(i, (String)localObject, str, bool, this.query, this.type, this.DNn);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "onDestroy");
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator;
    if (paramInt == 25)
    {
      localIterator = this.Egx.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).eOp();
      }
    }
    if (paramInt == 24)
    {
      localIterator = this.Egx.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).eOq();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.Egx.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onBackground();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length > 0) {}
    for (paramArrayOfString = paramArrayOfInt[0];; paramArrayOfString = "")
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onRequestPermissionsResult, granted ? %s", new Object[] { paramArrayOfString });
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.Egx.iterator();
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
    eOr();
    this.mov = paramView;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (com.tencent.mm.compatible.util.d.lz(19)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */