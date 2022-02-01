package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SuixintieCheckItem
  extends JceStruct
{
  public int appid = 0;
  public int fontType = 0;
  public int itemId = 0;
  
  public SuixintieCheckItem() {}
  
  public SuixintieCheckItem(int paramInt1, int paramInt2, int paramInt3)
  {
    this.appid = paramInt1;
    this.itemId = paramInt2;
    this.fontType = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.itemId = paramJceInputStream.read(this.itemId, 1, false);
    this.fontType = paramJceInputStream.read(this.fontType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.itemId, 1);
    paramJceOutputStream.write(this.fontType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.SuixintieCheckItem
 * JD-Core Version:    0.7.0.1
 */