package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public static boolean jK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200667);
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(paramString2)))
    {
      ac.d("SnsCardAdTagUtils", "should refresh adTag");
      AppMethodBeat.o(200667);
      return false;
    }
    ac.d("SnsCardAdTagUtils", "should not refresh adTag, show origin adTag");
    AppMethodBeat.o(200667);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */