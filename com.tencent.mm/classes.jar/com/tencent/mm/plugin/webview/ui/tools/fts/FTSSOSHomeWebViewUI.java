package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI
  extends BaseSOSWebViewUI
{
  private FTSMainUIEducationLayout mXD;
  private View.OnClickListener mYg;
  private View qKl;
  private View qVf;
  private TextView titleView;
  private String vkA;
  boolean vkB;
  boolean vkC;
  private int vkD;
  private int vkE;
  private String vkF;
  private WeappWebSearchFragment vkG;
  private boolean vkH;
  private View.OnClickListener vkI;
  private a.a vkJ;
  private a.a vkK;
  private a.a vkL;
  private String vkM;
  int vkN;
  private View.OnClickListener vkO;
  private AdapterView.OnItemClickListener vkP;
  private View.OnClickListener vkQ;
  private boolean vkR;
  private View vkh;
  private View vki;
  private View vkj;
  private FTSSOSHomeWebViewUI.a vkk;
  private b vkl;
  private c vkm;
  private d vkn;
  private float vko;
  private FTSMainUIHotWordLayout vkp;
  private FTSMainUIEducationLayoutWithAll vkq;
  private View vkr;
  private TextView vks;
  private View vkt;
  private View vku;
  private View vkv;
  private FTSSOSHomeWebViewUI.b vkw;
  private int vkx;
  private boolean vky;
  private int vkz;
  
  public FTSSOSHomeWebViewUI()
  {
    AppMethodBeat.i(8475);
    this.vko = 3.4028235E+38F;
    this.vkz = 0;
    this.vkA = "";
    this.vkD = 0;
    this.vkE = 0;
    this.vkF = "";
    this.mYg = new FTSSOSHomeWebViewUI.18(this);
    this.vkI = new FTSSOSHomeWebViewUI.2(this);
    this.vkJ = new FTSSOSHomeWebViewUI.3(this);
    this.vkK = new FTSSOSHomeWebViewUI.4(this);
    this.vkL = new FTSSOSHomeWebViewUI.5(this);
    this.vkO = new FTSSOSHomeWebViewUI.6(this);
    this.vkP = new FTSSOSHomeWebViewUI.7(this);
    this.vkQ = new FTSSOSHomeWebViewUI.8(this);
    AppMethodBeat.o(8475);
  }
  
  private void KI(int paramInt)
  {
    AppMethodBeat.i(8492);
    this.vkq.setSelected(paramInt);
    this.vks.setText(this.vkq.wC(paramInt));
    dfA().setIconRes(com.tencent.mm.bd.a.b(paramInt, getContext()));
    AppMethodBeat.o(8492);
  }
  
  private String KJ(int paramInt)
  {
    AppMethodBeat.i(8498);
    KK(paramInt);
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if ((dfJ()) || (this.scene == 53)) {
        paramInt = 2131303020;
      }
      if (paramInt >= 0) {
        break;
      }
      str = getString(2131302998, new Object[] { this.vkF });
      AppMethodBeat.o(8498);
      return str;
      paramInt = 2131303000;
      continue;
      paramInt = 2131300223;
      continue;
      paramInt = 2131302999;
      continue;
      paramInt = 2131300221;
      continue;
      paramInt = 2131296630;
      continue;
      paramInt = 2131300210;
      continue;
      paramInt = 2131300211;
      continue;
      paramInt = 2131300219;
      continue;
      paramInt = 2131300220;
    }
    String str = getString(2131302998, new Object[] { getString(paramInt) });
    AppMethodBeat.o(8498);
    return str;
  }
  
  private void KK(int paramInt)
  {
    AppMethodBeat.i(8499);
    if ((this.vkw != null) && (this.vkw.dfE()))
    {
      dfA().setEditTextDrawableLeft(KL(paramInt));
      AppMethodBeat.o(8499);
      return;
    }
    dfA().setEditTextDrawableLeft(-1);
    AppMethodBeat.o(8499);
  }
  
  private static int KL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2131232219;
    case 16777728: 
      return 2131232211;
    case 16777248: 
      return 2131232218;
    case 12582912: 
      return 2131232214;
    case 1: 
      return 2131232209;
    case 8: 
      return 2131232213;
    case 2: 
      return 2131232210;
    case 64: 
    case 2359360: 
      return 2131232220;
    case 256: 
    case 384: 
      return 2131232212;
    case 16793600: 
      return 2131232217;
    case 512: 
      return 2131232215;
    case 1024: 
      return 2131232216;
    }
    return 2131232221;
  }
  
  private static String aiI(String paramString)
  {
    AppMethodBeat.i(8481);
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      try
      {
        int i = f.auQ(paramString);
        if (i <= 100)
        {
          AppMethodBeat.o(8481);
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
          k += f.auQ(String.valueOf(paramString[j]));
          if (k >= 100)
          {
            localObject = str;
            paramString = str.substring(0, i) + '…';
            AppMethodBeat.o(8481);
            return paramString;
          }
          j += 1;
          i += 1;
        }
        AppMethodBeat.o(8481);
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(8481);
        return localObject;
      }
    }
    return localObject;
  }
  
  private boolean dfJ()
  {
    return this.scene == 36;
  }
  
  private void dfK()
  {
    AppMethodBeat.i(8479);
    if (this.pOd == null)
    {
      AppMethodBeat.o(8479);
      return;
    }
    final AbsoluteLayout localAbsoluteLayout = (AbsoluteLayout)this.pOd.getView();
    localAbsoluteLayout.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(153300);
        if (FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this) != null)
        {
          paramAnonymousView = FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this);
          d.c localc = paramAnonymousView.yrd;
          if (localc != null) {
            localc.sendMessage(paramAnonymousView.obtainMessage(15, paramAnonymousMotionEvent));
          }
        }
        boolean bool = localAbsoluteLayout.onTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(153300);
        return bool;
      }
    });
    AppMethodBeat.o(8479);
  }
  
  private void dfN()
  {
    AppMethodBeat.i(8489);
    try
    {
      this.vkk.clear();
      ab.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "start to update history");
      Bundle localBundle = new Bundle();
      localBundle.putInt("webview_id", hashCode());
      localBundle.putString("query", getInEditTextQuery());
      localBundle.putInt("count", 6);
      localBundle.putInt("scene", getScene());
      this.igU.r(3, localBundle);
      AppMethodBeat.o(8489);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(8489);
    }
  }
  
  private void dfO()
  {
    AppMethodBeat.i(8500);
    if ((this.vkq.getVisibility() == 0) && (!this.vkR))
    {
      this.vkR = true;
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.vkq, View.TRANSLATION_Y, new float[] { 0.0F, -this.vkq.getHeight() });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.vkt, View.ALPHA, new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.setInterpolator(new AccelerateInterpolator());
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(153294);
          FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this).setVisibility(8);
          FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.this).setVisibility(8);
          FTSSOSHomeWebViewUI.A(FTSSOSHomeWebViewUI.this);
          AppMethodBeat.o(153294);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(153293);
          FTSSOSHomeWebViewUI.y(FTSSOSHomeWebViewUI.this).setVisibility(8);
          FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.this).setVisibility(8);
          FTSSOSHomeWebViewUI.A(FTSSOSHomeWebViewUI.this);
          AppMethodBeat.o(153293);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      localAnimatorSet.start();
    }
    AppMethodBeat.o(8500);
  }
  
  public final void KD(int paramInt)
  {
    AppMethodBeat.i(8506);
    if ((this.pOd == null) || (this.pOd.getSettings() == null))
    {
      AppMethodBeat.o(8506);
      return;
    }
    float f = getContext().getSharedPreferences(ah.dsP(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cb.a.gg(getContext()));
    if (f >= com.tencent.mm.cb.a.gm(getContext()))
    {
      this.pOd.getSettings().setTextZoom(160);
      AppMethodBeat.o(8506);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gl(getContext()))
    {
      this.pOd.getSettings().setTextZoom(150);
      AppMethodBeat.o(8506);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gk(getContext()))
    {
      this.pOd.getSettings().setTextZoom(140);
      AppMethodBeat.o(8506);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gj(getContext()))
    {
      this.pOd.getSettings().setTextZoom(130);
      AppMethodBeat.o(8506);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gi(getContext()))
    {
      this.pOd.getSettings().setTextZoom(120);
      AppMethodBeat.o(8506);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gh(getContext()))
    {
      this.pOd.getSettings().setTextZoom(110);
      AppMethodBeat.o(8506);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gg(getContext()))
    {
      this.pOd.getSettings().setTextZoom(100);
      AppMethodBeat.o(8506);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gf(getContext()))
    {
      this.pOd.getSettings().setTextZoom(90);
      AppMethodBeat.o(8506);
      return;
    }
    this.pOd.getSettings().setTextZoom(80);
    AppMethodBeat.o(8506);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(8490);
    if (paramb == FTSEditTextView.b.naZ) {
      this.vkN = 0;
    }
    if (this.vkw.dfE())
    {
      super.a(paramString1, paramString2, paramList, paramb);
      AppMethodBeat.o(8490);
      return;
    }
    if (getTotalQuery().length() == 0)
    {
      this.mXD.setVisibility(0);
      this.vkp.setVisibility(0);
      this.vkh.setVisibility(0);
      this.vkk.clear();
      AppMethodBeat.o(8490);
      return;
    }
    this.mXD.setVisibility(8);
    this.vkp.setVisibility(8);
    this.vkh.setVisibility(4);
    if (paramb != FTSEditTextView.b.nbb) {
      dfN();
    }
    AppMethodBeat.o(8490);
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(8478);
    super.aMf();
    this.vkw = new FTSSOSHomeWebViewUI.b(this, "sos_home_webview_ui", getMainLooper());
    this.qKl = findViewById(2131828204);
    this.vkv = findViewById(2131828205);
    this.vkt = findViewById(2131828193);
    this.vkr = findViewById(2131828198);
    this.vks = ((TextView)findViewById(2131828199));
    this.vkr.setOnClickListener(this.vkQ);
    this.vki = findViewById(2131828192);
    this.vkj = findViewById(2131821084);
    this.titleView = ((TextView)findViewById(2131821212));
    this.vkh = findViewById(2131823716);
    ((WebViewKeyboardLinearLayout)this.vkh).setOnkbdStateListener(new FTSSOSHomeWebViewUI.1(this));
    this.mXD = ((FTSMainUIEducationLayout)findViewById(2131824367));
    this.mXD.setOnCellClickListener(this.mYg);
    this.mXD.setCellClickable(false);
    this.mXD.getViewTreeObserver().addOnGlobalLayoutListener(new FTSSOSHomeWebViewUI.11(this));
    this.vkq = ((FTSMainUIEducationLayoutWithAll)findViewById(2131828194));
    this.vkq.setOnCellClickListener(this.mYg);
    this.vkq.setCellClickable(true);
    this.vkp = ((FTSMainUIHotWordLayout)findViewById(2131828201));
    this.vkp.setOnCellClickListener(this.vkI);
    this.vkl = new b(this, this.vjy, this.titleView, dfA().getIconView(), this.pbT, this.pbT, dfA().getEditText(), this.vku, this.qKl, this.vkv);
    this.vkl.a(this.vkJ);
    this.vkm = new c(this, this.vjy, this.titleView, dfA().getIconView(), this.pbT, this.pbT, dfA().getEditText(), this.vku, this.qKl, this.vkv);
    this.vkm.a(this.vkL);
    this.vkn = new d(this, this.vjy, this.titleView, dfA().getIconView(), this.pbT, this.pbT, dfA().getEditText(), this.vku, this.qKl, this.vkv);
    this.vkn.a(this.vkK);
    this.vkk = new FTSSOSHomeWebViewUI.a(this, (byte)0);
    this.qVf = findViewById(2131828203);
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("key", "educationTab");
        localObject2 = this.igU.s(2, (Bundle)localObject1);
        localObject1 = ((Bundle)localObject2).getString("result");
        localObject2 = ((Bundle)localObject2).getString("result_1");
        if (localObject2 == null)
        {
          localObject1 = new JSONObject((String)localObject1);
          this.mXD.aa((JSONObject)localObject1);
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
        localObject1 = new JSONObject(this.igU.s(2, (Bundle)localObject1).getString("result"));
        this.vkq.aa((JSONObject)localObject1);
        findViewById(2131821724).setOnTouchListener(new FTSSOSHomeWebViewUI.12(this));
        this.vkt.setOnClickListener(new FTSSOSHomeWebViewUI.13(this));
        localObject1 = getIntent().getStringExtra("title");
        this.titleView.setText((CharSequence)localObject1);
        this.vkx = (((RelativeLayout.LayoutParams)this.titleView.getLayoutParams()).leftMargin - (int)getResources().getDimension(2131428726));
        dfA().dNi();
        if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsInitToSearch", false)))
        {
          bool = true;
          this.vkB = bool;
          if ((getIntent() == null) || (!getIntent().getBooleanExtra("hideSearchInput", false))) {
            continue;
          }
          bool = true;
          this.vkC = bool;
          if (this.vkw != null)
          {
            if (!this.vkB) {
              continue;
            }
            this.vkv.setBackgroundColor(getResources().getColor(2131690605));
            localObject1 = this.vkw;
            ((FTSSOSHomeWebViewUI.b)localObject1).b(((FTSSOSHomeWebViewUI.b)localObject1).vld);
            if ((com.tencent.mm.compatible.util.d.fv(23)) && (!com.tencent.mm.compatible.util.h.Mo())) {
              au(getResources().getColor(2131690709), true);
            }
            if (this.type == 64)
            {
              this.vkH = true;
              this.vkj.setVisibility(8);
              this.vki.setVisibility(0);
            }
            this.vkw.start();
          }
        }
        try
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("key", "searchID");
          this.vkA = this.igU.s(6, (Bundle)localObject1).getString("result");
          an.au(this.vkA, getSessionId(), this.mXD.getVertBizTypes());
          an.Ju(getScene());
          dfK();
          this.vjy.getViewTreeObserver().addOnPreDrawListener(new FTSSOSHomeWebViewUI.14(this));
          if (!this.vlr)
          {
            this.vkh.setVisibility(4);
            this.vjz.setVoiceBtnClickListener(new FTSSOSHomeWebViewUI.15(this));
            this.vjz.setCancelTextViewClickListener(new FTSSOSHomeWebViewUI.16(this));
            KI(this.vjX);
            localObject1 = dfA().getClearBtn();
            if (localObject1 != null) {
              ((ImageButton)localObject1).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
            }
            AppMethodBeat.o(8478);
            return;
            localObject1 = localObject2;
            continue;
            bool = false;
            continue;
            bool = false;
            continue;
            this.vkw.dfP();
            continue;
          }
          this.vkh.setVisibility(0);
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2) {}
    }
  }
  
  public final int aMg()
  {
    boolean bool2 = false;
    AppMethodBeat.i(8486);
    boolean bool1 = bool2;
    if (getIntent() != null)
    {
      bool1 = bool2;
      if (getIntent().getBooleanExtra("ftsInitToSearch", false)) {
        bool1 = true;
      }
    }
    this.vkB = bool1;
    if ((com.tencent.mm.compatible.util.d.fv(23)) && (!com.tencent.mm.sdk.h.b.Mo()))
    {
      if (this.vkB)
      {
        AppMethodBeat.o(8486);
        return -1;
      }
      i = getResources().getColor(2131690690);
      AppMethodBeat.o(8486);
      return i;
    }
    int i = super.aMg();
    AppMethodBeat.o(8486);
    return i;
  }
  
  public final boolean aMm()
  {
    AppMethodBeat.i(8491);
    if (!this.vjF)
    {
      AppMethodBeat.o(8491);
      return true;
    }
    this.vkw.sendMessage(0);
    super.aMm();
    AppMethodBeat.o(8491);
    return true;
  }
  
  public final boolean ddz()
  {
    return true;
  }
  
  public final boolean dfE()
  {
    AppMethodBeat.i(8502);
    if (this.vkw == null)
    {
      AppMethodBeat.o(8502);
      return false;
    }
    boolean bool = this.vkw.dfE();
    AppMethodBeat.o(8502);
    return bool;
  }
  
  protected final boolean dfF()
  {
    AppMethodBeat.i(8503);
    if ((dfE()) && (!this.vkl.isAnimating) && (!this.vkm.isAnimating) && (!this.vkn.isAnimating))
    {
      AppMethodBeat.o(8503);
      return true;
    }
    AppMethodBeat.o(8503);
    return false;
  }
  
  public final int dfL()
  {
    return 1;
  }
  
  protected final Map<String, Object> dfM()
  {
    AppMethodBeat.i(8485);
    HashMap localHashMap = new HashMap();
    if ((this.mXD == null) || (this.qKl == null))
    {
      AppMethodBeat.o(8485);
      return localHashMap;
    }
    ab.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom %d, title.bottom %d", new Object[] { Integer.valueOf(this.mXD.getBottom()), Integer.valueOf(this.qKl.getBottom()) });
    int i;
    if (this.mXD.getTop() < this.qKl.getBottom())
    {
      i = this.mXD.getBottom() - this.qKl.getBottom();
      localHashMap.put("nativeHeight", Integer.valueOf(com.tencent.mm.cb.a.ar(this, i)));
    }
    for (;;)
    {
      try
      {
        localObject = this.igU.s(7, null);
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
        ab.printErrStackTrace("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(8485);
      return localHashMap;
      i = this.mXD.getBottom();
      break;
      localObject = ((Bundle)localObject).getString("data");
    }
  }
  
  protected final void dfu()
  {
    AppMethodBeat.i(8493);
    super.dfu();
    this.vkw.sendMessage(11);
    AppMethodBeat.o(8493);
  }
  
  protected final void dfv()
  {
    AppMethodBeat.i(8488);
    super.dfv();
    KI(this.vjX);
    dfA().setHint(KJ(this.vjX));
    AppMethodBeat.o(8488);
  }
  
  protected final void dfw()
  {
    AppMethodBeat.i(8494);
    if (this.vkz > 0)
    {
      AppMethodBeat.o(8494);
      return;
    }
    super.dfw();
    dfA().setHint(getHint());
    this.vkw.sendMessage(2);
    this.vjy.setBackgroundResource(2130840435);
    this.qVf.setVisibility(8);
    this.vkM = null;
    this.vkN = 0;
    this.vkH = false;
    this.vkj.setVisibility(0);
    this.vki.setVisibility(8);
    com.tencent.mm.plugin.report.service.h.qsU.e(15521, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(1), dfA().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.vjX) });
    AppMethodBeat.o(8494);
  }
  
  protected final void dfx()
  {
    AppMethodBeat.i(8495);
    super.dfx();
    if (!this.vlr)
    {
      this.vkh.setVisibility(0);
      if ((this.pOd.getTopView() != null) && ((this.pOd.getTopView() instanceof AbsoluteLayout)))
      {
        ((ViewGroup)this.mXD.getParent()).removeView(this.mXD);
        AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, this.vkE - this.qKl.getHeight());
        ((AbsoluteLayout)this.pOd.getTopView()).addView(this.mXD, localLayoutParams);
      }
    }
    AppMethodBeat.o(8495);
  }
  
  public final String dfy()
  {
    if (this.vkN == 0) {
      return "";
    }
    return this.vkM;
  }
  
  public final int dfz()
  {
    return this.vkN;
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(8496);
    String str = KJ(dfC());
    AppMethodBeat.o(8496);
    return str;
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.jsapi.d getJsapi()
  {
    AppMethodBeat.i(8504);
    if (this.vkH)
    {
      locald = this.vkG.getJsapi();
      AppMethodBeat.o(8504);
      return locald;
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald = super.getJsapi();
    AppMethodBeat.o(8504);
    return locald;
  }
  
  public int getLayoutId()
  {
    return 2130970903;
  }
  
  public final void hQ(boolean paramBoolean)
  {
    AppMethodBeat.i(8487);
    if (this.vkw == null)
    {
      AppMethodBeat.o(8487);
      return;
    }
    if (this.vkw.dfE()) {
      super.hQ(paramBoolean);
    }
    this.vkw.sendMessage(5);
    AppMethodBeat.o(8487);
  }
  
  public final void l(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(8497);
    if ((this.vkH) && (this.vkG.A(paramInt, paramBundle)))
    {
      AppMethodBeat.o(8497);
      return;
    }
    super.l(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(8497);
      return;
      final ArrayList localArrayList = new ArrayList();
      String str;
      Object localObject;
      if (dfA().naN.hasFocus())
      {
        str = paramBundle.getString("query");
        if (getInEditTextQuery().equals(str))
        {
          paramBundle = paramBundle.getStringArrayList("result").iterator();
          paramInt = 0;
          while (paramBundle.hasNext())
          {
            localObject = (String)paramBundle.next();
            if (com.tencent.mm.bd.a.aR((String)localObject, str))
            {
              paramInt += 1;
              if (paramInt > 2) {
                break;
              }
              FTSSOSHomeWebViewUI.c localc = new FTSSOSHomeWebViewUI.c(this, (byte)0);
              localc.type = 1;
              localc.icon = 2131232043;
              localc.content = ((String)localObject);
              localc.vlh = 2130840434;
              localArrayList.add(localc);
            }
          }
        }
      }
      al.d(new FTSSOSHomeWebViewUI.a.1(this.vkk, localArrayList));
      AppMethodBeat.o(8497);
      return;
      localArrayList = new ArrayList();
      if (dfA().naN.hasFocus())
      {
        str = paramBundle.getString("query");
        if (getInEditTextQuery().equals(str))
        {
          this.vkM = paramBundle.getString("suggestionId");
          paramBundle = paramBundle.getStringArrayList("result").iterator();
          while (paramBundle.hasNext())
          {
            str = (String)paramBundle.next();
            localObject = new FTSSOSHomeWebViewUI.c(this, (byte)0);
            ((FTSSOSHomeWebViewUI.c)localObject).type = 2;
            ((FTSSOSHomeWebViewUI.c)localObject).icon = 0;
            ((FTSSOSHomeWebViewUI.c)localObject).content = str;
            ((FTSSOSHomeWebViewUI.c)localObject).vlh = 2130840437;
            localArrayList.add(localObject);
          }
        }
      }
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(8450);
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            FTSSOSHomeWebViewUI.c localc = (FTSSOSHomeWebViewUI.c)localIterator.next();
            if (!FTSSOSHomeWebViewUI.a.a(FTSSOSHomeWebViewUI.this).contains(localc)) {
              FTSSOSHomeWebViewUI.a.a(FTSSOSHomeWebViewUI.this).add(localc);
            }
          }
          FTSSOSHomeWebViewUI.this.notifyDataSetChanged();
          AppMethodBeat.o(8450);
        }
      });
      AppMethodBeat.o(8497);
      return;
      this.vkw.sendMessage(8);
      AppMethodBeat.o(8497);
      return;
      this.vkw.sendMessage(10);
      AppMethodBeat.o(8497);
      return;
      AppMethodBeat.o(8497);
      return;
      paramBundle.getString("fts_key_new_query", "");
      this.vkw.sendMessage(13);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(8480);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(8480);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("text");
      if (!TextUtils.isEmpty(paramIntent))
      {
        paramIntent = aiI(paramIntent);
        ab.i("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[] { Integer.valueOf(paramIntent.length()), paramIntent });
        this.vjz.o(paramIntent, null);
        aMm();
        AppMethodBeat.o(8480);
        return;
      }
    }
    AppMethodBeat.o(8480);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(8501);
    if (this.vkq.getVisibility() == 0) {
      dfO();
    }
    for (;;)
    {
      dfA().bDj();
      AppMethodBeat.o(8501);
      return;
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(8476);
    super.onCreate(paramBundle);
    boolean bool1 = bool2;
    if (getIntent() != null)
    {
      bool1 = bool2;
      if (getIntent().getBooleanExtra("ftsInitToSearch", false)) {
        bool1 = true;
      }
    }
    this.vkB = bool1;
    this.vkG = new WeappWebSearchFragment();
    paramBundle = new Bundle();
    paramBundle.putString("url", getIntent().getStringExtra("key_weapp_url"));
    this.vkG.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().a(2131828192, this.vkG).commit();
    AppMethodBeat.o(8476);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(8484);
    super.onDestroy();
    an.cZJ();
    an.cZK();
    AppMethodBeat.o(8484);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(8483);
    super.onPause();
    an.cZI();
    AppMethodBeat.o(8483);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(8482);
    super.onResume();
    an.cZH();
    AppMethodBeat.o(8482);
  }
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(8505);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = Math.min(paramInt2, Math.max(com.tencent.mm.cb.a.fromDPToPix(this, this.pOd.getContentHeight()) - this.pOd.getHeight(), 0));
    this.vkl.KN(this.vkD - paramInt1);
    this.vkm.KN(this.vkD - paramInt1);
    this.vkn.KN(this.vkD - paramInt1);
    if (!this.vkw.dfE()) {
      this.vjy.setTranslationY(-paramInt1);
    }
    if (paramInt2 != 0)
    {
      dfA().naN.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(8505);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b$b
    extends com.tencent.mm.sdk.d.b
  {
    private b$b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(8462);
      super.enter();
      FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this.vkS, a.b.vlU);
      FTSSOSHomeWebViewUI.this.vkS.vjy.setBackgroundResource(2131690709);
      FTSSOSHomeWebViewUI.this.vkS.vjz.naN.clearFocus();
      FTSSOSHomeWebViewUI.this.vkS.hideVKB();
      FTSSOSHomeWebViewUI.G(FTSSOSHomeWebViewUI.this.vkS).setVisibility(0);
      FTSSOSHomeWebViewUI.this.vkS.vjy.setPadding(FTSSOSHomeWebViewUI.H(FTSSOSHomeWebViewUI.this.vkS), 0, 0, 0);
      FTSSOSHomeWebViewUI.this.vkS.dfA().bDj();
      FTSSOSHomeWebViewUI.this.vkS.pbT.setVisibility(0);
      FTSSOSHomeWebViewUI.this.vkS.dfA().bDh();
      FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this.vkS).clear();
      FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this.vkS).setVisibility(0);
      FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this.vkS).setVisibility(8);
      FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this.vkS).setVisibility(8);
      FTSSOSHomeWebViewUI.this.vkS.vjz.setSearchBarCancelTextContainerVisibile(0);
      FTSSOSHomeWebViewUI.this.vkS.vjz.setVoiceImageButtonVisibile(0);
      FTSSOSHomeWebViewUI.this.vkS.vjz.bDj();
      FTSSOSHomeWebViewUI.I(FTSSOSHomeWebViewUI.this.vkS);
      if (!FTSSOSHomeWebViewUI.this.vkS.vkB) {
        FTSSOSHomeWebViewUI.this.vkS.dfA().bDh();
      }
      FTSSOSHomeWebViewUI.J(FTSSOSHomeWebViewUI.this.vkS).setVisibility(0);
      if ((com.tencent.mm.compatible.util.d.fv(23)) && (!com.tencent.mm.sdk.h.b.Mo())) {
        FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this.vkS, FTSSOSHomeWebViewUI.this.vkS.getResources().getColor(2131690709));
      }
      FTSSOSHomeWebViewUI.K(FTSSOSHomeWebViewUI.this.vkS).setAlpha(0.0F);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.this.vkS.vjy.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      if (FTSSOSHomeWebViewUI.this.vkS.vkB) {
        localLayoutParams.topMargin = 0;
      }
      localLayoutParams.width = -1;
      FTSSOSHomeWebViewUI.this.vkS.vjy.setLayoutParams(localLayoutParams);
      FTSSOSHomeWebViewUI.this.vkS.vjy.setY(0.0F);
      FTSSOSHomeWebViewUI.this.vkS.vjy.setX(0.0F);
      if (FTSSOSHomeWebViewUI.this.vkS.vkB)
      {
        FTSSOSHomeWebViewUI.this.vkS.vjy.setTranslationX(0.0F);
        FTSSOSHomeWebViewUI.this.vkS.vjy.setTranslationY(0.0F);
      }
      if ((FTSSOSHomeWebViewUI.this.vkS.vkB) && (FTSSOSHomeWebViewUI.this.vkS.vkC))
      {
        FTSSOSHomeWebViewUI.this.vkS.vjy.setVisibility(8);
        FTSSOSHomeWebViewUI.K(FTSSOSHomeWebViewUI.this.vkS).setAlpha(1.0F);
        FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.this.vkS).setVisibility(0);
        FTSSOSHomeWebViewUI.K(FTSSOSHomeWebViewUI.this.vkS).setVisibility(0);
        if ((FTSSOSHomeWebViewUI.this.vkS.getIntent() != null) && (FTSSOSHomeWebViewUI.this.vkS.getIntent().hasExtra("customize_status_bar_color")))
        {
          FTSSOSHomeWebViewUI.C(FTSSOSHomeWebViewUI.this.vkS).setBackgroundColor(FTSSOSHomeWebViewUI.L(FTSSOSHomeWebViewUI.this.vkS));
          if (FTSSOSHomeWebViewUI.this.vkS.getIntent().hasExtra("status_bar_style")) {
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this.vkS, FTSSOSHomeWebViewUI.M(FTSSOSHomeWebViewUI.this.vkS), "black".equals(FTSSOSHomeWebViewUI.N(FTSSOSHomeWebViewUI.this.vkS)));
          }
        }
      }
      FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this.vkS, FTSSOSHomeWebViewUI.this.vkS.vjX);
      FTSSOSHomeWebViewUI.this.vkS.dfI();
      AppMethodBeat.o(8462);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(8463);
      super.exit();
      AppMethodBeat.o(8463);
    }
    
    public final String getName()
    {
      return "SearchNoFocusState";
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(8464);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        boolean bool = super.k(paramMessage);
        AppMethodBeat.o(8464);
        return bool;
        if (!FTSSOSHomeWebViewUI.this.vkS.vkB)
        {
          FTSSOSHomeWebViewUI.O(FTSSOSHomeWebViewUI.this.vkS);
          FTSSOSHomeWebViewUI.P(FTSSOSHomeWebViewUI.this.vkS).setVisibility(8);
          FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this.vkS, 0);
          FTSSOSHomeWebViewUI.D(FTSSOSHomeWebViewUI.this.vkS).b(a.b.vlT);
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this.vkS, a.b.vlT);
        }
        else
        {
          FTSSOSHomeWebViewUI.this.vkS.finish();
          continue;
          FTSSOSHomeWebViewUI.this.b(FTSSOSHomeWebViewUI.this.vlb);
          continue;
          if (FTSSOSHomeWebViewUI.this.vkS.dfA().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.this.b(FTSSOSHomeWebViewUI.this.vlc);
            com.tencent.mm.plugin.report.service.h.qsU.e(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.vkS.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.vkS.dfA().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.vkS.vjX) });
            continue;
            FTSSOSHomeWebViewUI.this.vkS.dfA().bDj();
          }
        }
      }
    }
  }
  
  final class b$d
    extends com.tencent.mm.sdk.d.b
  {
    private b$d() {}
    
    public final void enter()
    {
      AppMethodBeat.i(8468);
      super.enter();
      FTSSOSHomeWebViewUI.this.vkS.dfA().bDh();
      FTSSOSHomeWebViewUI.G(FTSSOSHomeWebViewUI.this.vkS).setVisibility(0);
      FTSSOSHomeWebViewUI.this.vkS.vjy.setPadding(FTSSOSHomeWebViewUI.H(FTSSOSHomeWebViewUI.this.vkS), 0, 0, 0);
      FTSSOSHomeWebViewUI.P(FTSSOSHomeWebViewUI.this.vkS).setVisibility(8);
      FTSSOSHomeWebViewUI.this.vkS.vjz.setSearchBarCancelTextContainerVisibile(8);
      FTSSOSHomeWebViewUI.this.vkS.vjz.setVoiceImageButtonVisibile(8);
      FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this.vkS);
      FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.this.vkS).setVisibility(8);
      FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.this.vkS).setVisibility(8);
      FTSSOSHomeWebViewUI.J(FTSSOSHomeWebViewUI.this.vkS).setVisibility(0);
      if (!FTSSOSHomeWebViewUI.this.vkS.dfA().naN.hasFocus())
      {
        FTSSOSHomeWebViewUI.this.vkS.dfA().bDf();
        FTSSOSHomeWebViewUI.this.vkS.showVKB();
      }
      if ((com.tencent.mm.compatible.util.d.fv(23)) && (!com.tencent.mm.sdk.h.b.Mo())) {
        FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this.vkS, FTSSOSHomeWebViewUI.this.vkS.getResources().getColor(2131690709));
      }
      if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.vkS.getInEditTextQuery())) {
        FTSSOSHomeWebViewUI.this.vkS.dfA().bDk();
      }
      FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this.vkS, FTSSOSHomeWebViewUI.this.vkS.vjX);
      AppMethodBeat.o(8468);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(8469);
      super.exit();
      FTSSOSHomeWebViewUI.this.vkS.hideVKB();
      AppMethodBeat.o(8469);
    }
    
    public final String getName()
    {
      return "SearchWithFocusState";
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(8470);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        boolean bool = super.k(paramMessage);
        AppMethodBeat.o(8470);
        return bool;
        if (!FTSSOSHomeWebViewUI.this.vkS.vkB)
        {
          FTSSOSHomeWebViewUI.O(FTSSOSHomeWebViewUI.this.vkS);
          FTSSOSHomeWebViewUI.P(FTSSOSHomeWebViewUI.this.vkS).setVisibility(8);
          FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this.vkS, 0);
          FTSSOSHomeWebViewUI.E(FTSSOSHomeWebViewUI.this.vkS).b(a.b.vlT);
          FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this.vkS, a.b.vlT);
        }
        else
        {
          FTSSOSHomeWebViewUI.this.vkS.finish();
          continue;
          FTSSOSHomeWebViewUI.this.b(FTSSOSHomeWebViewUI.this.vlb);
          continue;
          if (!FTSSOSHomeWebViewUI.this.vkS.dfA().getEditText().hasFocus())
          {
            FTSSOSHomeWebViewUI.this.b(FTSSOSHomeWebViewUI.this.vld);
          }
          else
          {
            com.tencent.mm.plugin.report.service.h.qsU.e(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.this.vkS.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.vkS.dfA().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.vkS.vjX) });
            continue;
            if (FTSSOSHomeWebViewUI.this.vkS.getTotalQuery().length() > 0) {
              FTSSOSHomeWebViewUI.this.b(FTSSOSHomeWebViewUI.this.vld);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI
 * JD-Core Version:    0.7.0.1
 */