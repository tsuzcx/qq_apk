package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.i;

final class SoterTestUI$4
  implements View.OnClickListener
{
  SoterTestUI$4(SoterTestUI paramSoterTestUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = a.cPm();
    if (paramView == null)
    {
      SoterTestUI.a(this.psO).setText("not passed: no certificate");
      return;
    }
    SoterTestUI.a(this.psO).setText("model available: " + paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI.4
 * JD-Core Version:    0.7.0.1
 */