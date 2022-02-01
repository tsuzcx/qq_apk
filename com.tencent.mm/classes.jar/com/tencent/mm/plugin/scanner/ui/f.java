package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.g;
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
    setLayoutResource(l.g.OKo);
    AppMethodBeat.o(51812);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
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
    AppMethodBeat.i(369996);
    super.onBindView(paramView);
    AppMethodBeat.o(369996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.f
 * JD-Core Version:    0.7.0.1
 */