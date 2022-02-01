package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;

public final class e
{
  public static String aPv(String paramString)
  {
    AppMethodBeat.i(141283);
    paramString = paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(141283);
    return paramString;
  }
  
  public static final class b
  {
    public static final String HgX = e.m.Hhx;
    public static final String HgY = e.m.Hhy;
  }
  
  public static abstract interface d {}
  
  public static final class e
  {
    public static final String Hhe;
    
    static
    {
      AppMethodBeat.i(141282);
      Hhe = b.aph() + "switchAccountBg";
      AppMethodBeat.o(141282);
    }
  }
  
  public static final class h {}
  
  public static final class m
  {
    public static String HhA = "k_tmpl_orig_prc_pid";
    public static String HhB = "k_tmpl_item_show_type";
    public static String HhC = "k_tmpl_open_type";
    public static String HhD = "k_tmpl_session";
    public static String HhE = "k_tmpl_force_url";
    public static String HhF = "k_tmpl_content_id";
    public static String HhG = "k_serach_log_id";
    public static String HhH = "k_serach_log_args";
    public static String HhI = "k_scan_from_biz_username";
    public static String HhJ = "ad_ux_info_for_jsapi_pay";
    public static String HhK = "no_support_dark_mode";
    public static String Hhr = "k_tmpl_params";
    public static String Hhs = "k_tmpl_next_webview";
    public static String Hht = "k_tmpl_start_load_page";
    public static String Hhu = "k_tmpl_page_info";
    public static String Hhv = "k_tmpl_data_key";
    public static String Hhw = "k_tmpl_session_id";
    public static String Hhx = "k_tmpl_scene";
    public static String Hhy = "k_tmpl_sub_scene";
    public static String Hhz = "k_tmpl_is_webview_prc_created";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.e
 * JD-Core Version:    0.7.0.1
 */