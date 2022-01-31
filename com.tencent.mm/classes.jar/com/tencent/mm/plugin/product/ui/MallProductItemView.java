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
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;

public class MallProductItemView
  extends LinearLayout
{
  private TextView haW;
  private Object mData = null;
  private String mRw;
  private int mTX = 1;
  private String mTitle;
  private TextView mTp;
  private ImageView mTq;
  private int mType = 0;
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MallProductItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.MallProductItemView_mallProductTitle, 0);
    if (paramInt != 0) {
      this.mTitle = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.MallProductItemView_mallProductSummary, 0);
    if (paramInt != 0) {
      this.mRw = paramContext.getString(paramInt);
    }
    this.mTX = paramAttributeSet.getInt(a.k.MallProductItemView_android_lines, 1);
    paramAttributeSet.recycle();
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.product_item_view, this, true);
    this.haW = ((TextView)paramContext.findViewById(a.f.title_tv));
    this.mTp = ((TextView)paramContext.findViewById(a.f.summary_tv));
    this.mTq = ((ImageView)paramContext.findViewById(a.f.indecator_iv));
    this.haW.setText(this.mTitle);
    this.mTp.setText(this.mRw);
    this.mTp.setLines(this.mTX);
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
    this.mRw = paramSpanned.toString();
    this.mTp.setText(this.mRw);
  }
  
  public void setSummary(String paramString)
  {
    this.mRw = paramString;
    this.mTp.setText(this.mRw);
  }
  
  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
    this.haW.setText(this.mTitle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductItemView
 * JD-Core Version:    0.7.0.1
 */