package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class SnsUploadUI$20
  implements TextWatcher
{
  SnsUploadUI$20(SnsUploadUI paramSnsUploadUI, boolean[] paramArrayOfBoolean) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(145663);
    if (this.sbV[0] != 0)
    {
      this.sbV[0] = false;
      b.pgQ.VV("ie_sns_upload");
    }
    b.pgQ.VW("ie_sns_upload");
    AppMethodBeat.o(145663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.20
 * JD-Core Version:    0.7.0.1
 */