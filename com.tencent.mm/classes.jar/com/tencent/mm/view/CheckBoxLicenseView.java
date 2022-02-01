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
  private CompoundButton.OnCheckedChangeListener RiF;
  private View.OnClickListener RiG;
  
  public CheckBoxLicenseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public CheckBoxLicenseView(Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206165);
    Object localObject = inflate(getContext(), 2131493695, this);
    paramContext = ((View)localObject).findViewById(2131308964);
    paramAttributeSet = (CheckBox)((View)localObject).findViewById(2131308965);
    localObject = (TextView)((View)localObject).findViewById(2131308968);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(206164);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAttributeSet.performClick();
        a.a(this, "com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206164);
      }
    });
    if (this.RiF != null) {
      paramAttributeSet.setOnCheckedChangeListener(this.RiF);
    }
    if (this.RiG != null) {
      ((TextView)localObject).setOnClickListener(this.RiG);
    }
    AppMethodBeat.o(206165);
  }
  
  public void setCheckStateChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    AppMethodBeat.i(206166);
    this.RiF = paramOnCheckedChangeListener;
    ((CheckBox)findViewById(2131308965)).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    AppMethodBeat.o(206166);
  }
  
  public void setLicenseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(206167);
    TextView localTextView = (TextView)findViewById(2131308968);
    this.RiG = paramOnClickListener;
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(206167);
  }
  
  public void setTermText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(206168);
    ((TextView)findViewById(2131308968)).setText(paramCharSequence);
    AppMethodBeat.o(206168);
  }
  
  public void setTermTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(206169);
    ((TextView)findViewById(2131308967)).setText(paramCharSequence);
    AppMethodBeat.o(206169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.view.CheckBoxLicenseView
 * JD-Core Version:    0.7.0.1
 */