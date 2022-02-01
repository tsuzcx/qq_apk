package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;

public class WalletItemView
  extends LinearLayout
{
  private String GJR;
  private int GUZ;
  private TextView GUs;
  private Object mData;
  private String mTitle;
  private int mType;
  private TextView pPT;
  
  public WalletItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(69847);
    this.GUZ = 1;
    this.mType = 0;
    this.mData = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WalletItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletItemView_walletTitle, 0);
    if (paramInt != 0) {
      this.mTitle = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.WalletItemView_walletSummary, 0);
    if (paramInt != 0) {
      this.GJR = paramContext.getString(paramInt);
    }
    this.GUZ = paramAttributeSet.getInt(a.k.WalletItemView_android_lines, 1);
    paramAttributeSet.recycle();
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wallet_item_view, this, true);
    this.pPT = ((TextView)paramContext.findViewById(a.f.title_tv));
    this.GUs = ((TextView)paramContext.findViewById(a.f.summary_tv));
    if (this.pPT != null) {
      this.pPT.setText(this.mTitle);
    }
    if (this.GUs != null)
    {
      this.GUs.setText(this.GJR);
      this.GUs.setLines(this.GUZ);
    }
    AppMethodBeat.o(69847);
  }
  
  public Object getData()
  {
    return this.mData;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public void setSummary(Spanned paramSpanned)
  {
    AppMethodBeat.i(69850);
    this.GJR = paramSpanned.toString();
    this.GUs.setText(this.GJR);
    AppMethodBeat.o(69850);
  }
  
  public void setSummary(String paramString)
  {
    AppMethodBeat.i(69849);
    this.GJR = paramString;
    this.GUs.setText(this.GJR);
    AppMethodBeat.o(69849);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(69848);
    this.mTitle = paramString;
    this.pPT.setText(this.mTitle);
    AppMethodBeat.o(69848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.WalletItemView
 * JD-Core Version:    0.7.0.1
 */