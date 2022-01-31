package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AlbumInfo
  extends JceStruct
{
  static ArrayList cache_vPhotos;
  public ArrayList vPhotos;
  
  public AlbumInfo() {}
  
  public AlbumInfo(ArrayList paramArrayList)
  {
    this.vPhotos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vPhotos == null)
    {
      cache_vPhotos = new ArrayList();
      PhotoInfo localPhotoInfo = new PhotoInfo();
      cache_vPhotos.add(localPhotoInfo);
    }
    this.vPhotos = ((ArrayList)paramJceInputStream.read(cache_vPhotos, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vPhotos != null) {
      paramJceOutputStream.write(this.vPhotos, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCard.AlbumInfo
 * JD-Core Version:    0.7.0.1
 */