package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ItemBase
  extends JceStruct
{
  public int bid;
  public int ext1;
  public int isSetUp;
  public int itemId;
  public int sourceId;
  
  public ItemBase() {}
  
  public ItemBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.bid = paramInt1;
    this.itemId = paramInt2;
    this.ext1 = paramInt3;
    this.sourceId = paramInt4;
    this.isSetUp = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bid = paramJceInputStream.read(this.bid, 0, false);
    this.itemId = paramJceInputStream.read(this.itemId, 1, false);
    this.ext1 = paramJceInputStream.read(this.ext1, 2, false);
    this.sourceId = paramJceInputStream.read(this.sourceId, 3, false);
    this.isSetUp = paramJceInputStream.read(this.isSetUp, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bid, 0);
    paramJceOutputStream.write(this.itemId, 1);
    paramJceOutputStream.write(this.ext1, 2);
    paramJceOutputStream.write(this.sourceId, 3);
    paramJceOutputStream.write(this.isSetUp, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.ItemBase
 * JD-Core Version:    0.7.0.1
 */