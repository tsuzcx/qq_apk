package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusinessItem
  extends JceStruct
{
  public int appid = 0;
  public String hashid = "";
  public int itemid = 0;
  
  public UniBusinessItem() {}
  
  public UniBusinessItem(int paramInt1, int paramInt2, String paramString)
  {
    this.appid = paramInt1;
    this.itemid = paramInt2;
    this.hashid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.itemid = paramJceInputStream.read(this.itemid, 1, false);
    this.hashid = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.itemid, 1);
    String str = this.hashid;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusinessItem
 * JD-Core Version:    0.7.0.1
 */