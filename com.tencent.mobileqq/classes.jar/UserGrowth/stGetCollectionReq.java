package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetCollectionReq
  extends JceStruct
{
  public String attachInfo = "";
  public String cid = "";
  public int scene = 0;
  
  public stGetCollectionReq() {}
  
  public stGetCollectionReq(String paramString1, String paramString2, int paramInt)
  {
    this.attachInfo = paramString1;
    this.cid = paramString2;
    this.scene = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
    this.cid = paramJceInputStream.readString(1, false);
    this.scene = paramJceInputStream.read(this.scene, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 0);
    }
    if (this.cid != null) {
      paramJceOutputStream.write(this.cid, 1);
    }
    paramJceOutputStream.write(this.scene, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stGetCollectionReq
 * JD-Core Version:    0.7.0.1
 */