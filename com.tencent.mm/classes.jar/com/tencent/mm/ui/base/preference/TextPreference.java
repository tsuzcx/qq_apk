package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.h;

public class TextPreference
  extends Preference
{
  public a aeat;
  private Context context;
  protected CharSequence mText;
  protected TextView sQ;
  protected int tJ;
  
  public TextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142681);
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference_info);
    AppMethodBeat.o(142681);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(142684);
    if (this.sQ == null)
    {
      AppMethodBeat.o(142684);
      return;
    }
    this.sQ.setText(this.mText);
    this.sQ.setGravity(this.tJ);
    AppMethodBeat.o(142684);
  }
  
  public final void aT(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142685);
    this.mText = paramCharSequence;
    this.tJ = 17;
    updateView();
    AppMethodBeat.o(142685);
  }
  
  public final void aU(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251501);
    if (this.sQ == null)
    {
      AppMethodBeat.o(251501);
      return;
    }
    this.mText = paramCharSequence;
    this.tJ = 17;
    this.sQ.setGravity(this.tJ);
    AppMethodBeat.o(251501);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142683);
    super.onBindView(paramView);
    this.sQ = ((TextView)paramView.findViewById(16908310));
    updateView();
    if (this.aeat != null) {
      this.aeat.D(this.sQ);
    }
    AppMethodBeat.o(142683);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142682);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(142682);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void D(TextView paramTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.TextPreference
 * JD-Core Version:    0.7.0.1
 */