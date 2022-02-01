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
  private CompoundButton.OnCheckedChangeListener JuY;
  private View.OnClickListener JuZ;
  
  public CheckBoxLicenseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public CheckBoxLicenseView(Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197241);
    Object localObject = inflate(getContext(), 2131493578, this);
    paramContext = ((View)localObject).findViewById(2131305697);
    paramAttributeSet = (CheckBox)((View)localObject).findViewById(2131305698);
    localObject = (TextView)((View)localObject).findViewById(2131305701);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(197240);
        paramAttributeSet.performClick();
        AppMethodBeat.o(197240);
      }
    });
    if (this.JuY != null) {
      paramAttributeSet.setOnCheckedChangeListener(this.JuY);
    }
    if (this.JuZ != null) {
      ((TextView)localObject).setOnClickListener(this.JuZ);
    }
    AppMethodBeat.o(197241);
  }
  
  public void setCheckStateChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    AppMethodBeat.i(197242);
    this.JuY = paramOnCheckedChangeListener;
    ((CheckBox)findViewById(2131305698)).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    AppMethodBeat.o(197242);
  }
  
  public void setLicenseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(197243);
    TextView localTextView = (TextView)findViewById(2131305701);
    this.JuZ = paramOnClickListener;
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(197243);
  }
  
  public void setTermText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(197244);
    ((TextView)findViewById(2131305701)).setText(paramCharSequence);
    AppMethodBeat.o(197244);
  }
  
  public void setTermTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(197245);
    ((TextView)findViewById(2131305700)).setText(paramCharSequence);
    AppMethodBeat.o(197245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.CheckBoxLicenseView
 * JD-Core Version:    0.7.0.1
 */