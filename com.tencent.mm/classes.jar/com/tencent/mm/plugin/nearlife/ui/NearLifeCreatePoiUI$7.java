package com.tencent.mm.plugin.nearlife.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearLifeCreatePoiUI$7
  implements TextWatcher
{
  NearLifeCreatePoiUI$7(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(22978);
    if ((NearLifeCreatePoiUI.d(this.pfL).getText().toString().trim().length() == 0) || (NearLifeCreatePoiUI.f(this.pfL).getText().toString().trim().length() == 0) || (NearLifeCreatePoiUI.e(this.pfL).getText().toString().trim().length() == 0))
    {
      this.pfL.enableOptionMenu(0, false);
      AppMethodBeat.o(22978);
      return;
    }
    this.pfL.enableOptionMenu(0, true);
    AppMethodBeat.o(22978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.7
 * JD-Core Version:    0.7.0.1
 */