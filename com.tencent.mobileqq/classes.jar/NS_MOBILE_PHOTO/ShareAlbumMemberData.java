package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public class ShareAlbumMemberData
  extends JceStruct
{
  static comm_page_info cache_page_info = new comm_page_info();
  static ArrayList<s_picdata> cache_photos = new ArrayList();
  public String nick = "";
  public comm_page_info page;
  public long photo_cnt;
  public ArrayList<s_picdata> photos;
  public long uin;
  public long video_cnt;
  
  static
  {
    s_picdata locals_picdata = new s_picdata();
    cache_photos.add(locals_picdata);
  }
  
  public ShareAlbumMemberData() {}
  
  public ShareAlbumMemberData(long paramLong1, String paramString, long paramLong2, long paramLong3, comm_page_info paramcomm_page_info, ArrayList<s_picdata> paramArrayList)
  {
    this.uin = paramLong1;
    this.nick = paramString;
    this.photo_cnt = paramLong2;
    this.video_cnt = paramLong3;
    this.page = paramcomm_page_info;
    this.photos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nick = paramJceInputStream.readString(1, false);
    this.photo_cnt = paramJceInputStream.read(this.photo_cnt, 2, false);
    this.video_cnt = paramJceInputStream.read(this.video_cnt, 3, false);
    this.page = ((comm_page_info)paramJceInputStream.read(cache_page_info, 4, false));
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 1);
    }
    paramJceOutputStream.write(this.photo_cnt, 2);
    paramJceOutputStream.write(this.video_cnt, 3);
    if (this.page != null) {
      paramJceOutputStream.write(this.page, 4);
    }
    if (this.photos != null) {
      paramJceOutputStream.write(this.photos, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.ShareAlbumMemberData
 * JD-Core Version:    0.7.0.1
 */