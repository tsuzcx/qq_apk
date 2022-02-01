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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class CheckBoxLicenseView
  extends LinearLayout
{
  private CompoundButton.OnCheckedChangeListener YKm;
  private View.OnClickListener YKn;
  
  public CheckBoxLicenseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public CheckBoxLicenseView(Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197613);
    Object localObject = inflate(getContext(), a.h.common_term_check_view, this);
    paramContext = ((View)localObject).findViewById(a.g.term_check);
    paramAttributeSet = (CheckBox)((View)localObject).findViewById(a.g.term_check_box);
    localObject = (TextView)((View)localObject).findViewById(a.g.term_tv);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(189028);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAttributeSet.performClick();
        a.a(this, "com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(189028);
      }
    });
    if (this.YKm != null) {
      paramAttributeSet.setOnCheckedChangeListener(this.YKm);
    }
    if (this.YKn != null) {
      ((TextView)localObject).setOnClickListener(this.YKn);
    }
    AppMethodBeat.o(197613);
  }
  
  public void setCheckStateChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    AppMethodBeat.i(197618);
    this.YKm = paramOnCheckedChangeListener;
    ((CheckBox)findViewById(a.g.term_check_box)).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    AppMethodBeat.o(197618);
  }
  
  public void setLicenseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(197621);
    TextView localTextView = (TextView)findViewById(a.g.term_tv);
    this.YKn = paramOnClickListener;
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(197621);
  }
  
  public void setTermText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(197622);
    ((TextView)findViewById(a.g.term_tv)).setText(paramCharSequence);
    AppMethodBeat.o(197622);
  }
  
  public void setTermTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(197625);
    ((TextView)findViewById(a.g.term_tip)).setText(paramCharSequence);
    AppMethodBeat.o(197625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.CheckBoxLicenseView
 * JD-Core Version:    0.7.0.1
 */