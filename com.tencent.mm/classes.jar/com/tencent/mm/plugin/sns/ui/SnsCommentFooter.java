package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.List;

public class SnsCommentFooter
  extends InputPanelLinearLayout
{
  MMActivity cmc;
  ChatFooterPanel eys;
  private int kjA;
  private ImageButton kjv;
  private int kjy;
  private int kjz;
  MMEditText oxm;
  private Button oxn;
  private boolean oxo;
  public boolean oxp;
  private boolean oxq;
  boolean oxr;
  private TextWatcher oxs;
  private ImageView rPX;
  private ImageView rPY;
  private Button rPZ;
  int rQa;
  private String rQb;
  private boolean rQc;
  public boolean rQd;
  private String rQe;
  private boolean rQf;
  private SnsCommentFooter.a rQg;
  private SnsCommentFooter.c rQh;
  private bf rQi;
  cds reJ;
  int state;
  
  public SnsCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38890);
    this.reJ = null;
    this.rQa = 0;
    this.state = 0;
    this.oxo = false;
    this.kjy = -1;
    this.kjz = -1;
    this.kjA = 0;
    this.rQc = x.gN(getContext());
    this.oxp = false;
    this.oxq = true;
    this.rQe = "";
    this.rQf = false;
    this.oxr = true;
    this.oxs = new SnsCommentFooter.4(this);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(38890);
  }
  
  private void aRl()
  {
    AppMethodBeat.i(38894);
    this.eys.onResume();
    if ((x.gN(getContext())) && (cvg())) {
      getInputPanelHelper().az(new SnsCommentFooter.2(this));
    }
    for (;;)
    {
      if (this.rQh != null) {
        this.rQh.onShow();
      }
      AppMethodBeat.o(38894);
      return;
      this.eys.setVisibility(0);
    }
  }
  
  private void baf()
  {
    AppMethodBeat.i(38905);
    int i = x.gL(getContext());
    if (this.eys != null)
    {
      this.eys.setPortHeightPx(i);
      this.eys.AD();
      ViewGroup.LayoutParams localLayoutParams = this.eys.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.height = i;
      }
    }
    AppMethodBeat.o(38905);
  }
  
  private boolean cvg()
  {
    AppMethodBeat.i(38906);
    int i = af.fx(getContext());
    ab.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.kjz), Integer.valueOf(this.kjy), Integer.valueOf(i) });
    if ((this.kjz > 0) && (this.kjz < this.kjy - i))
    {
      AppMethodBeat.o(38906);
      return true;
    }
    AppMethodBeat.o(38906);
    return false;
  }
  
  private void jf(boolean paramBoolean)
  {
    AppMethodBeat.i(38909);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2131034217);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2131034222);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if ((this.oxn == null) || (this.rPZ == null))
    {
      AppMethodBeat.o(38909);
      return;
    }
    if (paramBoolean)
    {
      if ((this.oxn.getVisibility() == 8) || (this.oxn.getVisibility() == 4))
      {
        AppMethodBeat.o(38909);
        return;
      }
      this.rPZ.startAnimation(localAnimation1);
      this.rPZ.setVisibility(0);
      this.oxn.startAnimation(localAnimation2);
      this.oxn.setVisibility(8);
    }
    for (;;)
    {
      this.rPZ.getParent().requestLayout();
      AppMethodBeat.o(38909);
      return;
      if ((this.oxn.getVisibility() == 0) || (this.oxn.getVisibility() == 0))
      {
        AppMethodBeat.o(38909);
        return;
      }
      this.oxn.startAnimation(localAnimation1);
      this.oxn.setVisibility(0);
      this.rPZ.startAnimation(localAnimation2);
      this.rPZ.setVisibility(8);
    }
  }
  
  public final void EN(int paramInt)
  {
    this.rQa &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final void bOo()
  {
    AppMethodBeat.i(38908);
    this.rQi = null;
    if (this.eys != null)
    {
      ab.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.eys.Ay();
      this.eys.destroy();
    }
    AppMethodBeat.o(38908);
  }
  
  public final boolean cvc()
  {
    AppMethodBeat.i(38889);
    if ((this.oxm.getText() == null) || (bo.isNullOrNil(this.oxm.getText().toString())))
    {
      AppMethodBeat.o(38889);
      return true;
    }
    AppMethodBeat.o(38889);
    return false;
  }
  
  public final boolean cvd()
  {
    return this.state == 1;
  }
  
  public final void cve()
  {
    AppMethodBeat.i(38895);
    if (this.oxm == null)
    {
      ab.e("MicroMsg.SnsCommentFooter", "send edittext is null");
      AppMethodBeat.o(38895);
      return;
    }
    this.oxm.removeTextChangedListener(this.oxs);
    this.oxm.addTextChangedListener(this.oxs);
    AppMethodBeat.o(38895);
  }
  
  public final void cvf()
  {
    AppMethodBeat.i(38900);
    this.oxm.setText("");
    this.oxm.setHint("");
    this.reJ = null;
    this.rQa = 0;
    this.state = 0;
    AppMethodBeat.o(38900);
  }
  
  public String getCommentAtPrefix()
  {
    return this.rQb;
  }
  
  public int getCommentFlag()
  {
    return this.rQa;
  }
  
  public cds getCommentInfo()
  {
    AppMethodBeat.i(38901);
    if (this.reJ == null)
    {
      localcds = new cds();
      AppMethodBeat.o(38901);
      return localcds;
    }
    cds localcds = this.reJ;
    AppMethodBeat.o(38901);
    return localcds;
  }
  
  public final void h(List<k> paramList, String paramString)
  {
    AppMethodBeat.i(38896);
    this.rQe = paramString;
    k localk;
    if (this.oxm != null)
    {
      if (bo.isNullOrNil(paramString)) {
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
    for (paramString = bo.bf(localk.text, "");; paramString = "")
    {
      if (!bo.isNullOrNil(paramString))
      {
        this.rPZ.setVisibility(0);
        this.oxn.setVisibility(8);
        this.oxm.setText("");
        this.oxm.avk(paramString);
      }
      for (;;)
      {
        if (!this.rQf) {
          this.oxm.addTextChangedListener(new SnsCommentFooter.5(this, paramList));
        }
        this.rQf = true;
        AppMethodBeat.o(38896);
        return;
        this.oxm.setText("");
      }
    }
  }
  
  public final void lC(boolean paramBoolean)
  {
    AppMethodBeat.i(38893);
    if (this.eys == null)
    {
      AppMethodBeat.o(38893);
      return;
    }
    this.rQd = paramBoolean;
    ab.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      this.eys.setVisibility(8);
      this.kjv.setImageResource(2131231506);
      this.cmc.hideVKB();
      requestLayout();
      AppMethodBeat.o(38893);
      return;
    }
    if (this.state == 0)
    {
      this.cmc.showVKB();
      this.oxm.requestFocus();
      this.eys.setVisibility(8);
    }
    for (;;)
    {
      this.oxq = false;
      AppMethodBeat.o(38893);
      return;
      this.cmc.hideVKB();
      this.oxm.requestFocus();
      aRl();
    }
  }
  
  public final void lD(boolean paramBoolean)
  {
    AppMethodBeat.i(38899);
    if (this.rPX != null)
    {
      if (paramBoolean)
      {
        this.rPX.setVisibility(0);
        if ((com.tencent.mm.m.g.Nq().getInt("SnsAdAtFriendRedDot", 0) == 1) && (com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yLq, true)))
        {
          this.rPY.setVisibility(0);
          AppMethodBeat.o(38899);
          return;
        }
        this.rPY.setVisibility(8);
        AppMethodBeat.o(38899);
        return;
      }
      this.rPX.setVisibility(8);
      this.rPY.setVisibility(8);
    }
    AppMethodBeat.o(38899);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38903);
    super.onConfigurationChanged(paramConfiguration);
    if (this.eys != null) {
      baf();
    }
    AppMethodBeat.o(38903);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38907);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.kjy < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.kjy)
    {
      this.kjy = paramInt1;
      this.kjz = paramInt4;
      AppMethodBeat.o(38907);
      return;
    }
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(38904);
    super.p(paramBoolean, paramInt);
    this.oxp = paramBoolean;
    if ((paramBoolean) && (getVisibility() == 0) && (this.rQi != null))
    {
      ab.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
      this.rQi.cwI();
    }
    if ((this.kjA != paramInt) && (paramInt != 0))
    {
      this.kjA = paramInt;
      com.tencent.mm.compatible.util.j.z(getContext(), paramInt);
      baf();
    }
    AppMethodBeat.o(38904);
  }
  
  public void setAfterEditAction(Runnable paramRunnable)
  {
    AppMethodBeat.i(38891);
    paramRunnable = (ViewGroup)inflate(this.cmc, 2130970819, this);
    this.rPX = ((ImageView)paramRunnable.findViewById(2131827963));
    this.rPY = ((ImageView)paramRunnable.findViewById(2131827964));
    this.oxn = ((Button)paramRunnable.findViewById(2131827966));
    this.rPZ = ((Button)paramRunnable.findViewById(2131827967));
    this.oxm = ((MMEditText)paramRunnable.findViewById(2131827965));
    jf(false);
    this.rPX.setOnClickListener(new SnsCommentFooter.6(this));
    this.kjv = ((ImageButton)paramRunnable.findViewById(2131825850));
    this.kjv.setOnClickListener(new SnsCommentFooter.7(this));
    this.oxm.setHint(this.cmc.getString(2131304029));
    this.oxm.setOnTouchListener(new SnsCommentFooter.8(this));
    if (com.tencent.mm.pluginsdk.ui.chat.e.vYI == null)
    {
      this.eys = new com.tencent.mm.pluginsdk.ui.chat.d(this.cmc);
      AppMethodBeat.o(38891);
      return;
    }
    this.eys = com.tencent.mm.pluginsdk.ui.chat.e.vYI.dK(getContext());
    this.eys.setEntranceScene(ChatFooterPanel.vQn);
    this.eys.setVisibility(8);
    this.eys.setBackgroundResource(2130838214);
    paramRunnable = (LinearLayout)findViewById(2131821003);
    this.kjA = x.gL(getContext());
    paramRunnable.addView(this.eys, -1, this.kjA);
    this.eys.Az();
    this.eys.bo(false);
    this.eys.onResume();
    this.eys.setOnTextOperationListener(new SnsCommentFooter.9(this));
    AppMethodBeat.o(38891);
  }
  
  public void setAnitiomAdjust(bf parambf)
  {
    this.rQi = parambf;
  }
  
  public void setCommentAtPrefix(String paramString)
  {
    this.rQb = paramString;
  }
  
  public void setCommentFlag(int paramInt)
  {
    this.rQa |= paramInt;
  }
  
  public void setCommentHint(String paramString)
  {
    AppMethodBeat.i(38898);
    if (!bo.isNullOrNil(paramString))
    {
      if (com.tencent.mm.plugin.sns.ui.widget.d.fS(this.rQa, 1))
      {
        this.oxm.setHint(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), this.cmc.getString(2131303742) + paramString + this.cmc.getString(2131303772, new Object[] { Float.valueOf(this.oxm.getTextSize()) }), this.oxm.getTextSize()));
        AppMethodBeat.o(38898);
        return;
      }
      this.oxm.setHint(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), paramString, this.oxm.getTextSize()));
      AppMethodBeat.o(38898);
      return;
    }
    this.oxm.setHint("");
    AppMethodBeat.o(38898);
  }
  
  public void setCommentInfo(cds paramcds)
  {
    this.reJ = paramcds;
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.oxo = paramBoolean;
  }
  
  public void setOnCommentSendImp(final SnsCommentFooter.b paramb)
  {
    AppMethodBeat.i(38902);
    this.rPZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38875);
        paramAnonymousView = c.d(SnsCommentFooter.b(SnsCommentFooter.this)).QS(com.tencent.mm.m.b.MS());
        paramAnonymousView.AyD = true;
        paramAnonymousView.a(new SnsCommentFooter.1.1(this));
        AppMethodBeat.o(38875);
      }
    });
    AppMethodBeat.o(38902);
  }
  
  public void setOnEditTouchListener(SnsCommentFooter.a parama)
  {
    this.rQg = parama;
  }
  
  public void setOnSmileyShowListener(SnsCommentFooter.c paramc)
  {
    this.rQh = paramc;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(38897);
    if (this.oxm != null)
    {
      this.oxm.setText("");
      this.oxm.avk(paramString);
    }
    AppMethodBeat.o(38897);
  }
  
  public void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(38892);
    this.state = 0;
    if (paramInt == 0) {
      bool = true;
    }
    lC(bool);
    super.setVisibility(paramInt);
    AppMethodBeat.o(38892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter
 * JD-Core Version:    0.7.0.1
 */