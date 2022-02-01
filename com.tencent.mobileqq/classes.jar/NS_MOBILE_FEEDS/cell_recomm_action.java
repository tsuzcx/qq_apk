package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_recomm_action
  extends JceStruct
{
  static Map<Integer, String> cache_extend_info;
  static s_button cache_left_bottom_button = new s_button();
  static ArrayList<s_user> cache_relation_chain;
  static s_rank cache_s_app_rank = new s_rank();
  static ArrayList<s_user> cache_userlist = new ArrayList();
  public int actiontype = 0;
  public String add_group_url = "";
  public int adv_pos = 0;
  public int allcount = 0;
  public String alternate_ad_identification = "";
  public int btn_type = 0;
  public int button_actiontype = 0;
  public int button_style = 0;
  public String button_text = "";
  public String button_url = "";
  public String channel = "";
  public int count_down_timer;
  public String currency_pass_field = "";
  public int dest_type = 0;
  public String dest_url = "";
  public int detail_actiontype = 0;
  public String detail_text = "";
  public String detail_url = "";
  public Map<Integer, String> extend_info = null;
  public String installed_buttontxt = "";
  public String interact_left_text = "";
  public int is_hide_action_area = 0;
  public int is_report = 0;
  public s_button left_bottom_button = null;
  public int multi_adv_offset = 0;
  public int product_type = 0;
  public long productid = 0L;
  public ArrayList<s_user> relation_chain = null;
  public int relation_total_number = 0;
  public String remark = "";
  public String report_url = "";
  public String rl = "";
  public s_rank s_app_rank = null;
  public int style = 0;
  public int templ_layout = 0;
  public String tips_icon = "";
  public ArrayList<s_user> userlist = null;
  public String via = "";
  
  static
  {
    s_user locals_user = new s_user();
    cache_userlist.add(locals_user);
    cache_relation_chain = new ArrayList();
    locals_user = new s_user();
    cache_relation_chain.add(locals_user);
    cache_extend_info = new HashMap();
    cache_extend_info.put(Integer.valueOf(0), "");
  }
  
  public cell_recomm_action() {}
  
  public cell_recomm_action(s_rank params_rank, String paramString1, ArrayList<s_user> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, String paramString4, int paramInt7, String paramString5, int paramInt8, String paramString6, String paramString7, int paramInt9, int paramInt10, String paramString8, String paramString9, String paramString10, ArrayList<s_user> paramArrayList2, int paramInt11, int paramInt12, Map<Integer, String> paramMap, s_button params_button, String paramString11, String paramString12, String paramString13, long paramLong, int paramInt13, int paramInt14, int paramInt15, String paramString14, String paramString15, int paramInt16, String paramString16)
  {
    this.s_app_rank = params_rank;
    this.remark = paramString1;
    this.userlist = paramArrayList1;
    this.actiontype = paramInt1;
    this.btn_type = paramInt2;
    this.is_hide_action_area = paramInt3;
    this.is_report = paramInt4;
    this.report_url = paramString2;
    this.allcount = paramInt5;
    this.button_text = paramString3;
    this.button_actiontype = paramInt6;
    this.button_url = paramString4;
    this.button_style = paramInt7;
    this.detail_text = paramString5;
    this.detail_actiontype = paramInt8;
    this.detail_url = paramString6;
    this.tips_icon = paramString7;
    this.adv_pos = paramInt9;
    this.multi_adv_offset = paramInt10;
    this.interact_left_text = paramString8;
    this.installed_buttontxt = paramString9;
    this.alternate_ad_identification = paramString10;
    this.relation_chain = paramArrayList2;
    this.relation_total_number = paramInt11;
    this.count_down_timer = paramInt12;
    this.extend_info = paramMap;
    this.left_bottom_button = params_button;
    this.currency_pass_field = paramString11;
    this.via = paramString12;
    this.channel = paramString13;
    this.productid = paramLong;
    this.templ_layout = paramInt13;
    this.dest_type = paramInt14;
    this.product_type = paramInt15;
    this.dest_url = paramString14;
    this.rl = paramString15;
    this.style = paramInt16;
    this.add_group_url = paramString16;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.s_app_rank = ((s_rank)paramJceInputStream.read(cache_s_app_rank, 0, false));
    this.remark = paramJceInputStream.readString(1, false);
    this.userlist = ((ArrayList)paramJceInputStream.read(cache_userlist, 2, false));
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.btn_type = paramJceInputStream.read(this.btn_type, 4, false);
    this.is_hide_action_area = paramJceInputStream.read(this.is_hide_action_area, 5, false);
    this.is_report = paramJceInputStream.read(this.is_report, 6, false);
    this.report_url = paramJceInputStream.readString(7, false);
    this.allcount = paramJceInputStream.read(this.allcount, 8, false);
    this.button_text = paramJceInputStream.readString(9, false);
    this.button_actiontype = paramJceInputStream.read(this.button_actiontype, 10, false);
    this.button_url = paramJceInputStream.readString(11, false);
    this.button_style = paramJceInputStream.read(this.button_style, 12, false);
    this.detail_text = paramJceInputStream.readString(13, false);
    this.detail_actiontype = paramJceInputStream.read(this.detail_actiontype, 14, false);
    this.detail_url = paramJceInputStream.readString(15, false);
    this.tips_icon = paramJceInputStream.readString(17, false);
    this.adv_pos = paramJceInputStream.read(this.adv_pos, 18, false);
    this.multi_adv_offset = paramJceInputStream.read(this.multi_adv_offset, 19, false);
    this.interact_left_text = paramJceInputStream.readString(20, false);
    this.installed_buttontxt = paramJceInputStream.readString(21, false);
    this.alternate_ad_identification = paramJceInputStream.readString(22, false);
    this.relation_chain = ((ArrayList)paramJceInputStream.read(cache_relation_chain, 23, false));
    this.relation_total_number = paramJceInputStream.read(this.relation_total_number, 24, false);
    this.count_down_timer = paramJceInputStream.read(this.count_down_timer, 25, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 26, false));
    this.left_bottom_button = ((s_button)paramJceInputStream.read(cache_left_bottom_button, 28, false));
    this.currency_pass_field = paramJceInputStream.readString(29, false);
    this.via = paramJceInputStream.readString(30, false);
    this.channel = paramJceInputStream.readString(31, false);
    this.productid = paramJceInputStream.read(this.productid, 32, false);
    this.templ_layout = paramJceInputStream.read(this.templ_layout, 33, false);
    this.dest_type = paramJceInputStream.read(this.dest_type, 34, false);
    this.product_type = paramJceInputStream.read(this.product_type, 35, false);
    this.dest_url = paramJceInputStream.read(this.dest_url, 36, false);
    this.rl = paramJceInputStream.read(this.rl, 37, false);
    this.style = paramJceInputStream.read(this.style, 38, false);
    this.add_group_url = paramJceInputStream.read(this.add_group_url, 39, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.s_app_rank != null) {
      paramJceOutputStream.write(this.s_app_rank, 0);
    }
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 1);
    }
    if (this.userlist != null) {
      paramJceOutputStream.write(this.userlist, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    paramJceOutputStream.write(this.btn_type, 4);
    paramJceOutputStream.write(this.is_hide_action_area, 5);
    paramJceOutputStream.write(this.is_report, 6);
    if (this.report_url != null) {
      paramJceOutputStream.write(this.report_url, 7);
    }
    paramJceOutputStream.write(this.allcount, 8);
    if (this.button_text != null) {
      paramJceOutputStream.write(this.button_text, 9);
    }
    paramJceOutputStream.write(this.button_actiontype, 10);
    if (this.button_url != null) {
      paramJceOutputStream.write(this.button_url, 11);
    }
    paramJceOutputStream.write(this.button_style, 12);
    if (this.detail_text != null) {
      paramJceOutputStream.write(this.detail_text, 13);
    }
    paramJceOutputStream.write(this.detail_actiontype, 14);
    if (this.detail_url != null) {
      paramJceOutputStream.write(this.detail_url, 15);
    }
    if (this.tips_icon != null) {
      paramJceOutputStream.write(this.tips_icon, 17);
    }
    paramJceOutputStream.write(this.adv_pos, 18);
    paramJceOutputStream.write(this.multi_adv_offset, 19);
    if (this.interact_left_text != null) {
      paramJceOutputStream.write(this.interact_left_text, 20);
    }
    if (this.installed_buttontxt != null) {
      paramJceOutputStream.write(this.installed_buttontxt, 21);
    }
    if (this.alternate_ad_identification != null) {
      paramJceOutputStream.write(this.alternate_ad_identification, 22);
    }
    if (this.relation_chain != null) {
      paramJceOutputStream.write(this.relation_chain, 23);
    }
    paramJceOutputStream.write(this.relation_total_number, 24);
    paramJceOutputStream.write(this.count_down_timer, 25);
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 26);
    }
    if (this.left_bottom_button != null) {
      paramJceOutputStream.write(this.left_bottom_button, 28);
    }
    if (this.currency_pass_field != null) {
      paramJceOutputStream.write(this.currency_pass_field, 29);
    }
    if (this.via != null) {
      paramJceOutputStream.write(this.via, 30);
    }
    if (this.channel != null) {
      paramJceOutputStream.write(this.channel, 31);
    }
    paramJceOutputStream.write(this.productid, 32);
    paramJceOutputStream.write(this.templ_layout, 33);
    paramJceOutputStream.write(this.dest_type, 34);
    paramJceOutputStream.write(this.product_type, 35);
    if (this.dest_url != null) {
      paramJceOutputStream.write(this.dest_url, 36);
    }
    if (this.rl != null) {
      paramJceOutputStream.write(this.rl, 37);
    }
    paramJceOutputStream.write(this.style, 38);
    if (this.add_group_url != null) {
      paramJceOutputStream.write(this.add_group_url, 39);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_recomm_action
 * JD-Core Version:    0.7.0.1
 */