package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;

public final class e
{
  public static String aix(String paramString)
  {
    AppMethodBeat.i(141283);
    paramString = paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(141283);
    return paramString;
  }
  
  public static final class b
  {
    public static final String IUn = e.m.IUN;
    public static final String IUo = e.m.IUO;
  }
  
  public static abstract interface d {}
  
  public static final class e
  {
    public static final String IUu;
    
    static
    {
      AppMethodBeat.i(141282);
      IUu = b.arU() + "switchAccountBg";
      AppMethodBeat.o(141282);
    }
  }
  
  public static final class h {}
  
  public static final class k
  {
    public static String IUF = "trust_friend_show_tips";
  }
  
  public static final class m
  {
    public static String IUH = "k_tmpl_params";
    public static String IUI = "k_tmpl_next_webview";
    public static String IUJ = "k_tmpl_start_load_page";
    public static String IUK = "k_tmpl_page_info";
    public static String IUL = "k_tmpl_data_key";
    public static String IUM = "k_tmpl_session_id";
    public static String IUN = "k_tmpl_scene";
    public static String IUO = "k_tmpl_sub_scene";
    public static String IUP = "k_tmpl_is_webview_prc_created";
    public static String IUQ = "k_tmpl_orig_prc_pid";
    public static String IUR = "k_tmpl_item_show_type";
    public static String IUS = "k_tmpl_open_type";
    public static String IUT = "k_tmpl_session";
    public static String IUU = "k_tmpl_force_url";
    public static String IUV = "k_tmpl_content_id";
    public static String IUW = "k_serach_log_id";
    public static String IUX = "k_serach_log_args";
    public static String IUY = "k_scan_from_biz_username";
    public static String IUZ = "ad_ux_info_for_jsapi_pay";
    public static String IVa = "no_support_dark_mode";
    public static String IVb = "key_allow_jump_inner_jump_without_perm";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.e
 * JD-Core Version:    0.7.0.1
 */