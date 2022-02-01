package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cell_id;
import NS_MOBILE_FEEDS.cell_like;
import NS_MOBILE_FEEDS.cell_operation;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class PhotoFeedsData
  extends JceStruct
{
  static Album cache_album;
  static ArrayList<Photo> cache_photolist = new ArrayList();
  static cell_comm cache_pss_cell_comm;
  static cell_comment cache_pss_cell_comment = new cell_comment();
  static cell_id cache_pss_cell_id;
  static cell_like cache_pss_cell_like;
  static cell_operation cache_pss_cell_operation;
  public Album album = null;
  public int appid = 0;
  public ArrayList<Photo> photolist = null;
  public cell_comm pss_cell_comm = null;
  public cell_comment pss_cell_comment = null;
  public cell_id pss_cell_id = null;
  public cell_like pss_cell_like = null;
  public cell_operation pss_cell_operation = null;
  
  static
  {
    Photo localPhoto = new Photo();
    cache_photolist.add(localPhoto);
    cache_album = new Album();
    cache_pss_cell_comm = new cell_comm();
    cache_pss_cell_id = new cell_id();
    cache_pss_cell_operation = new cell_operation();
    cache_pss_cell_like = new cell_like();
  }
  
  public PhotoFeedsData() {}
  
  public PhotoFeedsData(int paramInt, ArrayList<Photo> paramArrayList, Album paramAlbum, cell_comm paramcell_comm, cell_id paramcell_id, cell_operation paramcell_operation, cell_like paramcell_like, cell_comment paramcell_comment)
  {
    this.appid = paramInt;
    this.photolist = paramArrayList;
    this.album = paramAlbum;
    this.pss_cell_comm = paramcell_comm;
    this.pss_cell_id = paramcell_id;
    this.pss_cell_operation = paramcell_operation;
    this.pss_cell_like = paramcell_like;
    this.pss_cell_comment = paramcell_comment;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, false));
    this.album = ((Album)paramJceInputStream.read(cache_album, 2, false));
    this.pss_cell_comm = ((cell_comm)paramJceInputStream.read(cache_pss_cell_comm, 3, false));
    this.pss_cell_id = ((cell_id)paramJceInputStream.read(cache_pss_cell_id, 4, false));
    this.pss_cell_operation = ((cell_operation)paramJceInputStream.read(cache_pss_cell_operation, 5, false));
    this.pss_cell_like = ((cell_like)paramJceInputStream.read(cache_pss_cell_like, 6, false));
    this.pss_cell_comment = ((cell_comment)paramJceInputStream.read(cache_pss_cell_comment, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    Object localObject = this.photolist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.album;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.pss_cell_comm;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.pss_cell_id;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.pss_cell_operation;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.pss_cell_like;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.pss_cell_comment;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoFeedsData
 * JD-Core Version:    0.7.0.1
 */