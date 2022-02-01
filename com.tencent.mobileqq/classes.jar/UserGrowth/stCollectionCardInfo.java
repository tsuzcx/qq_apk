package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    Object localObject = this.collectionList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stCollectionCardInfo
 * JD-Core Version:    0.7.0.1
 */