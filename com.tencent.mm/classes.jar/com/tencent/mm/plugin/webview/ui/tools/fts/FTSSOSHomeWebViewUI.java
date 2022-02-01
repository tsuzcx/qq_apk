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
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI
  extends BaseSOSWebViewUI
{
  private View CDd;
  private View CDe;
  private TextView CDf;
  private b CDg;
  private c CDh;
  private d CDi;
  private float CDj;
  private View CDk;
  private a CDl;
  private int CDm;
  private int CDn;
  private String CDo;
  boolean CDp;
  boolean CDq;
  private int CDr;
  private int CDs;
  private String CDt;
  private a.a CDu;
  private a.a CDv;
  private a.a CDw;
  private String CDx;
  private int CDy;
  private FTSMainUIEducationLayout sDj;
  private View.OnClickListener sDy;
  private View sMc;
  private View xET;
  private View xuw;
  
  public FTSSOSHomeWebViewUI()
  {
    AppMethodBeat.i(80651);
    this.CDj = 3.4028235E+38F;
    this.CDn = 0;
    this.CDo = "";
    this.CDr = 0;
    this.CDs = 0;
    this.CDt = "";
    this.sDy = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(80632);
        if (!FTSSOSHomeWebViewUI.this.CCA)
        {
          AppMethodBeat.o(80632);
          return;
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Yv(1);
        String str = ((TextView)paramAnonymousView).getText().toString();
        final int i = FTSSOSHomeWebViewUI.a((JSONObject)paramAnonymousView.getTag(), str, FTSSOSHomeWebViewUI.this);
        if (i != 0)
        {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, str);
          if (FTSSOSHomeWebViewUI.this.CCR != i) {
            h.wUl.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(4), FTSSOSHomeWebViewUI.this.eEX().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.CCR) });
          }
          if ((FTSSOSHomeWebViewUI.this.CCR != i) && (!FTSSOSHomeWebViewUI.this.eEX().getTagList().isEmpty()))
          {
            paramAnonymousView = FTSSOSHomeWebViewUI.this.getTotalQuery();
            FTSSOSHomeWebViewUI.this.eEX().clearText();
            FTSSOSHomeWebViewUI.this.eEX().F(paramAnonymousView, null);
            FTSSOSHomeWebViewUI.this.eEX().fth();
          }
          FTSSOSHomeWebViewUI.this.CCR = i;
          FTSSOSHomeWebViewUI.this.eES();
          FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this, i);
        }
        for (;;)
        {
          try
          {
            FTSSOSHomeWebViewUI.f(FTSSOSHomeWebViewUI.this);
            paramAnonymousView = new Bundle();
            paramAnonymousView.putInt("type", i);
            if (i == 0)
            {
              bool = true;
              paramAnonymousView.putBoolean("isHomePage", bool);
              if ((FTSSOSHomeWebViewUI.this.getScene() != 20) || (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).eFa())) {
                break label417;
              }
              if (i == 0) {
                continue;
              }
              FTSSOSHomeWebViewUI.this.CCQ = 22;
              paramAnonymousView.putInt("scene", 22);
              paramAnonymousView = FTSSOSHomeWebViewUI.this.kYt.t(4, paramAnonymousView);
              FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this).post(new Runnable()
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
                    if (!bs.isNullOrNil(FTSSOSHomeWebViewUI.this.getTotalQuery())) {
                      localHashMap.put("query", FTSSOSHomeWebViewUI.this.getTotalQuery());
                    }
                    bool = FTSSOSHomeWebViewUI.this.getJsapi().a(paramAnonymousView.getString("scene", "0"), paramAnonymousView.getString("type", "0"), paramAnonymousView.getString("isSug", "0"), paramAnonymousView.getString("isLocalSug", "0"), FTSSOSHomeWebViewUI.this.getSessionId(), localHashMap);
                    if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
                      y.a(FTSSOSHomeWebViewUI.this.scene, FTSSOSHomeWebViewUI.this.sessionId, FTSSOSHomeWebViewUI.this.drf, true, FTSSOSHomeWebViewUI.this.getInEditTextQuery(), FTSSOSHomeWebViewUI.this.CCR);
                    }
                    if (bool)
                    {
                      FTSSOSHomeWebViewUI.this.eEX().setHint(FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, i));
                      com.tencent.mm.plugin.websearch.api.ai.d(i, FTSSOSHomeWebViewUI.this.CCQ, FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this), FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).eFa());
                      FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Yv(7);
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
            FTSSOSHomeWebViewUI.this.CCQ = 20;
            paramAnonymousView.putInt("scene", 20);
            continue;
            FTSSOSHomeWebViewUI.this.CCQ = FTSSOSHomeWebViewUI.this.getScene();
          }
          catch (Exception paramAnonymousView)
          {
            AppMethodBeat.o(80632);
            return;
          }
          label417:
          paramAnonymousView.putInt("scene", FTSSOSHomeWebViewUI.this.getScene());
        }
      }
    };
    this.CDu = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80633);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Yv(4);
        FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80633);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80634);
        FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80634);
      }
    };
    this.CDv = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80621);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Yv(9);
        FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80621);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80622);
        FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80622);
      }
    };
    this.CDw = new a.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(80623);
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Yv(3);
        FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80623);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(80624);
        FTSSOSHomeWebViewUI.j(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80624);
      }
    };
    AppMethodBeat.o(80651);
  }
  
  private String VO(int paramInt)
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
      if ((eFe()) || (this.scene == 53)) {
        paramInt = 2131762962;
      }
      if (paramInt >= 0) {
        break label228;
      }
      if (bs.isNullOrNil(this.CDt)) {
        break;
      }
      str = getString(2131762937, new Object[] { this.CDt });
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
  
  private void VP(int paramInt)
  {
    AppMethodBeat.i(80672);
    eEX().getIconView().setImageDrawable(VN(paramInt));
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
        ac.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "option " + paramString + " no type");
        i = j;
      }
    }
  }
  
  private static String aDw(String paramString)
  {
    AppMethodBeat.i(80656);
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      try
      {
        int i = com.tencent.mm.ui.tools.f.aRl(paramString);
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
          k += com.tencent.mm.ui.tools.f.aRl(String.valueOf(paramString[j]));
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
  
  private boolean eFe()
  {
    return this.scene == 36;
  }
  
  private void eFf()
  {
    AppMethodBeat.i(80654);
    if (this.nKq == null)
    {
      AppMethodBeat.o(80654);
      return;
    }
    final View localView = this.nKq.getView();
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80630);
        FTSSOSHomeWebViewUI.this.eFd();
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) != null)
        {
          paramAnonymousView = FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this);
          d.c localc = paramAnonymousView.GuZ;
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
  
  private void fdg()
  {
    AppMethodBeat.i(210082);
    if ((this.sDj.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      this.CDs = ((RelativeLayout.LayoutParams)this.sDj.getLayoutParams()).topMargin;
      if (this.CCA) {
        if ((this.nKq.getTopView() == null) || (!(this.nKq.getTopView() instanceof AbsoluteLayout))) {
          break label186;
        }
      }
    }
    label186:
    for (boolean bool = true;; bool = false)
    {
      int i = this.CDs;
      int j = this.xuw.getHeight();
      ac.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "setEducationViewToWebView %b educationOriginMarginTop:%d titleContainer.getHeight:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.CDs), Integer.valueOf(this.xuw.getHeight()) });
      if (bool)
      {
        ((ViewGroup)this.sDj.getParent()).removeView(this.sDj);
        AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, i - j);
        ((AbsoluteLayout)this.nKq.getTopView()).addView(this.sDj, localLayoutParams);
      }
      AppMethodBeat.o(210082);
      return;
    }
  }
  
  private void zL(boolean paramBoolean)
  {
    AppMethodBeat.i(210084);
    ac.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "updateWebViewStatus isCancelling:%b visible:%s", new Object[] { Boolean.valueOf(this.Had), Boolean.valueOf(paramBoolean) });
    if ((!this.Had) && (paramBoolean))
    {
      this.CDd.setAlpha(1.0F);
      AppMethodBeat.o(210084);
      return;
    }
    this.CDd.setAlpha(0.0F);
    AppMethodBeat.o(210084);
  }
  
  public final void US(int paramInt)
  {
    AppMethodBeat.i(80678);
    if ((this.nKq == null) || (this.nKq.getSettings() == null))
    {
      AppMethodBeat.o(80678);
      return;
    }
    float f = getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cc.a.hQ(getContext()));
    if (f >= com.tencent.mm.cc.a.hW(getContext()))
    {
      this.nKq.getSettings().setTextZoom(160);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hV(getContext()))
    {
      this.nKq.getSettings().setTextZoom(150);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hU(getContext()))
    {
      this.nKq.getSettings().setTextZoom(140);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hT(getContext()))
    {
      this.nKq.getSettings().setTextZoom(130);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hS(getContext()))
    {
      this.nKq.getSettings().setTextZoom(120);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hR(getContext()))
    {
      this.nKq.getSettings().setTextZoom(110);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hQ(getContext()))
    {
      this.nKq.getSettings().setTextZoom(100);
      AppMethodBeat.o(80678);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hP(getContext()))
    {
      this.nKq.getSettings().setTextZoom(90);
      AppMethodBeat.o(80678);
      return;
    }
    this.nKq.getSettings().setTextZoom(80);
    AppMethodBeat.o(80678);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164033);
    if (paramb == FTSEditTextView.b.ILv) {
      this.CDy = 0;
    }
    super.a(paramString1, paramString2, paramList, paramb);
    AppMethodBeat.o(164033);
  }
  
  public final void bvh()
  {
    boolean bool2 = true;
    AppMethodBeat.i(80653);
    super.bvh();
    this.CDl = new a("sos_home_webview_ui", getMainLooper());
    this.xuw = findViewById(2131305918);
    this.CDk = findViewById(2131305919);
    this.CDe = findViewById(2131298736);
    this.sMc = findViewById(2131305949);
    this.CDd = findViewById(2131306921);
    this.CDf = ((TextView)findViewById(2131300740));
    ((WebViewKeyboardLinearLayout)this.CDd).setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void FG(int paramAnonymousInt)
      {
        AppMethodBeat.i(80620);
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) == null)
        {
          AppMethodBeat.o(80620);
          return;
        }
        if (paramAnonymousInt == -2) {
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this).Yv(12);
        }
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, paramAnonymousInt);
        AppMethodBeat.o(80620);
      }
    });
    this.sDj = ((FTSMainUIEducationLayout)findViewById(2131304415));
    this.sDj.setOnCellClickListener(this.sDy);
    this.sDj.setCellClickable(false);
    this.sDj.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
        FTSSOSHomeWebViewUI.this.CDL.countDown();
        if ((FTSSOSHomeWebViewUI.this.CCt.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.CCt.getLayoutParams()).topMargin);
        }
        FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.e(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80625);
      }
    });
    this.CDg = new b(this, this.CCt, this.sMc, eEX().getIconView(), this.ucS, this.ucS, eEX().getEditText(), this.xuw, this.CDk);
    this.CDg.a(this.CDu);
    this.CDh = new c(this, this.CCt, this.sMc, eEX().getIconView(), this.ucS, this.ucS, eEX().getEditText(), this.xuw, this.CDk);
    this.CDh.a(this.CDw);
    this.CDi = new d(this, this.CCt, this.sMc, eEX().getIconView(), this.ucS, this.ucS, eEX().getEditText(), this.xuw, this.CDk);
    this.CDi.a(this.CDv);
    this.xET = findViewById(2131305116);
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "educationTab");
        localObject2 = this.kYt.t(2, (Bundle)localObject1);
        localObject1 = ((Bundle)localObject2).getString("result");
        localObject2 = ((Bundle)localObject2).getString("result_1");
        if (localObject2 != null) {
          continue;
        }
        localObject1 = new JSONObject((String)localObject1);
        this.sDj.ap((JSONObject)localObject1);
      }
      catch (Exception localException2)
      {
        Object localObject1;
        Object localObject2;
        boolean bool1;
        int i;
        continue;
      }
      findViewById(2131298761).setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(80626);
          FTSSOSHomeWebViewUI.this.eEX().ty.clearFocus();
          FTSSOSHomeWebViewUI.this.hideVKB();
          AppMethodBeat.o(80626);
          return false;
        }
      });
      this.CDm = com.tencent.mm.cc.a.fromDPToPix(this, 24);
      eEX().exR();
      eEX().ftb();
      if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsInitToSearch", false)))
      {
        bool1 = true;
        this.CDp = bool1;
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("hideSearchInput", false))) {
          continue;
        }
        bool1 = true;
        this.CDq = bool1;
        if (this.CDl != null)
        {
          if (!this.CDp) {
            continue;
          }
          this.CDk.setBackgroundColor(getResources().getColor(2131101053));
          localObject1 = this.CDl;
          ((a)localObject1).b(((a)localObject1).CDE);
          if ((com.tencent.mm.compatible.util.d.kZ(23)) && (!com.tencent.mm.compatible.util.g.YJ()))
          {
            i = getResources().getColor(2131101179);
            if (aj.DT()) {
              continue;
            }
            bool1 = bool2;
            aM(i, bool1);
          }
          this.CDl.start();
        }
      }
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "searchID");
        this.CDo = this.kYt.t(6, (Bundle)localObject1).getString("result");
        com.tencent.mm.plugin.websearch.api.ai.aI(this.CDo, getSessionId(), this.sDj.getVertBizTypes());
        com.tencent.mm.plugin.websearch.api.ai.Ur(getScene());
        eFf();
        this.CCt.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(80627);
            FTSSOSHomeWebViewUI.this.CCt.getViewTreeObserver().removeOnPreDrawListener(this);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.CCt.getX());
            AppMethodBeat.o(80627);
            return true;
          }
        });
        this.CCu.setVoiceBtnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int i = 2;
            AppMethodBeat.i(80628);
            boolean bool = com.tencent.mm.pluginsdk.permission.b.a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "");
            ac.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), FTSSOSHomeWebViewUI.this });
            if (!bool)
            {
              AppMethodBeat.o(80628);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("sessionId", FTSSOSHomeWebViewUI.this.sessionId);
            paramAnonymousView.putExtra("subSessionId", FTSSOSHomeWebViewUI.this.drf);
            paramAnonymousView.putExtra("key_scene", FTSSOSHomeWebViewUI.this.scene);
            if (FTSSOSHomeWebViewUI.this.eFa()) {
              i = 1;
            }
            paramAnonymousView.putExtra("key_is_nav_voice", i);
            com.tencent.mm.br.d.c(FTSSOSHomeWebViewUI.this, ".ui.websearch.WebSearchVoiceUI", paramAnonymousView, 1);
            FTSSOSHomeWebViewUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.o(80628);
          }
        });
        this.CCu.setCancelTextViewClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80629);
            FTSSOSHomeWebViewUI.this.eET();
            FTSSOSHomeWebViewUI.this.eFd();
            AppMethodBeat.o(80629);
          }
        });
        this.CCu.getIconView().setImageDrawable(VN(getType()));
        localObject1 = eEX().getClearBtn();
        if (localObject1 != null) {
          ((ImageButton)localObject1).getDrawable().setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
        }
        AppMethodBeat.o(80653);
        return;
        localObject1 = localObject2;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        this.CDl.eFi();
      }
      catch (Exception localException1) {}
    }
  }
  
  public final int bvi()
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
    this.CDp = bool1;
    if ((com.tencent.mm.compatible.util.d.kZ(23)) && (!com.tencent.mm.sdk.h.b.YJ()))
    {
      if (this.CDp)
      {
        AppMethodBeat.o(80661);
        return -1;
      }
      i = getResources().getColor(2131101159);
      AppMethodBeat.o(80661);
      return i;
    }
    int i = super.bvi();
    AppMethodBeat.o(80661);
    return i;
  }
  
  public final boolean bvs()
  {
    AppMethodBeat.i(80665);
    if (!this.CCA)
    {
      AppMethodBeat.o(80665);
      return true;
    }
    this.CDl.Yv(0);
    super.bvs();
    AppMethodBeat.o(80665);
    return true;
  }
  
  protected final void eER()
  {
    AppMethodBeat.i(80666);
    super.eER();
    this.CDl.Yv(11);
    AppMethodBeat.o(80666);
  }
  
  protected final void eES()
  {
    AppMethodBeat.i(80663);
    super.eES();
    eEX().setHint(VO(this.CCR));
    AppMethodBeat.o(80663);
  }
  
  protected final void eET()
  {
    AppMethodBeat.i(80667);
    if (this.CDn > 0)
    {
      AppMethodBeat.o(80667);
      return;
    }
    super.eET();
    VP(0);
    eEX().ftb();
    eEX().setHint(getHint());
    this.CDl.Yv(2);
    this.CCt.setBackgroundResource(2131234159);
    this.xET.setVisibility(8);
    this.CDx = null;
    this.CDy = 0;
    this.CDe.setVisibility(0);
    h.wUl.f(15521, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(1), eEX().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.CCR) });
    AppMethodBeat.o(80667);
  }
  
  protected final void eEU()
  {
    AppMethodBeat.i(80668);
    super.eEU();
    zL(true);
    fdg();
    AppMethodBeat.o(80668);
  }
  
  public final String eEV()
  {
    if (this.CDy == 0) {
      return "";
    }
    return this.CDx;
  }
  
  public final int eEW()
  {
    return this.CDy;
  }
  
  public final boolean eFa()
  {
    AppMethodBeat.i(80674);
    if (this.CDl == null)
    {
      AppMethodBeat.o(80674);
      return false;
    }
    boolean bool = this.CDl.eFa();
    AppMethodBeat.o(80674);
    return bool;
  }
  
  protected final boolean eFb()
  {
    AppMethodBeat.i(80675);
    if ((eFa()) && (!this.CDg.isAnimating) && (!this.CDh.isAnimating) && (!this.CDi.isAnimating))
    {
      AppMethodBeat.o(80675);
      return true;
    }
    AppMethodBeat.o(80675);
    return false;
  }
  
  public final int eFg()
  {
    return 1;
  }
  
  protected final Map<String, Object> eFh()
  {
    AppMethodBeat.i(80660);
    HashMap localHashMap = new HashMap();
    if ((this.sDj == null) || (this.xuw == null))
    {
      AppMethodBeat.o(80660);
      return localHashMap;
    }
    int i;
    if (this.Ckh)
    {
      i = this.sDj.getBottom();
      ac.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom:%d edu.top:%d title.bottom():%d nativeH%d", new Object[] { Integer.valueOf(this.sDj.getBottom()), Integer.valueOf(this.xuw.getBottom()), Integer.valueOf(this.sDj.getTop()), Integer.valueOf(i) });
      localHashMap.put("nativeHeight", Integer.valueOf(com.tencent.mm.cc.a.ax(this, i)));
    }
    for (;;)
    {
      try
      {
        localObject = this.kYt.t(7, null);
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
        ac.printErrStackTrace("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", localException, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(80660);
      return localHashMap;
      i = this.sDj.getBottom() - this.xuw.getBottom();
      break;
      localObject = ((Bundle)localObject).getString("data");
    }
  }
  
  protected final void fdd()
  {
    AppMethodBeat.i(210083);
    zL(true);
    AppMethodBeat.o(210083);
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80669);
    String str = VO(cvi());
    AppMethodBeat.o(80669);
    return str;
  }
  
  protected final com.tencent.mm.plugin.webview.c.f getJsapi()
  {
    AppMethodBeat.i(188527);
    com.tencent.mm.plugin.webview.c.f localf = super.getJsapi();
    AppMethodBeat.o(188527);
    return localf;
  }
  
  public int getLayoutId()
  {
    return 2131495630;
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(80662);
    if (this.CDl == null)
    {
      AppMethodBeat.o(80662);
      return;
    }
    if (this.CDl.eFa()) {
      super.lF(paramBoolean);
    }
    this.CDl.Yv(5);
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
      this.CDl.Yv(8);
      AppMethodBeat.o(80670);
      return;
      this.CDl.Yv(10);
      AppMethodBeat.o(80670);
      return;
      paramBundle.getString("fts_key_new_query", "");
      this.CDl.Yv(13);
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
        paramIntent = aDw(paramIntent);
        ac.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[] { Integer.valueOf(paramIntent.length()), paramIntent });
        this.CCu.F(paramIntent, null);
        bvs();
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
    eEX().fth();
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
    this.CDp = bool1;
    new Bundle().putString("url", getIntent().getStringExtra("key_weapp_url"));
    AppMethodBeat.o(80652);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80659);
    super.onDestroy();
    com.tencent.mm.plugin.websearch.api.ai.exB();
    com.tencent.mm.plugin.websearch.api.ai.exC();
    AppMethodBeat.o(80659);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80658);
    super.onPause();
    com.tencent.mm.plugin.websearch.api.ai.exA();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).c(105, false, false);
    }
    AppMethodBeat.o(80658);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80657);
    super.onResume();
    com.tencent.mm.plugin.websearch.api.ai.exz();
    AppMethodBeat.o(80657);
  }
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80677);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.nKq == null)
    {
      AppMethodBeat.o(80677);
      return;
    }
    paramInt1 = Math.min(paramInt2, Math.max(com.tencent.mm.cc.a.fromDPToPix(this, this.nKq.getContentHeight()) - this.nKq.getHeight(), 0));
    this.CDg.VQ(this.CDr - paramInt1);
    this.CDh.VQ(this.CDr - paramInt1);
    this.CDi.VQ(this.CDr - paramInt1);
    if (!this.CDl.eFa())
    {
      this.sMc.setTranslationY(-paramInt1);
      this.CCt.setTranslationY(-paramInt1);
    }
    if (paramInt2 != 0)
    {
      eEX().ty.clearFocus();
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
    com.tencent.mm.sdk.d.c CDC;
    com.tencent.mm.sdk.d.c CDD;
    com.tencent.mm.sdk.d.c CDE;
    com.tencent.mm.sdk.d.c CDF;
    
    protected a(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(80648);
      this.CDC = new a((byte)0);
      this.CDD = new d((byte)0);
      this.CDE = new b((byte)0);
      this.CDF = new c((byte)0);
      a(this.CDC);
      a(this.CDD);
      a(this.CDE);
      a(this.CDF);
      b(this.CDC);
      AppMethodBeat.o(80648);
    }
    
    public final boolean eFa()
    {
      AppMethodBeat.i(80650);
      com.tencent.mm.sdk.d.a locala = eWv();
      if ((locala == this.CDD) || (locala == this.CDE) || (locala == this.CDF))
      {
        AppMethodBeat.o(80650);
        return true;
      }
      AppMethodBeat.o(80650);
      return false;
    }
    
    public final void eFi()
    {
      AppMethodBeat.i(80649);
      FTSSOSHomeWebViewUI.this.CCu.setSearchBarCancelTextContainerVisibile(0);
      b(this.CDC);
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
        FTSSOSHomeWebViewUI.k(FTSSOSHomeWebViewUI.this);
        AppMethodBeat.o(80636);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(80637);
        super.exit();
        FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.this.getResources().getColor(2131101053));
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
              FTSSOSHomeWebViewUI.this.eEX().fth();
              FTSSOSHomeWebViewUI.this.eEX().ty.clearFocus();
              FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this).b(a.b.CEm);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.CEm);
              FTSSOSHomeWebViewUI.this.CCt.setBackgroundResource(2131101179);
              continue;
              FTSSOSHomeWebViewUI.this.eEX().fth();
              FTSSOSHomeWebViewUI.this.eEX().ty.clearFocus();
              FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this).a(a.b.CEm, false);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.CEm);
              FTSSOSHomeWebViewUI.this.CCt.setBackgroundResource(2131101179);
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDE);
              FTSSOSHomeWebViewUI.this.CCz = true;
              continue;
              FTSSOSHomeWebViewUI.this.eEX().fth();
              FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).b(a.b.CEm);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.CEm);
              FTSSOSHomeWebViewUI.this.CCt.setBackgroundResource(2131101179);
              continue;
              FTSSOSHomeWebViewUI.this.CCz = true;
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDD);
              continue;
              FTSSOSHomeWebViewUI.this.CCz = true;
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDE);
              continue;
              if ((FTSSOSHomeWebViewUI.this.eEX().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0))
              {
                FTSSOSHomeWebViewUI.this.eEX().fth();
                FTSSOSHomeWebViewUI.this.CCt.setBackgroundResource(2131101179);
                FTSSOSHomeWebViewUI.this.CCu.setSearchBarCancelTextContainerVisibile(8);
                FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).b(a.b.CEm);
                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.CEm);
                FTSSOSHomeWebViewUI.this.aw(new FTSSOSHomeWebViewUI.a.a.1(this));
                h.wUl.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.this.eEX().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.CCR) });
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
        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.CEm);
        FTSSOSHomeWebViewUI.this.CCt.setBackgroundResource(2131101179);
        FTSSOSHomeWebViewUI.this.CCu.ty.clearFocus();
        FTSSOSHomeWebViewUI.this.hideVKB();
        FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.CCt.setPadding(FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.eEX().fth();
        FTSSOSHomeWebViewUI.this.ucS.setVisibility(0);
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.this.CCu.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.CCu.setVoiceImageButtonVisibile(0);
        FTSSOSHomeWebViewUI.this.CCu.fth();
        FTSSOSHomeWebViewUI.this.CCu.ftg();
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this).setVisibility(0);
        Object localObject;
        int i;
        if ((com.tencent.mm.compatible.util.d.kZ(23)) && (!com.tencent.mm.sdk.h.b.YJ()))
        {
          localObject = FTSSOSHomeWebViewUI.this;
          i = FTSSOSHomeWebViewUI.this.getResources().getColor(2131101179);
          if (aj.DT()) {
            break label727;
          }
        }
        label727:
        for (boolean bool = true;; bool = false)
        {
          FTSSOSHomeWebViewUI.a((FTSSOSHomeWebViewUI)localObject, i, bool);
          FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setAlpha(0.0F);
          localObject = (RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.CCt.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (FTSSOSHomeWebViewUI.this.CDp) {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          }
          ((RelativeLayout.LayoutParams)localObject).width = -1;
          FTSSOSHomeWebViewUI.this.CCt.setLayoutParams((ViewGroup.LayoutParams)localObject);
          FTSSOSHomeWebViewUI.this.CCt.setY(0.0F);
          FTSSOSHomeWebViewUI.this.CCt.setX(0.0F);
          if (FTSSOSHomeWebViewUI.this.CDp)
          {
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setTranslationY(0.0F);
            FTSSOSHomeWebViewUI.this.CCt.setTranslationX(0.0F);
            FTSSOSHomeWebViewUI.this.CCt.setTranslationY(0.0F);
          }
          if ((FTSSOSHomeWebViewUI.this.CDp) && (FTSSOSHomeWebViewUI.this.CDq))
          {
            FTSSOSHomeWebViewUI.this.CCt.setVisibility(8);
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setAlpha(1.0F);
            FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
            FTSSOSHomeWebViewUI.r(FTSSOSHomeWebViewUI.this).setVisibility(8);
            if ((FTSSOSHomeWebViewUI.this.getIntent() != null) && (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("customize_status_bar_color")))
            {
              FTSSOSHomeWebViewUI.l(FTSSOSHomeWebViewUI.this).setBackgroundColor(FTSSOSHomeWebViewUI.s(FTSSOSHomeWebViewUI.this));
              if (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("status_bar_style")) {
                FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.t(FTSSOSHomeWebViewUI.this), "black".equals(FTSSOSHomeWebViewUI.u(FTSSOSHomeWebViewUI.this)));
              }
            }
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this).setVisibility(0);
            String str = FTSSOSHomeWebViewUI.this.getIntent().getStringExtra("title");
            localObject = str;
            if (bs.isNullOrNil(str)) {
              localObject = FTSSOSHomeWebViewUI.this.getString(2131759106);
            }
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this).setText((CharSequence)localObject);
          }
          FTSSOSHomeWebViewUI.this.eFd();
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
          if (!FTSSOSHomeWebViewUI.this.CDp)
          {
            FTSSOSHomeWebViewUI.m(FTSSOSHomeWebViewUI.this).b(a.b.CEl);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.CEl);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDC);
            continue;
            if (FTSSOSHomeWebViewUI.this.eEX().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDD);
              h.wUl.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.eEX().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.CCR) });
              continue;
              FTSSOSHomeWebViewUI.this.eEX().fth();
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
        FTSSOSHomeWebViewUI.this.CCt.setPadding(FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.CCt.setX(0.0F);
        FTSSOSHomeWebViewUI.this.CCt.setY(0.0F);
        FTSSOSHomeWebViewUI.this.eEX().fth();
        FTSSOSHomeWebViewUI.this.ucS.setVisibility(0);
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this).setVisibility(0);
        FTSSOSHomeWebViewUI.this.CCu.setSearchBarCancelTextContainerVisibile(0);
        FTSSOSHomeWebViewUI.this.CCu.setVoiceImageButtonVisibile(0);
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
          if (FTSSOSHomeWebViewUI.this.eEX().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDD);
            h.wUl.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.eEX().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.CCR) });
            continue;
            if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDE);
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0)
              {
                FTSSOSHomeWebViewUI.this.eEX().fth();
                FTSSOSHomeWebViewUI.this.eEX().ty.clearFocus();
                FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDE);
                continue;
                if (!FTSSOSHomeWebViewUI.this.CDp)
                {
                  FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.this).b(a.b.CEl);
                  FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.CEl);
                }
                else
                {
                  FTSSOSHomeWebViewUI.this.finish();
                  continue;
                  FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDC);
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
        FTSSOSHomeWebViewUI.o(FTSSOSHomeWebViewUI.this);
        FTSSOSHomeWebViewUI.this.CCt.setPadding(FTSSOSHomeWebViewUI.p(FTSSOSHomeWebViewUI.this), 0, 0, 0);
        FTSSOSHomeWebViewUI.this.CCt.setX(0.0F);
        FTSSOSHomeWebViewUI.this.CCt.setY(0.0F);
        FTSSOSHomeWebViewUI.this.CCu.setSearchBarCancelTextContainerVisibile(8);
        FTSSOSHomeWebViewUI.this.CCu.setVoiceImageButtonVisibile(8);
        FTSSOSHomeWebViewUI.this.CCu.ftg();
        FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this).setVisibility(8);
        FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this).setVisibility(0);
        if (!FTSSOSHomeWebViewUI.this.eEX().ty.hasFocus())
        {
          FTSSOSHomeWebViewUI.this.eEX().fte();
          FTSSOSHomeWebViewUI.this.showVKB();
        }
        if ((com.tencent.mm.compatible.util.d.kZ(23)) && (!com.tencent.mm.sdk.h.b.YJ()))
        {
          FTSSOSHomeWebViewUI localFTSSOSHomeWebViewUI = FTSSOSHomeWebViewUI.this;
          int i = FTSSOSHomeWebViewUI.this.getResources().getColor(2131101179);
          if (!aj.DT()) {
            bool = true;
          }
          FTSSOSHomeWebViewUI.c(localFTSSOSHomeWebViewUI, i, bool);
        }
        if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
          FTSSOSHomeWebViewUI.this.eEX().fti();
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
          if (!FTSSOSHomeWebViewUI.this.CDp)
          {
            FTSSOSHomeWebViewUI.n(FTSSOSHomeWebViewUI.this).b(a.b.CEl);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, a.b.CEl);
          }
          else
          {
            FTSSOSHomeWebViewUI.this.finish();
            continue;
            FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDC);
            continue;
            if (!FTSSOSHomeWebViewUI.this.eEX().getEditText().hasFocus())
            {
              FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDE);
            }
            else
            {
              h.wUl.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.eEX().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.CCR) });
              continue;
              if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                FTSSOSHomeWebViewUI.a.this.b(FTSSOSHomeWebViewUI.a.this.CDE);
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