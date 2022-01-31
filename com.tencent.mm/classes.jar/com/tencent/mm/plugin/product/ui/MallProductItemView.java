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
  private TextView iJG;
  private Object mData;
  private String mTitle;
  private int mType;
  private String prJ;
  private TextView pvv;
  private ImageView pvw;
  private int pwd;
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallProductItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(44079);
    this.pwd = 1;
    this.mType = 0;
    this.mData = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallProductItemView, paramInt, 0);
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
    paramContext = LayoutInflater.from(paramContext).inflate(2130970448, this, true);
    this.iJG = ((TextView)paramContext.findViewById(2131821212));
    this.pvv = ((TextView)paramContext.findViewById(2131826794));
    this.pvw = ((ImageView)paramContext.findViewById(2131826795));
    this.iJG.setText(this.mTitle);
    this.pvv.setText(this.prJ);
    this.pvv.setLines(this.pwd);
    AppMethodBeat.o(44079);
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
    AppMethodBeat.i(44082);
    this.prJ = paramSpanned.toString();
    this.pvv.setText(this.prJ);
    AppMethodBeat.o(44082);
  }
  
  public void setSummary(String paramString)
  {
    AppMethodBeat.i(44081);
    this.prJ = paramString;
    this.pvv.setText(this.prJ);
    AppMethodBeat.o(44081);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(44080);
    this.mTitle = paramString;
    this.iJG.setText(this.mTitle);
    AppMethodBeat.o(44080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductItemView
 * JD-Core Version:    0.7.0.1
 */