package com.tencent.mm.plugin.profile.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class SayHiWithSnsPermissionUI2$4
  implements View.OnFocusChangeListener
{
  SayHiWithSnsPermissionUI2$4(SayHiWithSnsPermissionUI2 paramSayHiWithSnsPermissionUI2) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(179676);
    if (paramBoolean)
    {
      if ((!Util.isNullOrNil(SayHiWithSnsPermissionUI2.a(this.BiF).getHint())) && (Util.isNullOrNil(SayHiWithSnsPermissionUI2.a(this.BiF).getText())))
      {
        SayHiWithSnsPermissionUI2.a(this.BiF).setText(SayHiWithSnsPermissionUI2.a(this.BiF).getHint());
        SayHiWithSnsPermissionUI2.a(this.BiF).setHint(null);
      }
      SayHiWithSnsPermissionUI2.a(this.BiF).setSelection(SayHiWithSnsPermissionUI2.a(this.BiF).getText().length());
    }
    AppMethodBeat.o(179676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.4
 * JD-Core Version:    0.7.0.1
 */