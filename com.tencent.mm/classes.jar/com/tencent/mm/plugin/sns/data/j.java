package com.tencent.mm.plugin.sns.data;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class j
{
  public static String ztL = "offline_video_error";
  public static String ztM = "offline_video_error2";
  public static String ztN = "fullcard_info_null";
  public static String ztO = "download_info_null";
  public static String ztP = "video_end_in_anim";
  public static String ztQ = "sight_del_err_file";
  public static String ztR = "cut_height_error";
  public static String ztS = "oaid_empty";
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(219238);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool)
      {
        AppMethodBeat.o(219238);
        return;
      }
      paramString2 = bu.bI(paramString2, "");
      paramString3 = bu.bI(paramString3, "");
      ae.i("SnsAdTecReportUtil", "adTecReport, actName=" + paramString1 + ", actValue=" + paramString2 + ", subType=" + paramInt1 + ", subValue=" + paramInt2 + ", extra=" + paramString3);
      g.yxI.f(19789, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
      AppMethodBeat.o(219238);
      return;
    }
    catch (Throwable paramString1)
    {
      ae.e("SnsAdTecReportUtil", "adTecReport exp=" + paramString1.toString());
      AppMethodBeat.o(219238);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.j
 * JD-Core Version:    0.7.0.1
 */