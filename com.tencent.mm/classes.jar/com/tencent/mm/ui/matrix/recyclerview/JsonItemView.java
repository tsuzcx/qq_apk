package com.tencent.mm.ui.matrix.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class JsonItemView
  extends LinearLayout
{
  public static int XLe = 12;
  private TextView XLf;
  private TextView XLg;
  private ImageView XLh;
  private Context mContext;
  
  public JsonItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JsonItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public JsonItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38898);
    this.mContext = paramContext;
    setOrientation(1);
    LayoutInflater.from(this.mContext).inflate(R.i.eij, this, true);
    this.XLf = ((TextView)findViewById(R.h.dYh));
    this.XLg = ((TextView)findViewById(R.h.dYn));
    this.XLh = ((ImageView)findViewById(R.h.iv_icon));
    AppMethodBeat.o(38898);
  }
  
  public final void GY(boolean paramBoolean)
  {
    AppMethodBeat.i(38905);
    this.XLh.setVisibility(0);
    ImageView localImageView = this.XLh;
    if (paramBoolean) {}
    for (int i = R.g.dnI;; i = R.g.dnH)
    {
      localImageView.setImageResource(i);
      AppMethodBeat.o(38905);
      return;
    }
  }
  
  public final void aJ(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(38901);
    this.XLf.setVisibility(0);
    this.XLf.setText(paramCharSequence);
    AppMethodBeat.o(38901);
  }
  
  public final void aK(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(38902);
    this.XLg.setVisibility(0);
    if (paramCharSequence != null) {
      this.XLg.setText(paramCharSequence);
    }
    AppMethodBeat.o(38902);
  }
  
  public CharSequence getRightText()
  {
    AppMethodBeat.i(38903);
    CharSequence localCharSequence = this.XLg.getText();
    AppMethodBeat.o(38903);
    return localCharSequence;
  }
  
  public final void hXA()
  {
    AppMethodBeat.i(38900);
    this.XLf.setVisibility(8);
    AppMethodBeat.o(38900);
  }
  
  public final void hXB()
  {
    AppMethodBeat.i(38904);
    this.XLh.setVisibility(8);
    AppMethodBeat.o(38904);
  }
  
  public final void iB(View paramView)
  {
    AppMethodBeat.i(38907);
    Object localObject2 = paramView.getLayoutParams();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = generateDefaultLayoutParams();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramView = new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
        AppMethodBeat.o(38907);
        throw paramView;
      }
    }
    addViewInLayout(paramView, -1, localObject1);
    AppMethodBeat.o(38907);
  }
  
  public void setIconClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(38906);
    this.XLh.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(38906);
  }
  
  public void setRightColor(int paramInt)
  {
    AppMethodBeat.i(38899);
    this.XLg.setTextColor(paramInt);
    AppMethodBeat.o(38899);
  }
  
  public void setTextSize(float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.JsonItemView
 * JD-Core Version:    0.7.0.1
 */