package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.d.h.42;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI
  extends BaseSOSWebViewUI
{
  private View Bnt;
  private boolean Gky;
  boolean IEm;
  private int IEn;
  private WebViewKeyboardLinearLayout JnT;
  private View JnU;
  private View JnV;
  private TextView JnW;
  private b JnX;
  private c JnY;
  private d JnZ;
  private float Joa;
  private float Job;
  private View Joc;
  private b Jod;
  private int Joe;
  private int Jof;
  private String Jog;
  private int Joh;
  private int Joi;
  private String Joj;
  private boolean Jok;
  private FTSSOSHomeWebViewUI.a Jol;
  private a.a Jom;
  private a.a Jon;
  private a.a Joo;
  private String Jop;
  private int Joq;
  private View.OnClickListener Jor;
  private View nmd;
  private View tql;
  
  public FTSSOSHomeWebViewUI()
  {
    AppMethodBeat.i(80651);
    this.Joa = 0.0F;
    this.Job = 0.0F;
    this.Jof = 0;
    this.Jog = "";
    this.Joh = 0;
    this.Joi = 0;
    this.Joj = "";
    this.Jol = FTSSOSHomeWebViewUI.a.Jov;
    this.Gky = false;
    this.Jom = new a.a()
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
    this.Jon = new a.a()
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
    this.Joo = new a.a()
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
    this.Jor = new FTSSOSHomeWebViewUI.5(this);
    AppMethodBeat.o(80651);
  }
  
  private boolean a(FTSSOSHomeWebViewUI.a parama)
  {
    AppMethodBeat.i(211268);
    if (this.Gky)
    {
      fzW();
      fyl();
    }
    if ((parama == FTSSOSHomeWebViewUI.a.Jov) && (ggC()))
    {
      AppMethodBeat.o(211268);
      return false;
    }
    if ((this.Jok) && (super.getJsapi() != null))
    {
      com.tencent.mm.plugin.webview.d.h localh = super.getJsapi();
      if (!localh.GBl) {
        Log.e("MicroMsg.JsApiHandler", "onClientNavAction fail, not ready");
      }
      for (int i = 0; i != 0; i = 1)
      {
        this.Jol = parama;
        AppMethodBeat.o(211268);
        return true;
        Log.i("MicroMsg.JsApiHandler", "onClientNavAction success, ready");
        HashMap localHashMap = new HashMap();
        localHashMap.put("action", "willExitSearch");
        MMHandlerThread.postToMainThread(new h.42(localh, n.a.b("onClientNavAction", localHashMap, localh.IRj, localh.zpY)));
      }
    }
    AppMethodBeat.o(211268);
    return false;
  }
  
  private String agT(int paramInt)
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
      if ((ggU()) || (this.scene == 53)) {
        paramInt = 2131765099;
      }
      if (paramInt >= 0) {
        break label240;
      }
      if (Util.isNullOrNil(this.Joj)) {
        break;
      }
      str = getString(2131765073, new Object[] { this.Joj });
      AppMethodBeat.o(80671);
      return str;
      paramInt = 2131765075;
      continue;
      paramInt = 2131761017;
      continue;
      paramInt = 2131765074;
      continue;
      paramInt = 2131761015;
      continue;
      paramInt = 2131755440;
      continue;
      paramInt = 2131761004;
      continue;
      paramInt = 2131761005;
      continue;
      paramInt = 2131761013;
      continue;
      paramInt = 2131761014;
    }
    String str = getString(2131765088);
    AppMethodBeat.o(80671);
    return str;
    label240:
    str = getString(2131765073, new Object[] { getString(paramInt) });
    AppMethodBeat.o(80671);
    return str;
  }
  
  private void agU(int paramInt)
  {
    AppMethodBeat.i(80672);
    ggL().getIconView().setImageDrawable(agS(paramInt));
    if (paramInt == 0) {
      ggL().getIconView().setIconColor(getResources().getColor(2131099749));
    }
    AppMethodBeat.o(80672);
  }
  
  private void agV(int paramInt)
  {
    AppMethodBeat.i(211274);
    if (getIntent().getBooleanExtra("key_hide_shadow_view", false))
    {
      this.Bnt.setVisibility(8);
      AppMethodBeat.o(211274);
      return;
    }
    this.Bnt.setVisibility(paramInt);
    AppMethodBeat.o(211274);
  }
  
  private static String baE(String paramString)
  {
    AppMethodBeat.i(80656);
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      try
      {
        int i = f.bnP(paramString);
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
          k += f.bnP(String.valueOf(paramString[j]));
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
  
  private void fyl()
  {
    AppMethodBeat.i(211276);
    if (this.JnV != null) {
      this.JnV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211246);
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "hideNavBarShadow");
          FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setVisibility(8);
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, false);
          AppMethodBeat.o(211246);
        }
      });
    }
    AppMethodBeat.o(211276);
  }
  
  private void fzW()
  {
    AppMethodBeat.i(211275);
    if (super.getJsapi() != null) {
      super.getJsapi().gbd();
    }
    AppMethodBeat.o(211275);
  }
  
  private boolean ggU()
  {
    return this.scene == 36;
  }
  
  private void ggV()
  {
    AppMethodBeat.i(80654);
    if (this.pGj == null)
    {
      AppMethodBeat.o(80654);
      return;
    }
    final View localView = this.pGj.getView();
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211250);
        FTSSOSHomeWebViewUI.this.ggR();
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) != null) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(15, paramAnonymousMotionEvent);
        }
        boolean bool = localView.onTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(211250);
        return bool;
      }
    });
    AppMethodBeat.o(80654);
  }
  
  private static void y(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(211278);
    ab localab = new ab();
    localab.eki = paramInt1;
    localab.enp = 0;
    localab.ie(paramString);
    localab.enq = paramInt2;
    localab.enx = System.currentTimeMillis();
    localab.bfK();
    AppMethodBeat.o(211278);
  }
  
  private void zm(boolean paramBoolean)
  {
    AppMethodBeat.i(211272);
    Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "updateWebViewStatus isCancelling:%b visible:%s", new Object[] { Boolean.valueOf(this.Jnj), Boolean.valueOf(paramBoolean) });
    if (this.JnT != null)
    {
      if ((!this.Jnj) && (paramBoolean))
      {
        this.JnT.setAlpha(1.0F);
        AppMethodBeat.o(211272);
        return;
      }
      this.JnT.setAlpha(0.0F);
    }
    AppMethodBeat.o(211272);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164033);
    if (paramb == FTSEditTextView.b.QnQ) {
      this.Joq = 0;
    }
    super.a(paramString1, paramString2, paramList, paramb);
    AppMethodBeat.o(164033);
  }
  
  public final void agP(int paramInt)
  {
    AppMethodBeat.i(80678);
    if ((this.pGj == null) || (this.pGj.getSettings() == null))
    {
      AppMethodBeat.o(80678);
      return;
    }
    float f = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cb.a.iX(getContext()));
    if (f >= com.tencent.mm.cb.a.jd(getContext()))
    {
      this.pGj.getSettings().setTextZoom(160);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.jc(getContext()))
    {
      this.pGj.getSettings().setTextZoom(150);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.jb(getContext()))
    {
      this.pGj.getSettings().setTextZoom(140);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.ja(getContext()))
    {
      this.pGj.getSettings().setTextZoom(130);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.iZ(getContext()))
    {
      this.pGj.getSettings().setTextZoom(120);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.iY(getContext()))
    {
      this.pGj.getSettings().setTextZoom(110);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.iX(getContext()))
    {
      this.pGj.getSettings().setTextZoom(100);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.iW(getContext()))
    {
      this.pGj.getSettings().setTextZoom(90);
      AppMethodBeat.o(80678);
      return;
    }
    this.pGj.getSettings().setTextZoom(80);
    AppMethodBeat.o(80678);
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(80665);
    if (!this.Jnk)
    {
      AppMethodBeat.o(80665);
      return true;
    }
    this.Jod.sendMessage(0);
    super.awE();
    AppMethodBeat.o(80665);
    return true;
  }
  
  public final void bXg()
  {
    AppMethodBeat.i(80653);
    super.bXg();
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", "searchID");
      this.Jog = this.mHh.u(6, (Bundle)localObject1).getString("result");
      for (;;)
      {
        try
        {
          label50:
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("key", "educationTab");
          localObject2 = this.mHh.u(2, (Bundle)localObject1);
          localObject1 = ((Bundle)localObject2).getString("result");
          localObject2 = ((Bundle)localObject2).getString("result_1");
          if (localObject2 != null) {
            continue;
          }
          localObject1 = new JSONObject((String)localObject1);
          localObject2 = ((JSONObject)localObject1).optJSONArray("items");
          String str = ((JSONObject)localObject1).optString("title");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new JSONArray("[{\"businessType\":8,\"hotword\":\"朋友圈\",\"optype\":5},{\"businessType\":2,\"hotword\":\"文章\",\"optype\":5},{\"businessType\":1,\"hotword\":\"公众号\",\"optype\":5}]");
          }
          aD(new FTSSOSHomeWebViewUI.13(this, (JSONArray)localObject1, str));
        }
        catch (Exception localException1)
        {
          Object localObject2;
          continue;
        }
        this.tql.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(211251);
            if ((FTSSOSHomeWebViewUI.this.Jnb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
              FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Jnb.getLayoutParams()).topMargin);
            }
            AppMethodBeat.o(211251);
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
  
  public final int bXh()
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
    this.Jnd = bool1;
    if ((com.tencent.mm.compatible.util.d.oD(23)) && (!MIUI.isMIUIV8()))
    {
      if (this.Jnd)
      {
        AppMethodBeat.o(80661);
        return -1;
      }
      i = getResources().getColor(2131101402);
      AppMethodBeat.o(80661);
      return i;
    }
    int i = super.bXh();
    AppMethodBeat.o(80661);
    return i;
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(80662);
    if (this.Jod == null)
    {
      AppMethodBeat.o(80662);
      return;
    }
    if (this.Jod.ggO()) {
      super.eh(paramBoolean);
    }
    this.Jod.sendMessage(5);
    AppMethodBeat.o(80662);
  }
  
  public void finish()
  {
    AppMethodBeat.i(211277);
    super.finish();
    if ((getScene() == 67) || (getScene() == 81)) {
      y(11, getIntent().getStringExtra("sessionId"), getScene());
    }
    AppMethodBeat.o(211277);
  }
  
  protected final void fzm()
  {
    AppMethodBeat.i(211269);
    if ((!ggC()) && (a(FTSSOSHomeWebViewUI.a.Jov)))
    {
      AppMethodBeat.o(211269);
      return;
    }
    super.fzm();
    AppMethodBeat.o(211269);
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80669);
    String str = agT(getTabType());
    AppMethodBeat.o(80669);
    return str;
  }
  
  protected final com.tencent.mm.plugin.webview.d.h getJsapi()
  {
    AppMethodBeat.i(258626);
    com.tencent.mm.plugin.webview.d.h localh = super.getJsapi();
    AppMethodBeat.o(258626);
    return localh;
  }
  
  public int getLayoutId()
  {
    return 2131496532;
  }
  
  protected final void ggD()
  {
    AppMethodBeat.i(80666);
    super.ggD();
    this.Jod.sendMessage(11);
    AppMethodBeat.o(80666);
  }
  
  protected final void ggE()
  {
    AppMethodBeat.i(80663);
    super.ggE();
    ggL().setHint(agT(this.JnE));
    AppMethodBeat.o(80663);
  }
  
  protected final void ggF()
  {
    AppMethodBeat.i(80667);
    if (this.Jof > 0)
    {
      AppMethodBeat.o(80667);
      return;
    }
    if (a(FTSSOSHomeWebViewUI.a.Jow))
    {
      AppMethodBeat.o(80667);
      return;
    }
    super.ggF();
    this.pGj.scrollTo(0, 0);
    agU(0);
    ggL().gWY();
    ggL().setHint(getHint());
    this.Jod.sendMessage(2);
    this.Jnb.setBackgroundResource(2131235028);
    agV(8);
    this.Jop = null;
    this.Joq = 0;
    this.JnU.setVisibility(0);
    com.tencent.mm.plugin.report.service.h.CyF.a(15521, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(1), ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.JnE) });
    AppMethodBeat.o(80667);
  }
  
  protected final void ggG()
  {
    AppMethodBeat.i(211270);
    zm(true);
    AppMethodBeat.o(211270);
  }
  
  protected final void ggH()
  {
    AppMethodBeat.i(80668);
    super.ggH();
    zm(true);
    if ((getScene() == 67) || (getScene() == 81)) {
      y(10, getIntent().getStringExtra("sessionId"), getScene());
    }
    AppMethodBeat.o(80668);
  }
  
  protected final void ggI()
  {
    AppMethodBeat.i(211271);
    super.ggI();
    if ((getScene() == 67) || (getScene() == 81)) {
      y(9, getIntent().getStringExtra("sessionId"), getScene());
    }
    AppMethodBeat.o(211271);
  }
  
  public final String ggJ()
  {
    if (this.Joq == 0) {
      return "";
    }
    return this.Jop;
  }
  
  public final int ggK()
  {
    return this.Joq;
  }
  
  public final boolean ggO()
  {
    AppMethodBeat.i(80674);
    if (this.Jod == null)
    {
      AppMethodBeat.o(80674);
      return false;
    }
    boolean bool = this.Jod.ggO();
    AppMethodBeat.o(80674);
    return bool;
  }
  
  protected final boolean ggP()
  {
    AppMethodBeat.i(80675);
    if ((ggO()) && (!this.JnX.isAnimating) && (!this.JnY.isAnimating) && (!this.JnZ.isAnimating))
    {
      AppMethodBeat.o(80675);
      return true;
    }
    AppMethodBeat.o(80675);
    return false;
  }
  
  protected final Map<String, Object> ggW()
  {
    AppMethodBeat.i(80660);
    HashMap localHashMap = new HashMap();
    if (this.tql == null)
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
        localObject = this.mHh.u(7, null);
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
  
  public final void m(final int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80670);
    super.m(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80670);
      return;
      this.Jod.sendMessage(8);
      AppMethodBeat.o(80670);
      return;
      this.Jod.sendMessage(10);
      AppMethodBeat.o(80670);
      return;
      paramBundle.getString("fts_key_new_query", "");
      this.Jod.sendMessage(13);
      AppMethodBeat.o(80670);
      return;
      paramBundle = paramBundle.getString("fts_key_data", "exit");
      if (TextUtils.equals("controlExit", paramBundle)) {
        this.Jok = true;
      }
      for (;;)
      {
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "AC_ON_NAV_CONTROL mIsExitControl:%b, lastClickType:%s", new Object[] { Boolean.valueOf(this.Jok), this.Jol });
        AppMethodBeat.o(80670);
        return;
        if (TextUtils.equals("exit", paramBundle))
        {
          this.Jok = false;
          if (this.Jol == FTSSOSHomeWebViewUI.a.Jow) {
            ggF();
          } else {
            fzm();
          }
        }
      }
      paramInt = paramBundle.getInt("fts_key_data");
      final int i = paramBundle.getInt("fts_key_cache");
      if (this.JnV != null) {
        this.JnV.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(211244);
            Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "showNavBarShadow %s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
            int i = paramInt;
            int j = i;
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setBackgroundColor(i + 16777216 * j);
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setVisibility(0);
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setOnClickListener(FTSSOSHomeWebViewUI.u(FTSSOSHomeWebViewUI.this));
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, true);
            AppMethodBeat.o(211244);
          }
        });
      }
      AppMethodBeat.o(80670);
      return;
      fyl();
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
        paramIntent = baE(paramIntent);
        Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[] { Integer.valueOf(paramIntent.length()), paramIntent });
        this.Jnc.O(paramIntent, null);
        awE();
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
    ggL().gXf();
    AppMethodBeat.o(80673);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80652);
    super.onCreate(paramBundle);
    this.Jod = new b("sos_home_webview_ui", getMainLooper());
    this.tql = findViewById(2131309214);
    this.Joc = findViewById(2131309215);
    this.JnU = findViewById(2131299174);
    this.nmd = findViewById(2131309252);
    this.JnT = ((WebViewKeyboardLinearLayout)findViewById(2131310394));
    this.JnW = ((TextView)findViewById(2131302325));
    this.JnV = findViewById(2131308293);
    this.JnT.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void Ns(int paramAnonymousInt)
      {
        AppMethodBeat.i(80620);
        if (paramAnonymousInt == -2) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).sendMessage(12);
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, paramAnonymousInt);
        AppMethodBeat.o(80620);
      }
    });
    this.JnX = new b(this, this.Jnb, this.nmd, ggL().getIconView(), this.hNZ, this.hNZ, ggL().getEditText(), this.tql, this.Joc);
    this.JnX.a(this.Jom);
    this.JnY = new c(this, this.Jnb, this.nmd, ggL().getIconView(), this.hNZ, this.hNZ, ggL().getEditText(), this.tql, this.Joc);
    this.JnY.a(this.Joo);
    this.JnZ = new d(this, this.Jnb, this.nmd, ggL().getIconView(), this.hNZ, this.hNZ, ggL().getEditText(), this.tql, this.Joc);
    this.JnZ.a(this.Jon);
    this.Bnt = findViewById(2131308294);
    findViewById(2131299205).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211247);
        FTSSOSHomeWebViewUI.this.ggL().vy.clearFocus();
        FTSSOSHomeWebViewUI.this.hideVKB();
        AppMethodBeat.o(211247);
        return false;
      }
    });
    this.Joe = com.tencent.mm.cb.a.fromDPToPix(this, 24);
    ggL().fYP();
    ggL().gWY();
    boolean bool;
    if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsInitToSearch", false)))
    {
      bool = true;
      this.Jnd = bool;
      if ((getIntent() == null) || (!getIntent().getBooleanExtra("hideSearchInput", false))) {
        break label674;
      }
      bool = true;
      label415:
      this.IEm = bool;
      this.IEn = getIntent().getIntExtra("key_back_btn_type", 0);
      if (this.Jod != null)
      {
        if (!this.Jnd) {
          break label684;
        }
        this.Jnb.setVisibility(0);
        this.Joc.setBackgroundColor(getResources().getColor(2131101287));
        paramBundle = this.Jod;
        paramBundle.setInitialState(paramBundle.JoA);
        if ((com.tencent.mm.compatible.util.d.oD(23)) && (!com.tencent.mm.compatible.util.g.isMIUIV8()))
        {
          int i = getResources().getColor(2131101424);
          if (ao.isDarkMode()) {
            break label679;
          }
          bool = true;
          label520:
          bt(i, bool);
        }
        label526:
        this.Jod.start();
      }
      if (this.IEn != 1) {
        break label714;
      }
      if (!ao.isDarkMode()) {
        break label694;
      }
      this.hNZ.setImageDrawable(com.tencent.mm.ui.ar.m(this, 2131690761, -1));
    }
    for (;;)
    {
      com.tencent.mm.plugin.websearch.api.ar.afz(getScene());
      ggV();
      this.Jnb.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211248);
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Jnb.getX());
          FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Jnb.getY());
          Log.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getSearchInputLayout originInputX=%s originInputY=%s", new Object[] { Float.valueOf(FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this)), Float.valueOf(FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this)) });
          AppMethodBeat.o(211248);
        }
      }, 100L);
      this.Jnc.setVoiceBtnClickListener(new FTSSOSHomeWebViewUI.9(this));
      this.Jnc.setCancelTextViewClickListener(new FTSSOSHomeWebViewUI.10(this));
      agU(getType());
      paramBundle = ggL().getClearBtn();
      if (paramBundle != null) {
        paramBundle.getDrawable().setColorFilter(getResources().getColor(2131099746), PorterDuff.Mode.SRC_ATOP);
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
      this.Jod.ggX();
      break label526;
      label694:
      this.hNZ.setImageDrawable(com.tencent.mm.ui.ar.m(this, 2131690761, -16777216));
      continue;
      label714:
      if (this.IEn == 2)
      {
        this.hNZ.setVisibility(8);
        this.Joe = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80659);
    super.onDestroy();
    com.tencent.mm.plugin.websearch.api.ar.fYo();
    com.tencent.mm.plugin.websearch.api.ar.fYp();
    AppMethodBeat.o(80659);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80658);
    super.onPause();
    com.tencent.mm.plugin.websearch.api.ar.fYn();
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class) != null) {
      ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class)).d(105, false, false);
    }
    AppMethodBeat.o(80658);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80657);
    super.onResume();
    com.tencent.mm.plugin.websearch.api.ar.fYm();
    AppMethodBeat.o(80657);
  }
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80677);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.pGj == null)
    {
      AppMethodBeat.o(80677);
      return;
    }
    paramInt1 = Math.min(paramInt2, Math.max(com.tencent.mm.cb.a.fromDPToPix(this, this.pGj.getContentHeight()) - this.pGj.getHeight(), 0));
    this.JnX.agW(this.Joh - paramInt1);
    this.JnY.agW(this.Joh - paramInt1);
    this.JnZ.agW(this.Joh - paramInt1);
    if (!this.Jod.ggO())
    {
      this.nmd.setTranslationY(-paramInt1);
      this.Jnb.setTranslationY(-paramInt1);
    }
    if (paramInt2 != 0)
    {
      ggL().vy.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(80677);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
    extends StateMachine
  {
    State JoA;
    State JoB;
    State Joy;
    State Joz;
    
    protected b(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(80648);
      this.Joy = new a((byte)0);
      this.Joz = new d((byte)0);
      this.JoA = new b((byte)0);
      this.JoB = new c((byte)0);
      addState(this.Joy);
      addState(this.Joz);
      addState(this.JoA);
      addState(this.JoB);
      setInitialState(this.Joy);
      AppMethodBeat.o(80648);
    }
    
    public final boolean ggO()
    {
      AppMethodBeat.i(80650);
      IState localIState = getCurrentState();
      if ((localIState == this.Joz) || (localIState == this.JoA) || (localIState == this.JoB))
      {
        AppMethodBeat.o(80650);
        return true;
      }
      AppMethodBeat.o(80650);
      return false;
    }
    
    public final void ggX()
    {
      AppMethodBeat.i(80649);
      FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(0);
      setInitialState(this.Joy);
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
        FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.this.getResources().getColor(2131101287));
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
            FTSSOSHomeWebViewUI.this.ggL().gXf();
            FTSSOSHomeWebViewUI.this.ggL().vy.clearFocus();
            FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this).b(a.b.Jpi);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Jpi);
            FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(2131101424);
            continue;
            FTSSOSHomeWebViewUI.this.ggL().gXf();
            FTSSOSHomeWebViewUI.this.ggL().vy.clearFocus();
            FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this).a(a.b.Jpi, false);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Jpi);
            FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(2131101424);
            FTSSOSHomeWebViewUI.b.a(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.JoA);
            FTSSOSHomeWebViewUI.this.Jni = true;
            continue;
            FTSSOSHomeWebViewUI.this.ggL().gXf();
            FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this).b(a.b.Jpi);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Jpi);
            FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(2131101424);
            continue;
            FTSSOSHomeWebViewUI.this.Jni = true;
            FTSSOSHomeWebViewUI.b.b(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Joz);
            continue;
            FTSSOSHomeWebViewUI.this.Jni = true;
            FTSSOSHomeWebViewUI.b.c(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.JoA);
            continue;
            if ((FTSSOSHomeWebViewUI.this.ggL().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0))
            {
              FTSSOSHomeWebViewUI.this.ggL().gXf();
              FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(2131101424);
              FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(8);
              FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this).b(a.b.Jpi);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Jpi);
              FTSSOSHomeWebViewUI.this.aD(new FTSSOSHomeWebViewUI.b.a.1(this));
              com.tencent.mm.plugin.report.service.h.CyF.a(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.this.ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.JnE) });
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
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Jpi);
        FTSSOSHomeWebViewUI.this.Jnb.setBackgroundResource(2131101424);
        FTSSOSHomeWebViewUI.this.Jnc.vy.clearFocus();
        FTSSOSHomeWebViewUI.this.hideVKB();
        FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Jnb.setPadding(FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.ggL().gXf();
        FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Jnc.setVoiceImageButtonVisibile(0);
        FTSSOSHomeWebViewUI.this.Jnc.gXf();
        FTSSOSHomeWebViewUI.this.Jnc.gXe();
        FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
        Object localObject;
        int i;
        if ((com.tencent.mm.compatible.util.d.oD(23)) && (!MIUI.isMIUIV8()))
        {
          localObject = FTSSOSHomeWebViewUI.this;
          i = FTSSOSHomeWebViewUI.this.getResources().getColor(2131101424);
          if (ao.isDarkMode()) {
            break label693;
          }
        }
        label693:
        for (boolean bool = true;; bool = false)
        {
          FTSSOSHomeWebViewUI.a((FTSSOSHomeWebViewUI)localObject, i, bool);
          FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setAlpha(0.0F);
          localObject = (RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Jnb.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (FTSSOSHomeWebViewUI.this.Jnd) {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          }
          ((RelativeLayout.LayoutParams)localObject).width = -1;
          FTSSOSHomeWebViewUI.this.Jnb.setLayoutParams((ViewGroup.LayoutParams)localObject);
          FTSSOSHomeWebViewUI.this.Jnb.setY(0.0F);
          FTSSOSHomeWebViewUI.this.Jnb.setX(0.0F);
          if (FTSSOSHomeWebViewUI.this.Jnd)
          {
            FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setTranslationY(0.0F);
            FTSSOSHomeWebViewUI.this.Jnb.setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.this.Jnb.setTranslationY(0.0F);
          }
          if ((FTSSOSHomeWebViewUI.this.Jnd) && (FTSSOSHomeWebViewUI.this.IEm))
          {
            FTSSOSHomeWebViewUI.this.Jnb.setVisibility(8);
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
              localObject = FTSSOSHomeWebViewUI.this.getString(2131759440);
            }
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setText((CharSequence)localObject);
          }
          FTSSOSHomeWebViewUI.this.ggR();
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
          if (!FTSSOSHomeWebViewUI.this.Jnd)
          {
            FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this).b(a.b.Jph);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Jph);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.b.d(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Joy);
            continue;
            if (FTSSOSHomeWebViewUI.this.ggL().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.b.e(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Joz);
              com.tencent.mm.plugin.report.service.h.CyF.a(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.JnE) });
              continue;
              FTSSOSHomeWebViewUI.this.ggL().gXf();
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
        FTSSOSHomeWebViewUI.this.Jnb.setPadding(FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Jnb.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Jnb.setY(0.0F);
        FTSSOSHomeWebViewUI.this.ggL().gXf();
        FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Jnc.setVoiceImageButtonVisibile(0);
        AppMethodBeat.o(80642);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80643);
        super.exit();
        FTSSOSHomeWebViewUI.this.hideVKB();
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
          if (FTSSOSHomeWebViewUI.this.ggL().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.b.i(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Joz);
            com.tencent.mm.plugin.report.service.h.CyF.a(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.JnE) });
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.b.j(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.JoA);
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
              {
                FTSSOSHomeWebViewUI.this.ggL().gXf();
                FTSSOSHomeWebViewUI.this.ggL().vy.clearFocus();
                FTSSOSHomeWebViewUI.b.k(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.JoA);
                continue;
                if (!FTSSOSHomeWebViewUI.this.Jnd)
                {
                  FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this).b(a.b.Jph);
                  FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Jph);
                }
                else
                {
                  FTSSOSHomeWebViewUI.this.finish();
                  continue;
                  FTSSOSHomeWebViewUI.b.l(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Joy);
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
        FTSSOSHomeWebViewUI.this.Jnb.setPadding(FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Jnb.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Jnb.setY(0.0F);
        FTSSOSHomeWebViewUI.this.Jnc.setSearchBarCancelTextContainerVisibile(8);
        FTSSOSHomeWebViewUI.this.Jnc.setVoiceImageButtonVisibile(8);
        FTSSOSHomeWebViewUI.this.Jnc.gXe();
        FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
        if (!FTSSOSHomeWebViewUI.this.ggL().vy.hasFocus())
        {
          FTSSOSHomeWebViewUI.this.ggL().awD();
          FTSSOSHomeWebViewUI.this.showVKB();
        }
        if ((com.tencent.mm.compatible.util.d.oD(23)) && (!MIUI.isMIUIV8()))
        {
          FTSSOSHomeWebViewUI localFTSSOSHomeWebViewUI = FTSSOSHomeWebViewUI.this;
          int i = FTSSOSHomeWebViewUI.this.getResources().getColor(2131101424);
          if (!ao.isDarkMode()) {
            bool = true;
          }
          FTSSOSHomeWebViewUI.c(localFTSSOSHomeWebViewUI, i, bool);
        }
        if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
          FTSSOSHomeWebViewUI.this.ggL().gXg();
        }
        AppMethodBeat.o(80645);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80646);
        super.exit();
        FTSSOSHomeWebViewUI.this.hideVKB();
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
          if (!FTSSOSHomeWebViewUI.this.Jnd)
          {
            FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this).b(a.b.Jph);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Jph);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.b.f(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.Joy);
            continue;
            if (!FTSSOSHomeWebViewUI.this.ggL().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.b.g(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.JoA);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.ggL().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.JnE) });
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                FTSSOSHomeWebViewUI.b.h(FTSSOSHomeWebViewUI.b.this, FTSSOSHomeWebViewUI.b.this.JoA);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI
 * JD-Core Version:    0.7.0.1
 */