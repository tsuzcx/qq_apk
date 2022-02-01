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
  private TextView lHk;
  private Object mData;
  private String mTitle;
  private int mType;
  private String wUK;
  private TextView xcS;
  private ImageView xcT;
  private int xdz;
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66984);
    this.xdz = 1;
    this.mType = 0;
    this.mData = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallProductItemView, paramInt, 0);
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131495121, this, true);
    this.lHk = ((TextView)paramContext.findViewById(2131305948));
    this.xcS = ((TextView)paramContext.findViewById(2131305553));
    this.xcT = ((ImageView)paramContext.findViewById(2131300997));
    this.lHk.setText(this.mTitle);
    this.xcS.setText(this.wUK);
    this.xcS.setLines(this.xdz);
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
    this.wUK = paramSpanned.toString();
    this.xcS.setText(this.wUK);
    AppMethodBeat.o(66987);
  }
  
  public void setSummary(String paramString)
  {
    AppMethodBeat.i(66986);
    this.wUK = paramString;
    this.xcS.setText(this.wUK);
    AppMethodBeat.o(66986);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(66985);
    this.mTitle = paramString;
    this.lHk.setText(this.mTitle);
    AppMethodBeat.o(66985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductItemView
 * JD-Core Version:    0.7.0.1
 */