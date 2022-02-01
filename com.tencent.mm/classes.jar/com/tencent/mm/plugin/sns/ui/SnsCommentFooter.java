package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.aa.a;
import com.tencent.mm.api.z.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.List;

public class SnsCommentFooter
  extends InputPanelLinearLayout
{
  private boolean AcA;
  public boolean AcB;
  private String AcC;
  private boolean AcD;
  private a AcE;
  private c AcF;
  private bq AcG;
  private ImageView Acp;
  private ImageView Acq;
  private Button Acr;
  int Acs;
  private int Act;
  private int Acu;
  private int Acv;
  private String Acw;
  private b Acx;
  boolean Acy;
  private boolean Acz;
  MMActivity fLP;
  private Button gmY;
  ChatFooterPanel pWJ;
  int state;
  private ImageButton vBo;
  MMEditText vBp;
  private boolean vBq;
  public boolean vBr;
  private boolean vBs;
  boolean vBt;
  private TextWatcher vBu;
  dfn zhw;
  
  public SnsCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98650);
    this.zhw = null;
    this.Acs = 0;
    this.state = 0;
    this.vBq = false;
    this.Act = -1;
    this.Acu = -1;
    this.Acv = 0;
    this.Acx = null;
    this.Acy = false;
    this.Acz = false;
    this.AcA = z.iK(getContext());
    this.vBr = false;
    this.vBs = true;
    this.AcC = "";
    this.AcD = false;
    this.vBt = true;
    this.vBu = new TextWatcher()
    {
      private int AcM = 0;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(98639);
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
        {
          AppMethodBeat.o(98639);
          return;
        }
        if ((com.tencent.mm.plugin.sns.ui.widget.e.ia(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!bt.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (SnsCommentFooter.b(SnsCommentFooter.this).getText() != null) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
        {
          ad.i("MicroMsg.SnsCommentFooter", "cur text %s", new Object[] { SnsCommentFooter.b(SnsCommentFooter.this).getText() });
          SnsCommentFooter.a(SnsCommentFooter.this, "");
          SnsCommentFooter.e(SnsCommentFooter.this);
          SnsCommentFooter.this.Rf(8);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
        SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (SnsCommentFooter.this.vBt))
          {
            SnsCommentFooter.a(SnsCommentFooter.this, true);
            SnsCommentFooter.this.vBt = false;
          }
          if (i == 0)
          {
            SnsCommentFooter.a(SnsCommentFooter.this, false);
            SnsCommentFooter.this.vBt = true;
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
          this.AcM = paramAnonymousInt1;
          AppMethodBeat.o(98637);
          return;
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98638);
        if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.c.a.zbZ))
        {
          SnsCommentFooter.this.Rf(16);
          ad.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
          AppMethodBeat.o(98638);
          return;
        }
        if (paramAnonymousCharSequence.length() - this.AcM > com.tencent.mm.plugin.sns.c.a.zbZ)
        {
          SnsCommentFooter.this.setCommentFlag(16);
          ad.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
        }
        AppMethodBeat.o(98638);
      }
    };
    this.fLP = ((MMActivity)paramContext);
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.DEBUG))
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBi, 0) == 1) {}
      for (bool = true;; bool = false)
      {
        this.Acy = bool;
        AppMethodBeat.o(98650);
        return;
      }
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBi, 0) == 1) {}
    for (;;)
    {
      this.Acy = bool;
      AppMethodBeat.o(98650);
      return;
      bool = false;
    }
  }
  
  private void bEE()
  {
    AppMethodBeat.i(98654);
    this.pWJ.onResume();
    if ((z.iK(getContext())) && (ebU())) {
      getInputPanelHelper().aL(new Runnable()
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
      if (this.AcF != null) {
        this.AcF.onShow();
      }
      AppMethodBeat.o(98654);
      return;
      this.pWJ.setVisibility(0);
    }
  }
  
  private void ebT()
  {
    AppMethodBeat.i(98666);
    int i = z.iI(getContext());
    if (this.pWJ != null)
    {
      this.pWJ.setPortHeightPx(i);
      ViewGroup.LayoutParams localLayoutParams = this.pWJ.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.height = i;
      }
    }
    AppMethodBeat.o(98666);
  }
  
  private boolean ebU()
  {
    AppMethodBeat.i(98667);
    int i = al.ej(getContext());
    ad.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.Acu), Integer.valueOf(this.Act), Integer.valueOf(i) });
    if ((this.Acu > 0) && (this.Acu < this.Act - i))
    {
      AppMethodBeat.o(98667);
      return true;
    }
    AppMethodBeat.o(98667);
    return false;
  }
  
  private void og(boolean paramBoolean)
  {
    AppMethodBeat.i(98670);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772095);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772100);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if ((this.gmY == null) || (this.Acr == null))
    {
      AppMethodBeat.o(98670);
      return;
    }
    if (paramBoolean)
    {
      if ((this.gmY.getVisibility() == 8) || (this.gmY.getVisibility() == 4))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.Acr.startAnimation(localAnimation1);
      this.Acr.setVisibility(0);
      this.gmY.startAnimation(localAnimation2);
      this.gmY.setVisibility(8);
    }
    for (;;)
    {
      this.Acr.getParent().requestLayout();
      AppMethodBeat.o(98670);
      return;
      if ((this.gmY.getVisibility() == 0) || (this.gmY.getVisibility() == 0))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.gmY.startAnimation(localAnimation1);
      this.gmY.setVisibility(0);
      this.Acr.startAnimation(localAnimation2);
      this.Acr.setVisibility(8);
    }
  }
  
  public final void Rf(int paramInt)
  {
    this.Acs &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final boolean ebP()
  {
    AppMethodBeat.i(98649);
    if ((this.vBp.getText() == null) || (bt.isNullOrNil(this.vBp.getText().toString())))
    {
      AppMethodBeat.o(98649);
      return true;
    }
    AppMethodBeat.o(98649);
    return false;
  }
  
  public final boolean ebQ()
  {
    return this.state == 1;
  }
  
  public final void ebR()
  {
    AppMethodBeat.i(98655);
    if (this.vBp == null)
    {
      ad.e("MicroMsg.SnsCommentFooter", "send edittext is null");
      AppMethodBeat.o(98655);
      return;
    }
    this.vBp.removeTextChangedListener(this.vBu);
    this.vBp.addTextChangedListener(this.vBu);
    AppMethodBeat.o(98655);
  }
  
  public final void ebS()
  {
    AppMethodBeat.i(98660);
    this.vBp.setText("");
    this.vBp.setHint("");
    this.zhw = null;
    this.Acs = 0;
    this.state = 0;
    AppMethodBeat.o(98660);
  }
  
  public final void ebV()
  {
    AppMethodBeat.i(98669);
    this.AcG = null;
    if (this.pWJ != null)
    {
      ad.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.pWJ.fbE();
      this.pWJ.destroy();
    }
    AppMethodBeat.o(98669);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(98665);
    super.g(paramBoolean, paramInt);
    this.vBr = paramBoolean;
    if ((paramBoolean) && (getVisibility() == 0) && (this.AcG != null))
    {
      ad.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
      this.AcG.edO();
    }
    if ((this.Acv != paramInt) && (paramInt != 0))
    {
      this.Acv = paramInt;
      com.tencent.mm.compatible.util.i.A(getContext(), paramInt);
      ebT();
    }
    AppMethodBeat.o(98665);
  }
  
  public String getCommentAtPrefix()
  {
    return this.Acw;
  }
  
  public int getCommentFlag()
  {
    return this.Acs;
  }
  
  public dfn getCommentInfo()
  {
    AppMethodBeat.i(98661);
    if (this.zhw == null)
    {
      localdfn = new dfn();
      AppMethodBeat.o(98661);
      return localdfn;
    }
    dfn localdfn = this.zhw;
    AppMethodBeat.o(98661);
    return localdfn;
  }
  
  public final void mq(boolean paramBoolean)
  {
    AppMethodBeat.i(98659);
    if (this.Acp != null)
    {
      if (paramBoolean)
      {
        this.Acp.setVisibility(0);
        if ((com.tencent.mm.n.g.acA().getInt("SnsAdAtFriendRedDot", 0) == 1) && (com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IFk, true)))
        {
          this.Acq.setVisibility(0);
          AppMethodBeat.o(98659);
          return;
        }
        this.Acq.setVisibility(8);
        AppMethodBeat.o(98659);
        return;
      }
      this.Acp.setVisibility(8);
      this.Acq.setVisibility(8);
    }
    AppMethodBeat.o(98659);
  }
  
  public final void n(final List<k> paramList, String paramString)
  {
    AppMethodBeat.i(98656);
    this.AcC = paramString;
    k localk;
    if (this.vBp != null)
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
    for (paramString = bt.bI(localk.text, "");; paramString = "")
    {
      if (!bt.isNullOrNil(paramString))
      {
        this.Acr.setVisibility(0);
        this.gmY.setVisibility(8);
        this.vBp.setText("");
        this.vBp.aXD(paramString);
      }
      for (;;)
      {
        if (!this.AcD) {
          this.vBp.addTextChangedListener(new TextWatcher()
          {
            int AcM = 0;
            
            public final void afterTextChanged(Editable paramAnonymousEditable)
            {
              AppMethodBeat.i(98642);
              if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
              {
                AppMethodBeat.o(98642);
                return;
              }
              if ((com.tencent.mm.plugin.sns.ui.widget.e.ia(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!bt.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (!bt.isNullOrNil(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString())) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
              {
                ad.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", new Object[] { SnsCommentFooter.d(SnsCommentFooter.this), SnsCommentFooter.b(SnsCommentFooter.this).getText() });
                SnsCommentFooter.a(SnsCommentFooter.this, "");
                SnsCommentFooter.e(SnsCommentFooter.this);
                SnsCommentFooter.this.Rf(8);
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
                    localk.dDp = SnsCommentFooter.c(SnsCommentFooter.this);
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
                  paramAnonymousEditable.dDp = SnsCommentFooter.c(SnsCommentFooter.this);
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
                  if ((bool) && (SnsCommentFooter.this.vBt))
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.vBt = false;
                  }
                  if (!bool)
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.vBt = true;
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
                this.AcM = paramAnonymousInt1;
                AppMethodBeat.o(98641);
                return;
              }
            }
            
            public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(98640);
              if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.c.a.zbZ))
              {
                SnsCommentFooter.this.Rf(16);
                ad.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.o(98640);
                return;
              }
              if (paramAnonymousCharSequence.length() - this.AcM > com.tencent.mm.plugin.sns.c.a.zbZ)
              {
                SnsCommentFooter.this.setCommentFlag(16);
                ad.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
              }
              AppMethodBeat.o(98640);
            }
          });
        }
        this.AcD = true;
        AppMethodBeat.o(98656);
        return;
        this.vBp.setText("");
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98664);
    super.onConfigurationChanged(paramConfiguration);
    if (this.pWJ != null) {
      ebT();
    }
    AppMethodBeat.o(98664);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98668);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Act < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.Act)
    {
      this.Act = paramInt1;
      this.Acu = paramInt4;
      AppMethodBeat.o(98668);
      return;
    }
  }
  
  public final void rQ(boolean paramBoolean)
  {
    AppMethodBeat.i(98653);
    if (this.pWJ == null)
    {
      AppMethodBeat.o(98653);
      return;
    }
    this.AcB = paramBoolean;
    ad.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      this.pWJ.setVisibility(8);
      this.vBo.setImageResource(2131690564);
      this.fLP.hideVKB();
      requestLayout();
      AppMethodBeat.o(98653);
      return;
    }
    if (this.state == 0)
    {
      this.vBp.requestFocus();
      this.fLP.showVKB();
      this.pWJ.setVisibility(8);
    }
    for (;;)
    {
      this.vBs = false;
      AppMethodBeat.o(98653);
      return;
      this.vBp.requestFocus();
      this.fLP.hideVKB();
      bEE();
    }
  }
  
  public void setAfterEditAction(Runnable paramRunnable)
  {
    AppMethodBeat.i(98651);
    paramRunnable = (ViewGroup)inflate(this.fLP, 2131495541, this);
    this.Acp = ((ImageView)paramRunnable.findViewById(2131296545));
    this.Acq = ((ImageView)paramRunnable.findViewById(2131296546));
    this.gmY = ((Button)paramRunnable.findViewById(2131296560));
    this.Acr = ((Button)paramRunnable.findViewById(2131296553));
    this.vBp = ((MMEditText)paramRunnable.findViewById(2131296549));
    og(false);
    this.Acp.setOnClickListener(new SnsCommentFooter.7(this));
    this.vBo = ((ImageButton)paramRunnable.findViewById(2131296558));
    this.vBo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98644);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SnsCommentFooter.this.setModeClick(true);
        ad.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.i(SnsCommentFooter.this));
        if (SnsCommentFooter.i(SnsCommentFooter.this) == 0)
        {
          SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
          SnsCommentFooter.this.fLP.hideVKB();
          SnsCommentFooter.a(SnsCommentFooter.this, 1);
          SnsCommentFooter.j(SnsCommentFooter.this);
          SnsCommentFooter.this.setToSendTextColor(false);
          SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131231706);
          SnsCommentFooter.l(SnsCommentFooter.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98644);
          return;
          SnsCommentFooter.m(SnsCommentFooter.this);
          SnsCommentFooter.l(SnsCommentFooter.this);
          SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
          SnsCommentFooter.this.fLP.showVKB();
          SnsCommentFooter.this.setToSendTextColor(true);
          SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690564);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
      }
    });
    this.vBp.setHint(this.fLP.getString(2131764046));
    this.vBp.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(98645);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        SnsCommentFooter.this.setToSendTextColor(true);
        SnsCommentFooter.l(SnsCommentFooter.this);
        SnsCommentFooter.m(SnsCommentFooter.this);
        SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690564);
        if (SnsCommentFooter.n(SnsCommentFooter.this) != null) {
          SnsCommentFooter.n(SnsCommentFooter.this).ebO();
        }
        SnsCommentFooter.a(SnsCommentFooter.this, 0);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(98645);
        return false;
      }
    });
    if (com.tencent.mm.pluginsdk.ui.chat.e.FdJ == null)
    {
      this.pWJ = new d(this.fLP);
      AppMethodBeat.o(98651);
      return;
    }
    this.pWJ = com.tencent.mm.pluginsdk.ui.chat.e.FdJ.eA(getContext());
    this.pWJ.setEntranceScene(ChatFooterPanel.ESt);
    this.pWJ.setVisibility(8);
    paramRunnable = (LinearLayout)findViewById(2131304239);
    this.Acv = z.iI(getContext());
    paramRunnable.addView(this.pWJ, -1, this.Acv);
    if (!this.Acy) {
      this.pWJ.fbF();
    }
    this.pWJ.onResume();
    this.pWJ.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aoO()
      {
        AppMethodBeat.i(98647);
        if (SnsCommentFooter.b(SnsCommentFooter.this) != null)
        {
          if (SnsCommentFooter.b(SnsCommentFooter.this).getInputConnection() == null)
          {
            AppMethodBeat.o(98647);
            return;
          }
          SnsCommentFooter.b(SnsCommentFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
          SnsCommentFooter.b(SnsCommentFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        }
        AppMethodBeat.o(98647);
      }
      
      public final void aoP() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(98648);
        try
        {
          SnsCommentFooter.b(SnsCommentFooter.this).aXD(paramAnonymousString);
          AppMethodBeat.o(98648);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.printErrStackTrace("MicroMsg.SnsCommentFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(98648);
        }
      }
      
      public final void dU(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(98646);
        SnsCommentFooter.this.setToSendTextColor(paramAnonymousBoolean);
        AppMethodBeat.o(98646);
      }
    });
    paramRunnable = aa.cRX.Lp();
    paramRunnable.cRW = new z.a()
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
          com.tencent.mm.plugin.sns.c.a.iRG.a(SnsCommentFooter.h(SnsCommentFooter.this), str, ((EmojiInfo)paramAnonymousp).field_md5, bool, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(98630);
              if ((SnsCommentFooter.q(SnsCommentFooter.this) != null) && (paramAnonymous2Boolean)) {
                if (!com.tencent.mm.plugin.sns.ui.widget.e.ia(SnsCommentFooter.c(SnsCommentFooter.this), 8)) {
                  break label94;
                }
              }
              label94:
              for (paramAnonymous2String = SnsCommentFooter.this.getCommentAtPrefix();; paramAnonymous2String = "")
              {
                SnsCommentFooter.q(SnsCommentFooter.this).jU(paramAnonymous2String, ((EmojiInfo)paramAnonymousp).field_md5);
                com.tencent.mm.plugin.report.service.g.yhR.dD(150, 81);
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
    this.pWJ.setCallback(paramRunnable);
    AppMethodBeat.o(98651);
  }
  
  public void setAnitiomAdjust(bq parambq)
  {
    this.AcG = parambq;
  }
  
  public void setCommentAtPrefix(String paramString)
  {
    this.Acw = paramString;
  }
  
  public void setCommentFlag(int paramInt)
  {
    this.Acs |= paramInt;
  }
  
  public void setCommentHint(String paramString)
  {
    AppMethodBeat.i(98658);
    if (!bt.isNullOrNil(paramString))
    {
      if (com.tencent.mm.plugin.sns.ui.widget.e.ia(this.Acs, 1))
      {
        this.vBp.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.fLP.getString(2131763743) + paramString + this.fLP.getString(2131763775, new Object[] { Float.valueOf(this.vBp.getTextSize()) }), this.vBp.getTextSize()));
        AppMethodBeat.o(98658);
        return;
      }
      this.vBp.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), paramString, this.vBp.getTextSize()));
      AppMethodBeat.o(98658);
      return;
    }
    this.vBp.setHint("");
    AppMethodBeat.o(98658);
  }
  
  public void setCommentInfo(dfn paramdfn)
  {
    this.zhw = paramdfn;
  }
  
  public void setFeedEmojiCommentEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(176296);
    this.Acz = paramBoolean;
    ad.i("MicroMsg.SnsCommentFooter", "setFeedEmojiCommentEnable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(176296);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.vBq = paramBoolean;
  }
  
  public void setOnCommentSendImp(final b paramb)
  {
    AppMethodBeat.i(98663);
    this.Acx = paramb;
    this.Acr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98634);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = c.d(SnsCommentFooter.b(SnsCommentFooter.this)).aeU(com.tencent.mm.n.b.acc());
        paramAnonymousView.KMn = true;
        paramAnonymousView.a(new c.a()
        {
          public final void JZ(String paramAnonymous2String)
          {
            AppMethodBeat.i(98632);
            SnsCommentFooter.2.this.AcK.jU(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString(), "");
            SnsCommentFooter.b(SnsCommentFooter.this).setText("");
            AppMethodBeat.o(98632);
          }
          
          public final void aUu() {}
          
          public final void cU(String paramAnonymous2String)
          {
            AppMethodBeat.i(163118);
            h.l(SnsCommentFooter.h(SnsCommentFooter.this), 2131764058, 2131764059);
            AppMethodBeat.o(163118);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98634);
      }
    });
    AppMethodBeat.o(98663);
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.AcE = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.AcF = paramc;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98657);
    if (this.vBp != null)
    {
      this.vBp.setText("");
      this.vBp.aXD(paramString);
    }
    AppMethodBeat.o(98657);
  }
  
  public void setToSendTextColor(boolean paramBoolean)
  {
    AppMethodBeat.i(98662);
    if (this.vBp == null)
    {
      AppMethodBeat.o(98662);
      return;
    }
    if (paramBoolean)
    {
      this.vBp.setTextColor(getResources().getColor(2131100636));
      AppMethodBeat.o(98662);
      return;
    }
    this.vBp.setTextColor(getResources().getColor(2131100482));
    ad.i("MicroMsg.SnsCommentFooter", "focusEdt: %s, %s", new Object[] { Boolean.FALSE, this.vBp });
    if (this.vBp != null) {
      this.vBp.clearFocus();
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
    rQ(bool);
    super.setVisibility(paramInt);
    AppMethodBeat.o(98652);
  }
  
  static abstract interface a
  {
    public abstract void ebO();
  }
  
  static abstract interface b
  {
    public abstract void jU(String paramString1, String paramString2);
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