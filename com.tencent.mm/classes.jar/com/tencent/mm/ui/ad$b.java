package com.tencent.mm.ui;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Wordings;

final class ad$b
{
  public static void K(TextView paramTextView)
  {
    AppMethodBeat.i(196613);
    CharSequence localCharSequence = paramTextView.getText();
    if (!TextUtils.isEmpty(localCharSequence)) {
      paramTextView.setText(aE(localCharSequence));
    }
    localCharSequence = paramTextView.getHint();
    if (!TextUtils.isEmpty(localCharSequence)) {
      paramTextView.setHint(aE(localCharSequence));
    }
    localCharSequence = paramTextView.getContentDescription();
    if (!TextUtils.isEmpty(localCharSequence)) {
      paramTextView.setContentDescription(aE(localCharSequence));
    }
    AppMethodBeat.o(196613);
  }
  
  static String aE(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196615);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(196615);
      return null;
    }
    paramCharSequence = bys(paramCharSequence.toString());
    AppMethodBeat.o(196615);
    return paramCharSequence;
  }
  
  private static String bys(String paramString)
  {
    AppMethodBeat.i(196616);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(196616);
      return paramString;
    }
    paramString = WeChatBrands.Wordings.translate(paramString);
    AppMethodBeat.o(196616);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ad.b
 * JD-Core Version:    0.7.0.1
 */