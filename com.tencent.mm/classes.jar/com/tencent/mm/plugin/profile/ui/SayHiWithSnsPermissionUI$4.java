package com.tencent.mm.plugin.profile.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class SayHiWithSnsPermissionUI$4
  implements View.OnFocusChangeListener
{
  SayHiWithSnsPermissionUI$4(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(27394);
    if (paramBoolean)
    {
      if ((!Util.isNullOrNil(SayHiWithSnsPermissionUI.a(this.Biw).getHint())) && (Util.isNullOrNil(SayHiWithSnsPermissionUI.a(this.Biw).getText())))
      {
        SayHiWithSnsPermissionUI.a(this.Biw).setText(SayHiWithSnsPermissionUI.a(this.Biw).getHint());
        SayHiWithSnsPermissionUI.a(this.Biw).setHint(null);
      }
      SayHiWithSnsPermissionUI.a(this.Biw).setSelection(SayHiWithSnsPermissionUI.a(this.Biw).getText().length());
    }
    AppMethodBeat.o(27394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.4
 * JD-Core Version:    0.7.0.1
 */