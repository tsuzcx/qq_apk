package com.tencent.mm.plugin.sns.data;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
{
  public static String DDV = "offline_video_error";
  public static String DDW = "offline_video_error2";
  public static String DDX = "fullcard_info_null";
  public static String DDY = "download_info_null";
  public static String DDZ = "video_end_in_anim";
  public static String DEa = "sight_del_err_file";
  public static String DEb = "cut_height_error";
  public static String DEc = "oaid_empty";
  public static String DEd = "gyroscope_sensor";
  public static String DEe = "dev_disable_hevc";
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(202586);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool)
      {
        AppMethodBeat.o(202586);
        return;
      }
      paramString2 = Util.nullAs(paramString2, "");
      paramString3 = Util.nullAs(paramString3, "");
      Log.i("SnsAdTecReportUtil", "adTecReport, actName=" + paramString1 + ", actValue=" + paramString2 + ", subType=" + paramInt1 + ", subValue=" + paramInt2 + ", extra=" + paramString3);
      h.CyF.a(19789, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
      AppMethodBeat.o(202586);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("SnsAdTecReportUtil", "adTecReport exp=" + paramString1.toString());
      AppMethodBeat.o(202586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.j
 * JD-Core Version:    0.7.0.1
 */