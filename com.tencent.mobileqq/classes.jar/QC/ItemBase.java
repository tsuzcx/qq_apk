package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ItemBase
  extends JceStruct
{
  public int bid;
  public int ext1;
  public int itemId;
  
  public ItemBase() {}
  
  public ItemBase(int paramInt1, int paramInt2, int paramInt3)
  {
    this.bid = paramInt1;
    this.itemId = paramInt2;
    this.ext1 = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bid = paramJceInputStream.read(this.bid, 0, false);
    this.itemId = paramJceInputStream.read(this.itemId, 1, false);
    this.ext1 = paramJceInputStream.read(this.ext1, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bid, 0);
    paramJceOutputStream.write(this.itemId, 1);
    paramJceOutputStream.write(this.ext1, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.ItemBase
 * JD-Core Version:    0.7.0.1
 */