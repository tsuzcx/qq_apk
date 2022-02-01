package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.r;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import java.util.Iterator;
import java.util.List;

public class SnsCommentFooter
  extends InputPanelLinearLayout
{
  public static String lyo;
  private ImageButton EOg;
  private boolean EOi;
  public boolean EOj;
  private boolean EOk;
  boolean EOl;
  private TextWatcher EOm;
  ejo JVu;
  com.tencent.mm.ui.widget.cedit.api.c KQB;
  private ImageView KQC;
  private ImageView KQD;
  private Button KQE;
  int KQF;
  private String KQG;
  private b KQH;
  boolean KQI;
  private boolean KQJ;
  private boolean KQK;
  public boolean KQL;
  private String KQM;
  private boolean KQN;
  private a KQO;
  private c KQP;
  private bw KQQ;
  MMActivity iXq;
  private Button jLo;
  ChatFooterPanel jPN;
  private int jPQ;
  private int jPR;
  private int jPS;
  int state;
  
  static
  {
    AppMethodBeat.i(292766);
    lyo = com.tencent.mm.plugin.fts.a.d.Sx(79);
    AppMethodBeat.o(292766);
  }
  
  public SnsCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98650);
    this.JVu = null;
    this.KQF = 0;
    this.state = 0;
    this.EOi = false;
    this.jPQ = -1;
    this.jPR = -1;
    this.jPS = 0;
    this.KQH = null;
    this.KQI = false;
    this.KQJ = false;
    this.KQK = KeyBoardUtil.isPortOrientation(getContext());
    this.EOj = false;
    this.EOk = true;
    this.KQM = "";
    this.KQN = false;
    this.EOl = true;
    this.EOm = new TextWatcher()
    {
      private int KQX = 0;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(98639);
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
        {
          AppMethodBeat.o(98639);
          return;
        }
        if ((com.tencent.mm.plugin.sns.ui.widget.e.ki(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!Util.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (SnsCommentFooter.b(SnsCommentFooter.this).getText() != null) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
        {
          Log.i("MicroMsg.SnsCommentFooter", "cur text %s", new Object[] { SnsCommentFooter.b(SnsCommentFooter.this).getText() });
          SnsCommentFooter.a(SnsCommentFooter.this, "");
          SnsCommentFooter.e(SnsCommentFooter.this);
          SnsCommentFooter.this.ahf(8);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
        SnsCommentFooter.b(SnsCommentFooter.this).hZB();
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (SnsCommentFooter.this.EOl))
          {
            SnsCommentFooter.a(SnsCommentFooter.this, true);
            SnsCommentFooter.this.EOl = false;
          }
          if (i == 0)
          {
            SnsCommentFooter.a(SnsCommentFooter.this, false);
            SnsCommentFooter.this.EOl = true;
          }
          AppMethodBeat.o(98639);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98637);
        if (paramAnonymousCharSequence == null) {}
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousCharSequence.length())
        {
          this.KQX = paramAnonymousInt1;
          AppMethodBeat.o(98637);
          return;
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98638);
        if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.c.a.JPj))
        {
          SnsCommentFooter.this.ahf(16);
          Log.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
          AppMethodBeat.o(98638);
          return;
        }
        if (paramAnonymousCharSequence.length() - this.KQX > com.tencent.mm.plugin.sns.c.a.JPj)
        {
          SnsCommentFooter.this.setCommentFlag(16);
          Log.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
        }
        AppMethodBeat.o(98638);
      }
    };
    this.iXq = ((MMActivity)paramContext);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNc, 0) == 1) {}
      for (bool = true;; bool = false)
      {
        this.KQI = bool;
        AppMethodBeat.o(98650);
        return;
      }
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNc, 0) == 1) {}
    for (;;)
    {
      this.KQI = bool;
      AppMethodBeat.o(98650);
      return;
      bool = false;
    }
  }
  
  public static void a(Context paramContext, Object paramObject, boolean paramBoolean, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(200943);
    if (!(paramObject instanceof SnsInfo))
    {
      AppMethodBeat.o(200943);
      return;
    }
    paramObject = (SnsInfo)paramObject;
    int k;
    int i;
    label43:
    String str;
    int j;
    if (paramBoolean)
    {
      k = 3;
      i = 1;
      if (!(paramContext instanceof SnsTimeLineUI)) {
        break label104;
      }
      i = 1;
      paramContext = paramObject.field_userName;
      str = t.Qu(paramObject.field_snsId);
      if (!paramObject.isAd()) {
        break label130;
      }
      j = 2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.websearch.a.b.a(k, i, paramContext, str, j, String.valueOf(paramString1), lyo, paramInt, paramString2, paramLong);
      AppMethodBeat.o(200943);
      return;
      k = 2;
      break;
      label104:
      if ((paramContext instanceof SnsCommentDetailUI))
      {
        i = 3;
        break label43;
      }
      if (!(paramContext instanceof SnsCommentUI)) {
        break label43;
      }
      i = 2;
      break label43;
      label130:
      if (paramObject.isWxWork()) {
        j = 3;
      } else {
        j = 1;
      }
    }
  }
  
  private void aDM()
  {
    AppMethodBeat.i(98666);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    Log.i("MicroMsg.SnsCommentFooter", "refreshBottomPanelHeight: %s", new Object[] { Integer.valueOf(i) });
    if (this.jPN != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jPN.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = i;
        this.jPN.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(98666);
  }
  
  private void eQo()
  {
    AppMethodBeat.i(98654);
    this.jPN.onResume();
    if ((KeyBoardUtil.isPortOrientation(getContext())) && (fWm())) {
      getInputPanelHelper().aX(new SnsCommentFooter.5(this));
    }
    for (;;)
    {
      if (this.KQP != null) {
        this.KQP.onShow();
      }
      AppMethodBeat.o(98654);
      return;
      Log.i("MicroMsg.SnsCommentFooter", "showSmileyPanel");
      this.jPN.setVisibility(0);
    }
  }
  
  private boolean fWm()
  {
    AppMethodBeat.i(98667);
    int i = ar.aB(getContext());
    Log.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.jPR), Integer.valueOf(this.jPQ), Integer.valueOf(i) });
    if ((this.jPR > 0) && (this.jPR < this.jPQ - i))
    {
      AppMethodBeat.o(98667);
      return true;
    }
    AppMethodBeat.o(98667);
    return false;
  }
  
  private void tV(boolean paramBoolean)
  {
    AppMethodBeat.i(98670);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), i.a.pop_in);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), i.a.pop_out);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if ((this.jLo == null) || (this.KQE == null))
    {
      AppMethodBeat.o(98670);
      return;
    }
    if (paramBoolean)
    {
      if ((this.jLo.getVisibility() == 8) || (this.jLo.getVisibility() == 4))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.KQE.startAnimation(localAnimation1);
      this.KQE.setVisibility(0);
      this.jLo.startAnimation(localAnimation2);
      this.jLo.setVisibility(8);
    }
    for (;;)
    {
      this.KQE.getParent().requestLayout();
      AppMethodBeat.o(98670);
      return;
      if ((this.jLo.getVisibility() == 0) || (this.jLo.getVisibility() == 0))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.jLo.startAnimation(localAnimation1);
      this.jLo.setVisibility(0);
      this.KQE.startAnimation(localAnimation2);
      this.KQE.setVisibility(8);
    }
  }
  
  public final void ahf(int paramInt)
  {
    this.KQF &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final boolean fWi()
  {
    AppMethodBeat.i(98649);
    if ((this.KQB.getText() == null) || (Util.isNullOrNil(this.KQB.getText().toString())))
    {
      AppMethodBeat.o(98649);
      return true;
    }
    AppMethodBeat.o(98649);
    return false;
  }
  
  public final boolean fWj()
  {
    return this.state == 1;
  }
  
  public final void fWk()
  {
    AppMethodBeat.i(98655);
    if (this.KQB == null)
    {
      Log.e("MicroMsg.SnsCommentFooter", "send edittext is null");
      AppMethodBeat.o(98655);
      return;
    }
    this.KQB.removeTextChangedListener(this.EOm);
    this.KQB.addTextChangedListener(this.EOm);
    AppMethodBeat.o(98655);
  }
  
  public final void fWl()
  {
    AppMethodBeat.i(98660);
    this.KQB.setText("");
    this.KQB.setHint("");
    this.JVu = null;
    this.KQF = 0;
    this.state = 0;
    AppMethodBeat.o(98660);
  }
  
  public final void fWn()
  {
    AppMethodBeat.i(98669);
    this.KQQ = null;
    if (this.jPN != null)
    {
      Log.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.jPN.hjm();
      this.jPN.destroy();
    }
    if (this.KQB != null) {
      this.KQB.destroy();
    }
    AppMethodBeat.o(98669);
  }
  
  public String getCommentAtPrefix()
  {
    return this.KQG;
  }
  
  public int getCommentFlag()
  {
    return this.KQF;
  }
  
  public ejo getCommentInfo()
  {
    AppMethodBeat.i(98661);
    if (this.JVu == null)
    {
      localejo = new ejo();
      AppMethodBeat.o(98661);
      return localejo;
    }
    ejo localejo = this.JVu;
    AppMethodBeat.o(98661);
    return localejo;
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(98665);
    super.h(paramBoolean, paramInt);
    this.EOj = paramBoolean;
    if ((paramBoolean) && (getVisibility() == 0) && (this.KQQ != null))
    {
      Log.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
      this.KQQ.fYg();
    }
    this.KQB.Hm(paramBoolean);
    if ((this.jPS != paramInt) && (paramInt != 0))
    {
      this.jPS = paramInt;
      i.E(getContext(), paramInt);
      aDM();
    }
    AppMethodBeat.o(98665);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98664);
    super.onConfigurationChanged(paramConfiguration);
    if (this.jPN != null) {
      aDM();
    }
    AppMethodBeat.o(98664);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98668);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jPQ < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.jPQ)
    {
      this.jPQ = paramInt1;
      this.jPR = paramInt4;
      AppMethodBeat.o(98668);
      return;
    }
  }
  
  public final void q(final List<k> paramList, String paramString)
  {
    AppMethodBeat.i(98656);
    this.KQM = paramString;
    k localk;
    if (this.KQB != null)
    {
      if (Util.isNullOrNil(paramString)) {
        break label180;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localk = (k)localIterator.next();
        if (paramString.equals(localk.key)) {
          paramList.remove(localk);
        }
      }
    }
    label180:
    for (paramString = Util.nullAs(localk.text, "");; paramString = "")
    {
      if (!Util.isNullOrNil(paramString))
      {
        this.KQE.setVisibility(0);
        this.jLo.setVisibility(8);
        this.KQB.setText("");
        this.KQB.bBa(paramString);
      }
      for (;;)
      {
        if (!this.KQN) {
          this.KQB.addTextChangedListener(new TextWatcher()
          {
            int KQX = 0;
            
            public final void afterTextChanged(Editable paramAnonymousEditable)
            {
              AppMethodBeat.i(98642);
              if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
              {
                AppMethodBeat.o(98642);
                return;
              }
              if ((com.tencent.mm.plugin.sns.ui.widget.e.ki(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!Util.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (!Util.isNullOrNil(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString())) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
              {
                Log.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", new Object[] { SnsCommentFooter.d(SnsCommentFooter.this), SnsCommentFooter.b(SnsCommentFooter.this).getText() });
                SnsCommentFooter.a(SnsCommentFooter.this, "");
                SnsCommentFooter.e(SnsCommentFooter.this);
                SnsCommentFooter.this.ahf(8);
                SnsCommentFooter.a(SnsCommentFooter.this, 0);
              }
              Log.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.f(SnsCommentFooter.this));
              if (!Util.isNullOrNil(SnsCommentFooter.f(SnsCommentFooter.this)))
              {
                paramAnonymousEditable = paramList.iterator();
                while (paramAnonymousEditable.hasNext())
                {
                  k localk = (k)paramAnonymousEditable.next();
                  if (SnsCommentFooter.f(SnsCommentFooter.this).equals(localk.key))
                  {
                    Log.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                    localk.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                    localk.cUP = SnsCommentFooter.c(SnsCommentFooter.this);
                  }
                }
              }
              for (int i = 1;; i = 0)
              {
                if (i == 0)
                {
                  Log.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                  paramAnonymousEditable = new k();
                  paramAnonymousEditable.key = SnsCommentFooter.f(SnsCommentFooter.this);
                  paramAnonymousEditable.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                  paramAnonymousEditable.cUP = SnsCommentFooter.c(SnsCommentFooter.this);
                  if ((paramAnonymousEditable.text != null) && (paramAnonymousEditable.text.length() > 0)) {
                    paramList.add(paramAnonymousEditable);
                  }
                }
                if (paramList.size() > 5)
                {
                  Log.d("MicroMsg.SnsCommentFooter", "comments remove");
                  paramList.remove(0);
                }
                SnsCommentFooter.b(SnsCommentFooter.this).hZB();
                if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
                for (boolean bool = true;; bool = false)
                {
                  if ((bool) && (SnsCommentFooter.this.EOl))
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.EOl = false;
                  }
                  if (!bool)
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.EOl = true;
                  }
                  AppMethodBeat.o(98642);
                  return;
                }
              }
            }
            
            public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(98641);
              if (paramAnonymousCharSequence == null) {}
              for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousCharSequence.length())
              {
                this.KQX = paramAnonymousInt1;
                AppMethodBeat.o(98641);
                return;
              }
            }
            
            public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(98640);
              if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.c.a.JPj))
              {
                SnsCommentFooter.this.ahf(16);
                Log.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.o(98640);
                return;
              }
              if (paramAnonymousCharSequence.length() - this.KQX > com.tencent.mm.plugin.sns.c.a.JPj)
              {
                SnsCommentFooter.this.setCommentFlag(16);
                Log.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
              }
              AppMethodBeat.o(98640);
            }
          });
        }
        this.KQN = true;
        AppMethodBeat.o(98656);
        return;
        this.KQB.setText("");
      }
    }
  }
  
  public final void rs(boolean paramBoolean)
  {
    AppMethodBeat.i(98659);
    if (this.KQC != null)
    {
      if (paramBoolean)
      {
        this.KQC.setVisibility(0);
        if ((com.tencent.mm.n.h.axc().getInt("SnsAdAtFriendRedDot", 0) == 1) && (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VwG, true)))
        {
          this.KQD.setVisibility(0);
          AppMethodBeat.o(98659);
          return;
        }
        this.KQD.setVisibility(8);
        AppMethodBeat.o(98659);
        return;
      }
      this.KQC.setVisibility(8);
      this.KQD.setVisibility(8);
    }
    AppMethodBeat.o(98659);
  }
  
  public void setAfterEditAction(Runnable paramRunnable)
  {
    AppMethodBeat.i(98651);
    paramRunnable = (ViewGroup)inflate(this.iXq, i.g.sns_comment_footer, this);
    this.KQC = ((ImageView)paramRunnable.findViewById(i.f.album_comment_at_btn));
    this.KQD = ((ImageView)paramRunnable.findViewById(i.f.album_comment_at_reddot));
    this.jLo = ((Button)paramRunnable.findViewById(i.f.album_comment_send_btn));
    this.KQE = ((Button)paramRunnable.findViewById(i.f.album_comment_green_send_btn));
    this.KQB = ((com.tencent.mm.ui.widget.cedit.api.c)paramRunnable.findViewById(i.f.album_comment_content_et));
    this.KQB.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.ag(PluginWebSearch.class)).isUseSysEditText());
    this.KQB.getInputExtras(true).putBoolean("if_support_wx_emoji", true);
    SnsCommentFooter.2 local2 = new SnsCommentFooter.2(this);
    this.KQB.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(this.iXq), local2);
    this.KQB.addTextChangedListener(new SnsCommentFooter.3(this));
    tV(false);
    this.KQC.setOnClickListener(new SnsCommentFooter.9(this));
    this.EOg = ((ImageButton)paramRunnable.findViewById(i.f.album_comment_mode_iv));
    this.EOg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98644);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        SnsCommentFooter.this.setModeClick(true);
        Log.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.i(SnsCommentFooter.this));
        if (SnsCommentFooter.i(SnsCommentFooter.this) == 0)
        {
          SnsCommentFooter.b(SnsCommentFooter.this).hZB();
          SnsCommentFooter.this.iXq.hideVKB();
          SnsCommentFooter.a(SnsCommentFooter.this, 1);
          SnsCommentFooter.j(SnsCommentFooter.this);
          SnsCommentFooter.this.setToSendTextColor(false);
          SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(i.e.chatting_setmode_keyboard_btn);
          SnsCommentFooter.k(SnsCommentFooter.this).setContentDescription(SnsCommentFooter.this.getContext().getString(i.j.ime_setting_keyboard_type));
          SnsCommentFooter.l(SnsCommentFooter.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98644);
          return;
          SnsCommentFooter.m(SnsCommentFooter.this);
          SnsCommentFooter.l(SnsCommentFooter.this);
          SnsCommentFooter.b(SnsCommentFooter.this).hZB();
          SnsCommentFooter.this.iXq.showVKB();
          SnsCommentFooter.this.setToSendTextColor(true);
          SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(i.i.icons_outlined_emoji);
          SnsCommentFooter.k(SnsCommentFooter.this).setContentDescription(SnsCommentFooter.this.getContext().getString(i.j.chat_footer_smiley_btn));
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
      }
    });
    this.KQB.setHint(this.iXq.getString(i.j.sns_ui_comment));
    paramRunnable = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(98645);
        SnsCommentFooter.this.setToSendTextColor(true);
        SnsCommentFooter.l(SnsCommentFooter.this);
        SnsCommentFooter.m(SnsCommentFooter.this);
        SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(i.i.icons_outlined_emoji);
        if (SnsCommentFooter.n(SnsCommentFooter.this) != null) {
          SnsCommentFooter.n(SnsCommentFooter.this).fWh();
        }
        SnsCommentFooter.a(SnsCommentFooter.this, 0);
        AppMethodBeat.o(98645);
        return false;
      }
    };
    this.KQB.setOnTouchListener(paramRunnable);
    if (com.tencent.mm.pluginsdk.ui.chat.e.RnO == null)
    {
      this.jPN = new com.tencent.mm.pluginsdk.ui.chat.d(this.iXq);
      AppMethodBeat.o(98651);
      return;
    }
    this.jPN = com.tencent.mm.pluginsdk.ui.chat.e.RnO.fd(getContext());
    this.jPN.setEntranceScene(ChatFooterPanel.Rcl);
    this.jPN.setVisibility(8);
    paramRunnable = (LinearLayout)findViewById(i.f.root);
    this.jPS = KeyBoardUtil.getValidPanelHeight(getContext());
    paramRunnable.addView(this.jPN, -1, this.jPS);
    Log.i("MicroMsg.SnsCommentFooter", "init: height %s", new Object[] { Integer.valueOf(this.jPS) });
    if (!this.KQI) {
      this.jPN.hjp();
    }
    this.jPN.onResume();
    this.jPN.setOnTextOperationListener(new SnsCommentFooter.12(this));
    paramRunnable = ad.faK.aag();
    paramRunnable.faJ = new ac.a()
    {
      public final void a(final r paramAnonymousr)
      {
        AppMethodBeat.i(98631);
        if ((paramAnonymousr instanceof EmojiInfo))
        {
          boolean bool = false;
          String str;
          if ((SnsCommentFooter.o(SnsCommentFooter.this) != null) && (!Util.isNullOrNil(SnsCommentFooter.o(SnsCommentFooter.this).Username)))
          {
            str = SnsCommentFooter.o(SnsCommentFooter.this).Username;
            bool = true;
          }
          while (!SnsCommentFooter.p(SnsCommentFooter.this))
          {
            AppMethodBeat.o(98631);
            return;
            if ((SnsCommentFooter.this.getTag() != null) && ((SnsCommentFooter.this.getTag() instanceof SnsInfo)))
            {
              str = ((SnsInfo)SnsCommentFooter.this.getTag()).getUserName();
            }
            else
            {
              AppMethodBeat.o(98631);
              return;
            }
          }
          com.tencent.mm.plugin.sns.c.a.mIG.a(SnsCommentFooter.h(SnsCommentFooter.this), str, ((EmojiInfo)paramAnonymousr).field_md5, bool, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(98630);
              if ((SnsCommentFooter.q(SnsCommentFooter.this) != null) && (paramAnonymous2Boolean)) {
                if (!com.tencent.mm.plugin.sns.ui.widget.e.ki(SnsCommentFooter.c(SnsCommentFooter.this), 8)) {
                  break label94;
                }
              }
              label94:
              for (paramAnonymous2String = SnsCommentFooter.this.getCommentAtPrefix();; paramAnonymous2String = "")
              {
                SnsCommentFooter.q(SnsCommentFooter.this).ll(paramAnonymous2String, ((EmojiInfo)paramAnonymousr).field_md5);
                com.tencent.mm.plugin.report.service.h.IzE.el(150, 81);
                AppMethodBeat.o(98630);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(98631);
      }
      
      public final void onHide() {}
    };
    this.jPN.setCallback(paramRunnable);
    AppMethodBeat.o(98651);
  }
  
  public void setAnitiomAdjust(bw parambw)
  {
    this.KQQ = parambw;
  }
  
  public void setCommentAtPrefix(String paramString)
  {
    this.KQG = paramString;
  }
  
  public void setCommentFlag(int paramInt)
  {
    this.KQF |= paramInt;
  }
  
  public void setCommentHint(String paramString)
  {
    AppMethodBeat.i(98658);
    if (!Util.isNullOrNil(paramString))
    {
      if (com.tencent.mm.plugin.sns.ui.widget.e.ki(this.KQF, 1))
      {
        this.KQB.setHint(l.b(getContext(), this.iXq.getString(i.j.sns_ad_at_tips1) + paramString + this.iXq.getString(i.j.sns_after_reply, new Object[] { Float.valueOf(this.KQB.getTextSize()) }), this.KQB.getTextSize()));
        AppMethodBeat.o(98658);
        return;
      }
      this.KQB.setHint(l.b(getContext(), paramString, this.KQB.getTextSize()));
      AppMethodBeat.o(98658);
      return;
    }
    this.KQB.setHint("");
    AppMethodBeat.o(98658);
  }
  
  public void setCommentInfo(ejo paramejo)
  {
    this.JVu = paramejo;
  }
  
  public void setFeedEmojiCommentEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(176296);
    this.KQJ = paramBoolean;
    Log.i("MicroMsg.SnsCommentFooter", "setFeedEmojiCommentEnable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(176296);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.EOi = paramBoolean;
  }
  
  public void setOnCommentSendImp(final b paramb)
  {
    AppMethodBeat.i(98663);
    this.KQH = paramb;
    this.KQE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(229254);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.ui.widget.cedit.api.d.a(SnsCommentFooter.b(SnsCommentFooter.this)).axx(com.tencent.mm.n.c.awD()).Hh(true).a(new c.a()
        {
          public final void abc(String paramAnonymous2String)
          {
            AppMethodBeat.i(196304);
            SnsCommentFooter.b(SnsCommentFooter.this).getText();
            SnsCommentFooter.4.this.KQV.ll(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString(), "");
            SnsCommentFooter.b(SnsCommentFooter.this).setText("");
            AppMethodBeat.o(196304);
          }
          
          public final void abd(String paramAnonymous2String) {}
          
          public final void dN(String paramAnonymous2String)
          {
            AppMethodBeat.i(196308);
            com.tencent.mm.ui.base.h.p(SnsCommentFooter.h(SnsCommentFooter.this), i.j.sns_upload_post_text_invalid_more, i.j.sns_upload_post_text_invalid_title);
            AppMethodBeat.o(196308);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229254);
      }
    });
    AppMethodBeat.o(98663);
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.KQO = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.KQP = paramc;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98657);
    if (this.KQB != null)
    {
      this.KQB.setText("");
      this.KQB.bBa(paramString);
    }
    AppMethodBeat.o(98657);
  }
  
  public void setToSendTextColor(boolean paramBoolean)
  {
    AppMethodBeat.i(98662);
    if (this.KQB == null)
    {
      AppMethodBeat.o(98662);
      return;
    }
    if (paramBoolean)
    {
      this.KQB.setTextColor(getResources().getColor(i.c.mm_edit_text_color));
      AppMethodBeat.o(98662);
      return;
    }
    this.KQB.setTextColor(getResources().getColor(i.c.half_alpha_black));
    Log.i("MicroMsg.SnsCommentFooter", "focusEdt: %s, %s", new Object[] { Boolean.FALSE, this.KQB });
    if (this.KQB != null) {
      this.KQB.clearFocus();
    }
    AppMethodBeat.o(98662);
  }
  
  public void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(98652);
    this.state = 0;
    if (paramInt == 0) {
      bool = true;
    }
    yX(bool);
    super.setVisibility(paramInt);
    AppMethodBeat.o(98652);
  }
  
  public final void yX(boolean paramBoolean)
  {
    AppMethodBeat.i(98653);
    if (this.jPN == null)
    {
      AppMethodBeat.o(98653);
      return;
    }
    this.KQL = paramBoolean;
    Log.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      this.jPN.setVisibility(8);
      this.EOg.setImageResource(i.i.icons_outlined_emoji);
      this.iXq.hideVKB();
      requestLayout();
      AppMethodBeat.o(98653);
      return;
    }
    if (this.state == 0)
    {
      this.KQB.hZB();
      this.iXq.showVKB();
      this.jPN.setVisibility(8);
    }
    for (;;)
    {
      this.EOk = false;
      AppMethodBeat.o(98653);
      return;
      this.KQB.hZB();
      this.iXq.hideVKB();
      eQo();
    }
  }
  
  static abstract interface a
  {
    public abstract void fWh();
  }
  
  static abstract interface b
  {
    public abstract void ll(String paramString1, String paramString2);
  }
  
  static abstract interface c
  {
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter
 * JD-Core Version:    0.7.0.1
 */