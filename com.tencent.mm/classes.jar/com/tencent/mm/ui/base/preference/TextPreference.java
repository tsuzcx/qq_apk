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
  protected int Hu;
  protected TextView Tu;
  private Context context;
  protected CharSequence mText;
  
  public TextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142681);
    this.context = paramContext;
    setLayoutResource(2131494863);
    AppMethodBeat.o(142681);
  }
  
  private void cE()
  {
    AppMethodBeat.i(142684);
    if (this.Tu == null)
    {
      AppMethodBeat.o(142684);
      return;
    }
    this.Tu.setText(this.mText);
    this.Tu.setGravity(this.Hu);
    AppMethodBeat.o(142684);
  }
  
  public final void al(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142685);
    this.mText = paramCharSequence;
    this.Hu = 17;
    cE();
    AppMethodBeat.o(142685);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142683);
    super.onBindView(paramView);
    this.Tu = ((TextView)paramView.findViewById(16908310));
    cE();
    AppMethodBeat.o(142683);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142682);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(142682);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.TextPreference
 * JD-Core Version:    0.7.0.1
 */