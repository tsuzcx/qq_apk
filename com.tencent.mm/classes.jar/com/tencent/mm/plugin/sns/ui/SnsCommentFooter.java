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
import com.tencent.mm.api.aa.a;
import com.tencent.mm.api.z.a;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private ImageView AtC;
  private ImageView AtD;
  private Button AtE;
  int AtF;
  private int AtG;
  private int AtH;
  private int AtI;
  private String AtJ;
  private b AtK;
  boolean AtL;
  private boolean AtM;
  private boolean AtN;
  public boolean AtO;
  private String AtP;
  private boolean AtQ;
  private a AtR;
  private c AtS;
  private bq AtT;
  MMActivity fNT;
  private Button gpu;
  ChatFooterPanel qdo;
  int state;
  private ImageButton vNs;
  MMEditText vNt;
  private boolean vNu;
  public boolean vNv;
  private boolean vNw;
  boolean vNx;
  private TextWatcher vNy;
  dgh zyl;
  
  public SnsCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98650);
    this.zyl = null;
    this.AtF = 0;
    this.state = 0;
    this.vNu = false;
    this.AtG = -1;
    this.AtH = -1;
    this.AtI = 0;
    this.AtK = null;
    this.AtL = false;
    this.AtM = false;
    this.AtN = com.tencent.mm.sdk.platformtools.aa.iP(getContext());
    this.vNv = false;
    this.vNw = true;
    this.AtP = "";
    this.AtQ = false;
    this.vNx = true;
    this.vNy = new TextWatcher()
    {
      private int AtZ = 0;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(98639);
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
        {
          AppMethodBeat.o(98639);
          return;
        }
        if ((com.tencent.mm.plugin.sns.ui.widget.e.id(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!bu.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (SnsCommentFooter.b(SnsCommentFooter.this).getText() != null) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
        {
          ae.i("MicroMsg.SnsCommentFooter", "cur text %s", new Object[] { SnsCommentFooter.b(SnsCommentFooter.this).getText() });
          SnsCommentFooter.a(SnsCommentFooter.this, "");
          SnsCommentFooter.e(SnsCommentFooter.this);
          SnsCommentFooter.this.RM(8);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
        SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (SnsCommentFooter.this.vNx))
          {
            SnsCommentFooter.a(SnsCommentFooter.this, true);
            SnsCommentFooter.this.vNx = false;
          }
          if (i == 0)
          {
            SnsCommentFooter.a(SnsCommentFooter.this, false);
            SnsCommentFooter.this.vNx = true;
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
          this.AtZ = paramAnonymousInt1;
          AppMethodBeat.o(98637);
          return;
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98638);
        if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.c.a.zsC))
        {
          SnsCommentFooter.this.RM(16);
          ae.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
          AppMethodBeat.o(98638);
          return;
        }
        if (paramAnonymousCharSequence.length() - this.AtZ > com.tencent.mm.plugin.sns.c.a.zsC)
        {
          SnsCommentFooter.this.setCommentFlag(16);
          ae.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
        }
        AppMethodBeat.o(98638);
      }
    };
    this.fNT = ((MMActivity)paramContext);
    if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE) || (j.DEBUG))
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIB, 0) == 1) {}
      for (bool = true;; bool = false)
      {
        this.AtL = bool;
        AppMethodBeat.o(98650);
        return;
      }
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIB, 0) == 1) {}
    for (;;)
    {
      this.AtL = bool;
      AppMethodBeat.o(98650);
      return;
      bool = false;
    }
  }
  
  private void bFw()
  {
    AppMethodBeat.i(98654);
    this.qdo.onResume();
    if ((com.tencent.mm.sdk.platformtools.aa.iP(getContext())) && (efB())) {
      getInputPanelHelper().aI(new Runnable()
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
      if (this.AtS != null) {
        this.AtS.onShow();
      }
      AppMethodBeat.o(98654);
      return;
      this.qdo.setVisibility(0);
    }
  }
  
  private void efA()
  {
    AppMethodBeat.i(98666);
    int i = com.tencent.mm.sdk.platformtools.aa.iN(getContext());
    if (this.qdo != null)
    {
      this.qdo.setPortHeightPx(i);
      ViewGroup.LayoutParams localLayoutParams = this.qdo.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.height = i;
      }
    }
    AppMethodBeat.o(98666);
  }
  
  private boolean efB()
  {
    AppMethodBeat.i(98667);
    int i = al.en(getContext());
    ae.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.AtH), Integer.valueOf(this.AtG), Integer.valueOf(i) });
    if ((this.AtH > 0) && (this.AtH < this.AtG - i))
    {
      AppMethodBeat.o(98667);
      return true;
    }
    AppMethodBeat.o(98667);
    return false;
  }
  
  private void ol(boolean paramBoolean)
  {
    AppMethodBeat.i(98670);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772095);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772100);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if ((this.gpu == null) || (this.AtE == null))
    {
      AppMethodBeat.o(98670);
      return;
    }
    if (paramBoolean)
    {
      if ((this.gpu.getVisibility() == 8) || (this.gpu.getVisibility() == 4))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.AtE.startAnimation(localAnimation1);
      this.AtE.setVisibility(0);
      this.gpu.startAnimation(localAnimation2);
      this.gpu.setVisibility(8);
    }
    for (;;)
    {
      this.AtE.getParent().requestLayout();
      AppMethodBeat.o(98670);
      return;
      if ((this.gpu.getVisibility() == 0) || (this.gpu.getVisibility() == 0))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.gpu.startAnimation(localAnimation1);
      this.gpu.setVisibility(0);
      this.AtE.startAnimation(localAnimation2);
      this.AtE.setVisibility(8);
    }
  }
  
  public final void RM(int paramInt)
  {
    this.AtF &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final void efC()
  {
    AppMethodBeat.i(98669);
    this.AtT = null;
    if (this.qdo != null)
    {
      ae.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.qdo.ffs();
      this.qdo.destroy();
    }
    AppMethodBeat.o(98669);
  }
  
  public final boolean efw()
  {
    AppMethodBeat.i(98649);
    if ((this.vNt.getText() == null) || (bu.isNullOrNil(this.vNt.getText().toString())))
    {
      AppMethodBeat.o(98649);
      return true;
    }
    AppMethodBeat.o(98649);
    return false;
  }
  
  public final boolean efx()
  {
    return this.state == 1;
  }
  
  public final void efy()
  {
    AppMethodBeat.i(98655);
    if (this.vNt == null)
    {
      ae.e("MicroMsg.SnsCommentFooter", "send edittext is null");
      AppMethodBeat.o(98655);
      return;
    }
    this.vNt.removeTextChangedListener(this.vNy);
    this.vNt.addTextChangedListener(this.vNy);
    AppMethodBeat.o(98655);
  }
  
  public final void efz()
  {
    AppMethodBeat.i(98660);
    this.vNt.setText("");
    this.vNt.setHint("");
    this.zyl = null;
    this.AtF = 0;
    this.state = 0;
    AppMethodBeat.o(98660);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(98665);
    super.g(paramBoolean, paramInt);
    this.vNv = paramBoolean;
    if ((paramBoolean) && (getVisibility() == 0) && (this.AtT != null))
    {
      ae.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
      this.AtT.ehv();
    }
    if ((this.AtI != paramInt) && (paramInt != 0))
    {
      this.AtI = paramInt;
      i.A(getContext(), paramInt);
      efA();
    }
    AppMethodBeat.o(98665);
  }
  
  public String getCommentAtPrefix()
  {
    return this.AtJ;
  }
  
  public int getCommentFlag()
  {
    return this.AtF;
  }
  
  public dgh getCommentInfo()
  {
    AppMethodBeat.i(98661);
    if (this.zyl == null)
    {
      localdgh = new dgh();
      AppMethodBeat.o(98661);
      return localdgh;
    }
    dgh localdgh = this.zyl;
    AppMethodBeat.o(98661);
    return localdgh;
  }
  
  public final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(98659);
    if (this.AtC != null)
    {
      if (paramBoolean)
      {
        this.AtC.setVisibility(0);
        if ((com.tencent.mm.n.g.acL().getInt("SnsAdAtFriendRedDot", 0) == 1) && (com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IZK, true)))
        {
          this.AtD.setVisibility(0);
          AppMethodBeat.o(98659);
          return;
        }
        this.AtD.setVisibility(8);
        AppMethodBeat.o(98659);
        return;
      }
      this.AtC.setVisibility(8);
      this.AtD.setVisibility(8);
    }
    AppMethodBeat.o(98659);
  }
  
  public final void n(final List<k> paramList, String paramString)
  {
    AppMethodBeat.i(98656);
    this.AtP = paramString;
    k localk;
    if (this.vNt != null)
    {
      if (bu.isNullOrNil(paramString)) {
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
    for (paramString = bu.bI(localk.text, "");; paramString = "")
    {
      if (!bu.isNullOrNil(paramString))
      {
        this.AtE.setVisibility(0);
        this.gpu.setVisibility(8);
        this.vNt.setText("");
        this.vNt.aZf(paramString);
      }
      for (;;)
      {
        if (!this.AtQ) {
          this.vNt.addTextChangedListener(new TextWatcher()
          {
            int AtZ = 0;
            
            public final void afterTextChanged(Editable paramAnonymousEditable)
            {
              AppMethodBeat.i(98642);
              if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
              {
                AppMethodBeat.o(98642);
                return;
              }
              if ((com.tencent.mm.plugin.sns.ui.widget.e.id(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!bu.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (!bu.isNullOrNil(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString())) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
              {
                ae.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", new Object[] { SnsCommentFooter.d(SnsCommentFooter.this), SnsCommentFooter.b(SnsCommentFooter.this).getText() });
                SnsCommentFooter.a(SnsCommentFooter.this, "");
                SnsCommentFooter.e(SnsCommentFooter.this);
                SnsCommentFooter.this.RM(8);
                SnsCommentFooter.a(SnsCommentFooter.this, 0);
              }
              ae.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.f(SnsCommentFooter.this));
              if (!bu.isNullOrNil(SnsCommentFooter.f(SnsCommentFooter.this)))
              {
                paramAnonymousEditable = paramList.iterator();
                while (paramAnonymousEditable.hasNext())
                {
                  k localk = (k)paramAnonymousEditable.next();
                  if (SnsCommentFooter.f(SnsCommentFooter.this).equals(localk.key))
                  {
                    ae.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                    localk.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                    localk.dEu = SnsCommentFooter.c(SnsCommentFooter.this);
                  }
                }
              }
              for (int i = 1;; i = 0)
              {
                if (i == 0)
                {
                  ae.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                  paramAnonymousEditable = new k();
                  paramAnonymousEditable.key = SnsCommentFooter.f(SnsCommentFooter.this);
                  paramAnonymousEditable.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                  paramAnonymousEditable.dEu = SnsCommentFooter.c(SnsCommentFooter.this);
                  if ((paramAnonymousEditable.text != null) && (paramAnonymousEditable.text.length() > 0)) {
                    paramList.add(paramAnonymousEditable);
                  }
                }
                if (paramList.size() > 5)
                {
                  ae.d("MicroMsg.SnsCommentFooter", "comments remove");
                  paramList.remove(0);
                }
                SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
                if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
                for (boolean bool = true;; bool = false)
                {
                  if ((bool) && (SnsCommentFooter.this.vNx))
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.vNx = false;
                  }
                  if (!bool)
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.vNx = true;
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
                this.AtZ = paramAnonymousInt1;
                AppMethodBeat.o(98641);
                return;
              }
            }
            
            public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(98640);
              if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.c.a.zsC))
              {
                SnsCommentFooter.this.RM(16);
                ae.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.o(98640);
                return;
              }
              if (paramAnonymousCharSequence.length() - this.AtZ > com.tencent.mm.plugin.sns.c.a.zsC)
              {
                SnsCommentFooter.this.setCommentFlag(16);
                ae.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
              }
              AppMethodBeat.o(98640);
            }
          });
        }
        this.AtQ = true;
        AppMethodBeat.o(98656);
        return;
        this.vNt.setText("");
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98664);
    super.onConfigurationChanged(paramConfiguration);
    if (this.qdo != null) {
      efA();
    }
    AppMethodBeat.o(98664);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98668);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.AtG < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.AtG)
    {
      this.AtG = paramInt1;
      this.AtH = paramInt4;
      AppMethodBeat.o(98668);
      return;
    }
  }
  
  public final void rX(boolean paramBoolean)
  {
    AppMethodBeat.i(98653);
    if (this.qdo == null)
    {
      AppMethodBeat.o(98653);
      return;
    }
    this.AtO = paramBoolean;
    ae.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      this.qdo.setVisibility(8);
      this.vNs.setImageResource(2131690564);
      this.fNT.hideVKB();
      requestLayout();
      AppMethodBeat.o(98653);
      return;
    }
    if (this.state == 0)
    {
      this.vNt.requestFocus();
      this.fNT.showVKB();
      this.qdo.setVisibility(8);
    }
    for (;;)
    {
      this.vNw = false;
      AppMethodBeat.o(98653);
      return;
      this.vNt.requestFocus();
      this.fNT.hideVKB();
      bFw();
    }
  }
  
  public void setAfterEditAction(Runnable paramRunnable)
  {
    AppMethodBeat.i(98651);
    paramRunnable = (ViewGroup)inflate(this.fNT, 2131495541, this);
    this.AtC = ((ImageView)paramRunnable.findViewById(2131296545));
    this.AtD = ((ImageView)paramRunnable.findViewById(2131296546));
    this.gpu = ((Button)paramRunnable.findViewById(2131296560));
    this.AtE = ((Button)paramRunnable.findViewById(2131296553));
    this.vNt = ((MMEditText)paramRunnable.findViewById(2131296549));
    ol(false);
    this.AtC.setOnClickListener(new SnsCommentFooter.7(this));
    this.vNs = ((ImageButton)paramRunnable.findViewById(2131296558));
    this.vNs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98644);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        SnsCommentFooter.this.setModeClick(true);
        ae.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.i(SnsCommentFooter.this));
        if (SnsCommentFooter.i(SnsCommentFooter.this) == 0)
        {
          SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
          SnsCommentFooter.this.fNT.hideVKB();
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
          SnsCommentFooter.this.fNT.showVKB();
          SnsCommentFooter.this.setToSendTextColor(true);
          SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690564);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
      }
    });
    this.vNt.setHint(this.fNT.getString(2131764046));
    this.vNt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(98645);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        SnsCommentFooter.this.setToSendTextColor(true);
        SnsCommentFooter.l(SnsCommentFooter.this);
        SnsCommentFooter.m(SnsCommentFooter.this);
        SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690564);
        if (SnsCommentFooter.n(SnsCommentFooter.this) != null) {
          SnsCommentFooter.n(SnsCommentFooter.this).efv();
        }
        SnsCommentFooter.a(SnsCommentFooter.this, 0);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(98645);
        return false;
      }
    });
    if (com.tencent.mm.pluginsdk.ui.chat.e.Fwh == null)
    {
      this.qdo = new d(this.fNT);
      AppMethodBeat.o(98651);
      return;
    }
    this.qdo = com.tencent.mm.pluginsdk.ui.chat.e.Fwh.eE(getContext());
    this.qdo.setEntranceScene(ChatFooterPanel.FkO);
    this.qdo.setVisibility(8);
    paramRunnable = (LinearLayout)findViewById(2131304239);
    this.AtI = com.tencent.mm.sdk.platformtools.aa.iN(getContext());
    paramRunnable.addView(this.qdo, -1, this.AtI);
    if (!this.AtL) {
      this.qdo.fft();
    }
    this.qdo.onResume();
    this.qdo.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void apc()
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
      
      public final void apd() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(98648);
        try
        {
          SnsCommentFooter.b(SnsCommentFooter.this).aZf(paramAnonymousString);
          AppMethodBeat.o(98648);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.printErrStackTrace("MicroMsg.SnsCommentFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(98648);
        }
      }
      
      public final void dW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(98646);
        SnsCommentFooter.this.setToSendTextColor(paramAnonymousBoolean);
        AppMethodBeat.o(98646);
      }
    });
    paramRunnable = com.tencent.mm.api.aa.cSH.Lx();
    paramRunnable.cSG = new z.a()
    {
      public final void a(final com.tencent.mm.api.p paramAnonymousp)
      {
        AppMethodBeat.i(98631);
        if ((paramAnonymousp instanceof EmojiInfo))
        {
          boolean bool = false;
          String str;
          if ((SnsCommentFooter.o(SnsCommentFooter.this) != null) && (!bu.isNullOrNil(SnsCommentFooter.o(SnsCommentFooter.this).Username)))
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
          com.tencent.mm.plugin.sns.c.a.iUz.a(SnsCommentFooter.h(SnsCommentFooter.this), str, ((EmojiInfo)paramAnonymousp).field_md5, bool, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(98630);
              if ((SnsCommentFooter.q(SnsCommentFooter.this) != null) && (paramAnonymous2Boolean)) {
                if (!com.tencent.mm.plugin.sns.ui.widget.e.id(SnsCommentFooter.c(SnsCommentFooter.this), 8)) {
                  break label94;
                }
              }
              label94:
              for (paramAnonymous2String = SnsCommentFooter.this.getCommentAtPrefix();; paramAnonymous2String = "")
              {
                SnsCommentFooter.q(SnsCommentFooter.this).kb(paramAnonymous2String, ((EmojiInfo)paramAnonymousp).field_md5);
                com.tencent.mm.plugin.report.service.g.yxI.dD(150, 81);
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
    this.qdo.setCallback(paramRunnable);
    AppMethodBeat.o(98651);
  }
  
  public void setAnitiomAdjust(bq parambq)
  {
    this.AtT = parambq;
  }
  
  public void setCommentAtPrefix(String paramString)
  {
    this.AtJ = paramString;
  }
  
  public void setCommentFlag(int paramInt)
  {
    this.AtF |= paramInt;
  }
  
  public void setCommentHint(String paramString)
  {
    AppMethodBeat.i(98658);
    if (!bu.isNullOrNil(paramString))
    {
      if (com.tencent.mm.plugin.sns.ui.widget.e.id(this.AtF, 1))
      {
        this.vNt.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.fNT.getString(2131763743) + paramString + this.fNT.getString(2131763775, new Object[] { Float.valueOf(this.vNt.getTextSize()) }), this.vNt.getTextSize()));
        AppMethodBeat.o(98658);
        return;
      }
      this.vNt.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), paramString, this.vNt.getTextSize()));
      AppMethodBeat.o(98658);
      return;
    }
    this.vNt.setHint("");
    AppMethodBeat.o(98658);
  }
  
  public void setCommentInfo(dgh paramdgh)
  {
    this.zyl = paramdgh;
  }
  
  public void setFeedEmojiCommentEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(176296);
    this.AtM = paramBoolean;
    ae.i("MicroMsg.SnsCommentFooter", "setFeedEmojiCommentEnable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(176296);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.vNu = paramBoolean;
  }
  
  public void setOnCommentSendImp(final b paramb)
  {
    AppMethodBeat.i(98663);
    this.AtK = paramb;
    this.AtE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98634);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = c.d(SnsCommentFooter.b(SnsCommentFooter.this)).afD(com.tencent.mm.n.b.acl());
        paramAnonymousView.LiL = true;
        paramAnonymousView.a(new c.a()
        {
          public final void Ky(String paramAnonymous2String)
          {
            AppMethodBeat.i(98632);
            SnsCommentFooter.2.this.AtX.kb(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString(), "");
            SnsCommentFooter.b(SnsCommentFooter.this).setText("");
            AppMethodBeat.o(98632);
          }
          
          public final void aUT() {}
          
          public final void cW(String paramAnonymous2String)
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
    this.AtR = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.AtS = paramc;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98657);
    if (this.vNt != null)
    {
      this.vNt.setText("");
      this.vNt.aZf(paramString);
    }
    AppMethodBeat.o(98657);
  }
  
  public void setToSendTextColor(boolean paramBoolean)
  {
    AppMethodBeat.i(98662);
    if (this.vNt == null)
    {
      AppMethodBeat.o(98662);
      return;
    }
    if (paramBoolean)
    {
      this.vNt.setTextColor(getResources().getColor(2131100636));
      AppMethodBeat.o(98662);
      return;
    }
    this.vNt.setTextColor(getResources().getColor(2131100482));
    ae.i("MicroMsg.SnsCommentFooter", "focusEdt: %s, %s", new Object[] { Boolean.FALSE, this.vNt });
    if (this.vNt != null) {
      this.vNt.clearFocus();
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
    rX(bool);
    super.setVisibility(paramInt);
    AppMethodBeat.o(98652);
  }
  
  static abstract interface a
  {
    public abstract void efv();
  }
  
  static abstract interface b
  {
    public abstract void kb(String paramString1, String paramString2);
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