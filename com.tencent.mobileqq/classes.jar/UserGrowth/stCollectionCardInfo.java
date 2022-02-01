package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stCollectionCardInfo
  extends JceStruct
{
  static ArrayList<stCollection> cache_collectionList = new ArrayList();
  public ArrayList<stCollection> collectionList = null;
  public String title = "";
  
  static
  {
    stCollection localstCollection = new stCollection();
    cache_collectionList.add(localstCollection);
  }
  
  public stCollectionCardInfo() {}
  
  public stCollectionCardInfo(ArrayList<stCollection> paramArrayList, String paramString)
  {
    this.collectionList = paramArrayList;
    this.title = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.collectionList = ((ArrayList)paramJceInputStream.read(cache_collectionList, 0, false));
    this.title = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.collectionList != null) {
      paramJceOutputStream.write(this.collectionList, 0);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stCollectionCardInfo
 * JD-Core Version:    0.7.0.1
 */