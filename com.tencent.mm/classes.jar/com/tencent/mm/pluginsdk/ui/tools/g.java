package com.tencent.mm.pluginsdk.ui.tools;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public static InputFilter[] wfe;
  
  static
  {
    AppMethodBeat.i(105868);
    wfe = new InputFilter[] { new InputFilter.LengthFilter(50) };
    AppMethodBeat.o(105868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */