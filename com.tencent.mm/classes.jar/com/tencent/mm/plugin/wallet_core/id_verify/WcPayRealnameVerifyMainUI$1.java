package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.w.b;

final class WcPayRealnameVerifyMainUI$1
  implements w.b
{
  WcPayRealnameVerifyMainUI$1(WcPayRealnameVerifyMainUI paramWcPayRealnameVerifyMainUI) {}
  
  public final Context getContext()
  {
    AppMethodBeat.i(70118);
    AppCompatActivity localAppCompatActivity = this.VBp.getContext();
    AppMethodBeat.o(70118);
    return localAppCompatActivity;
  }
  
  public final int getShowAgreenRequestCode()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.1
 * JD-Core Version:    0.7.0.1
 */