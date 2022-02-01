package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.autogen.mmdata.rpt.ap;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView.b;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.j.43;
import com.tencent.mm.plugin.webview.jsapi.j.46;
import com.tencent.mm.plugin.webview.jsapi.j.49;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.statemachine.IState;
import com.tencent.mm.sdk.statemachine.LogStateTransitionState;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.KeyboardLinearLayout.b;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.ad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI
  extends BaseSOSWebViewUI
  implements FTSEditTextView.a, com.tencent.mm.ui.tools.h
{
  private View AtJ;
  private ObjectAnimator JWJ;
  private View NfI;
  private boolean TJM;
  boolean WoJ;
  private int WoK;
  private float XdA;
  private float XdB;
  private View XdC;
  private View XdD;
  private b XdE;
  private int XdF;
  private int XdG;
  private String XdH;
  private String XdI;
  protected View XdJ;
  private int XdK;
  private int XdL;
  private String XdM;
  private boolean XdN;
  private a XdO;
  private a XdP;
  public boolean XdQ;
  private a.a XdR;
  private a.a XdS;
  private a.a XdT;
  private String XdU;
  private int XdV;
  private View.OnClickListener XdW;
  private WebViewKeyboardLinearLayout Xds;
  private View Xdt;
  private ImageView Xdu;
  private View Xdv;
  private TextView Xdw;
  private b Xdx;
  private c Xdy;
  private d Xdz;
  final MMHandler handler;
  private i lKz;
  private View tss;
  
  public FTSSOSHomeWebViewUI()
  {
    AppMethodBeat.i(80651);
    this.XdA = 0.0F;
    this.XdB = 0.0F;
    this.XdG = 0;
    this.XdH = "";
    this.XdK = 0;
    this.XdL = 0;
    this.XdM = "";
    this.XdO = a.Xed;
    this.XdP = a.Xeb;
    this.TJM = false;
    this.XdQ = false;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(296777);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 101) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, "2");
        }
        AppMethodBeat.o(296777);
      }
    };
    this.JWJ = null;
    this.XdR = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(296796);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(4);
        FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(296796);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(296800);
        FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(296800);
      }
    };
    this.XdS = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(296794);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(9);
        FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(296794);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(296799);
        FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(296799);
      }
    };
    this.XdT = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(296808);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(3);
        FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(296808);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(296817);
        FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(296817);
      }
    };
    this.XdW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(296941);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(296941);
      }
    };
    AppMethodBeat.o(80651);
  }
  
  private static void F(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(296850);
    ap localap = new ap();
    localap.ilm = paramInt1;
    localap.ioZ = 0;
    localap.kC(paramString);
    localap.imW = paramInt2;
    localap.ipe = System.currentTimeMillis();
    localap.bMH();
    AppMethodBeat.o(296850);
  }
  
  private void IS(boolean paramBoolean)
  {
    AppMethodBeat.i(296830);
    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "updateWebViewStatus isCancelling:%b visible:%s", new Object[] { Boolean.valueOf(this.Xcx), Boolean.valueOf(paramBoolean) });
    if (this.Xds != null)
    {
      if ((this.Xcx) || (!paramBoolean)) {
        break label81;
      }
      this.Xds.setAlpha(1.0F);
    }
    for (;;)
    {
      if (!this.Xcn) {
        iAe().setClearBtnVisable(8);
      }
      AppMethodBeat.o(296830);
      return;
      label81:
      this.Xds.setAlpha(0.0F);
    }
  }
  
  private boolean a(a parama)
  {
    AppMethodBeat.i(296823);
    if (this.XdO != a.Xed)
    {
      parama = this.XdO;
      iAy();
    }
    if (this.TJM)
    {
      hOY();
      hNe();
    }
    if ((this.XdN) && (super.getJsapi() != null))
    {
      j localj = super.getJsapi();
      if (!localj.UcS) {
        Log.e("MicroMsg.JsApiHandler", "onClientNavAction fail, not ready");
      }
      for (int i = 0; i != 0; i = 1)
      {
        this.XdP = parama;
        AppMethodBeat.o(296823);
        return true;
        Log.i("MicroMsg.JsApiHandler", "onClientNavAction success, ready");
        HashMap localHashMap = new HashMap();
        localHashMap.put("action", "willExitSearch");
        MMHandlerThread.postToMainThread(new j.43(localj, p.a.b("onClientNavAction", localHashMap, localj.WDI, localj.KQY)));
      }
    }
    if ((parama == a.Xeb) && (izU()))
    {
      AppMethodBeat.o(296823);
      return false;
    }
    AppMethodBeat.o(296823);
    return false;
  }
  
  private String auF(int paramInt)
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
      if ((iAt()) || (this.scene == 53)) {
        paramInt = c.i.search_recommend_hint;
      }
      if (paramInt >= 0) {
        break label250;
      }
      if (Util.isNullOrNil(this.XdM)) {
        break;
      }
      str = getString(c.i.search_detail_page_hint, new Object[] { this.XdM });
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
    label250:
    str = getString(c.i.search_detail_page_hint, new Object[] { getString(paramInt) });
    AppMethodBeat.o(80671);
    return str;
  }
  
  private void auG(int paramInt)
  {
    AppMethodBeat.i(80672);
    if ((!this.WoS) && (!this.Xcn))
    {
      iAe().getIconView().setImageDrawable(getResources().getDrawable(c.e.trans_drawable));
      AppMethodBeat.o(80672);
      return;
    }
    iAe().getIconView().setImageDrawable(auD(paramInt));
    iAe().getIconView().setIconColor(getResources().getColor(c.c.FG_2));
    AppMethodBeat.o(80672);
  }
  
  private void auH(int paramInt)
  {
    AppMethodBeat.i(296839);
    if ((this.WoS) || (!this.Xcn))
    {
      this.NfI.setVisibility(8);
      AppMethodBeat.o(296839);
      return;
    }
    if (getIntent().getBooleanExtra("key_hide_shadow_view", false))
    {
      this.NfI.setVisibility(8);
      AppMethodBeat.o(296839);
      return;
    }
    this.NfI.setVisibility(paramInt);
    AppMethodBeat.o(296839);
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(296826);
    if (((parama != a.Xeb) && (parama != a.Xec)) || (this.nfU == null))
    {
      AppMethodBeat.o(296826);
      return;
    }
    if (parama == a.Xeb) {
      if (aw.isDarkMode()) {
        this.nfU.setImageDrawable(bb.m(this, c.h.actionbar_icon_dark_back, -1));
      }
    }
    for (;;)
    {
      this.nfU.setVisibility(0);
      AppMethodBeat.o(296826);
      return;
      this.nfU.setImageDrawable(bb.m(this, c.h.actionbar_icon_dark_back, -16777216));
      continue;
      if (parama == a.Xec) {
        this.nfU.setImageDrawable(bb.m(this, c.h.icons_outlined_close, -16777216));
      }
    }
  }
  
  private void bmd(String paramString)
  {
    AppMethodBeat.i(296804);
    if ((this.Xdw != null) && (this.Xdw.getVisibility() == 0) && (!Util.isNullOrNil(this.Xdw.getText())))
    {
      Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "reportAction25147, show hide searchtitle.");
      AppMethodBeat.o(296804);
      return;
    }
    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "stack = " + Util.getStack());
    String str1 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getString("sos_fts_search_data_tmp", "");
    Object localObject1 = new JSONObject();
    if (!Util.isNullOrNil(str1)) {}
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(str1);
        localObject1 = localObject2;
        localObject2 = ((JSONObject)localObject1).optString("requestId");
        int i = ((JSONObject)localObject1).optInt("type");
        String str2 = ((JSONObject)localObject1).optString("url");
        String str3 = ((JSONObject)localObject1).optString("parentSearchID");
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "requestId = %s, type = %s, searchData = %s, rawUrl = %s.", new Object[] { localObject2, Integer.valueOf(i), ((JSONObject)localObject1).toString(), str2 });
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "reportAction25147 searchData = %s, searchDataTmp = %s, mapRawUrl= %s.", new Object[] { localObject1, str1, str3 });
        a(this.sessionId, this.XdH, (String)localObject2, getScene(), 2, paramString, i, str3);
        AppMethodBeat.o(296804);
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private static String bme(String paramString)
  {
    AppMethodBeat.i(80656);
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      try
      {
        int i = com.tencent.mm.ui.tools.g.bCx(paramString);
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
          k += com.tencent.mm.ui.tools.g.bCx(String.valueOf(paramString[j]));
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
  
  private void def()
  {
    AppMethodBeat.i(296798);
    if ((this.Xdw != null) && (this.Xdw.getVisibility() == 0))
    {
      Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "reportExpose, show hide searchtitle.");
      AppMethodBeat.o(296798);
      return;
    }
    if (this.XdQ)
    {
      AppMethodBeat.o(296798);
      return;
    }
    this.XdQ = true;
    this.handler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296936);
        BaseSOSWebViewUI.a(FTSSOSHomeWebViewUI.this.sessionId, FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this), "", FTSSOSHomeWebViewUI.this.getScene(), 1, FTSSOSHomeWebViewUI.this.iAs(), 0L, "");
        AppMethodBeat.o(296936);
      }
    }, 1000L);
    AppMethodBeat.o(296798);
  }
  
  private void hNe()
  {
    AppMethodBeat.i(296845);
    if (this.Xdv != null) {
      this.Xdv.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(296943);
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "hideNavBarShadow");
          FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setVisibility(8);
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, false);
          AppMethodBeat.o(296943);
        }
      });
    }
    AppMethodBeat.o(296845);
  }
  
  private void hOY()
  {
    AppMethodBeat.i(296843);
    if (super.getJsapi() != null) {
      super.getJsapi().itF();
    }
    AppMethodBeat.o(296843);
  }
  
  private void iAA()
  {
    AppMethodBeat.i(296862);
    if (this.Xcf != null)
    {
      this.Xcf.setVisibility(0);
      this.Xcf.setBackgroundDrawable(getResources().getDrawable(c.e.sos_round_corner_super_bg));
      if (this.Xcf != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Xcf.getLayoutParams();
        localLayoutParams.rightMargin = ((int)getResources().getDimension(c.d.Edge_8A));
        localLayoutParams.leftMargin = ((int)getResources().getDimension(c.d.Edge_2A));
        this.Xcf.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(296862);
  }
  
  private boolean iAt()
  {
    return this.scene == 36;
  }
  
  private void iAu()
  {
    AppMethodBeat.i(80654);
    if (this.sMP == null)
    {
      AppMethodBeat.o(80654);
      return;
    }
    final View localView = this.sMP.getView();
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(296776);
        FTSSOSHomeWebViewUI.this.iAo();
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) != null) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(15, paramAnonymousMotionEvent);
        }
        boolean bool = localView.onTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(296776);
        return bool;
      }
    });
    AppMethodBeat.o(80654);
  }
  
  private boolean iAw()
  {
    AppMethodBeat.i(296820);
    if (!iAf())
    {
      AppMethodBeat.o(296820);
      return true;
    }
    this.XdE.sendMessage(0);
    super.aWU();
    AppMethodBeat.o(296820);
    return true;
  }
  
  private void iAy()
  {
    AppMethodBeat.i(296828);
    if (this.WoK == 1)
    {
      if (aw.isDarkMode())
      {
        this.nfU.setImageDrawable(bb.m(this, c.h.icons_outlined_close, -1));
        AppMethodBeat.o(296828);
        return;
      }
      this.nfU.setImageDrawable(bb.m(this, c.h.icons_outlined_close, -16777216));
      AppMethodBeat.o(296828);
      return;
    }
    if (this.WoK == 2)
    {
      this.nfU.setVisibility(8);
      this.XdF = 0;
      AppMethodBeat.o(296828);
      return;
    }
    this.nfU.setImageDrawable(bb.m(this, c.h.actionbar_icon_dark_back, -16777216));
    AppMethodBeat.o(296828);
  }
  
  private void iAz()
  {
    boolean bool = false;
    AppMethodBeat.i(296858);
    auH(8);
    this.Xcp = true;
    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "updateSearchBarStatus, isSearchInputBackLast = %s, isSearchInputTypeOld = %s, isSearchInputShowCancel = %s.", new Object[] { Boolean.valueOf(this.Xcm), Boolean.valueOf(this.Xcn), Boolean.valueOf(this.Xco) });
    if (!this.Xco)
    {
      iAe().setCancelBtnForceHide(true);
      iAe().setSearchBarCancelTextContainerVisibile(8);
    }
    if (!this.Xcm) {
      izV();
    }
    if (!this.Xcn)
    {
      iAe().setForceShowClearBtn(true);
      iAe().setActionSearchDoneListener(this);
      iAe().setCancelVisableChangeListener(new SOSEditTextView.b()
      {
        public final boolean atk(int paramAnonymousInt)
        {
          AppMethodBeat.i(296955);
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "updateActionDonePos, visibility = ".concat(String.valueOf(paramAnonymousInt)));
          if (!FTSSOSHomeWebViewUI.this.Xco)
          {
            AppMethodBeat.o(296955);
            return false;
          }
          SOSEditTextView localSOSEditTextView;
          if (FTSSOSHomeWebViewUI.this.iAe().getSearchBarCancelTextContainer() != null)
          {
            localSOSEditTextView = FTSSOSHomeWebViewUI.this.iAe();
            if (FTSSOSHomeWebViewUI.this.iAe().getSearchBarCancelTextContainer().getVisibility() != 0) {
              break label87;
            }
          }
          label87:
          for (boolean bool = true;; bool = false)
          {
            localSOSEditTextView.MT(bool);
            AppMethodBeat.o(296955);
            return false;
          }
        }
      });
      iAe().setSearchIconGone(0);
      iAe().jBL();
      iAe().setIconMarginVisable(8);
      if (iAe().getSearchBarCancelTextContainer() != null)
      {
        SOSEditTextView localSOSEditTextView = iAe();
        if (iAe().getSearchBarCancelTextContainer().getVisibility() == 0) {
          bool = true;
        }
        localSOSEditTextView.MT(bool);
      }
      iAA();
      iAe().setCommonRightBtnForceHide(true);
      iAe().setCommonRightImageButtonVisibile(8);
    }
    AppMethodBeat.o(296858);
  }
  
  public final boolean aWU()
  {
    AppMethodBeat.i(80665);
    boolean bool = iAw();
    AppMethodBeat.o(80665);
    return bool;
  }
  
  public final void atq(int paramInt)
  {
    AppMethodBeat.i(80678);
    if ((this.sMP == null) || (this.sMP.getSettings() == null))
    {
      AppMethodBeat.o(80678);
      return;
    }
    float f = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cd.a.md(getContext()));
    if (f >= com.tencent.mm.cd.a.mj(getContext()))
    {
      this.sMP.getSettings().setTextZoom(160);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.mi(getContext()))
    {
      this.sMP.getSettings().setTextZoom(150);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.mh(getContext()))
    {
      this.sMP.getSettings().setTextZoom(140);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.mg(getContext()))
    {
      this.sMP.getSettings().setTextZoom(130);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.mf(getContext()))
    {
      this.sMP.getSettings().setTextZoom(120);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.me(getContext()))
    {
      this.sMP.getSettings().setTextZoom(110);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.md(getContext()))
    {
      this.sMP.getSettings().setTextZoom(100);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.mc(getContext()))
    {
      this.sMP.getSettings().setTextZoom(90);
      AppMethodBeat.o(80678);
      return;
    }
    this.sMP.getSettings().setTextZoom(80);
    AppMethodBeat.o(80678);
  }
  
  protected final Drawable auD(int paramInt)
  {
    AppMethodBeat.i(297041);
    if ((!this.WoS) && (!this.Xcn))
    {
      localDrawable = getResources().getDrawable(c.e.trans_drawable);
      AppMethodBeat.o(297041);
      return localDrawable;
    }
    if (this.Xde)
    {
      localDrawable = getResources().getDrawable(c.h.icons_outlined_wechat_search_one_search);
      AppMethodBeat.o(297041);
      return localDrawable;
    }
    Drawable localDrawable = super.auD(paramInt);
    AppMethodBeat.o(297041);
    return localDrawable;
  }
  
  public final void auE(int paramInt)
  {
    AppMethodBeat.i(296963);
    if (this.XdD != null) {
      this.XdD.setVisibility(paramInt);
    }
    AppMethodBeat.o(296963);
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(80653);
    super.cKX();
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "searchID");
      this.XdH = this.sLC.z(6, (Bundle)localObject1).getString("result");
      for (;;)
      {
        try
        {
          label50:
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("key", "educationTab");
          localObject2 = this.sLC.z(2, (Bundle)localObject1);
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
          aS(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(296790);
              j localj = FTSSOSHomeWebViewUI.this.getJsapi();
              JSONArray localJSONArray = this.XdZ;
              String str = str;
              if (!localj.UcS)
              {
                Log.e("MicroMsg.JsApiHandler", "onGetVertSearchEntriesData fail, not ready");
                AppMethodBeat.o(296790);
                return;
              }
              Log.i("MicroMsg.JsApiHandler", "onGetVertSearchEntriesData success, ready");
              HashMap localHashMap = new HashMap();
              localHashMap.put("items", localJSONArray);
              localHashMap.put("title", str);
              MMHandlerThread.postToMainThread(new j.46(localj, p.a.b("onGetVertSearchEntriesData", localHashMap, localj.WDI, localj.KQY)));
              AppMethodBeat.o(296790);
            }
          });
        }
        catch (Exception localException1)
        {
          Object localObject2;
          continue;
        }
        this.AtJ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(296781);
            if ((FTSSOSHomeWebViewUI.this.Xcd.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
              FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Xcd.getLayoutParams()).topMargin);
            }
            AppMethodBeat.o(296781);
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
  
  public final int cKY()
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
    this.Xci = bool1;
    if ((com.tencent.mm.compatible.util.d.rb(23)) && (!MIUI.isMIUIV8()))
    {
      if (this.Xci)
      {
        AppMethodBeat.o(80661);
        return -1;
      }
      i = getResources().getColor(c.c.websearch_bg);
      AppMethodBeat.o(80661);
      return i;
    }
    int i = super.cKY();
    AppMethodBeat.o(80661);
    return i;
  }
  
  public void finish()
  {
    AppMethodBeat.i(297059);
    super.finish();
    if ((getScene() == 67) || (getScene() == 81) || (getScene() == 83) || (getScene() == 100)) {
      F(11, getIntent().getStringExtra("sessionId"), getScene());
    }
    AppMethodBeat.o(297059);
  }
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(80662);
    if (this.XdE == null)
    {
      AppMethodBeat.o(80662);
      return;
    }
    if (this.XdE.iAk()) {
      super.fq(paramBoolean);
    }
    if (!this.WoS) {
      this.XdE.sendMessage(5);
    }
    AppMethodBeat.o(80662);
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80669);
    if (this.Xde)
    {
      str = MMApplicationContext.getContext().getResources().getString(c.i.app_search);
      AppMethodBeat.o(80669);
      return str;
    }
    String str = auF(getTabType());
    AppMethodBeat.o(80669);
    return str;
  }
  
  protected final j getJsapi()
  {
    AppMethodBeat.i(369871);
    j localj = super.getJsapi();
    AppMethodBeat.o(369871);
    return localj;
  }
  
  public int getLayoutId()
  {
    return c.g.sos_home_webview_ui;
  }
  
  protected final void hOk()
  {
    AppMethodBeat.i(297025);
    this.handler.removeMessages(101);
    this.handler.sendEmptyMessageDelayed(101, 500L);
    if ((this.XdN) && (a(a.Xeb)))
    {
      AppMethodBeat.o(297025);
      return;
    }
    if ((!izU()) && (a(a.Xeb)))
    {
      AppMethodBeat.o(297025);
      return;
    }
    super.hOk();
    AppMethodBeat.o(297025);
  }
  
  protected final void iAa()
  {
    AppMethodBeat.i(80668);
    super.iAa();
    IS(true);
    if ((getScene() == 67) || (getScene() == 81) || (getScene() == 100)) {
      F(10, getIntent().getStringExtra("sessionId"), getScene());
    }
    AppMethodBeat.o(80668);
  }
  
  protected final void iAb()
  {
    AppMethodBeat.i(297031);
    super.iAb();
    if ((getScene() == 67) || (getScene() == 81) || (getScene() == 100)) {
      F(9, getIntent().getStringExtra("sessionId"), getScene());
    }
    AppMethodBeat.o(297031);
  }
  
  public final String iAc()
  {
    if (this.XdV == 0) {
      return "";
    }
    return this.XdU;
  }
  
  public final int iAd()
  {
    return this.XdV;
  }
  
  public final boolean iAk()
  {
    AppMethodBeat.i(80674);
    if (this.XdE == null)
    {
      AppMethodBeat.o(80674);
      return false;
    }
    boolean bool = this.XdE.iAk();
    AppMethodBeat.o(80674);
    return bool;
  }
  
  protected final boolean iAl()
  {
    AppMethodBeat.i(80675);
    if ((iAk()) && (!this.Xdx.isAnimating) && (!this.Xdy.isAnimating) && (!this.Xdz.isAnimating))
    {
      AppMethodBeat.o(80675);
      return true;
    }
    AppMethodBeat.o(80675);
    return false;
  }
  
  public final String iAs()
  {
    AppMethodBeat.i(296960);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (iAe().getClearBtn() != null)
    {
      localObject1 = localObject2;
      if (iAe().getClearBtn().getVisibility() == 0) {
        localObject1 = "1";
      }
    }
    localObject2 = localObject1;
    if (this.nfU != null)
    {
      localObject2 = localObject1;
      if (this.nfU.getVisibility() == 0)
      {
        localObject2 = new StringBuilder().append((String)localObject1);
        if (!Util.isNullOrNil((String)localObject1)) {
          break label197;
        }
        localObject1 = "";
        localObject2 = (String)localObject1 + "2";
      }
    }
    localObject1 = localObject2;
    if (iAe().getSearchDone() != null)
    {
      localObject1 = localObject2;
      if (iAe().getSearchDone().getVisibility() == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject2);
        if (!Util.isNullOrNil((String)localObject2)) {
          break label204;
        }
        localObject1 = "";
        label147:
        localObject1 = (String)localObject1 + "3";
      }
    }
    if ((this.Xdw != null) && (this.Xdw.getVisibility() == 0))
    {
      Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getFeatureInfo, show hide searchtitle.");
      localObject2 = localObject1;
    }
    label197:
    label204:
    do
    {
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(296960);
            return localObject2;
            localObject1 = "#";
            break;
            localObject1 = "#";
            break label147;
            localObject2 = localObject1;
          } while (iAe().getSearchBarCancelTextContainer() == null);
          localObject2 = localObject1;
        } while (iAe().getSearchBarCancelTextContainer().getVisibility() != 0);
        localObject2 = localObject1;
      } while (iAe().getCancelTextView() == null);
      localObject2 = localObject1;
    } while (iAe().getCancelTextView().getVisibility() != 0);
    localObject2 = new StringBuilder().append((String)localObject1);
    if (Util.isNullOrNil((String)localObject1)) {}
    for (localObject1 = "";; localObject1 = "#")
    {
      localObject2 = (String)localObject1 + "10";
      break;
    }
  }
  
  protected final Map<String, Object> iAv()
  {
    AppMethodBeat.i(80660);
    HashMap localHashMap = new HashMap();
    if (this.AtJ == null)
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
        localObject = this.sLC.z(7, null);
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
  
  public final boolean iAx()
  {
    AppMethodBeat.i(297019);
    bmd("3");
    boolean bool = iAw();
    AppMethodBeat.o(297019);
    return bool;
  }
  
  protected final void izW()
  {
    AppMethodBeat.i(80666);
    super.izW();
    this.XdE.sendMessage(11);
    AppMethodBeat.o(80666);
  }
  
  protected final void izX()
  {
    AppMethodBeat.i(80663);
    super.izX();
    iAe().setHint(auF(this.Xdc));
    AppMethodBeat.o(80663);
  }
  
  protected final void izY()
  {
    AppMethodBeat.i(80667);
    if (this.XdG > 0)
    {
      AppMethodBeat.o(80667);
      return;
    }
    if (a(a.Xec))
    {
      AppMethodBeat.o(80667);
      return;
    }
    super.izY();
    this.sMP.scrollTo(0, 0);
    auG(0);
    iAe().jBL();
    iAe().setHint(getHint());
    this.XdE.sendMessage(2);
    this.Xcd.setBackgroundResource(c.e.sos_round_corner);
    auH(8);
    this.XdU = null;
    this.XdV = 0;
    this.Xdt.setVisibility(0);
    com.tencent.mm.plugin.report.service.h.OAn.b(15521, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(1), iAe().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.Xdc) });
    AppMethodBeat.o(80667);
  }
  
  protected final void izZ()
  {
    AppMethodBeat.i(297026);
    IS(true);
    AppMethodBeat.o(297026);
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
        paramIntent = bme(paramIntent);
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[] { Integer.valueOf(paramIntent.length()), paramIntent });
        this.Xch.V(paramIntent, null);
        aWU();
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
    iAe().jCx();
    AppMethodBeat.o(80673);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(297033);
    super.onClickClearTextBtn(paramView);
    bmd("1");
    AppMethodBeat.o(297033);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80652);
    super.onCreate(paramBundle);
    this.XdE = new b("sos_home_webview_ui", getMainLooper());
    this.AtJ = findViewById(c.f.title_container);
    this.XdC = findViewById(c.f.title_container_bg);
    this.XdD = findViewById(c.f.fts_sos_voice_btns_layout);
    this.Xdt = findViewById(c.f.container);
    this.tss = findViewById(c.f.title_view);
    this.Xds = ((WebViewKeyboardLinearLayout)findViewById(c.f.webview_keyboard_ll));
    this.Xdu = ((ImageView)findViewById(c.f.voice_search_start_btn));
    this.Xdw = ((TextView)findViewById(c.f.hide_search_bar_title_tv));
    this.Xdv = findViewById(c.f.sos_home_actionbar_mask);
    this.XdJ = findViewById(c.f.search_icon);
    this.Xds.setOnkbdStateListener(new KeyboardLinearLayout.b()
    {
      public final void onKeyBoardStateChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(296953);
        if (paramAnonymousInt == -2) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(12);
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, paramAnonymousInt);
        AppMethodBeat.o(296953);
      }
    });
    this.Xdx = new b(this, this.Xcd, this.tss, iAe().getIconView(), this.nfU, this.nfU, iAe().getEditText(), this.AtJ, this.XdC, this.Xcf, iAe().getSearchDone());
    this.Xdx.a(this.XdR);
    this.Xdy = new c(this, this.Xcd, this.tss, iAe().getIconView(), this.nfU, this.nfU, iAe().getEditText(), this.AtJ, this.XdC, this.Xcf, iAe().getSearchDone());
    this.Xdy.a(this.XdT);
    this.Xdz = new d(this, this.Xcd, this.tss, iAe().getIconView(), this.nfU, this.nfU, iAe().getEditText(), this.AtJ, this.XdC, this.Xcf, iAe().getSearchDone());
    this.Xdz.a(this.XdS);
    this.NfI = findViewById(c.f.sos_shadow_view);
    findViewById(c.f.content_layout).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80626);
        FTSSOSHomeWebViewUI.this.iAe().dzv.clearFocus();
        FTSSOSHomeWebViewUI.this.hideVKB();
        AppMethodBeat.o(80626);
        return false;
      }
    });
    this.Xcm = FTSEditTextView.jCz();
    this.Xcn = FTSEditTextView.jCA();
    this.Xco = FTSEditTextView.jCB();
    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "initData, isSearchInputBackLast = %s, isSearchInputTypeOld = %s, isSearchInputShowCancel = %s.", new Object[] { Boolean.valueOf(this.Xcm), Boolean.valueOf(this.Xcn), Boolean.valueOf(this.Xco) });
    this.XdF = com.tencent.mm.cd.a.fromDPToPix(this, 24);
    iAe().iqO();
    iAe().jBL();
    boolean bool;
    label547:
    int i;
    label666:
    label672:
    label739:
    label879:
    LinearLayout.LayoutParams localLayoutParams;
    if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsInitToSearch", false)))
    {
      bool = true;
      this.Xci = bool;
      if ((getIntent() == null) || (!getIntent().getBooleanExtra("hideSearchInput", false))) {
        break label1175;
      }
      bool = true;
      this.WoJ = bool;
      this.WoK = getIntent().getIntExtra("key_back_btn_type", 0);
      this.XdI = getIntent().getStringExtra("key_search_bar_text_color");
      if (this.XdE != null)
      {
        if (!this.Xci) {
          break label1185;
        }
        this.Xcd.setVisibility(0);
        this.XdC.setBackgroundColor(getResources().getColor(c.c.transparent));
        paramBundle = this.XdE;
        paramBundle.setInitialState(paramBundle.Xeh);
        if ((com.tencent.mm.compatible.util.d.rb(23)) && (!com.tencent.mm.compatible.util.g.isMIUIV8()))
        {
          i = getResources().getColor(c.c.white);
          if (aw.isDarkMode()) {
            break label1180;
          }
          bool = true;
          cn(i, bool);
        }
        this.XdE.start();
      }
      if (this.Xdu != null) {
        this.Xdu.setImageDrawable(bb.m(this, c.h.icons_outlined_mike, com.tencent.mm.cd.a.w(getContext(), c.c.BW_0_Alpha_0_5)));
      }
      if (this.WoK != 1) {
        break label1215;
      }
      if (!aw.isDarkMode()) {
        break label1195;
      }
      this.nfU.setImageDrawable(bb.m(this, c.h.icons_outlined_close, -1));
      Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "searchBarTextColor = " + this.XdI);
      if ("placeholderColor".equals(this.XdI)) {
        iAe().setTextColor(getResources().getColor(c.c.FG_2));
      }
      as.dD(getScene(), this.sessionId);
      iAu();
      this.Xcd.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(296952);
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Xcd.getX());
          FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Xcd.getY());
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getSearchInputLayout originInputX=%s originInputY=%s", new Object[] { Float.valueOf(FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this)), Float.valueOf(FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this)) });
          AppMethodBeat.o(296952);
        }
      }, 100L);
      this.Xch.setCameraBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(80628);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
          Object localObject2 = new HashMap();
          ((HashMap)localObject2).put("sessionId", FTSSOSHomeWebViewUI.this.sessionId);
          ((HashMap)localObject2).put("scene", FTSSOSHomeWebViewUI.this.scene);
          localObject1 = FTSSOSHomeWebViewUI.this;
          paramAnonymousView = FTSSOSHomeWebViewUI.this.Xch.getContext();
          if ((!com.tencent.mm.n.a.dl(paramAnonymousView)) && (!com.tencent.mm.n.a.dp(paramAnonymousView)) && (com.tencent.mm.pluginsdk.permission.b.a((Activity)paramAnonymousView, "android.permission.CAMERA", 18, "")))
          {
            localObject2 = (String)((HashMap)localObject2).get("sessionId");
            Object localObject3 = new VideoTransPara();
            ((VideoTransPara)localObject3).duration = 10000;
            localObject3 = RecordConfigProvider.a("", "", (VideoTransPara)localObject3, ((VideoTransPara)localObject3).duration * 1000, 16);
            ((RecordConfigProvider)localObject3).NHV = Boolean.TRUE;
            ((RecordConfigProvider)localObject3).NHW = Boolean.FALSE;
            ((RecordConfigProvider)localObject3).NHY = Boolean.TRUE;
            ((RecordConfigProvider)localObject3).NHR.text = ((BaseSearchWebViewUI)localObject1).getResources().getString(c.i.plugin_soso_opt);
            if (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVi, true)) {
              break label277;
            }
            localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(paramAnonymousView, 101, b.a.sight_slide_bottom_in, b.a.sight_slide_bottom_out, (RecordConfigProvider)localObject3);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80628);
            return;
            label277:
            Log.e("MicroMsg.WebSearch.BaseSearchWebViewUI", "openCamera, jumpToMediaRecordNew = false.");
            t.a(paramAnonymousView, 101, new Intent(), 3, (String)localObject2);
          }
        }
      });
      this.Xch.setCancelTextViewClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(80629);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          FTSSOSHomeWebViewUI.this.izY();
          FTSSOSHomeWebViewUI.this.iAo();
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, "10");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(80629);
        }
      });
      paramBundle = iAe();
      if ((!this.WoS) && (!this.Xcn)) {
        break label1240;
      }
      i = 1;
      if (paramBundle.mpe != null)
      {
        if (i == 0) {
          break label1245;
        }
        localLayoutParams = (LinearLayout.LayoutParams)paramBundle.mpe.getLayoutParams();
        localLayoutParams.width = ((int)(paramBundle.getResources().getDimension(a.e.Edge_2A) * com.tencent.mm.cd.a.getScaleSize(paramBundle.getContext())));
        localLayoutParams.height = ((int)(paramBundle.getResources().getDimension(a.e.Edge_2A) * com.tencent.mm.cd.a.getScaleSize(paramBundle.getContext())));
        localLayoutParams.leftMargin = ((int)paramBundle.getResources().getDimension(a.e.Edge_A));
        localLayoutParams.rightMargin = ((int)paramBundle.getResources().getDimension(a.e.Edge_A));
        paramBundle.mpe.setLayoutParams(localLayoutParams);
      }
      label991:
      auG(getType());
      paramBundle = iAe().getClearBtn();
      if (paramBundle != null) {
        paramBundle.getDrawable().setColorFilter(getResources().getColor(c.c.FG_0), PorterDuff.Mode.SRC_ATOP);
      }
      if (this.XdJ != null) {
        this.XdJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(296942);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (FTSSOSHomeWebViewUI.this.WoS)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(296942);
              return;
            }
            if (FTSSOSHomeWebViewUI.this.Xch != null)
            {
              FTSSOSHomeWebViewUI.this.Xch.aWT();
              FTSSOSHomeWebViewUI.this.Xch.showVKB();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(296942);
          }
        });
      }
      if ((iAt()) || (this.scene == 53)) {
        this.Xch.setCancelTextViewVisibile(8);
      }
      this.XdD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(80632);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this) == -3)
          {
            FTSSOSHomeWebViewUI.this.hideVKB();
            FTSSOSHomeWebViewUI.f(FTSSOSHomeWebViewUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80631);
                FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
                AppMethodBeat.o(80631);
              }
            }, 300L);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80632);
            return;
            FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
          }
        }
      });
      if (!this.WoS)
      {
        if (!this.Xci) {
          break label1305;
        }
        iAz();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "onCreate, needSosEditTextToBeTouchOnly = %s, isInitToSearch = %s.", new Object[] { Boolean.valueOf(this.WoS), Boolean.valueOf(this.Xci) });
      this.lKz = new i(this);
      this.lKz.afIL = this;
      AppMethodBeat.o(80652);
      return;
      bool = false;
      break;
      label1175:
      bool = false;
      break label547;
      label1180:
      bool = false;
      break label666;
      label1185:
      this.XdE.iAB();
      break label672;
      label1195:
      this.nfU.setImageDrawable(bb.m(this, c.h.icons_outlined_close, -16777216));
      break label739;
      label1215:
      if (this.WoK != 2) {
        break label739;
      }
      this.nfU.setVisibility(8);
      this.XdF = 0;
      break label739;
      label1240:
      i = 0;
      break label879;
      label1245:
      localLayoutParams = (LinearLayout.LayoutParams)paramBundle.mpe.getLayoutParams();
      localLayoutParams.width = ((int)(paramBundle.getResources().getDimension(a.e.Edge_1_5_A) * com.tencent.mm.cd.a.jO(paramBundle.getContext())));
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      paramBundle.mpe.setLayoutParams(localLayoutParams);
      break label991;
      label1305:
      iAA();
      if (this.Xcf != null) {
        this.Xcf.setVisibility(8);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80659);
    super.onDestroy();
    as.iql();
    as.iqm();
    AppMethodBeat.o(80659);
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(164033);
    if (paramd == FTSEditTextView.d.afCj) {
      this.XdV = 0;
    }
    super.onEditTextChange(paramString1, paramString2, paramList, paramd);
    AppMethodBeat.o(164033);
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(296973);
    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "onKeyboardHeightChanged, height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.JWJ != null) && (this.JWJ.isRunning())) {
      this.JWJ.cancel();
    }
    View localView = this.XdD;
    if (localView == null)
    {
      AppMethodBeat.o(296973);
      return;
    }
    if (paramInt > 0)
    {
      if (localView.getTranslationY() != 0.0F) {
        localView.setTranslationY(0.0F);
      }
      this.JWJ = ObjectAnimator.ofFloat(localView, "translationY", new float[] { 0.0F, -paramInt });
      this.XdD.setVisibility(0);
    }
    for (;;)
    {
      this.JWJ.setDuration(200L);
      this.JWJ.setInterpolator(new androidx.g.a.a.b());
      this.JWJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(296791);
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
          AppMethodBeat.o(296791);
        }
      });
      this.JWJ.start();
      AppMethodBeat.o(296973);
      return;
      this.JWJ = ObjectAnimator.ofFloat(localView, "translationY", new float[] { localView.getTranslationY(), 0.0F });
      this.XdD.setVisibility(8);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80658);
    super.onPause();
    as.iqk();
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.a.class) != null) {
      ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.a.class)).f(105, false, false);
    }
    if (this.lKz != null) {
      this.lKz.close();
    }
    AppMethodBeat.o(80658);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80657);
    super.onResume();
    as.iqj();
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(80657);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80677);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.sMP == null)
    {
      AppMethodBeat.o(80677);
      return;
    }
    paramInt1 = Math.min(paramInt2, Math.max(com.tencent.mm.cd.a.fromDPToPix(this, this.sMP.getContentHeight()) - this.sMP.getHeight(), 0));
    this.Xdx.auI(this.XdK - paramInt1);
    this.Xdy.auI(this.XdK - paramInt1);
    this.Xdz.auI(this.XdK - paramInt1);
    if (!this.XdE.iAk())
    {
      this.tss.setTranslationY(-paramInt1);
      this.Xcd.setTranslationY(-paramInt1);
    }
    if (paramInt2 != 0)
    {
      iAe().dzv.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(80677);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(296969);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    if (this.Xci) {
      def();
    }
    AppMethodBeat.o(296969);
  }
  
  public final void q(final int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80670);
    super.q(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80670);
      return;
      this.XdE.sendMessage(8);
      AppMethodBeat.o(80670);
      return;
      this.XdE.sendMessage(10);
      AppMethodBeat.o(80670);
      return;
      paramBundle.getString("fts_key_new_query", "");
      this.XdE.sendMessage(13);
      AppMethodBeat.o(80670);
      return;
      Object localObject = paramBundle.getString("fts_key_data", "exit");
      String str = paramBundle.getString("fts_key_leftBar_button_type", "");
      Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "handleFTSAction, action = ".concat(String.valueOf(localObject)));
      if (TextUtils.equals("resignControl", (CharSequence)localObject))
      {
        this.XdN = false;
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "AC_ON_NAV_CONTROL, forceBackType = " + this.XdO);
        if (this.XdO != a.Xed) {
          iAy();
        }
        this.XdO = a.Xed;
      }
      do
      {
        for (;;)
        {
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "AC_ON_NAV_CONTROL mIsExitControl:%b, lastClickType:%s", new Object[] { Boolean.valueOf(this.XdN), this.XdP });
          AppMethodBeat.o(80670);
          return;
          if (TextUtils.equals("controlExit", (CharSequence)localObject))
          {
            this.XdN = true;
            if (TextUtils.equals("exit", str))
            {
              this.XdO = a.Xec;
              b(this.XdO);
            }
            else if (TextUtils.equals("back", str))
            {
              this.XdO = a.Xeb;
              b(this.XdO);
            }
            else
            {
              this.XdO = a.Xed;
            }
          }
          else
          {
            if (!TextUtils.equals("exit", (CharSequence)localObject)) {
              break;
            }
            this.XdN = false;
            this.XdO = a.Xed;
            izY();
          }
        }
      } while (!TextUtils.equals("configNavBar", (CharSequence)localObject));
      int j = paramBundle.getInt("key_back_btn_type", 0);
      label436:
      int k;
      if (j == 1) {
        if (aw.isDarkMode())
        {
          this.nfU.setImageDrawable(bb.m(this, c.h.icons_outlined_close, -1));
          localObject = paramBundle.getString("key_search_bar_text_color");
          if ("placeholderColor".equals(localObject)) {
            iAe().setTextColor(getResources().getColor(c.c.hint_text_color));
          }
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "handleFTSAction, searchBarTextColor = %s.", new Object[] { localObject });
          if ((paramBundle.getBoolean("key_search_hide_nav_bottom_line")) && (this.Xcg != null)) {
            this.Xcg.setVisibility(8);
          }
          k = paramBundle.getInt("hideSearchInput", 0);
          if (k != 0)
          {
            if (k != 1) {
              break label936;
            }
            Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "first enter, hideSearchBarType = " + k + ", isHideSearchInput = " + this.WoJ);
            this.WoJ = true;
            this.Xcd.setVisibility(8);
            this.AtJ.setVisibility(0);
            if ((getIntent() != null) && (getIntent().hasExtra("customize_status_bar_color")))
            {
              this.XdC.setBackgroundColor(this.INO);
              if (getIntent().hasExtra("status_bar_style")) {
                cn(this.INO, "black".equals(this.INP));
              }
            }
            this.Xdw.setVisibility(0);
            str = getIntent().getStringExtra("title");
            localObject = str;
            if (Util.isNullOrNil(str)) {
              localObject = getString(c.i.find_friends_search);
            }
            this.Xdw.setText((CharSequence)localObject);
            this.XdC.setVisibility(0);
            if (getIntent() != null) {
              getIntent().putExtra("hideSearchInput", this.WoJ);
            }
          }
          label737:
          localObject = "";
          if (this.WoJ) {
            break label1135;
          }
          i = paramBundle.getInt("ftsneedkeyboard", 0);
          if (i != 1) {
            break label1098;
          }
          getContentView().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(296795);
              FTSSOSHomeWebViewUI.this.iAe().aWT();
              FTSSOSHomeWebViewUI.this.iAe().aWS();
              AppMethodBeat.o(296795);
            }
          }, 128L);
          paramBundle = (Bundle)localObject;
          paramInt = i;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "backButtonType = " + j + ", pageTitle = " + paramBundle + ", hideSearchBarType = " + k + ", ftsNeedHideKeyBoard = " + paramInt);
        break;
        this.nfU.setImageDrawable(bb.m(this, c.h.icons_outlined_close, -16777216));
        break label436;
        if (j == 2)
        {
          this.nfU.setVisibility(8);
          this.XdF = 0;
          break label436;
        }
        if (j != 3) {
          break label436;
        }
        if (aw.isDarkMode())
        {
          this.nfU.setImageDrawable(bb.m(this, c.h.actionbar_icon_dark_back, -1));
          break label436;
        }
        this.nfU.setImageDrawable(bb.m(this, c.h.actionbar_icon_dark_back, -16777216));
        break label436;
        label936:
        if ((k == 2) && (this.WoS))
        {
          this.WoJ = false;
          this.Xcd.setVisibility(0);
          this.nfU.setVisibility(0);
          this.Xdw.setVisibility(8);
          this.XdC.setVisibility(8);
          if (getIntent() == null) {
            break label737;
          }
          getIntent().putExtra("hideSearchInput", this.WoJ);
          break label737;
        }
        if (this.WoS) {
          break label737;
        }
        this.WoJ = false;
        this.Xcd.setVisibility(0);
        this.nfU.setVisibility(0);
        this.Xdw.setVisibility(8);
        iAe().aWT();
        iAe().showVKB();
        this.XdC.setVisibility(8);
        if (getIntent() == null) {
          break label737;
        }
        getIntent().putExtra("hideSearchInput", this.WoJ);
        break label737;
        label1098:
        paramInt = i;
        paramBundle = (Bundle)localObject;
        if (i == 2)
        {
          getContentView().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(296946);
              FTSSOSHomeWebViewUI.this.iAe().dzv.clearFocus();
              FTSSOSHomeWebViewUI.this.iAe().hideVKB();
              AppMethodBeat.o(296946);
            }
          }, 128L);
          paramInt = i;
          paramBundle = (Bundle)localObject;
          continue;
          label1135:
          paramBundle = paramBundle.getString("title");
          if (!Util.isNullOrNil(paramBundle)) {
            this.Xdw.setText(paramBundle);
          }
          paramInt = 0;
        }
      }
      paramInt = paramBundle.getInt("fts_key_data");
      final int i = paramBundle.getInt("fts_key_cache");
      if (this.Xdv != null) {
        this.Xdv.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(296949);
            Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "showNavBarShadow %s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
            int i = paramInt;
            int j = i;
            FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setBackgroundColor(i + 16777216 * j);
            FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setVisibility(0);
            FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setOnClickListener(FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this));
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, true);
            AppMethodBeat.o(296949);
          }
        });
      }
      AppMethodBeat.o(80670);
      return;
      hNe();
    }
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(297062);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.fts.ui.a.b.class);
    AppMethodBeat.o(297062);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(296935);
      Xeb = new a("Back", 0);
      Xec = new a("cancel", 1);
      Xed = new a("None", 2);
      Xee = new a[] { Xeb, Xec, Xed };
      AppMethodBeat.o(296935);
    }
    
    private a() {}
  }
  
  final class b
    extends StateMachine
  {
    State Xef;
    State Xeg;
    State Xeh;
    State Xei;
    
    protected b(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(80648);
      this.Xef = new a((byte)0);
      this.Xeg = new d((byte)0);
      this.Xeh = new b((byte)0);
      this.Xei = new c((byte)0);
      addState(this.Xef);
      addState(this.Xeg);
      addState(this.Xeh);
      addState(this.Xei);
      setInitialState(this.Xef);
      AppMethodBeat.o(80648);
    }
    
    public final void iAB()
    {
      AppMethodBeat.i(80649);
      FTSSOSHomeWebViewUI.this.Xch.setSearchBarCancelTextContainerVisibile(0);
      setInitialState(this.Xef);
      AppMethodBeat.o(80649);
    }
    
    public final boolean iAk()
    {
      AppMethodBeat.i(80650);
      IState localIState = getCurrentState();
      if ((localIState == this.Xeg) || (localIState == this.Xeh) || (localIState == this.Xei))
      {
        AppMethodBeat.o(80650);
        return true;
      }
      AppMethodBeat.o(80650);
      return false;
    }
    
    final class a
      extends LogStateTransitionState
    {
      private a() {}
      
      public final void enter()
      {
        AppMethodBeat.i(80636);
        super.enter();
        FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80636);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80637);
        super.exit();
        FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.this.getResources().getColor(c.c.transparent));
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
          Log.i("LogStateTransitionState", "InitState processMessage = %d.", new Object[] { Integer.valueOf(paramMessage.what) });
          if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
          {
            FTSSOSHomeWebViewUI.this.iAe().jCx();
            FTSSOSHomeWebViewUI.this.iAe().dzv.clearFocus();
            FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).b(a.b.XeS);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.XeS);
            FTSSOSHomeWebViewUI.this.Xcd.setBackgroundResource(c.c.white);
            continue;
            FTSSOSHomeWebViewUI.this.iAe().jCx();
            FTSSOSHomeWebViewUI.this.iAe().dzv.clearFocus();
            FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).a(a.b.XeS, false);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.XeS);
            FTSSOSHomeWebViewUI.this.Xcd.setBackgroundResource(c.c.white);
            FTSSOSHomeWebViewUI.b.a(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xeh);
            FTSSOSHomeWebViewUI.this.Xcw = true;
            continue;
            FTSSOSHomeWebViewUI.this.iAe().jCx();
            FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this).b(a.b.XeS);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.XeS);
            FTSSOSHomeWebViewUI.this.Xcd.setBackgroundResource(c.c.white);
            continue;
            FTSSOSHomeWebViewUI.this.Xcw = true;
            FTSSOSHomeWebViewUI.b.b(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xeg);
            continue;
            FTSSOSHomeWebViewUI.this.Xcw = true;
            FTSSOSHomeWebViewUI.b.c(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xeh);
            continue;
            if ((FTSSOSHomeWebViewUI.this.iAe().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0))
            {
              FTSSOSHomeWebViewUI.this.iAe().jCx();
              FTSSOSHomeWebViewUI.this.Xcd.setBackgroundResource(c.c.white);
              FTSSOSHomeWebViewUI.this.Xch.setSearchBarCancelTextContainerVisibile(8);
              FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this).b(a.b.XeS);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.XeS);
              FTSSOSHomeWebViewUI.this.aS(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80635);
                  j localj = FTSSOSHomeWebViewUI.this.getJsapi();
                  if (!localj.UcS)
                  {
                    Log.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
                    AppMethodBeat.o(80635);
                    return;
                  }
                  Log.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
                  MMHandlerThread.postToMainThread(new j.49(localj, p.a.b("onFocusSearchInput", null, localj.WDI, localj.KQY)));
                  AppMethodBeat.o(80635);
                }
              });
              com.tencent.mm.plugin.report.service.h.OAn.b(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.this.iAe().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.Xdc) });
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
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.XeS);
        FTSSOSHomeWebViewUI.this.Xcd.setBackgroundResource(c.c.white);
        FTSSOSHomeWebViewUI.this.Xch.dzv.clearFocus();
        FTSSOSHomeWebViewUI.this.iAn();
        FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Xcd.setPadding(FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.iAe().jCx();
        FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.this.Xch.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Xch.setCommonRightImageButtonVisibile(0);
        FTSSOSHomeWebViewUI.this.auE(8);
        if (FTSSOSHomeWebViewUI.this.Xcn) {
          FTSSOSHomeWebViewUI.this.Xch.jCx();
        }
        FTSSOSHomeWebViewUI.this.Xch.jCw();
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this);
        Object localObject;
        int i;
        if ((com.tencent.mm.compatible.util.d.rb(23)) && (!MIUI.isMIUIV8()))
        {
          localObject = FTSSOSHomeWebViewUI.this;
          i = FTSSOSHomeWebViewUI.this.getResources().getColor(c.c.white);
          if (aw.isDarkMode()) {
            break label721;
          }
        }
        label721:
        for (boolean bool = true;; bool = false)
        {
          FTSSOSHomeWebViewUI.a((FTSSOSHomeWebViewUI)localObject, i, bool);
          FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setAlpha(0.0F);
          localObject = (RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Xcd.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (FTSSOSHomeWebViewUI.this.Xci) {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          }
          ((RelativeLayout.LayoutParams)localObject).width = -1;
          FTSSOSHomeWebViewUI.this.Xcd.setLayoutParams((ViewGroup.LayoutParams)localObject);
          FTSSOSHomeWebViewUI.this.Xcd.setY(0.0F);
          FTSSOSHomeWebViewUI.this.Xcd.setX(0.0F);
          if (FTSSOSHomeWebViewUI.this.Xci)
          {
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setTranslationY(0.0F);
            FTSSOSHomeWebViewUI.this.Xcd.setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.this.Xcd.setTranslationY(0.0F);
          }
          if ((FTSSOSHomeWebViewUI.this.Xci) && (FTSSOSHomeWebViewUI.this.WoJ))
          {
            FTSSOSHomeWebViewUI.this.Xcd.setVisibility(8);
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setAlpha(1.0F);
            FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this).setVisibility(0);
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setVisibility(8);
            if ((FTSSOSHomeWebViewUI.this.getIntent() != null) && (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("customize_status_bar_color")))
            {
              FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this));
              if (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("status_bar_style")) {
                FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this), "black".equals(FTSSOSHomeWebViewUI.u(FTSSOSHomeWebViewUI.this)));
              }
            }
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this).setVisibility(0);
            String str = FTSSOSHomeWebViewUI.this.getIntent().getStringExtra("title");
            localObject = str;
            if (Util.isNullOrNil(str)) {
              localObject = FTSSOSHomeWebViewUI.this.getString(c.i.find_friends_search);
            }
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this).setText((CharSequence)localObject);
          }
          FTSSOSHomeWebViewUI.this.iAo();
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
          if (!FTSSOSHomeWebViewUI.this.Xci)
          {
            FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).b(a.b.XeR);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.XeR);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.b.d(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xef);
            continue;
            if (FTSSOSHomeWebViewUI.this.iAe().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.b.e(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xeg);
              com.tencent.mm.plugin.report.service.h.OAn.b(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.iAe().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.Xdc) });
              continue;
              Log.i("LogStateTransitionState", "SearchNoFocusState processMessage = MSG_SEARCH_KEY_DOWN.");
              FTSSOSHomeWebViewUI.this.iAe().jCx();
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
        FTSSOSHomeWebViewUI.this.Xcd.setPadding(FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Xcd.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Xcd.setY(0.0F);
        FTSSOSHomeWebViewUI.this.iAe().jCx();
        FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Xch.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Xch.setCommonRightImageButtonVisibile(0);
        FTSSOSHomeWebViewUI.this.auE(8);
        AppMethodBeat.o(80642);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80643);
        super.exit();
        FTSSOSHomeWebViewUI.this.iAn();
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
          if (FTSSOSHomeWebViewUI.this.iAe().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.b.i(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xeg);
            com.tencent.mm.plugin.report.service.h.OAn.b(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.iAe().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.Xdc) });
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.b.j(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xeh);
              continue;
              Log.i("LogStateTransitionState", "SearchWithFocusState processMessage = MSG_SEARCH_KEY_DOWN.");
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
              {
                FTSSOSHomeWebViewUI.this.iAe().jCx();
                FTSSOSHomeWebViewUI.this.iAe().dzv.clearFocus();
                FTSSOSHomeWebViewUI.b.k(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xeh);
                continue;
                if (!FTSSOSHomeWebViewUI.this.Xci)
                {
                  FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.this).b(a.b.XeR);
                  FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.XeR);
                }
                else
                {
                  FTSSOSHomeWebViewUI.this.finish();
                  continue;
                  FTSSOSHomeWebViewUI.b.l(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xef);
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
        FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Xcd.setPadding(FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Xcd.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Xcd.setY(0.0F);
        FTSSOSHomeWebViewUI.this.Xch.setSearchBarCancelTextContainerVisibile(8);
        FTSSOSHomeWebViewUI.this.Xch.setCommonRightImageButtonVisibile(8);
        FTSSOSHomeWebViewUI.this.auE(0);
        FTSSOSHomeWebViewUI.this.Xch.jCw();
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this);
        if (!FTSSOSHomeWebViewUI.this.iAe().dzv.hasFocus())
        {
          FTSSOSHomeWebViewUI.this.iAe().aWT();
          FTSSOSHomeWebViewUI.this.showVKB();
        }
        if ((com.tencent.mm.compatible.util.d.rb(23)) && (!MIUI.isMIUIV8()))
        {
          FTSSOSHomeWebViewUI localFTSSOSHomeWebViewUI = FTSSOSHomeWebViewUI.this;
          int i = FTSSOSHomeWebViewUI.this.getResources().getColor(c.c.white);
          if (!aw.isDarkMode()) {
            bool = true;
          }
          FTSSOSHomeWebViewUI.c(localFTSSOSHomeWebViewUI, i, bool);
        }
        if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
          FTSSOSHomeWebViewUI.this.iAe().jCy();
        }
        AppMethodBeat.o(80645);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80646);
        super.exit();
        FTSSOSHomeWebViewUI.this.iAn();
        FTSSOSHomeWebViewUI.this.auE(8);
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
          if (!FTSSOSHomeWebViewUI.this.Xci)
          {
            FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this).b(a.b.XeR);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.XeR);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.b.f(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xef);
            continue;
            if (!FTSSOSHomeWebViewUI.this.iAe().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.b.g(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xeh);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.iAe().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.Xdc) });
              continue;
              Log.i("LogStateTransitionState", "SearchWithFocusState processMessage = %d.", new Object[] { Integer.valueOf(paramMessage.what) });
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                FTSSOSHomeWebViewUI.b.h(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Xeh);
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