package com.tencent.mm.plugin.sns.data;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
{
  public static String JQE = "offline_video_error";
  public static String JQF = "offline_video_error2";
  public static String JQG = "fullcard_info_null";
  public static String JQH = "download_info_null";
  public static String JQI = "video_end_in_anim";
  public static String JQJ = "sight_del_err_file";
  public static String JQK = "cut_height_error";
  public static String JQL = "oaid_empty";
  public static String JQM = "gyroscope_sensor";
  public static String JQN = "dev_disable_hevc";
  public static String JQO = "twist_zone_sensor";
  public static String JQP = "twist_req_cost";
  public static String JQQ = "ad_pull_nettype";
  public static String JQR = "image_md5_empty";
  public static String JQS = "filter_ad_exp";
  public static String JQT = "landing_page_cost";
  public static String JQU = "landing_page_comp_type";
  public static String JQV = "landing_page_comp_size";
  public static String JQW = "fullcard_time_cost";
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(254120);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool)
      {
        AppMethodBeat.o(254120);
        return;
      }
      paramString2 = Util.nullAs(paramString2, "");
      paramString3 = Util.nullAs(paramString3, "");
      Log.i("SnsAdTecReportUtil", "adTecReport, actName=" + paramString1 + ", actValue=" + paramString2 + ", subType=" + paramInt1 + ", subValue=" + paramInt2 + ", extra=" + paramString3);
      h.IzE.a(19789, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
      AppMethodBeat.o(254120);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("SnsAdTecReportUtil", "adTecReport exp=" + paramString1.toString());
      AppMethodBeat.o(254120);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.l
 * JD-Core Version:    0.7.0.1
 */