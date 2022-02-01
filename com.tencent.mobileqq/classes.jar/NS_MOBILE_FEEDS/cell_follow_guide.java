package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class cell_follow_guide
  extends JceStruct
{
  static ArrayList<s_user> cache_followed_list = new ArrayList();
  public int action_type = 0;
  public String action_url = "";
  public String attach_info = "";
  public String button_text = "";
  public long count = 0L;
  public int feed_type = 0;
  public ArrayList<s_user> followed_list = null;
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
    Object localObject = this.followed_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    paramJceOutputStream.write(this.count, 1);
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.icon_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.action_type, 5);
    localObject = this.action_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.feed_type, 7);
    localObject = this.button_text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_follow_guide
 * JD-Core Version:    0.7.0.1
 */