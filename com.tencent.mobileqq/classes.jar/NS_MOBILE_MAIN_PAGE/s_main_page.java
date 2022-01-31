package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_main_page
  extends JceStruct
{
  static Map cache_prompt_msg;
  static s_question cache_question = new s_question();
  public String addblack_msg = "";
  public long follow_flag;
  public String info_askfor_friend = "";
  public int is_askfor_friend;
  public int is_black;
  public int is_both_friend;
  public boolean is_concerned = true;
  public int is_friend;
  public int is_host_gray_follow_usr;
  public int is_host_gray_tongcheng_usr;
  public int is_in_visitor_notify_list;
  public int is_open_follow;
  public boolean is_readspace_followed = true;
  public int is_realname;
  public int is_recipient_yellow_banner;
  public int is_reverse_black;
  public int is_special;
  public boolean is_special_concerned;
  public int is_uncare;
  public int is_visitor_gray_follow_usr;
  public int is_visitor_gray_tongcheng_usr;
  public String msg = "";
  public Map prompt_msg;
  public s_question question;
  public int relation;
  public int visit_right;
  
  static
  {
    cache_prompt_msg = new HashMap();
    cache_prompt_msg.put(Integer.valueOf(0), "");
  }
  
  public s_main_page() {}
  
  public s_main_page(int paramInt1, int paramInt2, String paramString1, int paramInt3, s_question params_question, String paramString2, boolean paramBoolean1, int paramInt4, int paramInt5, int paramInt6, String paramString3, Map paramMap, boolean paramBoolean2, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, boolean paramBoolean3, long paramLong)
  {
    this.relation = paramInt1;
    this.is_askfor_friend = paramInt2;
    this.info_askfor_friend = paramString1;
    this.is_special = paramInt3;
    this.question = params_question;
    this.msg = paramString2;
    this.is_concerned = paramBoolean1;
    this.is_black = paramInt4;
    this.is_uncare = paramInt5;
    this.is_realname = paramInt6;
    this.addblack_msg = paramString3;
    this.prompt_msg = paramMap;
    this.is_readspace_followed = paramBoolean2;
    this.is_both_friend = paramInt7;
    this.is_reverse_black = paramInt8;
    this.visit_right = paramInt9;
    this.is_recipient_yellow_banner = paramInt10;
    this.is_in_visitor_notify_list = paramInt11;
    this.is_friend = paramInt12;
    this.is_open_follow = paramInt13;
    this.is_visitor_gray_follow_usr = paramInt14;
    this.is_host_gray_follow_usr = paramInt15;
    this.is_visitor_gray_tongcheng_usr = paramInt16;
    this.is_host_gray_tongcheng_usr = paramInt17;
    this.is_special_concerned = paramBoolean3;
    this.follow_flag = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.relation = paramJceInputStream.read(this.relation, 0, false);
    this.is_askfor_friend = paramJceInputStream.read(this.is_askfor_friend, 1, false);
    this.info_askfor_friend = paramJceInputStream.readString(2, false);
    this.is_special = paramJceInputStream.read(this.is_special, 3, false);
    this.question = ((s_question)paramJceInputStream.read(cache_question, 4, false));
    this.msg = paramJceInputStream.readString(5, false);
    this.is_concerned = paramJceInputStream.read(this.is_concerned, 6, false);
    this.is_black = paramJceInputStream.read(this.is_black, 7, false);
    this.is_uncare = paramJceInputStream.read(this.is_uncare, 8, false);
    this.is_realname = paramJceInputStream.read(this.is_realname, 9, false);
    this.addblack_msg = paramJceInputStream.readString(10, false);
    this.prompt_msg = ((Map)paramJceInputStream.read(cache_prompt_msg, 11, false));
    this.is_readspace_followed = paramJceInputStream.read(this.is_readspace_followed, 12, false);
    this.is_both_friend = paramJceInputStream.read(this.is_both_friend, 13, false);
    this.is_reverse_black = paramJceInputStream.read(this.is_reverse_black, 14, false);
    this.visit_right = paramJceInputStream.read(this.visit_right, 15, false);
    this.is_recipient_yellow_banner = paramJceInputStream.read(this.is_recipient_yellow_banner, 16, false);
    this.is_in_visitor_notify_list = paramJceInputStream.read(this.is_in_visitor_notify_list, 17, false);
    this.is_friend = paramJceInputStream.read(this.is_friend, 18, false);
    this.is_open_follow = paramJceInputStream.read(this.is_open_follow, 19, false);
    this.is_visitor_gray_follow_usr = paramJceInputStream.read(this.is_visitor_gray_follow_usr, 20, false);
    this.is_host_gray_follow_usr = paramJceInputStream.read(this.is_host_gray_follow_usr, 21, false);
    this.is_visitor_gray_tongcheng_usr = paramJceInputStream.read(this.is_visitor_gray_tongcheng_usr, 22, false);
    this.is_host_gray_tongcheng_usr = paramJceInputStream.read(this.is_host_gray_tongcheng_usr, 23, false);
    this.is_special_concerned = paramJceInputStream.read(this.is_special_concerned, 24, false);
    this.follow_flag = paramJceInputStream.read(this.follow_flag, 25, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.relation, 0);
    paramJceOutputStream.write(this.is_askfor_friend, 1);
    if (this.info_askfor_friend != null) {
      paramJceOutputStream.write(this.info_askfor_friend, 2);
    }
    paramJceOutputStream.write(this.is_special, 3);
    if (this.question != null) {
      paramJceOutputStream.write(this.question, 4);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 5);
    }
    paramJceOutputStream.write(this.is_concerned, 6);
    paramJceOutputStream.write(this.is_black, 7);
    paramJceOutputStream.write(this.is_uncare, 8);
    paramJceOutputStream.write(this.is_realname, 9);
    if (this.addblack_msg != null) {
      paramJceOutputStream.write(this.addblack_msg, 10);
    }
    if (this.prompt_msg != null) {
      paramJceOutputStream.write(this.prompt_msg, 11);
    }
    paramJceOutputStream.write(this.is_readspace_followed, 12);
    paramJceOutputStream.write(this.is_both_friend, 13);
    paramJceOutputStream.write(this.is_reverse_black, 14);
    paramJceOutputStream.write(this.visit_right, 15);
    paramJceOutputStream.write(this.is_recipient_yellow_banner, 16);
    paramJceOutputStream.write(this.is_in_visitor_notify_list, 17);
    paramJceOutputStream.write(this.is_friend, 18);
    paramJceOutputStream.write(this.is_open_follow, 19);
    paramJceOutputStream.write(this.is_visitor_gray_follow_usr, 20);
    paramJceOutputStream.write(this.is_host_gray_follow_usr, 21);
    paramJceOutputStream.write(this.is_visitor_gray_tongcheng_usr, 22);
    paramJceOutputStream.write(this.is_host_gray_tongcheng_usr, 23);
    paramJceOutputStream.write(this.is_special_concerned, 24);
    paramJceOutputStream.write(this.follow_flag, 25);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_main_page
 * JD-Core Version:    0.7.0.1
 */