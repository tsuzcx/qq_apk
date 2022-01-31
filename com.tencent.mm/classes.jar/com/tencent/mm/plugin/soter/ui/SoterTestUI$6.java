package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.f;

final class SoterTestUI$6
  implements View.OnClickListener
{
  SoterTestUI$6(SoterTestUI paramSoterTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(59384);
    paramView = a.cu("sample_auth_key_name", false);
    TextView localTextView = SoterTestUI.a(this.soU);
    if (paramView.isSuccess()) {}
    for (paramView = "pass";; paramView = "not passed")
    {
      localTextView.setText(paramView);
      AppMethodBeat.o(59384);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI.6
 * JD-Core Version:    0.7.0.1
 */