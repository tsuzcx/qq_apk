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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;

public class CheckBoxLicenseView
  extends LinearLayout
{
  private CompoundButton.OnCheckedChangeListener agGe;
  private View.OnClickListener agGf;
  
  public CheckBoxLicenseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public CheckBoxLicenseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(234803);
    Object localObject = inflate(getContext(), a.h.common_term_check_view, this);
    paramContext = ((View)localObject).findViewById(a.g.term_check);
    paramAttributeSet = (CheckBox)((View)localObject).findViewById(a.g.term_check_box);
    localObject = (TextView)((View)localObject).findViewById(a.g.term_tv);
    paramContext.setOnClickListener(new CheckBoxLicenseView.1(this, paramAttributeSet));
    if (this.agGe != null) {
      paramAttributeSet.setOnCheckedChangeListener(this.agGe);
    }
    if (this.agGf != null) {
      ((TextView)localObject).setOnClickListener(this.agGf);
    }
    AppMethodBeat.o(234803);
  }
  
  public void setCheckStateChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    AppMethodBeat.i(234808);
    this.agGe = paramOnCheckedChangeListener;
    ((CheckBox)findViewById(a.g.term_check_box)).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    AppMethodBeat.o(234808);
  }
  
  public void setLicenseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(234809);
    TextView localTextView = (TextView)findViewById(a.g.term_tv);
    this.agGf = paramOnClickListener;
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(234809);
  }
  
  public void setTermText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(234811);
    ((TextView)findViewById(a.g.term_tv)).setText(paramCharSequence);
    AppMethodBeat.o(234811);
  }
  
  public void setTermTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(234814);
    ((TextView)findViewById(a.g.term_tip)).setText(paramCharSequence);
    AppMethodBeat.o(234814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.CheckBoxLicenseView
 * JD-Core Version:    0.7.0.1
 */