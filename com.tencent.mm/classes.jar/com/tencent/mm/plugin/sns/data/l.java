package com.tencent.mm.plugin.sns.data;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
{
  public static String QnA = "landing_page_comp_type_fp";
  public static String QnB = "landing_page_comp_no_size";
  public static String QnC = "fullcard_time_cost";
  public static String QnD = "has_sensor_type";
  public static String QnE = "landing_page_img_hit";
  public static String QnF = "landing_page_sight_hit";
  public static String QnG = "landing_page_video_comp_loading_time";
  public static String QnH = "landing_page_video_comp_play_exposure_time_diff";
  public static String QnI = "report_video_capability_in_landing_page";
  public static String Qnk = "offline_video_error";
  public static String Qnl = "offline_video_error2";
  public static String Qnm = "fullcard_info_null";
  public static String Qnn = "download_info_null";
  public static String Qno = "sight_del_err_file";
  public static String Qnp = "cut_height_error";
  public static String Qnq = "oaid_empty";
  public static String Qnr = "gyroscope_sensor";
  public static String Qns = "dev_disable_hevc";
  public static String Qnt = "twist_zone_sensor";
  public static String Qnu = "twist_req_cost";
  public static String Qnv = "ad_pull_nettype";
  public static String Qnw = "image_md5_empty";
  public static String Qnx = "filter_ad_exp";
  public static String Qny = "landing_page_cost";
  public static String Qnz = "landing_page_comp_type";
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(306394);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool)
      {
        AppMethodBeat.o(306394);
        return;
      }
      paramString2 = Util.nullAs(paramString2, "");
      paramString3 = Util.nullAs(paramString3, "");
      Log.i("SnsAdTecReportUtil", "adTecReport, actName=" + paramString1 + ", actValue=" + paramString2 + ", subType=" + paramInt1 + ", subValue=" + paramInt2 + ", extra=" + paramString3);
      h.OAn.b(19789, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
      AppMethodBeat.o(306394);
      return;
    }
    finally
    {
      Log.e("SnsAdTecReportUtil", "adTecReport exp=" + paramString1.toString());
      AppMethodBeat.o(306394);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.l
 * JD-Core Version:    0.7.0.1
 */