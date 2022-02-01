package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class SnsUploadUI$2
  implements TextWatcher
{
  SnsUploadUI$2(SnsUploadUI paramSnsUploadUI, boolean[] paramArrayOfBoolean) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(176363);
    if (this.Apf[0] != 0)
    {
      this.Apf[0] = false;
      b.wtJ.atp("ie_sns_upload");
    }
    b.wtJ.atq("ie_sns_upload");
    AppMethodBeat.o(176363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.2
 * JD-Core Version:    0.7.0.1
 */