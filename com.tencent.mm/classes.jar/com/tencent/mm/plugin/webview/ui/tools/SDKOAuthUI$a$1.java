package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgv;

final class SDKOAuthUI$a$1
  implements View.OnClickListener
{
  SDKOAuthUI$a$1(SDKOAuthUI.a parama, bgv parambgv, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7539);
    if (this.vbC.xwa == 2)
    {
      this.vbD.setImageResource(2131231594);
      this.vbC.xwa = 1;
      AppMethodBeat.o(7539);
      return;
    }
    if (this.vbC.xwa == 1)
    {
      this.vbD.setImageResource(2131231592);
      this.vbC.xwa = 2;
    }
    AppMethodBeat.o(7539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.a.1
 * JD-Core Version:    0.7.0.1
 */