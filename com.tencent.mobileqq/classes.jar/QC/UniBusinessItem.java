package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusinessItem
  extends JceStruct
{
  public int appid;
  public int itemid;
  
  public UniBusinessItem() {}
  
  public UniBusinessItem(int paramInt1, int paramInt2)
  {
    this.appid = paramInt1;
    this.itemid = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.itemid = paramJceInputStream.read(this.itemid, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.itemid, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusinessItem
 * JD-Core Version:    0.7.0.1
 */