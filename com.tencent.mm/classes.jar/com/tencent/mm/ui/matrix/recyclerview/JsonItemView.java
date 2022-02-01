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
  public static int Qnf = 12;
  private TextView Qng;
  private TextView Qnh;
  private ImageView Qni;
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
    LayoutInflater.from(this.mContext).inflate(2131495125, this, true);
    this.Qng = ((TextView)findViewById(2131309498));
    this.Qnh = ((TextView)findViewById(2131309518));
    this.Qni = ((ImageView)findViewById(2131302896));
    AppMethodBeat.o(38898);
  }
  
  public final void CE(boolean paramBoolean)
  {
    AppMethodBeat.i(38905);
    this.Qni.setVisibility(0);
    ImageView localImageView = this.Qni;
    if (paramBoolean) {}
    for (int i = 2131233199;; i = 2131233198)
    {
      localImageView.setImageResource(i);
      AppMethodBeat.o(38905);
      return;
    }
  }
  
  public final void au(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(38901);
    this.Qng.setVisibility(0);
    this.Qng.setText(paramCharSequence);
    AppMethodBeat.o(38901);
  }
  
  public final void av(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(38902);
    this.Qnh.setVisibility(0);
    if (paramCharSequence != null) {
      this.Qnh.setText(paramCharSequence);
    }
    AppMethodBeat.o(38902);
  }
  
  public final void gWX()
  {
    AppMethodBeat.i(38900);
    this.Qng.setVisibility(8);
    AppMethodBeat.o(38900);
  }
  
  public final void gWY()
  {
    AppMethodBeat.i(38904);
    this.Qni.setVisibility(8);
    AppMethodBeat.o(38904);
  }
  
  public CharSequence getRightText()
  {
    AppMethodBeat.i(38903);
    CharSequence localCharSequence = this.Qnh.getText();
    AppMethodBeat.o(38903);
    return localCharSequence;
  }
  
  public final void hm(View paramView)
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
    this.Qni.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(38906);
  }
  
  public void setRightColor(int paramInt)
  {
    AppMethodBeat.i(38899);
    this.Qnh.setTextColor(paramInt);
    AppMethodBeat.o(38899);
  }
  
  public void setTextSize(float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.JsonItemView
 * JD-Core Version:    0.7.0.1
 */