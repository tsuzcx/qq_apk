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
  private CompoundButton.OnCheckedChangeListener Loa;
  private View.OnClickListener Lob;
  
  public CheckBoxLicenseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public CheckBoxLicenseView(Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186550);
    Object localObject = inflate(getContext(), 2131493578, this);
    paramContext = ((View)localObject).findViewById(2131305697);
    paramAttributeSet = (CheckBox)((View)localObject).findViewById(2131305698);
    localObject = (TextView)((View)localObject).findViewById(2131305701);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186549);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAttributeSet.performClick();
        a.a(this, "com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186549);
      }
    });
    if (this.Loa != null) {
      paramAttributeSet.setOnCheckedChangeListener(this.Loa);
    }
    if (this.Lob != null) {
      ((TextView)localObject).setOnClickListener(this.Lob);
    }
    AppMethodBeat.o(186550);
  }
  
  public void setCheckStateChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    AppMethodBeat.i(186551);
    this.Loa = paramOnCheckedChangeListener;
    ((CheckBox)findViewById(2131305698)).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    AppMethodBeat.o(186551);
  }
  
  public void setLicenseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(186552);
    TextView localTextView = (TextView)findViewById(2131305701);
    this.Lob = paramOnClickListener;
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(186552);
  }
  
  public void setTermText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(186553);
    ((TextView)findViewById(2131305701)).setText(paramCharSequence);
    AppMethodBeat.o(186553);
  }
  
  public void setTermTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(186554);
    ((TextView)findViewById(2131305700)).setText(paramCharSequence);
    AppMethodBeat.o(186554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.view.CheckBoxLicenseView
 * JD-Core Version:    0.7.0.1
 */