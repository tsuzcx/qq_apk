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
  private String AQG;
  private TextView Bau;
  private int Bbb;
  private Object mData;
  private TextView mPa;
  private String mTitle;
  private int mType;
  
  public WalletItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(69847);
    this.Bbb = 1;
    this.mType = 0;
    this.mData = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(3, 0);
    if (paramInt != 0) {
      this.mTitle = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(2, 0);
    if (paramInt != 0) {
      this.AQG = paramContext.getString(paramInt);
    }
    this.Bbb = paramAttributeSet.getInt(0, 1);
    paramAttributeSet.recycle();
    paramContext = LayoutInflater.from(paramContext).inflate(2131496949, this, true);
    this.mPa = ((TextView)paramContext.findViewById(2131309249));
    this.Bau = ((TextView)paramContext.findViewById(2131308774));
    if (this.mPa != null) {
      this.mPa.setText(this.mTitle);
    }
    if (this.Bau != null)
    {
      this.Bau.setText(this.AQG);
      this.Bau.setLines(this.Bbb);
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
    this.AQG = paramSpanned.toString();
    this.Bau.setText(this.AQG);
    AppMethodBeat.o(69850);
  }
  
  public void setSummary(String paramString)
  {
    AppMethodBeat.i(69849);
    this.AQG = paramString;
    this.Bau.setText(this.AQG);
    AppMethodBeat.o(69849);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(69848);
    this.mTitle = paramString;
    this.mPa.setText(this.mTitle);
    AppMethodBeat.o(69848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.WalletItemView
 * JD-Core Version:    0.7.0.1
 */