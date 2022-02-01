package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ah;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.d.h.42;
import com.tencent.mm.plugin.webview.d.h.45;
import com.tencent.mm.plugin.webview.d.h.48;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.statemachine.IState;
import com.tencent.mm.sdk.statemachine.LogStateTransitionState;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.aa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI
  extends BaseSOSWebViewUI
{
  private View HhP;
  private boolean MXl;
  boolean PyC;
  private int PyD;
  private int QlA;
  private String QlB;
  private boolean QlC;
  private a QlD;
  private a QlE;
  private a.a QlF;
  private a.a QlG;
  private a.a QlH;
  private String QlI;
  private int QlJ;
  private View.OnClickListener QlK;
  private WebViewKeyboardLinearLayout Qll;
  private View Qlm;
  private View Qln;
  private TextView Qlo;
  private b Qlp;
  private c Qlq;
  private d Qlr;
  private float Qls;
  private float Qlt;
  private View Qlu;
  private b Qlv;
  private int Qlw;
  private int Qlx;
  private String Qly;
  private int Qlz;
  private View qnL;
  private View wWQ;
  
  public FTSSOSHomeWebViewUI()
  {
    AppMethodBeat.i(80651);
    this.Qls = 0.0F;
    this.Qlt = 0.0F;
    this.Qlx = 0;
    this.Qly = "";
    this.Qlz = 0;
    this.QlA = 0;
    this.QlB = "";
    this.QlD = a.QlQ;
    this.QlE = a.QlO;
    this.MXl = false;
    this.QlF = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80633);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(4);
        FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80633);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80634);
        FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80634);
      }
    };
    this.QlG = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80621);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(9);
        FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80621);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80622);
        FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80622);
      }
    };
    this.QlH = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80623);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(3);
        FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80623);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80624);
        FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80624);
      }
    };
    this.QlK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(267822);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267822);
      }
    };
    AppMethodBeat.o(80651);
  }
  
  private static void A(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(222444);
    ah localah = new ah();
    localah.geN = paramInt1;
    localah.giu = 0;
    localah.iX(paramString);
    localah.ggl = paramInt2;
    localah.giA = System.currentTimeMillis();
    localah.bpa();
    AppMethodBeat.o(222444);
  }
  
  private void Dk(boolean paramBoolean)
  {
    AppMethodBeat.i(222382);
    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "updateWebViewStatus isCancelling:%b visible:%s", new Object[] { Boolean.valueOf(this.QkA), Boolean.valueOf(paramBoolean) });
    if (this.Qll != null)
    {
      if ((!this.QkA) && (paramBoolean))
      {
        this.Qll.setAlpha(1.0F);
        AppMethodBeat.o(222382);
        return;
      }
      this.Qll.setAlpha(0.0F);
    }
    AppMethodBeat.o(222382);
  }
  
  private boolean a(a parama)
  {
    AppMethodBeat.i(222342);
    if (this.QlD != a.QlQ)
    {
      parama = this.QlD;
      hap();
    }
    if (this.MXl)
    {
      grX();
      gqi();
    }
    if ((parama == a.QlO) && (gZR()))
    {
      AppMethodBeat.o(222342);
      return false;
    }
    if ((this.QlC) && (super.getJsapi() != null))
    {
      com.tencent.mm.plugin.webview.d.h localh = super.getJsapi();
      if (!localh.NoX) {
        Log.e("MicroMsg.JsApiHandler", "onClientNavAction fail, not ready");
      }
      for (int i = 0; i != 0; i = 1)
      {
        this.QlE = parama;
        AppMethodBeat.o(222342);
        return true;
        Log.i("MicroMsg.JsApiHandler", "onClientNavAction success, ready");
        HashMap localHashMap = new HashMap();
        localHashMap.put("action", "willExitSearch");
        MMHandlerThread.postToMainThread(new h.42(localh, n.a.b("onClientNavAction", localHashMap, localh.PNx, localh.EVx)));
      }
    }
    AppMethodBeat.o(222342);
    return false;
  }
  
  private String aoK(int paramInt)
  {
    AppMethodBeat.i(80671);
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if ((ham()) || (this.scene == 53)) {
        paramInt = c.i.search_recommend_hint;
      }
      if (paramInt >= 0) {
        break label242;
      }
      if (Util.isNullOrNil(this.QlB)) {
        break;
      }
      str = getString(c.i.search_detail_page_hint, new Object[] { this.QlB });
      AppMethodBeat.o(80671);
      return str;
      paramInt = c.i.search_education_biz_contact;
      continue;
      paramInt = c.i.fts_header_timeline;
      continue;
      paramInt = c.i.search_education_article;
      continue;
      paramInt = c.i.fts_header_poi;
      continue;
      paramInt = c.i.app_brand_entrance;
      continue;
      paramInt = c.i.fts_header_emoji;
      continue;
      paramInt = c.i.fts_header_emoji_product;
      continue;
      paramInt = c.i.fts_header_music;
      continue;
      paramInt = c.i.fts_header_novel;
    }
    String str = getString(c.i.search_home_page_hint);
    AppMethodBeat.o(80671);
    return str;
    label242:
    str = getString(c.i.search_detail_page_hint, new Object[] { getString(paramInt) });
    AppMethodBeat.o(80671);
    return str;
  }
  
  private void aoL(int paramInt)
  {
    AppMethodBeat.i(80672);
    haa().getIconView().setImageDrawable(aoJ(paramInt));
    if (paramInt == 0) {
      haa().getIconView().setIconColor(getResources().getColor(c.c.FG_2));
    }
    AppMethodBeat.o(80672);
  }
  
  private void aoM(int paramInt)
  {
    AppMethodBeat.i(222430);
    if (getIntent().getBooleanExtra("key_hide_shadow_view", false))
    {
      this.HhP.setVisibility(8);
      AppMethodBeat.o(222430);
      return;
    }
    this.HhP.setVisibility(paramInt);
    AppMethodBeat.o(222430);
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(222373);
    if (((parama != a.QlO) && (parama != a.QlP)) || (this.kCv == null))
    {
      AppMethodBeat.o(222373);
      return;
    }
    if (parama == a.QlO) {
      if (com.tencent.mm.ui.ar.isDarkMode()) {
        this.kCv.setImageDrawable(au.o(this, c.h.actionbar_icon_dark_back, -1));
      }
    }
    for (;;)
    {
      this.kCv.setVisibility(0);
      AppMethodBeat.o(222373);
      return;
      this.kCv.setImageDrawable(au.o(this, c.h.actionbar_icon_dark_back, -16777216));
      continue;
      if (parama == a.QlP) {
        this.kCv.setImageDrawable(au.o(this, c.h.icons_outlined_close, c.c.FG_0));
      }
    }
  }
  
  private static String bmC(String paramString)
  {
    AppMethodBeat.i(80656);
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      try
      {
        int i = com.tencent.mm.ui.tools.g.bAB(paramString);
        if (i <= 100)
        {
          AppMethodBeat.o(80656);
          return paramString;
        }
        String str = paramString;
        localObject = paramString;
        if (paramString.length() > 200)
        {
          localObject = paramString;
          str = paramString.substring(0, 200);
        }
        localObject = str;
        paramString = str.toCharArray();
        localObject = str;
        int m = paramString.length;
        int j = 0;
        i = 0;
        int k = 0;
        for (;;)
        {
          localObject = str;
          if (j >= m) {
            break;
          }
          localObject = str;
          k += com.tencent.mm.ui.tools.g.bAB(String.valueOf(paramString[j]));
          if (k >= 100)
          {
            localObject = str;
            paramString = str.substring(0, i) + '…';
            AppMethodBeat.o(80656);
            return paramString;
          }
          j += 1;
          i += 1;
        }
        AppMethodBeat.o(80656);
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(80656);
        return localObject;
      }
    }
    return localObject;
  }
  
  private void gqi()
  {
    AppMethodBeat.i(222434);
    if (this.Qln != null) {
      this.Qln.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268174);
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "hideNavBarShadow");
          FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setVisibility(8);
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, false);
          AppMethodBeat.o(268174);
        }
      });
    }
    AppMethodBeat.o(222434);
  }
  
  private void grX()
  {
    AppMethodBeat.i(222432);
    if (super.getJsapi() != null) {
      super.getJsapi().gTX();
    }
    AppMethodBeat.o(222432);
  }
  
  private boolean ham()
  {
    return this.scene == 36;
  }
  
  private void han()
  {
    AppMethodBeat.i(80654);
    if (this.pHS == null)
    {
      AppMethodBeat.o(80654);
      return;
    }
    final View localView = this.pHS.getView();
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(267673);
        FTSSOSHomeWebViewUI.this.hai();
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) != null) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(15, paramAnonymousMotionEvent);
        }
        boolean bool = localView.onTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(267673);
        return bool;
      }
    });
    AppMethodBeat.o(80654);
  }
  
  private void hap()
  {
    AppMethodBeat.i(222378);
    if (this.PyD == 1)
    {
      if (com.tencent.mm.ui.ar.isDarkMode())
      {
        this.kCv.setImageDrawable(au.o(this, c.h.icons_outlined_close, -1));
        AppMethodBeat.o(222378);
        return;
      }
      this.kCv.setImageDrawable(au.o(this, c.h.icons_outlined_close, -16777216));
      AppMethodBeat.o(222378);
      return;
    }
    if (this.PyD == 2)
    {
      this.kCv.setVisibility(8);
      this.Qlw = 0;
      AppMethodBeat.o(222378);
      return;
    }
    this.kCv.setImageDrawable(au.o(this, c.h.actionbar_icon_dark_back, c.c.FG_0));
    AppMethodBeat.o(222378);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(164033);
    if (paramc == FTSEditTextView.c.XLV) {
      this.QlJ = 0;
    }
    super.a(paramString1, paramString2, paramList, paramc);
    AppMethodBeat.o(164033);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(80665);
    if (!hab())
    {
      AppMethodBeat.o(80665);
      return true;
    }
    this.Qlv.sendMessage(0);
    super.aDV();
    AppMethodBeat.o(80665);
    return true;
  }
  
  public final void aoF(int paramInt)
  {
    AppMethodBeat.i(80678);
    if ((this.pHS == null) || (this.pHS.getSettings() == null))
    {
      AppMethodBeat.o(80678);
      return;
    }
    float f = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.ci.a.kb(getContext()));
    if (f >= com.tencent.mm.ci.a.kh(getContext()))
    {
      this.pHS.getSettings().setTextZoom(160);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.ci.a.kg(getContext()))
    {
      this.pHS.getSettings().setTextZoom(150);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.ci.a.kf(getContext()))
    {
      this.pHS.getSettings().setTextZoom(140);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.ci.a.ke(getContext()))
    {
      this.pHS.getSettings().setTextZoom(130);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.ci.a.kd(getContext()))
    {
      this.pHS.getSettings().setTextZoom(120);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.ci.a.kc(getContext()))
    {
      this.pHS.getSettings().setTextZoom(110);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.ci.a.kb(getContext()))
    {
      this.pHS.getSettings().setTextZoom(100);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.ci.a.ka(getContext()))
    {
      this.pHS.getSettings().setTextZoom(90);
      AppMethodBeat.o(80678);
      return;
    }
    this.pHS.getSettings().setTextZoom(80);
    AppMethodBeat.o(80678);
  }
  
  protected final Drawable aoJ(int paramInt)
  {
    AppMethodBeat.i(222404);
    if (this.QkX)
    {
      localDrawable = getResources().getDrawable(c.h.icons_outlined_wechat_search_one_search);
      AppMethodBeat.o(222404);
      return localDrawable;
    }
    Drawable localDrawable = super.aoJ(paramInt);
    AppMethodBeat.o(222404);
    return localDrawable;
  }
  
  public final void cjK()
  {
    AppMethodBeat.i(80653);
    super.cjK();
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "searchID");
      this.Qly = this.pGC.w(6, (Bundle)localObject1).getString("result");
      for (;;)
      {
        try
        {
          label50:
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("key", "educationTab");
          localObject2 = this.pGC.w(2, (Bundle)localObject1);
          localObject1 = ((Bundle)localObject2).getString("result");
          localObject2 = ((Bundle)localObject2).getString("result_1");
          if (localObject2 != null) {
            continue;
          }
          localObject1 = new JSONObject((String)localObject1);
          localObject2 = ((JSONObject)localObject1).optJSONArray("items");
          final String str = ((JSONObject)localObject1).optString("title");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new JSONArray("[{\"businessType\":8,\"hotword\":\"朋友圈\",\"optype\":5},{\"businessType\":2,\"hotword\":\"文章\",\"optype\":5},{\"businessType\":1,\"hotword\":\"公众号\",\"optype\":5}]");
          }
          aJ(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(265358);
              com.tencent.mm.plugin.webview.d.h localh = FTSSOSHomeWebViewUI.this.getJsapi();
              JSONArray localJSONArray = this.QlN;
              String str = str;
              if (!localh.NoX)
              {
                Log.e("MicroMsg.JsApiHandler", "onGetVertSearchEntriesData fail, not ready");
                AppMethodBeat.o(265358);
                return;
              }
              Log.i("MicroMsg.JsApiHandler", "onGetVertSearchEntriesData success, ready");
              HashMap localHashMap = new HashMap();
              localHashMap.put("items", localJSONArray);
              localHashMap.put("title", str);
              MMHandlerThread.postToMainThread(new h.45(localh, n.a.b("onGetVertSearchEntriesData", localHashMap, localh.PNx, localh.EVx)));
              AppMethodBeat.o(265358);
            }
          });
        }
        catch (Exception localException1)
        {
          Object localObject2;
          continue;
        }
        this.wWQ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(267602);
            if ((FTSSOSHomeWebViewUI.this.Qks.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
              FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Qks.getLayoutParams()).topMargin);
            }
            AppMethodBeat.o(267602);
          }
        });
        AppMethodBeat.o(80653);
        return;
        localObject1 = localObject2;
      }
    }
    catch (Exception localException2)
    {
      break label50;
    }
  }
  
  public final int cjL()
  {
    boolean bool2 = false;
    AppMethodBeat.i(80661);
    boolean bool1 = bool2;
    if (getIntent() != null)
    {
      bool1 = bool2;
      if (getIntent().getBooleanExtra("ftsInitToSearch", false)) {
        bool1 = true;
      }
    }
    this.Qku = bool1;
    if ((com.tencent.mm.compatible.util.d.qV(23)) && (!MIUI.isMIUIV8()))
    {
      if (this.Qku)
      {
        AppMethodBeat.o(80661);
        return -1;
      }
      i = getResources().getColor(c.c.websearch_bg);
      AppMethodBeat.o(80661);
      return i;
    }
    int i = super.cjL();
    AppMethodBeat.o(80661);
    return i;
  }
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(80662);
    if (this.Qlv == null)
    {
      AppMethodBeat.o(80662);
      return;
    }
    if (this.Qlv.hae()) {
      super.eF(paramBoolean);
    }
    this.Qlv.sendMessage(5);
    AppMethodBeat.o(80662);
  }
  
  public void finish()
  {
    AppMethodBeat.i(222440);
    super.finish();
    if ((getScene() == 67) || (getScene() == 81) || (getScene() == 83)) {
      A(11, getIntent().getStringExtra("sessionId"), getScene());
    }
    AppMethodBeat.o(222440);
  }
  
  protected final void gZS()
  {
    AppMethodBeat.i(80666);
    super.gZS();
    this.Qlv.sendMessage(11);
    AppMethodBeat.o(80666);
  }
  
  protected final void gZT()
  {
    AppMethodBeat.i(80663);
    super.gZT();
    haa().setHint(aoK(this.QkV));
    AppMethodBeat.o(80663);
  }
  
  protected final void gZU()
  {
    AppMethodBeat.i(80667);
    if (this.Qlx > 0)
    {
      AppMethodBeat.o(80667);
      return;
    }
    if (a(a.QlP))
    {
      AppMethodBeat.o(80667);
      return;
    }
    super.gZU();
    this.pHS.scrollTo(0, 0);
    aoL(0);
    haa().hXB();
    haa().setHint(getHint());
    this.Qlv.sendMessage(2);
    this.Qks.setBackgroundResource(c.e.sos_round_corner);
    aoM(8);
    this.QlI = null;
    this.QlJ = 0;
    this.Qlm.setVisibility(0);
    com.tencent.mm.plugin.report.service.h.IzE.a(15521, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(1), haa().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.QkV) });
    AppMethodBeat.o(80667);
  }
  
  protected final void gZV()
  {
    AppMethodBeat.i(222357);
    Dk(true);
    AppMethodBeat.o(222357);
  }
  
  protected final void gZW()
  {
    AppMethodBeat.i(80668);
    super.gZW();
    Dk(true);
    if ((getScene() == 67) || (getScene() == 81)) {
      A(10, getIntent().getStringExtra("sessionId"), getScene());
    }
    AppMethodBeat.o(80668);
  }
  
  protected final void gZX()
  {
    AppMethodBeat.i(222366);
    super.gZX();
    if ((getScene() == 67) || (getScene() == 81)) {
      A(9, getIntent().getStringExtra("sessionId"), getScene());
    }
    AppMethodBeat.o(222366);
  }
  
  public final String gZY()
  {
    if (this.QlJ == 0) {
      return "";
    }
    return this.QlI;
  }
  
  public final int gZZ()
  {
    return this.QlJ;
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80669);
    if (this.QkX)
    {
      str = MMApplicationContext.getContext().getResources().getString(c.i.app_search);
      AppMethodBeat.o(80669);
      return str;
    }
    String str = aoK(getTabType());
    AppMethodBeat.o(80669);
    return str;
  }
  
  protected final com.tencent.mm.plugin.webview.d.h getJsapi()
  {
    AppMethodBeat.i(293016);
    com.tencent.mm.plugin.webview.d.h localh = super.getJsapi();
    AppMethodBeat.o(293016);
    return localh;
  }
  
  public int getLayoutId()
  {
    return c.g.sos_home_webview_ui;
  }
  
  protected final void grl()
  {
    AppMethodBeat.i(222345);
    if ((!gZR()) && (a(a.QlO)))
    {
      AppMethodBeat.o(222345);
      return;
    }
    super.grl();
    AppMethodBeat.o(222345);
  }
  
  public final boolean hae()
  {
    AppMethodBeat.i(80674);
    if (this.Qlv == null)
    {
      AppMethodBeat.o(80674);
      return false;
    }
    boolean bool = this.Qlv.hae();
    AppMethodBeat.o(80674);
    return bool;
  }
  
  protected final boolean haf()
  {
    AppMethodBeat.i(80675);
    if ((hae()) && (!this.Qlp.isAnimating) && (!this.Qlq.isAnimating) && (!this.Qlr.isAnimating))
    {
      AppMethodBeat.o(80675);
      return true;
    }
    AppMethodBeat.o(80675);
    return false;
  }
  
  protected final Map<String, Object> hao()
  {
    AppMethodBeat.i(80660);
    HashMap localHashMap = new HashMap();
    if (this.wWQ == null)
    {
      AppMethodBeat.o(80660);
      return localHashMap;
    }
    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getOnUiInitParams");
    localHashMap.put("nativeHeight", Integer.valueOf(0));
    for (;;)
    {
      try
      {
        localObject = this.pGC.w(7, null);
        if (localObject != null) {
          continue;
        }
        localObject = "";
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put("operationData", localObject);
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        String str;
        Log.printErrStackTrace("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", localException, "", new Object[0]);
        continue;
      }
      str = getIntent().getStringExtra("first_page_result");
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      localHashMap.put("cachePageResult", localObject);
      AppMethodBeat.o(80660);
      return localHashMap;
      localObject = ((Bundle)localObject).getString("data");
    }
  }
  
  public final void o(final int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80670);
    super.o(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80670);
      return;
      this.Qlv.sendMessage(8);
      AppMethodBeat.o(80670);
      return;
      this.Qlv.sendMessage(10);
      AppMethodBeat.o(80670);
      return;
      paramBundle.getString("fts_key_new_query", "");
      this.Qlv.sendMessage(13);
      AppMethodBeat.o(80670);
      return;
      String str = paramBundle.getString("fts_key_data", "exit");
      paramBundle = paramBundle.getString("fts_key_leftBar_button_type", "");
      if (TextUtils.equals("resignControl", str))
      {
        this.QlC = false;
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "AC_ON_NAV_CONTROL, forceBackType = " + this.QlD);
        if (this.QlD != a.QlQ) {
          hap();
        }
        this.QlD = a.QlQ;
      }
      for (;;)
      {
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "AC_ON_NAV_CONTROL mIsExitControl:%b, lastClickType:%s", new Object[] { Boolean.valueOf(this.QlC), this.QlE });
        AppMethodBeat.o(80670);
        return;
        if (TextUtils.equals("controlExit", str))
        {
          this.QlC = true;
          if (TextUtils.equals("exit", paramBundle))
          {
            this.QlD = a.QlP;
            b(this.QlD);
          }
          else if (TextUtils.equals("back", paramBundle))
          {
            this.QlD = a.QlO;
            b(this.QlD);
          }
          else
          {
            this.QlD = a.QlQ;
          }
        }
        else if (TextUtils.equals("exit", str))
        {
          this.QlC = false;
          this.QlD = a.QlQ;
          if (this.QlE == a.QlP) {
            gZU();
          } else {
            grl();
          }
        }
      }
      paramInt = paramBundle.getInt("fts_key_data");
      final int i = paramBundle.getInt("fts_key_cache");
      if (this.Qln != null) {
        this.Qln.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(268341);
            Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "showNavBarShadow %s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
            int i = paramInt;
            int j = i;
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setBackgroundColor(i + 16777216 * j);
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setVisibility(0);
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setOnClickListener(FTSSOSHomeWebViewUI.u(FTSSOSHomeWebViewUI.this));
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, true);
            AppMethodBeat.o(268341);
          }
        });
      }
      AppMethodBeat.o(80670);
      return;
      gqi();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(80655);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(80655);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("text");
      if (!TextUtils.isEmpty(paramIntent))
      {
        paramIntent = bmC(paramIntent);
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[] { Integer.valueOf(paramIntent.length()), paramIntent });
        this.Qkt.O(paramIntent, null);
        aDV();
        AppMethodBeat.o(80655);
        return;
      }
    }
    AppMethodBeat.o(80655);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80673);
    super.onBackPressed();
    haa().hXQ();
    AppMethodBeat.o(80673);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80652);
    super.onCreate(paramBundle);
    this.Qlv = new b("sos_home_webview_ui", getMainLooper());
    this.wWQ = findViewById(c.f.title_container);
    this.Qlu = findViewById(c.f.title_container_bg);
    this.Qlm = findViewById(c.f.container);
    this.qnL = findViewById(c.f.title_view);
    this.Qll = ((WebViewKeyboardLinearLayout)findViewById(c.f.webview_keyboard_ll));
    this.Qlo = ((TextView)findViewById(c.f.hide_search_bar_title_tv));
    this.Qln = findViewById(c.f.sos_home_actionbar_mask);
    this.Qll.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void SG(int paramAnonymousInt)
      {
        AppMethodBeat.i(80620);
        if (paramAnonymousInt == -2) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(12);
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, paramAnonymousInt);
        AppMethodBeat.o(80620);
      }
    });
    this.Qlp = new b(this, this.Qks, this.qnL, haa().getIconView(), this.kCv, this.kCv, haa().getEditText(), this.wWQ, this.Qlu);
    this.Qlp.a(this.QlF);
    this.Qlq = new c(this, this.Qks, this.qnL, haa().getIconView(), this.kCv, this.kCv, haa().getEditText(), this.wWQ, this.Qlu);
    this.Qlq.a(this.QlH);
    this.Qlr = new d(this, this.Qks, this.qnL, haa().getIconView(), this.kCv, this.kCv, haa().getEditText(), this.wWQ, this.Qlu);
    this.Qlr.a(this.QlG);
    this.HhP = findViewById(c.f.sos_shadow_view);
    findViewById(c.f.content_layout).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(266189);
        FTSSOSHomeWebViewUI.this.haa().bGw.clearFocus();
        FTSSOSHomeWebViewUI.this.hideVKB();
        AppMethodBeat.o(266189);
        return false;
      }
    });
    this.Qlw = com.tencent.mm.ci.a.fromDPToPix(this, 24);
    haa().gRA();
    haa().hXB();
    boolean bool;
    if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsInitToSearch", false)))
    {
      bool = true;
      this.Qku = bool;
      if ((getIntent() == null) || (!getIntent().getBooleanExtra("hideSearchInput", false))) {
        break label674;
      }
      bool = true;
      label415:
      this.PyC = bool;
      this.PyD = getIntent().getIntExtra("key_back_btn_type", 0);
      if (this.Qlv != null)
      {
        if (!this.Qku) {
          break label684;
        }
        this.Qks.setVisibility(0);
        this.Qlu.setBackgroundColor(getResources().getColor(c.c.transparent));
        paramBundle = this.Qlv;
        paramBundle.setInitialState(paramBundle.QlU);
        if ((com.tencent.mm.compatible.util.d.qV(23)) && (!com.tencent.mm.compatible.util.g.isMIUIV8()))
        {
          int i = getResources().getColor(c.c.white);
          if (com.tencent.mm.ui.ar.isDarkMode()) {
            break label679;
          }
          bool = true;
          label520:
          bF(i, bool);
        }
        label526:
        this.Qlv.start();
      }
      if (this.PyD != 1) {
        break label714;
      }
      if (!com.tencent.mm.ui.ar.isDarkMode()) {
        break label694;
      }
      this.kCv.setImageDrawable(au.o(this, c.h.icons_outlined_close, -1));
    }
    for (;;)
    {
      com.tencent.mm.plugin.websearch.api.ar.ann(getScene());
      han();
      this.Qks.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(265088);
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Qks.getX());
          FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Qks.getY());
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getSearchInputLayout originInputX=%s originInputY=%s", new Object[] { Float.valueOf(FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this)), Float.valueOf(FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this)) });
          AppMethodBeat.o(265088);
        }
      }, 100L);
      this.Qkt.setVoiceBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(267198);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "");
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), FTSSOSHomeWebViewUI.this });
          if (!bool)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(267198);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sessionId", FTSSOSHomeWebViewUI.this.sessionId);
          paramAnonymousView.putExtra("subSessionId", FTSSOSHomeWebViewUI.this.fPs);
          paramAnonymousView.putExtra("key_scene", FTSSOSHomeWebViewUI.this.scene);
          if (FTSSOSHomeWebViewUI.this.hae()) {}
          for (int i = 1;; i = 2)
          {
            paramAnonymousView.putExtra("key_is_nav_voice", i);
            com.tencent.mm.by.c.d(FTSSOSHomeWebViewUI.this, ".ui.websearch.WebSearchVoiceUI", paramAnonymousView, 1);
            FTSSOSHomeWebViewUI.this.overridePendingTransition(0, 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(267198);
            return;
          }
        }
      });
      this.Qkt.setCancelTextViewClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(80628);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FTSSOSHomeWebViewUI.this.gZU();
          FTSSOSHomeWebViewUI.this.hai();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(80628);
        }
      });
      aoL(getType());
      paramBundle = haa().getClearBtn();
      if (paramBundle != null) {
        paramBundle.getDrawable().setColorFilter(getResources().getColor(c.c.FG_0), PorterDuff.Mode.SRC_ATOP);
      }
      AppMethodBeat.o(80652);
      return;
      bool = false;
      break;
      label674:
      bool = false;
      break label415;
      label679:
      bool = false;
      break label520;
      label684:
      this.Qlv.haq();
      break label526;
      label694:
      this.kCv.setImageDrawable(au.o(this, c.h.icons_outlined_close, -16777216));
      continue;
      label714:
      if (this.PyD == 2)
      {
        this.kCv.setVisibility(8);
        this.Qlw = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80659);
    super.onDestroy();
    com.tencent.mm.plugin.websearch.api.ar.gQZ();
    com.tencent.mm.plugin.websearch.api.ar.gRa();
    AppMethodBeat.o(80659);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80658);
    super.onPause();
    com.tencent.mm.plugin.websearch.api.ar.gQY();
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.a.class) != null) {
      ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.a.class)).f(105, false, false);
    }
    AppMethodBeat.o(80658);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80657);
    super.onResume();
    com.tencent.mm.plugin.websearch.api.ar.gQX();
    AppMethodBeat.o(80657);
  }
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80677);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.pHS == null)
    {
      AppMethodBeat.o(80677);
      return;
    }
    paramInt1 = Math.min(paramInt2, Math.max(com.tencent.mm.ci.a.fromDPToPix(this, this.pHS.getContentHeight()) - this.pHS.getHeight(), 0));
    this.Qlp.aoN(this.Qlz - paramInt1);
    this.Qlq.aoN(this.Qlz - paramInt1);
    this.Qlr.aoN(this.Qlz - paramInt1);
    if (!this.Qlv.hae())
    {
      this.qnL.setTranslationY(-paramInt1);
      this.Qks.setTranslationY(-paramInt1);
    }
    if (paramInt2 != 0)
    {
      haa().bGw.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(80677);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(223954);
      QlO = new a("Back", 0);
      QlP = new a("cancel", 1);
      QlQ = new a("None", 2);
      QlR = new a[] { QlO, QlP, QlQ };
      AppMethodBeat.o(223954);
    }
    
    private a() {}
  }
  
  final class b
    extends StateMachine
  {
    State QlS;
    State QlT;
    State QlU;
    State QlV;
    
    protected b(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(80648);
      this.QlS = new a((byte)0);
      this.QlT = new d((byte)0);
      this.QlU = new b((byte)0);
      this.QlV = new c((byte)0);
      addState(this.QlS);
      addState(this.QlT);
      addState(this.QlU);
      addState(this.QlV);
      setInitialState(this.QlS);
      AppMethodBeat.o(80648);
    }
    
    public final boolean hae()
    {
      AppMethodBeat.i(80650);
      IState localIState = getCurrentState();
      if ((localIState == this.QlT) || (localIState == this.QlU) || (localIState == this.QlV))
      {
        AppMethodBeat.o(80650);
        return true;
      }
      AppMethodBeat.o(80650);
      return false;
    }
    
    public final void haq()
    {
      AppMethodBeat.i(80649);
      FTSSOSHomeWebViewUI.this.Qkt.setSearchBarCancelTextContainerVisibile(0);
      setInitialState(this.QlS);
      AppMethodBeat.o(80649);
    }
    
    final class a
      extends LogStateTransitionState
    {
      private a() {}
      
      public final void enter()
      {
        AppMethodBeat.i(80636);
        super.enter();
        FTSSOSHomeWebViewUI.f(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80636);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80637);
        super.exit();
        FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.this.getResources().getColor(c.c.transparent));
        AppMethodBeat.o(80637);
      }
      
      public final String getName()
      {
        return "InitSate";
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(80638);
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          boolean bool = super.processMessage(paramMessage);
          AppMethodBeat.o(80638);
          return bool;
          if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
          {
            FTSSOSHomeWebViewUI.this.haa().hXQ();
            FTSSOSHomeWebViewUI.this.haa().bGw.clearFocus();
            FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this).b(a.b.QmC);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.QmC);
            FTSSOSHomeWebViewUI.this.Qks.setBackgroundResource(c.c.white);
            continue;
            FTSSOSHomeWebViewUI.this.haa().hXQ();
            FTSSOSHomeWebViewUI.this.haa().bGw.clearFocus();
            FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this).a(a.b.QmC, false);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.QmC);
            FTSSOSHomeWebViewUI.this.Qks.setBackgroundResource(c.c.white);
            FTSSOSHomeWebViewUI.b.a(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlU);
            FTSSOSHomeWebViewUI.this.Qkz = true;
            continue;
            FTSSOSHomeWebViewUI.this.haa().hXQ();
            FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this).b(a.b.QmC);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.QmC);
            FTSSOSHomeWebViewUI.this.Qks.setBackgroundResource(c.c.white);
            continue;
            FTSSOSHomeWebViewUI.this.Qkz = true;
            FTSSOSHomeWebViewUI.b.b(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlT);
            continue;
            FTSSOSHomeWebViewUI.this.Qkz = true;
            FTSSOSHomeWebViewUI.b.c(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlU);
            continue;
            if ((FTSSOSHomeWebViewUI.this.haa().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0))
            {
              FTSSOSHomeWebViewUI.this.haa().hXQ();
              FTSSOSHomeWebViewUI.this.Qks.setBackgroundResource(c.c.white);
              FTSSOSHomeWebViewUI.this.Qkt.setSearchBarCancelTextContainerVisibile(8);
              FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this).b(a.b.QmC);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.QmC);
              FTSSOSHomeWebViewUI.this.aJ(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80635);
                  com.tencent.mm.plugin.webview.d.h localh = FTSSOSHomeWebViewUI.this.getJsapi();
                  if (!localh.NoX)
                  {
                    Log.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
                    AppMethodBeat.o(80635);
                    return;
                  }
                  Log.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
                  MMHandlerThread.postToMainThread(new h.48(localh, n.a.b("onFocusSearchInput", null, localh.PNx, localh.EVx)));
                  AppMethodBeat.o(80635);
                }
              });
              com.tencent.mm.plugin.report.service.h.IzE.a(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.this.haa().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.QkV) });
            }
          }
        }
      }
    }
    
    final class b
      extends LogStateTransitionState
    {
      private b() {}
      
      public final void enter()
      {
        AppMethodBeat.i(80639);
        super.enter();
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.QmC);
        FTSSOSHomeWebViewUI.this.Qks.setBackgroundResource(c.c.white);
        FTSSOSHomeWebViewUI.this.Qkt.bGw.clearFocus();
        FTSSOSHomeWebViewUI.this.hah();
        FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Qks.setPadding(FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.haa().hXQ();
        FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.this.Qkt.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Qkt.setVoiceImageButtonVisibile(0);
        FTSSOSHomeWebViewUI.this.Qkt.hXQ();
        FTSSOSHomeWebViewUI.this.Qkt.hXP();
        FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
        Object localObject;
        int i;
        if ((com.tencent.mm.compatible.util.d.qV(23)) && (!MIUI.isMIUIV8()))
        {
          localObject = FTSSOSHomeWebViewUI.this;
          i = FTSSOSHomeWebViewUI.this.getResources().getColor(c.c.white);
          if (com.tencent.mm.ui.ar.isDarkMode()) {
            break label696;
          }
        }
        label696:
        for (boolean bool = true;; bool = false)
        {
          FTSSOSHomeWebViewUI.a((FTSSOSHomeWebViewUI)localObject, i, bool);
          FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setAlpha(0.0F);
          localObject = (RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Qks.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (FTSSOSHomeWebViewUI.this.Qku) {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          }
          ((RelativeLayout.LayoutParams)localObject).width = -1;
          FTSSOSHomeWebViewUI.this.Qks.setLayoutParams((ViewGroup.LayoutParams)localObject);
          FTSSOSHomeWebViewUI.this.Qks.setY(0.0F);
          FTSSOSHomeWebViewUI.this.Qks.setX(0.0F);
          if (FTSSOSHomeWebViewUI.this.Qku)
          {
            FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setTranslationY(0.0F);
            FTSSOSHomeWebViewUI.this.Qks.setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.this.Qks.setTranslationY(0.0F);
          }
          if ((FTSSOSHomeWebViewUI.this.Qku) && (FTSSOSHomeWebViewUI.this.PyC))
          {
            FTSSOSHomeWebViewUI.this.Qks.setVisibility(8);
            FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setAlpha(1.0F);
            FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).setVisibility(0);
            FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setVisibility(8);
            if ((FTSSOSHomeWebViewUI.this.getIntent() != null) && (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("customize_status_bar_color")))
            {
              FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this));
              if (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("status_bar_style")) {
                FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this), "black".equals(FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this)));
              }
            }
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setVisibility(0);
            String str = FTSSOSHomeWebViewUI.this.getIntent().getStringExtra("title");
            localObject = str;
            if (Util.isNullOrNil(str)) {
              localObject = FTSSOSHomeWebViewUI.this.getString(c.i.find_friends_search);
            }
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setText((CharSequence)localObject);
          }
          FTSSOSHomeWebViewUI.this.hai();
          AppMethodBeat.o(80639);
          return;
        }
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80640);
        super.exit();
        AppMethodBeat.o(80640);
      }
      
      public final String getName()
      {
        return "SearchNoFocusState";
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(80641);
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          boolean bool = super.processMessage(paramMessage);
          AppMethodBeat.o(80641);
          return bool;
          if (!FTSSOSHomeWebViewUI.this.Qku)
          {
            FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this).b(a.b.QmB);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.QmB);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.b.d(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlS);
            continue;
            if (FTSSOSHomeWebViewUI.this.haa().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.b.e(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlT);
              com.tencent.mm.plugin.report.service.h.IzE.a(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.haa().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.QkV) });
              continue;
              FTSSOSHomeWebViewUI.this.haa().hXQ();
            }
          }
        }
      }
    }
    
    final class c
      extends LogStateTransitionState
    {
      private c() {}
      
      public final void enter()
      {
        AppMethodBeat.i(80642);
        super.enter();
        FTSSOSHomeWebViewUI.this.Qks.setPadding(FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Qks.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Qks.setY(0.0F);
        FTSSOSHomeWebViewUI.this.haa().hXQ();
        FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Qkt.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Qkt.setVoiceImageButtonVisibile(0);
        AppMethodBeat.o(80642);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80643);
        super.exit();
        FTSSOSHomeWebViewUI.this.hah();
        AppMethodBeat.o(80643);
      }
      
      public final String getName()
      {
        return "SearchWithFocusNoResultState";
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(80644);
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          boolean bool = super.processMessage(paramMessage);
          AppMethodBeat.o(80644);
          return bool;
          if (FTSSOSHomeWebViewUI.this.haa().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.b.i(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlT);
            com.tencent.mm.plugin.report.service.h.IzE.a(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.haa().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.QkV) });
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.b.j(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlU);
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
              {
                FTSSOSHomeWebViewUI.this.haa().hXQ();
                FTSSOSHomeWebViewUI.this.haa().bGw.clearFocus();
                FTSSOSHomeWebViewUI.b.k(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlU);
                continue;
                if (!FTSSOSHomeWebViewUI.this.Qku)
                {
                  FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this).b(a.b.QmB);
                  FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.QmB);
                }
                else
                {
                  FTSSOSHomeWebViewUI.this.finish();
                  continue;
                  FTSSOSHomeWebViewUI.b.l(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlS);
                }
              }
            }
          }
        }
      }
    }
    
    final class d
      extends LogStateTransitionState
    {
      private d() {}
      
      public final void enter()
      {
        boolean bool = false;
        AppMethodBeat.i(80645);
        super.enter();
        FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Qks.setPadding(FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Qks.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Qks.setY(0.0F);
        FTSSOSHomeWebViewUI.this.Qkt.setSearchBarCancelTextContainerVisibile(8);
        FTSSOSHomeWebViewUI.this.Qkt.setVoiceImageButtonVisibile(8);
        FTSSOSHomeWebViewUI.this.Qkt.hXP();
        FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
        if (!FTSSOSHomeWebViewUI.this.haa().bGw.hasFocus())
        {
          FTSSOSHomeWebViewUI.this.haa().aDU();
          FTSSOSHomeWebViewUI.this.showVKB();
        }
        if ((com.tencent.mm.compatible.util.d.qV(23)) && (!MIUI.isMIUIV8()))
        {
          FTSSOSHomeWebViewUI localFTSSOSHomeWebViewUI = FTSSOSHomeWebViewUI.this;
          int i = FTSSOSHomeWebViewUI.this.getResources().getColor(c.c.white);
          if (!com.tencent.mm.ui.ar.isDarkMode()) {
            bool = true;
          }
          FTSSOSHomeWebViewUI.c(localFTSSOSHomeWebViewUI, i, bool);
        }
        if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
          FTSSOSHomeWebViewUI.this.haa().hXR();
        }
        AppMethodBeat.o(80645);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80646);
        super.exit();
        FTSSOSHomeWebViewUI.this.hah();
        AppMethodBeat.o(80646);
      }
      
      public final String getName()
      {
        return "SearchWithFocusState";
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(80647);
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          boolean bool = super.processMessage(paramMessage);
          AppMethodBeat.o(80647);
          return bool;
          if (!FTSSOSHomeWebViewUI.this.Qku)
          {
            FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this).b(a.b.QmB);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.QmB);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.b.f(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlS);
            continue;
            if (!FTSSOSHomeWebViewUI.this.haa().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.b.g(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlU);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.haa().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.QkV) });
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                FTSSOSHomeWebViewUI.b.h(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.QlU);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI
 * JD-Core Version:    0.7.0.1
 */