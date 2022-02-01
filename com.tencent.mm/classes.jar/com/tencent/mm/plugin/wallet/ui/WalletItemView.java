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
import com.tencent.mm.plugin.wxpay.a.a;

public class WalletItemView
  extends LinearLayout
{
  private TextView lHk;
  private Object mData;
  private String mTitle;
  private int mType;
  private String wUK;
  private TextView xcS;
  private int xdz;
  
  public WalletItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(69847);
    this.xdz = 1;
    this.mType = 0;
    this.mData = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(3, 0);
    if (paramInt != 0) {
      this.mTitle = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(2, 0);
    if (paramInt != 0) {
      this.wUK = paramContext.getString(paramInt);
    }
    this.xdz = paramAttributeSet.getInt(0, 1);
    paramAttributeSet.recycle();
    paramContext = LayoutInflater.from(paramContext).inflate(2131495969, this, true);
    this.lHk = ((TextView)paramContext.findViewById(2131305948));
    this.xcS = ((TextView)paramContext.findViewById(2131305553));
    if (this.lHk != null) {
      this.lHk.setText(this.mTitle);
    }
    if (this.xcS != null)
    {
      this.xcS.setText(this.wUK);
      this.xcS.setLines(this.xdz);
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
    this.wUK = paramSpanned.toString();
    this.xcS.setText(this.wUK);
    AppMethodBeat.o(69850);
  }
  
  public void setSummary(String paramString)
  {
    AppMethodBeat.i(69849);
    this.wUK = paramString;
    this.xcS.setText(this.wUK);
    AppMethodBeat.o(69849);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(69848);
    this.mTitle = paramString;
    this.lHk.setText(this.mTitle);
    AppMethodBeat.o(69848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.WalletItemView
 * JD-Core Version:    0.7.0.1
 */