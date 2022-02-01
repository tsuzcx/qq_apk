package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;

public final class e
{
  public static String aJX(String paramString)
  {
    AppMethodBeat.i(141283);
    paramString = paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(141283);
    return paramString;
  }
  
  public static final class b
  {
    public static final String FHP = e.m.FIp;
    public static final String FHQ = e.m.FIq;
  }
  
  public static abstract interface d {}
  
  public static final class e
  {
    public static final String FHW;
    
    static
    {
      AppMethodBeat.i(141282);
      FHW = b.aih() + "switchAccountBg";
      AppMethodBeat.o(141282);
    }
  }
  
  public static final class h {}
  
  public static final class m
  {
    public static String FIA = "k_scan_from_biz_username";
    public static String FIB = "ad_ux_info_for_jsapi_pay";
    public static String FIC = "no_support_dark_mode";
    public static String FIj = "k_tmpl_params";
    public static String FIk = "k_tmpl_next_webview";
    public static String FIl = "k_tmpl_start_load_page";
    public static String FIm = "k_tmpl_page_info";
    public static String FIn = "k_tmpl_data_key";
    public static String FIo = "k_tmpl_session_id";
    public static String FIp = "k_tmpl_scene";
    public static String FIq = "k_tmpl_sub_scene";
    public static String FIr = "k_tmpl_is_webview_prc_created";
    public static String FIs = "k_tmpl_orig_prc_pid";
    public static String FIt = "k_tmpl_item_show_type";
    public static String FIu = "k_tmpl_open_type";
    public static String FIv = "k_tmpl_session";
    public static String FIw = "k_tmpl_force_url";
    public static String FIx = "k_tmpl_content_id";
    public static String FIy = "k_serach_log_id";
    public static String FIz = "k_serach_log_args";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.e
 * JD-Core Version:    0.7.0.1
 */