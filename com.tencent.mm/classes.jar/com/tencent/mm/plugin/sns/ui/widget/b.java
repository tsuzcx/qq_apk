package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static boolean kS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203998);
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(paramString2)))
    {
      Log.d("SnsCardAdTagUtils", "should refresh adTag");
      AppMethodBeat.o(203998);
      return false;
    }
    Log.d("SnsCardAdTagUtils", "should not refresh adTag, show origin adTag");
    AppMethodBeat.o(203998);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */