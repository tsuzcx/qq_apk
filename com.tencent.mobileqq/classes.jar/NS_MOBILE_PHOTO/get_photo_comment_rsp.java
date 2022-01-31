package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cell_like;
import NS_MOBILE_FEEDS.cell_visitor;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_photo_comment_rsp
  extends JceStruct
{
  static cell_comment cache_comment = new cell_comment();
  static Map cache_extend_info;
  static cell_like cache_like = new cell_like();
  static cell_visitor cache_visitor = new cell_visitor();
  public String albumid = "";
  public String attach_info = "";
  public cell_comment comment;
  public Map extend_info;
  public boolean hasmore = true;
  public cell_like like;
  public String photoid = "";
  public String topicid = "";
  public long uin;
  public cell_visitor visitor;
  
  static
  {
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
  }
  
  public get_photo_comment_rsp() {}
  
  public get_photo_comment_rsp(boolean paramBoolean, String paramString1, cell_comment paramcell_comment, cell_like paramcell_like, cell_visitor paramcell_visitor, long paramLong, String paramString2, String paramString3, String paramString4, Map paramMap)
  {
    this.hasmore = paramBoolean;
    this.attach_info = paramString1;
    this.comment = paramcell_comment;
    this.like = paramcell_like;
    this.visitor = paramcell_visitor;
    this.uin = paramLong;
    this.albumid = paramString2;
    this.photoid = paramString3;
    this.topicid = paramString4;
    this.extend_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, true);
    this.attach_info = paramJceInputStream.readString(1, true);
    this.comment = ((cell_comment)paramJceInputStream.read(cache_comment, 2, true));
    this.like = ((cell_like)paramJceInputStream.read(cache_like, 3, false));
    this.visitor = ((cell_visitor)paramJceInputStream.read(cache_visitor, 4, false));
    this.uin = paramJceInputStream.read(this.uin, 5, false);
    this.albumid = paramJceInputStream.readString(6, false);
    this.photoid = paramJceInputStream.readString(7, false);
    this.topicid = paramJceInputStream.readString(8, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    paramJceOutputStream.write(this.attach_info, 1);
    paramJceOutputStream.write(this.comment, 2);
    if (this.like != null) {
      paramJceOutputStream.write(this.like, 3);
    }
    if (this.visitor != null) {
      paramJceOutputStream.write(this.visitor, 4);
    }
    paramJceOutputStream.write(this.uin, 5);
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 6);
    }
    if (this.photoid != null) {
      paramJceOutputStream.write(this.photoid, 7);
    }
    if (this.topicid != null) {
      paramJceOutputStream.write(this.topicid, 8);
    }
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_photo_comment_rsp
 * JD-Core Version:    0.7.0.1
 */