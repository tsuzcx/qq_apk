package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public class GetShareAlbumMemberRsp
  extends JceStruct
{
  static Album cache_album = new Album();
  static ArrayList<ShareAlbumMemberData> cache_member_datas = new ArrayList();
  public Album album;
  public ArrayList<ShareAlbumMemberData> member_datas;
  public String msg = "";
  public int ret = 0;
  
  static
  {
    ShareAlbumMemberData localShareAlbumMemberData = new ShareAlbumMemberData();
    cache_member_datas.add(localShareAlbumMemberData);
  }
  
  public GetShareAlbumMemberRsp() {}
  
  public GetShareAlbumMemberRsp(int paramInt, String paramString, Album paramAlbum, ArrayList<ShareAlbumMemberData> paramArrayList)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.album = paramAlbum;
    this.member_datas = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.album = ((Album)paramJceInputStream.read(cache_album, 2, false));
    this.member_datas = ((ArrayList)paramJceInputStream.read(cache_member_datas, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.album;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.member_datas;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetShareAlbumMemberRsp
 * JD-Core Version:    0.7.0.1
 */