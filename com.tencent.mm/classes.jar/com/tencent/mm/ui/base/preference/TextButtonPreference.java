package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.y;

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
    return 2131494808;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142680);
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView != null)
    {
      paramView.setText(getTitle());
      paramView.setEnabled(isEnabled());
    }
    AppMethodBeat.o(142680);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142679);
    super.onCreateView(paramViewGroup);
    paramViewGroup = y.js(this.mContext).inflate(2131494808, paramViewGroup, false);
    AppMethodBeat.o(142679);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.TextButtonPreference
 * JD-Core Version:    0.7.0.1
 */