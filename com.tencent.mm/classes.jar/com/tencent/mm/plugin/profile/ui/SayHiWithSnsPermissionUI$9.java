package com.tencent.mm.plugin.profile.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class SayHiWithSnsPermissionUI$9
  implements View.OnFocusChangeListener
{
  SayHiWithSnsPermissionUI$9(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(27394);
    if (paramBoolean)
    {
      if ((!Util.isNullOrNil(SayHiWithSnsPermissionUI.a(this.HcH).getHint())) && (Util.isNullOrNil(SayHiWithSnsPermissionUI.a(this.HcH).getText())))
      {
        SayHiWithSnsPermissionUI.a(this.HcH).setText(SayHiWithSnsPermissionUI.a(this.HcH).getHint());
        SayHiWithSnsPermissionUI.a(this.HcH).setHint(null);
      }
      SayHiWithSnsPermissionUI.a(this.HcH).setSelection(SayHiWithSnsPermissionUI.a(this.HcH).getText().length());
      this.HcH.Hcp = true;
    }
    AppMethodBeat.o(27394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.9
 * JD-Core Version:    0.7.0.1
 */