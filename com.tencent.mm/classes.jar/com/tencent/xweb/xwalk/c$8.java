package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.q;

final class c$8
  implements View.OnClickListener
{
  c$8(c paramc, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85129);
    paramView = q.dYn();
    boolean bool;
    Button localButton;
    if (!q.dYn().BDR)
    {
      bool = true;
      paramView.sf(bool);
      localButton = this.BIR;
      if (!q.dYn().BDR) {
        break label58;
      }
    }
    label58:
    for (paramView = "使用正式版config";; paramView = "使用测试config")
    {
      localButton.setText(paramView);
      AppMethodBeat.o(85129);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.8
 * JD-Core Version:    0.7.0.1
 */