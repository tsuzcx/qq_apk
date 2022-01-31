package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.w;

public class TextButtonPreference
  extends Preference
{
  public TextButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final int getLayoutResource()
  {
    return 2130970183;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(107297);
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView != null)
    {
      paramView.setText(getTitle());
      paramView.setEnabled(isEnabled());
    }
    AppMethodBeat.o(107297);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107296);
    super.onCreateView(paramViewGroup);
    paramViewGroup = w.hM(this.mContext).inflate(2130970183, paramViewGroup, false);
    AppMethodBeat.o(107296);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.TextButtonPreference
 * JD-Core Version:    0.7.0.1
 */