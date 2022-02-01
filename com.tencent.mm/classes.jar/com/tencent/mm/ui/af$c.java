package com.tencent.mm.ui;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Wordings;

final class af$c
{
  public static void N(TextView paramTextView)
  {
    AppMethodBeat.i(249907);
    CharSequence localCharSequence = paramTextView.getText();
    if (!TextUtils.isEmpty(localCharSequence)) {
      paramTextView.setText(aR(localCharSequence));
    }
    localCharSequence = paramTextView.getHint();
    if (!TextUtils.isEmpty(localCharSequence)) {
      paramTextView.setHint(aR(localCharSequence));
    }
    localCharSequence = paramTextView.getContentDescription();
    if (!TextUtils.isEmpty(localCharSequence)) {
      paramTextView.setContentDescription(aR(localCharSequence));
    }
    AppMethodBeat.o(249907);
  }
  
  static String aR(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(249908);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(249908);
      return null;
    }
    paramCharSequence = bzO(paramCharSequence.toString());
    AppMethodBeat.o(249908);
    return paramCharSequence;
  }
  
  private static String bzO(String paramString)
  {
    AppMethodBeat.i(249912);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(249912);
      return paramString;
    }
    paramString = WeChatBrands.Wordings.translate(paramString);
    AppMethodBeat.o(249912);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.af.c
 * JD-Core Version:    0.7.0.1
 */