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
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.List;

public class SnsCommentFooter
  extends InputPanelLinearLayout
{
  private Button fTu;
  ChatFooterPanel fWT;
  MMActivity iMV;
  private ImageView rYm;
  int state;
  private ImageButton uyL;
  MMEditText uyM;
  private boolean uyN;
  public boolean uyO;
  private boolean uyP;
  boolean uyQ;
  private TextWatcher uyR;
  daa xRC;
  private ImageView yKU;
  private Button yKV;
  int yKW;
  private int yKX;
  private int yKY;
  private int yKZ;
  private String yLa;
  private b yLb;
  boolean yLc;
  private boolean yLd;
  private boolean yLe;
  public boolean yLf;
  private String yLg;
  private boolean yLh;
  private a yLi;
  private c yLj;
  private bn yLk;
  
  public SnsCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98650);
    this.xRC = null;
    this.yKW = 0;
    this.state = 0;
    this.uyN = false;
    this.yKX = -1;
    this.yKY = -1;
    this.yKZ = 0;
    this.yLb = null;
    this.yLc = false;
    this.yLd = false;
    this.yLe = y.iA(getContext());
    this.uyO = false;
    this.uyP = true;
    this.yLg = "";
    this.yLh = false;
    this.uyQ = true;
    this.uyR = new TextWatcher()
    {
      private int yLq = 0;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(98639);
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
        {
          AppMethodBeat.o(98639);
          return;
        }
        if ((com.tencent.mm.plugin.sns.ui.widget.e.hJ(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!bs.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (SnsCommentFooter.b(SnsCommentFooter.this).getText() != null) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
        {
          ac.i("MicroMsg.SnsCommentFooter", "cur text %s", new Object[] { SnsCommentFooter.b(SnsCommentFooter.this).getText() });
          SnsCommentFooter.a(SnsCommentFooter.this, "");
          SnsCommentFooter.e(SnsCommentFooter.this);
          SnsCommentFooter.this.Pw(8);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
        SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (SnsCommentFooter.this.uyQ))
          {
            SnsCommentFooter.a(SnsCommentFooter.this, true);
            SnsCommentFooter.this.uyQ = false;
          }
          if (i == 0)
          {
            SnsCommentFooter.a(SnsCommentFooter.this, false);
            SnsCommentFooter.this.uyQ = true;
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
          this.yLq = paramAnonymousInt1;
          AppMethodBeat.o(98637);
          return;
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98638);
        if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.xMh))
        {
          SnsCommentFooter.this.Pw(16);
          ac.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
          AppMethodBeat.o(98638);
          return;
        }
        if (paramAnonymousCharSequence.length() - this.yLq > a.xMh)
        {
          SnsCommentFooter.this.setCommentFlag(16);
          ac.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
        }
        AppMethodBeat.o(98638);
      }
    };
    this.iMV = ((MMActivity)paramContext);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
    {
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWo, 0) == 1) {}
      for (bool = true;; bool = false)
      {
        this.yLc = bool;
        AppMethodBeat.o(98650);
        return;
      }
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWo, 0) == 1) {}
    for (;;)
    {
      this.yLc = bool;
      AppMethodBeat.o(98650);
      return;
      bool = false;
    }
  }
  
  private void bAC()
  {
    AppMethodBeat.i(98654);
    this.fWT.onResume();
    if ((y.iA(getContext())) && (dPD())) {
      getInputPanelHelper().aM(new Runnable()
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
      if (this.yLj != null) {
        this.yLj.onShow();
      }
      AppMethodBeat.o(98654);
      return;
      this.fWT.setVisibility(0);
    }
  }
  
  private void dPC()
  {
    AppMethodBeat.i(98666);
    int i = y.iy(getContext());
    if (this.fWT != null)
    {
      this.fWT.setPortHeightPx(i);
      ViewGroup.LayoutParams localLayoutParams = this.fWT.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.height = i;
      }
    }
    AppMethodBeat.o(98666);
  }
  
  private boolean dPD()
  {
    AppMethodBeat.i(98667);
    int i = aj.ej(getContext());
    ac.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.yKY), Integer.valueOf(this.yKX), Integer.valueOf(i) });
    if ((this.yKY > 0) && (this.yKY < this.yKX - i))
    {
      AppMethodBeat.o(98667);
      return true;
    }
    AppMethodBeat.o(98667);
    return false;
  }
  
  private void nM(boolean paramBoolean)
  {
    AppMethodBeat.i(98670);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772095);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772100);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if ((this.fTu == null) || (this.yKV == null))
    {
      AppMethodBeat.o(98670);
      return;
    }
    if (paramBoolean)
    {
      if ((this.fTu.getVisibility() == 8) || (this.fTu.getVisibility() == 4))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.yKV.startAnimation(localAnimation1);
      this.yKV.setVisibility(0);
      this.fTu.startAnimation(localAnimation2);
      this.fTu.setVisibility(8);
    }
    for (;;)
    {
      this.yKV.getParent().requestLayout();
      AppMethodBeat.o(98670);
      return;
      if ((this.fTu.getVisibility() == 0) || (this.fTu.getVisibility() == 0))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.fTu.startAnimation(localAnimation1);
      this.fTu.setVisibility(0);
      this.yKV.startAnimation(localAnimation2);
      this.yKV.setVisibility(8);
    }
  }
  
  public final void Pw(int paramInt)
  {
    this.yKW &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final void dPA()
  {
    AppMethodBeat.i(98655);
    if (this.uyM == null)
    {
      ac.e("MicroMsg.SnsCommentFooter", "send edittext is null");
      AppMethodBeat.o(98655);
      return;
    }
    this.uyM.removeTextChangedListener(this.uyR);
    this.uyM.addTextChangedListener(this.uyR);
    AppMethodBeat.o(98655);
  }
  
  public final void dPB()
  {
    AppMethodBeat.i(98660);
    this.uyM.setText("");
    this.uyM.setHint("");
    this.xRC = null;
    this.yKW = 0;
    this.state = 0;
    AppMethodBeat.o(98660);
  }
  
  public final void dPE()
  {
    AppMethodBeat.i(98669);
    this.yLk = null;
    if (this.fWT != null)
    {
      ac.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.fWT.eMG();
      this.fWT.destroy();
    }
    AppMethodBeat.o(98669);
  }
  
  public final boolean dPy()
  {
    AppMethodBeat.i(98649);
    if ((this.uyM.getText() == null) || (bs.isNullOrNil(this.uyM.getText().toString())))
    {
      AppMethodBeat.o(98649);
      return true;
    }
    AppMethodBeat.o(98649);
    return false;
  }
  
  public final boolean dPz()
  {
    return this.state == 1;
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(98665);
    super.g(paramBoolean, paramInt);
    this.uyO = paramBoolean;
    if ((paramBoolean) && (getVisibility() == 0) && (this.yLk != null))
    {
      ac.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
      this.yLk.dRu();
    }
    if ((this.yKZ != paramInt) && (paramInt != 0))
    {
      this.yKZ = paramInt;
      i.A(getContext(), paramInt);
      dPC();
    }
    AppMethodBeat.o(98665);
  }
  
  public String getCommentAtPrefix()
  {
    return this.yLa;
  }
  
  public int getCommentFlag()
  {
    return this.yKW;
  }
  
  public daa getCommentInfo()
  {
    AppMethodBeat.i(98661);
    if (this.xRC == null)
    {
      localdaa = new daa();
      AppMethodBeat.o(98661);
      return localdaa;
    }
    daa localdaa = this.xRC;
    AppMethodBeat.o(98661);
    return localdaa;
  }
  
  public final void lY(boolean paramBoolean)
  {
    AppMethodBeat.i(98659);
    if (this.rYm != null)
    {
      if (paramBoolean)
      {
        this.rYm.setVisibility(0);
        if ((com.tencent.mm.m.g.ZY().getInt("SnsAdAtFriendRedDot", 0) == 1) && (com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GSF, true)))
        {
          this.yKU.setVisibility(0);
          AppMethodBeat.o(98659);
          return;
        }
        this.yKU.setVisibility(8);
        AppMethodBeat.o(98659);
        return;
      }
      this.rYm.setVisibility(8);
      this.yKU.setVisibility(8);
    }
    AppMethodBeat.o(98659);
  }
  
  public final void o(final List<k> paramList, String paramString)
  {
    AppMethodBeat.i(98656);
    this.yLg = paramString;
    k localk;
    if (this.uyM != null)
    {
      if (bs.isNullOrNil(paramString)) {
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
    for (paramString = bs.bG(localk.text, "");; paramString = "")
    {
      if (!bs.isNullOrNil(paramString))
      {
        this.yKV.setVisibility(0);
        this.fTu.setVisibility(8);
        this.uyM.setText("");
        this.uyM.aRF(paramString);
      }
      for (;;)
      {
        if (!this.yLh) {
          this.uyM.addTextChangedListener(new TextWatcher()
          {
            int yLq = 0;
            
            public final void afterTextChanged(Editable paramAnonymousEditable)
            {
              AppMethodBeat.i(98642);
              if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
              {
                AppMethodBeat.o(98642);
                return;
              }
              if ((com.tencent.mm.plugin.sns.ui.widget.e.hJ(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!bs.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (!bs.isNullOrNil(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString())) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
              {
                ac.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", new Object[] { SnsCommentFooter.d(SnsCommentFooter.this), SnsCommentFooter.b(SnsCommentFooter.this).getText() });
                SnsCommentFooter.a(SnsCommentFooter.this, "");
                SnsCommentFooter.e(SnsCommentFooter.this);
                SnsCommentFooter.this.Pw(8);
                SnsCommentFooter.a(SnsCommentFooter.this, 0);
              }
              ac.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.f(SnsCommentFooter.this));
              if (!bs.isNullOrNil(SnsCommentFooter.f(SnsCommentFooter.this)))
              {
                paramAnonymousEditable = paramList.iterator();
                while (paramAnonymousEditable.hasNext())
                {
                  k localk = (k)paramAnonymousEditable.next();
                  if (SnsCommentFooter.f(SnsCommentFooter.this).equals(localk.key))
                  {
                    ac.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                    localk.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                    localk.drx = SnsCommentFooter.c(SnsCommentFooter.this);
                  }
                }
              }
              for (int i = 1;; i = 0)
              {
                if (i == 0)
                {
                  ac.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                  paramAnonymousEditable = new k();
                  paramAnonymousEditable.key = SnsCommentFooter.f(SnsCommentFooter.this);
                  paramAnonymousEditable.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                  paramAnonymousEditable.drx = SnsCommentFooter.c(SnsCommentFooter.this);
                  if ((paramAnonymousEditable.text != null) && (paramAnonymousEditable.text.length() > 0)) {
                    paramList.add(paramAnonymousEditable);
                  }
                }
                if (paramList.size() > 5)
                {
                  ac.d("MicroMsg.SnsCommentFooter", "comments remove");
                  paramList.remove(0);
                }
                SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
                if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
                for (boolean bool = true;; bool = false)
                {
                  if ((bool) && (SnsCommentFooter.this.uyQ))
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.uyQ = false;
                  }
                  if (!bool)
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.uyQ = true;
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
                this.yLq = paramAnonymousInt1;
                AppMethodBeat.o(98641);
                return;
              }
            }
            
            public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(98640);
              if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.xMh))
              {
                SnsCommentFooter.this.Pw(16);
                ac.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.o(98640);
                return;
              }
              if (paramAnonymousCharSequence.length() - this.yLq > a.xMh)
              {
                SnsCommentFooter.this.setCommentFlag(16);
                ac.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
              }
              AppMethodBeat.o(98640);
            }
          });
        }
        this.yLh = true;
        AppMethodBeat.o(98656);
        return;
        this.uyM.setText("");
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98664);
    super.onConfigurationChanged(paramConfiguration);
    if (this.fWT != null) {
      dPC();
    }
    AppMethodBeat.o(98664);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98668);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.yKX < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.yKX)
    {
      this.yKX = paramInt1;
      this.yKY = paramInt4;
      AppMethodBeat.o(98668);
      return;
    }
  }
  
  public final void rm(boolean paramBoolean)
  {
    AppMethodBeat.i(98653);
    if (this.fWT == null)
    {
      AppMethodBeat.o(98653);
      return;
    }
    this.yLf = paramBoolean;
    ac.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      this.fWT.setVisibility(8);
      this.uyL.setImageResource(2131690564);
      this.iMV.hideVKB();
      requestLayout();
      AppMethodBeat.o(98653);
      return;
    }
    if (this.state == 0)
    {
      this.uyM.requestFocus();
      this.iMV.showVKB();
      this.fWT.setVisibility(8);
    }
    for (;;)
    {
      this.uyP = false;
      AppMethodBeat.o(98653);
      return;
      this.uyM.requestFocus();
      this.iMV.hideVKB();
      bAC();
    }
  }
  
  public void setAfterEditAction(Runnable paramRunnable)
  {
    AppMethodBeat.i(98651);
    paramRunnable = (ViewGroup)inflate(this.iMV, 2131495541, this);
    this.rYm = ((ImageView)paramRunnable.findViewById(2131296545));
    this.yKU = ((ImageView)paramRunnable.findViewById(2131296546));
    this.fTu = ((Button)paramRunnable.findViewById(2131296560));
    this.yKV = ((Button)paramRunnable.findViewById(2131296553));
    this.uyM = ((MMEditText)paramRunnable.findViewById(2131296549));
    nM(false);
    this.rYm.setOnClickListener(new SnsCommentFooter.7(this));
    this.uyL = ((ImageButton)paramRunnable.findViewById(2131296558));
    this.uyL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98644);
        SnsCommentFooter.this.setModeClick(true);
        ac.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.i(SnsCommentFooter.this));
        if (SnsCommentFooter.i(SnsCommentFooter.this) == 0)
        {
          SnsCommentFooter.b(SnsCommentFooter.this).requestFocus();
          SnsCommentFooter.this.iMV.hideVKB();
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
        SnsCommentFooter.this.iMV.showVKB();
        SnsCommentFooter.this.setToSendTextColor(true);
        SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690564);
        SnsCommentFooter.a(SnsCommentFooter.this, 0);
        AppMethodBeat.o(98644);
      }
    });
    this.uyM.setHint(this.iMV.getString(2131764046));
    this.uyM.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(98645);
        SnsCommentFooter.this.setToSendTextColor(true);
        SnsCommentFooter.l(SnsCommentFooter.this);
        SnsCommentFooter.m(SnsCommentFooter.this);
        SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690564);
        if (SnsCommentFooter.n(SnsCommentFooter.this) != null) {
          SnsCommentFooter.n(SnsCommentFooter.this).dPx();
        }
        SnsCommentFooter.a(SnsCommentFooter.this, 0);
        AppMethodBeat.o(98645);
        return false;
      }
    });
    if (com.tencent.mm.pluginsdk.ui.chat.e.DyA == null)
    {
      this.fWT = new d(this.iMV);
      AppMethodBeat.o(98651);
      return;
    }
    this.fWT = com.tencent.mm.pluginsdk.ui.chat.e.DyA.eA(getContext());
    this.fWT.setEntranceScene(ChatFooterPanel.Dno);
    this.fWT.setVisibility(8);
    paramRunnable = (LinearLayout)findViewById(2131304239);
    this.yKZ = y.iy(getContext());
    paramRunnable.addView(this.fWT, -1, this.yKZ);
    if (!this.yLc) {
      this.fWT.eMH();
    }
    this.fWT.onResume();
    this.fWT.setOnTextOperationListener(new SnsCommentFooter.10(this));
    paramRunnable = aa.cGT.JQ();
    paramRunnable.cGS = new z.a()
    {
      public final void a(final com.tencent.mm.api.p paramAnonymousp)
      {
        AppMethodBeat.i(98631);
        if ((paramAnonymousp instanceof EmojiInfo))
        {
          boolean bool = false;
          String str;
          if ((SnsCommentFooter.o(SnsCommentFooter.this) != null) && (!bs.isNullOrNil(SnsCommentFooter.o(SnsCommentFooter.this).Username)))
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
          a.iyx.a(SnsCommentFooter.h(SnsCommentFooter.this), str, ((EmojiInfo)paramAnonymousp).field_md5, bool, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(98630);
              if ((SnsCommentFooter.q(SnsCommentFooter.this) != null) && (paramAnonymous2Boolean)) {
                if (!com.tencent.mm.plugin.sns.ui.widget.e.hJ(SnsCommentFooter.c(SnsCommentFooter.this), 8)) {
                  break label94;
                }
              }
              label94:
              for (paramAnonymous2String = SnsCommentFooter.this.getCommentAtPrefix();; paramAnonymous2String = "")
              {
                SnsCommentFooter.q(SnsCommentFooter.this).jH(paramAnonymous2String, ((EmojiInfo)paramAnonymousp).field_md5);
                com.tencent.mm.plugin.report.service.h.wUl.dB(150, 81);
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
    this.fWT.setCallback(paramRunnable);
    AppMethodBeat.o(98651);
  }
  
  public void setAnitiomAdjust(bn parambn)
  {
    this.yLk = parambn;
  }
  
  public void setCommentAtPrefix(String paramString)
  {
    this.yLa = paramString;
  }
  
  public void setCommentFlag(int paramInt)
  {
    this.yKW |= paramInt;
  }
  
  public void setCommentHint(String paramString)
  {
    AppMethodBeat.i(98658);
    if (!bs.isNullOrNil(paramString))
    {
      if (com.tencent.mm.plugin.sns.ui.widget.e.hJ(this.yKW, 1))
      {
        this.uyM.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.iMV.getString(2131763743) + paramString + this.iMV.getString(2131763775, new Object[] { Float.valueOf(this.uyM.getTextSize()) }), this.uyM.getTextSize()));
        AppMethodBeat.o(98658);
        return;
      }
      this.uyM.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), paramString, this.uyM.getTextSize()));
      AppMethodBeat.o(98658);
      return;
    }
    this.uyM.setHint("");
    AppMethodBeat.o(98658);
  }
  
  public void setCommentInfo(daa paramdaa)
  {
    this.xRC = paramdaa;
  }
  
  public void setFeedEmojiCommentEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(176296);
    this.yLd = paramBoolean;
    ac.i("MicroMsg.SnsCommentFooter", "setFeedEmojiCommentEnable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(176296);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.uyN = paramBoolean;
  }
  
  public void setOnCommentSendImp(final b paramb)
  {
    AppMethodBeat.i(98663);
    this.yLb = paramb;
    this.yKV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98634);
        paramAnonymousView = c.d(SnsCommentFooter.b(SnsCommentFooter.this)).acw(com.tencent.mm.m.b.ZC());
        paramAnonymousView.IVj = true;
        paramAnonymousView.a(new c.a()
        {
          public final void GK(String paramAnonymous2String)
          {
            AppMethodBeat.i(98632);
            SnsCommentFooter.2.this.yLo.jH(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString(), "");
            SnsCommentFooter.b(SnsCommentFooter.this).setText("");
            AppMethodBeat.o(98632);
          }
          
          public final void aRi() {}
          
          public final void ca(String paramAnonymous2String)
          {
            AppMethodBeat.i(163118);
            com.tencent.mm.ui.base.h.l(SnsCommentFooter.h(SnsCommentFooter.this), 2131764058, 2131764059);
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
    this.yLi = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.yLj = paramc;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98657);
    if (this.uyM != null)
    {
      this.uyM.setText("");
      this.uyM.aRF(paramString);
    }
    AppMethodBeat.o(98657);
  }
  
  public void setToSendTextColor(boolean paramBoolean)
  {
    AppMethodBeat.i(98662);
    if (this.uyM == null)
    {
      AppMethodBeat.o(98662);
      return;
    }
    if (paramBoolean)
    {
      this.uyM.setTextColor(getResources().getColor(2131100636));
      AppMethodBeat.o(98662);
      return;
    }
    this.uyM.setTextColor(getResources().getColor(2131100482));
    ac.i("MicroMsg.SnsCommentFooter", "focusEdt: %s, %s", new Object[] { Boolean.FALSE, this.uyM });
    if (this.uyM != null) {
      this.uyM.clearFocus();
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
    rm(bool);
    super.setVisibility(paramInt);
    AppMethodBeat.o(98652);
  }
  
  static abstract interface a
  {
    public abstract void dPx();
  }
  
  static abstract interface b
  {
    public abstract void jH(String paramString1, String paramString2);
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