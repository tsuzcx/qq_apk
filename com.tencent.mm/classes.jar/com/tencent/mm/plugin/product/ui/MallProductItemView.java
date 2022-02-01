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
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;

public class MallProductItemView
  extends LinearLayout
{
  private String MGG;
  private TextView MRV;
  private ImageView MRW;
  private int MSB;
  private Object mData;
  private String mTitle;
  private int mType;
  private TextView sUt;
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66984);
    this.MSB = 1;
    this.mType = 0;
    this.mData = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MallProductItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.MallProductItemView_mallProductTitle, 0);
    if (paramInt != 0) {
      this.mTitle = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.MallProductItemView_mallProductSummary, 0);
    if (paramInt != 0) {
      this.MGG = paramContext.getString(paramInt);
    }
    this.MSB = paramAttributeSet.getInt(a.k.MallProductItemView_android_lines, 1);
    paramAttributeSet.recycle();
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.product_item_view, this, true);
    this.sUt = ((TextView)paramContext.findViewById(a.f.title_tv));
    this.MRV = ((TextView)paramContext.findViewById(a.f.summary_tv));
    this.MRW = ((ImageView)paramContext.findViewById(a.f.indecator_iv));
    this.sUt.setText(this.mTitle);
    this.MRV.setText(this.MGG);
    this.MRV.setLines(this.MSB);
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
    this.MGG = paramSpanned.toString();
    this.MRV.setText(this.MGG);
    AppMethodBeat.o(66987);
  }
  
  public void setSummary(String paramString)
  {
    AppMethodBeat.i(66986);
    this.MGG = paramString;
    this.MRV.setText(this.MGG);
    AppMethodBeat.o(66986);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(66985);
    this.mTitle = paramString;
    this.sUt.setText(this.mTitle);
    AppMethodBeat.o(66985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductItemView
 * JD-Core Version:    0.7.0.1
 */