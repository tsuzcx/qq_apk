package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public final class f
  extends Preference
{
  private View mView;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51812);
    this.mView = null;
    setLayoutResource(2131495112);
    AppMethodBeat.o(51812);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51813);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    super.onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(51813);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(224240);
    super.onBindView(paramView);
    AppMethodBeat.o(224240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.f
 * JD-Core Version:    0.7.0.1
 */