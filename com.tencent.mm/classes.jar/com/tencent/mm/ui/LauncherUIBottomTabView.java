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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.q;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements c
{
  protected int jQL = 0;
  private long ldT = 0L;
  private boolean uLA = false;
  private int uLB = 0;
  private boolean uLC = false;
  private c.a uLd;
  protected LauncherUIBottomTabView.a uLe;
  protected LauncherUIBottomTabView.a uLf;
  protected LauncherUIBottomTabView.a uLg;
  protected LauncherUIBottomTabView.a uLh;
  private int uLi = 0;
  private int uLj;
  private int uLk;
  private int uLl;
  private int uLm = 0;
  private int uLn;
  private int uLo;
  private int uLp;
  private int uLq;
  private int uLr;
  private int uLs;
  private int uLt = -1;
  private int uLu = 0;
  protected View.OnClickListener uLv = new LauncherUIBottomTabView.1(this);
  private ah uLw = new LauncherUIBottomTabView.2(this);
  private int uLx = 0;
  private int uLy = 0;
  private int uLz = 0;
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private LauncherUIBottomTabView.a FM(int paramInt)
  {
    LauncherUIBottomTabView.a locala = new LauncherUIBottomTabView.a(this);
    if (a.fh(getContext())) {}
    for (locala.uLE = b.ED().a((Activity)getContext(), "R.layout.mm_bottom_tabitem_large", R.i.mm_bottom_tabitem_large);; locala.uLE = b.ED().a((Activity)getContext(), "R.layout.mm_bottom_tabitem", R.i.mm_bottom_tabitem))
    {
      locala.uLF = ((TabIconView)locala.uLE.findViewById(R.h.icon_iv));
      locala.uLG = ((TextView)locala.uLE.findViewById(R.h.icon_tv));
      locala.uLH = ((TextView)locala.uLE.findViewById(R.h.unread_tv));
      locala.uLH.setBackgroundResource(q.hh(getContext()));
      locala.uLI = ((ImageView)locala.uLE.findViewById(R.h.dot_iv));
      locala.uLE.setTag(Integer.valueOf(paramInt));
      locala.uLE.setOnClickListener(this.uLv);
      float f1 = a.ab(getContext(), R.f.SmallestTextSize);
      float f2 = a.ff(getContext());
      locala.uLG.setTextSize(0, f1 * f2);
      return locala;
    }
  }
  
  private void init()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(0);
    addView(localLinearLayout, new RelativeLayout.LayoutParams(-1, -2));
    this.uLu = ((int)(a.ab(getContext(), R.f.DefaultTabbarHeight) * a.ff(getContext())));
    LauncherUIBottomTabView.a locala = FM(0);
    locala.uLE.setId(-16777215);
    locala.uLG.setText(R.l.main_title);
    locala.uLG.setTextColor(getResources().getColor(R.e.navbar_text_focus));
    locala.uLF.f(R.k.navbar_chat_icon_focus, R.k.navbar_chat_icon_middle, R.k.navbar_chat_icon_normal, a.fh(getContext()));
    locala.uLH.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.uLu);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(locala.uLE, localLayoutParams);
    this.uLe = locala;
    locala = FM(1);
    locala.uLE.setId(-16777214);
    locala.uLG.setText(R.l.main_contact);
    locala.uLG.setTextColor(getResources().getColor(R.e.navbar_text_normal));
    locala.uLF.f(R.k.navbar_addresslist_icon_focus, R.k.navbar_addresslist_icon_middle, R.k.navbar_addresslist_icon_normal, a.fh(getContext()));
    locala.uLH.setVisibility(4);
    localLayoutParams = new LinearLayout.LayoutParams(0, this.uLu);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(locala.uLE, localLayoutParams);
    this.uLg = locala;
    locala = FM(2);
    locala.uLE.setId(-16777213);
    locala.uLG.setText(R.l.main_addcontact);
    locala.uLG.setTextColor(getResources().getColor(R.e.navbar_text_normal));
    locala.uLF.f(R.k.navbar_discovery_icon_focus, R.k.navbar_discovery_icon_middle, R.k.navbar_discovery_icon_normal, a.fh(getContext()));
    locala.uLH.setVisibility(4);
    localLayoutParams = new LinearLayout.LayoutParams(0, this.uLu);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(locala.uLE, localLayoutParams);
    this.uLf = locala;
    locala = FM(3);
    locala.uLE.setId(-16777212);
    locala.uLG.setText(R.l.main_more);
    locala.uLG.setTextColor(getResources().getColor(R.e.navbar_text_normal));
    locala.uLF.f(R.k.navbar_me_icon_focus, R.k.navbar_me_icon_middle, R.k.navbar_me_icon_normal, a.fh(getContext()));
    locala.uLH.setVisibility(4);
    localLayoutParams = new LinearLayout.LayoutParams(0, this.uLu);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(locala.uLE, localLayoutParams);
    this.uLh = locala;
    this.uLi = getResources().getColor(R.e.navbar_text_focus);
    this.uLj = ((this.uLi & 0xFF0000) >> 16);
    this.uLk = ((this.uLi & 0xFF00) >> 8);
    this.uLl = (this.uLi & 0xFF);
    this.uLm = getResources().getColor(R.e.navbar_text_normal);
    this.uLn = ((this.uLm & 0xFF0000) >> 16);
    this.uLo = ((this.uLm & 0xFF00) >> 8);
    this.uLp = (this.uLm & 0xFF);
    this.uLq = (this.uLj - this.uLn);
    this.uLr = (this.uLk - this.uLo);
    this.uLs = (this.uLl - this.uLp);
  }
  
  public final void FH(int paramInt)
  {
    y.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.uLx = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uLe.uLH.setText(getContext().getString(R.l.unread_count_overt_100));
        this.uLe.uLH.setVisibility(0);
        this.uLe.uLI.setVisibility(4);
        return;
      }
      this.uLe.uLH.setText(String.valueOf(paramInt));
      this.uLe.uLH.setVisibility(0);
      this.uLe.uLI.setVisibility(4);
      return;
    }
    this.uLe.uLH.setText("");
    this.uLe.uLH.setVisibility(4);
  }
  
  public final void FI(int paramInt)
  {
    this.uLy = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uLg.uLH.setText(getContext().getString(R.l.unread_count_overt_100));
        this.uLg.uLH.setVisibility(0);
        this.uLg.uLI.setVisibility(4);
        return;
      }
      this.uLg.uLH.setText(String.valueOf(paramInt));
      this.uLg.uLH.setVisibility(0);
      this.uLg.uLI.setVisibility(4);
      return;
    }
    this.uLg.uLH.setText("");
    this.uLg.uLH.setVisibility(4);
  }
  
  public final void FJ(int paramInt)
  {
    this.uLz = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uLf.uLH.setText(getContext().getString(R.l.unread_count_overt_100));
        this.uLf.uLH.setVisibility(0);
        this.uLf.uLI.setVisibility(4);
        return;
      }
      this.uLf.uLH.setText(String.valueOf(paramInt));
      this.uLf.uLH.setVisibility(0);
      this.uLf.uLI.setVisibility(4);
      return;
    }
    this.uLf.uLH.setText("");
    this.uLf.uLH.setVisibility(4);
  }
  
  public final void FK(int paramInt)
  {
    this.uLB = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uLh.uLH.setText(getContext().getString(R.l.unread_count_overt_100));
        this.uLh.uLH.setVisibility(0);
        this.uLh.uLI.setVisibility(4);
        return;
      }
      this.uLh.uLH.setText(String.valueOf(paramInt));
      this.uLh.uLH.setVisibility(0);
      this.uLh.uLI.setVisibility(4);
      return;
    }
    this.uLh.uLH.setText("");
    this.uLh.uLH.setVisibility(4);
  }
  
  public final void cxS()
  {
    if ((this.uLe != null) && (this.uLg != null) && (this.uLf == null)) {}
  }
  
  public int getContactTabUnread()
  {
    return this.uLy;
  }
  
  public int getCurIdx()
  {
    return this.jQL;
  }
  
  public int getFriendTabUnread()
  {
    return this.uLz;
  }
  
  public int getMainTabUnread()
  {
    return this.uLx;
  }
  
  public boolean getSettingsPoint()
  {
    return this.uLC;
  }
  
  public int getSettingsTabUnread()
  {
    return this.uLB;
  }
  
  public boolean getShowFriendPoint()
  {
    return this.uLA;
  }
  
  public final void i(int paramInt, float paramFloat)
  {
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.uLq * paramFloat + this.uLn) << 16) + ((int)(this.uLr * paramFloat + this.uLo) << 8) + (int)(this.uLs * paramFloat + this.uLp) - 16777216;
    int m = ((int)(this.uLq * (1.0F - paramFloat) + this.uLn) << 16) + ((int)(this.uLr * (1.0F - paramFloat) + this.uLo) << 8) + (int)(this.uLs * (1.0F - paramFloat) + this.uLp) - 16777216;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.uLe.uLF.setFocusAlpha(j);
      this.uLg.uLF.setFocusAlpha(i);
      this.uLe.uLG.setTextColor(m);
      this.uLg.uLG.setTextColor(k);
      return;
    case 1: 
      this.uLg.uLF.setFocusAlpha(j);
      this.uLf.uLF.setFocusAlpha(i);
      this.uLg.uLG.setTextColor(m);
      this.uLf.uLG.setTextColor(k);
      return;
    }
    this.uLf.uLF.setFocusAlpha(j);
    this.uLh.uLF.setFocusAlpha(i);
    this.uLf.uLG.setTextColor(m);
    this.uLh.uLG.setTextColor(k);
  }
  
  public final void mH(boolean paramBoolean)
  {
    int i = 4;
    this.uLA = paramBoolean;
    this.uLf.uLH.setVisibility(4);
    ImageView localImageView = this.uLf.uLI;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
  }
  
  public final void mI(boolean paramBoolean)
  {
    int i = 4;
    this.uLC = paramBoolean;
    this.uLh.uLH.setVisibility(4);
    ImageView localImageView = this.uLh.uLI;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
  }
  
  public void setOnTabClickListener(c.a parama)
  {
    this.uLd = parama;
  }
  
  public void setTo(int paramInt)
  {
    this.jQL = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.ldT = System.currentTimeMillis();
      this.uLt = this.jQL;
      return;
      this.uLe.uLF.setFocusAlpha(255);
      this.uLf.uLF.setFocusAlpha(0);
      this.uLg.uLF.setFocusAlpha(0);
      this.uLh.uLF.setFocusAlpha(0);
      this.uLe.uLG.setTextColor(this.uLi);
      this.uLf.uLG.setTextColor(this.uLm);
      this.uLg.uLG.setTextColor(this.uLm);
      this.uLh.uLG.setTextColor(this.uLm);
      continue;
      this.uLe.uLF.setFocusAlpha(0);
      this.uLf.uLF.setFocusAlpha(255);
      this.uLg.uLF.setFocusAlpha(0);
      this.uLh.uLF.setFocusAlpha(0);
      this.uLe.uLG.setTextColor(this.uLm);
      this.uLf.uLG.setTextColor(this.uLi);
      this.uLg.uLG.setTextColor(this.uLm);
      this.uLh.uLG.setTextColor(this.uLm);
      continue;
      this.uLe.uLF.setFocusAlpha(0);
      this.uLf.uLF.setFocusAlpha(0);
      this.uLg.uLF.setFocusAlpha(255);
      this.uLh.uLF.setFocusAlpha(0);
      this.uLe.uLG.setTextColor(this.uLm);
      this.uLf.uLG.setTextColor(this.uLm);
      this.uLg.uLG.setTextColor(this.uLi);
      this.uLh.uLG.setTextColor(this.uLm);
      continue;
      this.uLe.uLF.setFocusAlpha(0);
      this.uLf.uLF.setFocusAlpha(0);
      this.uLg.uLF.setFocusAlpha(0);
      this.uLh.uLF.setFocusAlpha(255);
      this.uLe.uLG.setTextColor(this.uLm);
      this.uLf.uLG.setTextColor(this.uLm);
      this.uLg.uLG.setTextColor(this.uLm);
      this.uLh.uLG.setTextColor(this.uLi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView
 * JD-Core Version:    0.7.0.1
 */