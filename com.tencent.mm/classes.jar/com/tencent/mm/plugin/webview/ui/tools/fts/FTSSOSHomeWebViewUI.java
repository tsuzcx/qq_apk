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
import android.support.v4.app.k;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI
  extends BaseSOSWebViewUI
{
  private View BkN;
  private View BkO;
  private View BkP;
  private TextView BkQ;
  private b BkR;
  private c BkS;
  private d BkT;
  private float BkU;
  private View BkV;
  private View BkW;
  private a BkX;
  private int BkY;
  private int BkZ;
  private String Bla;
  boolean Blb;
  boolean Blc;
  private int Bld;
  private int Ble;
  private String Blf;
  private WeappWebSearchFragment Blg;
  private boolean Blh;
  private a.a Bli;
  private a.a Blj;
  private a.a Blk;
  private String Bll;
  private int Blm;
  private View rDk;
  private View.OnClickListener ruG;
  private FTSMainUIEducationLayout rur;
  private View wjg;
  private View wtD;
  
  public FTSSOSHomeWebViewUI()
  {
    AppMethodBeat.i(80651);
    this.BkU = 3.4028235E+38F;
    this.BkZ = 0;
    this.Bla = "";
    this.Bld = 0;
    this.Ble = 0;
    this.Blf = "";
    this.ruG = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(80632);
        if (!FTSSOSHomeWebViewUI.this.Bkl)
        {
          AppMethodBeat.o(80632);
          return;
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Wm(1);
        String str = ((TextView)paramAnonymousView).getText().toString();
        final int i = FTSSOSHomeWebViewUI.a((JSONObject)paramAnonymousView.getTag(), str, FTSSOSHomeWebViewUI.this);
        if (i == 64)
        {
          FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
          FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this).setVisibility(0);
          paramAnonymousView = FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this);
          int j = FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this).getHeight();
          ViewGroup.LayoutParams localLayoutParams = paramAnonymousView.Bmn.getLayoutParams();
          localLayoutParams.height = j;
          paramAnonymousView.Bmn.setLayoutParams(localLayoutParams);
          FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this).setVisibility(8);
        }
        if (i != 0)
        {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, str);
          if (FTSSOSHomeWebViewUI.this.BkC != i) {
            h.vKh.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(4), FTSSOSHomeWebViewUI.this.epC().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.BkC) });
          }
          if ((FTSSOSHomeWebViewUI.this.BkC != i) && (!FTSSOSHomeWebViewUI.this.epC().getTagList().isEmpty()))
          {
            paramAnonymousView = FTSSOSHomeWebViewUI.this.getTotalQuery();
            FTSSOSHomeWebViewUI.this.epC().clearText();
            FTSSOSHomeWebViewUI.this.epC().J(paramAnonymousView, null);
            FTSSOSHomeWebViewUI.this.epC().fdm();
          }
          FTSSOSHomeWebViewUI.this.BkC = i;
          FTSSOSHomeWebViewUI.this.epx();
          FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, i);
        }
        for (;;)
        {
          try
          {
            FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
            paramAnonymousView = new Bundle();
            paramAnonymousView.putInt("type", i);
            if (i == 0)
            {
              bool = true;
              paramAnonymousView.putBoolean("isHomePage", bool);
              if ((FTSSOSHomeWebViewUI.this.getScene() != 20) || (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).epG())) {
                break label500;
              }
              if (i == 0) {
                continue;
              }
              FTSSOSHomeWebViewUI.this.BkB = 22;
              paramAnonymousView.putInt("scene", 22);
              paramAnonymousView = FTSSOSHomeWebViewUI.this.kxf.s(4, paramAnonymousView);
              FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80631);
                  boolean bool = false;
                  HashMap localHashMap;
                  if (FTSSOSHomeWebViewUI.this.getJsapi() != null)
                  {
                    localHashMap = new HashMap();
                    localHashMap.put("isHomePage", "0");
                    if (i != 0) {
                      break label323;
                    }
                    localHashMap.put("isHomePage", "1");
                  }
                  for (;;)
                  {
                    if (!bt.isNullOrNil(FTSSOSHomeWebViewUI.this.getTotalQuery())) {
                      localHashMap.put("query", FTSSOSHomeWebViewUI.this.getTotalQuery());
                    }
                    bool = FTSSOSHomeWebViewUI.this.getJsapi().a(paramAnonymousView.getString("scene", "0"), paramAnonymousView.getString("type", "0"), paramAnonymousView.getString("isSug", "0"), paramAnonymousView.getString("isLocalSug", "0"), FTSSOSHomeWebViewUI.this.getSessionId(), localHashMap);
                    if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
                      z.a(FTSSOSHomeWebViewUI.this.scene, FTSSOSHomeWebViewUI.this.sessionId, FTSSOSHomeWebViewUI.this.dtw, true, FTSSOSHomeWebViewUI.this.getInEditTextQuery(), FTSSOSHomeWebViewUI.this.BkC);
                    }
                    if (bool)
                    {
                      FTSSOSHomeWebViewUI.this.epC().setHint(FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this, i));
                      ak.e(i, FTSSOSHomeWebViewUI.this.BkB, FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this), FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).epG());
                      FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Wm(7);
                    }
                    AppMethodBeat.o(80631);
                    return;
                    label323:
                    if (i == 1) {
                      localHashMap.put("isMostSearchBiz", paramAnonymousView.getString("isMostSearchBiz", "0"));
                    } else {
                      localHashMap.put("isHomePage", "0");
                    }
                  }
                }
              });
              AppMethodBeat.o(80632);
              return;
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, "");
              break;
            }
            boolean bool = false;
            continue;
            FTSSOSHomeWebViewUI.this.BkB = 20;
            paramAnonymousView.putInt("scene", 20);
            continue;
            FTSSOSHomeWebViewUI.this.BkB = FTSSOSHomeWebViewUI.this.getScene();
          }
          catch (Exception paramAnonymousView)
          {
            AppMethodBeat.o(80632);
            return;
          }
          label500:
          paramAnonymousView.putInt("scene", FTSSOSHomeWebViewUI.this.getScene());
        }
      }
    };
    this.Bli = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80633);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Wm(4);
        FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80633);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80634);
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80634);
      }
    };
    this.Blj = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80621);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Wm(9);
        FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80621);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80622);
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80622);
      }
    };
    this.Blk = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80623);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Wm(3);
        FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80623);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80624);
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80624);
      }
    };
    AppMethodBeat.o(80651);
  }
  
  private String TG(int paramInt)
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
      if ((epK()) || (this.scene == 53)) {
        paramInt = 2131762962;
      }
      if (paramInt >= 0) {
        break label228;
      }
      if (bt.isNullOrNil(this.Blf)) {
        break;
      }
      str = getString(2131762937, new Object[] { this.Blf });
      AppMethodBeat.o(80671);
      return str;
      paramInt = 2131762939;
      continue;
      paramInt = 2131759696;
      continue;
      paramInt = 2131762938;
      continue;
      paramInt = 2131759694;
      continue;
      paramInt = 2131755401;
      continue;
      paramInt = 2131759683;
      continue;
      paramInt = 2131759684;
      continue;
      paramInt = 2131759692;
      continue;
      paramInt = 2131759693;
    }
    String str = getString(2131762952);
    AppMethodBeat.o(80671);
    return str;
    label228:
    str = getString(2131762937, new Object[] { getString(paramInt) });
    AppMethodBeat.o(80671);
    return str;
  }
  
  private void TH(int paramInt)
  {
    AppMethodBeat.i(80672);
    epC().getIconView().setImageDrawable(TF(paramInt));
    AppMethodBeat.o(80672);
  }
  
  public static int a(JSONObject paramJSONObject, String paramString, Context paramContext)
  {
    AppMethodBeat.i(80679);
    int j;
    int i;
    if (paramJSONObject == null)
    {
      j = 0;
      i = j;
      if (j == 0)
      {
        if (!paramString.equals(paramContext.getString(2131762938))) {
          break label53;
        }
        i = 2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(80679);
      return i;
      j = paramJSONObject.optInt("businessType");
      break;
      label53:
      if (paramString.equals(paramContext.getString(2131762942)))
      {
        i = 8;
      }
      else if (paramString.equals(paramContext.getString(2131762939)))
      {
        i = 1;
      }
      else
      {
        ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "option " + paramString + " no type");
        i = j;
      }
    }
  }
  
  private static String ayf(String paramString)
  {
    AppMethodBeat.i(80656);
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      try
      {
        int i = com.tencent.mm.ui.tools.f.aLJ(paramString);
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
          k += com.tencent.mm.ui.tools.f.aLJ(String.valueOf(paramString[j]));
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
  
  private boolean epK()
  {
    return this.scene == 36;
  }
  
  private void epL()
  {
    AppMethodBeat.i(80654);
    if (this.nhy == null)
    {
      AppMethodBeat.o(80654);
      return;
    }
    final View localView = this.nhy.getView();
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80630);
        FTSSOSHomeWebViewUI.this.epJ();
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) != null)
        {
          paramAnonymousView = FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this);
          d.c localc = paramAnonymousView.EXN;
          if (localc != null) {
            localc.sendMessage(paramAnonymousView.obtainMessage(15, paramAnonymousMotionEvent));
          }
        }
        boolean bool = localView.onTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(80630);
        return bool;
      }
    });
    AppMethodBeat.o(80654);
  }
  
  public final void SK(int paramInt)
  {
    AppMethodBeat.i(80678);
    if ((this.nhy == null) || (this.nhy.getSettings() == null))
    {
      AppMethodBeat.o(80678);
      return;
    }
    float f = getContext().getSharedPreferences(aj.eFD(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cd.a.hF(getContext()));
    if (f >= com.tencent.mm.cd.a.hL(getContext()))
    {
      this.nhy.getSettings().setTextZoom(160);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.hK(getContext()))
    {
      this.nhy.getSettings().setTextZoom(150);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.hJ(getContext()))
    {
      this.nhy.getSettings().setTextZoom(140);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.hI(getContext()))
    {
      this.nhy.getSettings().setTextZoom(130);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.hH(getContext()))
    {
      this.nhy.getSettings().setTextZoom(120);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.hG(getContext()))
    {
      this.nhy.getSettings().setTextZoom(110);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.hF(getContext()))
    {
      this.nhy.getSettings().setTextZoom(100);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cd.a.hE(getContext()))
    {
      this.nhy.getSettings().setTextZoom(90);
      AppMethodBeat.o(80678);
      return;
    }
    this.nhy.getSettings().setTextZoom(80);
    AppMethodBeat.o(80678);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164033);
    if (paramb == FTSEditTextView.b.Hlc) {
      this.Blm = 0;
    }
    super.a(paramString1, paramString2, paramList, paramb);
    AppMethodBeat.o(164033);
  }
  
  public final void bol()
  {
    AppMethodBeat.i(80653);
    super.bol();
    this.BkX = new a("sos_home_webview_ui", getMainLooper());
    this.wjg = findViewById(2131305918);
    this.BkW = findViewById(2131305919);
    this.BkO = findViewById(2131306894);
    this.BkP = findViewById(2131298736);
    this.rDk = findViewById(2131305949);
    this.BkN = findViewById(2131306921);
    this.BkQ = ((TextView)findViewById(2131300740));
    ((WebViewKeyboardLinearLayout)this.BkN).setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void DK(int paramAnonymousInt)
      {
        AppMethodBeat.i(80620);
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) == null)
        {
          AppMethodBeat.o(80620);
          return;
        }
        if (paramAnonymousInt == -2) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Wm(12);
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, paramAnonymousInt);
        AppMethodBeat.o(80620);
      }
    });
    this.rur = ((FTSMainUIEducationLayout)findViewById(2131304415));
    this.rur.setOnCellClickListener(this.ruG);
    this.rur.setCellClickable(false);
    this.rur.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(80625);
        if (FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).getHeight() <= 0)
        {
          AppMethodBeat.o(80625);
          return;
        }
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        FTSSOSHomeWebViewUI.this.BlA.countDown();
        if ((FTSSOSHomeWebViewUI.this.Bke.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Bke.getLayoutParams()).topMargin);
        }
        if ((FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).getLayoutParams() instanceof RelativeLayout.LayoutParams))
        {
          FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).getLayoutParams()).topMargin);
          if ((FTSSOSHomeWebViewUI.this.ARU) && (FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this).getTopView() != null) && ((FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this).getTopView() instanceof AbsoluteLayout)))
          {
            ((ViewGroup)FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).getParent()).removeView(FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this));
            AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, FTSSOSHomeWebViewUI.f(FTSSOSHomeWebViewUI.this) - FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).getHeight());
            ((AbsoluteLayout)FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this).getTopView()).addView(FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this), localLayoutParams);
          }
        }
        FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80625);
      }
    });
    this.BkR = new b(this, this.Bke, this.rDk, epC().getIconView(), this.sUG, this.sUG, epC().getEditText(), this.BkV, this.wjg, this.BkW);
    this.BkR.a(this.Bli);
    this.BkS = new c(this, this.Bke, this.rDk, epC().getIconView(), this.sUG, this.sUG, epC().getEditText(), this.BkV, this.wjg, this.BkW);
    this.BkS.a(this.Blk);
    this.BkT = new d(this, this.Bke, this.rDk, epC().getIconView(), this.sUG, this.sUG, epC().getEditText(), this.BkV, this.wjg, this.BkW);
    this.BkT.a(this.Blj);
    this.wtD = findViewById(2131305116);
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "educationTab");
        localObject2 = this.kxf.s(2, (Bundle)localObject1);
        localObject1 = ((Bundle)localObject2).getString("result");
        localObject2 = ((Bundle)localObject2).getString("result_1");
        if (localObject2 != null) {
          continue;
        }
        localObject1 = new JSONObject((String)localObject1);
        this.rur.ap((JSONObject)localObject1);
      }
      catch (Exception localException2)
      {
        Object localObject1;
        Object localObject2;
        boolean bool;
        int i;
        continue;
      }
      findViewById(2131298761).setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(80626);
          FTSSOSHomeWebViewUI.this.epC().sz.clearFocus();
          FTSSOSHomeWebViewUI.this.hideVKB();
          AppMethodBeat.o(80626);
          return false;
        }
      });
      this.BkY = com.tencent.mm.cd.a.fromDPToPix(this, 24);
      epC().eix();
      epC().fdg();
      if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsInitToSearch", false)))
      {
        bool = true;
        this.Blb = bool;
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("hideSearchInput", false))) {
          continue;
        }
        bool = true;
        this.Blc = bool;
        if (this.BkX != null)
        {
          if (!this.Blb) {
            continue;
          }
          this.BkW.setBackgroundColor(getResources().getColor(2131101053));
          localObject1 = this.BkX;
          ((a)localObject1).b(((a)localObject1).Bls);
          if ((com.tencent.mm.compatible.util.d.lf(23)) && (!com.tencent.mm.compatible.util.g.XM()))
          {
            i = getResources().getColor(2131101179);
            if (ai.Eq()) {
              continue;
            }
            bool = true;
            aI(i, bool);
          }
          if (this.type == 64)
          {
            this.Blh = true;
            this.BkP.setVisibility(8);
            this.BkO.setVisibility(0);
          }
          this.BkX.start();
        }
      }
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "searchID");
        this.Bla = this.kxf.s(6, (Bundle)localObject1).getString("result");
        ak.aF(this.Bla, getSessionId(), this.rur.getVertBizTypes());
        ak.Si(getScene());
        epL();
        this.Bke.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(80627);
            FTSSOSHomeWebViewUI.this.Bke.getViewTreeObserver().removeOnPreDrawListener(this);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Bke.getX());
            AppMethodBeat.o(80627);
            return true;
          }
        });
        if (!this.ARU)
        {
          this.BkN.setVisibility(4);
          this.Bkf.setVoiceBtnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              int i = 2;
              AppMethodBeat.i(80628);
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "");
              ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), FTSSOSHomeWebViewUI.this });
              if (!bool)
              {
                AppMethodBeat.o(80628);
                return;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("sessionId", FTSSOSHomeWebViewUI.this.sessionId);
              paramAnonymousView.putExtra("subSessionId", FTSSOSHomeWebViewUI.this.dtw);
              paramAnonymousView.putExtra("key_scene", FTSSOSHomeWebViewUI.this.scene);
              if (FTSSOSHomeWebViewUI.this.epG()) {
                i = 1;
              }
              paramAnonymousView.putExtra("key_is_nav_voice", i);
              com.tencent.mm.bs.d.c(FTSSOSHomeWebViewUI.this, ".ui.websearch.WebSearchVoiceUI", paramAnonymousView, 1);
              FTSSOSHomeWebViewUI.this.overridePendingTransition(0, 0);
              AppMethodBeat.o(80628);
            }
          });
          this.Bkf.setCancelTextViewClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(80629);
              FTSSOSHomeWebViewUI.this.epy();
              FTSSOSHomeWebViewUI.this.epJ();
              AppMethodBeat.o(80629);
            }
          });
          this.Bkf.getIconView().setImageDrawable(TF(getType()));
          localObject1 = epC().getClearBtn();
          if (localObject1 != null) {
            ((ImageButton)localObject1).getDrawable().setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
          }
          AppMethodBeat.o(80653);
          return;
          localObject1 = localObject2;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          this.BkX.epO();
          continue;
        }
        this.BkN.setVisibility(0);
      }
      catch (Exception localException1) {}
    }
  }
  
  public final int bom()
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
    this.Blb = bool1;
    if ((com.tencent.mm.compatible.util.d.lf(23)) && (!com.tencent.mm.sdk.h.b.XM()))
    {
      if (this.Blb)
      {
        AppMethodBeat.o(80661);
        return -1;
      }
      i = getResources().getColor(2131101159);
      AppMethodBeat.o(80661);
      return i;
    }
    int i = super.bom();
    AppMethodBeat.o(80661);
    return i;
  }
  
  public final boolean bow()
  {
    AppMethodBeat.i(80665);
    if (!this.Bkl)
    {
      AppMethodBeat.o(80665);
      return true;
    }
    this.BkX.Wm(0);
    super.bow();
    AppMethodBeat.o(80665);
    return true;
  }
  
  public final String epA()
  {
    if (this.Blm == 0) {
      return "";
    }
    return this.Bll;
  }
  
  public final int epB()
  {
    return this.Blm;
  }
  
  public final boolean epG()
  {
    AppMethodBeat.i(80674);
    if (this.BkX == null)
    {
      AppMethodBeat.o(80674);
      return false;
    }
    boolean bool = this.BkX.epG();
    AppMethodBeat.o(80674);
    return bool;
  }
  
  protected final boolean epH()
  {
    AppMethodBeat.i(80675);
    if ((epG()) && (!this.BkR.isAnimating) && (!this.BkS.isAnimating) && (!this.BkT.isAnimating))
    {
      AppMethodBeat.o(80675);
      return true;
    }
    AppMethodBeat.o(80675);
    return false;
  }
  
  public final int epM()
  {
    return 1;
  }
  
  protected final Map<String, Object> epN()
  {
    AppMethodBeat.i(80660);
    HashMap localHashMap = new HashMap();
    if ((this.rur == null) || (this.wjg == null))
    {
      AppMethodBeat.o(80660);
      return localHashMap;
    }
    ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom %d, title.bottom %d", new Object[] { Integer.valueOf(this.rur.getBottom()), Integer.valueOf(this.wjg.getBottom()) });
    int i;
    if (this.rur.getTop() < this.wjg.getBottom())
    {
      i = this.rur.getBottom() - this.wjg.getBottom();
      localHashMap.put("nativeHeight", Integer.valueOf(com.tencent.mm.cd.a.ar(this, i)));
    }
    for (;;)
    {
      try
      {
        localObject = this.kxf.s(7, null);
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
        ad.printErrStackTrace("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", localException, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(80660);
      return localHashMap;
      i = this.rur.getBottom();
      break;
      localObject = ((Bundle)localObject).getString("data");
    }
  }
  
  protected final void epw()
  {
    AppMethodBeat.i(80666);
    super.epw();
    this.BkX.Wm(11);
    AppMethodBeat.o(80666);
  }
  
  protected final void epx()
  {
    AppMethodBeat.i(80663);
    super.epx();
    epC().setHint(TG(this.BkC));
    AppMethodBeat.o(80663);
  }
  
  protected final void epy()
  {
    AppMethodBeat.i(80667);
    if (this.BkZ > 0)
    {
      AppMethodBeat.o(80667);
      return;
    }
    super.epy();
    TH(0);
    epC().fdg();
    epC().setHint(getHint());
    this.BkX.Wm(2);
    this.Bke.setBackgroundResource(2131234159);
    this.wtD.setVisibility(8);
    this.Bll = null;
    this.Blm = 0;
    this.Blh = false;
    this.BkP.setVisibility(0);
    this.BkO.setVisibility(8);
    h.vKh.f(15521, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(1), epC().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.BkC) });
    AppMethodBeat.o(80667);
  }
  
  protected final void epz()
  {
    AppMethodBeat.i(80668);
    super.epz();
    if (!this.ARU)
    {
      this.BkN.setVisibility(0);
      if ((this.nhy.getTopView() != null) && ((this.nhy.getTopView() instanceof AbsoluteLayout)))
      {
        ((ViewGroup)this.rur.getParent()).removeView(this.rur);
        AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, this.Ble - this.wjg.getHeight());
        ((AbsoluteLayout)this.nhy.getTopView()).addView(this.rur, localLayoutParams);
      }
    }
    AppMethodBeat.o(80668);
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80669);
    String str = TG(epE());
    AppMethodBeat.o(80669);
    return str;
  }
  
  protected final com.tencent.mm.plugin.webview.c.f getJsapi()
  {
    AppMethodBeat.i(188091);
    if (this.Blh)
    {
      localf = this.Blg.getJsapi();
      AppMethodBeat.o(188091);
      return localf;
    }
    com.tencent.mm.plugin.webview.c.f localf = super.getJsapi();
    AppMethodBeat.o(188091);
    return localf;
  }
  
  public int getLayoutId()
  {
    return 2131495630;
  }
  
  public final void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(80662);
    if (this.BkX == null)
    {
      AppMethodBeat.o(80662);
      return;
    }
    if (this.BkX.epG()) {
      super.lb(paramBoolean);
    }
    this.BkX.Wm(5);
    AppMethodBeat.o(80662);
  }
  
  public final void m(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80670);
    if ((this.Blh) && (this.Blg.z(paramInt, paramBundle)))
    {
      AppMethodBeat.o(80670);
      return;
    }
    super.m(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80670);
      return;
      this.BkX.Wm(8);
      AppMethodBeat.o(80670);
      return;
      this.BkX.Wm(10);
      AppMethodBeat.o(80670);
      return;
      paramBundle.getString("fts_key_new_query", "");
      this.BkX.Wm(13);
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
        paramIntent = ayf(paramIntent);
        ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[] { Integer.valueOf(paramIntent.length()), paramIntent });
        this.Bkf.J(paramIntent, null);
        bow();
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
    epC().fdm();
    AppMethodBeat.o(80673);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(80652);
    super.onCreate(paramBundle);
    boolean bool1 = bool2;
    if (getIntent() != null)
    {
      bool1 = bool2;
      if (getIntent().getBooleanExtra("ftsInitToSearch", false)) {
        bool1 = true;
      }
    }
    this.Blb = bool1;
    this.Blg = new WeappWebSearchFragment();
    paramBundle = new Bundle();
    paramBundle.putString("url", getIntent().getStringExtra("key_weapp_url"));
    this.Blg.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().a(2131306894, this.Blg).commit();
    AppMethodBeat.o(80652);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80659);
    super.onDestroy();
    ak.eih();
    ak.eii();
    AppMethodBeat.o(80659);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80658);
    super.onPause();
    ak.eig();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).c(105, false, false);
    }
    AppMethodBeat.o(80658);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80657);
    super.onResume();
    ak.eif();
    AppMethodBeat.o(80657);
  }
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80677);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.nhy == null)
    {
      AppMethodBeat.o(80677);
      return;
    }
    paramInt1 = Math.min(paramInt2, Math.max(com.tencent.mm.cd.a.fromDPToPix(this, this.nhy.getContentHeight()) - this.nhy.getHeight(), 0));
    this.BkR.TI(this.Bld - paramInt1);
    this.BkS.TI(this.Bld - paramInt1);
    this.BkT.TI(this.Bld - paramInt1);
    if (!this.BkX.epG())
    {
      this.rDk.setTranslationY(-paramInt1);
      this.Bke.setTranslationY(-paramInt1);
    }
    if (paramInt2 != 0)
    {
      epC().sz.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(80677);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.sdk.d.d
  {
    com.tencent.mm.sdk.d.c Blq;
    com.tencent.mm.sdk.d.c Blr;
    com.tencent.mm.sdk.d.c Bls;
    com.tencent.mm.sdk.d.c Blt;
    
    protected a(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(80648);
      this.Blq = new a((byte)0);
      this.Blr = new d((byte)0);
      this.Bls = new b((byte)0);
      this.Blt = new c((byte)0);
      a(this.Blq);
      a(this.Blr);
      a(this.Bls);
      a(this.Blt);
      b(this.Blq);
      AppMethodBeat.o(80648);
    }
    
    public final boolean epG()
    {
      AppMethodBeat.i(80650);
      com.tencent.mm.sdk.d.a locala = eHa();
      if ((locala == this.Blr) || (locala == this.Bls) || (locala == this.Blt))
      {
        AppMethodBeat.o(80650);
        return true;
      }
      AppMethodBeat.o(80650);
      return false;
    }
    
    public final void epO()
    {
      AppMethodBeat.i(80649);
      FTSSOSHomeWebViewUI.this.Bkf.setSearchBarCancelTextContainerVisibile(0);
      b(this.Blq);
      AppMethodBeat.o(80649);
    }
    
    final class a
      extends com.tencent.mm.sdk.d.b
    {
      private a() {}
      
      public final void enter()
      {
        AppMethodBeat.i(80636);
        super.enter();
        FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80636);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80637);
        super.exit();
        FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.this.getResources().getColor(2131101053));
        AppMethodBeat.o(80637);
      }
      
      public final String getName()
      {
        return "InitSate";
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(80638);
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          boolean bool = super.k(paramMessage);
          AppMethodBeat.o(80638);
          return bool;
          if ((FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this) != null) && (FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).getVisibility() == 0))
          {
            MotionEvent localMotionEvent = (MotionEvent)paramMessage.obj;
            FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).V(localMotionEvent);
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.this.epC().fdm();
              FTSSOSHomeWebViewUI.this.epC().sz.clearFocus();
              FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).b(a.b.Bmc);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Bmc);
              FTSSOSHomeWebViewUI.this.Bke.setBackgroundResource(2131101179);
              continue;
              FTSSOSHomeWebViewUI.this.epC().fdm();
              FTSSOSHomeWebViewUI.this.epC().sz.clearFocus();
              FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).a(a.b.Bmc, false);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Bmc);
              FTSSOSHomeWebViewUI.this.Bke.setBackgroundResource(2131101179);
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Bls);
              FTSSOSHomeWebViewUI.this.Bkk = true;
              continue;
              FTSSOSHomeWebViewUI.this.epC().fdm();
              FTSSOSHomeWebViewUI.u(FTSSOSHomeWebViewUI.this).b(a.b.Bmc);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Bmc);
              FTSSOSHomeWebViewUI.this.Bke.setBackgroundResource(2131101179);
              continue;
              FTSSOSHomeWebViewUI.this.Bkk = true;
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Blr);
              continue;
              FTSSOSHomeWebViewUI.this.Bkk = true;
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Bls);
              continue;
              if ((FTSSOSHomeWebViewUI.this.epC().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0))
              {
                FTSSOSHomeWebViewUI.this.epC().fdm();
                FTSSOSHomeWebViewUI.this.Bke.setBackgroundResource(2131101179);
                FTSSOSHomeWebViewUI.this.Bkf.setSearchBarCancelTextContainerVisibile(8);
                FTSSOSHomeWebViewUI.u(FTSSOSHomeWebViewUI.this).b(a.b.Bmc);
                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Bmc);
                FTSSOSHomeWebViewUI.this.au(new FTSSOSHomeWebViewUI.a.a.1(this));
                h.vKh.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.this.epC().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.BkC) });
              }
            }
          }
        }
      }
    }
    
    final class b
      extends com.tencent.mm.sdk.d.b
    {
      private b() {}
      
      public final void enter()
      {
        AppMethodBeat.i(80639);
        super.enter();
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Bmc);
        FTSSOSHomeWebViewUI.this.Bke.setBackgroundResource(2131101179);
        FTSSOSHomeWebViewUI.this.Bkf.sz.clearFocus();
        FTSSOSHomeWebViewUI.this.hideVKB();
        FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.this.Bke.setPadding(FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.epC().fdm();
        FTSSOSHomeWebViewUI.this.sUG.setVisibility(0);
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.this.Bkf.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Bkf.setVoiceImageButtonVisibile(0);
        FTSSOSHomeWebViewUI.this.Bkf.fdm();
        FTSSOSHomeWebViewUI.this.Bkf.fdl();
        FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setVisibility(0);
        Object localObject;
        int i;
        if ((com.tencent.mm.compatible.util.d.lf(23)) && (!com.tencent.mm.sdk.h.b.XM()))
        {
          localObject = FTSSOSHomeWebViewUI.this;
          i = FTSSOSHomeWebViewUI.this.getResources().getColor(2131101179);
          if (ai.Eq()) {
            break label731;
          }
        }
        label731:
        for (boolean bool = true;; bool = false)
        {
          FTSSOSHomeWebViewUI.a((FTSSOSHomeWebViewUI)localObject, i, bool);
          FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this).setAlpha(0.0F);
          localObject = (RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Bke.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (FTSSOSHomeWebViewUI.this.Blb) {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          }
          ((RelativeLayout.LayoutParams)localObject).width = -1;
          FTSSOSHomeWebViewUI.this.Bke.setLayoutParams((ViewGroup.LayoutParams)localObject);
          FTSSOSHomeWebViewUI.this.Bke.setY(0.0F);
          FTSSOSHomeWebViewUI.this.Bke.setX(0.0F);
          if (FTSSOSHomeWebViewUI.this.Blb)
          {
            FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this).setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this).setTranslationY(0.0F);
            FTSSOSHomeWebViewUI.this.Bke.setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.this.Bke.setTranslationY(0.0F);
          }
          if ((FTSSOSHomeWebViewUI.this.Blb) && (FTSSOSHomeWebViewUI.this.Blc))
          {
            FTSSOSHomeWebViewUI.this.Bke.setVisibility(8);
            FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this).setAlpha(1.0F);
            FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
            FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this).setVisibility(8);
            if ((FTSSOSHomeWebViewUI.this.getIntent() != null) && (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("customize_status_bar_color")))
            {
              FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.this));
              if (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("status_bar_style")) {
                FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.A(FTSSOSHomeWebViewUI.this), "black".equals(FTSSOSHomeWebViewUI.B(FTSSOSHomeWebViewUI.this)));
              }
            }
            FTSSOSHomeWebViewUI.C(FTSSOSHomeWebViewUI.this).setVisibility(0);
            String str = FTSSOSHomeWebViewUI.this.getIntent().getStringExtra("title");
            localObject = str;
            if (bt.isNullOrNil(str)) {
              localObject = FTSSOSHomeWebViewUI.this.getString(2131759106);
            }
            FTSSOSHomeWebViewUI.C(FTSSOSHomeWebViewUI.this).setText((CharSequence)localObject);
          }
          FTSSOSHomeWebViewUI.this.epJ();
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
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(80641);
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          boolean bool = super.k(paramMessage);
          AppMethodBeat.o(80641);
          return bool;
          if (!FTSSOSHomeWebViewUI.this.Blb)
          {
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).b(a.b.Bmb);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Bmb);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Blq);
            continue;
            if (FTSSOSHomeWebViewUI.this.epC().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Blr);
              h.vKh.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.epC().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.BkC) });
              continue;
              FTSSOSHomeWebViewUI.this.epC().fdm();
            }
          }
        }
      }
    }
    
    final class c
      extends com.tencent.mm.sdk.d.b
    {
      private c() {}
      
      public final void enter()
      {
        AppMethodBeat.i(80642);
        super.enter();
        FTSSOSHomeWebViewUI.this.Bke.setPadding(FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Bke.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Bke.setY(0.0F);
        FTSSOSHomeWebViewUI.this.epC().fdm();
        FTSSOSHomeWebViewUI.this.sUG.setVisibility(0);
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.this.Bkf.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Bkf.setVoiceImageButtonVisibile(0);
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
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(80644);
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          boolean bool = super.k(paramMessage);
          AppMethodBeat.o(80644);
          return bool;
          if (FTSSOSHomeWebViewUI.this.epC().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Blr);
            h.vKh.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.epC().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.BkC) });
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Bls);
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
              {
                FTSSOSHomeWebViewUI.this.epC().fdm();
                FTSSOSHomeWebViewUI.this.epC().sz.clearFocus();
                FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Bls);
                continue;
                if (!FTSSOSHomeWebViewUI.this.Blb)
                {
                  FTSSOSHomeWebViewUI.D(FTSSOSHomeWebViewUI.this).b(a.b.Bmb);
                  FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Bmb);
                }
                else
                {
                  FTSSOSHomeWebViewUI.this.finish();
                  continue;
                  FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Blq);
                }
              }
            }
          }
        }
      }
    }
    
    final class d
      extends com.tencent.mm.sdk.d.b
    {
      private d() {}
      
      public final void enter()
      {
        boolean bool = false;
        AppMethodBeat.i(80645);
        super.enter();
        FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.this.Bke.setPadding(FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Bke.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Bke.setY(0.0F);
        FTSSOSHomeWebViewUI.this.Bkf.setSearchBarCancelTextContainerVisibile(8);
        FTSSOSHomeWebViewUI.this.Bkf.setVoiceImageButtonVisibile(8);
        FTSSOSHomeWebViewUI.this.Bkf.fdl();
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setVisibility(0);
        if (!FTSSOSHomeWebViewUI.this.epC().sz.hasFocus())
        {
          FTSSOSHomeWebViewUI.this.epC().fdj();
          FTSSOSHomeWebViewUI.this.showVKB();
        }
        if ((com.tencent.mm.compatible.util.d.lf(23)) && (!com.tencent.mm.sdk.h.b.XM()))
        {
          FTSSOSHomeWebViewUI localFTSSOSHomeWebViewUI = FTSSOSHomeWebViewUI.this;
          int i = FTSSOSHomeWebViewUI.this.getResources().getColor(2131101179);
          if (!ai.Eq()) {
            bool = true;
          }
          FTSSOSHomeWebViewUI.c(localFTSSOSHomeWebViewUI, i, bool);
        }
        if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
          FTSSOSHomeWebViewUI.this.epC().fdn();
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
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(80647);
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          boolean bool = super.k(paramMessage);
          AppMethodBeat.o(80647);
          return bool;
          if (!FTSSOSHomeWebViewUI.this.Blb)
          {
            FTSSOSHomeWebViewUI.u(FTSSOSHomeWebViewUI.this).b(a.b.Bmb);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.Bmb);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Blq);
            continue;
            if (!FTSSOSHomeWebViewUI.this.epC().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Bls);
            }
            else
            {
              h.vKh.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.epC().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.BkC) });
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Bls);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI
 * JD-Core Version:    0.7.0.1
 */