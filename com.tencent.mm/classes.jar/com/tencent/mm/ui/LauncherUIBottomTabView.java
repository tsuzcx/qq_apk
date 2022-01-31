package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.tools.t;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements c
{
  protected int eSO;
  private long nBO;
  private ak yZA;
  private int yZB;
  private int yZC;
  private int yZD;
  private boolean yZE;
  private boolean yZF;
  private int yZG;
  private boolean yZH;
  private c.a yZh;
  protected LauncherUIBottomTabView.a yZi;
  protected LauncherUIBottomTabView.a yZj;
  protected LauncherUIBottomTabView.a yZk;
  protected LauncherUIBottomTabView.a yZl;
  private int yZm;
  private int yZn;
  private int yZo;
  private int yZp;
  private int yZq;
  private int yZr;
  private int yZs;
  private int yZt;
  private int yZu;
  private int yZv;
  private int yZw;
  private int yZx;
  private int yZy;
  protected View.OnClickListener yZz;
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(29488);
    this.eSO = 0;
    this.yZm = 0;
    this.yZq = 0;
    this.nBO = 0L;
    this.yZx = -1;
    this.yZy = 0;
    this.yZz = new LauncherUIBottomTabView.1(this);
    this.yZA = new LauncherUIBottomTabView.2(this);
    this.yZB = 0;
    this.yZC = 0;
    this.yZD = 0;
    this.yZE = false;
    this.yZF = false;
    this.yZG = 0;
    this.yZH = false;
    init();
    AppMethodBeat.o(29488);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29489);
    this.eSO = 0;
    this.yZm = 0;
    this.yZq = 0;
    this.nBO = 0L;
    this.yZx = -1;
    this.yZy = 0;
    this.yZz = new LauncherUIBottomTabView.1(this);
    this.yZA = new LauncherUIBottomTabView.2(this);
    this.yZB = 0;
    this.yZC = 0;
    this.yZD = 0;
    this.yZE = false;
    this.yZF = false;
    this.yZG = 0;
    this.yZH = false;
    init();
    AppMethodBeat.o(29489);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29490);
    this.eSO = 0;
    this.yZm = 0;
    this.yZq = 0;
    this.nBO = 0L;
    this.yZx = -1;
    this.yZy = 0;
    this.yZz = new LauncherUIBottomTabView.1(this);
    this.yZA = new LauncherUIBottomTabView.2(this);
    this.yZB = 0;
    this.yZC = 0;
    this.yZD = 0;
    this.yZE = false;
    this.yZF = false;
    this.yZG = 0;
    this.yZH = false;
    init();
    AppMethodBeat.o(29490);
  }
  
  private LauncherUIBottomTabView.a Od(int paramInt)
  {
    AppMethodBeat.i(29491);
    LauncherUIBottomTabView.a locala = new LauncherUIBottomTabView.a(this);
    if (a.gu(getContext())) {
      b.SH();
    }
    for (locala.yZJ = b.b((Activity)getContext(), 2130970154);; locala.yZJ = b.b((Activity)getContext(), 2130970153))
    {
      locala.yZK = ((TabIconView)locala.yZJ.findViewById(2131821253));
      locala.yZL = ((TextView)locala.yZJ.findViewById(2131826164));
      locala.yZM = ((TextView)locala.yZJ.findViewById(2131826163));
      locala.yZM.setBackgroundResource(t.iF(getContext()));
      locala.yZN = ((ImageView)locala.yZJ.findViewById(2131820977));
      locala.yZJ.setTag(Integer.valueOf(paramInt));
      locala.yZJ.setOnClickListener(this.yZz);
      float f1 = a.ap(getContext(), 2131427862);
      float f2 = a.gr(getContext());
      locala.yZL.setTextSize(0, f1 * f2);
      AppMethodBeat.o(29491);
      return locala;
      b.SH();
    }
  }
  
  private LauncherUIBottomTabView.a b(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(29492);
    LauncherUIBottomTabView.a locala = Od(0);
    locala.yZJ.setId(-16777215);
    locala.yZL.setText(2131301430);
    locala.yZL.setTextColor(getResources().getColor(2131690308));
    locala.yZK.g(2131231445, 2131231494, 2131231493, a.gu(getContext()));
    locala.yZM.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.yZy);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.yZJ, localLayoutParams);
    AppMethodBeat.o(29492);
    return locala;
  }
  
  private LauncherUIBottomTabView.a c(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(29493);
    LauncherUIBottomTabView.a locala = Od(1);
    locala.yZJ.setId(-16777214);
    locala.yZL.setText(2131301392);
    locala.yZL.setTextColor(getResources().getColor(2131690309));
    locala.yZK.g(2131231448, 2131231499, 2131231498, a.gu(getContext()));
    locala.yZM.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.yZy);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.yZJ, localLayoutParams);
    AppMethodBeat.o(29493);
    return locala;
  }
  
  private LauncherUIBottomTabView.a d(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(29494);
    LauncherUIBottomTabView.a locala = Od(2);
    locala.yZJ.setId(-16777213);
    locala.yZL.setText(2131301390);
    locala.yZL.setTextColor(getResources().getColor(2131690309));
    locala.yZK.g(2131231453, 2131231503, 2131231502, a.gu(getContext()));
    locala.yZM.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.yZy);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.yZJ, localLayoutParams);
    AppMethodBeat.o(29494);
    return locala;
  }
  
  private LauncherUIBottomTabView.a e(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(29495);
    LauncherUIBottomTabView.a locala = Od(3);
    locala.yZJ.setId(-16777212);
    locala.yZL.setText(2131301424);
    locala.yZL.setTextColor(getResources().getColor(2131690309));
    locala.yZK.g(2131231460, 2131231513, 2131231513, a.gu(getContext()));
    locala.yZM.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.yZy);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(locala.yZJ, localLayoutParams);
    AppMethodBeat.o(29495);
    return locala;
  }
  
  private void init()
  {
    AppMethodBeat.i(29496);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setBackgroundColor(getResources().getColor(2131689499));
    localLinearLayout.setOrientation(0);
    addView(localLinearLayout, new RelativeLayout.LayoutParams(-1, -2));
    this.yZy = ((int)(a.ap(getContext(), 2131427563) * a.gr(getContext())));
    this.yZi = b(localLinearLayout);
    this.yZk = c(localLinearLayout);
    this.yZj = d(localLinearLayout);
    this.yZl = e(localLinearLayout);
    this.yZm = getResources().getColor(2131690308);
    this.yZn = ((this.yZm & 0xFF0000) >> 16);
    this.yZo = ((this.yZm & 0xFF00) >> 8);
    this.yZp = (this.yZm & 0xFF);
    this.yZq = getResources().getColor(2131690309);
    this.yZr = ((this.yZq & 0xFF0000) >> 16);
    this.yZs = ((this.yZq & 0xFF00) >> 8);
    this.yZt = (this.yZq & 0xFF);
    this.yZu = (this.yZn - this.yZr);
    this.yZv = (this.yZo - this.yZs);
    this.yZw = (this.yZp - this.yZt);
    AppMethodBeat.o(29496);
  }
  
  public final void NU(int paramInt)
  {
    AppMethodBeat.i(29497);
    ab.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.yZB = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.yZi.yZM.setText("");
        this.yZi.yZM.setBackgroundResource(2131230963);
        this.yZi.yZM.setTextSize(0, a.ap(getContext(), 2131428775));
        this.yZi.yZM.setVisibility(0);
        this.yZi.yZN.setVisibility(4);
        AppMethodBeat.o(29497);
        return;
      }
      this.yZi.yZM.setText(String.valueOf(paramInt));
      this.yZi.yZM.setBackgroundResource(t.iF(getContext()));
      this.yZi.yZM.setTextSize(0, a.ap(getContext(), 2131428775) * a.gr(getContext()));
      this.yZi.yZM.setVisibility(0);
      this.yZi.yZN.setVisibility(4);
      AppMethodBeat.o(29497);
      return;
    }
    this.yZi.yZM.setText("");
    this.yZi.yZM.setVisibility(4);
    AppMethodBeat.o(29497);
  }
  
  public final void NV(int paramInt)
  {
    AppMethodBeat.i(29498);
    this.yZC = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.yZk.yZM.setText("");
        this.yZk.yZM.setBackgroundResource(2131230963);
        this.yZk.yZM.setTextSize(0, a.ap(getContext(), 2131428775));
        this.yZk.yZM.setVisibility(0);
        this.yZk.yZN.setVisibility(4);
        AppMethodBeat.o(29498);
        return;
      }
      this.yZk.yZM.setText(String.valueOf(paramInt));
      this.yZk.yZM.setTextSize(0, a.ap(getContext(), 2131428775) * a.gr(getContext()));
      this.yZk.yZM.setBackgroundResource(t.iF(getContext()));
      this.yZk.yZM.setVisibility(0);
      this.yZk.yZN.setVisibility(4);
      AppMethodBeat.o(29498);
      return;
    }
    this.yZk.yZM.setText("");
    this.yZk.yZM.setVisibility(4);
    AppMethodBeat.o(29498);
  }
  
  public final void NW(int paramInt)
  {
    AppMethodBeat.i(29499);
    this.yZD = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.yZj.yZM.setText("");
        this.yZj.yZM.setBackgroundResource(2131230963);
        this.yZj.yZM.setTextSize(0, a.ap(getContext(), 2131428775));
        this.yZj.yZM.setVisibility(0);
        this.yZj.yZN.setVisibility(4);
        AppMethodBeat.o(29499);
        return;
      }
      this.yZj.yZM.setText(String.valueOf(paramInt));
      this.yZj.yZM.setTextSize(0, a.ap(getContext(), 2131428775) * a.gr(getContext()));
      this.yZj.yZM.setVisibility(0);
      this.yZj.yZM.setBackgroundResource(t.iF(getContext()));
      this.yZj.yZN.setVisibility(4);
      AppMethodBeat.o(29499);
      return;
    }
    this.yZj.yZM.setText("");
    this.yZj.yZM.setVisibility(4);
    AppMethodBeat.o(29499);
  }
  
  public final void NX(int paramInt)
  {
    AppMethodBeat.i(29502);
    if (this.yZF)
    {
      AppMethodBeat.o(29502);
      return;
    }
    this.yZG = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.yZl.yZM.setText("");
        this.yZl.yZM.setBackgroundResource(2131230963);
        this.yZl.yZM.setTextSize(0, a.ap(getContext(), 2131428775));
        this.yZl.yZM.setVisibility(0);
        this.yZl.yZN.setVisibility(4);
        AppMethodBeat.o(29502);
        return;
      }
      this.yZl.yZM.setText(String.valueOf(paramInt));
      this.yZl.yZM.setTextSize(0, a.ap(getContext(), 2131428775) * a.gr(getContext()));
      this.yZl.yZM.setVisibility(0);
      this.yZl.yZM.setBackgroundResource(t.iF(getContext()));
      this.yZl.yZN.setVisibility(4);
      AppMethodBeat.o(29502);
      return;
    }
    this.yZl.yZM.setText("");
    this.yZl.yZM.setVisibility(4);
    AppMethodBeat.o(29502);
  }
  
  public final void dAP()
  {
    if ((this.yZi != null) && (this.yZk != null) && (this.yZj == null)) {}
  }
  
  public int getContactTabUnread()
  {
    return this.yZC;
  }
  
  public int getCurIdx()
  {
    return this.eSO;
  }
  
  public int getFriendTabUnread()
  {
    return this.yZD;
  }
  
  public int getMainTabUnread()
  {
    return this.yZB;
  }
  
  public boolean getSettingsPoint()
  {
    return this.yZH;
  }
  
  public int getSettingsTabUnread()
  {
    return this.yZG;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.yZE;
  }
  
  public final void k(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(29504);
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.yZu * paramFloat + this.yZr) << 16) + ((int)(this.yZv * paramFloat + this.yZs) << 8) + (int)(this.yZw * paramFloat + this.yZt) - 16777216;
    int m = ((int)(this.yZu * (1.0F - paramFloat) + this.yZr) << 16) + ((int)(this.yZv * (1.0F - paramFloat) + this.yZs) << 8) + (int)(this.yZw * (1.0F - paramFloat) + this.yZt) - 16777216;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29504);
      return;
      this.yZi.yZK.setFocusAlpha(j);
      this.yZk.yZK.setFocusAlpha(i);
      this.yZi.yZL.setTextColor(m);
      this.yZk.yZL.setTextColor(k);
      AppMethodBeat.o(29504);
      return;
      this.yZk.yZK.setFocusAlpha(j);
      this.yZj.yZK.setFocusAlpha(i);
      this.yZk.yZL.setTextColor(m);
      this.yZj.yZL.setTextColor(k);
      AppMethodBeat.o(29504);
      return;
      this.yZj.yZK.setFocusAlpha(j);
      this.yZl.yZK.setFocusAlpha(i);
      this.yZj.yZL.setTextColor(m);
      this.yZl.yZL.setTextColor(k);
    }
  }
  
  public final void qa(boolean paramBoolean)
  {
    int i = 4;
    AppMethodBeat.i(29500);
    this.yZE = paramBoolean;
    this.yZj.yZM.setVisibility(4);
    ImageView localImageView = this.yZj.yZN;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
    AppMethodBeat.o(29500);
  }
  
  public final void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(29503);
    if (this.yZF)
    {
      AppMethodBeat.o(29503);
      return;
    }
    Object localObject = i.sFa;
    long l;
    if (paramBoolean)
    {
      l = 1L;
      i.mM(l);
      this.yZH = paramBoolean;
      this.yZl.yZM.setVisibility(4);
      localObject = this.yZl.yZN;
      if (!paramBoolean) {
        break label84;
      }
    }
    label84:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      AppMethodBeat.o(29503);
      return;
      l = 0L;
      break;
    }
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.yZh = parama;
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(29505);
    this.eSO = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.nBO = System.currentTimeMillis();
      this.yZx = this.eSO;
      AppMethodBeat.o(29505);
      return;
      this.yZi.yZK.setFocusAlpha(255);
      this.yZj.yZK.setFocusAlpha(0);
      this.yZk.yZK.setFocusAlpha(0);
      this.yZl.yZK.setFocusAlpha(0);
      this.yZi.yZL.setTextColor(this.yZm);
      this.yZj.yZL.setTextColor(this.yZq);
      this.yZk.yZL.setTextColor(this.yZq);
      this.yZl.yZL.setTextColor(this.yZq);
      continue;
      this.yZi.yZK.setFocusAlpha(0);
      this.yZj.yZK.setFocusAlpha(255);
      this.yZk.yZK.setFocusAlpha(0);
      this.yZl.yZK.setFocusAlpha(0);
      this.yZi.yZL.setTextColor(this.yZq);
      this.yZj.yZL.setTextColor(this.yZm);
      this.yZk.yZL.setTextColor(this.yZq);
      this.yZl.yZL.setTextColor(this.yZq);
      continue;
      this.yZi.yZK.setFocusAlpha(0);
      this.yZj.yZK.setFocusAlpha(0);
      this.yZk.yZK.setFocusAlpha(255);
      this.yZl.yZK.setFocusAlpha(0);
      this.yZi.yZL.setTextColor(this.yZq);
      this.yZj.yZL.setTextColor(this.yZq);
      this.yZk.yZL.setTextColor(this.yZm);
      this.yZl.yZL.setTextColor(this.yZq);
      continue;
      this.yZi.yZK.setFocusAlpha(0);
      this.yZj.yZK.setFocusAlpha(0);
      this.yZk.yZK.setFocusAlpha(0);
      this.yZl.yZK.setFocusAlpha(255);
      this.yZi.yZL.setTextColor(this.yZq);
      this.yZj.yZL.setTextColor(this.yZq);
      this.yZk.yZL.setTextColor(this.yZq);
      this.yZl.yZL.setTextColor(this.yZm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView
 * JD-Core Version:    0.7.0.1
 */