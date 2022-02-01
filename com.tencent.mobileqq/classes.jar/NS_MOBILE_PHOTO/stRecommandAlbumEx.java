package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stRecommandAlbumEx
  extends JceStruct
{
  static Album cache_albuminfo = new Album();
  static ArrayList<s_picdata> cache_photolist = new ArrayList();
  public Album albuminfo = null;
  public int commentCnt = 0;
  public int likeCnt = 0;
  public ArrayList<s_picdata> photolist = null;
  public int viewCnt = 0;
  
  static
  {
    s_picdata locals_picdata = new s_picdata();
    cache_photolist.add(locals_picdata);
  }
  
  public stRecommandAlbumEx() {}
  
  public stRecommandAlbumEx(Album paramAlbum, int paramInt1, int paramInt2, ArrayList<s_picdata> paramArrayList, int paramInt3)
  {
    this.albuminfo = paramAlbum;
    this.commentCnt = paramInt1;
    this.likeCnt = paramInt2;
    this.photolist = paramArrayList;
    this.viewCnt = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 0, false));
    this.commentCnt = paramJceInputStream.read(this.commentCnt, 1, false);
    this.likeCnt = paramJceInputStream.read(this.likeCnt, 2, false);
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 3, false));
    this.viewCnt = paramJceInputStream.read(this.viewCnt, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.albuminfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.commentCnt, 1);
    paramJceOutputStream.write(this.likeCnt, 2);
    localObject = this.photolist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.viewCnt, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.stRecommandAlbumEx
 * JD-Core Version:    0.7.0.1
 */