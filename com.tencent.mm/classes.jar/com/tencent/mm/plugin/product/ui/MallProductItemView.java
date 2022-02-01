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
  private TextView lCL;
  private Object mData;
  private String mTitle;
  private int mType;
  private String wEZ;
  private int wNL;
  private TextView wNe;
  private ImageView wNf;
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66984);
    this.wNL = 1;
    this.mType = 0;
    this.mData = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallProductItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(3, 0);
    if (paramInt != 0) {
      this.mTitle = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(2, 0);
    if (paramInt != 0) {
      this.wEZ = paramContext.getString(paramInt);
    }
    this.wNL = paramAttributeSet.getInt(0, 1);
    paramAttributeSet.recycle();
    paramContext = LayoutInflater.from(paramContext).inflate(2131495121, this, true);
    this.lCL = ((TextView)paramContext.findViewById(2131305948));
    this.wNe = ((TextView)paramContext.findViewById(2131305553));
    this.wNf = ((ImageView)paramContext.findViewById(2131300997));
    this.lCL.setText(this.mTitle);
    this.wNe.setText(this.wEZ);
    this.wNe.setLines(this.wNL);
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
    this.wEZ = paramSpanned.toString();
    this.wNe.setText(this.wEZ);
    AppMethodBeat.o(66987);
  }
  
  public void setSummary(String paramString)
  {
    AppMethodBeat.i(66986);
    this.wEZ = paramString;
    this.wNe.setText(this.wEZ);
    AppMethodBeat.o(66986);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(66985);
    this.mTitle = paramString;
    this.lCL.setText(this.mTitle);
    AppMethodBeat.o(66985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductItemView
 * JD-Core Version:    0.7.0.1
 */