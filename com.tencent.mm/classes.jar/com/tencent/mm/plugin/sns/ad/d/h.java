package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  public static void a(int paramInt1, ai paramai, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(309942);
    if (paramInt2 <= paramLong)
    {
      AppMethodBeat.o(309942);
      return;
    }
    if (paramLong < 0L) {
      if (paramInt1 != 61) {}
    }
    for (;;)
    {
      String str;
      try
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 14);
        str = "";
        if (paramai != null) {
          str = paramai.source + "|" + paramai.uxInfo;
        }
        if (paramInt1 != 61) {
          break label360;
        }
        l.a(l.QnH, "1", paramInt2, (int)paramLong, str);
        Log.e(paramString, "playTimeInterval more than compStayTime, videoComp type is " + paramInt1 + ", playTimeInterval is " + paramInt2 + ", compStayTime is " + paramLong + ", extra is " + str);
        AppMethodBeat.o(309942);
        return;
      }
      finally
      {
        Log.e(paramString, paramai.toString());
        AppMethodBeat.o(309942);
        return;
      }
      if (paramInt1 == 62)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 17);
      }
      else if (paramInt1 == 142)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 11);
        continue;
        if (paramLong == 0L)
        {
          if (paramInt1 == 61) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 15);
          } else if (paramInt1 == 62) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 18);
          } else if (paramInt1 == 142) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 12);
          }
        }
        else if (paramInt2 - paramLong > 10L)
        {
          if (paramInt1 == 61) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 16);
          } else if (paramInt1 == 62) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 19);
          } else if (paramInt1 == 142) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 13);
          }
        }
        else
        {
          AppMethodBeat.o(309942);
          return;
          label360:
          if (paramInt1 == 62) {
            l.a(l.QnH, "2", paramInt2, (int)paramLong, str);
          } else if (paramInt1 == 142) {
            l.a(l.QnH, "0", paramInt2, (int)paramLong, str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.h
 * JD-Core Version:    0.7.0.1
 */