package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class e
{
  public static String atl(String paramString)
  {
    AppMethodBeat.i(105954);
    paramString = paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(105954);
    return paramString;
  }
  
  public static final class a
  {
    public static int NY(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        return 1;
      case 1: 
        return 2;
      }
      return 3;
    }
  }
  
  public static final class b
  {
    public static String yUZ = "AntispamTicket";
  }
  
  public static final class c
  {
    public static final String yVa;
    
    static
    {
      AppMethodBeat.i(105952);
      yVa = com.tencent.mm.compatible.util.e.eQz + "switchAccountBg";
      AppMethodBeat.o(105952);
    }
  }
  
  public static abstract interface d
  {
    public static final String yVb = "FREE_WIFI_IS_DEFAULT_FOCUS".toLowerCase();
  }
  
  public static final class e
  {
    public static String yVc = "key_envelope_source";
    public static String yVd = "key_source_resp";
  }
  
  public static final class f {}
  
  public static final class g
  {
    public static int yVe = 0;
    public static int yVf = 1;
    public static int yVg = 2;
  }
  
  public static final class h
  {
    public static final String etD = null;
  }
  
  public static final class i
  {
    public static String yVh = "trust_friend_show_tips";
  }
  
  public static final class j
  {
    public static final String yVi;
    
    static
    {
      AppMethodBeat.i(105953);
      yVi = "Kdescription" + System.currentTimeMillis();
      AppMethodBeat.o(105953);
    }
  }
  
  public static abstract interface k
  {
    public static final String hoC = ah.getPackageName() + ":tools";
    public static final String iXz = ;
  }
  
  public static final class l
  {
    public static String yVj = "k_tmpl_params";
    public static String yVk = "k_tmpl_next_webview";
    public static String yVl = "k_tmpl_start_load_page";
    public static String yVm = "k_tmpl_page_info";
    public static String yVn = "k_tmpl_data_key";
    public static String yVo = "k_tmpl_session_id";
    public static String yVp = "k_tmpl_scene";
    public static String yVq = "k_tmpl_sub_scene";
    public static String yVr = "k_tmpl_is_webview_prc_created";
    public static String yVs = "k_tmpl_orig_prc_pid";
    public static String yVt = "k_tmpl_item_show_type";
    public static String yVu = "k_tmpl_open_type";
    public static String yVv = "k_tmpl_session";
    public static String yVw = "k_tmpl_force_url";
    public static String yVx = "k_serach_log_id";
    public static String yVy = "k_serach_log_args";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.e
 * JD-Core Version:    0.7.0.1
 */