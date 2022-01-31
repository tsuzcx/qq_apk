package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.f;

final class SoterTestUI$6
  implements View.OnClickListener
{
  SoterTestUI$6(SoterTestUI paramSoterTestUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = a.bR("sample_auth_key_name", false);
    TextView localTextView = SoterTestUI.a(this.psO);
    if (paramView.isSuccess()) {}
    for (paramView = "pass";; paramView = "not passed")
    {
      localTextView.setText(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI.6
 * JD-Core Version:    0.7.0.1
 */