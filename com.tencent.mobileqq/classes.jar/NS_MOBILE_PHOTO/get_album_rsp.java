package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_album_rsp
  extends JceStruct
{
  static Album cache_album = new Album();
  static PublicShareData cache_public_share_data = new PublicShareData();
  public Album album;
  public int albumCommentNum;
  public int albumFaceNum;
  public int albumLikeNum;
  public String albumLikekey = "";
  public int albumVisitNum;
  public String invite_key = "";
  public boolean isMyLiked;
  public String largeCoverUrl = "";
  public PublicShareData public_share_data;
  public String share_url = "";
  
  public get_album_rsp() {}
  
  public get_album_rsp(Album paramAlbum, int paramInt1, int paramInt2, String paramString1, int paramInt3, boolean paramBoolean, String paramString2, int paramInt4, String paramString3, String paramString4, PublicShareData paramPublicShareData)
  {
    this.album = paramAlbum;
    this.albumFaceNum = paramInt1;
    this.albumLikeNum = paramInt2;
    this.albumLikekey = paramString1;
    this.albumVisitNum = paramInt3;
    this.isMyLiked = paramBoolean;
    this.largeCoverUrl = paramString2;
    this.albumCommentNum = paramInt4;
    this.share_url = paramString3;
    this.invite_key = paramString4;
    this.public_share_data = paramPublicShareData;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_album_rsp
 * JD-Core Version:    0.7.0.1
 */