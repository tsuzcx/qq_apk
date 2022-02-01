package com.tencent.mm.plugin.sns.data;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
{
  public static String wAJ = "offline_video_error";
  public static String wAK = "fullcard_info_null";
  public static String wAL = "download_info_null";
  public static String wAM = "video_end_in_anim";
  public static String wAN = "sight_del_err_file";
  public static String wAO = "cut_height_error";
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(187253);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool)
      {
        AppMethodBeat.o(187253);
        return;
      }
      paramString2 = bt.by(paramString2, "");
      paramString3 = bt.by(paramString3, "");
      ad.i("SnsAdTecReportUtil", "adTecReport, actName=" + paramString1 + ", actValue=" + paramString2 + ", subType=" + paramInt1 + ", subValue=" + paramInt2 + ", extra=" + paramString3);
      h.vKh.f(19789, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
      AppMethodBeat.o(187253);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("SnsAdTecReportUtil", "adTecReport exp=" + paramString1.toString());
      AppMethodBeat.o(187253);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.i
 * JD-Core Version:    0.7.0.1
 */