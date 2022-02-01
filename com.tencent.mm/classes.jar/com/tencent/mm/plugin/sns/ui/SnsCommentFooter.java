package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import com.tencent.mm.api.aa;
import com.tencent.mm.api.aa.a;
import com.tencent.mm.api.z.a;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.List;

public class SnsCommentFooter
  extends InputPanelLinearLayout
{
  private Button fPz;
  ChatFooterPanel fSY;
  MMActivity imP;
  int state;
  private TextWatcher tqA;
  private ImageButton tqu;
  MMEditText tqv;
  private boolean tqw;
  public boolean tqx;
  private boolean tqy;
  boolean tqz;
  cuo wFh;
  private ImageView xye;
  private ImageView xyf;
  private Button xyg;
  int xyh;
  private int xyi;
  private int xyj;
  private int xyk;
  private String xyl;
  private b xym;
  boolean xyn;
  private boolean xyo;
  private boolean xyp;
  public boolean xyq;
  private String xyr;
  private boolean xyt;
  private a xyu;
  private c xyv;
  private bn xyw;
  
  public SnsCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98650);
    this.wFh = null;
    this.xyh = 0;
    this.state = 0;
    this.tqw = false;
    this.xyi = -1;
    this.xyj = -1;
    this.xyk = 0;
    this.xym = null;
    this.xyn = false;
    this.xyo = false;
    this.xyp = z.ip(getContext());
    this.tqx = false;
    this.tqy = true;
    this.xyr = "";
    this.xyt = false;
    this.tqz = true;
    this.tqA = new TextWatcher()
    {
      private int xyC = 0;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(98639);
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
        {
          AppMethodBeat.o(98639);
          return;
        }
        if ((com.tencent.mm.plugin.sns.ui.widget.e.hA(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!bt.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (SnsCommentFooter.b(SnsCommentFooter.this).getText() != null) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
        {
          ad.i("MicroMsg.SnsCommentFooter", "cur text %s", new Object[] { SnsCommentFooter.b(SnsCommentFooter.this).getText() });
          SnsCommentFooter.a(SnsCommentFooter.this, "");
          SnsCommentFooter.e(SnsCommentFooter.this);
          SnsCommentFooter.this.Ns(8);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
        SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (SnsCommentFooter.this.tqz))
          {
            SnsCommentFooter.a(SnsCommentFooter.this, true);
            SnsCommentFooter.this.tqz = false;
          }
          if (i == 0)
          {
            SnsCommentFooter.a(SnsCommentFooter.this, false);
            SnsCommentFooter.this.tqz = true;
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
          this.xyC = paramAnonymousInt1;
          AppMethodBeat.o(98637);
          return;
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98638);
        if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.wzN))
        {
          SnsCommentFooter.this.Ns(16);
          ad.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
          AppMethodBeat.o(98638);
          return;
        }
        if (paramAnonymousCharSequence.length() - this.xyC > a.wzN)
        {
          SnsCommentFooter.this.setCommentFlag(16);
          ad.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
        }
        AppMethodBeat.o(98638);
      }
    };
    this.imP = ((MMActivity)paramContext);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
    {
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psj, 0) == 1) {}
      for (bool = true;; bool = false)
      {
        this.xyn = bool;
        AppMethodBeat.o(98650);
        return;
      }
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psj, 0) == 1) {}
    for (;;)
    {
      this.xyn = bool;
      AppMethodBeat.o(98650);
      return;
      bool = false;
    }
  }
  
  private void btC()
  {
    AppMethodBeat.i(98654);
    this.fSY.onResume();
    if ((z.ip(getContext())) && (dBg())) {
      getInputPanelHelper().aJ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98635);
          SnsCommentFooter.a(SnsCommentFooter.this).setVisibility(0);
          AppMethodBeat.o(98635);
        }
      });
    }
    for (;;)
    {
      if (this.xyv != null) {
        this.xyv.onShow();
      }
      AppMethodBeat.o(98654);
      return;
      this.fSY.setVisibility(0);
    }
  }
  
  private void dBf()
  {
    AppMethodBeat.i(98666);
    int i = z.in(getContext());
    if (this.fSY != null)
    {
      this.fSY.setPortHeightPx(i);
      ViewGroup.LayoutParams localLayoutParams = this.fSY.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.height = i;
      }
    }
    AppMethodBeat.o(98666);
  }
  
  private boolean dBg()
  {
    AppMethodBeat.i(98667);
    int i = ai.eb(getContext());
    ad.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.xyj), Integer.valueOf(this.xyi), Integer.valueOf(i) });
    if ((this.xyj > 0) && (this.xyj < this.xyi - i))
    {
      AppMethodBeat.o(98667);
      return true;
    }
    AppMethodBeat.o(98667);
    return false;
  }
  
  private void mU(boolean paramBoolean)
  {
    AppMethodBeat.i(98670);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772095);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772100);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if ((this.fPz == null) || (this.xyg == null))
    {
      AppMethodBeat.o(98670);
      return;
    }
    if (paramBoolean)
    {
      if ((this.fPz.getVisibility() == 8) || (this.fPz.getVisibility() == 4))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.xyg.startAnimation(localAnimation1);
      this.xyg.setVisibility(0);
      this.fPz.startAnimation(localAnimation2);
      this.fPz.setVisibility(8);
    }
    for (;;)
    {
      this.xyg.getParent().requestLayout();
      AppMethodBeat.o(98670);
      return;
      if ((this.fPz.getVisibility() == 0) || (this.fPz.getVisibility() == 0))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.fPz.startAnimation(localAnimation1);
      this.fPz.setVisibility(0);
      this.xyg.startAnimation(localAnimation2);
      this.xyg.setVisibility(8);
    }
  }
  
  public final void Ns(int paramInt)
  {
    this.xyh &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final boolean dBb()
  {
    AppMethodBeat.i(98649);
    if ((this.tqv.getText() == null) || (bt.isNullOrNil(this.tqv.getText().toString())))
    {
      AppMethodBeat.o(98649);
      return true;
    }
    AppMethodBeat.o(98649);
    return false;
  }
  
  public final boolean dBc()
  {
    return this.state == 1;
  }
  
  public final void dBd()
  {
    AppMethodBeat.i(98655);
    if (this.tqv == null)
    {
      ad.e("MicroMsg.SnsCommentFooter", "send edittext is null");
      AppMethodBeat.o(98655);
      return;
    }
    this.tqv.removeTextChangedListener(this.tqA);
    this.tqv.addTextChangedListener(this.tqA);
    AppMethodBeat.o(98655);
  }
  
  public final void dBe()
  {
    AppMethodBeat.i(98660);
    this.tqv.setText("");
    this.tqv.setHint("");
    this.wFh = null;
    this.xyh = 0;
    this.state = 0;
    AppMethodBeat.o(98660);
  }
  
  public final void dBh()
  {
    AppMethodBeat.i(98669);
    this.xyw = null;
    if (this.fSY != null)
    {
      ad.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.fSY.exm();
      this.fSY.destroy();
    }
    AppMethodBeat.o(98669);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(98665);
    super.g(paramBoolean, paramInt);
    this.tqx = paramBoolean;
    if ((paramBoolean) && (getVisibility() == 0) && (this.xyw != null))
    {
      ad.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
      this.xyw.dCX();
    }
    if ((this.xyk != paramInt) && (paramInt != 0))
    {
      this.xyk = paramInt;
      i.A(getContext(), paramInt);
      dBf();
    }
    AppMethodBeat.o(98665);
  }
  
  public String getCommentAtPrefix()
  {
    return this.xyl;
  }
  
  public int getCommentFlag()
  {
    return this.xyh;
  }
  
  public cuo getCommentInfo()
  {
    AppMethodBeat.i(98661);
    if (this.wFh == null)
    {
      localcuo = new cuo();
      AppMethodBeat.o(98661);
      return localcuo;
    }
    cuo localcuo = this.wFh;
    AppMethodBeat.o(98661);
    return localcuo;
  }
  
  public final void o(final List<k> paramList, String paramString)
  {
    AppMethodBeat.i(98656);
    this.xyr = paramString;
    k localk;
    if (this.tqv != null)
    {
      if (bt.isNullOrNil(paramString)) {
        break label172;
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
    label172:
    for (paramString = bt.by(localk.text, "");; paramString = "")
    {
      if (!bt.isNullOrNil(paramString))
      {
        this.xyg.setVisibility(0);
        this.fPz.setVisibility(8);
        this.tqv.setText("");
        this.tqv.aMd(paramString);
      }
      for (;;)
      {
        if (!this.xyt) {
          this.tqv.addTextChangedListener(new TextWatcher()
          {
            int xyC = 0;
            
            public final void afterTextChanged(Editable paramAnonymousEditable)
            {
              AppMethodBeat.i(98642);
              if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
              {
                AppMethodBeat.o(98642);
                return;
              }
              if ((com.tencent.mm.plugin.sns.ui.widget.e.hA(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!bt.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (!bt.isNullOrNil(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString())) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
              {
                ad.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", new Object[] { SnsCommentFooter.d(SnsCommentFooter.this), SnsCommentFooter.b(SnsCommentFooter.this).getText() });
                SnsCommentFooter.a(SnsCommentFooter.this, "");
                SnsCommentFooter.e(SnsCommentFooter.this);
                SnsCommentFooter.this.Ns(8);
                SnsCommentFooter.a(SnsCommentFooter.this, 0);
              }
              ad.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.f(SnsCommentFooter.this));
              if (!bt.isNullOrNil(SnsCommentFooter.f(SnsCommentFooter.this)))
              {
                paramAnonymousEditable = paramList.iterator();
                while (paramAnonymousEditable.hasNext())
                {
                  k localk = (k)paramAnonymousEditable.next();
                  if (SnsCommentFooter.f(SnsCommentFooter.this).equals(localk.key))
                  {
                    ad.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                    localk.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                    localk.dtM = SnsCommentFooter.c(SnsCommentFooter.this);
                  }
                }
              }
              for (int i = 1;; i = 0)
              {
                if (i == 0)
                {
                  ad.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                  paramAnonymousEditable = new k();
                  paramAnonymousEditable.key = SnsCommentFooter.f(SnsCommentFooter.this);
                  paramAnonymousEditable.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                  paramAnonymousEditable.dtM = SnsCommentFooter.c(SnsCommentFooter.this);
                  if ((paramAnonymousEditable.text != null) && (paramAnonymousEditable.text.length() > 0)) {
                    paramList.add(paramAnonymousEditable);
                  }
                }
                if (paramList.size() > 5)
                {
                  ad.d("MicroMsg.SnsCommentFooter", "comments remove");
                  paramList.remove(0);
                }
                SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
                if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
                for (boolean bool = true;; bool = false)
                {
                  if ((bool) && (SnsCommentFooter.this.tqz))
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.tqz = false;
                  }
                  if (!bool)
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.tqz = true;
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
                this.xyC = paramAnonymousInt1;
                AppMethodBeat.o(98641);
                return;
              }
            }
            
            public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(98640);
              if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.wzN))
              {
                SnsCommentFooter.this.Ns(16);
                ad.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.o(98640);
                return;
              }
              if (paramAnonymousCharSequence.length() - this.xyC > a.wzN)
              {
                SnsCommentFooter.this.setCommentFlag(16);
                ad.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
              }
              AppMethodBeat.o(98640);
            }
          });
        }
        this.xyt = true;
        AppMethodBeat.o(98656);
        return;
        this.tqv.setText("");
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98664);
    super.onConfigurationChanged(paramConfiguration);
    if (this.fSY != null) {
      dBf();
    }
    AppMethodBeat.o(98664);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98668);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xyi < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.xyi)
    {
      this.xyi = paramInt1;
      this.xyj = paramInt4;
      AppMethodBeat.o(98668);
      return;
    }
  }
  
  public final void qn(boolean paramBoolean)
  {
    AppMethodBeat.i(98653);
    if (this.fSY == null)
    {
      AppMethodBeat.o(98653);
      return;
    }
    this.xyq = paramBoolean;
    ad.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      this.fSY.setVisibility(8);
      this.tqu.setImageResource(2131690564);
      this.imP.hideVKB();
      requestLayout();
      AppMethodBeat.o(98653);
      return;
    }
    if (this.state == 0)
    {
      this.tqv.requestFocus();
      this.imP.showVKB();
      this.fSY.setVisibility(8);
    }
    for (;;)
    {
      this.tqy = false;
      AppMethodBeat.o(98653);
      return;
      this.tqv.requestFocus();
      this.imP.hideVKB();
      btC();
    }
  }
  
  public final void qo(boolean paramBoolean)
  {
    AppMethodBeat.i(98659);
    if (this.xye != null)
    {
      if (paramBoolean)
      {
        this.xye.setVisibility(0);
        if ((com.tencent.mm.m.g.Zd().getInt("SnsAdAtFriendRedDot", 0) == 1) && (com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FuL, true)))
        {
          this.xyf.setVisibility(0);
          AppMethodBeat.o(98659);
          return;
        }
        this.xyf.setVisibility(8);
        AppMethodBeat.o(98659);
        return;
      }
      this.xye.setVisibility(8);
      this.xyf.setVisibility(8);
    }
    AppMethodBeat.o(98659);
  }
  
  public void setAfterEditAction(Runnable paramRunnable)
  {
    AppMethodBeat.i(98651);
    paramRunnable = (ViewGroup)inflate(this.imP, 2131495541, this);
    this.xye = ((ImageView)paramRunnable.findViewById(2131296545));
    this.xyf = ((ImageView)paramRunnable.findViewById(2131296546));
    this.fPz = ((Button)paramRunnable.findViewById(2131296560));
    this.xyg = ((Button)paramRunnable.findViewById(2131296553));
    this.tqv = ((MMEditText)paramRunnable.findViewById(2131296549));
    mU(false);
    this.xye.setOnClickListener(new SnsCommentFooter.7(this));
    this.tqu = ((ImageButton)paramRunnable.findViewById(2131296558));
    this.tqu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98644);
        SnsCommentFooter.this.setModeClick(true);
        ad.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.i(SnsCommentFooter.this));
        if (SnsCommentFooter.i(SnsCommentFooter.this) == 0)
        {
          SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
          SnsCommentFooter.this.imP.hideVKB();
          SnsCommentFooter.a(SnsCommentFooter.this, 1);
          SnsCommentFooter.j(SnsCommentFooter.this);
          SnsCommentFooter.this.setToSendTextColor(false);
          SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131231706);
          SnsCommentFooter.l(SnsCommentFooter.this);
          AppMethodBeat.o(98644);
          return;
        }
        SnsCommentFooter.m(SnsCommentFooter.this);
        SnsCommentFooter.l(SnsCommentFooter.this);
        SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
        SnsCommentFooter.this.imP.showVKB();
        SnsCommentFooter.this.setToSendTextColor(true);
        SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690564);
        SnsCommentFooter.a(SnsCommentFooter.this, 0);
        AppMethodBeat.o(98644);
      }
    });
    this.tqv.setHint(this.imP.getString(2131764046));
    this.tqv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(98645);
        SnsCommentFooter.this.setToSendTextColor(true);
        SnsCommentFooter.l(SnsCommentFooter.this);
        SnsCommentFooter.m(SnsCommentFooter.this);
        SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690564);
        if (SnsCommentFooter.n(SnsCommentFooter.this) != null) {
          SnsCommentFooter.n(SnsCommentFooter.this).dBa();
        }
        SnsCommentFooter.a(SnsCommentFooter.this, 0);
        AppMethodBeat.o(98645);
        return false;
      }
    });
    if (com.tencent.mm.pluginsdk.ui.chat.e.Cgj == null)
    {
      this.fSY = new d(this.imP);
      AppMethodBeat.o(98651);
      return;
    }
    this.fSY = com.tencent.mm.pluginsdk.ui.chat.e.Cgj.es(getContext());
    this.fSY.setEntranceScene(ChatFooterPanel.BUY);
    this.fSY.setVisibility(8);
    paramRunnable = (LinearLayout)findViewById(2131304239);
    this.xyk = z.in(getContext());
    paramRunnable.addView(this.fSY, -1, this.xyk);
    if (!this.xyn) {
      this.fSY.exn();
    }
    this.fSY.onResume();
    this.fSY.setOnTextOperationListener(new SnsCommentFooter.10(this));
    paramRunnable = aa.cJM.Kg();
    paramRunnable.cJL = new z.a()
    {
      public final void a(final com.tencent.mm.api.p paramAnonymousp)
      {
        AppMethodBeat.i(98631);
        if ((paramAnonymousp instanceof EmojiInfo))
        {
          boolean bool = false;
          String str;
          if ((SnsCommentFooter.o(SnsCommentFooter.this) != null) && (!bt.isNullOrNil(SnsCommentFooter.o(SnsCommentFooter.this).Username)))
          {
            str = SnsCommentFooter.o(SnsCommentFooter.this).Username;
            bool = true;
          }
          while (!SnsCommentFooter.p(SnsCommentFooter.this))
          {
            AppMethodBeat.o(98631);
            return;
            if ((SnsCommentFooter.this.getTag() != null) && ((SnsCommentFooter.this.getTag() instanceof com.tencent.mm.plugin.sns.storage.p)))
            {
              str = ((com.tencent.mm.plugin.sns.storage.p)SnsCommentFooter.this.getTag()).field_userName;
            }
            else
            {
              AppMethodBeat.o(98631);
              return;
            }
          }
          a.hYt.a(SnsCommentFooter.h(SnsCommentFooter.this), str, ((EmojiInfo)paramAnonymousp).field_md5, bool, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(98630);
              if ((SnsCommentFooter.q(SnsCommentFooter.this) != null) && (paramAnonymous2Boolean)) {
                if (!com.tencent.mm.plugin.sns.ui.widget.e.hA(SnsCommentFooter.c(SnsCommentFooter.this), 8)) {
                  break label94;
                }
              }
              label94:
              for (paramAnonymous2String = SnsCommentFooter.this.getCommentAtPrefix();; paramAnonymous2String = "")
              {
                SnsCommentFooter.q(SnsCommentFooter.this).jj(paramAnonymous2String, ((EmojiInfo)paramAnonymousp).field_md5);
                com.tencent.mm.plugin.report.service.h.vKh.dB(150, 81);
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
    this.fSY.setCallback(paramRunnable);
    AppMethodBeat.o(98651);
  }
  
  public void setAnitiomAdjust(bn parambn)
  {
    this.xyw = parambn;
  }
  
  public void setCommentAtPrefix(String paramString)
  {
    this.xyl = paramString;
  }
  
  public void setCommentFlag(int paramInt)
  {
    this.xyh |= paramInt;
  }
  
  public void setCommentHint(String paramString)
  {
    AppMethodBeat.i(98658);
    if (!bt.isNullOrNil(paramString))
    {
      if (com.tencent.mm.plugin.sns.ui.widget.e.hA(this.xyh, 1))
      {
        this.tqv.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.imP.getString(2131763743) + paramString + this.imP.getString(2131763775, new Object[] { Float.valueOf(this.tqv.getTextSize()) }), this.tqv.getTextSize()));
        AppMethodBeat.o(98658);
        return;
      }
      this.tqv.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), paramString, this.tqv.getTextSize()));
      AppMethodBeat.o(98658);
      return;
    }
    this.tqv.setHint("");
    AppMethodBeat.o(98658);
  }
  
  public void setCommentInfo(cuo paramcuo)
  {
    this.wFh = paramcuo;
  }
  
  public void setFeedEmojiCommentEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(176296);
    this.xyo = paramBoolean;
    ad.i("MicroMsg.SnsCommentFooter", "setFeedEmojiCommentEnable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(176296);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.tqw = paramBoolean;
  }
  
  public void setOnCommentSendImp(final b paramb)
  {
    AppMethodBeat.i(98663);
    this.xym = paramb;
    this.xyg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98634);
        paramAnonymousView = c.d(SnsCommentFooter.b(SnsCommentFooter.this)).aaj(com.tencent.mm.m.b.YF());
        paramAnonymousView.HuM = true;
        paramAnonymousView.a(new c.a()
        {
          public final void CH(String paramAnonymous2String)
          {
            AppMethodBeat.i(98632);
            SnsCommentFooter.2.this.xyA.jj(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString(), "");
            SnsCommentFooter.b(SnsCommentFooter.this).setText("");
            AppMethodBeat.o(98632);
          }
          
          public final void aKr() {}
          
          public final void ck(String paramAnonymous2String)
          {
            AppMethodBeat.i(163118);
            com.tencent.mm.ui.base.h.j(SnsCommentFooter.h(SnsCommentFooter.this), 2131764058, 2131764059);
            AppMethodBeat.o(163118);
          }
        });
        AppMethodBeat.o(98634);
      }
    });
    AppMethodBeat.o(98663);
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.xyu = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.xyv = paramc;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98657);
    if (this.tqv != null)
    {
      this.tqv.setText("");
      this.tqv.aMd(paramString);
    }
    AppMethodBeat.o(98657);
  }
  
  public void setToSendTextColor(boolean paramBoolean)
  {
    AppMethodBeat.i(98662);
    if (this.tqv == null)
    {
      AppMethodBeat.o(98662);
      return;
    }
    if (paramBoolean)
    {
      this.tqv.setTextColor(getResources().getColor(2131100636));
      AppMethodBeat.o(98662);
      return;
    }
    this.tqv.setTextColor(getResources().getColor(2131100482));
    ad.i("MicroMsg.SnsCommentFooter", "focusEdt: %s, %s", new Object[] { Boolean.FALSE, this.tqv });
    if (this.tqv != null) {
      this.tqv.clearFocus();
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
    qn(bool);
    super.setVisibility(paramInt);
    AppMethodBeat.o(98652);
  }
  
  static abstract interface a
  {
    public abstract void dBa();
  }
  
  static abstract interface b
  {
    public abstract void jj(String paramString1, String paramString2);
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