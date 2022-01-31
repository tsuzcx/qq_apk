package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI
  extends BaseSOSWebViewUI
{
  private FTSMainUIEducationLayout kBI;
  private View.OnClickListener kCk = new FTSSOSHomeWebViewUI.18(this);
  private View nWb;
  private View ogQ;
  private View rtW;
  private FTSSOSHomeWebViewUI.a rtX;
  private b rtY;
  private c rtZ;
  private AdapterView.OnItemClickListener ruA = new FTSSOSHomeWebViewUI.7(this);
  private View.OnClickListener ruB = new FTSSOSHomeWebViewUI.8(this);
  private boolean ruC;
  private d rua;
  private float rub = 3.4028235E+38F;
  private FTSMainUIHotWordLayout ruc;
  private FTSMainUIEducationLayoutWithAll rud;
  private View rue;
  private TextView ruf;
  private View rug;
  private View ruh;
  private View rui;
  FTSSOSHomeWebViewUI.b ruj;
  private int ruk;
  private boolean rul;
  private int rum = 0;
  private String run = "";
  boolean ruo;
  boolean rup;
  private int ruq = 0;
  private int rur = 0;
  private String rus = "";
  private View.OnClickListener rut = new FTSSOSHomeWebViewUI.2(this);
  private a.a ruu = new FTSSOSHomeWebViewUI.3(this);
  private a.a ruv = new FTSSOSHomeWebViewUI.4(this);
  private a.a ruw = new FTSSOSHomeWebViewUI.5(this);
  private String rux;
  int ruy;
  private View.OnClickListener ruz = new FTSSOSHomeWebViewUI.6(this);
  private TextView titleView;
  
  private void CP(int paramInt)
  {
    this.rud.setSelected(paramInt);
    TextView localTextView = this.ruf;
    Object localObject = (TextView)this.rud.kEK.get(Integer.valueOf(paramInt));
    if (localObject == null) {}
    for (localObject = "";; localObject = ((TextView)localObject).getText().toString())
    {
      localTextView.setText((CharSequence)localObject);
      cfr().setIconRes(com.tencent.mm.bc.a.b(paramInt, this.mController.uMN));
      return;
    }
  }
  
  private String CQ(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if (this.scene == 36) {
        paramInt = R.l.search_recommend_hint;
      }
      if (paramInt >= 0) {
        break;
      }
      return getString(R.l.search_detail_page_hint, new Object[] { this.rus });
      paramInt = R.l.search_education_biz_contact;
      continue;
      paramInt = R.l.fts_header_timeline;
      continue;
      paramInt = R.l.search_education_article;
      continue;
      paramInt = R.l.fts_header_poi;
      continue;
      paramInt = R.l.app_brand_entrance;
      continue;
      paramInt = R.l.fts_header_emoji;
      continue;
      paramInt = R.l.fts_header_emoji_product;
      continue;
      paramInt = R.l.fts_header_music;
      continue;
      paramInt = R.l.fts_header_novel;
    }
    return getString(R.l.search_detail_page_hint, new Object[] { getString(paramInt) });
  }
  
  private static String TF(String paramString)
  {
    localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      try
      {
        if (f.aek(paramString) <= 100) {
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
        int i = 0;
        int k = 0;
        for (;;)
        {
          localObject = str;
          if (j >= m) {
            break;
          }
          localObject = str;
          k += f.aek(String.valueOf(paramString[j]));
          if (k >= 100)
          {
            localObject = str;
            paramString = str.substring(0, i) + '…';
            return paramString;
          }
          j += 1;
          i += 1;
        }
        return localObject;
      }
      catch (Exception paramString) {}
    }
  }
  
  private void cfA()
  {
    if (this.niQ == null) {
      return;
    }
    AbsoluteLayout localAbsoluteLayout = (AbsoluteLayout)this.niQ.getView();
    localAbsoluteLayout.setOnTouchListener(new FTSSOSHomeWebViewUI.17(this, localAbsoluteLayout));
  }
  
  private void cfD()
  {
    try
    {
      this.rtX.clear();
      y.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "start to update history");
      Bundle localBundle = new Bundle();
      localBundle.putInt("webview_id", hashCode());
      localBundle.putString("query", getInEditTextQuery());
      localBundle.putInt("count", 6);
      localBundle.putInt("scene", aZY());
      this.gGn.i(3, localBundle);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  private void cfE()
  {
    if ((this.rud.getVisibility() == 0) && (!this.ruC))
    {
      this.ruC = true;
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.rud, View.TRANSLATION_Y, new float[] { 0.0F, -this.rud.getHeight() });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.rug, View.ALPHA, new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.setInterpolator(new AccelerateInterpolator());
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      localAnimatorSet.addListener(new FTSSOSHomeWebViewUI.10(this));
      localAnimatorSet.start();
    }
  }
  
  public final void a(String paramString1, String paramString2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> paramList, FTSEditTextView.b paramb)
  {
    if (paramb == FTSEditTextView.b.kEB) {
      this.ruy = 0;
    }
    if (this.ruj.cfG()) {
      super.a(paramString1, paramString2, paramList, paramb);
    }
    do
    {
      return;
      if (getTotalQuery().length() == 0)
      {
        this.kBI.setVisibility(0);
        this.ruc.setVisibility(0);
        this.rtW.setVisibility(0);
        this.rtX.clear();
        return;
      }
      this.kBI.setVisibility(8);
      this.ruc.setVisibility(8);
      this.rtW.setVisibility(4);
    } while (paramb == FTSEditTextView.b.kED);
    cfD();
  }
  
  protected final void aoX()
  {
    super.aoX();
    this.ruj = new FTSSOSHomeWebViewUI.b(this, "sos_home_webview_ui", getMainLooper());
    this.nWb = findViewById(R.h.title_container);
    this.rui = findViewById(R.h.title_container_bg);
    this.rug = findViewById(R.h.menu_bg);
    this.rue = findViewById(R.h.dropdown_menu_container);
    this.ruf = ((TextView)findViewById(R.h.dropdown_menu_btn));
    this.rue.setOnClickListener(this.ruB);
    this.titleView = ((TextView)findViewById(R.h.title_tv));
    this.rtW = findViewById(R.h.webview_keyboard_ll);
    ((WebViewKeyboardLinearLayout)this.rtW).setOnkbdStateListener(new FTSSOSHomeWebViewUI.1(this));
    this.kBI = ((FTSMainUIEducationLayout)findViewById(R.h.search_education_layout));
    this.kBI.setOnCellClickListener(this.kCk);
    this.kBI.setCellClickable(false);
    this.kBI.getViewTreeObserver().addOnGlobalLayoutListener(new FTSSOSHomeWebViewUI.11(this));
    this.rud = ((FTSMainUIEducationLayoutWithAll)findViewById(R.h.search_education_layout_with_all));
    this.rud.setOnCellClickListener(this.kCk);
    this.rud.setCellClickable(true);
    this.ruc = ((FTSMainUIHotWordLayout)findViewById(R.h.search_hotword_layout));
    this.ruc.setOnCellClickListener(this.rut);
    this.rtY = new b(this, this.rts, this.titleView, cfr().getIconView(), this.mBP, this.mBP, cfr().getEditText(), this.ruh, this.nWb, this.rui);
    this.rtY.a(this.ruu);
    this.rtZ = new c(this, this.rts, this.titleView, cfr().getIconView(), this.mBP, this.mBP, cfr().getEditText(), this.ruh, this.nWb, this.rui);
    this.rtZ.a(this.ruw);
    this.rua = new d(this, this.rts, this.titleView, cfr().getIconView(), this.mBP, this.mBP, cfr().getEditText(), this.ruh, this.nWb, this.rui);
    this.rua.a(this.ruv);
    this.rtX = new FTSSOSHomeWebViewUI.a(this, (byte)0);
    this.ogQ = findViewById(R.h.sos_shadow_view);
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "educationTab");
        localObject2 = this.gGn.o(2, (Bundle)localObject1);
        localObject1 = ((Bundle)localObject2).getString("result");
        localObject2 = ((Bundle)localObject2).getString("result_1");
        if (localObject2 == null)
        {
          localObject1 = new JSONObject((String)localObject1);
          this.kBI.P((JSONObject)localObject1);
        }
      }
      catch (Exception localException3)
      {
        Object localObject1;
        Object localObject2;
        boolean bool;
        continue;
      }
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "tabSlice");
        localObject1 = new JSONObject(this.gGn.o(2, (Bundle)localObject1).getString("result"));
        this.rud.P((JSONObject)localObject1);
        findViewById(R.h.content_layout).setOnTouchListener(new FTSSOSHomeWebViewUI.12(this));
        this.rug.setOnClickListener(new FTSSOSHomeWebViewUI.13(this));
        localObject1 = getIntent().getStringExtra("title");
        this.titleView.setText((CharSequence)localObject1);
        this.ruk = (((RelativeLayout.LayoutParams)this.titleView.getLayoutParams()).leftMargin - (int)getResources().getDimension(R.f.sos_search_edittext_margin));
        cfr().cIy();
        if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsInitToSearch", false)))
        {
          bool = true;
          this.ruo = bool;
          if ((getIntent() == null) || (!getIntent().getBooleanExtra("hideSearchInput", false))) {
            continue;
          }
          bool = true;
          this.rup = bool;
          if (!this.ruo) {
            continue;
          }
          this.rui.setBackgroundColor(getResources().getColor(R.e.transparent));
          localObject1 = this.ruj;
          ((FTSSOSHomeWebViewUI.b)localObject1).b(((FTSSOSHomeWebViewUI.b)localObject1).ruO);
          if ((com.tencent.mm.compatible.util.d.gF(23)) && (!com.tencent.mm.compatible.util.h.zL())) {
            af(getResources().getColor(R.e.white), true);
          }
          this.ruj.start();
        }
        try
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("key", "searchID");
          this.run = this.gGn.o(6, (Bundle)localObject1).getString("result");
          ao.ag(this.run, getSessionId(), this.kBI.getVertBizTypes());
          ao.BE(aZY());
          cfA();
          this.rts.getViewTreeObserver().addOnPreDrawListener(new FTSSOSHomeWebViewUI.14(this));
          if (!this.rvc)
          {
            this.rtW.setVisibility(4);
            this.rtt.setVoiceBtnClickListener(new FTSSOSHomeWebViewUI.15(this));
            this.rtt.setCancelTextViewClickListener(new FTSSOSHomeWebViewUI.16(this));
            CP(this.rtQ);
            localObject1 = cfr().getClearBtn();
            if (localObject1 != null) {
              ((ImageButton)localObject1).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
            }
            return;
            localObject1 = localObject2;
            continue;
            bool = false;
            continue;
            bool = false;
            continue;
            this.ruj.cfF();
            continue;
          }
          this.rtW.setVisibility(0);
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2) {}
    }
  }
  
  protected final int aoY()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getIntent() != null)
    {
      bool1 = bool2;
      if (getIntent().getBooleanExtra("ftsInitToSearch", false)) {
        bool1 = true;
      }
    }
    this.ruo = bool1;
    if ((com.tencent.mm.compatible.util.d.gF(23)) && (!com.tencent.mm.sdk.g.b.zL()))
    {
      if (this.ruo) {
        return -1;
      }
      return getResources().getColor(R.e.websearch_bg);
    }
    return super.aoY();
  }
  
  public final boolean apb()
  {
    if (!this.rtz) {
      return true;
    }
    this.ruj.Ff(0);
    super.apb();
    return true;
  }
  
  protected final boolean cdz()
  {
    return true;
  }
  
  public final int cfB()
  {
    return 1;
  }
  
  protected final Map<String, Object> cfC()
  {
    HashMap localHashMap = new HashMap();
    if ((this.kBI == null) || (this.nWb == null)) {
      return localHashMap;
    }
    y.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom %d, title.bottom %d", new Object[] { Integer.valueOf(this.kBI.getBottom()), Integer.valueOf(this.nWb.getBottom()) });
    int i;
    if (this.kBI.getTop() < this.nWb.getBottom())
    {
      i = this.kBI.getBottom() - this.nWb.getBottom();
      localHashMap.put("nativeHeight", Integer.valueOf(com.tencent.mm.cb.a.ad(this, i)));
    }
    for (;;)
    {
      try
      {
        localObject = this.gGn.o(7, null);
        if (localObject != null) {
          continue;
        }
        localObject = "";
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put("operationData", localObject);
        }
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject;
        y.printErrStackTrace("MicroMsg.FTS.FTSSOSHomeWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      return localHashMap;
      i = this.kBI.getBottom();
      break;
      localObject = ((Bundle)localObject).getString("data");
    }
  }
  
  protected final void cfl()
  {
    super.cfl();
    this.ruj.Ff(11);
  }
  
  protected final void cfm()
  {
    super.cfm();
    CP(this.rtQ);
    cfr().setHint(CQ(this.rtQ));
  }
  
  protected final void cfn()
  {
    if (this.rum > 0) {
      return;
    }
    super.cfn();
    cfr().setHint(getHint());
    this.ruj.Ff(2);
    this.rts.setBackgroundResource(R.g.sos_round_corner);
    this.ogQ.setVisibility(8);
    this.rux = null;
    this.ruy = 0;
    com.tencent.mm.plugin.report.service.h.nFQ.f(15521, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(1), cfr().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.rtQ) });
  }
  
  protected final void cfo()
  {
    super.cfo();
    if (!this.rvc)
    {
      this.rtW.setVisibility(0);
      if ((this.niQ.getTopView() != null) && ((this.niQ.getTopView() instanceof AbsoluteLayout)))
      {
        ((ViewGroup)this.kBI.getParent()).removeView(this.kBI);
        AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, this.rur - this.nWb.getHeight());
        ((AbsoluteLayout)this.niQ.getTopView()).addView(this.kBI, localLayoutParams);
      }
    }
  }
  
  public final String cfp()
  {
    if (this.ruy == 0) {
      return "";
    }
    return this.rux;
  }
  
  public final int cfq()
  {
    return this.ruy;
  }
  
  protected final boolean cfx()
  {
    return (this.ruj.cfG()) && (!this.rtY.isAnimating) && (!this.rtZ.isAnimating) && (!this.rua.isAnimating);
  }
  
  protected final String getHint()
  {
    return CQ(cfv());
  }
  
  protected final int getLayoutId()
  {
    return R.i.sos_home_webview_ui;
  }
  
  public final void gn(boolean paramBoolean)
  {
    if (this.ruj.cfG()) {
      super.gn(paramBoolean);
    }
    this.ruj.Ff(5);
  }
  
  protected final void i(int paramInt, Bundle paramBundle)
  {
    super.i(paramInt, paramBundle);
    ArrayList localArrayList;
    String str;
    Object localObject;
    switch (paramInt)
    {
    case 130: 
    default: 
      return;
    case 126: 
      localArrayList = new ArrayList();
      if (cfr().kEp.hasFocus())
      {
        str = paramBundle.getString("query");
        if (getInEditTextQuery().equals(str))
        {
          paramBundle = paramBundle.getStringArrayList("result").iterator();
          paramInt = 0;
          while (paramBundle.hasNext())
          {
            localObject = (String)paramBundle.next();
            if (com.tencent.mm.bc.a.ay((String)localObject, str))
            {
              paramInt += 1;
              if (paramInt > 2) {
                break;
              }
              FTSSOSHomeWebViewUI.c localc = new FTSSOSHomeWebViewUI.c(this, (byte)0);
              localc.type = 1;
              localc.icon = R.k.sos_history;
              localc.content = ((String)localObject);
              localc.ruS = R.g.sos_edittext_clear;
              localArrayList.add(localc);
            }
          }
        }
      }
      ai.d(new FTSSOSHomeWebViewUI.a.1(this.rtX, localArrayList));
      return;
    case 127: 
      localArrayList = new ArrayList();
      if (cfr().kEp.hasFocus())
      {
        str = paramBundle.getString("query");
        if (getInEditTextQuery().equals(str))
        {
          this.rux = paramBundle.getString("suggestionId");
          paramBundle = paramBundle.getStringArrayList("result").iterator();
          while (paramBundle.hasNext())
          {
            str = (String)paramBundle.next();
            localObject = new FTSSOSHomeWebViewUI.c(this, (byte)0);
            ((FTSSOSHomeWebViewUI.c)localObject).type = 2;
            ((FTSSOSHomeWebViewUI.c)localObject).icon = 0;
            ((FTSSOSHomeWebViewUI.c)localObject).content = str;
            ((FTSSOSHomeWebViewUI.c)localObject).ruS = R.g.sos_up;
            localArrayList.add(localObject);
          }
        }
      }
      ai.d(new FTSSOSHomeWebViewUI.a.3(this.rtX, localArrayList));
      return;
    case 119: 
      this.ruj.Ff(8);
      return;
    case 122: 
      this.ruj.Ff(10);
      return;
    }
    paramBundle.getString("fts_key_new_query", "");
    this.ruj.Ff(13);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("text");
    } while (TextUtils.isEmpty(paramIntent));
    paramIntent = TF(paramIntent);
    y.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[] { Integer.valueOf(paramIntent.length()), paramIntent });
    this.rtt.n(paramIntent, null);
    apb();
  }
  
  public void onBackPressed()
  {
    if (this.rud.getVisibility() == 0) {
      cfE();
    }
    for (;;)
    {
      cfr().aWC();
      return;
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    super.onCreate(paramBundle);
    boolean bool1 = bool2;
    if (getIntent() != null)
    {
      bool1 = bool2;
      if (getIntent().getBooleanExtra("ftsInitToSearch", false)) {
        bool1 = true;
      }
    }
    this.ruo = bool1;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ao.bZO();
    ao.bZP();
  }
  
  protected void onPause()
  {
    super.onPause();
    ao.bZN();
  }
  
  protected void onResume()
  {
    super.onResume();
    ao.bZM();
  }
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = Math.min(paramInt2, Math.max(com.tencent.mm.cb.a.fromDPToPix(this, this.niQ.getContentHeight()) - this.niQ.getHeight(), 0));
    this.rtY.CS(this.ruq - paramInt1);
    this.rtZ.CS(this.ruq - paramInt1);
    this.rua.CS(this.ruq - paramInt1);
    if (!this.ruj.cfG()) {
      this.rts.setTranslationY(-paramInt1);
    }
    if (paramInt2 != 0)
    {
      cfr().kEp.clearFocus();
      XM();
    }
  }
  
  private final class b$b
    extends com.tencent.mm.sdk.d.b
  {
    private b$b() {}
    
    public final void enter()
    {
      super.enter();
      FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this.ruD, a.b.rvE);
      FTSSOSHomeWebViewUI.this.ruD.rts.setBackgroundResource(R.e.white);
      FTSSOSHomeWebViewUI.this.ruD.rtt.kEp.clearFocus();
      FTSSOSHomeWebViewUI.this.ruD.XM();
      FTSSOSHomeWebViewUI.L(FTSSOSHomeWebViewUI.this.ruD).setVisibility(0);
      FTSSOSHomeWebViewUI.this.ruD.rts.setPadding(FTSSOSHomeWebViewUI.M(FTSSOSHomeWebViewUI.this.ruD), 0, 0, 0);
      FTSSOSHomeWebViewUI.this.ruD.cfr().aWC();
      FTSSOSHomeWebViewUI.this.ruD.mBP.setVisibility(0);
      FTSSOSHomeWebViewUI.this.ruD.cfr().aWA();
      FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.this.ruD).clear();
      FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this.ruD).setVisibility(0);
      FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this.ruD).setVisibility(8);
      FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this.ruD).setVisibility(8);
      FTSSOSHomeWebViewUI.this.ruD.rtt.setSearchBarCancelTextContainerVisibile(0);
      FTSSOSHomeWebViewUI.this.ruD.rtt.setVoiceImageButtonVisibile(0);
      FTSSOSHomeWebViewUI.this.ruD.rtt.aWC();
      FTSSOSHomeWebViewUI.N(FTSSOSHomeWebViewUI.this.ruD);
      if (!FTSSOSHomeWebViewUI.this.ruD.ruo) {
        FTSSOSHomeWebViewUI.this.ruD.cfr().aWA();
      }
      FTSSOSHomeWebViewUI.O(FTSSOSHomeWebViewUI.this.ruD).setVisibility(0);
      if ((com.tencent.mm.compatible.util.d.gF(23)) && (!com.tencent.mm.sdk.g.b.zL())) {
        FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this.ruD, FTSSOSHomeWebViewUI.this.ruD.getResources().getColor(R.e.white));
      }
      FTSSOSHomeWebViewUI.P(FTSSOSHomeWebViewUI.this.ruD).setAlpha(0.0F);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.ruD.rts.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      if (FTSSOSHomeWebViewUI.this.ruD.ruo) {
        localLayoutParams.topMargin = 0;
      }
      localLayoutParams.width = -1;
      FTSSOSHomeWebViewUI.this.ruD.rts.setLayoutParams(localLayoutParams);
      FTSSOSHomeWebViewUI.this.ruD.rts.setY(0.0F);
      FTSSOSHomeWebViewUI.this.ruD.rts.setX(0.0F);
      if (FTSSOSHomeWebViewUI.this.ruD.ruo)
      {
        FTSSOSHomeWebViewUI.this.ruD.rts.setTranslationX(0.0F);
        FTSSOSHomeWebViewUI.this.ruD.rts.setTranslationY(0.0F);
      }
      if ((FTSSOSHomeWebViewUI.this.ruD.ruo) && (FTSSOSHomeWebViewUI.this.ruD.rup))
      {
        FTSSOSHomeWebViewUI.this.ruD.rts.setVisibility(8);
        FTSSOSHomeWebViewUI.P(FTSSOSHomeWebViewUI.this.ruD).setAlpha(1.0F);
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this.ruD).setVisibility(0);
        FTSSOSHomeWebViewUI.P(FTSSOSHomeWebViewUI.this.ruD).setVisibility(0);
        if ((FTSSOSHomeWebViewUI.this.ruD.getIntent() != null) && (FTSSOSHomeWebViewUI.this.ruD.getIntent().hasExtra("customize_status_bar_color")))
        {
          FTSSOSHomeWebViewUI.G(FTSSOSHomeWebViewUI.this.ruD).setBackgroundColor(FTSSOSHomeWebViewUI.Q(FTSSOSHomeWebViewUI.this.ruD));
          if (FTSSOSHomeWebViewUI.this.ruD.getIntent().hasExtra("status_bar_style")) {
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this.ruD, FTSSOSHomeWebViewUI.R(FTSSOSHomeWebViewUI.this.ruD), "black".equals(FTSSOSHomeWebViewUI.S(FTSSOSHomeWebViewUI.this.ruD)));
          }
        }
      }
    }
    
    public final void exit()
    {
      super.exit();
    }
    
    public final boolean g(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return super.g(paramMessage);
        if (!FTSSOSHomeWebViewUI.this.ruD.ruo)
        {
          FTSSOSHomeWebViewUI.T(FTSSOSHomeWebViewUI.this.ruD);
          FTSSOSHomeWebViewUI.U(FTSSOSHomeWebViewUI.this.ruD).setVisibility(8);
          FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this.ruD, 0);
          FTSSOSHomeWebViewUI.H(FTSSOSHomeWebViewUI.this.ruD).b(a.b.rvD);
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this.ruD, a.b.rvD);
        }
        else
        {
          FTSSOSHomeWebViewUI.this.ruD.finish();
          continue;
          FTSSOSHomeWebViewUI.this.b(FTSSOSHomeWebViewUI.this.ruM);
          continue;
          if (FTSSOSHomeWebViewUI.this.ruD.cfr().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.this.b(FTSSOSHomeWebViewUI.this.ruN);
            com.tencent.mm.plugin.report.service.h.nFQ.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.ruD.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.ruD.cfr().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.ruD.rtQ) });
            continue;
            FTSSOSHomeWebViewUI.this.ruD.cfr().aWC();
          }
        }
      }
    }
    
    public final String getName()
    {
      return "SearchNoFocusState";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI
 * JD-Core Version:    0.7.0.1
 */