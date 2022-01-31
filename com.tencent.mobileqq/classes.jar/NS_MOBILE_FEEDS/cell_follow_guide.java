package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_follow_guide
  extends JceStruct
{
  static ArrayList<s_user> cache_followed_list = new ArrayList();
  public int action_type;
  public String action_url = "";
  public String attach_info = "";
  public String button_text = "";
  public long count;
  public int feed_type;
  public ArrayList<s_user> followed_list;
  public String icon_url = "";
  public String summary = "";
  public String title = "";
  
  static
  {
    s_user locals_user = new s_user();
    cache_followed_list.add(locals_user);
  }
  
  public cell_follow_guide() {}
  
  public cell_follow_guide(ArrayList<s_user> paramArrayList, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5, String paramString6)
  {
    this.followed_list = paramArrayList;
    this.count = paramLong;
    this.title = paramString1;
    this.summary = paramString2;
    this.icon_url = paramString3;
    this.action_type = paramInt1;
    this.action_url = paramString4;
    this.feed_type = paramInt2;
    this.button_text = paramString5;
    this.attach_info = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.followed_list = ((ArrayList)paramJceInputStream.read(cache_followed_list, 0, false));
    this.count = paramJceInputStream.read(this.count, 1, false);
    this.title = paramJceInputStream.readString(2, false);
    this.summary = paramJceInputStream.readString(3, false);
    this.icon_url = paramJceInputStream.readString(4, false);
    this.action_type = paramJceInputStream.read(this.action_type, 5, false);
    this.action_url = paramJceInputStream.readString(6, false);
    this.feed_type = paramJceInputStream.read(this.feed_type, 7, false);
    this.button_text = paramJceInputStream.readString(8, false);
    this.attach_info = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.followed_list != null) {
      paramJceOutputStream.write(this.followed_list, 0);
    }
    paramJceOutputStream.write(this.count, 1);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 2);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 3);
    }
    if (this.icon_url != null) {
      paramJceOutputStream.write(this.icon_url, 4);
    }
    paramJceOutputStream.write(this.action_type, 5);
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 6);
    }
    paramJceOutputStream.write(this.feed_type, 7);
    if (this.button_text != null) {
      paramJceOutputStream.write(this.button_text, 8);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_follow_guide
 * JD-Core Version:    0.7.0.1
 */