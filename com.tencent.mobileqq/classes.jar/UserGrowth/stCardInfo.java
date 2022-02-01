package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCardInfo
  extends JceStruct
{
  static stCollectionCardInfo cache_collectionCardInfo = new stCollectionCardInfo();
  public int cardType = 0;
  public stCollectionCardInfo collectionCardInfo = null;
  
  public stCardInfo() {}
  
  public stCardInfo(int paramInt, stCollectionCardInfo paramstCollectionCardInfo)
  {
    this.cardType = paramInt;
    this.collectionCardInfo = paramstCollectionCardInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cardType = paramJceInputStream.read(this.cardType, 0, false);
    this.collectionCardInfo = ((stCollectionCardInfo)paramJceInputStream.read(cache_collectionCardInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cardType, 0);
    if (this.collectionCardInfo != null) {
      paramJceOutputStream.write(this.collectionCardInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stCardInfo
 * JD-Core Version:    0.7.0.1
 */