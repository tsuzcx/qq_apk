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

public class JsonItemView
  extends LinearLayout
{
  public static int Hkr = 12;
  private TextView Hks;
  private TextView Hkt;
  private ImageView Hku;
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
    LayoutInflater.from(this.mContext).inflate(2131494529, this, true);
    this.Hks = ((TextView)findViewById(2131306136));
    this.Hkt = ((TextView)findViewById(2131306148));
    this.Hku = ((ImageView)findViewById(2131301215));
    AppMethodBeat.o(38898);
  }
  
  public final void ao(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(38901);
    this.Hks.setVisibility(0);
    this.Hks.setText(paramCharSequence);
    AppMethodBeat.o(38901);
  }
  
  public final void ap(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(38902);
    this.Hkt.setVisibility(0);
    if (paramCharSequence != null) {
      this.Hkt.setText(paramCharSequence);
    }
    AppMethodBeat.o(38902);
  }
  
  public final void fdf()
  {
    AppMethodBeat.i(38900);
    this.Hks.setVisibility(8);
    AppMethodBeat.o(38900);
  }
  
  public final void fdg()
  {
    AppMethodBeat.i(38904);
    this.Hku.setVisibility(8);
    AppMethodBeat.o(38904);
  }
  
  public CharSequence getRightText()
  {
    AppMethodBeat.i(38903);
    CharSequence localCharSequence = this.Hkt.getText();
    AppMethodBeat.o(38903);
    return localCharSequence;
  }
  
  public final void gm(View paramView)
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
    this.Hku.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(38906);
  }
  
  public void setRightColor(int paramInt)
  {
    AppMethodBeat.i(38899);
    this.Hkt.setTextColor(paramInt);
    AppMethodBeat.o(38899);
  }
  
  public void setTextSize(float paramFloat) {}
  
  public final void wC(boolean paramBoolean)
  {
    AppMethodBeat.i(38905);
    this.Hku.setVisibility(0);
    ImageView localImageView = this.Hku;
    if (paramBoolean) {}
    for (int i = 2131232758;; i = 2131232757)
    {
      localImageView.setImageResource(i);
      AppMethodBeat.o(38905);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.JsonItemView
 * JD-Core Version:    0.7.0.1
 */