package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;

final class SnsUploadUI$3
  implements TextWatcher
{
  SnsUploadUI$3(SnsUploadUI paramSnsUploadUI, boolean[] paramArrayOfBoolean) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(369960);
    if (this.akiS[0] != 0)
    {
      this.akiS[0] = false;
      d.MtP.aQh("ie_sns_upload");
    }
    d.MtP.aQi("ie_sns_upload");
    AppMethodBeat.o(369960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.3
 * JD-Core Version:    0.7.0.1
 */