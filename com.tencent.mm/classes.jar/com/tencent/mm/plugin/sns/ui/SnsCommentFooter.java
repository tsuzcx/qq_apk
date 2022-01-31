package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SnsCommentFooter
  extends BasePanelKeybordLayout
{
  MMActivity bER;
  ChatFooterPanel jpC;
  private ImageButton kEW;
  MMEditText lXN;
  private Button lXO;
  private boolean lXP = false;
  public boolean lXQ = false;
  private boolean lXR = true;
  boolean lXS = true;
  private TextWatcher lXT = new SnsCommentFooter.3(this);
  private ImageView oXA;
  private Button oXB;
  private int oXC = 0;
  private boolean oXD = false;
  private boolean oXE = false;
  private int oXF = -1;
  private int oXG = -1;
  private String oXH;
  private boolean oXI = u.fA(getContext());
  public boolean oXJ;
  private String oXK = "";
  private boolean oXL = false;
  private SnsCommentFooter.a oXM;
  private SnsCommentFooter.d oXN;
  private bh oXO;
  ImageView oXz;
  btd oqc = null;
  int state = 0;
  
  public SnsCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
  }
  
  private void ash()
  {
    this.jpC.onResume();
    int i;
    if (u.fA(getContext()))
    {
      i = ak.gv(getContext());
      y.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.oXG), Integer.valueOf(this.oXF), Integer.valueOf(i) });
      if ((this.oXG > 0) && (this.oXG < this.oXF - i))
      {
        i = 1;
        if (i == 0) {
          break label182;
        }
        this.oXE = true;
        postDelayed(new SnsCommentFooter.2(this), 100L);
      }
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jpC.getLayoutParams();
      if ((localLayoutParams != null) && ((this.lXR) || (localLayoutParams.height == 0)))
      {
        localLayoutParams.height = com.tencent.mm.compatible.util.j.fy(getContext());
        this.jpC.setLayoutParams(localLayoutParams);
        this.lXR = false;
      }
      if (this.oXN != null) {
        this.oXN.onShow();
      }
      return;
      i = 0;
      break;
      label182:
      this.jpC.setVisibility(0);
    }
  }
  
  private void hideSmileyPanel()
  {
    this.jpC.onPause();
    if (u.fA(getContext()))
    {
      this.oXD = true;
      return;
    }
    this.jpC.setVisibility(8);
  }
  
  private void ho(boolean paramBoolean)
  {
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), i.a.pop_in);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), i.a.pop_out);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if ((this.lXO == null) || (this.oXB == null)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while ((this.lXO.getVisibility() == 8) || (this.lXO.getVisibility() == 4));
    this.oXB.startAnimation(localAnimation1);
    this.oXB.setVisibility(0);
    this.lXO.startAnimation(localAnimation2);
    this.lXO.setVisibility(8);
    for (;;)
    {
      this.oXB.getParent().requestLayout();
      return;
      if ((this.lXO.getVisibility() == 0) || (this.lXO.getVisibility() == 0)) {
        break;
      }
      this.lXO.startAnimation(localAnimation1);
      this.lXO.setVisibility(0);
      this.oXB.startAnimation(localAnimation2);
      this.oXB.setVisibility(8);
    }
  }
  
  public final boolean bII()
  {
    return (this.lXN.getText() == null) || (bk.bl(this.lXN.getText().toString()));
  }
  
  public final boolean bIJ()
  {
    return this.state == 1;
  }
  
  public final void bIK()
  {
    if (this.lXN == null)
    {
      y.e("MicroMsg.SnsCommentFooter", "send edittext is null");
      return;
    }
    this.lXN.removeTextChangedListener(this.lXT);
    this.lXN.addTextChangedListener(this.lXT);
  }
  
  public final void bIL()
  {
    this.lXN.setText("");
    this.lXN.setHint("");
    this.oqc = null;
    this.oXC = 0;
    this.state = 0;
  }
  
  public final void bgu()
  {
    this.oXO = null;
    if (this.jpC != null)
    {
      y.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.jpC.sj();
      this.jpC.destroy();
    }
  }
  
  public String getCommentAtPrefix()
  {
    return this.oXH;
  }
  
  public int getCommentFlag()
  {
    return this.oXC;
  }
  
  public btd getCommentInfo()
  {
    if (this.oqc == null) {
      return new btd();
    }
    return this.oqc;
  }
  
  protected List<View> getPanelView()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jpC);
    return localArrayList;
  }
  
  public final void h(List<k> paramList, String paramString)
  {
    this.oXK = paramString;
    k localk;
    if (this.lXN != null)
    {
      if (bk.bl(paramString)) {
        break label160;
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
    label160:
    for (paramString = bk.aM(localk.text, "");; paramString = "")
    {
      if (!bk.bl(paramString))
      {
        this.oXB.setVisibility(0);
        this.lXO.setVisibility(8);
        this.lXN.setText("");
        this.lXN.aex(paramString);
      }
      for (;;)
      {
        if (!this.oXL) {
          this.lXN.addTextChangedListener(new SnsCommentFooter.4(this, paramList));
        }
        this.oXL = true;
        return;
        this.lXN.setText("");
      }
    }
  }
  
  public final void jw(boolean paramBoolean)
  {
    if (this.jpC == null) {
      return;
    }
    this.oXJ = paramBoolean;
    y.i("MicroMsg.SnsCommentFooter", "showState " + paramBoolean);
    if (!paramBoolean)
    {
      this.jpC.setVisibility(8);
      this.kEW.setImageResource(i.i.textfield_icon_emoji_normal);
      this.bER.XM();
      requestLayout();
      return;
    }
    if (this.state == 0)
    {
      this.bER.showVKB();
      this.lXN.requestFocus();
      this.jpC.setVisibility(8);
    }
    for (;;)
    {
      this.lXR = false;
      return;
      this.bER.XM();
      this.lXN.requestFocus();
      ash();
    }
  }
  
  public final void jx(boolean paramBoolean)
  {
    if (this.oXA != null)
    {
      if (paramBoolean) {
        this.oXA.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.oXA.setVisibility(8);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.oXE) || (this.oXD)) {
      y.i("MicroMsg.SnsCommentFooter", "onLayout maxBottom %d currBottom %d layoutBottom %d", new Object[] { Integer.valueOf(this.oXF), Integer.valueOf(this.oXG), Integer.valueOf(paramInt4) });
    }
    if ((this.oXE) && (this.jpC != null) && (this.oXG != paramInt4))
    {
      this.jpC.setVisibility(0);
      this.oXE = false;
    }
    if (this.oXF < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.oXF)
    {
      this.oXF = paramInt1;
      this.oXG = paramInt4;
      if ((this.oXD) && (this.jpC != null))
      {
        this.jpC.setVisibility(8);
        this.oXD = false;
      }
      if (u.fA(getContext()) != this.oXI)
      {
        this.jpC.setPortHeightPx(u.fy(getContext()));
        this.jpC.refresh();
        this.oXI = u.fA(getContext());
        hideSmileyPanel();
        this.kEW.setImageResource(i.e.chatting_setmode_biaoqing_btn);
        this.state = 0;
      }
      return;
    }
  }
  
  protected final void rD(int paramInt)
  {
    super.rD(paramInt);
    switch (paramInt)
    {
    default: 
      this.lXQ = false;
    }
    do
    {
      return;
      this.lXQ = true;
    } while ((getVisibility() != 0) || (this.oXO == null));
    y.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
    this.oXO.bKg();
  }
  
  public void setAfterEditAction(Runnable paramRunnable)
  {
    paramRunnable = (ViewGroup)inflate(this.bER, i.g.sns_comment_footer, this);
    this.oXz = ((ImageView)paramRunnable.findViewById(i.f.sns_liked_iv));
    this.oXA = ((ImageView)paramRunnable.findViewById(i.f.album_comment_at_btn));
    this.lXO = ((Button)paramRunnable.findViewById(i.f.album_comment_send_btn));
    this.oXB = ((Button)paramRunnable.findViewById(i.f.album_comment_green_send_btn));
    this.lXN = ((MMEditText)paramRunnable.findViewById(i.f.album_comment_content_et));
    ho(false);
    this.oXA.setOnClickListener(new SnsCommentFooter.5(this));
    this.kEW = ((ImageButton)paramRunnable.findViewById(i.f.album_comment_mode_iv));
    this.kEW.setOnClickListener(new SnsCommentFooter.6(this));
    this.lXN.setHint(this.bER.getString(i.j.sns_ui_comment));
    this.lXN.setOnTouchListener(new SnsCommentFooter.7(this));
    if (e.sgr == null)
    {
      this.jpC = new d(this.bER);
      return;
    }
    this.jpC = e.sgr.cX(getContext());
    this.jpC.setEntranceScene(ChatFooterPanel.SCENE_SNS);
    this.jpC.setVisibility(8);
    this.jpC.setBackgroundResource(i.e.bottombar_bg);
    ((LinearLayout)findViewById(i.f.root)).addView(this.jpC, -1, 0);
    this.jpC.sk();
    this.jpC.aN(false);
    this.jpC.setOnTextOperationListener(new SnsCommentFooter.8(this));
  }
  
  public void setAnitiomAdjust(bh parambh)
  {
    this.oXO = parambh;
  }
  
  public void setCommentAtPrefix(String paramString)
  {
    this.oXH = paramString;
  }
  
  public void setCommentFlag(int paramInt)
  {
    this.oXC = paramInt;
  }
  
  public void setCommentHint(String paramString)
  {
    if (!bk.bl(paramString))
    {
      if (this.oXC == 1)
      {
        this.lXN.setHint(com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), this.bER.getString(i.j.sns_ad_at_tips1) + paramString + this.bER.getString(i.j.sns_after_reply, new Object[] { Float.valueOf(this.lXN.getTextSize()) }), this.lXN.getTextSize()));
        return;
      }
      this.lXN.setHint(com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), paramString, this.lXN.getTextSize()));
      return;
    }
    this.lXN.setHint("");
  }
  
  public void setCommentInfo(btd parambtd)
  {
    this.oqc = parambtd;
  }
  
  public void setHeartBtnVisibility(int paramInt)
  {
    this.oXz.setVisibility(paramInt);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.lXP = paramBoolean;
  }
  
  public final void setOnCommentLikedImp$632a1e7b(SnsCommentFooter.b paramb)
  {
    this.oXz.setVisibility(0);
    this.oXz.setOnClickListener(new SnsCommentFooter.1(this, paramb));
  }
  
  public void setOnCommentSendImp(SnsCommentFooter.c paramc)
  {
    this.oXB.setOnClickListener(new SnsCommentFooter.9(this, paramc));
  }
  
  public void setOnEditTouchListener(SnsCommentFooter.a parama)
  {
    this.oXM = parama;
  }
  
  public void setOnSmileyShowListener(SnsCommentFooter.d paramd)
  {
    this.oXN = paramd;
  }
  
  public void setText(String paramString)
  {
    if (this.lXN != null)
    {
      this.lXN.setText("");
      this.lXN.aex(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    boolean bool = false;
    this.state = 0;
    if (paramInt == 0) {
      bool = true;
    }
    jw(bool);
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter
 * JD-Core Version:    0.7.0.1
 */