package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class feeds_context_info
  extends JceStruct
{
  static ArrayList<String> cache_video_tag_list = new ArrayList();
  public int index = 0;
  public String summary = "";
  public String ugckey = "";
  public String vid = "";
  public ArrayList<String> video_tag_list = null;
  
  static
  {
    cache_video_tag_list.add("");
  }
  
  public feeds_context_info() {}
  
  public feeds_context_info(int paramInt, String paramString1, String paramString2, ArrayList<String> paramArrayList, String paramString3)
  {
    this.index = paramInt;
    this.ugckey = paramString1;
    this.summary = paramString2;
    this.video_tag_list = paramArrayList;
    this.vid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.index = paramJceInputStream.read(this.index, 0, false);
    this.ugckey = paramJceInputStream.readString(1, false);
    this.summary = paramJceInputStream.readString(2, false);
    this.video_tag_list = ((ArrayList)paramJceInputStream.read(cache_video_tag_list, 3, false));
    this.vid = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.index, 0);
    Object localObject = this.ugckey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.video_tag_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.vid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.feeds_context_info
 * JD-Core Version:    0.7.0.1
 */