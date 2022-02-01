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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  private View EyR;
  private View EyS;
  private TextView EyT;
  private b EyU;
  private c EyV;
  private d EyW;
  private float EyX;
  private float EyY;
  private View EyZ;
  private a Eza;
  private int Ezb;
  private int Ezc;
  private String Ezd;
  boolean Eze;
  private int Ezf;
  private int Ezg;
  private int Ezh;
  private String Ezi;
  private a.a Ezj;
  private a.a Ezk;
  private a.a Ezl;
  private String Ezm;
  private int Ezn;
  private FTSMainUIEducationLayout tKP;
  private View.OnClickListener tLe;
  private View tTA;
  private View yZr;
  private View zjN;
  
  public FTSSOSHomeWebViewUI()
  {
    AppMethodBeat.i(80651);
    this.EyX = 0.0F;
    this.EyY = 0.0F;
    this.Ezc = 0;
    this.Ezd = "";
    this.Ezg = 0;
    this.Ezh = 0;
    this.Ezi = "";
    this.tLe = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(80632);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (!FTSSOSHomeWebViewUI.this.Eym)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(80632);
          return;
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).abg(1);
        localObject = ((TextView)paramAnonymousView).getText().toString();
        final int i = FTSSOSHomeWebViewUI.a((JSONObject)paramAnonymousView.getTag(), (String)localObject, FTSSOSHomeWebViewUI.this);
        if (i != 0)
        {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, (String)localObject);
          if (FTSSOSHomeWebViewUI.this.EyD != i) {
            com.tencent.mm.plugin.report.service.g.yxI.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(4), FTSSOSHomeWebViewUI.this.eXD().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EyD) });
          }
          if ((FTSSOSHomeWebViewUI.this.EyD != i) && (!FTSSOSHomeWebViewUI.this.eXD().getTagList().isEmpty()))
          {
            paramAnonymousView = FTSSOSHomeWebViewUI.this.getTotalQuery();
            FTSSOSHomeWebViewUI.this.eXD().clearText();
            FTSSOSHomeWebViewUI.this.eXD().I(paramAnonymousView, null);
            FTSSOSHomeWebViewUI.this.eXD().fOm();
          }
          FTSSOSHomeWebViewUI.this.EyD = i;
          FTSSOSHomeWebViewUI.this.eXx();
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
            if ((FTSSOSHomeWebViewUI.this.getScene() != 20) || (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).eXG())) {
              continue;
            }
            if (i == 0) {
              continue;
            }
            FTSSOSHomeWebViewUI.this.EyC = 22;
            paramAnonymousView.putInt("scene", 22);
            paramAnonymousView = FTSSOSHomeWebViewUI.this.lzT.v(4, paramAnonymousView);
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
                  if (!bu.isNullOrNil(FTSSOSHomeWebViewUI.this.getTotalQuery())) {
                    localHashMap.put("query", FTSSOSHomeWebViewUI.this.getTotalQuery());
                  }
                  bool = FTSSOSHomeWebViewUI.this.getJsapi().a(paramAnonymousView.getString("scene", "0"), paramAnonymousView.getString("type", "0"), paramAnonymousView.getString("isSug", "0"), paramAnonymousView.getString("isLocalSug", "0"), FTSSOSHomeWebViewUI.this.getSessionId(), localHashMap);
                  if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
                    ac.a(FTSSOSHomeWebViewUI.this.scene, FTSSOSHomeWebViewUI.this.sessionId, FTSSOSHomeWebViewUI.this.dEb, true, FTSSOSHomeWebViewUI.this.getInEditTextQuery(), FTSSOSHomeWebViewUI.this.EyD);
                  }
                  if (bool)
                  {
                    FTSSOSHomeWebViewUI.this.eXD().setHint(FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, i));
                    am.d(i, FTSSOSHomeWebViewUI.this.EyC, FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this), FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).eXG());
                    FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).abg(7);
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
          FTSSOSHomeWebViewUI.this.EyC = 20;
          paramAnonymousView.putInt("scene", 20);
          continue;
          FTSSOSHomeWebViewUI.this.EyC = FTSSOSHomeWebViewUI.this.getScene();
          paramAnonymousView.putInt("scene", FTSSOSHomeWebViewUI.this.getScene());
        }
      }
    };
    this.Ezj = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80633);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).abg(4);
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
    this.Ezk = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80621);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).abg(9);
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
    this.Ezl = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80623);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).abg(3);
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
  
  private String Yk(int paramInt)
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
      if ((eXM()) || (this.scene == 53)) {
        paramInt = 2131762962;
      }
      if (paramInt >= 0) {
        break label228;
      }
      if (bu.isNullOrNil(this.Ezi)) {
        break;
      }
      str = getString(2131762937, new Object[] { this.Ezi });
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
  
  private void Yl(int paramInt)
  {
    AppMethodBeat.i(80672);
    eXD().getIconView().setImageDrawable(Yj(paramInt));
    if (paramInt == 0) {
      eXD().getIconView().setIconColor(getResources().getColor(2131099735));
    }
    AppMethodBeat.o(80672);
  }
  
  private void Ym(int paramInt)
  {
    AppMethodBeat.i(198371);
    if (getIntent().getBooleanExtra("key_hide_shadow_view", false))
    {
      this.zjN.setVisibility(8);
      AppMethodBeat.o(198371);
      return;
    }
    this.zjN.setVisibility(paramInt);
    AppMethodBeat.o(198371);
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
        ae.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "option " + paramString + " no type");
        i = j;
      }
    }
  }
  
  private static String aKq(String paramString)
  {
    AppMethodBeat.i(80656);
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      try
      {
        int i = com.tencent.mm.ui.tools.f.aYK(paramString);
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
          k += com.tencent.mm.ui.tools.f.aYK(String.valueOf(paramString[j]));
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
  
  private boolean eXM()
  {
    return this.scene == 36;
  }
  
  private void eXN()
  {
    AppMethodBeat.i(80654);
    if (this.osM == null)
    {
      AppMethodBeat.o(80654);
      return;
    }
    final View localView = this.osM.getView();
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80630);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        FTSSOSHomeWebViewUI.this.eXJ();
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) != null)
        {
          paramAnonymousView = FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this);
          localObject = paramAnonymousView.IBf;
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
  
  private void eXQ()
  {
    AppMethodBeat.i(198367);
    if ((this.tKP != null) && ((this.tKP.getLayoutParams() instanceof RelativeLayout.LayoutParams)))
    {
      this.Ezh = ((RelativeLayout.LayoutParams)this.tKP.getLayoutParams()).topMargin;
      if (this.Eym) {
        if ((this.osM.getTopView() == null) || (!(this.osM.getTopView() instanceof AbsoluteLayout))) {
          break label193;
        }
      }
    }
    label193:
    for (boolean bool = true;; bool = false)
    {
      int i = this.Ezh;
      int j = this.yZr.getHeight();
      ae.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "setEducationViewToWebView %b educationOriginMarginTop:%d titleContainer.getHeight:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Ezh), Integer.valueOf(this.yZr.getHeight()) });
      if (bool)
      {
        ((ViewGroup)this.tKP.getParent()).removeView(this.tKP);
        AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, i - j);
        ((AbsoluteLayout)this.osM.getTopView()).addView(this.tKP, localLayoutParams);
      }
      AppMethodBeat.o(198367);
      return;
    }
  }
  
  private void vs(boolean paramBoolean)
  {
    AppMethodBeat.i(198369);
    ae.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "updateWebViewStatus isCancelling:%b visible:%s", new Object[] { Boolean.valueOf(this.Eyl), Boolean.valueOf(paramBoolean) });
    if (this.EyR != null)
    {
      if ((!this.Eyl) && (paramBoolean))
      {
        this.EyR.setAlpha(1.0F);
        AppMethodBeat.o(198369);
        return;
      }
      this.EyR.setAlpha(0.0F);
    }
    AppMethodBeat.o(198369);
  }
  
  public final void Xp(int paramInt)
  {
    AppMethodBeat.i(80678);
    if ((this.osM == null) || (this.osM.getSettings() == null))
    {
      AppMethodBeat.o(80678);
      return;
    }
    float f = getContext().getSharedPreferences(ak.fow(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cb.a.ie(getContext()));
    if (f >= com.tencent.mm.cb.a.ik(getContext()))
    {
      this.osM.getSettings().setTextZoom(160);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.ij(getContext()))
    {
      this.osM.getSettings().setTextZoom(150);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.ii(getContext()))
    {
      this.osM.getSettings().setTextZoom(140);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.ih(getContext()))
    {
      this.osM.getSettings().setTextZoom(130);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.ig(getContext()))
    {
      this.osM.getSettings().setTextZoom(120);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.jdMethod_if(getContext()))
    {
      this.osM.getSettings().setTextZoom(110);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.ie(getContext()))
    {
      this.osM.getSettings().setTextZoom(100);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cb.a.id(getContext()))
    {
      this.osM.getSettings().setTextZoom(90);
      AppMethodBeat.o(80678);
      return;
    }
    this.osM.getSettings().setTextZoom(80);
    AppMethodBeat.o(80678);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164033);
    if (paramb == FTSEditTextView.b.KYW) {
      this.Ezn = 0;
    }
    super.a(paramString1, paramString2, paramList, paramb);
    AppMethodBeat.o(164033);
  }
  
  public final void bAi()
  {
    AppMethodBeat.i(80653);
    super.bAi();
    this.Eza = new a("sos_home_webview_ui", getMainLooper());
    this.yZr = findViewById(2131305918);
    this.EyZ = findViewById(2131305919);
    this.EyS = findViewById(2131298736);
    this.tTA = findViewById(2131305949);
    this.EyR = findViewById(2131306921);
    this.EyT = ((TextView)findViewById(2131300740));
    ((WebViewKeyboardLinearLayout)this.EyR).setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void Hs(int paramAnonymousInt)
      {
        AppMethodBeat.i(80620);
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) == null)
        {
          AppMethodBeat.o(80620);
          return;
        }
        if (paramAnonymousInt == -2) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).abg(12);
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, paramAnonymousInt);
        AppMethodBeat.o(80620);
      }
    });
    this.tKP = ((FTSMainUIEducationLayout)findViewById(2131304415));
    this.tKP.setOnCellClickListener(this.tLe);
    this.tKP.setCellClickable(false);
    this.tKP.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
        FTSSOSHomeWebViewUI.this.EzA.countDown();
        if ((FTSSOSHomeWebViewUI.this.Eyd.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Eyd.getLayoutParams()).topMargin);
        }
        FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80625);
      }
    });
    this.EyU = new b(this, this.Eyd, this.tTA, eXD().getIconView(), this.gVf, this.gVf, eXD().getEditText(), this.yZr, this.EyZ);
    this.EyU.a(this.Ezj);
    this.EyV = new c(this, this.Eyd, this.tTA, eXD().getIconView(), this.gVf, this.gVf, eXD().getEditText(), this.yZr, this.EyZ);
    this.EyV.a(this.Ezl);
    this.EyW = new d(this, this.Eyd, this.tTA, eXD().getIconView(), this.gVf, this.gVf, eXD().getEditText(), this.yZr, this.EyZ);
    this.EyW.a(this.Ezk);
    this.zjN = findViewById(2131305116);
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "educationTab");
        localObject2 = this.lzT.v(2, (Bundle)localObject1);
        localObject1 = ((Bundle)localObject2).getString("result");
        localObject2 = ((Bundle)localObject2).getString("result_1");
        if (localObject2 != null) {
          continue;
        }
        localObject1 = new JSONObject((String)localObject1);
        this.tKP.at((JSONObject)localObject1);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          FTSSOSHomeWebViewUI.this.eXD().vr.clearFocus();
          FTSSOSHomeWebViewUI.this.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(80626);
          return false;
        }
      });
      this.Ezb = com.tencent.mm.cb.a.fromDPToPix(this, 24);
      eXD().eQt();
      eXD().fOg();
      if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsInitToSearch", false)))
      {
        bool = true;
        this.Eyf = bool;
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("hideSearchInput", false))) {
          continue;
        }
        bool = true;
        this.Eze = bool;
        this.Ezf = getIntent().getIntExtra("key_back_btn_type", 0);
        if (this.Eza != null)
        {
          if (!this.Eyf) {
            continue;
          }
          this.Eyd.setVisibility(0);
          this.EyZ.setBackgroundColor(getResources().getColor(2131101053));
          localObject1 = this.Eza;
          ((a)localObject1).b(((a)localObject1).Ezt);
          if ((com.tencent.mm.compatible.util.d.lA(23)) && (!com.tencent.mm.compatible.util.g.abu()))
          {
            i = getResources().getColor(2131101179);
            if (al.isDarkMode()) {
              continue;
            }
            bool = true;
            aZ(i, bool);
          }
          this.Eza.start();
        }
        if (this.Ezf != 1) {
          continue;
        }
        if (!al.isDarkMode()) {
          continue;
        }
        this.gVf.setImageDrawable(ao.k(this, 2131690535, -1));
      }
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "searchID");
        this.Ezd = this.lzT.v(6, (Bundle)localObject1).getString("result");
        am.aR(this.Ezd, getSessionId(), this.tKP.getVertBizTypes());
        am.WR(getScene());
        eXN();
        this.Eyd.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198366);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Eyd.getX());
            FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.Eyd.getY());
            ae.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getSearchInputLayout originInputX=%s originInputY=%s", new Object[] { Float.valueOf(FTSSOSHomeWebViewUI.f(FTSSOSHomeWebViewUI.this)), Float.valueOf(FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this)) });
            AppMethodBeat.o(198366);
          }
        }, 100L);
        this.Eye.setVoiceBtnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80628);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            boolean bool = com.tencent.mm.pluginsdk.permission.b.a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "");
            ae.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), FTSSOSHomeWebViewUI.this });
            if (!bool)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(80628);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("sessionId", FTSSOSHomeWebViewUI.this.sessionId);
            paramAnonymousView.putExtra("subSessionId", FTSSOSHomeWebViewUI.this.dEb);
            paramAnonymousView.putExtra("key_scene", FTSSOSHomeWebViewUI.this.scene);
            if (FTSSOSHomeWebViewUI.this.eXG()) {}
            for (int i = 1;; i = 2)
            {
              paramAnonymousView.putExtra("key_is_nav_voice", i);
              com.tencent.mm.br.d.c(FTSSOSHomeWebViewUI.this, ".ui.websearch.WebSearchVoiceUI", paramAnonymousView, 1);
              FTSSOSHomeWebViewUI.this.overridePendingTransition(0, 0);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(80628);
              return;
            }
          }
        });
        this.Eye.setCancelTextViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80629);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            FTSSOSHomeWebViewUI.this.eXy();
            FTSSOSHomeWebViewUI.this.eXJ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80629);
          }
        });
        Yl(getType());
        localObject1 = eXD().getClearBtn();
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
        this.Eza.eXR();
        continue;
        this.gVf.setImageDrawable(ao.k(this, 2131690535, -16777216));
        continue;
        if (this.Ezf != 2) {
          continue;
        }
        this.gVf.setVisibility(8);
        this.Ezb = 0;
      }
      catch (Exception localException1) {}
    }
  }
  
  public final int bAj()
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
    this.Eyf = bool1;
    if ((com.tencent.mm.compatible.util.d.lA(23)) && (!com.tencent.mm.sdk.h.b.abu()))
    {
      if (this.Eyf)
      {
        AppMethodBeat.o(80661);
        return -1;
      }
      i = getResources().getColor(2131101159);
      AppMethodBeat.o(80661);
      return i;
    }
    int i = super.bAj();
    AppMethodBeat.o(80661);
    return i;
  }
  
  public final boolean bAu()
  {
    AppMethodBeat.i(80665);
    if (!this.Eym)
    {
      AppMethodBeat.o(80665);
      return true;
    }
    this.Eza.abg(0);
    super.bAu();
    AppMethodBeat.o(80665);
    return true;
  }
  
  protected final void eXA()
  {
    AppMethodBeat.i(80668);
    super.eXA();
    vs(true);
    eXQ();
    AppMethodBeat.o(80668);
  }
  
  public final String eXB()
  {
    if (this.Ezn == 0) {
      return "";
    }
    return this.Ezm;
  }
  
  public final int eXC()
  {
    return this.Ezn;
  }
  
  public final boolean eXG()
  {
    AppMethodBeat.i(80674);
    if (this.Eza == null)
    {
      AppMethodBeat.o(80674);
      return false;
    }
    boolean bool = this.Eza.eXG();
    AppMethodBeat.o(80674);
    return bool;
  }
  
  protected final boolean eXH()
  {
    AppMethodBeat.i(80675);
    if ((eXG()) && (!this.EyU.isAnimating) && (!this.EyV.isAnimating) && (!this.EyW.isAnimating))
    {
      AppMethodBeat.o(80675);
      return true;
    }
    AppMethodBeat.o(80675);
    return false;
  }
  
  public final int eXO()
  {
    return 1;
  }
  
  protected final Map<String, Object> eXP()
  {
    AppMethodBeat.i(80660);
    HashMap localHashMap = new HashMap();
    if ((this.tKP == null) || (this.yZr == null))
    {
      AppMethodBeat.o(80660);
      return localHashMap;
    }
    int i;
    if (this.Efm)
    {
      i = this.tKP.getBottom();
      ae.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom:%d edu.top:%d title.bottom():%d nativeH:%d", new Object[] { Integer.valueOf(this.tKP.getBottom()), Integer.valueOf(this.yZr.getBottom()), Integer.valueOf(this.tKP.getTop()), Integer.valueOf(i) });
      localHashMap.put("nativeHeight", Integer.valueOf(com.tencent.mm.cb.a.aA(this, i)));
    }
    for (;;)
    {
      try
      {
        localObject = this.lzT.v(7, null);
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
        ae.printErrStackTrace("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", localException, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(80660);
      return localHashMap;
      i = this.tKP.getBottom() - this.yZr.getBottom();
      break;
      localObject = ((Bundle)localObject).getString("data");
    }
  }
  
  protected final void eXw()
  {
    AppMethodBeat.i(80666);
    super.eXw();
    this.Eza.abg(11);
    AppMethodBeat.o(80666);
  }
  
  protected final void eXx()
  {
    AppMethodBeat.i(80663);
    super.eXx();
    eXD().setHint(Yk(this.EyD));
    AppMethodBeat.o(80663);
  }
  
  protected final void eXy()
  {
    AppMethodBeat.i(80667);
    if (this.Ezc > 0)
    {
      AppMethodBeat.o(80667);
      return;
    }
    super.eXy();
    Yl(0);
    eXD().fOg();
    eXD().setHint(getHint());
    this.Eza.abg(2);
    this.Eyd.setBackgroundResource(2131234159);
    Ym(8);
    this.Ezm = null;
    this.Ezn = 0;
    this.EyS.setVisibility(0);
    com.tencent.mm.plugin.report.service.g.yxI.f(15521, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(1), eXD().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.EyD) });
    AppMethodBeat.o(80667);
  }
  
  protected final void eXz()
  {
    AppMethodBeat.i(198368);
    vs(true);
    AppMethodBeat.o(198368);
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80669);
    String str = Yk(cDl());
    AppMethodBeat.o(80669);
    return str;
  }
  
  protected final com.tencent.mm.plugin.webview.c.f getJsapi()
  {
    AppMethodBeat.i(198370);
    com.tencent.mm.plugin.webview.c.f localf = super.getJsapi();
    AppMethodBeat.o(198370);
    return localf;
  }
  
  public int getLayoutId()
  {
    return 2131495630;
  }
  
  public final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(80662);
    if (this.Eza == null)
    {
      AppMethodBeat.o(80662);
      return;
    }
    if (this.Eza.eXG()) {
      super.mb(paramBoolean);
    }
    this.Eza.abg(5);
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
      this.Eza.abg(8);
      AppMethodBeat.o(80670);
      return;
      this.Eza.abg(10);
      AppMethodBeat.o(80670);
      return;
      paramBundle.getString("fts_key_new_query", "");
      this.Eza.abg(13);
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
        paramIntent = aKq(paramIntent);
        ae.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[] { Integer.valueOf(paramIntent.length()), paramIntent });
        this.Eye.I(paramIntent, null);
        bAu();
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
    eXD().fOm();
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
    am.eQb();
    am.eQc();
    AppMethodBeat.o(80659);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80658);
    super.onPause();
    am.eQa();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).c(105, false, false);
    }
    AppMethodBeat.o(80658);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80657);
    super.onResume();
    am.ePZ();
    AppMethodBeat.o(80657);
  }
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80677);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.osM == null)
    {
      AppMethodBeat.o(80677);
      return;
    }
    paramInt1 = Math.min(paramInt2, Math.max(com.tencent.mm.cb.a.fromDPToPix(this, this.osM.getContentHeight()) - this.osM.getHeight(), 0));
    this.EyU.Yn(this.Ezg - paramInt1);
    this.EyV.Yn(this.Ezg - paramInt1);
    this.EyW.Yn(this.Ezg - paramInt1);
    if (!this.Eza.eXG())
    {
      this.tTA.setTranslationY(-paramInt1);
      this.Eyd.setTranslationY(-paramInt1);
    }
    if (paramInt2 != 0)
    {
      eXD().vr.clearFocus();
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
    com.tencent.mm.sdk.d.c Ezr;
    com.tencent.mm.sdk.d.c Ezs;
    com.tencent.mm.sdk.d.c Ezt;
    com.tencent.mm.sdk.d.c Ezu;
    
    protected a(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(80648);
      this.Ezr = new a((byte)0);
      this.Ezs = new d((byte)0);
      this.Ezt = new b((byte)0);
      this.Ezu = new c((byte)0);
      a(this.Ezr);
      a(this.Ezs);
      a(this.Ezt);
      a(this.Ezu);
      b(this.Ezr);
      AppMethodBeat.o(80648);
    }
    
    public final boolean eXG()
    {
      AppMethodBeat.i(80650);
      com.tencent.mm.sdk.d.a locala = fqa();
      if ((locala == this.Ezs) || (locala == this.Ezt) || (locala == this.Ezu))
      {
        AppMethodBeat.o(80650);
        return true;
      }
      AppMethodBeat.o(80650);
      return false;
    }
    
    public final void eXR()
    {
      AppMethodBeat.i(80649);
      FTSSOSHomeWebViewUI.this.Eye.setSearchBarCancelTextContainerVisibile(0);
      b(this.Ezr);
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
            FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).S(localMotionEvent);
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.this.eXD().fOm();
              FTSSOSHomeWebViewUI.this.eXD().vr.clearFocus();
              FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this).b(a.b.EAb);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EAb);
              FTSSOSHomeWebViewUI.this.Eyd.setBackgroundResource(2131101179);
              continue;
              FTSSOSHomeWebViewUI.this.eXD().fOm();
              FTSSOSHomeWebViewUI.this.eXD().vr.clearFocus();
              FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this).a(a.b.EAb, false);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EAb);
              FTSSOSHomeWebViewUI.this.Eyd.setBackgroundResource(2131101179);
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezt);
              FTSSOSHomeWebViewUI.this.Eyk = true;
              continue;
              FTSSOSHomeWebViewUI.this.eXD().fOm();
              FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this).b(a.b.EAb);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EAb);
              FTSSOSHomeWebViewUI.this.Eyd.setBackgroundResource(2131101179);
              continue;
              FTSSOSHomeWebViewUI.this.Eyk = true;
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezs);
              continue;
              FTSSOSHomeWebViewUI.this.Eyk = true;
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezt);
              continue;
              if ((FTSSOSHomeWebViewUI.this.eXD().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0))
              {
                FTSSOSHomeWebViewUI.this.eXD().fOm();
                FTSSOSHomeWebViewUI.this.Eyd.setBackgroundResource(2131101179);
                FTSSOSHomeWebViewUI.this.Eye.setSearchBarCancelTextContainerVisibile(8);
                FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this).b(a.b.EAb);
                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EAb);
                FTSSOSHomeWebViewUI.this.at(new FTSSOSHomeWebViewUI.a.a.1(this));
                com.tencent.mm.plugin.report.service.g.yxI.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.this.eXD().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EyD) });
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
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EAb);
        FTSSOSHomeWebViewUI.this.Eyd.setBackgroundResource(2131101179);
        FTSSOSHomeWebViewUI.this.Eye.vr.clearFocus();
        FTSSOSHomeWebViewUI.this.hideVKB();
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Eyd.setPadding(FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.eXD().fOm();
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.this.Eye.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Eye.setVoiceImageButtonVisibile(0);
        FTSSOSHomeWebViewUI.this.Eye.fOm();
        FTSSOSHomeWebViewUI.this.Eye.fOl();
        FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this);
        Object localObject;
        int i;
        if ((com.tencent.mm.compatible.util.d.lA(23)) && (!com.tencent.mm.sdk.h.b.abu()))
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
          localObject = (RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.Eyd.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (FTSSOSHomeWebViewUI.this.Eyf) {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          }
          ((RelativeLayout.LayoutParams)localObject).width = -1;
          FTSSOSHomeWebViewUI.this.Eyd.setLayoutParams((ViewGroup.LayoutParams)localObject);
          FTSSOSHomeWebViewUI.this.Eyd.setY(0.0F);
          FTSSOSHomeWebViewUI.this.Eyd.setX(0.0F);
          if (FTSSOSHomeWebViewUI.this.Eyf)
          {
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this).setTranslationY(0.0F);
            FTSSOSHomeWebViewUI.this.Eyd.setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.this.Eyd.setTranslationY(0.0F);
          }
          if ((FTSSOSHomeWebViewUI.this.Eyf) && (FTSSOSHomeWebViewUI.this.Eze))
          {
            FTSSOSHomeWebViewUI.this.Eyd.setVisibility(8);
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
            if (bu.isNullOrNil(str)) {
              localObject = FTSSOSHomeWebViewUI.this.getString(2131759106);
            }
            FTSSOSHomeWebViewUI.x(FTSSOSHomeWebViewUI.this).setText((CharSequence)localObject);
          }
          FTSSOSHomeWebViewUI.this.eXJ();
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
          if (!FTSSOSHomeWebViewUI.this.Eyf)
          {
            FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this).b(a.b.EAa);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EAa);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezr);
            continue;
            if (FTSSOSHomeWebViewUI.this.eXD().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezs);
              com.tencent.mm.plugin.report.service.g.yxI.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.eXD().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EyD) });
              continue;
              FTSSOSHomeWebViewUI.this.eXD().fOm();
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
        FTSSOSHomeWebViewUI.this.Eyd.setPadding(FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Eyd.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Eyd.setY(0.0F);
        FTSSOSHomeWebViewUI.this.eXD().fOm();
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.Eye.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.Eye.setVoiceImageButtonVisibile(0);
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
          if (FTSSOSHomeWebViewUI.this.eXD().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezs);
            com.tencent.mm.plugin.report.service.g.yxI.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.eXD().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EyD) });
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezt);
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
              {
                FTSSOSHomeWebViewUI.this.eXD().fOm();
                FTSSOSHomeWebViewUI.this.eXD().vr.clearFocus();
                FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezt);
                continue;
                if (!FTSSOSHomeWebViewUI.this.Eyf)
                {
                  FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this).b(a.b.EAa);
                  FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EAa);
                }
                else
                {
                  FTSSOSHomeWebViewUI.this.finish();
                  continue;
                  FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezr);
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
        FTSSOSHomeWebViewUI.this.Eyd.setPadding(FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.Eyd.setX(0.0F);
        FTSSOSHomeWebViewUI.this.Eyd.setY(0.0F);
        FTSSOSHomeWebViewUI.this.Eye.setSearchBarCancelTextContainerVisibile(8);
        FTSSOSHomeWebViewUI.this.Eye.setVoiceImageButtonVisibile(8);
        FTSSOSHomeWebViewUI.this.Eye.fOl();
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this);
        if (!FTSSOSHomeWebViewUI.this.eXD().vr.hasFocus())
        {
          FTSSOSHomeWebViewUI.this.eXD().fOj();
          FTSSOSHomeWebViewUI.this.showVKB();
        }
        if ((com.tencent.mm.compatible.util.d.lA(23)) && (!com.tencent.mm.sdk.h.b.abu()))
        {
          FTSSOSHomeWebViewUI localFTSSOSHomeWebViewUI = FTSSOSHomeWebViewUI.this;
          int i = FTSSOSHomeWebViewUI.this.getResources().getColor(2131101179);
          if (!al.isDarkMode()) {
            bool = true;
          }
          FTSSOSHomeWebViewUI.c(localFTSSOSHomeWebViewUI, i, bool);
        }
        if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
          FTSSOSHomeWebViewUI.this.eXD().fOn();
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
          if (!FTSSOSHomeWebViewUI.this.Eyf)
          {
            FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this).b(a.b.EAa);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.EAa);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezr);
            continue;
            if (!FTSSOSHomeWebViewUI.this.eXD().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezt);
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.eXD().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.EyD) });
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.Ezt);
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