package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class profileItem
  extends JceStruct
{
  public int itemid = 0;
  
  public profileItem() {}
  
  public profileItem(int paramInt)
  {
    this.itemid = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.itemid = paramJceInputStream.read(this.itemid, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.itemid, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ProfileLogic.QC.profileItem
 * JD-Core Version:    0.7.0.1
 */