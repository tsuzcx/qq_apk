package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static boolean jm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187794);
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(paramString2)))
    {
      ad.d("SnsCardAdTagUtils", "should refresh adTag");
      AppMethodBeat.o(187794);
      return false;
    }
    ad.d("SnsCardAdTagUtils", "should not refresh adTag, show origin adTag");
    AppMethodBeat.o(187794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */