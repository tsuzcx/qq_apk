package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;

final class d$8
  implements View.OnClickListener
{
  d$8(d paramd, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154159);
    paramView = this.KFu;
    Button localButton = this.KFx;
    int i = paramView.KFf.getSettings().getForceDarkMode();
    int j = paramView.KFf.getSettings().getForceDarkBehavior();
    if ((i != 0) && (i == 2)) {
      if (j == 2) {
        paramView.KFf.getSettings().setForceDarkBehavior(1);
      }
    }
    for (;;)
    {
      paramView.f(localButton);
      AppMethodBeat.o(154159);
      return;
      if (j == 1)
      {
        paramView.KFf.getSettings().setForceDarkMode(0);
      }
      else if (j == 0)
      {
        paramView.KFf.getSettings().setForceDarkMode(0);
      }
      else
      {
        paramView.KFf.getSettings().setForceDarkMode(2);
        paramView.KFf.getSettings().setForceDarkBehavior(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.8
 * JD-Core Version:    0.7.0.1
 */