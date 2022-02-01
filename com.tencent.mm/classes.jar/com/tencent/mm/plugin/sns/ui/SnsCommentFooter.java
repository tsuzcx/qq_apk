package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ae;
import com.tencent.mm.api.ae.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.g;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import java.util.Iterator;
import java.util.List;

public class SnsCommentFooter
  extends InputPanelLinearLayout
{
  public static String opP;
  private ImageButton KIF;
  private boolean KIH;
  public boolean KII;
  private boolean KIJ;
  boolean KIK;
  private TextWatcher KIL;
  private SnsInfo PJQ;
  fdv Qsv;
  boolean RqA;
  private boolean RqB;
  private boolean RqC;
  public boolean RqD;
  private String RqE;
  private boolean RqF;
  private a RqG;
  private c RqH;
  private bx RqI;
  com.tencent.mm.ui.widget.cedit.api.c Rqt;
  private ImageView Rqu;
  private ImageView Rqv;
  private Button Rqw;
  int Rqx;
  private String Rqy;
  private SnsCommentFooter.b Rqz;
  MMActivity lzt;
  private Button mkz;
  ChatFooterPanel moD;
  private int moG;
  private int moH;
  private int moI;
  int state;
  
  static
  {
    AppMethodBeat.i(307736);
    opP = com.tencent.mm.plugin.fts.a.d.We(79);
    AppMethodBeat.o(307736);
  }
  
  public SnsCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98650);
    this.Qsv = null;
    this.Rqx = 0;
    this.state = 0;
    this.KIH = false;
    this.moG = -1;
    this.moH = -1;
    this.moI = 0;
    this.Rqz = null;
    this.RqA = false;
    this.RqB = false;
    this.RqC = KeyBoardUtil.isPortOrientation(getContext());
    this.KII = false;
    this.KIJ = true;
    this.RqE = "";
    this.RqF = false;
    this.KIK = true;
    this.KIL = new TextWatcher()
    {
      private int RqQ = 0;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(98639);
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
        {
          AppMethodBeat.o(98639);
          return;
        }
        if ((g.lU(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!Util.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (SnsCommentFooter.b(SnsCommentFooter.this).getText() != null) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
        {
          Log.i("MicroMsg.SnsCommentFooter", "cur text %s", new Object[] { SnsCommentFooter.b(SnsCommentFooter.this).getText() });
          SnsCommentFooter.a(SnsCommentFooter.this, "");
          SnsCommentFooter.e(SnsCommentFooter.this);
          SnsCommentFooter.this.alZ(8);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
        SnsCommentFooter.b(SnsCommentFooter.this).jEJ();
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (SnsCommentFooter.this.KIK))
          {
            SnsCommentFooter.a(SnsCommentFooter.this, true);
            SnsCommentFooter.this.KIK = false;
          }
          if (i == 0)
          {
            SnsCommentFooter.a(SnsCommentFooter.this, false);
            SnsCommentFooter.this.KIK = true;
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
          this.RqQ = paramAnonymousInt1;
          AppMethodBeat.o(98637);
          return;
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98638);
        if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.d.a.Qkq))
        {
          SnsCommentFooter.this.alZ(16);
          Log.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
          AppMethodBeat.o(98638);
          return;
        }
        if (paramAnonymousCharSequence.length() - this.RqQ > com.tencent.mm.plugin.sns.d.a.Qkq)
        {
          SnsCommentFooter.this.setCommentFlag(16);
          Log.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
        }
        AppMethodBeat.o(98638);
      }
    };
    this.lzt = ((MMActivity)paramContext);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
    {
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfb, 0) == 1) {}
      for (bool = true;; bool = false)
      {
        this.RqA = bool;
        AppMethodBeat.o(98650);
        return;
      }
    }
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfb, 0) == 1) {}
    for (;;)
    {
      this.RqA = bool;
      AppMethodBeat.o(98650);
      return;
      bool = false;
    }
  }
  
  public static void a(Context paramContext, Object paramObject, boolean paramBoolean, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(307682);
    if (!(paramObject instanceof SnsInfo))
    {
      AppMethodBeat.o(307682);
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
      str = t.uA(paramObject.field_snsId);
      if (!paramObject.isAd()) {
        break label130;
      }
      j = 2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.websearch.b.b.a(k, i, paramContext, str, j, String.valueOf(paramString1), opP, paramInt, paramString2, paramLong);
      AppMethodBeat.o(307682);
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
  
  private void aWK()
  {
    AppMethodBeat.i(98666);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    Log.i("MicroMsg.SnsCommentFooter", "refreshBottomPanelHeight: %s", new Object[] { Integer.valueOf(i) });
    if (this.moD != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.moD.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = i;
        this.moD.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(98666);
  }
  
  private void fYY()
  {
    AppMethodBeat.i(98654);
    this.moD.onResume();
    if ((KeyBoardUtil.isPortOrientation(getContext())) && (hoA())) {
      getInputPanelHelper().bf(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98635);
          Log.i("MicroMsg.SnsCommentFooter", "showSmileyPanel in run");
          SnsCommentFooter.a(SnsCommentFooter.this).setVisibility(0);
          SnsCommentFooter.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(307884);
              if (SnsCommentFooter.this.getHeight() < SnsCommentFooter.a(SnsCommentFooter.this).getHeight()) {
                SnsCommentFooter.this.requestLayout();
              }
              AppMethodBeat.o(307884);
            }
          });
          AppMethodBeat.o(98635);
        }
      });
    }
    for (;;)
    {
      if (this.RqH != null) {
        this.RqH.onShow();
      }
      AppMethodBeat.o(98654);
      return;
      Log.i("MicroMsg.SnsCommentFooter", "showSmileyPanel");
      this.moD.setVisibility(0);
    }
  }
  
  private boolean hoA()
  {
    AppMethodBeat.i(98667);
    int i = aw.bk(getContext());
    Log.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.moH), Integer.valueOf(this.moG), Integer.valueOf(i) });
    if ((this.moH > 0) && (this.moH < this.moG - i))
    {
      AppMethodBeat.o(98667);
      return true;
    }
    AppMethodBeat.o(98667);
    return false;
  }
  
  private void yk(boolean paramBoolean)
  {
    AppMethodBeat.i(98670);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), b.a.pop_in);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), b.a.pop_out);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if ((this.mkz == null) || (this.Rqw == null))
    {
      AppMethodBeat.o(98670);
      return;
    }
    if (paramBoolean)
    {
      if ((this.mkz.getVisibility() == 8) || (this.mkz.getVisibility() == 4))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.Rqw.startAnimation(localAnimation1);
      this.Rqw.setVisibility(0);
      this.mkz.startAnimation(localAnimation2);
      this.mkz.setVisibility(8);
    }
    for (;;)
    {
      this.Rqw.getParent().requestLayout();
      AppMethodBeat.o(98670);
      return;
      if ((this.mkz.getVisibility() == 0) || (this.mkz.getVisibility() == 0))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.mkz.startAnimation(localAnimation1);
      this.mkz.setVisibility(0);
      this.Rqw.startAnimation(localAnimation2);
      this.Rqw.setVisibility(8);
    }
  }
  
  public final void E(final List<k> paramList, String paramString)
  {
    AppMethodBeat.i(98656);
    this.RqE = paramString;
    k localk;
    if (this.Rqt != null)
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
        this.Rqw.setVisibility(0);
        this.mkz.setVisibility(8);
        this.Rqt.setText("");
        this.Rqt.bDt(paramString);
      }
      for (;;)
      {
        if (!this.RqF) {
          this.Rqt.addTextChangedListener(new TextWatcher()
          {
            int RqQ = 0;
            
            public final void afterTextChanged(Editable paramAnonymousEditable)
            {
              AppMethodBeat.i(98642);
              if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
              {
                AppMethodBeat.o(98642);
                return;
              }
              if ((g.lU(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!Util.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (!Util.isNullOrNil(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString())) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
              {
                Log.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", new Object[] { SnsCommentFooter.d(SnsCommentFooter.this), SnsCommentFooter.b(SnsCommentFooter.this).getText() });
                SnsCommentFooter.a(SnsCommentFooter.this, "");
                SnsCommentFooter.e(SnsCommentFooter.this);
                SnsCommentFooter.this.alZ(8);
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
                    localk.eQp = SnsCommentFooter.c(SnsCommentFooter.this);
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
                  paramAnonymousEditable.eQp = SnsCommentFooter.c(SnsCommentFooter.this);
                  if ((paramAnonymousEditable.text != null) && (paramAnonymousEditable.text.length() > 0)) {
                    paramList.add(paramAnonymousEditable);
                  }
                }
                if (paramList.size() > 5)
                {
                  Log.d("MicroMsg.SnsCommentFooter", "comments remove");
                  paramList.remove(0);
                }
                SnsCommentFooter.b(SnsCommentFooter.this).jEJ();
                if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
                for (boolean bool = true;; bool = false)
                {
                  if ((bool) && (SnsCommentFooter.this.KIK))
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.KIK = false;
                  }
                  if (!bool)
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.KIK = true;
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
                this.RqQ = paramAnonymousInt1;
                AppMethodBeat.o(98641);
                return;
              }
            }
            
            public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(98640);
              if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.d.a.Qkq))
              {
                SnsCommentFooter.this.alZ(16);
                Log.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.o(98640);
                return;
              }
              if (paramAnonymousCharSequence.length() - this.RqQ > com.tencent.mm.plugin.sns.d.a.Qkq)
              {
                SnsCommentFooter.this.setCommentFlag(16);
                Log.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
              }
              AppMethodBeat.o(98640);
            }
          });
        }
        this.RqF = true;
        AppMethodBeat.o(98656);
        return;
        this.Rqt.setText("");
      }
    }
  }
  
  public final void alZ(int paramInt)
  {
    this.Rqx &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final void evh()
  {
    AppMethodBeat.i(307761);
    ((InputMethodManager)this.lzt.getSystemService("input_method")).showSoftInput(this.Rqt.jEG(), 0);
    AppMethodBeat.o(307761);
  }
  
  public String getCommentAtPrefix()
  {
    return this.Rqy;
  }
  
  public int getCommentFlag()
  {
    return this.Rqx;
  }
  
  public fdv getCommentInfo()
  {
    AppMethodBeat.i(98661);
    if (this.Qsv == null)
    {
      localfdv = new fdv();
      AppMethodBeat.o(98661);
      return localfdv;
    }
    fdv localfdv = this.Qsv;
    AppMethodBeat.o(98661);
    return localfdv;
  }
  
  public final void hoB()
  {
    AppMethodBeat.i(98669);
    this.RqI = null;
    if (this.moD != null)
    {
      Log.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.moD.iKg();
      this.moD.destroy();
    }
    if (this.Rqt != null) {
      this.Rqt.destroy();
    }
    AppMethodBeat.o(98669);
  }
  
  public final boolean how()
  {
    AppMethodBeat.i(98649);
    if ((this.Rqt.getText() == null) || (Util.isNullOrNil(this.Rqt.getText().toString())))
    {
      AppMethodBeat.o(98649);
      return true;
    }
    AppMethodBeat.o(98649);
    return false;
  }
  
  public final boolean hox()
  {
    return this.state == 1;
  }
  
  public final void hoy()
  {
    AppMethodBeat.i(98655);
    if (this.Rqt == null)
    {
      Log.e("MicroMsg.SnsCommentFooter", "send edittext is null");
      AppMethodBeat.o(98655);
      return;
    }
    this.Rqt.removeTextChangedListener(this.KIL);
    this.Rqt.addTextChangedListener(this.KIL);
    AppMethodBeat.o(98655);
  }
  
  public final void hoz()
  {
    AppMethodBeat.i(98660);
    this.Rqt.setText("");
    this.Rqt.setHint("");
    this.Qsv = null;
    this.Rqx = 0;
    this.state = 0;
    AppMethodBeat.o(98660);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98664);
    super.onConfigurationChanged(paramConfiguration);
    if (this.moD != null) {
      aWK();
    }
    AppMethodBeat.o(98664);
  }
  
  public void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(98665);
    super.onInputPanelChange(paramBoolean, paramInt);
    this.KII = paramBoolean;
    if ((paramBoolean) && (getVisibility() == 0) && (this.RqI != null))
    {
      Log.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
      this.RqI.hqE();
    }
    this.Rqt.Ni(paramBoolean);
    if ((this.moI != paramInt) && (paramInt != 0))
    {
      this.moI = paramInt;
      j.H(getContext(), paramInt);
      aWK();
    }
    AppMethodBeat.o(98665);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98668);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.moG < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.moG)
    {
      this.moG = paramInt1;
      this.moH = paramInt4;
      AppMethodBeat.o(98668);
      return;
    }
  }
  
  public void setAfterEditAction(Runnable paramRunnable)
  {
    AppMethodBeat.i(98651);
    paramRunnable = (ViewGroup)inflate(this.lzt, b.g.sns_comment_footer, this);
    this.Rqu = ((ImageView)paramRunnable.findViewById(b.f.album_comment_at_btn));
    this.Rqv = ((ImageView)paramRunnable.findViewById(b.f.album_comment_at_reddot));
    this.mkz = ((Button)paramRunnable.findViewById(b.f.album_comment_send_btn));
    this.Rqw = ((Button)paramRunnable.findViewById(b.f.album_comment_green_send_btn));
    this.Rqt = ((com.tencent.mm.ui.widget.cedit.api.c)paramRunnable.findViewById(b.f.album_comment_content_et));
    this.Rqt.refresh(((PluginWebSearch)h.az(PluginWebSearch.class)).isUseSysEditText());
    this.Rqt.getInputExtras(true).putBoolean("if_support_wx_emoji", true);
    this.Rqt.addTextChangedListener(new SnsCommentFooter.9(this));
    SnsCommentFooter.3 local3 = new SnsCommentFooter.3(this);
    this.Rqt.a(((com.tencent.mm.plugin.websearch.api.c)h.az(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)h.az(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(this.lzt), local3);
    this.Rqt.addTextChangedListener(new SnsCommentFooter.4(this));
    yk(false);
    this.Rqu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98644);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (i.aRC().getInt("SnsAdAtFriendRedDot", 0) == 1) {
          h.baE().ban().set(at.a.acYr, Boolean.FALSE);
        }
        SnsCommentFooter.h(SnsCommentFooter.this).setVisibility(8);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("list_attr", 16391);
        paramAnonymousView.putExtra("block_contact", z.bAM());
        paramAnonymousView.putExtra("max_limit_num", 1);
        paramAnonymousView.putExtra("titile", SnsCommentFooter.j(SnsCommentFooter.this).getString(b.j.sns_ad_comment_at_title));
        com.tencent.mm.br.c.d(SnsCommentFooter.j(SnsCommentFooter.this), ".ui.contact.SelectContactUI", paramAnonymousView, 2333);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98644);
      }
    });
    this.KIF = ((ImageButton)paramRunnable.findViewById(b.f.album_comment_mode_iv));
    this.KIF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(369912);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        SnsCommentFooter.this.setModeClick(true);
        Log.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.i(SnsCommentFooter.this));
        if (SnsCommentFooter.i(SnsCommentFooter.this) == 0)
        {
          SnsCommentFooter.b(SnsCommentFooter.this).jEJ();
          SnsCommentFooter.this.lzt.hideVKB();
          SnsCommentFooter.a(SnsCommentFooter.this, 1);
          SnsCommentFooter.k(SnsCommentFooter.this);
          SnsCommentFooter.this.setToSendTextColor(false);
          SnsCommentFooter.l(SnsCommentFooter.this).setImageResource(b.e.chatting_setmode_keyboard_btn);
          SnsCommentFooter.l(SnsCommentFooter.this).setContentDescription(SnsCommentFooter.this.getContext().getString(b.j.ime_setting_keyboard_type));
          SnsCommentFooter.m(SnsCommentFooter.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(369912);
          return;
          SnsCommentFooter.n(SnsCommentFooter.this);
          SnsCommentFooter.m(SnsCommentFooter.this);
          SnsCommentFooter.b(SnsCommentFooter.this).jEJ();
          SnsCommentFooter.this.evh();
          SnsCommentFooter.this.setToSendTextColor(true);
          SnsCommentFooter.l(SnsCommentFooter.this).setImageResource(b.i.icons_outlined_emoji);
          SnsCommentFooter.l(SnsCommentFooter.this).setContentDescription(SnsCommentFooter.this.getContext().getString(b.j.chat_footer_smiley_btn));
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
      }
    });
    this.Rqt.setHint(this.lzt.getString(b.j.sns_ui_comment));
    paramRunnable = new SnsCommentFooter.12(this);
    this.Rqt.setOnTouchListener(paramRunnable);
    if (e.Ykf == null)
    {
      this.moD = new com.tencent.mm.pluginsdk.ui.chat.d(this.lzt);
      AppMethodBeat.o(98651);
      return;
    }
    this.moD = e.Ykf.fZ(getContext());
    this.moD.setEntranceScene(ChatFooterPanel.XYq);
    this.moD.setVisibility(8);
    paramRunnable = (LinearLayout)findViewById(b.f.root);
    this.moI = KeyBoardUtil.getValidPanelHeight(getContext());
    paramRunnable.addView(this.moD, -1, this.moI);
    Log.i("MicroMsg.SnsCommentFooter", "init: height %s", new Object[] { Integer.valueOf(this.moI) });
    if (!this.RqA) {
      this.moD.iKh();
    }
    this.moD.onResume();
    this.moD.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aWL() {}
      
      public final void aWM()
      {
        AppMethodBeat.i(369947);
        if (SnsCommentFooter.b(SnsCommentFooter.this) != null)
        {
          if (SnsCommentFooter.b(SnsCommentFooter.this).getInputConnection() == null)
          {
            AppMethodBeat.o(369947);
            return;
          }
          SnsCommentFooter.b(SnsCommentFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
          SnsCommentFooter.b(SnsCommentFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        }
        AppMethodBeat.o(369947);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(369948);
        try
        {
          SnsCommentFooter.b(SnsCommentFooter.this).bDt(paramAnonymousString);
          AppMethodBeat.o(369948);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.SnsCommentFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(369948);
        }
      }
      
      public final void fp(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(369946);
        SnsCommentFooter.this.setToSendTextColor(paramAnonymousBoolean);
        AppMethodBeat.o(369946);
      }
    });
    paramRunnable = ae.hek.aBK();
    paramRunnable.hej = new SnsCommentFooter.2(this);
    this.moD.setCallback(paramRunnable);
    AppMethodBeat.o(98651);
  }
  
  public void setAnitiomAdjust(bx parambx)
  {
    this.RqI = parambx;
  }
  
  public void setCommentAtPrefix(String paramString)
  {
    this.Rqy = paramString;
  }
  
  public void setCommentFlag(int paramInt)
  {
    this.Rqx |= paramInt;
  }
  
  public void setCommentHint(String paramString)
  {
    AppMethodBeat.i(98658);
    if (!Util.isNullOrNil(paramString))
    {
      if (g.lU(this.Rqx, 1))
      {
        this.Rqt.setHint(p.b(getContext(), this.lzt.getString(b.j.sns_ad_at_tips1) + paramString + this.lzt.getString(b.j.sns_after_reply, new Object[] { Float.valueOf(this.Rqt.getTextSize()) }), this.Rqt.getTextSize()));
        AppMethodBeat.o(98658);
        return;
      }
      this.Rqt.setHint(p.b(getContext(), paramString, this.Rqt.getTextSize()));
      AppMethodBeat.o(98658);
      return;
    }
    this.Rqt.setHint("");
    AppMethodBeat.o(98658);
  }
  
  public void setCommentInfo(fdv paramfdv)
  {
    this.Qsv = paramfdv;
  }
  
  public void setFeedEmojiCommentEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(176296);
    this.RqB = paramBoolean;
    Log.i("MicroMsg.SnsCommentFooter", "setFeedEmojiCommentEnable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(176296);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.KIH = paramBoolean;
  }
  
  public void setOnCommentSendImp(SnsCommentFooter.b paramb)
  {
    AppMethodBeat.i(98663);
    this.Rqz = paramb;
    this.Rqw.setOnClickListener(new SnsCommentFooter.13(this, paramb));
    AppMethodBeat.o(98663);
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.RqG = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.RqH = paramc;
  }
  
  public void setSnsInfo(SnsInfo paramSnsInfo)
  {
    this.PJQ = paramSnsInfo;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98657);
    if (this.Rqt != null)
    {
      this.Rqt.setText("");
      this.Rqt.bDt(paramString);
    }
    AppMethodBeat.o(98657);
  }
  
  public void setToSendTextColor(boolean paramBoolean)
  {
    AppMethodBeat.i(98662);
    if (this.Rqt == null)
    {
      AppMethodBeat.o(98662);
      return;
    }
    if (paramBoolean)
    {
      this.Rqt.setTextColor(getResources().getColor(b.c.mm_edit_text_color));
      AppMethodBeat.o(98662);
      return;
    }
    this.Rqt.setTextColor(getResources().getColor(b.c.half_alpha_black));
    Log.i("MicroMsg.SnsCommentFooter", "focusEdt: %s, %s", new Object[] { Boolean.FALSE, this.Rqt });
    if (this.Rqt != null) {
      this.Rqt.clearFocus();
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
    wh(bool);
    super.setVisibility(paramInt);
    AppMethodBeat.o(98652);
  }
  
  public final void uW(boolean paramBoolean)
  {
    AppMethodBeat.i(98659);
    if (this.Rqu != null)
    {
      if (paramBoolean)
      {
        this.Rqu.setVisibility(0);
        if ((i.aRC().getInt("SnsAdAtFriendRedDot", 0) == 1) && (h.baE().ban().getBoolean(at.a.acYr, true)))
        {
          this.Rqv.setVisibility(0);
          AppMethodBeat.o(98659);
          return;
        }
        this.Rqv.setVisibility(8);
        AppMethodBeat.o(98659);
        return;
      }
      this.Rqu.setVisibility(8);
      this.Rqv.setVisibility(8);
    }
    AppMethodBeat.o(98659);
  }
  
  public final void wh(boolean paramBoolean)
  {
    AppMethodBeat.i(98653);
    if (this.moD == null)
    {
      AppMethodBeat.o(98653);
      return;
    }
    this.RqD = paramBoolean;
    Log.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      this.moD.setVisibility(8);
      this.KIF.setImageResource(b.i.icons_outlined_emoji);
      this.lzt.hideVKB();
      requestLayout();
      AppMethodBeat.o(98653);
      return;
    }
    if (this.state == 0)
    {
      this.Rqt.jEJ();
      evh();
      this.moD.setVisibility(8);
    }
    for (;;)
    {
      this.KIJ = false;
      AppMethodBeat.o(98653);
      return;
      this.Rqt.jEJ();
      this.lzt.hideVKB();
      fYY();
    }
  }
  
  static abstract interface a
  {
    public abstract void hov();
  }
  
  static abstract interface c
  {
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter
 * JD-Core Version:    0.7.0.1
 */