package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.a;

public class MallProductItemView
  extends LinearLayout
{
  private TextView kEu;
  private Object mData;
  private String mTitle;
  private int mType;
  private String uqJ;
  private int uxL;
  private TextView uxf;
  private ImageView uxg;
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66984);
    this.uxL = 1;
    this.mType = 0;
    this.mData = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallProductItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(3, 0);
    if (paramInt != 0) {
      this.mTitle = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(2, 0);
    if (paramInt != 0) {
      this.uqJ = paramContext.getString(paramInt);
    }
    this.uxL = paramAttributeSet.getInt(0, 1);
    paramAttributeSet.recycle();
    paramContext = LayoutInflater.from(paramContext).inflate(2131495121, this, true);
    this.kEu = ((TextView)paramContext.findViewById(2131305948));
    this.uxf = ((TextView)paramContext.findViewById(2131305553));
    this.uxg = ((ImageView)paramContext.findViewById(2131300997));
    this.kEu.setText(this.mTitle);
    this.uxf.setText(this.uqJ);
    this.uxf.setLines(this.uxL);
    AppMethodBeat.o(66984);
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
    AppMethodBeat.i(66987);
    this.uqJ = paramSpanned.toString();
    this.uxf.setText(this.uqJ);
    AppMethodBeat.o(66987);
  }
  
  public void setSummary(String paramString)
  {
    AppMethodBeat.i(66986);
    this.uqJ = paramString;
    this.uxf.setText(this.uqJ);
    AppMethodBeat.o(66986);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(66985);
    this.mTitle = paramString;
    this.kEu.setText(this.mTitle);
    AppMethodBeat.o(66985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductItemView
 * JD-Core Version:    0.7.0.1
 */