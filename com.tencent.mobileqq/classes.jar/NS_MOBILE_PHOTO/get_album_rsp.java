package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;
import photo_share_struct.PublicShareData;

public final class get_album_rsp
  extends JceStruct
{
  static Album cache_album = new Album();
  static PublicShareData cache_public_share_data = new PublicShareData();
  static Map<Long, wx_user_info> cache_sharer_wx_info;
  static int cache_sort_type = 0;
  public Album album = null;
  public int albumCommentNum = 0;
  public int albumFaceNum = 0;
  public int albumLikeNum = 0;
  public String albumLikekey = "";
  public int albumVisitNum = 0;
  public String invite_key = "";
  public boolean isCoverUserSet = false;
  public boolean isMyLiked = false;
  public boolean isOwner = false;
  public int largeCoverHeight = 0;
  public String largeCoverUrl = "";
  public int largeCoverWidth = 0;
  public PublicShareData public_share_data = null;
  public String share_url = "";
  public Map<Long, wx_user_info> sharer_wx_info = null;
  public int sort_type = 3;
  
  static
  {
    cache_sharer_wx_info = new HashMap();
    wx_user_info localwx_user_info = new wx_user_info();
    cache_sharer_wx_info.put(Long.valueOf(0L), localwx_user_info);
  }
  
  public get_album_rsp() {}
  
  public get_album_rsp(Album paramAlbum, int paramInt1, int paramInt2, String paramString1, int paramInt3, boolean paramBoolean1, String paramString2, int paramInt4, String paramString3, String paramString4, PublicShareData paramPublicShareData, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean2, Map<Long, wx_user_info> paramMap, boolean paramBoolean3)
  {
    this.album = paramAlbum;
    this.albumFaceNum = paramInt1;
    this.albumLikeNum = paramInt2;
    this.albumLikekey = paramString1;
    this.albumVisitNum = paramInt3;
    this.isMyLiked = paramBoolean1;
    this.largeCoverUrl = paramString2;
    this.albumCommentNum = paramInt4;
    this.share_url = paramString3;
    this.invite_key = paramString4;
    this.public_share_data = paramPublicShareData;
    this.largeCoverHeight = paramInt5;
    this.largeCoverWidth = paramInt6;
    this.sort_type = paramInt7;
    this.isOwner = paramBoolean2;
    this.sharer_wx_info = paramMap;
    this.isCoverUserSet = paramBoolean3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, true));
    this.albumFaceNum = paramJceInputStream.read(this.albumFaceNum, 1, false);
    this.albumLikeNum = paramJceInputStream.read(this.albumLikeNum, 2, false);
    this.albumLikekey = paramJceInputStream.readString(3, false);
    this.albumVisitNum = paramJceInputStream.read(this.albumVisitNum, 4, false);
    this.isMyLiked = paramJceInputStream.read(this.isMyLiked, 5, false);
    this.largeCoverUrl = paramJceInputStream.readString(6, false);
    this.albumCommentNum = paramJceInputStream.read(this.albumCommentNum, 7, false);
    this.share_url = paramJceInputStream.readString(8, false);
    this.invite_key = paramJceInputStream.readString(9, false);
    this.public_share_data = ((PublicShareData)paramJceInputStream.read(cache_public_share_data, 10, false));
    this.largeCoverHeight = paramJceInputStream.read(this.largeCoverHeight, 11, false);
    this.largeCoverWidth = paramJceInputStream.read(this.largeCoverWidth, 12, false);
    this.sort_type = paramJceInputStream.read(this.sort_type, 13, false);
    this.isOwner = paramJceInputStream.read(this.isOwner, 14, false);
    this.sharer_wx_info = ((Map)paramJceInputStream.read(cache_sharer_wx_info, 15, false));
    this.isCoverUserSet = paramJceInputStream.read(this.isCoverUserSet, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album, 0);
    paramJceOutputStream.write(this.albumFaceNum, 1);
    paramJceOutputStream.write(this.albumLikeNum, 2);
    if (this.albumLikekey != null) {
      paramJceOutputStream.write(this.albumLikekey, 3);
    }
    paramJceOutputStream.write(this.albumVisitNum, 4);
    paramJceOutputStream.write(this.isMyLiked, 5);
    if (this.largeCoverUrl != null) {
      paramJceOutputStream.write(this.largeCoverUrl, 6);
    }
    paramJceOutputStream.write(this.albumCommentNum, 7);
    if (this.share_url != null) {
      paramJceOutputStream.write(this.share_url, 8);
    }
    if (this.invite_key != null) {
      paramJceOutputStream.write(this.invite_key, 9);
    }
    if (this.public_share_data != null) {
      paramJceOutputStream.write(this.public_share_data, 10);
    }
    paramJceOutputStream.write(this.largeCoverHeight, 11);
    paramJceOutputStream.write(this.largeCoverWidth, 12);
    paramJceOutputStream.write(this.sort_type, 13);
    paramJceOutputStream.write(this.isOwner, 14);
    if (this.sharer_wx_info != null) {
      paramJceOutputStream.write(this.sharer_wx_info, 15);
    }
    paramJceOutputStream.write(this.isCoverUserSet, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_album_rsp
 * JD-Core Version:    0.7.0.1
 */