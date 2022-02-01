package com.tencent.mm.plugin.profile.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class SayHiWithSnsPermissionUI3$8
  implements View.OnFocusChangeListener
{
  SayHiWithSnsPermissionUI3$8(SayHiWithSnsPermissionUI3 paramSayHiWithSnsPermissionUI3) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(231907);
    if (paramBoolean)
    {
      if ((!Util.isNullOrNil(SayHiWithSnsPermissionUI3.d(this.BiJ).getHint())) && (Util.isNullOrNil(SayHiWithSnsPermissionUI3.d(this.BiJ).getText())))
      {
        SayHiWithSnsPermissionUI3.d(this.BiJ).setText(SayHiWithSnsPermissionUI3.d(this.BiJ).getHint());
        SayHiWithSnsPermissionUI3.d(this.BiJ).setHint(null);
      }
      SayHiWithSnsPermissionUI3.d(this.BiJ).setSelection(SayHiWithSnsPermissionUI3.d(this.BiJ).getText().length());
    }
    AppMethodBeat.o(231907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.8
 * JD-Core Version:    0.7.0.1
 */