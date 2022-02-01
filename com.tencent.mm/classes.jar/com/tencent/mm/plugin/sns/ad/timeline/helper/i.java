package com.tencent.mm.plugin.sns.ad.timeline.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class i
{
  public static void ajC(int paramInt)
  {
    AppMethodBeat.i(311146);
    try
    {
      String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
      l.a(l.Qnv, str, paramInt, 0, "");
      AppMethodBeat.o(311146);
      return;
    }
    finally
    {
      Log.e("TimeLineStaticHelper", "reportNetType, exp=" + localObject.toString());
      AppMethodBeat.o(311146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.i
 * JD-Core Version:    0.7.0.1
 */