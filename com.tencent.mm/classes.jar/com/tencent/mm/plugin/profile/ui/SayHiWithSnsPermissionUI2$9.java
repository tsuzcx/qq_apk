package com.tencent.mm.plugin.profile.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class SayHiWithSnsPermissionUI2$9
  implements View.OnFocusChangeListener
{
  SayHiWithSnsPermissionUI2$9(SayHiWithSnsPermissionUI2 paramSayHiWithSnsPermissionUI2) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(179676);
    if (paramBoolean)
    {
      if ((!Util.isNullOrNil(SayHiWithSnsPermissionUI2.a(this.HcW).getHint())) && (Util.isNullOrNil(SayHiWithSnsPermissionUI2.a(this.HcW).getText())))
      {
        SayHiWithSnsPermissionUI2.a(this.HcW).setText(SayHiWithSnsPermissionUI2.a(this.HcW).getHint());
        SayHiWithSnsPermissionUI2.a(this.HcW).setHint(null);
      }
      SayHiWithSnsPermissionUI2.b(this.HcW);
      SayHiWithSnsPermissionUI2.a(this.HcW).setSelection(SayHiWithSnsPermissionUI2.a(this.HcW).getText().length());
    }
    AppMethodBeat.o(179676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.9
 * JD-Core Version:    0.7.0.1
 */