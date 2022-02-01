package com.tencent.mm.ui.matrix;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class MatrixSettingUI$2
  implements MatrixSettingSeekBarPreference.a
{
  MatrixSettingUI$2(MatrixSettingUI paramMatrixSettingUI) {}
  
  public final void aeO(int paramInt)
  {
    AppMethodBeat.i(38887);
    ad.i("Matrix.SettingUI", "[onConfirm] threshold=".concat(String.valueOf(paramInt)));
    MatrixSettingUI.cm("MODIFY_EVIL_THRESHOLD", paramInt);
    AppMethodBeat.o(38887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingUI.2
 * JD-Core Version:    0.7.0.1
 */