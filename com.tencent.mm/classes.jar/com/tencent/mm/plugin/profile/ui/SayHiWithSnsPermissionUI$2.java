package com.tencent.mm.plugin.profile.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class SayHiWithSnsPermissionUI$2
  implements TextWatcher
{
  SayHiWithSnsPermissionUI$2(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(153565);
    if (this.pCR.pCP[0] != 0)
    {
      this.pCR.pCP[0] = false;
      b.pgQ.VV("ie_ver_usr");
    }
    b.pgQ.VW("ie_ver_usr");
    AppMethodBeat.o(153565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.2
 * JD-Core Version:    0.7.0.1
 */