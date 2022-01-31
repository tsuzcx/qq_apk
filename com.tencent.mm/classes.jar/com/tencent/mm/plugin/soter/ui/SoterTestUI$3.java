package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.f;

final class SoterTestUI$3
  implements View.OnClickListener
{
  SoterTestUI$3(SoterTestUI paramSoterTestUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = a.cPj();
    TextView localTextView = SoterTestUI.a(this.psO);
    if (paramView.isSuccess()) {}
    for (paramView = "passed";; paramView = "not passed")
    {
      localTextView.setText(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI.3
 * JD-Core Version:    0.7.0.1
 */