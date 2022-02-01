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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class CheckBoxLicenseView
  extends LinearLayout
{
  private CompoundButton.OnCheckedChangeListener LKL;
  private View.OnClickListener LKM;
  
  public CheckBoxLicenseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public CheckBoxLicenseView(Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193808);
    Object localObject = inflate(getContext(), 2131493578, this);
    paramContext = ((View)localObject).findViewById(2131305697);
    paramAttributeSet = (CheckBox)((View)localObject).findViewById(2131305698);
    localObject = (TextView)((View)localObject).findViewById(2131305701);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193807);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAttributeSet.performClick();
        a.a(this, "com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193807);
      }
    });
    if (this.LKL != null) {
      paramAttributeSet.setOnCheckedChangeListener(this.LKL);
    }
    if (this.LKM != null) {
      ((TextView)localObject).setOnClickListener(this.LKM);
    }
    AppMethodBeat.o(193808);
  }
  
  public void setCheckStateChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    AppMethodBeat.i(193809);
    this.LKL = paramOnCheckedChangeListener;
    ((CheckBox)findViewById(2131305698)).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    AppMethodBeat.o(193809);
  }
  
  public void setLicenseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(193810);
    TextView localTextView = (TextView)findViewById(2131305701);
    this.LKM = paramOnClickListener;
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(193810);
  }
  
  public void setTermText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(193811);
    ((TextView)findViewById(2131305701)).setText(paramCharSequence);
    AppMethodBeat.o(193811);
  }
  
  public void setTermTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(193812);
    ((TextView)findViewById(2131305700)).setText(paramCharSequence);
    AppMethodBeat.o(193812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.view.CheckBoxLicenseView
 * JD-Core Version:    0.7.0.1
 */