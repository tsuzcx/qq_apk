package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class SayHiWithSnsPermissionUI$4
  implements View.OnFocusChangeListener
{
  SayHiWithSnsPermissionUI$4(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(153567);
    if ((paramBoolean) && (!bo.aa(SayHiWithSnsPermissionUI.b(this.pCR).getHint())) && (bo.aa(SayHiWithSnsPermissionUI.b(this.pCR).getText())))
    {
      SayHiWithSnsPermissionUI.b(this.pCR).setText(SayHiWithSnsPermissionUI.b(this.pCR).getHint());
      SayHiWithSnsPermissionUI.b(this.pCR).setOnFocusChangeListener(null);
      SayHiWithSnsPermissionUI.b(this.pCR).setHint(null);
    }
    AppMethodBeat.o(153567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.4
 * JD-Core Version:    0.7.0.1
 */