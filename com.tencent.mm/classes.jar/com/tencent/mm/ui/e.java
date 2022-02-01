package com.tencent.mm.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class e
{
  public static final String OyP;
  
  static
  {
    AppMethodBeat.i(205107);
    OyP = "https://" + WeChatHosts.domainString(2131761749);
    AppMethodBeat.o(205107);
  }
  
  public static String avA(String paramString)
  {
    AppMethodBeat.i(141283);
    paramString = paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(141283);
    return paramString;
  }
  
  public static final class b
  {
    public static final String OyQ = e.p.Ozw;
    public static final String OyR = e.p.Ozx;
  }
  
  public static final class c
  {
    public static final class a
    {
      public static final String OyS;
      
      static
      {
        AppMethodBeat.i(205100);
        OyS = "https://" + MMApplicationContext.getContext().getString(2131761742) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=weishihb20/index";
        AppMethodBeat.o(205100);
      }
    }
  }
  
  public static final class d
  {
    public static String OyT = "AntispamTicket";
  }
  
  public static final class e
  {
    public static final String OyU;
    public static final String OyV;
    public static final String OyW;
    
    static
    {
      AppMethodBeat.i(205101);
      OyU = "https://" + WeChatHosts.domainString(2131761748) + "/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect";
      OyV = "https://" + WeChatHosts.domainString(2131761726) + "/mp/infringement?url=%s#wechat_redirect";
      OyW = "https://" + WeChatHosts.domainString(2131761748) + "/security/readtemplate?t=weixin_report/w_type&scene=60";
      AppMethodBeat.o(205101);
    }
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public static final String Ozb;
    
    static
    {
      AppMethodBeat.i(141282);
      Ozb = b.aKJ() + "switchAccountBg";
      AppMethodBeat.o(141282);
    }
  }
  
  public static final class j {}
  
  public static final class m
  {
    public static String Ozm = "trust_friend_show_tips";
  }
  
  public static abstract interface n
  {
    public static final String Ozn = ;
    public static final String lnh = MMApplicationContext.getPackageName() + ":tools";
  }
  
  public static final class o
  {
    public static final String Ozo;
    
    static
    {
      AppMethodBeat.i(205105);
      Ozo = "https://" + MMApplicationContext.getContext().getString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
      AppMethodBeat.o(205105);
    }
  }
  
  public static final class p
  {
    public static String OzA;
    public static String OzB;
    public static String OzC;
    public static String OzD;
    public static String OzE;
    public static String OzF;
    public static String OzG;
    public static String OzH;
    public static String OzI;
    public static String OzJ;
    public static String OzK;
    public static final String Ozp;
    public static String Ozq;
    public static String Ozr;
    public static String Ozs;
    public static String Ozt;
    public static String Ozu;
    public static String Ozv;
    public static String Ozw;
    public static String Ozx;
    public static String Ozy;
    public static String Ozz;
    
    static
    {
      AppMethodBeat.i(205106);
      Ozp = "https://" + MMApplicationContext.getContext().getString(2131761742) + "/update/";
      Ozq = "k_tmpl_params";
      Ozr = "k_tmpl_next_webview";
      Ozs = "k_tmpl_start_load_page";
      Ozt = "k_tmpl_page_info";
      Ozu = "k_tmpl_data_key";
      Ozv = "k_tmpl_session_id";
      Ozw = "k_tmpl_scene";
      Ozx = "k_tmpl_sub_scene";
      Ozy = "k_tmpl_is_webview_prc_created";
      Ozz = "k_tmpl_orig_prc_pid";
      OzA = "k_tmpl_item_show_type";
      OzB = "k_tmpl_open_type";
      OzC = "k_tmpl_session";
      OzD = "k_tmpl_force_url";
      OzE = "k_tmpl_content_id";
      OzF = "k_serach_log_id";
      OzG = "k_serach_log_args";
      OzH = "k_scan_from_biz_username";
      OzI = "ad_ux_info_for_jsapi_pay";
      OzJ = "no_support_dark_mode";
      OzK = "key_allow_jump_inner_jump_without_perm";
      AppMethodBeat.o(205106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.e
 * JD-Core Version:    0.7.0.1
 */