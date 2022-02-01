package com.tencent.mm.wallet_core.ui;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  implements InputFilter
{
  private static String TAG = "MicroMsg.TextByteLengthInputFilter";
  private int agUQ = 75;
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(242195);
    Log.d(TAG, "byte filter: %s, %s, %s, %s, %s, %s", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      Log.i(TAG, "skip delete case");
      AppMethodBeat.o(242195);
      return null;
    }
    int i = paramInt4 - paramInt3;
    if ((paramSpanned != null) && (paramSpanned.toString().getBytes().length >= this.agUQ) && (i == 0))
    {
      Log.i(TAG, "ignore exceed case: %s", new Object[] { Integer.valueOf(paramSpanned.toString().getBytes().length) });
      AppMethodBeat.o(242195);
      return "";
    }
    paramInt2 = paramCharSequence.toString().getBytes().length;
    if (paramSpanned != null)
    {
      paramInt1 = paramSpanned.toString().getBytes().length;
      Log.i(TAG, "source length: %s, dest length: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (i != 0) {
        break label283;
      }
      paramInt1 += paramInt2;
    }
    for (;;)
    {
      Log.d(TAG, "final byte length: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 <= this.agUQ) {
        break label335;
      }
      Log.i(TAG, "exceed max byte length: %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.agUQ) });
      AppMethodBeat.o(242195);
      return "";
      paramInt1 = 0;
      break;
      label283:
      paramInt3 = paramSpanned.subSequence(paramInt3, paramInt4).toString().getBytes().length;
      paramInt1 = paramInt1 + paramInt2 - paramInt3;
      Log.i(TAG, "replace byte length: %s", new Object[] { Integer.valueOf(paramInt3) });
    }
    label335:
    AppMethodBeat.o(242195);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */