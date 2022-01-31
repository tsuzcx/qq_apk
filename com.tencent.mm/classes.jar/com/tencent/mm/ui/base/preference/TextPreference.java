package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextPreference
  extends Preference
{
  protected int AZ;
  private Context context;
  protected CharSequence mText;
  protected TextView md;
  
  public TextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107298);
    this.context = paramContext;
    setLayoutResource(2130970236);
    AppMethodBeat.o(107298);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(107301);
    if (this.md == null)
    {
      AppMethodBeat.o(107301);
      return;
    }
    this.md.setText(this.mText);
    this.md.setGravity(this.AZ);
    AppMethodBeat.o(107301);
  }
  
  public final void ac(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107302);
    this.mText = paramCharSequence;
    this.AZ = 17;
    bJ();
    AppMethodBeat.o(107302);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(107300);
    super.onBindView(paramView);
    this.md = ((TextView)paramView.findViewById(16908310));
    bJ();
    AppMethodBeat.o(107300);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107299);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(107299);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.TextPreference
 * JD-Core Version:    0.7.0.1
 */