package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stRecommandAlbum
  extends JceStruct
{
  static ArrayList<Album> cache_recommandAlbumVec = new ArrayList();
  static ArrayList<stRecommandAlbumEx> cache_recommandAlbumVecEx;
  public boolean hasMore;
  public ArrayList<Album> recommandAlbumVec;
  public ArrayList<stRecommandAlbumEx> recommandAlbumVecEx;
  public String summary = "";
  
  static
  {
    Object localObject = new Album();
    cache_recommandAlbumVec.add(localObject);
    cache_recommandAlbumVecEx = new ArrayList();
    localObject = new stRecommandAlbumEx();
    cache_recommandAlbumVecEx.add(localObject);
  }
  
  public stRecommandAlbum() {}
  
  public stRecommandAlbum(ArrayList<Album> paramArrayList, String paramString, boolean paramBoolean, ArrayList<stRecommandAlbumEx> paramArrayList1)
  {
    this.recommandAlbumVec = paramArrayList;
    this.summary = paramString;
    this.hasMore = paramBoolean;
    this.recommandAlbumVecEx = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.recommandAlbumVec = ((ArrayList)paramJceInputStream.read(cache_recommandAlbumVec, 0, false));
    this.summary = paramJceInputStream.readString(1, false);
    this.hasMore = paramJceInputStream.read(this.hasMore, 2, false);
    this.recommandAlbumVecEx = ((ArrayList)paramJceInputStream.read(cache_recommandAlbumVecEx, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.recommandAlbumVec != null) {
      paramJceOutputStream.write(this.recommandAlbumVec, 0);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 1);
    }
    paramJceOutputStream.write(this.hasMore, 2);
    if (this.recommandAlbumVecEx != null) {
      paramJceOutputStream.write(this.recommandAlbumVecEx, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.stRecommandAlbum
 * JD-Core Version:    0.7.0.1
 */