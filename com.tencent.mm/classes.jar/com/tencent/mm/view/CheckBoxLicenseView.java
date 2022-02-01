package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CheckBoxLicenseView
  extends LinearLayout
{
  private CompoundButton.OnCheckedChangeListener HUq;
  private View.OnClickListener HUr;
  
  public CheckBoxLicenseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public CheckBoxLicenseView(Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(191024);
    Object localObject = inflate(getContext(), 2131493578, this);
    paramContext = ((View)localObject).findViewById(2131305697);
    paramAttributeSet = (CheckBox)((View)localObject).findViewById(2131305698);
    localObject = (TextView)((View)localObject).findViewById(2131305701);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191023);
        paramAttributeSet.performClick();
        AppMethodBeat.o(191023);
      }
    });
    if (this.HUq != null) {
      paramAttributeSet.setOnCheckedChangeListener(this.HUq);
    }
    if (this.HUr != null) {
      ((TextView)localObject).setOnClickListener(this.HUr);
    }
    AppMethodBeat.o(191024);
  }
  
  public void setCheckStateChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    AppMethodBeat.i(191025);
    this.HUq = paramOnCheckedChangeListener;
    ((CheckBox)findViewById(2131305698)).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    AppMethodBeat.o(191025);
  }
  
  public void setLicenseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(191026);
    TextView localTextView = (TextView)findViewById(2131305701);
    this.HUr = paramOnClickListener;
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(191026);
  }
  
  public void setTermText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(191027);
    ((TextView)findViewById(2131305701)).setText(paramCharSequence);
    AppMethodBeat.o(191027);
  }
  
  public void setTermTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(191028);
    ((TextView)findViewById(2131305700)).setText(paramCharSequence);
    AppMethodBeat.o(191028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.CheckBoxLicenseView
 * JD-Core Version:    0.7.0.1
 */