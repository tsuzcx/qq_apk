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
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI
  extends BaseSOSWebViewUI
{
  private View EgO;
  private View EgP;
  private TextView EgQ;
  private b EgR;
  private c EgS;
  private d EgT;
  private float EgU;
  private View EgV;
  private a EgW;
  private int EgX;
  private int EgY;
  private String EgZ;
  boolean Eha;
  private int Ehb;
  private int Ehc;
  private int Ehd;
  private String Ehe;
  private a.a Ehf;
  private a.a Ehg;
  private a.a Ehh;
  private String Ehi;
  private int Ehj;
  private float OdZ;
  private View.OnClickListener tAn;
  private View tIJ;
  private FTSMainUIEducationLayout tzY;
  private View yJh;
  private View yTD;
  
  public FTSSOSHomeWebViewUI()
  {
    AppMethodBeat.i(80651);
    this.EgU = 0.0F;
    this.OdZ = 0.0F;
    this.EgY = 0;
    this.EgZ = "";
    this.Ehc = 0;
    this.Ehd = 0;
    this.Ehe = "";
    this.tAn = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(80632);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (!FTSSOSHomeWebViewUI.this.Egj)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(80632);
          return;
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).aaA(1);
        localObject = ((TextView)paramAnonymousView).getText().toString();
        final int i = FTSSOSHomeWebViewUI.a((JSONObject)paramAnonymousView.getTag(), (String)localObject, FTSSOSHomeWebViewUI.this);
        if (i != 0)
        {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, (String)localObject);
          if (FTSSOSHomeWebViewUI.this.EgA != i) {
            com.tencent.mm.plugin.report.service.g.yhR.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(4), FTSSOSHomeWebViewUI.this.eTQ().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EgA) });
          }
          if ((FTSSOSHomeWebViewUI.this.EgA != i) && (!FTSSOSHomeWebViewUI.this.eTQ().getTagList().isEmpty()))
          {
            paramAnonymousView = FTSSOSHomeWebViewUI.this.getTotalQuery();
            FTSSOSHomeWebViewUI.this.eTQ().clearText();
            FTSSOSHomeWebViewUI.this.eTQ().H(paramAnonymousView, null);
            FTSSOSHomeWebViewUI.this.eTQ().fJV();
          }
          FTSSOSHomeWebViewUI.this.EgA = i;
          FTSSOSHomeWebViewUI.this.eTK();
          FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this, i);
        }
        for (;;)
        {
          try
          {
            FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this);
            paramAnonymousView = new Bundle();
            paramAnonymousView.putInt("type", i);
            if (i != 0) {
              continue;
            }
            bool = true;
            paramAnonymousView.putBoolean("isHomePage", bool);
            if ((FTSSOSHomeWebViewUI.this.getScene() != 20) || (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).eTT())) {
              continue;
            }
            if (i == 0) {
              continue;
            }
            FTSSOSHomeWebViewUI.this.Egz = 22;
            paramAnonymousView.putInt("scene", 22);
            paramAnonymousView = FTSSOSHomeWebViewUI.this.lvv.v(4, paramAnonymousView);
            FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this).post(new Runnable()
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
                    ac.a(FTSSOSHomeWebViewUI.this.scene, FTSSOSHomeWebViewUI.this.sessionId, FTSSOSHomeWebViewUI.this.dCW, true, FTSSOSHomeWebViewUI.this.getInEditTextQuery(), FTSSOSHomeWebViewUI.this.EgA);
                  }
                  if (bool)
                  {
                    FTSSOSHomeWebViewUI.this.eTQ().setHint(FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, i));
                    am.d(i, FTSSOSHomeWebViewUI.this.Egz, FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this), FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).eTT());
                    FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).aaA(7);
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
          }
          catch (Exception paramAnonymousView)
          {
            boolean bool;
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(80632);
          return;
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, "");
          break;
          bool = false;
          continue;
          FTSSOSHomeWebViewUI.this.Egz = 20;
          paramAnonymousView.putInt("scene", 20);
          continue;
          FTSSOSHomeWebViewUI.this.Egz = FTSSOSHomeWebViewUI.this.getScene();
          paramAnonymousView.putInt("scene", FTSSOSHomeWebViewUI.this.getScene());
        }
      }
    };
    this.Ehf = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80633);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).aaA(4);
        FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80633);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80634);
        FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80634);
      }
    };
    this.Ehg = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80621);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).aaA(9);
        FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80621);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80622);
        FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80622);
      }
    };
    this.Ehh = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80623);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).aaA(3);
        FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80623);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80624);
        FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80624);
      }
    };
    AppMethodBeat.o(80651);
  }
  
  private String XE(int paramInt)
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
      if ((eTZ()) || (this.scene == 53)) {
        paramInt = 2131762962;
      }
      if (paramInt >= 0) {
        break label228;
      }
      if (bt.isNullOrNil(this.Ehe)) {
        break;
      }
      str = getString(2131762937, new Object[] { this.Ehe });
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
  
  private void XF(int paramInt)
  {
    AppMethodBeat.i(80672);
    eTQ().getIconView().setImageDrawable(XD(paramInt));
    if (paramInt == 0) {
      eTQ().getIconView().setIconColor(getResources().getColor(2131099735));
    }
    AppMethodBeat.o(80672);
  }
  
  private void XG(int paramInt)
  {
    AppMethodBeat.i(208192);
    if (getIntent().getBooleanExtra("key_hide_shadow_view", false))
    {
      this.yTD.setVisibility(8);
      AppMethodBeat.o(208192);
      return;
    }
    this.yTD.setVisibility(paramInt);
    AppMethodBeat.o(208192);
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
  
  private static String aIX(String paramString)
  {
    AppMethodBeat.i(80656);
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      try
      {
        int i = com.tencent.mm.ui.tools.f.aXj(paramString);
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
          k += com.tencent.mm.ui.tools.f.aXj(String.valueOf(paramString[j]));
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
  
  private boolean eTZ()
  {
    return this.scene == 36;
  }
  
  private void eUa()
  {
    AppMethodBeat.i(80654);
    if (this.omW == null)
    {
      AppMethodBeat.o(80654);
      return;
    }
    final View localView = this.omW.getView();
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80630);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        FTSSOSHomeWebViewUI.this.eTW();
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) != null)
        {
          paramAnonymousView = FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this);
          localObject = paramAnonymousView.IgU;
          if (localObject != null) {
            ((d.c)localObject).sendMessage(paramAnonymousView.obtainMessage(15, paramAnonymousMotionEvent));
          }
        }
        boolean bool = localView.onTouchEvent(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(80630);
        return bool;
      }
    });
    AppMethodBeat.o(80654);
  }
  
  private void eUd()
  {
    AppMethodBeat.i(208188);
    if ((this.tzY != null) && ((this.tzY.getLayoutParams() instanceof RelativeLayout.LayoutParams)))
    {
      this.Ehd = ((RelativeLayout.LayoutParams)this.tzY.getLayoutParams()).topMargin;
      if (this.Egj) {
        if ((this.omW.getTopView() == null) || (!(this.omW.getTopView() instanceof AbsoluteLayout))) {
          break label193;
        }
      }
    }
    label193:
    for (boolean bool = true;; bool = false)
    {
      int i = this.Ehd;
      int j = this.yJh.getHeight();
      ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "setEducationViewToWebView %b educationOriginMarginTop:%d titleContainer.getHeight:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Ehd), Integer.valueOf(this.yJh.getHeight()) });
      if (bool)
      {
        ((ViewGroup)this.tzY.getParent()).removeView(this.tzY);
        AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, i - j);
        ((AbsoluteLayout)this.omW.getTopView()).addView(this.tzY, localLayoutParams);
      }
      AppMethodBeat.o(208188);
      return;
    }
  }
  
  private void vj(boolean paramBoolean)
  {
    AppMethodBeat.i(208190);
    ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "updateWebViewStatus isCancelling:%b visible:%s", new Object[] { Boolean.valueOf(this.Egi), Boolean.valueOf(paramBoolean) });
    if (this.EgO != null)
    {
      if ((!this.Egi) && (paramBoolean))
      {
        this.EgO.setAlpha(1.0F);
        AppMethodBeat.o(208190);
        return;
      }
      this.EgO.setAlpha(0.0F);
    }
    AppMethodBeat.o(208190);
  }
  
  public final void WI(int paramInt)
  {
    AppMethodBeat.i(80678);
    if ((this.omW == null) || (this.omW.getSettings() == null))
    {
      AppMethodBeat.o(80678);
      return;
    }
    float f = getContext().getSharedPreferences(aj.fkC(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cc.a.hZ(getContext()));
    if (f >= com.tencent.mm.cc.a.jdMethod_if(getContext()))
    {
      this.omW.getSettings().setTextZoom(160);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.ie(getContext()))
    {
      this.omW.getSettings().setTextZoom(150);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.id(getContext()))
    {
      this.omW.getSettings().setTextZoom(140);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.ic(getContext()))
    {
      this.omW.getSettings().setTextZoom(130);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.ib(getContext()))
    {
      this.omW.getSettings().setTextZoom(120);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.ia(getContext()))
    {
      this.omW.getSettings().setTextZoom(110);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hZ(getContext()))
    {
      this.omW.getSettings().setTextZoom(100);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hY(getContext()))
    {
      this.omW.getSettings().setTextZoom(90);
      AppMethodBeat.o(80678);
      return;
    }
    this.omW.getSettings().setTextZoom(80);
    AppMethodBeat.o(80678);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164033);
    if (paramb == FTSEditTextView.b.KCC) {
      this.Ehj = 0;
    }
    super.a(paramString1, paramString2, paramList, paramb);
    AppMethodBeat.o(164033);
  }
  
  public final void bzn()
  {
    AppMethodBeat.i(80653);
    super.bzn();
    this.EgW = new a("sos_home_webview_ui", getMainLooper());
    this.yJh = findViewById(2131305918);
    this.EgV = findViewById(2131305919);
    this.EgP = findViewById(2131298736);
    this.tIJ = findViewById(2131305949);
    this.EgO = findViewById(2131306921);
    this.EgQ = ((TextView)findViewById(2131300740));
    ((WebViewKeyboardLinearLayout)this.EgO).setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void GV(int paramAnonymousInt)
      {
        AppMethodBeat.i(80620);
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) == null)
        {
          AppMethodBeat.o(80620);
          return;
        }
        if (paramAnonymousInt == -2) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).aaA(12);
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, paramAnonymousInt);
        AppMethodBeat.o(80620);
      }
    });
    this.tzY = ((FTSMainUIEducationLayout)findViewById(2131304415));
    this.tzY.setOnCellClickListener(this.tAn);
    this.tzY.setCellClickable(false);
    this.tzY.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
        FTSSOSHomeWebViewUI.this.Ehw.countDown();
        if ((FTSSOSHomeWebViewUI.this.Ega.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Ega.getLayoutParams()).topMargin);
        }
        FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80625);
      }
    });
    this.EgR = new b(this, this.Ega, this.tIJ, eTQ().getIconView(), this.gSx, this.gSx, eTQ().getEditText(), this.yJh, this.EgV);
    this.EgR.a(this.Ehf);
    this.EgS = new c(this, this.Ega, this.tIJ, eTQ().getIconView(), this.gSx, this.gSx, eTQ().getEditText(), this.yJh, this.EgV);
    this.EgS.a(this.Ehh);
    this.EgT = new d(this, this.Ega, this.tIJ, eTQ().getIconView(), this.gSx, this.gSx, eTQ().getEditText(), this.yJh, this.EgV);
    this.EgT.a(this.Ehg);
    this.yTD = findViewById(2131305116);
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "educationTab");
        localObject2 = this.lvv.v(2, (Bundle)localObject1);
        localObject1 = ((Bundle)localObject2).getString("result");
        localObject2 = ((Bundle)localObject2).getString("result_1");
        if (localObject2 != null) {
          continue;
        }
        localObject1 = new JSONObject((String)localObject1);
        this.tzY.at((JSONObject)localObject1);
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          FTSSOSHomeWebViewUI.this.eTQ().vr.clearFocus();
          FTSSOSHomeWebViewUI.this.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(80626);
          return false;
        }
      });
      this.EgX = com.tencent.mm.cc.a.fromDPToPix(this, 24);
      eTQ().eMI();
      eTQ().fJP();
      if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsInitToSearch", false)))
      {
        bool = true;
        this.Egc = bool;
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("hideSearchInput", false))) {
          continue;
        }
        bool = true;
        this.Eha = bool;
        this.Ehb = getIntent().getIntExtra("key_back_btn_type", 0);
        if (this.EgW != null)
        {
          if (!this.Egc) {
            continue;
          }
          this.Ega.setVisibility(0);
          this.EgV.setBackgroundColor(getResources().getColor(2131101053));
          localObject1 = this.EgW;
          ((a)localObject1).b(((a)localObject1).Ehp);
          if ((com.tencent.mm.compatible.util.d.ly(23)) && (!com.tencent.mm.compatible.util.g.abl()))
          {
            i = getResources().getColor(2131101179);
            if (al.isDarkMode()) {
              continue;
            }
            bool = true;
            aT(i, bool);
          }
          this.EgW.start();
        }
        if (this.Ehb != 1) {
          continue;
        }
        if (!al.isDarkMode()) {
          continue;
        }
        this.gSx.setImageDrawable(ao.k(this, 2131690535, -1));
      }
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "searchID");
        this.EgZ = this.lvv.v(6, (Bundle)localObject1).getString("result");
        am.aQ(this.EgZ, getSessionId(), this.tzY.getVertBizTypes());
        am.Wk(getScene());
        eUa();
        this.Ega.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208187);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Ega.getX());
            FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Ega.getY());
            ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getSearchInputLayout originInputX=%s originInputY=%s", new Object[] { Float.valueOf(FTSSOSHomeWebViewUI.f(FTSSOSHomeWebViewUI.this)), Float.valueOf(FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this)) });
            AppMethodBeat.o(208187);
          }
        }, 100L);
        this.Egb.setVoiceBtnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80628);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            boolean bool = com.tencent.mm.pluginsdk.permission.b.a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "");
            ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), FTSSOSHomeWebViewUI.this });
            if (!bool)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(80628);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("sessionId", FTSSOSHomeWebViewUI.this.sessionId);
            paramAnonymousView.putExtra("subSessionId", FTSSOSHomeWebViewUI.this.dCW);
            paramAnonymousView.putExtra("key_scene", FTSSOSHomeWebViewUI.this.scene);
            if (FTSSOSHomeWebViewUI.this.eTT()) {}
            for (int i = 1;; i = 2)
            {
              paramAnonymousView.putExtra("key_is_nav_voice", i);
              com.tencent.mm.bs.d.c(FTSSOSHomeWebViewUI.this, ".ui.websearch.WebSearchVoiceUI", paramAnonymousView, 1);
              FTSSOSHomeWebViewUI.this.overridePendingTransition(0, 0);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(80628);
              return;
            }
          }
        });
        this.Egb.setCancelTextViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80629);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            FTSSOSHomeWebViewUI.this.eTL();
            FTSSOSHomeWebViewUI.this.eTW();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80629);
          }
        });
        XF(getType());
        localObject1 = eTQ().getClearBtn();
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
        this.EgW.eUe();
        continue;
        this.gSx.setImageDrawable(ao.k(this, 2131690535, -16777216));
        continue;
        if (this.Ehb != 2) {
          continue;
        }
        this.gSx.setVisibility(8);
        this.EgX = 0;
      }
      catch (Exception localException1) {}
    }
  }
  
  public final int bzo()
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
    this.Egc = bool1;
    if ((com.tencent.mm.compatible.util.d.ly(23)) && (!com.tencent.mm.sdk.h.b.abl()))
    {
      if (this.Egc)
      {
        AppMethodBeat.o(80661);
        return -1;
      }
      i = getResources().getColor(2131101159);
      AppMethodBeat.o(80661);
      return i;
    }
    int i = super.bzo();
    AppMethodBeat.o(80661);
    return i;
  }
  
  public final boolean bzz()
  {
    AppMethodBeat.i(80665);
    if (!this.Egj)
    {
      AppMethodBeat.o(80665);
      return true;
    }
    this.EgW.aaA(0);
    super.bzz();
    AppMethodBeat.o(80665);
    return true;
  }
  
  protected final void eTJ()
  {
    AppMethodBeat.i(80666);
    super.eTJ();
    this.EgW.aaA(11);
    AppMethodBeat.o(80666);
  }
  
  protected final void eTK()
  {
    AppMethodBeat.i(80663);
    super.eTK();
    eTQ().setHint(XE(this.EgA));
    AppMethodBeat.o(80663);
  }
  
  protected final void eTL()
  {
    AppMethodBeat.i(80667);
    if (this.EgY > 0)
    {
      AppMethodBeat.o(80667);
      return;
    }
    super.eTL();
    XF(0);
    eTQ().fJP();
    eTQ().setHint(getHint());
    this.EgW.aaA(2);
    this.Ega.setBackgroundResource(2131234159);
    XG(8);
    this.Ehi = null;
    this.Ehj = 0;
    this.EgP.setVisibility(0);
    com.tencent.mm.plugin.report.service.g.yhR.f(15521, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(1), eTQ().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.EgA) });
    AppMethodBeat.o(80667);
  }
  
  protected final void eTM()
  {
    AppMethodBeat.i(208189);
    vj(true);
    AppMethodBeat.o(208189);
  }
  
  protected final void eTN()
  {
    AppMethodBeat.i(80668);
    super.eTN();
    vj(true);
    eUd();
    AppMethodBeat.o(80668);
  }
  
  public final String eTO()
  {
    if (this.Ehj == 0) {
      return "";
    }
    return this.Ehi;
  }
  
  public final int eTP()
  {
    return this.Ehj;
  }
  
  public final boolean eTT()
  {
    AppMethodBeat.i(80674);
    if (this.EgW == null)
    {
      AppMethodBeat.o(80674);
      return false;
    }
    boolean bool = this.EgW.eTT();
    AppMethodBeat.o(80674);
    return bool;
  }
  
  protected final boolean eTU()
  {
    AppMethodBeat.i(80675);
    if ((eTT()) && (!this.EgR.isAnimating) && (!this.EgS.isAnimating) && (!this.EgT.isAnimating))
    {
      AppMethodBeat.o(80675);
      return true;
    }
    AppMethodBeat.o(80675);
    return false;
  }
  
  public final int eUb()
  {
    return 1;
  }
  
  protected final Map<String, Object> eUc()
  {
    AppMethodBeat.i(80660);
    HashMap localHashMap = new HashMap();
    if ((this.tzY == null) || (this.yJh == null))
    {
      AppMethodBeat.o(80660);
      return localHashMap;
    }
    int i;
    if (this.DNn)
    {
      i = this.tzY.getBottom();
      ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom:%d edu.top:%d title.bottom():%d nativeH:%d", new Object[] { Integer.valueOf(this.tzY.getBottom()), Integer.valueOf(this.yJh.getBottom()), Integer.valueOf(this.tzY.getTop()), Integer.valueOf(i) });
      localHashMap.put("nativeHeight", Integer.valueOf(com.tencent.mm.cc.a.aA(this, i)));
    }
    for (;;)
    {
      try
      {
        localObject = this.lvv.v(7, null);
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
      i = this.tzY.getBottom() - this.yJh.getBottom();
      break;
      localObject = ((Bundle)localObject).getString("data");
    }
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80669);
    String str = XE(cBz());
    AppMethodBeat.o(80669);
    return str;
  }
  
  protected final com.tencent.mm.plugin.webview.c.f getJsapi()
  {
    AppMethodBeat.i(208191);
    com.tencent.mm.plugin.webview.c.f localf = super.getJsapi();
    AppMethodBeat.o(208191);
    return localf;
  }
  
  public int getLayoutId()
  {
    return 2131495630;
  }
  
  public final void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(80662);
    if (this.EgW == null)
    {
      AppMethodBeat.o(80662);
      return;
    }
    if (this.EgW.eTT()) {
      super.ma(paramBoolean);
    }
    this.EgW.aaA(5);
    AppMethodBeat.o(80662);
  }
  
  public final void n(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80670);
    super.n(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80670);
      return;
      this.EgW.aaA(8);
      AppMethodBeat.o(80670);
      return;
      this.EgW.aaA(10);
      AppMethodBeat.o(80670);
      return;
      paramBundle.getString("fts_key_new_query", "");
      this.EgW.aaA(13);
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
        paramIntent = aIX(paramIntent);
        ad.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[] { Integer.valueOf(paramIntent.length()), paramIntent });
        this.Egb.H(paramIntent, null);
        bzz();
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
    eTQ().fJV();
    AppMethodBeat.o(80673);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80652);
    super.onCreate(paramBundle);
    new Bundle().putString("url", getIntent().getStringExtra("key_weapp_url"));
    AppMethodBeat.o(80652);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80659);
    super.onDestroy();
    am.eMs();
    am.eMt();
    AppMethodBeat.o(80659);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80658);
    super.onPause();
    am.eMr();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).c(105, false, false);
    }
    AppMethodBeat.o(80658);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80657);
    super.onResume();
    am.eMq();
    AppMethodBeat.o(80657);
  }
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80677);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.omW == null)
    {
      AppMethodBeat.o(80677);
      return;
    }
    paramInt1 = Math.min(paramInt2, Math.max(com.tencent.mm.cc.a.fromDPToPix(this, this.omW.getContentHeight()) - this.omW.getHeight(), 0));
    this.EgR.XH(this.Ehc - paramInt1);
    this.EgS.XH(this.Ehc - paramInt1);
    this.EgT.XH(this.Ehc - paramInt1);
    if (!this.EgW.eTT())
    {
      this.tIJ.setTranslationY(-paramInt1);
      this.Ega.setTranslationY(-paramInt1);
    }
    if (paramInt2 != 0)
    {
      eTQ().vr.clearFocus();
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
    com.tencent.mm.sdk.d.c Ehn;
    com.tencent.mm.sdk.d.c Eho;
    com.tencent.mm.sdk.d.c Ehp;
    com.tencent.mm.sdk.d.c Ehq;
    
    protected a(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(80648);
      this.Ehn = new a((byte)0);
      this.Eho = new d((byte)0);
      this.Ehp = new b((byte)0);
      this.Ehq = new c((byte)0);
      a(this.Ehn);
      a(this.Eho);
      a(this.Ehp);
      a(this.Ehq);
      b(this.Ehn);
      AppMethodBeat.o(80648);
    }
    
    public final boolean eTT()
    {
      AppMethodBeat.i(80650);
      com.tencent.mm.sdk.d.a locala = fmf();
      if ((locala == this.Eho) || (locala == this.Ehp) || (locala == this.Ehq))
      {
        AppMethodBeat.o(80650);
        return true;
      }
      AppMethodBeat.o(80650);
      return false;
    }
    
    public final void eUe()
    {
      AppMethodBeat.i(80649);
      FTSSOSHomeWebViewUI.this.Egb.setSearchBarCancelTextContainerVisibile(0);
      b(this.Ehn);
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
        FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80636);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80637);
        super.exit();
        FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.this.getResources().getColor(2131101053));
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
            FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).U(localMotionEvent);
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.this.eTQ().fJV();
              FTSSOSHomeWebViewUI.this.eTQ().vr.clearFocus();
              FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this).b(a.b.EhX);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EhX);
              FTSSOSHomeWebViewUI.this.Ega.setBackgroundResource(2131101179);
              continue;
              FTSSOSHomeWebViewUI.this.eTQ().fJV();
              FTSSOSHomeWebViewUI.this.eTQ().vr.clearFocus();
              FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this).a(a.b.EhX, false);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EhX);
              FTSSOSHomeWebViewUI.this.Ega.setBackgroundResource(2131101179);
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ehp);
              FTSSOSHomeWebViewUI.this.Egh = true;
              continue;
              FTSSOSHomeWebViewUI.this.eTQ().fJV();
              FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this).b(a.b.EhX);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EhX);
              FTSSOSHomeWebViewUI.this.Ega.setBackgroundResource(2131101179);
              continue;
              FTSSOSHomeWebViewUI.this.Egh = true;
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Eho);
              continue;
              FTSSOSHomeWebViewUI.this.Egh = true;
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ehp);
              continue;
              if ((FTSSOSHomeWebViewUI.this.eTQ().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0))
              {
                FTSSOSHomeWebViewUI.this.eTQ().fJV();
                FTSSOSHomeWebViewUI.this.Ega.setBackgroundResource(2131101179);
                FTSSOSHomeWebViewUI.this.Egb.setSearchBarCancelTextContainerVisibile(8);
                FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this).b(a.b.EhX);
                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EhX);
                FTSSOSHomeWebViewUI.this.av(new FTSSOSHomeWebViewUI.a.a.1(this));
                com.tencent.mm.plugin.report.service.g.yhR.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.this.eTQ().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EgA) });
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
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EhX);
        FTSSOSHomeWebViewUI.this.Ega.setBackgroundResource(2131101179);
        FTSSOSHomeWebViewUI.this.Egb.vr.clearFocus();
        FTSSOSHomeWebViewUI.this.hideVKB();
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Ega.setPadding(FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.eTQ().fJV();
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.this.Egb.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Egb.setVoiceImageButtonVisibile(0);
        FTSSOSHomeWebViewUI.this.Egb.fJV();
        FTSSOSHomeWebViewUI.this.Egb.fJU();
        FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this);
        Object localObject;
        int i;
        if ((com.tencent.mm.compatible.util.d.ly(23)) && (!com.tencent.mm.sdk.h.b.abl()))
        {
          localObject = FTSSOSHomeWebViewUI.this;
          i = FTSSOSHomeWebViewUI.this.getResources().getColor(2131101179);
          if (al.isDarkMode()) {
            break label709;
          }
        }
        label709:
        for (boolean bool = true;; bool = false)
        {
          FTSSOSHomeWebViewUI.a((FTSSOSHomeWebViewUI)localObject, i, bool);
          FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setAlpha(0.0F);
          localObject = (RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Ega.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (FTSSOSHomeWebViewUI.this.Egc) {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          }
          ((RelativeLayout.LayoutParams)localObject).width = -1;
          FTSSOSHomeWebViewUI.this.Ega.setLayoutParams((ViewGroup.LayoutParams)localObject);
          FTSSOSHomeWebViewUI.this.Ega.setY(0.0F);
          FTSSOSHomeWebViewUI.this.Ega.setX(0.0F);
          if (FTSSOSHomeWebViewUI.this.Egc)
          {
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setTranslationY(0.0F);
            FTSSOSHomeWebViewUI.this.Ega.setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.this.Ega.setTranslationY(0.0F);
          }
          if ((FTSSOSHomeWebViewUI.this.Egc) && (FTSSOSHomeWebViewUI.this.Eha))
          {
            FTSSOSHomeWebViewUI.this.Ega.setVisibility(8);
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setAlpha(1.0F);
            FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setVisibility(8);
            if ((FTSSOSHomeWebViewUI.this.getIntent() != null) && (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("customize_status_bar_color")))
            {
              FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.u(FTSSOSHomeWebViewUI.this));
              if (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("status_bar_style")) {
                FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this), "black".equals(FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.this)));
              }
            }
            FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setVisibility(0);
            String str = FTSSOSHomeWebViewUI.this.getIntent().getStringExtra("title");
            localObject = str;
            if (bt.isNullOrNil(str)) {
              localObject = FTSSOSHomeWebViewUI.this.getString(2131759106);
            }
            FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setText((CharSequence)localObject);
          }
          FTSSOSHomeWebViewUI.this.eTW();
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
          if (!FTSSOSHomeWebViewUI.this.Egc)
          {
            FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this).b(a.b.EhW);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EhW);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ehn);
            continue;
            if (FTSSOSHomeWebViewUI.this.eTQ().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Eho);
              com.tencent.mm.plugin.report.service.g.yhR.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.eTQ().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EgA) });
              continue;
              FTSSOSHomeWebViewUI.this.eTQ().fJV();
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
        FTSSOSHomeWebViewUI.this.Ega.setPadding(FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Ega.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Ega.setY(0.0F);
        FTSSOSHomeWebViewUI.this.eTQ().fJV();
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Egb.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Egb.setVoiceImageButtonVisibile(0);
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
          if (FTSSOSHomeWebViewUI.this.eTQ().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Eho);
            com.tencent.mm.plugin.report.service.g.yhR.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.eTQ().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EgA) });
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ehp);
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
              {
                FTSSOSHomeWebViewUI.this.eTQ().fJV();
                FTSSOSHomeWebViewUI.this.eTQ().vr.clearFocus();
                FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ehp);
                continue;
                if (!FTSSOSHomeWebViewUI.this.Egc)
                {
                  FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this).b(a.b.EhW);
                  FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EhW);
                }
                else
                {
                  FTSSOSHomeWebViewUI.this.finish();
                  continue;
                  FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ehn);
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
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Ega.setPadding(FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Ega.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Ega.setY(0.0F);
        FTSSOSHomeWebViewUI.this.Egb.setSearchBarCancelTextContainerVisibile(8);
        FTSSOSHomeWebViewUI.this.Egb.setVoiceImageButtonVisibile(8);
        FTSSOSHomeWebViewUI.this.Egb.fJU();
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this);
        if (!FTSSOSHomeWebViewUI.this.eTQ().vr.hasFocus())
        {
          FTSSOSHomeWebViewUI.this.eTQ().fJS();
          FTSSOSHomeWebViewUI.this.showVKB();
        }
        if ((com.tencent.mm.compatible.util.d.ly(23)) && (!com.tencent.mm.sdk.h.b.abl()))
        {
          FTSSOSHomeWebViewUI localFTSSOSHomeWebViewUI = FTSSOSHomeWebViewUI.this;
          int i = FTSSOSHomeWebViewUI.this.getResources().getColor(2131101179);
          if (!al.isDarkMode()) {
            bool = true;
          }
          FTSSOSHomeWebViewUI.c(localFTSSOSHomeWebViewUI, i, bool);
        }
        if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
          FTSSOSHomeWebViewUI.this.eTQ().fJW();
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
          if (!FTSSOSHomeWebViewUI.this.Egc)
          {
            FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this).b(a.b.EhW);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EhW);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ehn);
            continue;
            if (!FTSSOSHomeWebViewUI.this.eTQ().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ehp);
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yhR.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.eTQ().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EgA) });
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ehp);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI
 * JD-Core Version:    0.7.0.1
 */