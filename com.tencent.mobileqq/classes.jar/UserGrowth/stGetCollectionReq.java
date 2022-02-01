package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetCollectionReq
  extends JceStruct
{
  public String attachInfo = "";
  public String cid = "";
  public String feedId = "";
  public int pageOrder = 0;
  public int scene = 0;
  
  public stGetCollectionReq() {}
  
  public stGetCollectionReq(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    this.attachInfo = paramString1;
    this.cid = paramString2;
    this.scene = paramInt1;
    this.feedId = paramString3;
    this.pageOrder = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
    this.cid = paramJceInputStream.readString(1, false);
    this.scene = paramJceInputStream.read(this.scene, 2, false);
    this.feedId = paramJceInputStream.readString(3, false);
    this.pageOrder = paramJceInputStream.read(this.pageOrder, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.attachInfo;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.cid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.scene, 2);
    str = this.feedId;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.pageOrder, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetCollectionReq
 * JD-Core Version:    0.7.0.1
 */