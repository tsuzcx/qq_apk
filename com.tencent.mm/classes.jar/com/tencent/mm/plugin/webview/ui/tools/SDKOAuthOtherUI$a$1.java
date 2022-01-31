package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgv;

final class SDKOAuthOtherUI$a$1
  implements View.OnClickListener
{
  SDKOAuthOtherUI$a$1(SDKOAuthOtherUI.a parama, bgv parambgv, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7510);
    if (this.vbC.xwa == 2)
    {
      this.vbD.setImageResource(2131231597);
      this.vbC.xwa = 1;
      AppMethodBeat.o(7510);
      return;
    }
    if (this.vbC.xwa == 1)
    {
      this.vbD.setImageResource(2131231595);
      this.vbC.xwa = 2;
    }
    AppMethodBeat.o(7510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.a.1
 * JD-Core Version:    0.7.0.1
 */