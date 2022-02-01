package com.tencent.mm.plugin.sns.data;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class i
{
  public static String xNd = "offline_video_error";
  public static String xNe = "fullcard_info_null";
  public static String xNf = "download_info_null";
  public static String xNg = "video_end_in_anim";
  public static String xNh = "sight_del_err_file";
  public static String xNi = "cut_height_error";
  public static String xNj = "oaid_empty";
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(200038);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool)
      {
        AppMethodBeat.o(200038);
        return;
      }
      paramString2 = bs.bG(paramString2, "");
      paramString3 = bs.bG(paramString3, "");
      ac.i("SnsAdTecReportUtil", "adTecReport, actName=" + paramString1 + ", actValue=" + paramString2 + ", subType=" + paramInt1 + ", subValue=" + paramInt2 + ", extra=" + paramString3);
      h.wUl.f(19789, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
      AppMethodBeat.o(200038);
      return;
    }
    catch (Throwable paramString1)
    {
      ac.e("SnsAdTecReportUtil", "adTecReport exp=" + paramString1.toString());
      AppMethodBeat.o(200038);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.i
 * JD-Core Version:    0.7.0.1
 */