package com.tencent.mm.plugin.profile.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class SayHiWithSnsPermissionUI3$15
  implements View.OnFocusChangeListener
{
  SayHiWithSnsPermissionUI3$15(SayHiWithSnsPermissionUI3 paramSayHiWithSnsPermissionUI3) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(286470);
    if (paramBoolean)
    {
      if ((!Util.isNullOrNil(SayHiWithSnsPermissionUI3.d(this.Hdf).getHint())) && (Util.isNullOrNil(SayHiWithSnsPermissionUI3.d(this.Hdf).getText())))
      {
        SayHiWithSnsPermissionUI3.d(this.Hdf).setText(SayHiWithSnsPermissionUI3.d(this.Hdf).getHint());
        SayHiWithSnsPermissionUI3.d(this.Hdf).setHint(null);
      }
      SayHiWithSnsPermissionUI3.e(this.Hdf);
      SayHiWithSnsPermissionUI3.d(this.Hdf).setSelection(SayHiWithSnsPermissionUI3.d(this.Hdf).getText().length());
    }
    AppMethodBeat.o(286470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.15
 * JD-Core Version:    0.7.0.1
 */