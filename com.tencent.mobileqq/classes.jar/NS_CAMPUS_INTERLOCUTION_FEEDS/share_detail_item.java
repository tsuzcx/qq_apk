package NS_CAMPUS_INTERLOCUTION_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class share_detail_item
  extends JceStruct
{
  public int action_type = 0;
  public String action_url = "";
  public long answer_num = 0L;
  public String content = "";
  public String module_name = "";
  public String nick = "";
  public String optype = "";
  public String pic_url = "";
  public String portrait = "";
  public String school_name = "";
  public String share_content = "";
  public int type = 0;
  public long uin = 0L;
  public long user_type = 0L;
  public long visit_num = 0L;
  
  public share_detail_item() {}
  
  public share_detail_item(int paramInt1, String paramString1, int paramInt2, String paramString2, long paramLong1, String paramString3, String paramString4, String paramString5, long paramLong2, long paramLong3, String paramString6, long paramLong4, String paramString7, String paramString8, String paramString9)
  {
    this.action_type = paramInt1;
    this.action_url = paramString1;
    this.type = paramInt2;
    this.pic_url = paramString2;
    this.uin = paramLong1;
    this.nick = paramString3;
    this.optype = paramString4;
    this.content = paramString5;
    this.visit_num = paramLong2;
    this.answer_num = paramLong3;
    this.portrait = paramString6;
    this.user_type = paramLong4;
    this.school_name = paramString7;
    this.module_name = paramString8;
    this.share_content = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.action_type = paramJceInputStream.read(this.action_type, 0, true);
    this.action_url = paramJceInputStream.readString(1, true);
    this.type = paramJceInputStream.read(this.type, 2, true);
    this.pic_url = paramJceInputStream.readString(3, true);
    this.uin = paramJceInputStream.read(this.uin, 10, false);
    this.nick = paramJceInputStream.readString(11, false);
    this.optype = paramJceInputStream.readString(12, false);
    this.content = paramJceInputStream.readString(13, false);
    this.visit_num = paramJceInputStream.read(this.visit_num, 14, false);
    this.answer_num = paramJceInputStream.read(this.answer_num, 15, false);
    this.portrait = paramJceInputStream.readString(16, false);
    this.user_type = paramJceInputStream.read(this.user_type, 17, false);
    this.school_name = paramJceInputStream.readString(20, false);
    this.module_name = paramJceInputStream.readString(21, false);
    this.share_content = paramJceInputStream.readString(30, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.action_type, 0);
    paramJceOutputStream.write(this.action_url, 1);
    paramJceOutputStream.write(this.type, 2);
    paramJceOutputStream.write(this.pic_url, 3);
    paramJceOutputStream.write(this.uin, 10);
    String str = this.nick;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.optype;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.content;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    paramJceOutputStream.write(this.visit_num, 14);
    paramJceOutputStream.write(this.answer_num, 15);
    str = this.portrait;
    if (str != null) {
      paramJceOutputStream.write(str, 16);
    }
    paramJceOutputStream.write(this.user_type, 17);
    str = this.school_name;
    if (str != null) {
      paramJceOutputStream.write(str, 20);
    }
    str = this.module_name;
    if (str != null) {
      paramJceOutputStream.write(str, 21);
    }
    str = this.share_content;
    if (str != null) {
      paramJceOutputStream.write(str, 30);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CAMPUS_INTERLOCUTION_FEEDS.share_detail_item
 * JD-Core Version:    0.7.0.1
 */