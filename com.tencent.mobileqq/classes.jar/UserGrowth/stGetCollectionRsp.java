package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stGetCollectionRsp
  extends JceStruct
{
  static ArrayList<stSimpleMetaFeed> cache_feedList = new ArrayList();
  public String attachInfo = "";
  public ArrayList<stSimpleMetaFeed> feedList;
  public boolean isFinished = true;
  
  static
  {
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
    cache_feedList.add(localstSimpleMetaFeed);
  }
  
  public stGetCollectionRsp() {}
  
  public stGetCollectionRsp(String paramString, boolean paramBoolean, ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    this.attachInfo = paramString;
    this.isFinished = paramBoolean;
    this.feedList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
    this.isFinished = paramJceInputStream.read(this.isFinished, 1, false);
    this.feedList = ((ArrayList)paramJceInputStream.read(cache_feedList, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 0);
    }
    paramJceOutputStream.write(this.isFinished, 1);
    if (this.feedList != null) {
      paramJceOutputStream.write(this.feedList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stGetCollectionRsp
 * JD-Core Version:    0.7.0.1
 */