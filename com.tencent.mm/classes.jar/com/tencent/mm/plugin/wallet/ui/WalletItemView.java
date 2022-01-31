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
  private TextView iJG;
  private Object mData;
  private String mTitle;
  private int mType;
  private String prJ;
  private TextView pvv;
  private int pwd;
  
  public WalletItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(46452);
    this.pwd = 1;
    this.mType = 0;
    this.mData = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(2, 0);
    if (paramInt != 0) {
      this.mTitle = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(3, 0);
    if (paramInt != 0) {
      this.prJ = paramContext.getString(paramInt);
    }
    this.pwd = paramAttributeSet.getInt(0, 1);
    paramAttributeSet.recycle();
    paramContext = LayoutInflater.from(paramContext).inflate(2130971193, this, true);
    this.iJG = ((TextView)paramContext.findViewById(2131821212));
    this.pvv = ((TextView)paramContext.findViewById(2131826794));
    if (this.iJG != null) {
      this.iJG.setText(this.mTitle);
    }
    if (this.pvv != null)
    {
      this.pvv.setText(this.prJ);
      this.pvv.setLines(this.pwd);
    }
    AppMethodBeat.o(46452);
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
    AppMethodBeat.i(46455);
    this.prJ = paramSpanned.toString();
    this.pvv.setText(this.prJ);
    AppMethodBeat.o(46455);
  }
  
  public void setSummary(String paramString)
  {
    AppMethodBeat.i(46454);
    this.prJ = paramString;
    this.pvv.setText(this.prJ);
    AppMethodBeat.o(46454);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(46453);
    this.mTitle = paramString;
    this.iJG.setText(this.mTitle);
    AppMethodBeat.o(46453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.WalletItemView
 * JD-Core Version:    0.7.0.1
 */