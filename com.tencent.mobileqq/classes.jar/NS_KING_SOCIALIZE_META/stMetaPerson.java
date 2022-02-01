package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaPerson
  extends JceStruct
{
  public String address = "";
  public int age = 0;
  public String avatar = "";
  public String chatlist_id = "";
  public int createtime = 0;
  public String feedlist_hot_id = "";
  public String feedlist_time_id = "";
  public String followerlist_id = "";
  public String id = "";
  public String interesterlist_id = "";
  public String nick = "";
  public String related_feedlist_id = "";
  public int rich_flag = 0;
  public int sex = 0;
  public int type = 0;
  public String uid = "";
  
  public stMetaPerson() {}
  
  public stMetaPerson(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt4, int paramInt5, String paramString11)
  {
    this.id = paramString1;
    this.type = paramInt1;
    this.uid = paramString2;
    this.createtime = paramInt2;
    this.nick = paramString3;
    this.avatar = paramString4;
    this.sex = paramInt3;
    this.feedlist_time_id = paramString5;
    this.feedlist_hot_id = paramString6;
    this.related_feedlist_id = paramString7;
    this.followerlist_id = paramString8;
    this.interesterlist_id = paramString9;
    this.chatlist_id = paramString10;
    this.rich_flag = paramInt4;
    this.age = paramInt5;
    this.address = paramString11;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.uid = paramJceInputStream.readString(2, false);
    this.createtime = paramJceInputStream.read(this.createtime, 3, false);
    this.nick = paramJceInputStream.readString(4, false);
    this.avatar = paramJceInputStream.readString(5, false);
    this.sex = paramJceInputStream.read(this.sex, 6, false);
    this.feedlist_time_id = paramJceInputStream.readString(7, false);
    this.feedlist_hot_id = paramJceInputStream.readString(8, false);
    this.related_feedlist_id = paramJceInputStream.readString(9, false);
    this.followerlist_id = paramJceInputStream.readString(10, false);
    this.interesterlist_id = paramJceInputStream.readString(11, false);
    this.chatlist_id = paramJceInputStream.readString(12, false);
    this.rich_flag = paramJceInputStream.read(this.rich_flag, 13, false);
    this.age = paramJceInputStream.read(this.age, 14, false);
    this.address = paramJceInputStream.readString(15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.type, 1);
    str = this.uid;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.createtime, 3);
    str = this.nick;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.avatar;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.sex, 6);
    str = this.feedlist_time_id;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.feedlist_hot_id;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.related_feedlist_id;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.followerlist_id;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.interesterlist_id;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.chatlist_id;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    paramJceOutputStream.write(this.rich_flag, 13);
    paramJceOutputStream.write(this.age, 14);
    str = this.address;
    if (str != null) {
      paramJceOutputStream.write(str, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaPerson
 * JD-Core Version:    0.7.0.1
 */