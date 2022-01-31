package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.f;

final class SoterTestUI$3
  implements View.OnClickListener
{
  SoterTestUI$3(SoterTestUI paramSoterTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(59381);
    paramView = a.dVe();
    TextView localTextView = SoterTestUI.a(this.soU);
    if (paramView.isSuccess()) {}
    for (paramView = "passed";; paramView = "not passed")
    {
      localTextView.setText(paramView);
      AppMethodBeat.o(59381);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI.3
 * JD-Core Version:    0.7.0.1
 */