package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView
  extends LinearLayout
{
  private ArrayList<View> akN;
  private Context mContext;
  private MMAutoHeightViewPager qNl;
  private MMPageControlView qNm;
  private WalletPayUOpenIntroView.a qNn;
  private d[] qNo;
  
  public WalletPayUOpenIntroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletPayUOpenIntroView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(a.g.payu_view_open_intro, this, true);
    this.qNl = ((MMAutoHeightViewPager)paramContext.findViewById(a.f.pager));
    this.qNm = ((MMPageControlView)paramContext.findViewById(a.f.controller));
    this.qNm.setVisibility(0);
    this.qNl.setOnPageChangeListener(new WalletPayUOpenIntroView.1(this));
  }
  
  public void setPagerData(d[] paramArrayOfd)
  {
    this.qNo = paramArrayOfd;
    this.akN = new ArrayList();
    if (this.qNo != null)
    {
      i = 0;
      while (i < this.qNo.length)
      {
        paramArrayOfd = LayoutInflater.from(this.mContext).inflate(a.g.payu_view_open_intro_item, null);
        this.akN.add(paramArrayOfd);
        i += 1;
      }
    }
    this.qNn = new WalletPayUOpenIntroView.a(this, (byte)0);
    this.qNl.setAdapter(this.qNn);
    paramArrayOfd = this.qNm;
    if (this.qNo == null) {}
    for (int i = 0;; i = this.qNo.length)
    {
      paramArrayOfd.fr(i, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView
 * JD-Core Version:    0.7.0.1
 */