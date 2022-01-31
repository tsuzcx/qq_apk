package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView
  extends LinearLayout
{
  private ArrayList<View> ang;
  private Context mContext;
  private MMAutoHeightViewPager uCs;
  private MMPageControlView uCt;
  private WalletPayUOpenIntroView.a uCu;
  private d[] uCv;
  
  public WalletPayUOpenIntroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletPayUOpenIntroView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(48393);
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2130970413, this, true);
    this.uCs = ((MMAutoHeightViewPager)paramContext.findViewById(2131823945));
    this.uCt = ((MMPageControlView)paramContext.findViewById(2131826710));
    this.uCt.setVisibility(0);
    this.uCs.setOnPageChangeListener(new WalletPayUOpenIntroView.1(this));
    AppMethodBeat.o(48393);
  }
  
  public void setPagerData(d[] paramArrayOfd)
  {
    AppMethodBeat.i(48394);
    this.uCv = paramArrayOfd;
    this.ang = new ArrayList();
    if (this.uCv != null)
    {
      i = 0;
      while (i < this.uCv.length)
      {
        paramArrayOfd = LayoutInflater.from(this.mContext).inflate(2130970414, null);
        this.ang.add(paramArrayOfd);
        i += 1;
      }
    }
    this.uCu = new WalletPayUOpenIntroView.a(this, (byte)0);
    this.uCs.setAdapter(this.uCu);
    paramArrayOfd = this.uCt;
    if (this.uCv == null) {}
    for (int i = 0;; i = this.uCv.length)
    {
      paramArrayOfd.hy(i, 0);
      AppMethodBeat.o(48394);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView
 * JD-Core Version:    0.7.0.1
 */